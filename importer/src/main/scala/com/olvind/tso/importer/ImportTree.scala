package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.scalajs._
import com.olvind.tso.ts.{ParentsResolver, _}
import com.olvind.tso.seqs._
import com.olvind.tso.ts.transforms.ExpandCallables

object ImportTree {

  def apply(lib: LibTs, logger: Logger[Unit]): ContainerSymbol = {
    val deps = Unpack.Libs(lib.dependencies).map {
      case (_, depLib) => depLib.name -> depLib.parsed
    }

    val scope = TreeScope(lib.name, deps, logger) / lib.parsed

    ContainerSymbol.container(isWithinScalaModule = false,
                              scope,
                              lib.parsed.comments,
                              lib.name,
                              JsLocation.Zero,
                              lib.parsed.members)
  }

  object ContainerSymbol {
    private def canBeCompact(members: Seq[TsContainerOrDecl]): Boolean =
      members.forall {
        case _: TsImport        => true
        case _: TsDeclVar       => true
        case _: TsDeclFunction  => true
        case x: TsDeclNamespace => canBeCompact(x.members)
        case _ => false
      }

    private def allTypes(members: Seq[TsContainerOrDecl]): Boolean =
      members.forall {
        case _: TsImport        => true
        case _: TsDeclInterface => true
        case _: TsDeclTypeAlias => true
        case x: TsDeclNamespace => allTypes(x.members)
        case _ => false
      }

    /* A namespace within a module must end up as a scala module, given that we don't have a way to express the `@JSImport` */
    private def mustBeCompact(scope: TreeScope): Boolean = {
      var foundNamespace = false
      var idx            = 0
      while (idx < scope.stack.length) {
        scope.stack(idx) match {
          case x: TsDeclNamespace if !allTypes(x.members) =>
            foundNamespace = true
          case _: TsDeclModule if foundNamespace =>
            return true
          case _ => ()
        }
        idx += 1
      }
      false
    }

    private def avoidPackageObject(members: Seq[Symbol]): (Seq[TypeRef], Seq[MemberSymbol], Seq[Symbol]) =
      members.partitionCollect3(
        { case x: FieldSymbol if x.name === Name.namespaced  => x },
        { case x: MethodSymbol if x.name === Name.namespaced => x },
        { case x: MemberSymbol                               => x }
      ) match {
        case (namespacedFields, namespacedMethods, memberSyms, rest) =>
          val rewrittenMethods = namespacedMethods.map(_.copy(name = Name.APPLY))

          val asParents: Seq[TypeRef] =
            namespacedFields.map(x => x.tpe).toList.distinct match {
              case Nil => Nil
              /* This is a shortcut so we don't have to implement the members */
              case more => Seq(TypeRef.TopLevel(TypeRef.Intersection(more)))
            }

          (asParents, memberSyms ++ rewrittenMethods, rest)
      }

    def container(isWithinScalaModule: Boolean,
                  scope:               TreeScope,
                  cs:                  Comments,
                  name:                TsIdent,
                  jsLocation:          JsLocation,
                  members:             Seq[TsContainerOrDecl]): ContainerSymbol = {

      val anns                               = ImportJsLocation(jsLocation, isWithinScalaModule)
      val inModule                           = isWithinScalaModule || canBeCompact(members) || mustBeCompact(scope)
      val (inheritance, liftedMembers, rest) = avoidPackageObject(members flatMap decl(scope, inModule))
      val scalaName                          = ImportName(name)

      if (inModule) {
        val nameAnns: Option[JsName] =
          name match {
            case x: TsIdentNamespace if isWithinScalaModule => Option(JsName(Name(x.value)))
            case _ => None
          }
        ModuleSymbol(anns ++ nameAnns, scalaName, ModuleTypeNative, inheritance, liftedMembers ++ rest, cs)
      } else {
        val membersModule =
          if (liftedMembers.nonEmpty || inheritance.nonEmpty)
            Some(
              ModuleSymbol(
                anns,
                Name(scalaName.unescaped + "Members"),
                ModuleTypeNative,
                inheritance,
                liftedMembers,
                NoComments
              )
            )
          else None

        PackageSymbol(anns, scalaName, rest ++ membersModule, cs)
      }
    }
  }

  def decl(_scope: TreeScope, isWithinScalaModule: Boolean)(t1: TsContainerOrDecl): Seq[Symbol] = {
    val scope: TreeScope = _scope / t1

    t1 match {
      case TsDeclModule(cs, _, name, innerDecls, _, jsLocation) =>
        Seq(ContainerSymbol.container(isWithinScalaModule, scope, cs, name, jsLocation, innerDecls))

      case TsAugmentedModule(name, innerDecls, _, jsLocation) =>
        Seq(ContainerSymbol.container(isWithinScalaModule, scope, NoComments, name, jsLocation, innerDecls))

      case TsDeclNamespace(cs, _, name, innerDecls, _, jsLocation) =>
        if (innerDecls.nonEmpty) {
          Seq(ContainerSymbol.container(isWithinScalaModule, scope, cs, name, jsLocation, innerDecls))
        } else Nil

      case TsGlobal(cs, _, ms, _) =>
        Seq(ContainerSymbol.container(isWithinScalaModule, scope, cs, TsIdent.Global, JsLocation.Zero, ms))

      case TsDeclVar(cs, _, _, ImportName(name), Some(TsTypeObject(members)), None, location, _, false) =>
        val MemberRet(ctors, ms, inheritance, Nil) = members flatMap tsMember(scope, scalaJsDefined = false)
        Seq(
          ModuleSymbol(ImportJsLocation(location, isWithinScalaModule),
                       name,
                       ModuleTypeNative,
                       inheritance,
                       ms ++ ctors,
                       cs)
        )

      case TsDeclVar(cs,
                     _,
                     readOnly,
                     ImportName(name),
                     tpeOpt: Option[TsType],
                     literalOpt,
                     jsLocation,
                     _,
                     isOptional) =>
        val base: TypeRef = tpeOpt map ImportType(Wildcards.Prohibit, scope) getOrElse {
          literalOpt match {
            case Some(TsLiteralNumber(_))  => TypeRef.Double
            case Some(TsLiteralBoolean(_)) => TypeRef.Boolean
            case Some(TsLiteralString(_))  => TypeRef.String
            case None                      => TypeRef.Any
          }
        }

        if (name === Name.Symbol) {
          Seq(
            ModuleSymbol(
              annotations = ImportJsLocation(jsLocation, isWithinScalaModule),
              name        = name,
              moduleType  = ModuleTypeNative,
              parents     = Seq(base.withOptional(isOptional)),
              members     = Nil,
              comments    = cs
            )
          )
        } else
          Seq(
            FieldSymbol(
              annotations = Annotation.jsName(name),
              name        = name,
              tpe         = base.withOptional(isOptional),
              impl        = MemberImplNative,
              isReadOnly  = readOnly,
              isOverride  = false,
              comments    = cs
            )
          )

      case TsDeclEnum(cs, _, ImportName(name), members, location, _) =>
        tsEnumDecl(name, members, cs, ImportJsLocation(location, isWithinScalaModule))

      case TsDeclClass(cs, _, isAbstract, ImportName(name), tparams, parent, implements, members, location, _) =>
        val MemberRet(ctors, ms, extraInheritance, statics) =
          members flatMap tsMember(scope, scalaJsDefined = false)

        val anns = ImportJsLocation(location, isWithinScalaModule)

        val parents = parent.to[Seq] ++ implements map ImportType(Wildcards.Prohibit, scope)

        val classType = if (isAbstract) ClassType.AbstractClass else ClassType.Class
        val cls = ClassSymbol(
          annotations = anns,
          name        = name,
          tparams     = tparams map typeParam(scope),
          parents     = parents ++ extraInheritance,
          ctors       = ctors,
          members     = ms,
          classType   = classType,
          isSealed    = false,
          comments    = cs
        )

        val module: Option[ModuleSymbol] =
          if (statics.nonEmpty) Some(ModuleSymbol(anns, name, ModuleTypeNative, Nil, statics, cs))
          else None

        cls :: module.to[List]

      case i @ TsDeclInterface(cs, _, ImportName(name), tparams, inheritance, members, _) =>
        val withParents                                 = ParentsResolver(scope, i)
        val scalaJsDefined                              = CanBeScalaJsDefined(withParents)
        val MemberRet(ctors, ms, extraInheritance, Nil) = members flatMap tsMember(scope, scalaJsDefined)
        val parents                                     = inheritance.map(ImportType(Wildcards.Prohibit, scope))

        Seq(
          ClassSymbol(
            annotations = Seq(if (scalaJsDefined) ScalaJSDefined else JsNative),
            name        = name,
            tparams     = tparams map typeParam(scope),
            parents     = parents ++ extraInheritance,
            ctors       = ctors,
            members     = ms,
            classType   = ClassType.Trait,
            isSealed    = false,
            comments    = cs
          )
        )

      case TsDeclTypeAlias(cs, _, ImportName(name), tparams, alias, _) =>
        Seq(
          TypeAliasSymbol(
            name     = name,
            tparams  = tparams map typeParam(scope),
            alias    = ImportType(Wildcards.Prohibit, scope)(alias),
            comments = cs
          )
        )

      case TsDeclFunction(cs, _, ImportName(name), sig, _, _) =>
        Seq(
          tsMethod(
            scope          = scope,
            level          = Default,
            name           = name,
            cs             = cs,
            sig            = sig,
            scalaJsDefined = false,
          )
        )
      case _: TsExportAsNamespace => Nil
      case _: TsImport            => Nil

      case other =>
        scope.logger.fatalMaybe(s"Unexpected: $other", constants.Pedantic)
        Nil
    }
  }

  private def literalComment(lit: TsLiteral) =
    Comment(s"/* ${lit.literal} */")

  private def tsEnumDecl(name:    Name,
                         members: Seq[TsEnumMember],
                         cs:      Comments,
                         anns:    Seq[ClassAnnotation]): Seq[ContainerSymbol] = {
    val classSymbol =
      ClassSymbol(
        annotations = Seq(JsNative),
        name        = name,
        tparams     = Nil,
        parents     = Nil,
        ctors       = Nil,
        members     = Nil,
        classType   = ClassType.Trait,
        isSealed    = true,
        comments    = NoComments
      )

    val moduleSymbol: ModuleSymbol = {
      val applyMethod = MethodSymbol(
        annotations = Annotation.method(name, isBracketAccess = true),
        level       = Default,
        name        = Name.APPLY,
        tparams     = Nil,
        params = Seq(
          Seq(
            ParamSymbol(Name.value, TypeRef(QualifiedName(name :: Nil), Nil, NoComments), NoComments)
          )
        ),
        impl       = MemberImplNative,
        resultType = TypeRef(QualifiedName.String, Nil, NoComments),
        isOverride = false,
        comments   = NoComments
      )

      val membersSyms: Seq[ContainerSymbol] =
        members flatMap {
          case TsEnumMember(memberCs, ImportName(_memberName), literalOpt) =>
            val (memberName: Name, anns) =
              _memberName match {
                /* work around that object A {object notify} doesnt compile */
                case n if ObjectMembers.byName.contains(n) =>
                  (Name(n.unescaped.toUpperCase), Seq(JsNative, JsName(n)))
                /* and that `js`/`java` will cause a name collision */
                case n @ (Name.js | Name.java) => (Name(n.unescaped.toUpperCase), Seq(JsNative, JsName(n)))
                case n @ Name.underscore       => (Name("underscore"), Seq(JsNative, JsName(n)))
                case n                         => (n, Seq(JsNative))
              }

            Seq(
              ClassSymbol(
                annotations = Seq(JsNative),
                name        = memberName,
                tparams     = Nil,
                parents     = Seq(TypeRef(QualifiedName(name :: Nil), Nil, NoComments)),
                ctors       = Nil,
                members     = Nil,
                classType   = ClassType.Trait,
                isSealed    = true,
                comments    = memberCs
              ),
              ModuleSymbol(
                annotations = anns,
                name        = memberName,
                moduleType  = ModuleTypeNative,
                parents     = Seq(TypeRef(QualifiedName(memberName :: Nil), Nil, NoComments)),
                members     = Nil,
                comments = Comments(literalOpt map {
                  case Left(x)  => literalComment(x)
                  case Right(x) => Comment(s"/* ${x.value} */")
                })
              )
            )
        }

      ModuleSymbol(anns, name, ModuleTypeNative, parents = Nil, members = applyMethod +: membersSyms, comments = cs)
    }

    Seq(classSymbol, moduleSymbol)
  }

  sealed trait MemberRet

  object MemberRet {
    def apply(value: MemberSymbol, isStatic: Boolean): MemberRet =
      if (isStatic) Static(value) else Normal(value)

    final case class Ctor(value: CtorSymbol) extends MemberRet

    final case class Normal(value: MemberSymbol) extends MemberRet
    final case class Static(value: MemberSymbol) extends MemberRet

    final case class Inheritance(value: TypeRef) extends MemberRet

    def unapply(es: Seq[MemberRet]): Some[(Seq[CtorSymbol], Seq[MemberSymbol], Seq[TypeRef], Seq[MemberSymbol])] = {
      val ctors = es.collect {
        case Ctor(c) => c
      }
      val others = es.collect {
        case Normal(o) => o
      }
      val inheritance = es.collect {
        case Inheritance(o) => o
      }
      val static = es.collect {
        case Static(o) => o
      }
      Some((ctors, others, inheritance, static))
    }
  }

  def tsMember(_scope: TreeScope, scalaJsDefined: Boolean)(t1: TsMember): Seq[MemberRet] = {
    lazy val scope = _scope / t1
    t1 match {
      case TsMemberCall(cs, level, signature) =>
        Seq(
          MemberRet(
            tsMethod(scope, level, Name.APPLY, cs, signature, scalaJsDefined),
            isStatic = false
          )
        )
      case TsMemberCtor(cs, _, sig) =>
        if (sig.tparams.nonEmpty) {
          scope.logger.info(s"Dropping Instantiable with type params at")
          Nil
        } else if (sig.params.exists(_.tpe.exists(_.isInstanceOf[TsTypeRepeated]))) {
          scope.logger.info(s"Dropping Instantiable with repeated params")
          Nil
        } else {
          val params = sig.params.map(
            param =>
              ImportType
                .orAny(Wildcards.Prohibit, scope)(param.tpe)
                .withComments(Comments(Comment(s"/* ${param.name.value} */ ")))
                .withOptional(param.isOptional)
          )
          val ret = ImportType.orAny(Wildcards.Prohibit, scope)(sig.resultType)
          Seq(
            MemberRet.Inheritance(
              TypeRef(
                QualifiedName.Instantiable(sig.params.length),
                params :+ ret,
                cs
              )
            )
          )
        }

      case TsMemberFunction(cs, level, TsIdent.constructor, sig, false, _, _) =>
        Seq(MemberRet.Ctor(CtorSymbol(level, tsFunParams(scope / sig, params = sig.params), cs ++ sig.comments)))

      case m: TsMemberProperty =>
        tsMemberProperty(scope, scalaJsDefined)(m)

      case TsMemberFunction(cs, level, name, signature, isStatic, isReadOnly, isOptional) =>
        if (isOptional) {
          val asFunction =
            TsMemberProperty(cs, level, name, Some(TsTypeFunction(signature)), isStatic, isReadOnly, isOptional)

          tsMemberProperty(scope.`..`, scalaJsDefined)(asFunction)
        } else {
          Seq(MemberRet(tsMethod(scope, level, ImportName(name), cs, signature, scalaJsDefined), isStatic))
        }

      case m: TsMemberIndex =>
        m.indexing match {
          case IndexingDict(indexName, indexType) =>
            val indexTpe = ImportType(Wildcards.No, scope)(indexType)
            val valueTpe = ImportType(Wildcards.No, scope)(m.valueType)

            val rewritten: TypeRef =
              if (indexTpe === TypeRef.String)
                TypeRef.StringDictionary(valueTpe, m.comments + Comment(s"/* ${indexName.value} */ "))
              else if (indexTpe === TypeRef.Double)
                TypeRef.NumberDictionary(valueTpe, m.comments + Comment(s"/* ${indexName.value} */ "))
              else scope.logger.fatal(s"Unsupported index type $indexTpe")

            Seq(MemberRet.Inheritance(rewritten))
          case IndexingSingle(name) =>
            val KnownSymbols = Set(
              "asyncIterator",
              "hasInstance",
              "isConcatSpreadable",
              "iterator",
              "match",
              "replace",
              "observable",
              "search",
              "species",
              "split",
              "toPrimitive",
              "toStringTag",
              "unscopables"
            )
            name.parts match {
              case TsIdent.Symbol :: symName :: Nil if KnownSymbols(symName.value) =>
                val a = Annotation.jsNameSymbol(QualifiedName.Runtime ++ ImportName.skipConversion(name))

                val fieldType: MemberImpl =
                  (scalaJsDefined, m.isOptional) match {
                    case (true, true)  => MemberImplCustom("js.undefined")
                    case (true, false) => MemberImplNotImplemented
                    case _             => MemberImplNative
                  }

                Seq(
                  MemberRet(
                    FieldSymbol(
                      annotations = Seq(a),
                      name        = ImportName(symName),
                      tpe         = ImportType(Wildcards.No, scope)(m.valueType).withOptional(m.isOptional),
                      impl        = fieldType,
                      isReadOnly  = m.isReadOnly,
                      isOverride  = false,
                      comments    = m.comments
                    ),
                    isStatic = false
                  )
                )
              case other =>
                scope.logger.warn(s"Dropping $other")
                Nil
            }
        }

      case other: TsMemberTypeMapped =>
        scope.logger.info(s"Dropping $other")
        Nil
    }
  }

  def tsMemberProperty(scope: TreeScope, scalaJsDefined: Boolean)(m: TsMemberProperty): Seq[MemberRet] =
    (m.name, m.tpe) match {
      case (_, Some(TsTypeQuery(_))) =>
        scope.logger.info(s"Dropping $m")
        Nil
      case (ImportName(name), Some(TsTypeObject(members)))
          if !m.isOptional && members.forall(_.isInstanceOf[TsMemberCall]) =>
        // alternative notation for overload methods
        members.collect { case x: TsMemberCall => x } map (
            call =>
              MemberRet(tsMethod(scope / call, call.level, name, call.comments, call.signature, scalaJsDefined),
                        m.isStatic)
        )

      case (ImportName(name), tpe: Option[TsType]) =>
        val fieldType: MemberImpl =
          (scalaJsDefined, m.isOptional) match {
            case (true, true)  => MemberImplCustom("js.undefined")
            case (true, false) => MemberImplNotImplemented
            case _             => MemberImplNative
          }

        Seq(
          MemberRet(
            hack(
              FieldSymbol(
                annotations = Annotation.jsName(name),
                name        = name,
                tpe         = ImportType.orAny(Wildcards.No, scope)(tpe).withOptional(m.isOptional),
                impl        = fieldType,
                isReadOnly  = m.isReadOnly,
                isOverride  = false,
                comments    = m.comments
              )
            ),
            m.isStatic
          )
        )
      case (name, _) =>
        scope.logger.info(s"dropping member $name")
        Nil
    }

  def hack(fs: FieldSymbol): FieldSymbol =
    fs.comments.cs.partitionCollect { case c if c === ExpandCallables.MarkerComment => c } match {
      case (Nil, _)  => fs
      case (_, rest) => fs.withSuffix("Original").copy(comments = Comments(rest))
    }

  def typeParam(scope: TreeScope)(tp: TsTypeParam): TypeParamSymbol =
    TypeParamSymbol(
      name       = ImportName(tp.name),
      upperBound = tp.upperBound map ImportType(Wildcards.No, scope / tp),
      comments   = tp.comments
    )

  def tsFunParams(scope: TreeScope, params: Seq[TsFunParam]): Seq[ParamSymbol] =
    params map { param =>
      val tpe       = ImportType.orAny(Wildcards.No, scope / param)(param.tpe)
      val undefType = if (param.isOptional) TypeRef.UndefOr(tpe) else tpe
      ParamSymbol(ImportName(param.name), undefType, param.comments)
    }

  def tsMethod(scope:          TreeScope,
               level:          ProtectionLevel,
               name:           Name,
               cs:             Comments,
               sig:            TsFunSig,
               scalaJsDefined: Boolean): MethodSymbol = {

    val as = Annotation.method(name, isBracketAccess = false)

    val containedLiterals: Seq[TsLiteralString] =
      TreeTraverse.collectSeq(sig.params) { case x: TsLiteralString => x }

    val fieldType: MemberImpl =
      if (scalaJsDefined) MemberImplNotImplemented else MemberImplNative

    val resultType: TypeRef = (
      sig.resultType filter (_ =/= TsTypeRef.any)
        map ImportType(Wildcards.No, scope)
        getOrElse TypeRef.Any
    )

    val ret = MethodSymbol(
      as,
      level      = level,
      name       = name,
      tparams    = sig.tparams map typeParam(scope),
      params     = Seq(tsFunParams(scope, sig.params)),
      impl       = fieldType,
      resultType = resultType,
      isOverride = false,
      comments   = cs ++ sig.comments
    )

    containedLiterals.distinct.toList match {
      case _ if name === Name.APPLY || name === Name.namespaced => ret
      case oneLit :: Nil                                        => ret withSuffix oneLit
      case _                                                    => ret
    }
  }
}

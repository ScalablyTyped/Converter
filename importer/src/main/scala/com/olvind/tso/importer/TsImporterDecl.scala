package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.scalajs._
import com.olvind.tso.ts.{ParentsResolver, _}
import com.olvind.tso.seqs._

object TsImporterDecl {

  def apply(lib: LibTs, logger: Logger[Unit]): ContainerSymbol = {
    val deps = Unpack.Libs(lib.dependencies).map {
      case (_, depLib) => depLib.name -> depLib.parsed
    }

    val scope = TreeScope(lib.name, deps, logger) / lib.parsed

    ContainerSymbol.container(isWithinScalaModule = false,
                              scope,
                              lib.parsed.comments,
                              AsName(lib.name),
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
                  name:                Name,
                  jsLocation:          JsLocation,
                  members:             Seq[TsContainerOrDecl]): ContainerSymbol = {

      val anns                               = JsLocationAnnotation(jsLocation, isWithinScalaModule)
      val inModule                           = isWithinScalaModule || canBeCompact(members) || mustBeCompact(scope)
      val (inheritance, liftedMembers, rest) = avoidPackageObject(members flatMap decl(scope, inModule))

      if (inModule) {
        ModuleSymbol(anns, name, ModuleTypeNative, inheritance, liftedMembers ++ rest, cs)
      } else {
        val membersModule =
          if (liftedMembers.nonEmpty || inheritance.nonEmpty)
            Some(
              ModuleSymbol(
                anns,
                Name(name.unescaped + "Members"),
                ModuleTypeNative,
                inheritance,
                liftedMembers,
                NoComments
              )
            )
          else None

        PackageSymbol(anns, name, rest ++ membersModule, cs)
      }
    }
  }

  def decl(_scope: TreeScope, isWithinScalaModule: Boolean)(t1: TsContainerOrDecl): Seq[Symbol] = {
    val scope: TreeScope = _scope / t1

    t1 match {
      case TsDeclModule(cs, _, AsName(name), innerDecls, _, jsLocation) =>
        Seq(ContainerSymbol.container(isWithinScalaModule, scope, cs, name, jsLocation, innerDecls))

      case TsAugmentedModule(AsName(name), innerDecls, _, jsLocation) =>
        Seq(ContainerSymbol.container(isWithinScalaModule, scope, NoComments, name, jsLocation, innerDecls))

      case TsDeclNamespace(cs, _, AsName(name), innerDecls, _, jsLocation) =>
        if (innerDecls.nonEmpty) {
          Seq(ContainerSymbol.container(isWithinScalaModule, scope, cs, name, jsLocation, innerDecls))
        } else Nil

      case TsGlobal(cs, _, ms, _) =>
        Seq(ContainerSymbol.container(isWithinScalaModule, scope, cs, AsName(TsIdent.Global), JsLocation.Zero, ms))

      case TsDeclVar(cs, _, _, AsName(name), Some(TsTypeObject(members)), None, location, _, false) =>
        val MemberRet(ctors, ms, inheritance, Nil) = members flatMap tsMember(scope, scalaJsDefined = false)
        Seq(
          ModuleSymbol(JsLocationAnnotation(location, isWithinScalaModule),
                       name,
                       ModuleTypeNative,
                       inheritance,
                       ms ++ ctors,
                       cs)
        )

      case TsDeclVar(cs, _, readOnly, AsName(name), tpeOpt: Option[TsType], literalOpt, jsLocation, _, isOptional) =>
        val base: TypeRef = tpeOpt map TsImporterTypes(Wildcards.Prohibit, scope) getOrElse {
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
              annotations = JsLocationAnnotation(jsLocation, isWithinScalaModule),
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
              annotations = Nil,
              name        = name,
              tpe         = base.withOptional(isOptional),
              fieldType   = FieldTypeNative,
              isReadOnly  = readOnly,
              isOverride  = false,
              comments    = cs
            )
          )

      case TsDeclEnum(cs, _, AsName(name), members, location, _) =>
        tsEnumDecl(name, members, cs, JsLocationAnnotation(location, isWithinScalaModule))

      case TsDeclClass(cs, _, isAbstract, AsName(name), tparams, parent, implements, members, location, _) =>
        val MemberRet(ctors, ms, extraInheritance, statics) =
          members flatMap tsMember(scope, scalaJsDefined = false)

        val anns = JsLocationAnnotation(location, isWithinScalaModule)

        val parents = parent.to[Seq] ++ implements map TsImporterTypes(Wildcards.Prohibit, scope)

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

      case i @ TsDeclInterface(cs, _, AsName(name), tparams, inheritance, members, _) =>
        val withParents                                 = ParentsResolver(scope, i)
        val scalaJsDefined                              = CanBeScalaJsDefined(withParents)
        val MemberRet(ctors, ms, extraInheritance, Nil) = members flatMap tsMember(scope, scalaJsDefined)
        val parents                                     = inheritance.map(TsImporterTypes(Wildcards.Prohibit, scope))

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

      case TsDeclTypeAlias(cs, _, AsName(name), tparams, alias, _) =>
        Seq(
          TypeAliasSymbol(
            name     = name,
            tparams  = tparams map typeParam(scope),
            alias    = TsImporterTypes(Wildcards.Prohibit, scope)(alias),
            comments = cs
          )
        )

      case TsDeclFunction(cs, _, AsName(name), sig, _, _) =>
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
        annotations = Annotations.method(name, isBracketAccess = true),
        level       = Default,
        name        = Name.APPLY,
        tparams     = Nil,
        params = Seq(
          Seq(
            ParamSymbol(Name.value, TypeRef(QualifiedName(name :: Nil), Nil, NoComments), NoComments)
          )
        ),
        fieldType  = FieldTypeNative,
        resultType = TypeRef(QualifiedName.String, Nil, NoComments),
        isOverride = false,
        comments   = NoComments
      )

      val membersSyms: Seq[ContainerSymbol] =
        members flatMap {
          case TsEnumMember(memberCs, AsName(memberName), literalOpt) =>
            val (_memberName: Name, _annotations) =
              memberName match {
                /* work around that object A {object notify} doesnt compile */
                case n if ObjectMembers.byName.contains(n) =>
                  (Name(memberName.unescaped.toUpperCase), Seq(JsNative, JsName(memberName)))
                /* and that `js`/`java` will cause a name collision */
                case Name.js | Name.java => (Name(memberName.unescaped.toUpperCase), Seq(JsNative, JsName(memberName)))
                case _ =>
                  (memberName, Seq(JsNative))
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
                annotations = _annotations,
                name        = _memberName,
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
            tsMethod(scope, level, Name.APPLY, cs, signature, scalaJsDefined = scalaJsDefined),
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
              TsImporterTypes
                .orAny(Wildcards.Prohibit, scope)(param.tpe)
                .withComments(Comments(Comment(s"/* ${param.name.value} */ ")))
                .withOptional(param.isOptional)
          )
          val ret = TsImporterTypes.orAny(Wildcards.Prohibit, scope)(sig.resultType)
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

          tsMemberProperty(scope, scalaJsDefined)(asFunction)
        } else {
          Seq(MemberRet(tsMethod(scope, level, AsName(name), cs, signature, scalaJsDefined), isStatic))
        }

      case m: TsMemberIndex =>
        m.indexing match {
          case IndexingDict(indexName, indexType) =>
            val indexTpe = TsImporterTypes(Wildcards.No, scope)(indexType)
            val valueTpe = TsImporterTypes(Wildcards.No, scope)(m.valueType)

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
                val a = Annotations.jsNameSymbol(QualifiedName.Runtime ++ AsName.skipConversion(name))

                val fieldType: FieldType =
                  (scalaJsDefined, m.isOptional) match {
                    case (true, true)  => FieldTypeScala("js.undefined")
                    case (true, false) => FieldTypeNotImplemented
                    case _             => FieldTypeNative
                  }

                Seq(
                  MemberRet(
                    FieldSymbol(
                      annotations = Seq(a),
                      name        = AsName(symName),
                      tpe         = TsImporterTypes(Wildcards.No, scope / m)(m.valueType).withOptional(m.isOptional),
                      fieldType   = fieldType,
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
      case (AsName(name), Some(TsTypeObject(members)))
          if !m.isOptional && members.forall(_.isInstanceOf[TsMemberCall]) =>
        // alternative notation for overload methods
        members.collect { case x: TsMemberCall => x } map (
            call =>
              MemberRet(tsMethod(scope / call, call.level, name, call.comments, call.signature, scalaJsDefined),
                        m.isStatic)
        )

      case (AsName(name), tpe: Option[TsType]) =>
        val fieldType: FieldType =
          (scalaJsDefined, m.isOptional) match {
            case (true, true)  => FieldTypeScala("js.undefined")
            case (true, false) => FieldTypeNotImplemented
            case _             => FieldTypeNative
          }

        Seq(
          MemberRet(
            FieldSymbol(
              annotations = Annotations.jsName(name),
              name        = name,
              tpe         = TsImporterTypes.orAny(Wildcards.No, scope / m)(tpe).withOptional(m.isOptional),
              fieldType   = fieldType,
              isReadOnly  = m.isReadOnly,
              isOverride  = false,
              comments    = m.comments
            ),
            m.isStatic
          )
        )
      case (name, _) =>
        scope.logger.info(s"dropping member $name")
        Nil
    }

  def typeParam(scope: TreeScope)(tp: TsTypeParam): TypeParamSymbol =
    TypeParamSymbol(
      name       = AsName(tp.name),
      upperBound = tp.upperBound map TsImporterTypes(Wildcards.No, scope / tp),
      comments   = tp.comments
    )

  def tsFunParams(scope: TreeScope, params: Seq[TsFunParam]): Seq[ParamSymbol] =
    params map { param =>
      val tpe       = TsImporterTypes.orAny(Wildcards.No, scope / param)(param.tpe)
      val undefType = if (param.isOptional) TypeRef.UndefOr(tpe) else tpe
      ParamSymbol(AsName(param.name), undefType, param.comments)
    }

  def tsMethod(scope:          TreeScope,
               level:          ProtectionLevel,
               name:           Name,
               cs:             Comments,
               sig:            TsFunSig,
               scalaJsDefined: Boolean): MethodSymbol = {

    val as = Annotations.method(name, isBracketAccess = false)

    val containedLiterals: Seq[TsLiteralString] =
      TreeTraverse.collectSeq(sig.params) { case x: TsLiteralString => x }

    val fieldType: FieldType =
      if (scalaJsDefined) FieldTypeNotImplemented else FieldTypeNative

    val resultType: TypeRef = (
      sig.resultType filter (_ =/= TsTypeRef.any)
        map TsImporterTypes(Wildcards.No, scope)
        getOrElse TypeRef.Any
    )

    val ret = MethodSymbol(
      as,
      level      = level,
      name       = name,
      tparams    = sig.tparams map typeParam(scope),
      params     = Seq(tsFunParams(scope, sig.params)),
      fieldType  = fieldType,
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

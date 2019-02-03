package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase1Res.{LibTs, UnpackLibs}
import com.olvind.tso.scalajs._
import com.olvind.tso.seqs._
import com.olvind.tso.ts.transforms.ExpandCallables
import com.olvind.tso.ts.{ParentsResolver, _}

object ImportTree {
  def apply(lib: LibTs, logger: Logger[Unit], importName: ImportName): ContainerTree = {
    val deps = UnpackLibs(lib.dependencies).map {
      case (_, depLib) => depLib.name -> depLib.parsed
    }

    val scope = TsTreeScope(lib.name, pedantic = true, deps, logger) / lib.parsed

    val ret = ContainerTree.container(
      isWithinScalaModule = false,
      importName,
      scope,
      lib.parsed.comments,
      lib.name,
      JsLocation.Zero,
      lib.parsed.members
    )

    val require = ModuleTree(
      Seq(JsImport(lib.name.value, Imported.Namespace), JsNative),
      importName(lib.name).withSuffix("Require"),
      ModuleTypeNative,
      Nil,
      Nil,
      Comments("""/* This can be used to `require` the library as a side effect.
  If it is a global library this will make scalajs-bundler include it */
""")
    )

    ret match {
      case x: ModuleTree  => x.copy(members = x.members :+ require)
      case x: PackageTree => x.copy(members = x.members :+ require)
      case other => other
    }
  }

  object ContainerTree {
    private def canBeCompact(members: Seq[TsContainerOrDecl]): Boolean =
      members.forall {
        case _: TsImport        => true
        case _: TsDeclVar       => true
        case _: TsDeclFunction  => true
        case x: TsDeclNamespace => canBeCompact(x.members)
        case TsDeclTypeAlias(Comments(Seq(constants.MagicComments.TrivialTypeAlias)), _, _, _, _, _) => true
        case _                                                                                       => false
      }

    private def allTypes(members: Seq[TsContainerOrDecl]): Boolean =
      members.forall {
        case _: TsImport        => true
        case _: TsDeclInterface => true
        case _: TsDeclTypeAlias => true
        case x: TsDeclEnum      => !x.isValue
        case x: TsDeclNamespace => allTypes(x.members)
        case _ => false
      }

    /* A namespace within a module must end up as a scala module, given that we don't have a way to express the `@JSImport` */
    private def mustBeCompact(scope: TsTreeScope): Boolean = {
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

    private def avoidPackageObject(members: Seq[Tree]): (Seq[TypeRef], Seq[MemberTree], Seq[Tree]) =
      members.partitionCollect3(
        { case x: FieldTree if x.name === Name.namespaced  => x },
        { case x: MethodTree if x.name === Name.namespaced => x },
        { case x: MemberTree                               => x }
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
                  importName:          ImportName,
                  scope:               TsTreeScope,
                  cs:                  Comments,
                  name:                TsIdent,
                  jsLocation:          JsLocation,
                  members:             Seq[TsContainerOrDecl]): ContainerTree = {

      val anns                               = ImportJsLocation(jsLocation, isWithinScalaModule)
      val inModule                           = scope.stack.length > 1 && (isWithinScalaModule || canBeCompact(members) || mustBeCompact(scope))
      val (inheritance, liftedMembers, rest) = avoidPackageObject(members flatMap decl(scope, inModule, importName))
      val scalaName                          = importName(name)

      if (inModule) {
        val nameAnns: Option[JsName] =
          name match {
            case x: TsIdentNamespace if isWithinScalaModule => Option(JsName(Name(x.value)))
            case _ => None
          }
        ModuleTree(anns ++ nameAnns, scalaName, ModuleTypeNative, inheritance, liftedMembers ++ rest, cs)
      } else {
        val membersModule =
          if (liftedMembers.nonEmpty || inheritance.nonEmpty)
            Some(
              ModuleTree(
                anns,
                Name("^"),
                ModuleTypeNative,
                inheritance,
                liftedMembers,
                NoComments
              )
            )
          else None

        PackageTree(anns, scalaName, rest ++ membersModule, cs)
      }
    }
  }

  def decl(_scope: TsTreeScope, isWithinScalaModule: Boolean, importName: ImportName)(
      t1:          TsContainerOrDecl
  ): Seq[Tree] = {
    val scope: TsTreeScope = _scope / t1

    t1 match {
      case TsDeclModule(cs, _, name, innerDecls, _, jsLocation) =>
        Seq(ContainerTree.container(isWithinScalaModule, importName, scope, cs, name, jsLocation, innerDecls))

      case TsAugmentedModule(name, innerDecls, _, jsLocation) =>
        Seq(ContainerTree.container(isWithinScalaModule, importName, scope, NoComments, name, jsLocation, innerDecls))

      case TsDeclNamespace(cs, _, name, innerDecls, _, jsLocation) =>
        if (innerDecls.nonEmpty) {
          Seq(ContainerTree.container(isWithinScalaModule, importName, scope, cs, name, jsLocation, innerDecls))
        } else Nil

      case TsGlobal(cs, _, ms, _) =>
        Seq(ContainerTree.container(isWithinScalaModule, importName, scope, cs, TsIdent.Global, JsLocation.Zero, ms))

      case TsDeclVar(cs, _, _, importName(name), Some(TsTypeObject(members)), None, location, _, false) =>
        val MemberRet(ctors, ms, inheritance, Nil) = members flatMap tsMember(scope, scalaJsDefined = false, importName)
        Seq(
          ModuleTree(ImportJsLocation(location, isWithinScalaModule),
                     name,
                     ModuleTypeNative,
                     inheritance,
                     ms ++ ctors,
                     cs)
        )

      case TsDeclVar(cs, _, readOnly, importName(name), tpeOpt, literalOpt, jsLocation, _, isOptional) =>
        val base = ImportType.orLitOrAny(Wildcards.Prohibit, scope, importName)(tpeOpt, literalOpt)

        if (name === Name.Symbol) {
          Seq(
            ModuleTree(
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
            FieldTree(
              annotations = Annotation.jsName(name),
              name        = name,
              tpe         = base.withOptional(isOptional),
              impl        = MemberImplNative,
              isReadOnly  = readOnly,
              isOverride  = false,
              comments    = cs
            )
          )

      case e: TsDeclEnum =>
        ImportEnum(e, ImportJsLocation(e.jsLocation, isWithinScalaModule), scope, importName)

      case TsDeclClass(cs, _, isAbstract, importName(name), tparams, parent, implements, members, location, _) =>
        val MemberRet(ctors, ms, extraInheritance, statics) =
          members flatMap tsMember(scope, scalaJsDefined = false, importName)

        val anns = ImportJsLocation(location, isWithinScalaModule)

        val parents = parent.to[Seq] ++ implements map ImportType(Wildcards.Prohibit, scope, importName)

        val classType = if (isAbstract) ClassType.AbstractClass else ClassType.Class
        val cls = ClassTree(
          annotations = anns,
          name        = name,
          tparams     = tparams map typeParam(scope, importName),
          parents     = parents ++ extraInheritance,
          ctors       = ctors,
          members     = ms,
          classType   = classType,
          isSealed    = false,
          comments    = cs
        )

        val module: Option[ModuleTree] =
          if (statics.nonEmpty)
            Some(ModuleTree(anns, name, ModuleTypeNative, Nil, statics, Comments(Comment("/* static members */\n"))))
          else None

        cls :: module.to[List]

      case i @ TsDeclInterface(cs, _, importName(name), tparams, inheritance, members, _) =>
        val withParents                                 = ParentsResolver(scope, i)
        val scalaJsDefined                              = CanBeScalaJsDefined(withParents)
        val MemberRet(ctors, ms, extraInheritance, Nil) = members flatMap tsMember(scope, scalaJsDefined, importName)
        val parents                                     = inheritance.map(ImportType(Wildcards.Prohibit, scope, importName))

        Seq(
          ClassTree(
            annotations = Seq(if (scalaJsDefined) ScalaJSDefined else JsNative),
            name        = name,
            tparams     = tparams map typeParam(scope, importName),
            parents     = parents ++ extraInheritance,
            ctors       = ctors,
            members     = ms,
            classType   = ClassType.Trait,
            isSealed    = false,
            comments    = cs
          )
        )

      case TsDeclTypeAlias(cs, _, importName(name), tparams, alias, _) =>
        Seq(
          TypeAliasTree(
            name     = name,
            tparams  = tparams map typeParam(scope, importName),
            alias    = ImportType(Wildcards.Prohibit, scope, importName)(alias),
            comments = cs
          )
        )

      case TsDeclFunction(cs, _, importName(name), sig, _, _) =>
        Seq(
          tsMethod(
            scope = scope,
            importName,
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
        scope.fatalMaybe(s"Unexpected: $other")
        Nil
    }
  }

  sealed trait MemberRet

  object MemberRet {
    def apply(value: MemberTree, isStatic: Boolean): MemberRet =
      if (isStatic) Static(value) else Normal(value)

    final case class Ctor(value: CtorTree) extends MemberRet

    final case class Normal(value: MemberTree) extends MemberRet
    final case class Static(value: MemberTree) extends MemberRet

    final case class Inheritance(value: TypeRef) extends MemberRet

    def unapply(es: Seq[MemberRet]): Some[(Seq[CtorTree], Seq[MemberTree], Seq[TypeRef], Seq[MemberTree])] = {
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

  def tsMember(_scope: TsTreeScope, scalaJsDefined: Boolean, importName: ImportName)(t1: TsMember): Seq[MemberRet] = {
    lazy val scope = _scope / t1
    t1 match {
      case TsMemberCall(cs, level, signature) =>
        Seq(
          MemberRet(
            tsMethod(scope, importName, level, Name.APPLY, cs, signature, scalaJsDefined),
            isStatic = false
          )
        )
      case TsMemberCtor(cs, _, _sig) =>
        Seq(MemberRet.Inheritance(ImportType.newableFunction(scope, importName, _sig, cs)))

      case TsMemberFunction(cs, level, TsIdent.constructor, sig, false, _, _) =>
        Seq(
          MemberRet.Ctor(CtorTree(level, tsFunParams(scope / sig, importName, params = sig.params), cs ++ sig.comments))
        )

      case m: TsMemberProperty =>
        tsMemberProperty(scope, scalaJsDefined, importName)(m)

      case TsMemberFunction(cs, level, name, signature, isStatic, isReadOnly, isOptional) =>
        if (isOptional) {
          val asFunction =
            TsMemberProperty(cs, level, name, Some(TsTypeFunction(signature)), None, isStatic, isReadOnly, isOptional)

          tsMemberProperty(scope.`..`, scalaJsDefined, importName)(asFunction)
        } else {
          Seq(MemberRet(tsMethod(scope, importName, level, importName(name), cs, signature, scalaJsDefined), isStatic))
        }

      case m: TsMemberIndex =>
        m.indexing match {
          case IndexingDict(indexName, indexType) =>
            val indexTpe = ImportType(Wildcards.No, scope, importName)(indexType)
            val valueTpe = ImportType(Wildcards.No, scope, importName)(m.valueType)

            val rewritten: TypeRef =
              if (indexTpe === TypeRef.String)
                TypeRef.StringDictionary(valueTpe, m.comments + Comment(s"/* ${indexName.value} */"))
              else if (indexTpe === TypeRef.Double)
                TypeRef.NumberDictionary(valueTpe, m.comments + Comment(s"/* ${indexName.value} */"))
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
                    FieldTree(
                      annotations = Seq(a),
                      name        = importName(symName),
                      tpe         = ImportType(Wildcards.No, scope, importName)(m.valueType).withOptional(m.isOptional),
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

  def tsMemberProperty(scope: TsTreeScope, scalaJsDefined: Boolean, importName: ImportName)(
      m:                      TsMemberProperty
  ): Seq[MemberRet] =
    (m.name, m.tpe) match {
      case (_, Some(TsTypeQuery(_))) =>
        scope.logger.info(s"Dropping $m")
        Nil
      case (importName(name), Some(TsTypeObject(members)))
          if !m.isOptional && members.forall(_.isInstanceOf[TsMemberCall]) =>
        // alternative notation for overload methods
        members.collect { case x: TsMemberCall => x } map (
            call =>
              MemberRet(
                tsMethod(scope / call, importName, call.level, name, call.comments, call.signature, scalaJsDefined),
                m.isStatic
              )
        )

      case (importName(name), tpe: Option[TsType]) =>
        val fieldType: MemberImpl =
          (scalaJsDefined, m.isOptional) match {
            case (true, true)  => MemberImplCustom("js.undefined")
            case (true, false) => MemberImplNotImplemented
            case _             => MemberImplNative
          }

        val importedType =
          ImportType.orLitOrAny(Wildcards.No, scope, importName)(tpe, m.literal).withOptional(m.isOptional)
        Seq(
          MemberRet(
            hack(
              FieldTree(
                annotations = Annotation.jsName(name),
                name        = name,
                tpe         = importedType,
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

  def hack(fs: FieldTree): FieldTree =
    fs.comments.cs.partitionCollect { case c if c === ExpandCallables.MarkerComment => c } match {
      case (Nil, _)  => fs
      case (_, rest) => fs.withSuffix("_Original").copy(comments = Comments(rest))
    }

  def typeParam(scope: TsTreeScope, importName: ImportName)(tp: TsTypeParam): TypeParamTree =
    TypeParamTree(
      name       = importName(tp.name),
      upperBound = tp.upperBound map ImportType(Wildcards.No, scope / tp, importName),
      comments   = tp.comments
    )

  def tsFunParams(scope: TsTreeScope, importName: ImportName, params: Seq[TsFunParam]): Seq[ParamTree] =
    params map { param =>
      val tpe       = ImportType.orAny(Wildcards.No, scope / param, importName)(param.tpe)
      val undefType = if (param.isOptional) TypeRef.UndefOr(tpe) else tpe
      ParamTree(importName(param.name), undefType, param.comments)
    }

  def tsMethod(scope:          TsTreeScope,
               importName:     ImportName,
               level:          ProtectionLevel,
               name:           Name,
               cs:             Comments,
               sig:            TsFunSig,
               scalaJsDefined: Boolean): MethodTree = {

    val as = Annotation.method(name, isBracketAccess = false)

    val containedLiterals: Seq[TsLiteralString] =
      TreeTraverse.collectSeq(sig.params) { case x: TsLiteralString => x }

    val fieldType: MemberImpl =
      if (scalaJsDefined) MemberImplNotImplemented else MemberImplNative

    val resultType: TypeRef = (
      sig.resultType filter (_ =/= TsTypeRef.any)
        map ImportType(Wildcards.No, scope, importName)
        getOrElse TypeRef.Any
    )

    val ret = MethodTree(
      annotations = as,
      level       = level,
      name        = name,
      tparams     = sig.tparams map typeParam(scope, importName),
      params      = Seq(tsFunParams(scope, importName, sig.params)),
      impl        = fieldType,
      resultType  = resultType,
      isOverride  = false,
      comments    = cs ++ sig.comments
    )

    containedLiterals.distinct.toList match {
      case _ if name === Name.APPLY || name === Name.namespaced => ret
      case oneLit :: Nil                                        => ret withSuffix "_" withSuffix oneLit
      case _                                                    => ret
    }
  }
}

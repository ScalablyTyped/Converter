package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase1Res.{LibTs, UnpackLibs}
import com.olvind.tso.scalajs._
import com.olvind.tso.scalajs.transforms.{CleanIllegalNames, ContainerPolicy}
import com.olvind.tso.ts.{ParentsResolver, _}

class ImportTree(
    importName:           ImportName,
    importType:           ImportType,
    illegalNames:         CleanIllegalNames,
    enableScalaJsDefined: Boolean,
) {
  def apply(lib: LibTs, logger: Logger[Unit]): PackageTree = {
    val deps = UnpackLibs(lib.dependencies).map {
      case (source, depLib) => source -> depLib.parsed
    }

    val scope = TsTreeScope(lib.name, pedantic = true, deps, logger).caching / lib.parsed

    val ret = container(
      importName,
      scope,
      lib.parsed.comments,
      lib.name,
      JsLocation.Zero,
      lib.parsed.members,
      lib.parsed.codePath,
    )

    val require = {
      val libName = importName(lib.name)
      val name    = Name(libName.unescaped + "Require")
      ModuleTree(
        Seq(Annotation.JsImport(lib.name.value, Imported.Namespace), Annotation.JsNative),
        name,
        Nil,
        Nil,
        Comments("""/* This can be used to `require` the library as a side effect.
  If it is a global library this will make scalajs-bundler include it */
"""),
        codePath   = QualifiedName(importName.outputPkg :: libName :: name :: Nil),
        isOverride = false,
      )
    }

    val withRequire = ret.copy(members = ret.members :+ require)

    PackageTree(Nil, importName.outputPkg, List(withRequire), NoComments, QualifiedName(List(importName.outputPkg)))
  }

  def decl(_scope: TsTreeScope)(t1: TsContainerOrDecl): Seq[Tree] = {
    val scope: TsTreeScope = _scope / t1

    t1 match {
      case TsDeclModule(cs, _, name, decls, codePath, jsLocation) =>
        Seq(
          container(
            importName = importName,
            scope      = scope,
            cs         = cs,
            name       = name,
            jsLocation = jsLocation,
            tsMembers  = decls,
            codePath   = codePath,
          ),
        )

      case TsAugmentedModule(name, decls, codePath, jsLocation) =>
        Seq(
          container(
            importName = importName,
            scope      = scope,
            cs         = Comments(Comment("/* augmented module */\n")),
            name       = name,
            jsLocation = jsLocation,
            tsMembers  = decls,
            codePath   = codePath,
          ),
        )

      case TsDeclNamespace(cs, _, name, decls, codePath, jsLocation) =>
        Seq(
          container(
            importName = importName,
            scope      = scope,
            cs         = cs,
            name       = name,
            jsLocation = jsLocation,
            tsMembers  = decls,
            codePath   = codePath,
          ),
        )

      case TsGlobal(cs, _, ms, codePath) =>
        Seq(
          container(
            importName = importName,
            scope      = scope,
            cs         = cs,
            name       = TsIdent.Global,
            jsLocation = JsLocation.Zero,
            tsMembers  = ms,
            codePath   = codePath,
          ),
        )

      case TsDeclVar(cs, _, _, importName(name), Some(TsTypeObject(_, members)), None, location, codePath, false) =>
        val newCodePath = importName(codePath)
        val MemberRet(ctors, ms, inheritance, statics) =
          members flatMap tsMember(scope, scalaJsDefined = false, importName, newCodePath)

        if (statics.nonEmpty || ctors.nonEmpty) {
          scope.logger.warn(s"Dropping static members from var ${statics.map(_.codePath)}")
        }

        Seq(ModuleTree(ImportJsLocation(location), name, inheritance, ms, cs, newCodePath, isOverride = false))

      case TsDeclVar(
          cs,
          _,
          readOnly,
          ImportName.valueDefinition(name, annOpt),
          tpeOpt,
          _,
          jsLocation,
          codePath,
          isOptional,
          ) =>
        val tpe = importType.orAny(Wildcards.Prohibit, scope, importName)(tpeOpt).withOptional(isOptional)

        if (name === Name.Symbol) {
          Seq(
            ModuleTree(
              annotations = ImportJsLocation(jsLocation),
              name        = name,
              parents     = Seq(tpe),
              members     = Nil,
              comments    = cs,
              codePath    = importName(codePath),
              isOverride  = false,
            ),
          )
        } else
          Seq(
            FieldTree(
              annotations = annOpt.toList,
              name        = name,
              tpe         = tpe,
              impl        = MemberImpl.Native,
              isReadOnly  = readOnly,
              isOverride  = false,
              comments    = cs +? nameHint(name, jsLocation) + annotationComment(jsLocation),
              codePath    = importName(codePath),
            ),
          )

      case e: TsDeclEnum =>
        ImportEnum(e, ImportJsLocation(e.jsLocation), scope, importName, importType, illegalNames)

      case TsDeclClass(cs, _, isAbstract, importName(name), tparams, parent, implements, members, location, codePath) =>
        val newCodePath = importName(codePath)
        val MemberRet(ctors, ms, extraInheritance, statics: Seq[MemberTree]) =
          members flatMap tsMember(scope, scalaJsDefined = false, importName, newCodePath)

        val anns    = ImportJsLocation(location)
        val parents = parent.to[Seq] ++ implements map importType(Wildcards.Prohibit, scope, importName)

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
          comments    = cs,
          codePath    = newCodePath,
        )

        val module: Option[ModuleTree] =
          if (statics.nonEmpty)
            Some(
              ModuleTree(
                anns,
                name,
                Nil,
                statics,
                Comments(Comment("/* static members */\n")),
                newCodePath,
                isOverride = false,
              ),
            )
          else None

        cls :: module.to[List]

      case i @ TsDeclInterface(cs, _, importName(name), tparams, inheritance, members, codePath) =>
        val withParents = ParentsResolver(scope, i)

        val (anns, newComments, isScalaJsDefined) = (CanBeScalaJsDefined(withParents), enableScalaJsDefined) match {
          case (true, true)  => (List(Annotation.ScalaJSDefined), cs, true)
          case (true, false) => (List(Annotation.JsNative), cs + CommentData(Markers.CouldBeScalaJsDefined), false)
          case (false, _)    => (List(Annotation.JsNative), cs, false)
        }

        val newCodePath = importName(codePath)
        val MemberRet(ctors, ms, extraInheritance, _) =
          members flatMap tsMember(scope, isScalaJsDefined, importName, newCodePath)
        val parents = inheritance.map(importType(Wildcards.Prohibit, scope, importName))

        Seq(
          ClassTree(
            annotations = anns,
            name        = name,
            tparams     = tparams map typeParam(scope, importName),
            parents     = parents ++ extraInheritance,
            ctors       = ctors,
            members     = ms,
            classType   = ClassType.Trait,
            isSealed    = false,
            comments    = newComments,
            codePath    = newCodePath,
          ),
        )

      case TsDeclTypeAlias(cs, _, importName(name), tparams, alias, codePath) =>
        Seq(
          TypeAliasTree(
            name     = name,
            tparams  = tparams map typeParam(scope, importName),
            alias    = importType(Wildcards.Prohibit, scope, importName)(alias),
            comments = cs,
            codePath = importName(codePath),
          ),
        )

      case TsDeclFunction(cs, _, ImportName.valueDefinition(name, annOpt), sig, jsLocation, codePath) =>
        Seq(
          tsMethod(
            scope          = scope,
            importName     = importName,
            level          = ProtectionLevel.Default,
            name           = name,
            annOpt         = annOpt,
            cs             = cs +? nameHint(name, jsLocation) + annotationComment(jsLocation),
            sig            = sig,
            scalaJsDefined = false,
            ownerCP        = importName(codePath),
          ),
        )
      case _: TsExportAsNamespace => Nil
      case _: TsImport            => Nil

      case other =>
        scope.fatalMaybe(s"Unexpected: $other")
        Nil
    }
  }

  def nameHint(name: Name, jsLocation: JsLocation): Option[CommentData] =
    name match {
      case Name.Default | Name.APPLY | Name.namespaced =>
        val strOpt = jsLocation match {
          case JsLocation.Global(TsQIdent(parts)) if parts.nonEmpty                => Some(parts.last.value)
          case JsLocation.Module(_, ModuleSpec.Specified(parts)) if parts.nonEmpty => Some(parts.last.value)
          case JsLocation.Module(modName, _)                                       => Some(modName.fragments.last)
          case _                                                                   => None
        }
        strOpt map (h => CommentData(Markers.NameHint(h)))
      case _ => None
    }

  sealed trait MemberRet

  object MemberRet {
    def apply(value: MemberTree, isStatic: Boolean): MemberRet =
      if (isStatic) Static(value) else Normal(value)

    case class Ctor(value: CtorTree) extends MemberRet

    case class Normal(value: MemberTree) extends MemberRet
    case class Static(value: MemberTree) extends MemberRet

    case class Inheritance(value: TypeRef) extends MemberRet

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

      RewriteNamespaceMembers(others) match {
        case (moreInheritance, newOthers, shouldBeEmpty) =>
          require(shouldBeEmpty.isEmpty)
          Some((ctors, newOthers, inheritance ++ moreInheritance, static))
      }
    }
  }

  def tsMember(_scope: TsTreeScope, scalaJsDefined: Boolean, importName: ImportName, ownerCP: QualifiedName)(
      t1:              TsMember,
  ): Seq[MemberRet] = {
    lazy val scope = _scope / t1
    t1 match {
      case TsMemberCall(cs, level, signature) =>
        Seq(
          MemberRet(
            tsMethod(scope, importName, level, Name.APPLY, None, cs, signature, scalaJsDefined, ownerCP),
            isStatic = false,
          ),
        )
      case TsMemberCtor(cs, _, _sig) =>
        Seq(MemberRet.Inheritance(importType.newableFunction(scope, importName, _sig, cs)))

      case TsMemberFunction(cs, level, TsIdent.constructor, sig, false, _, _) =>
        Seq(
          MemberRet.Ctor(
            CtorTree(level, tsFunParams(scope / sig, importName, params = sig.params), cs ++ sig.comments),
          ),
        )

      case m: TsMemberProperty =>
        tsMemberProperty(scope, scalaJsDefined, importName, ownerCP)(m)

      case TsMemberFunction(cs, level, name, signature, isStatic, isReadOnly, isOptional) =>
        if (isOptional) {
          val asFunction =
            TsMemberProperty(cs, level, name, Some(TsTypeFunction(signature)), None, isStatic, isReadOnly, isOptional)

          tsMemberProperty(scope.`..`, scalaJsDefined, importName, ownerCP)(asFunction)
        } else {
          val (newName, annOpt) = ImportName.valueDefinition(name)
          Seq(
            MemberRet(
              tsMethod(scope, importName, level, newName, annOpt, cs, signature, scalaJsDefined, ownerCP),
              isStatic,
            ),
          )
        }

      case m: TsMemberIndex =>
        m.indexing match {
          case IndexingDict(indexName, indexType) =>
            val indexTpe = importType(Wildcards.No, scope, importName)(indexType)
            val valueTpe = importType.orAny(Wildcards.No, scope, importName)(m.valueType)

            val rewritten: TypeRef =
              if (indexTpe === TypeRef.String)
                TypeRef.StringDictionary(valueTpe, m.comments + Comment(s"/* ${indexName.value} */"))
              else if (indexTpe === TypeRef.Double)
                TypeRef.NumberDictionary(valueTpe, m.comments + Comment(s"/* ${indexName.value} */"))
              else scope.logger.fatal(s"Unsupported index type $indexTpe")

            Seq(MemberRet.Inheritance(rewritten))
          case IndexingSingle(name) =>
            val KnownSymbols = Set(
              "hasInstance",
              "isConcatSpreadable",
              "iterator",
              "match",
              "replace",
              "search",
              "species",
              "split",
              "toPrimitive",
              "toStringTag",
              "unscopables",
            )
            name.parts match {
              case TsIdent.Symbol :: symName :: Nil if KnownSymbols(symName.value) =>
                val a = Annotation.JsNameSymbol(QualifiedName.Symbol + ImportName.skipConversion(symName))

                val fieldType: MemberImpl =
                  (scalaJsDefined, m.isOptional) match {
                    case (true, true)  => MemberImpl.Undefined
                    case (true, false) => MemberImpl.NotImplemented
                    case _             => MemberImpl.Native
                  }

                val codeName = importName(symName)

                Seq(
                  MemberRet(
                    FieldTree(
                      annotations = Seq(a),
                      name        = codeName,
                      tpe         = importType.orAny(Wildcards.No, scope, importName)(m.valueType).withOptional(m.isOptional),
                      impl        = fieldType,
                      isReadOnly  = m.isReadOnly,
                      isOverride  = false,
                      comments    = m.comments,
                      codePath    = ownerCP + codeName,
                    ),
                    isStatic = false,
                  ),
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

  def tsMemberProperty(scope: TsTreeScope, scalaJsDefined: Boolean, importName: ImportName, ownerCP: QualifiedName)(
      m:                      TsMemberProperty,
  ): Seq[MemberRet] =
    (m.name, m.tpe) match {
      case (_, Some(TsTypeQuery(_))) =>
        scope.logger.info(s"Dropping $m")
        Nil
      case (ImportName.valueDefinition((name, annOpt)), Some(TsTypeObject(_, members)))
          if !m.isOptional && members.forall(_.isInstanceOf[TsMemberCall]) =>
        // alternative notation for overload methods
        members.collect { case x: TsMemberCall => x } map (
            call =>
              MemberRet(
                tsMethod(
                  scope / call,
                  importName,
                  call.level,
                  name,
                  annOpt,
                  call.comments,
                  call.signature,
                  scalaJsDefined,
                  ownerCP,
                ),
                m.isStatic,
              ),
          )

      case (ImportName.valueDefinition(name, annOpt), tpeOpt: Option[TsType]) =>
        val importedType = importType.orAny(Wildcards.No, scope, importName)(tpeOpt).withOptional(m.isOptional)
        val impl: MemberImpl =
          (scalaJsDefined, importedType) match {
            case (true, TypeRef.UndefOr(_)) => MemberImpl.Undefined
            case (true, _)                  => MemberImpl.NotImplemented
            case (false, _)                 => MemberImpl.Native
          }

        hack(
          FieldTree(
            annotations = annOpt.toList,
            name        = name,
            tpe         = importedType,
            impl        = impl,
            isReadOnly  = m.isReadOnly,
            isOverride  = false,
            comments    = m.comments,
            codePath    = ownerCP + name,
          ),
        ).map(f => MemberRet(f, m.isStatic)).to[Seq]
      case (name, _) =>
        scope.logger.info(s"dropping member $name")
        Nil
    }

  def hack(f: FieldTree): Option[FieldTree] =
    f.comments.extract { case Markers.ExpandedCallables => () } match {
      case None => Some(f)
      case Some((_, restCs)) =>
        if (f.name === Name.namespaced) None
        else Some(f.withSuffix("Original").copy(comments = restCs))
    }

  def typeParam(scope: TsTreeScope, importName: ImportName)(tp: TsTypeParam): TypeParamTree =
    TypeParamTree(
      name       = importName(tp.name),
      upperBound = tp.upperBound map importType(Wildcards.No, scope / tp, importName),
      comments   = tp.comments,
    )

  def tsFunParams(scope: TsTreeScope, importName: ImportName, params: Seq[TsFunParam]): Seq[ParamTree] =
    params map { param =>
      val tpe       = importType.orAny(Wildcards.No, scope / param, importName)(param.tpe)
      val undefType = tpe.withOptional(param.isOptional)
      ParamTree(importName(param.name), false, undefType, None, param.comments)
    }

  def tsMethod(
      scope:          TsTreeScope,
      importName:     ImportName,
      level:          ProtectionLevel,
      name:           Name,
      annOpt:         Option[Annotation.JsName],
      cs:             Comments,
      sig:            TsFunSig,
      scalaJsDefined: Boolean,
      ownerCP:        QualifiedName,
  ): MethodTree = {

    val fieldType: MemberImpl =
      if (scalaJsDefined) MemberImpl.NotImplemented else MemberImpl.Native

    val resultType: TypeRef = (
      sig.resultType filter (_ =/= TsTypeRef.any)
        map importType(Wildcards.No, scope, importName)
        getOrElse TypeRef.Any
    )

    /** This is how typescript specifies what types of objects the given method can be legally called on.
      * It's useful information, but only if we wanted to output say implicit conversions where we add
      * the given methods. Let's drop them for now
      */
    val trimmedParams =
      if (sig.params.headOption.exists(_.name === TsIdent.`this`)) sig.params.drop(1) else sig.params

    val ret = MethodTree(
      annotations = annOpt.toList,
      level       = level,
      name        = name,
      tparams     = sig.tparams map typeParam(scope, importName),
      params      = Seq(tsFunParams(scope, importName, trimmedParams)),
      impl        = fieldType,
      resultType  = resultType,
      isOverride  = false,
      comments    = cs ++ sig.comments,
      codePath    = ownerCP + name,
    )

    if (name === Name.APPLY || name === Name.namespaced) ret
    else {
      val containedLiterals: Seq[String] =
        TsTreeTraverse.collectSeq(sig.params) {
          case x: TsLiteral => x.literal
        }

      containedLiterals.distinct.toList.map(_.filter(_.isLetterOrDigit)).filter(_.nonEmpty) match {
        case suffix :: Nil =>
          ret withSuffix suffix
        case _ => ret
      }
    }
  }

  def annotationComment(jsLocation: JsLocation) =
    CommentData(ContainerPolicy.ClassAnnotations(ImportJsLocation(jsLocation)))

  def container(
      importName: ImportName,
      scope:      TsTreeScope,
      cs:         Comments,
      name:       TsIdent,
      jsLocation: JsLocation,
      tsMembers:  Seq[TsContainerOrDecl],
      codePath:   CodePath,
  ): ModuleTree =
    RewriteNamespaceMembers(tsMembers flatMap decl(scope)) match {
      case (inheritance, memberTrees, restTrees) =>
        val importedCp = importName(codePath)

        setCodePath(
          importedCp,
          ModuleTree(
            annotations = ImportJsLocation(jsLocation),
            name        = importName(name),
            parents     = inheritance,
            members     = memberTrees ++ restTrees,
            comments    = cs,
            codePath    = importedCp,
            isOverride  = false,
          ),
        )
    }
}

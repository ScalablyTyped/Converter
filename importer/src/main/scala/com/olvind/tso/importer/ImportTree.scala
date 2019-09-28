package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase1Res.{LibTs, UnpackLibs}
import com.olvind.tso.scalajs._
import com.olvind.tso.scalajs.transforms.ContainerPolicy
import com.olvind.tso.ts.{ParentsResolver, _}

object ImportTree {
  def apply(lib: LibTs, logger: Logger[Unit], importName: ImportName): PackageTree = {
    val deps = UnpackLibs(lib.dependencies).map {
      case (source, depLib) => source -> depLib.parsed
    }

    val scope = TsTreeScope(lib.name, pedantic = true, deps, logger).caching / lib.parsed

    val ret = ImportContainer(
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
        Seq(AnnotationTree.JsImport.Namespace(lib.name.value), AnnotationTree.JsNative.get),
        name,
        Nil,
        Nil,
        Comments("""/* This can be used to `require` the library as a side effect.
  If it is a global library this will make scalajs-bundler include it */
"""),
        codePath = QualifiedName(ScalaConfig.outputPkg, libName, name),
      )
    }

    val withRequire = ret.copy(members = ret.members :+ require)

    PackageTree(Nil, ScalaConfig.outputPkg, List(withRequire), NoComments, QualifiedName(ScalaConfig.outputPkg))
  }

  def decl(_scope: TsTreeScope, importName: ImportName)(t1: TsContainerOrDecl): Seq[Tree] = {
    val scope: TsTreeScope = _scope / t1

    t1 match {
      case TsDeclModule(cs, _, name, decls, codePath, jsLocation) =>
        Seq(
          ImportContainer(
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
          ImportContainer(
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
          ImportContainer(
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
          ImportContainer(
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

        Seq(ModuleTree(ImportJsLocation(location), name, inheritance, ms, cs, newCodePath))

      case TsDeclVar(cs, _, readOnly, importName(name), tpeOpt, _, jsLocation, codePath, isOptional) =>
        val tpe = ImportType.orAny(Wildcards.Prohibit, scope, importName)(tpeOpt).withOptional(isOptional)

        if (name === Name.Symbol) {
          Seq(
            ModuleTree(
              annotations = ImportJsLocation(jsLocation),
              name        = name,
              parents     = Seq(tpe),
              members     = Nil,
              comments    = cs,
              codePath    = importName(codePath),
            ),
          )
        } else
          Seq(
            FieldTree(
              annotations = AnnotationTree.jsName(name),
              name        = name,
              tpe         = tpe,
              impl        = ExprTree.native,
              isReadOnly  = readOnly,
              isOverride  = false,
              comments    = cs +? nameHint(name, jsLocation) + annotationComment(jsLocation),
              codePath    = importName(codePath),
            ),
          )

      case e: TsDeclEnum =>
        ImportEnum(e, ImportJsLocation(e.jsLocation), scope, importName)

      case TsDeclClass(cs, _, isAbstract, importName(name), tparams, parent, implements, members, location, codePath) =>
        val newCodePath = importName(codePath)
        val MemberRet(ctors, ms, extraInheritance, statics: Seq[MemberTree]) =
          members flatMap tsMember(scope, scalaJsDefined = false, importName, newCodePath)

        val anns    = ImportJsLocation(location)
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
              ),
            )
          else None

        cls :: module.to[List]

      case i @ TsDeclInterface(cs, _, importName(name), tparams, inheritance, members, codePath) =>
        val withParents    = ParentsResolver(scope, i)
        val scalaJsDefined = CanBeScalaJsDefined(withParents)
        val newCodePath    = importName(codePath)
        val MemberRet(ctors, ms, extraInheritance, Nil) =
          members flatMap tsMember(scope, scalaJsDefined, importName, newCodePath)
        val parents = inheritance.map(ImportType(Wildcards.Prohibit, scope, importName))

        Seq(
          ClassTree(
            annotations = Seq(if (scalaJsDefined) AnnotationTree.ScalaJSDefined.get else AnnotationTree.JsNative.get),
            name        = name,
            tparams     = tparams map typeParam(scope, importName),
            parents     = parents ++ extraInheritance,
            ctors       = ctors,
            members     = ms,
            classType   = ClassType.Trait,
            isSealed    = false,
            comments    = cs,
            codePath    = newCodePath,
          ),
        )

      case TsDeclTypeAlias(cs, _, importName(name), tparams, alias, codePath) =>
        Seq(
          TypeAliasTree(
            name     = name,
            tparams  = tparams map typeParam(scope, importName),
            alias    = ImportType(Wildcards.Prohibit, scope, importName)(alias),
            comments = cs,
            codePath = importName(codePath),
          ),
        )

      case TsDeclFunction(cs, _, importName(name), sig, jsLocation, codePath) =>
        Seq(
          tsMethod(
            scope          = scope,
            importName     = importName,
            level          = ProtectionLevel.Default,
            name           = name,
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
            tsMethod(scope, importName, level, Name.APPLY, cs, signature, scalaJsDefined, ownerCP),
            isStatic = false,
          ),
        )
      case TsMemberCtor(cs, _, _sig) =>
        Seq(MemberRet.Inheritance(ImportType.newableFunction(scope, importName, _sig, cs)))

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
          Seq(
            MemberRet(
              tsMethod(scope, importName, level, importName(name), cs, signature, scalaJsDefined, ownerCP),
              isStatic,
            ),
          )
        }

      case m: TsMemberIndex =>
        m.indexing match {
          case IndexingDict(indexName, indexType) =>
            val indexTpe = ImportType(Wildcards.No, scope, importName)(indexType)
            val valueTpe = ImportType.orAny(Wildcards.No, scope, importName)(m.valueType)

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
                val a = AnnotationTree.JsNameSymbol(QualifiedName.Symbol + ImportName.skipConversion(symName))

                val fieldType: ImplTree =
                  (scalaJsDefined, m.isOptional) match {
                    case (true, true)  => ExprTree.undefined
                    case (true, false) => NotImplemented
                    case _             => ExprTree.native
                  }

                val codeName = importName(symName)

                Seq(
                  MemberRet(
                    FieldTree(
                      annotations = Seq(a),
                      name        = codeName,
                      tpe         = ImportType.orAny(Wildcards.No, scope, importName)(m.valueType).withOptional(m.isOptional),
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
      case (importName(name), Some(TsTypeObject(_, members)))
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
                  call.comments,
                  call.signature,
                  scalaJsDefined,
                  ownerCP,
                ),
                m.isStatic,
              ),
          )

      case (importName(name), tpeOpt: Option[TsType]) =>
        val importedType = ImportType.orAny(Wildcards.No, scope, importName)(tpeOpt).withOptional(m.isOptional)
        val impl: ImplTree =
          (scalaJsDefined, importedType) match {
            case (true, TypeRef.UndefOr(_)) => ExprTree.undefined
            case (true, _)                  => NotImplemented
            case (false, _)                 => ExprTree.native
          }

        hack(
          FieldTree(
            annotations = AnnotationTree.jsName(name),
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
      upperBound = tp.upperBound map ImportType(Wildcards.No, scope / tp, importName),
      comments   = tp.comments,
    )

  def tsFunParams(scope: TsTreeScope, importName: ImportName, params: Seq[TsFunParam]): Seq[ParamTree] =
    params map { param =>
      val tpe       = ImportType.orAny(Wildcards.No, scope / param, importName)(param.tpe)
      val undefType = tpe.withOptional(param.isOptional)
      ParamTree(importName(param.name), undefType, NotImplemented, param.comments)
    }

  def tsMethod(
      scope:          TsTreeScope,
      importName:     ImportName,
      level:          ProtectionLevel,
      name:           Name,
      cs:             Comments,
      sig:            TsFunSig,
      scalaJsDefined: Boolean,
      ownerCP:        QualifiedName,
  ): MethodTree = {

    val as = AnnotationTree.method(name, isBracketAccess = false)

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
      impl        = if (scalaJsDefined) NotImplemented else ExprTree.native,
      resultType  = resultType,
      isOverride  = false,
      comments    = cs ++ sig.comments,
      codePath    = ownerCP + name,
    )

    if (name === Name.APPLY || name === Name.namespaced) ret
    else {
      val containedLiterals: Seq[String] =
        TreeTraverse.collectSeq(sig.params) {
          case x: TsLiteral => stringUtils.unquote(x.literal)
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
}

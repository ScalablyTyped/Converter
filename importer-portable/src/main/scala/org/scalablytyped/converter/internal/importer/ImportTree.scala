package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.importer.Phase1Res.{LibTs, UnpackLibs}
import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.scalajs.transforms.{CleanIllegalNames, ContainerPolicy}
import org.scalablytyped.converter.internal.ts.{ParentsResolver, _}

class ImportTree(
    outputPkg:            Name,
    importName:           AdaptiveNamingImport,
    importType:           ImportType,
    illegalNames:         CleanIllegalNames,
    importExpr:           ImportExpr,
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
      JsLocation.Zero,
      lib.parsed.members,
      lib.parsed.codePath,
    )

    val require = {
      val libName = ImportName(lib.name)
      val name    = Name(libName.unescaped + "Require")
      ModuleTree(
        IArray(Annotation.JsImport(lib.name.value, Imported.Namespace, None), Annotation.JsNative),
        name,
        Empty,
        Empty,
        Comments("""/* This can be used to `require` the library as a side effect.
  If it is a global library this will make scalajs-bundler include it */
"""),
        codePath   = QualifiedName(IArray(outputPkg, libName, name)),
        isOverride = false,
      )
    }

    val withRequire = ret.copy(members = ret.members :+ require)

    PackageTree(
      Empty,
      outputPkg,
      IArray(withRequire),
      NoComments,
      QualifiedName(IArray(outputPkg)),
    )
  }

  def decl(_scope: TsTreeScope)(t1: TsContainerOrDecl): IArray[Tree] = {
    val scope: TsTreeScope = _scope / t1

    t1 match {
      case TsDeclModule(cs, _, _, decls, codePath, jsLocation) =>
        IArray(
          container(
            importName = importName,
            scope      = scope,
            cs         = cs,
            jsLocation = jsLocation,
            tsMembers  = decls,
            codePath   = codePath,
          ),
        )

      case TsAugmentedModule(_, decls, codePath, jsLocation) =>
        IArray(
          container(
            importName = importName,
            scope      = scope,
            cs         = Comments(Comment("/* augmented module */\n")),
            jsLocation = jsLocation,
            tsMembers  = decls,
            codePath   = codePath,
          ),
        )

      case TsDeclNamespace(cs, _, _, decls, codePath, jsLocation) =>
        IArray(
          container(
            importName = importName,
            scope      = scope,
            cs         = cs,
            jsLocation = jsLocation,
            tsMembers  = decls,
            codePath   = codePath,
          ),
        )

      case TsGlobal(cs, _, ms, codePath) =>
        IArray(
          container(
            importName = importName,
            scope      = scope,
            cs         = cs,
            jsLocation = JsLocation.Zero,
            tsMembers  = ms,
            codePath   = codePath,
          ),
        )

      case TsDeclVar(cs, _, _, _, Some(TsTypeObject(_, members)), None, location, codePath) =>
        val newCodePath = importName(codePath)
        val MemberRet(ctors, ms, inheritance, statics) =
          members.flatMap(tsMember(scope, scalaJsDefined = false, importName, newCodePath))

        if (statics.nonEmpty || ctors.nonEmpty) {
          scope.logger.warn(s"Dropping static members from var ${statics.map(_.codePath)}")
        }

        IArray(
          ModuleTree(
            ImportJsLocation(location),
            newCodePath.parts.last,
            inheritance.sorted,
            ms,
            cs,
            newCodePath,
            isOverride = false,
          ),
        )

      case TsDeclVar(
          cs,
          _,
          readOnly,
          _,
          tpeOpt,
          _,
          jsLocation,
          importName.withJsNameAnnotation((codePath, annOpt)),
          ) =>
        val tpe  = importType.orAny(Wildcards.Prohibit, scope, importName)(tpeOpt)
        val name = codePath.parts.last

        if (name === Name.Symbol) {
          IArray(
            ModuleTree(
              annotations = ImportJsLocation(jsLocation),
              name        = name,
              parents     = IArray(tpe),
              members     = Empty,
              comments    = cs,
              codePath    = codePath,
              isOverride  = false,
            ),
          )
        } else
          IArray(
            FieldTree(
              annotations = IArray.fromOption(annOpt),
              name        = name,
              tpe         = tpe,
              impl        = ExprTree.native,
              isReadOnly  = readOnly,
              isOverride  = false,
              comments    = cs +? nameHint(name, jsLocation) + annotationComment(jsLocation),
              codePath    = codePath,
            ),
          )

      case e: TsDeclEnum =>
        ImportEnum(e, ImportJsLocation(e.jsLocation), scope, importName, importType, illegalNames, importExpr)

      case TsDeclClass(cs, _, isAbstract, _, tparams, parent, implements, members, location, codePath) =>
        val newCodePath = importName(codePath)
        val MemberRet(ctors, ms, extraInheritance, statics: IArray[MemberTree]) =
          members.flatMap(tsMember(scope, scalaJsDefined = false, importName, newCodePath))

        val anns    = ImportJsLocation(location)
        val parents = (IArray.fromOption(parent) ++ implements).map(importType(Wildcards.Prohibit, scope, importName))

        val classType = if (isAbstract) ClassType.AbstractClass else ClassType.Class
        val cls = ClassTree(
          isImplicit  = false,
          annotations = anns,
          name        = newCodePath.parts.last,
          tparams     = tparams.map(typeParam(scope, importName)),
          parents     = parents ++ extraInheritance.sorted,
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
                newCodePath.parts.last,
                Empty,
                statics,
                Comments(Comment("/* static members */\n")),
                newCodePath,
                isOverride = false,
              ),
            )
          else None

        IArray.fromOptions(Some(cls), module)

      case i @ TsDeclInterface(cs, _, _, tparams, inheritance, members, codePath) =>
        val withParents = ParentsResolver(scope, i)

        val (anns, newComments, isScalaJsDefined) = (CanBeScalaJsDefined(withParents), enableScalaJsDefined) match {
          case (true, true)  => (IArray(Annotation.ScalaJSDefined), cs, true)
          case (true, false) => (IArray(Annotation.JsNative), cs + CommentData(Markers.CouldBeScalaJsDefined), false)
          case (false, _)    => (IArray(Annotation.JsNative), cs, false)
        }

        val newCodePath = importName(codePath)
        val MemberRet(ctors, ms, extraInheritance, _) =
          members.flatMap(tsMember(scope, isScalaJsDefined, importName, newCodePath))
        val parents = inheritance.map(importType(Wildcards.Prohibit, scope, importName))

        IArray(
          ClassTree(
            isImplicit  = false,
            annotations = anns,
            name        = newCodePath.parts.last,
            tparams     = tparams.map(typeParam(scope, importName)),
            parents     = parents ++ extraInheritance.sorted,
            ctors       = ctors,
            members     = ms,
            classType   = ClassType.Trait,
            isSealed    = false,
            comments    = newComments,
            codePath    = newCodePath,
          ),
        )

      case TsDeclTypeAlias(cs, _, _, tparams, alias, codePath) =>
        val importedCp = importName(codePath)
        IArray(
          TypeAliasTree(
            name     = importedCp.parts.last,
            tparams  = tparams.map(typeParam(scope, importName)),
            alias    = importType(Wildcards.Prohibit, scope, importName)(alias),
            comments = cs,
            codePath = importedCp,
          ),
        )

      case TsDeclFunction(cs, _, _, sig, jsLocation, importName.withJsNameAnnotation(codePath, annOpt)) =>
        val name = codePath.parts.last
        IArray(
          tsMethod(
            scope          = scope,
            importName     = importName,
            level          = ProtectionLevel.Default,
            name           = name,
            annOpt         = annOpt,
            cs             = cs +? nameHint(name, jsLocation) + annotationComment(jsLocation),
            methodType     = MethodType.Normal,
            sig            = sig,
            scalaJsDefined = false,
            ownerCP        = codePath,
          ),
        )
      case _: TsExportAsNamespace => Empty
      case _: TsImport            => Empty

      case other =>
        scope.fatalMaybe(s"Unexpected: $other")
        Empty
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
        strOpt.map(h => CommentData(Markers.NameHint(h)))
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

    def unapply(
        es: IArray[MemberRet],
    ): Some[(IArray[CtorTree], IArray[MemberTree], IArray[TypeRef], IArray[MemberTree])] = {
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

  def tsMember(_scope: TsTreeScope, scalaJsDefined: Boolean, importName: AdaptiveNamingImport, ownerCP: QualifiedName)(
      t1:              TsMember,
  ): IArray[MemberRet] = {
    lazy val scope = _scope / t1
    t1 match {
      case TsMemberCall(cs, level, signature) =>
        IArray(
          MemberRet(
            tsMethod(
              scope          = scope,
              importName     = importName,
              level          = level,
              name           = Name.APPLY,
              annOpt         = None,
              cs             = cs,
              methodType     = MethodType.Normal,
              sig            = signature,
              scalaJsDefined = scalaJsDefined,
              ownerCP        = ownerCP,
            ),
            isStatic = false,
          ),
        )
      case TsMemberCtor(cs, _, _sig) =>
        IArray(MemberRet.Inheritance(importType.newableFunction(scope, importName, _sig, cs)))

      case f @ TsMemberFunction(cs, level, TsIdent.constructor, methodType, sig, false, _) =>
        if (methodType =/= MethodType.Normal) {
          sys.error(s"unexpected $f")
        }
        IArray(
          MemberRet.Ctor(
            CtorTree(level, tsFunParams(scope / sig, importName, params = sig.params), cs ++ sig.comments),
          ),
        )

      case m: TsMemberProperty =>
        tsMemberProperty(scope, scalaJsDefined, importName, ownerCP)(m)

      case TsMemberFunction(cs, level, name, methodType, signature, isStatic, isReadOnly @ _) =>
        val (newName, annOpt) = ImportName.withJsNameAnnotation(name)
        IArray(
          MemberRet(
            tsMethod(scope, importName, level, newName, annOpt, cs, methodType, signature, scalaJsDefined, ownerCP),
            isStatic,
          ),
        )

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

            IArray(MemberRet.Inheritance(rewritten))
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
              case IArray.exactlyTwo(TsIdent.Symbol, sym) if KnownSymbols(sym.value) =>
                val symName    = ImportName.skipConversion(sym)
                val a          = Annotation.JsNameSymbol(QualifiedName.Symbol + symName)
                val isOptional = m.valueType.exists(tpe => OptionalType.unapply(tpe).isDefined)
                val fieldType: ImplTree =
                  (scalaJsDefined, isOptional) match {
                    case (true, true)  => ExprTree.undefined
                    case (true, false) => NotImplemented
                    case _             => ExprTree.native
                  }

                IArray(
                  MemberRet(
                    FieldTree(
                      annotations = IArray(a),
                      name        = symName,
                      tpe         = importType.orAny(Wildcards.No, scope, importName)(m.valueType),
                      impl        = fieldType,
                      isReadOnly  = m.isReadOnly,
                      isOverride  = false,
                      comments    = m.comments,
                      codePath    = ownerCP + symName,
                    ),
                    isStatic = false,
                  ),
                )
              case other =>
                scope.logger.info(s"Dropping $other")
                Empty
            }
        }

      case other: TsMemberTypeMapped =>
        scope.logger.info(s"Dropping $other")
        Empty
    }
  }

  def tsMemberProperty(
      scope:          TsTreeScope,
      scalaJsDefined: Boolean,
      importName:     AdaptiveNamingImport,
      ownerCP:        QualifiedName,
  )(m:                TsMemberProperty): IArray[MemberRet] =
    (m.name, m.tpe) match {
      case (_, Some(TsTypeQuery(_))) =>
        scope.logger.info(s"Dropping $m")
        Empty
      case (ImportName.withJsNameAnnotation((name, annOpt)), Some(TsTypeObject(_, members)))
          if members.forall(_.isInstanceOf[TsMemberCall]) =>
        // alternative notation for overload methods
        members
          .collect { case x: TsMemberCall => x }
          .map(call =>
            MemberRet(
              tsMethod(
                scope          = scope / call,
                importName     = importName,
                level          = call.level,
                name           = name,
                annOpt         = annOpt,
                cs             = call.comments,
                methodType     = MethodType.Normal,
                sig            = call.signature,
                scalaJsDefined = scalaJsDefined,
                ownerCP        = ownerCP,
              ),
              m.isStatic,
            ),
          )

      case (ImportName.withJsNameAnnotation(name, annOpt), tpeOpt: Option[TsType]) =>
        val importedType = importType.orAny(Wildcards.No, scope, importName)(tpeOpt)
        val impl: ImplTree =
          (scalaJsDefined, importedType) match {
            case (true, TypeRef.UndefOr(_, _)) => ExprTree.undefined
            case (true, _)                     => NotImplemented
            case (false, _)                    => ExprTree.native
          }

        IArray
          .fromOption(
            hack(
              FieldTree(
                annotations = IArray.fromOption(annOpt),
                name        = name,
                tpe         = importedType,
                impl        = impl,
                isReadOnly  = m.isReadOnly,
                isOverride  = false,
                comments    = m.comments,
                codePath    = ownerCP + name,
              ),
            ),
          )
          .map(f => MemberRet(f, m.isStatic))
      case (name, _) =>
        scope.logger.info(s"dropping member $name")
        Empty
    }

  def hack(f: FieldTree): Option[FieldTree] =
    f.comments.extract { case Markers.ExpandedCallables => () } match {
      case None => Some(f)
      case Some((_, restCs)) =>
        if (f.name === Name.namespaced) None
        else Some(f.withSuffix("Original").copy(comments = restCs))
    }

  def typeParam(scope: TsTreeScope, importName: AdaptiveNamingImport)(tp: TsTypeParam): TypeParamTree =
    TypeParamTree(
      name        = ImportName(tp.name),
      params      = Empty,
      upperBound  = tp.upperBound.map(importType(Wildcards.No, scope / tp, importName)),
      comments    = tp.comments,
      ignoreBound = true,
    )

  def tsFunParams(scope: TsTreeScope, importName: AdaptiveNamingImport, params: IArray[TsFunParam]): IArray[ParamTree] =
    params.map { param =>
      val tpe = importType.orAny(Wildcards.No, scope / param, importName)(param.tpe)
      ParamTree(ImportName(param.name), isImplicit = false, isVal = false, tpe, NotImplemented, param.comments)
    }

  def tsMethod(
      scope:          TsTreeScope,
      importName:     AdaptiveNamingImport,
      level:          ProtectionLevel,
      name:           Name,
      annOpt:         Option[Annotation.JsName],
      cs:             Comments,
      methodType:     MethodType,
      sig:            TsFunSig,
      scalaJsDefined: Boolean,
      ownerCP:        QualifiedName,
  ): MethodTree = {

    val impl: ImplTree =
      if (scalaJsDefined) NotImplemented else ExprTree.native

    /** This is how typescript specifies what types of objects the given method can be legally called on.
      * It's useful information, but only if we wanted to output say implicit conversions where we add
      * the given methods. Let's drop them for now
      */
    val trimmedParams =
      if (sig.params.headOption.exists(_.name === TsIdent.`this`)) sig.params.drop(1) else sig.params

    val params =
      methodType match {
        case MethodType.Getter => Empty
        case _                 => IArray(tsFunParams(scope, importName, trimmedParams))
      }

    val (correctedName: Name, resultType: TypeRef) =
      methodType match {
        case MethodType.Setter =>
          (Name(s"${name.unescaped}_="), TypeRef.Unit)
        case _ =>
          val tpe = sig.resultType
            .filter(_ =/= TsTypeRef.any)
            .map(importType(Wildcards.No, scope, importName))
            .getOrElse(TypeRef.Any)
          (name, tpe)
      }

    val ret = MethodTree(
      annotations = IArray.fromOption(annOpt),
      level       = level,
      name        = correctedName,
      tparams     = sig.tparams.map(typeParam(scope, importName)),
      params      = params,
      impl        = impl,
      resultType  = resultType,
      isOverride  = false,
      comments    = cs ++ sig.comments,
      codePath    = ownerCP + correctedName,
      isImplicit  = false,
    )

    if (name === Name.APPLY || name === Name.namespaced) ret
    else {
      val containedLiterals: IArray[String] =
        TsTreeTraverse.collectIArray(sig.params) {
          case x: TsLiteral => x.literal
        }

      containedLiterals.distinct.toList.map(_.filter(_.isLetterOrDigit)).filter(_.nonEmpty) match {
        case suffix :: Nil =>
          ret.withSuffix(suffix)
        case _ => ret
      }
    }
  }

  def annotationComment(jsLocation: JsLocation) =
    CommentData(ContainerPolicy.ClassAnnotations(ImportJsLocation(jsLocation)))

  def container(
      importName: AdaptiveNamingImport,
      scope:      TsTreeScope,
      cs:         Comments,
      jsLocation: JsLocation,
      tsMembers:  IArray[TsContainerOrDecl],
      codePath:   CodePath,
  ): ModuleTree =
    RewriteNamespaceMembers(tsMembers.flatMap(decl(scope))) match {
      case (inheritance, memberTrees, restTrees) =>
        val importedCp = importName(codePath)

        setCodePath(
          importedCp,
          ModuleTree(
            annotations = ImportJsLocation(jsLocation),
            name        = importedCp.parts.last,
            parents     = inheritance,
            members     = memberTrees ++ restTrees,
            comments    = cs,
            codePath    = importedCp,
            isOverride  = false,
          ),
        )
    }
}

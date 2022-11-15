package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.scalajs.transforms.CleanIllegalNames
import org.scalablytyped.converter.internal.ts.{ParentsResolver, _}

class ImportTree(
    outputPkg:            Name,
    importName:           AdaptiveNamingImport,
    importType:           ImportType,
    illegalNames:         CleanIllegalNames,
    importExpr:           ImportExpr,
    enableScalaJsDefined: Boolean,
    scalaVersion:         Versions.Scala,
) {
  def apply(lib: LibTs, logger: Logger[Unit]): PackageTree = {
    val deps = lib.transitiveDependencies.map {
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
        ProtectionLevel.Public,
        name,
        Empty,
        Empty,
        Comments(
          List(
            Comment("""/* This can be used to `require` the library as a side effect.
  If it is a global library this will make scalajs-bundler include it */
"""),
            Marker.ManglerLeaveAlone,
          ),
        ),
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

  implicit val TypeRefOrdering: Ordering[TypeRef] =
    Ordering.by[TypeRef, String](Printer.formatTypeRef(0))

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

      case TsAugmentedModule(cs, _, decls, codePath, jsLocation) =>
        IArray(
          container(
            importName = importName,
            scope      = scope,
            cs         = cs + Comment("/* augmented module */\n"),
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

      case TsDeclVar(cs, _, readOnly, _, tpeOpt, _, jsLocation, codePath) =>
        val importedCp = importName(codePath)
        val name       = importedCp.parts.last
        val tpe = {
          tpeOpt match {
            case Some(TsTypeRef.`null`) =>
              TypeRef.Any.withComments(
                Comments("/* is `Null`, but independent javascript fields cannot be in scala 3 */"),
              )
            case _ =>
              importType.orAny(scope, importName)(tpeOpt)
          }
        }

        val anns = ImportJsLocation(jsLocation)

        /* need to reach well known symbols through a stable path */
        if (name === Name.Symbol)
          IArray(
            ModuleTree(
              annotations = anns,
              level       = ProtectionLevel.Public,
              name        = name,
              parents     = IArray(tpe),
              members     = Empty,
              comments    = cs,
              codePath    = importedCp,
              isOverride  = false,
            ),
          )
        else {
          IArray(
            FieldTree(
              annotations = anns,
              level       = ProtectionLevel.Public,
              name        = name,
              tpe         = tpe,
              impl        = ExprTree.native,
              isReadOnly  = readOnly,
              isOverride  = false,
              comments    = cs,
              codePath    = importedCp,
            ),
          )
        }

      case e: TsDeclEnum =>
        ImportEnum(e, ImportJsLocation(e.jsLocation), scope, importName, importType, illegalNames, importExpr)

      case TsDeclClass(cs, _, isAbstract, _, tparams, parent, implements, members, location, codePath) =>
        val newCodePath = importName(codePath)

        val (statics, nonStatics) = members.partitionCollect {
          case x: TsMemberFunction if x.isStatic => Hoisting.memberToDecl(codePath, location)(x)
          case x: TsMemberProperty if x.isStatic => Hoisting.memberToDecl(codePath, location)(x)
        }

        val MemberRet(ctors, ms, extraInheritance, cs2) =
          nonStatics.flatMap(tsMember(scope, scalaJsDefined = false, newCodePath))

        val importedStatics = statics.flatMap {
          case Some(static) => decl(scope)(static)
          case None         => Empty
        }
        val anns    = ImportJsLocation(location)
        val parents = (IArray.fromOption(parent) ++ implements).map(importType(scope, importName))

        val abstractComment = if (isAbstract) Comments("/* note: abstract class */") else NoComments

        val cls = ClassTree(
          isImplicit  = false,
          annotations = anns,
          level       = ProtectionLevel.Public,
          name        = newCodePath.parts.last,
          tparams     = tparams.map(typeParam(scope, importName)),
          parents     = parents ++ extraInheritance.sorted,
          ctors       = ctors,
          members     = ms,
          classType   = ClassType.Class,
          isSealed    = false,
          comments    = cs ++ cs2 ++ abstractComment,
          codePath    = newCodePath,
        )

        val module: Option[ModuleTree] =
          if (importedStatics.nonEmpty)
            Some(
              ModuleTree(
                anns,
                ProtectionLevel.Public,
                newCodePath.parts.last,
                Empty,
                importedStatics,
                Comments(Comment("/* static members */\n")),
                newCodePath,
                isOverride = false,
              ),
            )
          else None

        IArray.fromOptions(Some(cls), module)

      case i @ TsDeclInterface(cs, _, _, tparams, inheritance, members, codePath) =>
        val withParents = ParentsResolver(scope, i)

        val (anns, newComments, isScalaJsDefined) = (IsUserImplementable(withParents), enableScalaJsDefined) match {
          case (true, true)  => (IArray(Annotation.ScalaJSDefined), cs, true)
          case (true, false) => (IArray(Annotation.JsNative), cs + Marker.CouldBeScalaJsDefined, false)
          case (false, _)    => (IArray(Annotation.JsNative), cs, false)
        }

        val newCodePath = importName(codePath)
        val MemberRet(ctors, ms, extraInheritance, cs2) =
          members.flatMap(tsMember(scope, isScalaJsDefined, newCodePath))
        val parents = inheritance.map(importType(scope, importName))

        IArray(
          ClassTree(
            isImplicit  = false,
            annotations = anns,
            level       = ProtectionLevel.Public,
            name        = newCodePath.parts.last,
            tparams     = tparams.map(typeParam(scope, importName)),
            parents     = parents ++ extraInheritance.sorted,
            ctors       = ctors,
            members     = ms,
            classType   = ClassType.Trait,
            isSealed    = false,
            comments    = newComments ++ cs2,
            codePath    = newCodePath,
          ),
        )

      /* Conditional types. Proper handling (of static) cases is done elsewhere, this just takes care of the dependencies */
      case TsDeclTypeAlias(cs, _, _, tparams, tpe: TsTypeConditional, codePath) =>
        val importedCp      = importName(codePath)
        val importedName    = importedCp.parts.last
        val importedTparams = tparams.map(typeParam(scope, importName))

        def warning(explain: String) =
          cs ++ Comments(
            s"""/** NOTE: Conditional type definitions are impossible to translate to Scala.
               | * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
               | * $explain.
               | * TS definition: {{{
               | ${TsTypeFormatter(tpe)}
               | }}}
               | */
               |""".stripMargin,
          )

        /**
          * Find the first referenced type in the conditional type which
          * - is not  recursive
          * - does not refer to any inferred types
          * - does not translate to `Any` or similar, since those types are not useful
          */
        def findCandidates(x: TsType, depth: Int, inferred: IArray[TsTypeRef]): IArray[TsType] =
          x match {
            case tr: TsTypeRef if inferred.contains(tr) => Empty
            case aliased =>
              ts.FollowAliases(scope, skipValidation = true)(x) match {
                /* It's common to nest these things, so handle that */
                case xx: TsTypeConditional if depth < 3 =>
                  val inferredThis = TsTreeTraverse.collect(xx.pred) { case TsTypeInfer(tp) => TsTypeRef(tp.name) }

                  val inferredAll: IArray[TsTypeRef] = inferred ++ inferredThis

                  findCandidates(xx.ifTrue, depth + 1, inferredAll) ++
                    findCandidates(xx.ifFalse, depth + 1, inferredAll)

                // keep types which do not refer to inferred types (or back to self)
                case _ =>
                  val referencesInferred = TsTreeTraverse.collect(aliased) {
                    case tr: TsTypeRef if inferred.contains(tr) => tr
                    // break recursion by referencing back to initial type alias (the depth check is more through)
                    case tr: TsTypeRef if tr.name == codePath.forceHasPath.codePath => tr
                  }
                  referencesInferred match {
                    case Empty => IArray(aliased)
                    case _     => Empty
                  }
              }
          }

        val approximationCandidates = findCandidates(tpe, depth = 0, inferred = Empty)

        val chosen: Option[TypeRef] =
          approximationCandidates
            .collectFirst {
              case x @ TsTypeRef(_, name, Empty) if scope.isAbstract(name) => importType(scope, importName)(x)
            }
            .orElse {
              approximationCandidates.map(importType(scope, importName)).collectFirst {
                case x if x != TypeRef.Any && x != TypeRef.JsObject && x != TypeRef.JsAny && x != TypeRef.Nothing => x
              }
            }

        chosen match {
          case Some(approximation) =>
            IArray(
              TypeAliasTree(
                importedName,
                ProtectionLevel.Public,
                importedTparams,
                approximation,
                warning("This RHS of the type alias is guess work. You should cast if it's not correct in your case"),
                codePath = importedCp,
              ),
            )

          case None =>
            IArray(
              ClassTree(
                isImplicit  = false,
                annotations = IArray(Annotation.JsNative),
                level       = ProtectionLevel.Public,
                name        = importedName,
                tparams     = importedTparams,
                parents     = Empty,
                ctors       = Empty,
                members     = Empty,
                classType   = ClassType.Trait,
                isSealed    = false,
                comments    = warning("You'll have to cast your way around this structure, unfortunately"),
                codePath    = importedCp,
              ),
            )
        }

      /* Mapped types. Proper handling (of static) cases is done elsewhere, this just takes care of the dependencies */
      case TsDeclTypeAlias(
          cs,
          _,
          _,
          tparams,
          tpe @ TsTypeObject(_, IArray.exactlyOne(mtm: TsMemberTypeMapped)),
          codePath,
          ) =>
        val importedCp      = importName(codePath)
        val importedName    = importedCp.parts.last
        val importedTparams = tparams.map(typeParam(scope, importName))

        def warning(explain: String) =
          cs ++ Comments(
            s"""/** NOTE: Mapped type definitions are impossible to translate to Scala.
               | * See https://www.typescriptlang.org/docs/handbook/2/mapped-types.html for an intro.
               | * $explain. 
               | * TS definition: {{{
               | ${TsTypeFormatter(tpe)}
               | }}}
               | */
               |""".stripMargin,
          )

        val imported = mtm match {
          // is this a `Record`-like structure? in that case translate to string dictionary
          case TsMemberTypeMapped(_, _, ReadonlyModifier.Noop, _, from, None, _, to)
              if tparams.length == 2 &&
                tparams(0).upperBound.exists {
                  case TsTypeKeyOf(_)   => true
                  case TsTypeRef.string => true
                  case _                => false
                } &&
                TsTypeRef(tparams(0).name) == from &&
                TsTypeRef(tparams(1).name) == to =>
            TypeAliasTree(
              name     = importedName,
              level    = ProtectionLevel.Public,
              tparams  = importedTparams,
              alias    = TypeRef.StringDictionary(TypeRef(importedTparams(1).name), NoComments),
              comments = warning("This translation throws away the known field names"),
              codePath = importedCp,
            )

          // can we ignore the effects of the type mapping and get more or less correct types? This is meant to cover `Readonly`, `Partial`, `Pick` and more
          case TsMemberTypeMapped(_, _, _, _, _, None, _, TsTypeLookup(from, _)) =>
            val base = importType(scope, importName)(from)
            val alias =
              if (scalaVersion.is3) base
              else
                TypeRef.Intersection(
                  IArray(TypeRef.StringLiteral(importedName.unescaped), TypeRef.TopLevel(base)),
                  Comments(
                    "/* note, weird intersection type is needed for scala 2 since it doesn't handle `Id[Id[T]]`, and things like `Partial` frequently ends up applied twice */\n",
                  ),
                )

            TypeAliasTree(
              name     = importedName,
              level    = ProtectionLevel.Public,
              tparams  = importedTparams,
              alias    = alias,
              comments = warning("This translation is imprecise and ignores the effect of the type mapping"),
              codePath = importedCp,
            )

          // for all other cases generate a new trait and have users cast
          case _ =>
            ClassTree(
              isImplicit  = false,
              annotations = IArray(Annotation.JsNative),
              level       = ProtectionLevel.Public,
              name        = importedName,
              tparams     = importedTparams,
              parents     = Empty,
              ctors       = Empty,
              members     = Empty,
              classType   = ClassType.Trait,
              isSealed    = false,
              comments    = warning("You'll have to cast your way around this structure, unfortunately"),
              codePath    = importedCp,
            )
        }

        IArray(imported)

      case TsDeclTypeAlias(cs, _, _, tparams, alias, codePath) =>
        val importedCp = importName(codePath)
        IArray(
          TypeAliasTree(
            name     = importedCp.parts.last,
            level    = ProtectionLevel.Public,
            tparams  = tparams.map(typeParam(scope, importName)),
            alias    = importType(scope, importName)(alias),
            comments = cs,
            codePath = importedCp,
          ),
        )

      case TsDeclFunction(cs, _, _, sig, jsLocation, codePath) =>
        val importedCp = importName(codePath)
        val name       = importedCp.parts.last
        IArray(
          tsMethod(
            scope          = scope,
            level          = ProtectionLevel.Public,
            name           = name,
            annotations    = ImportJsLocation(jsLocation),
            cs             = cs,
            methodType     = MethodType.Normal,
            sig            = sig,
            scalaJsDefined = false,
            ownerCP        = importedCp,
          ),
        )
      case _: TsExportAsNamespace => Empty
      case _: TsImport            => Empty

      case other =>
        scope.fatalMaybe(s"Unexpected: $other")
        Empty
    }
  }

  sealed trait MemberRet

  object MemberRet {
    def apply(value: MemberTree): MemberRet = Normal(value)

    case class Ctor(value: CtorTree) extends MemberRet

    case class Normal(value: MemberTree) extends MemberRet

    case class Inheritance(value: TypeRef) extends MemberRet

    def unapply(es: IArray[MemberRet]): Some[(IArray[CtorTree], IArray[MemberTree], IArray[TypeRef], Comments)] = {
      val ctors = es.collect {
        case Ctor(c) => c
      }
      val others = es.collect {
        case Normal(o) => o
      }

      val inheritance = es.collect {
        case Inheritance(o) => o
      }

      RewriteNamespaceMembers(others) match {
        case (moreInheritance, newOthers, shouldBeEmpty, comments) =>
          require(shouldBeEmpty.isEmpty)
          Some((ctors, newOthers, inheritance ++ moreInheritance, comments))
      }
    }
  }

  def tsMember(_scope: TsTreeScope, scalaJsDefined: Boolean, ownerCP: QualifiedName)(
      t1:              TsMember,
  ): IArray[MemberRet] = {
    lazy val scope = _scope / t1
    t1 match {
      case TsMemberCall(cs, level, signature) =>
        IArray(
          MemberRet(
            tsMethod(
              scope          = scope,
              level          = ProtectionLevel.Public,
              name           = Name.APPLY,
              annotations    = Empty,
              cs             = cs +? protectionLevelComment(level),
              methodType     = MethodType.Normal,
              sig            = signature,
              scalaJsDefined = scalaJsDefined,
              ownerCP        = ownerCP,
            ),
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
            CtorTree(
              level    = ProtectionLevel.Public,
              params   = tsFunParams(scope / sig, importName, params = sig.params),
              comments = cs ++ sig.comments +? protectionLevelComment(level),
            ),
          ),
        )

      case m: TsMemberProperty if !m.isStatic =>
        tsMemberProperty(scope, scalaJsDefined, importName, ownerCP)(m)

      case TsMemberFunction(cs, level, name, methodType, signature, isStatic, isReadOnly @ _) if !isStatic =>
        val (newName, annOpt) = ImportName.withJsNameAnnotation(name)
        IArray(
          MemberRet(
            tsMethod(
              scope          = scope,
              level          = ProtectionLevel.Public,
              name           = newName,
              annotations    = IArray.fromOption(annOpt),
              cs             = cs +? protectionLevelComment(level),
              methodType     = methodType,
              sig            = signature,
              scalaJsDefined = scalaJsDefined,
              ownerCP        = ownerCP,
            ),
          ),
        )

      case m: TsMemberIndex =>
        m.indexing match {
          case Indexing.Dict(indexName, indexType) =>
            val indexTpe = importType(scope, importName)(indexType)
            val valueTpe = importType.orAny(scope, importName)(m.valueType)

            val rewritten: TypeRef =
              if (indexTpe === TypeRef.Double)
                TypeRef.NumberDictionary(valueTpe, m.comments + Comment(s"/* ${indexName.value} */"))
              else
                TypeRef.StringDictionary(valueTpe, m.comments + Comment(s"/* ${indexName.value} */"))

            IArray(MemberRet.Inheritance(rewritten))
          case Indexing.Single(name) =>
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
                val a          = Annotation.JsNameSymbol(QualifiedName.JsSymbol + symName)
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
                      level       = ProtectionLevel.Public,
                      name        = symName,
                      tpe         = importType.orAny(scope, importName)(m.valueType),
                      impl        = fieldType,
                      isReadOnly  = m.isReadOnly,
                      isOverride  = false,
                      comments    = m.comments,
                      codePath    = ownerCP + symName,
                    ),
                  ),
                )
              case other =>
                scope.logger.info(s"Dropping $other")
                Empty
            }
        }

      case other =>
        scope.logger.info(s"Dropping $other")
        Empty
    }
  }
  def protectionLevelComment(pl: TsProtectionLevel): Option[Comment] =
    pl match {
      case TsProtectionLevel.Default   => None
      case TsProtectionLevel.Private   => Some(Comment("/* private */"))
      case TsProtectionLevel.Protected => Some(Comment("/* protected */"))
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
                level          = ProtectionLevel.Public,
                name           = name,
                annotations    = IArray.fromOption(annOpt),
                cs             = call.comments +? protectionLevelComment(call.level),
                methodType     = MethodType.Normal,
                sig            = call.signature,
                scalaJsDefined = scalaJsDefined,
                ownerCP        = ownerCP,
              ),
            ),
          )

      case (ImportName.withJsNameAnnotation(name, annOpt), tpeOpt: Option[TsType]) =>
        val importedType = importType.orAny(scope, importName)(tpeOpt)
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
                level       = ProtectionLevel.Public,
                name        = name,
                tpe         = importedType,
                impl        = impl,
                isReadOnly  = m.isReadOnly,
                isOverride  = false,
                comments    = m.comments +? protectionLevelComment(m.level),
                codePath    = ownerCP + name,
              ),
            ),
          )
          .map(MemberRet.apply)
      case (name, _) =>
        scope.logger.info(s"dropping member $name")
        Empty
    }

  def hack(f: FieldTree): Option[FieldTree] =
    f.comments.extract { case Marker.ExpandedCallables => () } match {
      case None => Some(f)
      case Some((_, _)) =>
        if (f.name === Name.namespaced) None
        else Some(f.withSuffix("Original"))
    }

  def typeParam(scope: TsTreeScope, importName: AdaptiveNamingImport)(tp: TsTypeParam): TypeParamTree =
    TypeParamTree(
      name        = ImportName(tp.name),
      params      = Empty,
      upperBound  = tp.upperBound.map(importType(scope / tp, importName)),
      comments    = tp.comments,
      ignoreBound = true,
    )

  def tsFunParams(scope: TsTreeScope, importName: AdaptiveNamingImport, params: IArray[TsFunParam]): IArray[ParamTree] =
    params.map { param =>
      val tpe = importType.orAny(scope / param, importName)(param.tpe)
      ParamTree(ImportName(param.name), isImplicit = false, isVal = false, tpe, NotImplemented, param.comments)
    }

  def tsMethod(
      scope:          TsTreeScope,
      level:          ProtectionLevel,
      name:           Name,
      annotations:    IArray[Annotation],
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
            .map(importType(scope, importName))
            .getOrElse(TypeRef.Any)
          (name, tpe)
      }

    val ret = MethodTree(
      annotations = annotations,
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
        case suffix :: Nil => ret.withSuffix(suffix)
        case _             => ret
      }
    }
  }

  def container(
      importName: AdaptiveNamingImport,
      scope:      TsTreeScope,
      cs:         Comments,
      jsLocation: JsLocation,
      tsMembers:  IArray[TsContainerOrDecl],
      codePath:   CodePath,
  ): ModuleTree =
    RewriteNamespaceMembers(tsMembers.flatMap(decl(scope))) match {
      case (inheritance, memberTrees, restTrees, cs2) =>
        val importedCp = importName(codePath)

        val patchedRestTrees = restTrees.groupBy(_.name).flatMapToIArray {
          case (_, sameName) =>
            sameName.partitionCollect2({ case x: TypeAliasTree => x }, { case x: ClassTree => x }) match {
              case (tas, cs, rest) if tas.nonEmpty && cs.nonEmpty =>
                cs ++ rest
              case _ => sameName
            }
        }

        setCodePath(
          importedCp,
          ModuleTree(
            annotations = ImportJsLocation(jsLocation),
            level       = ProtectionLevel.Public,
            name        = importedCp.parts.last,
            parents     = inheritance,
            members     = memberTrees ++ patchedRestTrees,
            comments    = cs ++ cs2,
            codePath    = importedCp,
            isOverride  = false,
          ),
        )

    }
}

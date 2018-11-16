package com.olvind.tso
package importer

import ammonite.ops.up
import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts.TreeScope.LoopDetector
import com.olvind.tso.ts.modules._
import com.olvind.tso.ts.{transforms => T, _}

class Phase1ReadTypescript(sources:      Seq[InFolder],
                           ignored:      Set[String],
                           stdlibSource: TsSource,
                           pedantic:     Boolean,
                           parser:       InFile => Either[String, TsParsedFile])
    extends Phase[TsSource, TsSource, Either[LibraryPart, LibTs]] {

  import jsonCodecs._

  implicit val InFileFormatter: Formatter[InFile] =
    inFile =>
      if (inFile.path.segments.length > 3)
        inFile.path.segments.takeRight(3).mkString("../", "/", "")
      else inFile.path.segments.mkString("/")

  override def apply(
      source:     TsSource,
      _1:         TsSource,
      getDeps:    GetDeps[TsSource, Either[LibraryPart, LibTs]],
      isCircular: IsCircular,
      logger:     Logger[Unit]
  ): PhaseRes[TsSource, Either[LibraryPart, LibTs]] = {

    source match {
      case source: TsSource.TsLibSource if ignored(source.libName.value) => PhaseRes.Ignore()
      case _ if isCircular => PhaseRes.Ignore()

      case TsSource.HelperFile(file, inLib, _) =>
        val L = logger.withContext(file)

        val resolveDep = (value: String) =>
          PhaseRes.fromOption(
            source,
            libraryResolver(sources, source, value).map(_._1),
            Right(s"Couldn't resolve $value")
        )

        PhaseRes.fromEither(source, parser(file)) flatMap { parsed: TsParsedFile =>
          val (pathRefsR: Set[PhaseRes[TsSource, TsSource]],
               typeRefsR: Set[PhaseRes[TsSource, TsSource]],
               libRefsR:  Set[PhaseRes[TsSource, TsSource]],
               remaining: Set[Directive]) =
            parsed.directives
              .to[Set]
              .partitionCollect3(
                {
                  case r @ DirectivePathRef(value) =>
                    def src(f: InFile): TsSource =
                      TsSource.HelperFile(f, inLib, ModuleNameParser.inferred(file.path, inLib))

                    PhaseRes.fromOption(source,
                                        libraryResolver.resolveFile(file.folder, value).map(src),
                                        Right(s"Couldn't resolve $r"))
                },
                { case DirectiveTypesRef(value) => resolveDep(value) }, {
                  case r @ DirectiveLibRef(value) =>
                    def src(f: InFile): TsSource =
                      TsSource.HelperFile(f, inLib, ModuleNameParser.inferred(file.path, inLib))

                    PhaseRes.fromOption(source,
                                        libraryResolver.resolveFile(stdlibSource.folder, s"lib.$value.d.ts").map(src),
                                        Right(s"Couldn't resolve $r"))
                }
              )

          for {
            /* Ensure we resolved all modules referenced by a path directive */
            pathRefs <- PhaseRes sequenceSet (pathRefsR ++ libRefsR)
            /* Assert all path directive referenced modules are files (not libraries) */
            toInline <- getDeps(pathRefs) map maps.assertLeftOnly map (_.values.map(_.file))

            withoutDirectives = parsed.copy(directives = remaining.to[Seq])

            /* Ensure we resolved all modules referenced by a type reference directive */
            typeReferencedDeps <- PhaseRes sequenceSet typeRefsR

            /* Resolve all references to other modules in `from` clauses, rename modules */
            withExternals = ResolveExternalReferences(sources, source, withoutDirectives, L)

            inferredDepNames = InferredDependency(inLib.libName,
                                                  withExternals.rewritten,
                                                  withExternals.unresolvedDeps,
                                                  L)
            inferredDeps <- PhaseRes sequenceSet (inferredDepNames map (n => resolveDep(n.value)))

            /* look up all resulting dependencies */
            parts <- getDeps(withExternals.resolvedDeps ++ typeReferencedDeps ++ inferredDeps)
          } yield
            Left[LibraryPart, LibTs](LibraryPart(FileAndRefsRec(withExternals.rewritten, toInline.to[Seq]), parts))
        }

      case source: TsSource.TsLibSource =>
        val packageJsonOpt: Option[PackageJsonDeps] =
          Json.opt[PackageJsonDeps](source.folder.path / "package.json") orElse
            /* discover stdlib package.json as well */
            Json.opt[PackageJsonDeps](source.folder.path / up / "package.json")

        val tsConfig: Option[TsConfig] =
          Json.opt[TsConfig](source.folder.path / "tsconfig.json")

        val fileSources: Set[TsSource.HelperFile] =
          PathsFromTsLibSource(source, packageJsonOpt, tsConfig)

        if (fileSources.isEmpty) {
          logger.warn(s"No typescript definitions found for $source")
          PhaseRes.Ignore()
        } else {
          val declaredDependencies: Set[TsSource] =
            packageJsonOpt
              .to[Set]
              .flatMap(x => x.dependencies.map(_.keys).getOrElse(Nil) ++ x.peerDependencies.map(_.keys).getOrElse(Nil))
              .flatMap(
                depName =>
                  libraryResolver(sources, source, depName) match {
                    case Some((x, _)) => Some(x)
                    case None =>
                      logger.fatalMaybe(s"Could not resolve declared dependency $depName", pedantic)
                      None
                }
              )

          val stdlibSourceOpt: Option[TsSource] =
            if (fileSources.exists(_.path === stdlibSource.path)) None else Option(stdlibSource)

          getDeps(fileSources ++ declaredDependencies ++ stdlibSourceOpt) map {
            case Unpack(libParts: Map[TsSource.HelperFile, FileAndRefs], deps: Map[TsSource, LibTs]) =>
              val scope: TreeScope.Root =
                TreeScope(source.libName, pedantic, deps.map { case (_, lib) => lib.name -> lib.parsed }, logger)

              val preprocessed: Seq[TsParsedFile] =
                libParts.to[Seq].sortBy(_._1.file.path) map {
                  case (thisSource, file) =>
                    logger.info(s"Preprocessing $thisSource")
                    val _1 = InferredDefaultModule(file.file, thisSource.moduleName, logger)
                    val _2 = FlattenTrees(_1 +: file.pathRefFiles)
                    T.SetCodePath.visitTsParsedFile(CodePath.HasPath(source.libName, TsQIdent.empty))(_2)
                }

              val ProcessAll = List[TsParsedFile => TsParsedFile](
                T.SetJsLocation.visitTsParsedFile(JsLocation.Global(TsQIdent.empty)),
                (
                  T.SimplifyParents >>
                    T.NormalizeFunctions // run before FlattenTrees
                ).visitTsParsedFile(scope),
                T.QualifyReferences.visitTsParsedFile(scope.caching),
                AugmentModules(scope),
                T.ResolveTypeQueries.visitTsParsedFile(scope),
                new ReplaceExports(new LoopDetector()).visitTsParsedFile(scope.caching),
                f => FlattenTrees(f :: Nil),
                (
                  T.SimplifyTypes >> //before ExpandCallables
                    T.PreferTypeAlias >>
                    T.ExpandCallables >>
                    T.ExpandKeyOfTypeParams >>
                    T.SimplifyRecursiveTypeAlias >> // after PreferTypeAlias
                    T.UnionTypesFromKeyOf >>
                    T.DropPrototypes >>
                    T.InferReturnTypes >>
                    T.RewriteTypeThis //
                ).visitTsParsedFile(scope.caching),
                T.DefaultedTParams.visitTsParsedFile(scope), //after SimplifyTypes
                (
                  T.InlineTrivialTypeAlias >> //after DefaultedTParams
                    T.SplitMethodsOnUnionTypes >>
                    T.RemoveDifficultInheritance //after DefaultedTParams
                ).visitTsParsedFile(scope),
                T.SplitMethodsOnOptionalParams.visitTsParsedFile(scope),
                T.ExtractInterfaces(source.libName, scope) //
              )

              logger.warn(s"Processing ${source.libName}")
              val finished = ProcessAll.foldLeft(FlattenTrees(preprocessed)) { case (acc, f) => f(acc) }

              val version = CalculateLibraryVersion(
                source.folder,
                libParts.keys.map(_.file).to[Seq],
                packageJsonOpt,
                finished.comments
              )

              Right(LibTs(source.libName, source, version, tsConfig, finished, deps))
          }
        }
    }
  }
}

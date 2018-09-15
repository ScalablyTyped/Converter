package com.olvind.tso
package importer

import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts.TreeScope.LoopDetector
import com.olvind.tso.ts.modules._
import com.olvind.tso.ts.{transforms => TS, _}

class PhaseReadTypescript(sources:      Seq[InFolder],
                          ignored:      Set[String],
                          stdlibSource: TsSource,
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

          val patched: TsParsedFile =
            if (source.inLibrary.libName === TsIdentLibrarySimple("prop-types")) {
              parsed.withMembers(parsed.members.filter {
                case TsImport(_, TsImporteeFrom(TsIdentModule(None, Seq("react")))) => false
                case _                                                              => true
              })
            } else parsed

          for {
            /* Ensure we resolved all modules referenced by a path directive */
            pathRefs <- PhaseRes sequenceSet (pathRefsR ++ libRefsR)
            /* Assert all path directive referenced modules are files (not libraries) */
            toInline <- getDeps(pathRefs) map maps.assertLeftOnly map (_.values.map(_.file))

            withoutDirectives = patched.copy(directives = remaining.to[Seq])

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
          Json.opt[PackageJsonDeps](source.folder.path / "package.json")

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
              .flatMap(
                x =>
                  x.dependencies.fold[scala.Iterable[String]](Nil)(_.keys) ++
                    x.peerDependencies.fold[scala.Iterable[String]](Nil)(_.keys)
              )
              .flatMap(
                depName =>
                  libraryResolver(sources, source, depName) match {
                    case Some((x, _)) => Seq(x)
                    case None =>
                      logger.fatalMaybe(s"Could not resolve declared dependency $depName", constants.Pedantic)
                      Nil
                }
              )

          val stdlibSourceOpt: Option[TsSource] =
            if (fileSources.exists(_.path === stdlibSource.path)) None else Option(stdlibSource)

          getDeps(fileSources ++ declaredDependencies ++ stdlibSourceOpt) map {
            case Unpack(libParts: Map[TsSource.HelperFile, FileAndRefs], deps: Map[TsSource, LibTs]) =>
              val libName = source.libName
              val scope: TreeScope.Root =
                TreeScope(libName, deps.map { case (_, lib) => lib.name -> lib.parsed }, logger)

              val preprocessed: Iterable[TsParsedFile] =
                libParts map {
                  case (thisSource, file) =>
                    val PreProcessAll = (Pipe[TsParsedFile]
                      >> TS.SetCodePath.visitTsParsedFile(CodePath.HasPath(libName, TsQIdent.empty)))

                    logger.info(s"Preprocessing $thisSource")

                    val file1 = InferredDefaultModule(file.file, thisSource.moduleName, logger)
                    val file2 = FlattenTrees(file1 +: file.pathRefFiles)
                    val file3 = PreProcessAll run file2

                    logger.info(s"Preprocessed $thisSource")
                    file3
                }

              val ProcessAll = (Pipe[TsParsedFile]
                >> TS.SetJsLocation.visitTsParsedFile(JsLocation.Global(TsQIdent(Nil)))
                >> (
                  TS.SimplifyParents >>
                    TS.NormalizeFunctions // run before FlattenTrees
                ).visitTsParsedFile(scope)
                >> TS.QualifyReferences.visitTsParsedFile(scope.caching)
                >> AugmentModules(scope)
                >> TS.ResolveTypeQueries.visitTsParsedFile(scope)
                >> new ReplaceExports(new LoopDetector()).visitTsParsedFile(scope.caching)
                >> (f => FlattenTrees(f :: Nil))
                >> (
                  TS.PreferTypeAlias >>
                    TS.ExpandKeyOfTypeParams >>
                    TS.SimplifyRecursiveTypeAlias >> // after PreferTypeAlias
                    TS.RemoveBivarianceHacks >>
                    TS.UnionTypesFromKeyOf >>
                    TS.DropPrototypes >>
                    TS.DefaultedTParams >>
                    TS.InlineTrivialTypeAlias >>
                    TS.InferTypes >>
                    TS.RewriteTypeThis //
                ).visitTsParsedFile(scope.caching)
                >> (TS.SplitMethodsOnUnionTypes >> TS.RemoveDifficultInheritance).visitTsParsedFile(scope)
                >> TS.SplitMethodsOnOptionalParams.visitTsParsedFile(scope)
                >> TS.ExtractInterfaces(libName, scope) //
              )

              logger.warn(s"Processing $libName")
              val finished = ProcessAll run FlattenTrees(preprocessed)
              logger.info(s"Processed $libName")

              val version = CalculateLibraryVersion(
                source.folder,
                libParts.keys.map(_.file).to[Seq],
                packageJsonOpt,
                finished.comments
              )

              Right(LibTs(libName, source, version, tsConfig, finished, deps))
          }
        }
    }
  }
}

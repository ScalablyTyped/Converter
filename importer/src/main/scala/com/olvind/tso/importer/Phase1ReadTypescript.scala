package com.olvind.tso
package importer

import ammonite.ops.up
import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.importer.Phase1Res._
import com.olvind.tso.importer.Source.{TsLibSource, TsSource}
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts.TsTreeScope.LoopDetector
import com.olvind.tso.ts.modules._
import com.olvind.tso.ts.{transforms => T, _}
import sets.SetOps

class Phase1ReadTypescript(resolve:      LibraryResolver,
                           ignored:      Set[String],
                           stdlibSource: Source,
                           pedantic:     Boolean,
                           parser:       InFile => Either[String, TsParsedFile])
    extends Phase[Source, Source, Phase1Res] {

  import jsonCodecs._

  implicit val InFileFormatter: Formatter[InFile] =
    inFile =>
      if (inFile.path.segments.length > 3)
        inFile.path.segments.takeRight(3).mkString("../", "/", "")
      else inFile.path.segments.mkString("/")

  override def apply(
      source:     Source,
      _1:         Source,
      getDeps:    GetDeps[Source, Phase1Res],
      isCircular: IsCircular,
      logger:     Logger[Unit]
  ): PhaseRes[Source, Phase1Res] = {

    source match {
      case _:      Source.ContribSource                                => PhaseRes.Ok(Contrib)
      case source: Source.TsLibSource if ignored(source.libName.value) => PhaseRes.Ignore()
      case _ if isCircular => PhaseRes.Ignore()

      case Source.TsHelperFile(file, inLib, _) =>
        val L = logger.withContext(file)

        val resolveDep = (value: String) =>
          PhaseRes.fromOption(
            source,
            resolve.lookup(inLib, value).map(_._1),
            Right(s"Couldn't resolve $value")
        )

        def assertPartsOnly(m: Map[Source, Phase1Res]): Map[Source, LibraryPart] =
          m.map {
            case (s, part: LibraryPart) => s -> part
            case (s, other) => sys.error(s"$s: Unexpected $other")
          }

        PhaseRes.fromEither(source, parser(file)) flatMap { parsed: TsParsedFile =>
          val (pathRefsR: Set[PhaseRes[Source, Source]],
               typeRefsR: Set[PhaseRes[Source, Source]],
               libRefsR:  Set[PhaseRes[Source, Source]],
               remaining: Set[Directive]) =
            parsed.directives
              .to[Set]
              .partitionCollect3(
                {
                  case r @ DirectivePathRef(value) =>
                    def src(f: InFile): Source =
                      Source.TsHelperFile(f, inLib, resolve.inferredModule(file.path, inLib))

                    PhaseRes.fromOption(source,
                                        resolve.file(file.folder, value).map(src),
                                        Right(s"Couldn't resolve $r"))
                },
                { case DirectiveTypesRef(value) => resolveDep(value) }, {
                  case r @ DirectiveLibRef(value) =>
                    def src(f: InFile): Source =
                      Source.TsHelperFile(f, inLib, resolve.inferredModule(file.path, inLib))

                    PhaseRes.fromOption(source,
                                        resolve.file(stdlibSource.folder, s"lib.$value.d.ts").map(src),
                                        Right(s"Couldn't resolve $r"))
                }
              )

          for {
            /* Ensure we resolved all modules referenced by a path directive */
            pathRefs <- PhaseRes sequenceSet (pathRefsR ++ libRefsR)
            /* Assert all path directive referenced modules are files (not libraries) */
            toInline <- getDeps(pathRefs.sorted) map assertPartsOnly map (_.values.map(_.file))

            withoutDirectives = parsed.copy(directives = remaining.to[Seq])

            /* Ensure we resolved all modules referenced by a type reference directive */
            typeReferencedDeps <- PhaseRes sequenceSet typeRefsR

            /* Resolve all references to other modules in `from` clauses, rename modules */
            withExternals = ResolveExternalReferences(resolve, source.asInstanceOf[TsSource], withoutDirectives, L)

            inferredDepNames = InferredDependency(inLib.libName,
                                                  withExternals.rewritten,
                                                  withExternals.unresolvedDeps,
                                                  L)
            inferredDeps <- PhaseRes sequenceSet (inferredDepNames map (n => resolveDep(n.value)))

            /* look up all resulting dependencies */
            parts <- getDeps((withExternals.resolvedDeps ++ typeReferencedDeps ++ inferredDeps).sorted)
          } yield LibraryPart(FileAndRefsRec(withExternals.rewritten, toInline.to[Seq]), parts)
        }

      case source: Source.TsLibSource =>
        val packageJsonOpt: Option[PackageJsonDeps] =
          Json.opt[PackageJsonDeps](source.folder.path / "package.json") orElse
            /* discover stdlib package.json as well */
            Json.opt[PackageJsonDeps](source.folder.path / up / "package.json")

        val tsConfig: Option[TsConfig] =
          Json.opt[TsConfig](source.folder.path / "tsconfig.json")

        val fileSources: Set[Source.TsHelperFile] =
          PathsFromTsLibSource(resolve, source, packageJsonOpt, tsConfig)

        if (fileSources.isEmpty) {
          logger.warn(s"No typescript definitions found for $source")
          PhaseRes.Ignore()
        } else {
          val declaredDependencies: Set[Source] =
            packageJsonOpt
              .to[Set]
              .flatMap(x => x.dependencies.map(_.keys).getOrElse(Nil) ++ x.peerDependencies.map(_.keys).getOrElse(Nil))
              .flatMap(
                depName =>
                  resolve.lookup(source, depName) match {
                    case Some((x, _)) => Some(x)
                    case None =>
                      logger.fatalMaybe(s"Could not resolve declared dependency $depName", pedantic)
                      None
                }
              )

          val stdlibSourceOpt: Option[Source] =
            if (fileSources.exists(_.path === stdlibSource.path)) None else Option(stdlibSource)

          getDeps((fileSources ++ declaredDependencies ++ stdlibSourceOpt).sorted) map {
            case Unpack(libParts: Map[Source.TsHelperFile, FileAndRefs], deps: Map[TsLibSource, LibTs], contribs) =>
              val scope: TsTreeScope.Root =
                TsTreeScope(source.libName, pedantic, deps.map { case (_, lib) => lib.name -> lib.parsed }, logger)

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

              LibTs(source)(version, tsConfig, finished, deps, contribs)
          }
        }
    }
  }
}

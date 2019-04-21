package com.olvind.tso
package importer

import ammonite.ops.up
import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.importer.Phase1Res._
import com.olvind.tso.importer.Source.{TsLibSource, TsSource}
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.sets.SetOps
import com.olvind.tso.ts.TsTreeScope.LoopDetector
import com.olvind.tso.ts.{modules, transforms => T, _}

import scala.collection.immutable.SortedMap

class Phase1ReadTypescript(resolve:          LibraryResolver,
                           lastChangedIndex: RepoLastChangedIndex,
                           ignored:          Set[String],
                           stdlibSource:     Source,
                           pedantic:         Boolean,
                           parser:           InFile => Either[String, TsParsedFile])
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
      case _:      Source.FacadeSource                                 => PhaseRes.Ok(Facade)
      case source: Source.TsLibSource if ignored(source.libName.value) => PhaseRes.Ignore()
      case _ if isCircular => PhaseRes.Ignore()
      case Source.TsHelperFile(file, _, _) if !file.path.segments.last.endsWith(".d.ts") =>
        PhaseRes.Ignore()

      case s @ Source.TsHelperFile(file, inLib, _) =>
        val L = logger.withContext(file)

        val resolveDep = (value: String) =>
          PhaseRes.fromOption(
            source,
            resolve.lookup(s, value).map(_._1),
            Right(s"Couldn't resolve $value")
        )

        def assertPartsOnly(m: SortedMap[Source, Phase1Res]): SortedMap[Source, LibraryPart] =
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
                  case r @ DirectiveLibRef(value) if inLib.libName === TsIdent.std =>
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
            toInline <- getDeps(pathRefs.sorted) map assertPartsOnly

            withoutDirectives = parsed.copy(directives = remaining.to[Seq])

            /* Ensure we resolved all modules referenced by a type reference directive */
            typeReferencedDeps <- PhaseRes sequenceSet typeRefsR

            /* Resolve all references to other modules in `from` clauses, rename modules */
            withExternals = ResolveExternalReferences(resolve, source.asInstanceOf[TsSource], withoutDirectives, L)

            inferredDepNames = modules.InferredDependency(inLib.libName,
                                                          withExternals.rewritten,
                                                          withExternals.unresolvedDeps,
                                                          L)
            inferredDeps <- PhaseRes sequenceSet (inferredDepNames map (n => resolveDep(n.value)))

            /* look up all resulting dependencies */
            deps <- getDeps((withExternals.resolvedDeps ++ typeReferencedDeps ++ inferredDeps).sorted)
          } yield LibraryPart(FileAndInlinesRec(withExternals.rewritten, toInline), deps)
        }

      case source: Source.TsLibSource =>
        val packageJsonOpt: Option[PackageJsonDeps] =
          Json.opt[PackageJsonDeps](source.folder.path / "package.json", logger.warn(_)) orElse
            /* discover stdlib package.json as well */
            Json.opt[PackageJsonDeps](source.folder.path / up / "package.json", logger.warn(_))

        val tsConfig: Option[TsConfig] =
          Json.opt[TsConfig](source.folder.path / "tsconfig.json", logger.warn(_))

        val fileSources: Set[Source.TsHelperFile] =
          PathsFromTsLibSource(resolve, source, packageJsonOpt, tsConfig)

        val stdlibSourceOpt: Option[Source] =
          if (fileSources.exists(_.path === stdlibSource.path)) None else Option(stdlibSource)

        if (fileSources.isEmpty) {
          logger.warn(s"No typescript definitions found for $source")
          PhaseRes.Ignore()
        } else {
          val declaredDependencies: Set[Source] =
            if (stdlibSourceOpt.isEmpty) Set.empty
            else
              packageJsonOpt
                .to[Set]
                .flatMap(
                  x => x.dependencies.map(_.keys).getOrElse(Nil) ++ x.peerDependencies.map(_.keys).getOrElse(Nil)
                )
                .flatMap(
                  depName =>
                    resolve.lookup(source, depName) match {
                      case Some((x, _)) => Some(x)
                      case None =>
                        logger.fatalMaybe(s"Could not resolve declared dependency $depName", pedantic)
                        None
                  }
                )

          getDeps((fileSources ++ declaredDependencies ++ stdlibSourceOpt).sorted) map {
            case Unpack(libParts: SortedMap[Source.TsHelperFile, FileAndInlinesFlat],
                        deps:     SortedMap[TsLibSource, LibTs],
                        facades) =>
              val scope: TsTreeScope.Root =
                TsTreeScope(source.libName, pedantic, deps.map { case (_, lib) => lib.name -> lib.parsed }, logger)

              val preprocessed: Seq[TsParsedFile] =
                libParts.to[Seq] map {
                  case (thisSource, file) =>
                    logger.info(s"Preprocessing $thisSource")
                    val _1 = modules.InferredDefaultModule(file.file, thisSource.moduleName, logger)
                    val _2 = FlattenTrees(_1 +: file.toInline.filterNot(_._2.isModule).to[Seq].map(_._2))
                    T.SetCodePath.visitTsParsedFile(CodePath.HasPath(source.libName, TsQIdent.empty))(_2)
                }

              val ProcessAll = List[TsParsedFile => TsParsedFile](
                T.SetJsLocation.visitTsParsedFile(JsLocation.Global(TsQIdent.empty)),
                modules.HandleCommonJsModules.visitTsParsedFile(scope),
                (
                  T.SimplifyParents >>
                    T.InferTypeFromExpr >>
                    T.NormalizeFunctions // run before FlattenTrees
                ).visitTsParsedFile(scope.caching),
                T.QualifyReferences.visitTsParsedFile(scope.caching),
                modules.AugmentModules(scope.caching),
                T.ResolveTypeQueries.visitTsParsedFile(scope.caching), // before ReplaceExports
                new modules.ReplaceExports(LoopDetector.initial).visitTsParsedFile(scope.caching),
                f => FlattenTrees(f :: Nil),
                T.DefaultedTParams.visitTsParsedFile(scope.caching), //after FlattenTrees
                (
//                      T.ApplyTypeMapping >> //after ResolveTypeLookups
                  T.SimplifyConditionals >>
                    T.PreferTypeAlias >>
                    T.ExpandKeyOfTypeParams >>
                    T.SimplifyRecursiveTypeAlias >> // after PreferTypeAlias
                    T.UnionTypesFromKeyOf >>
                    T.DropPrototypes >>
                    T.InferReturnTypes >>
                    T.RewriteTypeThis >>
                    T.InlineTrivialTypeAlias //after DefaultedTParams
                ).visitTsParsedFile(scope.caching),
                T.ResolveTypeLookups
                  .visitTsParsedFile(scope.caching), //before ExpandCallables and ExtractInterfaces, after InlineTrivialTypeAlias
                T.ExtractInterfaces(source.libName, scope.caching), // before things which break initial ordering of members, like `ExtractClasses`
                (
                  T.ExtractClasses >> // after DefaultedTParams
                    T.ExpandCallables((tpe, _) => !IsFunctionalComponent(tpe)) // after DefaultedTParams
                ).visitTsParsedFile(scope.caching),
                (
                  T.SplitMethodsOnUnionTypes >> // after ExpandCallables
                    T.RemoveDifficultInheritance // after DefaultedTParams
                ).visitTsParsedFile(scope.caching),
                T.SplitMethodsOnOptionalParams.visitTsParsedFile(scope.caching),
              )

              logger.warn(s"Processing ${source.libName}")
              val finished = ProcessAll.foldLeft(FlattenTrees(preprocessed)) { case (acc, f) => f(acc) }

              val version = CalculateLibraryVersion(
                source.folder,
                source.isInstanceOf[Source.StdLibSource],
                libParts.keys.map(_.file).to[Seq],
                lastChangedIndex,
                packageJsonOpt,
                finished.comments
              )

              LibTs(source)(version, tsConfig, finished, deps, facades)
          }
        }
    }
  }
}

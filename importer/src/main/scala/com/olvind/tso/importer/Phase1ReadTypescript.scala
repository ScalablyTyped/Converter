package com.olvind.tso
package importer

import com.olvind.logging.{Formatter, Logger}
import com.olvind.tso.importer.Phase1Res._
import com.olvind.tso.importer.Source.TsSource
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.sets.SetOps
import com.olvind.tso.ts.TsTreeScope.LoopDetector
import com.olvind.tso.ts.{transforms => T, _}

import scala.collection.immutable.SortedMap

class Phase1ReadTypescript(
    resolve:                 LibraryResolver,
    calculateLibraryVersion: CalculateLibraryVersion,
    ignored:                 Set[String],
    stdlibSource:            Source,
    pedantic:                Boolean,
    parser:                  InFile => Either[String, TsParsedFile],
) extends Phase[Source, Source, Phase1Res] {

  implicit val InFileFormatter: Formatter[InFile] =
    inFile =>
      if (inFile.path.segments.length > 3)
        inFile.path.segments.toList.takeRight(3).mkString("../", "/", "")
      else inFile.path.segments.mkString("/")

  override def apply(
      source:     Source,
      _1:         Source,
      getDeps:    GetDeps[Source, Phase1Res],
      isCircular: IsCircular,
      logger:     Logger[Unit],
  ): PhaseRes[Source, Phase1Res] = {

    source match {
      case _:      Source.FacadeSource                                 => PhaseRes.Ok(Facade)
      case source: Source.TsLibSource if ignored(source.libName.value) => PhaseRes.Ignore()
      case _ if isCircular => PhaseRes.Ignore()
      case Source.TsHelperFile(file, _, _) if !file.path.last.endsWith(".d.ts") =>
        PhaseRes.Ignore()

      case s @ Source.TsHelperFile(file, inLib, _) =>
        val L = logger.withContext(file)

        val resolveDep = (value: String) =>
          PhaseRes.fromOption(
            source,
            resolve.lookup(s, value).map(_._1),
            Right(s"Couldn't resolve $value"),
          )

        def assertPartsOnly(m: SortedMap[Source, Phase1Res]): SortedMap[Source, LibraryPart] =
          m.map {
            case (s, part: LibraryPart) => s -> part
            case (s, other) => sys.error(s"$s: Unexpected $other")
          }

        PhaseRes.fromEither(source, parser(file)) flatMap { parsed: TsParsedFile =>
          val (
            pathRefsR: Set[PhaseRes[Source, Source]],
            typeRefsR: Set[PhaseRes[Source, Source]],
            libRefsR:  Set[PhaseRes[Source, Source]],
            remaining: Set[Directive],
          ) =
            parsed.directives
              .to[Set]
              .partitionCollect3(
                {
                  case r @ DirectivePathRef(value) =>
                    def src(f: InFile): Source =
                      Source.TsHelperFile(f, inLib, resolve.inferredModule(file.path, inLib))

                    PhaseRes
                      .fromOption(source, resolve.file(file.folder, value).map(src), Right(s"Couldn't resolve $r"))
                },
                { case DirectiveTypesRef(value) => resolveDep(value) }, {
                  case r @ DirectiveLibRef(value) if inLib.libName === TsIdent.std =>
                    def src(f: InFile): Source =
                      Source.TsHelperFile(f, inLib, resolve.inferredModule(file.path, inLib))

                    PhaseRes.fromOption(
                      source,
                      resolve.file(stdlibSource.folder, s"lib.$value.d.ts").map(src),
                      Right(s"Couldn't resolve $r"),
                    )
                },
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

            inferredDepNames = modules.InferredDependency(
              inLib.libName,
              withExternals.rewritten,
              withExternals.unresolvedDeps,
              L,
            )
            inferredDeps <- PhaseRes sequenceSet (inferredDepNames map (n => resolveDep(n.value)))

            /* look up all resulting dependencies */
            deps <- getDeps((withExternals.resolvedDeps ++ typeReferencedDeps ++ inferredDeps).sorted)
          } yield LibraryPart(FileAndInlinesRec(withExternals.rewritten, toInline), deps)
        }

      case source: Source.TsLibSource =>
        val fileSources: Set[Source.TsHelperFile] =
          PathsFromTsLibSource(resolve, source)

        val stdlibSourceOpt: Option[Source] =
          if (fileSources.exists(_.path === stdlibSource.path)) None else Option(stdlibSource)

        if (fileSources.isEmpty) {
          logger.warn(s"No typescript definitions found for $source")
          PhaseRes.Ignore()
        } else {
          val declaredDependencies: Set[Source] =
            if (stdlibSourceOpt.isEmpty) Set.empty
            else
              source.packageJsonOpt
                .to[Set]
                .flatMap(
                  x => x.dependencies.map(_.keys).getOrElse(Nil) ++ x.peerDependencies.map(_.keys).getOrElse(Nil),
                )
                .flatMap(
                  depName =>
                    resolve.lookup(source, depName) match {
                      case Some((x, _)) => Some(x)
                      case None =>
                        logger.fatalMaybe(s"Could not resolve declared dependency $depName", pedantic)
                        None
                    },
                )

          getDeps((fileSources ++ declaredDependencies ++ stdlibSourceOpt).sorted) map {
            case Unpack(
                libParts: SortedMap[Source.TsHelperFile, FileAndInlinesFlat],
                deps:     SortedMap[Source.TsLibSource, LibTs],
                facades,
                ) =>
              val scope: TsTreeScope.Root =
                TsTreeScope(source.libName, pedantic, deps.map { case (source, lib) => source -> lib.parsed }, logger)

              val preprocessed: Seq[TsParsedFile] =
                libParts.to[Seq] map {
                  case (thisSource, file) =>
                    logger.info(s"Preprocessing $thisSource")
                    val _1 = modules.InferredDefaultModule(file.file, thisSource.moduleName, logger)
                    val _2 = FlattenTrees(_1 +: file.toInline.filterNot(_._2.isModule).to[Seq].map(_._2))
                    T.SetCodePath.visitTsParsedFile(CodePath.HasPath(source.libName, TsQIdent.empty))(_2)
                }

              val enableExpandTypeMappings = source.libName match {
                case TsIdentLibraryScoped("material-ui", _)    => true
                case TsIdentLibrarySimple("styled-components") => true
                case TsIdentLibrarySimple("antd")              => true
                case TsIdentLibrarySimple("amap-js-api")       => true
                case TsIdentLibrarySimple("react-onsenui")     => true
                case TsIdentLibraryScoped("uifabric", _)       => true
                case TsIdentLibraryScoped("tensorflow", _)     => true
                case TsIdentLibraryScoped("ant-design", _)     => true
                case TsIdentLibraryScoped("nivo", _)           => true
                case _                                         => false
              }

              val involvesReact = {
                val react = TsIdentLibrarySimple("react")
                source.libName === react || deps.exists { case (s, _) => s.libName === react }
              }

              logger.warn(s"Processing ${source.libName}")
              val finished = Phase1ReadTypescript
                .Pipeline(scope, source.libName, enableExpandTypeMappings, enableExpandCallables = !involvesReact)
                .foldLeft(FlattenTrees(preprocessed)) { case (acc, f) => f(acc) }

              val version = calculateLibraryVersion(
                source.folder,
                source.isInstanceOf[Source.StdLibSource],
                libParts.keys.map(_.file).to[Seq],
                source.packageJsonOpt,
                finished.comments,
              )

              LibTs(source)(version, finished, deps, facades)
          }
        }
    }
  }
}

object Phase1ReadTypescript {
  def Pipeline(
      scope:                    TsTreeScope.Root,
      libName:                  TsIdentLibrary,
      enableExpandTypeMappings: Boolean,
      enableExpandCallables:    Boolean,
  ): List[TsParsedFile => TsParsedFile] =
    List(
      T.LibrarySpecific(libName).fold[TsParsedFile => TsParsedFile](identity)(_.visitTsParsedFile(scope)),
      T.SetJsLocation.visitTsParsedFile(JsLocation.Global(TsQIdent.empty)),
      modules.HandleCommonJsModules.visitTsParsedFile(scope),
      (T.SimplifyParents >>
        T.RemoveStubs >> //before QualifyReferences
        T.InferTypeFromExpr >>
        T.InferEnumTypes /* before InlineConstEnum */ >>
        T.NormalizeFunctions /* before FlattenTrees */
      ).visitTsParsedFile(scope.caching),
      T.QualifyReferences.visitTsParsedFile(scope.caching),
      modules.AugmentModules(scope.caching),
      T.ResolveTypeQueries.visitTsParsedFile(scope.caching), // before ReplaceExports
      new modules.ReplaceExports(LoopDetector.initial).visitTsParsedFile(scope.caching),
      FlattenTrees.apply,
      T.DefaultedTypeArguments.visitTsParsedFile(scope.caching), //after FlattenTrees
      T.InlineTrivialParents.visitTsParsedFile(scope.caching), //after FlattenTrees and DefaultedTypeArguments
      if (enableExpandTypeMappings) T.ExpandTypeMappings.visitTsParsedFile(scope.caching) else identity, // before ExtractInterfaces
      if (enableExpandTypeMappings) T.ExpandTypeMappings.After(libName, scope) else identity, // before ExtractInterfaces
      (
        T.SimplifyConditionals >> // after ExpandTypeMappings
          T.PreferTypeAlias >>
          T.ExpandTypeParams >>
          T.SimplifyRecursiveTypeAlias >> // after PreferTypeAlias
          T.UnionTypesFromKeyOf >>
          T.DropProperties >>
          T.InferReturnTypes >>
          T.RewriteTypeThis >>
          T.InlineConstEnum >>
          T.InlineTrivialTypeAlias
      ).visitTsParsedFile(scope.caching),
      T.ResolveTypeLookups
        .visitTsParsedFile(scope.caching), //before ExpandCallables and ExtractInterfaces, after InlineTrivialTypeAlias and ExpandKeyOfTypeParams
      T.ExtractInterfaces(libName, scope.caching), // before things which break initial ordering of members, like `ExtractClasses`
      (
        if (enableExpandCallables) T.ExtractClasses >> T.ExpandCallables
        else T.ExtractClasses
      ).visitTsParsedFile(scope.caching),
      (
        T.SplitMethodsOnUnionTypes >> // after ExpandCallables
          T.RemoveDifficultInheritance
      ).visitTsParsedFile(scope.caching),
      T.SplitMethodsOnOptionalParams.visitTsParsedFile(scope.caching),
    )
}

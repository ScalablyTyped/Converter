package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.{Formatter, Logger}
import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.ts.modules.ModuleAsGlobalNamespace
import org.scalablytyped.converter.internal.ts.{transforms => T, _}

import scala.collection.immutable.{SortedMap, SortedSet}
import scala.collection.mutable

/**
  * This phase parses files, implements the module system, and "implements" a bunch of typescript features by rewriting the tree.
  * For instance defaulted parameters are filled in. The point is to go from a complex tree to a simpler tree
  */
class Phase1ReadTypescript(
    resolve:                 LibraryResolver,
    calculateLibraryVersion: CalculateLibraryVersion,
    ignored:                 Set[TsIdentLibrary],
    ignoredModulePrefixes:   Set[List[String]],
    pedantic:                Boolean,
    parser:                  InFile => Either[String, TsParsedFile],
    expandTypeMappings:      Selection[TsIdentLibrary],
) extends Phase[LibTsSource, LibTsSource, LibTs] {

  implicit val InFileFormatter: Formatter[InFile] =
    inFile =>
      if (inFile.path.segments.length > 3)
        inFile.path.segments.toList.takeRight(3).mkString("../", "/", "")
      else inFile.path.segments.mkString("/")

  implicit val InFolderFormatter: Formatter[InFolder] =
    _.path.toString

  def ignoreModule(modName: TsIdentModule): Boolean =
    (1 to modName.fragments.length).exists(n => ignoredModulePrefixes(modName.fragments.take(n)))

  override def apply(
      source:     LibTsSource,
      _1:         LibTsSource,
      getDeps:    GetDeps[LibTsSource, LibTs],
      isCircular: IsCircular,
      logger:     Logger[Unit],
  ): PhaseRes[LibTsSource, LibTs] = {
    source match {
      case source if ignored(source.libName) || isCircular => PhaseRes.Ignore()
      case source =>
        val includedFiles: IArray[InFile] =
          source match {
            case LibTsSource.StdLibSource(_, files, _) =>
              PathsFromTsLibSource.filesFrom(files.head.folder)
            case f @ LibTsSource.FromFolder(_, TsIdentLibrarySimple("typescript")) =>
              /* don't include std */
              f.shortenedFiles
            case f: LibTsSource.FromFolder =>
              /* There are often whole trees parallel to what is specified in `typings` (or similar). This ignores them */
              val bound = f.shortenedFiles.headOption.map(_.folder).getOrElse(f.folder)
              PathsFromTsLibSource.filesFrom(bound)
          }

        val includedViaDirective = mutable.Set.empty[InFile]

        lazy val preparingFiles: SortedMap[InFile, Lazy[(TsParsedFile, Set[LibTsSource])]] =
          includedFiles.sorted
            .map { file =>
              file -> Lazy {
                parser(file) match {
                  case Left(msg) =>
                    logger.withContext(file).fatal(s"Couldn't parse: $msg")
                  case Right(parsed) =>
                    val deps = Set.newBuilder[LibTsSource]

                    val fileLogger = logger.withContext(file)
                    fileLogger.info(s"Preprocessing")

                    val toInline: IArray[Either[Directive.Ref, InFile]] =
                      parsed.directives.collect {
                        case dir @ Directive.PathRef(stringPath) =>
                          LibraryResolver.file(file.folder, stringPath).toRight(dir)
                        case dir @ Directive.LibRef(value) if source.libName === TsIdent.std =>
                          LibraryResolver.file(resolve.stdLib.folder, s"lib.$value.d.ts").toRight(dir)
                      }

                    val moduleNames = LibraryResolver.moduleNameFor(source, file)

                    val withInferredModule = modules.InferredDefaultModule(parsed, moduleNames.head, logger)

                    withInferredModule.directives.foreach {
                      case dir @ Directive.TypesRef(value) =>
                        resolve.module(source, file.folder, value) match {
                          case Some(ResolvedModule.NotLocal(depSource, _)) =>
                            deps += depSource
                          case Some(ResolvedModule.Local(depSource, _)) =>
                            logger.warn(s"unexpected typeref from local file $depSource")
                          case _ =>
                            logger.warn(s"directives: couldn't resolve $dir")
                        }
                      case _ => ()
                    }

                    /* Resolve all references to other modules in `from` clauses, rename modules */
                    val ResolveExternalReferences.Result(withExternals, resolvedModules, unresolvedModules) =
                      ResolveExternalReferences(resolve, source, file.folder, withInferredModule, logger)

                    resolvedModules.foreach {
                      case ResolvedModule.NotLocal(source, _) => deps += source
                      case _                                  => ()
                    }

                    val withOrigin = {
                      source match {
                        case LibTsSource.StdLibSource(_, _, _) =>
                          val shortName = file.path.last.split("\\.").drop(1).dropRight(2).mkString(".")
                          if (shortName.nonEmpty) {
                            val stdComment = Comments(List(Comment(s"/* standard $shortName */\n")))
                            T.AddComments(stdComment).visitTsParsedFile(())(withExternals)
                          } else withExternals

                        case _ =>
                          withExternals
                      }
                    }

                    val inferredDepNames: Set[TsIdentLibrary] =
                      modules.InferredDependency(
                        source.libName,
                        withOrigin,
                        unresolvedModules,
                        logger,
                      )

                    inferredDepNames.foreach { libraryName =>
                      resolve.module(source, file.folder, libraryName.value) match {
                        case Some(ResolvedModule.NotLocal(dep, _)) =>
                          deps += dep
                        case _ =>
                          logger.warn(s"Couldn't resolve inferred dependency ${libraryName.value}")
                      }
                    }

                    val withInlined: TsParsedFile =
                      toInline.distinct.foldLeft(withOrigin) {
                        case (parsed, Right(referencedFile)) =>
                          val referencedFileLogger = fileLogger.withContext(referencedFile)

                          preparingFiles.get(referencedFile).flatMap(_.get) match {
                            case Some((toInline, depsForInline)) if !toInline.isModule =>
                              includedViaDirective += referencedFile
                              deps ++= depsForInline
                              FlattenTrees.mergeFile(parsed, toInline)
                            case Some((modFile, _)) if modFile.isModule =>
                              referencedFileLogger.warn("directives: referenced file was a module")
                              parsed
                            case _ =>
                              referencedFileLogger.warn("directives: reference caused circular graph")
                              parsed
                          }
                        case (parsed, Left(dir)) =>
                          fileLogger.warn(s"directives: couldn't resolve $dir")
                          parsed
                      }

                    val _3 = moduleNames match {
                      case IArray.exactlyOne(_) => withInlined
                      case more =>
                        withInlined.copy(members = withInlined.members.map {
                          case m: TsDeclModule if more.contains(m.name) =>
                            m.copy(comments = m.comments + Marker.ModuleAliases(more.filterNot(_ === m.name)))
                          case other => other
                        })
                    }
                    val _4 = T.SetCodePath.visitTsParsedFile(CodePath.HasPath(source.libName, TsQIdent.empty))(_3)

                    (_4, deps.result())
                }
              }
            }
            .toMap
            .toSorted

        val preparedFiles: IArray[(TsParsedFile, Set[LibTsSource])] = {
          // evaluate all, don't refactor and combine this with other steps
          val base: SortedMap[InFile, (TsParsedFile, Set[LibTsSource])] =
            source match {
              case LibTsSource.StdLibSource(_, files, _) =>
                val b = SortedMap.newBuilder[InFile, (TsParsedFile, Set[LibTsSource])]
                files.foreach { file =>
                  for {
                    found <- preparingFiles.get(file)
                    evaluated <- found.get
                  } b += ((file, evaluated))
                }
                b.result()
              case LibTsSource.FromFolder(_, _) =>
                preparingFiles.mapNotNone { case (_, v) => v.get }
            }

          base.flatMapToIArray {
            case (file, _) if includedViaDirective(file) => Empty
            case (_, fileResult)                         => IArray(fileResult)
          }
        }

        if (preparedFiles.isEmpty) {
          logger.warn(s"No typescript definitions files found for library ${source.libName.value}")
          return PhaseRes.Ignore()
        }

        val flattened     = FlattenTrees(preparedFiles.map(_._1))
        val depsFromFiles = preparedFiles.foldLeft(Set.empty[LibTsSource]) { case (acc, (_, deps)) => acc ++ deps }

        val withExportedModules = source.packageJsonOpt.flatMap(_.parsedExported).foldLeft(flattened) {
          case (file, exports) =>
            val proxyModules = ProxyModule.fromExports(
              source,
              logger,
              resolve,
              existing = file.membersByName.contains,
              exports,
            )
            file.copy(members = IArray.fromTraversable(proxyModules).map(_.asModule) ++ file.members)
        }

        val withFilteredModules: TsParsedFile =
          if (ignoredModulePrefixes.nonEmpty)
            withExportedModules.copy(members = withExportedModules.members.filterNot {
              case x: TsDeclModule      => ignoreModule(x.name)
              case x: TsAugmentedModule => ignoreModule(x.name)
              case _ => false
            })
          else withExportedModules

        val stdlibSourceOpt: Option[LibTsSource] =
          if (includedFiles.exists(_.path === resolve.stdLib.path)) None else Option(resolve.stdLib)

        val depsDeclared: SortedSet[LibTsSource] =
          if (stdlibSourceOpt.isEmpty) SortedSet.empty
          else
            source.packageJsonOpt.getOrElse(PackageJson.Empty).allLibs(dev = false, peer = true).keySet.flatMap {
              depName =>
                resolve.library(depName) match {
                  case LibraryResolver.Found(source) =>
                    Some(source)
                  case LibraryResolver.Ignored(_) =>
                    None
                  case LibraryResolver.NotAvailable(name) =>
                    logger.warn(s"Could not find typescript definitions for dependency ${name.value}")
                    None
                }
            }

        getDeps(depsDeclared ++ stdlibSourceOpt ++ depsFromFiles).map { deps =>
          val transitiveDeps = deps.foldLeft(deps) {
            case (acc, (_, lib)) => acc ++ lib.transitiveDependencies
          }
          val scope: TsTreeScope.Root =
            TsTreeScope(
              source.libName,
              pedantic,
              transitiveDeps.map { case (source, lib) => source -> lib.parsed },
              logger,
            )

          val involvesReact = {
            val react = TsIdentLibrarySimple("react")
            source.libName === react || deps.exists { case (s, _) => s.libName === react }
          }
          val finished = Phase1ReadTypescript
            .Pipeline(scope, source.libName, expandTypeMappings, involvesReact)
            .foldLeft(withFilteredModules) { case (acc, f) => f(acc) }

          val version = calculateLibraryVersion(
            source.folder,
            source.isInstanceOf[LibTsSource.StdLibSource],
            source.packageJsonOpt,
            finished.comments,
          )

          LibTs(source)(version, finished, deps)
        }
    }
  }
}

object Phase1ReadTypescript {
  def Pipeline(
      scope:              TsTreeScope.Root,
      libName:            TsIdentLibrary,
      expandTypeMappings: Selection[TsIdentLibrary],
      involvesReact:      Boolean,
  ): List[TsParsedFile => TsParsedFile] =
    List(
      T.LibrarySpecific(libName).fold[TsParsedFile => TsParsedFile](identity)(_.visitTsParsedFile(scope)),
      T.SetJsLocation.visitTsParsedFile(JsLocation.Global(TsQIdent.empty)),
      (T.SimplifyParents >>
        T.RemoveStubs >> //before HandleCommonJsModules and QualifyReferences
        T.InferTypeFromExpr >>
        T.InferEnumTypes /* before InlineConstEnum */ >>
        T.NormalizeFunctions /* before FlattenTrees */ >>
        T.MoveStatics).visitTsParsedFile(scope.enableUnqualifiedLookup.caching),
      (modules.HandleCommonJsModules >> modules.RewriteExportStarAs)
        .visitTsParsedFile(scope), //before QualifyReferences
      new T.QualifyReferences(skipValidation = false).visitTsParsedFile(scope.enableUnqualifiedLookup.caching),
      modules.AugmentModules(scope.caching),
      T.ResolveTypeQueries.visitTsParsedFile(scope.enableUnqualifiedLookup.caching), // before ReplaceExports
      new modules.ReplaceExports(LoopDetector.initial).visitTsParsedFile(scope.enableUnqualifiedLookup.caching),
      file => ModuleAsGlobalNamespace(scope.root.libName, file),
      modules.MoveGlobals.apply,
      FlattenTrees.apply,
      (
        T.DefaultedTypeArguments >> //after FlattenTrees
          T.TypeAliasIntersection >> // before ExpandTypeMappings
          T.RejiggerIntersections
      ).visitTsParsedFile(scope.caching),
      if (expandTypeMappings(libName)) T.ExpandTypeMappings.visitTsParsedFile(scope.caching) else identity, // before ExtractInterfaces
      if (expandTypeMappings(libName)) T.ExpandTypeMappings.After.visitTsParsedFile(scope.caching) else identity, // before ExtractInterfaces
      (
        T.TypeAliasToConstEnum >>
          T.ForwardCtors >>
          T.ExpandTypeParams >>
          T.UnionTypesFromKeyOf >>
          T.DropProperties >>
          T.InferReturnTypes >>
          T.RewriteTypeThis >>
          T.InlineConstEnum >>
          T.InlineTrivial
      ).visitTsParsedFile(scope.caching),
      T.ResolveTypeLookups
        .visitTsParsedFile(scope.caching), //before ExpandCallables and ExtractInterfaces, after InlineTrivialTypeAlias and ExpandKeyOfTypeParams
      x => T.PreferTypeAlias(x, scope), // before extract interfaces
      T.ExtractInterfaces(libName, TsIdent("anon"), scope.caching), // before things which break initial ordering of members, like `ExtractClasses`
      (
        if (involvesReact) T.ExtractClasses
        else T.ExtractClasses >> T.ExpandCallables
      ).visitTsParsedFile(scope.caching),
      (T.SplitMethods /* after ExpandCallables */ >>
        T.RemoveDifficultInheritance >>
        T.VarToNamespace // after ExtractClasses
      ).visitTsParsedFile(scope.caching),
    )
}

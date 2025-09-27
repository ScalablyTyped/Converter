package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.{Formatter, Logger}
import org.scalablytyped.converter.internal.importer.build._
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl

import java.time.ZonedDateTime
import scala.collection.immutable.SortedSet
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.Try

/**
  * This phase goes from scala AST to compiled jar files on the local file system
  */
class Phase3Compile(
    versions:                   Versions,
    compiler:                   Compiler,
    targetFolder:               os.Path,
    organization:               String,
    publishLocalFolder:         os.Path,
    metadataFetcher:            Npmjs,
    softWrites:                 Boolean,
    flavour:                    FlavourImpl,
    generateScalaJsBundlerFile: Boolean,
    ensureSourceFilesWritten:   Boolean,
) extends Phase[LibTsSource, LibScalaJs, PublishedSbtProject] {

  val ScalaFiles: PartialFunction[(os.RelPath, String), String] = {
    case (path, value)
        if path.ext === "scala" ||
          path.ext === "sbt" ||
          path.last === ScalaJsBundlerDepFile.manifestFileName =>
      value
  }

  implicit val PathFormatter: Formatter[os.Path] = _.toString

  override def apply(
      source:  LibTsSource,
      lib:     LibScalaJs,
      getDeps: GetDeps[LibTsSource, PublishedSbtProject],
      v4:      IsCircular,
      _logger: Logger[Unit],
  ): PhaseRes[LibTsSource, PublishedSbtProject] = {
    val logger = _logger.withContext("flavour", flavour.toString)

    getDeps(lib.dependencies.keys.map(x => x: LibTsSource).to(SortedSet)).flatMap {
      case PublishedSbtProject.Unpack(deps) =>
        val scope = new TreeScope.Root(
          libName       = lib.scalaName,
          _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
          logger        = logger,
          pedantic      = false,
          outputPkg     = flavour.outputPkg,
        )

        val scalaFiles    = Printer(scope, new ParentsResolver, lib.packageTree, flavour.outputPkg, versions.scala)
        val sourcesDir    = os.RelPath("src") / 'main / 'scala
        val resourcesDir  = os.RelPath("src") / 'main / 'resources
        val metadataOpt   = Try(Await.result(metadataFetcher(lib.source, logger), 2.seconds)).toOption.flatten
        val compilerPaths = CompilerPaths.of(versions, targetFolder, lib.libName)
        val resources: IArray[(os.RelPath, String)] =
          if (generateScalaJsBundlerFile) ScalaJsBundlerDepFile(lib.source.libName, lib.libVersion)
          else Empty

        val sbtLayout: SbtProjectLayout[os.RelPath, String] =
          ContentSbtProject(
            versions        = versions,
            comments        = lib.packageTree.comments,
            organization    = organization,
            name            = lib.libName,
            version         = VersionHack.TemplateValue,
            localDeps       = deps.toIArrayValues,
            deps            = flavour.dependencies,
            scalaFiles      = scalaFiles.map { case (relPath, content) => sourcesDir / relPath -> content },
            resources       = resources.map { case (relPath, content) => resourcesDir / relPath -> content },
            metadataOpt     = metadataOpt,
            declaredVersion = Some(lib.libVersion),
          )

        val digest                = Digest.of(sbtLayout.all.collect(ScalaFiles))
        val finalVersion          = lib.libVersion.version(digest)
        val allFilesProperVersion = VersionHack.templateVersion(sbtLayout, finalVersion)

        val reference = Dep.ScalaJs(organization, lib.libName, finalVersion).concrete(versions)

        val sbtProject = SbtProject(lib.libName, reference)(compilerPaths.baseDir, deps, metadataOpt)

        val existing: IvyLayout[os.RelPath, os.Path] =
          IvyLayout.unit(reference).mapValues { case (relPath, _) => publishLocalFolder / relPath }

        val jarFile  = existing.jarFile._2
        val lockFile = jarFile / os.up / ".lock"

        FileLocking.withLock(lockFile.toNIO) { _ =>
          if (ensureSourceFilesWritten) {
            files.sync(allFilesProperVersion.all, compilerPaths.baseDir, deleteUnknowns = true, soft = softWrites)
          }

          if (existing.all.forall { case (_, file) => files.exists(file) }) {
            logger.warn(s"Using cached build $jarFile")
            PhaseRes.Ok(PublishedSbtProject(sbtProject)(compilerPaths.classesDir, existing, None))
          } else {

            files.deleteAll(compilerPaths.classesDir)
            os.makeDir.all(compilerPaths.classesDir)
            if (!ensureSourceFilesWritten) {
              files.sync(
                allFilesProperVersion.all,
                compilerPaths.baseDir,
                deleteUnknowns = true,
                soft           = softWrites,
              )
            }

            val jarDeps: Set[Compiler.InternalDep] =
              deps.values.to(Set).map(x => Compiler.InternalDepJar(x.localIvyFiles.jarFile._2))

            if (files.exists(compilerPaths.resourcesDir))
              os.copy.over(from = compilerPaths.resourcesDir, to = compilerPaths.classesDir, replaceExisting = true)

            logger.warn(s"Building $jarFile...")
            val t0 = System.currentTimeMillis()
            val ret: PhaseRes[LibTsSource, PublishedSbtProject] =
              compiler.compile(lib.libName, digest, compilerPaths, jarDeps, flavour.dependencies) match {
                case Right(()) =>
                  val writtenIvyFiles: IvyLayout[os.RelPath, os.Path] =
                    ContentForPublish(
                      v            = versions,
                      paths        = compilerPaths,
                      p            = sbtProject,
                      publication  = ZonedDateTime.now(),
                      externalDeps = flavour.dependencies,
                    ).mapValues { (relPath, contents) =>
                      val path = publishLocalFolder / relPath
                      files.softWriteBytes(path, contents)
                      path
                    }

                  val elapsed = System.currentTimeMillis - t0
                  logger.warn(s"Built $jarFile in $elapsed ms")

                  PhaseRes.Ok(PublishedSbtProject(sbtProject)(compilerPaths.classesDir, writtenIvyFiles, None))

                case Left(err) =>
                  logger.error(err)
                  val firstError = err.split("\n").drop(1).headOption.getOrElse("")
                  PhaseRes.Failure(Map(source -> Right(s"Compilation failed: $firstError")))
              }

            files.deleteAll(compilerPaths.targetDir)

            ret
          }
        }
    }
  }
}

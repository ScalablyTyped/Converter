package org.scalablytyped.converter.internal
package importer

import java.time.ZonedDateTime

import com.olvind.logging.{Formatter, Logger}
import org.scalablytyped.converter.internal.importer.build._
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl

import scala.collection.immutable.SortedSet
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.Try

/**
  * This phase goes from scala AST to compiled jar files on the local file system
  */
class Phase3Compile(
    resolve:                    LibraryResolver,
    versions:                   Versions,
    compiler:                   Compiler,
    targetFolder:               os.Path,
    organization:               String,
    publisherOpt:               Option[Publisher],
    publishLocalFolder:         os.Path,
    metadataFetcher:            Npmjs,
    softWrites:                 Boolean,
    flavour:                    FlavourImpl,
    generateScalaJsBundlerFile: Boolean,
    ensureSourceFilesWritten:   Boolean,
) extends Phase[Source, LibScalaJs, PublishedSbtProject] {

  val ScalaFiles: PartialFunction[(os.RelPath, Array[Byte]), Array[Byte]] = {
    case (path, value)
        if path.ext === "scala" ||
          path.ext === "sbt" ||
          path.last === ScalaJsBundlerDepFile.manifestFileName =>
      value
  }

  implicit val PathFormatter: Formatter[os.Path] = _.toString

  override def apply(
      source:  Source,
      lib:     LibScalaJs,
      getDeps: GetDeps[Source, PublishedSbtProject],
      v4:      IsCircular,
      _logger: Logger[Unit],
  ): PhaseRes[Source, PublishedSbtProject] = {
    val logger = _logger.withContext("flavour", flavour.toString)

    getDeps(lib.dependencies.keys.map(x => x: Source).to[SortedSet]) flatMap {
      case PublishedSbtProject.Unpack(deps) =>
        val scope = new TreeScope.Root(
          libName       = lib.scalaName,
          _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
          logger        = logger,
          pedantic      = false,
          outputPkg     = flavour.outputPkg,
        )

        val scalaFiles    = Printer(scope, new ParentsResolver, lib.packageTree)
        val sourcesDir    = os.RelPath("src") / 'main / 'scala
        val resourcesDir  = os.RelPath("src") / 'main / 'resources
        val metadataOpt   = Try(Await.result(metadataFetcher(lib.source, logger), 2.seconds)).toOption.flatten
        val compilerPaths = CompilerPaths.of(versions, targetFolder, lib.libName)
        val externalDeps  = flavour.dependencies

        val resources: Map[os.RelPath, Array[Byte]] =
          if (generateScalaJsBundlerFile) ScalaJsBundlerDepFile(lib.source.libName, lib.libVersion)
          else Map()

        val sbtLayout = ContentSbtProject(
          versions        = versions,
          comments        = lib.packageTree.comments,
          organization    = organization,
          name            = lib.libName,
          version         = VersionHack.TemplateValue,
          publisherOpt    = publisherOpt,
          localDeps       = deps.toIArrayValues,
          deps            = externalDeps,
          scalaFiles      = scalaFiles.map { case (relPath, content) => sourcesDir / relPath -> content },
          resources       = resources.map { case (relPath, content) => resourcesDir / relPath -> content },
          metadataOpt     = metadataOpt,
          declaredVersion = Some(lib.libVersion),
        )

        val digest                = Digest.of(sbtLayout.all collect ScalaFiles)
        val finalVersion          = lib.libVersion.version(digest)
        val allFilesProperVersion = VersionHack.templateVersion(sbtLayout, finalVersion)

        if (ensureSourceFilesWritten) {
          files.sync(allFilesProperVersion.all, compilerPaths.baseDir, true, softWrites)
        }

        val reference = Dep.ScalaJs(organization, lib.libName, finalVersion)

        val sbtProject = SbtProject(
          lib.libName,
          reference.mangledArtifact(versions),
          reference,
        )(compilerPaths.baseDir, deps, metadataOpt)

        val existing: IvyLayout[os.Path, Unit] =
          IvyLayout(sbtProject, (), (), (), ()).mapFiles(publishLocalFolder / _)

        val jarFile  = existing.jarFile._1
        val lockFile = jarFile / os.up / ".lock"

        FileLocking.withLock(lockFile.toNIO) { _ =>
          if (existing.all.keys forall files.exists) {
            logger warn s"Using cached build $jarFile"
            PhaseRes.Ok(PublishedSbtProject(sbtProject)(compilerPaths.classesDir, existing, None))
          } else {
            files.deleteAll(compilerPaths.classesDir)
            os.makeDir.all(compilerPaths.classesDir)
            if (!ensureSourceFilesWritten) {
              files.sync(allFilesProperVersion.all, compilerPaths.baseDir, true, softWrites)
            }

            val jarDeps: Set[Compiler.InternalDep] =
              deps.values.to[Set].map(x => Compiler.InternalDepJar(x.localIvyFiles.jarFile._1))

            if (files.exists(compilerPaths.resourcesDir))
              os.copy.over(from = compilerPaths.resourcesDir, to = compilerPaths.classesDir, replaceExisting = true)

            logger warn s"Building $jarFile..."
            val t0 = System.currentTimeMillis()
            val ret: PhaseRes[Source, PublishedSbtProject] =
              compiler.compile(lib.libName, digest, compilerPaths, jarDeps, externalDeps) match {
                case Right(()) =>
                  val writtenIvyFiles: IvyLayout[os.Path, Synced] =
                    ContentForPublish(
                      versions,
                      compilerPaths,
                      sbtProject,
                      ZonedDateTime.now(),
                      externalDeps,
                    ).mapFiles(p => publishLocalFolder / p).mapValues(files.softWriteBytes)

                  val elapsed = System.currentTimeMillis - t0
                  logger warn s"Built $jarFile in $elapsed ms"

                  PhaseRes.Ok(PublishedSbtProject(sbtProject)(compilerPaths.classesDir, writtenIvyFiles, None))

                case Left(err) =>
                  logger.error(err)
                  PhaseRes.Failure(Map(source -> Right(s"Compilation failed")))
              }

            files.deleteAll(compilerPaths.targetDir)

            ret
          }
        }
    }
  }
}

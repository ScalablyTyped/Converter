package org.scalablytyped.converter.internal
package importer

import bleep.model
import com.olvind.logging.{Formatter, Logger}
import org.scalablytyped.converter.internal.importer.Phase3Compile.bleepBuildFile
import org.scalablytyped.converter.internal.importer.build._
import org.scalablytyped.converter.internal.importer.cli.WrittenLine
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl

import java.nio.file.Paths
import scala.collection.immutable.{SortedMap, SortedSet}
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
    bleepCompiler:              BleepCompiler,
    targetFolder:               os.Path,
    organization:               String,
    publishLocalTarget:         PublishLocalTarget,
    metadataFetcher:            Npmjs,
    softWrites:                 Boolean,
    flavour:                    FlavourImpl,
    generateScalaJsBundlerFile: Boolean,
    ensureSourceFilesWritten:   Boolean,
) extends Phase[LibTsSource, LibScalaJs, ScalaProject] {

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
      getDeps: GetDeps[LibTsSource, ScalaProject],
      v4:      IsCircular,
      _logger: Logger[Unit],
  ): PhaseRes[LibTsSource, ScalaProject] = {
    val logger = _logger.withContext("flavour", flavour.toString)

    getDeps(lib.dependencies.keys.map(x => x: LibTsSource).to[SortedSet]).flatMap {
      case ScalaProject.Unpack(deps: SortedMap[LibTsSource, ScalaProject]) =>
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

        val allDeps: IArray[Dep] =
          IArray.fromTraversable(flavour.dependencies) ++ IArray(versions.runtime) ++ deps.toIArrayValues.map(d =>
            d.reference,
          )

        val bleepFile = bleepBuildFile(lib.libName, versions, allDeps, publishLocalTarget)
        val sbtLayout: SbtProjectLayout[os.RelPath, String] = ContentSbtProject(
          versions        = versions,
          comments        = lib.packageTree.comments,
          organization    = organization,
          name            = lib.libName,
          version         = VersionHack.TemplateValue,
          scalaFiles      = scalaFiles.map { case (relPath, content) => sourcesDir / relPath -> content },
          resources       = resources.map { case (relPath, content) => resourcesDir / relPath -> content },
          metadataOpt     = metadataOpt,
          declaredVersion = Some(lib.libVersion),
          bleepBuildFile  = bleepFile,
          allDeps         = allDeps,
        )

        val digest                = Digest.of(sbtLayout.all.collect(ScalaFiles))
        val finalVersion          = lib.libVersion.version(digest)
        val allFilesProperVersion = VersionHack.templateVersion(sbtLayout, finalVersion)

        val reference = Dep.ScalaJs(organization, lib.libName, finalVersion).concrete(versions)

        val sbtProject = ScalaProject(lib.libName, reference)(compilerPaths.baseDir, deps, metadataOpt, bleepFile)

        val (jarFile, existing) = {
          publishLocalTarget match {
            case PublishLocalTarget.DefaultIvy2 =>
              val layout =
                IvyLayout.unit(reference).mapValues { case (relPath, _) => publishLocalTarget.path / relPath }
              (layout.jarFile._2, layout)
            case PublishLocalTarget.InHomeFolder(_) =>
              val layout =
                MavenLayout.unit(reference).mapValues { case (relPath, _) => publishLocalTarget.path / relPath }
              (layout.jarFile._2, layout)
          }
        }

        val lockFile = jarFile / os.up / ".lock"

        FileLocking.withLock(lockFile.toNIO) { _ =>
          if (ensureSourceFilesWritten) {
            files.sync(allFilesProperVersion.all, compilerPaths.baseDir, deleteUnknowns = true, soft = softWrites)
          }

          if (existing.all.forall { case (_, file) => files.exists(file) }) {
            logger.warn(s"Using cached build $jarFile")
            PhaseRes.Ok(sbtProject)
          } else {

            if (!ensureSourceFilesWritten) {
              files.sync(
                allFilesProperVersion.all,
                compilerPaths.baseDir,
                deleteUnknowns = true,
                soft           = softWrites,
              )
            }

            logger.warn(s"Building $jarFile...")
            val t0 = System.currentTimeMillis()

            cli(
              "bleep compile-server auto-shutdown-enable",
              cwd = compilerPaths.baseDir.toNIO,
              cmd = List(
                bleepCompiler.path.toString,
                "compile-server",
                "auto-shutdown-enable",
              ),
              cli.CliLogger(logger),
            )

            val ret: PhaseRes[LibTsSource, ScalaProject] = {
              val cmd = {
                List(
                  List(
                    bleepCompiler.path.toString,
                    "--debug",
                    "--dev",
                    "publish-local",
                    "--groupId",
                    organization,
                    "--version",
                    finalVersion,
                  ),
                  publishLocalTarget match {
                    case PublishLocalTarget.DefaultIvy2 => Nil
                    case inHome: PublishLocalTarget.InHomeFolder => List("--to", inHome.path.toString())
                  },
                  List(lib.libName),
                ).flatten
              }

              cli(
                "bleep publish-local",
                compilerPaths.baseDir.toNIO,
                cmd,
                cliLogger = cli.CliLogger(logger),
              ) match {
                case Right(_) =>
                  val elapsed = System.currentTimeMillis - t0
                  logger.warn(s"Built $jarFile in $elapsed ms")

                  PhaseRes.Ok(sbtProject)
                case Left(writtenLines) =>
                  val errors = writtenLines.combined
                    .collect {
                      case WrittenLine.StdErr(line) if line.contains("\uD83D\uDCD5") => line
                      case WrittenLine.StdOut(line) if line.contains("\uD83D\uDCD5") => line
                    }
                    .mkString("\n")
                  logger.error(errors)

                  PhaseRes.Failure(Map(source -> Right(s"Compilation failed: $errors")))

              }
            }

            // ignore errors - the folder may not exist if everything failed above
            Try(files.deleteAll(compilerPaths.baseDir / ".bleep"))

            ret
          }
        }
    }
  }

}

object Phase3Compile {
  def bleepBuildFile(
      name:               String,
      versions:           Versions,
      allDeps:            IArray[Dep],
      publishLocalTarget: PublishLocalTarget,
  ): model.BuildFile = {
    def toBleep(dep: Dep.Concrete): model.Dep =
      model.Dep.Java(dep.org, dep.mangledArtifact, dep.version)

    model.BuildFile(
      $schema   = model.$schema,
      $version  = model.BleepVersion.current,
      templates = model.JsonMap.empty,
      scripts   = model.JsonMap.empty,
      resolvers = publishLocalTarget match {
        case PublishLocalTarget.DefaultIvy2 => model.JsonList.empty
        case PublishLocalTarget.InHomeFolder(relPath) =>
          model.JsonList(List(model.Repository.MavenFolder(None, Paths.get(s"$${HOME_DIR}/$relPath"))))
      },
      projects = model.JsonMap(
        Map(
          model.ProjectName(name) -> model.Project(
            `extends`       = model.JsonSet.empty,
            cross           = model.JsonMap.empty,
            folder          = Some(bleep.RelPath.force(".")),
            dependsOn       = model.JsonSet.empty,
            `source-layout` = None,
            `sbt-scope`     = Some("main"),
            sources         = model.JsonSet.empty,
            resources       = model.JsonSet.empty,
            dependencies    = model.JsonSet[model.Dep](allDeps.map(dep => toBleep(dep.concrete(versions))).toList: _*),
            java            = None,
            scala = Some(
              model.Scala(
                version         = Some(model.VersionScala(versions.scala.scalaVersion)),
                options         = model.Options.parse(versions.scalacOptions, None),
                setup           = None,
                compilerPlugins = model.JsonSet.empty,
                strict          = None,
              ),
            ),
            platform = Some(
              model.Platform.Js(
                model.VersionScalaJs(versions.scalaJs.scalaJsVersion),
                jsMode           = None,
                jsKind           = None,
                jsEmitSourceMaps = None,
                jsJsdom          = None,
                jsNodeVersion    = None,
                jsMainClass      = None,
              ),
            ),
            isTestProject  = None,
            testFrameworks = model.JsonSet.empty,
          ),
        ),
      ),
      jvm = Some(model.Jvm("graalvm-java17:22.3.0", None)),
    )
  }
}

package org.scalablytyped.converter.internal
package importer

import java.time.{Instant, ZonedDateTime}

import ammonite.ops.%
import com.olvind.logging.{Formatter, Logger}
import org.scalablytyped.converter.internal.importer.Phase2Res.{Facade, LibScalaJs}
import org.scalablytyped.converter.internal.importer.build._
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl
import org.scalablytyped.converter.internal.sets.SetOps
import org.scalablytyped.converter.internal.ts.TsIdentLibrary

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
    projectName:                String,
    organization:               String,
    publishUser:                String,
    publishFolder:              os.Path,
    metadataFetcher:            Npmjs,
    softWrites:                 Boolean,
    flavour:                    FlavourImpl,
    generateScalaJsBundlerFile: Boolean,
    ensureSourceFilesWritten:   Boolean,
) extends Phase[Source, Phase2Res, PublishedSbtProject] {

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
      _lib:    Phase2Res,
      getDeps: GetDeps[Source, PublishedSbtProject],
      v4:      IsCircular,
      _logger: Logger[Unit],
  ): PhaseRes[Source, PublishedSbtProject] = {
    val logger = _logger.withContext("flavour", flavour.toString)

    _lib match {
      case Facade =>
        val buildJson = Json[FacadeJson](source.path / "build.json")

        val dependencies: PhaseRes[Source, Set[Source]] =
          PhaseRes.sequenceSet(
            buildJson.typings.map { t =>
              val maybeSource: Option[Source] = resolve.libraryOrFacade(TsIdentLibrary(t))
              PhaseRes.fromOption(source, maybeSource, Right(s"Couldn't resolve $t"))
            },
          )

        dependencies flatMap (x => getDeps(x.sorted)) flatMap {
          case PublishedSbtProject.Unpack(deps) =>
            val sourceFilesBase: Map[os.RelPath, (Array[Byte], Instant)] =
              os.walk(source.path / 'src)
                .collect { case path if os.isFile(path) => path }
                .map { path =>
                  val relPath = path relativeTo source.path
                  val bytes   = os.read.bytes(path)
                  val mtime   = os.mtime(path)
                  relPath -> ((bytes, Instant.ofEpochMilli(mtime)))
                }
                .toMap

            require(sourceFilesBase.nonEmpty, "no files found")

            val sourceFiles: Map[os.RelPath, Array[Byte]] =
              sourceFilesBase mapValues { case (bytes, _) => bytes }

            val newestChange: Instant =
              sourceFilesBase.foldLeft(Instant.MIN) {
                case (acc, (_, (_, instant))) =>
                  if (acc isBefore instant) instant else acc
              }

            val externalDeps: Set[Dep] = buildJson.dependencies ++ flavour.dependencies

            val sbtLayout = ContentSbtProject(
              v               = versions,
              comments        = NoComments,
              organization    = organization,
              name            = source.libName.value,
              version         = VersionHack.TemplateValue,
              publishUser     = publishUser,
              localDeps       = IArray.fromTraversable(deps.values),
              deps            = externalDeps,
              scalaFiles      = sourceFiles,
              resources       = Map(),
              projectName     = projectName,
              metadataOpt     = None,
              declaredVersion = None,
            )

            go(
              logger             = logger,
              deps               = deps,
              externalDeps       = externalDeps,
              source             = source,
              name               = source.libName.value,
              sbtLayout          = sbtLayout,
              compilerPaths      = CompilerPaths(versions, source.path),
              deleteUnknownFiles = false,
              makeVersion        = digest => s"${constants.DateTimePattern.format(newestChange)}-${digest.hexString.take(6)}",
              metadataOpt        = None,
            )
        }

      case lib: LibScalaJs =>
        getDeps(lib.dependencies.keys.map(x => x: Source).to[SortedSet]) flatMap {
          case PublishedSbtProject.Unpack(deps) =>
            val scope = new TreeScope.Root(
              libName       = lib.scalaName,
              _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
              logger        = logger,
              pedantic      = false,
              outputPkg     = flavour.outputPkg,
            )

            val scalaFiles    = Printer(scope, lib.packageTree)
            val sourcesDir    = os.RelPath("src") / 'main / 'scala
            val resourcesDir  = os.RelPath("src") / 'main / 'resources
            val metadataOpt   = Try(Await.result(metadataFetcher(lib.source, logger), 2.seconds)).toOption.flatten
            val compilerPaths = CompilerPaths.of(versions, targetFolder, lib.libName)
            val externalDeps  = flavour.dependencies

            val resources: Map[os.RelPath, Array[Byte]] =
              if (generateScalaJsBundlerFile) ScalaJsBundlerDepFile(lib.source.libName, lib.libVersion)
              else Map()

            val sbtLayout = ContentSbtProject(
              v               = versions,
              comments        = lib.packageTree.comments,
              organization    = organization,
              name            = lib.libName,
              version         = VersionHack.TemplateValue,
              publishUser     = publishUser,
              localDeps       = IArray.fromTraversable(deps.values),
              deps            = externalDeps,
              scalaFiles      = scalaFiles.map { case (relPath, content) => sourcesDir / relPath -> content },
              resources       = resources.map { case (relPath, content) => resourcesDir / relPath -> content },
              projectName     = projectName,
              metadataOpt     = metadataOpt,
              declaredVersion = Some(lib.libVersion),
            )

            go(
              logger             = logger,
              deps               = deps,
              externalDeps       = externalDeps,
              source             = source,
              name               = lib.libName,
              sbtLayout          = sbtLayout,
              compilerPaths      = compilerPaths,
              deleteUnknownFiles = true,
              makeVersion        = lib.libVersion.version,
              metadataOpt        = metadataOpt,
            )
        }
    }
  }

  def go(
      logger:             Logger[Unit],
      deps:               Map[Source, PublishedSbtProject],
      externalDeps:       Set[Dep],
      source:             Source,
      name:               String,
      sbtLayout:          SbtProjectLayout[os.RelPath, Array[Byte]],
      compilerPaths:      CompilerPaths,
      deleteUnknownFiles: Boolean,
      makeVersion:        Digest => String,
      metadataOpt:        Option[Npmjs.Data],
  ): PhaseRes[Source, PublishedSbtProject] = {

    val digest                = Digest.of(sbtLayout.all collect ScalaFiles)
    val finalVersion          = makeVersion(digest)
    val allFilesProperVersion = VersionHack.templateVersion(sbtLayout, finalVersion)

    if (ensureSourceFilesWritten) {
      files.sync(allFilesProperVersion.all, compilerPaths.baseDir, deleteUnknownFiles, softWrites)
    }

    val reference = Dep.ScalaJs(organization, name, finalVersion)

    val sbtProject = SbtProject(
      name,
      reference.mangledArtifact(versions),
      reference,
    )(compilerPaths.baseDir, deps, metadataOpt)

    val existing: IvyLayout[os.Path, Unit] =
      IvyLayout(sbtProject, (), (), (), ()).mapFiles(publishFolder / _)

    val jarFile  = existing.jarFile._1
    val lockFile = jarFile / os.up / ".lock"

    FileLocking.withLock(lockFile.toNIO) { _ =>
      if (existing.all.keys forall os.exists) {
        logger warn s"Using cached build $jarFile"
        PhaseRes.Ok(PublishedSbtProject(sbtProject)(compilerPaths.classesDir, existing, None))
      } else {
        remove(compilerPaths.classesDir)
        os.makeDir.all(compilerPaths.classesDir)
        if (!ensureSourceFilesWritten) {
          files.sync(allFilesProperVersion.all, compilerPaths.baseDir, deleteUnknownFiles, softWrites)
        }

        val jarDeps: Set[Compiler.InternalDep] =
          deps.values.to[Set].map(x => Compiler.InternalDepJar(x.localIvyFiles.jarFile._1))

        if (os.exists(compilerPaths.resourcesDir))
          os.copy.over(from = compilerPaths.resourcesDir, to = compilerPaths.classesDir, replaceExisting = true)

        logger warn s"Building $jarFile..."
        val t0 = System.currentTimeMillis()
        val ret: PhaseRes[Source, PublishedSbtProject] =
          compiler.compile(name, digest, compilerPaths, jarDeps, externalDeps) match {
            case Right(()) =>
              val writtenIvyFiles: IvyLayout[os.Path, Synced] =
                ContentForPublish(
                  versions,
                  compilerPaths,
                  sbtProject,
                  ZonedDateTime.now(),
                  externalDeps,
                ).mapFiles(p => publishFolder / p).mapValues(files.softWriteBytes)

              val elapsed = System.currentTimeMillis - t0
              logger warn s"Built $jarFile in $elapsed ms"

              PhaseRes.Ok(PublishedSbtProject(sbtProject)(compilerPaths.classesDir, writtenIvyFiles, None))

            case Left(err) =>
              logger.error(err)
              PhaseRes.Failure(Map(source -> Right(s"Compilation failed")))
          }

        remove(compilerPaths.targetDir)

        ret
      }
    }
  }

  /* don't use `os.remove` as it's much slower */
  def remove(p: os.Path): Unit = {
    implicit val wd = os.home
    % rm ("-Rf", p)
  }
}

package org.scalablytyped.converter.internal
package importer

import java.nio.ByteBuffer
import java.time.ZonedDateTime

import ammonite.ops.%
import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.importer.Phase2Res.{Facade, LibScalaJs}
import org.scalablytyped.converter.internal.importer.build._
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl
import os.Path

import scala.collection.immutable.{SortedMap, SortedSet}

/**
  * This phase goes from scala AST to compiled jar files on the local file system
  */
class Phase3CompileForPlugin(
    versions:      Versions,
    compiler:      Compiler,
    targetFolder:  os.Path,
    publishFolder: os.Path,
    flavour:       FlavourImpl,
) extends Phase[Source, Phase2Res, IArray[os.Path]] {

  override def apply(
      source:  Source,
      _lib:    Phase2Res,
      getDeps: GetDeps[Source, IArray[os.Path]],
      v4:      IsCircular,
      _logger: Logger[Unit],
  ): PhaseRes[Source, IArray[os.Path]] = {
    val logger = _logger.withContext("flavour", flavour.toString)

    _lib match {
      case Facade => PhaseRes.Ignore()

      case lib: LibScalaJs =>
        getDeps(lib.dependencies.keys.map(x => x: Source).to[SortedSet]) flatMap {
          deps: SortedMap[Source, IArray[Path]] =>
            val scope = new TreeScope.Root(
              libName       = lib.scalaName,
              _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
              logger        = logger,
              pedantic      = false,
              outputPkg     = flavour.outputPkg,
            )

            val externalDeps = flavour.dependencies

            /* all dependencies need to be part of the digest, so we output this file */
            val depsFile = {
              val localFileNames = IArray
                .fromTraversable(deps.values)
                .flatten
                .map(_.last) // avoid absolute paths, and the file name contains enough info

              val externalReferences = IArray.fromTraversable(externalDeps).map(_.asSbt(versions))

              Map(
                os.RelPath(".deps") ->
                  (localFileNames ++ externalReferences).sorted.distinct
                    .mkString("\n")
                    .getBytes(constants.Utf8),
              )
            }

            val scalaFiles    = Printer(scope, lib.packageTree)
            val allFiles      = scalaFiles ++ depsFile
            val compilerPaths = CompilerPaths.of(versions, targetFolder, lib.libName)
            val digest        = Digest.of(allFiles.toSorted.values)
            val finalVersion  = lib.libVersion.version(digest)

            def jar(suffix: String) =
              publishFolder / lib.source.libName.`__value` / (versions.sjs(
                s"${lib.source.libName.`__value`}-$finalVersion",
              ) + suffix)

            val jarFile    = jar(".jar")
            val sourcesJar = jar("-sources.jar")

            /* return a list of jars for this library and all its dependencies */
            val allJars = (IArray(jarFile, sourcesJar) ++ IArray.fromTraversable(deps.values).flatten).distinct

            FileLocking.tryWrite(
              jarFile.toNIO,
              onExists = (_, _) => {
                logger warn s"Using cached build $jarFile"
                PhaseRes.Ok(allJars)
              },
              onNotExists = channel => {
                {
                  implicit val wd = os.home
                  % rm ("-Rf", compilerPaths.baseDir)
                }

                files.sync(allFiles, compilerPaths.sourcesDir, deleteUnknowns = false, soft = false)
                os.makeDir.all(compilerPaths.classesDir)

                val jarDeps: Set[Compiler.InternalDep] =
                  deps.values.to[Set].flatMap(_.toSet).map(x => Compiler.InternalDepJar(x))

                logger warn s"Building ${jarFile}..."
                val t0 = System.currentTimeMillis

                compiler.compile(lib.libName, digest, compilerPaths, jarDeps, externalDeps) match {
                  case Right(()) =>
                    val publication = ZonedDateTime.now()

                    channel.write(ByteBuffer.wrap(ContentForPublish.createJar(publication)(compilerPaths.classesDir)))

                    files.softWriteBytes(
                      sourcesJar,
                      ContentForPublish.createJar(MapLayout(allFiles), publication),
                    )

                    val elapsed = System.currentTimeMillis - t0
                    logger warn s"Built $jarFile in $elapsed ms"

                    PhaseRes.Ok(allJars)
                  case Left(err) =>
                    logger.error(err)
                    PhaseRes.Failure(Map(source -> Right(s"Compilation failed")))
                }
              },
            )
        }
    }
  }
}

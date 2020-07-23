package org.scalablytyped.converter
package internal

import java.nio.file.Path

import com.olvind.logging.Logger
import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer._
import org.scalablytyped.converter.internal.importer.build.{Compiler, IvyLayout, PublishedSbtProject}
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.Dep
import org.scalablytyped.converter.internal.ts._
import os.RelPath
import sbt.librarymanagement.ModuleID

import scala.collection.immutable.SortedMap

object ImportTypings {
  type InOut = (Input, Output)

  case class Input(
      converterVersion: String,
      conversion:       ConversionOptions,
      wantedLibs:       SortedMap[TsIdentLibrary, String],
  ) {
    lazy val packageJsonHash: String = Digest.of(wantedLibs.map { case (name, v) => s"${name.value} $v" }).hexString
  }

  object Input {
    import io.circe013.generic.auto._
    import jsonCodecs._

    implicit val InputEncoder: Encoder[Input] = exportEncoder[Input].instance
    implicit val InputDecoder: Decoder[Input] = exportDecoder[Input].instance
  }

  case class Output(externalDeps: Set[Dep.Concrete], allProjects: Seq[Dep.Concrete]) {
    val allRelPaths: Seq[RelPath] =
      allProjects.flatMap(p => IvyLayout.unit(p).all.keys)

    def allPaths(in: os.Path): Seq[os.Path] =
      allRelPaths map (in / _)

    def moduleIds: Set[ModuleID] =
      externalDeps ++ allProjects map Utils.asModuleID
  }

  object Output {
    import io.circe013.generic.auto._
    import jsonCodecs._
    implicit val OutputEncoder: Encoder[Output] = exportEncoder[Output].instance
    implicit val OutputDecoder: Decoder[Output] = exportDecoder[Output].instance
  }

  def apply(
      input:              Input,
      logger:             Logger[Unit],
      parseCacheDirOpt:   Option[Path],
      publishLocalFolder: os.Path,
      fromFolder:         InFolder,
      targetFolder:       os.Path,
      compiler:           Compiler,
  ): Either[Map[Source, Either[Throwable, String]], Output] = {

    if (input.conversion.expandTypeMappings =/= EnabledTypeMappingExpansion.DefaultSelection) {
      logger.warn("Changing stInternalExpandTypeMappings not encouraged. It might blow up")
    }

    val fromNodeModules = Source.fromNodeModules(fromFolder, input.conversion, input.wantedLibs.keySet)
    logger.warn(s"Importing ${fromNodeModules.sources.map(_.libName.value).mkString(", ")}")

    val cachedParser = PersistingParser(parseCacheDirOpt, fromNodeModules.folders, logger)

    val Phases: RecPhase[Source, PublishedSbtProject] = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          resolve                 = fromNodeModules.libraryResolver,
          calculateLibraryVersion = CalculateLibraryVersion.PackageJsonOnly,
          ignored                 = input.conversion.ignoredLibs,
          ignoredModulePrefixes   = input.conversion.ignoredModulePrefixes,
          stdlibSource            = fromNodeModules.stdLibSource,
          pedantic                = false,
          parser                  = cachedParser,
          expandTypeMappings      = input.conversion.expandTypeMappings,
        ),
        "typescript",
      )
      .next(
        new Phase2ToScalaJs(
          pedantic             = false,
          enableScalaJsDefined = input.conversion.enableScalaJsDefined,
          outputPkg            = input.conversion.outputPackage,
          flavour              = input.conversion.flavourImpl,
        ),
        "scala.js",
      )
      .next(new PhaseFlavour(input.conversion.flavourImpl), input.conversion.flavourImpl.toString)
      .next(
        new Phase3Compile(
          versions                   = input.conversion.versions,
          compiler                   = compiler,
          targetFolder               = targetFolder,
          organization               = input.conversion.organization,
          publisherOpt               = None,
          publishLocalFolder         = publishLocalFolder,
          metadataFetcher            = Npmjs.No,
          softWrites                 = true,
          flavour                    = input.conversion.flavourImpl,
          generateScalaJsBundlerFile = false,
          ensureSourceFilesWritten   = false,
        ),
        "build",
      )

    val results: SortedMap[Source, PhaseRes[Source, PublishedSbtProject]] =
      fromNodeModules.sources
        .map(s => s -> PhaseRunner(Phases, (_: Source) => logger, PhaseListener.NoListener)(s))
        .toMap
        .toSorted

    val successes: Map[Source, Dep.Concrete] = {
      def go(source: Source, lib: PublishedSbtProject): Map[Source, Dep.Concrete] =
        Map(source -> lib.project.reference) ++ lib.project.deps.flatMap { case (k, v) => go(k, v) }

      results.collect { case (s, PhaseRes.Ok(res)) => go(s, res) }.reduceOption(_ ++ _).getOrElse(Map.empty)
    }

    val failures: Map[Source, Either[Throwable, String]] =
      results.collect { case (_, PhaseRes.Failure(errors)) => errors }.reduceOption(_ ++ _).getOrElse(Map.empty)

    if (failures.nonEmpty) Left(failures)
    else
      Right(
        Output(
          input.conversion.flavourImpl.dependencies.map(_.concrete(input.conversion.versions)),
          successes.values.toVector,
        ),
      )
  }
}

package org.scalablytyped.converter
package internal

import java.nio.file.Path

import com.olvind.logging.Logger
import io.circe.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer._
import org.scalablytyped.converter.internal.importer.build.{Compiler, PublishedSbtProject}
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.Dep
import org.scalablytyped.converter.internal.ts._

import scala.collection.immutable.SortedMap

object ImportTypings {

  case class Input(
      fromFolder:       InFolder,
      targetFolder:     os.Path,
      converterVersion: String,
      packageJsonHash:  String,
      shared:           SharedInput,
  )

  object Input {
    import io.circe.generic.auto._
    import jsonCodecs._

    implicit val InputEncoder: Encoder[Input] = exportEncoder[Input].instance
    implicit val InputDecoder: Decoder[Input] = exportDecoder[Input].instance
  }

  case class Output(deps: Set[Dep], allJars: Set[os.Path])

  object Output {
    import io.circe.generic.auto._
    import jsonCodecs._
    implicit val OutputEncoder: Encoder[Output] = exportEncoder[Output].instance
    implicit val OutputDecoder: Decoder[Output] = exportDecoder[Output].instance
  }

  def apply(
      input:            Input,
      logger:           Logger[Unit],
      parseCacheDirOpt: Option[Path],
      publishFolder:    os.Path,
      compiler:         Compiler,
  ): Either[Map[Source, Either[Throwable, String]], Output] = {

    if (input.shared.expandTypeMappings =/= EnabledTypeMappingExpansion.DefaultSelection) {
      logger.warn("Changing stInternalExpandTypeMappings not encouraged. It might blow up")
    }

    val fromNodeModules = Source.fromNodeModules(input.fromFolder, input.shared)
    logger.warn(s"Importing ${fromNodeModules.sources.map(_.libName.value).mkString(", ")}")

    val cachedParser = PersistingParser(parseCacheDirOpt, fromNodeModules.folders, logger)

    val flavour = flavourImpl.fromInput(input.shared)

    val Phases: RecPhase[Source, PublishedSbtProject] = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          resolve                 = fromNodeModules.libraryResolver,
          calculateLibraryVersion = CalculateLibraryVersion.PackageJsonOnly,
          ignored                 = input.shared.ignoredLibs,
          ignoredModulePrefixes   = input.shared.ignoredModulePrefixes,
          stdlibSource            = fromNodeModules.stdLibSource,
          pedantic                = false,
          parser                  = cachedParser,
          expandTypeMappings      = input.shared.expandTypeMappings,
        ),
        "typescript",
      )
      .next(
        new Phase2ToScalaJs(
          pedantic             = false,
          enableScalaJsDefined = input.shared.enableScalaJsDefined,
          outputPkg            = input.shared.outputPackage,
        ),
        "scala.js",
      )
      .next(new PhaseFlavour(flavour), flavour.toString)
      .next(
        new Phase3Compile(
          versions                   = input.shared.versions,
          compiler                   = compiler,
          targetFolder               = input.targetFolder,
          publishFolder              = publishFolder,
          flavour                    = flavour,
          organization               = "org.scalablytyped",
          projectName                = "ScalablyTyped",
          publishUser                = "oyvindberg",
          metadataFetcher            = Npmjs.No,
          resolve                    = fromNodeModules.libraryResolver,
          softWrites                 = true,
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

    val successes: Map[Source, PublishedSbtProject] = {
      def go(source: Source, p: PublishedSbtProject): Map[Source, PublishedSbtProject] =
        Map(source -> p) ++ p.project.deps.flatMap { case (k, v) => go(k, v) }

      results.collect { case (s, PhaseRes.Ok(res)) => go(s, res) }.reduceOption(_ ++ _).getOrElse(Map.empty)
    }

    val failures: Map[Source, Either[Throwable, String]] =
      results.collect { case (_, PhaseRes.Failure(errors)) => errors }.reduceOption(_ ++ _).getOrElse(Map.empty)

    if (failures.nonEmpty) Left(failures)
    else
      Right(
        Output(
          flavour.dependencies ++ successes.map(_._2.project.reference),
          successes.foldLeft(Set[os.Path]()) { case (acc, (_, p)) => acc ++ p.localIvyFiles.all.keys },
        ),
      )
  }
}

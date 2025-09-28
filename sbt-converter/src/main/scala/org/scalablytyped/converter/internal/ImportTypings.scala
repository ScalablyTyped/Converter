package org.scalablytyped.converter
package internal

import java.nio.file.Path

import com.olvind.logging.Logger
import io.circe.{Decoder, Encoder}
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
    lazy val packageJsonHash: String =
      Digest.of(IArray.fromTraversable(wantedLibs.map { case (name, v) => s"${name.value} $v" })).hexString
  }

  object Input {
    implicit val encodes: Encoder[Input] = io.circe.generic.semiauto.deriveEncoder
    implicit val decodes: Decoder[Input] = io.circe.generic.semiauto.deriveDecoder
  }

  case class Output(externalDeps: Set[Dep.Concrete], allProjects: IArray[Dep.Concrete]) {
    val allRelPaths: IArray[RelPath] =
      allProjects.flatMap(p => IvyLayout.unit(p).all.map { case (k, _) => k })

    def moduleIds: Set[ModuleID] =
      (externalDeps ++ allProjects.toSet).map(Utils.asModuleID)
  }

  object Output {
    implicit val encodes: Encoder[Output] = io.circe.generic.semiauto.deriveEncoder
    implicit val decodes: Decoder[Output] = io.circe.generic.semiauto.deriveDecoder
  }

  def apply(
      input:              Input,
      logger:             Logger[Unit],
      parseCacheDirOpt:   Option[Path],
      publishLocalFolder: os.Path,
      fromFolder:         InFolder,
      targetFolder:       os.Path,
      compiler:           Compiler,
  ): Either[Map[LibTsSource, Either[Throwable, String]], Output] = {

    if (input.conversion.expandTypeMappings =/= EnabledTypeMappingExpansion.DefaultSelection) {
      logger.warn("Changing stInternalExpandTypeMappings not encouraged. It might blow up")
    }

    if (input.conversion.enableLongApplyMethod) {
      logger.warn("enableLongApplyMethod is deprecated and untested. You should migrate to the builder pattern.")
    }

    val bootstrapped = Bootstrap.fromNodeModules(fromFolder, input.conversion, input.wantedLibs.keySet)

    val initial = bootstrapped.initialLibs match {
      case Left(unresolved) => sys.error(unresolved.msg)
      case Right(initial)   => initial
    }

    logger.info(s"Importing ${initial.map(_.libName.value).mkString(", ")}")

    val cachedParser = PersistingParser(parseCacheDirOpt, bootstrapped.inputFolders, logger)

    val Phases: RecPhase[LibTsSource, PublishedSbtProject] = RecPhase[LibTsSource]
      .next(
        new Phase1ReadTypescript(
          resolve                 = bootstrapped.libraryResolver,
          calculateLibraryVersion = CalculateLibraryVersion.PackageJsonOnly,
          ignored                 = input.conversion.ignoredLibs,
          ignoredModulePrefixes   = input.conversion.ignoredModulePrefixes,
          pedantic                = false,
          parser                  = cachedParser,
          expandTypeMappings      = input.conversion.expandTypeMappings,
        ),
        "typescript",
      )
      .next(
        new Phase2ToScalaJs(
          pedantic                 = false,
          scalaVersion             = input.conversion.versions.scala,
          enableScalaJsDefined     = input.conversion.enableScalaJsDefined,
          outputPkg                = input.conversion.outputPackage,
          flavour                  = input.conversion.flavourImpl,
          useDeprecatedModuleNames = input.conversion.useDeprecatedModuleNames,
        ),
        "scala.js",
      )
      .next(
        new PhaseFlavour(input.conversion.flavourImpl, maybePrivateWithin = input.conversion.privateWithin),
        input.conversion.flavourImpl.toString,
      )
      .next(
        new Phase3Compile(
          versions                   = input.conversion.versions,
          compiler                   = compiler,
          targetFolder               = targetFolder,
          organization               = input.conversion.organization,
          publishLocalFolder         = publishLocalFolder,
          metadataFetcher            = Npmjs.No,
          softWrites                 = true,
          flavour                    = input.conversion.flavourImpl,
          generateScalaJsBundlerFile = false,
          ensureSourceFilesWritten   = false,
        ),
        "build",
      )

    val results: SortedMap[LibTsSource, PhaseRes[LibTsSource, PublishedSbtProject]] =
      initial
        .map(s => (s: LibTsSource) -> PhaseRunner(Phases, (_: LibTsSource) => logger, PhaseListener.NoListener)(s))
        .toMap
        .toSorted

    val successes: Map[LibTsSource, Dep.Concrete] = {
      def go(source: LibTsSource, lib: PublishedSbtProject): Map[LibTsSource, Dep.Concrete] =
        Map(source -> lib.project.reference) ++ lib.project.deps.flatMap { case (k, v) => go(k, v) }

      results.collect { case (s, PhaseRes.Ok(res)) => go(s, res) }.reduceOption(_ ++ _).getOrElse(Map.empty)
    }

    val failures: Map[LibTsSource, Either[Throwable, String]] =
      results.collect { case (_, PhaseRes.Failure(errors)) => errors }.reduceOption(_ ++ _).getOrElse(Map.empty)

    if (failures.nonEmpty) Left(failures)
    else
      Right(
        Output(
          input.conversion.flavourImpl.dependencies.map(_.concrete(input.conversion.versions)),
          IArray.fromTraversable(successes.values),
        ),
      )
  }
}

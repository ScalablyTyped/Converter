package org.scalablytyped.converter
package internal

import java.io.File
import java.nio.file.Path

import com.olvind.logging
import com.olvind.logging.{LogLevel, Logger}
import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer._
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.{ParentsResolver, _}
import org.scalablytyped.converter.internal.ts._

import scala.collection.immutable.{SortedMap, SortedSet}

object ImportTypingsGenSources {
  val NoListener: PhaseListener[LibTsSource] = (_, _, _) => ()

  case class Input(
      fromFolder:       InFolder,
      targetFolder:     os.Path,
      converterVersion: String,
      conversion:       ConversionOptions,
      wantedLibs:       SortedMap[TsIdentLibrary, String],
      minimize:         Selection[TsIdentLibrary],
      minimizeKeep:     IArray[QualifiedName],
  )

  object Input {
    import orphanCodecs._
    implicit val encodes: Encoder[Input] = io.circe013.generic.semiauto.deriveEncoder
    implicit val decodes: Decoder[Input] = io.circe013.generic.semiauto.deriveDecoder
  }

  def apply(
      input:            Input,
      logger:           Logger[Unit],
      parseCacheDirOpt: Option[Path],
      cacheDirOpt:      os.Path,
  ): Either[Map[LibTsSource, Either[Throwable, String]], Set[File]] = {
    import input._

    if (input.conversion.expandTypeMappings =/= EnabledTypeMappingExpansion.DefaultSelection) {
      logger.warn("Changing stInternalExpandTypeMappings not encouraged. It might blow up")
    }

    if (input.conversion.enableLongApplyMethod) {
      logger.warn("enableLongApplyMethod is deprecated and untested. You should really to the builder pattern.")
    }

    val bootstrapped = Bootstrap.fromNodeModules(input.fromFolder, input.conversion, input.wantedLibs.keySet)

    val initial = bootstrapped.initialLibs match {
      case Left(unresolved) => sys.error(unresolved.msg)
      case Right(initial)   => initial
    }

    logger.info(s"Importing ${initial.map(_.libName.value).mkString(", ")}")

    val cachedParser = PersistingParser(parseCacheDirOpt, bootstrapped.inputFolders, logger)

    val Phases: RecPhase[LibTsSource, LibScalaJs] = RecPhase[LibTsSource]
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
          outputPkg                = conversion.outputPackage,
          flavour                  = input.conversion.flavourImpl,
          useDeprecatedModuleNames = input.conversion.useDeprecatedModuleNames,
        ),
        "scala.js",
      )
      .next(
        new PhaseFlavour(input.conversion.flavourImpl, maybePrivateWithin = input.conversion.privateWithin),
        input.conversion.flavour.toString,
      )

    val importedLibs: SortedMap[LibTsSource, PhaseRes[LibTsSource, LibScalaJs]] =
      initial
        .map(s => (s: LibTsSource) -> PhaseRunner(Phases, (_: LibTsSource) => logger, NoListener)(s))
        .toMap
        .toSorted

    PhaseRes.sequenceMap(importedLibs) match {
      case PhaseRes.Ok(LibScalaJs.Unpack(libs: SortedMap[LibTsSource, LibScalaJs])) =>
        /* global because it includes all translated libraries */
        val globalScope = new scalajs.TreeScope.Root(
          input.conversion.outputPackage,
          scalajs.Name.dummy,
          libs.map { case (_, l) => (l.scalaName, l.packageTree) },
          logger,
          false,
        )

        lazy val referencesToKeep: Minimization.KeepIndex = {
          val packagesWithShouldMinimize: IArray[(PackageTree, Boolean)] =
            IArray.fromTraversable(libs).map { case (s, l) => (l.packageTree, minimize(s.libName)) }

          Minimization.findReferences(globalScope, input.minimizeKeep, packagesWithShouldMinimize)
        }

        val outFiles: Map[os.Path, Array[Byte]] =
          libs.par.flatMap {
            case (source, lib) =>
              val willMinimize = minimize(source.libName)
              val minimized =
                if (willMinimize) {
                  Minimization(globalScope, referencesToKeep, logger, lib.packageTree)
                } else lib.packageTree

              val printed = Printer(
                globalScope,
                new ParentsResolver,
                minimized,
                conversion.outputPackage,
                conversion.versions.scala,
              )

              val outFiles = printed.map {
                case (relPath, content) => targetFolder / relPath -> content
              }
              val minimizedMessage = if (willMinimize) "minimized " else ""
              logger.info(
                s"Wrote $minimizedMessage${source.libName.value} (${outFiles.size} files) to $targetFolder...",
              )
              outFiles
          }.seq

        files.syncAbs(outFiles, folder = targetFolder, deleteUnknowns = true, soft = true)

        Right(outFiles.keys.map(_.toIO)(collection.breakOut))

      case PhaseRes.Failure(errors) => Left(errors)
      case PhaseRes.Ignore()        => Right(Set.empty)
    }
  }

  // the only use for this is to debug minimization
  def main(args: Array[String]): Unit = {
    val cacheDir   = constants.defaultCacheFolder
    val outputName = Name.typings

    val conversion = ConversionOptions(
      useScalaJsDomTypes       = true,
      flavour                  = Flavour.Slinky,
      outputPackage            = outputName,
      enableScalaJsDefined     = Selection.All,
      stdLibs                  = SortedSet("es5", "dom"),
      expandTypeMappings       = EnabledTypeMappingExpansion.DefaultSelection,
      ignored                  = SortedSet(),
      versions                 = Versions(Versions.Scala213, Versions.ScalaJs1),
      organization             = "org.scalablytyped",
      enableReactTreeShaking   = Selection.None,
      enableLongApplyMethod    = false,
      privateWithin            = None,
      useDeprecatedModuleNames = false,
    )

    println(
      ImportTypingsGenSources(
        input = Input(
          fromFolder       = InFolder(cacheDir / "npm" / "node_modules"),
          targetFolder     = files.existing(cacheDir / 'work),
          converterVersion = BuildInfo.version,
          conversion       = conversion,
          wantedLibs = SortedMap(
            TsIdentLibrary("typescript") -> "1",
            TsIdentLibrary("csstype") -> "1",
            TsIdentLibrary("@storybook/react") -> "1",
          ),
          minimize     = Selection.AllExcept(TsIdentLibrary("@storybook/react")),
          minimizeKeep = IArray(QualifiedName(IArray(outputName, Name("std"), Name("console")))),
        ),
        logger           = logging.stdout.filter(LogLevel.warn),
        parseCacheDirOpt = Some(cacheDir.toNIO.resolve("parse")),
        cacheDirOpt      = cacheDir,
      ).map(_.size),
    )
  }
}

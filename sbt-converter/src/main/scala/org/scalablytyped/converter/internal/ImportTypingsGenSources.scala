package org.scalablytyped.converter
package internal

import java.io.File
import java.nio.file.Path

import com.olvind.logging
import com.olvind.logging.{LogLevel, Logger}
import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer.Source.TsLibSource
import org.scalablytyped.converter.internal.importer._
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.{ParentsResolver, _}
import org.scalablytyped.converter.internal.ts._

import scala.collection.immutable.SortedMap

object ImportTypingsGenSources {
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

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
    import io.circe013.generic.auto._
    import jsonCodecs._

    implicit val ConfigEncoder: Encoder[Input] = exportEncoder[Input].instance
    implicit val ConfigDecoder: Decoder[Input] = exportDecoder[Input].instance
  }

  def apply(
      input:            Input,
      logger:           Logger[Unit],
      parseCacheDirOpt: Option[Path],
      cacheDirOpt:      os.Path,
  ): Either[Map[Source, Either[Throwable, String]], Set[File]] = {
    import input._

    val fromNodeModules = Source.fromNodeModules(input.fromFolder, input.conversion, input.wantedLibs.keySet)
    logger.warn(s"Importing ${fromNodeModules.sources.map(_.libName.value).mkString(", ")}")

    val cachedParser = PersistingParser(parseCacheDirOpt, fromNodeModules.folders, logger)

    val Phases: RecPhase[Source, LibScalaJs] = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          fromNodeModules.libraryResolver,
          CalculateLibraryVersion.PackageJsonOnly,
          input.conversion.ignoredLibs,
          input.conversion.ignoredModulePrefixes,
          fromNodeModules.stdLibSource,
          pedantic = false,
          cachedParser,
          input.conversion.expandTypeMappings,
        ),
        "typescript",
      )
      .next(
        new Phase2ToScalaJs(
          pedantic             = false,
          enableScalaJsDefined = input.conversion.enableScalaJsDefined,
          outputPkg            = conversion.outputPackage,
          flavour              = input.conversion.flavourImpl,
        ),
        "scala.js",
      )
      .next(new PhaseFlavour(input.conversion.flavourImpl), input.conversion.flavour.toString)

    val importedLibs: SortedMap[Source, PhaseRes[Source, LibScalaJs]] =
      fromNodeModules.sources
        .map(s => s -> PhaseRunner(Phases, (_: Source) => logger, NoListener)(s))
        .toMap
        .toSorted

    PhaseRes.sequenceMap(importedLibs) match {
      case PhaseRes.Ok(LibScalaJs.Unpack(libs: SortedMap[TsLibSource, LibScalaJs])) =>
        /* global because it includes all translated libraries */
        val globalScope = new scalajs.TreeScope.Root(
          input.conversion.outputPackage,
          scalajs.Name.dummy,
          libs.map { case (_, l) => (l.scalaName, l.packageTree) },
          logger,
          false,
        )

        lazy val referencesToKeep: Minimization.KeepIndex =
          Minimization.findReferences(globalScope, input.minimizeKeep, IArray.fromTraversable(libs).map {
            case (s, l) => (minimize(s.libName), l.packageTree)
          })

        val outFiles: Map[os.Path, Array[Byte]] =
          libs.par.flatMap {
            case (source, lib) =>
              val willMinimize = minimize(source.libName)
              val minimized =
                if (willMinimize) {
                  Minimization(globalScope, referencesToKeep, logger, lib.packageTree)
                } else lib.packageTree

              val outFiles = Printer(globalScope, new ParentsResolver, minimized, conversion.outputPackage) map {
                case (relPath, content) => targetFolder / relPath -> content
              }
              val minimizedMessage = if (willMinimize) "minimized " else ""
              logger warn s"Wrote $minimizedMessage${source.libName.value} (${outFiles.size} files) to $targetFolder..."
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
      useScalaJsDomTypes = true,
      Flavour.Slinky,
      outputName,
      Selection.All,
      IArray("es5", "dom"),
      EnabledTypeMappingExpansion.DefaultSelection,
      Set(),
      Set(),
      Versions(Versions.Scala213, Versions.ScalaJs1),
      "org.scalablytyped",
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
        parseCacheDirOpt = Some(cacheDir.toNIO resolve "parse"),
        cacheDirOpt      = cacheDir,
      ).map(_.size),
    )
  }
}

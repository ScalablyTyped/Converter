package org.scalablytyped.converter
package internal

import java.io.File

import com.olvind.logging.{stdout, LogLevel, Logger}
import io.circe.{Decoder, Encoder}
import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.importer.Source.{StdLibSource, TsLibSource}
import org.scalablytyped.converter.internal.importer._
import org.scalablytyped.converter.internal.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.{KeepOnlyReferenced, Printer}
import org.scalablytyped.converter.internal.ts._
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.plugin.{Flavour, PrettyStringType}

import scala.collection.immutable.SortedMap

object ImportTypings {
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  case class Input(
      gitSha:                   String,
      packageJsonHash:          Int,
      npmDependencies:          IArray[(String, String)],
      fromFolder:               InFolder,
      targetFolder:             os.Path,
      chosenFlavour:            Flavour,
      shouldGenerateCompanions: Boolean,
      enableScalaJsDefined:     Selection[TsIdentLibrary],
      prettyStringType:         PrettyStringType,
      libs:                     IArray[String],
      ignore:                   Set[String],
      minimize:                 Selection[TsIdentLibrary],
  )

  object Input {
    import io.circe.generic.auto._
    import jsonCodecs._

    implicit val ConfigEncoder: Encoder[Input] = exportEncoder[Input].instance
    implicit val ConfigDecoder: Decoder[Input] = exportDecoder[Input].instance
  }

  def apply(config: Input, logger: Logger[Unit]): Either[Map[Source, Either[Throwable, String]], Set[File]] = {
    import config._

    val stdLibSource: StdLibSource = {
      val folder = fromFolder.path / "typescript" / "lib"
      StdLibSource(
        InFolder(folder),
        libs.map(s => InFile(folder / s"lib.$s.d.ts")),
        TsIdent.std,
      )
    }
    val flavour = chosenFlavour match {
      case Flavour.Plain        => scalajs.flavours.Flavour.Plain
      case Flavour.Normal       => scalajs.flavours.Flavour.Normal(config.shouldGenerateCompanions)
      case Flavour.Slinky       => scalajs.flavours.Flavour.Slinky(config.shouldGenerateCompanions)
      case Flavour.SlinkyNative => scalajs.flavours.Flavour.SlinkyNative(config.shouldGenerateCompanions)
      case Flavour.Japgolly     => scalajs.flavours.Flavour.Japgolly(config.shouldGenerateCompanions)
    }

    val prettyString = prettyStringType match {
      case PrettyStringType.Regular     => PrettyString.Regular
      case PrettyStringType.Simplifying => PrettyString.Simplifying
    }

    val sources: Set[Source] = findSources(fromFolder.path, npmDependencies) + stdLibSource
    logger.warn(s"Importing ${sources.map(_.libName.value).mkString(", ")}")

    val parseCachePath = os.root / "tmp" / "scalablytyped-sbt-cache" / "parse" / BuildInfo.gitSha.take(6)

    val persistingParser: InFile => Either[String, TsParsedFile] = {
      val pf = PersistingFunction[(InFile, Array[Byte]), Either[String, TsParsedFile]]({
        case (file, bs) => (parseCachePath / file.path.last / bs.hashCode.toString).toNIO
      }, logger) {
        case (inFile, bytes) => parser.parseFileContent(inFile, bytes)
      }
      (inFile: InFile) => pf((inFile, os.read.bytes(inFile.path)))
    }
    val Pipeline: RecPhase[Source, Phase2Res] = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          new LibraryResolver(stdLibSource, IArray(InFolder(fromFolder.path / "@types"), fromFolder), None),
          CalculateLibraryVersion.PackageJsonOnly,
          ignore.map(TsIdentLibrary.apply),
          ignore.map(_.split("/").toList),
          stdLibSource,
          pedantic = false,
          persistingParser,
        ),
        "typescript",
      )
      .next(new Phase2ToScalaJs(pedantic = false, prettyString, enableScalaJsDefined), "scala.js")
      .next(new PhaseFlavour(flavour, prettyString), flavour.toString)

    val importedLibs: SortedMap[Source, PhaseRes[Source, Phase2Res]] =
      sources.par
        .map(s => s -> PhaseRunner(Pipeline, (_: Source) => logger, NoListener)(s))
        .seq
        .toMap
        .toSorted

    PhaseRes.sequenceMap(importedLibs) match {
      case PhaseRes.Ok(Phase2Res.Unpack(libs: SortedMap[TsLibSource, Phase2Res.LibScalaJs], _)) =>
        /* global because it includes all translated libraries */
        val globalScope = new scalajs.TreeScope.Root(
          flavour.outputPkg,
          scalajs.Name.dummy,
          libs.map { case (_, l) => (l.scalaName, l.packageTree) },
          logger,
          false,
        )

        lazy val referencesToKeep: KeepOnlyReferenced.Index =
          KeepOnlyReferenced.findReferences(globalScope, IArray.fromTraversable(libs).map {
            case (s, l) => (minimize(s.libName), l.packageTree)
          })

        val outFiles: Map[os.Path, Array[Byte]] =
          libs.par.flatMap {
            case (source, lib) =>
              val willMinimize = minimize(source.libName)
              val minimized =
                if (willMinimize) {
                  KeepOnlyReferenced(globalScope, referencesToKeep, logger, lib.packageTree)
                } else lib.packageTree

              val outFiles = Printer(globalScope, minimized) map {
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

  /* `npmDependencies` should exist (have been downloaded by npm/yarn) in `fromFolder` */
  def findSources(fromFolder: os.Path, npmDependencies: IArray[(String, String)]): Set[Source] =
    npmDependencies
      .map {
        case (name, _) => Source.FromFolder(InFolder(fromFolder / os.RelPath(name)), TsIdentLibrary(name)): Source
      }
      .groupBy(_.libName)
      .flatMap {
        case (_, sameName) =>
          sameName.find(s => os.walk.stream(s.folder.path, _.last == "node_modules").exists(_.last.endsWith(".d.ts")))
      }
      .to[Set]

  def main(args: Array[String]): Unit = {
    val cacheDir = os.home / "tmp" / "tso-cache"
    println(
      ImportTypings(
        Input(
          "0",
          0,
          IArray(("@storybook/react" -> "1")),
          InFolder(cacheDir / "npm" / "node_modules"),
          files.existing(cacheDir / 'work),
          Flavour.Slinky,
          shouldGenerateCompanions = true,
          enableScalaJsDefined     = Selection.None,
          PrettyStringType.Regular,
          IArray("es5", "dom"),
          Set("typescript", "csstype"),
          minimize = Selection.AllExcept(TsIdentLibrary("@storybook/react"), TsIdentLibrary("node")),
        ),
        stdout.filter(LogLevel.warn),
      ).map(_.size),
    )
  }
}

package org.scalablytyped.converter
package internal

import java.io.File

import com.olvind.logging.{stdout, LogLevel, Logger}
import io.circe.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer.Source.{StdLibSource, TsLibSource}
import org.scalablytyped.converter.internal.importer._
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.{Minimization, Name, Printer, QualifiedName}
import org.scalablytyped.converter.internal.scalajs.flavours.{Flavour => InternalFlavour}
import org.scalablytyped.converter.internal.ts._
import org.scalajs.sbtplugin.ScalaJSCrossVersion

import scala.collection.immutable.SortedMap

object ImportTypings {
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  case class Input(
      version:              String,
      packageJsonHash:      String,
      npmDependencies:      IArray[(String, String)],
      fromFolder:           InFolder,
      targetFolder:         os.Path,
      flavour:              InternalFlavour,
      enableScalaJsDefined: Selection[TsIdentLibrary],
      libs:                 IArray[String],
      ignore:               Set[String],
      minimize:             Selection[TsIdentLibrary],
      minimizeKeep:         IArray[QualifiedName],
  )

  object Input {
    import io.circe.generic.auto._
    import jsonCodecs._

    implicit val ConfigEncoder: Encoder[Input] = exportEncoder[Input].instance
    implicit val ConfigDecoder: Decoder[Input] = exportDecoder[Input].instance
  }

  def apply(
      config:      Input,
      logger:      Logger[Unit],
      cacheDirOpt: Option[os.Path],
  ): Either[Map[Source, Either[Throwable, String]], Set[File]] = {
    import config._

    val stdLibSource: StdLibSource = {
      val folder = fromFolder.path / "typescript" / "lib"
      StdLibSource(
        InFolder(folder),
        libs.map(s => InFile(folder / s"lib.$s.d.ts")),
        TsIdent.std,
      )
    }

    val sources: Set[Source] = findSources(fromFolder.path, npmDependencies) + stdLibSource
    logger.warn(s"Importing ${sources.map(_.libName.value).mkString(", ")}")

    def cachePath(base: os.Path, function: String) =
      base / function / s"${BuildInfo.version}_${ScalaJSCrossVersion.currentBinaryVersion}"

    val cachedParser: InFile => Either[String, TsParsedFile] =
      cacheDirOpt match {
        case Some(cacheDir) =>
          val pf = PersistingFunction[(InFile, Array[Byte]), Either[String, TsParsedFile]]({
            case (file, bs) =>
              val base = cachePath(cacheDir, "parse") / file.path.relativeTo(config.fromFolder.path)
              (base / Digest.of(List(bs)).hexString).toNIO
          }, logger) {
            case (inFile, bytes) => parser.parseFileContent(inFile, bytes)
          }
          inFile => pf((inFile, os.read.bytes(inFile.path)))
        case None =>
          inFile => parser.parseFileContent(inFile, os.read.bytes(inFile.path))
      }

    val Phases: RecPhase[Source, Phase2Res] = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          new LibraryResolver(stdLibSource, IArray(InFolder(fromFolder.path / "@types"), fromFolder), None),
          CalculateLibraryVersion.PackageJsonOnly,
          ignore.map(TsIdentLibrary.apply),
          ignore.map(_.split("/").toList),
          stdLibSource,
          pedantic = false,
          cachedParser,
        ),
        "typescript",
      )
      .next(new Phase2ToScalaJs(pedantic = false, enableScalaJsDefined, outputPkg = Name.typings), "scala.js")
      .next(new PhaseFlavour(flavour), flavour.toString)

    val importedLibs: SortedMap[Source, PhaseRes[Source, Phase2Res]] =
      sources
        .map(s => s -> PhaseRunner(Phases, (_: Source) => logger, NoListener)(s))
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

        lazy val referencesToKeep: Minimization.KeepIndex =
          Minimization.findReferences(globalScope, config.minimizeKeep, IArray.fromTraversable(libs).map {
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
    val cacheDir   = os.home / "tmp" / "tso-cache"
    val outputName = Name("typings")

    println(
      ImportTypings(
        Input(
          "0",
          "0xA",
          IArray(("@storybook/react" -> "1")),
          InFolder(cacheDir / "npm" / "node_modules"),
          files.existing(cacheDir / 'work),
          InternalFlavour.Slinky(shouldGenerateCompanions = true, outputName),
          enableScalaJsDefined = Selection.None,
          IArray("es5", "dom"),
          Set("typescript", "csstype"),
          minimize     = Selection.AllExcept(TsIdentLibrary("@storybook/react"), TsIdentLibrary("node")),
          minimizeKeep = IArray(QualifiedName(IArray(outputName, Name("std"), Name("console")))),
        ),
        stdout.filter(LogLevel.warn),
        Some(cacheDir / 'work / 'cache),
      ).map(_.size),
    )
  }
}

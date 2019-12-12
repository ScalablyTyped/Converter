package com.olvind.tso
package plugin

import com.olvind.logging.{LogLevel, Logger, stdout}
import com.olvind.tso.importer.Source.{StdLibSource, TsLibSource}
import com.olvind.tso.importer._
import com.olvind.tso.maps._
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.scalajs.{KeepOnlyReferenced, Printer}
import com.olvind.tso.ts._
import io.circe.{Decoder, Encoder}
import sbt.File

import scala.collection.immutable.SortedMap

object ImportTypings {
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  case class Input(
      packageJsonHash: Int,
      npmDependencies: Seq[(String, String)],
      fromFolder:      InFolder,
      targetFolder:    os.Path,
      chosenFlavour:   Flavour,
      libs:            List[String],
      ignore:          Set[String],
      minimize:        Selection[TsIdentLibrary],
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
      case Flavour.Plain    => com.olvind.tso.scalajs.flavours.Flavour.Plain
      case Flavour.Normal   => com.olvind.tso.scalajs.flavours.Flavour.Normal
      case Flavour.Slinky   => com.olvind.tso.scalajs.flavours.Flavour.Slinky
      case Flavour.Japgolly => com.olvind.tso.scalajs.flavours.Flavour.Japgolly
    }

    val sources: Set[Source] = findSources(fromFolder.path, npmDependencies) + stdLibSource
    logger.warn(s"Importing ${sources.map(_.libName.value).mkString(", ")}")

    val parseCachePath = os.root / "tmp" / "tso-sbt-cache" / "parse"

    val persistingParser: InFile => Either[String, TsParsedFile] = {
      val pf = PersistingFunction[(InFile, Array[Byte]), Either[String, TsParsedFile]]({
        case (file, bs) => parseCachePath / file.path.last / bs.hashCode.toString
      }, logger) {
        case (inFile, bytes) => parser.parseFileContent(inFile, bytes)
      }
      (inFile: InFile) => pf((inFile, os.read.bytes(inFile.path)))
    }
    val Pipeline: RecPhase[Source, Phase2Res] = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          new LibraryResolver(stdLibSource, Seq(InFolder(fromFolder.path / "@types"), fromFolder), None),
          CalculateLibraryVersion.PackageJsonOnly,
          ignore.map(TsIdentLibrary.apply),
          ignore.map(_.split("/").toList),
          stdLibSource,
          pedantic = false,
          persistingParser,
        ),
        "typescript",
      )
      .next(new Phase2ToScalaJs(pedantic = false), "scala.js")
      .next(new PhaseFlavour(flavour), flavour.toString)

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
          KeepOnlyReferenced.findReferences(globalScope, libs.to[Seq].map {
            case (s, l) => (minimize(s.libName), l.packageTree)
          })

        val outFiles: Map[os.Path, Array[Byte]] =
          libs.par.flatMap {
            case (source, lib) =>
              val minimized =
                if (minimize(source.libName)) {
                  globalScope.logger.warn(s"Minimizing ${source.libName.value}")
                  KeepOnlyReferenced(globalScope, referencesToKeep, logger, lib.packageTree)
                } else lib.packageTree

              val outFiles = Printer(globalScope, minimized) map {
                case (relPath, content) => targetFolder / relPath -> content
              }
              logger warn s"Writing ${source.libName.value} (${outFiles.size} files) to $targetFolder..."
              outFiles
          }.seq

        files.syncAbs(outFiles, folder = targetFolder, deleteUnknowns = true, soft = true)

        Right(outFiles.keys.map(_.toIO)(collection.breakOut))

      case PhaseRes.Failure(errors) => Left(errors)
      case PhaseRes.Ignore()        => Right(Set.empty)
    }
  }

  /* `npmDependencies` should exist (have been downloaded by npm/yarn) in `fromFolder` */
  def findSources(fromFolder: os.Path, npmDependencies: Seq[(String, String)]): Set[Source] =
    npmDependencies
      .map {
        case (name, _) => Source.FromFolder(InFolder(fromFolder / os.RelPath(name)), TsIdentLibrary(name)): Source
      }
      .groupBy(_.libName)
      .flatMap {
        case (_, sameName) =>
          sameName.find(s => os.walk.stream(s.folder.path, _.last === "node_modules").exists(_.last.endsWith(".d.ts")))
      }
      .to[Set]

  def main(args: Array[String]): Unit = {
    val tsoCache = os.home / "tmp" / "tso-cache"
    println(
      ImportTypings(
        Input(
          0,
          List(("@storybook/react" -> "1")),
          InFolder(tsoCache / "npm" / "node_modules"),
          files.existing(tsoCache / 'work),
          Flavour.Slinky,
          List("es5", "dom"),
          Set("typescript", "csstype"),
          minimize = Selection.AllExcept(TsIdentLibrary("@storybook/react"), TsIdentLibrary("node")),
        ),
        stdout.filter(LogLevel.warn),
      ).map(_.size),
    )
  }
}

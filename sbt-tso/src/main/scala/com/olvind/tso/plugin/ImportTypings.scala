package com.olvind.tso
package plugin

import com.olvind.logging.{stdout, LogLevel, Logger}
import com.olvind.tso.importer.Source.{StdLibSource, TsLibSource}
import com.olvind.tso.importer._
import com.olvind.tso.maps._
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.scalajs.{KeepOnlyReferenced, Printer, QualifiedName}
import com.olvind.tso.ts._
import sbt.File

import scala.collection.immutable.SortedMap

object ImportTypings {
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  def apply(
      npmDependencies: Seq[(String, String)],
      fromFolder:      InFolder,
      targetFolder:    os.Path,
      logger:          Logger[Unit],
      reactBinding:    ReactBinding,
      libs:            List[String],
      ignore:          Set[TsIdentLibrary],
      minimize:        Selection[TsIdentLibrary],
  ): Either[Map[Source, Either[Throwable, String]], Set[File]] = {

    val stdLibSource: Source = {
      val folder = fromFolder.path / "typescript" / "lib"
      StdLibSource(
        InFolder(folder),
        libs.map(s => InFile(folder / s"lib.$s.d.ts")),
        TsIdent.std,
      )
    }

    val binding = reactBinding match {
      case ReactBinding.Native   => List(com.olvind.tso.scalajs.react.ReactBinding.native)
      case ReactBinding.Slinky   => List(com.olvind.tso.scalajs.react.ReactBinding.slinky)
      case ReactBinding.Japgolly => List(com.olvind.tso.scalajs.react.ReactBinding.japgolly)
    }

    val sources: Set[Source] = findSources(fromFolder.path, npmDependencies) + stdLibSource
    logger.warn(s"Importing ${sources.map(_.libName.value).mkString(", ")}")

    val Pipeline: RecPhase[Source, Phase2Res] = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          new LibraryResolver(stdLibSource, Seq(InFolder(fromFolder.path / "@types"), fromFolder), None),
          None,
          ignore,
          stdLibSource,
          pedantic = false,
          parser.parseFile,
        ),
        "typescript",
      )
      .next(new Phase2ToScalaJs(pedantic = false, binding), "scala.js")

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
          scalajs.Name.dummy,
          libs.map { case (_, l) => (l.scalaName, l.packageTree) },
          logger,
          false,
        )

        lazy val referencesToKeep: Set[QualifiedName] =
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
        case (_, sameName) => sameName.find(s => os.walk.stream(s.folder.path).exists(_.last.endsWith(".d.ts")))
      }
      .to[Set]

  def main(args: Array[String]): Unit = {
    val tsoCache = os.home / "tmp" / "tso-cache"
    println(
      ImportTypings(
        List(("semantic-ui-react" -> "1"), ("@material-ui/core" -> "1")),
        InFolder(tsoCache / "npm" / "node_modules"),
        Main.existing(tsoCache / 'work),
        stdout.filter(LogLevel.warn),
        ReactBinding.Slinky,
        List("es5", "dom"),
        Set(TsIdentLibrary("typescript")),
        minimize = Selection.AllExcept(TsIdentLibrarySimple("react-dom")),
      ).map(_.size),
    )
  }
}

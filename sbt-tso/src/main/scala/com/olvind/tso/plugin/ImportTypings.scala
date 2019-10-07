package com.olvind.tso
package plugin

import com.olvind.logging.{LogLevel, Logger, stdout}
import com.olvind.tso.importer.Source.{StdLibSource, TsLibSource}
import com.olvind.tso.importer._
import com.olvind.tso.maps._
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.scalajs.{PackageTree, Printer, QualifiedName}
import com.olvind.tso.ts._
import sbt.File

import scala.collection.immutable.SortedMap

object ImportTypings {
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  def main(args: Array[String]): Unit = {
    val tsoCache = os.home / "tmp" / "tso-cache"
    println(
      runImport(
        List(("semantic-ui-react" -> "1"), ("@material-ui/core" -> "1")),
        InFolder(tsoCache / "npm" / "node_modules"),
        Main.existing(tsoCache / 'work),
        stdout.filter(LogLevel.warn),
        ReactBindingSlinky,
        List("es5", "dom"),
      ).map(_.size),
    )
  }

  def runImport(
      npmDependencies: Seq[(String, String)],
      fromFolder:      InFolder,
      targetFolder:    os.Path,
      logger:          Logger[Unit],
      reactBinding:    ReactBinding,
      libs:            List[String],
  ): Either[Map[Source, Either[Throwable, String]], Seq[File]] = {

    val stdLibSource: Source = {
      val folder = fromFolder.path / "typescript" / "lib"
      StdLibSource(
        InFolder(folder),
        libs.map(s => InFile(folder / s"lib.${s}.d.ts")),
        TsIdent.std,
      )
    }

    val binding = reactBinding match {
      case ReactBindingNative   => None
      case ReactBindingSlinky   => Option(com.olvind.tso.importer.ReactBinding.slinky)
      case ReactBindingJagpolly => Option(com.olvind.tso.importer.ReactBinding.scalajsReact)
    }

    val sources: Set[Source] = findSources(fromFolder.path, npmDependencies) + stdLibSource

    sources.foreach(src => println(s">>>>>>>>>>>>>>>>>>>>>>>>> ${src}"))

    val Pipeline: RecPhase[Source, Phase2Res] = RecPhase[Source]
      .next(
        new Phase1ReadTypescript(
          new LibraryResolver(stdLibSource, Seq(InFolder(fromFolder.path / "@types"), fromFolder), None),
          None,
          Set.empty,
          stdLibSource,
          pedantic = false,
          parser.parseFile,
        ),
        "typescript",
      )
      .next(new Phase2ToScalaJs(pedantic = false, binding), "scala.js")

    val importedLibs: SortedMap[Source, PhaseRes[Source, Phase2Res]] =
      sources
        .map(s => s -> PhaseRunner(Pipeline, (_: Source) => logger, NoListener)(s))
        .toMap
        .toSorted

    PhaseRes.sequenceMap(importedLibs) match {
      case PhaseRes.Ok(Phase2Res.Unpack(libs: SortedMap[TsLibSource, Phase2Res.LibScalaJs], _)) =>
        /* global because it includes all translated libraries */
        val globalScope = new scalajs.TreeScope.Root(
          scalajs.Name.dummy,
          libs.map { case (_, l) => (l.scalaName, l.packageTree) },
          stdout,
          false,
        )

        val referencesToKeep: Set[QualifiedName] =
          KeepOnlyReferenced.findReferences(globalScope, libs).to[Set]

        val trimmedLibs: Map[TsLibSource, PackageTree] =
          libs.map {
            case (source, lib) =>
              source -> KeepOnlyReferenced(globalScope, referencesToKeep, logger, lib.packageTree)
          }

        val outFiles: Map[os.Path, Array[Byte]] =
          trimmedLibs
            .flatMap {
              case (source, lib) =>
                val outFiles = Printer(globalScope, lib) map { case (relPath, content) => targetFolder / relPath -> content }
                logger warn s"Writing ${source.libName.value} (${outFiles.size} files) to $targetFolder..."
                outFiles
            }

        files.syncAbs(outFiles, folder = targetFolder, deleteUnknowns = true, soft = true)

        Right(outFiles.keys.map(_.toIO)(collection.breakOut))

      case PhaseRes.Failure(errors) => Left(errors)
      case PhaseRes.Ignore()        => Right(Nil)
    }
  }

  /* `npmDependencies` should exist (have been downloaded by npm/yarn) in `fromFolder` */
  def findSources(fromFolder: os.Path, npmDependencies: Seq[(String, String)]): Set[Source] =
    npmDependencies
      .map {
        case (name, _) =>
          val libName = TsIdentLibrary(name) match {
            case TsIdentLibraryScoped("types", Some(value)) => TsIdentLibrarySimple(value)
            case other                                      => other
          }

          Source.FromFolder(InFolder(fromFolder / os.RelPath(name)), libName): Source
      }
      .groupBy(_.libName)
      .flatMap {
        /* we require this to get the std definitins, but it's unlikely that a user wants it.
         * might provide an escape hatch in that rare case.
         */
        case (TsIdentLibrarySimple("typescript"), _) =>
          None
        case (_, sameName) =>
          sameName.find(s => os.walk.stream(s.folder.path).exists(_.last.endsWith(".d.ts")))
      }
      .to[Set]

}

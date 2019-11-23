package com.olvind.tso
package plugin

import com.olvind.logging.LogLevel
import com.olvind.tso.importer.Source.StdLibSource
import com.olvind.tso.importer._
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.seqs._
import com.olvind.tso.ts._
import os.Path
import sbt.Keys._
import sbt._
import sbt.internal.util.ManagedLogger
import sbt.plugins.JvmPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

sealed trait ReactBinding

object ReactBindingNative extends ReactBinding

object ReactBindingSlinky extends ReactBinding

object ReactBindingJagpolly extends ReactBinding

object TsoPlugin extends AutoPlugin {
  object autoImport {
    val tsoImport     = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val tsoReactBinding      = settingKey[ReactBinding]("The type of react binding to use")
    val tsoPedantic          = settingKey[Boolean]("How harsh to be")
    val tsoTypescriptVersion = settingKey[String]("The version of the typescript library that it should use")

    import ScalaJSBundlerPlugin.autoImport._

    lazy val baseTSOImportSettings: Seq[Def.Setting[_]] = Seq(
      //Make sure we always include the stdlib
      npmDependencies in Compile ++= {
        //Make sure it doesn't already exist
        (npmDependencies in Compile).value
          .find(_._1 == "typescript")
          .fold(Seq("typescript" -> (tsoTypescriptVersion).value))(_ => Seq.empty)
      },
      tsoReactBinding := ReactBindingNative,
      tsoTypescriptVersion := "3.6.3",
      tsoImport := {
        println(s">>>>>>>>>>>>>>>>>>>>>>>>> Using ${(tsoReactBinding).value} value")

        //TODO check to see if nothing has changed, if nothing has changed, then do nothing.
        ImportTypings(
          npmDependencies = (npmDependencies in Compile).value.to[Seq],
          npmDirectory    = (npmInstallDependencies in Compile).value,
          target          = (sourceManaged in Compile).value / "tso",
          reactBinding    = (tsoReactBinding).value,
          sbtLogger       = streams.value.log,
        )
      },
      sourceGenerators in Compile += tsoImport.taskValue,
    )
  }

  import autoImport._
  override def requires = JvmPlugin && ScalaJSBundlerPlugin

  override def trigger = allRequirements

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] = inConfig(Compile)(baseTSOImportSettings)

  override lazy val buildSettings: Seq[Nothing] = Seq()

  override lazy val globalSettings: Seq[Nothing] = Seq()

}

object ImportTypings {
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  private def runImport(
      npmDependencies: Seq[(String, String)],
      source:          InFolder,
      targetFolder:    os.Path,
      sbtLogger:       ManagedLogger,
      reactBinding:    ReactBinding,
  ): Either[Map[Source, List[Either[Throwable, String]]], Seq[File]] = {

    val stdLibSource: Source =
      StdLibSource(
        InFile(source.path / "typescript" / "lib" / "lib.esnext.full.d.ts"),
        TsIdent.std,
      )

    val binding = reactBinding match {
      case ReactBindingNative   => None
      case ReactBindingSlinky   => Option(com.olvind.tso.importer.ReactBinding.slinky)
      case ReactBindingJagpolly => Option(com.olvind.tso.importer.ReactBinding.scalajsReact)
    }

    val phase: RecPhase[Source, Map[Source, Seq[os.Path]]] =
      RecPhase[Source]
        .next(
          new Phase1ReadTypescript(
            new LibraryResolver(stdLibSource, Seq(InFolder(source.path / "@types"), source), None),
            None,
            Set.empty,
            stdLibSource,
            pedantic = false,
            parser.parseFile,
          ),
          "typescript",
        )
        .next(new Phase2ToScalaJs(pedantic = false, binding), "scala.js")
        .next(new Phase3WriteFiles(targetFolder = targetFolder, softWrites = false), "build")

    val sources: Set[Source] =
      npmDependencies
        .map {
          case (name, _) =>
            val libName = TsIdentLibrary(name) match {
              case TsIdentLibraryScoped("types", Some(value)) => TsIdentLibrarySimple(value)
              case other                                      => other
            }

            Source.FromFolder(InFolder(source.path / os.RelPath(name)), libName): Source
        }
        .groupBy(_.libName)
        .flatMap {
          case (TsIdentLibrarySimple("typescript"), _) => None
          case (_, sameName)                           => sameName.find(s => os.walk(s.folder.path).exists(_.last.endsWith(".d.ts")))
        }
        .to[Set] + stdLibSource

    sources.foreach(src => println(s">>>>>>>>>>>>>>>>>>>>>>>>> ${src}"))

    sources
      .map(PhaseRunner(phase, (s: Source) => WrapSbtLogger(sbtLogger)(s).filter(LogLevel.warn).void, NoListener))
      .to[Seq]
      .partitionCollect2({ case PhaseRes.Failure(x) => x }, { case PhaseRes.Ok(x) => x }) match {
      case (Nil, filesBySource: Seq[Map[Source, Seq[Path]]], _) =>
        Right(maps.smash(filesBySource).foldLeft(Seq.empty[File]) { _ ++ _._2.map(_.toIO) })
      case (errors, _, _) => Left(maps.sum(errors))
    }
  }

  def apply(
      npmDependencies: Seq[(String, String)],
      npmDirectory:    File,
      target:          File,
      reactBinding:    ReactBinding,
      sbtLogger:       ManagedLogger,
  ): Seq[File] =
    runImport(
      npmDependencies,
      InFolder(os.Path(npmDirectory / "node_modules")),
      os.Path(target),
      sbtLogger,
      reactBinding,
    ) match {
      case Right(files) => files
      case Left(errors) =>
        errors foreach System.err.println
        Nil
    }
}

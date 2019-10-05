package com.olvind.tso
package plugin

import com.olvind.logging
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.Source.StdLibSource
import com.olvind.tso.importer._
import com.olvind.tso.maps._
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.ts.{parser, TsIdent, TsIdentLibrary, TsIdentLibrarySimple}
import os.Path
import sbt.Keys._
import sbt.{Def, _}
import sbt.plugins.JvmPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

import scala.collection.immutable.SortedMap

object ReactBinding extends Enumeration {
  val native, slinky, jagpolly = Value
}

object TsoPlugin extends AutoPlugin {

  override def trigger = allRequirements

  override def requires = JvmPlugin && ScalaJSBundlerPlugin

  object autoImport {
    val importTypings     = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val reactBinding      = settingKey[ReactBinding.Value]("The type of react binding to use")
    val pedantic          = settingKey[Boolean]("How harsh to be")
    val typescriptVersion = settingKey[String]("The version of the typescript library that it should use")

    import ScalaJSBundlerPlugin.autoImport._

    lazy val tsoPluginSettings: Seq[Def.Setting[_]] = Seq(
      //Make sure we always include the stdlib
      npmDependencies in Compile ++= {
        //Make sure it doesn't already exist
        (npmDependencies in Compile).value
          .find(_._1 == "typescript")
          .fold(Seq("typescript" -> (typescriptVersion in importTypings).value))(_ => Seq.empty)
      },
      importTypings := {
        //TODO check to see if nothing has changed, if nothing has changed, then do nothing.

        val npmDirectory = os.Path((npmInstallDependencies in Compile).value.getAbsolutePath)

        val target = os.Path(((sourceManaged in Compile).value / "tso").getAbsolutePath)

        val returnedFiles = ImportTyping(
          (npmDependencies in Compile).value,
          npmDirectory,
          target,
          (reactBinding in importTypings).value,
          (pedantic in importTypings).value,
        ).map(_.toIO)

        println("Returned files")
        println(returnedFiles.map(_.absolutePath).mkString("\n")) //We're obviously not returning all the files

        returnedFiles.to[scala.collection.immutable.Seq]
      },
      reactBinding in importTypings := ReactBinding.native,
      pedantic in importTypings := false,
      typescriptVersion in importTypings := "3.6.3",
      sourceGenerators in Compile += importTypings.taskValue,
    )
  }

  import autoImport._

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] = inConfig(Compile)(tsoPluginSettings)

  override lazy val buildSettings: Seq[Nothing] = Seq()

  override lazy val globalSettings: Seq[Nothing] = Seq()

}

object ImportTyping {
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  private def runImport(
      npmDependencies: scala.Seq[(String, String)],
      source:          InFolder,
      targetFolder:    os.Path,
      pedantic:        Boolean,
      logRegistry:     LogRegistry[Source, TsIdentLibrary, _],
  ): PhaseRes[Source, SortedMap[Source, Iterable[Path]]] = {

    val stdLibSource: Source =
      StdLibSource(
        InFile(source.path / "typescript" / "lib" / "lib.esnext.full.d.ts"),
        TsIdent.std,
      )

    val phase =
      RecPhase[Source]
        .next(
          new Phase1ReadTypescript(
            new LibraryResolver(stdLibSource, Seq(source), None),
            None,
            Set.empty,
            stdLibSource,
            pedantic,
            parser.parseFile,
          ),
          "typescript",
        )
        .next(new Phase2ToScalaJs(pedantic), "scala.js")
        .next(new Phase3WriteFiles(targetFolder = targetFolder, softWrites = false), "build")

    val found: Set[Source] = npmDependencies.map(
      tuple => Source.FromFolder(InFolder(source.path / os.RelPath(tuple._1)), TsIdentLibrarySimple(tuple._1)),
    )(collection.breakOut)

    found.foreach(src => println(s">>>>>>>>>>>>>>>>>>>>>>>>> ${src.path}"))

    PhaseRes.sequenceMap(found.map(s => s -> PhaseRunner(phase, logRegistry.get, NoListener)(s)).toMap.toSorted)
  }

  def apply(
      npmDependencies: scala.Seq[(String, String)],
      npmDirectory:    os.Path,
      target:          os.Path,
      reactBinding:    ReactBinding.Value,
      pedantic:        Boolean,
  ): Iterable[os.Path] = {

    //TODO integrate reactBinding here.
    val logRegistry = new LogRegistry[Source, TsIdentLibrary, Unit](
      logging.stdout.filter(LogLevel.warn).syncAccess.void,
      _.libName,
      _ => logging.storing(),
    )
    //TODO Here's what the plugin should do
    //TODO run npm on a set of projects
    //TODO run the importer on those projects
    //TODO compile the results of the importer

    runImport(
      npmDependencies,
      InFolder(npmDirectory / "node_modules"),
      target,
      pedantic,
      logRegistry,
    ) match {
      case PhaseRes.Ok(files) =>
        files.flatMap(_._2)
      case PhaseRes.Failure(errors) =>
        errors foreach System.err.println
        Nil
      case PhaseRes.Ignore() =>
        Nil
    }
  }
}

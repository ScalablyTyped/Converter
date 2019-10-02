package com.olvind.tso.plugin

import java.io.StringWriter

import com.olvind.logging
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.Source.TsLibSource
import com.olvind.tso.importer._
import com.olvind.tso.importer.build.{BloopCompiler, PublishedSbtProject, Versions}
import com.olvind.tso.importer.documentation.Npmjs
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.ts.{TsIdentLibrary, TsIdentLibrarySimple, parser}
import com.olvind.tso.{InFile, InFolder, Seq, Set}
import os.Path
import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin

import scala.collection.immutable.{SortedMap, TreeMap}
import scala.concurrent.ExecutionContext

object ReactBinding extends Enumeration {
  type ReactBinding = Value
  val native, slinky, jagpolly = Value
}
import com.olvind.tso.plugin.ReactBinding._

object TsoPlugin extends AutoPlugin {

  override def trigger = allRequirements
  override def requires = JvmPlugin && scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

  object autoImport {
    val importTypings = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val reactBinding = settingKey[ReactBinding]("The type of react binding to use")
    val pedantic = settingKey[Boolean]("How harsh to be")

    lazy val tsoPluginSettings: Seq[Def.Setting[_]] = Seq(
      importTypings := {
        ImportTyping(sources.value.to[collection.immutable.Seq], (reactBinding in importTypings).value, (pedantic in importTypings).value)
      },
      reactBinding in importTypings := ReactBinding.native,
      pedantic in importTypings := false
    )
  }

  import autoImport._

  override lazy val projectSettings = inConfig(Compile)(tsoPluginSettings)


  override lazy val buildSettings = Seq()

  override lazy val globalSettings = Seq()

}

object ImportTyping {
  val failureCacheDir = os.root / 'tmp / 'tso / 'compileFailures
  os.makeDir.all(failureCacheDir)
  private val testLogger = logging.stdout.filter(LogLevel.error)
  private val testCmd = new Cmd(testLogger, None)
  private val version = Versions.`scala 2.13 with scala.js 1`
  private val bloop = BloopCompiler(testLogger, version, ExecutionContext.Implicits.global, failureCacheDir)
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  private def runImport(source: InFolder,
                        targetFolder: os.Path,
                        pedantic: Boolean,
                        logRegistry: LogRegistry[Source, TsIdentLibrary, StringWriter],
                        publishFolder: os.Path,
                       ): PhaseRes[Source, SortedMap[Source, PublishedSbtProject]] = {
    val stdLibSource: Source =
      Source.StdLibSource(InFile(source.path / "stdlib.d.ts"), TsIdentLibrarySimple("std"))

    val resolve = new LibraryResolver(stdLibSource, Seq(source), None)
    val lastChangedIndex = RepoLastChangedIndex(testCmd, source.path)

    val phase: RecPhase[Source, PublishedSbtProject] =
      RecPhase[Source]
        .next(
          new Phase1ReadTypescript(
            resolve,
            new CalculateLibraryVersion(lastChangedIndex, "test"),
            Set.empty,
            stdLibSource,
            pedantic,
            parser.parseFile,
          ),
          "typescript",
        )
        .next(new Phase2ToScalaJs(pedantic), "scala.js")
        .next(
          new Phase3Compile(
            resolve = resolve,
            versions = version,
            compiler = bloop,
            targetFolder = targetFolder,
            projectName = "ScalablyTyped",
            organization = "org.scalablytyped",
            publishUser = "oyvindberg",
            publishFolder = publishFolder,
            metadataFetcher = Npmjs.No,
            softWrites = false,
          ),
          "build",
        )

    val found: Set[TsLibSource] =
      TypescriptSources.forFolder(InFolder(source.path), Set.empty)

    PhaseRes.sequenceMap(
      TreeMap.empty[TsLibSource, PhaseRes[Source, PublishedSbtProject]] ++ found
        .map(s => s -> PhaseRunner(phase, logRegistry.get, NoListener)(s)),
    )
  }

  def apply(sources: scala.collection.immutable.Seq[java.io.File], reactBinding: ReactBinding, pedantic: Boolean): scala.collection.immutable.Seq[File] = {
    println("==============> Doing the import thing here")
    var sourceDir: InFolder = ???
    var targetDir: Path = ???
    var logRegistry: LogRegistry[Source, TsIdentLibrary, StringWriter] = ???
    var publishFolder: Path = ???
    //TODO Here's what the plugin should do
    //TODO run npm on a set of projects
    //TODO run the importer on those projects
    //TODO compile the results of the importer
    runImport(sourceDir, targetDir, pedantic, logRegistry, publishFolder) match {

      case PhaseRes.Ok(value) =>
      case PhaseRes.Failure(errors) =>
      case PhaseRes.Ignore() =>
    }

    sources
  }
}


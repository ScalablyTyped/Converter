package com.olvind.tso.plugin

import com.olvind.logging
import com.olvind.logging.Logger.Stored
import com.olvind.logging.{LogLevel, LogRegistry}
import com.olvind.tso.importer.Source.{StdLibSource, TsLibSource}
import com.olvind.tso.importer._
import com.olvind.tso.importer.build.{BloopCompiler, PublishedSbtProject, Versions}
import com.olvind.tso.importer.documentation.Npmjs
import com.olvind.tso.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import com.olvind.tso.ts.{TsIdent, TsIdentLibrary, TsIdentLibrarySimple, parser}
import com.olvind.tso.{InFile, InFolder}
import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

import scala.collection.immutable.{SortedMap, TreeMap}
import scala.concurrent.ExecutionContext

object ReactBinding extends Enumeration {
  type ReactBinding = Value
  val native, slinky, jagpolly = Value
}
import com.olvind.tso.plugin.ReactBinding._

object TsoPlugin extends AutoPlugin {

  override def trigger = allRequirements

  override def requires = JvmPlugin && ScalaJSBundlerPlugin

  object autoImport {
    val importTypings = taskKey[Seq[File]]("Imports all the bundled npm and generates bindings")
    val reactBinding = settingKey[ReactBinding]("The type of react binding to use")
    val pedantic = settingKey[Boolean]("How harsh to be")

    import ScalaJSBundlerPlugin.autoImport._

    lazy val tsoPluginSettings: Seq[Def.Setting[_]] = Seq(
      npmDependencies in Compile += "typescript" -> "3.6.3", //Make sure we always include the stdlib //TODO make the version a parameter
      importTypings := {
        val npmDirectory = better.files.File((npmInstallDependencies in Compile).value.getAbsolutePath)

        val target = better.files.File(((sourceManaged in Compile).value / "tso").getAbsolutePath)

        println(s"====================================== npmDirectory       ${npmDirectory}")
        println(s"====================================== npmDevDependencies ${(npmDevDependencies in Compile).value}")
        println(s"====================================== npmDependencies    ${(npmDependencies in Compile).value}")
        println(s"====================================== npmResolutions     ${(npmResolutions in Compile).value}")
        //        printDir(npmDirectory, "")

        ImportTyping((npmDependencies in Compile).value, npmDirectory, target, (reactBinding in importTypings).value, (pedantic in importTypings).value).map(_.toJava)
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
  val failureCacheDir = os.root / 'tmp / 'tso / 'compileFailures //TODO change this
  os.makeDir.all(failureCacheDir)
  private val testLogger = logging.stdout.filter(LogLevel.error)
  private val testCmd = new Cmd(testLogger, None)
  private val version = Versions.`scala 2.13 with scala.js 1`
  private val bloop = BloopCompiler(testLogger, version, ExecutionContext.Implicits.global, failureCacheDir)
  val NoListener: PhaseListener[Source] = (_, _, _) => ()

  private def runImport(npmDependencies: scala.Seq[(String, String)],
                        source: InFolder,
                        targetFolder: os.Path,
                        pedantic: Boolean,
                        logRegistry: LogRegistry[Source, TsIdentLibrary, _],
                        publishFolder: os.Path,
                       ): PhaseRes[Source, SortedMap[Source, PublishedSbtProject]] = {

    val stdLibSource: Source =
      StdLibSource(
        InFile(source.path / "typescript" / "lib" / "lib.esnext.full.d.ts"),
        TsIdent.std,
      )

    val libraryResolver = new LibraryResolver(stdLibSource, Seq(source), None)
    val phase: RecPhase[Source, PublishedSbtProject] =
      RecPhase[Source]
        .next(
          new Phase1ReadTypescript(
            libraryResolver,
            None,
            Set.empty,
            stdLibSource,
            pedantic,
            parser.parseFile,
          ),
          "typescript",
        )
        .next(new Phase2ToScalaJs(pedantic), "scala.js")
        .next(
          new Phase3WriteFiles(
            resolve = libraryResolver,
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

    val found: Set[TsLibSource] = npmDependencies.map(tuple =>
      Source.FromFolder(InFolder(source.path / tuple._1), TsIdentLibrarySimple(tuple._1))
    )(collection.breakOut)

    found.foreach(src => println(s">>>>>>>>>>>>>>>>>>>>>>>>> ${src.path}"))

    PhaseRes.sequenceMap(
      TreeMap.empty[TsLibSource, PhaseRes[Source, PublishedSbtProject]] ++ found
        .map(s => s -> PhaseRunner(phase, logRegistry.get, NoListener)(s)),
    )
  }

  def apply(npmDependencies: scala.Seq[(String, String)], npmDirectory: better.files.File, target: better.files.File, reactBinding: ReactBinding, pedantic: Boolean): Seq[better.files.File] = {
    val logRegistry = new LogRegistry[Source, TsIdentLibrary, Unit](
      logging.stdout.filter(LogLevel.error).syncAccess.void,
      _.libName,
      _ => logging.stdout.filter(LogLevel.error),
    )

    runImport(npmDependencies, InFolder(os.Path(npmDirectory.path / "node_modules")), os.Path(target.path), pedantic, logRegistry, os.Path(target.path)) match {

      case PhaseRes.Ok(value) =>
      case PhaseRes.Failure(errors) =>
      case PhaseRes.Ignore() =>
    }

    //TODO Figure out what to return here.
    target.list(file => !file.isDirectory).to[Seq]
  }
}


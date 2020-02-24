package org.scalablytyped.converter.plugin

import java.nio.file.Path
import java.time.Instant

import com.olvind.logging
import com.olvind.logging.{Formatter, LogLevel}
import org.scalablytyped.converter.internal.importer.build.Versions
import org.scalablytyped.converter.internal.importer.jsonCodecs.{FileDecoder, FileEncoder, PackageJsonDepsDecoder}
import org.scalablytyped.converter.internal.importer.{Json, SharedInput}
import org.scalablytyped.converter.internal.scalajs.Name
import org.scalablytyped.converter.internal.ts.{PackageJsonDeps, TsIdentLibrary}
import org.scalablytyped.converter.internal.{
  BuildInfo,
  Digest,
  IArray,
  ImportTypings,
  InFolder,
  WrapSbtLogger,
  ZincCompiler,
}
import org.scalajs.sbtplugin.ScalaJSCrossVersion
import sbt.Keys._
import sbt._

import scala.util.Try

object ScalablyTypedConverterExternalNpmPlugin extends AutoPlugin {
  implicit val PathFormatter: Formatter[Path] = _.toString

  object autoImport {
    val externalNpm = taskKey[File]("Runs npm and returns the folder with package.json and node_modules")
  }

  override def requires = ScalablyTypedPluginBase

  lazy val stExternalNpmIntegration: Seq[Def.Setting[_]] = {
    import ScalablyTypedPluginBase.autoImport._
    import autoImport._

    Seq(
      stImport := {
        val projectName     = name.value
        val folder          = os.Path(externalNpm.value)
        val packageJsonFile = folder / "package.json"
        val ignored         = stIgnore.value.to[Set]
        val sbtLog          = streams.value.log
        val outputDir       = os.Path(streams.value.cacheDirectory)
        val cacheDir        = (Global / stDir).value
        val outputPackage   = Name((Compile / stOutputPackage).value)

        val stLogger: logging.Logger[Unit] =
          if ((Global / stQuiet).value) logging.Logger.DevNull
          else WrapSbtLogger(sbtLog, Instant.now).filter(LogLevel.warn).void.withContext("project", projectName)

        val wantedLibs: Set[TsIdentLibrary] =
          Json[PackageJsonDeps](packageJsonFile).dependencies.getOrElse(Map()).keys.to[Set].map(TsIdentLibrary.apply)

        val ScalaVersion = Versions.Scala(
          scalaVersion = (Compile / Keys.scalaVersion).value,
          binVersion   = (Compile / Keys.scalaBinaryVersion).value,
        )
        val ScalaJsVersion = Versions.ScalaJs(
          scalaJsVersion    = org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion,
          scalaJsBinVersion = org.scalajs.ir.ScalaJSVersions.binaryCross,
        )

        val versions = Versions(ScalaVersion, ScalaJsVersion)
        val compiler = new ZincCompiler((stInternalCompileInputs in compile).value, stLogger, versions)

        val shared = SharedInput(
          shouldUseScalaJsDomTypes = (Compile / stUseScalaJsDom).value,
          wantedLibs               = wantedLibs,
          flavour                  = (Compile / stFlavour).value,
          outputPackage            = outputPackage,
          enableScalaJsDefined     = stEnableScalaJsDefined.value.map(TsIdentLibrary.apply),
          stdLibs                  = IArray.fromTraversable(stStdlib.value),
          expandTypeMappings       = stInternalExpandTypeMappings.value.map(TsIdentLibrary.apply),
          ignoredLibs              = ignored.map(TsIdentLibrary.apply),
          ignoredModulePrefixes    = ignored.map(_.split("/").toList),
          versions                 = versions,
        )

        val fromFolder = InFolder(folder / "node_modules")

        val input = ImportTypings.Input(
          converterVersion = BuildInfo.version,
          packageJsonHash  = Digest.of(List(os.read.bytes(packageJsonFile))).hexString,
          shared           = shared,
          fromFolder       = fromFolder,
          targetFolder     = outputDir / "sources",
        )

        val runCache = (cacheDir / "runs" / s"${input.hashCode}.json").toPath

        type InOut = (ImportTypings.Input, Seq[File])

        Try(Json[InOut](runCache)).toOption match {
          case Some((`input`, output)) if output.forall(_.exists()) =>
            stLogger.withContext(runCache).warn(s"Using cached result :)")
            Attributed.blankSeq(output)
          case _ =>
            val ran = ImportTypings(
              input            = input,
              logger           = stLogger,
              parseCacheDirOpt = Some(cacheDir.toPath resolve "parse"),
              compiler         = compiler,
              publishFolder    = os.Path(cacheDir) / 'artifacts,
            )
            ran match {
              case Right(files) =>
                val outSeq = files.to[Seq]
                Json.persist[InOut](runCache)((input, outSeq))
                Attributed.blankSeq(outSeq)
              case Left(errors) =>
                errors.foreach {
                  case (_, Left(th)) => throw th
                  case _             => ()
                }

                sys.error(errors.mkString("\n").take(2000))
            }
        }
      },
    )
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] =
    inConfig(Compile)(stExternalNpmIntegration)
}

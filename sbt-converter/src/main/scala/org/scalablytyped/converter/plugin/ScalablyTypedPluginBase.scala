package org.scalablytyped.converter.plugin

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin
import org.scalablytyped.converter
import org.scalablytyped.converter.internal.constants
import org.scalablytyped.converter.internal.importer.{ConversionOptions, EnabledTypeMappingExpansion, ImportName}
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalablytyped.converter.internal.sets.SetOps
import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import sbt.*
import sbt.Tags.Tag
import sbt.plugins.JvmPlugin

import java.io.File
import scala.collection.immutable.SortedSet
import scala.util.Try

object ScalablyTypedPluginBase extends AutoPlugin {

  object autoImport {
    type Selection[T] = converter.Selection[T]
    val Selection = converter.Selection
    type Flavour = converter.Flavour
    val Flavour     = converter.Flavour
    val RemoteCache = org.scalablytyped.converter.plugin.RemoteCache
    type RemoteCache = org.scalablytyped.converter.plugin.RemoteCache

    val ScalablyTypedTag: Tag = Tag("ScalablyTyped")

    val stConversionOptions = settingKey[ConversionOptions]("All conversion options")
    val stDir               = settingKey[File]("Directory used for caches, built artifacts and so on")
    val stIgnore            = settingKey[List[String]]("completely ignore libraries or modules")
    val stFlavour           = settingKey[Flavour]("The type of react binding to use")
    val stEnableScalaJsDefined = settingKey[Selection[String]](
      "Whether to generate @ScalaJSDefined traits when possible",
    )
    val stUseScalaJsDom = settingKey[Boolean]("Use types from scala-js-dom instead of from std when possible")
    /* Options are: dom, dom.iterable, es2015.collection, es2015.core, es2015, es2015.generator, es2015.iterable, es2015.promise, es2015.proxy, es2015.reflect, es2015.symbol, es2015.symbol.wellknown, es2016.array.include, es2016, es2016.full, es2017, es2017.full, es2017.intl, es2017.object, es2017.sharedmemory, es2017.string, es2017.typedarrays, es2018.asyncgenerator, es2018.asynciterable, es2018, es2018.full, es2018.intl, es2018.promise, es2018.regexp, es2019.array, es2019, es2019.full, es2019.object, es2019.string, es2019.symbol, es2020, es2020.full, es2020.string, es2020.symbol.wellknown, es5, es6, esnext.array, esnext.asynciterable, esnext.bigint, esnext, esnext.full, esnext.intl, esnext.symbol, scripthost, webworker, webworker.importscripts */
    val stStdlib = settingKey[List[String]](
      "Which versions of typescript library to include (same as `lib` in tsconfig.json)",
    )
    val stTypescriptVersion          = settingKey[String]("The version of the typescript library that it should use")
    val stOutputPackage              = settingKey[String]("The top-level package to put generated code in")
    val stQuiet                      = settingKey[Boolean]("remove all output")
    val stInternalExpandTypeMappings = settingKey[Selection[String]]("Experimental: enable type mapping expansion")
    val stRemoteCache                = settingKey[RemoteCache]("Enable/disable remote cache")
    val stReactEnableTreeShaking = settingKey[Selection[String]](
      "If a given library is enabled, the react flavour will pick *longest* module names instead of shortest.",
    )
    val stEnableLongApplyMethod = settingKey[Boolean]("long apply methods instead of implicit ops builders")
    val stShortModuleNames = settingKey[Boolean](
      "Enables short module names. This used to be the default, and is now deprecated since it's so difficult to navigate",
    )
    val stPrivateWithin = settingKey[Option[String]]("generate all top-level things private to the given package")
    val stIncludeDev    = settingKey[Boolean]("generate facades for dev dependencies as well")
  }

  override def requires = JvmPlugin && PlatformDepsPlugin

  import autoImport.*

  override lazy val projectSettings =
    Seq(
      stInternalExpandTypeMappings := EnabledTypeMappingExpansion.DefaultSelection.map(_.value),
      stEnableScalaJsDefined := {
        if ((Compile / Keys.scalaVersion).value.startsWith("3")) converter.Selection.All else converter.Selection.None
      },
      stFlavour := converter.Flavour.Normal,
      stIgnore := List("typescript"),
      stOutputPackage := Name.typings.unescaped,
      stStdlib := List("es6", "dom"),
      stTypescriptVersion := "4.3",
      stUseScalaJsDom := true,
      stReactEnableTreeShaking := Selection.None,
      stEnableLongApplyMethod := false,
      stPrivateWithin := None,
      stIncludeDev := false,
      stShortModuleNames := false,
      stConversionOptions := {
        val versions = Versions(
          Versions.Scala(scalaVersion = (Compile / Keys.scalaVersion).value),
          Versions.ScalaJs(org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion),
        )

        val outputPackage = Name(stOutputPackage.value)
        val organization =
          outputPackage match {
            case Name.typings    => "org.scalablytyped"
            case Name(unescaped) => s"org.scalablytyped.$unescaped"
          }

        ConversionOptions(
          useScalaJsDomTypes       = stUseScalaJsDom.value,
          flavour                  = stFlavour.value,
          outputPackage            = outputPackage,
          enableScalaJsDefined     = stEnableScalaJsDefined.value.map(TsIdentLibrary.apply),
          stdLibs                  = SortedSet.empty ++ stStdlib.value,
          expandTypeMappings       = stInternalExpandTypeMappings.value.map(TsIdentLibrary.apply),
          ignored                  = stIgnore.value.to(Set).sorted,
          versions                 = versions,
          organization             = organization,
          enableReactTreeShaking   = stReactEnableTreeShaking.value.map(name => ImportName(TsIdentLibrary(name))),
          enableLongApplyMethod    = stEnableLongApplyMethod.value,
          privateWithin            = stPrivateWithin.value.map(Name.apply),
          useDeprecatedModuleNames = stShortModuleNames.value,
        )
      },
    )

  override lazy val globalSettings =
    Seq(
      Global / Keys.onLoad := (state => {
        val old               = (Global / Keys.onLoad).value
        val sbtVersionPattern = """^(\d+)\.(\d+)(\..*)?""".r
        Keys.sbtVersion.value match {
          case sbtVersionPattern(major, minor, _) if major == "1" && Try(minor.toInt).toOption.exists(_ >= 8) =>
            old(state)
          case invalid =>
            sys.error(
              s"This version of the ScalablyTyped plugin only supports 1.8.x or later. You're currently using $invalid",
            )
        }
      }),
      stQuiet := false,
      stDir := constants.defaultCacheFolder.toIO,
      stRemoteCache := RemoteCache.Disabled,
      // don't OOM memory constrained environments like IDE build imports or CI
      Global / Keys.concurrentRestrictions += {
        val gigabytes   = (java.lang.Runtime.getRuntime.maxMemory) / (1000 * 1000 * 1000)
        val numParallel = Math.max(1, gigabytes.toInt)
        Tags.limit(ScalablyTypedTag, numParallel)
      },
    )
}

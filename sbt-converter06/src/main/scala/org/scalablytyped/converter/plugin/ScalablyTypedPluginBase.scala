package org.scalablytyped.converter.plugin

import java.util.Optional

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin
import org.scalablytyped.converter
import org.scalablytyped.converter.internal.constants
import org.scalablytyped.converter.internal.importer.{flavourImpl, EnabledTypeMappingExpansion}
import org.scalablytyped.converter.internal.scalajs.{Dep, Name}
import sbt.Tags.Tag
import sbt._
import sbt.internal.server.LanguageServerReporter
import sbt.internal.util.Attributed
import sbt.plugins.JvmPlugin
import sbt.util.InterfaceUtil
import xsbti.compile._

object ScalablyTypedPluginBase extends AutoPlugin {

  object autoImport {
    type Selection[T] = converter.Selection[T]
    val Selection = converter.Selection
    type Flavour = converter.Flavour
    val Flavour = converter.Flavour

    val ScalablyTypedTag: Tag = Tag("ScalablyTyped")

    val stImport  = taskKey[Seq[Attributed[File]]]("Imports all the bundled npm and generates bindings")
    val stDir     = settingKey[File]("Directory used for caches, built artifacts and so on")
    val stIgnore  = settingKey[List[String]]("completely ignore libraries or modules")
    val stFlavour = settingKey[Flavour]("The type of react binding to use")
    val stEnableScalaJsDefined = settingKey[Selection[String]](
      "Generate @ScalaJSDefined traits when necessary. This enables you to `new` them, but it may require tons of compilation time",
    )

    val stUseScalaJsDom = settingKey[Boolean]("Use types from scala-js-dom instead of from std when possible")

    /** Options are
      * dom
      * dom.iterable
      * es2015.collection
      * es2015.core
      * es2015
      * es2015.generator
      * es2015.iterable
      * es2015.promise
      * es2015.proxy
      * es2015.reflect
      * es2015.symbol
      * es2015.symbol.wellknown
      * es2016.array.include
      * es2016
      * es2016.full
      * es2017
      * es2017.full
      * es2017.intl
      * es2017.object
      * es2017.sharedmemory
      * es2017.string
      * es2017.typedarrays
      * es2018.asyncgenerator
      * es2018.asynciterable
      * es2018
      * es2018.full
      * es2018.intl
      * es2018.promise
      * es2018.regexp
      * es2019.array
      * es2019
      * es2019.full
      * es2019.object
      * es2019.string
      * es2019.symbol
      * es2020
      * es2020.full
      * es2020.string
      * es2020.symbol.wellknown
      * es5
      * es6
      * esnext.array
      * esnext.asynciterable
      * esnext.bigint
      * esnext
      * esnext.full
      * esnext.intl
      * esnext.symbol
      * scripthost
      * webworker
      * webworker.importscripts
      */
    val stStdlib = settingKey[List[String]](
      "Which versions of typescript library to include (same as `lib` in tsconfig.json)",
    )
    val stTypescriptVersion = settingKey[String](
      "The version of the typescript library that it should use",
    )
    val stOutputPackage = settingKey[String](
      "The top-level package to put generated code in",
    )

    val stQuiet = settingKey[Boolean]("remove all output")

    val stInternalExpandTypeMappings                     = settingKey[Selection[String]]("Experimental: enable type mapping expansion")
    private[plugin] val stInternalCompileInputs          = taskKey[Inputs]("Hijack compiler settings")
    private[plugin] val stInternalNpmInstallDependencies = taskKey[File]("Install deps from npm")
  }

  override def requires = JvmPlugin && PlatformDepsPlugin

  lazy val stOutsideConfig: Seq[Def.Setting[_]] = {
    import PlatformDepsPlugin.autoImport._
    import autoImport._
    import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.scalaJSVersion

    Seq(
      Keys.libraryDependencies ++= Seq(constants.RuntimeOrg %%% constants.RuntimeName % constants.RuntimeVersion),
      Keys.libraryDependencies ++= {
        val impl = flavourImpl(
          flavour                  = (Compile / stFlavour).value,
          shouldUseScalaJsDomTypes = (Compile / stUseScalaJsDom).value,
          outputPackage            = Name((Compile / stOutputPackage).value),
        )
        impl.dependencies
          .map {
            case Dep(org, artifact, version) => org %%% artifact % version
          }
          .to[Seq]
      },
      Keys.scalacOptions ++= {
        val isScalaJs1 = !scalaJSVersion.startsWith("0.6")

        val old = Keys.scalacOptions.value
        if (old.contains("-P:scalajs:sjsDefinedByDefault") || isScalaJs1) Nil
        else Seq("-P:scalajs:sjsDefinedByDefault")
      },
    )
  }

  lazy val stDefaults: Seq[Def.Setting[_]] = {
    import autoImport._

    Seq(
      stInternalExpandTypeMappings := EnabledTypeMappingExpansion.DefaultSelection.map(_.value),
      stEnableScalaJsDefined := converter.Selection.None,
      stFlavour := converter.Flavour.Normal,
      stIgnore := List("typescript"),
      stOutputPackage := "typings",
      stStdlib := List("es6"),
      stTypescriptVersion := "3.7.2",
      stUseScalaJsDom := true,
      /* This is where we add our generated artifacts to the project for compilation */
      Keys.unmanagedJars := stImport.value,
      /* This is duplicated/inlined from sbt. The point is that we cannot reference `unmanaged` here, because we use it above. */
      stInternalCompileInputs := {
        import Keys._

        def foldMappers[A](mappers: Seq[A => Option[A]]) =
          mappers.foldRight({ p: A =>
            p
          }) { (mapper, mappers) => p: A =>
            mapper(p).getOrElse(mappers(p))
          }

        val dependencyClasspath: Seq[Attributed[File]] =
          internalDependencyClasspath.value ++ managedClasspath.value

        val options = CompileOptions.of(
          (classDirectory.value +: dependencyClasspath.map(_.data)).toArray,
          Array(),
          classDirectory.value,
          scalacOptions.value.toArray,
          javacOptions.value.toArray,
          maxErrors.value,
          InterfaceUtil.toJavaFunction(foldMappers(sourcePositionMappers.value)),
          compileOrder.value,
        )

        object lookup extends PerClasspathEntryLookup {
          private val cachedAnalysisMap                = Defaults.analysisMap(dependencyClasspath)
          private val cachedPerEntryDefinesClassLookup = Keys.classpathEntryDefinesClass.value

          override def analysis(classpathEntry: File): Optional[CompileAnalysis] =
            cachedAnalysisMap(classpathEntry) match {
              case Some(value) => Optional.of(value)
              case None        => Optional.empty()
            }
          override def definesClass(classpathEntry: File): DefinesClass =
            cachedPerEntryDefinesClassLookup(classpathEntry)
        }

        Inputs.of(
          compilers.value,
          options,
          Setup.of(
            lookup,
            (skip in compile).value,
            streams.value.cacheDirectory / compileAnalysisFilename.value,
            compilerCache.value,
            IncOptions.of(),
            new LanguageServerReporter(
              maxErrors.value,
              streams.value.log,
              foldMappers(sourcePositionMappers.value),
            ),
            Optional.empty(),
            Array.empty,
          ),
          PreviousResult.create(Optional.empty(), Optional.empty()),
        )
      },
    )
  }

  override lazy val projectSettings: scala.Seq[Def.Setting[_]] =
    inConfig(Compile)(stDefaults) ++ stOutsideConfig

  override lazy val globalSettings: scala.Seq[Def.Setting[_]] = {
    import autoImport.{stDir, stQuiet}
    Seq(
      stQuiet := false,
      stDir := constants.defaultCacheFolder.toIO,
    )
  }
}

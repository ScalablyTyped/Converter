package org.scalablytyped.converter.internal

import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport.stTypescriptVersion
import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.{NpmUpdateTasks, PackageJsonTasks}

object ScalaJsBundlerHack {

  import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

  /* workaround private definition */
  private val scalaJSBundlerPackageJson =
    TaskKey[BundlerFile.PackageJson](
      "scalaJSBundlerPackageJson",
      "Write a package.json file defining the NPM dependencies of project",
      KeyRanks.Invisible,
    )

  val adaptScalaJSBundlerPackageJson: Def.Setting[_] = {
    Compile / scalaJSBundlerPackageJson := {
      val deps = (Compile / npmDevDependencies).value
      /* Make sure we always include typescript for the stdlib if it wasnt already added */
      val withTypescript: Seq[(String, String)] =
        if (deps.exists { case (lib, _) => lib == "typescript" }) deps
        else deps :+ ("typescript" -> stTypescriptVersion.value)

      PackageJsonTasks.writePackageJson(
        (Compile / npmUpdate / crossTarget).value,
        (Compile / npmDependencies).value,
        withTypescript,
        (Compile / npmResolutions).value,
        (Compile / additionalNpmConfig).value,
        fullClasspath = Nil, // hack here
        Compile,
        (Compile / webpack / version).value,
        (Compile / startWebpackDevServer / version).value,
        (Compile / webpackCliVersion).value,
        (Compile / scalaJSBundlerPackageJson / streams).value,
      )
    }
  }

  val adaptNpmInstallJSResources: Def.Setting[_] = {
    Compile / npmInstallJSResources := {
      NpmUpdateTasks.npmInstallJSResources(
        (Compile / npmUpdate / crossTarget).value,
        jsResources = Nil, // hack here
        (Compile / jsSourceDirectories).value,
        (Compile / npmInstallJSResources / streams).value,
      )
    }
  }
}

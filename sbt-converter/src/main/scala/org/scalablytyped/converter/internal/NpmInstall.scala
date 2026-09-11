package org.scalablytyped.converter.internal

import _root_.io.circe.{Json => CJson}
import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport._
import sbt.Keys._
import sbt._

/** Writes a minimal package.json from the st{Npm,NpmDev,NpmResolutions} settings and runs `npm install`
  * (or `yarn install`), independent of any third-party scalajs-bundler-style plugin.
  */
object NpmInstall {

  /** Where package.json/node_modules end up. Pure computation, doesn't trigger installation. */
  def targetDir(crossTarget: File): File = crossTarget / "scalablytyped-npm"

  val task: Def.Initialize[Task[File]] = Def.task {
    val log       = streams.value.log
    val targetDir = os.Path(NpmInstall.targetDir((Compile / crossTarget).value))
    os.makeDir.all(targetDir)

    val dependencies = (Compile / stNpmDependencies).value
    val devDependencies = {
      val declared = (Compile / stNpmDevDependencies).value
      if ((dependencies ++ declared).exists { case (lib, _) => lib == "typescript" }) declared
      else declared :+ ("typescript" -> stTypescriptVersion.value)
    }
    val resolutions = (Compile / stNpmResolutions).value
    val useYarn     = stUseYarn.value

    val packageJsonContent = packageJson(dependencies, devDependencies, resolutions)
    val packageJsonFile    = targetDir / "package.json"
    val hashFile           = targetDir / ".stNpmInstall.hash"
    val nodeModules        = targetDir / "node_modules"

    val newHash = Digest.of(IArray(packageJsonContent)).hexString
    val upToDate =
      os.exists(nodeModules) && os.exists(hashFile) && os.read(hashFile) == newHash

    if (!upToDate) {
      os.write.over(packageJsonFile, packageJsonContent)

      val command = if (useYarn) "yarn" else "npm"
      log.info(s"Running `$command install` in $targetDir")

      val result = os
        .proc(command, "install")
        .call(
          cwd    = targetDir,
          stdout = os.Inherit,
          stderr = os.Inherit,
          check  = false,
        )
      if (result.exitCode != 0)
        sys.error(s"`$command install` failed with exit code ${result.exitCode}")

      os.write.over(hashFile, newHash)
    }

    targetDir.toIO
  }

  private def packageJson(
      dependencies:    Seq[(String, String)],
      devDependencies: Seq[(String, String)],
      resolutions:     Map[String, String],
  ): String = {
    def obj(entries: Iterable[(String, String)]): CJson =
      CJson.fromFields(entries.map { case (k, v) => k -> CJson.fromString(v) })

    CJson
      .obj(
        "name" -> CJson.fromString("scalablytyped-npm-install"),
        "version" -> CJson.fromString("0.0.0"),
        "private" -> CJson.fromBoolean(true),
        "dependencies" -> obj(dependencies),
        "devDependencies" -> obj(devDependencies),
        "resolutions" -> obj(resolutions),
      )
      .spaces2
  }
}

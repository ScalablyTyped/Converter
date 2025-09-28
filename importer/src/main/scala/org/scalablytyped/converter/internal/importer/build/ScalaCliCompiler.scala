package org.scalablytyped.converter.internal
package importer
package build

import com.olvind.logging.Logger
import coursier.cache.{ArchiveCache, CacheLogger, FileCache}
import coursier.util.{Artifact, Task}
import org.scalablytyped.converter.internal.scalajs.{Dep, Versions}

import scala.concurrent.{ExecutionContext, Future}
import scala.sys.process.{Process, ProcessLogger}

class ScalaCliCompiler private (
    logger:       Logger[Unit],
    versions:     Versions,
    scalaCliPath: String,
) extends Compiler {

  override def compile(
      name:          String,
      digest:        Digest,
      compilerPaths: CompilerPaths,
      deps:          Set[Compiler.InternalDep],
      externalDeps:  Set[Dep],
  ): Either[String, Unit] = {

    // Create build.scala with directives
    val buildFile    = compilerPaths.sourcesDir / "build.scala"
    val buildContent = generateBuildFile(name, deps, externalDeps, versions)
    os.write.over(buildFile, buildContent)

    try {
      // Prepare classpath for dependencies
      val depClasspath = deps.collect {
        case Compiler.InternalDepClassFiles(_, path) => path.toString
        case Compiler.InternalDepJar(path)           => path.toString
      }

      // Build command
      val compileCmd = Seq(
        scalaCliPath,
        "compile",
        "--scala",
        versions.scala.scalaVersion,
        "--js",
        "--js-version",
        versions.scalaJs.scalaJsVersion,
        "--js-mode",
        "dev",
        "--js-module-kind",
        "commonjs",
        "-d",
        compilerPaths.classesDir.toString,
        compilerPaths.sourcesDir.toString,
      ) ++ (if (depClasspath.nonEmpty) Seq("--classpath", depClasspath.mkString(java.io.File.pathSeparator))
            else Seq.empty)

      logger.info(s"Compiling $name with scala-cli...")
      logger.debug(s"Command: ${compileCmd.mkString(" ")}")

      // Run compilation and capture output
      val output      = new StringBuilder
      val errorOutput = new StringBuilder

      val processLogger = ProcessLogger(
        (line: String) => {
          output.append(line).append("\n")
          // Pattern match on stdout for better logging levels
          line match {
            case s if s.startsWith("[error]")                             => logger.error(s)
            case s if s.startsWith("[warn]") || s.startsWith("[warning]") => logger.warn(s)
            case s if s.startsWith("[info]")                              => logger.info(s)
            case s if s.startsWith("[debug]")                             => logger.debug(s)
            case s                                                        => logger.info(s)
          }
        },
        (line: String) => {
          errorOutput.append(line).append("\n")
          // Pattern match on stderr for better logging levels
          line match {
            case s if s.startsWith("[error]")                             => logger.error(s)
            case s if s.startsWith("[warn]") || s.startsWith("[warning]") => logger.warn(s)
            case s if s.startsWith("[info]")                              => logger.info(s)
            case s                                                        => logger.warn(s) // Default stderr to warn
          }
        },
      )

      val result = Process(compileCmd, compilerPaths.baseDir.toIO).!(processLogger)

      if (result == 0) {
        logger.info(s"Successfully compiled $name")
        Right(())
      } else {
        val errorMsg = if (errorOutput.nonEmpty) {
          s"Compilation failed with exit code $result:\n${errorOutput.toString}"
        } else if (output.nonEmpty) {
          s"Compilation failed with exit code $result:\n${output.toString}"
        } else {
          s"Compilation failed with exit code $result"
        }
        Left(errorMsg)
      }
    } catch {
      case e: Exception =>
        Left(s"Compilation failed: ${e.getMessage}")
    } finally {
      // Always remove build.scala after compilation
      if (os.exists(buildFile)) {
        os.remove(buildFile)
      }
    }
  }

  private def generateBuildFile(
      name:         String,
      deps:         Set[Compiler.InternalDep],
      externalDeps: Set[Dep],
      versions:     Versions,
  ): String = {
    val sb = new StringBuilder

    // Add scala-cli directives
    sb.append(s"//> using scala ${versions.scala.scalaVersion}\n")
    sb.append(s"//> using platform js\n")
    sb.append(s"//> using jsVersion ${versions.scalaJs.scalaJsVersion}\n")
    sb.append(s"//> using jsMode dev\n")
    sb.append(s"//> using jsModuleKind commonjs\n")
    sb.append("\n")

    // Add external dependencies (make them concrete first)
    val concreteDeps = externalDeps.map(_.concrete(versions))
    if (concreteDeps.nonEmpty) {
      sb.append("// External dependencies\n")
      concreteDeps.foreach { dep =>
        sb.append(s"//> using dep ${dep.asConcreteScalaCli}\n")
      }
      sb.append("\n")
    }

    // Add internal dependencies as jars
    val jarDeps = deps.collect { case Compiler.InternalDepJar(path) => path }
    if (jarDeps.nonEmpty) {
      sb.append("// Internal JAR dependencies\n")
      jarDeps.foreach { jar =>
        sb.append(s"//> using jar ${jar}\n")
      }
      sb.append("\n")
    }

    // Add classpath for class files
    val classDeps = deps.collect { case Compiler.InternalDepClassFiles(_, path) => path }
    if (classDeps.nonEmpty) {
      sb.append("// Internal class dependencies\n")
      sb.append(s"//> using classpath ${classDeps.mkString(":")}\n")
      sb.append("\n")
    }

    // Add compiler options
    sb.append("// Compiler options\n")
    versions.scalacOptions.foreach { opt =>
      sb.append(s"//> using option $opt\n")
    }

    sb.toString
  }
}

object ScalaCliCompiler {
  val DefaultScalaCliVersion = "1.9.1"

  def apply(
      logger:          Logger[Unit],
      versions:        Versions,
      cacheDir:        os.Path = os.home / ".cache" / "scalablytyped",
      scalaCliVersion: String = DefaultScalaCliVersion,
  )(implicit ec:       ExecutionContext): Future[ScalaCliCompiler] = {
    val scalaCliCacheDir = cacheDir / "scala-cli"
    val scalaCliPath     = scalaCliCacheDir / s"scala-cli-$scalaCliVersion"

    if (os.exists(scalaCliPath)) {
      Future.successful(new ScalaCliCompiler(logger, versions, scalaCliPath.toString))
    } else {
      logger.info(s"Downloading scala-cli $scalaCliVersion...")

      val osName = System.getProperty("os.name")
      val osArch = System.getProperty("os.arch")

      downloadScalaCli(osName, osArch, scalaCliVersion, scalaCliCacheDir).map { downloadedPath =>
        logger.info(s"Downloaded scala-cli to $downloadedPath")
        new ScalaCliCompiler(logger, versions, downloadedPath.toString)
      }
    }
  }

  def downloadScalaCli(
      osName:    String,
      osArch:    String,
      version:   String,
      cacheDir:  os.Path,
  )(implicit ec: ExecutionContext): Future[os.Path] = {
    import java.util.Locale

    // Normalize OS name using battle-tested logic
    val normalizedOs = Option(osName).getOrElse("").toLowerCase(Locale.ROOT) match {
      case s if s.contains("windows") => "windows"
      case s if s.contains("linux")   => "linux"
      case s if s.contains("mac")     => "macos"
      case unrecognized               => throw new RuntimeException(s"OS $unrecognized not supported yet")
    }

    // Normalize architecture using battle-tested logic
    val normalizedArch = Option(osArch).getOrElse("").toLowerCase(Locale.ROOT) match {
      case "x86_64" | "amd64"  => "x86_64"
      case "aarch64" | "arm64" => "aarch64"
      case unrecognized        => throw new RuntimeException(s"Arch $unrecognized not supported yet")
    }

    val artifactUrl = (normalizedOs, normalizedArch) match {
      case ("macos", "aarch64") =>
        s"https://github.com/VirtusLab/scala-cli/releases/download/v$version/scala-cli-aarch64-apple-darwin.gz"
      case ("macos", "x86_64") =>
        s"https://github.com/VirtusLab/scala-cli/releases/download/v$version/scala-cli-x86_64-apple-darwin.gz"

      case ("linux", "x86_64") =>
        // Use mostly-static for x86_64 Linux
        s"https://github.com/VirtusLab/scala-cli/releases/download/v$version/scala-cli-x86_64-pc-linux-mostly-static.gz"
      case ("linux", "aarch64") =>
        s"https://github.com/VirtusLab/scala-cli/releases/download/v$version/scala-cli-aarch64-pc-linux.gz"

      case ("windows", "x86_64") =>
        // Note: Only x86_64 builds are available for Windows, no ARM64/aarch64
        s"https://github.com/VirtusLab/scala-cli/releases/download/v$version/scala-cli-x86_64-pc-win32.zip"
      case ("windows", arch) =>
        throw new RuntimeException(s"Windows $arch not supported - only x86_64 available")

      case (os, arch) =>
        throw new RuntimeException(s"Unsupported platform: $os/$arch")
    }

    // Use ArchiveCache which automatically handles decompression
    ArchiveCache[Task]()
      .withCache(FileCache[Task]().withLogger(CacheLogger.nop))
      .get(Artifact(artifactUrl))
      .value(ec)
      .map {
        case Left(err) =>
          throw new RuntimeException(s"Failed to download scala-cli: $err")
        case Right(file) =>
          // ArchiveCache extracts archives to directories, find the executable inside
          if (file.isDirectory) {
            val files = file.listFiles().filter(_.getName.contains("scala-cli"))
            files.headOption match {
              case Some(executable) =>
                executable.setExecutable(true)
                os.Path(executable)
              case None =>
                throw new RuntimeException(s"No scala-cli executable found in extracted archive at $file")
            }
          } else {
            // Direct file (shouldn't happen with ArchiveCache but handle it)
            file.setExecutable(true)
            os.Path(file)
          }
      }
  }
}

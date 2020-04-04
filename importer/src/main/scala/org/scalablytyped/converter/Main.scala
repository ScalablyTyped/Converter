package org.scalablytyped.converter

import java.nio.file.Path

import org.scalablytyped.converter.internal.constants.defaultCacheFolder
import org.scalablytyped.converter.internal.files
import org.scalablytyped.converter.internal.importer.{withZipFs, Ci}

object Main {
  def main(args: Array[String]): Unit = {
    val Ci.Config(config) = args
    /* I havent found a way to configure bloop to customize the global ExecutionContext, so this is it */
    System.setProperty("scala.concurrent.context.numThreads", config.parallelScalas.toString)

    val publishFolder = os.home / ".ivy2" / "local"

    withZipFs(files.existing(defaultCacheFolder) / "bintray.zip") { bintrayPath =>
      withZipFs(defaultCacheFolder / "npmjs.zip") { npmjsPath =>
        withZipFs.maybe(defaultCacheFolder / "parseCache.zip", config.enableParseCache && config.conserveSpace) {
          parseCachePathOpt =>
            val parseCacheOpt: Option[Path] = parseCachePathOpt orElse {
              if (config.enableParseCache) Some((defaultCacheFolder / "parse").toNIO) else None
            }
            val paths = Ci.Paths(bintrayPath, npmjsPath, parseCacheOpt, defaultCacheFolder, publishFolder)
            new Ci(config, paths).run()
        }
      }
    }

    System.exit(0)
  }
}

package org.scalablytyped.converter

import org.scalablytyped.converter.internal.importer.{withZipFs, Config, Main, MainPaths}

object Main {
  def main(args: Array[String]): Unit = {
    val Config(config) = args
    /* I havent found a way to configure bloop to customize the global ExecutionContext, so this is it */
    System.setProperty("scala.concurrent.context.numThreads", config.parallelScalas.toString)

    val publishFolder = os.home / ".ivy2" / "local"

    withZipFs(Config.cacheFolder / "bintray.zip") { bintrayPath =>
      withZipFs(Config.cacheFolder / "npmjs.zip") { npmjsPath =>
        withZipFs(Config.cacheFolder / "parseCache.zip") { parseCachePath =>
          val paths = MainPaths(bintrayPath, npmjsPath, parseCachePath, Config.cacheFolder, publishFolder)
          new Main(config, paths).run()
        }
      }
    }

    System.exit(0)
  }
}

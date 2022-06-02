package org.scalablytyped.converter

import java.nio.file.Path
import java.util.concurrent.ForkJoinPool

import org.scalablytyped.converter.internal.constants
import org.scalablytyped.converter.internal.constants.defaultCacheFolder
import org.scalablytyped.converter.internal.importer.{withZipFs, Ci}

import scala.concurrent.ExecutionContext

object Main {
  def main(args: Array[String]): Unit = {
    val Ci.Config(config) = args
    /* I havent found a way to configure bloop to customize the global ExecutionContext, so this is it */
    System.setProperty("scala.concurrent.context.numThreads", config.parallelScalas.toString)

    val pool = new ForkJoinPool(config.parallelLibraries)
    val ec   = ExecutionContext.fromExecutorService(pool)

    os.makeDir.all(defaultCacheFolder)

    withZipFs(defaultCacheFolder / "npmjs.zip") { npmjsPath =>
      withZipFs.maybe(defaultCacheFolder / "parseCache.zip", config.enableParseCache && config.conserveSpace) {
        parseCachePathOpt =>
          val parseCacheOpt: Option[Path] = parseCachePathOpt.orElse {
            if (config.enableParseCache) Some((defaultCacheFolder / "parse").toNIO) else None
          }
          val paths =
            Ci.Paths(
              npmjs              = npmjsPath,
              parseCache         = parseCacheOpt,
              cacheFolder        = defaultCacheFolder,
              publishLocalFolder = constants.defaultLocalPublishFolder,
              gitCache           = defaultCacheFolder / "git",
            )
          val ci = new Ci(config, paths, pool, ec)
          if (config.benchmark) {
            println(ci.run())
            println(ci.run())
            println(ci.run())
          } else {
            ci.run()
          }
      }
    }

    pool.shutdown()
    System.exit(0)
  }
}

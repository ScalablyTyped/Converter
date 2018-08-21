package com.olvind.tso
package importer

import ammonite.ops.Path
import com.olvind.logging.Logger
import io.circe._
import io.circe.parser._

object PersistedFunction {

  def apply[K, V: Encoder: Decoder](cachedFileFor: K => Path, logger: Logger[Unit])(f: K => V): K => V = { key: K =>
    cachedFileFor(key) match {
      case files.Exists(cachedFile) =>
        decode[V](files content InFile(cachedFile)) match {
          case Left(error) =>
            logger.warn(s"Couldn't decode cached file $cachedFile for $key: $error")
            val ret = f(key)
            Json.persist(cachedFile)(ret)
            ret
          case Right(file) => file
        }

      case cacheFile =>
        val ret = f(key)
        Json.persist(cacheFile)(ret)
        ret
    }
  }

  def nameAndMtimeUnder(path: Path): InFile => Path =
    (file: InFile) =>
      path /
        file.path.toString().replaceAll("/", "_") /
        file.path.mtime.toMillis.toString

}

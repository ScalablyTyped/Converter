package com.olvind.tso
package importer

import ammonite.ops.Path
import com.olvind.logging.Logger
import io.circe._
import io.circe.parser._
import monix.eval.Task

object PersistingFunction {

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

  def taskPartial[K, V, VV <: V: Encoder: Decoder](cachedFile: Path,
                                                   logger:  Logger[Unit],
                                                   run:     Task[V],
                                                   extract: PartialFunction[V, VV]): Task[V] = {
    def persisted(v: V): V = {
      extract.lift(v).foreach(vv => Json.persist(cachedFile)(vv))
      v
    }
    cachedFile match {
      case files.Exists(existingFile) =>
        decode[VV](files content InFile(existingFile)) match {
          case Left(error) =>
            logger.warn(s"Couldn't decode cached file $existingFile: $error")
            run.map(persisted)
          case Right(file) => Task.pure(file)
        }

      case _ => run.map(persisted)
    }
  }

  def nameAndMtimeUnder(path: Path): InFile => Path =
    (file: InFile) =>
      path /
        file.path.toString().replaceAll("/", "_") /
        file.path.mtime.toMillis.toString

}

package com.olvind.tso
package importer

import io.circe.parser.decode
import io.circe.syntax._
import io.circe.{Decoder, Encoder}

object Json {
  def apply[T: Decoder](path: os.Path): T =
    decode[T](files content InFile(path)) match {
      case Left(error) => sys.error(s"Error while parsing: $path: $error")
      case Right(t)    => t
    }

  def opt[T: Decoder](path: os.Path, log: String => Unit): Option[T] =
    if (os.exists(path))
      decode[T](files content InFile(path)) match {
        case Left(error) =>
          log(s"Error while parsing: $path: $error")
          None
        case Right(t) => Some(t)
      } else None

  def persist[V: Encoder](file: os.Path)(value: V): Synced =
    files.softWrite(file)(_.append(value.asJson.noSpaces))
}

package com.olvind.tso
package importer

import ammonite.ops.{exists, Path}
import io.circe.{Decoder, Encoder}
import io.circe.parser.decode
import io.circe.syntax._

object Json {
  def apply[T: Decoder](path: Path): T =
    decode[T](files content InFile(path)) match {
      case Left(error) => sys.error(s"Error while parsing: $path: $error")
      case Right(t)    => t
    }

  def opt[T: Decoder](path: Path): Option[T] =
    if (exists(path)) Some(apply[T](path)) else None

  def persist[V: Encoder](file: Path)(value: V): Synced =
    files.softWrite(file)(_.append(value.asJson.noSpaces))
}

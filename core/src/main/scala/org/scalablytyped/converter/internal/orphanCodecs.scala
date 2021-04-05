package org.scalablytyped.converter.internal

import java.io.File
import java.net.URI

import io.circe013.{Decoder, Encoder}

import scala.collection.immutable.{SortedSet, TreeSet}

object orphanCodecs {
  implicit def SortedSetEncoder[T: Encoder: Ordering]: Encoder[SortedSet[T]] =
    Encoder[Vector[T]].contramap[SortedSet[T]](x => x.toVector)

  implicit def SortedSetDecoder[T: Decoder: Ordering]: Decoder[SortedSet[T]] =
    Decoder[Vector[T]].map[SortedSet[T]](ts => TreeSet.empty[T] ++ ts)

  implicit val FileEncoder:    Encoder[File]       = Encoder[String].contramap[File](_.toString)
  implicit val FileDecoder:    Decoder[File]       = Decoder[String].map[File](new File(_))
  implicit val RelPathDecoder: Decoder[os.RelPath] = Decoder[String].map(str => os.RelPath(str.dropWhile(_ === '/')))
  implicit val RelPathEncoder: Encoder[os.RelPath] = Encoder[String].contramap[os.RelPath](_.toString)
  implicit val PathDecoder:    Decoder[os.Path]    = Decoder[String].map(str => os.Path(str))
  implicit val PathEncoder:    Encoder[os.Path]    = Encoder[String].contramap[os.Path](_.toString)
  implicit val URIDecoder:     Decoder[URI]        = Decoder[String].map(new URI(_))
  implicit val URIEncoder:     Encoder[URI]        = Encoder[String].contramap[URI](_.toString)
}

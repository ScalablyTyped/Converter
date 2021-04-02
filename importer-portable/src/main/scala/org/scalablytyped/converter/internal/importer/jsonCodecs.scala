package org.scalablytyped.converter.internal
package importer

import io.circe013._
import org.scalablytyped.converter.internal.ts._

import java.io.File
import java.net.URI
import scala.collection.immutable.{SortedSet, TreeSet}

object jsonCodecs {
  implicit def IArrayEncoder[T <: AnyRef: Encoder]: Encoder[IArray[T]] =
    Encoder[List[T]].contramap[IArray[T]](_.toList)

  implicit def IArrayDecoder[T <: AnyRef: Decoder]: Decoder[IArray[T]] =
    Decoder[List[T]].map[IArray[T]](IArray.fromTraversable)

  implicit def SortedSetEncoder[T: Encoder: Ordering]: Encoder[SortedSet[T]] =
    Encoder[Vector[T]].contramap[SortedSet[T]](x => x.toVector)

  implicit def SortedSetDecoder[T: Decoder: Ordering]: Decoder[SortedSet[T]] =
    Decoder[Vector[T]].map[SortedSet[T]](ts => TreeSet.empty[T] ++ ts)

  implicit val FileEncoder:           Encoder[File]              = Encoder[String].contramap[File](_.toString)
  implicit val FileDecoder:           Decoder[File]              = Decoder[String].map[File](new File(_))
  implicit val RelPathDecoder:        Decoder[os.RelPath]        = Decoder[String].map(str => os.RelPath(str.dropWhile(_ === '/')))
  implicit val RelPathEncoder:        Encoder[os.RelPath]        = Encoder[String].contramap[os.RelPath](_.toString)
  implicit val PathDecoder:           Decoder[os.Path]           = Decoder[String].map(str => os.Path(str))
  implicit val PathEncoder:           Encoder[os.Path]           = Encoder[String].contramap[os.Path](_.toString)
  implicit val URIDecoder:            Decoder[URI]               = Decoder[String].map(new URI(_))
  implicit val URIEncoder:            Encoder[URI]               = Encoder[String].contramap[URI](_.toString)
  implicit val TsIdentLibraryDecoder: Decoder[TsIdentLibrary]    = Decoder[String].map(TsIdentLibrary.apply)
  implicit val TsIdentLibraryEncoder: Encoder[TsIdentLibrary]    = Encoder[String].contramap[TsIdentLibrary](_.value)
  implicit val TsIdentLibraryKeyDec:  KeyDecoder[TsIdentLibrary] = KeyDecoder[String].map(TsIdentLibrary.apply)
  implicit val TsIdentLibraryKeyEnc:  KeyEncoder[TsIdentLibrary] = KeyEncoder[String].contramap[TsIdentLibrary](_.value)

  import io.circe013.generic.semiauto._

  implicit val CompilerOptionsEncoder:   Encoder[CompilerOptions]   = deriveEncoder[CompilerOptions]
  implicit val CompilerOptionsDecoder:   Decoder[CompilerOptions]   = deriveDecoder[CompilerOptions]
  implicit val TsConfigEncoder:          Encoder[TsConfig]          = deriveEncoder[TsConfig]
  implicit val TsConfigDecoder:          Decoder[TsConfig]          = deriveDecoder[TsConfig]
  implicit val PackageJsonDepsEncoder:   Encoder[PackageJsonDeps]   = deriveEncoder[PackageJsonDeps]
  implicit val PackageJsonDepsDecoder:   Decoder[PackageJsonDeps]   = deriveDecoder[PackageJsonDeps]
  implicit val NotNeededPackageEncoder:  Encoder[NotNeededPackage]  = deriveEncoder[NotNeededPackage]
  implicit val NotNeededPackageDecoder:  Decoder[NotNeededPackage]  = deriveDecoder[NotNeededPackage]
  implicit val NotNeededPackagesEncoder: Encoder[NotNeededPackages] = deriveEncoder[NotNeededPackages]
  implicit val NotNeededPackagesDecoder: Decoder[NotNeededPackages] = deriveDecoder[NotNeededPackages]
  implicit val TypingsJsonEncoder:       Encoder[TypingsJson]       = deriveEncoder[TypingsJson]
  implicit val TypingsJsonDecoder:       Decoder[TypingsJson]       = deriveDecoder[TypingsJson]

}

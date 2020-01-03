package org.scalablytyped.converter.internal
package importer

import java.io.File
import java.net.URI

import org.scalablytyped.converter.internal.ts._
import io.circe._

object jsonCodecs {
  implicit val FileEncoder:           Encoder[File]           = Encoder[String].contramap[File](_.toString)
  implicit val FileDecoder:           Decoder[File]           = Decoder[String].map[File](new File(_))
  implicit val RelPathDecoder:        Decoder[os.RelPath]     = Decoder[String].map(str => os.RelPath(str.dropWhile(_ === '/')))
  implicit val RelPathEncoder:        Encoder[os.RelPath]     = Encoder[String].contramap[os.RelPath](_.toString)
  implicit val PathDecoder:           Decoder[os.Path]        = Decoder[String].map(str => os.Path(str))
  implicit val PathEncoder:           Encoder[os.Path]        = Encoder[String].contramap[os.Path](_.toString)
  implicit val URIDecoder:            Decoder[URI]            = Decoder[String].map(new URI(_))
  implicit val URIEncoder:            Encoder[URI]            = Encoder[String].contramap[URI](_.toString)
  implicit val TsIdentLibraryDecoder: Decoder[TsIdentLibrary] = Decoder[String].map(TsIdentLibrary.apply)
  implicit val TsIdentLibraryEncoder: Encoder[TsIdentLibrary] = Encoder[String].contramap[TsIdentLibrary](_.value)

  implicit val TsIdentLibraryMapDecoder: Decoder[Map[TsIdentLibrary, String]] =
    Decoder[Map[String, String]].map(_.map { case (k, v) => TsIdentLibrary(k) -> v })

  implicit val TsIdentLibraryMapEncoder: Encoder[Map[TsIdentLibrary, String]] =
    Encoder[Map[String, String]].contramap[Map[TsIdentLibrary, String]](_.map { case (k, v) => k.value -> v })

  import io.circe.generic.semiauto._

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

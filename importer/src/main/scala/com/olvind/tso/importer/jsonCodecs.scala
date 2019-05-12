package com.olvind.tso
package importer

import java.net.URI

import ammonite.ops.RelPath
import com.olvind.tso.ts._
import io.circe._

object jsonCodecs {
  implicit val RelPathDecoder: Decoder[RelPath] = Decoder[String].map(str => RelPath(str.dropWhile(_ === '/')))
  implicit val RelPathEncoder: Encoder[RelPath] = Encoder[String].contramap[RelPath](_.toString)
  implicit val URIDecoder:     Decoder[URI]     = Decoder[String].map(new URI(_))
  implicit val URIEncoder:     Encoder[URI]     = Encoder[String].contramap[URI](_.toString)

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

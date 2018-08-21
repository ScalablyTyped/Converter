package com.olvind.tso.importer

import java.net.URI

import ammonite.ops.RelPath
import com.olvind.tso.ts._
import com.olvind.tso.{Comment, Comments}
import io.circe._

object jsonCodecs extends MetadataCodecs with TreeCodecs

trait MetadataCodecs {

  implicit val RelPathDecoder: Decoder[RelPath] = Decoder[String].map(str => RelPath(str))
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

trait TreeCodecsLower {
  implicit val CommentEncoder:  Encoder[Comment]  = Encoder[String].contramap[Comment](_.raw)
  implicit val CommentDecoder:  Decoder[Comment]  = Decoder[String].map(Comment.apply)
  implicit val CommentsEncoder: Encoder[Comments] = Encoder[List[Comment]].contramap[Comments](_.cs)
  implicit val CommentsDecoder: Decoder[Comments] = Decoder[List[Comment]].map(Comments.apply)

  import io.circe.generic.auto._

  implicit val TsIdentEncoder:           Encoder[TsIdent]           = exportEncoder[TsIdent].instance
  implicit val TsIdentDecoder:           Decoder[TsIdent]           = exportDecoder[TsIdent].instance
  implicit val TsIdentLibraryEncoder:    Encoder[TsIdentLibrary]    = exportEncoder[TsIdentLibrary].instance
  implicit val TsIdentLibraryDecoder:    Decoder[TsIdentLibrary]    = exportDecoder[TsIdentLibrary].instance
  implicit val TsIdentModuleEncoder:     Encoder[TsIdentModule]     = exportEncoder[TsIdentModule].instance
  implicit val TsIdentModuleDecoder:     Decoder[TsIdentModule]     = exportDecoder[TsIdentModule].instance
  implicit val TsQIdentEncoder:          Encoder[TsQIdent]          = exportEncoder[TsQIdent].instance
  implicit val TsQIdentDecoder:          Decoder[TsQIdent]          = exportDecoder[TsQIdent].instance
  implicit val CodePathEncoder:          Encoder[CodePath]          = exportEncoder[CodePath].instance
  implicit val CodePathDecoder:          Decoder[CodePath]          = exportDecoder[CodePath].instance
  implicit val TsLiteralEncoder:         Encoder[TsLiteral]         = exportEncoder[TsLiteral].instance
  implicit val TsLiteralDecoder:         Decoder[TsLiteral]         = exportDecoder[TsLiteral].instance
  implicit val TsTypeRefEncoder:         Encoder[TsTypeRef]         = exportEncoder[TsTypeRef].instance
  implicit val TsTypeRefDecoder:         Decoder[TsTypeRef]         = exportDecoder[TsTypeRef].instance
  implicit val TsTypeEncoder:            Encoder[TsType]            = exportEncoder[TsType].instance
  implicit val TsTypeDecoder:            Decoder[TsType]            = exportDecoder[TsType].instance
  implicit val TsMemberEncoder:          Encoder[TsMember]          = exportEncoder[TsMember].instance
  implicit val TsMemberDecoder:          Decoder[TsMember]          = exportDecoder[TsMember].instance
  implicit val TsImportEncoder:          Encoder[TsImport]          = exportEncoder[TsImport].instance
  implicit val TsImportDecoder:          Decoder[TsImport]          = exportDecoder[TsImport].instance
  implicit val TsDeclEncoder:            Encoder[TsDecl]            = exportEncoder[TsDecl].instance
  implicit val TsDeclDecoder:            Decoder[TsDecl]            = exportDecoder[TsDecl].instance
  implicit val TsContainerOrDeclEncoder: Encoder[TsContainerOrDecl] = exportEncoder[TsContainerOrDecl].instance
  implicit val TsContainerOrDeclDecoder: Decoder[TsContainerOrDecl] = exportDecoder[TsContainerOrDecl].instance
  implicit val TsParsedFileEncoder:      Encoder[TsParsedFile]      = exportEncoder[TsParsedFile].instance
  implicit val TsParsedFileDecoder:      Decoder[TsParsedFile]      = exportDecoder[TsParsedFile].instance
}

trait TreeCodecs extends TreeCodecsLower {

  implicit val StringOrTsParsedEncoder: Encoder[Either[String, TsParsedFile]] =
    Encoder.encodeEither("error", "parsed")(Encoder[String], TsParsedFileEncoder)
  implicit val StringOrTsParsedDecoder: Decoder[Either[String, TsParsedFile]] =
    Decoder.decodeEither("error", "parsed")(Decoder[String], TsParsedFileDecoder)
}

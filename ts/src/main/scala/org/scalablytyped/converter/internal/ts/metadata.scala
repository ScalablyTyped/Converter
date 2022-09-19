package org.scalablytyped.converter.internal
package ts

import io.circe013.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe013.{Decoder, Encoder, Json}
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.orphanCodecs._

import scala.collection.immutable.SortedMap

case class CompilerOptions(
    module:                           Option[String],
    lib:                              Option[IArray[String]],
    noImplicitAny:                    Option[Boolean],
    noImplicitThis:                   Option[Boolean],
    strictNullChecks:                 Option[Boolean],
    baseUrl:                          Option[os.RelPath],
    typeRoots:                        Option[IArray[os.RelPath]],
    types:                            Option[IArray[String]],
    noEmit:                           Option[Boolean],
    forceConsistentCasingInFileNames: Option[Boolean],
)

object CompilerOptions {
  implicit val encodes: Encoder[CompilerOptions] = deriveEncoder
  implicit val decodes: Decoder[CompilerOptions] = deriveDecoder
}

case class TsConfig(
    compilerOptions: Option[CompilerOptions],
    files:           Option[IArray[String]],
)

object TsConfig {
  implicit val encodes: Encoder[TsConfig] = deriveEncoder
  implicit val decodes: Decoder[TsConfig] = deriveDecoder
}

case class PackageJson(
    version:          Option[String],
    dependencies:     Option[Map[TsIdentLibrary, String]],
    devDependencies:  Option[Map[TsIdentLibrary, String]],
    peerDependencies: Option[Map[TsIdentLibrary, String]],
    typings:          Option[Json],
    module:           Option[Json],
    types:            Option[Json],
    files:            Option[IArray[String]],
    dist:             Option[PackageJson.Dist],
    exports:          Option[Json],
) {
  def allLibs(dev: Boolean, peer: Boolean): SortedMap[TsIdentLibrary, String] =
    smash(IArray.fromOptions(dependencies, devDependencies.filter(_ => dev), peerDependencies.filter(_ => peer))).toSorted

  def parsedTypes: Option[IArray[String]] =
    types
      .map { types =>
        types.fold(
          IArray.Empty,
          _ => sys.error(s"unexpected boolean in types structure: $types"),
          _ => sys.error(s"unexpected number in types structure: $types"),
          IArray(_),
          arr => IArray.fromTraversable(arr).mapNotNone(_.asString),
          _   => sys.error(s"unexpected object in types structure: $types"),
        )
      }
      .filter(_.nonEmpty)

  def parsedTypings: Option[IArray[String]] =
    typings
      .map { typings =>
        typings.fold(
          IArray.Empty,
          _ => sys.error(s"unexpected boolean in typings structure: $typings"),
          _ => sys.error(s"unexpected number in typings structure: $typings"),
          IArray(_),
          arr => IArray.fromTraversable(arr).mapNotNone(_.asString),
          _   => sys.error(s"unexpected object in typings structure: $typings"),
        )
      }
      .filter(_.nonEmpty)

  def parsedModules: Option[Map[String, String]] = {
    def look(json: Json): Map[String, String] =
      json.fold[Map[String, String]](
        Map.empty,
        _   => Map.empty,
        _   => Map.empty,
        str => Map("" -> str),
        _   => Map.empty,
        obj => obj.toMap.flatMap { case (name, value) => value.asString.map(str => (name, str)) },
      )

    module.map(look).filter(_.nonEmpty)
  }

  // this is an impossibly flexibly defined structure, so we're maximally flexible in this parse step
  // we only extract the `types` information for now
  def parsedExported: Option[Map[String, String]] = {
    def look(json: Json): Map[String, String] =
      json.fold[Map[String, String]](
        Map.empty,
        _      => Map.empty,
        _      => Map.empty,
        _      => Map.empty,
        values => maps.smash(IArray.fromTraversable(values.map(look))),
        obj =>
          obj.toMap.flatMap {
            case (name, value) =>
              val maybe = for {
                obj <- value.asObject
                types <- obj.toMap.get("types")
                typesString <- types.asString
              } yield typesString
              maybe.map(tpe => (name, tpe))
          },
      )

    exports.map(look).filter(_.nonEmpty)
  }
}

object PackageJson {
  case class Dist(tarball: String)

  object Dist {
    implicit val encodes:     Encoder[Dist] = deriveEncoder
    implicit val decodesDist: Decoder[Dist] = deriveDecoder
  }

  val Empty: PackageJson = PackageJson(None, None, None, None, None, None, None, None, None, None)

  implicit val encodes: Encoder[PackageJson] = deriveEncoder
  implicit val decodes: Decoder[PackageJson] = deriveDecoder
}

case class NotNeededPackage(libraryName: TsIdentLibrary, asOfVersion: String)

object NotNeededPackage {
  implicit val encodes: Encoder[NotNeededPackage] = deriveEncoder
  implicit val decodes: Decoder[NotNeededPackage] = deriveDecoder
}

case class TypingsJson(
    name:   String,
    main:   String,
    files:  IArray[String],
    global: Boolean,
)

object TypingsJson {
  implicit val encodes: Encoder[TypingsJson] = deriveEncoder
  implicit val decodes: Decoder[TypingsJson] = deriveDecoder
}

case class NotNeededPackages(packages: Map[String, NotNeededPackage])

object NotNeededPackages {
  implicit val encodes: Encoder[NotNeededPackages] = deriveEncoder
  implicit val decodes: Decoder[NotNeededPackages] = {
    val old = deriveDecoder[NotNeededPackages]

    // at some point they changed the format, this is the new one
    val array = Decoder[Vector[NotNeededPackage]]
      .map { ps =>
        NotNeededPackages(ps.map(p => p.libraryName.value -> p).toMap)
      }
      .at("packages")

    old.or(array)
  }
}

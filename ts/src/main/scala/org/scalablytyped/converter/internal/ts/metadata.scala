package org.scalablytyped.converter.internal
package ts

import io.circe013.{Decoder, Encoder}
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
  implicit val encodes: Encoder[CompilerOptions] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[CompilerOptions] = io.circe013.generic.semiauto.deriveDecoder
}

case class TsConfig(
    compilerOptions: Option[CompilerOptions],
    files:           Option[IArray[String]],
)

object TsConfig {
  implicit val encodes: Encoder[TsConfig] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[TsConfig] = io.circe013.generic.semiauto.deriveDecoder
}

case class PackageJson(
    version:          Option[String],
    dependencies:     Option[Map[TsIdentLibrary, String]],
    devDependencies:  Option[Map[TsIdentLibrary, String]],
    peerDependencies: Option[Map[TsIdentLibrary, String]],
//    browser:          Option[String], this seems to be a bit more complicated
    module:           Option[String],
    main:             Option[String],
    es2015:           Option[String],
    esm2015:          Option[String],
    fesm2015:         Option[String],
    typings:          Option[String],
    types:            Option[String],
    files:            Option[IArray[String]],
) {
  def allLibs(dev: Boolean, peer: Boolean): SortedMap[TsIdentLibrary, String] =
    smash(IArray.fromOptions(dependencies, devDependencies.filter(_ => dev), peerDependencies.filter(_ => peer))).toSorted
}

object PackageJson {
  val Empty: PackageJson = PackageJson(None, None, None, None, None, None, None, None, None, None, None, None)

  implicit val encodes: Encoder[PackageJson] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[PackageJson] = io.circe013.generic.semiauto.deriveDecoder
}

case class NotNeededPackage(libraryName: TsIdentLibrary, asOfVersion: String)

object NotNeededPackage {
  implicit val encodes: Encoder[NotNeededPackage] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[NotNeededPackage] = io.circe013.generic.semiauto.deriveDecoder
}

case class TypingsJson(
    name:   String,
    main:   String,
    files:  IArray[String],
    global: Boolean,
)

object TypingsJson {
  implicit val encodes: Encoder[TypingsJson] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[TypingsJson] = io.circe013.generic.semiauto.deriveDecoder
}

case class NotNeededPackages(packages: Map[String, NotNeededPackage])

object NotNeededPackages {
  implicit val encodes: Encoder[NotNeededPackages] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[NotNeededPackages] = io.circe013.generic.semiauto.deriveDecoder
}

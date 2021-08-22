package org.scalablytyped.converter.internal
package ts

import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.sets.SetOps
import org.scalablytyped.converter.internal.orphanCodecs._

import scala.collection.immutable.SortedSet

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

case class PackageJsonDeps(
    version:          Option[String],
    dependencies:     Option[Map[String, String]],
    devDependencies:  Option[Map[String, String]],
    peerDependencies: Option[Map[String, String]],
    typings:          Option[String],
    module:           Option[String],
    types:            Option[String],
    files:            Option[IArray[String]],
) {
  def allLibs(dev: Boolean, peer: Boolean): SortedSet[String] =
    Set(dependencies, devDependencies.filter(_ => dev), peerDependencies.filter(_ => peer)).flatten
      .flatMap(_.keys)
      .sorted
}

object PackageJsonDeps {
  implicit val encodes: Encoder[PackageJsonDeps] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[PackageJsonDeps] = io.circe013.generic.semiauto.deriveDecoder
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

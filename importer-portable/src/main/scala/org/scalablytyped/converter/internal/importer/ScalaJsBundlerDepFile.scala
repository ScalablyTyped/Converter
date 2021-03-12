package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}
import io.circe.syntax._

object ScalaJsBundlerDepFile {

  /** Name of the file containing the NPM dependencies */
  val manifestFileName = "NPM_DEPENDENCIES"

  type Dependencies = List[Map[String, String]]

  case class NpmDependencies(
      `compile-dependencies`:    Dependencies,
      `test-dependencies`:       Dependencies,
      `compile-devDependencies`: Dependencies,
      `test-devDependencies`:    Dependencies,
  )

  object NpmDependencies {
    implicit val Encoder: Encoder[NpmDependencies] = deriveEncoder[NpmDependencies]
    implicit val Decoder: Decoder[NpmDependencies] = deriveDecoder[NpmDependencies]
  }

  def apply(libName: TsIdentLibrary, v: LibraryVersion): Map[os.RelPath, Array[Byte]] =
    (v.libraryVersion, v.inGit) match {
      case (Some(version), None) if libName =/= ts.TsIdent.std =>
        val deps = List(Map(libName.value -> version))
        Map(
          os.RelPath(ScalaJsBundlerDepFile.manifestFileName) ->
            NpmDependencies(
              `compile-dependencies`    = deps,
              `test-dependencies`       = deps,
              `compile-devDependencies` = Nil,
              `test-devDependencies`    = Nil,
            ).asJson.spaces2.getBytes(constants.Utf8),
        )
      case _ => Map.empty
    }
}

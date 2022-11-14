package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.ts.TsIdentLibrary
import io.circe013.{Decoder, Encoder}
import io.circe013.syntax._

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
    implicit val Encoder: Encoder[NpmDependencies] = io.circe013.generic.semiauto.deriveEncoder
    implicit val Decoder: Decoder[NpmDependencies] = io.circe013.generic.semiauto.deriveDecoder
  }

  def apply(libName: TsIdentLibrary, v: LibraryVersion): IArray[(os.RelPath, String)] =
    (v.libraryVersion, v.inGit) match {
      case (Some(version), None) if libName =/= ts.TsIdent.std =>
        val deps = List(Map(libName.value -> version))
        IArray(
          os.RelPath(ScalaJsBundlerDepFile.manifestFileName) ->
            NpmDependencies(
              `compile-dependencies`    = deps,
              `test-dependencies`       = deps,
              `compile-devDependencies` = Nil,
              `test-devDependencies`    = Nil,
            ).asJson.spaces2,
        )
      case _ => Empty
    }
}

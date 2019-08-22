package com.olvind.tso
package importer

import com.olvind.tso.ts.TsIdentLibrary
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

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

  def write(dir: os.Path, libName: TsIdentLibrary, v: LibraryVersion): Unit =
    (v.libraryVersion, v.inGit) match {
      case (Some(version), None) if libName =/= ts.TsIdent.std =>
        val deps = List(Map(libName.value -> version))
        Json.persist(dir / manifestFileName)(
          NpmDependencies(
            `compile-dependencies`    = deps,
            `test-dependencies`       = deps,
            `compile-devDependencies` = Nil,
            `test-devDependencies`    = Nil,
          ),
        )
        ()
      case _ => ()
    }
}

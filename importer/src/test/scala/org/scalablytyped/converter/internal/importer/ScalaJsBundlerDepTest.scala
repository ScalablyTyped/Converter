package org.scalablytyped.converter.internal.importer

import io.circe013.parser._
import io.circe013.syntax._
import org.scalablytyped.converter.internal.importer.ScalaJsBundlerDepFile.NpmDependencies
import org.scalatest.funsuite.AnyFunSuite

class ScalaJsBundlerDepTest extends AnyFunSuite {
  val content =
    """{"compile-dependencies":[{"@material-ui/core":"3.9.3"},{"@material-ui/icons":"3.0.2"},{"react":"16.9"},{"react-dom":"16.9"}],"test-dependencies":[{"@material-ui/core":"3.9.3"},{"@material-ui/icons":"3.0.2"},{"react":"16.9"},{"react-dom":"16.9"}],"compile-devDependencies":[],"test-devDependencies":[]}"""

  val deps = List(
    Map("@material-ui/core" -> "3.9.3"),
    Map("@material-ui/icons" -> "3.0.2"),
    Map("react" -> "16.9"),
    Map("react-dom" -> "16.9"),
  )

  val expected = NpmDependencies(deps, deps, Nil, Nil)

  test("parses existing") {
    assert(decode[ScalaJsBundlerDepFile.NpmDependencies](content) === Right(expected))
  }

  test("roundtrips") {
    assert(decode[ScalaJsBundlerDepFile.NpmDependencies](expected.asJson.spaces4) === Right(expected))
  }
}

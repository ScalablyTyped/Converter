package com.olvind.tso.importer

import com.olvind.tso.ts._
import com.olvind.tso.importer.jsonCodecs._
import io.circe.parser._
import org.scalatest.FunSuite

class JsonTests extends FunSuite {

  test("tsconfig") {

    val content = """
  {
      "compilerOptions": {
          "module": "commonjs",
          "lib": [
              "es6"
          ],
          "noImplicitAny": true,
          "noImplicitThis": true,
          "strictNullChecks": true,
          "baseUrl": "../",
          "typeRoots": [
              "../"
          ],
          "types": [],
          "noEmit": true,
          "forceConsistentCasingInFileNames": true
      },
      "files": [
          "index.d.ts",
          "range-parser-tests.ts"
      ]
  }"""

    val expected = TsConfig(
      Some(
        CompilerOptions(
          module                           = Option("commonjs"),
          lib                              = Option(Vector("es6")),
          noImplicitAny                    = Option(true),
          noImplicitThis                   = Option(true),
          strictNullChecks                 = Option(true),
          baseUrl                          = Some(os.RelPath("../")),
          typeRoots                        = Some(Vector(os.RelPath("../"))),
          types                            = Some(Vector()),
          noEmit                           = Some(true),
          forceConsistentCasingInFileNames = Some(true),
        ),
      ),
      Some(
        Vector(
          "index.d.ts",
          "range-parser-tests.ts",
        ),
      ),
    )
    assert(decode[TsConfig](content) === Right(expected))
  }

  test("notNeededPackages.json") {
    val content = """{
    "packages": [
        {
            "libraryName": "ajv",
            "typingsPackageName": "ajv",
            "sourceRepoURL": "https://github.com/epoberezkin/ajv",
            "asOfVersion": "1.0.0"
        },
        {
            "libraryName": "antd",
            "typingsPackageName": "antd",
            "sourceRepoURL": "git@github.com:KyleAMathews/deepmerge.git",
            "asOfVersion": "1.0.0"
        }]}
"""
    val expected =
      NotNeededPackages(
        Vector(
          NotNeededPackage("ajv", TsIdentLibrary("ajv"), "https://github.com/epoberezkin/ajv", "1.0.0"),
          NotNeededPackage("antd", TsIdentLibrary("antd"), "git@github.com:KyleAMathews/deepmerge.git", "1.0.0"),
        ),
      )

    assert(decode[NotNeededPackages](content) === Right(expected))
  }

  test("typings.json") {
    val content = """{
  "name": "phaser",
  "main": "phaser.comments.d.ts",
  "files": ["pixi.comments.d.ts", "p2.d.ts"],
  "global": true
}
"""
    val expected =
      TypingsJson(
        "phaser",
        "phaser.comments.d.ts",
        List("pixi.comments.d.ts", "p2.d.ts"),
        true,
      )

    assert(decode[TypingsJson](content) === Right(expected))
  }
}

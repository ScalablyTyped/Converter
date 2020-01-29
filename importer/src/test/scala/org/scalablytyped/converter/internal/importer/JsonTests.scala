package org.scalablytyped.converter.internal.importer

import io.circe.parser._
import org.scalablytyped.converter.internal.IArray
import org.scalablytyped.converter.internal.importer.jsonCodecs._
import org.scalablytyped.converter.internal.ts._
import org.scalatest.funsuite.AnyFunSuite

class JsonTests extends AnyFunSuite {

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
          lib                              = Option(IArray("es6")),
          noImplicitAny                    = Option(true),
          noImplicitThis                   = Option(true),
          strictNullChecks                 = Option(true),
          baseUrl                          = Some(os.RelPath("../")),
          typeRoots                        = Some(IArray(os.RelPath("../"))),
          types                            = Some(IArray.Empty),
          noEmit                           = Some(true),
          forceConsistentCasingInFileNames = Some(true),
        ),
      ),
      Some(
        IArray(
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
        IArray(
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
        IArray("pixi.comments.d.ts", "p2.d.ts"),
        true,
      )

    assert(decode[TypingsJson](content) === Right(expected))
  }

  test("summary.json") {
    val content = """{
  "successes": [
    {
      "TsIdentLibraryScoped": {
        "scope": "feathersjs",
        "nameOpt": "authentication-oauth2"
      }
    },
    {
      "TsIdentLibraryScoped": {
        "scope": "feathersjs"
      }
    }
  ],
  "failures": []
}
"""
    val expected =
      Summary(
        Set(TsIdentLibraryScoped("feathersjs", "authentication-oauth2"), TsIdentLibrarySimple("@feathersjs")),
        Set(),
      )

    assert(decode[Summary](content) === Right(expected))
  }
}

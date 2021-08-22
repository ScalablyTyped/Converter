package org.scalablytyped.converter.internal.importer

import org.scalablytyped.converter.internal.{IArray, Json}
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
    assert(Json[TsConfig](content) === Right(expected))
  }

  test("notNeededPackages.json") {
    val content = """{
    "packages": {
        "3d-bin-packing": {
            "libraryName": "3d-bin-packing",
            "asOfVersion": "1.1.3"
        },
        "a11y-dialog": {
            "libraryName": "a11y-dialog",
            "asOfVersion": "5.3.2"
        }
    }
}"""
    val expected =
      NotNeededPackages(
        Map(
          "3d-bin-packing" -> NotNeededPackage(TsIdentLibrary("3d-bin-packing"), "1.1.3"),
          "a11y-dialog" -> NotNeededPackage(TsIdentLibrary("a11y-dialog"), "5.3.2"),
        ),
      )

    assert(Json[NotNeededPackages](content) === Right(expected))
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

    assert(Json[TypingsJson](content) === Right(expected))
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

    assert(Json[Summary](content) === Right(expected))
  }
}

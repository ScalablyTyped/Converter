package org.scalablytyped.converter.internal.importer

import org.scalablytyped.converter.internal.Json
import org.scalablytyped.converter.internal.ts.PackageJson
import org.scalatest.funsuite.AnyFunSuite

class ExportsJsonTest extends AnyFunSuite {
  test("no - 1") {
    val content =
      """{"exports": [
        |        {
        |          "default": "./index.js"
        |        },
        |        "./index.js"
        |      ]
        |}""".stripMargin
    val actual = Json.force[PackageJson](content).parsedExported

    assert(actual === None)
  }

  test("no - 2") {
    val content =
      """{"exports": {
        |        "import": "./build/lib/index.js",
        |        "require": "./build/index.cjs"
        |      }
        |}""".stripMargin
    val actual = Json.force[PackageJson](content).parsedExported

    assert(actual === None)
  }
  test("no - 3") {
    val content =
      """{"exports": {
        |        ".": [
        |          {
        |            "import": "./build/lib/index.js",
        |            "require": "./build/index.cjs"
        |          },
        |          "./build/index.cjs"
        |        ]
        |      }
        |}""".stripMargin
    val actual = Json.force[PackageJson](content).parsedExported

    assert(actual === None)
  }
  test("no - 4") {
    val content =
      """{"exports": {
        |        ".": [
        |          {
        |            "import": "./build/lib/index.js",
        |            "require": "./build/index.cjs"
        |          },
        |          "./build/index.cjs"
        |        ],
        |        "./browser": [
        |          "./browser.js"
        |        ]
        |      }}""".stripMargin
    val actual = Json.force[PackageJson](content).parsedExported

    assert(actual === None)
  }

  test("no - 5") {
    val content =
      """{"exports": "picocolors.js"}""".stripMargin
    val actual = Json.force[PackageJson](content).parsedExported

    assert(actual === None)
  }

  test("yes - 5") {
    val content =
      """{"exports": {
        |    "./analytics": {
        |      "types": "./analytics/dist/analytics/index.d.ts",
        |      "node": {
        |        "require": "./analytics/dist/index.cjs.js",
        |        "import": "./analytics/dist/index.mjs"
        |      },
        |      "default": "./analytics/dist/index.esm.js"
        |    },
        |    "./app": {
        |      "types": "./app/dist/app/index.d.ts",
        |      "node": {
        |        "require": "./app/dist/index.cjs.js",
        |        "import": "./app/dist/index.mjs"
        |      },
        |      "default": "./app/dist/index.esm.js"
        |    },
        |    "./package.json": "./package.json"
        |  }}""".stripMargin
    val actual = Json.force[PackageJson](content).parsedExported
    val expected = Some(
      Map(
        "./analytics" -> "./analytics/dist/analytics/index.d.ts",
        "./app" -> "./app/dist/app/index.d.ts",
      ),
    )
    assert(actual === expected)
  }
}

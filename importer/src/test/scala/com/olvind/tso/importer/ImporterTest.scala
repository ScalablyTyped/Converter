package com.olvind
package tso
package importer

import org.scalatest.FunSuite

class ImporterTest extends FunSuite with ImporterHarness {
  // todo: automatically update locally, check in ci. Seems the build is not deterministic!
  val update = sys.env.get("CIRCLECI").isEmpty

  test("augment-module")(assertImportsOk("augment-module", update))
  test("typings-json")(assertImportsOk("typings-json", update))
  test("export-as-namespace")(assertImportsOk("export-as-namespace", update))
  test("react-transition-group")(assertImportsOk("react-transition-group", update))
  test("bigint")(assertImportsOk("bigint", update))
  test("react-icons")(assertImportsOk("react-icons", update))
  test("vue")(assertImportsOk("vue", update))
  test("sax")(assertImportsOk("sax", update))
  test("serve-static")(assertImportsOk("serve-static", update))
  test("tstl")(assertImportsOk("tstl", update))
  test("react-select")(assertImportsOk("react-select", update))
  test("numjs")(assertImportsOk("numjs", update))
  test("rxjs")(assertImportsOk("rxjs", update))
  test("material-ui")(assertImportsOk("material-ui", update))
  test("virtual-dom")(assertImportsOk("virtual-dom", update))
  test("fp-ts")(assertImportsOk("fp-ts", update))
  test("monaco-editor")(assertImportsOk("monaco-editor", update))
  test("chart.js")(assertImportsOk("chart.js", update))
  test("fullcalendar")(assertImportsOk("fullcalendar", update))
  test("stylis")(assertImportsOk("stylis", update))
  test("mongoose-simple-random")(assertImportsOk("mongoose-simple-random", update))
  test("electron")(assertImportsOk("electron", update))
  test("aws-sdk")(assertImportsOk("aws-sdk", update))
  test("winston")(assertImportsOk("winston", update))
  test("commander")(assertImportsOk("commander", update))
  test("with-theme")(assertImportsOk("with-theme", update))
  test("create-error") { assertImportsOk("create-error", update) }
  test("react-bootstrap")(assertImportsOk("react-bootstrap", update))
  test("insight")(assertImportsOk("insight", update))
  test("cldrjs")(assertImportsOk("cldrjs", update))
  test("void-elements")(assertImportsOk("void-elements", update))
  test("type-mappings")(assertImportsOk("type-mappings", update))
  test("swiz")(assertImportsOk("swiz", update))
}

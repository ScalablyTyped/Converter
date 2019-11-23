package com.olvind
package tso
package importer

import org.scalatest.{FunSuite, ParallelTestExecution}

class ImporterTest extends FunSuite with ImporterHarness with ParallelTestExecution {
  val update = !constants.isCi

  test("augment-module")(assertImportsOk("augment-module", pedantic                 = false, update = update))
  test("typings-json")(assertImportsOk("typings-json", pedantic                     = true, update  = update))
  test("export-as-namespace")(assertImportsOk("export-as-namespace", pedantic       = true, update  = update))
  test("bigint")(assertImportsOk("bigint", pedantic                                 = true, update  = update))
  test("react-icons")(assertImportsOk("react-icons", pedantic                       = true, update  = update))
  test("vue")(assertImportsOk("vue", pedantic                                       = true, update  = update))
  test("sax")(assertImportsOk("sax", pedantic                                       = true, update  = update))
  test("serve-static")(assertImportsOk("serve-static", pedantic                     = true, update  = update))
  test("tstl")(assertImportsOk("tstl", pedantic                                     = true, update  = update))
  test("react-select")(assertImportsOk("react-select", pedantic                     = true, update  = update))
  test("numjs")(assertImportsOk("numjs", pedantic                                   = true, update  = update))
  test("rxjs")(assertImportsOk("rxjs", pedantic                                     = true, update  = update))
  test("virtual-dom")(assertImportsOk("virtual-dom", pedantic                       = true, update  = update))
  test("fp-ts")(assertImportsOk("fp-ts", pedantic                                   = true, update  = update))
  test("monaco-editor")(assertImportsOk("monaco-editor", pedantic                   = true, update  = update))
  test("chart.js")(assertImportsOk("chart.js", pedantic                             = true, update  = update))
  test("fullcalendar")(assertImportsOk("fullcalendar", pedantic                     = true, update  = update))
  test("stylis")(assertImportsOk("stylis", pedantic                                 = true, update  = update))
  test("mongoose-simple-random")(assertImportsOk("mongoose-simple-random", pedantic = true, update  = update))
  test("electron")(assertImportsOk("electron", pedantic                             = true, update  = update))
  test("aws-sdk")(assertImportsOk("aws-sdk", pedantic                               = true, update  = update))
  test("winston")(assertImportsOk("winston", pedantic                               = true, update  = update))
  test("commander")(assertImportsOk("commander", pedantic                           = true, update  = update))
  test("with-theme")(assertImportsOk("with-theme", pedantic                         = true, update  = update))
  test("create-error")(assertImportsOk("create-error", pedantic                     = true, update  = update))
  test("insight")(assertImportsOk("insight", pedantic                               = true, update  = update))
  test("cldrjs")(assertImportsOk("cldrjs", pedantic                                 = true, update  = update))
  test("void-elements")(assertImportsOk("void-elements", pedantic                   = true, update  = update))
  test("type-mappings")(assertImportsOk("type-mappings", pedantic                   = true, update  = update))
  test("swiz")(assertImportsOk("swiz", pedantic                                     = true, update  = update))
  test("defaulted-tparams")(assertImportsOk("defaulted-tparams", pedantic           = true, update  = update))
  test("union-to-inheritance")(assertImportsOk("union-to-inheritance", pedantic     = true, update  = update))
  test("expand-type-parameters")(assertImportsOk("expand-type-parameters", pedantic = true, update  = update))
  test("const-enum")(assertImportsOk("const-enum", pedantic                         = true, update  = update))
  test("firebase-admin")(assertImportsOk("firebase-admin", pedantic                 = true, update  = update))

  test("material-ui")(
    assertImportsOk("material-ui", pedantic = true, update = update),
  )
  test("material-ui-slinky")(
    assertImportsOk("material-ui", pedantic = true, update = update, flavour = Flavour.reactSlinky),
  )
  test("material-ui-japgolly")(
    assertImportsOk("material-ui", pedantic = true, update = update, flavour = Flavour.reactJapgolly),
  )

  test("react-bootstrap")(
    assertImportsOk("react-bootstrap", pedantic = true, update = update),
  )
  test("react-bootstrap-slinky")(
    assertImportsOk("react-bootstrap", pedantic = true, update = update, flavour = Flavour.reactSlinky),
  )
  test("react-bootstrap-japgolly")(
    assertImportsOk("react-bootstrap", pedantic = true, update = update, flavour = Flavour.reactJapgolly),
  )

  test("react-transition-group")(
    assertImportsOk("react-transition-group", pedantic = true, update = update),
  )
  test("react-transition-group-slinky")(
    assertImportsOk("react-transition-group", pedantic = true, update = update, flavour = Flavour.reactSlinky),
  )
  test("react-transition-group-japgolly")(
    assertImportsOk("react-transition-group", pedantic = true, update = update, flavour = Flavour.reactJapgolly),
  )

  test("semantic-ui-react")(
    assertImportsOk("semantic-ui-react", pedantic = false, update = update),
  )
  test("semantic-ui-react-slinky")(
    assertImportsOk("semantic-ui-react", pedantic = false, update = update, flavour = Flavour.reactSlinky),
  )
  test("semantic-ui-react-japgolly")(
    assertImportsOk("semantic-ui-react", pedantic = false, update = update, flavour = Flavour.reactJapgolly),
  )

  test("react-contextmenu")(
    assertImportsOk("react-contextmenu", pedantic = false, update = update),
  )
  test("react-contextmenu-slinky")(
    assertImportsOk("react-contextmenu", pedantic = false, update = update, flavour = Flavour.reactSlinky),
  )
  test("react-contextmenu-japgolly")(
    assertImportsOk("react-contextmenu", pedantic = false, update = update, flavour = Flavour.reactJapgolly),
  )

  test("react-dropzone")(
    assertImportsOk("react-dropzone", pedantic = false, update = update),
  )
  test("react-dropzone-slinky")(
    assertImportsOk("react-dropzone", pedantic = false, update = update, flavour = Flavour.reactSlinky),
  )
  test("react-dropzone-japgolly")(
    assertImportsOk("react-dropzone", pedantic = false, update = update, flavour = Flavour.reactJapgolly),
  )
}

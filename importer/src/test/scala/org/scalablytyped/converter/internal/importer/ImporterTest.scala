package org.scalablytyped.converter
package internal
package importer

import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalablytyped.converter.internal.scalajs.flavours.{JapgollyFlavour, SlinkyFlavour}
import org.scalatest.ParallelTestExecution
import org.scalatest.funsuite.AnyFunSuite

class ImporterTest213 extends ImporterTest {
  override def version: Versions = Versions(Versions.Scala213, Versions.ScalaJs1)
}

class ImporterTest extends AnyFunSuite with ImporterHarness with ParallelTestExecution {
  val update   = !constants.isCi
  val Slinky   = SlinkyFlavour(Name("typingsSlinky"), enableLongApplyMethod = false, version, Selection.None)
  val Japgolly = JapgollyFlavour(Name("typingsJapgolly"), enableLongApplyMethod = false, version, Selection.All)
  val JapgollyLong =
    JapgollyFlavour(Name("typingsJapgolly"), enableLongApplyMethod = true, version, Selection.All)

  test("augment-module")(assertImportsOk("augment-module", pedantic                 = false, update = update))
  test("typings-json")(assertImportsOk("typings-json", pedantic                     = true, update  = update))
  test("export-as-namespace")(assertImportsOk("export-as-namespace", pedantic       = true, update  = update))
  test("babylon")(assertImportsOk("babylon", pedantic                               = true, update  = update))
  test("bigint")(assertImportsOk("bigint", pedantic                                 = true, update  = update))
  test("react-icons")(assertImportsOk("react-icons", pedantic                       = true, update  = update))
  test("vue")(assertImportsOk("vue", pedantic                                       = true, update  = update))
  test("sax")(assertImportsOk("sax", pedantic                                       = true, update  = update))
  test("serve-static")(assertImportsOk("serve-static", pedantic                     = true, update  = update))
  test("tstl")(assertImportsOk("tstl", pedantic                                     = true, update  = update))
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
  test("interface-package")(assertImportsOk("interface-package", pedantic           = true, update  = update))
  test("cldrjs")(assertImportsOk("cldrjs", pedantic                                 = true, update  = update))
  test("void-elements")(assertImportsOk("void-elements", pedantic                   = true, update  = update))
  test("type-mappings")(assertImportsOk("type-mappings", pedantic                   = true, update  = update))
  test("documentation")(assertImportsOk("documentation", pedantic                   = true, update  = update))
  test("swiz")(assertImportsOk("swiz", pedantic                                     = true, update  = update))
  test("defaulted-tparams")(assertImportsOk("defaulted-tparams", pedantic           = true, update  = update))
  test("union-to-inheritance")(assertImportsOk("union-to-inheritance", pedantic     = true, update  = update))
  test("expand-type-parameters")(assertImportsOk("expand-type-parameters", pedantic = true, update  = update))
  test("const-enum")(assertImportsOk("const-enum", pedantic                         = true, update  = update))
  test("firebase-admin")(assertImportsOk("firebase-admin", pedantic                 = true, update  = update))
  test("properties")(assertImportsOk("properties", pedantic                         = true, update  = update))
  test("keyof")(assertImportsOk("keyof", pedantic                                   = true, update  = update))
  test("antd")(assertImportsOk("antd", pedantic                                     = true, update  = update))
  test("echarts")(assertImportsOk("echarts", pedantic                               = true, update  = update))
  test("elasticsearch-js")(assertImportsOk("elasticsearch-js", pedantic             = true, update  = update))
  test("vfile")(assertImportsOk("vfile", pedantic                                   = true, update  = update))

  test("material-ui-slinky")(
    assertImportsOk("material-ui", pedantic = true, update = update, flavour = Slinky),
  )

  test("material-ui-japgolly")(
    assertImportsOk("material-ui", pedantic = true, update = update, flavour = Japgolly),
  )

  test("react-transition-group-slinky")(
    assertImportsOk("react-transition-group", pedantic = true, update = update, flavour = Slinky),
  )
  test("react-transition-group-japgolly")(
    assertImportsOk("react-transition-group", pedantic = true, update = update, flavour = JapgollyLong),
  )

  test("react-integration-test-slinky")(
    assertImportsOk("react-integration-test", pedantic = false, update = update, flavour = Slinky),
  )
  test("react-integration-test-japgolly")(
    assertImportsOk("react-integration-test", pedantic = false, update = update, flavour = Japgolly),
  )
}

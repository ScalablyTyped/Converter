package org.scalablytyped.converter
package internal
package importer

import org.scalablytyped.converter.internal.scalajs.flavours.{JapgollyFlavour, SlinkyFlavour}
import org.scalablytyped.converter.internal.scalajs.{Name, Versions}
import org.scalatest.ParallelTestExecution
import org.scalatest.funsuite.AnyFunSuite

class ImporterTest213 extends ImporterTest {
  override def version: Versions = Versions(Versions.Scala213, Versions.ScalaJs1)
  override def mode:    Mode     = Mode.releaseOnly
}

class ImporterTest3 extends ImporterTest {
  override def version: Versions = Versions(Versions.Scala3, Versions.ScalaJs1)
  override def mode:    Mode     = Mode.normal
}

trait ImporterTest extends AnyFunSuite with ImporterHarness with ParallelTestExecution {

  val Slinky       = SlinkyFlavour(Name("typingsSlinky"), enableLongApplyMethod     = false, version, Selection.None)
  val Japgolly     = JapgollyFlavour(Name("typingsJapgolly"), enableLongApplyMethod = false, version, Selection.All)
  val JapgollyLong = JapgollyFlavour(Name("typingsJapgolly"), enableLongApplyMethod = true, version, Selection.All)

  test("pixi.js")(assertImportsOk("pixi.js", pedantic                               = false))
  test("augment-module")(assertImportsOk("augment-module", pedantic                 = false))
  test("typings-json")(assertImportsOk("typings-json", pedantic                     = true))
  test("export-as-namespace")(assertImportsOk("export-as-namespace", pedantic       = true))
  test("babylon")(assertImportsOk("babylon", pedantic                               = true))
  test("bigint")(assertImportsOk("bigint", pedantic                                 = true))
  test("react-icons")(assertImportsOk("react-icons", pedantic                       = true))
  test("vue")(assertImportsOk("vue", pedantic                                       = true))
  test("sax")(assertImportsOk("sax", pedantic                                       = true))
  test("serve-static")(assertImportsOk("serve-static", pedantic                     = true))
  test("tstl")(assertImportsOk("tstl", pedantic                                     = true))
  test("numjs")(assertImportsOk("numjs", pedantic                                   = true))
  test("rxjs")(assertImportsOk("rxjs", pedantic                                     = true))
  test("virtual-dom")(assertImportsOk("virtual-dom", pedantic                       = true))
  test("fp-ts")(assertImportsOk("fp-ts", pedantic                                   = true))
  test("monaco-editor")(assertImportsOk("monaco-editor", pedantic                   = true))
  test("chart.js")(assertImportsOk("chart.js", pedantic                             = true))
  test("fullcalendar")(assertImportsOk("fullcalendar", pedantic                     = true))
  test("stylis")(assertImportsOk("stylis", pedantic                                 = true))
  test("mongoose-simple-random")(assertImportsOk("mongoose-simple-random", pedantic = true))
  test("electron")(assertImportsOk("electron", pedantic                             = true))
  test("aws-sdk")(assertImportsOk("aws-sdk", pedantic                               = true))
  test("winston")(assertImportsOk("winston", pedantic                               = true))
  test("commander")(assertImportsOk("commander", pedantic                           = true))
  test("with-theme")(assertImportsOk("with-theme", pedantic                         = true))
  test("create-error")(assertImportsOk("create-error", pedantic                     = true))
  test("insight")(assertImportsOk("insight", pedantic                               = true))
  test("interface-package")(assertImportsOk("interface-package", pedantic           = true))
  test("cldrjs")(assertImportsOk("cldrjs", pedantic                                 = true))
  test("void-elements")(assertImportsOk("void-elements", pedantic                   = true))
  test("type-mappings")(assertImportsOk("type-mappings", pedantic                   = true))
  test("documentation")(assertImportsOk("documentation", pedantic                   = true))
  test("swiz")(assertImportsOk("swiz", pedantic                                     = true))
  test("defaulted-tparams")(assertImportsOk("defaulted-tparams", pedantic           = true))
  test("union-to-inheritance")(assertImportsOk("union-to-inheritance", pedantic     = true))
  test("expand-type-parameters")(assertImportsOk("expand-type-parameters", pedantic = true))
  test("const-enum")(assertImportsOk("const-enum", pedantic                         = true))
  test("firebase-admin")(assertImportsOk("firebase-admin", pedantic                 = true))
  test("properties")(assertImportsOk("properties", pedantic                         = true))
  test("keyof")(assertImportsOk("keyof", pedantic                                   = true))
  test("antd")(assertImportsOk("antd", pedantic                                     = true))
  test("echarts")(assertImportsOk("echarts", pedantic                               = true))
  test("elasticsearch-js")(assertImportsOk("elasticsearch-js", pedantic             = true))
  test("vfile")(assertImportsOk("vfile", pedantic                                   = true))
  test("punchcard")(assertImportsOk("punchcard", pedantic                           = true))
  test("recharts")(assertImportsOk("recharts", pedantic                             = true))
  test("firebase")(assertImportsOk("firebase", pedantic                             = true))
  test("prisma")(assertImportsOk("prisma", pedantic                                 = true))

  test("material-ui-slinky")(
    assertImportsOk("material-ui", pedantic = true, flavour = Slinky),
  )

  test("material-ui-japgolly")(
    assertImportsOk(
      "material-ui",
      pedantic           = true,
      flavour            = Japgolly.copy(outputPkg = Name("mylib.internal.baz")),
      maybePrivateWithin = Some(Name("internal")),
    ),
  )

  test("react-transition-group-slinky")(
    assertImportsOk("react-transition-group", pedantic = true, flavour = Slinky),
  )
  test("react-transition-group-japgolly")(
    assertImportsOk("react-transition-group", pedantic = true, flavour = JapgollyLong),
  )

  test("react-integration-test-slinky")(
    assertImportsOk("react-integration-test", pedantic = false, flavour = Slinky),
  )
  test("react-integration-test-japgolly")(
    assertImportsOk("react-integration-test", pedantic = false, flavour = Japgolly),
  )
}

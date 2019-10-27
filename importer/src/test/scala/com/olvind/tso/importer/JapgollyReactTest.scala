package com.olvind.tso
package importer

import com.olvind.tso.scalajs.react.ReactBinding

object JapgollyReactTest extends ImporterHarness {
  val update = !constants.isCi

  def main(args: Array[String]): Unit =
    assertImportsOk(
      "semantic-ui-react",
      pedantic      = false,
      update        = update,
      reactBindings = List(ReactBinding.japgolly),
    )
  assertImportsOk(
    "react-contextmenu",
    pedantic      = false,
    update        = update,
    reactBindings = List(ReactBinding.japgolly),
  )
}

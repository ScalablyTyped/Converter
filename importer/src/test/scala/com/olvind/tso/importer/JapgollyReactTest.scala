package com.olvind
package tso
package importer

import com.olvind.tso.scalajs.react.ReactBinding
import org.scalatest.{FunSuite, ParallelTestExecution}

class JapgollyReactTest extends FunSuite with ImporterHarness with ParallelTestExecution {
  val update = !constants.isCi

    test("semanticui")(assertImportsOk(
      "semantic-ui-react",
      pedantic = false,
      update = update,
      reactBindings = List(ReactBinding.japgolly),
    ))

    test("react-contextmenu")(assertImportsOk(
      "react-contextmenu",
      pedantic = false,
      update = update,
      reactBindings = List(ReactBinding.japgolly),
    ))

    test("react-dropzone")(assertImportsOk(
      "react-dropzone",
      pedantic = false,
      update = update,
      reactBindings = List(ReactBinding.japgolly),
    ))
}

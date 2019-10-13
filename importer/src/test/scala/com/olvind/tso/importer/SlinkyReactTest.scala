package com.olvind.tso
package importer

import com.olvind.tso.scalajs.react.ReactBinding

class SlinkyReactTest extends ImporterHarness {
  val update = !constants.isCi

  def main(args: Array[String]): Unit =
    assertImportsOk("semantic-ui-react", pedantic = false, update = update, reactBindings = List(ReactBinding.slinky))
}

package com.olvind.tso.importer

import com.olvind.tso.scalajs.react.ReactBinding
import org.scalatest.{FunSuite, ParallelTestExecution}

class SemanticUiReactTest extends FunSuite with ImporterHarness with ParallelTestExecution {
  val update = sys.env.get("CIRCLECI").isEmpty

  test("semantic-ui-react")(assertImportsOk("semantic-ui-react", pedantic = false, update = update, reactBinding = Option(ReactBinding.scalajsReact)))

}

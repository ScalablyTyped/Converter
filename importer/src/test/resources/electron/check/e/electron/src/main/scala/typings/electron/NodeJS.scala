package typings.electron

import scala.scalajs.js.annotation.JSGlobal
import typings.electron.electronStrings.bar
import typings.node.NodeJS.EventEmitter
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSGlobal("NodeJS")
@js.native
object NodeJS extends js.Object {
  @js.native
  trait Process extends EventEmitter {
    var foo: bar = js.native
  }
  
}


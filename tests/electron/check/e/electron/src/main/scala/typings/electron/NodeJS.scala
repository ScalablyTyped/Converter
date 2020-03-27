package typings.electron

import typings.electron.electronStrings.Bar
import typings.electron.electronStrings.bar_
import typings.node.NodeJS.EventEmitter
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("NodeJS")
@js.native
object NodeJS extends js.Object {
  @js.native
  trait Process extends EventEmitter {
    var foo: bar_ | Bar = js.native
  }
  
}


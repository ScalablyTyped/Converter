package typings.node.mod

import typings.node.mod.stream.Readable
import typings.node.mod.stream.Writable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fs", JSImport.Namespace)
@js.native
object fs extends js.Object {
  @js.native
  class ReadStream () extends Readable
  
  @js.native
  class WriteStream () extends Writable
  
}


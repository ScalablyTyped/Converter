package typings.node

import typings.node.streamMod.Readable
import typings.node.streamMod.Writable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fs", JSImport.Namespace)
@js.native
object mod extends js.Object {
  @js.native
  class ReadStream () extends Readable
  
  @js.native
  class WriteStream () extends Writable
  
}


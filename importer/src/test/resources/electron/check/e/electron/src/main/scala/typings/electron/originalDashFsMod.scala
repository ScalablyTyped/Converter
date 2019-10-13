package typings.electron

import typings.node.streamMod.Readable
import typings.node.streamMod.Writable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("original-fs", JSImport.Namespace)
@js.native
object originalDashFsMod extends js.Object {
  @js.native
  class ReadStream () extends Readable
  
  @js.native
  class WriteStream () extends Writable
  
}


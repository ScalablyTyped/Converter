package typings.electron

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.node.streamMod.Readable
import typings.node.streamMod.Writable
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("original-fs", Namespace)
@js.native
object originalDashFsMod extends js.Object {
  @js.native
  class ReadStream () extends Readable
  
  @js.native
  class WriteStream () extends Writable
  
}


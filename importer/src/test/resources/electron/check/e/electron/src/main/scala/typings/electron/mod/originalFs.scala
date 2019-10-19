package typings.electron.mod

import typings.node.mod.stream.Readable
import typings.node.mod.stream.Writable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("original-fs", JSImport.Namespace)
@js.native
object originalFs extends js.Object {
  @js.native
  class ReadStream () extends Readable
  
  @js.native
  class WriteStream () extends Writable
  
}


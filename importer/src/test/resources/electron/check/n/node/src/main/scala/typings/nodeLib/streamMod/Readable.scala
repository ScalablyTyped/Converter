package typings.nodeLib.streamMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* import warning: RemoveMultipleInheritance.findNewParents newComments Dropped parents 
- typings.nodeLib.NodeJSNs.ReadableStream because Inheritance from two classes. Inlined readable */ @JSImport("stream", "Readable")
@js.native
class Readable () extends Stream {
  var readable: Boolean = js.native
  def emit(event: String, args: js.Any*): Boolean = js.native
  def emit(event: js.Symbol, args: js.Any*): Boolean = js.native
  def read(): String = js.native
  def read(size: Double): String = js.native
}


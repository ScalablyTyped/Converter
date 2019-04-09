package typings
package nodeLib.streamMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* import warning: RemoveMultipleInheritance.findNewParents newComments Dropped parents 
- nodeLib.NodeJSNs.ReadableStream because Inheritance from two classes. Inlined readable */ @JSImport("stream", "Readable")
@js.native
class Readable () extends Stream {
  var readable: scala.Boolean = js.native
  def emit(event: java.lang.String, args: js.Any*): scala.Boolean = js.native
  def emit(event: js.Symbol, args: js.Any*): scala.Boolean = js.native
  def read(): java.lang.String = js.native
  def read(size: scala.Double): java.lang.String = js.native
}


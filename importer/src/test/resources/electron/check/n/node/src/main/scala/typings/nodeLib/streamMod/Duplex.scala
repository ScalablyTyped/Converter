package typings
package nodeLib.streamMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* import warning: RemoveMultipleInheritance.findNewParents newComments Dropped parents 
- nodeLib.streamMod.Writable because Inheritance from two classes. Inlined writable, emit, emit, end, end, end */ @JSImport("stream", "Duplex")
@js.native
class Duplex () extends Readable {
  var writable: scala.Boolean = js.native
  def end(): scala.Unit = js.native
  def end(cb: js.Function): scala.Unit = js.native
  def end(chunk: js.Any): scala.Unit = js.native
  def end(chunk: js.Any, cb: js.Function): scala.Unit = js.native
  def end(chunk: js.Any, encoding: java.lang.String): scala.Unit = js.native
  def end(chunk: js.Any, encoding: java.lang.String, cb: js.Function): scala.Unit = js.native
  def end(str: java.lang.String): scala.Unit = js.native
  def end(str: java.lang.String, encoding: java.lang.String): scala.Unit = js.native
  def end(str: java.lang.String, encoding: java.lang.String, cb: js.Function): scala.Unit = js.native
}


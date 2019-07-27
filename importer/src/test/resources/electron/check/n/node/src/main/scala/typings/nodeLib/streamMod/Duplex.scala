package typings.nodeLib.streamMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* import warning: RemoveMultipleInheritance.findNewParents newComments Dropped parents 
- typings.nodeLib.streamMod.Writable because Inheritance from two classes. Inlined writable, emit, emit, end, end, end */ @JSImport("stream", "Duplex")
@js.native
class Duplex () extends Readable {
  var writable: Boolean = js.native
  def end(): Unit = js.native
  def end(cb: js.Function): Unit = js.native
  def end(chunk: js.Any): Unit = js.native
  def end(chunk: js.Any, cb: js.Function): Unit = js.native
  def end(chunk: js.Any, encoding: String): Unit = js.native
  def end(chunk: js.Any, encoding: String, cb: js.Function): Unit = js.native
  def end(str: String): Unit = js.native
  def end(str: String, encoding: String): Unit = js.native
  def end(str: String, encoding: String, cb: js.Function): Unit = js.native
}


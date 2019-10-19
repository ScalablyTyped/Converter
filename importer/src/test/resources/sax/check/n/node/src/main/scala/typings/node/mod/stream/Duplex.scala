package typings.node.mod.stream

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* import warning: RemoveMultipleInheritance.findNewParents newComments Dropped parents 
- typings.node.NodeJS.EventEmitter because Already inherited
- typings.node.mod.events.EventEmitter because Already inherited
- typings.node.NodeJS.WritableStream because var conflicts: writable. Inlined 
- typings.node.mod.stream.internal because Already inherited
- typings.node.mod.stream.Writable because Inheritance from two classes. Inlined writable, end, end, end, end, end, end, on, on_close */ @JSImport("stream", "Duplex")
@js.native
class Duplex () extends Readable {
  def this(opts: DuplexOptions) = this()
  var writable: Boolean = js.native
  def end(): Unit = js.native
  def end(cb: js.Function): Unit = js.native
  def end(chunk: js.Any): Unit = js.native
  def end(chunk: js.Any, cb: js.Function): Unit = js.native
  def end(chunk: js.Any, encoding: String): Unit = js.native
  def end(chunk: js.Any, encoding: String, cb: js.Function): Unit = js.native
}


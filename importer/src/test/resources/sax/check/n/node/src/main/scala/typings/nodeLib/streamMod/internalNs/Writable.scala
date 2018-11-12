package typings
package nodeLib.streamMod.internalNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Writable
  extends nodeLib.streamMod.internal
     with nodeLib.NodeJSNs.WritableStream {
  def end(): scala.Unit = js.native
  def end(cb: js.Function): scala.Unit = js.native
  def end(chunk: js.Any): scala.Unit = js.native
  def end(chunk: js.Any, cb: js.Function): scala.Unit = js.native
  def end(chunk: js.Any, encoding: java.lang.String): scala.Unit = js.native
  def end(chunk: js.Any, encoding: java.lang.String, cb: js.Function): scala.Unit = js.native
  @JSName("on")
  def on_close(event: nodeLib.nodeLibStrings.close, listener: js.Function0[scala.Unit]): this.type = js.native
}


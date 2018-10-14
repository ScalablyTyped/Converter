package ScalablyTyped
package NodeLib.StreamModule.internalNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Writable
  extends NodeLib.StreamModule.internal
     with NodeLib.NodeJSNamespace.WritableStream {
  def end(): scala.Unit = js.native
  def end(cb: js.Function): scala.Unit = js.native
  def end(chunk: js.Any): scala.Unit = js.native
  def end(chunk: js.Any, cb: js.Function): scala.Unit = js.native
  def end(chunk: js.Any, encoding: java.lang.String): scala.Unit = js.native
  def end(chunk: js.Any, encoding: java.lang.String, cb: js.Function): scala.Unit = js.native
  @JSName("on")
  def on_close(event: NodeLib.NodeLibStrings.close, listener: js.Function0[scala.Unit]): this.type = js.native
}


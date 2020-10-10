package typings.node.streamMod

import typings.node.NodeJS.WritableStream
import typings.node.nodeStrings.close
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("stream", "Writable")
@js.native
class Writable ()
  extends Stream
     with WritableStream {
  def this(opts: WritableOptions) = this()
  
  def end(): Unit = js.native
  def end(cb: js.Function): Unit = js.native
  def end(chunk: js.Any): Unit = js.native
  def end(chunk: js.Any, cb: js.Function): Unit = js.native
  def end(chunk: js.Any, encoding: js.UndefOr[scala.Nothing], cb: js.Function): Unit = js.native
  def end(chunk: js.Any, encoding: String): Unit = js.native
  def end(chunk: js.Any, encoding: String, cb: js.Function): Unit = js.native
  
  @JSName("on")
  def on_close(event: close, listener: js.Function0[Unit]): this.type = js.native
}

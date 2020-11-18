package typings.node.streamMod

import typings.node.NodeJS.ReadableStream
import typings.node.nodeStrings.close
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("stream", "Readable")
@js.native
class Readable ()
  extends Stream
     with ReadableStream {
  
  @JSName("on")
  def on_close(event: close, listener: js.Function0[Unit]): this.type = js.native
}

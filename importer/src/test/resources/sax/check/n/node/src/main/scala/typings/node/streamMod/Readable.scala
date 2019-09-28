package typings.node.streamMod

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSName
import typings.node.NodeJS.ReadableStream
import typings.node.nodeStrings.close
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("stream", "Readable")
@js.native
class Readable ()
  extends internal
     with ReadableStream {
  @JSName("on")
  def on_close(event: close, listener: js.Function0[Unit]): this.type = js.native
}


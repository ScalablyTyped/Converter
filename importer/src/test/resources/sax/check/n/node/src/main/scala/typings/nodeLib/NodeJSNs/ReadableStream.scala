package typings.nodeLib.NodeJSNs

import typings.nodeLib.Buffer
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReadableStream extends EventEmitter {
  def read(): String | Buffer = js.native
  def read(size: Double): String | Buffer = js.native
}


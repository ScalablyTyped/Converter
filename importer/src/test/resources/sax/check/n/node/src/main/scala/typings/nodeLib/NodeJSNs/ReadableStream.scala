package typings
package nodeLib.NodeJSNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReadableStream extends EventEmitter {
  def read(): java.lang.String | nodeLib.Buffer = js.native
  def read(size: scala.Double): java.lang.String | nodeLib.Buffer = js.native
}


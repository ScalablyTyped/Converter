package ScalablyTyped
package NodeLib.NodeJSNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReadableStream extends EventEmitter {
  def read(): java.lang.String | NodeLib.Buffer = js.native
  def read(size: scala.Double): java.lang.String | NodeLib.Buffer = js.native
}


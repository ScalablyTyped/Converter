package ScalablyTyped
package NodeLib
package NodeJSNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReadableStream extends NodeLib.NodeJSNamespace.EventEmitter {
  def read(): java.lang.String | NodeLib.Buffer = js.native
  def read(size: scala.Double): java.lang.String | NodeLib.Buffer = js.native
}


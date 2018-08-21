package ScalablyTyped
package NodeLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("SlowBuffer")
@js.native
object SlowBuffer extends ScalablyTyped.runtime.Instantiable2[/* str */ java.lang.String, /* encoding */ java.lang.String, NodeLib.Buffer] with ScalablyTyped.runtime.Instantiable1[(/* str */ java.lang.String) | (/* size */ scala.Double) | (/* size */ StdLib.Uint8Array[js.Object]) | (/* array */ StdLib.Array[js.Any]), NodeLib.Buffer] {
  def byteLength(string: java.lang.String): scala.Double = js.native
  def byteLength(string: java.lang.String, encoding: java.lang.String): scala.Double = js.native
  def concat(list: StdLib.Array[NodeLib.Buffer]): NodeLib.Buffer = js.native
  def concat(list: StdLib.Array[NodeLib.Buffer], totalLength: scala.Double): NodeLib.Buffer = js.native
  def isBuffer(obj: js.Any): scala.Boolean = js.native
}


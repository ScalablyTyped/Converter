package typings.nodeLib.bufferMod

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import typings.stdLib.Uint8Array
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("buffer", "SlowBuffer")
@js.native
class SlowBuffer protected ()
  extends typings.nodeLib.Buffer {
  def this(array: js.Array[_]) = this()
  def this(size: Double) = this()
  def this(size: Uint8Array) = this()
  def this(str: String) = this()
  def this(str: String, encoding: String) = this()
}

@JSImport("buffer", "SlowBuffer")
@js.native
object SlowBuffer
  extends Instantiable2[/* str */ String, /* encoding */ String, typings.nodeLib.Buffer]
     with Instantiable1[
      (/* array */ js.Array[js.Any]) | (/* size */ Double) | (/* str */ String) | (/* size */ Uint8Array), 
      typings.nodeLib.Buffer
    ] {
  def byteLength(string: String): Double = js.native
  def byteLength(string: String, encoding: String): Double = js.native
  def concat(list: js.Array[typings.nodeLib.Buffer]): typings.nodeLib.Buffer = js.native
  def concat(list: js.Array[typings.nodeLib.Buffer], totalLength: Double): typings.nodeLib.Buffer = js.native
  def isBuffer(obj: js.Any): Boolean = js.native
}


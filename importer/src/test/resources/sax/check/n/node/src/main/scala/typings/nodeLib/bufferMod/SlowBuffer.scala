package typings
package nodeLib.bufferMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("buffer", "SlowBuffer")
@js.native
class SlowBuffer protected ()
  extends nodeLib.Buffer {
  def this(array: js.Array[_]) = this()
  def this(size: scala.Double) = this()
  def this(size: stdLib.Uint8Array) = this()
  def this(str: java.lang.String) = this()
  def this(str: java.lang.String, encoding: java.lang.String) = this()
}


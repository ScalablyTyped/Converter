package typings
package nodeLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait NodeBuffer
  extends stdLib.Uint8Array[js.Object] {
  def write(string: java.lang.String): scala.Double = js.native
  def write(string: java.lang.String, offset: scala.Double): scala.Double = js.native
  def write(string: java.lang.String, offset: scala.Double, length: scala.Double): scala.Double = js.native
  def write(string: java.lang.String, offset: scala.Double, length: scala.Double, encoding: java.lang.String): scala.Double = js.native
}


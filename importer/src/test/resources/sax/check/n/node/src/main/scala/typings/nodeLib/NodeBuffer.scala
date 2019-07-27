package typings.nodeLib

import typings.stdLib.Uint8Array
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait NodeBuffer extends Uint8Array {
  def write(string: String): Double = js.native
  def write(string: String, offset: Double): Double = js.native
  def write(string: String, offset: Double, length: Double): Double = js.native
  def write(string: String, offset: Double, length: Double, encoding: String): Double = js.native
}


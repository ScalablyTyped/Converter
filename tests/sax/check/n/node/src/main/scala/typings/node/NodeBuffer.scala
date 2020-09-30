package typings.node

import typings.std.Uint8Array
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait NodeBuffer extends Uint8Array {
  def write(string: String): Double = js.native
  def write(
    string: String,
    offset: js.UndefOr[scala.Nothing],
    length: js.UndefOr[scala.Nothing],
    encoding: String
  ): Double = js.native
  def write(string: String, offset: js.UndefOr[scala.Nothing], length: Double): Double = js.native
  def write(string: String, offset: js.UndefOr[scala.Nothing], length: Double, encoding: String): Double = js.native
  def write(string: String, offset: Double): Double = js.native
  def write(string: String, offset: Double, length: js.UndefOr[scala.Nothing], encoding: String): Double = js.native
  def write(string: String, offset: Double, length: Double): Double = js.native
  def write(string: String, offset: Double, length: Double, encoding: String): Double = js.native
}


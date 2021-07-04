package typings.node

import typings.std.Uint8Array
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait NodeBuffer
  extends StObject
     with Uint8Array {
  
  def write(string: String): Double = js.native
  def write(string: String, offset: Double): Double = js.native
  def write(string: String, offset: Double, length: Double): Double = js.native
  def write(string: String, offset: Double, length: Double, encoding: String): Double = js.native
  def write(string: String, offset: Double, length: Unit, encoding: String): Double = js.native
  def write(string: String, offset: Unit, length: Double): Double = js.native
  def write(string: String, offset: Unit, length: Double, encoding: String): Double = js.native
  def write(string: String, offset: Unit, length: Unit, encoding: String): Double = js.native
}

package typings.unionToInheritance

import typings.std.HTMLInputElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceNumbers.`1`
  - typings.unionToInheritance.unionToInheritanceNumbers.`2`
  - typings.std.HTMLInputElement
  - js.Array[typings.unionToInheritance.B]
  - typings.unionToInheritance.B
*/
trait C extends js.Object

object C {
  @scala.inline
  def `1`: typings.unionToInheritance.unionToInheritanceNumbers.`1` = 1.asInstanceOf[typings.unionToInheritance.unionToInheritanceNumbers.`1`]
  @scala.inline
  def `2`: typings.unionToInheritance.unionToInheritanceNumbers.`2` = 2.asInstanceOf[typings.unionToInheritance.unionToInheritanceNumbers.`2`]
  @scala.inline
  def b1: typings.unionToInheritance.unionToInheritanceStrings.b1 = "b1".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.b1]
  @scala.inline
  def b2: typings.unionToInheritance.unionToInheritanceStrings.b2 = "b2".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.b2]
  @scala.inline
  def a1: typings.unionToInheritance.unionToInheritanceStrings.a1 = "a1".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.a1]
  @scala.inline
  def a2: typings.unionToInheritance.unionToInheritanceStrings.a2 = "a2".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.a2]
  @scala.inline
  implicit def apply(value: js.Array[B]): C = value.asInstanceOf[C]
  @scala.inline
  implicit def apply(value: Double): C = value.asInstanceOf[C]
  @scala.inline
  implicit def apply(value: HTMLInputElement): C = value.asInstanceOf[C]
  @scala.inline
  implicit def apply(value: String): C = value.asInstanceOf[C]
}


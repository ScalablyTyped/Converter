package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.b1
  - typings.unionToInheritance.unionToInheritanceStrings.b2
  - scala.Double
  - typings.unionToInheritance.A
*/
trait B extends C

object B {
  @scala.inline
  def b1: typings.unionToInheritance.unionToInheritanceStrings.b1 = "b1".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.b1]
  @scala.inline
  def b2: typings.unionToInheritance.unionToInheritanceStrings.b2 = "b2".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.b2]
  @scala.inline
  def a1: typings.unionToInheritance.unionToInheritanceStrings.a1 = "a1".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.a1]
  @scala.inline
  def a2: typings.unionToInheritance.unionToInheritanceStrings.a2 = "a2".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.a2]
  @scala.inline
  implicit def apply(value: Double): B = value.asInstanceOf[B]
  @scala.inline
  implicit def apply(value: String): B = value.asInstanceOf[B]
}


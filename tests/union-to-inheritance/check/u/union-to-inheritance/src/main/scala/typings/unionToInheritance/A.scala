package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.a1
  - typings.unionToInheritance.unionToInheritanceStrings.a2
  - java.lang.String
*/
trait A extends B

object A {
  @scala.inline
  def a1: typings.unionToInheritance.unionToInheritanceStrings.a1 = "a1".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.a1]
  @scala.inline
  def a2: typings.unionToInheritance.unionToInheritanceStrings.a2 = "a2".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.a2]
  @scala.inline
  implicit def apply(value: String): A = value.asInstanceOf[A]
}


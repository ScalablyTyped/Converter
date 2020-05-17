package typings.unionToInheritance

import typings.std.TwoFoo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.Test[O1, O1, O2]
  - typings.unionToInheritance.Either[O2, O1]
  - typings.unionToInheritance.Legal1[O2]
*/
trait Test2[O1, O2] extends js.Object

object Test2 {
  @scala.inline
  def foo[O1, O2]: typings.unionToInheritance.unionToInheritanceStrings.foo = "foo".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.foo]
  @scala.inline
  def bar[O1, O2]: typings.unionToInheritance.unionToInheritanceStrings.bar = "bar".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.bar]
  @scala.inline
  implicit def apply[O1, O2](value: Either[O1 | O2, O1 | O2]): Test2[O1, O2] = value.asInstanceOf[Test2[O1, O2]]
  @scala.inline
  implicit def apply[O1, O2](value: Foo[O2]): Test2[O1, O2] = value.asInstanceOf[Test2[O1, O2]]
  @scala.inline
  implicit def apply[O1, O2](value: Foo2[O1, O2]): Test2[O1, O2] = value.asInstanceOf[Test2[O1, O2]]
  @scala.inline
  implicit def apply[O1, O2](value: TwoFoo[O2, O1]): Test2[O1, O2] = value.asInstanceOf[Test2[O1, O2]]
}


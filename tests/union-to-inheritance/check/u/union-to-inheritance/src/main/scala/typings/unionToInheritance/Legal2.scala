package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.foo
  - typings.unionToInheritance.unionToInheritanceStrings.bar
  - typings.unionToInheritance.Foo[P]
  - typings.unionToInheritance.Foo2[T, P]
*/
trait Legal2[P, T] extends js.Object

object Legal2 {
  @scala.inline
  def foo[P, T]: typings.unionToInheritance.unionToInheritanceStrings.foo = "foo".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.foo]
  @scala.inline
  def bar[P, T]: typings.unionToInheritance.unionToInheritanceStrings.bar = "bar".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.bar]
  @scala.inline
  implicit def apply[P, T](value: Foo[P]): Legal2[P, T] = value.asInstanceOf[Legal2[P, T]]
  @scala.inline
  implicit def apply[P, T](value: Foo2[T, P]): Legal2[P, T] = value.asInstanceOf[Legal2[P, T]]
}


package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.foo
  - typings.unionToInheritance.unionToInheritanceStrings.bar
  - typings.unionToInheritance.Foo2[T, T]
*/
trait Illegal3[T] extends js.Object

object Illegal3 {
  @scala.inline
  def foo[T]: typings.unionToInheritance.unionToInheritanceStrings.foo = "foo".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.foo]
  @scala.inline
  def bar[T]: typings.unionToInheritance.unionToInheritanceStrings.bar = "bar".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.bar]
  @scala.inline
  implicit def apply[T](value: Foo2[T, T]): Illegal3[T] = value.asInstanceOf[Illegal3[T]]
}


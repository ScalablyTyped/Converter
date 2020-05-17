package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.foo
  - typings.unionToInheritance.unionToInheritanceStrings.bar
  - typings.unionToInheritance.Foo[java.lang.String]
*/
trait Illegal1 extends js.Object

object Illegal1 {
  @scala.inline
  def foo: typings.unionToInheritance.unionToInheritanceStrings.foo = "foo".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.foo]
  @scala.inline
  def bar: typings.unionToInheritance.unionToInheritanceStrings.bar = "bar".asInstanceOf[typings.unionToInheritance.unionToInheritanceStrings.bar]
  @scala.inline
  implicit def apply(value: Foo[String]): Illegal1 = value.asInstanceOf[Illegal1]
}


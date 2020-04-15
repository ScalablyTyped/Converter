package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Foo[U]
  extends Legal1[U]
     with Legal2[U, js.Any]
     with Legal3[js.Any, js.Any, U] {
  var value: U = js.native
}

object Foo {
  @scala.inline
  def apply[U](value: U): Foo[U] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[Foo[U]]
  }
}


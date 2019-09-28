package typings.std

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

/* let's pretend */
trait TwoFoo[Foo1, Foo2] extends js.Object {
  var value: Foo1
}

object TwoFoo {
  @inline
  def apply[Foo1, Foo2](value: Foo1): TwoFoo[Foo1, Foo2] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[TwoFoo[Foo1, Foo2]]
  }
}


package typings
package stdLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* let's pretend */
trait TwoFoo[Foo1, Foo2] extends js.Object {
  var value: Foo1
}

object TwoFoo {
  @scala.inline
  def apply[Foo1, Foo2](value: Foo1): TwoFoo[Foo1, Foo2] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[TwoFoo[Foo1, Foo2]]
  }
}


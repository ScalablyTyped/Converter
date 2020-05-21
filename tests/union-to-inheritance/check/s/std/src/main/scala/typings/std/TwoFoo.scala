package typings.std

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* let's pretend */
@js.native
trait TwoFoo[Foo1, Foo2] extends js.Object {
  var value: Foo1 = js.native
}

object TwoFoo {
  @scala.inline
  def apply[Foo1, Foo2](value: Foo1): TwoFoo[Foo1, Foo2] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[TwoFoo[Foo1, Foo2]]
  }
  @scala.inline
  implicit class TwoFooOps[Self <: TwoFoo[_, _], Foo1, Foo2] (val x: Self with (TwoFoo[Foo1, Foo2])) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withValue(value: Foo1): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("value")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}


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
  implicit class TwoFooOps[Self[foo1, foo2] <: TwoFoo[foo1, foo2], Foo1, Foo2] (val x: Self[Foo1, Foo2]) extends AnyVal {
    @scala.inline
    def duplicate: Self[Foo1, Foo2] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[Foo1, Foo2]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[Foo1, Foo2]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[Foo1, Foo2]) with Other]
    @scala.inline
    def withValue(value: Foo1): Self[Foo1, Foo2] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("value")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}


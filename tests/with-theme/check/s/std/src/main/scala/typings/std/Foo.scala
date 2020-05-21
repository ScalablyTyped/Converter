package typings.std

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Foo extends js.Object {
  var f: js.UndefOr[js.Function1[/* n */ Double, String]] = js.native
}

object Foo {
  @scala.inline
  def apply(f: /* n */ Double => String = null): Foo = {
    val __obj = js.Dynamic.literal()
    if (f != null) __obj.updateDynamic("f")(js.Any.fromFunction1(f))
    __obj.asInstanceOf[Foo]
  }
  @scala.inline
  implicit class FooOps[Self <: Foo] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withF(f: /* n */ Double => String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (f != null) ret.updateDynamic("f")(js.Any.fromFunction1(f))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutF: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "f")
        ret.asInstanceOf[Self]
    }
  }
  
}


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
  def apply(): Foo = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[Foo]
  }
  @scala.inline
  implicit class FooOps[Self <: Foo] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setF(value: /* n */ Double => String): Self = this.set("f", js.Any.fromFunction1(value))
    @scala.inline
    def deleteF: Self = this.set("f", js.undefined)
  }
  
}


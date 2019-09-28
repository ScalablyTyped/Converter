package typings.std

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Foo extends js.Object {
  var f: js.UndefOr[js.Function1[/* n */ Double, String]] = js.undefined
}

object Foo {
  @inline
  def apply(f: /* n */ Double => String = null): Foo = {
    val __obj = js.Dynamic.literal()
    if (f != null) __obj.updateDynamic("f")(js.Any.fromFunction1(f))
    __obj.asInstanceOf[Foo]
  }
}


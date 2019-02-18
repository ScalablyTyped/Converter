package typings
package stdLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Foo extends js.Object {
  var f: js.UndefOr[js.Function1[/* n */ scala.Double, java.lang.String]] = js.undefined
}

object Foo {
  @scala.inline
  def apply(f: js.Function1[/* n */ scala.Double, java.lang.String] = null): Foo = {
    val __obj = js.Dynamic.literal()
    if (f != null) __obj.updateDynamic("f")(f)
    __obj.asInstanceOf[Foo]
  }
}


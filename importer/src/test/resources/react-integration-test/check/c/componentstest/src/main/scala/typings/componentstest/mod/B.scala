package typings.componentstest.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait B extends Props {
  var bCallback: js.UndefOr[js.Function0[String]] = js.undefined
  var bMember: String
}

object B {
  @scala.inline
  def apply(bMember: String, bCallback: () => String = null): B = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    if (bCallback != null) __obj.updateDynamic("bCallback")(js.Any.fromFunction0(bCallback))
    __obj.asInstanceOf[B]
  }
}


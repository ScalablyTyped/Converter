package typingsJapgolly.componentstest.mod

import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait B extends Props {
  var bCallback: js.UndefOr[js.Function0[String]] = js.undefined
  var bMember: String
}

object B {
  @scala.inline
  def apply(bMember: String, bCallback: js.UndefOr[CallbackTo[String]] = js.undefined): B = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    bCallback.foreach(p => __obj.updateDynamic("bCallback")(p.toJsFn))
    __obj.asInstanceOf[B]
  }
}


package typings.reactDashTransitionDashGroup

import japgolly.scalajs.react.raw.React.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Anon_Child extends js.Object {
  var childFactory: js.UndefOr[js.Function1[/* child */ Element, Element]] = js.undefined
}

object Anon_Child {
  @scala.inline
  def apply(childFactory: /* child */ Element => Element = null): Anon_Child = {
    val __obj = js.Dynamic.literal()
    if (childFactory != null) __obj.updateDynamic("childFactory")(js.Any.fromFunction1(childFactory))
    __obj.asInstanceOf[Anon_Child]
  }
}


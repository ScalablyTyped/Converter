package typingsJapgolly.reactTransitionGroup

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonChildFactory extends js.Object {
  var childFactory: js.UndefOr[js.Function1[/* child */ Element, Element]] = js.native
}

object AnonChildFactory {
  @scala.inline
  def apply(childFactory: /* child */ Element => CallbackTo[Element] = null): AnonChildFactory = {
    val __obj = js.Dynamic.literal()
    if (childFactory != null) __obj.updateDynamic("childFactory")(js.Any.fromFunction1((t0: /* child */ japgolly.scalajs.react.raw.React.Element) => childFactory(t0).runNow()))
    __obj.asInstanceOf[AnonChildFactory]
  }
}


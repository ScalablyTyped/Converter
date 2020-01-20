package typings.reactTransitionGroup

import typings.react.mod.ReactElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonChild extends js.Object {
  var childFactory: js.UndefOr[js.Function1[/* child */ ReactElement, ReactElement]] = js.native
}

object AnonChild {
  @scala.inline
  def apply(childFactory: /* child */ ReactElement => ReactElement = null): AnonChild = {
    val __obj = js.Dynamic.literal()
    if (childFactory != null) __obj.updateDynamic("childFactory")(js.Any.fromFunction1(childFactory))
    __obj.asInstanceOf[AnonChild]
  }
}


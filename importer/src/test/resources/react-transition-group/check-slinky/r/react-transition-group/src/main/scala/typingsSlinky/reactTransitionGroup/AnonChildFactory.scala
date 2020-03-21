package typingsSlinky.reactTransitionGroup

import slinky.core.facade.ReactElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonChildFactory extends js.Object {
  var childFactory: js.UndefOr[js.Function1[/* child */ ReactElement, ReactElement]] = js.native
}

object AnonChildFactory {
  @scala.inline
  def apply(childFactory: /* child */ ReactElement => ReactElement = null): AnonChildFactory = {
    val __obj = js.Dynamic.literal()
    if (childFactory != null) __obj.updateDynamic("childFactory")(js.Any.fromFunction1(childFactory))
    __obj.asInstanceOf[AnonChildFactory]
  }
}


package typingsSlinky.react.reactMod

import typingsSlinky.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// Unfortunately, we have no way of declaring that the component constructor must implement this
@js.native
trait StaticLifecycle[P, S] extends js.Object {
  var getDerivedStateFromError: js.UndefOr[GetDerivedStateFromError[P, S]] = js.native
  var getDerivedStateFromProps: js.UndefOr[GetDerivedStateFromProps[P, S]] = js.native
}

object StaticLifecycle {
  @scala.inline
  def apply[P, S](
    getDerivedStateFromError: /* error */ js.Any => Partial[S] | Null = null,
    getDerivedStateFromProps: (P, S) => Partial[S] | Null = null
  ): StaticLifecycle[P, S] = {
    val __obj = js.Dynamic.literal()
    if (getDerivedStateFromError != null) __obj.updateDynamic("getDerivedStateFromError")(js.Any.fromFunction1(getDerivedStateFromError))
    if (getDerivedStateFromProps != null) __obj.updateDynamic("getDerivedStateFromProps")(js.Any.fromFunction2(getDerivedStateFromProps))
    __obj.asInstanceOf[StaticLifecycle[P, S]]
  }
}


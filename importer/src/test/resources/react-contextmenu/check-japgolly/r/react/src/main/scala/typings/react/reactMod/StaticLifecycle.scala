package typings.react.reactMod

import japgolly.scalajs.react.CallbackTo
import typings.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// Unfortunately, we have no way of declaring that the component constructor must implement this
trait StaticLifecycle[P, S] extends js.Object {
  var getDerivedStateFromError: js.UndefOr[GetDerivedStateFromError[P, S]] = js.undefined
  var getDerivedStateFromProps: js.UndefOr[GetDerivedStateFromProps[P, S]] = js.undefined
}

object StaticLifecycle {
  @scala.inline
  def apply[P, S](
    getDerivedStateFromError: js.UndefOr[/* error */ js.Any => CallbackTo[Partial[S] | Null]] = js.undefined,
    getDerivedStateFromProps: js.UndefOr[(P, S) => CallbackTo[Partial[S] | Null]] = js.undefined
  ): StaticLifecycle[P, S] = {
    val __obj = js.Dynamic.literal()
    getDerivedStateFromError.foreach(p => __obj.updateDynamic("getDerivedStateFromError")(js.Any.fromFunction1(((t0: /* error */ js.Any) => p(t0).runNow()))))
    getDerivedStateFromProps.foreach(p => __obj.updateDynamic("getDerivedStateFromProps")(js.Any.fromFunction2(((t0: P, t1: S) => p(t0, t1).runNow()))))
    __obj.asInstanceOf[StaticLifecycle[P, S]]
  }
}


package typingsSlinky.react.mod

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
  @scala.inline
  implicit class StaticLifecycleOps[Self[p, s] <: StaticLifecycle[p, s], P, S] (val x: Self[P, S]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, S] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, S]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, S]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, S]) with Other]
    @scala.inline
    def withGetDerivedStateFromError(getDerivedStateFromError: /* error */ js.Any => Partial[S] | Null): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (getDerivedStateFromError != null) ret.updateDynamic("getDerivedStateFromError")(js.Any.fromFunction1(getDerivedStateFromError))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutGetDerivedStateFromError: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "getDerivedStateFromError")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withGetDerivedStateFromProps(getDerivedStateFromProps: (P, S) => Partial[S] | Null): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (getDerivedStateFromProps != null) ret.updateDynamic("getDerivedStateFromProps")(js.Any.fromFunction2(getDerivedStateFromProps))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutGetDerivedStateFromProps: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "getDerivedStateFromProps")
        ret.asInstanceOf[Self[P, S]]
    }
  }
  
}


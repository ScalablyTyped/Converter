package typings.react.mod

import typings.std.Partial
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
  def apply[P, S](): StaticLifecycle[P, S] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StaticLifecycle[P, S]]
  }
  @scala.inline
  implicit class StaticLifecycleOps[Self[p, s] <: StaticLifecycle[p, s], P, S] (val x: Self[P, S]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, S] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, S]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, S]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, S]) with Other]
    @scala.inline
    def withGetDerivedStateFromError(value: /* error */ js.Any => Partial[S] | Null): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("getDerivedStateFromError")(js.Any.fromFunction1(value))
        ret
    }
    @scala.inline
    def withoutGetDerivedStateFromError: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("getDerivedStateFromError")(js.undefined)
        ret
    }
    @scala.inline
    def withGetDerivedStateFromProps(value: (P, S) => Partial[S] | Null): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("getDerivedStateFromProps")(js.Any.fromFunction2(value))
        ret
    }
    @scala.inline
    def withoutGetDerivedStateFromProps: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("getDerivedStateFromProps")(js.undefined)
        ret
    }
  }
  
}


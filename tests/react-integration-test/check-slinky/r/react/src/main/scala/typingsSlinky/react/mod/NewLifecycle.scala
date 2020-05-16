package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// This should be "infer SS" but can't use it yet
@js.native
trait NewLifecycle[P, S, SS] extends js.Object {
  /**
    * Called immediately after updating occurs. Not called for the initial render.
    *
    * The snapshot is only present if getSnapshotBeforeUpdate is present and returns non-null.
    */
  var componentDidUpdate: js.UndefOr[
    js.Function3[/* prevProps */ P, /* prevState */ S, /* snapshot */ js.UndefOr[SS], Unit]
  ] = js.native
  /**
    * Runs before React applies the result of `render` to the document, and
    * returns an object to be given to componentDidUpdate. Useful for saving
    * things such as scroll position before `render` causes changes to it.
    *
    * Note: the presence of getSnapshotBeforeUpdate prevents any of the deprecated
    * lifecycle events from running.
    */
  var getSnapshotBeforeUpdate: js.UndefOr[js.Function2[/* prevProps */ P, /* prevState */ S, SS | Null]] = js.native
}

object NewLifecycle {
  @scala.inline
  def apply[P, S, SS](
    componentDidUpdate: (/* prevProps */ P, /* prevState */ S, /* snapshot */ js.UndefOr[SS]) => Unit = null,
    getSnapshotBeforeUpdate: (/* prevProps */ P, /* prevState */ S) => SS | Null = null
  ): NewLifecycle[P, S, SS] = {
    val __obj = js.Dynamic.literal()
    if (componentDidUpdate != null) __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3(componentDidUpdate))
    if (getSnapshotBeforeUpdate != null) __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2(getSnapshotBeforeUpdate))
    __obj.asInstanceOf[NewLifecycle[P, S, SS]]
  }
  @scala.inline
  implicit class NewLifecycleOps[Self[p, s, ss] <: NewLifecycle[p, s, ss], P, S, SS] (val x: Self[P, S, SS]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, S, SS] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, S, SS]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, S, SS]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, S, SS]) with Other]
    @scala.inline
    def withComponentDidUpdate(componentDidUpdate: (/* prevProps */ P, /* prevState */ S, /* snapshot */ js.UndefOr[SS]) => Unit): Self[P, S, SS] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentDidUpdate != null) ret.updateDynamic("componentDidUpdate")(js.Any.fromFunction3(componentDidUpdate))
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withoutComponentDidUpdate: Self[P, S, SS] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentDidUpdate")
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withGetSnapshotBeforeUpdate(getSnapshotBeforeUpdate: (/* prevProps */ P, /* prevState */ S) => SS | Null): Self[P, S, SS] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (getSnapshotBeforeUpdate != null) ret.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2(getSnapshotBeforeUpdate))
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withoutGetSnapshotBeforeUpdate: Self[P, S, SS] = {
        val ret = this.duplicate
        js.special.delete(ret, "getSnapshotBeforeUpdate")
        ret.asInstanceOf[Self[P, S, SS]]
    }
  }
  
}


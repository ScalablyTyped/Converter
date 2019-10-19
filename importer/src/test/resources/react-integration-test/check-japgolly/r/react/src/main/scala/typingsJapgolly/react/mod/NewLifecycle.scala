package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// This should be "infer SS" but can't use it yet
trait NewLifecycle[P, S, SS] extends js.Object {
  /**
    * Called immediately after updating occurs. Not called for the initial render.
    *
    * The snapshot is only present if getSnapshotBeforeUpdate is present and returns non-null.
    */
  var componentDidUpdate: js.UndefOr[
    js.Function3[/* prevProps */ P, /* prevState */ S, /* snapshot */ js.UndefOr[SS], Unit]
  ] = js.undefined
  /**
    * Runs before React applies the result of `render` to the document, and
    * returns an object to be given to componentDidUpdate. Useful for saving
    * things such as scroll position before `render` causes changes to it.
    *
    * Note: the presence of getSnapshotBeforeUpdate prevents any of the deprecated
    * lifecycle events from running.
    */
  var getSnapshotBeforeUpdate: js.UndefOr[js.Function2[/* prevProps */ P, /* prevState */ S, SS | Null]] = js.undefined
}

object NewLifecycle {
  @scala.inline
  def apply[P, S, SS](
    componentDidUpdate: (/* prevProps */ P, /* prevState */ S, /* snapshot */ js.UndefOr[SS]) => Callback = null,
    getSnapshotBeforeUpdate: (/* prevProps */ P, /* prevState */ S) => CallbackTo[SS | Null] = null
  ): NewLifecycle[P, S, SS] = {
    val __obj = js.Dynamic.literal()
    if (componentDidUpdate != null) __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3((t0: /* prevProps */ P, t1: /* prevState */ S, t2: /* snapshot */ js.UndefOr[SS]) => componentDidUpdate(t0, t1, t2).runNow()))
    if (getSnapshotBeforeUpdate != null) __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2((t0: /* prevProps */ P, t1: /* prevState */ S) => getSnapshotBeforeUpdate(t0, t1).runNow()))
    __obj.asInstanceOf[NewLifecycle[P, S, SS]]
  }
}


package typings.rxjs.internalTypesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ErrorObserver[T] extends PartialObserver[T] {
  var closed: js.UndefOr[Boolean] = js.native
  var complete: js.UndefOr[js.Function0[Unit]] = js.native
  var next: js.UndefOr[js.Function1[/* value */ T, Unit]] = js.native
  def error(err: js.Any): Unit = js.native
}

object ErrorObserver {
  @scala.inline
  def apply[T](
    error: js.Any => Unit,
    closed: js.UndefOr[Boolean] = js.undefined,
    complete: () => Unit = null,
    next: /* value */ T => Unit = null
  ): ErrorObserver[T] = {
    val __obj = js.Dynamic.literal(error = js.Any.fromFunction1(error))
    if (!js.isUndefined(closed)) __obj.updateDynamic("closed")(closed.asInstanceOf[js.Any])
    if (complete != null) __obj.updateDynamic("complete")(js.Any.fromFunction0(complete))
    if (next != null) __obj.updateDynamic("next")(js.Any.fromFunction1(next))
    __obj.asInstanceOf[ErrorObserver[T]]
  }
}


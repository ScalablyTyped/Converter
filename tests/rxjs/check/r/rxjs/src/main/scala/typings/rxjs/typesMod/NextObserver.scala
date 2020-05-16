package typings.rxjs.typesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait NextObserver[T] extends PartialObserver[T] {
  var closed: js.UndefOr[Boolean] = js.native
  var complete: js.UndefOr[js.Function0[Unit]] = js.native
  var error: js.UndefOr[js.Function1[/* err */ js.Any, Unit]] = js.native
  def next(value: T): Unit = js.native
}

object NextObserver {
  @scala.inline
  def apply[T](
    next: T => Unit,
    closed: js.UndefOr[Boolean] = js.undefined,
    complete: () => Unit = null,
    error: /* err */ js.Any => Unit = null
  ): NextObserver[T] = {
    val __obj = js.Dynamic.literal(next = js.Any.fromFunction1(next))
    if (!js.isUndefined(closed)) __obj.updateDynamic("closed")(closed.asInstanceOf[js.Any])
    if (complete != null) __obj.updateDynamic("complete")(js.Any.fromFunction0(complete))
    if (error != null) __obj.updateDynamic("error")(js.Any.fromFunction1(error))
    __obj.asInstanceOf[NextObserver[T]]
  }
  @scala.inline
  implicit class NextObserverOps[Self[t] <: NextObserver[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withNext(next: T => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("next")(js.Any.fromFunction1(next))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withClosed(closed: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(closed)) ret.updateDynamic("closed")(closed.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutClosed: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "closed")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withComplete(complete: () => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (complete != null) ret.updateDynamic("complete")(js.Any.fromFunction0(complete))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutComplete: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "complete")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withError(error: /* err */ js.Any => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (error != null) ret.updateDynamic("error")(js.Any.fromFunction1(error))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutError: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "error")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}


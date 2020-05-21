package typings.rxjs.typesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait CompletionObserver[T] extends PartialObserver[T] {
  var closed: js.UndefOr[Boolean] = js.native
  var error: js.UndefOr[js.Function1[/* err */ js.Any, Unit]] = js.native
  var next: js.UndefOr[js.Function1[/* value */ T, Unit]] = js.native
  def complete(): Unit = js.native
}

object CompletionObserver {
  @scala.inline
  def apply[T](
    complete: () => Unit,
    closed: js.UndefOr[Boolean] = js.undefined,
    error: /* err */ js.Any => Unit = null,
    next: /* value */ T => Unit = null
  ): CompletionObserver[T] = {
    val __obj = js.Dynamic.literal(complete = js.Any.fromFunction0(complete))
    if (!js.isUndefined(closed)) __obj.updateDynamic("closed")(closed.asInstanceOf[js.Any])
    if (error != null) __obj.updateDynamic("error")(js.Any.fromFunction1(error))
    if (next != null) __obj.updateDynamic("next")(js.Any.fromFunction1(next))
    __obj.asInstanceOf[CompletionObserver[T]]
  }
  @scala.inline
  implicit class CompletionObserverOps[Self[t] <: CompletionObserver[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withComplete(complete: () => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("complete")(js.Any.fromFunction0(complete))
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
    @scala.inline
    def withNext(next: /* value */ T => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (next != null) ret.updateDynamic("next")(js.Any.fromFunction1(next))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutNext: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "next")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}


package typings.rxjs.typesMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Observer[T] extends js.Object {
  var closed: js.UndefOr[Boolean] = js.native
  def complete(): Unit = js.native
  def error(err: js.Any): Unit = js.native
  def next(value: T): Unit = js.native
}

object Observer {
  @scala.inline
  def apply[T](
    complete: () => Unit,
    error: js.Any => Unit,
    next: T => Unit,
    closed: js.UndefOr[Boolean] = js.undefined
  ): Observer[T] = {
    val __obj = js.Dynamic.literal(complete = js.Any.fromFunction0(complete), error = js.Any.fromFunction1(error), next = js.Any.fromFunction1(next))
    if (!js.isUndefined(closed)) __obj.updateDynamic("closed")(closed.asInstanceOf[js.Any])
    __obj.asInstanceOf[Observer[T]]
  }
  @scala.inline
  implicit class ObserverOps[Self[t] <: Observer[t], T] (val x: Self[T]) extends AnyVal {
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
    def withError(error: js.Any => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("error")(js.Any.fromFunction1(error))
        ret.asInstanceOf[Self[T]]
    }
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
  }
  
}


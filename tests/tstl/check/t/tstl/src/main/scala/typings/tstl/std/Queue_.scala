package typings.tstl.std

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Queue_[T] extends js.Object {
  var container_ : js.Any = js.native
  def empty(): Boolean = js.native
}

object Queue_ {
  @scala.inline
  def apply[T](container_ : js.Any, empty: () => Boolean): Queue_[T] = {
    val __obj = js.Dynamic.literal(container_ = container_.asInstanceOf[js.Any], empty = js.Any.fromFunction0(empty))
    __obj.asInstanceOf[Queue_[T]]
  }
  @scala.inline
  implicit class Queue_Ops[Self[t] <: Queue_[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withContainer_(value: js.Any): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("container_")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withEmpty(value: () => Boolean): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("empty")(js.Any.fromFunction0(value))
        ret
    }
  }
  
}


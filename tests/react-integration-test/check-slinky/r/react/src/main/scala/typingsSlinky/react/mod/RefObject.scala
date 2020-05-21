package typingsSlinky.react.mod

import slinky.core.facade.ReactRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait RefObject[T] extends js.Object {
  val current: T | Null = js.native
}

object RefObject {
  @scala.inline
  def apply[T](current: T = null): RefObject[T] = {
    val __obj = js.Dynamic.literal()
    if (current != null) __obj.updateDynamic("current")(current.asInstanceOf[js.Any])
    __obj.asInstanceOf[RefObject[T]]
  }
  @scala.inline
  implicit class RefObjectOps[Self[t] <: ReactRef[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withCurrent(current: T): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (current != null) ret.updateDynamic("current")(current.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutCurrent: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "current")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}


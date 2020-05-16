package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait MutableRefObject[T] extends js.Object {
  var current: T = js.native
}

object MutableRefObject {
  @scala.inline
  def apply[T](current: T): MutableRefObject[T] = {
    val __obj = js.Dynamic.literal(current = current.asInstanceOf[js.Any])
    __obj.asInstanceOf[MutableRefObject[T]]
  }
  @scala.inline
  implicit class MutableRefObjectOps[Self[t] <: MutableRefObject[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withCurrent(current: T): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("current")(current.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
  }
  
}


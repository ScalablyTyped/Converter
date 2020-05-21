package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.RefHandle
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait RefObject[T] extends js.Object {
  val current: T | Null = js.native
}

object RefObject {
  @scala.inline
  def apply[T](): RefObject[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[RefObject[T]]
  }
  @scala.inline
  implicit class RefObjectOps[Self <: RefHandle[_], T] (val x: Self with RefHandle[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCurrent(value: T): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("current")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withCurrentNull: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("current")(null)
        ret
    }
  }
  
}


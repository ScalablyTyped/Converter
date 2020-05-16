package typingsJapgolly.reactDropzone.mod

import japgolly.scalajs.react.Callback
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DropzoneRef extends js.Object {
  def open(): Unit = js.native
}

object DropzoneRef {
  @scala.inline
  def apply(open: Callback): DropzoneRef = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("open")(open.toJsFn)
    __obj.asInstanceOf[DropzoneRef]
  }
  @scala.inline
  implicit class DropzoneRefOps[Self <: DropzoneRef] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withOpen(open: Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("open")(open.toJsFn)
        ret.asInstanceOf[Self]
    }
  }
  
}


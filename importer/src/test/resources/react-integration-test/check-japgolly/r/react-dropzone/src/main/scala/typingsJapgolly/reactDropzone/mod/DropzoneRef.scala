package typingsJapgolly.reactDropzone.mod

import japgolly.scalajs.react.Callback
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait DropzoneRef extends js.Object {
  def open(): Unit
}

object DropzoneRef {
  @scala.inline
  def apply(open: Callback): DropzoneRef = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("open")(open.toJsFn)
    __obj.asInstanceOf[DropzoneRef]
  }
}


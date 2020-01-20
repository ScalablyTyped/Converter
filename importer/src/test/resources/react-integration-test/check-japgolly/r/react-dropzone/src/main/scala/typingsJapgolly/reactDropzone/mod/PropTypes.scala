package typingsJapgolly.reactDropzone.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.reactDropzone.reactDropzoneStrings.multiple
  - typings.reactDropzone.reactDropzoneStrings.onDragEnter
  - typings.reactDropzone.reactDropzoneStrings.onDragOver
  - typings.reactDropzone.reactDropzoneStrings.onDragLeave
*/
trait PropTypes extends js.Object

object PropTypes {
  @scala.inline
  /* private */ def cast[T](in: js.Any): T = in.asInstanceOf[T]
  @scala.inline
  def multiple: typingsJapgolly.reactDropzone.reactDropzoneStrings.multiple = this.cast("multiple")
  @scala.inline
  def onDragEnter: typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragEnter = this.cast("onDragEnter")
  @scala.inline
  def onDragLeave: typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragLeave = this.cast("onDragLeave")
  @scala.inline
  def onDragOver: typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragOver = this.cast("onDragOver")
}


package typings.reactDropzone.mod

import typings.react.mod.ChangeEvent
import typings.std.DragEvent
import typings.std.Event
import typings.std.HTMLElement
import typings.std.HTMLInputElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.react.mod.DragEvent[typings.std.HTMLElement]
  - typings.react.mod.ChangeEvent[typings.std.HTMLInputElement]
  - typings.std.DragEvent
  - typings.std.Event
*/
trait DropEvent extends js.Object

object DropEvent {
  @scala.inline
  implicit def apply(value: DragEvent | Event): DropEvent = value.asInstanceOf[DropEvent]
  @scala.inline
  implicit def apply(value: ChangeEvent[HTMLInputElement]): DropEvent = value.asInstanceOf[DropEvent]
  @scala.inline
  implicit def apply(value: typings.react.mod.DragEvent[HTMLElement]): DropEvent = value.asInstanceOf[DropEvent]
}


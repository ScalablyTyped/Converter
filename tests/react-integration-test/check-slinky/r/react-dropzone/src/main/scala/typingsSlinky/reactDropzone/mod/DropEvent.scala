package typingsSlinky.reactDropzone.mod

import org.scalajs.dom.raw.DragEvent
import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.HTMLInputElement
import typingsSlinky.react.mod.ChangeEvent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsSlinky.react.mod.DragEvent[typingsSlinky.std.HTMLElement]
  - typingsSlinky.react.mod.ChangeEvent[typingsSlinky.std.HTMLInputElement]
  - typingsSlinky.std.DragEvent
  - typingsSlinky.std.Event
*/
trait DropEvent extends js.Object

object DropEvent {
  @scala.inline
  implicit def apply(value: DragEvent | Event): DropEvent = value.asInstanceOf[DropEvent]
  @scala.inline
  implicit def apply(value: ChangeEvent[HTMLInputElement]): DropEvent = value.asInstanceOf[DropEvent]
  @scala.inline
  implicit def apply(value: typingsSlinky.react.mod.DragEvent[HTMLElement]): DropEvent = value.asInstanceOf[DropEvent]
}


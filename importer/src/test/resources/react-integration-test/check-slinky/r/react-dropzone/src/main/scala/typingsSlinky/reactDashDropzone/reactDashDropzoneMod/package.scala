package typingsSlinky.reactDashDropzone

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactDashDropzoneMod {
  import org.scalajs.dom.raw.Event
  import org.scalajs.dom.raw.HTMLElement
  import org.scalajs.dom.raw.HTMLInputElement
  import typingsSlinky.react.reactMod.ChangeEvent
  import typingsSlinky.react.reactMod.DragEvent

  type DropEvent = DragEvent[HTMLElement] | ChangeEvent[HTMLInputElement] | org.scalajs.dom.raw.DragEvent | Event
}

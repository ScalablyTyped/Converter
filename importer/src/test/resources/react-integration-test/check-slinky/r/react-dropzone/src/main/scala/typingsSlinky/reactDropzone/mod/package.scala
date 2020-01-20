package typingsSlinky.reactDropzone

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  import org.scalajs.dom.raw.Event
  import org.scalajs.dom.raw.HTMLElement
  import org.scalajs.dom.raw.HTMLInputElement
  import typingsSlinky.react.mod.ChangeEvent
  import typingsSlinky.react.mod.DragEvent

  type DropEvent = DragEvent[HTMLElement] | ChangeEvent[HTMLInputElement] | org.scalajs.dom.raw.DragEvent | Event
}

package typingsSlinky.reactDropzone

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactDropzoneMod {
  import typingsSlinky.react.reactMod.ChangeEvent
  import typingsSlinky.react.reactMod.DragEvent
  import typingsSlinky.std.Event
  import typingsSlinky.std.HTMLElement
  import typingsSlinky.std.HTMLInputElement

  type DropEvent = DragEvent[HTMLElement] | ChangeEvent[HTMLInputElement] | typingsSlinky.std.DragEvent | Event
}

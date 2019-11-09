package typings.reactDropzone

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactDropzoneMod {
  import typings.react.reactMod.ChangeEvent
  import typings.react.reactMod.DragEvent
  import typings.std.Event
  import typings.std.HTMLElement
  import typings.std.HTMLInputElement

  type DropEvent = DragEvent[HTMLElement] | ChangeEvent[HTMLInputElement] | typings.std.DragEvent | Event
}

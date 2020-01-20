package typings.reactDropzone

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  import typings.react.mod.ChangeEvent
  import typings.react.mod.DragEvent
  import typings.std.Event
  import typings.std.HTMLElement
  import typings.std.HTMLInputElement

  type DropEvent = DragEvent[HTMLElement] | ChangeEvent[HTMLInputElement] | typings.std.DragEvent | Event
}

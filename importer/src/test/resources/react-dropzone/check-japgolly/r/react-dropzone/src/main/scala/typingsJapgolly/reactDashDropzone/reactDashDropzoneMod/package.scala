package typingsJapgolly.reactDashDropzone

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactDashDropzoneMod {
  import typingsJapgolly.react.reactMod.ChangeEvent
  import typingsJapgolly.react.reactMod.DragEvent
  import typingsJapgolly.std.Event
  import typingsJapgolly.std.HTMLElement
  import typingsJapgolly.std.HTMLInputElement

  type DropEvent = DragEvent[HTMLElement] | ChangeEvent[HTMLInputElement] | typingsJapgolly.std.DragEvent | Event
}

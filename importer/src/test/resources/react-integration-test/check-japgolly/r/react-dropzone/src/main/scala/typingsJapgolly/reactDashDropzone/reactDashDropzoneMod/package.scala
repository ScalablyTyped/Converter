package typingsJapgolly.reactDashDropzone

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactDashDropzoneMod {
  import japgolly.scalajs.react.ReactDragEventFrom
  import japgolly.scalajs.react.ReactEventFrom
  import org.scalajs.dom.raw.DragEvent
  import org.scalajs.dom.raw.Event
  import org.scalajs.dom.raw.HTMLElement
  import org.scalajs.dom.raw.HTMLInputElement

  type DropEvent = ReactDragEventFrom[HTMLElement] | ReactEventFrom[HTMLInputElement] | DragEvent | Event
}

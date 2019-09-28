package typings.reactDashSelect.reactDashSelectMod

import typings.react.reactMod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`

@js.native
trait ReactSelectClass[TValue] extends Component[ReactSelectProps[TValue], js.Object] {
  def focus(): Unit = js.native
  def setValue(value: Option[TValue]): Unit = js.native
}


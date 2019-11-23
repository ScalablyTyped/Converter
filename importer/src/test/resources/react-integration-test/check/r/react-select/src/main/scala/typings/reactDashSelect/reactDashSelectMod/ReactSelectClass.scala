package typings.reactDashSelect.reactDashSelectMod

import typings.react.reactMod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReactSelectClass[TValue]
  extends Component[ReactSelectProps[TValue], js.Object, js.Any] {
  def focus(): Unit = js.native
  def setValue(value: Option[TValue]): Unit = js.native
}


package typingsSlinky.reactSelect.mod

import typingsSlinky.react.mod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReactSelectClass[TValue]
  extends Component[ReactSelectProps[TValue], js.Object, js.Any] {
  def focus(): Unit = js.native
  def setValue(value: Option[TValue]): Unit = js.native
}


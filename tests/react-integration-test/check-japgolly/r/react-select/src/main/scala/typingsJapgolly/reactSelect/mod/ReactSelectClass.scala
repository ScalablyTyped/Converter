package typingsJapgolly.reactSelect.mod

import typingsJapgolly.react.mod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ReactSelectClass[TValue]
  extends Component[ReactSelectProps[TValue], js.Object, js.Any] {
  def focus(): Unit = js.native
  def setValue(value: Option[TValue]): Unit = js.native
}


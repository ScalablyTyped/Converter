package typings
package reactDashSelectLib.reactDashSelectMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReactSelectClass[TValue]
  extends reactLib.reactMod.Component[ReactSelectProps[TValue], js.Object] {
  def focus(): scala.Unit = js.native
  def setValue(value: Option[TValue]): scala.Unit = js.native
}


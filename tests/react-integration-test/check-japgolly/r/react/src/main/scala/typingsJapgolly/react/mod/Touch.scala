package typingsJapgolly.react.mod

import org.scalajs.dom.raw.EventTarget
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Touch extends js.Object {
  var clientX: Double = js.native
  var clientY: Double = js.native
  var identifier: Double = js.native
  var pageX: Double = js.native
  var pageY: Double = js.native
  var screenX: Double = js.native
  var screenY: Double = js.native
  var target: EventTarget = js.native
}

object Touch {
  @scala.inline
  def apply(
    clientX: Double,
    clientY: Double,
    identifier: Double,
    pageX: Double,
    pageY: Double,
    screenX: Double,
    screenY: Double,
    target: EventTarget
  ): Touch = {
    val __obj = js.Dynamic.literal(clientX = clientX.asInstanceOf[js.Any], clientY = clientY.asInstanceOf[js.Any], identifier = identifier.asInstanceOf[js.Any], pageX = pageX.asInstanceOf[js.Any], pageY = pageY.asInstanceOf[js.Any], screenX = screenX.asInstanceOf[js.Any], screenY = screenY.asInstanceOf[js.Any], target = target.asInstanceOf[js.Any])
    __obj.asInstanceOf[Touch]
  }
}


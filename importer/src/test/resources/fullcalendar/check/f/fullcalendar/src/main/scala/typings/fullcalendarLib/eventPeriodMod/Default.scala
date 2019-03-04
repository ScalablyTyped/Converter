package typings
package fullcalendarLib.eventPeriodMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fullcalendar/EventPeriod", "Default")
@js.native
class Default protected () extends js.Object {
  def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
  var eventInstanceGroupsById: js.Any = js.native
  var freezeDepth: scala.Double = js.native
  @JSName("on")
  var on_Original: js.Function2[/* types */ js.Any, /* handler */ js.Any, _] = js.native
  var pendingCnt: scala.Double = js.native
  var requestsByUid: js.Any = js.native
  def isWithinRange(start: js.Any, end: js.Any): scala.Boolean = js.native
  def on(types: js.Any, handler: js.Any): js.Any = js.native
  def thaw(): scala.Unit = js.native
}

@JSImport("fullcalendar/EventPeriod", JSImport.Default)
@js.native
class default protected () extends Default {
  def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
}


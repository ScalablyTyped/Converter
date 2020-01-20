package typings.fullcalendar.eventPeriodMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fullcalendar/EventPeriod", "Default")
@js.native
class Default_ protected () extends js.Object {
  def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
  var eventInstanceGroupsById: js.Any = js.native
  var freezeDepth: Double = js.native
  @JSName("on")
  var on_Original: js.Function2[/* types */ js.Any, /* handler */ js.Any, _] = js.native
  var pendingCnt: Double = js.native
  var requestsByUid: js.Any = js.native
  def isWithinRange(start: js.Any, end: js.Any): Boolean = js.native
  def on(types: js.Any, handler: js.Any): js.Any = js.native
  def thaw(): Unit = js.native
}


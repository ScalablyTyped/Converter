package ScalablyTyped
package FullcalendarLib.FullcalendarEventPeriodModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fullcalendar/EventPeriod", "Default")
@js.native
class Default protected () extends js.Object {
  def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
  val eventInstanceGroupsById: js.Any = js.native
  val freezeDepth: scala.Double = js.native
  val on: js.Function2[/* types */ js.Any, /* handler */ js.Any, _] = js.native
  val pendingCnt: scala.Double = js.native
  val requestsByUid: js.Any = js.native
  def isWithinRange(start: js.Any, end: js.Any): scala.Boolean = js.native
  def thaw(): scala.Unit = js.native
}

@JSImport("fullcalendar/EventPeriod", JSImport.Default)
@js.native
class default protected () extends Default {
  def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
}


package ScalablyTyped
package FullcalendarLib.FullcalendarEventPeriodModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fullcalendar/EventPeriod", "Default")
@js.native
class Default protected () extends js.Object {
  def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
  var eventInstanceGroupsById: js.Any = js.native
  var freezeDepth: scala.Double = js.native
  var on: /* import warning: Failed type conversion: TsTypeLookup(TsTypeRef(TsQIdent(List(TsIdentLibrarySimple(fullcalendar), TsIdentModule(None,List(fullcalendar, EmitterMixin)), TsIdentSimple(EmitterInterface))),List()),Left(TsIdentSimple(on))) */js.Any = js.native
  var pendingCnt: scala.Double = js.native
  var requestsByUid: js.Any = js.native
  def isWithinRange(start: js.Any, end: js.Any): scala.Boolean = js.native
  def thaw(): scala.Unit = js.native
}

@JSImport("fullcalendar/EventPeriod", JSImport.Default)
@js.native
class default protected () extends Default {
  def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
}


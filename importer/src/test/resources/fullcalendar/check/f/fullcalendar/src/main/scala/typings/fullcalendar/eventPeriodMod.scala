package typings.fullcalendar

import typings.fullcalendar.eventPeriodMod.Default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fullcalendar/EventPeriod", JSImport.Namespace)
@js.native
object eventPeriodMod extends js.Object {
  @js.native
  class Default protected () extends js.Object {
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
  
  @js.native
  class default protected () extends Default {
    def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
  }
  
}


package typings.fullcalendar

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object eventPeriodMod {
  
  @JSImport("fullcalendar/EventPeriod", "Default")
  @js.native
  class Default_ protected () extends js.Object {
    def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
    
    var eventInstanceGroupsById: js.Any = js.native
    
    var freezeDepth: Double = js.native
    
    def isWithinRange(start: js.Any, end: js.Any): Boolean = js.native
    
    def on(types: js.Any, handler: js.Any): js.Any = js.native
    @JSName("on")
    var on_Original: js.Function2[/* types */ js.Any, /* handler */ js.Any, _] = js.native
    
    var pendingCnt: Double = js.native
    
    var requestsByUid: js.Any = js.native
    
    def thaw(): Unit = js.native
  }
  
  @JSImport("fullcalendar/EventPeriod", JSImport.Default)
  @js.native
  class default protected () extends Default_ {
    def this(start: js.Any, end: js.Any, timezone: js.Any) = this()
  }
}

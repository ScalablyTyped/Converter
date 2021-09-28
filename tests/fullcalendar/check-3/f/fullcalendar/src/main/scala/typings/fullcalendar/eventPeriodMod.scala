package typings.fullcalendar

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object eventPeriodMod {
  
  @JSImport("fullcalendar/EventPeriod", JSImport.Default)
  @js.native
  open class default protected () extends Default_ {
    def this(start: Any, end: Any, timezone: Any) = this()
  }
  
  @JSImport("fullcalendar/EventPeriod", "Default")
  @js.native
  open class Default_ protected () extends StObject {
    def this(start: Any, end: Any, timezone: Any) = this()
    
    var eventInstanceGroupsById: Any = js.native
    
    var freezeDepth: Double = js.native
    
    def isWithinRange(start: Any, end: Any): Boolean = js.native
    
    def on(types: Any, handler: Any): Any = js.native
    @JSName("on")
    var on_Original: js.Function2[/* types */ Any, /* handler */ Any, Any] = js.native
    
    var pendingCnt: Double = js.native
    
    var requestsByUid: Any = js.native
    
    def thaw(): Unit = js.native
  }
}

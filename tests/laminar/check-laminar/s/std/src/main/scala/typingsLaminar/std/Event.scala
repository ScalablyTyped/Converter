package typingsLaminar.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Event extends StObject {
  
  val bubbles: Boolean = js.native
  
  var cancelBubble: Boolean = js.native
}
object Event {
  
  @scala.inline
  def apply(bubbles: Boolean, cancelBubble: Boolean): org.scalajs.dom.raw.Event = {
    val __obj = js.Dynamic.literal(bubbles = bubbles.asInstanceOf[js.Any], cancelBubble = cancelBubble.asInstanceOf[js.Any])
    __obj.asInstanceOf[org.scalajs.dom.raw.Event]
  }
  
  @scala.inline
  implicit class EventMutableBuilder[Self <: org.scalajs.dom.raw.Event] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setBubbles(value: Boolean): Self = StObject.set(x, "bubbles", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setCancelBubble(value: Boolean): Self = StObject.set(x, "cancelBubble", value.asInstanceOf[js.Any])
  }
}

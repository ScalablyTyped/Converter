package typingsSlinky.stardustUiReactComponentEventListener

import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventTypes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", JSImport.Namespace)
@js.native
object eventListenerMod extends js.Object {
  @js.native
  object default extends js.Object {
    var displayName: String = js.native
    var propTypes: AnonCapture | AnonListener = js.native
    def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = js.native
    @js.native
    object defaultProps extends js.Object {
      var capture: Boolean = js.native
    }
    
  }
  
}


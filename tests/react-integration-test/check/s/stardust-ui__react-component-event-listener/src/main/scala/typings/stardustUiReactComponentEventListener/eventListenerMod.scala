package typings.stardustUiReactComponentEventListener

import typings.stardustUiReactComponentEventListener.anon.Capture
import typings.stardustUiReactComponentEventListener.anon.Listener
import typings.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typings.stardustUiReactComponentEventListener.typesMod.EventTypes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", JSImport.Namespace)
@js.native
object eventListenerMod extends js.Object {
  @js.native
  object default extends js.Object {
    var displayName: String = js.native
    var propTypes: Capture | Listener = js.native
    def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = js.native
    @js.native
    object defaultProps extends js.Object {
      var capture: Boolean = js.native
    }
    
  }
  
}


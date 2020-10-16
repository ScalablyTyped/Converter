package typingsJapgolly.stardustUiReactComponentEventListener

import typingsJapgolly.stardustUiReactComponentEventListener.anon.Capture
import typingsJapgolly.stardustUiReactComponentEventListener.anon.Listener
import typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventTypes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", JSImport.Namespace)
@js.native
object eventListenerMod extends js.Object {
  @js.native
  object default extends js.Object {
    def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = js.native
    var displayName: String = js.native
    var propTypes: Capture | Listener = js.native
    @js.native
    object defaultProps extends js.Object {
      var capture: Boolean = js.native
    }
    
  }
  
}


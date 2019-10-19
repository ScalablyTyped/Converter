package typings.stardustUiReactComponentEventListener.mod.dist.es

import typings.stardustUiReactComponentEventListener.Anon_Capture
import typings.stardustUiReactComponentEventListener.Anon_CaptureListener
import typings.stardustUiReactComponentEventListener.mod.dist.es.types.EventListenerOptions
import typings.stardustUiReactComponentEventListener.mod.dist.es.types.EventTypes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", JSImport.Namespace)
@js.native
object EventListener extends js.Object {
  @js.native
  object default extends js.Object {
    var displayName: String = js.native
    var propTypes: Anon_Capture | Anon_CaptureListener = js.native
    def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = js.native
    @js.native
    object defaultProps extends js.Object {
      var capture: Boolean = js.native
    }
    
  }
  
}


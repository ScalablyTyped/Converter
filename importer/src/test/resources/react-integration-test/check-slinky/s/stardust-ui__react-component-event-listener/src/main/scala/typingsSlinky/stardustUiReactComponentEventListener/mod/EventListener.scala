package typingsSlinky.stardustUiReactComponentEventListener.mod

import typingsSlinky.stardustUiReactComponentEventListener.Anon_Capture
import typingsSlinky.stardustUiReactComponentEventListener.Anon_CaptureListener
import typingsSlinky.stardustUiReactComponentEventListener.mod.dist.es.types.EventListenerOptions
import typingsSlinky.stardustUiReactComponentEventListener.mod.dist.es.types.EventTypes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-event-listener", "EventListener")
@js.native
object EventListener extends js.Object {
  var displayName: String = js.native
  var propTypes: Anon_Capture | Anon_CaptureListener = js.native
  def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = js.native
  @js.native
  object defaultProps extends js.Object {
    var capture: Boolean = js.native
  }
  
}


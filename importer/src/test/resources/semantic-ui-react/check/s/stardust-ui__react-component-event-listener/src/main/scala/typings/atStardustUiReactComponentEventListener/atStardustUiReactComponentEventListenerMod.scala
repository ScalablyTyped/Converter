package typings.atStardustUiReactComponentEventListener

import typings.atStardustUiReactComponentEventListener.esTypesMod.EventListenerOptions
import typings.atStardustUiReactComponentEventListener.esTypesMod.EventTypes
import typings.atStardustUiReactComponentEventListener.esTypesMod.TargetRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-event-listener", JSImport.Namespace)
@js.native
object atStardustUiReactComponentEventListenerMod extends js.Object {
  val documentRef: TargetRef = js.native
  val windowRef: TargetRef = js.native
  def useEventListener[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 91 */ js.Any */](options: EventListenerOptions[T]): Unit = js.native
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
  
}


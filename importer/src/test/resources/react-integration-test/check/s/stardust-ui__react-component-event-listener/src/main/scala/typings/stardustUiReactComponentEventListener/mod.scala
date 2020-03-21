package typings.stardustUiReactComponentEventListener

import typings.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typings.stardustUiReactComponentEventListener.typesMod.EventTypes
import typings.stardustUiReactComponentEventListener.typesMod.TargetRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-event-listener", JSImport.Namespace)
@js.native
object mod extends js.Object {
  val documentRef: TargetRef = js.native
  val windowRef: TargetRef = js.native
  def useEventListener[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 91 */ js.Any */](options: EventListenerOptions[T]): Unit = js.native
  @js.native
  object EventListener extends js.Object {
    var displayName: String = js.native
    var propTypes: AnonCapture | AnonListener = js.native
    def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = js.native
    @js.native
    object defaultProps extends js.Object {
      var capture: Boolean = js.native
    }
    
  }
  
}


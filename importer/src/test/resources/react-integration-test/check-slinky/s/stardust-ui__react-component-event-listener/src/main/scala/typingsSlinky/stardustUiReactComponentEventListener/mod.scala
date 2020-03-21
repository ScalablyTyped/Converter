package typingsSlinky.stardustUiReactComponentEventListener

import slinky.core.facade.ReactRef
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventTypes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-event-listener", JSImport.Namespace)
@js.native
object mod extends js.Object {
  val documentRef: ReactRef[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
  val windowRef: ReactRef[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
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


package typingsJapgolly.stardustUiReactComponentEventListener

import japgolly.scalajs.react.raw.React.RefHandle
import typingsJapgolly.stardustUiReactComponentEventListener.anon.Capture
import typingsJapgolly.stardustUiReactComponentEventListener.anon.Listener
import typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventTypes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("@stardust-ui/react-component-event-listener", JSImport.Namespace)
@js.native
object mod extends js.Object {
  val documentRef: RefHandle[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
  def useEventListener[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 91 */ js.Any */](options: EventListenerOptions[T]): Unit = js.native
  val windowRef: RefHandle[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
  @js.native
  object EventListener extends js.Object {
    def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = js.native
    var displayName: String = js.native
    var propTypes: Capture | Listener = js.native
    @js.native
    object defaultProps extends js.Object {
      var capture: Boolean = js.native
    }
    
  }
  
}


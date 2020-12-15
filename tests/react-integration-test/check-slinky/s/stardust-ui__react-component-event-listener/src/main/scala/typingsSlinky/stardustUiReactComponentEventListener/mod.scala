package typingsSlinky.stardustUiReactComponentEventListener

import slinky.core.facade.ReactRef
import typingsSlinky.stardustUiReactComponentEventListener.anon.Capture
import typingsSlinky.stardustUiReactComponentEventListener.anon.Listener
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventTypes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("@stardust-ui/react-component-event-listener", "documentRef")
  @js.native
  val documentRef: ReactRef[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
  
  @JSImport("@stardust-ui/react-component-event-listener", "useEventListener")
  @js.native
  def useEventListener[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 91 */ js.Any */](options: EventListenerOptions[T]): Unit = js.native
  
  @JSImport("@stardust-ui/react-component-event-listener", "windowRef")
  @js.native
  val windowRef: ReactRef[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
  
  object EventListener {
    
    @JSImport("@stardust-ui/react-component-event-listener", "EventListener")
    @js.native
    val ^ : js.Any = js.native
    @JSImport("@stardust-ui/react-component-event-listener", "EventListener")
    @js.native
    def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = js.native
    
    @JSImport("@stardust-ui/react-component-event-listener", "EventListener.displayName")
    @js.native
    def displayName: String = js.native
    @scala.inline
    def displayName_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("displayName")(x.asInstanceOf[js.Any])
    
    @JSImport("@stardust-ui/react-component-event-listener", "EventListener.propTypes")
    @js.native
    def propTypes: Capture | Listener = js.native
    @scala.inline
    def propTypes_=(x: Capture | Listener): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(x.asInstanceOf[js.Any])
    
    object defaultProps {
      
      @JSImport("@stardust-ui/react-component-event-listener", "EventListener.defaultProps")
      @js.native
      val ^ : js.Any = js.native
      
      @JSImport("@stardust-ui/react-component-event-listener", "EventListener.defaultProps.capture")
      @js.native
      def capture: Boolean = js.native
      @scala.inline
      def capture_=(x: Boolean): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("capture")(x.asInstanceOf[js.Any])
    }
  }
}

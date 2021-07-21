package typingsSlinky.stardustUiReactComponentEventListener

import slinky.core.facade.ReactRef
import typingsSlinky.stardustUiReactComponentEventListener.anon.Capture
import typingsSlinky.stardustUiReactComponentEventListener.anon.Listener
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventTypes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("@stardust-ui/react-component-event-listener", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  object EventListener {
    
    inline def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = ^.asInstanceOf[js.Dynamic].apply(props.asInstanceOf[js.Any]).asInstanceOf[js.Any]
    
    @JSImport("@stardust-ui/react-component-event-listener", "EventListener")
    @js.native
    val ^ : js.Any = js.native
    
    object defaultProps {
      
      @JSImport("@stardust-ui/react-component-event-listener", "EventListener.defaultProps")
      @js.native
      val ^ : js.Any = js.native
      
      @JSImport("@stardust-ui/react-component-event-listener", "EventListener.defaultProps.capture")
      @js.native
      def capture: Boolean = js.native
      inline def capture_=(x: Boolean): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("capture")(x.asInstanceOf[js.Any])
    }
    
    @JSImport("@stardust-ui/react-component-event-listener", "EventListener.displayName")
    @js.native
    def displayName: String = js.native
    inline def displayName_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("displayName")(x.asInstanceOf[js.Any])
    
    @JSImport("@stardust-ui/react-component-event-listener", "EventListener.propTypes")
    @js.native
    def propTypes: Capture | Listener = js.native
    inline def propTypes_=(x: Capture | Listener): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(x.asInstanceOf[js.Any])
  }
  
  @JSImport("@stardust-ui/react-component-event-listener", "documentRef")
  @js.native
  val documentRef: ReactRef[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
  
  inline def useEventListener[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 91 */ js.Any */](options: EventListenerOptions[T]): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("useEventListener")(options.asInstanceOf[js.Any]).asInstanceOf[Unit]
  
  @JSImport("@stardust-ui/react-component-event-listener", "windowRef")
  @js.native
  val windowRef: ReactRef[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
}

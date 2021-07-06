package typingsSlinky.stardustUiReactComponentEventListener

import typingsSlinky.stardustUiReactComponentEventListener.anon.Capture
import typingsSlinky.stardustUiReactComponentEventListener.anon.Listener
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typingsSlinky.stardustUiReactComponentEventListener.typesMod.EventTypes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object eventListenerMod {
  
  object default {
    
    @scala.inline
    def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = ^.asInstanceOf[js.Dynamic].apply(props.asInstanceOf[js.Any]).asInstanceOf[js.Any]
    
    @JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", JSImport.Default)
    @js.native
    val ^ : js.Any = js.native
    
    object defaultProps {
      
      @JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", "default.defaultProps")
      @js.native
      val ^ : js.Any = js.native
      
      @JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", "default.defaultProps.capture")
      @js.native
      def capture: Boolean = js.native
      @scala.inline
      def capture_=(x: Boolean): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("capture")(x.asInstanceOf[js.Any])
    }
    
    @JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", "default.displayName")
    @js.native
    def displayName: String = js.native
    @scala.inline
    def displayName_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("displayName")(x.asInstanceOf[js.Any])
    
    @JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", "default.propTypes")
    @js.native
    def propTypes: Capture | Listener = js.native
    @scala.inline
    def propTypes_=(x: Capture | Listener): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(x.asInstanceOf[js.Any])
  }
}

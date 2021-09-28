package typingsJapgolly.stardustUiReactComponentEventListener

import typingsJapgolly.stardustUiReactComponentEventListener.anon.Capture
import typingsJapgolly.stardustUiReactComponentEventListener.anon.Listener
import typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventTypes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object eventListenerMod {
  
  object default {
    
    inline def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): Any = ^.asInstanceOf[js.Dynamic].apply(props.asInstanceOf[js.Any]).asInstanceOf[Any]
    
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
      inline def capture_=(x: Boolean): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("capture")(x.asInstanceOf[js.Any])
    }
    
    @JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", "default.displayName")
    @js.native
    def displayName: String = js.native
    inline def displayName_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("displayName")(x.asInstanceOf[js.Any])
    
    @JSImport("@stardust-ui/react-component-event-listener/dist/es/EventListener", "default.propTypes")
    @js.native
    def propTypes: Capture | Listener = js.native
    inline def propTypes_=(x: Capture | Listener): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(x.asInstanceOf[js.Any])
  }
}

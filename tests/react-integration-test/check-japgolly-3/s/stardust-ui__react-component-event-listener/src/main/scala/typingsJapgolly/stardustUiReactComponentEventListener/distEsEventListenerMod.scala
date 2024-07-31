package typingsJapgolly.stardustUiReactComponentEventListener

import _root_.typingsJapgolly.stardustUiReactComponentEventListener.anon.Capture
import _root_.typingsJapgolly.stardustUiReactComponentEventListener.anon.Listener
import _root_.typingsJapgolly.stardustUiReactComponentEventListener.distEsTypesMod.EventListenerOptions
import _root_.typingsJapgolly.stardustUiReactComponentEventListener.distEsTypesMod.EventTypes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distEsEventListenerMod {
  
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

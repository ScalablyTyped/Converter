package typingsJapgolly.stardustUiReactComponentEventListener

import japgolly.scalajs.react.raw.React.RefHandle
import typingsJapgolly.stardustUiReactComponentEventListener.anon.Capture
import typingsJapgolly.stardustUiReactComponentEventListener.anon.Listener
import typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventListenerOptions
import typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventTypes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("@stardust-ui/react-component-event-listener", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  object EventListener {
    
    @scala.inline
    def apply[T /* <: EventTypes */](props: EventListenerOptions[T]): js.Any = ^.asInstanceOf[js.Dynamic].apply(props.asInstanceOf[js.Any]).asInstanceOf[js.Any]
    
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
      @scala.inline
      def capture_=(x: Boolean): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("capture")(x.asInstanceOf[js.Any])
    }
    
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
  }
  
  @JSImport("@stardust-ui/react-component-event-listener", "documentRef")
  @js.native
  val documentRef: RefHandle[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
  
  @scala.inline
  def useEventListener[T /* <: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 91 */ js.Any */](options: EventListenerOptions[T]): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("useEventListener")(options.asInstanceOf[js.Any]).asInstanceOf[Unit]
  
  @JSImport("@stardust-ui/react-component-event-listener", "windowRef")
  @js.native
  val windowRef: RefHandle[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
}

package typings.electron

import typings.electron.electronStrings.`accessibility-support-changed`
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Electron {
  
  type AllElectron = MainInterface
  
  @js.native
  trait App
    extends StObject
       with EventEmitter {
    
    // Docs: http://electron.atom.io/docs/api/app
    /**
      * Emitted when Chrome's accessibility support changes. This event fires when
      * assistive technologies, such as screen readers, are enabled or disabled. See
      * https://www.chromium.org/developers/design-documents/accessibility for more
      * details.
      */
    @JSName("on")
    def on_accessibilitysupportchanged(event: `accessibility-support-changed`, listener: js.Any): String = js.native
  }
  object App {
    
    @scala.inline
    def apply(addListener: (String, js.Function) => App, on: (`accessibility-support-changed`, js.Any) => String): App = {
      val __obj = js.Dynamic.literal(addListener = js.Any.fromFunction2(addListener), on = js.Any.fromFunction2(on))
      __obj.asInstanceOf[App]
    }
    
    @scala.inline
    implicit class AppMutableBuilder[Self <: App] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setOn(value: (`accessibility-support-changed`, js.Any) => String): Self = StObject.set(x, "on", js.Any.fromFunction2(value))
    }
  }
  
  @js.native
  trait CommonInterface extends StObject
  
  @js.native
  trait Event
    extends StObject
       with typings.std.Event {
    
    var altKey: js.UndefOr[Boolean] = js.native
    
    var ctrlKey: js.UndefOr[Boolean] = js.native
    
    var metaKey: js.UndefOr[Boolean] = js.native
    
    def preventDefault(): Unit = js.native
    
    var returnValue: js.Any = js.native
    
    var shiftKey: js.UndefOr[Boolean] = js.native
  }
  object Event {
    
    @scala.inline
    def apply(preventDefault: () => Unit, returnValue: js.Any): Event = {
      val __obj = js.Dynamic.literal(preventDefault = js.Any.fromFunction0(preventDefault), returnValue = returnValue.asInstanceOf[js.Any])
      __obj.asInstanceOf[Event]
    }
    
    @scala.inline
    implicit class EventMutableBuilder[Self <: Event] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setAltKey(value: Boolean): Self = StObject.set(x, "altKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setAltKeyUndefined: Self = StObject.set(x, "altKey", js.undefined)
      
      @scala.inline
      def setCtrlKey(value: Boolean): Self = StObject.set(x, "ctrlKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setCtrlKeyUndefined: Self = StObject.set(x, "ctrlKey", js.undefined)
      
      @scala.inline
      def setMetaKey(value: Boolean): Self = StObject.set(x, "metaKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setMetaKeyUndefined: Self = StObject.set(x, "metaKey", js.undefined)
      
      @scala.inline
      def setPreventDefault(value: () => Unit): Self = StObject.set(x, "preventDefault", js.Any.fromFunction0(value))
      
      @scala.inline
      def setReturnValue(value: js.Any): Self = StObject.set(x, "returnValue", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setShiftKey(value: Boolean): Self = StObject.set(x, "shiftKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setShiftKeyUndefined: Self = StObject.set(x, "shiftKey", js.undefined)
    }
  }
  
  @js.native
  trait EventEmitter extends StObject {
    
    def addListener(event: String, listener: js.Function): this.type = js.native
  }
  object EventEmitter {
    
    @scala.inline
    def apply(addListener: (String, js.Function) => EventEmitter): EventEmitter = {
      val __obj = js.Dynamic.literal(addListener = js.Any.fromFunction2(addListener))
      __obj.asInstanceOf[EventEmitter]
    }
    
    @scala.inline
    implicit class EventEmitterMutableBuilder[Self <: EventEmitter] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setAddListener(value: (String, js.Function) => EventEmitter): Self = StObject.set(x, "addListener", js.Any.fromFunction2(value))
    }
  }
  
  @js.native
  trait MainInterface
    extends StObject
       with CommonInterface {
    
    var app: App = js.native
  }
  object MainInterface {
    
    @scala.inline
    def apply(app: App): MainInterface = {
      val __obj = js.Dynamic.literal(app = app.asInstanceOf[js.Any])
      __obj.asInstanceOf[MainInterface]
    }
    
    @scala.inline
    implicit class MainInterfaceMutableBuilder[Self <: MainInterface] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setApp(value: App): Self = StObject.set(x, "app", value.asInstanceOf[js.Any])
    }
  }
}

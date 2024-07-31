package typings.electron

import _root_.typings.electron.electronStrings.`accessibility-support-changed`
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Electron {
  
  type AllElectron = MainInterface
  
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
    def on_accessibilitysupportchanged(event: `accessibility-support-changed`, listener: Any): String
  }
  object App {
    
    inline def apply(addListener: (String, js.Function) => App, on: (`accessibility-support-changed`, Any) => String): App = {
      val __obj = js.Dynamic.literal(addListener = js.Any.fromFunction2(addListener), on = js.Any.fromFunction2(on))
      __obj.asInstanceOf[App]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: App] (val x: Self) extends AnyVal {
      
      inline def setOn(value: (`accessibility-support-changed`, Any) => String): Self = StObject.set(x, "on", js.Any.fromFunction2(value))
    }
  }
  
  trait CommonInterface extends StObject
  
  trait Event
    extends StObject
       with _root_.typings.std.Event {
    
    var altKey: js.UndefOr[Boolean] = js.undefined
    
    var ctrlKey: js.UndefOr[Boolean] = js.undefined
    
    var metaKey: js.UndefOr[Boolean] = js.undefined
    
    def preventDefault(): Unit
    
    var returnValue: Any
    
    var shiftKey: js.UndefOr[Boolean] = js.undefined
  }
  object Event {
    
    inline def apply(preventDefault: () => Unit, returnValue: Any): Event = {
      val __obj = js.Dynamic.literal(preventDefault = js.Any.fromFunction0(preventDefault), returnValue = returnValue.asInstanceOf[js.Any])
      __obj.asInstanceOf[Event]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Event] (val x: Self) extends AnyVal {
      
      inline def setAltKey(value: Boolean): Self = StObject.set(x, "altKey", value.asInstanceOf[js.Any])
      
      inline def setAltKeyUndefined: Self = StObject.set(x, "altKey", js.undefined)
      
      inline def setCtrlKey(value: Boolean): Self = StObject.set(x, "ctrlKey", value.asInstanceOf[js.Any])
      
      inline def setCtrlKeyUndefined: Self = StObject.set(x, "ctrlKey", js.undefined)
      
      inline def setMetaKey(value: Boolean): Self = StObject.set(x, "metaKey", value.asInstanceOf[js.Any])
      
      inline def setMetaKeyUndefined: Self = StObject.set(x, "metaKey", js.undefined)
      
      inline def setPreventDefault(value: () => Unit): Self = StObject.set(x, "preventDefault", js.Any.fromFunction0(value))
      
      inline def setReturnValue(value: Any): Self = StObject.set(x, "returnValue", value.asInstanceOf[js.Any])
      
      inline def setShiftKey(value: Boolean): Self = StObject.set(x, "shiftKey", value.asInstanceOf[js.Any])
      
      inline def setShiftKeyUndefined: Self = StObject.set(x, "shiftKey", js.undefined)
    }
  }
  
  trait EventEmitter extends StObject {
    
    def addListener(event: String, listener: js.Function): this.type
  }
  object EventEmitter {
    
    inline def apply(addListener: (String, js.Function) => EventEmitter): EventEmitter = {
      val __obj = js.Dynamic.literal(addListener = js.Any.fromFunction2(addListener))
      __obj.asInstanceOf[EventEmitter]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: EventEmitter] (val x: Self) extends AnyVal {
      
      inline def setAddListener(value: (String, js.Function) => EventEmitter): Self = StObject.set(x, "addListener", js.Any.fromFunction2(value))
    }
  }
  
  trait MainInterface
    extends StObject
       with CommonInterface {
    
    var app: App
  }
  object MainInterface {
    
    inline def apply(app: App): MainInterface = {
      val __obj = js.Dynamic.literal(app = app.asInstanceOf[js.Any])
      __obj.asInstanceOf[MainInterface]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: MainInterface] (val x: Self) extends AnyVal {
      
      inline def setApp(value: App): Self = StObject.set(x, "app", value.asInstanceOf[js.Any])
    }
  }
}

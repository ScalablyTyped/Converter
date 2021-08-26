package typings.electron

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
    def `on_accessibility-support-changed`(event: "accessibility-support-changed", listener: js.Any): String
  }
  object App {
    
    inline def apply(addListener: (String, js.Function) => App, on: ("accessibility-support-changed", js.Any) => String): App = {
      val __obj = js.Dynamic.literal(addListener = js.Any.fromFunction2(addListener), on = js.Any.fromFunction2(on))
      __obj.asInstanceOf[App]
    }
    
    extension [Self <: App](x: Self) {
      
      inline def setOn(value: ("accessibility-support-changed", js.Any) => String): Self = StObject.set(x, "on", js.Any.fromFunction2(value))
    }
  }
  
  trait CommonInterface extends StObject
  
  trait Event
    extends StObject
       with typings.std.Event {
    
    var altKey: js.UndefOr[Boolean] = js.undefined
    
    var ctrlKey: js.UndefOr[Boolean] = js.undefined
    
    var metaKey: js.UndefOr[Boolean] = js.undefined
    
    def preventDefault(): Unit
    
    var returnValue: js.Any
    
    var shiftKey: js.UndefOr[Boolean] = js.undefined
  }
  object Event {
    
    inline def apply(preventDefault: () => Unit, returnValue: js.Any): Event = {
      val __obj = js.Dynamic.literal(preventDefault = js.Any.fromFunction0(preventDefault), returnValue = returnValue.asInstanceOf[js.Any])
      __obj.asInstanceOf[Event]
    }
    
    extension [Self <: Event](x: Self) {
      
      inline def setAltKey(value: Boolean): Self = StObject.set(x, "altKey", value.asInstanceOf[js.Any])
      
      inline def setAltKeyUndefined: Self = StObject.set(x, "altKey", js.undefined)
      
      inline def setCtrlKey(value: Boolean): Self = StObject.set(x, "ctrlKey", value.asInstanceOf[js.Any])
      
      inline def setCtrlKeyUndefined: Self = StObject.set(x, "ctrlKey", js.undefined)
      
      inline def setMetaKey(value: Boolean): Self = StObject.set(x, "metaKey", value.asInstanceOf[js.Any])
      
      inline def setMetaKeyUndefined: Self = StObject.set(x, "metaKey", js.undefined)
      
      inline def setPreventDefault(value: () => Unit): Self = StObject.set(x, "preventDefault", js.Any.fromFunction0(value))
      
      inline def setReturnValue(value: js.Any): Self = StObject.set(x, "returnValue", value.asInstanceOf[js.Any])
      
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
    
    extension [Self <: EventEmitter](x: Self) {
      
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
    
    extension [Self <: MainInterface](x: Self) {
      
      inline def setApp(value: App): Self = StObject.set(x, "app", value.asInstanceOf[js.Any])
    }
  }
}

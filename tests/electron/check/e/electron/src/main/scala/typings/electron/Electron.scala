package typings.electron

import typings.electron.electronStrings.`accessibility-support-changed`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Electron {
  
  @js.native
  trait App extends EventEmitter {
    
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
    implicit class AppOps[Self <: App] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setOn(value: (`accessibility-support-changed`, js.Any) => String): Self = this.set("on", js.Any.fromFunction2(value))
    }
  }
  
  @js.native
  trait CommonInterface extends js.Object
  
  @js.native
  trait Event
    extends typings.std.Event {
    
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
    implicit class EventOps[Self <: Event] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setPreventDefault(value: () => Unit): Self = this.set("preventDefault", js.Any.fromFunction0(value))
      
      @scala.inline
      def setReturnValue(value: js.Any): Self = this.set("returnValue", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setAltKey(value: Boolean): Self = this.set("altKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAltKey: Self = this.set("altKey", js.undefined)
      
      @scala.inline
      def setCtrlKey(value: Boolean): Self = this.set("ctrlKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteCtrlKey: Self = this.set("ctrlKey", js.undefined)
      
      @scala.inline
      def setMetaKey(value: Boolean): Self = this.set("metaKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteMetaKey: Self = this.set("metaKey", js.undefined)
      
      @scala.inline
      def setShiftKey(value: Boolean): Self = this.set("shiftKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteShiftKey: Self = this.set("shiftKey", js.undefined)
    }
  }
  
  @js.native
  trait EventEmitter extends js.Object {
    
    def addListener(event: String, listener: js.Function): this.type = js.native
  }
  object EventEmitter {
    
    @scala.inline
    def apply(addListener: (String, js.Function) => EventEmitter): EventEmitter = {
      val __obj = js.Dynamic.literal(addListener = js.Any.fromFunction2(addListener))
      __obj.asInstanceOf[EventEmitter]
    }
    
    @scala.inline
    implicit class EventEmitterOps[Self <: EventEmitter] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setAddListener(value: (String, js.Function) => EventEmitter): Self = this.set("addListener", js.Any.fromFunction2(value))
    }
  }
  
  @js.native
  trait MainInterface extends CommonInterface {
    
    var app: App = js.native
  }
  object MainInterface {
    
    @scala.inline
    def apply(app: App): MainInterface = {
      val __obj = js.Dynamic.literal(app = app.asInstanceOf[js.Any])
      __obj.asInstanceOf[MainInterface]
    }
    
    @scala.inline
    implicit class MainInterfaceOps[Self <: MainInterface] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setApp(value: App): Self = this.set("app", value.asInstanceOf[js.Any])
    }
  }
  
  type AllElectron = MainInterface
}

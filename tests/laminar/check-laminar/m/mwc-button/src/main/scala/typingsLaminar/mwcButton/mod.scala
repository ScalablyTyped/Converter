package typingsLaminar.mwcButton

import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.HTMLElement
import typingsLaminar.litElement.mod.CSSResult
import typingsLaminar.litElement.mod.LitElement
import typingsLaminar.mwcRipple.mod.Ripple
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("mwc-button", "Button")
  @js.native
  class Button () extends ButtonBase
  /* static members */
  object Button {
    
    @JSImport("mwc-button", "Button")
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("mwc-button", "Button.styles")
    @js.native
    def styles: CSSResult = js.native
    @scala.inline
    def styles_=(x: CSSResult): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("styles")(x.asInstanceOf[js.Any])
  }
  
  @JSImport("mwc-button", "ButtonBase")
  @js.native
  class ButtonBase () extends LitElement {
    
    var buttonElement: HTMLElement = js.native
    
    var dense: Boolean = js.native
    
    var disabled: Boolean = js.native
    
    var expandContent: Boolean = js.native
    
    var fullwidth: Boolean = js.native
    
    /* protected */ def handleRippleActivate(): Unit = js.native
    /* protected */ def handleRippleActivate(evt: Event): Unit = js.native
    
    /* protected */ def handleRippleBlur(): Unit = js.native
    
    /* protected */ def handleRippleDeactivate(): Unit = js.native
    
    /* protected */ def handleRippleFocus(): Unit = js.native
    
    /* protected */ def handleRippleMouseEnter(): Unit = js.native
    
    /* protected */ def handleRippleMouseLeave(): Unit = js.native
    
    var icon: String = js.native
    
    var label: String = js.native
    
    var outlined: Boolean = js.native
    
    var raised: Boolean = js.native
    
    var ripple: js.Promise[Ripple | Null] = js.native
    
    var trailingIcon: Boolean = js.native
    
    var unelevated: Boolean = js.native
  }
  
  object global {
    
    @js.native
    trait HTMLElementTagNameMap extends StObject {
      
      var `mwc-button`: Button = js.native
    }
    object HTMLElementTagNameMap {
      
      @scala.inline
      def apply(`mwc-button`: Button): HTMLElementTagNameMap = {
        val __obj = js.Dynamic.literal()
        __obj.updateDynamic("mwc-button")(`mwc-button`.asInstanceOf[js.Any])
        __obj.asInstanceOf[HTMLElementTagNameMap]
      }
      
      @scala.inline
      implicit class HTMLElementTagNameMapMutableBuilder[Self <: HTMLElementTagNameMap] (val x: Self) extends AnyVal {
        
        @scala.inline
        def `setMwc-button`(value: Button): Self = StObject.set(x, "mwc-button", value.asInstanceOf[js.Any])
      }
    }
  }
}

package typingsLaminar.mwcRipple

import typingsLaminar.litElement.mod.CSSResult
import typingsLaminar.mwcRipple.mwcRippleBaseMod.RippleBase
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("mwc-ripple", "Ripple")
  @js.native
  class Ripple () extends RippleBase
  /* static members */
  object Ripple {
    
    @JSImport("mwc-ripple", "Ripple")
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("mwc-ripple", "Ripple.styles")
    @js.native
    def styles: CSSResult = js.native
    @scala.inline
    def styles_=(x: CSSResult): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("styles")(x.asInstanceOf[js.Any])
  }
  
  object global {
    
    @js.native
    trait HTMLElementTagNameMap extends StObject {
      
      var `mwc-ripple`: Ripple = js.native
    }
    object HTMLElementTagNameMap {
      
      @scala.inline
      def apply(`mwc-ripple`: Ripple): HTMLElementTagNameMap = {
        val __obj = js.Dynamic.literal()
        __obj.updateDynamic("mwc-ripple")(`mwc-ripple`.asInstanceOf[js.Any])
        __obj.asInstanceOf[HTMLElementTagNameMap]
      }
      
      @scala.inline
      implicit class HTMLElementTagNameMapMutableBuilder[Self <: HTMLElementTagNameMap] (val x: Self) extends AnyVal {
        
        @scala.inline
        def `setMwc-ripple`(value: Ripple): Self = StObject.set(x, "mwc-ripple", value.asInstanceOf[js.Any])
      }
    }
  }
}

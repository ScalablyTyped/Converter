package typingsLaminar.mwcRipple

import org.scalajs.dom.raw.Event
import typingsLaminar.mwcBase.mod.BaseElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mwcRippleBaseMod {
  
  @JSImport("mwc-ripple/mwc-ripple-base", "RippleBase")
  @js.native
  class RippleBase ()
    extends BaseElement
       with RippleInterface {
    
    var accent: Boolean = js.native
    
    var activated: Boolean = js.native
    
    var bgFocused: Boolean = js.native
    
    var disabled: Boolean = js.native
    
    var fgActivation: Boolean = js.native
    
    var fgDeactivation: Boolean = js.native
    
    var fgScale: String = js.native
    
    var fgSize: String = js.native
    
    var hovering: Boolean = js.native
    
    def isActive: Boolean = js.native
    
    var leftPos: String = js.native
    
    var primary: Boolean = js.native
    
    var selected: Boolean = js.native
    
    var topPos: String = js.native
    
    var translateEnd: String = js.native
    
    var translateStart: String = js.native
    
    var unbounded: Boolean = js.native
  }
  
  @js.native
  trait RippleInterface extends StObject {
    
    def endFocus(): Unit = js.native
    
    def endHover(): Unit = js.native
    
    def endPress(): Unit = js.native
    
    def startFocus(): Unit = js.native
    
    def startHover(): Unit = js.native
    
    def startPress(): Unit = js.native
    def startPress(e: Event): Unit = js.native
  }
}

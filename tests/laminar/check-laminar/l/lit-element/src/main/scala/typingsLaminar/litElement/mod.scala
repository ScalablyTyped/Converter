package typingsLaminar.litElement

import org.scalajs.dom.raw.CSSStyleSheet
import typingsLaminar.std.HTMLElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("lit-element", "CSSResult")
  @js.native
  class CSSResult protected () extends StObject {
    def this(cssText: String, safeToken: js.Symbol) = this()
    
    var _styleSheet: js.UndefOr[CSSStyleSheet | Null] = js.native
    
    val cssText: String = js.native
  }
  
  @JSImport("lit-element", "LitElement")
  @js.native
  class LitElement () extends UpdatingElement
  
  @JSImport("lit-element", "UpdatingElement")
  @js.native
  abstract class UpdatingElement () extends HTMLElement
}

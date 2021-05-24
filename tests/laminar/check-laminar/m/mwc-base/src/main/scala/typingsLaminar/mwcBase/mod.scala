package typingsLaminar.mwcBase

import org.scalajs.dom.raw.HTMLElement
import typingsLaminar.litElement.mod.LitElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("mwc-base", "BaseElement")
  @js.native
  abstract class BaseElement () extends LitElement {
    
    /**
      * Root element for MDC Foundation usage.
      *
      * Define in your component with the `@query` decorator
      */
    var mdcRoot: HTMLElement = js.native
  }
}

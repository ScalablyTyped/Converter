package typingsJapgolly.semanticUiReact.components

import typingsJapgolly.semanticUiReact.distCommonjsElementsButtonButtonOrMod.ButtonOrProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ButtonOr {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonOr", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  type Props = ButtonOrProps
  
  implicit def make(companion: ButtonOr.type): SharedBuilder_ButtonOrProps_1866251671 = new SharedBuilder_ButtonOrProps_1866251671(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ButtonOrProps): SharedBuilder_ButtonOrProps_1866251671 = new SharedBuilder_ButtonOrProps_1866251671(js.Array(this.component, p.asInstanceOf[js.Any]))
}

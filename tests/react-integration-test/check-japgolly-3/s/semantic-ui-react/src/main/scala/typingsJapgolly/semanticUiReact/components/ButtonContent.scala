package typingsJapgolly.semanticUiReact.components

import _root_.typingsJapgolly.semanticUiReact.distCommonjsElementsButtonButtonContentMod.ButtonContentProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ButtonContent {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonContent", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  type Props = ButtonContentProps
  
  implicit def make(companion: ButtonContent.type): SharedBuilder_ButtonContentProps_207125023 = new SharedBuilder_ButtonContentProps_207125023(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ButtonContentProps): SharedBuilder_ButtonContentProps_207125023 = new SharedBuilder_ButtonContentProps_207125023(js.Array(this.component, p.asInstanceOf[js.Any]))
}

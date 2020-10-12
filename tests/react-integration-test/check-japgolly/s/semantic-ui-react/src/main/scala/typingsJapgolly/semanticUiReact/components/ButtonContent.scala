package typingsJapgolly.semanticUiReact.components

import typingsJapgolly.semanticUiReact.buttonContentMod.ButtonContentProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ButtonContent {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonContent", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  def withProps(p: ButtonContentProps): SharedBuilder_ButtonContentProps1680783343 = new SharedBuilder_ButtonContentProps1680783343(js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: ButtonContent.type): SharedBuilder_ButtonContentProps1680783343 = new SharedBuilder_ButtonContentProps1680783343(js.Array(this.component, js.Dictionary.empty))()
}

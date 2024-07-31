package typingsSlinky.semanticUiReact.components

import _root_.typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonGroupMod.ButtonGroupProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ButtonGroup {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonGroup", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  type Props = ButtonGroupProps
  
  implicit def make(companion: ButtonGroup.type): SharedBuilder_ButtonGroupProps1675589688 = new SharedBuilder_ButtonGroupProps1675589688(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ButtonGroupProps): SharedBuilder_ButtonGroupProps1675589688 = new SharedBuilder_ButtonGroupProps1675589688(js.Array(this.component, p.asInstanceOf[js.Any]))
}

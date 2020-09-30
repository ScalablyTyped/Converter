package typingsJapgolly.semanticUiReact.components

import typingsJapgolly.semanticUiReact.buttonGroupMod.ButtonGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ButtonGroup {
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonGroup", JSImport.Default)
  @js.native
  object component extends js.Object
  
  def withProps(p: ButtonGroupProps): SharedBuilder_ButtonGroupProps_158814638 = new SharedBuilder_ButtonGroupProps_158814638(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: ButtonGroup.type): SharedBuilder_ButtonGroupProps_158814638 = new SharedBuilder_ButtonGroupProps_158814638(js.Array(this.component, js.Dictionary.empty))()
}


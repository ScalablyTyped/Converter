package typingsSlinky.semanticUiReact.components

import typingsSlinky.semanticUiReact.buttonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ButtonOr {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonOr", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  def withProps(p: ButtonOrProps): SharedBuilder_ButtonOrProps934189058 = new SharedBuilder_ButtonOrProps934189058(js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: ButtonOr.type): SharedBuilder_ButtonOrProps934189058 = new SharedBuilder_ButtonOrProps934189058(js.Array(this.component, js.Dictionary.empty))()
}

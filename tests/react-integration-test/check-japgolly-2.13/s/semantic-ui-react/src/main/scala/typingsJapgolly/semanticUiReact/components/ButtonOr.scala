package typingsJapgolly.semanticUiReact.components

import typingsJapgolly.semanticUiReact.buttonOrMod.ButtonOrProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ButtonOr {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonOr", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: ButtonOr.type): SharedBuilder_ButtonOrProps_184214248 = new SharedBuilder_ButtonOrProps_184214248(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ButtonOrProps): SharedBuilder_ButtonOrProps_184214248 = new SharedBuilder_ButtonOrProps_184214248(js.Array(this.component, p.asInstanceOf[js.Any]))
}

package typingsSlinky.semanticUiReact.components

import typingsSlinky.semanticUiReact.buttonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ButtonOr {
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonOr", JSImport.Default)
  @js.native
  object component extends js.Object
  
  def withProps(p: ButtonOrProps): SharedBuilder_ButtonOrProps934189058 = new SharedBuilder_ButtonOrProps934189058(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: ButtonOr.type): SharedBuilder_ButtonOrProps934189058 = new SharedBuilder_ButtonOrProps934189058(js.Array(this.component, js.Dictionary.empty))()
}


package typingsSlinky.semanticUiReact.components

import typingsSlinky.semanticUiReact.buttonContentMod.ButtonContentProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ButtonContent {
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/ButtonContent", JSImport.Default)
  @js.native
  object component extends js.Object
  
  def withProps(p: ButtonContentProps): SharedBuilder_ButtonContentProps_2074188261 = new SharedBuilder_ButtonContentProps_2074188261(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: ButtonContent.type): SharedBuilder_ButtonContentProps_2074188261 = new SharedBuilder_ButtonContentProps_2074188261(js.Array(this.component, js.Dictionary.empty))()
}


package typingsSlinky.semanticUiReact.components

import typingsSlinky.semanticUiReact.accordionContentMod.AccordionContentProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionContent {
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionContent", JSImport.Default)
  @js.native
  object component extends js.Object
  
  def withProps(p: AccordionContentProps): SharedBuilder_AccordionContentProps_1656243680 = new SharedBuilder_AccordionContentProps_1656243680(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: AccordionContent.type): SharedBuilder_AccordionContentProps_1656243680 = new SharedBuilder_AccordionContentProps_1656243680(js.Array(this.component, js.Dictionary.empty))()
}


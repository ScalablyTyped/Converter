package typingsSlinky.semanticUiReact.components

import typingsSlinky.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsSlinky.semanticUiReact.accordionAccordionAccordionMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionAccordion {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionAccordion", JSImport.Default)
  @js.native
  object component extends js.Object
  
  def withProps(p: AccordionAccordionProps): SharedBuilder_AccordionAccordionProps_1044969128[default] = new SharedBuilder_AccordionAccordionProps_1044969128[default](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: AccordionAccordion.type): SharedBuilder_AccordionAccordionProps_1044969128[default] = new SharedBuilder_AccordionAccordionProps_1044969128[default](js.Array(this.component, js.Dictionary.empty))()
}

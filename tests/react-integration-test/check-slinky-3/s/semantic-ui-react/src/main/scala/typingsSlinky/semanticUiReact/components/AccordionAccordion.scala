package typingsSlinky.semanticUiReact.components

import _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionAccordionMod.AccordionAccordionProps
import _root_.typingsSlinky.semanticUiReact.distCommonjsModulesAccordionAccordionAccordionMod.default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionAccordion {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionAccordion", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  type Props = AccordionAccordionProps
  
  implicit def make(companion: AccordionAccordion.type): SharedBuilder_AccordionAccordionProps_2090513651[default] = new SharedBuilder_AccordionAccordionProps_2090513651[default](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionAccordionProps): SharedBuilder_AccordionAccordionProps_2090513651[default] = new SharedBuilder_AccordionAccordionProps_2090513651[default](js.Array(this.component, p.asInstanceOf[js.Any]))
}

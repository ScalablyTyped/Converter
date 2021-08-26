package typingsJapgolly.semanticUiReact.components

import typingsJapgolly.semanticUiReact.accordionAccordionAccordionMod.AccordionAccordionProps
import typingsJapgolly.semanticUiReact.accordionAccordionAccordionMod.default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionAccordion {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionAccordion", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: AccordionAccordion.type): SharedBuilder_AccordionAccordionProps1188692388[default] = new SharedBuilder_AccordionAccordionProps1188692388[default](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionAccordionProps): SharedBuilder_AccordionAccordionProps1188692388[default] = new SharedBuilder_AccordionAccordionProps1188692388[default](js.Array(this.component, p.asInstanceOf[js.Any]))
}

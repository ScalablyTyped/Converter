package typingsJapgolly.react.components

import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionAccordionMod.AccordionAccordionProps
import typingsJapgolly.react.semanticUiReactDistCommonjsModulesAccordionAccordionAccordionMod.default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionAccordion {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion/AccordionAccordion", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  type Props = AccordionAccordionProps
  
  implicit def make(companion: AccordionAccordion.type): SharedBuilder_AccordionAccordionProps1579944095[default] = new SharedBuilder_AccordionAccordionProps1579944095[default](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionAccordionProps): SharedBuilder_AccordionAccordionProps1579944095[default] = new SharedBuilder_AccordionAccordionProps1579944095[default](js.Array(this.component, p.asInstanceOf[js.Any]))
}

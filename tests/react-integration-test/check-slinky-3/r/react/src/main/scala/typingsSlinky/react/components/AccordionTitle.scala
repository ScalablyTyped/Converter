package typingsSlinky.react.components

import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionTitleMod.default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionTitle {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion/AccordionTitle", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  type Props = AccordionTitleProps
  
  implicit def make(companion: AccordionTitle.type): SharedBuilder_AccordionTitleProps3915295[default] = new SharedBuilder_AccordionTitleProps3915295[default](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionTitleProps): SharedBuilder_AccordionTitleProps3915295[default] = new SharedBuilder_AccordionTitleProps3915295[default](js.Array(this.component, p.asInstanceOf[js.Any]))
}

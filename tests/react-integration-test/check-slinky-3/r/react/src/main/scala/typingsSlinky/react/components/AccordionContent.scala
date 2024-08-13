package typingsSlinky.react.components

import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionContentMod.AccordionContentProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionContent {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion/AccordionContent", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  type Props = AccordionContentProps
  
  implicit def make(companion: AccordionContent.type): SharedBuilder_AccordionContentProps_1433290124 = new SharedBuilder_AccordionContentProps_1433290124(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionContentProps): SharedBuilder_AccordionContentProps_1433290124 = new SharedBuilder_AccordionContentProps_1433290124(js.Array(this.component, p.asInstanceOf[js.Any]))
}

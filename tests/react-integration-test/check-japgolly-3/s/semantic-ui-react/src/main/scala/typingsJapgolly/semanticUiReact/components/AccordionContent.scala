package typingsJapgolly.semanticUiReact.components

import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionContentMod.AccordionContentProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionContent {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionContent", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  type Props = AccordionContentProps
  
  implicit def make(companion: AccordionContent.type): SharedBuilder_AccordionContentProps1671366922 = new SharedBuilder_AccordionContentProps1671366922(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionContentProps): SharedBuilder_AccordionContentProps1671366922 = new SharedBuilder_AccordionContentProps1671366922(js.Array(this.component, p.asInstanceOf[js.Any]))
}

package typingsSlinky.semanticUiReact.components

import typingsSlinky.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsSlinky.semanticUiReact.accordionTitleMod.default
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object AccordionTitle {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionTitle", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: AccordionTitle.type): SharedBuilder_AccordionTitleProps1986434512[default] = new SharedBuilder_AccordionTitleProps1986434512[default](js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: AccordionTitleProps): SharedBuilder_AccordionTitleProps1986434512[default] = new SharedBuilder_AccordionTitleProps1986434512[default](js.Array(this.component, p.asInstanceOf[js.Any]))
}

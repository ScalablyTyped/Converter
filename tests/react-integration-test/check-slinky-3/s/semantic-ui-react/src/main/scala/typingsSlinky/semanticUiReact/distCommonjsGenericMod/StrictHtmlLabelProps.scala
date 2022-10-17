package typingsSlinky.semanticUiReact.distCommonjsGenericMod

import slinky.core.facade.ReactElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait StrictHtmlLabelProps extends StObject {
  
  var children: js.UndefOr[ReactElement] = js.undefined
}
object StrictHtmlLabelProps {
  
  inline def apply(): StrictHtmlLabelProps = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StrictHtmlLabelProps]
  }
  
  extension [Self <: StrictHtmlLabelProps](x: Self) {
    
    inline def setChildren(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
    
    inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
  }
}

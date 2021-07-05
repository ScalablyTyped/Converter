package typingsSlinky.semanticUiReact.genericMod

import slinky.core.facade.ReactElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait StrictHtmlSpanProps extends StObject {
  
  var children: js.UndefOr[ReactElement] = js.native
}
object StrictHtmlSpanProps {
  
  @scala.inline
  def apply(): StrictHtmlSpanProps = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StrictHtmlSpanProps]
  }
  
  @scala.inline
  implicit class StrictHtmlSpanPropsMutableBuilder[Self <: StrictHtmlSpanProps] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setChildren(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
  }
}

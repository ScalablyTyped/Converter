package typingsSlinky.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait ReactPortal
  extends StObject
     with ReactElement {
  
  var children: slinky.core.facade.ReactElement
}
object ReactPortal {
  
  inline def apply(children: slinky.core.facade.ReactElement, props: Any, `type`: Any): ReactPortal = {
    val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any], props = props.asInstanceOf[js.Any], key = null)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactPortal]
  }
  
  extension [Self <: ReactPortal](x: Self) {
    
    inline def setChildren(value: slinky.core.facade.ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
  }
}

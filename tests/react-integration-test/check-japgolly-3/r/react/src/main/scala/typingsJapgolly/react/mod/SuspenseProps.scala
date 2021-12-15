package typingsJapgolly.react.mod

import japgolly.scalajs.react.facade.Empty
import japgolly.scalajs.react.facade.JsNumber
import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait SuspenseProps extends StObject {
  
  var children: js.UndefOr[Node] = js.undefined
  
  /** A fallback react tree to show when a Suspense child (like React.lazy) suspends */
  var fallback: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any) | Null
}
object SuspenseProps {
  
  inline def apply(): SuspenseProps = {
    val __obj = js.Dynamic.literal(fallback = null)
    __obj.asInstanceOf[SuspenseProps]
  }
  
  extension [Self <: SuspenseProps](x: Self) {
    
    inline def setChildren(value: VdomNode): Self = StObject.set(x, "children", value.rawNode.asInstanceOf[js.Any])
    
    inline def setChildrenNull: Self = StObject.set(x, "children", null)
    
    inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    
    inline def setChildrenVarargs(value: (Empty | String | JsNumber | Element)*): Self = StObject.set(x, "children", js.Array(value*))
    
    inline def setChildrenVdomElement(value: VdomElement): Self = StObject.set(x, "children", value.rawElement.asInstanceOf[js.Any])
    
    inline def setFallback(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any
    ): Self = StObject.set(x, "fallback", value.asInstanceOf[js.Any])
    
    inline def setFallbackNull: Self = StObject.set(x, "fallback", null)
  }
}

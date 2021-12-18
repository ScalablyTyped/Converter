package typingsSlinky.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait SuspenseProps extends StObject {
  
  var children: js.UndefOr[slinky.core.facade.ReactElement] = js.undefined
  
  /** A fallback react tree to show when a Suspense child (like React.lazy) suspends */
  var fallback: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ Any) | Null
}
object SuspenseProps {
  
  inline def apply(): SuspenseProps = {
    val __obj = js.Dynamic.literal(fallback = null)
    __obj.asInstanceOf[SuspenseProps]
  }
  
  extension [Self <: SuspenseProps](x: Self) {
    
    inline def setChildren(value: slinky.core.facade.ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
    
    inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    
    inline def setFallback(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ Any
    ): Self = StObject.set(x, "fallback", value.asInstanceOf[js.Any])
    
    inline def setFallbackNull: Self = StObject.set(x, "fallback", null)
  }
}

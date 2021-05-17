package typingsSlinky.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait SuspenseProps extends StObject {
  
  var children: js.UndefOr[slinky.core.facade.ReactElement] = js.native
  
  /** A fallback react tree to show when a Suspense child (like React.lazy) suspends */
  var fallback: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any) | Null = js.native
}
object SuspenseProps {
  
  @scala.inline
  def apply(): SuspenseProps = {
    val __obj = js.Dynamic.literal(fallback = null)
    __obj.asInstanceOf[SuspenseProps]
  }
  
  @scala.inline
  implicit class SuspensePropsMutableBuilder[Self <: SuspenseProps] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setChildren(value: slinky.core.facade.ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    
    @scala.inline
    def setFallback(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any
    ): Self = StObject.set(x, "fallback", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFallbackNull: Self = StObject.set(x, "fallback", null)
  }
}

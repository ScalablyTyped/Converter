package typingsSlinky.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

// Context via RenderProps
trait ProviderProps[T] extends StObject {
  
  var children: js.UndefOr[slinky.core.facade.ReactElement] = js.undefined
  
  var value: T
}
object ProviderProps {
  
  inline def apply[T](value: T): ProviderProps[T] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[ProviderProps[T]]
  }
  
  extension [Self <: ProviderProps[?], T](x: Self & ProviderProps[T]) {
    
    inline def setChildren(value: slinky.core.facade.ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
    
    inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    
    inline def setValue(value: T): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}

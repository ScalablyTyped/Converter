package typingsSlinky.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait ConsumerProps[T] extends StObject {
  
  def children(value: T): slinky.core.facade.ReactElement
  
  var unstable_observedBits: js.UndefOr[Double] = js.undefined
}
object ConsumerProps {
  
  inline def apply[T](children: T => slinky.core.facade.ReactElement): ConsumerProps[T] = {
    val __obj = js.Dynamic.literal(children = js.Any.fromFunction1(children))
    __obj.asInstanceOf[ConsumerProps[T]]
  }
  
  extension [Self <: ConsumerProps[?], T](x: Self & ConsumerProps[T]) {
    
    inline def setChildren(value: T => slinky.core.facade.ReactElement): Self = StObject.set(x, "children", js.Any.fromFunction1(value))
    
    inline def setUnstable_observedBits(value: Double): Self = StObject.set(x, "unstable_observedBits", value.asInstanceOf[js.Any])
    
    inline def setUnstable_observedBitsUndefined: Self = StObject.set(x, "unstable_observedBits", js.undefined)
  }
}

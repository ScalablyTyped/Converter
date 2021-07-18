package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait ClassAttributes[T]
  extends StObject
     with Attributes {
  
  var ref: js.UndefOr[LegacyRef[T]] = js.undefined
}
object ClassAttributes {
  
  inline def apply[T](): ClassAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ClassAttributes[T]]
  }
  
  extension [Self <: ClassAttributes[?], T](x: Self & ClassAttributes[T]) {
    
    inline def setRef(value: LegacyRef[T]): Self = StObject.set(x, "ref", value.asInstanceOf[js.Any])
    
    inline def setRefFunction1(value: /* instance */ T | Null => Callback): Self = StObject.set(x, "ref", js.Any.fromFunction1((t0: /* instance */ T | Null) => value(t0).runNow()))
    
    inline def setRefNull: Self = StObject.set(x, "ref", null)
    
    inline def setRefUndefined: Self = StObject.set(x, "ref", js.undefined)
  }
}

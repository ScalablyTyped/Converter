package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Child[T1, T2]
  extends StObject
     with Parent[T1] {
  
  var t2: js.UndefOr[T2] = js.undefined
}
object Child {
  
  inline def apply[T1, T2](t: T1): Child[T1, T2] = {
    val __obj = js.Dynamic.literal(t = t.asInstanceOf[js.Any])
    __obj.asInstanceOf[Child[T1, T2]]
  }
  
  extension [Self <: Child[?, ?], T1, T2](x: Self & (Child[T1, T2])) {
    
    inline def setT2(value: T2): Self = StObject.set(x, "t2", value.asInstanceOf[js.Any])
    
    inline def setT2Undefined: Self = StObject.set(x, "t2", js.undefined)
  }
}

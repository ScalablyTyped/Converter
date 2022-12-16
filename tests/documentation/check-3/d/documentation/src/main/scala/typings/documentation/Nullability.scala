package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Nullability extends StObject {
  
  var a: Double
  
  var b: js.UndefOr[Double] = js.undefined
  
  var c: Double | Null
  
  var d: js.UndefOr[Double | Null] = js.undefined
}
object Nullability {
  
  inline def apply(a: Double): Nullability = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], c = null)
    __obj.asInstanceOf[Nullability]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: Nullability] (val x: Self) extends AnyVal {
    
    inline def setA(value: Double): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
    
    inline def setB(value: Double): Self = StObject.set(x, "b", value.asInstanceOf[js.Any])
    
    inline def setBUndefined: Self = StObject.set(x, "b", js.undefined)
    
    inline def setC(value: Double): Self = StObject.set(x, "c", value.asInstanceOf[js.Any])
    
    inline def setCNull: Self = StObject.set(x, "c", null)
    
    inline def setD(value: Double): Self = StObject.set(x, "d", value.asInstanceOf[js.Any])
    
    inline def setDNull: Self = StObject.set(x, "d", null)
    
    inline def setDUndefined: Self = StObject.set(x, "d", js.undefined)
  }
}

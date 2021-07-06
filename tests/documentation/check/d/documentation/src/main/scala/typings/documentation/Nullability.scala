package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Nullability extends StObject {
  
  var a: Double = js.native
  
  var b: js.UndefOr[Double] = js.native
  
  var c: Double | Null = js.native
  
  var d: js.UndefOr[Double | Null] = js.native
}
object Nullability {
  
  @scala.inline
  def apply(a: Double): Nullability = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], c = null)
    __obj.asInstanceOf[Nullability]
  }
  
  @scala.inline
  implicit class NullabilityMutableBuilder[Self <: Nullability] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setA(value: Double): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setB(value: Double): Self = StObject.set(x, "b", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setBUndefined: Self = StObject.set(x, "b", js.undefined)
    
    @scala.inline
    def setC(value: Double): Self = StObject.set(x, "c", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setCNull: Self = StObject.set(x, "c", null)
    
    @scala.inline
    def setD(value: Double): Self = StObject.set(x, "d", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setDNull: Self = StObject.set(x, "d", null)
    
    @scala.inline
    def setDUndefined: Self = StObject.set(x, "d", js.undefined)
  }
}

package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Branch[T] extends StObject {
  
  var left: T
  
  var right: T
  
  var `type`: /* scala3 limitation: Should be type 'Branch' */ java.lang.String
}
object Branch {
  
  inline def apply[T](left: T, right: T): Branch[T] = {
    val __obj = js.Dynamic.literal(left = left.asInstanceOf[js.Any], right = right.asInstanceOf[js.Any])
    __obj.updateDynamic("type")("Branch")
    __obj.asInstanceOf[Branch[T]]
  }
  
  extension [Self <: Branch[?], T](x: Self & Branch[T]) {
    
    inline def setLeft(value: T): Self = StObject.set(x, "left", value.asInstanceOf[js.Any])
    
    inline def setRight(value: T): Self = StObject.set(x, "right", value.asInstanceOf[js.Any])
    
    inline def setType(value: "Branch"): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}

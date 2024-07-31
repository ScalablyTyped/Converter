package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Branch[T] extends StObject {
  
  var left: T
  
  var right: T
  
  var `type`: _root_.typings.documentation.documentationStrings.Branch
}
object Branch {
  
  inline def apply[T](left: T, right: T): Branch[T] = {
    val __obj = js.Dynamic.literal(left = left.asInstanceOf[js.Any], right = right.asInstanceOf[js.Any])
    __obj.updateDynamic("type")("Branch")
    __obj.asInstanceOf[Branch[T]]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: Branch[?], T] (val x: Self & Branch[T]) extends AnyVal {
    
    inline def setLeft(value: T): Self = StObject.set(x, "left", value.asInstanceOf[js.Any])
    
    inline def setRight(value: T): Self = StObject.set(x, "right", value.asInstanceOf[js.Any])
    
    inline def setType(value: _root_.typings.documentation.documentationStrings.Branch): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}

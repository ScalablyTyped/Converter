package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Leaf[T]
  extends StObject
     with Tree[T] {
  
  var `type`: typings.documentation.documentationStrings.Leaf
  
  var value: T
}
object Leaf {
  
  inline def apply[T](value: T): Leaf[T] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.updateDynamic("type")("Leaf")
    __obj.asInstanceOf[Leaf[T]]
  }
  
  extension [Self <: Leaf[?], T](x: Self & Leaf[T]) {
    
    inline def setType(value: typings.documentation.documentationStrings.Leaf): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    
    inline def setValue(value: T): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}

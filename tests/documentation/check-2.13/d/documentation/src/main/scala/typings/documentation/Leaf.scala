package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Leaf[T]
  extends StObject
     with Tree[T] {
  
  var `type`: typings.documentation.documentationStrings.Leaf = js.native
  
  var value: T = js.native
}
object Leaf {
  
  @scala.inline
  def apply[T](value: T): Leaf[T] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.updateDynamic("type")("Leaf")
    __obj.asInstanceOf[Leaf[T]]
  }
  
  @scala.inline
  implicit class LeafMutableBuilder[Self <: Leaf[_], T] (val x: Self with Leaf[T]) extends AnyVal {
    
    @scala.inline
    def setType(value: typings.documentation.documentationStrings.Leaf): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setValue(value: T): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}

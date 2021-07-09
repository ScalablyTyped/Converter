package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Branch[T]
  extends StObject
     with Tree[T] {
  
  var left: T = js.native
  
  var right: T = js.native
  
  var `type`: typings.documentation.documentationStrings.Branch = js.native
}
object Branch {
  
  @scala.inline
  def apply[T](left: T, right: T): Branch[T] = {
    val __obj = js.Dynamic.literal(left = left.asInstanceOf[js.Any], right = right.asInstanceOf[js.Any])
    __obj.updateDynamic("type")("Branch")
    __obj.asInstanceOf[Branch[T]]
  }
  
  @scala.inline
  implicit class BranchMutableBuilder[Self <: Branch[_], T] (val x: Self with Branch[T]) extends AnyVal {
    
    @scala.inline
    def setLeft(value: T): Self = StObject.set(x, "left", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setRight(value: T): Self = StObject.set(x, "right", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setType(value: typings.documentation.documentationStrings.Branch): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}

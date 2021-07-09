package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Parent[T] extends StObject {
  
  var t: T = js.native
}
object Parent {
  
  @scala.inline
  def apply[T](t: T): Parent[T] = {
    val __obj = js.Dynamic.literal(t = t.asInstanceOf[js.Any])
    __obj.asInstanceOf[Parent[T]]
  }
  
  @scala.inline
  implicit class ParentMutableBuilder[Self <: Parent[_], T] (val x: Self with Parent[T]) extends AnyVal {
    
    @scala.inline
    def setT(value: T): Self = StObject.set(x, "t", value.asInstanceOf[js.Any])
  }
}

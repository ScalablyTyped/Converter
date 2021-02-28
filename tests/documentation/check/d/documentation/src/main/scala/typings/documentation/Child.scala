package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Child[T1, T2] extends Parent[T1] {
  
  var t2: js.UndefOr[T2] = js.native
}
object Child {
  
  @scala.inline
  def apply[T1, T2](t: T1): Child[T1, T2] = {
    val __obj = js.Dynamic.literal(t = t.asInstanceOf[js.Any])
    __obj.asInstanceOf[Child[T1, T2]]
  }
  
  @scala.inline
  implicit class ChildMutableBuilder[Self <: Child[_, _], T1, T2] (val x: Self with (Child[T1, T2])) extends AnyVal {
    
    @scala.inline
    def setT2(value: T2): Self = StObject.set(x, "t2", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setT2Undefined: Self = StObject.set(x, "t2", js.undefined)
  }
}

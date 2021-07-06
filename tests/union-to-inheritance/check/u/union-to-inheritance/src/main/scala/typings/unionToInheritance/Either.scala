package typings.unionToInheritance

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Either[L, R]
  extends StObject
     with Legal3[js.Any, L, R]
     with _Test[js.Any, L, R]
     with _Test2[R, L] {
  
  var value: R = js.native
}
object Either {
  
  @scala.inline
  def apply[L, R](value: R): Either[L, R] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[Either[L, R]]
  }
  
  @scala.inline
  implicit class EitherMutableBuilder[Self <: Either[?, ?], L, R] (val x: Self & (Either[L, R])) extends AnyVal {
    
    @scala.inline
    def setValue(value: R): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}

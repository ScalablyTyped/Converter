package typings.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* let's pretend */
@js.native
trait TwoFoo[Foo1, Foo2] extends StObject {
  
  var value: Foo1 = js.native
}
object TwoFoo {
  
  @scala.inline
  def apply[Foo1, Foo2](value: Foo1): TwoFoo[Foo1, Foo2] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[TwoFoo[Foo1, Foo2]]
  }
  
  @scala.inline
  implicit class TwoFooMutableBuilder[Self <: TwoFoo[?, ?], Foo1, Foo2] (val x: Self & (TwoFoo[Foo1, Foo2])) extends AnyVal {
    
    @scala.inline
    def setValue(value: Foo1): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}

package typings.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* let's pretend */
trait TwoFoo[Foo1, Foo2] extends StObject {
  
  var value: Foo1
}
object TwoFoo {
  
  inline def apply[Foo1, Foo2](value: Foo1): TwoFoo[Foo1, Foo2] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[TwoFoo[Foo1, Foo2]]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: TwoFoo[?, ?], Foo1, Foo2] (val x: Self & (TwoFoo[Foo1, Foo2])) extends AnyVal {
    
    inline def setValue(value: Foo1): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}

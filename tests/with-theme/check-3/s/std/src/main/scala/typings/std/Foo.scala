package typings.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Foo extends StObject {
  
  var f: js.UndefOr[js.Function1[/* n */ Double, String]] = js.undefined
}
object Foo {
  
  inline def apply(): Foo = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[Foo]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: Foo] (val x: Self) extends AnyVal {
    
    inline def setF(value: /* n */ Double => String): Self = StObject.set(x, "f", js.Any.fromFunction1(value))
    
    inline def setFUndefined: Self = StObject.set(x, "f", js.undefined)
  }
}

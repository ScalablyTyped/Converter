package typings.keyof

import _root_.typings.keyof.keyofStrings.a
import _root_.typings.keyof.keyofStrings.b
import _root_.typings.keyof.keyofStrings.c
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait B extends StObject {
  
  def foo(p: a | b | c): String
  
  def foo2[T](p: /* keyof T */ String): String
}
object B {
  
  inline def apply(foo: a | b | c => String, foo2: /* keyof T */ String => String): B = {
    val __obj = js.Dynamic.literal(foo = js.Any.fromFunction1(foo), foo2 = js.Any.fromFunction1(foo2))
    __obj.asInstanceOf[B]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: B] (val x: Self) extends AnyVal {
    
    inline def setFoo(value: a | b | c => String): Self = StObject.set(x, "foo", js.Any.fromFunction1(value))
    
    inline def setFoo2(value: /* keyof T */ String => String): Self = StObject.set(x, "foo2", js.Any.fromFunction1(value))
  }
}

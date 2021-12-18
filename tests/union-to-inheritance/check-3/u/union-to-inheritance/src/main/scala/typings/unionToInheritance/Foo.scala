package typings.unionToInheritance

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Foo[U]
  extends StObject
     with Legal1[U]
     with Legal2[U, Any]
     with Legal3[Any, Any, U] {
  
  var value: U
}
object Foo {
  
  inline def apply[U](value: U): Foo[U] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[Foo[U]]
  }
  
  extension [Self <: Foo[?], U](x: Self & Foo[U]) {
    
    inline def setValue(value: U): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}

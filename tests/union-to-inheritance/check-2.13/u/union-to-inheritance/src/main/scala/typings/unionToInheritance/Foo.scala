package typings.unionToInheritance

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Foo[U]
  extends StObject
     with Legal1[U]
     with Legal2[U, js.Any]
     with Legal3[js.Any, js.Any, U] {
  
  var value: U = js.native
}
object Foo {
  
  @scala.inline
  def apply[U](value: U): Foo[U] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.asInstanceOf[Foo[U]]
  }
  
  @scala.inline
  implicit class FooMutableBuilder[Self <: Foo[_], U] (val x: Self with Foo[U]) extends AnyVal {
    
    @scala.inline
    def setValue(value: U): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
  }
}

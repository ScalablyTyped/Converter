package typings.unionToInheritance

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Foo2[U, V]
  extends StObject
     with Legal2[V, U]
     with Legal3[U, js.Any, V]
     with _Test[U, js.Any, V] {
  
  var u: U = js.native
  
  var v: V = js.native
}
object Foo2 {
  
  @scala.inline
  def apply[U, V](u: U, v: V): Foo2[U, V] = {
    val __obj = js.Dynamic.literal(u = u.asInstanceOf[js.Any], v = v.asInstanceOf[js.Any])
    __obj.asInstanceOf[Foo2[U, V]]
  }
  
  @scala.inline
  implicit class Foo2MutableBuilder[Self <: Foo2[_, _], U, V] (val x: Self with (Foo2[U, V])) extends AnyVal {
    
    @scala.inline
    def setU(value: U): Self = StObject.set(x, "u", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setV(value: V): Self = StObject.set(x, "v", value.asInstanceOf[js.Any])
  }
}

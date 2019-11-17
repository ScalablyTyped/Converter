package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Foo2[U, V]
  extends Legal2[V, U]
     with Legal3[U, js.Any, V]
     with _Test[U, js.Any, V] {
  var u: U
  var v: V
}

object Foo2 {
  @scala.inline
  def apply[U, V](u: U, v: V): Foo2[U, V] = {
    val __obj = js.Dynamic.literal(u = u.asInstanceOf[js.Any], v = v.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Foo2[U, V]]
  }
}


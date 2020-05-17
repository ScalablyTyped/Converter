package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Foo2[U, V]
  extends Legal2[V, U]
     with Legal3[U, js.Any, V]
     with Test[U, js.Any, V] {
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
  implicit class Foo2Ops[Self <: Foo2[_, _], U, V] (val x: Self with (Foo2[U, V])) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setU(value: U): Self = this.set("u", value.asInstanceOf[js.Any])
    @scala.inline
    def setV(value: V): Self = this.set("v", value.asInstanceOf[js.Any])
  }
  
}


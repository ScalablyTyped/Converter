package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Foo2[U, V]
  extends Legal2[V, U]
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
  implicit class Foo2Ops[Self[u, v] <: Foo2[u, v], U, V] (val x: Self[U, V]) extends AnyVal {
    @scala.inline
    def duplicate: Self[U, V] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[U, V]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[U, V]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[U, V]) with Other]
    @scala.inline
    def withU(u: U): Self[U, V] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("u")(u.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[U, V]]
    }
    @scala.inline
    def withV(v: V): Self[U, V] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("v")(v.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[U, V]]
    }
  }
  
}


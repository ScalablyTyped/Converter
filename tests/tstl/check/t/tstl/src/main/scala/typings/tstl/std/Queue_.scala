package typings.tstl.std

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Queue_[T] extends js.Object {
  var container_ : js.Any = js.native
  def empty(): Boolean = js.native
}

object Queue_ {
  @scala.inline
  def apply[T](container_ : js.Any, empty: () => Boolean): Queue_[T] = {
    val __obj = js.Dynamic.literal(container_ = container_.asInstanceOf[js.Any], empty = js.Any.fromFunction0(empty))
    __obj.asInstanceOf[Queue_[T]]
  }
  @scala.inline
  implicit class Queue_Ops[Self <: Queue_[_], T] (val x: Self with Queue_[T]) extends AnyVal {
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
    def setContainer_(value: js.Any): Self = this.set("container_", value.asInstanceOf[js.Any])
    @scala.inline
    def setEmpty(value: () => Boolean): Self = this.set("empty", js.Any.fromFunction0(value))
  }
  
}


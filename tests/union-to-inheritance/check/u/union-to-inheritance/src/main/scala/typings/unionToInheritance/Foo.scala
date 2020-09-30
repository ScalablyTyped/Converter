package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Foo[U]
  extends Legal1[U]
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
  implicit class FooOps[Self <: Foo[_], U] (val x: Self with Foo[U]) extends AnyVal {
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
    def setValue(value: U): Self = this.set("value", value.asInstanceOf[js.Any])
  }
  
}


package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Pick<{  name :string,   age :number}, 'age'> */
@js.native
trait V extends js.Object {
  var age: scala.Double = js.native
}

object V {
  @scala.inline
  def apply(age: scala.Double): V = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any])
    __obj.asInstanceOf[V]
  }
  @scala.inline
  implicit class VOps[Self <: V] (val x: Self) extends AnyVal {
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
    def setAge(value: scala.Double): Self = this.set("age", value.asInstanceOf[js.Any])
  }
  
}


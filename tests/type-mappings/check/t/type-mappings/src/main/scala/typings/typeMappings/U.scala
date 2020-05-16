package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Pick<{  name  :string,   age  :number}, 'name' | 'age'> */
@js.native
trait U extends js.Object {
  var age: scala.Double = js.native
  var name: String = js.native
}

object U {
  @scala.inline
  def apply(age: scala.Double, name: String): U = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[U]
  }
  @scala.inline
  implicit class UOps[Self <: U] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAge(age: scala.Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("age")(age.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withName(name: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("name")(name.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}


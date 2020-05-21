package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Partial<type-mappings.Person> */
@js.native
trait PartialPerson extends js.Object {
  var age: js.UndefOr[scala.Double] = js.native
  var name: js.UndefOr[String] = js.native
}

object PartialPerson {
  @scala.inline
  def apply(age: Int | scala.Double = null, name: String = null): PartialPerson = {
    val __obj = js.Dynamic.literal()
    if (age != null) __obj.updateDynamic("age")(age.asInstanceOf[js.Any])
    if (name != null) __obj.updateDynamic("name")(name.asInstanceOf[js.Any])
    __obj.asInstanceOf[PartialPerson]
  }
  @scala.inline
  implicit class PartialPersonOps[Self <: PartialPerson] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAge(age: Int | scala.Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (age != null) ret.updateDynamic("age")(age.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAge: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "age")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withName(name: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (name != null) ret.updateDynamic("name")(name.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutName: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "name")
        ret.asInstanceOf[Self]
    }
  }
  
}


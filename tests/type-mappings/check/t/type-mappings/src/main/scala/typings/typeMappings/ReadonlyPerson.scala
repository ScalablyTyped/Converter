package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Readonly<type-mappings.Person> */
@js.native
trait ReadonlyPerson extends js.Object {
  val age: js.UndefOr[scala.Double] = js.native
  val name: String = js.native
}

object ReadonlyPerson {
  @scala.inline
  def apply(name: String, age: Int | scala.Double = null): ReadonlyPerson = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    if (age != null) __obj.updateDynamic("age")(age.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReadonlyPerson]
  }
  @scala.inline
  implicit class ReadonlyPersonOps[Self <: ReadonlyPerson] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withName(name: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("name")(name.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
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
  }
  
}


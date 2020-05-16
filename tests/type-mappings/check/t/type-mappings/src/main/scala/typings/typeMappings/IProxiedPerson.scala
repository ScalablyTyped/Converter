package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined parent type-mappings.Proxify<type-mappings.Person> */
@js.native
trait IProxiedPerson extends js.Object {
  var age: AnonGet = js.native
  var name: AnonSet = js.native
}

object IProxiedPerson {
  @scala.inline
  def apply(age: AnonGet, name: AnonSet): IProxiedPerson = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[IProxiedPerson]
  }
  @scala.inline
  implicit class IProxiedPersonOps[Self <: IProxiedPerson] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAge(age: AnonGet): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("age")(age.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withName(name: AnonSet): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("name")(name.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}


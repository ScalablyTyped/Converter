package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Partial<type-mappings.Person> */
@js.native
trait PartialPerson extends js.Object {
  var age: js.UndefOr[Double] = js.native
  var name: js.UndefOr[String] = js.native
}

object PartialPerson {
  @scala.inline
  def apply(age: Int | Double = null, name: String = null): PartialPerson = {
    val __obj = js.Dynamic.literal()
    if (age != null) __obj.updateDynamic("age")(age.asInstanceOf[js.Any])
    if (name != null) __obj.updateDynamic("name")(name.asInstanceOf[js.Any])
    __obj.asInstanceOf[PartialPerson]
  }
}


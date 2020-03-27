package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Readonly<type-mappings.Person> */
@js.native
trait ReadonlyPerson extends js.Object {
  val age: js.UndefOr[Double] = js.native
  val name: String = js.native
}

object ReadonlyPerson {
  @scala.inline
  def apply(name: String, age: Int | Double = null): ReadonlyPerson = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    if (age != null) __obj.updateDynamic("age")(age.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReadonlyPerson]
  }
}


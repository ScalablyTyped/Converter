package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Required<type-mappings.Person> */
@js.native
trait RequiredPerson extends js.Object {
  var age: scala.Double = js.native
  var name: String = js.native
}

object RequiredPerson {
  @scala.inline
  def apply(age: scala.Double, name: String): RequiredPerson = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[RequiredPerson]
  }
}


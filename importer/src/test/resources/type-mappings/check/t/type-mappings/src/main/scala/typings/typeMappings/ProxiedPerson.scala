package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined type-mappings.Proxify<type-mappings.Person> */
@js.native
trait ProxiedPerson extends js.Object {
  var age: AnonGet = js.native
  var name: AnonGetSet = js.native
}

object ProxiedPerson {
  @scala.inline
  def apply(age: AnonGet, name: AnonGetSet): ProxiedPerson = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[ProxiedPerson]
  }
}


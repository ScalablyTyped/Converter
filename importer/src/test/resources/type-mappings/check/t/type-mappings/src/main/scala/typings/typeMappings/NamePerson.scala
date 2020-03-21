package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Pick<type-mappings.Person, 'name'> */
@js.native
trait NamePerson extends js.Object {
  var name: String = js.native
}

object NamePerson {
  @scala.inline
  def apply(name: String): NamePerson = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[NamePerson]
  }
}


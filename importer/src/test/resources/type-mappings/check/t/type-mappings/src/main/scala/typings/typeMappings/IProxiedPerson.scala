package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined parent type-mappings.Proxify<type-mappings.Person> */
@js.native
trait IProxiedPerson extends js.Object {
  var age: AnonGet = js.native
  var name: AnonGetSet = js.native
}

object IProxiedPerson {
  @scala.inline
  def apply(age: AnonGet, name: AnonGetSet): IProxiedPerson = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[IProxiedPerson]
  }
}


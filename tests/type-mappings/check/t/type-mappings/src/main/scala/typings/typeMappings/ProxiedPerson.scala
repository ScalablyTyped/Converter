package typings.typeMappings

import typings.typeMappings.anon.Get
import typings.typeMappings.anon.Set
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined type-mappings.Proxify<type-mappings.Person> */
@js.native
trait ProxiedPerson extends js.Object {
  var age: js.UndefOr[Get] = js.native
  var name: Set = js.native
}

object ProxiedPerson {
  @scala.inline
  def apply(name: Set): ProxiedPerson = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[ProxiedPerson]
  }
  @scala.inline
  implicit class ProxiedPersonOps[Self <: ProxiedPerson] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setName(value: Set): Self = this.set("name", value.asInstanceOf[js.Any])
    @scala.inline
    def setAge(value: Get): Self = this.set("age", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteAge: Self = this.set("age", js.undefined)
  }
  
}


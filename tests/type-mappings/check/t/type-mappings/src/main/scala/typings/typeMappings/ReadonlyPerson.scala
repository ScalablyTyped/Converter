package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Readonly<type-mappings.Person> */
@js.native
trait ReadonlyPerson extends js.Object {
  
  val age: js.UndefOr[scala.Double | Null] = js.native
  
  val name: String = js.native
}
object ReadonlyPerson {
  
  @scala.inline
  def apply(name: String): ReadonlyPerson = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReadonlyPerson]
  }
  
  @scala.inline
  implicit class ReadonlyPersonOps[Self <: ReadonlyPerson] (val x: Self) extends AnyVal {
    
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
    def setName(value: String): Self = this.set("name", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAge(value: scala.Double): Self = this.set("age", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteAge: Self = this.set("age", js.undefined)
    
    @scala.inline
    def setAgeNull: Self = this.set("age", null)
  }
}

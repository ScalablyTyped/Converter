package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Partial<type-mappings.Person> */
@js.native
trait PartialPerson extends StObject {
  
  var age: js.UndefOr[scala.Double | Null] = js.native
  
  var name: js.UndefOr[String] = js.native
}
object PartialPerson {
  
  @scala.inline
  def apply(): PartialPerson = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[PartialPerson]
  }
  
  @scala.inline
  implicit class PartialPersonMutableBuilder[Self <: PartialPerson] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAgeNull: Self = StObject.set(x, "age", null)
    
    @scala.inline
    def setAgeUndefined: Self = StObject.set(x, "age", js.undefined)
    
    @scala.inline
    def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setNameUndefined: Self = StObject.set(x, "name", js.undefined)
  }
}

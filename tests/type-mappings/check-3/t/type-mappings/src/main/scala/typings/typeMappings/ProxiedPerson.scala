package typings.typeMappings

import typings.typeMappings.anon.Get
import typings.typeMappings.anon.Set
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined type-mappings.Proxify<type-mappings.Person> */
@js.native
trait ProxiedPerson extends StObject {
  
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
  implicit class ProxiedPersonMutableBuilder[Self <: ProxiedPerson] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setAge(value: Get): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAgeUndefined: Self = StObject.set(x, "age", js.undefined)
    
    @scala.inline
    def setName(value: Set): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

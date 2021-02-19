package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Required<type-mappings.Person> */
@js.native
trait RequiredPerson extends StObject {
  
  var age: scala.Double = js.native
  
  var name: String = js.native
}
object RequiredPerson {
  
  @scala.inline
  def apply(age: scala.Double, name: String): RequiredPerson = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[RequiredPerson]
  }
  
  @scala.inline
  implicit class RequiredPersonMutableBuilder[Self <: RequiredPerson] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

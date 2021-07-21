package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Required<type-mappings.Person> */
trait RequiredPerson extends StObject {
  
  var age: scala.Double
  
  var name: String
}
object RequiredPerson {
  
  inline def apply(age: scala.Double, name: String): RequiredPerson = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[RequiredPerson]
  }
  
  extension [Self <: RequiredPerson](x: Self) {
    
    inline def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

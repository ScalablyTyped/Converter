package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Person extends StObject {
  
  var age: js.UndefOr[scala.Double | Null] = js.undefined
  
  var name: String
}
object Person {
  
  inline def apply(name: String): Person = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[Person]
  }
  
  extension [Self <: Person](x: Self) {
    
    inline def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    inline def setAgeNull: Self = StObject.set(x, "age", null)
    
    inline def setAgeUndefined: Self = StObject.set(x, "age", js.undefined)
    
    inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

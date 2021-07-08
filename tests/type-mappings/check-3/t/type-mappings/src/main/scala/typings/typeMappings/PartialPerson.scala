package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Partial<type-mappings.Person> */
trait PartialPerson extends StObject {
  
  var age: js.UndefOr[scala.Double | Null] = js.undefined
  
  var name: js.UndefOr[String] = js.undefined
}
object PartialPerson {
  
  inline def apply(): PartialPerson = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[PartialPerson]
  }
  
  extension [Self <: PartialPerson](x: Self) {
    
    inline def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    inline def setAgeNull: Self = StObject.set(x, "age", null)
    
    inline def setAgeUndefined: Self = StObject.set(x, "age", js.undefined)
    
    inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
    
    inline def setNameUndefined: Self = StObject.set(x, "name", js.undefined)
  }
}

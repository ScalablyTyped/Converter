package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Readonly<type-mappings.Person> */
trait ReadonlyPerson extends StObject {
  
  val age: js.UndefOr[scala.Double | Null] = js.undefined
  
  val name: String
}
object ReadonlyPerson {
  
  inline def apply(name: String): ReadonlyPerson = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReadonlyPerson]
  }
  
  extension [Self <: ReadonlyPerson](x: Self) {
    
    inline def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    inline def setAgeNull: Self = StObject.set(x, "age", null)
    
    inline def setAgeUndefined: Self = StObject.set(x, "age", js.undefined)
    
    inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

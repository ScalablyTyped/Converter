package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Pick<type-mappings.Person, 'name'> */
trait NamePerson extends StObject {
  
  var name: String
}
object NamePerson {
  
  inline def apply(name: String): NamePerson = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[NamePerson]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: NamePerson] (val x: Self) extends AnyVal {
    
    inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

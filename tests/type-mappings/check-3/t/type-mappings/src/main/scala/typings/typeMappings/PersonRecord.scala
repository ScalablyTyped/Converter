package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Record<'name' | 'age', string> */
trait PersonRecord extends StObject {
  
  var age: String
  
  var name: String
}
object PersonRecord {
  
  inline def apply(age: String, name: String): PersonRecord = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[PersonRecord]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: PersonRecord] (val x: Self) extends AnyVal {
    
    inline def setAge(value: String): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

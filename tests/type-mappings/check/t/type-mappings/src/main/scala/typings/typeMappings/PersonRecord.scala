package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Record<'name' | 'age', string> */
@js.native
trait PersonRecord extends StObject {
  
  var age: String = js.native
  
  var name: String = js.native
}
object PersonRecord {
  
  @scala.inline
  def apply(age: String, name: String): PersonRecord = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[PersonRecord]
  }
  
  @scala.inline
  implicit class PersonRecordMutableBuilder[Self <: PersonRecord] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setAge(value: String): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

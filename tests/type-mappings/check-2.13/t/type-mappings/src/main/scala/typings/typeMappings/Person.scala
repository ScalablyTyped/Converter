package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Person extends StObject {
  
  var age: js.UndefOr[scala.Double | Null] = js.native
  
  var name: String = js.native
}
object Person {
  
  @scala.inline
  def apply(name: String): Person = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[Person]
  }
  
  @scala.inline
  implicit class PersonMutableBuilder[Self <: Person] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAgeNull: Self = StObject.set(x, "age", null)
    
    @scala.inline
    def setAgeUndefined: Self = StObject.set(x, "age", js.undefined)
    
    @scala.inline
    def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

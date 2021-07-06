package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Readonly<type-mappings.Person> */
@js.native
trait ReadonlyPerson extends StObject {
  
  val age: js.UndefOr[scala.Double | Null] = js.native
  
  val name: String = js.native
}
object ReadonlyPerson {
  
  @scala.inline
  def apply(name: String): ReadonlyPerson = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReadonlyPerson]
  }
  
  @scala.inline
  implicit class ReadonlyPersonMutableBuilder[Self <: ReadonlyPerson] (val x: Self) extends AnyVal {
    
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

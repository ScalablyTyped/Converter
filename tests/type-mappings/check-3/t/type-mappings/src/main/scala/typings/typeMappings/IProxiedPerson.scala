package typings.typeMappings

import typings.typeMappings.anon.Get
import typings.typeMappings.anon.Set
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined parent type-mappings.Proxify<type-mappings.Person> */
trait IProxiedPerson extends StObject {
  
  var age: js.UndefOr[Get] = js.undefined
  
  var name: Set
}
object IProxiedPerson {
  
  inline def apply(name: Set): IProxiedPerson = {
    val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
    __obj.asInstanceOf[IProxiedPerson]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: IProxiedPerson] (val x: Self) extends AnyVal {
    
    inline def setAge(value: Get): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
    
    inline def setAgeUndefined: Self = StObject.set(x, "age", js.undefined)
    
    inline def setName(value: Set): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
  }
}

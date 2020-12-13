package typings.typeMappings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined std.Pick<{  name :string,   age :number}, 'age'> */
@js.native
trait V extends StObject {
  
  var age: scala.Double = js.native
}
object V {
  
  @scala.inline
  def apply(age: scala.Double): V = {
    val __obj = js.Dynamic.literal(age = age.asInstanceOf[js.Any])
    __obj.asInstanceOf[V]
  }
  
  @scala.inline
  implicit class VMutableBuilder[Self <: V] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setAge(value: scala.Double): Self = StObject.set(x, "age", value.asInstanceOf[js.Any])
  }
}

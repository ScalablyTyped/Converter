package typings.documentation

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Rewritten from type alias, can be one of: 
  - typings.documentation.Branch[T]
  - typings.documentation.Leaf[T]
*/
trait Tree[T] extends StObject
object Tree {
  
  @scala.inline
  def Branch[T](left: T, right: T): typings.documentation.Branch[T] = {
    val `type` = "Branch"
    val __obj = js.Dynamic.literal(left = left.asInstanceOf[js.Any], right = right.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[typings.documentation.Branch[T]]
  }
  
  @scala.inline
  def Leaf[T](value: T): typings.documentation.Leaf[T] = {
    val `type` = "Leaf"
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[typings.documentation.Leaf[T]]
  }
}

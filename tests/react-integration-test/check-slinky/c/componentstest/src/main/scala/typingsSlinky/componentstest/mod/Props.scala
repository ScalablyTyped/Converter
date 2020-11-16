package typingsSlinky.componentstest.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Rewritten from type alias, can be one of: 
  - typingsSlinky.componentstest.mod.A
  - typingsSlinky.componentstest.mod.B
*/
trait Props extends js.Object
object Props {
  
  @scala.inline
  def A(aCallback: () => Double, aMember: Double): Props = {
    val __obj = js.Dynamic.literal(aCallback = js.Any.fromFunction0(aCallback), aMember = aMember.asInstanceOf[js.Any])
    __obj.asInstanceOf[Props]
  }
  
  @scala.inline
  def B(bMember: String): Props = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    __obj.asInstanceOf[Props]
  }
}

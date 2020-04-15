package typings.componentstest.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.componentstest.mod.A
  - typings.componentstest.mod.B
*/
trait Props extends js.Object

object Props {
  @scala.inline
  def A(aCallback: () => Double, aMember: Double): Props = {
    val __obj = js.Dynamic.literal(aCallback = js.Any.fromFunction0(aCallback), aMember = aMember.asInstanceOf[js.Any])
    __obj.asInstanceOf[Props]
  }
  @scala.inline
  def B(bMember: String, bCallback: () => String = null): Props = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    if (bCallback != null) __obj.updateDynamic("bCallback")(js.Any.fromFunction0(bCallback))
    __obj.asInstanceOf[Props]
  }
}


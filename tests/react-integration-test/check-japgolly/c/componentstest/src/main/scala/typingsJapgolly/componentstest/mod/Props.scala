package typingsJapgolly.componentstest.mod

import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsJapgolly.componentstest.mod.A
  - typingsJapgolly.componentstest.mod.B
*/
trait Props extends js.Object

object Props {
  @scala.inline
  def A(aCallback: CallbackTo[Double], aMember: Double): Props = {
    val __obj = js.Dynamic.literal(aCallback = aCallback.toJsFn, aMember = aMember.asInstanceOf[js.Any])
    __obj.asInstanceOf[Props]
  }
  @scala.inline
  def B(bMember: String): Props = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    __obj.asInstanceOf[Props]
  }
}


package typingsJapgolly.componentstest.componentstestMod

import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.componentstest.componentstestMod.A
  - typings.componentstest.componentstestMod.B
*/
trait Props extends js.Object

object Props {
  @scala.inline
  def A(aCallback: CallbackTo[Double], aMember: Double): Props = {
    val __obj = js.Dynamic.literal(aMember = aMember.asInstanceOf[js.Any])
    __obj.updateDynamic("aCallback")(aCallback.toJsFn)
    __obj.asInstanceOf[Props]
  }
  @scala.inline
  def B(bMember: String, bCallback: js.UndefOr[CallbackTo[String]] = js.undefined): Props = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    bCallback.foreach(p => __obj.updateDynamic("bCallback")(p.toJsFn))
    __obj.asInstanceOf[Props]
  }
}


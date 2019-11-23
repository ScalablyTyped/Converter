package typings.react.reactMod

import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ChildContextProvider[CC] extends js.Object {
  def getChildContext(): CC
}

object ChildContextProvider {
  @scala.inline
  def apply[CC](getChildContext: CallbackTo[CC]): ChildContextProvider[CC] = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("getChildContext")(js.Any.fromFunction0((() => getChildContext.runNow())))
    __obj.asInstanceOf[ChildContextProvider[CC]]
  }
}


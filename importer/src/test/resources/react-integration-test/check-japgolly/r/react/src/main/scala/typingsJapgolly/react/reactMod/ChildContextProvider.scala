package typingsJapgolly.react.reactMod

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
    __obj.updateDynamic("getChildContext")(getChildContext.toJsFn)
    __obj.asInstanceOf[ChildContextProvider[CC]]
  }
}


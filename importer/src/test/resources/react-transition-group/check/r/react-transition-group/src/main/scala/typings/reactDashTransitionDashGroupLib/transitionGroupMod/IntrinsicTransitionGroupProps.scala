package typings
package reactDashTransitionDashGroupLib.transitionGroupMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait IntrinsicTransitionGroupProps[T /* <: reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.abbr | reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.animate */] extends js.Object {
  var component: js.UndefOr[T] = js.undefined
}

object IntrinsicTransitionGroupProps {
  @scala.inline
  def apply[T /* <: reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.abbr | reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.animate */](component: T = null): IntrinsicTransitionGroupProps[T] = {
    val __obj = js.Dynamic.literal()
    if (component != null) __obj.updateDynamic("component")(component.asInstanceOf[js.Any])
    __obj.asInstanceOf[IntrinsicTransitionGroupProps[T]]
  }
}


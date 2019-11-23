package typingsJapgolly.reactDashTransitionDashGroup.transitionGroupMod

import typingsJapgolly.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr
import typingsJapgolly.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.animate
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait IntrinsicTransitionGroupProps[T /* <: abbr | animate */] extends js.Object {
  var component: js.UndefOr[T] = js.undefined
}

object IntrinsicTransitionGroupProps {
  @scala.inline
  def apply[T /* <: abbr | animate */](component: T = null): IntrinsicTransitionGroupProps[T] = {
    val __obj = js.Dynamic.literal()
    if (component != null) __obj.updateDynamic("component")(component.asInstanceOf[js.Any])
    __obj.asInstanceOf[IntrinsicTransitionGroupProps[T]]
  }
}


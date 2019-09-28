package typings.reactDashTransitionDashGroup.transitionGroupMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr
import typings.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.animate
import scala.scalajs.js
import scala.scalajs.js.`|`

trait IntrinsicTransitionGroupProps[T /* <: abbr | animate */] extends js.Object {
  var component: js.UndefOr[T] = js.undefined
}

object IntrinsicTransitionGroupProps {
  @inline
  def apply[T /* <: abbr | animate */](component: T = null): IntrinsicTransitionGroupProps[T] = {
    val __obj = js.Dynamic.literal()
    if (component != null) __obj.updateDynamic("component")(component.asInstanceOf[js.Any])
    __obj.asInstanceOf[IntrinsicTransitionGroupProps[T]]
  }
}


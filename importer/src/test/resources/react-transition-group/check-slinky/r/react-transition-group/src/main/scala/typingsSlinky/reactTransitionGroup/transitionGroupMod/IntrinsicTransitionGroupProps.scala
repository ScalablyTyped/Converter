package typingsSlinky.reactTransitionGroup.transitionGroupMod

import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.animate
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait IntrinsicTransitionGroupProps[T /* <: abbr | animate */] extends js.Object {
  var component: js.UndefOr[T] = js.native
}

object IntrinsicTransitionGroupProps {
  @scala.inline
  def apply[T /* <: abbr | animate */](component: T = null): IntrinsicTransitionGroupProps[T] = {
    val __obj = js.Dynamic.literal()
    if (component != null) __obj.updateDynamic("component")(component.asInstanceOf[js.Any])
    __obj.asInstanceOf[IntrinsicTransitionGroupProps[T]]
  }
}


package typings.reactTransitionGroup.transitionGroupMod

import typings.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typings.reactTransitionGroup.reactTransitionGroupStrings.animate
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait IntrinsicTransitionGroupProps[T /* <: abbr | animate */] extends js.Object {
  var component: js.UndefOr[T] = js.native
}

object IntrinsicTransitionGroupProps {
  @scala.inline
  def apply[T](): IntrinsicTransitionGroupProps[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[IntrinsicTransitionGroupProps[T]]
  }
  @scala.inline
  implicit class IntrinsicTransitionGroupPropsOps[Self <: IntrinsicTransitionGroupProps[_], T] (val x: Self with IntrinsicTransitionGroupProps[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withComponent(value: T): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("component")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutComponent: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("component")(js.undefined)
        ret
    }
  }
  
}


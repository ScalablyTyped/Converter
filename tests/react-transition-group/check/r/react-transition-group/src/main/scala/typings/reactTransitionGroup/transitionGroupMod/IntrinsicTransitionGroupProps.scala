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
  def apply[T /* <: abbr | animate */](component: T = null): IntrinsicTransitionGroupProps[T] = {
    val __obj = js.Dynamic.literal()
    if (component != null) __obj.updateDynamic("component")(component.asInstanceOf[js.Any])
    __obj.asInstanceOf[IntrinsicTransitionGroupProps[T]]
  }
  @scala.inline
  implicit class IntrinsicTransitionGroupPropsOps[Self[t /* <: typings.reactTransitionGroup.reactTransitionGroupStrings.abbr | typings.reactTransitionGroup.reactTransitionGroupStrings.animate */] <: IntrinsicTransitionGroupProps[t], T <: abbr | animate] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withComponent(component: T): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (component != null) ret.updateDynamic("component")(component.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutComponent: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "component")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}


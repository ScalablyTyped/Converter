package typingsJapgolly.reactTransitionGroup.transitionGroupMod

import typingsJapgolly.react.mod.ReactType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ComponentTransitionGroupProps[T /* <: ReactType[_] */] extends js.Object {
  var component: T = js.native
}

object ComponentTransitionGroupProps {
  @scala.inline
  def apply[T /* <: ReactType[_] */](component: T): ComponentTransitionGroupProps[T] = {
    val __obj = js.Dynamic.literal(component = component.asInstanceOf[js.Any])
    __obj.asInstanceOf[ComponentTransitionGroupProps[T]]
  }
  @scala.inline
  implicit class ComponentTransitionGroupPropsOps[Self[t /* <: typingsJapgolly.react.mod.ReactType[_] */] <: ComponentTransitionGroupProps[t], T <: ReactType[_]] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withComponent(component: T): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("component")(component.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
  }
  
}


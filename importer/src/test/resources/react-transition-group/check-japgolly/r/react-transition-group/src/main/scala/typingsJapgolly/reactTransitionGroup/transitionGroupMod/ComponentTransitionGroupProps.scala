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
}


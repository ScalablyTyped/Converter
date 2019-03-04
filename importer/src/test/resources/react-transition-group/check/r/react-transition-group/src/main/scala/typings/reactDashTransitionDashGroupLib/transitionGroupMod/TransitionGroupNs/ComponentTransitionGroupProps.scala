package typings
package reactDashTransitionDashGroupLib.transitionGroupMod.TransitionGroupNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ComponentTransitionGroupProps[T /* <: reactLib.reactMod.ReactNs.ReactType[_] */] extends js.Object {
  var component: T
}

object ComponentTransitionGroupProps {
  @scala.inline
  def apply[T /* <: reactLib.reactMod.ReactNs.ReactType[_] */](component: T): ComponentTransitionGroupProps[T] = {
    val __obj = js.Dynamic.literal(component = component.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[ComponentTransitionGroupProps[T]]
  }
}


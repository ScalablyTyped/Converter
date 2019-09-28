package typings.reactDashTransitionDashGroup.transitionGroupMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.reactMod.ReactType
import scala.scalajs.js
import scala.scalajs.js.`|`

trait ComponentTransitionGroupProps[T /* <: ReactType[_] */] extends js.Object {
  var component: T
}

object ComponentTransitionGroupProps {
  @inline
  def apply[T /* <: ReactType[_] */](component: T): ComponentTransitionGroupProps[T] = {
    val __obj = js.Dynamic.literal(component = component.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[ComponentTransitionGroupProps[T]]
  }
}


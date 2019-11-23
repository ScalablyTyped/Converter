package typings.reactDashSelect.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactDashSelect.reactDashSelectMod.ReactSelectProps
import typings.reactDashSelect.reactDashSelectMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDashSelect {
  def apply[TValue](addLabelText: String = null): UnmountedWithRoot[ReactSelectProps[TValue], default[TValue], Unit, ReactSelectProps[TValue]] = {
    val __obj = js.Dynamic.literal()
  
      if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.reactDashSelect.reactDashSelectMod.ReactSelectProps[TValue], 
  japgolly.scalajs.react.Children.None, 
  typings.reactDashSelect.reactDashSelectMod.default[TValue]](js.constructorOf[typings.reactDashSelect.reactDashSelectMod.default[TValue]])
    f(__obj.asInstanceOf[typings.reactDashSelect.reactDashSelectMod.ReactSelectProps[TValue]])
  }
}


package typings.reactSelect.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactSelect.reactSelectMod.ReactSelectProps
import typings.reactSelect.reactSelectMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactSelect {
  def apply[TValue](addLabelText: String = null)(children: ChildArg*): UnmountedWithRoot[ReactSelectProps[TValue], default[TValue], Unit, ReactSelectProps[TValue]] = {
    val __obj = js.Dynamic.literal()
  
      if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactSelect.reactSelectMod.ReactSelectProps[TValue], 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactSelect.reactSelectMod.default[TValue]](js.constructorOf[typings.reactSelect.reactSelectMod.default[TValue]])
    f(__obj.asInstanceOf[typings.reactSelect.reactSelectMod.ReactSelectProps[TValue]])(children: _*)
  }
}


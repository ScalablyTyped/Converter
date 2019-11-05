package typings.japgolly.reactDashSelect

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.reactDashSelect.reactDashSelectMod.ReactSelectProps
import typings.reactDashSelect.reactDashSelectMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDashSelect {
  def apply[TValue](
    addLabelText: String = null,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[ReactSelectProps[TValue], default[TValue], Unit, ReactSelectProps[TValue]] = {
    val __obj = js.Dynamic.literal()
  
      if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDashSelect.reactDashSelectMod.ReactSelectProps[TValue], 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactDashSelect.reactDashSelectMod.default[TValue]](js.constructorOf[typings.reactDashSelect.reactDashSelectMod.default[TValue]])
    f(__obj.asInstanceOf[typings.reactDashSelect.reactDashSelectMod.ReactSelectProps[TValue]])(children: _*)
  }
}


package typingsJapgolly.reactDashSelect.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.reactDashSelect.reactDashSelectMod.ReactSelectProps
import typingsJapgolly.reactDashSelect.reactDashSelectMod.default
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
  
      if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.reactDashSelect.reactDashSelectMod.ReactSelectProps[TValue], 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.reactDashSelect.reactDashSelectMod.default[TValue]](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.reactDashSelect.reactDashSelectMod.ReactSelectProps[TValue]])(children: _*)
  }
  @JSImport("react-select", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
}


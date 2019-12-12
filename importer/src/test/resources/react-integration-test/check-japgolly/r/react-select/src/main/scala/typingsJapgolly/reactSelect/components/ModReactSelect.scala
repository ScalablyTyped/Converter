package typingsJapgolly.reactSelect.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.reactSelect.mod.ReactSelectProps
import typingsJapgolly.reactSelect.mod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ModReactSelect {
  def apply[TValue](
    addLabelText: String = null,
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[ReactSelectProps[TValue], default[TValue], Unit, ReactSelectProps[TValue]] = {
    val __obj = js.Dynamic.literal()
  
      if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.reactSelect.mod.ReactSelectProps[TValue], 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.reactSelect.mod.default[TValue]](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.reactSelect.mod.ReactSelectProps[TValue]])(children: _*)
  }
  @JSImport("react-select", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
}


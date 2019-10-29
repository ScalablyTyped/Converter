package typings.reactSelect.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.reactSelect.reactSelectMod.ReactSelectProps
import typings.reactSelect.reactSelectMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactSelect {
  def apply[TValue](key: js.UndefOr[Key] = js.undefined, addLabelText: String = null)(children: ChildArg*): UnmountedWithRoot[ReactSelectProps[TValue], default[TValue], Unit, ReactSelectProps[TValue]] = {
    val __obj = js.Dynamic.literal()
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactSelect.reactSelectMod.ReactSelectProps[TValue], 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactSelect.reactSelectMod.default[TValue]](js.constructorOf[typings.reactSelect.reactSelectMod.default[TValue]])
    f(__obj.asInstanceOf[typings.reactSelect.reactSelectMod.ReactSelectProps[TValue]])(children: _*)
  }
}


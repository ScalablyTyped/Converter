package typingsJapgolly.reactDashBootstrap.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.reactDashBootstrap.libToggleButtonGroupMod.ToggleButtonGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. */
object ToggleButtonGroup {
  def apply(
    props: ToggleButtonGroupProps with js.Object,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    ToggleButtonGroupProps with js.Object, 
    typingsJapgolly.reactDashBootstrap.libMod.ToggleButtonGroup, 
    Unit, 
    ToggleButtonGroupProps with js.Object
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, props)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.reactDashBootstrap.libToggleButtonGroupMod.ToggleButtonGroupProps with js.Object, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.reactDashBootstrap.libMod.ToggleButtonGroup](js.constructorOf[typingsJapgolly.reactDashBootstrap.libMod.ToggleButtonGroup])
    f(__obj.asInstanceOf[typingsJapgolly.reactDashBootstrap.libToggleButtonGroupMod.ToggleButtonGroupProps with js.Object])(children: _*)
  }
}


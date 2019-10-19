package typingsJapgolly.reactBootstrap.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.reactBootstrap.mod.lib.ToggleButtonGroup.ToggleButtonGroupProps
import typingsJapgolly.reactBootstrap.mod.lib.ToggleButtonGroup.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. */
object ModLibToggleButtonGroup {
  def apply(
    props: ToggleButtonGroupProps with js.Object,
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[ToggleButtonGroupProps with js.Object, ^, Unit, ToggleButtonGroupProps with js.Object] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, props)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.reactBootstrap.mod.lib.ToggleButtonGroup.ToggleButtonGroupProps with js.Object, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.reactBootstrap.mod.lib.ToggleButtonGroup.^](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.reactBootstrap.mod.lib.ToggleButtonGroup.ToggleButtonGroupProps with js.Object])(children: _*)
  }
  @JSImport("react-bootstrap/lib/ToggleButtonGroup", JSImport.Namespace)
  @js.native
  object componentImport extends js.Object
  
}


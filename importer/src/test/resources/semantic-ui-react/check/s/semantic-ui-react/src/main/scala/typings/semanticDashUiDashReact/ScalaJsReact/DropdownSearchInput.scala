package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.DropdownSearchInputProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object DropdownSearchInput {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    autoComplete: String = null,
    className: String = null,
    tabIndex: Double | String = null,
    `type`: String = null,
    value: Double | String = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[DropdownSearchInputProps, default, Unit, DropdownSearchInputProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (autoComplete != null) __obj.updateDynamic("autoComplete")(autoComplete)
    if (className != null) __obj.updateDynamic("className")(className)
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (`type` != null) __obj.updateDynamic("type")(`type`)
    if (value != null) __obj.updateDynamic("value")(value.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.DropdownSearchInputProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.DropdownSearchInputProps])(children: _*)
  }
}


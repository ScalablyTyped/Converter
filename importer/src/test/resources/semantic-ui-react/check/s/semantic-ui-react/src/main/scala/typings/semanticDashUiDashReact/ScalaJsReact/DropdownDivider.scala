package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownDividerMod.DropdownDividerProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownDividerMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: className */
object DropdownDivider {
  def apply(StringDictionary: /* key */ StringDictionary[js.Any] = null, as: js.Any = null): UnmountedWithRoot[DropdownDividerProps, default, Unit, DropdownDividerProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.semanticDashUiDashReact.srcModulesDropdownDropdownDividerMod.DropdownDividerProps, 
  japgolly.scalajs.react.Children.None, 
  typings.semanticDashUiDashReact.srcModulesDropdownDropdownDividerMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesDropdownDropdownDividerMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesDropdownDropdownDividerMod.DropdownDividerProps])
  }
}


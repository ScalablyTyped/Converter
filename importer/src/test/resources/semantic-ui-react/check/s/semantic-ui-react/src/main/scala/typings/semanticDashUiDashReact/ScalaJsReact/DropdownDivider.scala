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
  def apply(StringDictionary: /* key */ StringDictionary[js.Any] = null, as: js.Any = null)(): UnmountedWithRoot[DropdownDividerProps, default, Unit, DropdownDividerProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type DropdownDividerType = typings.semanticDashUiDashReact.srcModulesDropdownDropdownDividerMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, DropdownDividerType](js.constructorOf[DropdownDividerType])
  
    f(props)
  }
  type Props = DropdownDividerProps
}


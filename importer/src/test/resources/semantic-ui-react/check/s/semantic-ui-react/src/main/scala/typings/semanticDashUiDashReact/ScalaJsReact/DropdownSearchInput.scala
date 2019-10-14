package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.DropdownSearchInputProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: autoComplete, className, type, value */
object DropdownSearchInput {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    tabIndex: Double | String = null
  )(
    
  ): UnmountedWithRoot[DropdownSearchInputProps, default, Unit, DropdownSearchInputProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type DropdownSearchInputType = typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, DropdownSearchInputType](js.constructorOf[DropdownSearchInputType])
  
    f(props)
  }
  type Props = DropdownSearchInputProps
}


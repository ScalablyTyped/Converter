package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcElementsIconIconMod.IconProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownHeaderMod.DropdownHeaderProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownHeaderMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className */
object DropdownHeader {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    icon: SemanticShorthandItem[IconProps] = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedWithRoot[DropdownHeaderProps, default, Unit, DropdownHeaderProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type DropdownHeaderType = typings.semanticDashUiDashReact.srcModulesDropdownDropdownHeaderMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.Varargs, DropdownHeaderType](js.constructorOf[DropdownHeaderType])
  
    f(props)(children: _*)
  }
  type Props = DropdownHeaderProps
}


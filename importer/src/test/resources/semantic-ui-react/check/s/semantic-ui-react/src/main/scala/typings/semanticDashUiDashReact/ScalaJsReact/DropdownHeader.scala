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

object DropdownHeader {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    icon: SemanticShorthandItem[IconProps] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[DropdownHeaderProps, default, Unit, DropdownHeaderProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.semanticDashUiDashReact.srcModulesDropdownDropdownHeaderMod.DropdownHeaderProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcModulesDropdownDropdownHeaderMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesDropdownDropdownHeaderMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesDropdownDropdownHeaderMod.DropdownHeaderProps])(children: _*)
  }
}


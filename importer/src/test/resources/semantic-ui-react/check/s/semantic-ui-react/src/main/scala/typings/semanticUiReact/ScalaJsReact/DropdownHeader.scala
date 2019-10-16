package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.elementsIconIconMod.IconProps
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesDropdownDropdownHeaderMod.DropdownHeaderProps
import typings.semanticUiReact.modulesDropdownDropdownHeaderMod.default
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
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesDropdownDropdownHeaderMod.DropdownHeaderProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesDropdownDropdownHeaderMod.default](js.constructorOf[typings.semanticUiReact.modulesDropdownDropdownHeaderMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesDropdownDropdownHeaderMod.DropdownHeaderProps])(children: _*)
  }
}


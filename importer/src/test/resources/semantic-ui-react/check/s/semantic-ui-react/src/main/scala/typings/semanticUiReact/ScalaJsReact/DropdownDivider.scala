package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.modulesDropdownDropdownDividerMod.DropdownDividerProps
import typings.semanticUiReact.modulesDropdownDropdownDividerMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object DropdownDivider {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[DropdownDividerProps, default, Unit, DropdownDividerProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesDropdownDropdownDividerMod.DropdownDividerProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesDropdownDropdownDividerMod.default](js.constructorOf[typings.semanticUiReact.modulesDropdownDropdownDividerMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesDropdownDropdownDividerMod.DropdownDividerProps])(children: _*)
  }
}


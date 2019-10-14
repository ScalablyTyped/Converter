package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownMenuMod.DropdownMenuProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, direction, open */
object DropdownMenu {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    scrolling: js.UndefOr[Boolean] = js.undefined
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedSimple[
    DropdownMenuProps, 
    MountedWithRawType[DropdownMenuProps, js.Object, RawMounted[DropdownMenuProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(scrolling)) __obj.updateDynamic("scrolling")(scrolling)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcModulesDropdownDropdownMenuMod.DropdownMenuProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcModulesDropdownDropdownMenuMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesDropdownDropdownMenuMod.DropdownMenuProps])(children: _*)
  }
}


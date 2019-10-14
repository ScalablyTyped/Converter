package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesSidebarSidebarPusherMod.SidebarPusherProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object SidebarPusher {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    dimmed: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedSimple[
    SidebarPusherProps, 
    MountedWithRawType[SidebarPusherProps, js.Object, RawMounted[SidebarPusherProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(dimmed)) __obj.updateDynamic("dimmed")(dimmed)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcModulesSidebarSidebarPusherMod.SidebarPusherProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcModulesSidebarSidebarPusherMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesSidebarSidebarPusherMod.SidebarPusherProps])(children: _*)
  }
}


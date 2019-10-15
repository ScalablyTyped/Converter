package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesPopupPopupHeaderMod.PopupHeaderProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object PopupHeader {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    PopupHeaderProps, 
    MountedWithRawType[PopupHeaderProps, js.Object, RawMounted[PopupHeaderProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcModulesPopupPopupHeaderMod.PopupHeaderProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcModulesPopupPopupHeaderMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesPopupPopupHeaderMod.PopupHeaderProps])(children: _*)
  }
}


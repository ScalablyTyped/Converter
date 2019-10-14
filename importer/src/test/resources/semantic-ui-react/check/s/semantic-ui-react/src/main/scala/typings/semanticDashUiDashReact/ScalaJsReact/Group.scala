package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcElementsIconIconGroupMod.IconGroupProps
import typings.semanticDashUiDashReact.srcElementsIconIconMod.IconSizeProp
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className */
object Group {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    size: IconSizeProp = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedSimple[
    IconGroupProps, 
    MountedWithRawType[IconGroupProps, js.Object, RawMounted[IconGroupProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcElementsIconIconGroupMod.IconGroupProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcElementsIconMod.default.Group)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsIconIconGroupMod.IconGroupProps])(children: _*)
  }
}


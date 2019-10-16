package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.elementsIconIconGroupMod.IconGroupProps
import typings.semanticUiReact.elementsIconIconMod.IconSizeProp
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object IconGroup {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    size: IconSizeProp = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    IconGroupProps, 
    MountedWithRawType[IconGroupProps, js.Object, RawMounted[IconGroupProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticUiReact.elementsIconIconGroupMod.IconGroupProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticUiReact.elementsIconIconGroupMod.default)
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsIconIconGroupMod.IconGroupProps])(children: _*)
  }
}


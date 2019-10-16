package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.elementsLabelLabelGroupMod.LabelGroupProps
import typings.semanticUiReact.genericMod.SemanticCOLORS
import typings.semanticUiReact.genericMod.SemanticSIZES
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object LabelGroup {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    color: SemanticCOLORS = null,
    content: SemanticShorthandContent = null,
    size: SemanticSIZES = null,
    tag: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedSimple[
    LabelGroupProps, 
    MountedWithRawType[LabelGroupProps, js.Object, RawMounted[LabelGroupProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(circular)) __obj.updateDynamic("circular")(circular)
    if (className != null) __obj.updateDynamic("className")(className)
    if (color != null) __obj.updateDynamic("color")(color)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size)
    if (!js.isUndefined(tag)) __obj.updateDynamic("tag")(tag)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticUiReact.elementsLabelLabelGroupMod.LabelGroupProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticUiReact.elementsLabelLabelGroupMod.default)
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsLabelLabelGroupMod.LabelGroupProps])(children: _*)
  }
}


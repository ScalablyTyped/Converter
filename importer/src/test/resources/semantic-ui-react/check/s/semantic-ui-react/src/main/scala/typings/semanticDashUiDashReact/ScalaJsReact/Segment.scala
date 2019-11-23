package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.very
import typings.semanticDashUiDashReact.srcElementsSegmentSegmentMod.SegmentProps
import typings.semanticDashUiDashReact.srcElementsSegmentSegmentMod.SegmentSizeProp
import typings.semanticDashUiDashReact.srcGenericMod.SemanticCOLORS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticFLOATS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticTEXTALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Segment {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    attached: Boolean | top | bottom = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    clearing: js.UndefOr[Boolean] = js.undefined,
    color: SemanticCOLORS = null,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandContent = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    floated: SemanticFLOATS = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    padded: Boolean | very = null,
    piled: js.UndefOr[Boolean] = js.undefined,
    placeholder: js.UndefOr[Boolean] = js.undefined,
    raised: js.UndefOr[Boolean] = js.undefined,
    secondary: js.UndefOr[Boolean] = js.undefined,
    size: SegmentSizeProp = null,
    stacked: js.UndefOr[Boolean] = js.undefined,
    tertiary: js.UndefOr[Boolean] = js.undefined,
    textAlign: SemanticTEXTALIGNMENTS = null,
    vertical: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedSimple[
    SegmentProps, 
    MountedWithRawType[SegmentProps, js.Object, RawMounted[SegmentProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (!js.isUndefined(circular)) __obj.updateDynamic("circular")(circular)
    if (className != null) __obj.updateDynamic("className")(className)
    if (!js.isUndefined(clearing)) __obj.updateDynamic("clearing")(clearing)
    if (color != null) __obj.updateDynamic("color")(color)
    if (!js.isUndefined(compact)) __obj.updateDynamic("compact")(compact)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (floated != null) __obj.updateDynamic("floated")(floated)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (padded != null) __obj.updateDynamic("padded")(padded.asInstanceOf[js.Any])
    if (!js.isUndefined(piled)) __obj.updateDynamic("piled")(piled)
    if (!js.isUndefined(placeholder)) __obj.updateDynamic("placeholder")(placeholder)
    if (!js.isUndefined(raised)) __obj.updateDynamic("raised")(raised)
    if (!js.isUndefined(secondary)) __obj.updateDynamic("secondary")(secondary)
    if (size != null) __obj.updateDynamic("size")(size)
    if (!js.isUndefined(stacked)) __obj.updateDynamic("stacked")(stacked)
    if (!js.isUndefined(tertiary)) __obj.updateDynamic("tertiary")(tertiary)
    if (textAlign != null) __obj.updateDynamic("textAlign")(textAlign)
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcElementsSegmentSegmentMod.SegmentProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcElementsSegmentMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsSegmentSegmentMod.SegmentProps])(children: _*)
  }
}


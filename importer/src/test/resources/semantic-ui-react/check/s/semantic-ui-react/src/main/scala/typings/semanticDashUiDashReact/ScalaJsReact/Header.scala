package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.huge
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.large
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.medium
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.small
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.tiny
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typings.semanticDashUiDashReact.srcElementsHeaderHeaderMod.HeaderProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticCOLORS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticFLOATS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticTEXTALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Header {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    attached: Boolean | top | bottom = null,
    block: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    color: SemanticCOLORS = null,
    content: VdomNode = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    dividing: js.UndefOr[Boolean] = js.undefined,
    floated: SemanticFLOATS = null,
    icon: js.Any = null,
    image: js.Any = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    size: tiny | small | medium | large | huge = null,
    sub: js.UndefOr[Boolean] = js.undefined,
    subheader: js.Any = null,
    textAlign: SemanticTEXTALIGNMENTS = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    HeaderProps, 
    MountedWithRawType[HeaderProps, js.Object, RawMounted[HeaderProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (!js.isUndefined(block)) __obj.updateDynamic("block")(block)
    if (className != null) __obj.updateDynamic("className")(className)
    if (color != null) __obj.updateDynamic("color")(color)
        if (content != null) __obj.updateDynamic("content")(content.rawNode.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(dividing)) __obj.updateDynamic("dividing")(dividing)
    if (floated != null) __obj.updateDynamic("floated")(floated)
    if (icon != null) __obj.updateDynamic("icon")(icon)
    if (image != null) __obj.updateDynamic("image")(image)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (!js.isUndefined(sub)) __obj.updateDynamic("sub")(sub)
    if (subheader != null) __obj.updateDynamic("subheader")(subheader)
    if (textAlign != null) __obj.updateDynamic("textAlign")(textAlign)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcElementsHeaderHeaderMod.HeaderProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcElementsHeaderMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsHeaderHeaderMod.HeaderProps])(children: _*)
  }
}


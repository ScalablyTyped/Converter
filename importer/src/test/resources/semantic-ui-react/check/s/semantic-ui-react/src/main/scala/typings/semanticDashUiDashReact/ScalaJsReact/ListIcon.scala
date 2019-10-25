package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.clockwise
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.counterclockwise
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.horizontally
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.vertically
import typings.semanticDashUiDashReact.srcElementsIconIconMod.IconCorner
import typings.semanticDashUiDashReact.srcElementsIconIconMod.IconSizeProp
import typings.semanticDashUiDashReact.srcElementsListListIconMod.ListIconProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticCOLORS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticICONS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticVERTICALALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ListIcon {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    `aria-hidden`: String = null,
    `aria-label`: String = null,
    as: js.Any = null,
    bordered: js.UndefOr[Boolean] = js.undefined,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    color: SemanticCOLORS = null,
    corner: Boolean | IconCorner = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    fitted: js.UndefOr[Boolean] = js.undefined,
    flipped: horizontally | vertically = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    link: js.UndefOr[Boolean] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    name: SemanticICONS = null,
    rotated: clockwise | counterclockwise = null,
    size: IconSizeProp = null,
    verticalAlign: SemanticVERTICALALIGNMENTS = null
  ): UnmountedSimple[
    ListIconProps, 
    MountedWithRawType[ListIconProps, js.Object, RawMounted[ListIconProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (`aria-hidden` != null) __obj.updateDynamic("aria-hidden")(`aria-hidden`)
    if (`aria-label` != null) __obj.updateDynamic("aria-label")(`aria-label`)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(bordered)) __obj.updateDynamic("bordered")(bordered)
    if (!js.isUndefined(circular)) __obj.updateDynamic("circular")(circular)
    if (className != null) __obj.updateDynamic("className")(className)
    if (color != null) __obj.updateDynamic("color")(color)
    if (corner != null) __obj.updateDynamic("corner")(corner.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(fitted)) __obj.updateDynamic("fitted")(fitted)
    if (flipped != null) __obj.updateDynamic("flipped")(flipped.asInstanceOf[js.Any])
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (!js.isUndefined(link)) __obj.updateDynamic("link")(link)
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (name != null) __obj.updateDynamic("name")(name)
    if (rotated != null) __obj.updateDynamic("rotated")(rotated.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size)
    if (verticalAlign != null) __obj.updateDynamic("verticalAlign")(verticalAlign)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcElementsListListIconMod.ListIconProps, 
  japgolly.scalajs.react.Children.None, 
  js.Object](typings.semanticDashUiDashReact.srcElementsListListIconMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsListListIconMod.ListIconProps])
  }
}


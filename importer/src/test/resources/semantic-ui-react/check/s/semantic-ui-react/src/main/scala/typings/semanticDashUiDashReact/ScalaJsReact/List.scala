package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLAnchorElement
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.very
import typings.semanticDashUiDashReact.srcElementsListListItemMod.ListItemProps
import typings.semanticDashUiDashReact.srcElementsListListMod.ListProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticFLOATS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticSIZES
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandCollection
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticVERTICALALIGNMENTS
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object List {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    animated: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    bulleted: js.UndefOr[Boolean] = js.undefined,
    celled: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    content: SemanticShorthandContent = null,
    divided: js.UndefOr[Boolean] = js.undefined,
    floated: SemanticFLOATS = null,
    horizontal: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    items: SemanticShorthandCollection[ListItemProps] = null,
    link: js.UndefOr[Boolean] = js.undefined,
    onItemClick: (/* event */ ReactMouseEventFrom[HTMLAnchorElement], /* data */ ListItemProps) => Callback = null,
    ordered: js.UndefOr[Boolean] = js.undefined,
    relaxed: Boolean | very = null,
    selection: js.UndefOr[Boolean] = js.undefined,
    size: SemanticSIZES = null,
    verticalAlign: SemanticVERTICALALIGNMENTS = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    ListProps, 
    MountedWithRawType[ListProps, js.Object, RawMounted[ListProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(animated)) __obj.updateDynamic("animated")(animated)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(bulleted)) __obj.updateDynamic("bulleted")(bulleted)
    if (!js.isUndefined(celled)) __obj.updateDynamic("celled")(celled)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(divided)) __obj.updateDynamic("divided")(divided)
    if (floated != null) __obj.updateDynamic("floated")(floated)
    if (!js.isUndefined(horizontal)) __obj.updateDynamic("horizontal")(horizontal)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (items != null) __obj.updateDynamic("items")(items)
    if (!js.isUndefined(link)) __obj.updateDynamic("link")(link)
    if (onItemClick != null) __obj.updateDynamic("onItemClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLAnchorElement], t1: /* data */ typings.semanticDashUiDashReact.srcElementsListListItemMod.ListItemProps) => onItemClick(t0, t1).runNow())))
    if (!js.isUndefined(ordered)) __obj.updateDynamic("ordered")(ordered)
    if (relaxed != null) __obj.updateDynamic("relaxed")(relaxed.asInstanceOf[js.Any])
    if (!js.isUndefined(selection)) __obj.updateDynamic("selection")(selection)
    if (size != null) __obj.updateDynamic("size")(size)
    if (verticalAlign != null) __obj.updateDynamic("verticalAlign")(verticalAlign)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcElementsListListMod.ListProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.semanticDashUiDashReact.srcElementsListMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsListListMod.ListProps])(children: _*)
  }
}


package typings.semanticUiReact.jagpolly

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import org.scalajs.dom.raw.HTMLElement
import typings.semanticUiReact.elementsInputInputMod.InputProps
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesSearchMod.default
import typings.semanticUiReact.modulesSearchSearchCategoryMod.SearchCategoryProps
import typings.semanticUiReact.modulesSearchSearchMod.SearchProps
import typings.semanticUiReact.modulesSearchSearchMod.SearchResultData
import typings.semanticUiReact.modulesSearchSearchResultMod.SearchResultProps
import typings.semanticUiReact.semanticUiReactStrings.big
import typings.semanticUiReact.semanticUiReactStrings.huge
import typings.semanticUiReact.semanticUiReactStrings.large
import typings.semanticUiReact.semanticUiReactStrings.massive
import typings.semanticUiReact.semanticUiReactStrings.mini
import typings.semanticUiReact.semanticUiReactStrings.small
import typings.semanticUiReact.semanticUiReactStrings.tiny
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Search {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    aligned: String = null,
    as: js.Any = null,
    category: js.UndefOr[Boolean] = js.undefined,
    categoryRenderer: /* props */ SearchCategoryProps => Callback = null,
    className: String = null,
    defaultOpen: js.UndefOr[Boolean] = js.undefined,
    defaultValue: String = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    icon: js.Any = null,
    input: SemanticShorthandItem[InputProps] = null,
    loading: js.UndefOr[Boolean] = js.undefined,
    minCharacters: Int | Double = null,
    noResultsDescription: VdomNode = null,
    noResultsMessage: VdomNode = null,
    onBlur: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SearchProps) => Callback = null,
    onFocus: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SearchProps) => Callback = null,
    onMouseDown: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SearchProps) => Callback = null,
    onResultSelect: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ SearchResultData) => Callback = null,
    onSearchChange: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SearchProps) => Callback = null,
    onSelectionChange: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ SearchResultData) => Callback = null,
    open: js.UndefOr[Boolean] = js.undefined,
    resultRenderer: /* props */ SearchResultProps => Callback = null,
    results: js.Array[js.Any] | (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any) = null,
    selectFirstResult: js.UndefOr[Boolean] = js.undefined,
    showNoResults: js.UndefOr[Boolean] = js.undefined,
    size: mini | tiny | small | large | big | huge | massive = null,
    value: String = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[SearchProps, default, Unit, SearchProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (aligned != null) __obj.updateDynamic("aligned")(aligned)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(category)) __obj.updateDynamic("category")(category)
    if (categoryRenderer != null) __obj.updateDynamic("categoryRenderer")(js.Any.fromFunction1(((t0: /* props */ typings.semanticUiReact.modulesSearchSearchCategoryMod.SearchCategoryProps) => categoryRenderer(t0).runNow())))
    if (className != null) __obj.updateDynamic("className")(className)
    if (!js.isUndefined(defaultOpen)) __obj.updateDynamic("defaultOpen")(defaultOpen)
    if (defaultValue != null) __obj.updateDynamic("defaultValue")(defaultValue)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (icon != null) __obj.updateDynamic("icon")(icon)
    if (input != null) __obj.updateDynamic("input")(input.asInstanceOf[js.Any])
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (minCharacters != null) __obj.updateDynamic("minCharacters")(minCharacters.asInstanceOf[js.Any])
    if (noResultsDescription != null) __obj.updateDynamic("noResultsDescription")(noResultsDescription.rawNode.asInstanceOf[js.Any])
    if (noResultsMessage != null) __obj.updateDynamic("noResultsMessage")(noResultsMessage.rawNode.asInstanceOf[js.Any])
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticUiReact.modulesSearchSearchMod.SearchProps) => onBlur(t0, t1).runNow())))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticUiReact.modulesSearchSearchMod.SearchProps) => onFocus(t0, t1).runNow())))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticUiReact.modulesSearchSearchMod.SearchProps) => onMouseDown(t0, t1).runNow())))
    if (onResultSelect != null) __obj.updateDynamic("onResultSelect")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesSearchSearchMod.SearchResultData) => onResultSelect(t0, t1).runNow())))
    if (onSearchChange != null) __obj.updateDynamic("onSearchChange")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticUiReact.modulesSearchSearchMod.SearchProps) => onSearchChange(t0, t1).runNow())))
    if (onSelectionChange != null) __obj.updateDynamic("onSelectionChange")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticUiReact.modulesSearchSearchMod.SearchResultData) => onSelectionChange(t0, t1).runNow())))
    if (!js.isUndefined(open)) __obj.updateDynamic("open")(open)
    if (resultRenderer != null) __obj.updateDynamic("resultRenderer")(js.Any.fromFunction1(((t0: /* props */ typings.semanticUiReact.modulesSearchSearchResultMod.SearchResultProps) => resultRenderer(t0).runNow())))
    if (results != null) __obj.updateDynamic("results")(results.asInstanceOf[js.Any])
    if (!js.isUndefined(selectFirstResult)) __obj.updateDynamic("selectFirstResult")(selectFirstResult)
    if (!js.isUndefined(showNoResults)) __obj.updateDynamic("showNoResults")(showNoResults)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (value != null) __obj.updateDynamic("value")(value)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesSearchSearchMod.SearchProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesSearchMod.default](js.constructorOf[typings.semanticUiReact.modulesSearchMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesSearchSearchMod.SearchProps])(children: _*)
  }
}


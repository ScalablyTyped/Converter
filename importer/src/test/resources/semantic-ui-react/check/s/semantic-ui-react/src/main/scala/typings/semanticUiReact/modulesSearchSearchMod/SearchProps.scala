package typings.semanticUiReact.modulesSearchSearchMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.HTMLDivElement
import typings.react.HTMLElement
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.ReactElement
import typings.react.reactMod.ReactNode
import typings.semanticUiReact.elementsInputInputMod.InputProps
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesSearchSearchCategoryMod.SearchCategoryProps
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

trait SearchProps
  extends StrictSearchProps
     with /* key */ StringDictionary[js.Any]

object SearchProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    aligned: String = null,
    as: js.Any = null,
    category: js.UndefOr[Boolean] = js.undefined,
    categoryRenderer: /* props */ SearchCategoryProps => ReactElement = null,
    className: String = null,
    defaultOpen: js.UndefOr[Boolean] = js.undefined,
    defaultValue: String = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    icon: js.Any = null,
    input: SemanticShorthandItem[InputProps] = null,
    loading: js.UndefOr[Boolean] = js.undefined,
    minCharacters: Int | Double = null,
    noResultsDescription: ReactNode = null,
    noResultsMessage: ReactNode = null,
    onBlur: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ SearchProps) => Unit = null,
    onFocus: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ SearchProps) => Unit = null,
    onMouseDown: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ SearchProps) => Unit = null,
    onResultSelect: (/* event */ MouseEvent[HTMLDivElement, NativeMouseEvent], /* data */ SearchResultData) => Unit = null,
    onSearchChange: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ SearchProps) => Unit = null,
    onSelectionChange: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ SearchResultData) => Unit = null,
    open: js.UndefOr[Boolean] = js.undefined,
    resultRenderer: /* props */ SearchResultProps => ReactElement = null,
    results: js.Array[_] | (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Object */ js.Any) = null,
    selectFirstResult: js.UndefOr[Boolean] = js.undefined,
    showNoResults: js.UndefOr[Boolean] = js.undefined,
    size: mini | tiny | small | large | big | huge | massive = null,
    value: String = null
  ): SearchProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (aligned != null) __obj.updateDynamic("aligned")(aligned)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(category)) __obj.updateDynamic("category")(category)
    if (categoryRenderer != null) __obj.updateDynamic("categoryRenderer")(js.Any.fromFunction1(categoryRenderer))
    if (className != null) __obj.updateDynamic("className")(className)
    if (!js.isUndefined(defaultOpen)) __obj.updateDynamic("defaultOpen")(defaultOpen)
    if (defaultValue != null) __obj.updateDynamic("defaultValue")(defaultValue)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (icon != null) __obj.updateDynamic("icon")(icon)
    if (input != null) __obj.updateDynamic("input")(input.asInstanceOf[js.Any])
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (minCharacters != null) __obj.updateDynamic("minCharacters")(minCharacters.asInstanceOf[js.Any])
    if (noResultsDescription != null) __obj.updateDynamic("noResultsDescription")(noResultsDescription.asInstanceOf[js.Any])
    if (noResultsMessage != null) __obj.updateDynamic("noResultsMessage")(noResultsMessage.asInstanceOf[js.Any])
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction2(onBlur))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction2(onFocus))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction2(onMouseDown))
    if (onResultSelect != null) __obj.updateDynamic("onResultSelect")(js.Any.fromFunction2(onResultSelect))
    if (onSearchChange != null) __obj.updateDynamic("onSearchChange")(js.Any.fromFunction2(onSearchChange))
    if (onSelectionChange != null) __obj.updateDynamic("onSelectionChange")(js.Any.fromFunction2(onSelectionChange))
    if (!js.isUndefined(open)) __obj.updateDynamic("open")(open)
    if (resultRenderer != null) __obj.updateDynamic("resultRenderer")(js.Any.fromFunction1(resultRenderer))
    if (results != null) __obj.updateDynamic("results")(results.asInstanceOf[js.Any])
    if (!js.isUndefined(selectFirstResult)) __obj.updateDynamic("selectFirstResult")(selectFirstResult)
    if (!js.isUndefined(showNoResults)) __obj.updateDynamic("showNoResults")(showNoResults)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (value != null) __obj.updateDynamic("value")(value)
    __obj.asInstanceOf[SearchProps]
  }
}


package typings.semanticDashUiDashReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.NativeMouseEvent
import typings.react.reactMod.KeyboardEvent
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.ReactNode
import typings.react.reactMod.SyntheticEvent
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`bottom left`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`bottom right`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`top left`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`top right`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.left
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.right
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typings.semanticDashUiDashReact.srcElementsLabelLabelMod.LabelProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownItemMod.DropdownItemProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownMod.DropdownOnSearchChangeData
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownMod.DropdownProps
import typings.semanticDashUiDashReact.srcModulesDropdownMod.default
import typings.std.Event
import typings.std.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, defaultValue, direction, disabled, multiple, open, placeholder, value */
object Dropdown
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticDashUiDashReact.srcModulesDropdownMod.default].asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    additionLabel: Double | String | ReactNode = null,
    additionPosition: top | bottom = null,
    allowAdditions: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    button: js.UndefOr[Boolean] = js.undefined,
    clearable: js.UndefOr[Boolean] = js.undefined,
    closeOnBlur: js.UndefOr[Boolean] = js.undefined,
    closeOnChange: js.UndefOr[Boolean] = js.undefined,
    closeOnEscape: js.UndefOr[Boolean] = js.undefined,
    compact: js.UndefOr[Boolean] = js.undefined,
    deburr: js.UndefOr[Boolean] = js.undefined,
    defaultOpen: js.UndefOr[Boolean] = js.undefined,
    defaultSearchQuery: String = null,
    defaultSelectedLabel: Double | String = null,
    defaultUpward: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    floating: js.UndefOr[Boolean] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    header: ReactNode = null,
    icon: js.Any = null,
    `inline`: js.UndefOr[Boolean] = js.undefined,
    item: js.UndefOr[Boolean] = js.undefined,
    labeled: js.UndefOr[Boolean] = js.undefined,
    lazyLoad: js.UndefOr[Boolean] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    minCharacters: Int | Double = null,
    noResultsMessage: ReactNode = null,
    onAddItem: (/* event */ KeyboardEvent[HTMLElement], /* data */ DropdownProps) => Unit = null,
    onBlur: (/* event */ KeyboardEvent[HTMLElement], /* data */ DropdownProps) => Unit = null,
    onChange: (/* event */ SyntheticEvent[HTMLElement, Event], /* data */ DropdownProps) => Unit = null,
    onClick: (/* event */ KeyboardEvent[HTMLElement], /* data */ DropdownProps) => Unit = null,
    onClose: (/* event */ SyntheticEvent[HTMLElement, Event], /* data */ DropdownProps) => Unit = null,
    onFocus: (/* event */ SyntheticEvent[HTMLElement, Event], /* data */ DropdownProps) => Unit = null,
    onLabelClick: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ LabelProps) => Unit = null,
    onMouseDown: (/* event */ MouseEvent[HTMLElement, NativeMouseEvent], /* data */ DropdownProps) => Unit = null,
    onOpen: (/* event */ SyntheticEvent[HTMLElement, Event], /* data */ DropdownProps) => Unit = null,
    onSearchChange: (/* event */ SyntheticEvent[HTMLElement, Event], /* data */ DropdownOnSearchChangeData) => Unit = null,
    openOnFocus: js.UndefOr[Boolean] = js.undefined,
    options: js.Array[DropdownItemProps] = null,
    pointing: Boolean | left | right | top | (`top left`) | (`top right`) | bottom | (`bottom left`) | (`bottom right`) = null,
    renderLabel: (/* item */ DropdownItemProps, /* index */ Double, /* defaultLabelProps */ LabelProps) => _ = null,
    scrolling: js.UndefOr[Boolean] = js.undefined,
    search: Boolean | (js.Function2[
      /* options */ js.Array[DropdownItemProps], 
      /* value */ String, 
      js.Array[DropdownItemProps]
    ]) = null,
    searchInput: js.Any = null,
    searchQuery: String = null,
    selectOnBlur: js.UndefOr[Boolean] = js.undefined,
    selectOnNavigation: js.UndefOr[Boolean] = js.undefined,
    selectedLabel: Double | String = null,
    selection: js.Any = null,
    simple: js.UndefOr[Boolean] = js.undefined,
    tabIndex: Double | String = null,
    text: String = null,
    trigger: ReactNode = null,
    upward: js.UndefOr[Boolean] = js.undefined,
    wrapSelection: js.UndefOr[Boolean] = js.undefined
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (additionLabel != null) __obj.updateDynamic("additionLabel")(additionLabel.asInstanceOf[js.Any])
    if (additionPosition != null) __obj.updateDynamic("additionPosition")(additionPosition.asInstanceOf[js.Any])
    if (!js.isUndefined(allowAdditions)) __obj.updateDynamic("allowAdditions")(allowAdditions)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (!js.isUndefined(button)) __obj.updateDynamic("button")(button)
    if (!js.isUndefined(clearable)) __obj.updateDynamic("clearable")(clearable)
    if (!js.isUndefined(closeOnBlur)) __obj.updateDynamic("closeOnBlur")(closeOnBlur)
    if (!js.isUndefined(closeOnChange)) __obj.updateDynamic("closeOnChange")(closeOnChange)
    if (!js.isUndefined(closeOnEscape)) __obj.updateDynamic("closeOnEscape")(closeOnEscape)
    if (!js.isUndefined(compact)) __obj.updateDynamic("compact")(compact)
    if (!js.isUndefined(deburr)) __obj.updateDynamic("deburr")(deburr)
    if (!js.isUndefined(defaultOpen)) __obj.updateDynamic("defaultOpen")(defaultOpen)
    if (defaultSearchQuery != null) __obj.updateDynamic("defaultSearchQuery")(defaultSearchQuery)
    if (defaultSelectedLabel != null) __obj.updateDynamic("defaultSelectedLabel")(defaultSelectedLabel.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultUpward)) __obj.updateDynamic("defaultUpward")(defaultUpward)
    if (!js.isUndefined(error)) __obj.updateDynamic("error")(error)
    if (!js.isUndefined(floating)) __obj.updateDynamic("floating")(floating)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (header != null) __obj.updateDynamic("header")(header.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon)
    if (!js.isUndefined(`inline`)) __obj.updateDynamic("inline")(`inline`)
    if (!js.isUndefined(item)) __obj.updateDynamic("item")(item)
    if (!js.isUndefined(labeled)) __obj.updateDynamic("labeled")(labeled)
    if (!js.isUndefined(lazyLoad)) __obj.updateDynamic("lazyLoad")(lazyLoad)
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (minCharacters != null) __obj.updateDynamic("minCharacters")(minCharacters.asInstanceOf[js.Any])
    if (noResultsMessage != null) __obj.updateDynamic("noResultsMessage")(noResultsMessage.asInstanceOf[js.Any])
    if (onAddItem != null) __obj.updateDynamic("onAddItem")(js.Any.fromFunction2(onAddItem))
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction2(onBlur))
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction2(onChange))
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
    if (onClose != null) __obj.updateDynamic("onClose")(js.Any.fromFunction2(onClose))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction2(onFocus))
    if (onLabelClick != null) __obj.updateDynamic("onLabelClick")(js.Any.fromFunction2(onLabelClick))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction2(onMouseDown))
    if (onOpen != null) __obj.updateDynamic("onOpen")(js.Any.fromFunction2(onOpen))
    if (onSearchChange != null) __obj.updateDynamic("onSearchChange")(js.Any.fromFunction2(onSearchChange))
    if (!js.isUndefined(openOnFocus)) __obj.updateDynamic("openOnFocus")(openOnFocus)
    if (options != null) __obj.updateDynamic("options")(options)
    if (pointing != null) __obj.updateDynamic("pointing")(pointing.asInstanceOf[js.Any])
    if (renderLabel != null) __obj.updateDynamic("renderLabel")(js.Any.fromFunction3(renderLabel))
    if (!js.isUndefined(scrolling)) __obj.updateDynamic("scrolling")(scrolling)
    if (search != null) __obj.updateDynamic("search")(search.asInstanceOf[js.Any])
    if (searchInput != null) __obj.updateDynamic("searchInput")(searchInput)
    if (searchQuery != null) __obj.updateDynamic("searchQuery")(searchQuery)
    if (!js.isUndefined(selectOnBlur)) __obj.updateDynamic("selectOnBlur")(selectOnBlur)
    if (!js.isUndefined(selectOnNavigation)) __obj.updateDynamic("selectOnNavigation")(selectOnNavigation)
    if (selectedLabel != null) __obj.updateDynamic("selectedLabel")(selectedLabel.asInstanceOf[js.Any])
    if (selection != null) __obj.updateDynamic("selection")(selection)
    if (!js.isUndefined(simple)) __obj.updateDynamic("simple")(simple)
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (text != null) __obj.updateDynamic("text")(text)
    if (trigger != null) __obj.updateDynamic("trigger")(trigger.asInstanceOf[js.Any])
    if (!js.isUndefined(upward)) __obj.updateDynamic("upward")(upward)
    if (!js.isUndefined(wrapSelection)) __obj.updateDynamic("wrapSelection")(wrapSelection)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = DropdownProps
}

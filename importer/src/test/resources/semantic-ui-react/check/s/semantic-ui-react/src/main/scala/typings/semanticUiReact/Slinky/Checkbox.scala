package typings.semanticUiReact.Slinky

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.NativeMouseEvent
import typings.react.reactMod.FormEvent
import typings.react.reactMod.MouseEvent
import typings.semanticUiReact.genericMod.HtmlLabelProps
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesCheckboxCheckboxMod.CheckboxProps
import typings.semanticUiReact.modulesCheckboxMod.default
import typings.semanticUiReact.semanticUiReactStrings.checkbox
import typings.semanticUiReact.semanticUiReactStrings.radio
import typings.std.HTMLInputElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: about, accept, accessKey, alt, aria-activedescendant, aria-atomic, aria-autocomplete, aria-busy, aria-checked, aria-colcount, aria-colindex, aria-colspan, aria-controls, aria-current, aria-describedby, aria-details, aria-disabled, aria-dropeffect, aria-errormessage, aria-expanded, aria-flowto, aria-grabbed, aria-haspopup, aria-hidden, aria-invalid, aria-keyshortcuts, aria-label, aria-labelledby, aria-level, aria-live, aria-modal, aria-multiline, aria-multiselectable, aria-orientation, aria-owns, aria-placeholder, aria-posinset, aria-pressed, aria-readonly, aria-relevant, aria-required, aria-roledescription, aria-rowcount, aria-rowindex, aria-rowspan, aria-selected, aria-setsize, aria-sort, aria-valuemax, aria-valuemin, aria-valuenow, aria-valuetext, autoCapitalize, autoComplete, autoCorrect, autoFocus, autoSave, capture, checked, children, className, color, contentEditable, contextMenu, crossOrigin, dangerouslySetInnerHTML, datatype, defaultChecked, defaultValue, dir, disabled, draggable, form, formAction, formEncType, formMethod, formNoValidate, formTarget, height, hidden, id, inlist, inputMode, is, itemID, itemProp, itemRef, itemScope, itemType, lang, list, max, maxLength, min, minLength, multiple, name, onAbort, onAnimationEnd, onAnimationIteration, onAnimationStart, onAuxClick, onBeforeInput, onBlur, onCanPlay, onCanPlayThrough, onChange, onChange, onClick, onCompositionEnd, onCompositionStart, onCompositionUpdate, onContextMenu, onCopy, onCut, onDoubleClick, onDrag, onDragEnd, onDragEnter, onDragExit, onDragLeave, onDragOver, onDragStart, onDrop, onDurationChange, onEmptied, onEncrypted, onEnded, onError, onFocus, onInput, onInvalid, onKeyDown, onKeyPress, onKeyUp, onLoad, onLoadStart, onLoadedData, onLoadedMetadata, onMouseDown, onMouseEnter, onMouseLeave, onMouseMove, onMouseOut, onMouseOver, onMouseUp, onPaste, onPause, onPlay, onPlaying, onPointerCancel, onPointerDown, onPointerEnter, onPointerLeave, onPointerMove, onPointerOut, onPointerOver, onPointerUp, onProgress, onRateChange, onReset, onScroll, onSeeked, onSeeking, onSelect, onStalled, onSubmit, onSuspend, onTimeUpdate, onTouchCancel, onTouchEnd, onTouchMove, onTouchStart, onTransitionEnd, onVolumeChange, onWaiting, onWheel, pattern, placeholder, prefix, property, radioGroup, readOnly, required, resource, results, role, security, size, slot, spellCheck, src, step, style, suppressContentEditableWarning, suppressHydrationWarning, tabIndex, title, type, typeof, unselectable, value, value, vocab, width */
object Checkbox
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticUiReact.modulesCheckboxMod.default].asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    defaultIndeterminate: js.UndefOr[Boolean] = js.undefined,
    fitted: js.UndefOr[Boolean] = js.undefined,
    id: Double | String = null,
    indeterminate: js.UndefOr[Boolean] = js.undefined,
    label: SemanticShorthandItem[HtmlLabelProps] = null,
    onChange: (/* event */ FormEvent[HTMLInputElement], /* data */ CheckboxProps) => Unit = null,
    onClick: (/* event */ MouseEvent[HTMLInputElement, NativeMouseEvent], /* data */ CheckboxProps) => Unit = null,
    onMouseDown: (/* event */ MouseEvent[HTMLInputElement, NativeMouseEvent], /* data */ CheckboxProps) => Unit = null,
    onMouseUp: (/* event */ MouseEvent[HTMLInputElement, NativeMouseEvent], /* data */ CheckboxProps) => Unit = null,
    radio: js.UndefOr[Boolean] = js.undefined,
    slider: js.UndefOr[Boolean] = js.undefined,
    tabIndex: Double | String = null,
    toggle: js.UndefOr[Boolean] = js.undefined,
    `type`: checkbox | radio = null
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(defaultIndeterminate)) __obj.updateDynamic("defaultIndeterminate")(defaultIndeterminate)
    if (!js.isUndefined(fitted)) __obj.updateDynamic("fitted")(fitted)
    if (id != null) __obj.updateDynamic("id")(id.asInstanceOf[js.Any])
    if (!js.isUndefined(indeterminate)) __obj.updateDynamic("indeterminate")(indeterminate)
    if (label != null) __obj.updateDynamic("label")(label.asInstanceOf[js.Any])
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction2(onChange))
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction2(onMouseDown))
    if (onMouseUp != null) __obj.updateDynamic("onMouseUp")(js.Any.fromFunction2(onMouseUp))
    if (!js.isUndefined(radio)) __obj.updateDynamic("radio")(radio)
    if (!js.isUndefined(slider)) __obj.updateDynamic("slider")(slider)
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(toggle)) __obj.updateDynamic("toggle")(toggle)
    if (`type` != null) __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = CheckboxProps
}


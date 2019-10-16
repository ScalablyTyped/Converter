package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactAnimationEventFrom
import japgolly.scalajs.react.ReactClipboardEventFrom
import japgolly.scalajs.react.ReactCompositionEventFrom
import japgolly.scalajs.react.ReactDragEventFrom
import japgolly.scalajs.react.ReactFocusEventFrom
import japgolly.scalajs.react.ReactKeyboardEventFrom
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.ReactPointerEventFrom
import japgolly.scalajs.react.ReactTouchEventFrom
import japgolly.scalajs.react.ReactTransitionEventFrom
import japgolly.scalajs.react.ReactUIEventFrom
import japgolly.scalajs.react.ReactWheelEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.raw.SyntheticEvent
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLInputElement
import typings.react.Anon_Html
import typings.react.reactMod.CSSProperties
import typings.react.reactMod.FormEvent
import typings.react.reactStrings.`additions text`
import typings.react.reactStrings.`inline`
import typings.react.reactStrings.additions
import typings.react.reactStrings.all
import typings.react.reactStrings.ascending
import typings.react.reactStrings.assertive
import typings.react.reactStrings.both
import typings.react.reactStrings.copy
import typings.react.reactStrings.date
import typings.react.reactStrings.descending
import typings.react.reactStrings.dialog
import typings.react.reactStrings.execute
import typings.react.reactStrings.grammar
import typings.react.reactStrings.grid
import typings.react.reactStrings.horizontal
import typings.react.reactStrings.link
import typings.react.reactStrings.list
import typings.react.reactStrings.listbox
import typings.react.reactStrings.location
import typings.react.reactStrings.menu
import typings.react.reactStrings.mixed
import typings.react.reactStrings.move
import typings.react.reactStrings.none
import typings.react.reactStrings.off
import typings.react.reactStrings.on
import typings.react.reactStrings.other
import typings.react.reactStrings.page
import typings.react.reactStrings.polite
import typings.react.reactStrings.popup
import typings.react.reactStrings.removals
import typings.react.reactStrings.spelling
import typings.react.reactStrings.step
import typings.react.reactStrings.text
import typings.react.reactStrings.time
import typings.react.reactStrings.tree
import typings.react.reactStrings.vertical
import typings.semanticUiReact.genericMod.HtmlLabelProps
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesCheckboxCheckboxMod.CheckboxProps
import typings.semanticUiReact.modulesCheckboxMod.default
import typings.semanticUiReact.semanticUiReactStrings.checkbox
import typings.semanticUiReact.semanticUiReactStrings.radio
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Checkbox {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    about: String = null,
    accept: String = null,
    accessKey: String = null,
    alt: String = null,
    `aria-activedescendant`: String = null,
    `aria-atomic`: js.UndefOr[Boolean] = js.undefined,
    `aria-autocomplete`: none | `inline` | list | both = null,
    `aria-busy`: js.UndefOr[Boolean] = js.undefined,
    `aria-checked`: Boolean | mixed = null,
    `aria-colcount`: Int | Double = null,
    `aria-colindex`: Int | Double = null,
    `aria-colspan`: Int | Double = null,
    `aria-controls`: String = null,
    `aria-current`: Boolean | page | step | location | date | time = null,
    `aria-describedby`: String = null,
    `aria-details`: String = null,
    `aria-disabled`: js.UndefOr[Boolean] = js.undefined,
    `aria-dropeffect`: none | copy | execute | link | move | popup = null,
    `aria-errormessage`: String = null,
    `aria-expanded`: js.UndefOr[Boolean] = js.undefined,
    `aria-flowto`: String = null,
    `aria-grabbed`: js.UndefOr[Boolean] = js.undefined,
    `aria-haspopup`: Boolean | menu | listbox | tree | grid | dialog = null,
    `aria-hidden`: js.UndefOr[Boolean] = js.undefined,
    `aria-invalid`: Boolean | grammar | spelling = null,
    `aria-keyshortcuts`: String = null,
    `aria-label`: String = null,
    `aria-labelledby`: String = null,
    `aria-level`: Int | Double = null,
    `aria-live`: off | assertive | polite = null,
    `aria-modal`: js.UndefOr[Boolean] = js.undefined,
    `aria-multiline`: js.UndefOr[Boolean] = js.undefined,
    `aria-multiselectable`: js.UndefOr[Boolean] = js.undefined,
    `aria-orientation`: horizontal | vertical = null,
    `aria-owns`: String = null,
    `aria-placeholder`: String = null,
    `aria-posinset`: Int | Double = null,
    `aria-pressed`: Boolean | mixed = null,
    `aria-readonly`: js.UndefOr[Boolean] = js.undefined,
    `aria-relevant`: additions | (`additions text`) | all | removals | text = null,
    `aria-required`: js.UndefOr[Boolean] = js.undefined,
    `aria-roledescription`: String = null,
    `aria-rowcount`: Int | Double = null,
    `aria-rowindex`: Int | Double = null,
    `aria-rowspan`: Int | Double = null,
    `aria-selected`: js.UndefOr[Boolean] = js.undefined,
    `aria-setsize`: Int | Double = null,
    `aria-sort`: none | ascending | descending | other = null,
    `aria-valuemax`: Int | Double = null,
    `aria-valuemin`: Int | Double = null,
    `aria-valuenow`: Int | Double = null,
    `aria-valuetext`: String = null,
    as: js.Any = null,
    autoCapitalize: String = null,
    autoComplete: String = null,
    autoCorrect: String = null,
    autoFocus: js.UndefOr[Boolean] = js.undefined,
    autoSave: String = null,
    capture: Boolean | String = null,
    checked: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    color: String = null,
    contentEditable: js.UndefOr[Boolean] = js.undefined,
    contextMenu: String = null,
    crossOrigin: String = null,
    dangerouslySetInnerHTML: Anon_Html = null,
    datatype: String = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined,
    defaultIndeterminate: js.UndefOr[Boolean] = js.undefined,
    defaultValue: String | js.Array[String] = null,
    dir: String = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    draggable: js.UndefOr[Boolean] = js.undefined,
    fitted: js.UndefOr[Boolean] = js.undefined,
    form: String = null,
    formAction: String = null,
    formEncType: String = null,
    formMethod: String = null,
    formNoValidate: js.UndefOr[Boolean] = js.undefined,
    formTarget: String = null,
    height: Double | String = null,
    hidden: js.UndefOr[Boolean] = js.undefined,
    id: Double | String = null,
    indeterminate: js.UndefOr[Boolean] = js.undefined,
    inlist: js.Any = null,
    inputMode: String = null,
    is: String = null,
    itemID: String = null,
    itemProp: String = null,
    itemRef: String = null,
    itemScope: js.UndefOr[Boolean] = js.undefined,
    itemType: String = null,
    label: SemanticShorthandItem[HtmlLabelProps] = null,
    lang: String = null,
    list: String = null,
    max: Double | String = null,
    maxLength: Int | Double = null,
    min: Double | String = null,
    minLength: Int | Double = null,
    multiple: js.UndefOr[Boolean] = js.undefined,
    name: String = null,
    onAbort: SyntheticEvent[HTMLInputElement] => Callback = null,
    onAnimationEnd: ReactAnimationEventFrom[HTMLInputElement] => Callback = null,
    onAnimationIteration: ReactAnimationEventFrom[HTMLInputElement] => Callback = null,
    onAnimationStart: ReactAnimationEventFrom[HTMLInputElement] => Callback = null,
    onAuxClick: ReactMouseEventFrom[HTMLInputElement] => Callback = null,
    onBeforeInput: FormEvent[HTMLInputElement] => Callback = null,
    onBlur: ReactFocusEventFrom[HTMLInputElement] => Callback = null,
    onCanPlay: SyntheticEvent[HTMLInputElement] => Callback = null,
    onCanPlayThrough: SyntheticEvent[HTMLInputElement] => Callback = null,
    onChange: (/* event */ FormEvent[HTMLInputElement], /* data */ CheckboxProps) => Callback = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLInputElement], /* data */ CheckboxProps) => Callback = null,
    onCompositionEnd: ReactCompositionEventFrom[HTMLInputElement] => Callback = null,
    onCompositionStart: ReactCompositionEventFrom[HTMLInputElement] => Callback = null,
    onCompositionUpdate: ReactCompositionEventFrom[HTMLInputElement] => Callback = null,
    onContextMenu: ReactMouseEventFrom[HTMLInputElement] => Callback = null,
    onCopy: ReactClipboardEventFrom[HTMLInputElement] => Callback = null,
    onCut: ReactClipboardEventFrom[HTMLInputElement] => Callback = null,
    onDoubleClick: ReactMouseEventFrom[HTMLInputElement] => Callback = null,
    onDrag: ReactDragEventFrom[HTMLInputElement] => Callback = null,
    onDragEnd: ReactDragEventFrom[HTMLInputElement] => Callback = null,
    onDragEnter: ReactDragEventFrom[HTMLInputElement] => Callback = null,
    onDragExit: ReactDragEventFrom[HTMLInputElement] => Callback = null,
    onDragLeave: ReactDragEventFrom[HTMLInputElement] => Callback = null,
    onDragOver: ReactDragEventFrom[HTMLInputElement] => Callback = null,
    onDragStart: ReactDragEventFrom[HTMLInputElement] => Callback = null,
    onDrop: ReactDragEventFrom[HTMLInputElement] => Callback = null,
    onDurationChange: SyntheticEvent[HTMLInputElement] => Callback = null,
    onEmptied: SyntheticEvent[HTMLInputElement] => Callback = null,
    onEncrypted: SyntheticEvent[HTMLInputElement] => Callback = null,
    onEnded: SyntheticEvent[HTMLInputElement] => Callback = null,
    onError: SyntheticEvent[HTMLInputElement] => Callback = null,
    onFocus: ReactFocusEventFrom[HTMLInputElement] => Callback = null,
    onInput: FormEvent[HTMLInputElement] => Callback = null,
    onInvalid: FormEvent[HTMLInputElement] => Callback = null,
    onKeyDown: ReactKeyboardEventFrom[HTMLInputElement] => Callback = null,
    onKeyPress: ReactKeyboardEventFrom[HTMLInputElement] => Callback = null,
    onKeyUp: ReactKeyboardEventFrom[HTMLInputElement] => Callback = null,
    onLoad: SyntheticEvent[HTMLInputElement] => Callback = null,
    onLoadStart: SyntheticEvent[HTMLInputElement] => Callback = null,
    onLoadedData: SyntheticEvent[HTMLInputElement] => Callback = null,
    onLoadedMetadata: SyntheticEvent[HTMLInputElement] => Callback = null,
    onMouseDown: (/* event */ ReactMouseEventFrom[HTMLInputElement], /* data */ CheckboxProps) => Callback = null,
    onMouseEnter: ReactMouseEventFrom[HTMLInputElement] => Callback = null,
    onMouseLeave: ReactMouseEventFrom[HTMLInputElement] => Callback = null,
    onMouseMove: ReactMouseEventFrom[HTMLInputElement] => Callback = null,
    onMouseOut: ReactMouseEventFrom[HTMLInputElement] => Callback = null,
    onMouseOver: ReactMouseEventFrom[HTMLInputElement] => Callback = null,
    onMouseUp: (/* event */ ReactMouseEventFrom[HTMLInputElement], /* data */ CheckboxProps) => Callback = null,
    onPaste: ReactClipboardEventFrom[HTMLInputElement] => Callback = null,
    onPause: SyntheticEvent[HTMLInputElement] => Callback = null,
    onPlay: SyntheticEvent[HTMLInputElement] => Callback = null,
    onPlaying: SyntheticEvent[HTMLInputElement] => Callback = null,
    onPointerCancel: ReactPointerEventFrom[HTMLInputElement] => Callback = null,
    onPointerDown: ReactPointerEventFrom[HTMLInputElement] => Callback = null,
    onPointerEnter: ReactPointerEventFrom[HTMLInputElement] => Callback = null,
    onPointerLeave: ReactPointerEventFrom[HTMLInputElement] => Callback = null,
    onPointerMove: ReactPointerEventFrom[HTMLInputElement] => Callback = null,
    onPointerOut: ReactPointerEventFrom[HTMLInputElement] => Callback = null,
    onPointerOver: ReactPointerEventFrom[HTMLInputElement] => Callback = null,
    onPointerUp: ReactPointerEventFrom[HTMLInputElement] => Callback = null,
    onProgress: SyntheticEvent[HTMLInputElement] => Callback = null,
    onRateChange: SyntheticEvent[HTMLInputElement] => Callback = null,
    onReset: FormEvent[HTMLInputElement] => Callback = null,
    onScroll: ReactUIEventFrom[HTMLInputElement] => Callback = null,
    onSeeked: SyntheticEvent[HTMLInputElement] => Callback = null,
    onSeeking: SyntheticEvent[HTMLInputElement] => Callback = null,
    onSelect: SyntheticEvent[HTMLInputElement] => Callback = null,
    onStalled: SyntheticEvent[HTMLInputElement] => Callback = null,
    onSubmit: FormEvent[HTMLInputElement] => Callback = null,
    onSuspend: SyntheticEvent[HTMLInputElement] => Callback = null,
    onTimeUpdate: SyntheticEvent[HTMLInputElement] => Callback = null,
    onTouchCancel: ReactTouchEventFrom[HTMLInputElement] => Callback = null,
    onTouchEnd: ReactTouchEventFrom[HTMLInputElement] => Callback = null,
    onTouchMove: ReactTouchEventFrom[HTMLInputElement] => Callback = null,
    onTouchStart: ReactTouchEventFrom[HTMLInputElement] => Callback = null,
    onTransitionEnd: ReactTransitionEventFrom[HTMLInputElement] => Callback = null,
    onVolumeChange: SyntheticEvent[HTMLInputElement] => Callback = null,
    onWaiting: SyntheticEvent[HTMLInputElement] => Callback = null,
    onWheel: ReactWheelEventFrom[HTMLInputElement] => Callback = null,
    pattern: String = null,
    placeholder: String = null,
    prefix: String = null,
    property: String = null,
    radio: js.UndefOr[Boolean] = js.undefined,
    radioGroup: String = null,
    readOnly: js.UndefOr[Boolean] = js.undefined,
    required: js.UndefOr[Boolean] = js.undefined,
    resource: String = null,
    results: Int | Double = null,
    role: String = null,
    security: String = null,
    size: Int | Double = null,
    slider: js.UndefOr[Boolean] = js.undefined,
    slot: String = null,
    spellCheck: js.UndefOr[Boolean] = js.undefined,
    src: String = null,
    step: Double | String = null,
    style: CSSProperties = null,
    suppressContentEditableWarning: js.UndefOr[Boolean] = js.undefined,
    suppressHydrationWarning: js.UndefOr[Boolean] = js.undefined,
    tabIndex: Double | String = null,
    title: String = null,
    toggle: js.UndefOr[Boolean] = js.undefined,
    `type`: checkbox | radio = null,
    typeof: String = null,
    unselectable: on | off = null,
    value: Double | String = null,
    vocab: String = null,
    width: Double | String = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[CheckboxProps, default, Unit, CheckboxProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (about != null) __obj.updateDynamic("about")(about)
    if (accept != null) __obj.updateDynamic("accept")(accept)
    if (accessKey != null) __obj.updateDynamic("accessKey")(accessKey)
    if (alt != null) __obj.updateDynamic("alt")(alt)
    if (`aria-activedescendant` != null) __obj.updateDynamic("aria-activedescendant")(`aria-activedescendant`)
    if (!js.isUndefined(`aria-atomic`)) __obj.updateDynamic("aria-atomic")(`aria-atomic`)
    if (`aria-autocomplete` != null) __obj.updateDynamic("aria-autocomplete")(`aria-autocomplete`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-busy`)) __obj.updateDynamic("aria-busy")(`aria-busy`)
    if (`aria-checked` != null) __obj.updateDynamic("aria-checked")(`aria-checked`.asInstanceOf[js.Any])
    if (`aria-colcount` != null) __obj.updateDynamic("aria-colcount")(`aria-colcount`.asInstanceOf[js.Any])
    if (`aria-colindex` != null) __obj.updateDynamic("aria-colindex")(`aria-colindex`.asInstanceOf[js.Any])
    if (`aria-colspan` != null) __obj.updateDynamic("aria-colspan")(`aria-colspan`.asInstanceOf[js.Any])
    if (`aria-controls` != null) __obj.updateDynamic("aria-controls")(`aria-controls`)
    if (`aria-current` != null) __obj.updateDynamic("aria-current")(`aria-current`.asInstanceOf[js.Any])
    if (`aria-describedby` != null) __obj.updateDynamic("aria-describedby")(`aria-describedby`)
    if (`aria-details` != null) __obj.updateDynamic("aria-details")(`aria-details`)
    if (!js.isUndefined(`aria-disabled`)) __obj.updateDynamic("aria-disabled")(`aria-disabled`)
    if (`aria-dropeffect` != null) __obj.updateDynamic("aria-dropeffect")(`aria-dropeffect`.asInstanceOf[js.Any])
    if (`aria-errormessage` != null) __obj.updateDynamic("aria-errormessage")(`aria-errormessage`)
    if (!js.isUndefined(`aria-expanded`)) __obj.updateDynamic("aria-expanded")(`aria-expanded`)
    if (`aria-flowto` != null) __obj.updateDynamic("aria-flowto")(`aria-flowto`)
    if (!js.isUndefined(`aria-grabbed`)) __obj.updateDynamic("aria-grabbed")(`aria-grabbed`)
    if (`aria-haspopup` != null) __obj.updateDynamic("aria-haspopup")(`aria-haspopup`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-hidden`)) __obj.updateDynamic("aria-hidden")(`aria-hidden`)
    if (`aria-invalid` != null) __obj.updateDynamic("aria-invalid")(`aria-invalid`.asInstanceOf[js.Any])
    if (`aria-keyshortcuts` != null) __obj.updateDynamic("aria-keyshortcuts")(`aria-keyshortcuts`)
    if (`aria-label` != null) __obj.updateDynamic("aria-label")(`aria-label`)
    if (`aria-labelledby` != null) __obj.updateDynamic("aria-labelledby")(`aria-labelledby`)
    if (`aria-level` != null) __obj.updateDynamic("aria-level")(`aria-level`.asInstanceOf[js.Any])
    if (`aria-live` != null) __obj.updateDynamic("aria-live")(`aria-live`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-modal`)) __obj.updateDynamic("aria-modal")(`aria-modal`)
    if (!js.isUndefined(`aria-multiline`)) __obj.updateDynamic("aria-multiline")(`aria-multiline`)
    if (!js.isUndefined(`aria-multiselectable`)) __obj.updateDynamic("aria-multiselectable")(`aria-multiselectable`)
    if (`aria-orientation` != null) __obj.updateDynamic("aria-orientation")(`aria-orientation`.asInstanceOf[js.Any])
    if (`aria-owns` != null) __obj.updateDynamic("aria-owns")(`aria-owns`)
    if (`aria-placeholder` != null) __obj.updateDynamic("aria-placeholder")(`aria-placeholder`)
    if (`aria-posinset` != null) __obj.updateDynamic("aria-posinset")(`aria-posinset`.asInstanceOf[js.Any])
    if (`aria-pressed` != null) __obj.updateDynamic("aria-pressed")(`aria-pressed`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-readonly`)) __obj.updateDynamic("aria-readonly")(`aria-readonly`)
    if (`aria-relevant` != null) __obj.updateDynamic("aria-relevant")(`aria-relevant`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-required`)) __obj.updateDynamic("aria-required")(`aria-required`)
    if (`aria-roledescription` != null) __obj.updateDynamic("aria-roledescription")(`aria-roledescription`)
    if (`aria-rowcount` != null) __obj.updateDynamic("aria-rowcount")(`aria-rowcount`.asInstanceOf[js.Any])
    if (`aria-rowindex` != null) __obj.updateDynamic("aria-rowindex")(`aria-rowindex`.asInstanceOf[js.Any])
    if (`aria-rowspan` != null) __obj.updateDynamic("aria-rowspan")(`aria-rowspan`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-selected`)) __obj.updateDynamic("aria-selected")(`aria-selected`)
    if (`aria-setsize` != null) __obj.updateDynamic("aria-setsize")(`aria-setsize`.asInstanceOf[js.Any])
    if (`aria-sort` != null) __obj.updateDynamic("aria-sort")(`aria-sort`.asInstanceOf[js.Any])
    if (`aria-valuemax` != null) __obj.updateDynamic("aria-valuemax")(`aria-valuemax`.asInstanceOf[js.Any])
    if (`aria-valuemin` != null) __obj.updateDynamic("aria-valuemin")(`aria-valuemin`.asInstanceOf[js.Any])
    if (`aria-valuenow` != null) __obj.updateDynamic("aria-valuenow")(`aria-valuenow`.asInstanceOf[js.Any])
    if (`aria-valuetext` != null) __obj.updateDynamic("aria-valuetext")(`aria-valuetext`)
    if (as != null) __obj.updateDynamic("as")(as)
    if (autoCapitalize != null) __obj.updateDynamic("autoCapitalize")(autoCapitalize)
    if (autoComplete != null) __obj.updateDynamic("autoComplete")(autoComplete)
    if (autoCorrect != null) __obj.updateDynamic("autoCorrect")(autoCorrect)
    if (!js.isUndefined(autoFocus)) __obj.updateDynamic("autoFocus")(autoFocus)
    if (autoSave != null) __obj.updateDynamic("autoSave")(autoSave)
    if (capture != null) __obj.updateDynamic("capture")(capture.asInstanceOf[js.Any])
    if (!js.isUndefined(checked)) __obj.updateDynamic("checked")(checked)
    if (className != null) __obj.updateDynamic("className")(className)
    if (color != null) __obj.updateDynamic("color")(color)
    if (!js.isUndefined(contentEditable)) __obj.updateDynamic("contentEditable")(contentEditable)
    if (contextMenu != null) __obj.updateDynamic("contextMenu")(contextMenu)
    if (crossOrigin != null) __obj.updateDynamic("crossOrigin")(crossOrigin)
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    if (datatype != null) __obj.updateDynamic("datatype")(datatype)
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked)
    if (!js.isUndefined(defaultIndeterminate)) __obj.updateDynamic("defaultIndeterminate")(defaultIndeterminate)
    if (defaultValue != null) __obj.updateDynamic("defaultValue")(defaultValue.asInstanceOf[js.Any])
    if (dir != null) __obj.updateDynamic("dir")(dir)
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(draggable)) __obj.updateDynamic("draggable")(draggable)
    if (!js.isUndefined(fitted)) __obj.updateDynamic("fitted")(fitted)
    if (form != null) __obj.updateDynamic("form")(form)
    if (formAction != null) __obj.updateDynamic("formAction")(formAction)
    if (formEncType != null) __obj.updateDynamic("formEncType")(formEncType)
    if (formMethod != null) __obj.updateDynamic("formMethod")(formMethod)
    if (!js.isUndefined(formNoValidate)) __obj.updateDynamic("formNoValidate")(formNoValidate)
    if (formTarget != null) __obj.updateDynamic("formTarget")(formTarget)
    if (height != null) __obj.updateDynamic("height")(height.asInstanceOf[js.Any])
    if (!js.isUndefined(hidden)) __obj.updateDynamic("hidden")(hidden)
    if (id != null) __obj.updateDynamic("id")(id.asInstanceOf[js.Any])
    if (!js.isUndefined(indeterminate)) __obj.updateDynamic("indeterminate")(indeterminate)
    if (inlist != null) __obj.updateDynamic("inlist")(inlist)
    if (inputMode != null) __obj.updateDynamic("inputMode")(inputMode)
    if (is != null) __obj.updateDynamic("is")(is)
    if (itemID != null) __obj.updateDynamic("itemID")(itemID)
    if (itemProp != null) __obj.updateDynamic("itemProp")(itemProp)
    if (itemRef != null) __obj.updateDynamic("itemRef")(itemRef)
    if (!js.isUndefined(itemScope)) __obj.updateDynamic("itemScope")(itemScope)
    if (itemType != null) __obj.updateDynamic("itemType")(itemType)
    if (label != null) __obj.updateDynamic("label")(label.asInstanceOf[js.Any])
    if (lang != null) __obj.updateDynamic("lang")(lang)
    if (list != null) __obj.updateDynamic("list")(list)
    if (max != null) __obj.updateDynamic("max")(max.asInstanceOf[js.Any])
    if (maxLength != null) __obj.updateDynamic("maxLength")(maxLength.asInstanceOf[js.Any])
    if (min != null) __obj.updateDynamic("min")(min.asInstanceOf[js.Any])
    if (minLength != null) __obj.updateDynamic("minLength")(minLength.asInstanceOf[js.Any])
    if (!js.isUndefined(multiple)) __obj.updateDynamic("multiple")(multiple)
    if (name != null) __obj.updateDynamic("name")(name)
    if (onAbort != null) __obj.updateDynamic("onAbort")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onAbort(t0).runNow())))
    if (onAnimationEnd != null) __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onAnimationEnd(t0).runNow())))
    if (onAnimationIteration != null) __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onAnimationIteration(t0).runNow())))
    if (onAnimationStart != null) __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onAnimationStart(t0).runNow())))
    if (onAuxClick != null) __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onAuxClick(t0).runNow())))
    if (onBeforeInput != null) __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1(((t0: typings.react.reactMod.FormEvent[org.scalajs.dom.raw.HTMLInputElement]) => onBeforeInput(t0).runNow())))
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactFocusEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onBlur(t0).runNow())))
    if (onCanPlay != null) __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onCanPlay(t0).runNow())))
    if (onCanPlayThrough != null) __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onCanPlayThrough(t0).runNow())))
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction2(((t0: /* event */ typings.react.reactMod.FormEvent[org.scalajs.dom.raw.HTMLInputElement], t1: /* data */ typings.semanticUiReact.modulesCheckboxCheckboxMod.CheckboxProps) => onChange(t0, t1).runNow())))
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement], t1: /* data */ typings.semanticUiReact.modulesCheckboxCheckboxMod.CheckboxProps) => onClick(t0, t1).runNow())))
    if (onCompositionEnd != null) __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onCompositionEnd(t0).runNow())))
    if (onCompositionStart != null) __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onCompositionStart(t0).runNow())))
    if (onCompositionUpdate != null) __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onCompositionUpdate(t0).runNow())))
    if (onContextMenu != null) __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onContextMenu(t0).runNow())))
    if (onCopy != null) __obj.updateDynamic("onCopy")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onCopy(t0).runNow())))
    if (onCut != null) __obj.updateDynamic("onCut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onCut(t0).runNow())))
    if (onDoubleClick != null) __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onDoubleClick(t0).runNow())))
    if (onDrag != null) __obj.updateDynamic("onDrag")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onDrag(t0).runNow())))
    if (onDragEnd != null) __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onDragEnd(t0).runNow())))
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onDragEnter(t0).runNow())))
    if (onDragExit != null) __obj.updateDynamic("onDragExit")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onDragExit(t0).runNow())))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onDragLeave(t0).runNow())))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onDragOver(t0).runNow())))
    if (onDragStart != null) __obj.updateDynamic("onDragStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onDragStart(t0).runNow())))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onDrop(t0).runNow())))
    if (onDurationChange != null) __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onDurationChange(t0).runNow())))
    if (onEmptied != null) __obj.updateDynamic("onEmptied")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onEmptied(t0).runNow())))
    if (onEncrypted != null) __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onEncrypted(t0).runNow())))
    if (onEnded != null) __obj.updateDynamic("onEnded")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onEnded(t0).runNow())))
    if (onError != null) __obj.updateDynamic("onError")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onError(t0).runNow())))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactFocusEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onFocus(t0).runNow())))
    if (onInput != null) __obj.updateDynamic("onInput")(js.Any.fromFunction1(((t0: typings.react.reactMod.FormEvent[org.scalajs.dom.raw.HTMLInputElement]) => onInput(t0).runNow())))
    if (onInvalid != null) __obj.updateDynamic("onInvalid")(js.Any.fromFunction1(((t0: typings.react.reactMod.FormEvent[org.scalajs.dom.raw.HTMLInputElement]) => onInvalid(t0).runNow())))
    if (onKeyDown != null) __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onKeyDown(t0).runNow())))
    if (onKeyPress != null) __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onKeyPress(t0).runNow())))
    if (onKeyUp != null) __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onKeyUp(t0).runNow())))
    if (onLoad != null) __obj.updateDynamic("onLoad")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onLoad(t0).runNow())))
    if (onLoadStart != null) __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onLoadStart(t0).runNow())))
    if (onLoadedData != null) __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onLoadedData(t0).runNow())))
    if (onLoadedMetadata != null) __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onLoadedMetadata(t0).runNow())))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement], t1: /* data */ typings.semanticUiReact.modulesCheckboxCheckboxMod.CheckboxProps) => onMouseDown(t0, t1).runNow())))
    if (onMouseEnter != null) __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onMouseEnter(t0).runNow())))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onMouseLeave(t0).runNow())))
    if (onMouseMove != null) __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onMouseMove(t0).runNow())))
    if (onMouseOut != null) __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onMouseOut(t0).runNow())))
    if (onMouseOver != null) __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onMouseOver(t0).runNow())))
    if (onMouseUp != null) __obj.updateDynamic("onMouseUp")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement], t1: /* data */ typings.semanticUiReact.modulesCheckboxCheckboxMod.CheckboxProps) => onMouseUp(t0, t1).runNow())))
    if (onPaste != null) __obj.updateDynamic("onPaste")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onPaste(t0).runNow())))
    if (onPause != null) __obj.updateDynamic("onPause")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onPause(t0).runNow())))
    if (onPlay != null) __obj.updateDynamic("onPlay")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onPlay(t0).runNow())))
    if (onPlaying != null) __obj.updateDynamic("onPlaying")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onPlaying(t0).runNow())))
    if (onPointerCancel != null) __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onPointerCancel(t0).runNow())))
    if (onPointerDown != null) __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onPointerDown(t0).runNow())))
    if (onPointerEnter != null) __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onPointerEnter(t0).runNow())))
    if (onPointerLeave != null) __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onPointerLeave(t0).runNow())))
    if (onPointerMove != null) __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onPointerMove(t0).runNow())))
    if (onPointerOut != null) __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onPointerOut(t0).runNow())))
    if (onPointerOver != null) __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onPointerOver(t0).runNow())))
    if (onPointerUp != null) __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onPointerUp(t0).runNow())))
    if (onProgress != null) __obj.updateDynamic("onProgress")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onProgress(t0).runNow())))
    if (onRateChange != null) __obj.updateDynamic("onRateChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onRateChange(t0).runNow())))
    if (onReset != null) __obj.updateDynamic("onReset")(js.Any.fromFunction1(((t0: typings.react.reactMod.FormEvent[org.scalajs.dom.raw.HTMLInputElement]) => onReset(t0).runNow())))
    if (onScroll != null) __obj.updateDynamic("onScroll")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactUIEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onScroll(t0).runNow())))
    if (onSeeked != null) __obj.updateDynamic("onSeeked")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onSeeked(t0).runNow())))
    if (onSeeking != null) __obj.updateDynamic("onSeeking")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onSeeking(t0).runNow())))
    if (onSelect != null) __obj.updateDynamic("onSelect")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onSelect(t0).runNow())))
    if (onStalled != null) __obj.updateDynamic("onStalled")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onStalled(t0).runNow())))
    if (onSubmit != null) __obj.updateDynamic("onSubmit")(js.Any.fromFunction1(((t0: typings.react.reactMod.FormEvent[org.scalajs.dom.raw.HTMLInputElement]) => onSubmit(t0).runNow())))
    if (onSuspend != null) __obj.updateDynamic("onSuspend")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onSuspend(t0).runNow())))
    if (onTimeUpdate != null) __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onTimeUpdate(t0).runNow())))
    if (onTouchCancel != null) __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onTouchCancel(t0).runNow())))
    if (onTouchEnd != null) __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onTouchEnd(t0).runNow())))
    if (onTouchMove != null) __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onTouchMove(t0).runNow())))
    if (onTouchStart != null) __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onTouchStart(t0).runNow())))
    if (onTransitionEnd != null) __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTransitionEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onTransitionEnd(t0).runNow())))
    if (onVolumeChange != null) __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onVolumeChange(t0).runNow())))
    if (onWaiting != null) __obj.updateDynamic("onWaiting")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.raw.SyntheticEvent[org.scalajs.dom.raw.HTMLInputElement]) => onWaiting(t0).runNow())))
    if (onWheel != null) __obj.updateDynamic("onWheel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactWheelEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => onWheel(t0).runNow())))
    if (pattern != null) __obj.updateDynamic("pattern")(pattern)
    if (placeholder != null) __obj.updateDynamic("placeholder")(placeholder)
    if (prefix != null) __obj.updateDynamic("prefix")(prefix)
    if (property != null) __obj.updateDynamic("property")(property)
    if (!js.isUndefined(radio)) __obj.updateDynamic("radio")(radio)
    if (radioGroup != null) __obj.updateDynamic("radioGroup")(radioGroup)
    if (!js.isUndefined(readOnly)) __obj.updateDynamic("readOnly")(readOnly)
    if (!js.isUndefined(required)) __obj.updateDynamic("required")(required)
    if (resource != null) __obj.updateDynamic("resource")(resource)
    if (results != null) __obj.updateDynamic("results")(results.asInstanceOf[js.Any])
    if (role != null) __obj.updateDynamic("role")(role)
    if (security != null) __obj.updateDynamic("security")(security)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (!js.isUndefined(slider)) __obj.updateDynamic("slider")(slider)
    if (slot != null) __obj.updateDynamic("slot")(slot)
    if (!js.isUndefined(spellCheck)) __obj.updateDynamic("spellCheck")(spellCheck)
    if (src != null) __obj.updateDynamic("src")(src)
    if (step != null) __obj.updateDynamic("step")(step.asInstanceOf[js.Any])
    if (style != null) __obj.updateDynamic("style")(style)
    if (!js.isUndefined(suppressContentEditableWarning)) __obj.updateDynamic("suppressContentEditableWarning")(suppressContentEditableWarning)
    if (!js.isUndefined(suppressHydrationWarning)) __obj.updateDynamic("suppressHydrationWarning")(suppressHydrationWarning)
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (title != null) __obj.updateDynamic("title")(title)
    if (!js.isUndefined(toggle)) __obj.updateDynamic("toggle")(toggle)
    if (`type` != null) __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (typeof != null) __obj.updateDynamic("typeof")(typeof)
    if (unselectable != null) __obj.updateDynamic("unselectable")(unselectable.asInstanceOf[js.Any])
    if (value != null) __obj.updateDynamic("value")(value.asInstanceOf[js.Any])
    if (vocab != null) __obj.updateDynamic("vocab")(vocab)
    if (width != null) __obj.updateDynamic("width")(width.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesCheckboxCheckboxMod.CheckboxProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesCheckboxMod.default](js.constructorOf[typings.semanticUiReact.modulesCheckboxMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesCheckboxCheckboxMod.CheckboxProps])(children: _*)
  }
}


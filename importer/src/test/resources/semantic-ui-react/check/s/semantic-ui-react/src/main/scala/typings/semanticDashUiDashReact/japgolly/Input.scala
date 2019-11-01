package typings.semanticUiReact.japgolly

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactAnimationEventFrom
import japgolly.scalajs.react.ReactClipboardEventFrom
import japgolly.scalajs.react.ReactCompositionEventFrom
import japgolly.scalajs.react.ReactDragEventFrom
import japgolly.scalajs.react.ReactEventFrom
import japgolly.scalajs.react.ReactFocusEventFrom
import japgolly.scalajs.react.ReactKeyboardEventFrom
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.ReactPointerEventFrom
import japgolly.scalajs.react.ReactTouchEventFrom
import japgolly.scalajs.react.ReactTransitionEventFrom
import japgolly.scalajs.react.ReactUIEventFrom
import japgolly.scalajs.react.ReactWheelEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalajs.dom.raw.HTMLInputElement
import typings.react.Anon_Html
import typings.react.reactMod.CSSProperties
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
import typings.semanticUiReact.elementsInputInputMod.InputOnChangeData
import typings.semanticUiReact.elementsInputInputMod.InputProps
import typings.semanticUiReact.elementsInputMod.default
import typings.semanticUiReact.genericMod.HtmlInputrops
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.semanticUiReactStrings.`left corner`
import typings.semanticUiReact.semanticUiReactStrings.`right corner`
import typings.semanticUiReact.semanticUiReactStrings.big
import typings.semanticUiReact.semanticUiReactStrings.huge
import typings.semanticUiReact.semanticUiReactStrings.large
import typings.semanticUiReact.semanticUiReactStrings.left
import typings.semanticUiReact.semanticUiReactStrings.massive
import typings.semanticUiReact.semanticUiReactStrings.mini
import typings.semanticUiReact.semanticUiReactStrings.right
import typings.semanticUiReact.semanticUiReactStrings.small
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Input {
  def apply(
    key: js.UndefOr[Key] = js.undefined,
    about: String = null,
    accept: String = null,
    accessKey: String = null,
    action: js.Any | Boolean = null,
    actionPosition: left = null,
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
    defaultValue: String | js.Array[String] = null,
    dir: String = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    draggable: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    focus: js.UndefOr[Boolean] = js.undefined,
    form: String = null,
    formAction: String = null,
    formEncType: String = null,
    formMethod: String = null,
    formNoValidate: js.UndefOr[Boolean] = js.undefined,
    formTarget: String = null,
    height: Double | String = null,
    hidden: js.UndefOr[Boolean] = js.undefined,
    icon: js.Any | SemanticShorthandItem[InputProps] = null,
    iconPosition: left = null,
    id: String = null,
    inlist: js.Any = null,
    input: SemanticShorthandItem[HtmlInputrops] = null,
    inputMode: String = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    is: String = null,
    itemID: String = null,
    itemProp: String = null,
    itemRef: String = null,
    itemScope: js.UndefOr[Boolean] = js.undefined,
    itemType: String = null,
    label: SemanticShorthandItem[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify LabelProps */ js.Any
    ] = null,
    labelPosition: left | right | (`left corner`) | (`right corner`) = null,
    lang: String = null,
    list: String = null,
    loading: js.UndefOr[Boolean] = js.undefined,
    max: Double | String = null,
    maxLength: Int | Double = null,
    min: Double | String = null,
    minLength: Int | Double = null,
    multiple: js.UndefOr[Boolean] = js.undefined,
    name: String = null,
    onAbort: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onAnimationEnd: js.UndefOr[ReactAnimationEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onAnimationIteration: js.UndefOr[ReactAnimationEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onAnimationStart: js.UndefOr[ReactAnimationEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onAuxClick: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onBeforeInput: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onCanPlay: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onCanPlayThrough: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onChange: js.UndefOr[
      (/* event */ ReactEventFrom[HTMLInputElement], /* data */ InputOnChangeData) => Callback
    ] = js.undefined,
    onClick: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onCompositionEnd: js.UndefOr[ReactCompositionEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onCompositionStart: js.UndefOr[ReactCompositionEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onCompositionUpdate: js.UndefOr[ReactCompositionEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onContextMenu: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onCopy: js.UndefOr[ReactClipboardEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onCut: js.UndefOr[ReactClipboardEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDoubleClick: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDrag: js.UndefOr[ReactDragEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDragEnd: js.UndefOr[ReactDragEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDragEnter: js.UndefOr[ReactDragEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDragExit: js.UndefOr[ReactDragEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDragLeave: js.UndefOr[ReactDragEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDragOver: js.UndefOr[ReactDragEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDragStart: js.UndefOr[ReactDragEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDrop: js.UndefOr[ReactDragEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onDurationChange: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onEmptied: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onEncrypted: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onEnded: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onError: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onFocus: js.UndefOr[ReactFocusEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onInput: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onInvalid: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactKeyboardEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onKeyPress: js.UndefOr[ReactKeyboardEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onKeyUp: js.UndefOr[ReactKeyboardEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onLoad: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onLoadStart: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onLoadedData: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onLoadedMetadata: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onMouseEnter: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onMouseLeave: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onMouseMove: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onMouseOut: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onMouseOver: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPaste: js.UndefOr[ReactClipboardEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPause: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPlay: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPlaying: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPointerCancel: js.UndefOr[ReactPointerEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPointerDown: js.UndefOr[ReactPointerEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPointerEnter: js.UndefOr[ReactPointerEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPointerLeave: js.UndefOr[ReactPointerEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPointerMove: js.UndefOr[ReactPointerEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPointerOut: js.UndefOr[ReactPointerEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPointerOver: js.UndefOr[ReactPointerEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onPointerUp: js.UndefOr[ReactPointerEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onProgress: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onRateChange: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onReset: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onScroll: js.UndefOr[ReactUIEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onSeeked: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onSeeking: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onSelect: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onStalled: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onSubmit: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onSuspend: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onTimeUpdate: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onTouchCancel: js.UndefOr[ReactTouchEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onTouchEnd: js.UndefOr[ReactTouchEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onTouchMove: js.UndefOr[ReactTouchEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onTouchStart: js.UndefOr[ReactTouchEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onTransitionEnd: js.UndefOr[ReactTransitionEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onVolumeChange: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onWaiting: js.UndefOr[ReactEventFrom[HTMLInputElement] => Callback] = js.undefined,
    onWheel: js.UndefOr[ReactWheelEventFrom[HTMLInputElement] => Callback] = js.undefined,
    pattern: String = null,
    placeholder: String = null,
    prefix: String = null,
    property: String = null,
    radioGroup: String = null,
    readOnly: js.UndefOr[Boolean] = js.undefined,
    required: js.UndefOr[Boolean] = js.undefined,
    resource: String = null,
    results: Int | Double = null,
    role: String = null,
    security: String = null,
    size: mini | small | large | big | huge | massive = null,
    slot: String = null,
    spellCheck: js.UndefOr[Boolean] = js.undefined,
    src: String = null,
    step: Double | String = null,
    style: CSSProperties = null,
    suppressContentEditableWarning: js.UndefOr[Boolean] = js.undefined,
    suppressHydrationWarning: js.UndefOr[Boolean] = js.undefined,
    tabIndex: Double | String = null,
    title: String = null,
    transparent: js.UndefOr[Boolean] = js.undefined,
    `type`: String = null,
    typeof: String = null,
    unselectable: on | off = null,
    value: String | js.Array[String] | Double = null,
    vocab: String = null,
    width: Double | String = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[InputProps, default, Unit, InputProps] = {
    val __obj = js.Dynamic.literal()
  
    
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (about != null) __obj.updateDynamic("about")(about)
    if (accept != null) __obj.updateDynamic("accept")(accept)
    if (accessKey != null) __obj.updateDynamic("accessKey")(accessKey)
    if (action != null) __obj.updateDynamic("action")(action.asInstanceOf[js.Any])
    if (actionPosition != null) __obj.updateDynamic("actionPosition")(actionPosition)
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
    if (defaultValue != null) __obj.updateDynamic("defaultValue")(defaultValue.asInstanceOf[js.Any])
    if (dir != null) __obj.updateDynamic("dir")(dir)
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(draggable)) __obj.updateDynamic("draggable")(draggable)
    if (!js.isUndefined(error)) __obj.updateDynamic("error")(error)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (!js.isUndefined(focus)) __obj.updateDynamic("focus")(focus)
    if (form != null) __obj.updateDynamic("form")(form)
    if (formAction != null) __obj.updateDynamic("formAction")(formAction)
    if (formEncType != null) __obj.updateDynamic("formEncType")(formEncType)
    if (formMethod != null) __obj.updateDynamic("formMethod")(formMethod)
    if (!js.isUndefined(formNoValidate)) __obj.updateDynamic("formNoValidate")(formNoValidate)
    if (formTarget != null) __obj.updateDynamic("formTarget")(formTarget)
    if (height != null) __obj.updateDynamic("height")(height.asInstanceOf[js.Any])
    if (!js.isUndefined(hidden)) __obj.updateDynamic("hidden")(hidden)
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (iconPosition != null) __obj.updateDynamic("iconPosition")(iconPosition)
    if (id != null) __obj.updateDynamic("id")(id)
    if (inlist != null) __obj.updateDynamic("inlist")(inlist)
    if (input != null) __obj.updateDynamic("input")(input.asInstanceOf[js.Any])
    if (inputMode != null) __obj.updateDynamic("inputMode")(inputMode)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (is != null) __obj.updateDynamic("is")(is)
    if (itemID != null) __obj.updateDynamic("itemID")(itemID)
    if (itemProp != null) __obj.updateDynamic("itemProp")(itemProp)
    if (itemRef != null) __obj.updateDynamic("itemRef")(itemRef)
    if (!js.isUndefined(itemScope)) __obj.updateDynamic("itemScope")(itemScope)
    if (itemType != null) __obj.updateDynamic("itemType")(itemType)
    if (label != null) __obj.updateDynamic("label")(label.asInstanceOf[js.Any])
    if (labelPosition != null) __obj.updateDynamic("labelPosition")(labelPosition.asInstanceOf[js.Any])
    if (lang != null) __obj.updateDynamic("lang")(lang)
    if (list != null) __obj.updateDynamic("list")(list)
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (max != null) __obj.updateDynamic("max")(max.asInstanceOf[js.Any])
    if (maxLength != null) __obj.updateDynamic("maxLength")(maxLength.asInstanceOf[js.Any])
    if (min != null) __obj.updateDynamic("min")(min.asInstanceOf[js.Any])
    if (minLength != null) __obj.updateDynamic("minLength")(minLength.asInstanceOf[js.Any])
    if (!js.isUndefined(multiple)) __obj.updateDynamic("multiple")(multiple)
    if (name != null) __obj.updateDynamic("name")(name)
    onAbort.foreach(p => __obj.updateDynamic("onAbort")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onAnimationEnd.foreach(p => __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onAnimationIteration.foreach(p => __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onAnimationStart.foreach(p => __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onAuxClick.foreach(p => __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onBeforeInput.foreach(p => __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onBlur.foreach(p => __obj.updateDynamic("onBlur")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactFocusEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onCanPlay.foreach(p => __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onCanPlayThrough.foreach(p => __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onChange.foreach(p => __obj.updateDynamic("onChange")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement], t1: /* data */ typings.semanticUiReact.elementsInputInputMod.InputOnChangeData) => p(t0, t1).runNow()))))
    onClick.foreach(p => __obj.updateDynamic("onClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onCompositionEnd.foreach(p => __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onCompositionStart.foreach(p => __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onCompositionUpdate.foreach(p => __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onContextMenu.foreach(p => __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onCopy.foreach(p => __obj.updateDynamic("onCopy")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onCut.foreach(p => __obj.updateDynamic("onCut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDoubleClick.foreach(p => __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDrag.foreach(p => __obj.updateDynamic("onDrag")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDragEnd.foreach(p => __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDragEnter.foreach(p => __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDragExit.foreach(p => __obj.updateDynamic("onDragExit")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDragLeave.foreach(p => __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDragOver.foreach(p => __obj.updateDynamic("onDragOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDragStart.foreach(p => __obj.updateDynamic("onDragStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDrop.foreach(p => __obj.updateDynamic("onDrop")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onDurationChange.foreach(p => __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onEmptied.foreach(p => __obj.updateDynamic("onEmptied")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onEncrypted.foreach(p => __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onEnded.foreach(p => __obj.updateDynamic("onEnded")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onError.foreach(p => __obj.updateDynamic("onError")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onFocus.foreach(p => __obj.updateDynamic("onFocus")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactFocusEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onInput.foreach(p => __obj.updateDynamic("onInput")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onInvalid.foreach(p => __obj.updateDynamic("onInvalid")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onKeyDown.foreach(p => __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onKeyPress.foreach(p => __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onKeyUp.foreach(p => __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onLoad.foreach(p => __obj.updateDynamic("onLoad")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onLoadStart.foreach(p => __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onLoadedData.foreach(p => __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onLoadedMetadata.foreach(p => __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onMouseDown.foreach(p => __obj.updateDynamic("onMouseDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onMouseEnter.foreach(p => __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onMouseLeave.foreach(p => __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onMouseMove.foreach(p => __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onMouseOut.foreach(p => __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onMouseOver.foreach(p => __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onMouseUp.foreach(p => __obj.updateDynamic("onMouseUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPaste.foreach(p => __obj.updateDynamic("onPaste")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPause.foreach(p => __obj.updateDynamic("onPause")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPlay.foreach(p => __obj.updateDynamic("onPlay")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPlaying.foreach(p => __obj.updateDynamic("onPlaying")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPointerCancel.foreach(p => __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPointerDown.foreach(p => __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPointerEnter.foreach(p => __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPointerLeave.foreach(p => __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPointerMove.foreach(p => __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPointerOut.foreach(p => __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPointerOver.foreach(p => __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onPointerUp.foreach(p => __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onProgress.foreach(p => __obj.updateDynamic("onProgress")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onRateChange.foreach(p => __obj.updateDynamic("onRateChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onReset.foreach(p => __obj.updateDynamic("onReset")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onScroll.foreach(p => __obj.updateDynamic("onScroll")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactUIEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onSeeked.foreach(p => __obj.updateDynamic("onSeeked")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onSeeking.foreach(p => __obj.updateDynamic("onSeeking")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onSelect.foreach(p => __obj.updateDynamic("onSelect")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onStalled.foreach(p => __obj.updateDynamic("onStalled")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onSubmit.foreach(p => __obj.updateDynamic("onSubmit")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onSuspend.foreach(p => __obj.updateDynamic("onSuspend")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onTimeUpdate.foreach(p => __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onTouchCancel.foreach(p => __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onTouchEnd.foreach(p => __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onTouchMove.foreach(p => __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onTouchStart.foreach(p => __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onTransitionEnd.foreach(p => __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTransitionEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onVolumeChange.foreach(p => __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onWaiting.foreach(p => __obj.updateDynamic("onWaiting")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    onWheel.foreach(p => __obj.updateDynamic("onWheel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactWheelEventFrom[org.scalajs.dom.raw.HTMLInputElement]) => p(t0).runNow()))))
    if (pattern != null) __obj.updateDynamic("pattern")(pattern)
    if (placeholder != null) __obj.updateDynamic("placeholder")(placeholder)
    if (prefix != null) __obj.updateDynamic("prefix")(prefix)
    if (property != null) __obj.updateDynamic("property")(property)
    if (radioGroup != null) __obj.updateDynamic("radioGroup")(radioGroup)
    if (!js.isUndefined(readOnly)) __obj.updateDynamic("readOnly")(readOnly)
    if (!js.isUndefined(required)) __obj.updateDynamic("required")(required)
    if (resource != null) __obj.updateDynamic("resource")(resource)
    if (results != null) __obj.updateDynamic("results")(results.asInstanceOf[js.Any])
    if (role != null) __obj.updateDynamic("role")(role)
    if (security != null) __obj.updateDynamic("security")(security)
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (slot != null) __obj.updateDynamic("slot")(slot)
    if (!js.isUndefined(spellCheck)) __obj.updateDynamic("spellCheck")(spellCheck)
    if (src != null) __obj.updateDynamic("src")(src)
    if (step != null) __obj.updateDynamic("step")(step.asInstanceOf[js.Any])
    if (style != null) __obj.updateDynamic("style")(style)
    if (!js.isUndefined(suppressContentEditableWarning)) __obj.updateDynamic("suppressContentEditableWarning")(suppressContentEditableWarning)
    if (!js.isUndefined(suppressHydrationWarning)) __obj.updateDynamic("suppressHydrationWarning")(suppressHydrationWarning)
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (title != null) __obj.updateDynamic("title")(title)
    if (!js.isUndefined(transparent)) __obj.updateDynamic("transparent")(transparent)
    if (`type` != null) __obj.updateDynamic("type")(`type`)
    if (typeof != null) __obj.updateDynamic("typeof")(typeof)
    if (unselectable != null) __obj.updateDynamic("unselectable")(unselectable.asInstanceOf[js.Any])
    if (value != null) __obj.updateDynamic("value")(value.asInstanceOf[js.Any])
    if (vocab != null) __obj.updateDynamic("vocab")(vocab)
    if (width != null) __obj.updateDynamic("width")(width.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.elementsInputInputMod.InputProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.elementsInputMod.default](js.constructorOf[typings.semanticUiReact.elementsInputMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.elementsInputInputMod.InputProps])(children: _*)
  }
}


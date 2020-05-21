package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
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
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom.raw.Element
import typingsJapgolly.react.AnonHtml
import typingsJapgolly.react.reactStrings.`additions text`
import typingsJapgolly.react.reactStrings.`inline`
import typingsJapgolly.react.reactStrings.additions
import typingsJapgolly.react.reactStrings.all
import typingsJapgolly.react.reactStrings.ascending
import typingsJapgolly.react.reactStrings.assertive
import typingsJapgolly.react.reactStrings.both
import typingsJapgolly.react.reactStrings.copy
import typingsJapgolly.react.reactStrings.date
import typingsJapgolly.react.reactStrings.descending
import typingsJapgolly.react.reactStrings.dialog
import typingsJapgolly.react.reactStrings.execute
import typingsJapgolly.react.reactStrings.grammar
import typingsJapgolly.react.reactStrings.grid
import typingsJapgolly.react.reactStrings.horizontal
import typingsJapgolly.react.reactStrings.link
import typingsJapgolly.react.reactStrings.list
import typingsJapgolly.react.reactStrings.listbox
import typingsJapgolly.react.reactStrings.location
import typingsJapgolly.react.reactStrings.menu
import typingsJapgolly.react.reactStrings.mixed
import typingsJapgolly.react.reactStrings.move
import typingsJapgolly.react.reactStrings.none
import typingsJapgolly.react.reactStrings.off
import typingsJapgolly.react.reactStrings.on
import typingsJapgolly.react.reactStrings.other
import typingsJapgolly.react.reactStrings.page
import typingsJapgolly.react.reactStrings.polite
import typingsJapgolly.react.reactStrings.popup
import typingsJapgolly.react.reactStrings.removals
import typingsJapgolly.react.reactStrings.spelling
import typingsJapgolly.react.reactStrings.step
import typingsJapgolly.react.reactStrings.text
import typingsJapgolly.react.reactStrings.time
import typingsJapgolly.react.reactStrings.tree
import typingsJapgolly.react.reactStrings.vertical
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HTMLAttributes[T]
  extends AriaAttributes
     with DOMAttributes[T] {
  // RDFa Attributes
  var about: js.UndefOr[String] = js.native
  // Standard HTML Attributes
  var accessKey: js.UndefOr[String] = js.native
  // Non-standard Attributes
  var autoCapitalize: js.UndefOr[String] = js.native
  var autoCorrect: js.UndefOr[String] = js.native
  var autoSave: js.UndefOr[String] = js.native
  var className: js.UndefOr[String] = js.native
  var color: js.UndefOr[String] = js.native
  var contentEditable: js.UndefOr[Boolean] = js.native
  var contextMenu: js.UndefOr[String] = js.native
  var datatype: js.UndefOr[String] = js.native
  // React-specific Attributes
  var defaultChecked: js.UndefOr[Boolean] = js.native
  var defaultValue: js.UndefOr[String | js.Array[String]] = js.native
  var dir: js.UndefOr[String] = js.native
  var draggable: js.UndefOr[Boolean] = js.native
  var hidden: js.UndefOr[Boolean] = js.native
  var id: js.UndefOr[String] = js.native
  var inlist: js.UndefOr[js.Any] = js.native
  // Unknown
  var inputMode: js.UndefOr[String] = js.native
  var is: js.UndefOr[String] = js.native
  var itemID: js.UndefOr[String] = js.native
  var itemProp: js.UndefOr[String] = js.native
  var itemRef: js.UndefOr[String] = js.native
  var itemScope: js.UndefOr[Boolean] = js.native
  var itemType: js.UndefOr[String] = js.native
  var lang: js.UndefOr[String] = js.native
  var placeholder: js.UndefOr[String] = js.native
  var prefix: js.UndefOr[String] = js.native
  var property: js.UndefOr[String] = js.native
  var radioGroup: js.UndefOr[String] = js.native
  var resource: js.UndefOr[String] = js.native
  var results: js.UndefOr[Double] = js.native
   // <command>, <menuitem>
  // WAI-ARIA
  var role: js.UndefOr[String] = js.native
  var security: js.UndefOr[String] = js.native
  var slot: js.UndefOr[String] = js.native
  var spellCheck: js.UndefOr[Boolean] = js.native
  var style: js.UndefOr[CSSProperties] = js.native
  var suppressContentEditableWarning: js.UndefOr[Boolean] = js.native
  var suppressHydrationWarning: js.UndefOr[Boolean] = js.native
  var tabIndex: js.UndefOr[Double] = js.native
  var title: js.UndefOr[String] = js.native
  var typeof: js.UndefOr[String] = js.native
  var unselectable: js.UndefOr[on | off] = js.native
  var vocab: js.UndefOr[String] = js.native
}

object HTMLAttributes {
  @scala.inline
  def apply[T](
    about: String = null,
    accessKey: String = null,
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
    autoCapitalize: String = null,
    autoCorrect: String = null,
    autoSave: String = null,
    children: VdomNode = null,
    className: String = null,
    color: String = null,
    contentEditable: js.UndefOr[Boolean] = js.undefined,
    contextMenu: String = null,
    dangerouslySetInnerHTML: AnonHtml = null,
    datatype: String = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined,
    defaultValue: String | js.Array[String] = null,
    dir: String = null,
    draggable: js.UndefOr[Boolean] = js.undefined,
    hidden: js.UndefOr[Boolean] = js.undefined,
    id: String = null,
    inlist: js.Any = null,
    inputMode: String = null,
    is: String = null,
    itemID: String = null,
    itemProp: String = null,
    itemRef: String = null,
    itemScope: js.UndefOr[Boolean] = js.undefined,
    itemType: String = null,
    lang: String = null,
    onAbort: ReactEventFrom[T with Element] => Callback = null,
    onAnimationEnd: ReactAnimationEventFrom[T with Element] => Callback = null,
    onAnimationIteration: ReactAnimationEventFrom[T with Element] => Callback = null,
    onAnimationStart: ReactAnimationEventFrom[T with Element] => Callback = null,
    onAuxClick: ReactMouseEventFrom[T with Element] => Callback = null,
    onBeforeInput: ReactEventFrom[T with Element] => Callback = null,
    onBlur: ReactFocusEventFrom[T with Element] => Callback = null,
    onCanPlay: ReactEventFrom[T with Element] => Callback = null,
    onCanPlayThrough: ReactEventFrom[T with Element] => Callback = null,
    onChange: ReactEventFrom[T with Element] => Callback = null,
    onClick: ReactMouseEventFrom[T with Element] => Callback = null,
    onCompositionEnd: ReactCompositionEventFrom[T with Element] => Callback = null,
    onCompositionStart: ReactCompositionEventFrom[T with Element] => Callback = null,
    onCompositionUpdate: ReactCompositionEventFrom[T with Element] => Callback = null,
    onContextMenu: ReactMouseEventFrom[T with Element] => Callback = null,
    onCopy: ReactClipboardEventFrom[T with Element] => Callback = null,
    onCut: ReactClipboardEventFrom[T with Element] => Callback = null,
    onDoubleClick: ReactMouseEventFrom[T with Element] => Callback = null,
    onDrag: ReactDragEventFrom[T with Element] => Callback = null,
    onDragEnd: ReactDragEventFrom[T with Element] => Callback = null,
    onDragEnter: ReactDragEventFrom[T with Element] => Callback = null,
    onDragExit: ReactDragEventFrom[T with Element] => Callback = null,
    onDragLeave: ReactDragEventFrom[T with Element] => Callback = null,
    onDragOver: ReactDragEventFrom[T with Element] => Callback = null,
    onDragStart: ReactDragEventFrom[T with Element] => Callback = null,
    onDrop: ReactDragEventFrom[T with Element] => Callback = null,
    onDurationChange: ReactEventFrom[T with Element] => Callback = null,
    onEmptied: ReactEventFrom[T with Element] => Callback = null,
    onEncrypted: ReactEventFrom[T with Element] => Callback = null,
    onEnded: ReactEventFrom[T with Element] => Callback = null,
    onError: ReactEventFrom[T with Element] => Callback = null,
    onFocus: ReactFocusEventFrom[T with Element] => Callback = null,
    onInput: ReactEventFrom[T with Element] => Callback = null,
    onInvalid: ReactEventFrom[T with Element] => Callback = null,
    onKeyDown: ReactKeyboardEventFrom[T with Element] => Callback = null,
    onKeyPress: ReactKeyboardEventFrom[T with Element] => Callback = null,
    onKeyUp: ReactKeyboardEventFrom[T with Element] => Callback = null,
    onLoad: ReactEventFrom[T with Element] => Callback = null,
    onLoadStart: ReactEventFrom[T with Element] => Callback = null,
    onLoadedData: ReactEventFrom[T with Element] => Callback = null,
    onLoadedMetadata: ReactEventFrom[T with Element] => Callback = null,
    onMouseDown: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseEnter: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseLeave: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseMove: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseOut: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseOver: ReactMouseEventFrom[T with Element] => Callback = null,
    onMouseUp: ReactMouseEventFrom[T with Element] => Callback = null,
    onPaste: ReactClipboardEventFrom[T with Element] => Callback = null,
    onPause: ReactEventFrom[T with Element] => Callback = null,
    onPlay: ReactEventFrom[T with Element] => Callback = null,
    onPlaying: ReactEventFrom[T with Element] => Callback = null,
    onPointerCancel: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerDown: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerEnter: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerLeave: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerMove: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerOut: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerOver: ReactPointerEventFrom[T with Element] => Callback = null,
    onPointerUp: ReactPointerEventFrom[T with Element] => Callback = null,
    onProgress: ReactEventFrom[T with Element] => Callback = null,
    onRateChange: ReactEventFrom[T with Element] => Callback = null,
    onReset: ReactEventFrom[T with Element] => Callback = null,
    onScroll: ReactUIEventFrom[T with Element] => Callback = null,
    onSeeked: ReactEventFrom[T with Element] => Callback = null,
    onSeeking: ReactEventFrom[T with Element] => Callback = null,
    onSelect: ReactEventFrom[T with Element] => Callback = null,
    onStalled: ReactEventFrom[T with Element] => Callback = null,
    onSubmit: ReactEventFrom[T with Element] => Callback = null,
    onSuspend: ReactEventFrom[T with Element] => Callback = null,
    onTimeUpdate: ReactEventFrom[T with Element] => Callback = null,
    onTouchCancel: ReactTouchEventFrom[T with Element] => Callback = null,
    onTouchEnd: ReactTouchEventFrom[T with Element] => Callback = null,
    onTouchMove: ReactTouchEventFrom[T with Element] => Callback = null,
    onTouchStart: ReactTouchEventFrom[T with Element] => Callback = null,
    onTransitionEnd: ReactTransitionEventFrom[T with Element] => Callback = null,
    onVolumeChange: ReactEventFrom[T with Element] => Callback = null,
    onWaiting: ReactEventFrom[T with Element] => Callback = null,
    onWheel: ReactWheelEventFrom[T with Element] => Callback = null,
    placeholder: String = null,
    prefix: String = null,
    property: String = null,
    radioGroup: String = null,
    resource: String = null,
    results: Int | Double = null,
    role: String = null,
    security: String = null,
    slot: String = null,
    spellCheck: js.UndefOr[Boolean] = js.undefined,
    style: CSSProperties = null,
    suppressContentEditableWarning: js.UndefOr[Boolean] = js.undefined,
    suppressHydrationWarning: js.UndefOr[Boolean] = js.undefined,
    tabIndex: Int | Double = null,
    title: String = null,
    typeof: String = null,
    unselectable: on | off = null,
    vocab: String = null
  ): HTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (about != null) __obj.updateDynamic("about")(about.asInstanceOf[js.Any])
    if (accessKey != null) __obj.updateDynamic("accessKey")(accessKey.asInstanceOf[js.Any])
    if (`aria-activedescendant` != null) __obj.updateDynamic("aria-activedescendant")(`aria-activedescendant`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-atomic`)) __obj.updateDynamic("aria-atomic")(`aria-atomic`.asInstanceOf[js.Any])
    if (`aria-autocomplete` != null) __obj.updateDynamic("aria-autocomplete")(`aria-autocomplete`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-busy`)) __obj.updateDynamic("aria-busy")(`aria-busy`.asInstanceOf[js.Any])
    if (`aria-checked` != null) __obj.updateDynamic("aria-checked")(`aria-checked`.asInstanceOf[js.Any])
    if (`aria-colcount` != null) __obj.updateDynamic("aria-colcount")(`aria-colcount`.asInstanceOf[js.Any])
    if (`aria-colindex` != null) __obj.updateDynamic("aria-colindex")(`aria-colindex`.asInstanceOf[js.Any])
    if (`aria-colspan` != null) __obj.updateDynamic("aria-colspan")(`aria-colspan`.asInstanceOf[js.Any])
    if (`aria-controls` != null) __obj.updateDynamic("aria-controls")(`aria-controls`.asInstanceOf[js.Any])
    if (`aria-current` != null) __obj.updateDynamic("aria-current")(`aria-current`.asInstanceOf[js.Any])
    if (`aria-describedby` != null) __obj.updateDynamic("aria-describedby")(`aria-describedby`.asInstanceOf[js.Any])
    if (`aria-details` != null) __obj.updateDynamic("aria-details")(`aria-details`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-disabled`)) __obj.updateDynamic("aria-disabled")(`aria-disabled`.asInstanceOf[js.Any])
    if (`aria-dropeffect` != null) __obj.updateDynamic("aria-dropeffect")(`aria-dropeffect`.asInstanceOf[js.Any])
    if (`aria-errormessage` != null) __obj.updateDynamic("aria-errormessage")(`aria-errormessage`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-expanded`)) __obj.updateDynamic("aria-expanded")(`aria-expanded`.asInstanceOf[js.Any])
    if (`aria-flowto` != null) __obj.updateDynamic("aria-flowto")(`aria-flowto`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-grabbed`)) __obj.updateDynamic("aria-grabbed")(`aria-grabbed`.asInstanceOf[js.Any])
    if (`aria-haspopup` != null) __obj.updateDynamic("aria-haspopup")(`aria-haspopup`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-hidden`)) __obj.updateDynamic("aria-hidden")(`aria-hidden`.asInstanceOf[js.Any])
    if (`aria-invalid` != null) __obj.updateDynamic("aria-invalid")(`aria-invalid`.asInstanceOf[js.Any])
    if (`aria-keyshortcuts` != null) __obj.updateDynamic("aria-keyshortcuts")(`aria-keyshortcuts`.asInstanceOf[js.Any])
    if (`aria-label` != null) __obj.updateDynamic("aria-label")(`aria-label`.asInstanceOf[js.Any])
    if (`aria-labelledby` != null) __obj.updateDynamic("aria-labelledby")(`aria-labelledby`.asInstanceOf[js.Any])
    if (`aria-level` != null) __obj.updateDynamic("aria-level")(`aria-level`.asInstanceOf[js.Any])
    if (`aria-live` != null) __obj.updateDynamic("aria-live")(`aria-live`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-modal`)) __obj.updateDynamic("aria-modal")(`aria-modal`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-multiline`)) __obj.updateDynamic("aria-multiline")(`aria-multiline`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-multiselectable`)) __obj.updateDynamic("aria-multiselectable")(`aria-multiselectable`.asInstanceOf[js.Any])
    if (`aria-orientation` != null) __obj.updateDynamic("aria-orientation")(`aria-orientation`.asInstanceOf[js.Any])
    if (`aria-owns` != null) __obj.updateDynamic("aria-owns")(`aria-owns`.asInstanceOf[js.Any])
    if (`aria-placeholder` != null) __obj.updateDynamic("aria-placeholder")(`aria-placeholder`.asInstanceOf[js.Any])
    if (`aria-posinset` != null) __obj.updateDynamic("aria-posinset")(`aria-posinset`.asInstanceOf[js.Any])
    if (`aria-pressed` != null) __obj.updateDynamic("aria-pressed")(`aria-pressed`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-readonly`)) __obj.updateDynamic("aria-readonly")(`aria-readonly`.asInstanceOf[js.Any])
    if (`aria-relevant` != null) __obj.updateDynamic("aria-relevant")(`aria-relevant`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-required`)) __obj.updateDynamic("aria-required")(`aria-required`.asInstanceOf[js.Any])
    if (`aria-roledescription` != null) __obj.updateDynamic("aria-roledescription")(`aria-roledescription`.asInstanceOf[js.Any])
    if (`aria-rowcount` != null) __obj.updateDynamic("aria-rowcount")(`aria-rowcount`.asInstanceOf[js.Any])
    if (`aria-rowindex` != null) __obj.updateDynamic("aria-rowindex")(`aria-rowindex`.asInstanceOf[js.Any])
    if (`aria-rowspan` != null) __obj.updateDynamic("aria-rowspan")(`aria-rowspan`.asInstanceOf[js.Any])
    if (!js.isUndefined(`aria-selected`)) __obj.updateDynamic("aria-selected")(`aria-selected`.asInstanceOf[js.Any])
    if (`aria-setsize` != null) __obj.updateDynamic("aria-setsize")(`aria-setsize`.asInstanceOf[js.Any])
    if (`aria-sort` != null) __obj.updateDynamic("aria-sort")(`aria-sort`.asInstanceOf[js.Any])
    if (`aria-valuemax` != null) __obj.updateDynamic("aria-valuemax")(`aria-valuemax`.asInstanceOf[js.Any])
    if (`aria-valuemin` != null) __obj.updateDynamic("aria-valuemin")(`aria-valuemin`.asInstanceOf[js.Any])
    if (`aria-valuenow` != null) __obj.updateDynamic("aria-valuenow")(`aria-valuenow`.asInstanceOf[js.Any])
    if (`aria-valuetext` != null) __obj.updateDynamic("aria-valuetext")(`aria-valuetext`.asInstanceOf[js.Any])
    if (autoCapitalize != null) __obj.updateDynamic("autoCapitalize")(autoCapitalize.asInstanceOf[js.Any])
    if (autoCorrect != null) __obj.updateDynamic("autoCorrect")(autoCorrect.asInstanceOf[js.Any])
    if (autoSave != null) __obj.updateDynamic("autoSave")(autoSave.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (color != null) __obj.updateDynamic("color")(color.asInstanceOf[js.Any])
    if (!js.isUndefined(contentEditable)) __obj.updateDynamic("contentEditable")(contentEditable.asInstanceOf[js.Any])
    if (contextMenu != null) __obj.updateDynamic("contextMenu")(contextMenu.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (datatype != null) __obj.updateDynamic("datatype")(datatype.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
    if (defaultValue != null) __obj.updateDynamic("defaultValue")(defaultValue.asInstanceOf[js.Any])
    if (dir != null) __obj.updateDynamic("dir")(dir.asInstanceOf[js.Any])
    if (!js.isUndefined(draggable)) __obj.updateDynamic("draggable")(draggable.asInstanceOf[js.Any])
    if (!js.isUndefined(hidden)) __obj.updateDynamic("hidden")(hidden.asInstanceOf[js.Any])
    if (id != null) __obj.updateDynamic("id")(id.asInstanceOf[js.Any])
    if (inlist != null) __obj.updateDynamic("inlist")(inlist.asInstanceOf[js.Any])
    if (inputMode != null) __obj.updateDynamic("inputMode")(inputMode.asInstanceOf[js.Any])
    if (is != null) __obj.updateDynamic("is")(is.asInstanceOf[js.Any])
    if (itemID != null) __obj.updateDynamic("itemID")(itemID.asInstanceOf[js.Any])
    if (itemProp != null) __obj.updateDynamic("itemProp")(itemProp.asInstanceOf[js.Any])
    if (itemRef != null) __obj.updateDynamic("itemRef")(itemRef.asInstanceOf[js.Any])
    if (!js.isUndefined(itemScope)) __obj.updateDynamic("itemScope")(itemScope.asInstanceOf[js.Any])
    if (itemType != null) __obj.updateDynamic("itemType")(itemType.asInstanceOf[js.Any])
    if (lang != null) __obj.updateDynamic("lang")(lang.asInstanceOf[js.Any])
    if (onAbort != null) __obj.updateDynamic("onAbort")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onAbort(t0).runNow()))
    if (onAnimationEnd != null) __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1((t0: ReactAnimationEventFrom[T with Element]) => onAnimationEnd(t0).runNow()))
    if (onAnimationIteration != null) __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1((t0: ReactAnimationEventFrom[T with Element]) => onAnimationIteration(t0).runNow()))
    if (onAnimationStart != null) __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1((t0: ReactAnimationEventFrom[T with Element]) => onAnimationStart(t0).runNow()))
    if (onAuxClick != null) __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onAuxClick(t0).runNow()))
    if (onBeforeInput != null) __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onBeforeInput(t0).runNow()))
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction1((t0: ReactFocusEventFrom[T with Element]) => onBlur(t0).runNow()))
    if (onCanPlay != null) __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onCanPlay(t0).runNow()))
    if (onCanPlayThrough != null) __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onCanPlayThrough(t0).runNow()))
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onChange(t0).runNow()))
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onClick(t0).runNow()))
    if (onCompositionEnd != null) __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1((t0: ReactCompositionEventFrom[T with Element]) => onCompositionEnd(t0).runNow()))
    if (onCompositionStart != null) __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1((t0: ReactCompositionEventFrom[T with Element]) => onCompositionStart(t0).runNow()))
    if (onCompositionUpdate != null) __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1((t0: ReactCompositionEventFrom[T with Element]) => onCompositionUpdate(t0).runNow()))
    if (onContextMenu != null) __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onContextMenu(t0).runNow()))
    if (onCopy != null) __obj.updateDynamic("onCopy")(js.Any.fromFunction1((t0: ReactClipboardEventFrom[T with Element]) => onCopy(t0).runNow()))
    if (onCut != null) __obj.updateDynamic("onCut")(js.Any.fromFunction1((t0: ReactClipboardEventFrom[T with Element]) => onCut(t0).runNow()))
    if (onDoubleClick != null) __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onDoubleClick(t0).runNow()))
    if (onDrag != null) __obj.updateDynamic("onDrag")(js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => onDrag(t0).runNow()))
    if (onDragEnd != null) __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => onDragEnd(t0).runNow()))
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => onDragEnter(t0).runNow()))
    if (onDragExit != null) __obj.updateDynamic("onDragExit")(js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => onDragExit(t0).runNow()))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => onDragLeave(t0).runNow()))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => onDragOver(t0).runNow()))
    if (onDragStart != null) __obj.updateDynamic("onDragStart")(js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => onDragStart(t0).runNow()))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction1((t0: ReactDragEventFrom[T with Element]) => onDrop(t0).runNow()))
    if (onDurationChange != null) __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onDurationChange(t0).runNow()))
    if (onEmptied != null) __obj.updateDynamic("onEmptied")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onEmptied(t0).runNow()))
    if (onEncrypted != null) __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onEncrypted(t0).runNow()))
    if (onEnded != null) __obj.updateDynamic("onEnded")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onEnded(t0).runNow()))
    if (onError != null) __obj.updateDynamic("onError")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onError(t0).runNow()))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction1((t0: ReactFocusEventFrom[T with Element]) => onFocus(t0).runNow()))
    if (onInput != null) __obj.updateDynamic("onInput")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onInput(t0).runNow()))
    if (onInvalid != null) __obj.updateDynamic("onInvalid")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onInvalid(t0).runNow()))
    if (onKeyDown != null) __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1((t0: ReactKeyboardEventFrom[T with Element]) => onKeyDown(t0).runNow()))
    if (onKeyPress != null) __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1((t0: ReactKeyboardEventFrom[T with Element]) => onKeyPress(t0).runNow()))
    if (onKeyUp != null) __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1((t0: ReactKeyboardEventFrom[T with Element]) => onKeyUp(t0).runNow()))
    if (onLoad != null) __obj.updateDynamic("onLoad")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onLoad(t0).runNow()))
    if (onLoadStart != null) __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onLoadStart(t0).runNow()))
    if (onLoadedData != null) __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onLoadedData(t0).runNow()))
    if (onLoadedMetadata != null) __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onLoadedMetadata(t0).runNow()))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onMouseDown(t0).runNow()))
    if (onMouseEnter != null) __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onMouseEnter(t0).runNow()))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onMouseLeave(t0).runNow()))
    if (onMouseMove != null) __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onMouseMove(t0).runNow()))
    if (onMouseOut != null) __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onMouseOut(t0).runNow()))
    if (onMouseOver != null) __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onMouseOver(t0).runNow()))
    if (onMouseUp != null) __obj.updateDynamic("onMouseUp")(js.Any.fromFunction1((t0: ReactMouseEventFrom[T with Element]) => onMouseUp(t0).runNow()))
    if (onPaste != null) __obj.updateDynamic("onPaste")(js.Any.fromFunction1((t0: ReactClipboardEventFrom[T with Element]) => onPaste(t0).runNow()))
    if (onPause != null) __obj.updateDynamic("onPause")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onPause(t0).runNow()))
    if (onPlay != null) __obj.updateDynamic("onPlay")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onPlay(t0).runNow()))
    if (onPlaying != null) __obj.updateDynamic("onPlaying")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onPlaying(t0).runNow()))
    if (onPointerCancel != null) __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => onPointerCancel(t0).runNow()))
    if (onPointerDown != null) __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => onPointerDown(t0).runNow()))
    if (onPointerEnter != null) __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => onPointerEnter(t0).runNow()))
    if (onPointerLeave != null) __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => onPointerLeave(t0).runNow()))
    if (onPointerMove != null) __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => onPointerMove(t0).runNow()))
    if (onPointerOut != null) __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => onPointerOut(t0).runNow()))
    if (onPointerOver != null) __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => onPointerOver(t0).runNow()))
    if (onPointerUp != null) __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1((t0: ReactPointerEventFrom[T with Element]) => onPointerUp(t0).runNow()))
    if (onProgress != null) __obj.updateDynamic("onProgress")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onProgress(t0).runNow()))
    if (onRateChange != null) __obj.updateDynamic("onRateChange")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onRateChange(t0).runNow()))
    if (onReset != null) __obj.updateDynamic("onReset")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onReset(t0).runNow()))
    if (onScroll != null) __obj.updateDynamic("onScroll")(js.Any.fromFunction1((t0: ReactUIEventFrom[T with Element]) => onScroll(t0).runNow()))
    if (onSeeked != null) __obj.updateDynamic("onSeeked")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onSeeked(t0).runNow()))
    if (onSeeking != null) __obj.updateDynamic("onSeeking")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onSeeking(t0).runNow()))
    if (onSelect != null) __obj.updateDynamic("onSelect")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onSelect(t0).runNow()))
    if (onStalled != null) __obj.updateDynamic("onStalled")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onStalled(t0).runNow()))
    if (onSubmit != null) __obj.updateDynamic("onSubmit")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onSubmit(t0).runNow()))
    if (onSuspend != null) __obj.updateDynamic("onSuspend")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onSuspend(t0).runNow()))
    if (onTimeUpdate != null) __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onTimeUpdate(t0).runNow()))
    if (onTouchCancel != null) __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1((t0: ReactTouchEventFrom[T with Element]) => onTouchCancel(t0).runNow()))
    if (onTouchEnd != null) __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1((t0: ReactTouchEventFrom[T with Element]) => onTouchEnd(t0).runNow()))
    if (onTouchMove != null) __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1((t0: ReactTouchEventFrom[T with Element]) => onTouchMove(t0).runNow()))
    if (onTouchStart != null) __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1((t0: ReactTouchEventFrom[T with Element]) => onTouchStart(t0).runNow()))
    if (onTransitionEnd != null) __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1((t0: ReactTransitionEventFrom[T with Element]) => onTransitionEnd(t0).runNow()))
    if (onVolumeChange != null) __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onVolumeChange(t0).runNow()))
    if (onWaiting != null) __obj.updateDynamic("onWaiting")(js.Any.fromFunction1((t0: ReactEventFrom[T with Element]) => onWaiting(t0).runNow()))
    if (onWheel != null) __obj.updateDynamic("onWheel")(js.Any.fromFunction1((t0: ReactWheelEventFrom[T with Element]) => onWheel(t0).runNow()))
    if (placeholder != null) __obj.updateDynamic("placeholder")(placeholder.asInstanceOf[js.Any])
    if (prefix != null) __obj.updateDynamic("prefix")(prefix.asInstanceOf[js.Any])
    if (property != null) __obj.updateDynamic("property")(property.asInstanceOf[js.Any])
    if (radioGroup != null) __obj.updateDynamic("radioGroup")(radioGroup.asInstanceOf[js.Any])
    if (resource != null) __obj.updateDynamic("resource")(resource.asInstanceOf[js.Any])
    if (results != null) __obj.updateDynamic("results")(results.asInstanceOf[js.Any])
    if (role != null) __obj.updateDynamic("role")(role.asInstanceOf[js.Any])
    if (security != null) __obj.updateDynamic("security")(security.asInstanceOf[js.Any])
    if (slot != null) __obj.updateDynamic("slot")(slot.asInstanceOf[js.Any])
    if (!js.isUndefined(spellCheck)) __obj.updateDynamic("spellCheck")(spellCheck.asInstanceOf[js.Any])
    if (style != null) __obj.updateDynamic("style")(style.asInstanceOf[js.Any])
    if (!js.isUndefined(suppressContentEditableWarning)) __obj.updateDynamic("suppressContentEditableWarning")(suppressContentEditableWarning.asInstanceOf[js.Any])
    if (!js.isUndefined(suppressHydrationWarning)) __obj.updateDynamic("suppressHydrationWarning")(suppressHydrationWarning.asInstanceOf[js.Any])
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (title != null) __obj.updateDynamic("title")(title.asInstanceOf[js.Any])
    if (typeof != null) __obj.updateDynamic("typeof")(typeof.asInstanceOf[js.Any])
    if (unselectable != null) __obj.updateDynamic("unselectable")(unselectable.asInstanceOf[js.Any])
    if (vocab != null) __obj.updateDynamic("vocab")(vocab.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLAttributes[T]]
  }
  @scala.inline
  implicit class HTMLAttributesOps[Self[t] <: HTMLAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withAbout(about: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (about != null) ret.updateDynamic("about")(about.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAbout: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "about")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAccessKey(accessKey: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (accessKey != null) ret.updateDynamic("accessKey")(accessKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAccessKey: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "accessKey")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAutoCapitalize(autoCapitalize: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (autoCapitalize != null) ret.updateDynamic("autoCapitalize")(autoCapitalize.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAutoCapitalize: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "autoCapitalize")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAutoCorrect(autoCorrect: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (autoCorrect != null) ret.updateDynamic("autoCorrect")(autoCorrect.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAutoCorrect: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "autoCorrect")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAutoSave(autoSave: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (autoSave != null) ret.updateDynamic("autoSave")(autoSave.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAutoSave: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "autoSave")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withClassName(className: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (className != null) ret.updateDynamic("className")(className.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutClassName: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "className")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withColor(color: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (color != null) ret.updateDynamic("color")(color.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutColor: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "color")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withContentEditable(contentEditable: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(contentEditable)) ret.updateDynamic("contentEditable")(contentEditable.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutContentEditable: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "contentEditable")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withContextMenu(contextMenu: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (contextMenu != null) ret.updateDynamic("contextMenu")(contextMenu.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutContextMenu: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "contextMenu")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDatatype(datatype: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (datatype != null) ret.updateDynamic("datatype")(datatype.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDatatype: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "datatype")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDefaultChecked(defaultChecked: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(defaultChecked)) ret.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDefaultChecked: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "defaultChecked")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDefaultValue(defaultValue: String | js.Array[String]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (defaultValue != null) ret.updateDynamic("defaultValue")(defaultValue.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDefaultValue: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "defaultValue")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDir(dir: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (dir != null) ret.updateDynamic("dir")(dir.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDir: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "dir")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDraggable(draggable: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(draggable)) ret.updateDynamic("draggable")(draggable.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDraggable: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "draggable")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withHidden(hidden: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(hidden)) ret.updateDynamic("hidden")(hidden.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutHidden: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "hidden")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withId(id: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (id != null) ret.updateDynamic("id")(id.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutId: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "id")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withInlist(inlist: js.Any): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (inlist != null) ret.updateDynamic("inlist")(inlist.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutInlist: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "inlist")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withInputMode(inputMode: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (inputMode != null) ret.updateDynamic("inputMode")(inputMode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutInputMode: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "inputMode")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withIs(is: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (is != null) ret.updateDynamic("is")(is.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutIs: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "is")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withItemID(itemID: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (itemID != null) ret.updateDynamic("itemID")(itemID.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutItemID: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "itemID")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withItemProp(itemProp: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (itemProp != null) ret.updateDynamic("itemProp")(itemProp.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutItemProp: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "itemProp")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withItemRef(itemRef: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (itemRef != null) ret.updateDynamic("itemRef")(itemRef.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutItemRef: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "itemRef")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withItemScope(itemScope: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(itemScope)) ret.updateDynamic("itemScope")(itemScope.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutItemScope: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "itemScope")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withItemType(itemType: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (itemType != null) ret.updateDynamic("itemType")(itemType.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutItemType: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "itemType")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withLang(lang: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (lang != null) ret.updateDynamic("lang")(lang.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutLang: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "lang")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPlaceholder(placeholder: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (placeholder != null) ret.updateDynamic("placeholder")(placeholder.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPlaceholder: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "placeholder")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPrefix(prefix: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (prefix != null) ret.updateDynamic("prefix")(prefix.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPrefix: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "prefix")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withProperty(property: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (property != null) ret.updateDynamic("property")(property.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutProperty: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "property")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRadioGroup(radioGroup: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (radioGroup != null) ret.updateDynamic("radioGroup")(radioGroup.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRadioGroup: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "radioGroup")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withResource(resource: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (resource != null) ret.updateDynamic("resource")(resource.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutResource: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "resource")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withResults(results: Int | Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (results != null) ret.updateDynamic("results")(results.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutResults: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "results")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRole(role: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (role != null) ret.updateDynamic("role")(role.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRole: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "role")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSecurity(security: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (security != null) ret.updateDynamic("security")(security.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSecurity: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "security")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSlot(slot: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (slot != null) ret.updateDynamic("slot")(slot.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSlot: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "slot")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSpellCheck(spellCheck: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(spellCheck)) ret.updateDynamic("spellCheck")(spellCheck.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSpellCheck: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "spellCheck")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStyle(style: CSSProperties): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (style != null) ret.updateDynamic("style")(style.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStyle: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "style")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSuppressContentEditableWarning(suppressContentEditableWarning: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(suppressContentEditableWarning)) ret.updateDynamic("suppressContentEditableWarning")(suppressContentEditableWarning.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSuppressContentEditableWarning: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "suppressContentEditableWarning")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSuppressHydrationWarning(suppressHydrationWarning: js.UndefOr[Boolean]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(suppressHydrationWarning)) ret.updateDynamic("suppressHydrationWarning")(suppressHydrationWarning.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSuppressHydrationWarning: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "suppressHydrationWarning")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTabIndex(tabIndex: Int | Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (tabIndex != null) ret.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTabIndex: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "tabIndex")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTitle(title: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (title != null) ret.updateDynamic("title")(title.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTitle: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "title")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTypeof(typeof: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (typeof != null) ret.updateDynamic("typeof")(typeof.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTypeof: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "typeof")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withUnselectable(unselectable: on | off): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (unselectable != null) ret.updateDynamic("unselectable")(unselectable.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutUnselectable: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "unselectable")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVocab(vocab: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (vocab != null) ret.updateDynamic("vocab")(vocab.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVocab: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "vocab")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}


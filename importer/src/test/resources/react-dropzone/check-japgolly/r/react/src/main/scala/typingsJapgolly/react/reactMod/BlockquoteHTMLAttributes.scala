package typingsJapgolly.react.reactMod

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
import typingsJapgolly.react.Anon_Html
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

trait BlockquoteHTMLAttributes[T] extends HTMLAttributes[T] {
  var cite: js.UndefOr[String] = js.undefined
}

object BlockquoteHTMLAttributes {
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
    cite: String = null,
    className: String = null,
    color: String = null,
    contentEditable: js.UndefOr[Boolean] = js.undefined,
    contextMenu: String = null,
    dangerouslySetInnerHTML: Anon_Html = null,
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
    onAbort: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onAnimationEnd: js.UndefOr[ReactAnimationEventFrom[T with Element] => Callback] = js.undefined,
    onAnimationIteration: js.UndefOr[ReactAnimationEventFrom[T with Element] => Callback] = js.undefined,
    onAnimationStart: js.UndefOr[ReactAnimationEventFrom[T with Element] => Callback] = js.undefined,
    onAuxClick: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onBeforeInput: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEventFrom[T with Element] => Callback] = js.undefined,
    onCanPlay: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onCanPlayThrough: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onChange: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onClick: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onCompositionEnd: js.UndefOr[ReactCompositionEventFrom[T with Element] => Callback] = js.undefined,
    onCompositionStart: js.UndefOr[ReactCompositionEventFrom[T with Element] => Callback] = js.undefined,
    onCompositionUpdate: js.UndefOr[ReactCompositionEventFrom[T with Element] => Callback] = js.undefined,
    onContextMenu: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onCopy: js.UndefOr[ReactClipboardEventFrom[T with Element] => Callback] = js.undefined,
    onCut: js.UndefOr[ReactClipboardEventFrom[T with Element] => Callback] = js.undefined,
    onDoubleClick: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onDrag: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragEnd: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragEnter: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragExit: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragLeave: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragOver: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDragStart: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDrop: js.UndefOr[ReactDragEventFrom[T with Element] => Callback] = js.undefined,
    onDurationChange: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onEmptied: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onEncrypted: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onEnded: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onError: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onFocus: js.UndefOr[ReactFocusEventFrom[T with Element] => Callback] = js.undefined,
    onInput: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onInvalid: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactKeyboardEventFrom[T with Element] => Callback] = js.undefined,
    onKeyPress: js.UndefOr[ReactKeyboardEventFrom[T with Element] => Callback] = js.undefined,
    onKeyUp: js.UndefOr[ReactKeyboardEventFrom[T with Element] => Callback] = js.undefined,
    onLoad: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onLoadStart: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onLoadedData: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onLoadedMetadata: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseEnter: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseLeave: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseMove: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseOut: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseOver: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEventFrom[T with Element] => Callback] = js.undefined,
    onPaste: js.UndefOr[ReactClipboardEventFrom[T with Element] => Callback] = js.undefined,
    onPause: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onPlay: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onPlaying: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onPointerCancel: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerDown: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerEnter: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerLeave: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerMove: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerOut: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerOver: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onPointerUp: js.UndefOr[ReactPointerEventFrom[T with Element] => Callback] = js.undefined,
    onProgress: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onRateChange: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onReset: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onScroll: js.UndefOr[ReactUIEventFrom[T with Element] => Callback] = js.undefined,
    onSeeked: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onSeeking: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onSelect: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onStalled: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onSubmit: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onSuspend: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onTimeUpdate: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onTouchCancel: js.UndefOr[ReactTouchEventFrom[T with Element] => Callback] = js.undefined,
    onTouchEnd: js.UndefOr[ReactTouchEventFrom[T with Element] => Callback] = js.undefined,
    onTouchMove: js.UndefOr[ReactTouchEventFrom[T with Element] => Callback] = js.undefined,
    onTouchStart: js.UndefOr[ReactTouchEventFrom[T with Element] => Callback] = js.undefined,
    onTransitionEnd: js.UndefOr[ReactTransitionEventFrom[T with Element] => Callback] = js.undefined,
    onVolumeChange: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onWaiting: js.UndefOr[ReactEventFrom[T with Element] => Callback] = js.undefined,
    onWheel: js.UndefOr[ReactWheelEventFrom[T with Element] => Callback] = js.undefined,
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
  ): BlockquoteHTMLAttributes[T] = {
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
    if (cite != null) __obj.updateDynamic("cite")(cite.asInstanceOf[js.Any])
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
    onAbort.foreach(x => __obj.updateDynamic("onAbort")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onAnimationEnd.foreach(x => __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onAnimationIteration.foreach(x => __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onAnimationStart.foreach(x => __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onAuxClick.foreach(x => __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onBeforeInput.foreach(x => __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onBlur.foreach(x => __obj.updateDynamic("onBlur")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onCanPlay.foreach(x => __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onCanPlayThrough.foreach(x => __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onChange.foreach(x => __obj.updateDynamic("onChange")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onClick.foreach(x => __obj.updateDynamic("onClick")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onCompositionEnd.foreach(x => __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onCompositionStart.foreach(x => __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onCompositionUpdate.foreach(x => __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onContextMenu.foreach(x => __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onCopy.foreach(x => __obj.updateDynamic("onCopy")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onCut.foreach(x => __obj.updateDynamic("onCut")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDoubleClick.foreach(x => __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDrag.foreach(x => __obj.updateDynamic("onDrag")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDragEnd.foreach(x => __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDragEnter.foreach(x => __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDragExit.foreach(x => __obj.updateDynamic("onDragExit")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDragLeave.foreach(x => __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDragOver.foreach(x => __obj.updateDynamic("onDragOver")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDragStart.foreach(x => __obj.updateDynamic("onDragStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDrop.foreach(x => __obj.updateDynamic("onDrop")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onDurationChange.foreach(x => __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onEmptied.foreach(x => __obj.updateDynamic("onEmptied")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onEncrypted.foreach(x => __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onEnded.foreach(x => __obj.updateDynamic("onEnded")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onError.foreach(x => __obj.updateDynamic("onError")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onFocus.foreach(x => __obj.updateDynamic("onFocus")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onInput.foreach(x => __obj.updateDynamic("onInput")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onInvalid.foreach(x => __obj.updateDynamic("onInvalid")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onKeyDown.foreach(x => __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onKeyPress.foreach(x => __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onKeyUp.foreach(x => __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onLoad.foreach(x => __obj.updateDynamic("onLoad")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onLoadStart.foreach(x => __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onLoadedData.foreach(x => __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onLoadedMetadata.foreach(x => __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onMouseDown.foreach(x => __obj.updateDynamic("onMouseDown")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onMouseEnter.foreach(x => __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onMouseLeave.foreach(x => __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onMouseMove.foreach(x => __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onMouseOut.foreach(x => __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onMouseOver.foreach(x => __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onMouseUp.foreach(x => __obj.updateDynamic("onMouseUp")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPaste.foreach(x => __obj.updateDynamic("onPaste")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPause.foreach(x => __obj.updateDynamic("onPause")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPlay.foreach(x => __obj.updateDynamic("onPlay")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPlaying.foreach(x => __obj.updateDynamic("onPlaying")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPointerCancel.foreach(x => __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPointerDown.foreach(x => __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPointerEnter.foreach(x => __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPointerLeave.foreach(x => __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPointerMove.foreach(x => __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPointerOut.foreach(x => __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPointerOver.foreach(x => __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onPointerUp.foreach(x => __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onProgress.foreach(x => __obj.updateDynamic("onProgress")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onRateChange.foreach(x => __obj.updateDynamic("onRateChange")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onReset.foreach(x => __obj.updateDynamic("onReset")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onScroll.foreach(x => __obj.updateDynamic("onScroll")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactUIEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onSeeked.foreach(x => __obj.updateDynamic("onSeeked")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onSeeking.foreach(x => __obj.updateDynamic("onSeeking")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onSelect.foreach(x => __obj.updateDynamic("onSelect")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onStalled.foreach(x => __obj.updateDynamic("onStalled")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onSubmit.foreach(x => __obj.updateDynamic("onSubmit")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onSuspend.foreach(x => __obj.updateDynamic("onSuspend")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onTimeUpdate.foreach(x => __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onTouchCancel.foreach(x => __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onTouchEnd.foreach(x => __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onTouchMove.foreach(x => __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onTouchStart.foreach(x => __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onTransitionEnd.foreach(x => __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactTransitionEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onVolumeChange.foreach(x => __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onWaiting.foreach(x => __obj.updateDynamic("onWaiting")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
    onWheel.foreach(x => __obj.updateDynamic("onWheel")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactWheelEventFrom[T with org.scalajs.dom.raw.Element]) => x(t0).runNow())))
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
    __obj.asInstanceOf[BlockquoteHTMLAttributes[T]]
  }
}


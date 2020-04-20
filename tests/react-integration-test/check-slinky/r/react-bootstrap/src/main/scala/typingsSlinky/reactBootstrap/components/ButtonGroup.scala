package typingsSlinky.reactBootstrap.components

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.EventTarget
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.SyntheticEvent
import slinky.core.TagMod
import slinky.web.SyntheticAnimationEvent
import slinky.web.SyntheticClipboardEvent
import slinky.web.SyntheticCompositionEvent
import slinky.web.SyntheticFocusEvent
import slinky.web.SyntheticKeyboardEvent
import slinky.web.SyntheticMouseEvent
import slinky.web.SyntheticPointerEvent
import slinky.web.SyntheticTouchEvent
import slinky.web.SyntheticTransitionEvent
import slinky.web.SyntheticUIEvent
import slinky.web.SyntheticWheelEvent
import slinky.web.html.`*`.tag
import typingsSlinky.react.mod.DragEvent
import typingsSlinky.react.reactStrings.`additions text`
import typingsSlinky.react.reactStrings.`inline`
import typingsSlinky.react.reactStrings.additions
import typingsSlinky.react.reactStrings.all
import typingsSlinky.react.reactStrings.ascending
import typingsSlinky.react.reactStrings.assertive
import typingsSlinky.react.reactStrings.both
import typingsSlinky.react.reactStrings.copy
import typingsSlinky.react.reactStrings.date
import typingsSlinky.react.reactStrings.descending
import typingsSlinky.react.reactStrings.dialog
import typingsSlinky.react.reactStrings.execute
import typingsSlinky.react.reactStrings.grammar
import typingsSlinky.react.reactStrings.grid
import typingsSlinky.react.reactStrings.horizontal
import typingsSlinky.react.reactStrings.link
import typingsSlinky.react.reactStrings.list
import typingsSlinky.react.reactStrings.listbox
import typingsSlinky.react.reactStrings.location
import typingsSlinky.react.reactStrings.menu
import typingsSlinky.react.reactStrings.mixed
import typingsSlinky.react.reactStrings.move
import typingsSlinky.react.reactStrings.none
import typingsSlinky.react.reactStrings.off
import typingsSlinky.react.reactStrings.on
import typingsSlinky.react.reactStrings.other
import typingsSlinky.react.reactStrings.page
import typingsSlinky.react.reactStrings.polite
import typingsSlinky.react.reactStrings.popup
import typingsSlinky.react.reactStrings.removals
import typingsSlinky.react.reactStrings.spelling
import typingsSlinky.react.reactStrings.step
import typingsSlinky.react.reactStrings.text
import typingsSlinky.react.reactStrings.time
import typingsSlinky.react.reactStrings.tree
import typingsSlinky.react.reactStrings.vertical
import typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroupProps
import typingsSlinky.reactBootstrap.mod.Sizes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ButtonGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, typingsSlinky.reactBootstrap.mod.ButtonGroup] {
  @JSImport("react-bootstrap", "ButtonGroup")
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  /* The following DOM/SVG props were specified: accept, action, alt, async, autoComplete, autoFocus, capture, challenge, checked, cite, className, colSpan, cols, content, contentEditable, controls, coords, dangerouslySetInnerHTML, data, default, defaultChecked, defaultValue, defer, dir, disabled, download, draggable, form, headers, height, hidden, high, href, htmlFor, id, integrity, kind, label, lang, list, loop, low, manifest, max, media, method, min, multiple, muted, name, nonce, open, optimum, pattern, placeholder, poster, preload, readOnly, rel, required, reversed, rowSpan, rows, sandbox, scope, scoped, scrolling, selected, shape, size, sizes, span, spellCheck, src, start, step, style, summary, suppressContentEditableWarning, tabIndex, target, title, type, value, width, wrap */
  def apply(
    about: String = null,
    acceptCharset: String = null,
    accessKey: String = null,
    allowFullScreen: js.UndefOr[Boolean] = js.undefined,
    allowTransparency: js.UndefOr[Boolean] = js.undefined,
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
    as: String = null,
    autoCapitalize: String = null,
    autoCorrect: String = null,
    autoPlay: js.UndefOr[Boolean] = js.undefined,
    autoSave: String = null,
    block: js.UndefOr[Boolean] = js.undefined,
    bsSize: Sizes = null,
    bsStyle: String = null,
    cellPadding: Double | String = null,
    cellSpacing: Double | String = null,
    charSet: String = null,
    classID: String = null,
    color: String = null,
    contextMenu: String = null,
    crossOrigin: String = null,
    datatype: String = null,
    dateTime: String = null,
    encType: String = null,
    formAction: String = null,
    formEncType: String = null,
    formMethod: String = null,
    formNoValidate: js.UndefOr[Boolean] = js.undefined,
    formTarget: String = null,
    frameBorder: Double | String = null,
    hrefLang: String = null,
    httpEquiv: String = null,
    inlist: js.Any = null,
    inputMode: String = null,
    is: String = null,
    itemID: String = null,
    itemProp: String = null,
    itemRef: String = null,
    itemScope: js.UndefOr[Boolean] = js.undefined,
    itemType: String = null,
    justified: js.UndefOr[Boolean] = js.undefined,
    keyParams: String = null,
    keyType: String = null,
    marginHeight: Int | Double = null,
    marginWidth: Int | Double = null,
    maxLength: Int | Double = null,
    mediaGroup: String = null,
    minLength: Int | Double = null,
    noValidate: js.UndefOr[Boolean] = js.undefined,
    onAbort: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onAnimationEnd: SyntheticAnimationEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onAnimationIteration: SyntheticAnimationEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onAnimationStart: SyntheticAnimationEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onAuxClick: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onBeforeInput: SyntheticEvent[EventTarget with typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit = null,
    onBlur: SyntheticFocusEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onCanPlay: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onCanPlayThrough: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onChange: SyntheticEvent[EventTarget with typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit = null,
    onClick: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onCompositionEnd: SyntheticCompositionEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onCompositionStart: SyntheticCompositionEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onCompositionUpdate: SyntheticCompositionEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onContextMenu: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onCopy: SyntheticClipboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onCut: SyntheticClipboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDoubleClick: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDrag: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDragEnd: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDragEnter: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDragExit: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDragLeave: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDragOver: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDragStart: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDrop: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onDurationChange: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onEmptied: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onEncrypted: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onEnded: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onError: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onFocus: SyntheticFocusEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onInput: SyntheticEvent[EventTarget with typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit = null,
    onInvalid: SyntheticEvent[EventTarget with typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit = null,
    onKeyDown: SyntheticKeyboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onKeyPress: SyntheticKeyboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onKeyUp: SyntheticKeyboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onLoad: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onLoadStart: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onLoadedData: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onLoadedMetadata: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onMouseDown: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onMouseEnter: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onMouseLeave: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onMouseMove: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onMouseOut: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onMouseOver: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onMouseUp: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPaste: SyntheticClipboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPause: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPlay: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPlaying: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPointerCancel: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPointerDown: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPointerEnter: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPointerLeave: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPointerMove: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPointerOut: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPointerOver: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onPointerUp: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onProgress: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onRateChange: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onReset: SyntheticEvent[EventTarget with typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit = null,
    onScroll: SyntheticUIEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onSeeked: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onSeeking: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onSelect: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onStalled: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onSubmit: SyntheticEvent[EventTarget with typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit = null,
    onSuspend: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onTimeUpdate: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onTouchCancel: SyntheticTouchEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onTouchEnd: SyntheticTouchEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onTouchMove: SyntheticTouchEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onTouchStart: SyntheticTouchEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onTransitionEnd: SyntheticTransitionEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onVolumeChange: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onWaiting: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    onWheel: SyntheticWheelEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit = null,
    playsInline: js.UndefOr[Boolean] = js.undefined,
    prefix: String = null,
    property: String = null,
    radioGroup: String = null,
    resource: String = null,
    results: Int | Double = null,
    role: String = null,
    seamless: js.UndefOr[Boolean] = js.undefined,
    security: String = null,
    slot: String = null,
    srcDoc: String = null,
    srcLang: String = null,
    srcSet: String = null,
    suppressHydrationWarning: js.UndefOr[Boolean] = js.undefined,
    typeof: String = null,
    unselectable: on | off = null,
    useMap: String = null,
    vertical: js.UndefOr[Boolean] = js.undefined,
    vocab: String = null,
    wmode: String = null,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, typingsSlinky.reactBootstrap.mod.ButtonGroup] = {
    val __obj = js.Dynamic.literal()
    if (about != null) __obj.updateDynamic("about")(about.asInstanceOf[js.Any])
    if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
    if (accessKey != null) __obj.updateDynamic("accessKey")(accessKey.asInstanceOf[js.Any])
    if (!js.isUndefined(allowFullScreen)) __obj.updateDynamic("allowFullScreen")(allowFullScreen.asInstanceOf[js.Any])
    if (!js.isUndefined(allowTransparency)) __obj.updateDynamic("allowTransparency")(allowTransparency.asInstanceOf[js.Any])
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
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (autoCapitalize != null) __obj.updateDynamic("autoCapitalize")(autoCapitalize.asInstanceOf[js.Any])
    if (autoCorrect != null) __obj.updateDynamic("autoCorrect")(autoCorrect.asInstanceOf[js.Any])
    if (!js.isUndefined(autoPlay)) __obj.updateDynamic("autoPlay")(autoPlay.asInstanceOf[js.Any])
    if (autoSave != null) __obj.updateDynamic("autoSave")(autoSave.asInstanceOf[js.Any])
    if (!js.isUndefined(block)) __obj.updateDynamic("block")(block.asInstanceOf[js.Any])
    if (bsSize != null) __obj.updateDynamic("bsSize")(bsSize.asInstanceOf[js.Any])
    if (bsStyle != null) __obj.updateDynamic("bsStyle")(bsStyle.asInstanceOf[js.Any])
    if (cellPadding != null) __obj.updateDynamic("cellPadding")(cellPadding.asInstanceOf[js.Any])
    if (cellSpacing != null) __obj.updateDynamic("cellSpacing")(cellSpacing.asInstanceOf[js.Any])
    if (charSet != null) __obj.updateDynamic("charSet")(charSet.asInstanceOf[js.Any])
    if (classID != null) __obj.updateDynamic("classID")(classID.asInstanceOf[js.Any])
    if (color != null) __obj.updateDynamic("color")(color.asInstanceOf[js.Any])
    if (contextMenu != null) __obj.updateDynamic("contextMenu")(contextMenu.asInstanceOf[js.Any])
    if (crossOrigin != null) __obj.updateDynamic("crossOrigin")(crossOrigin.asInstanceOf[js.Any])
    if (datatype != null) __obj.updateDynamic("datatype")(datatype.asInstanceOf[js.Any])
    if (dateTime != null) __obj.updateDynamic("dateTime")(dateTime.asInstanceOf[js.Any])
    if (encType != null) __obj.updateDynamic("encType")(encType.asInstanceOf[js.Any])
    if (formAction != null) __obj.updateDynamic("formAction")(formAction.asInstanceOf[js.Any])
    if (formEncType != null) __obj.updateDynamic("formEncType")(formEncType.asInstanceOf[js.Any])
    if (formMethod != null) __obj.updateDynamic("formMethod")(formMethod.asInstanceOf[js.Any])
    if (!js.isUndefined(formNoValidate)) __obj.updateDynamic("formNoValidate")(formNoValidate.asInstanceOf[js.Any])
    if (formTarget != null) __obj.updateDynamic("formTarget")(formTarget.asInstanceOf[js.Any])
    if (frameBorder != null) __obj.updateDynamic("frameBorder")(frameBorder.asInstanceOf[js.Any])
    if (hrefLang != null) __obj.updateDynamic("hrefLang")(hrefLang.asInstanceOf[js.Any])
    if (httpEquiv != null) __obj.updateDynamic("httpEquiv")(httpEquiv.asInstanceOf[js.Any])
    if (inlist != null) __obj.updateDynamic("inlist")(inlist.asInstanceOf[js.Any])
    if (inputMode != null) __obj.updateDynamic("inputMode")(inputMode.asInstanceOf[js.Any])
    if (is != null) __obj.updateDynamic("is")(is.asInstanceOf[js.Any])
    if (itemID != null) __obj.updateDynamic("itemID")(itemID.asInstanceOf[js.Any])
    if (itemProp != null) __obj.updateDynamic("itemProp")(itemProp.asInstanceOf[js.Any])
    if (itemRef != null) __obj.updateDynamic("itemRef")(itemRef.asInstanceOf[js.Any])
    if (!js.isUndefined(itemScope)) __obj.updateDynamic("itemScope")(itemScope.asInstanceOf[js.Any])
    if (itemType != null) __obj.updateDynamic("itemType")(itemType.asInstanceOf[js.Any])
    if (!js.isUndefined(justified)) __obj.updateDynamic("justified")(justified.asInstanceOf[js.Any])
    if (keyParams != null) __obj.updateDynamic("keyParams")(keyParams.asInstanceOf[js.Any])
    if (keyType != null) __obj.updateDynamic("keyType")(keyType.asInstanceOf[js.Any])
    if (marginHeight != null) __obj.updateDynamic("marginHeight")(marginHeight.asInstanceOf[js.Any])
    if (marginWidth != null) __obj.updateDynamic("marginWidth")(marginWidth.asInstanceOf[js.Any])
    if (maxLength != null) __obj.updateDynamic("maxLength")(maxLength.asInstanceOf[js.Any])
    if (mediaGroup != null) __obj.updateDynamic("mediaGroup")(mediaGroup.asInstanceOf[js.Any])
    if (minLength != null) __obj.updateDynamic("minLength")(minLength.asInstanceOf[js.Any])
    if (!js.isUndefined(noValidate)) __obj.updateDynamic("noValidate")(noValidate.asInstanceOf[js.Any])
    if (onAbort != null) __obj.updateDynamic("onAbort")(js.Any.fromFunction1(onAbort))
    if (onAnimationEnd != null) __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1(onAnimationEnd))
    if (onAnimationIteration != null) __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1(onAnimationIteration))
    if (onAnimationStart != null) __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1(onAnimationStart))
    if (onAuxClick != null) __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1(onAuxClick))
    if (onBeforeInput != null) __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1(onBeforeInput))
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction1(onBlur))
    if (onCanPlay != null) __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1(onCanPlay))
    if (onCanPlayThrough != null) __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1(onCanPlayThrough))
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction1(onChange))
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction1(onClick))
    if (onCompositionEnd != null) __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1(onCompositionEnd))
    if (onCompositionStart != null) __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1(onCompositionStart))
    if (onCompositionUpdate != null) __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1(onCompositionUpdate))
    if (onContextMenu != null) __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1(onContextMenu))
    if (onCopy != null) __obj.updateDynamic("onCopy")(js.Any.fromFunction1(onCopy))
    if (onCut != null) __obj.updateDynamic("onCut")(js.Any.fromFunction1(onCut))
    if (onDoubleClick != null) __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1(onDoubleClick))
    if (onDrag != null) __obj.updateDynamic("onDrag")(js.Any.fromFunction1(onDrag))
    if (onDragEnd != null) __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1(onDragEnd))
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1(onDragEnter))
    if (onDragExit != null) __obj.updateDynamic("onDragExit")(js.Any.fromFunction1(onDragExit))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1(onDragLeave))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1(onDragOver))
    if (onDragStart != null) __obj.updateDynamic("onDragStart")(js.Any.fromFunction1(onDragStart))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction1(onDrop))
    if (onDurationChange != null) __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1(onDurationChange))
    if (onEmptied != null) __obj.updateDynamic("onEmptied")(js.Any.fromFunction1(onEmptied))
    if (onEncrypted != null) __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1(onEncrypted))
    if (onEnded != null) __obj.updateDynamic("onEnded")(js.Any.fromFunction1(onEnded))
    if (onError != null) __obj.updateDynamic("onError")(js.Any.fromFunction1(onError))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction1(onFocus))
    if (onInput != null) __obj.updateDynamic("onInput")(js.Any.fromFunction1(onInput))
    if (onInvalid != null) __obj.updateDynamic("onInvalid")(js.Any.fromFunction1(onInvalid))
    if (onKeyDown != null) __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1(onKeyDown))
    if (onKeyPress != null) __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1(onKeyPress))
    if (onKeyUp != null) __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1(onKeyUp))
    if (onLoad != null) __obj.updateDynamic("onLoad")(js.Any.fromFunction1(onLoad))
    if (onLoadStart != null) __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1(onLoadStart))
    if (onLoadedData != null) __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1(onLoadedData))
    if (onLoadedMetadata != null) __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1(onLoadedMetadata))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction1(onMouseDown))
    if (onMouseEnter != null) __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1(onMouseEnter))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1(onMouseLeave))
    if (onMouseMove != null) __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1(onMouseMove))
    if (onMouseOut != null) __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1(onMouseOut))
    if (onMouseOver != null) __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1(onMouseOver))
    if (onMouseUp != null) __obj.updateDynamic("onMouseUp")(js.Any.fromFunction1(onMouseUp))
    if (onPaste != null) __obj.updateDynamic("onPaste")(js.Any.fromFunction1(onPaste))
    if (onPause != null) __obj.updateDynamic("onPause")(js.Any.fromFunction1(onPause))
    if (onPlay != null) __obj.updateDynamic("onPlay")(js.Any.fromFunction1(onPlay))
    if (onPlaying != null) __obj.updateDynamic("onPlaying")(js.Any.fromFunction1(onPlaying))
    if (onPointerCancel != null) __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1(onPointerCancel))
    if (onPointerDown != null) __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1(onPointerDown))
    if (onPointerEnter != null) __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1(onPointerEnter))
    if (onPointerLeave != null) __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1(onPointerLeave))
    if (onPointerMove != null) __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1(onPointerMove))
    if (onPointerOut != null) __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1(onPointerOut))
    if (onPointerOver != null) __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1(onPointerOver))
    if (onPointerUp != null) __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1(onPointerUp))
    if (onProgress != null) __obj.updateDynamic("onProgress")(js.Any.fromFunction1(onProgress))
    if (onRateChange != null) __obj.updateDynamic("onRateChange")(js.Any.fromFunction1(onRateChange))
    if (onReset != null) __obj.updateDynamic("onReset")(js.Any.fromFunction1(onReset))
    if (onScroll != null) __obj.updateDynamic("onScroll")(js.Any.fromFunction1(onScroll))
    if (onSeeked != null) __obj.updateDynamic("onSeeked")(js.Any.fromFunction1(onSeeked))
    if (onSeeking != null) __obj.updateDynamic("onSeeking")(js.Any.fromFunction1(onSeeking))
    if (onSelect != null) __obj.updateDynamic("onSelect")(js.Any.fromFunction1(onSelect))
    if (onStalled != null) __obj.updateDynamic("onStalled")(js.Any.fromFunction1(onStalled))
    if (onSubmit != null) __obj.updateDynamic("onSubmit")(js.Any.fromFunction1(onSubmit))
    if (onSuspend != null) __obj.updateDynamic("onSuspend")(js.Any.fromFunction1(onSuspend))
    if (onTimeUpdate != null) __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1(onTimeUpdate))
    if (onTouchCancel != null) __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1(onTouchCancel))
    if (onTouchEnd != null) __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1(onTouchEnd))
    if (onTouchMove != null) __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1(onTouchMove))
    if (onTouchStart != null) __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1(onTouchStart))
    if (onTransitionEnd != null) __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1(onTransitionEnd))
    if (onVolumeChange != null) __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1(onVolumeChange))
    if (onWaiting != null) __obj.updateDynamic("onWaiting")(js.Any.fromFunction1(onWaiting))
    if (onWheel != null) __obj.updateDynamic("onWheel")(js.Any.fromFunction1(onWheel))
    if (!js.isUndefined(playsInline)) __obj.updateDynamic("playsInline")(playsInline.asInstanceOf[js.Any])
    if (prefix != null) __obj.updateDynamic("prefix")(prefix.asInstanceOf[js.Any])
    if (property != null) __obj.updateDynamic("property")(property.asInstanceOf[js.Any])
    if (radioGroup != null) __obj.updateDynamic("radioGroup")(radioGroup.asInstanceOf[js.Any])
    if (resource != null) __obj.updateDynamic("resource")(resource.asInstanceOf[js.Any])
    if (results != null) __obj.updateDynamic("results")(results.asInstanceOf[js.Any])
    if (role != null) __obj.updateDynamic("role")(role.asInstanceOf[js.Any])
    if (!js.isUndefined(seamless)) __obj.updateDynamic("seamless")(seamless.asInstanceOf[js.Any])
    if (security != null) __obj.updateDynamic("security")(security.asInstanceOf[js.Any])
    if (slot != null) __obj.updateDynamic("slot")(slot.asInstanceOf[js.Any])
    if (srcDoc != null) __obj.updateDynamic("srcDoc")(srcDoc.asInstanceOf[js.Any])
    if (srcLang != null) __obj.updateDynamic("srcLang")(srcLang.asInstanceOf[js.Any])
    if (srcSet != null) __obj.updateDynamic("srcSet")(srcSet.asInstanceOf[js.Any])
    if (!js.isUndefined(suppressHydrationWarning)) __obj.updateDynamic("suppressHydrationWarning")(suppressHydrationWarning.asInstanceOf[js.Any])
    if (typeof != null) __obj.updateDynamic("typeof")(typeof.asInstanceOf[js.Any])
    if (unselectable != null) __obj.updateDynamic("unselectable")(unselectable.asInstanceOf[js.Any])
    if (useMap != null) __obj.updateDynamic("useMap")(useMap.asInstanceOf[js.Any])
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical.asInstanceOf[js.Any])
    if (vocab != null) __obj.updateDynamic("vocab")(vocab.asInstanceOf[js.Any])
    if (wmode != null) __obj.updateDynamic("wmode")(wmode.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  def apply(mods: TagMod[tag.type]*): BuildingComponent[tag.type, typingsSlinky.reactBootstrap.mod.ButtonGroup] = new BuildingComponent[tag.type, typingsSlinky.reactBootstrap.mod.ButtonGroup](js.Array(component.asInstanceOf[js.Any], js.Dictionary.empty)).apply(mods :_*)
  type Props = ButtonGroupProps
}


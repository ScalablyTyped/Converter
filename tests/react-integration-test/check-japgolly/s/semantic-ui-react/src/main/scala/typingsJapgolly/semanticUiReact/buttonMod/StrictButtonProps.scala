package typingsJapgolly.semanticUiReact.buttonMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
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
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom.raw.HTMLButtonElement
import typingsJapgolly.react.AnonHtml
import typingsJapgolly.react.mod.ButtonHTMLAttributes
import typingsJapgolly.react.mod.CSSProperties
import typingsJapgolly.react.mod.ReactNodeArray
import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.react.reactStrings.`additions text`
import typingsJapgolly.react.reactStrings.`inline`
import typingsJapgolly.react.reactStrings.additions
import typingsJapgolly.react.reactStrings.all
import typingsJapgolly.react.reactStrings.ascending
import typingsJapgolly.react.reactStrings.assertive
import typingsJapgolly.react.reactStrings.both
import typingsJapgolly.react.reactStrings.button
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
import typingsJapgolly.react.reactStrings.reset
import typingsJapgolly.react.reactStrings.spelling
import typingsJapgolly.react.reactStrings.step
import typingsJapgolly.react.reactStrings.submit
import typingsJapgolly.react.reactStrings.text
import typingsJapgolly.react.reactStrings.time
import typingsJapgolly.react.reactStrings.tree
import typingsJapgolly.semanticUiReact.genericMod.SemanticCOLORS
import typingsJapgolly.semanticUiReact.genericMod.SemanticFLOATS
import typingsJapgolly.semanticUiReact.genericMod.SemanticSIZES
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandContent
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.`google plus`
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.bottom
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.facebook
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.fade
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.instagram
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.left
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.linkedin
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.right
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.top
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.twitter
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.vertical
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.vk
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.youtube
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictButtonProps extends ButtonHTMLAttributes[HTMLButtonElement] {
  /** A button can show it is currently the active user selection. */
  var active: js.UndefOr[Boolean] = js.native
  /** A button can animate to show hidden content. */
  var animated: js.UndefOr[Boolean | fade | vertical] = js.native
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.native
  /** A button can be attached to other content. */
  var attached: js.UndefOr[Boolean | left | right | top | bottom] = js.native
  /** A basic button is less pronounced. */
  var basic: js.UndefOr[Boolean] = js.native
  /** A button can be circular. */
  var circular: js.UndefOr[Boolean] = js.native
  /** A button can have different colors. */
  @JSName("color")
  var color_StrictButtonProps: js.UndefOr[
    SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube
  ] = js.native
  /** A button can reduce its padding to fit into tighter spaces. */
  var compact: js.UndefOr[Boolean] = js.native
  /** Shorthand for primary content. */
  var content: js.UndefOr[SemanticShorthandContent] = js.native
  /** A button can be aligned to the left or right of its container. */
  var floated: js.UndefOr[SemanticFLOATS] = js.native
  /** A button can take the width of its container. */
  var fluid: js.UndefOr[Boolean] = js.native
  /** Add an Icon by name, props object, or pass an <Icon />. */
  var icon: js.UndefOr[
    Boolean | (SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
    ])
  ] = js.native
  /** A button can be formatted to appear on dark backgrounds. */
  var inverted: js.UndefOr[Boolean] = js.native
  /** Add a Label by text, props object, or pass a <Label />. */
  var label: js.UndefOr[
    SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
    ]
  ] = js.native
  /** A labeled button can format a Label or Icon to appear on the left or right. */
  var labelPosition: js.UndefOr[right | left] = js.native
  /** A button can show a loading indicator. */
  var loading: js.UndefOr[Boolean] = js.native
  /** A button can hint towards a negative consequence. */
  var negative: js.UndefOr[Boolean] = js.native
  /**
    * Called after user's click.
    * @param {SyntheticEvent} event - React's original SyntheticEvent.
    * @param {object} data - All props.
    */
  @JSName("onClick")
  var onClick_StrictButtonProps: js.UndefOr[
    js.Function2[/* event */ ReactMouseEventFrom[HTMLButtonElement], /* data */ ButtonProps, Unit]
  ] = js.native
  /** A button can hint towards a positive consequence. */
  var positive: js.UndefOr[Boolean] = js.native
  /** A button can be formatted to show different levels of emphasis. */
  var primary: js.UndefOr[Boolean] = js.native
  /** A button can be formatted to show different levels of emphasis. */
  var secondary: js.UndefOr[Boolean] = js.native
  /** A button can have different sizes. */
  var size: js.UndefOr[SemanticSIZES] = js.native
  /** A button can receive focus. */
  @JSName("tabIndex")
  var tabIndex_StrictButtonProps: js.UndefOr[Double | String] = js.native
  /** A button can be formatted to toggle on and off. */
  var toggle: js.UndefOr[Boolean] = js.native
}

object StrictButtonProps {
  @scala.inline
  def apply(
    about: String = null,
    accessKey: String = null,
    active: js.UndefOr[Boolean] = js.undefined,
    animated: Boolean | fade | vertical = null,
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
    `aria-orientation`: horizontal | typingsJapgolly.react.reactStrings.vertical = null,
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
    attached: Boolean | left | right | top | bottom = null,
    autoCapitalize: String = null,
    autoCorrect: String = null,
    autoFocus: js.UndefOr[Boolean] = js.undefined,
    autoSave: String = null,
    basic: js.UndefOr[Boolean] = js.undefined,
    children: VdomNode = null,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    color: SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube = null,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandContent = null,
    contentEditable: js.UndefOr[Boolean] = js.undefined,
    contextMenu: String = null,
    dangerouslySetInnerHTML: AnonHtml = null,
    datatype: String = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined,
    defaultValue: String | js.Array[String] = null,
    dir: String = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    draggable: js.UndefOr[Boolean] = js.undefined,
    floated: SemanticFLOATS = null,
    fluid: js.UndefOr[Boolean] = js.undefined,
    form: String = null,
    formAction: String = null,
    formEncType: String = null,
    formMethod: String = null,
    formNoValidate: js.UndefOr[Boolean] = js.undefined,
    formTarget: String = null,
    hidden: js.UndefOr[Boolean] = js.undefined,
    icon: Boolean | (SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
    ]) = null,
    id: String = null,
    inlist: js.Any = null,
    inputMode: String = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    is: String = null,
    itemID: String = null,
    itemProp: String = null,
    itemRef: String = null,
    itemScope: js.UndefOr[Boolean] = js.undefined,
    itemType: String = null,
    label: SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
    ] = null,
    labelPosition: right | left = null,
    lang: String = null,
    loading: js.UndefOr[Boolean] = js.undefined,
    name: String = null,
    negative: js.UndefOr[Boolean] = js.undefined,
    onAbort: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onAnimationEnd: ReactAnimationEventFrom[HTMLButtonElement] => Callback = null,
    onAnimationIteration: ReactAnimationEventFrom[HTMLButtonElement] => Callback = null,
    onAnimationStart: ReactAnimationEventFrom[HTMLButtonElement] => Callback = null,
    onAuxClick: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onBeforeInput: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onBlur: ReactFocusEventFrom[HTMLButtonElement] => Callback = null,
    onCanPlay: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onCanPlayThrough: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onChange: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLButtonElement], /* data */ ButtonProps) => Callback = null,
    onCompositionEnd: ReactCompositionEventFrom[HTMLButtonElement] => Callback = null,
    onCompositionStart: ReactCompositionEventFrom[HTMLButtonElement] => Callback = null,
    onCompositionUpdate: ReactCompositionEventFrom[HTMLButtonElement] => Callback = null,
    onContextMenu: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onCopy: ReactClipboardEventFrom[HTMLButtonElement] => Callback = null,
    onCut: ReactClipboardEventFrom[HTMLButtonElement] => Callback = null,
    onDoubleClick: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onDrag: ReactDragEventFrom[HTMLButtonElement] => Callback = null,
    onDragEnd: ReactDragEventFrom[HTMLButtonElement] => Callback = null,
    onDragEnter: ReactDragEventFrom[HTMLButtonElement] => Callback = null,
    onDragExit: ReactDragEventFrom[HTMLButtonElement] => Callback = null,
    onDragLeave: ReactDragEventFrom[HTMLButtonElement] => Callback = null,
    onDragOver: ReactDragEventFrom[HTMLButtonElement] => Callback = null,
    onDragStart: ReactDragEventFrom[HTMLButtonElement] => Callback = null,
    onDrop: ReactDragEventFrom[HTMLButtonElement] => Callback = null,
    onDurationChange: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onEmptied: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onEncrypted: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onEnded: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onError: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onFocus: ReactFocusEventFrom[HTMLButtonElement] => Callback = null,
    onInput: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onInvalid: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onKeyDown: ReactKeyboardEventFrom[HTMLButtonElement] => Callback = null,
    onKeyPress: ReactKeyboardEventFrom[HTMLButtonElement] => Callback = null,
    onKeyUp: ReactKeyboardEventFrom[HTMLButtonElement] => Callback = null,
    onLoad: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onLoadStart: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onLoadedData: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onLoadedMetadata: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onMouseDown: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onMouseEnter: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onMouseLeave: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onMouseMove: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onMouseOut: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onMouseOver: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onMouseUp: ReactMouseEventFrom[HTMLButtonElement] => Callback = null,
    onPaste: ReactClipboardEventFrom[HTMLButtonElement] => Callback = null,
    onPause: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onPlay: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onPlaying: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onPointerCancel: ReactPointerEventFrom[HTMLButtonElement] => Callback = null,
    onPointerDown: ReactPointerEventFrom[HTMLButtonElement] => Callback = null,
    onPointerEnter: ReactPointerEventFrom[HTMLButtonElement] => Callback = null,
    onPointerLeave: ReactPointerEventFrom[HTMLButtonElement] => Callback = null,
    onPointerMove: ReactPointerEventFrom[HTMLButtonElement] => Callback = null,
    onPointerOut: ReactPointerEventFrom[HTMLButtonElement] => Callback = null,
    onPointerOver: ReactPointerEventFrom[HTMLButtonElement] => Callback = null,
    onPointerUp: ReactPointerEventFrom[HTMLButtonElement] => Callback = null,
    onProgress: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onRateChange: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onReset: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onScroll: ReactUIEventFrom[HTMLButtonElement] => Callback = null,
    onSeeked: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onSeeking: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onSelect: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onStalled: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onSubmit: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onSuspend: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onTimeUpdate: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onTouchCancel: ReactTouchEventFrom[HTMLButtonElement] => Callback = null,
    onTouchEnd: ReactTouchEventFrom[HTMLButtonElement] => Callback = null,
    onTouchMove: ReactTouchEventFrom[HTMLButtonElement] => Callback = null,
    onTouchStart: ReactTouchEventFrom[HTMLButtonElement] => Callback = null,
    onTransitionEnd: ReactTransitionEventFrom[HTMLButtonElement] => Callback = null,
    onVolumeChange: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onWaiting: ReactEventFrom[HTMLButtonElement] => Callback = null,
    onWheel: ReactWheelEventFrom[HTMLButtonElement] => Callback = null,
    placeholder: String = null,
    positive: js.UndefOr[Boolean] = js.undefined,
    prefix: String = null,
    primary: js.UndefOr[Boolean] = js.undefined,
    property: String = null,
    radioGroup: String = null,
    resource: String = null,
    results: Int | Double = null,
    role: String = null,
    secondary: js.UndefOr[Boolean] = js.undefined,
    security: String = null,
    size: SemanticSIZES = null,
    slot: String = null,
    spellCheck: js.UndefOr[Boolean] = js.undefined,
    style: CSSProperties = null,
    suppressContentEditableWarning: js.UndefOr[Boolean] = js.undefined,
    suppressHydrationWarning: js.UndefOr[Boolean] = js.undefined,
    tabIndex: Double | String = null,
    title: String = null,
    toggle: js.UndefOr[Boolean] = js.undefined,
    `type`: submit | reset | button = null,
    typeof: String = null,
    unselectable: on | off = null,
    value: String | js.Array[String] | Double = null,
    vocab: String = null
  ): StrictButtonProps = {
    val __obj = js.Dynamic.literal()
    if (about != null) __obj.updateDynamic("about")(about.asInstanceOf[js.Any])
    if (accessKey != null) __obj.updateDynamic("accessKey")(accessKey.asInstanceOf[js.Any])
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active.asInstanceOf[js.Any])
    if (animated != null) __obj.updateDynamic("animated")(animated.asInstanceOf[js.Any])
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
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (autoCapitalize != null) __obj.updateDynamic("autoCapitalize")(autoCapitalize.asInstanceOf[js.Any])
    if (autoCorrect != null) __obj.updateDynamic("autoCorrect")(autoCorrect.asInstanceOf[js.Any])
    if (!js.isUndefined(autoFocus)) __obj.updateDynamic("autoFocus")(autoFocus.asInstanceOf[js.Any])
    if (autoSave != null) __obj.updateDynamic("autoSave")(autoSave.asInstanceOf[js.Any])
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (!js.isUndefined(circular)) __obj.updateDynamic("circular")(circular.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (color != null) __obj.updateDynamic("color")(color.asInstanceOf[js.Any])
    if (!js.isUndefined(compact)) __obj.updateDynamic("compact")(compact.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(contentEditable)) __obj.updateDynamic("contentEditable")(contentEditable.asInstanceOf[js.Any])
    if (contextMenu != null) __obj.updateDynamic("contextMenu")(contextMenu.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (datatype != null) __obj.updateDynamic("datatype")(datatype.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
    if (defaultValue != null) __obj.updateDynamic("defaultValue")(defaultValue.asInstanceOf[js.Any])
    if (dir != null) __obj.updateDynamic("dir")(dir.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled.asInstanceOf[js.Any])
    if (!js.isUndefined(draggable)) __obj.updateDynamic("draggable")(draggable.asInstanceOf[js.Any])
    if (floated != null) __obj.updateDynamic("floated")(floated.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
    if (form != null) __obj.updateDynamic("form")(form.asInstanceOf[js.Any])
    if (formAction != null) __obj.updateDynamic("formAction")(formAction.asInstanceOf[js.Any])
    if (formEncType != null) __obj.updateDynamic("formEncType")(formEncType.asInstanceOf[js.Any])
    if (formMethod != null) __obj.updateDynamic("formMethod")(formMethod.asInstanceOf[js.Any])
    if (!js.isUndefined(formNoValidate)) __obj.updateDynamic("formNoValidate")(formNoValidate.asInstanceOf[js.Any])
    if (formTarget != null) __obj.updateDynamic("formTarget")(formTarget.asInstanceOf[js.Any])
    if (!js.isUndefined(hidden)) __obj.updateDynamic("hidden")(hidden.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (id != null) __obj.updateDynamic("id")(id.asInstanceOf[js.Any])
    if (inlist != null) __obj.updateDynamic("inlist")(inlist.asInstanceOf[js.Any])
    if (inputMode != null) __obj.updateDynamic("inputMode")(inputMode.asInstanceOf[js.Any])
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted.asInstanceOf[js.Any])
    if (is != null) __obj.updateDynamic("is")(is.asInstanceOf[js.Any])
    if (itemID != null) __obj.updateDynamic("itemID")(itemID.asInstanceOf[js.Any])
    if (itemProp != null) __obj.updateDynamic("itemProp")(itemProp.asInstanceOf[js.Any])
    if (itemRef != null) __obj.updateDynamic("itemRef")(itemRef.asInstanceOf[js.Any])
    if (!js.isUndefined(itemScope)) __obj.updateDynamic("itemScope")(itemScope.asInstanceOf[js.Any])
    if (itemType != null) __obj.updateDynamic("itemType")(itemType.asInstanceOf[js.Any])
    if (label != null) __obj.updateDynamic("label")(label.asInstanceOf[js.Any])
    if (labelPosition != null) __obj.updateDynamic("labelPosition")(labelPosition.asInstanceOf[js.Any])
    if (lang != null) __obj.updateDynamic("lang")(lang.asInstanceOf[js.Any])
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading.asInstanceOf[js.Any])
    if (name != null) __obj.updateDynamic("name")(name.asInstanceOf[js.Any])
    if (!js.isUndefined(negative)) __obj.updateDynamic("negative")(negative.asInstanceOf[js.Any])
    if (onAbort != null) __obj.updateDynamic("onAbort")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onAbort(t0).runNow()))
    if (onAnimationEnd != null) __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1((t0: ReactAnimationEventFrom[HTMLButtonElement]) => onAnimationEnd(t0).runNow()))
    if (onAnimationIteration != null) __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1((t0: ReactAnimationEventFrom[HTMLButtonElement]) => onAnimationIteration(t0).runNow()))
    if (onAnimationStart != null) __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1((t0: ReactAnimationEventFrom[HTMLButtonElement]) => onAnimationStart(t0).runNow()))
    if (onAuxClick != null) __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onAuxClick(t0).runNow()))
    if (onBeforeInput != null) __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onBeforeInput(t0).runNow()))
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction1((t0: ReactFocusEventFrom[HTMLButtonElement]) => onBlur(t0).runNow()))
    if (onCanPlay != null) __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onCanPlay(t0).runNow()))
    if (onCanPlayThrough != null) __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onCanPlayThrough(t0).runNow()))
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onChange(t0).runNow()))
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLButtonElement], t1: /* data */ ButtonProps) => onClick(t0, t1).runNow()))
    if (onCompositionEnd != null) __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1((t0: ReactCompositionEventFrom[HTMLButtonElement]) => onCompositionEnd(t0).runNow()))
    if (onCompositionStart != null) __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1((t0: ReactCompositionEventFrom[HTMLButtonElement]) => onCompositionStart(t0).runNow()))
    if (onCompositionUpdate != null) __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1((t0: ReactCompositionEventFrom[HTMLButtonElement]) => onCompositionUpdate(t0).runNow()))
    if (onContextMenu != null) __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onContextMenu(t0).runNow()))
    if (onCopy != null) __obj.updateDynamic("onCopy")(js.Any.fromFunction1((t0: ReactClipboardEventFrom[HTMLButtonElement]) => onCopy(t0).runNow()))
    if (onCut != null) __obj.updateDynamic("onCut")(js.Any.fromFunction1((t0: ReactClipboardEventFrom[HTMLButtonElement]) => onCut(t0).runNow()))
    if (onDoubleClick != null) __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onDoubleClick(t0).runNow()))
    if (onDrag != null) __obj.updateDynamic("onDrag")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLButtonElement]) => onDrag(t0).runNow()))
    if (onDragEnd != null) __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLButtonElement]) => onDragEnd(t0).runNow()))
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLButtonElement]) => onDragEnter(t0).runNow()))
    if (onDragExit != null) __obj.updateDynamic("onDragExit")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLButtonElement]) => onDragExit(t0).runNow()))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLButtonElement]) => onDragLeave(t0).runNow()))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLButtonElement]) => onDragOver(t0).runNow()))
    if (onDragStart != null) __obj.updateDynamic("onDragStart")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLButtonElement]) => onDragStart(t0).runNow()))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLButtonElement]) => onDrop(t0).runNow()))
    if (onDurationChange != null) __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onDurationChange(t0).runNow()))
    if (onEmptied != null) __obj.updateDynamic("onEmptied")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onEmptied(t0).runNow()))
    if (onEncrypted != null) __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onEncrypted(t0).runNow()))
    if (onEnded != null) __obj.updateDynamic("onEnded")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onEnded(t0).runNow()))
    if (onError != null) __obj.updateDynamic("onError")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onError(t0).runNow()))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction1((t0: ReactFocusEventFrom[HTMLButtonElement]) => onFocus(t0).runNow()))
    if (onInput != null) __obj.updateDynamic("onInput")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onInput(t0).runNow()))
    if (onInvalid != null) __obj.updateDynamic("onInvalid")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onInvalid(t0).runNow()))
    if (onKeyDown != null) __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1((t0: ReactKeyboardEventFrom[HTMLButtonElement]) => onKeyDown(t0).runNow()))
    if (onKeyPress != null) __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1((t0: ReactKeyboardEventFrom[HTMLButtonElement]) => onKeyPress(t0).runNow()))
    if (onKeyUp != null) __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1((t0: ReactKeyboardEventFrom[HTMLButtonElement]) => onKeyUp(t0).runNow()))
    if (onLoad != null) __obj.updateDynamic("onLoad")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onLoad(t0).runNow()))
    if (onLoadStart != null) __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onLoadStart(t0).runNow()))
    if (onLoadedData != null) __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onLoadedData(t0).runNow()))
    if (onLoadedMetadata != null) __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onLoadedMetadata(t0).runNow()))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onMouseDown(t0).runNow()))
    if (onMouseEnter != null) __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onMouseEnter(t0).runNow()))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onMouseLeave(t0).runNow()))
    if (onMouseMove != null) __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onMouseMove(t0).runNow()))
    if (onMouseOut != null) __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onMouseOut(t0).runNow()))
    if (onMouseOver != null) __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onMouseOver(t0).runNow()))
    if (onMouseUp != null) __obj.updateDynamic("onMouseUp")(js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLButtonElement]) => onMouseUp(t0).runNow()))
    if (onPaste != null) __obj.updateDynamic("onPaste")(js.Any.fromFunction1((t0: ReactClipboardEventFrom[HTMLButtonElement]) => onPaste(t0).runNow()))
    if (onPause != null) __obj.updateDynamic("onPause")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onPause(t0).runNow()))
    if (onPlay != null) __obj.updateDynamic("onPlay")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onPlay(t0).runNow()))
    if (onPlaying != null) __obj.updateDynamic("onPlaying")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onPlaying(t0).runNow()))
    if (onPointerCancel != null) __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLButtonElement]) => onPointerCancel(t0).runNow()))
    if (onPointerDown != null) __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLButtonElement]) => onPointerDown(t0).runNow()))
    if (onPointerEnter != null) __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLButtonElement]) => onPointerEnter(t0).runNow()))
    if (onPointerLeave != null) __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLButtonElement]) => onPointerLeave(t0).runNow()))
    if (onPointerMove != null) __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLButtonElement]) => onPointerMove(t0).runNow()))
    if (onPointerOut != null) __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLButtonElement]) => onPointerOut(t0).runNow()))
    if (onPointerOver != null) __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLButtonElement]) => onPointerOver(t0).runNow()))
    if (onPointerUp != null) __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLButtonElement]) => onPointerUp(t0).runNow()))
    if (onProgress != null) __obj.updateDynamic("onProgress")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onProgress(t0).runNow()))
    if (onRateChange != null) __obj.updateDynamic("onRateChange")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onRateChange(t0).runNow()))
    if (onReset != null) __obj.updateDynamic("onReset")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onReset(t0).runNow()))
    if (onScroll != null) __obj.updateDynamic("onScroll")(js.Any.fromFunction1((t0: ReactUIEventFrom[HTMLButtonElement]) => onScroll(t0).runNow()))
    if (onSeeked != null) __obj.updateDynamic("onSeeked")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onSeeked(t0).runNow()))
    if (onSeeking != null) __obj.updateDynamic("onSeeking")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onSeeking(t0).runNow()))
    if (onSelect != null) __obj.updateDynamic("onSelect")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onSelect(t0).runNow()))
    if (onStalled != null) __obj.updateDynamic("onStalled")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onStalled(t0).runNow()))
    if (onSubmit != null) __obj.updateDynamic("onSubmit")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onSubmit(t0).runNow()))
    if (onSuspend != null) __obj.updateDynamic("onSuspend")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onSuspend(t0).runNow()))
    if (onTimeUpdate != null) __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onTimeUpdate(t0).runNow()))
    if (onTouchCancel != null) __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLButtonElement]) => onTouchCancel(t0).runNow()))
    if (onTouchEnd != null) __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLButtonElement]) => onTouchEnd(t0).runNow()))
    if (onTouchMove != null) __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLButtonElement]) => onTouchMove(t0).runNow()))
    if (onTouchStart != null) __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLButtonElement]) => onTouchStart(t0).runNow()))
    if (onTransitionEnd != null) __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1((t0: ReactTransitionEventFrom[HTMLButtonElement]) => onTransitionEnd(t0).runNow()))
    if (onVolumeChange != null) __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onVolumeChange(t0).runNow()))
    if (onWaiting != null) __obj.updateDynamic("onWaiting")(js.Any.fromFunction1((t0: ReactEventFrom[HTMLButtonElement]) => onWaiting(t0).runNow()))
    if (onWheel != null) __obj.updateDynamic("onWheel")(js.Any.fromFunction1((t0: ReactWheelEventFrom[HTMLButtonElement]) => onWheel(t0).runNow()))
    if (placeholder != null) __obj.updateDynamic("placeholder")(placeholder.asInstanceOf[js.Any])
    if (!js.isUndefined(positive)) __obj.updateDynamic("positive")(positive.asInstanceOf[js.Any])
    if (prefix != null) __obj.updateDynamic("prefix")(prefix.asInstanceOf[js.Any])
    if (!js.isUndefined(primary)) __obj.updateDynamic("primary")(primary.asInstanceOf[js.Any])
    if (property != null) __obj.updateDynamic("property")(property.asInstanceOf[js.Any])
    if (radioGroup != null) __obj.updateDynamic("radioGroup")(radioGroup.asInstanceOf[js.Any])
    if (resource != null) __obj.updateDynamic("resource")(resource.asInstanceOf[js.Any])
    if (results != null) __obj.updateDynamic("results")(results.asInstanceOf[js.Any])
    if (role != null) __obj.updateDynamic("role")(role.asInstanceOf[js.Any])
    if (!js.isUndefined(secondary)) __obj.updateDynamic("secondary")(secondary.asInstanceOf[js.Any])
    if (security != null) __obj.updateDynamic("security")(security.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (slot != null) __obj.updateDynamic("slot")(slot.asInstanceOf[js.Any])
    if (!js.isUndefined(spellCheck)) __obj.updateDynamic("spellCheck")(spellCheck.asInstanceOf[js.Any])
    if (style != null) __obj.updateDynamic("style")(style.asInstanceOf[js.Any])
    if (!js.isUndefined(suppressContentEditableWarning)) __obj.updateDynamic("suppressContentEditableWarning")(suppressContentEditableWarning.asInstanceOf[js.Any])
    if (!js.isUndefined(suppressHydrationWarning)) __obj.updateDynamic("suppressHydrationWarning")(suppressHydrationWarning.asInstanceOf[js.Any])
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (title != null) __obj.updateDynamic("title")(title.asInstanceOf[js.Any])
    if (!js.isUndefined(toggle)) __obj.updateDynamic("toggle")(toggle.asInstanceOf[js.Any])
    if (`type` != null) __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (typeof != null) __obj.updateDynamic("typeof")(typeof.asInstanceOf[js.Any])
    if (unselectable != null) __obj.updateDynamic("unselectable")(unselectable.asInstanceOf[js.Any])
    if (value != null) __obj.updateDynamic("value")(value.asInstanceOf[js.Any])
    if (vocab != null) __obj.updateDynamic("vocab")(vocab.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictButtonProps]
  }
  @scala.inline
  implicit class StrictButtonPropsOps[Self <: StrictButtonProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withActive(active: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(active)) ret.updateDynamic("active")(active.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutActive: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "active")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAnimated(animated: Boolean | fade | vertical): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (animated != null) ret.updateDynamic("animated")(animated.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAnimated: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "animated")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAs(as: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (as != null) ret.updateDynamic("as")(as.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAs: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "as")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAttached(attached: Boolean | left | right | top | bottom): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (attached != null) ret.updateDynamic("attached")(attached.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAttached: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "attached")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withBasic(basic: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(basic)) ret.updateDynamic("basic")(basic.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutBasic: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "basic")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withCircular(circular: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(circular)) ret.updateDynamic("circular")(circular.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCircular: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "circular")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withColor(color: SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (color != null) ret.updateDynamic("color")(color.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutColor: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "color")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withCompact(compact: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(compact)) ret.updateDynamic("compact")(compact.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCompact: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "compact")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withContentVdomElement(content: VdomElement): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (content != null) ret.updateDynamic("content")(content.rawElement.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withContent(content: SemanticShorthandContent): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (content != null) ret.updateDynamic("content")(content.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutContent: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "content")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFloated(floated: SemanticFLOATS): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (floated != null) ret.updateDynamic("floated")(floated.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutFloated: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "floated")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFluid(fluid: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(fluid)) ret.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutFluid: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "fluid")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withIconVdomElement(icon: VdomElement): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (icon != null) ret.updateDynamic("icon")(icon.rawElement.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withIconFunction3(
      icon: (/* component */ ReactType[js.Any], js.Any, /* children */ js.UndefOr[Node | ReactNodeArray]) => CallbackTo[CallbackTo[Element | Null]]
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("icon")(js.Any.fromFunction3((t0: /* component */ ReactType[js.Any], t1: js.Any, t2: /* children */ js.UndefOr[Node | ReactNodeArray]) => icon(t0, t1, t2).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withIcon(
      icon: Boolean | (SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
        ])
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (icon != null) ret.updateDynamic("icon")(icon.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutIcon: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "icon")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withInverted(inverted: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(inverted)) ret.updateDynamic("inverted")(inverted.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutInverted: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "inverted")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLabelVdomElement(label: VdomElement): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (label != null) ret.updateDynamic("label")(label.rawElement.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLabelFunction3(
      label: (/* component */ ReactType[js.Any], js.Any, /* children */ js.UndefOr[Node | ReactNodeArray]) => CallbackTo[CallbackTo[Element | Null]]
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("label")(js.Any.fromFunction3((t0: /* component */ ReactType[js.Any], t1: js.Any, t2: /* children */ js.UndefOr[Node | ReactNodeArray]) => label(t0, t1, t2).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLabel(
      label: SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
        ]
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (label != null) ret.updateDynamic("label")(label.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutLabel: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "label")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLabelPosition(labelPosition: right | left): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (labelPosition != null) ret.updateDynamic("labelPosition")(labelPosition.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutLabelPosition: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "labelPosition")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLoading(loading: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(loading)) ret.updateDynamic("loading")(loading.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutLoading: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "loading")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNegative(negative: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(negative)) ret.updateDynamic("negative")(negative.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNegative: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "negative")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnClick(onClick: (/* event */ ReactMouseEventFrom[HTMLButtonElement], /* data */ ButtonProps) => Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onClick != null) ret.updateDynamic("onClick")(js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLButtonElement], t1: /* data */ ButtonProps) => onClick(t0, t1).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnClick: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onClick")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPositive(positive: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(positive)) ret.updateDynamic("positive")(positive.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPositive: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "positive")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPrimary(primary: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(primary)) ret.updateDynamic("primary")(primary.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPrimary: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "primary")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withSecondary(secondary: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(secondary)) ret.updateDynamic("secondary")(secondary.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutSecondary: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "secondary")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withSize(size: SemanticSIZES): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (size != null) ret.updateDynamic("size")(size.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutSize: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "size")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withTabIndex(tabIndex: Double | String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (tabIndex != null) ret.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutTabIndex: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "tabIndex")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withToggle(toggle: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(toggle)) ret.updateDynamic("toggle")(toggle.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutToggle: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "toggle")
        ret.asInstanceOf[Self]
    }
  }
  
}


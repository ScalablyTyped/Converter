package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
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
import org.scalajs.dom.raw.HTMLButtonElement
import typings.react.Anon_Html
import typings.react.reactMod.CSSProperties
import typings.react.reactStrings.`additions text`
import typings.react.reactStrings.`inline`
import typings.react.reactStrings.additions
import typings.react.reactStrings.all
import typings.react.reactStrings.ascending
import typings.react.reactStrings.assertive
import typings.react.reactStrings.both
import typings.react.reactStrings.button
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
import typings.react.reactStrings.reset
import typings.react.reactStrings.spelling
import typings.react.reactStrings.step
import typings.react.reactStrings.submit
import typings.react.reactStrings.text
import typings.react.reactStrings.time
import typings.react.reactStrings.tree
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`google plus`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.facebook
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.fade
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.instagram
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.left
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.linkedin
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.right
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.twitter
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.vertical
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.vk
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.youtube
import typings.semanticDashUiDashReact.srcElementsButtonButtonMod.ButtonProps
import typings.semanticDashUiDashReact.srcElementsButtonMod.default
import typings.semanticDashUiDashReact.srcElementsIconIconMod.IconProps
import typings.semanticDashUiDashReact.srcElementsLabelLabelMod.LabelProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticCOLORS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticFLOATS
import typings.semanticDashUiDashReact.srcGenericMod.SemanticSIZES
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Button {
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
    `aria-orientation`: horizontal | typings.react.reactStrings.vertical = null,
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
    circular: js.UndefOr[Boolean] = js.undefined,
    className: String = null,
    color: SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube = null,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandContent = null,
    contentEditable: js.UndefOr[Boolean] = js.undefined,
    contextMenu: String = null,
    dangerouslySetInnerHTML: Anon_Html = null,
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
    icon: Boolean | SemanticShorthandItem[IconProps] = null,
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
    label: SemanticShorthandItem[LabelProps] = null,
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
  )(
    children: ChildArg*
  ): UnmountedWithRoot[ButtonProps, default, Unit, ButtonProps] = {
    val __obj = js.Dynamic.literal()
  
      if (about != null) __obj.updateDynamic("about")(about)
    if (accessKey != null) __obj.updateDynamic("accessKey")(accessKey)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (animated != null) __obj.updateDynamic("animated")(animated.asInstanceOf[js.Any])
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
    if (attached != null) __obj.updateDynamic("attached")(attached.asInstanceOf[js.Any])
    if (autoCapitalize != null) __obj.updateDynamic("autoCapitalize")(autoCapitalize)
    if (autoCorrect != null) __obj.updateDynamic("autoCorrect")(autoCorrect)
    if (!js.isUndefined(autoFocus)) __obj.updateDynamic("autoFocus")(autoFocus)
    if (autoSave != null) __obj.updateDynamic("autoSave")(autoSave)
    if (!js.isUndefined(basic)) __obj.updateDynamic("basic")(basic)
    if (!js.isUndefined(circular)) __obj.updateDynamic("circular")(circular)
    if (className != null) __obj.updateDynamic("className")(className)
    if (color != null) __obj.updateDynamic("color")(color.asInstanceOf[js.Any])
    if (!js.isUndefined(compact)) __obj.updateDynamic("compact")(compact)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(contentEditable)) __obj.updateDynamic("contentEditable")(contentEditable)
    if (contextMenu != null) __obj.updateDynamic("contextMenu")(contextMenu)
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    if (datatype != null) __obj.updateDynamic("datatype")(datatype)
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked)
    if (defaultValue != null) __obj.updateDynamic("defaultValue")(defaultValue.asInstanceOf[js.Any])
    if (dir != null) __obj.updateDynamic("dir")(dir)
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(draggable)) __obj.updateDynamic("draggable")(draggable)
    if (floated != null) __obj.updateDynamic("floated")(floated)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (form != null) __obj.updateDynamic("form")(form)
    if (formAction != null) __obj.updateDynamic("formAction")(formAction)
    if (formEncType != null) __obj.updateDynamic("formEncType")(formEncType)
    if (formMethod != null) __obj.updateDynamic("formMethod")(formMethod)
    if (!js.isUndefined(formNoValidate)) __obj.updateDynamic("formNoValidate")(formNoValidate)
    if (formTarget != null) __obj.updateDynamic("formTarget")(formTarget)
    if (!js.isUndefined(hidden)) __obj.updateDynamic("hidden")(hidden)
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (id != null) __obj.updateDynamic("id")(id)
    if (inlist != null) __obj.updateDynamic("inlist")(inlist)
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
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (name != null) __obj.updateDynamic("name")(name)
    if (!js.isUndefined(negative)) __obj.updateDynamic("negative")(negative)
    if (onAbort != null) __obj.updateDynamic("onAbort")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onAbort(t0).runNow())))
    if (onAnimationEnd != null) __obj.updateDynamic("onAnimationEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onAnimationEnd(t0).runNow())))
    if (onAnimationIteration != null) __obj.updateDynamic("onAnimationIteration")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onAnimationIteration(t0).runNow())))
    if (onAnimationStart != null) __obj.updateDynamic("onAnimationStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactAnimationEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onAnimationStart(t0).runNow())))
    if (onAuxClick != null) __obj.updateDynamic("onAuxClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onAuxClick(t0).runNow())))
    if (onBeforeInput != null) __obj.updateDynamic("onBeforeInput")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onBeforeInput(t0).runNow())))
    if (onBlur != null) __obj.updateDynamic("onBlur")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactFocusEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onBlur(t0).runNow())))
    if (onCanPlay != null) __obj.updateDynamic("onCanPlay")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onCanPlay(t0).runNow())))
    if (onCanPlayThrough != null) __obj.updateDynamic("onCanPlayThrough")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onCanPlayThrough(t0).runNow())))
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onChange(t0).runNow())))
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement], t1: /* data */ typings.semanticDashUiDashReact.srcElementsButtonButtonMod.ButtonProps) => onClick(t0, t1).runNow())))
    if (onCompositionEnd != null) __obj.updateDynamic("onCompositionEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onCompositionEnd(t0).runNow())))
    if (onCompositionStart != null) __obj.updateDynamic("onCompositionStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onCompositionStart(t0).runNow())))
    if (onCompositionUpdate != null) __obj.updateDynamic("onCompositionUpdate")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactCompositionEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onCompositionUpdate(t0).runNow())))
    if (onContextMenu != null) __obj.updateDynamic("onContextMenu")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onContextMenu(t0).runNow())))
    if (onCopy != null) __obj.updateDynamic("onCopy")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onCopy(t0).runNow())))
    if (onCut != null) __obj.updateDynamic("onCut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onCut(t0).runNow())))
    if (onDoubleClick != null) __obj.updateDynamic("onDoubleClick")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDoubleClick(t0).runNow())))
    if (onDrag != null) __obj.updateDynamic("onDrag")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDrag(t0).runNow())))
    if (onDragEnd != null) __obj.updateDynamic("onDragEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDragEnd(t0).runNow())))
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDragEnter(t0).runNow())))
    if (onDragExit != null) __obj.updateDynamic("onDragExit")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDragExit(t0).runNow())))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDragLeave(t0).runNow())))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDragOver(t0).runNow())))
    if (onDragStart != null) __obj.updateDynamic("onDragStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDragStart(t0).runNow())))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDrop(t0).runNow())))
    if (onDurationChange != null) __obj.updateDynamic("onDurationChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onDurationChange(t0).runNow())))
    if (onEmptied != null) __obj.updateDynamic("onEmptied")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onEmptied(t0).runNow())))
    if (onEncrypted != null) __obj.updateDynamic("onEncrypted")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onEncrypted(t0).runNow())))
    if (onEnded != null) __obj.updateDynamic("onEnded")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onEnded(t0).runNow())))
    if (onError != null) __obj.updateDynamic("onError")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onError(t0).runNow())))
    if (onFocus != null) __obj.updateDynamic("onFocus")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactFocusEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onFocus(t0).runNow())))
    if (onInput != null) __obj.updateDynamic("onInput")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onInput(t0).runNow())))
    if (onInvalid != null) __obj.updateDynamic("onInvalid")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onInvalid(t0).runNow())))
    if (onKeyDown != null) __obj.updateDynamic("onKeyDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onKeyDown(t0).runNow())))
    if (onKeyPress != null) __obj.updateDynamic("onKeyPress")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onKeyPress(t0).runNow())))
    if (onKeyUp != null) __obj.updateDynamic("onKeyUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactKeyboardEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onKeyUp(t0).runNow())))
    if (onLoad != null) __obj.updateDynamic("onLoad")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onLoad(t0).runNow())))
    if (onLoadStart != null) __obj.updateDynamic("onLoadStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onLoadStart(t0).runNow())))
    if (onLoadedData != null) __obj.updateDynamic("onLoadedData")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onLoadedData(t0).runNow())))
    if (onLoadedMetadata != null) __obj.updateDynamic("onLoadedMetadata")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onLoadedMetadata(t0).runNow())))
    if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onMouseDown(t0).runNow())))
    if (onMouseEnter != null) __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onMouseEnter(t0).runNow())))
    if (onMouseLeave != null) __obj.updateDynamic("onMouseLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onMouseLeave(t0).runNow())))
    if (onMouseMove != null) __obj.updateDynamic("onMouseMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onMouseMove(t0).runNow())))
    if (onMouseOut != null) __obj.updateDynamic("onMouseOut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onMouseOut(t0).runNow())))
    if (onMouseOver != null) __obj.updateDynamic("onMouseOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onMouseOver(t0).runNow())))
    if (onMouseUp != null) __obj.updateDynamic("onMouseUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onMouseUp(t0).runNow())))
    if (onPaste != null) __obj.updateDynamic("onPaste")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactClipboardEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPaste(t0).runNow())))
    if (onPause != null) __obj.updateDynamic("onPause")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPause(t0).runNow())))
    if (onPlay != null) __obj.updateDynamic("onPlay")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPlay(t0).runNow())))
    if (onPlaying != null) __obj.updateDynamic("onPlaying")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPlaying(t0).runNow())))
    if (onPointerCancel != null) __obj.updateDynamic("onPointerCancel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPointerCancel(t0).runNow())))
    if (onPointerDown != null) __obj.updateDynamic("onPointerDown")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPointerDown(t0).runNow())))
    if (onPointerEnter != null) __obj.updateDynamic("onPointerEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPointerEnter(t0).runNow())))
    if (onPointerLeave != null) __obj.updateDynamic("onPointerLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPointerLeave(t0).runNow())))
    if (onPointerMove != null) __obj.updateDynamic("onPointerMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPointerMove(t0).runNow())))
    if (onPointerOut != null) __obj.updateDynamic("onPointerOut")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPointerOut(t0).runNow())))
    if (onPointerOver != null) __obj.updateDynamic("onPointerOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPointerOver(t0).runNow())))
    if (onPointerUp != null) __obj.updateDynamic("onPointerUp")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactPointerEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onPointerUp(t0).runNow())))
    if (onProgress != null) __obj.updateDynamic("onProgress")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onProgress(t0).runNow())))
    if (onRateChange != null) __obj.updateDynamic("onRateChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onRateChange(t0).runNow())))
    if (onReset != null) __obj.updateDynamic("onReset")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onReset(t0).runNow())))
    if (onScroll != null) __obj.updateDynamic("onScroll")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactUIEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onScroll(t0).runNow())))
    if (onSeeked != null) __obj.updateDynamic("onSeeked")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onSeeked(t0).runNow())))
    if (onSeeking != null) __obj.updateDynamic("onSeeking")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onSeeking(t0).runNow())))
    if (onSelect != null) __obj.updateDynamic("onSelect")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onSelect(t0).runNow())))
    if (onStalled != null) __obj.updateDynamic("onStalled")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onStalled(t0).runNow())))
    if (onSubmit != null) __obj.updateDynamic("onSubmit")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onSubmit(t0).runNow())))
    if (onSuspend != null) __obj.updateDynamic("onSuspend")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onSuspend(t0).runNow())))
    if (onTimeUpdate != null) __obj.updateDynamic("onTimeUpdate")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onTimeUpdate(t0).runNow())))
    if (onTouchCancel != null) __obj.updateDynamic("onTouchCancel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onTouchCancel(t0).runNow())))
    if (onTouchEnd != null) __obj.updateDynamic("onTouchEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onTouchEnd(t0).runNow())))
    if (onTouchMove != null) __obj.updateDynamic("onTouchMove")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onTouchMove(t0).runNow())))
    if (onTouchStart != null) __obj.updateDynamic("onTouchStart")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTouchEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onTouchStart(t0).runNow())))
    if (onTransitionEnd != null) __obj.updateDynamic("onTransitionEnd")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactTransitionEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onTransitionEnd(t0).runNow())))
    if (onVolumeChange != null) __obj.updateDynamic("onVolumeChange")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onVolumeChange(t0).runNow())))
    if (onWaiting != null) __obj.updateDynamic("onWaiting")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onWaiting(t0).runNow())))
    if (onWheel != null) __obj.updateDynamic("onWheel")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactWheelEventFrom[org.scalajs.dom.raw.HTMLButtonElement]) => onWheel(t0).runNow())))
    if (placeholder != null) __obj.updateDynamic("placeholder")(placeholder)
    if (!js.isUndefined(positive)) __obj.updateDynamic("positive")(positive)
    if (prefix != null) __obj.updateDynamic("prefix")(prefix)
    if (!js.isUndefined(primary)) __obj.updateDynamic("primary")(primary)
    if (property != null) __obj.updateDynamic("property")(property)
    if (radioGroup != null) __obj.updateDynamic("radioGroup")(radioGroup)
    if (resource != null) __obj.updateDynamic("resource")(resource)
    if (results != null) __obj.updateDynamic("results")(results.asInstanceOf[js.Any])
    if (role != null) __obj.updateDynamic("role")(role)
    if (!js.isUndefined(secondary)) __obj.updateDynamic("secondary")(secondary)
    if (security != null) __obj.updateDynamic("security")(security)
    if (size != null) __obj.updateDynamic("size")(size)
    if (slot != null) __obj.updateDynamic("slot")(slot)
    if (!js.isUndefined(spellCheck)) __obj.updateDynamic("spellCheck")(spellCheck)
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
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticDashUiDashReact.srcElementsButtonButtonMod.ButtonProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcElementsButtonMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcElementsButtonMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsButtonButtonMod.ButtonProps])(children: _*)
  }
}

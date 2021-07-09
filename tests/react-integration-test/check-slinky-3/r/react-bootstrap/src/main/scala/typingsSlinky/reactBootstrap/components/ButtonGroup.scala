package typingsSlinky.reactBootstrap.components

import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.EventTarget
import slinky.core.SyntheticEvent
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
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.anon.Html
import typingsSlinky.react.mod.CSSProperties
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
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ButtonGroup {
  
  @JSImport("react-bootstrap", "ButtonGroup")
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, typingsSlinky.reactBootstrap.mod.ButtonGroup] {
    
    @scala.inline
    def default(value: Boolean): this.type = set("default", value.asInstanceOf[js.Any])
    
    @scala.inline
    def about(value: String): this.type = set("about", value.asInstanceOf[js.Any])
    
    @scala.inline
    def accept(value: String): this.type = set("accept", value.asInstanceOf[js.Any])
    
    @scala.inline
    def acceptCharset(value: String): this.type = set("acceptCharset", value.asInstanceOf[js.Any])
    
    @scala.inline
    def accessKey(value: String): this.type = set("accessKey", value.asInstanceOf[js.Any])
    
    @scala.inline
    def action(value: String): this.type = set("action", value.asInstanceOf[js.Any])
    
    @scala.inline
    def allowFullScreen(value: Boolean): this.type = set("allowFullScreen", value.asInstanceOf[js.Any])
    
    @scala.inline
    def allowTransparency(value: Boolean): this.type = set("allowTransparency", value.asInstanceOf[js.Any])
    
    @scala.inline
    def alt(value: String): this.type = set("alt", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-activedescendant`(value: String): this.type = set("aria-activedescendant", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-atomic`(value: Boolean): this.type = set("aria-atomic", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-autocomplete`(value: none | `inline` | list | both): this.type = set("aria-autocomplete", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-busy`(value: Boolean): this.type = set("aria-busy", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-checked`(value: Boolean | mixed): this.type = set("aria-checked", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-colcount`(value: Double): this.type = set("aria-colcount", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-colindex`(value: Double): this.type = set("aria-colindex", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-colspan`(value: Double): this.type = set("aria-colspan", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-controls`(value: String): this.type = set("aria-controls", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-current`(value: Boolean | page | step | location | date | time): this.type = set("aria-current", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-describedby`(value: String): this.type = set("aria-describedby", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-details`(value: String): this.type = set("aria-details", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-disabled`(value: Boolean): this.type = set("aria-disabled", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-dropeffect`(value: none | copy | execute | link | move | popup): this.type = set("aria-dropeffect", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-errormessage`(value: String): this.type = set("aria-errormessage", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-expanded`(value: Boolean): this.type = set("aria-expanded", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-flowto`(value: String): this.type = set("aria-flowto", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-grabbed`(value: Boolean): this.type = set("aria-grabbed", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-haspopup`(value: Boolean | menu | listbox | tree | grid | dialog): this.type = set("aria-haspopup", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-hidden`(value: Boolean): this.type = set("aria-hidden", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-invalid`(value: Boolean | grammar | spelling): this.type = set("aria-invalid", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-keyshortcuts`(value: String): this.type = set("aria-keyshortcuts", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-label`(value: String): this.type = set("aria-label", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-labelledby`(value: String): this.type = set("aria-labelledby", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-level`(value: Double): this.type = set("aria-level", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-live`(value: off | assertive | polite): this.type = set("aria-live", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-modal`(value: Boolean): this.type = set("aria-modal", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-multiline`(value: Boolean): this.type = set("aria-multiline", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-multiselectable`(value: Boolean): this.type = set("aria-multiselectable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-orientation`(value: horizontal | vertical): this.type = set("aria-orientation", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-owns`(value: String): this.type = set("aria-owns", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-placeholder`(value: String): this.type = set("aria-placeholder", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-posinset`(value: Double): this.type = set("aria-posinset", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-pressed`(value: Boolean | mixed): this.type = set("aria-pressed", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-readonly`(value: Boolean): this.type = set("aria-readonly", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-relevant`(value: additions | (`additions text`) | all | removals | text): this.type = set("aria-relevant", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-required`(value: Boolean): this.type = set("aria-required", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-roledescription`(value: String): this.type = set("aria-roledescription", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-rowcount`(value: Double): this.type = set("aria-rowcount", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-rowindex`(value: Double): this.type = set("aria-rowindex", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-rowspan`(value: Double): this.type = set("aria-rowspan", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-selected`(value: Boolean): this.type = set("aria-selected", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-setsize`(value: Double): this.type = set("aria-setsize", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-sort`(value: none | ascending | descending | other): this.type = set("aria-sort", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-valuemax`(value: Double): this.type = set("aria-valuemax", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-valuemin`(value: Double): this.type = set("aria-valuemin", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-valuenow`(value: Double): this.type = set("aria-valuenow", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `aria-valuetext`(value: String): this.type = set("aria-valuetext", value.asInstanceOf[js.Any])
    
    @scala.inline
    def as(value: String): this.type = set("as", value.asInstanceOf[js.Any])
    
    @scala.inline
    def async(value: Boolean): this.type = set("async", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoCapitalize(value: String): this.type = set("autoCapitalize", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoComplete(value: String): this.type = set("autoComplete", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoCorrect(value: String): this.type = set("autoCorrect", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoFocus(value: Boolean): this.type = set("autoFocus", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoPlay(value: Boolean): this.type = set("autoPlay", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoSave(value: String): this.type = set("autoSave", value.asInstanceOf[js.Any])
    
    @scala.inline
    def block(value: Boolean): this.type = set("block", value.asInstanceOf[js.Any])
    
    @scala.inline
    def bsSize(value: Sizes): this.type = set("bsSize", value.asInstanceOf[js.Any])
    
    @scala.inline
    def bsStyle(value: String): this.type = set("bsStyle", value.asInstanceOf[js.Any])
    
    @scala.inline
    def capture(value: Boolean | String): this.type = set("capture", value.asInstanceOf[js.Any])
    
    @scala.inline
    def cellPadding(value: Double | String): this.type = set("cellPadding", value.asInstanceOf[js.Any])
    
    @scala.inline
    def cellSpacing(value: Double | String): this.type = set("cellSpacing", value.asInstanceOf[js.Any])
    
    @scala.inline
    def challenge(value: String): this.type = set("challenge", value.asInstanceOf[js.Any])
    
    @scala.inline
    def charSet(value: String): this.type = set("charSet", value.asInstanceOf[js.Any])
    
    @scala.inline
    def checked(value: Boolean): this.type = set("checked", value.asInstanceOf[js.Any])
    
    @scala.inline
    def cite(value: String): this.type = set("cite", value.asInstanceOf[js.Any])
    
    @scala.inline
    def classID(value: String): this.type = set("classID", value.asInstanceOf[js.Any])
    
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    @scala.inline
    def colSpan(value: Double): this.type = set("colSpan", value.asInstanceOf[js.Any])
    
    @scala.inline
    def color(value: String): this.type = set("color", value.asInstanceOf[js.Any])
    
    @scala.inline
    def cols(value: Double): this.type = set("cols", value.asInstanceOf[js.Any])
    
    @scala.inline
    def content(value: String): this.type = set("content", value.asInstanceOf[js.Any])
    
    @scala.inline
    def contentEditable(value: Boolean): this.type = set("contentEditable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def contextMenu(value: String): this.type = set("contextMenu", value.asInstanceOf[js.Any])
    
    @scala.inline
    def controls(value: Boolean): this.type = set("controls", value.asInstanceOf[js.Any])
    
    @scala.inline
    def coords(value: String): this.type = set("coords", value.asInstanceOf[js.Any])
    
    @scala.inline
    def crossOrigin(value: String): this.type = set("crossOrigin", value.asInstanceOf[js.Any])
    
    @scala.inline
    def dangerouslySetInnerHTML(value: Html): this.type = set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    @scala.inline
    def data(value: String): this.type = set("data", value.asInstanceOf[js.Any])
    
    @scala.inline
    def datatype(value: String): this.type = set("datatype", value.asInstanceOf[js.Any])
    
    @scala.inline
    def dateTime(value: String): this.type = set("dateTime", value.asInstanceOf[js.Any])
    
    @scala.inline
    def defaultChecked(value: Boolean): this.type = set("defaultChecked", value.asInstanceOf[js.Any])
    
    @scala.inline
    def defaultValue(value: String | js.Array[String]): this.type = set("defaultValue", value.asInstanceOf[js.Any])
    
    @scala.inline
    def defaultValueVarargs(value: String*): this.type = set("defaultValue", js.Array(value :_*))
    
    @scala.inline
    def defer(value: Boolean): this.type = set("defer", value.asInstanceOf[js.Any])
    
    @scala.inline
    def dir(value: String): this.type = set("dir", value.asInstanceOf[js.Any])
    
    @scala.inline
    def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    @scala.inline
    def download(value: js.Any): this.type = set("download", value.asInstanceOf[js.Any])
    
    @scala.inline
    def draggable(value: Boolean): this.type = set("draggable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def encType(value: String): this.type = set("encType", value.asInstanceOf[js.Any])
    
    @scala.inline
    def form(value: String): this.type = set("form", value.asInstanceOf[js.Any])
    
    @scala.inline
    def formAction(value: String): this.type = set("formAction", value.asInstanceOf[js.Any])
    
    @scala.inline
    def formEncType(value: String): this.type = set("formEncType", value.asInstanceOf[js.Any])
    
    @scala.inline
    def formMethod(value: String): this.type = set("formMethod", value.asInstanceOf[js.Any])
    
    @scala.inline
    def formNoValidate(value: Boolean): this.type = set("formNoValidate", value.asInstanceOf[js.Any])
    
    @scala.inline
    def formTarget(value: String): this.type = set("formTarget", value.asInstanceOf[js.Any])
    
    @scala.inline
    def frameBorder(value: Double | String): this.type = set("frameBorder", value.asInstanceOf[js.Any])
    
    @scala.inline
    def headers(value: String): this.type = set("headers", value.asInstanceOf[js.Any])
    
    @scala.inline
    def height(value: Double | String): this.type = set("height", value.asInstanceOf[js.Any])
    
    @scala.inline
    def hidden(value: Boolean): this.type = set("hidden", value.asInstanceOf[js.Any])
    
    @scala.inline
    def high(value: Double): this.type = set("high", value.asInstanceOf[js.Any])
    
    @scala.inline
    def href(value: String): this.type = set("href", value.asInstanceOf[js.Any])
    
    @scala.inline
    def hrefLang(value: String): this.type = set("hrefLang", value.asInstanceOf[js.Any])
    
    @scala.inline
    def htmlFor(value: String): this.type = set("htmlFor", value.asInstanceOf[js.Any])
    
    @scala.inline
    def httpEquiv(value: String): this.type = set("httpEquiv", value.asInstanceOf[js.Any])
    
    @scala.inline
    def id(value: String): this.type = set("id", value.asInstanceOf[js.Any])
    
    @scala.inline
    def inlist(value: js.Any): this.type = set("inlist", value.asInstanceOf[js.Any])
    
    @scala.inline
    def inputMode(value: String): this.type = set("inputMode", value.asInstanceOf[js.Any])
    
    @scala.inline
    def integrity(value: String): this.type = set("integrity", value.asInstanceOf[js.Any])
    
    @scala.inline
    def is(value: String): this.type = set("is", value.asInstanceOf[js.Any])
    
    @scala.inline
    def itemID(value: String): this.type = set("itemID", value.asInstanceOf[js.Any])
    
    @scala.inline
    def itemProp(value: String): this.type = set("itemProp", value.asInstanceOf[js.Any])
    
    @scala.inline
    def itemRef(value: String): this.type = set("itemRef", value.asInstanceOf[js.Any])
    
    @scala.inline
    def itemScope(value: Boolean): this.type = set("itemScope", value.asInstanceOf[js.Any])
    
    @scala.inline
    def itemType(value: String): this.type = set("itemType", value.asInstanceOf[js.Any])
    
    @scala.inline
    def justified(value: Boolean): this.type = set("justified", value.asInstanceOf[js.Any])
    
    @scala.inline
    def keyParams(value: String): this.type = set("keyParams", value.asInstanceOf[js.Any])
    
    @scala.inline
    def keyType(value: String): this.type = set("keyType", value.asInstanceOf[js.Any])
    
    @scala.inline
    def kind(value: String): this.type = set("kind", value.asInstanceOf[js.Any])
    
    @scala.inline
    def label(value: String): this.type = set("label", value.asInstanceOf[js.Any])
    
    @scala.inline
    def lang(value: String): this.type = set("lang", value.asInstanceOf[js.Any])
    
    @scala.inline
    def list(value: String): this.type = set("list", value.asInstanceOf[js.Any])
    
    @scala.inline
    def loop(value: Boolean): this.type = set("loop", value.asInstanceOf[js.Any])
    
    @scala.inline
    def low(value: Double): this.type = set("low", value.asInstanceOf[js.Any])
    
    @scala.inline
    def manifest(value: String): this.type = set("manifest", value.asInstanceOf[js.Any])
    
    @scala.inline
    def marginHeight(value: Double): this.type = set("marginHeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def marginWidth(value: Double): this.type = set("marginWidth", value.asInstanceOf[js.Any])
    
    @scala.inline
    def max(value: Double | String): this.type = set("max", value.asInstanceOf[js.Any])
    
    @scala.inline
    def maxLength(value: Double): this.type = set("maxLength", value.asInstanceOf[js.Any])
    
    @scala.inline
    def media(value: String): this.type = set("media", value.asInstanceOf[js.Any])
    
    @scala.inline
    def mediaGroup(value: String): this.type = set("mediaGroup", value.asInstanceOf[js.Any])
    
    @scala.inline
    def method(value: String): this.type = set("method", value.asInstanceOf[js.Any])
    
    @scala.inline
    def min(value: Double | String): this.type = set("min", value.asInstanceOf[js.Any])
    
    @scala.inline
    def minLength(value: Double): this.type = set("minLength", value.asInstanceOf[js.Any])
    
    @scala.inline
    def multiple(value: Boolean): this.type = set("multiple", value.asInstanceOf[js.Any])
    
    @scala.inline
    def muted(value: Boolean): this.type = set("muted", value.asInstanceOf[js.Any])
    
    @scala.inline
    def name(value: String): this.type = set("name", value.asInstanceOf[js.Any])
    
    @scala.inline
    def noValidate(value: Boolean): this.type = set("noValidate", value.asInstanceOf[js.Any])
    
    @scala.inline
    def nonce(value: String): this.type = set("nonce", value.asInstanceOf[js.Any])
    
    @scala.inline
    def onAbort(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onAbort", js.Any.fromFunction1(value))
    
    @scala.inline
    def onAnimationEnd(value: SyntheticAnimationEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onAnimationEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onAnimationIteration(value: SyntheticAnimationEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onAnimationIteration", js.Any.fromFunction1(value))
    
    @scala.inline
    def onAnimationStart(value: SyntheticAnimationEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onAnimationStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onAuxClick(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onAuxClick", js.Any.fromFunction1(value))
    
    @scala.inline
    def onBeforeInput(
      value: SyntheticEvent[EventTarget & typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit
    ): this.type = set("onBeforeInput", js.Any.fromFunction1(value))
    
    @scala.inline
    def onBlur(value: SyntheticFocusEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onBlur", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCanPlay(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onCanPlay", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCanPlayThrough(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onCanPlayThrough", js.Any.fromFunction1(value))
    
    @scala.inline
    def onChange(
      value: SyntheticEvent[EventTarget & typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit
    ): this.type = set("onChange", js.Any.fromFunction1(value))
    
    @scala.inline
    def onClick(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onClick", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCompositionEnd(value: SyntheticCompositionEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onCompositionEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCompositionStart(value: SyntheticCompositionEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onCompositionStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCompositionUpdate(value: SyntheticCompositionEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onCompositionUpdate", js.Any.fromFunction1(value))
    
    @scala.inline
    def onContextMenu(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onContextMenu", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCopy(value: SyntheticClipboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onCopy", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCut(value: SyntheticClipboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onCut", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDoubleClick(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDoubleClick", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDrag(value: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDrag", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragEnd(value: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDragEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragEnter(value: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDragEnter", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragExit(value: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDragExit", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragLeave(value: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDragLeave", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragOver(value: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDragOver", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragStart(value: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDragStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDrop(value: DragEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDrop", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDurationChange(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onDurationChange", js.Any.fromFunction1(value))
    
    @scala.inline
    def onEmptied(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onEmptied", js.Any.fromFunction1(value))
    
    @scala.inline
    def onEncrypted(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onEncrypted", js.Any.fromFunction1(value))
    
    @scala.inline
    def onEnded(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onEnded", js.Any.fromFunction1(value))
    
    @scala.inline
    def onError(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onError", js.Any.fromFunction1(value))
    
    @scala.inline
    def onFocus(value: SyntheticFocusEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onFocus", js.Any.fromFunction1(value))
    
    @scala.inline
    def onInput(
      value: SyntheticEvent[EventTarget & typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit
    ): this.type = set("onInput", js.Any.fromFunction1(value))
    
    @scala.inline
    def onInvalid(
      value: SyntheticEvent[EventTarget & typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit
    ): this.type = set("onInvalid", js.Any.fromFunction1(value))
    
    @scala.inline
    def onKeyDown(value: SyntheticKeyboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onKeyDown", js.Any.fromFunction1(value))
    
    @scala.inline
    def onKeyPress(value: SyntheticKeyboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onKeyPress", js.Any.fromFunction1(value))
    
    @scala.inline
    def onKeyUp(value: SyntheticKeyboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onKeyUp", js.Any.fromFunction1(value))
    
    @scala.inline
    def onLoad(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onLoad", js.Any.fromFunction1(value))
    
    @scala.inline
    def onLoadStart(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onLoadStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onLoadedData(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onLoadedData", js.Any.fromFunction1(value))
    
    @scala.inline
    def onLoadedMetadata(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onLoadedMetadata", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseDown(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onMouseDown", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseEnter(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onMouseEnter", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseLeave(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onMouseLeave", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseMove(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onMouseMove", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseOut(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onMouseOut", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseOver(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onMouseOver", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseUp(value: SyntheticMouseEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onMouseUp", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPaste(value: SyntheticClipboardEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPaste", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPause(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPause", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPlay(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPlay", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPlaying(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPlaying", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerCancel(value: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPointerCancel", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerDown(value: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPointerDown", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerEnter(value: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPointerEnter", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerLeave(value: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPointerLeave", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerMove(value: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPointerMove", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerOut(value: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPointerOut", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerOver(value: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPointerOver", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerUp(value: SyntheticPointerEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onPointerUp", js.Any.fromFunction1(value))
    
    @scala.inline
    def onProgress(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onProgress", js.Any.fromFunction1(value))
    
    @scala.inline
    def onRateChange(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onRateChange", js.Any.fromFunction1(value))
    
    @scala.inline
    def onReset(
      value: SyntheticEvent[EventTarget & typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit
    ): this.type = set("onReset", js.Any.fromFunction1(value))
    
    @scala.inline
    def onScroll(value: SyntheticUIEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onScroll", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSeeked(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onSeeked", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSeeking(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onSeeking", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSelect(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onSelect", js.Any.fromFunction1(value))
    
    @scala.inline
    def onStalled(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onStalled", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSubmit(
      value: SyntheticEvent[EventTarget & typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup, Event] => Unit
    ): this.type = set("onSubmit", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSuspend(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onSuspend", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTimeUpdate(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onTimeUpdate", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTouchCancel(value: SyntheticTouchEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onTouchCancel", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTouchEnd(value: SyntheticTouchEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onTouchEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTouchMove(value: SyntheticTouchEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onTouchMove", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTouchStart(value: SyntheticTouchEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onTouchStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTransitionEnd(value: SyntheticTransitionEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onTransitionEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onVolumeChange(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onVolumeChange", js.Any.fromFunction1(value))
    
    @scala.inline
    def onWaiting(value: SyntheticEvent[Event, typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onWaiting", js.Any.fromFunction1(value))
    
    @scala.inline
    def onWheel(value: SyntheticWheelEvent[typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroup] => Unit): this.type = set("onWheel", js.Any.fromFunction1(value))
    
    @scala.inline
    def open(value: Boolean): this.type = set("open", value.asInstanceOf[js.Any])
    
    @scala.inline
    def optimum(value: Double): this.type = set("optimum", value.asInstanceOf[js.Any])
    
    @scala.inline
    def pattern(value: String): this.type = set("pattern", value.asInstanceOf[js.Any])
    
    @scala.inline
    def placeholder(value: String): this.type = set("placeholder", value.asInstanceOf[js.Any])
    
    @scala.inline
    def playsInline(value: Boolean): this.type = set("playsInline", value.asInstanceOf[js.Any])
    
    @scala.inline
    def poster(value: String): this.type = set("poster", value.asInstanceOf[js.Any])
    
    @scala.inline
    def prefix(value: String): this.type = set("prefix", value.asInstanceOf[js.Any])
    
    @scala.inline
    def preload(value: String): this.type = set("preload", value.asInstanceOf[js.Any])
    
    @scala.inline
    def property(value: String): this.type = set("property", value.asInstanceOf[js.Any])
    
    @scala.inline
    def radioGroup(value: String): this.type = set("radioGroup", value.asInstanceOf[js.Any])
    
    @scala.inline
    def readOnly(value: Boolean): this.type = set("readOnly", value.asInstanceOf[js.Any])
    
    @scala.inline
    def rel(value: String): this.type = set("rel", value.asInstanceOf[js.Any])
    
    @scala.inline
    def required(value: Boolean): this.type = set("required", value.asInstanceOf[js.Any])
    
    @scala.inline
    def resource(value: String): this.type = set("resource", value.asInstanceOf[js.Any])
    
    @scala.inline
    def results(value: Double): this.type = set("results", value.asInstanceOf[js.Any])
    
    @scala.inline
    def reversed(value: Boolean): this.type = set("reversed", value.asInstanceOf[js.Any])
    
    @scala.inline
    def role(value: String): this.type = set("role", value.asInstanceOf[js.Any])
    
    @scala.inline
    def rowSpan(value: Double): this.type = set("rowSpan", value.asInstanceOf[js.Any])
    
    @scala.inline
    def rows(value: Double): this.type = set("rows", value.asInstanceOf[js.Any])
    
    @scala.inline
    def sandbox(value: String): this.type = set("sandbox", value.asInstanceOf[js.Any])
    
    @scala.inline
    def scope(value: String): this.type = set("scope", value.asInstanceOf[js.Any])
    
    @scala.inline
    def scoped(value: Boolean): this.type = set("scoped", value.asInstanceOf[js.Any])
    
    @scala.inline
    def scrolling(value: String): this.type = set("scrolling", value.asInstanceOf[js.Any])
    
    @scala.inline
    def seamless(value: Boolean): this.type = set("seamless", value.asInstanceOf[js.Any])
    
    @scala.inline
    def security(value: String): this.type = set("security", value.asInstanceOf[js.Any])
    
    @scala.inline
    def selected(value: Boolean): this.type = set("selected", value.asInstanceOf[js.Any])
    
    @scala.inline
    def shape(value: String): this.type = set("shape", value.asInstanceOf[js.Any])
    
    @scala.inline
    def size(value: Double): this.type = set("size", value.asInstanceOf[js.Any])
    
    @scala.inline
    def sizes(value: String): this.type = set("sizes", value.asInstanceOf[js.Any])
    
    @scala.inline
    def slot(value: String): this.type = set("slot", value.asInstanceOf[js.Any])
    
    @scala.inline
    def span(value: Double): this.type = set("span", value.asInstanceOf[js.Any])
    
    @scala.inline
    def spellCheck(value: Boolean): this.type = set("spellCheck", value.asInstanceOf[js.Any])
    
    @scala.inline
    def src(value: String): this.type = set("src", value.asInstanceOf[js.Any])
    
    @scala.inline
    def srcDoc(value: String): this.type = set("srcDoc", value.asInstanceOf[js.Any])
    
    @scala.inline
    def srcLang(value: String): this.type = set("srcLang", value.asInstanceOf[js.Any])
    
    @scala.inline
    def srcSet(value: String): this.type = set("srcSet", value.asInstanceOf[js.Any])
    
    @scala.inline
    def start(value: Double): this.type = set("start", value.asInstanceOf[js.Any])
    
    @scala.inline
    def step(value: Double | String): this.type = set("step", value.asInstanceOf[js.Any])
    
    @scala.inline
    def style(value: CSSProperties): this.type = set("style", value.asInstanceOf[js.Any])
    
    @scala.inline
    def summary(value: String): this.type = set("summary", value.asInstanceOf[js.Any])
    
    @scala.inline
    def suppressContentEditableWarning(value: Boolean): this.type = set("suppressContentEditableWarning", value.asInstanceOf[js.Any])
    
    @scala.inline
    def suppressHydrationWarning(value: Boolean): this.type = set("suppressHydrationWarning", value.asInstanceOf[js.Any])
    
    @scala.inline
    def tabIndex(value: Double): this.type = set("tabIndex", value.asInstanceOf[js.Any])
    
    @scala.inline
    def target(value: String): this.type = set("target", value.asInstanceOf[js.Any])
    
    @scala.inline
    def title(value: String): this.type = set("title", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `type`(value: String): this.type = set("type", value.asInstanceOf[js.Any])
    
    @scala.inline
    def typeof(value: String): this.type = set("typeof", value.asInstanceOf[js.Any])
    
    @scala.inline
    def unselectable(value: on | off): this.type = set("unselectable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def useMap(value: String): this.type = set("useMap", value.asInstanceOf[js.Any])
    
    @scala.inline
    def value(value: String | js.Array[String] | Double): this.type = set("value", value.asInstanceOf[js.Any])
    
    @scala.inline
    def valueVarargs(value: String*): this.type = set("value", js.Array(value :_*))
    
    @scala.inline
    def vertical(value: Boolean): this.type = set("vertical", value.asInstanceOf[js.Any])
    
    @scala.inline
    def vocab(value: String): this.type = set("vocab", value.asInstanceOf[js.Any])
    
    @scala.inline
    def width(value: Double | String): this.type = set("width", value.asInstanceOf[js.Any])
    
    @scala.inline
    def wmode(value: String): this.type = set("wmode", value.asInstanceOf[js.Any])
    
    @scala.inline
    def wrap(value: String): this.type = set("wrap", value.asInstanceOf[js.Any])
  }
  
  implicit def make(companion: ButtonGroup.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ButtonGroupProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}

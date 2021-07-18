package typingsJapgolly.react.components

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
import org.scalajs.dom.raw.Element
import org.scalajs.dom.raw.HTMLAreaElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.anon.Html
import typingsJapgolly.react.mod.AreaHTMLAttributes
import typingsJapgolly.react.mod.CSSProperties
import typingsJapgolly.react.mod.DetailedHTMLProps
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
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object area {
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[HTMLAreaElement] {
    
    inline def about(value: String): this.type = set("about", value.asInstanceOf[js.Any])
    
    inline def accessKey(value: String): this.type = set("accessKey", value.asInstanceOf[js.Any])
    
    inline def alt(value: String): this.type = set("alt", value.asInstanceOf[js.Any])
    
    inline def `aria-activedescendant`(value: String): this.type = set("aria-activedescendant", value.asInstanceOf[js.Any])
    
    inline def `aria-atomic`(value: Boolean): this.type = set("aria-atomic", value.asInstanceOf[js.Any])
    
    inline def `aria-autocomplete`(value: none | `inline` | list | both): this.type = set("aria-autocomplete", value.asInstanceOf[js.Any])
    
    inline def `aria-busy`(value: Boolean): this.type = set("aria-busy", value.asInstanceOf[js.Any])
    
    inline def `aria-checked`(value: Boolean | mixed): this.type = set("aria-checked", value.asInstanceOf[js.Any])
    
    inline def `aria-colcount`(value: Double): this.type = set("aria-colcount", value.asInstanceOf[js.Any])
    
    inline def `aria-colindex`(value: Double): this.type = set("aria-colindex", value.asInstanceOf[js.Any])
    
    inline def `aria-colspan`(value: Double): this.type = set("aria-colspan", value.asInstanceOf[js.Any])
    
    inline def `aria-controls`(value: String): this.type = set("aria-controls", value.asInstanceOf[js.Any])
    
    inline def `aria-current`(value: Boolean | page | step | location | date | time): this.type = set("aria-current", value.asInstanceOf[js.Any])
    
    inline def `aria-describedby`(value: String): this.type = set("aria-describedby", value.asInstanceOf[js.Any])
    
    inline def `aria-details`(value: String): this.type = set("aria-details", value.asInstanceOf[js.Any])
    
    inline def `aria-disabled`(value: Boolean): this.type = set("aria-disabled", value.asInstanceOf[js.Any])
    
    inline def `aria-dropeffect`(value: none | copy | execute | link | move | popup): this.type = set("aria-dropeffect", value.asInstanceOf[js.Any])
    
    inline def `aria-errormessage`(value: String): this.type = set("aria-errormessage", value.asInstanceOf[js.Any])
    
    inline def `aria-expanded`(value: Boolean): this.type = set("aria-expanded", value.asInstanceOf[js.Any])
    
    inline def `aria-flowto`(value: String): this.type = set("aria-flowto", value.asInstanceOf[js.Any])
    
    inline def `aria-grabbed`(value: Boolean): this.type = set("aria-grabbed", value.asInstanceOf[js.Any])
    
    inline def `aria-haspopup`(value: Boolean | menu | listbox | tree | grid | dialog): this.type = set("aria-haspopup", value.asInstanceOf[js.Any])
    
    inline def `aria-hidden`(value: Boolean): this.type = set("aria-hidden", value.asInstanceOf[js.Any])
    
    inline def `aria-invalid`(value: Boolean | grammar | spelling): this.type = set("aria-invalid", value.asInstanceOf[js.Any])
    
    inline def `aria-keyshortcuts`(value: String): this.type = set("aria-keyshortcuts", value.asInstanceOf[js.Any])
    
    inline def `aria-label`(value: String): this.type = set("aria-label", value.asInstanceOf[js.Any])
    
    inline def `aria-labelledby`(value: String): this.type = set("aria-labelledby", value.asInstanceOf[js.Any])
    
    inline def `aria-level`(value: Double): this.type = set("aria-level", value.asInstanceOf[js.Any])
    
    inline def `aria-live`(value: off | assertive | polite): this.type = set("aria-live", value.asInstanceOf[js.Any])
    
    inline def `aria-modal`(value: Boolean): this.type = set("aria-modal", value.asInstanceOf[js.Any])
    
    inline def `aria-multiline`(value: Boolean): this.type = set("aria-multiline", value.asInstanceOf[js.Any])
    
    inline def `aria-multiselectable`(value: Boolean): this.type = set("aria-multiselectable", value.asInstanceOf[js.Any])
    
    inline def `aria-orientation`(value: horizontal | vertical): this.type = set("aria-orientation", value.asInstanceOf[js.Any])
    
    inline def `aria-owns`(value: String): this.type = set("aria-owns", value.asInstanceOf[js.Any])
    
    inline def `aria-placeholder`(value: String): this.type = set("aria-placeholder", value.asInstanceOf[js.Any])
    
    inline def `aria-posinset`(value: Double): this.type = set("aria-posinset", value.asInstanceOf[js.Any])
    
    inline def `aria-pressed`(value: Boolean | mixed): this.type = set("aria-pressed", value.asInstanceOf[js.Any])
    
    inline def `aria-readonly`(value: Boolean): this.type = set("aria-readonly", value.asInstanceOf[js.Any])
    
    inline def `aria-relevant`(value: additions | (`additions text`) | all | removals | text): this.type = set("aria-relevant", value.asInstanceOf[js.Any])
    
    inline def `aria-required`(value: Boolean): this.type = set("aria-required", value.asInstanceOf[js.Any])
    
    inline def `aria-roledescription`(value: String): this.type = set("aria-roledescription", value.asInstanceOf[js.Any])
    
    inline def `aria-rowcount`(value: Double): this.type = set("aria-rowcount", value.asInstanceOf[js.Any])
    
    inline def `aria-rowindex`(value: Double): this.type = set("aria-rowindex", value.asInstanceOf[js.Any])
    
    inline def `aria-rowspan`(value: Double): this.type = set("aria-rowspan", value.asInstanceOf[js.Any])
    
    inline def `aria-selected`(value: Boolean): this.type = set("aria-selected", value.asInstanceOf[js.Any])
    
    inline def `aria-setsize`(value: Double): this.type = set("aria-setsize", value.asInstanceOf[js.Any])
    
    inline def `aria-sort`(value: none | ascending | descending | other): this.type = set("aria-sort", value.asInstanceOf[js.Any])
    
    inline def `aria-valuemax`(value: Double): this.type = set("aria-valuemax", value.asInstanceOf[js.Any])
    
    inline def `aria-valuemin`(value: Double): this.type = set("aria-valuemin", value.asInstanceOf[js.Any])
    
    inline def `aria-valuenow`(value: Double): this.type = set("aria-valuenow", value.asInstanceOf[js.Any])
    
    inline def `aria-valuetext`(value: String): this.type = set("aria-valuetext", value.asInstanceOf[js.Any])
    
    inline def autoCapitalize(value: String): this.type = set("autoCapitalize", value.asInstanceOf[js.Any])
    
    inline def autoCorrect(value: String): this.type = set("autoCorrect", value.asInstanceOf[js.Any])
    
    inline def autoSave(value: String): this.type = set("autoSave", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def color(value: String): this.type = set("color", value.asInstanceOf[js.Any])
    
    inline def contentEditable(value: Boolean): this.type = set("contentEditable", value.asInstanceOf[js.Any])
    
    inline def contextMenu(value: String): this.type = set("contextMenu", value.asInstanceOf[js.Any])
    
    inline def coords(value: String): this.type = set("coords", value.asInstanceOf[js.Any])
    
    inline def dangerouslySetInnerHTML(value: Html): this.type = set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    inline def datatype(value: String): this.type = set("datatype", value.asInstanceOf[js.Any])
    
    inline def defaultChecked(value: Boolean): this.type = set("defaultChecked", value.asInstanceOf[js.Any])
    
    inline def defaultValue(value: String | js.Array[String]): this.type = set("defaultValue", value.asInstanceOf[js.Any])
    
    inline def defaultValueVarargs(value: String*): this.type = set("defaultValue", js.Array(value :_*))
    
    inline def dir(value: String): this.type = set("dir", value.asInstanceOf[js.Any])
    
    inline def download(value: js.Any): this.type = set("download", value.asInstanceOf[js.Any])
    
    inline def draggable(value: Boolean): this.type = set("draggable", value.asInstanceOf[js.Any])
    
    inline def hidden(value: Boolean): this.type = set("hidden", value.asInstanceOf[js.Any])
    
    inline def href(value: String): this.type = set("href", value.asInstanceOf[js.Any])
    
    inline def hrefLang(value: String): this.type = set("hrefLang", value.asInstanceOf[js.Any])
    
    inline def id(value: String): this.type = set("id", value.asInstanceOf[js.Any])
    
    inline def inlist(value: js.Any): this.type = set("inlist", value.asInstanceOf[js.Any])
    
    inline def inputMode(value: String): this.type = set("inputMode", value.asInstanceOf[js.Any])
    
    inline def is(value: String): this.type = set("is", value.asInstanceOf[js.Any])
    
    inline def itemID(value: String): this.type = set("itemID", value.asInstanceOf[js.Any])
    
    inline def itemProp(value: String): this.type = set("itemProp", value.asInstanceOf[js.Any])
    
    inline def itemRef(value: String): this.type = set("itemRef", value.asInstanceOf[js.Any])
    
    inline def itemScope(value: Boolean): this.type = set("itemScope", value.asInstanceOf[js.Any])
    
    inline def itemType(value: String): this.type = set("itemType", value.asInstanceOf[js.Any])
    
    inline def lang(value: String): this.type = set("lang", value.asInstanceOf[js.Any])
    
    inline def media(value: String): this.type = set("media", value.asInstanceOf[js.Any])
    
    inline def onAbort(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onAbort", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onAnimationEnd(value: ReactAnimationEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onAnimationEnd", js.Any.fromFunction1((t0: ReactAnimationEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onAnimationIteration(value: ReactAnimationEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onAnimationIteration", js.Any.fromFunction1((t0: ReactAnimationEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onAnimationStart(value: ReactAnimationEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onAnimationStart", js.Any.fromFunction1((t0: ReactAnimationEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onAuxClick(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onAuxClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onBeforeInput(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onBeforeInput", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onBlur(value: ReactFocusEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onBlur", js.Any.fromFunction1((t0: ReactFocusEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onCanPlay(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onCanPlay", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onCanPlayThrough(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onCanPlayThrough", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onChange(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onChange", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onClick(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onCompositionEnd(value: ReactCompositionEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onCompositionEnd", js.Any.fromFunction1((t0: ReactCompositionEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onCompositionStart(value: ReactCompositionEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onCompositionStart", js.Any.fromFunction1((t0: ReactCompositionEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onCompositionUpdate(value: ReactCompositionEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onCompositionUpdate", js.Any.fromFunction1((t0: ReactCompositionEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onContextMenu(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onContextMenu", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onCopy(value: ReactClipboardEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onCopy", js.Any.fromFunction1((t0: ReactClipboardEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onCut(value: ReactClipboardEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onCut", js.Any.fromFunction1((t0: ReactClipboardEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDoubleClick(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDoubleClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDrag(value: ReactDragEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDrag", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDragEnd(value: ReactDragEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDragEnd", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDragEnter(value: ReactDragEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDragEnter", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDragExit(value: ReactDragEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDragExit", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDragLeave(value: ReactDragEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDragLeave", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDragOver(value: ReactDragEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDragOver", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDragStart(value: ReactDragEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDragStart", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDrop(value: ReactDragEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDrop", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onDurationChange(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onDurationChange", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onEmptied(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onEmptied", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onEncrypted(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onEncrypted", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onEnded(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onEnded", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onError(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onError", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onFocus(value: ReactFocusEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onFocus", js.Any.fromFunction1((t0: ReactFocusEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onInput(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onInput", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onInvalid(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onInvalid", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onKeyDown(value: ReactKeyboardEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onKeyDown", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onKeyPress(value: ReactKeyboardEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onKeyPress", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onKeyUp(value: ReactKeyboardEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onKeyUp", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onLoad(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onLoad", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onLoadStart(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onLoadStart", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onLoadedData(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onLoadedData", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onLoadedMetadata(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onLoadedMetadata", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onMouseDown(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onMouseDown", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onMouseEnter(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onMouseEnter", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onMouseLeave(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onMouseLeave", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onMouseMove(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onMouseMove", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onMouseOut(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onMouseOut", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onMouseOver(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onMouseOver", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onMouseUp(value: ReactMouseEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onMouseUp", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPaste(value: ReactClipboardEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPaste", js.Any.fromFunction1((t0: ReactClipboardEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPause(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPause", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPlay(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPlay", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPlaying(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPlaying", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPointerCancel(value: ReactPointerEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPointerCancel", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPointerDown(value: ReactPointerEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPointerDown", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPointerEnter(value: ReactPointerEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPointerEnter", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPointerLeave(value: ReactPointerEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPointerLeave", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPointerMove(value: ReactPointerEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPointerMove", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPointerOut(value: ReactPointerEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPointerOut", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPointerOver(value: ReactPointerEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPointerOver", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onPointerUp(value: ReactPointerEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onPointerUp", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onProgress(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onProgress", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onRateChange(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onRateChange", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onReset(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onReset", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onScroll(value: ReactUIEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onScroll", js.Any.fromFunction1((t0: ReactUIEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onSeeked(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onSeeked", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onSeeking(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onSeeking", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onSelect(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onSelect", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onStalled(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onStalled", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onSubmit(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onSubmit", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onSuspend(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onSuspend", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onTimeUpdate(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onTimeUpdate", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onTouchCancel(value: ReactTouchEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onTouchCancel", js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onTouchEnd(value: ReactTouchEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onTouchEnd", js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onTouchMove(value: ReactTouchEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onTouchMove", js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onTouchStart(value: ReactTouchEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onTouchStart", js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onTransitionEnd(value: ReactTransitionEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onTransitionEnd", js.Any.fromFunction1((t0: ReactTransitionEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onVolumeChange(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onVolumeChange", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onWaiting(value: ReactEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onWaiting", js.Any.fromFunction1((t0: ReactEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def onWheel(value: ReactWheelEventFrom[HTMLAreaElement & Element] => Callback): this.type = set("onWheel", js.Any.fromFunction1((t0: ReactWheelEventFrom[HTMLAreaElement & Element]) => value(t0).runNow()))
    
    inline def placeholder(value: String): this.type = set("placeholder", value.asInstanceOf[js.Any])
    
    inline def prefix(value: String): this.type = set("prefix", value.asInstanceOf[js.Any])
    
    inline def property(value: String): this.type = set("property", value.asInstanceOf[js.Any])
    
    inline def radioGroup(value: String): this.type = set("radioGroup", value.asInstanceOf[js.Any])
    
    inline def rel(value: String): this.type = set("rel", value.asInstanceOf[js.Any])
    
    inline def resource(value: String): this.type = set("resource", value.asInstanceOf[js.Any])
    
    inline def results(value: Double): this.type = set("results", value.asInstanceOf[js.Any])
    
    inline def role(value: String): this.type = set("role", value.asInstanceOf[js.Any])
    
    inline def security(value: String): this.type = set("security", value.asInstanceOf[js.Any])
    
    inline def shape(value: String): this.type = set("shape", value.asInstanceOf[js.Any])
    
    inline def slot(value: String): this.type = set("slot", value.asInstanceOf[js.Any])
    
    inline def spellCheck(value: Boolean): this.type = set("spellCheck", value.asInstanceOf[js.Any])
    
    inline def style(value: CSSProperties): this.type = set("style", value.asInstanceOf[js.Any])
    
    inline def suppressContentEditableWarning(value: Boolean): this.type = set("suppressContentEditableWarning", value.asInstanceOf[js.Any])
    
    inline def suppressHydrationWarning(value: Boolean): this.type = set("suppressHydrationWarning", value.asInstanceOf[js.Any])
    
    inline def tabIndex(value: Double): this.type = set("tabIndex", value.asInstanceOf[js.Any])
    
    inline def target(value: String): this.type = set("target", value.asInstanceOf[js.Any])
    
    inline def title(value: String): this.type = set("title", value.asInstanceOf[js.Any])
    
    inline def typeof(value: String): this.type = set("typeof", value.asInstanceOf[js.Any])
    
    inline def unselectable(value: on | off): this.type = set("unselectable", value.asInstanceOf[js.Any])
    
    inline def vocab(value: String): this.type = set("vocab", value.asInstanceOf[js.Any])
  }
  
  val component: String = "area"
  
  implicit def make(companion: area.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DetailedHTMLProps[AreaHTMLAttributes[HTMLAreaElement], HTMLAreaElement]): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}

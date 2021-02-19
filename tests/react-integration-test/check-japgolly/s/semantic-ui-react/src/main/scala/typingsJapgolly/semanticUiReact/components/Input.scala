package typingsJapgolly.semanticUiReact.components

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
import japgolly.scalajs.react.raw.Empty
import japgolly.scalajs.react.raw.JsNumber
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import org.scalajs.dom.raw.HTMLInputElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.anon.Html
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
import typingsJapgolly.semanticUiReact.genericMod.HtmlInputrops
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import typingsJapgolly.semanticUiReact.inputInputMod.InputOnChangeData
import typingsJapgolly.semanticUiReact.inputInputMod.InputProps
import typingsJapgolly.semanticUiReact.inputInputMod.StrictInputProps
import typingsJapgolly.semanticUiReact.inputInputMod.default
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.`left corner`
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.`right corner`
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.big
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.huge
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.large
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.left
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.massive
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.mini
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.right
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.small
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Input {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Input/Input", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[default] {
    
    @scala.inline
    def about(value: String): this.type = set("about", value.asInstanceOf[js.Any])
    
    @scala.inline
    def accept(value: String): this.type = set("accept", value.asInstanceOf[js.Any])
    
    @scala.inline
    def accessKey(value: String): this.type = set("accessKey", value.asInstanceOf[js.Any])
    
    @scala.inline
    def action(value: js.Any | Boolean): this.type = set("action", value.asInstanceOf[js.Any])
    
    @scala.inline
    def actionPosition(value: left): this.type = set("actionPosition", value.asInstanceOf[js.Any])
    
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
    def as(value: js.Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoCapitalize(value: String): this.type = set("autoCapitalize", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoComplete(value: String): this.type = set("autoComplete", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoCorrect(value: String): this.type = set("autoCorrect", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoFocus(value: Boolean): this.type = set("autoFocus", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoSave(value: String): this.type = set("autoSave", value.asInstanceOf[js.Any])
    
    @scala.inline
    def capture(value: Boolean | String): this.type = set("capture", value.asInstanceOf[js.Any])
    
    @scala.inline
    def checked(value: Boolean): this.type = set("checked", value.asInstanceOf[js.Any])
    
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    @scala.inline
    def color(value: String): this.type = set("color", value.asInstanceOf[js.Any])
    
    @scala.inline
    def contentEditable(value: Boolean): this.type = set("contentEditable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def contextMenu(value: String): this.type = set("contextMenu", value.asInstanceOf[js.Any])
    
    @scala.inline
    def crossOrigin(value: String): this.type = set("crossOrigin", value.asInstanceOf[js.Any])
    
    @scala.inline
    def dangerouslySetInnerHTML(value: Html): this.type = set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    @scala.inline
    def datatype(value: String): this.type = set("datatype", value.asInstanceOf[js.Any])
    
    @scala.inline
    def defaultChecked(value: Boolean): this.type = set("defaultChecked", value.asInstanceOf[js.Any])
    
    @scala.inline
    def defaultValue(value: String | js.Array[String]): this.type = set("defaultValue", value.asInstanceOf[js.Any])
    
    @scala.inline
    def defaultValueVarargs(value: String*): this.type = set("defaultValue", js.Array(value :_*))
    
    @scala.inline
    def dir(value: String): this.type = set("dir", value.asInstanceOf[js.Any])
    
    @scala.inline
    def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    @scala.inline
    def draggable(value: Boolean): this.type = set("draggable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def error(value: Boolean): this.type = set("error", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    @scala.inline
    def focus(value: Boolean): this.type = set("focus", value.asInstanceOf[js.Any])
    
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
    def height(value: Double | String): this.type = set("height", value.asInstanceOf[js.Any])
    
    @scala.inline
    def hidden(value: Boolean): this.type = set("hidden", value.asInstanceOf[js.Any])
    
    @scala.inline
    def icon(value: js.Any | SemanticShorthandItem[InputProps]): this.type = set("icon", value.asInstanceOf[js.Any])
    
    @scala.inline
    def iconFunction3(
      value: (/* component */ ReactType[InputProps], InputProps, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
    ): this.type = set("icon", js.Any.fromFunction3(value))
    
    @scala.inline
    def iconNull: this.type = set("icon", null)
    
    @scala.inline
    def iconPosition(value: left): this.type = set("iconPosition", value.asInstanceOf[js.Any])
    
    @scala.inline
    def iconVarargs(value: (Empty | String | JsNumber | Element)*): this.type = set("icon", js.Array(value :_*))
    
    @scala.inline
    def iconVdomElement(value: VdomElement): this.type = set("icon", value.rawElement.asInstanceOf[js.Any])
    
    @scala.inline
    def id(value: String): this.type = set("id", value.asInstanceOf[js.Any])
    
    @scala.inline
    def inlist(value: js.Any): this.type = set("inlist", value.asInstanceOf[js.Any])
    
    @scala.inline
    def input(value: SemanticShorthandItem[HtmlInputrops]): this.type = set("input", value.asInstanceOf[js.Any])
    
    @scala.inline
    def inputFunction3(
      value: (/* component */ ReactType[HtmlInputrops], HtmlInputrops, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
    ): this.type = set("input", js.Any.fromFunction3(value))
    
    @scala.inline
    def inputMode(value: String): this.type = set("inputMode", value.asInstanceOf[js.Any])
    
    @scala.inline
    def inputNull: this.type = set("input", null)
    
    @scala.inline
    def inputVarargs(value: (Empty | String | JsNumber | Element)*): this.type = set("input", js.Array(value :_*))
    
    @scala.inline
    def inputVdomElement(value: VdomElement): this.type = set("input", value.rawElement.asInstanceOf[js.Any])
    
    @scala.inline
    def inverted(value: Boolean): this.type = set("inverted", value.asInstanceOf[js.Any])
    
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
    def label(
      value: SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ js.Any
        ]
    ): this.type = set("label", value.asInstanceOf[js.Any])
    
    @scala.inline
    def labelFunction3(
      value: (/* component */ ReactType[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ js.Any
        ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ js.Any, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
    ): this.type = set("label", js.Any.fromFunction3(value))
    
    @scala.inline
    def labelNull: this.type = set("label", null)
    
    @scala.inline
    def labelPosition(value: left | right | (`left corner`) | (`right corner`)): this.type = set("labelPosition", value.asInstanceOf[js.Any])
    
    @scala.inline
    def labelVarargs(value: (Empty | String | JsNumber | Element)*): this.type = set("label", js.Array(value :_*))
    
    @scala.inline
    def labelVdomElement(value: VdomElement): this.type = set("label", value.rawElement.asInstanceOf[js.Any])
    
    @scala.inline
    def lang(value: String): this.type = set("lang", value.asInstanceOf[js.Any])
    
    @scala.inline
    def list(value: String): this.type = set("list", value.asInstanceOf[js.Any])
    
    @scala.inline
    def loading(value: Boolean): this.type = set("loading", value.asInstanceOf[js.Any])
    
    @scala.inline
    def max(value: Double | String): this.type = set("max", value.asInstanceOf[js.Any])
    
    @scala.inline
    def maxLength(value: Double): this.type = set("maxLength", value.asInstanceOf[js.Any])
    
    @scala.inline
    def min(value: Double | String): this.type = set("min", value.asInstanceOf[js.Any])
    
    @scala.inline
    def minLength(value: Double): this.type = set("minLength", value.asInstanceOf[js.Any])
    
    @scala.inline
    def multiple(value: Boolean): this.type = set("multiple", value.asInstanceOf[js.Any])
    
    @scala.inline
    def name(value: String): this.type = set("name", value.asInstanceOf[js.Any])
    
    @scala.inline
    def onAbort(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onAbort", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onAnimationEnd(value: ReactAnimationEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onAnimationEnd", js.Any.fromFunction1((t0: ReactAnimationEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onAnimationIteration(value: ReactAnimationEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onAnimationIteration", js.Any.fromFunction1((t0: ReactAnimationEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onAnimationStart(value: ReactAnimationEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onAnimationStart", js.Any.fromFunction1((t0: ReactAnimationEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onAuxClick(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onAuxClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onBeforeInput(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onBeforeInput", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onBlur(value: ReactFocusEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onBlur", js.Any.fromFunction1((t0: ReactFocusEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onCanPlay(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onCanPlay", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onCanPlayThrough(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onCanPlayThrough", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onChange(value: (/* event */ ReactEventFrom[HTMLInputElement], /* data */ InputOnChangeData) => Callback): this.type = set("onChange", js.Any.fromFunction2((t0: /* event */ ReactEventFrom[HTMLInputElement], t1: /* data */ InputOnChangeData) => (value(t0, t1)).runNow()))
    
    @scala.inline
    def onClick(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onCompositionEnd(value: ReactCompositionEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onCompositionEnd", js.Any.fromFunction1((t0: ReactCompositionEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onCompositionStart(value: ReactCompositionEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onCompositionStart", js.Any.fromFunction1((t0: ReactCompositionEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onCompositionUpdate(value: ReactCompositionEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onCompositionUpdate", js.Any.fromFunction1((t0: ReactCompositionEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onContextMenu(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onContextMenu", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onCopy(value: ReactClipboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onCopy", js.Any.fromFunction1((t0: ReactClipboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onCut(value: ReactClipboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onCut", js.Any.fromFunction1((t0: ReactClipboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDoubleClick(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDoubleClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDrag(value: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDrag", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDragEnd(value: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDragEnd", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDragEnter(value: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDragEnter", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDragExit(value: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDragExit", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDragLeave(value: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDragLeave", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDragOver(value: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDragOver", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDragStart(value: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDragStart", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDrop(value: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDrop", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDurationChange(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDurationChange", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onEmptied(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onEmptied", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onEncrypted(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onEncrypted", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onEnded(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onEnded", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onError(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onError", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onFocus(value: ReactFocusEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onFocus", js.Any.fromFunction1((t0: ReactFocusEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onInput(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onInput", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onInvalid(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onInvalid", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onKeyDown(value: ReactKeyboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onKeyDown", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onKeyPress(value: ReactKeyboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onKeyPress", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onKeyUp(value: ReactKeyboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onKeyUp", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onLoad(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onLoad", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onLoadStart(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onLoadStart", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onLoadedData(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onLoadedData", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onLoadedMetadata(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onLoadedMetadata", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onMouseDown(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onMouseDown", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onMouseEnter(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onMouseEnter", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onMouseLeave(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onMouseLeave", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onMouseMove(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onMouseMove", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onMouseOut(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onMouseOut", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onMouseOver(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onMouseOver", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onMouseUp(value: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onMouseUp", js.Any.fromFunction1((t0: ReactMouseEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPaste(value: ReactClipboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPaste", js.Any.fromFunction1((t0: ReactClipboardEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPause(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPause", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPlay(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPlay", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPlaying(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPlaying", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPointerCancel(value: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPointerCancel", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPointerDown(value: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPointerDown", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPointerEnter(value: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPointerEnter", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPointerLeave(value: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPointerLeave", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPointerMove(value: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPointerMove", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPointerOut(value: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPointerOut", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPointerOver(value: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPointerOver", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onPointerUp(value: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onPointerUp", js.Any.fromFunction1((t0: ReactPointerEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onProgress(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onProgress", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onRateChange(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onRateChange", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onReset(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onReset", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onScroll(value: ReactUIEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onScroll", js.Any.fromFunction1((t0: ReactUIEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onSeeked(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onSeeked", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onSeeking(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onSeeking", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onSelect(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onSelect", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onStalled(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onStalled", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onSubmit(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onSubmit", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onSuspend(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onSuspend", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onTimeUpdate(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onTimeUpdate", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onTouchCancel(value: ReactTouchEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onTouchCancel", js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onTouchEnd(value: ReactTouchEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onTouchEnd", js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onTouchMove(value: ReactTouchEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onTouchMove", js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onTouchStart(value: ReactTouchEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onTouchStart", js.Any.fromFunction1((t0: ReactTouchEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onTransitionEnd(value: ReactTransitionEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onTransitionEnd", js.Any.fromFunction1((t0: ReactTransitionEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onVolumeChange(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onVolumeChange", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onWaiting(value: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onWaiting", js.Any.fromFunction1((t0: ReactEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onWheel(value: ReactWheelEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onWheel", js.Any.fromFunction1((t0: ReactWheelEventFrom[HTMLInputElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def pattern(value: String): this.type = set("pattern", value.asInstanceOf[js.Any])
    
    @scala.inline
    def placeholder(value: String): this.type = set("placeholder", value.asInstanceOf[js.Any])
    
    @scala.inline
    def prefix(value: String): this.type = set("prefix", value.asInstanceOf[js.Any])
    
    @scala.inline
    def property(value: String): this.type = set("property", value.asInstanceOf[js.Any])
    
    @scala.inline
    def radioGroup(value: String): this.type = set("radioGroup", value.asInstanceOf[js.Any])
    
    @scala.inline
    def readOnly(value: Boolean): this.type = set("readOnly", value.asInstanceOf[js.Any])
    
    @scala.inline
    def required(value: Boolean): this.type = set("required", value.asInstanceOf[js.Any])
    
    @scala.inline
    def resource(value: String): this.type = set("resource", value.asInstanceOf[js.Any])
    
    @scala.inline
    def results(value: Double): this.type = set("results", value.asInstanceOf[js.Any])
    
    @scala.inline
    def role(value: String): this.type = set("role", value.asInstanceOf[js.Any])
    
    @scala.inline
    def security(value: String): this.type = set("security", value.asInstanceOf[js.Any])
    
    @scala.inline
    def size(value: mini | small | large | big | huge | massive): this.type = set("size", value.asInstanceOf[js.Any])
    
    @scala.inline
    def slot(value: String): this.type = set("slot", value.asInstanceOf[js.Any])
    
    @scala.inline
    def spellCheck(value: Boolean): this.type = set("spellCheck", value.asInstanceOf[js.Any])
    
    @scala.inline
    def src(value: String): this.type = set("src", value.asInstanceOf[js.Any])
    
    @scala.inline
    def step(value: Double | String): this.type = set("step", value.asInstanceOf[js.Any])
    
    @scala.inline
    def style(value: CSSProperties): this.type = set("style", value.asInstanceOf[js.Any])
    
    @scala.inline
    def suppressContentEditableWarning(value: Boolean): this.type = set("suppressContentEditableWarning", value.asInstanceOf[js.Any])
    
    @scala.inline
    def suppressHydrationWarning(value: Boolean): this.type = set("suppressHydrationWarning", value.asInstanceOf[js.Any])
    
    @scala.inline
    def tabIndex(value: Double | String): this.type = set("tabIndex", value.asInstanceOf[js.Any])
    
    @scala.inline
    def title(value: String): this.type = set("title", value.asInstanceOf[js.Any])
    
    @scala.inline
    def transparent(value: Boolean): this.type = set("transparent", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `type`(value: String): this.type = set("type", value.asInstanceOf[js.Any])
    
    @scala.inline
    def typeof(value: String): this.type = set("typeof", value.asInstanceOf[js.Any])
    
    @scala.inline
    def unselectable(value: on | off): this.type = set("unselectable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def value(value: String | js.Array[String] | Double): this.type = set("value", value.asInstanceOf[js.Any])
    
    @scala.inline
    def valueVarargs(value: String*): this.type = set("value", js.Array(value :_*))
    
    @scala.inline
    def vocab(value: String): this.type = set("vocab", value.asInstanceOf[js.Any])
    
    @scala.inline
    def width(value: Double | String): this.type = set("width", value.asInstanceOf[js.Any])
  }
  
  implicit def make(companion: Input.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: StrictInputProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}

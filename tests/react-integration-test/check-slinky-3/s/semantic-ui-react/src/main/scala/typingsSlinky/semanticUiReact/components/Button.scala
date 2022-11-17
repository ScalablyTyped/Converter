package typingsSlinky.semanticUiReact.components

import org.scalajs.dom.Event
import org.scalajs.dom.EventTarget
import org.scalajs.dom.HTMLButtonElement
import slinky.core.SyntheticEvent
import slinky.core.facade.ReactElement
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
import typingsSlinky.react.mod.ReactNodeArray
import typingsSlinky.react.mod.ReactType
import typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonContentMod.ButtonContentProps
import typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonGroupMod.ButtonGroupProps
import typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonMod.ButtonProps
import typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonMod.StrictButtonProps
import typingsSlinky.semanticUiReact.distCommonjsElementsButtonButtonOrMod.ButtonOrProps
import typingsSlinky.semanticUiReact.distCommonjsElementsButtonMod.default
import typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticCOLORS
import typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticFLOATS
import typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticSIZES
import typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticShorthandContent
import typingsSlinky.semanticUiReact.distCommonjsGenericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object Button {
  
  object Content {
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Content")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Content.type): SharedBuilder_ButtonContentProps920536737 = new SharedBuilder_ButtonContentProps920536737(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: ButtonContentProps): SharedBuilder_ButtonContentProps920536737 = new SharedBuilder_ButtonContentProps920536737(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Group {
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Group")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Group.type): SharedBuilder_ButtonGroupProps1675589688 = new SharedBuilder_ButtonGroupProps1675589688(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: ButtonGroupProps): SharedBuilder_ButtonGroupProps1675589688 = new SharedBuilder_ButtonGroupProps1675589688(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object Or {
    
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button", "default.Or")
    @js.native
    val component: js.Object = js.native
    
    implicit def make(companion: Or.type): SharedBuilder_ButtonOrProps1040544165 = new SharedBuilder_ButtonOrProps1040544165(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(p: ButtonOrProps): SharedBuilder_ButtonOrProps1040544165 = new SharedBuilder_ButtonOrProps1040544165(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, default] {
    
    inline def about(value: String): this.type = set("about", value.asInstanceOf[js.Any])
    
    inline def accessKey(value: String): this.type = set("accessKey", value.asInstanceOf[js.Any])
    
    inline def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
    
    inline def animated(value: Boolean | "fade" | "vertical"): this.type = set("animated", value.asInstanceOf[js.Any])
    
    inline def `aria-activedescendant`(value: String): this.type = set("aria-activedescendant", value.asInstanceOf[js.Any])
    
    inline def `aria-atomic`(value: Boolean): this.type = set("aria-atomic", value.asInstanceOf[js.Any])
    
    inline def `aria-autocomplete`(value: "none" | "inline" | "list" | "both"): this.type = set("aria-autocomplete", value.asInstanceOf[js.Any])
    
    inline def `aria-busy`(value: Boolean): this.type = set("aria-busy", value.asInstanceOf[js.Any])
    
    inline def `aria-checked`(value: Boolean | "mixed"): this.type = set("aria-checked", value.asInstanceOf[js.Any])
    
    inline def `aria-colcount`(value: Double): this.type = set("aria-colcount", value.asInstanceOf[js.Any])
    
    inline def `aria-colindex`(value: Double): this.type = set("aria-colindex", value.asInstanceOf[js.Any])
    
    inline def `aria-colspan`(value: Double): this.type = set("aria-colspan", value.asInstanceOf[js.Any])
    
    inline def `aria-controls`(value: String): this.type = set("aria-controls", value.asInstanceOf[js.Any])
    
    inline def `aria-current`(value: Boolean | "page" | "step" | "location" | "date" | "time"): this.type = set("aria-current", value.asInstanceOf[js.Any])
    
    inline def `aria-describedby`(value: String): this.type = set("aria-describedby", value.asInstanceOf[js.Any])
    
    inline def `aria-details`(value: String): this.type = set("aria-details", value.asInstanceOf[js.Any])
    
    inline def `aria-disabled`(value: Boolean): this.type = set("aria-disabled", value.asInstanceOf[js.Any])
    
    inline def `aria-dropeffect`(value: "none" | "copy" | "execute" | "link" | "move" | "popup"): this.type = set("aria-dropeffect", value.asInstanceOf[js.Any])
    
    inline def `aria-errormessage`(value: String): this.type = set("aria-errormessage", value.asInstanceOf[js.Any])
    
    inline def `aria-expanded`(value: Boolean): this.type = set("aria-expanded", value.asInstanceOf[js.Any])
    
    inline def `aria-flowto`(value: String): this.type = set("aria-flowto", value.asInstanceOf[js.Any])
    
    inline def `aria-grabbed`(value: Boolean): this.type = set("aria-grabbed", value.asInstanceOf[js.Any])
    
    inline def `aria-haspopup`(value: Boolean | "menu" | "listbox" | "tree" | "grid" | "dialog"): this.type = set("aria-haspopup", value.asInstanceOf[js.Any])
    
    inline def `aria-hidden`(value: Boolean): this.type = set("aria-hidden", value.asInstanceOf[js.Any])
    
    inline def `aria-invalid`(value: Boolean | "grammar" | "spelling"): this.type = set("aria-invalid", value.asInstanceOf[js.Any])
    
    inline def `aria-keyshortcuts`(value: String): this.type = set("aria-keyshortcuts", value.asInstanceOf[js.Any])
    
    inline def `aria-label`(value: String): this.type = set("aria-label", value.asInstanceOf[js.Any])
    
    inline def `aria-labelledby`(value: String): this.type = set("aria-labelledby", value.asInstanceOf[js.Any])
    
    inline def `aria-level`(value: Double): this.type = set("aria-level", value.asInstanceOf[js.Any])
    
    inline def `aria-live`(value: "off" | "assertive" | "polite"): this.type = set("aria-live", value.asInstanceOf[js.Any])
    
    inline def `aria-modal`(value: Boolean): this.type = set("aria-modal", value.asInstanceOf[js.Any])
    
    inline def `aria-multiline`(value: Boolean): this.type = set("aria-multiline", value.asInstanceOf[js.Any])
    
    inline def `aria-multiselectable`(value: Boolean): this.type = set("aria-multiselectable", value.asInstanceOf[js.Any])
    
    inline def `aria-orientation`(value: "horizontal" | "vertical"): this.type = set("aria-orientation", value.asInstanceOf[js.Any])
    
    inline def `aria-owns`(value: String): this.type = set("aria-owns", value.asInstanceOf[js.Any])
    
    inline def `aria-placeholder`(value: String): this.type = set("aria-placeholder", value.asInstanceOf[js.Any])
    
    inline def `aria-posinset`(value: Double): this.type = set("aria-posinset", value.asInstanceOf[js.Any])
    
    inline def `aria-pressed`(value: Boolean | "mixed"): this.type = set("aria-pressed", value.asInstanceOf[js.Any])
    
    inline def `aria-readonly`(value: Boolean): this.type = set("aria-readonly", value.asInstanceOf[js.Any])
    
    inline def `aria-relevant`(value: "additions" | ("additions text") | "all" | "removals" | "text"): this.type = set("aria-relevant", value.asInstanceOf[js.Any])
    
    inline def `aria-required`(value: Boolean): this.type = set("aria-required", value.asInstanceOf[js.Any])
    
    inline def `aria-roledescription`(value: String): this.type = set("aria-roledescription", value.asInstanceOf[js.Any])
    
    inline def `aria-rowcount`(value: Double): this.type = set("aria-rowcount", value.asInstanceOf[js.Any])
    
    inline def `aria-rowindex`(value: Double): this.type = set("aria-rowindex", value.asInstanceOf[js.Any])
    
    inline def `aria-rowspan`(value: Double): this.type = set("aria-rowspan", value.asInstanceOf[js.Any])
    
    inline def `aria-selected`(value: Boolean): this.type = set("aria-selected", value.asInstanceOf[js.Any])
    
    inline def `aria-setsize`(value: Double): this.type = set("aria-setsize", value.asInstanceOf[js.Any])
    
    inline def `aria-sort`(value: "none" | "ascending" | "descending" | "other"): this.type = set("aria-sort", value.asInstanceOf[js.Any])
    
    inline def `aria-valuemax`(value: Double): this.type = set("aria-valuemax", value.asInstanceOf[js.Any])
    
    inline def `aria-valuemin`(value: Double): this.type = set("aria-valuemin", value.asInstanceOf[js.Any])
    
    inline def `aria-valuenow`(value: Double): this.type = set("aria-valuenow", value.asInstanceOf[js.Any])
    
    inline def `aria-valuetext`(value: String): this.type = set("aria-valuetext", value.asInstanceOf[js.Any])
    
    inline def as(value: Any): this.type = set("as", value.asInstanceOf[js.Any])
    
    inline def attached(value: Boolean | "left" | "right" | "top" | "bottom"): this.type = set("attached", value.asInstanceOf[js.Any])
    
    inline def autoCapitalize(value: String): this.type = set("autoCapitalize", value.asInstanceOf[js.Any])
    
    inline def autoCorrect(value: String): this.type = set("autoCorrect", value.asInstanceOf[js.Any])
    
    inline def autoFocus(value: Boolean): this.type = set("autoFocus", value.asInstanceOf[js.Any])
    
    inline def autoSave(value: String): this.type = set("autoSave", value.asInstanceOf[js.Any])
    
    inline def basic(value: Boolean): this.type = set("basic", value.asInstanceOf[js.Any])
    
    inline def circular(value: Boolean): this.type = set("circular", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def color(
      value: SemanticCOLORS | "facebook" | ("google plus") | "vk" | "twitter" | "linkedin" | "instagram" | "youtube"
    ): this.type = set("color", value.asInstanceOf[js.Any])
    
    inline def compact(value: Boolean): this.type = set("compact", value.asInstanceOf[js.Any])
    
    inline def content(value: SemanticShorthandContent): this.type = set("content", value.asInstanceOf[js.Any])
    
    inline def contentEditable(value: Boolean): this.type = set("contentEditable", value.asInstanceOf[js.Any])
    
    inline def contextMenu(value: String): this.type = set("contextMenu", value.asInstanceOf[js.Any])
    
    inline def dangerouslySetInnerHTML(value: Html): this.type = set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    inline def datatype(value: String): this.type = set("datatype", value.asInstanceOf[js.Any])
    
    inline def defaultChecked(value: Boolean): this.type = set("defaultChecked", value.asInstanceOf[js.Any])
    
    inline def defaultValue(value: String | js.Array[String]): this.type = set("defaultValue", value.asInstanceOf[js.Any])
    
    inline def defaultValueVarargs(value: String*): this.type = set("defaultValue", js.Array(value*))
    
    inline def dir(value: String): this.type = set("dir", value.asInstanceOf[js.Any])
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def draggable(value: Boolean): this.type = set("draggable", value.asInstanceOf[js.Any])
    
    inline def floated(value: SemanticFLOATS): this.type = set("floated", value.asInstanceOf[js.Any])
    
    inline def fluid(value: Boolean): this.type = set("fluid", value.asInstanceOf[js.Any])
    
    inline def form(value: String): this.type = set("form", value.asInstanceOf[js.Any])
    
    inline def formAction(value: String): this.type = set("formAction", value.asInstanceOf[js.Any])
    
    inline def formEncType(value: String): this.type = set("formEncType", value.asInstanceOf[js.Any])
    
    inline def formMethod(value: String): this.type = set("formMethod", value.asInstanceOf[js.Any])
    
    inline def formNoValidate(value: Boolean): this.type = set("formNoValidate", value.asInstanceOf[js.Any])
    
    inline def formTarget(value: String): this.type = set("formTarget", value.asInstanceOf[js.Any])
    
    inline def hidden(value: Boolean): this.type = set("hidden", value.asInstanceOf[js.Any])
    
    inline def icon(
      value: Boolean | (SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any
        ])
    ): this.type = set("icon", value.asInstanceOf[js.Any])
    
    inline def iconFunction3(
      value: (/* component */ ReactType[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any
        ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any, /* children */ js.UndefOr[ReactElement | ReactNodeArray]) => ReactElement | Null
    ): this.type = set("icon", js.Any.fromFunction3(value))
    
    inline def iconReactElement(value: ReactElement): this.type = set("icon", value.asInstanceOf[js.Any])
    
    inline def id(value: String): this.type = set("id", value.asInstanceOf[js.Any])
    
    inline def inlist(value: Any): this.type = set("inlist", value.asInstanceOf[js.Any])
    
    inline def inputMode(value: String): this.type = set("inputMode", value.asInstanceOf[js.Any])
    
    inline def inverted(value: Boolean): this.type = set("inverted", value.asInstanceOf[js.Any])
    
    inline def is(value: String): this.type = set("is", value.asInstanceOf[js.Any])
    
    inline def itemID(value: String): this.type = set("itemID", value.asInstanceOf[js.Any])
    
    inline def itemProp(value: String): this.type = set("itemProp", value.asInstanceOf[js.Any])
    
    inline def itemRef(value: String): this.type = set("itemRef", value.asInstanceOf[js.Any])
    
    inline def itemScope(value: Boolean): this.type = set("itemScope", value.asInstanceOf[js.Any])
    
    inline def itemType(value: String): this.type = set("itemType", value.asInstanceOf[js.Any])
    
    inline def label(
      value: SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ Any
        ]
    ): this.type = set("label", value.asInstanceOf[js.Any])
    
    inline def labelFunction3(
      value: (/* component */ ReactType[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ Any
        ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ Any, /* children */ js.UndefOr[ReactElement | ReactNodeArray]) => ReactElement | Null
    ): this.type = set("label", js.Any.fromFunction3(value))
    
    inline def labelPosition(value: "right" | "left"): this.type = set("labelPosition", value.asInstanceOf[js.Any])
    
    inline def labelReactElement(value: ReactElement): this.type = set("label", value.asInstanceOf[js.Any])
    
    inline def lang(value: String): this.type = set("lang", value.asInstanceOf[js.Any])
    
    inline def loading(value: Boolean): this.type = set("loading", value.asInstanceOf[js.Any])
    
    inline def name(value: String): this.type = set("name", value.asInstanceOf[js.Any])
    
    inline def negative(value: Boolean): this.type = set("negative", value.asInstanceOf[js.Any])
    
    inline def onAbort(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onAbort", js.Any.fromFunction1(value))
    
    inline def onAnimationEnd(value: SyntheticAnimationEvent[HTMLButtonElement] => Unit): this.type = set("onAnimationEnd", js.Any.fromFunction1(value))
    
    inline def onAnimationIteration(value: SyntheticAnimationEvent[HTMLButtonElement] => Unit): this.type = set("onAnimationIteration", js.Any.fromFunction1(value))
    
    inline def onAnimationStart(value: SyntheticAnimationEvent[HTMLButtonElement] => Unit): this.type = set("onAnimationStart", js.Any.fromFunction1(value))
    
    inline def onAuxClick(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onAuxClick", js.Any.fromFunction1(value))
    
    inline def onBeforeInput(value: SyntheticEvent[EventTarget & HTMLButtonElement, Event] => Unit): this.type = set("onBeforeInput", js.Any.fromFunction1(value))
    
    inline def onBlur(value: SyntheticFocusEvent[HTMLButtonElement] => Unit): this.type = set("onBlur", js.Any.fromFunction1(value))
    
    inline def onCanPlay(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onCanPlay", js.Any.fromFunction1(value))
    
    inline def onCanPlayThrough(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onCanPlayThrough", js.Any.fromFunction1(value))
    
    inline def onChange(value: SyntheticEvent[EventTarget & HTMLButtonElement, Event] => Unit): this.type = set("onChange", js.Any.fromFunction1(value))
    
    inline def onClick(value: (/* event */ SyntheticMouseEvent[HTMLButtonElement], /* data */ ButtonProps) => Unit): this.type = set("onClick", js.Any.fromFunction2(value))
    
    inline def onCompositionEnd(value: SyntheticCompositionEvent[HTMLButtonElement] => Unit): this.type = set("onCompositionEnd", js.Any.fromFunction1(value))
    
    inline def onCompositionStart(value: SyntheticCompositionEvent[HTMLButtonElement] => Unit): this.type = set("onCompositionStart", js.Any.fromFunction1(value))
    
    inline def onCompositionUpdate(value: SyntheticCompositionEvent[HTMLButtonElement] => Unit): this.type = set("onCompositionUpdate", js.Any.fromFunction1(value))
    
    inline def onContextMenu(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onContextMenu", js.Any.fromFunction1(value))
    
    inline def onCopy(value: SyntheticClipboardEvent[HTMLButtonElement] => Unit): this.type = set("onCopy", js.Any.fromFunction1(value))
    
    inline def onCut(value: SyntheticClipboardEvent[HTMLButtonElement] => Unit): this.type = set("onCut", js.Any.fromFunction1(value))
    
    inline def onDoubleClick(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onDoubleClick", js.Any.fromFunction1(value))
    
    inline def onDrag(value: DragEvent[HTMLButtonElement] => Unit): this.type = set("onDrag", js.Any.fromFunction1(value))
    
    inline def onDragEnd(value: DragEvent[HTMLButtonElement] => Unit): this.type = set("onDragEnd", js.Any.fromFunction1(value))
    
    inline def onDragEnter(value: DragEvent[HTMLButtonElement] => Unit): this.type = set("onDragEnter", js.Any.fromFunction1(value))
    
    inline def onDragExit(value: DragEvent[HTMLButtonElement] => Unit): this.type = set("onDragExit", js.Any.fromFunction1(value))
    
    inline def onDragLeave(value: DragEvent[HTMLButtonElement] => Unit): this.type = set("onDragLeave", js.Any.fromFunction1(value))
    
    inline def onDragOver(value: DragEvent[HTMLButtonElement] => Unit): this.type = set("onDragOver", js.Any.fromFunction1(value))
    
    inline def onDragStart(value: DragEvent[HTMLButtonElement] => Unit): this.type = set("onDragStart", js.Any.fromFunction1(value))
    
    inline def onDrop(value: DragEvent[HTMLButtonElement] => Unit): this.type = set("onDrop", js.Any.fromFunction1(value))
    
    inline def onDurationChange(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onDurationChange", js.Any.fromFunction1(value))
    
    inline def onEmptied(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onEmptied", js.Any.fromFunction1(value))
    
    inline def onEncrypted(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onEncrypted", js.Any.fromFunction1(value))
    
    inline def onEnded(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onEnded", js.Any.fromFunction1(value))
    
    inline def onError(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onError", js.Any.fromFunction1(value))
    
    inline def onFocus(value: SyntheticFocusEvent[HTMLButtonElement] => Unit): this.type = set("onFocus", js.Any.fromFunction1(value))
    
    inline def onInput(value: SyntheticEvent[EventTarget & HTMLButtonElement, Event] => Unit): this.type = set("onInput", js.Any.fromFunction1(value))
    
    inline def onInvalid(value: SyntheticEvent[EventTarget & HTMLButtonElement, Event] => Unit): this.type = set("onInvalid", js.Any.fromFunction1(value))
    
    inline def onKeyDown(value: SyntheticKeyboardEvent[HTMLButtonElement] => Unit): this.type = set("onKeyDown", js.Any.fromFunction1(value))
    
    inline def onKeyPress(value: SyntheticKeyboardEvent[HTMLButtonElement] => Unit): this.type = set("onKeyPress", js.Any.fromFunction1(value))
    
    inline def onKeyUp(value: SyntheticKeyboardEvent[HTMLButtonElement] => Unit): this.type = set("onKeyUp", js.Any.fromFunction1(value))
    
    inline def onLoad(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onLoad", js.Any.fromFunction1(value))
    
    inline def onLoadStart(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onLoadStart", js.Any.fromFunction1(value))
    
    inline def onLoadedData(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onLoadedData", js.Any.fromFunction1(value))
    
    inline def onLoadedMetadata(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onLoadedMetadata", js.Any.fromFunction1(value))
    
    inline def onMouseDown(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onMouseDown", js.Any.fromFunction1(value))
    
    inline def onMouseEnter(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onMouseEnter", js.Any.fromFunction1(value))
    
    inline def onMouseLeave(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onMouseLeave", js.Any.fromFunction1(value))
    
    inline def onMouseMove(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onMouseMove", js.Any.fromFunction1(value))
    
    inline def onMouseOut(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onMouseOut", js.Any.fromFunction1(value))
    
    inline def onMouseOver(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onMouseOver", js.Any.fromFunction1(value))
    
    inline def onMouseUp(value: SyntheticMouseEvent[HTMLButtonElement] => Unit): this.type = set("onMouseUp", js.Any.fromFunction1(value))
    
    inline def onPaste(value: SyntheticClipboardEvent[HTMLButtonElement] => Unit): this.type = set("onPaste", js.Any.fromFunction1(value))
    
    inline def onPause(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onPause", js.Any.fromFunction1(value))
    
    inline def onPlay(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onPlay", js.Any.fromFunction1(value))
    
    inline def onPlaying(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onPlaying", js.Any.fromFunction1(value))
    
    inline def onPointerCancel(value: SyntheticPointerEvent[HTMLButtonElement] => Unit): this.type = set("onPointerCancel", js.Any.fromFunction1(value))
    
    inline def onPointerDown(value: SyntheticPointerEvent[HTMLButtonElement] => Unit): this.type = set("onPointerDown", js.Any.fromFunction1(value))
    
    inline def onPointerEnter(value: SyntheticPointerEvent[HTMLButtonElement] => Unit): this.type = set("onPointerEnter", js.Any.fromFunction1(value))
    
    inline def onPointerLeave(value: SyntheticPointerEvent[HTMLButtonElement] => Unit): this.type = set("onPointerLeave", js.Any.fromFunction1(value))
    
    inline def onPointerMove(value: SyntheticPointerEvent[HTMLButtonElement] => Unit): this.type = set("onPointerMove", js.Any.fromFunction1(value))
    
    inline def onPointerOut(value: SyntheticPointerEvent[HTMLButtonElement] => Unit): this.type = set("onPointerOut", js.Any.fromFunction1(value))
    
    inline def onPointerOver(value: SyntheticPointerEvent[HTMLButtonElement] => Unit): this.type = set("onPointerOver", js.Any.fromFunction1(value))
    
    inline def onPointerUp(value: SyntheticPointerEvent[HTMLButtonElement] => Unit): this.type = set("onPointerUp", js.Any.fromFunction1(value))
    
    inline def onProgress(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onProgress", js.Any.fromFunction1(value))
    
    inline def onRateChange(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onRateChange", js.Any.fromFunction1(value))
    
    inline def onReset(value: SyntheticEvent[EventTarget & HTMLButtonElement, Event] => Unit): this.type = set("onReset", js.Any.fromFunction1(value))
    
    inline def onScroll(value: SyntheticUIEvent[HTMLButtonElement] => Unit): this.type = set("onScroll", js.Any.fromFunction1(value))
    
    inline def onSeeked(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onSeeked", js.Any.fromFunction1(value))
    
    inline def onSeeking(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onSeeking", js.Any.fromFunction1(value))
    
    inline def onSelect(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onSelect", js.Any.fromFunction1(value))
    
    inline def onStalled(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onStalled", js.Any.fromFunction1(value))
    
    inline def onSubmit(value: SyntheticEvent[EventTarget & HTMLButtonElement, Event] => Unit): this.type = set("onSubmit", js.Any.fromFunction1(value))
    
    inline def onSuspend(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onSuspend", js.Any.fromFunction1(value))
    
    inline def onTimeUpdate(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onTimeUpdate", js.Any.fromFunction1(value))
    
    inline def onTouchCancel(value: SyntheticTouchEvent[HTMLButtonElement] => Unit): this.type = set("onTouchCancel", js.Any.fromFunction1(value))
    
    inline def onTouchEnd(value: SyntheticTouchEvent[HTMLButtonElement] => Unit): this.type = set("onTouchEnd", js.Any.fromFunction1(value))
    
    inline def onTouchMove(value: SyntheticTouchEvent[HTMLButtonElement] => Unit): this.type = set("onTouchMove", js.Any.fromFunction1(value))
    
    inline def onTouchStart(value: SyntheticTouchEvent[HTMLButtonElement] => Unit): this.type = set("onTouchStart", js.Any.fromFunction1(value))
    
    inline def onTransitionEnd(value: SyntheticTransitionEvent[HTMLButtonElement] => Unit): this.type = set("onTransitionEnd", js.Any.fromFunction1(value))
    
    inline def onVolumeChange(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onVolumeChange", js.Any.fromFunction1(value))
    
    inline def onWaiting(value: SyntheticEvent[Event, HTMLButtonElement] => Unit): this.type = set("onWaiting", js.Any.fromFunction1(value))
    
    inline def onWheel(value: SyntheticWheelEvent[HTMLButtonElement] => Unit): this.type = set("onWheel", js.Any.fromFunction1(value))
    
    inline def placeholder(value: String): this.type = set("placeholder", value.asInstanceOf[js.Any])
    
    inline def positive(value: Boolean): this.type = set("positive", value.asInstanceOf[js.Any])
    
    inline def prefix(value: String): this.type = set("prefix", value.asInstanceOf[js.Any])
    
    inline def primary(value: Boolean): this.type = set("primary", value.asInstanceOf[js.Any])
    
    inline def property(value: String): this.type = set("property", value.asInstanceOf[js.Any])
    
    inline def radioGroup(value: String): this.type = set("radioGroup", value.asInstanceOf[js.Any])
    
    inline def resource(value: String): this.type = set("resource", value.asInstanceOf[js.Any])
    
    inline def results(value: Double): this.type = set("results", value.asInstanceOf[js.Any])
    
    inline def role(value: String): this.type = set("role", value.asInstanceOf[js.Any])
    
    inline def secondary(value: Boolean): this.type = set("secondary", value.asInstanceOf[js.Any])
    
    inline def security(value: String): this.type = set("security", value.asInstanceOf[js.Any])
    
    inline def size(value: SemanticSIZES): this.type = set("size", value.asInstanceOf[js.Any])
    
    inline def slot(value: String): this.type = set("slot", value.asInstanceOf[js.Any])
    
    inline def spellCheck(value: Boolean): this.type = set("spellCheck", value.asInstanceOf[js.Any])
    
    inline def style(value: CSSProperties): this.type = set("style", value.asInstanceOf[js.Any])
    
    inline def suppressContentEditableWarning(value: Boolean): this.type = set("suppressContentEditableWarning", value.asInstanceOf[js.Any])
    
    inline def suppressHydrationWarning(value: Boolean): this.type = set("suppressHydrationWarning", value.asInstanceOf[js.Any])
    
    inline def tabIndex(value: Double | String): this.type = set("tabIndex", value.asInstanceOf[js.Any])
    
    inline def title(value: String): this.type = set("title", value.asInstanceOf[js.Any])
    
    inline def toggle(value: Boolean): this.type = set("toggle", value.asInstanceOf[js.Any])
    
    inline def `type`(value: "submit" | "reset" | "button"): this.type = set("type", value.asInstanceOf[js.Any])
    
    inline def typeof(value: String): this.type = set("typeof", value.asInstanceOf[js.Any])
    
    inline def unselectable(value: "on" | "off"): this.type = set("unselectable", value.asInstanceOf[js.Any])
    
    inline def value(value: String | js.Array[String] | Double): this.type = set("value", value.asInstanceOf[js.Any])
    
    inline def valueVarargs(value: String*): this.type = set("value", js.Array(value*))
    
    inline def vocab(value: String): this.type = set("vocab", value.asInstanceOf[js.Any])
  }
  
  implicit def make(companion: Button.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: StrictButtonProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}

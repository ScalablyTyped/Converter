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
import org.scalajs.dom.Element
import org.scalajs.dom.SVGViewElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.anon.Html
import typingsJapgolly.react.mod.CSSProperties
import typingsJapgolly.react.mod.SVGProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object view {
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[SVGViewElement] {
    
    inline def accentHeight(value: Double | String): this.type = set("accentHeight", value.asInstanceOf[js.Any])
    
    inline def accumulate(value: "none" | "sum"): this.type = set("accumulate", value.asInstanceOf[js.Any])
    
    inline def additive(value: "replace" | "sum"): this.type = set("additive", value.asInstanceOf[js.Any])
    
    inline def alignmentBaseline(
      value: "auto" | "baseline" | "before-edge" | "text-before-edge" | "middle" | "central" | "after-edge" | "text-after-edge" | "ideographic" | "alphabetic" | "hanging" | "mathematical" | "inherit"
    ): this.type = set("alignmentBaseline", value.asInstanceOf[js.Any])
    
    inline def allowReorder(value: "no" | "yes"): this.type = set("allowReorder", value.asInstanceOf[js.Any])
    
    inline def alphabetic(value: Double | String): this.type = set("alphabetic", value.asInstanceOf[js.Any])
    
    inline def amplitude(value: Double | String): this.type = set("amplitude", value.asInstanceOf[js.Any])
    
    inline def arabicForm(value: "initial" | "medial" | "terminal" | "isolated"): this.type = set("arabicForm", value.asInstanceOf[js.Any])
    
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
    
    inline def ascent(value: Double | String): this.type = set("ascent", value.asInstanceOf[js.Any])
    
    inline def attributeName(value: String): this.type = set("attributeName", value.asInstanceOf[js.Any])
    
    inline def attributeType(value: String): this.type = set("attributeType", value.asInstanceOf[js.Any])
    
    inline def autoReverse(value: Double | String): this.type = set("autoReverse", value.asInstanceOf[js.Any])
    
    inline def azimuth(value: Double | String): this.type = set("azimuth", value.asInstanceOf[js.Any])
    
    inline def baseFrequency(value: Double | String): this.type = set("baseFrequency", value.asInstanceOf[js.Any])
    
    inline def baseProfile(value: Double | String): this.type = set("baseProfile", value.asInstanceOf[js.Any])
    
    inline def baselineShift(value: Double | String): this.type = set("baselineShift", value.asInstanceOf[js.Any])
    
    inline def bbox(value: Double | String): this.type = set("bbox", value.asInstanceOf[js.Any])
    
    inline def begin(value: Double | String): this.type = set("begin", value.asInstanceOf[js.Any])
    
    inline def bias(value: Double | String): this.type = set("bias", value.asInstanceOf[js.Any])
    
    inline def by(value: Double | String): this.type = set("by", value.asInstanceOf[js.Any])
    
    inline def calcMode(value: Double | String): this.type = set("calcMode", value.asInstanceOf[js.Any])
    
    inline def capHeight(value: Double | String): this.type = set("capHeight", value.asInstanceOf[js.Any])
    
    inline def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    inline def clip(value: Double | String): this.type = set("clip", value.asInstanceOf[js.Any])
    
    inline def clipPath(value: String): this.type = set("clipPath", value.asInstanceOf[js.Any])
    
    inline def clipPathUnits(value: Double | String): this.type = set("clipPathUnits", value.asInstanceOf[js.Any])
    
    inline def clipRule(value: Double | String): this.type = set("clipRule", value.asInstanceOf[js.Any])
    
    inline def color(value: String): this.type = set("color", value.asInstanceOf[js.Any])
    
    inline def colorInterpolation(value: Double | String): this.type = set("colorInterpolation", value.asInstanceOf[js.Any])
    
    inline def colorInterpolationFilters(value: "auto" | "sRGB" | "linearRGB" | "inherit"): this.type = set("colorInterpolationFilters", value.asInstanceOf[js.Any])
    
    inline def colorProfile(value: Double | String): this.type = set("colorProfile", value.asInstanceOf[js.Any])
    
    inline def colorRendering(value: Double | String): this.type = set("colorRendering", value.asInstanceOf[js.Any])
    
    inline def contentScriptType(value: Double | String): this.type = set("contentScriptType", value.asInstanceOf[js.Any])
    
    inline def contentStyleType(value: Double | String): this.type = set("contentStyleType", value.asInstanceOf[js.Any])
    
    inline def cursor(value: Double | String): this.type = set("cursor", value.asInstanceOf[js.Any])
    
    inline def cx(value: Double | String): this.type = set("cx", value.asInstanceOf[js.Any])
    
    inline def cy(value: Double | String): this.type = set("cy", value.asInstanceOf[js.Any])
    
    inline def d(value: String): this.type = set("d", value.asInstanceOf[js.Any])
    
    inline def dangerouslySetInnerHTML(value: Html): this.type = set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    inline def decelerate(value: Double | String): this.type = set("decelerate", value.asInstanceOf[js.Any])
    
    inline def descent(value: Double | String): this.type = set("descent", value.asInstanceOf[js.Any])
    
    inline def diffuseConstant(value: Double | String): this.type = set("diffuseConstant", value.asInstanceOf[js.Any])
    
    inline def direction(value: Double | String): this.type = set("direction", value.asInstanceOf[js.Any])
    
    inline def display(value: Double | String): this.type = set("display", value.asInstanceOf[js.Any])
    
    inline def divisor(value: Double | String): this.type = set("divisor", value.asInstanceOf[js.Any])
    
    inline def dominantBaseline(value: Double | String): this.type = set("dominantBaseline", value.asInstanceOf[js.Any])
    
    inline def dur(value: Double | String): this.type = set("dur", value.asInstanceOf[js.Any])
    
    inline def dx(value: Double | String): this.type = set("dx", value.asInstanceOf[js.Any])
    
    inline def dy(value: Double | String): this.type = set("dy", value.asInstanceOf[js.Any])
    
    inline def edgeMode(value: Double | String): this.type = set("edgeMode", value.asInstanceOf[js.Any])
    
    inline def elevation(value: Double | String): this.type = set("elevation", value.asInstanceOf[js.Any])
    
    inline def enableBackground(value: Double | String): this.type = set("enableBackground", value.asInstanceOf[js.Any])
    
    inline def end(value: Double | String): this.type = set("end", value.asInstanceOf[js.Any])
    
    inline def exponent(value: Double | String): this.type = set("exponent", value.asInstanceOf[js.Any])
    
    inline def externalResourcesRequired(value: Double | String): this.type = set("externalResourcesRequired", value.asInstanceOf[js.Any])
    
    inline def fill(value: String): this.type = set("fill", value.asInstanceOf[js.Any])
    
    inline def fillOpacity(value: Double | String): this.type = set("fillOpacity", value.asInstanceOf[js.Any])
    
    inline def fillRule(value: "nonzero" | "evenodd" | "inherit"): this.type = set("fillRule", value.asInstanceOf[js.Any])
    
    inline def filter(value: String): this.type = set("filter", value.asInstanceOf[js.Any])
    
    inline def filterRes(value: Double | String): this.type = set("filterRes", value.asInstanceOf[js.Any])
    
    inline def filterUnits(value: Double | String): this.type = set("filterUnits", value.asInstanceOf[js.Any])
    
    inline def floodColor(value: Double | String): this.type = set("floodColor", value.asInstanceOf[js.Any])
    
    inline def floodOpacity(value: Double | String): this.type = set("floodOpacity", value.asInstanceOf[js.Any])
    
    inline def focusable(value: Double | String): this.type = set("focusable", value.asInstanceOf[js.Any])
    
    inline def fontFamily(value: String): this.type = set("fontFamily", value.asInstanceOf[js.Any])
    
    inline def fontSize(value: Double | String): this.type = set("fontSize", value.asInstanceOf[js.Any])
    
    inline def fontSizeAdjust(value: Double | String): this.type = set("fontSizeAdjust", value.asInstanceOf[js.Any])
    
    inline def fontStretch(value: Double | String): this.type = set("fontStretch", value.asInstanceOf[js.Any])
    
    inline def fontStyle(value: Double | String): this.type = set("fontStyle", value.asInstanceOf[js.Any])
    
    inline def fontVariant(value: Double | String): this.type = set("fontVariant", value.asInstanceOf[js.Any])
    
    inline def fontWeight(value: Double | String): this.type = set("fontWeight", value.asInstanceOf[js.Any])
    
    inline def format(value: Double | String): this.type = set("format", value.asInstanceOf[js.Any])
    
    inline def from(value: Double | String): this.type = set("from", value.asInstanceOf[js.Any])
    
    inline def fx(value: Double | String): this.type = set("fx", value.asInstanceOf[js.Any])
    
    inline def fy(value: Double | String): this.type = set("fy", value.asInstanceOf[js.Any])
    
    inline def g1(value: Double | String): this.type = set("g1", value.asInstanceOf[js.Any])
    
    inline def g2(value: Double | String): this.type = set("g2", value.asInstanceOf[js.Any])
    
    inline def glyphName(value: Double | String): this.type = set("glyphName", value.asInstanceOf[js.Any])
    
    inline def glyphOrientationHorizontal(value: Double | String): this.type = set("glyphOrientationHorizontal", value.asInstanceOf[js.Any])
    
    inline def glyphOrientationVertical(value: Double | String): this.type = set("glyphOrientationVertical", value.asInstanceOf[js.Any])
    
    inline def glyphRef(value: Double | String): this.type = set("glyphRef", value.asInstanceOf[js.Any])
    
    inline def gradientTransform(value: String): this.type = set("gradientTransform", value.asInstanceOf[js.Any])
    
    inline def gradientUnits(value: String): this.type = set("gradientUnits", value.asInstanceOf[js.Any])
    
    inline def hanging(value: Double | String): this.type = set("hanging", value.asInstanceOf[js.Any])
    
    inline def height(value: Double | String): this.type = set("height", value.asInstanceOf[js.Any])
    
    inline def horizAdvX(value: Double | String): this.type = set("horizAdvX", value.asInstanceOf[js.Any])
    
    inline def horizOriginX(value: Double | String): this.type = set("horizOriginX", value.asInstanceOf[js.Any])
    
    inline def href(value: String): this.type = set("href", value.asInstanceOf[js.Any])
    
    inline def id(value: String): this.type = set("id", value.asInstanceOf[js.Any])
    
    inline def ideographic(value: Double | String): this.type = set("ideographic", value.asInstanceOf[js.Any])
    
    inline def imageRendering(value: Double | String): this.type = set("imageRendering", value.asInstanceOf[js.Any])
    
    inline def in(value: String): this.type = set("in", value.asInstanceOf[js.Any])
    
    inline def in2(value: Double | String): this.type = set("in2", value.asInstanceOf[js.Any])
    
    inline def intercept(value: Double | String): this.type = set("intercept", value.asInstanceOf[js.Any])
    
    inline def k(value: Double | String): this.type = set("k", value.asInstanceOf[js.Any])
    
    inline def k1(value: Double | String): this.type = set("k1", value.asInstanceOf[js.Any])
    
    inline def k2(value: Double | String): this.type = set("k2", value.asInstanceOf[js.Any])
    
    inline def k3(value: Double | String): this.type = set("k3", value.asInstanceOf[js.Any])
    
    inline def k4(value: Double | String): this.type = set("k4", value.asInstanceOf[js.Any])
    
    inline def kernelMatrix(value: Double | String): this.type = set("kernelMatrix", value.asInstanceOf[js.Any])
    
    inline def kernelUnitLength(value: Double | String): this.type = set("kernelUnitLength", value.asInstanceOf[js.Any])
    
    inline def kerning(value: Double | String): this.type = set("kerning", value.asInstanceOf[js.Any])
    
    inline def keyPoints(value: Double | String): this.type = set("keyPoints", value.asInstanceOf[js.Any])
    
    inline def keySplines(value: Double | String): this.type = set("keySplines", value.asInstanceOf[js.Any])
    
    inline def keyTimes(value: Double | String): this.type = set("keyTimes", value.asInstanceOf[js.Any])
    
    inline def lang(value: String): this.type = set("lang", value.asInstanceOf[js.Any])
    
    inline def lengthAdjust(value: Double | String): this.type = set("lengthAdjust", value.asInstanceOf[js.Any])
    
    inline def letterSpacing(value: Double | String): this.type = set("letterSpacing", value.asInstanceOf[js.Any])
    
    inline def lightingColor(value: Double | String): this.type = set("lightingColor", value.asInstanceOf[js.Any])
    
    inline def limitingConeAngle(value: Double | String): this.type = set("limitingConeAngle", value.asInstanceOf[js.Any])
    
    inline def local(value: Double | String): this.type = set("local", value.asInstanceOf[js.Any])
    
    inline def markerEnd(value: String): this.type = set("markerEnd", value.asInstanceOf[js.Any])
    
    inline def markerHeight(value: Double | String): this.type = set("markerHeight", value.asInstanceOf[js.Any])
    
    inline def markerMid(value: String): this.type = set("markerMid", value.asInstanceOf[js.Any])
    
    inline def markerStart(value: String): this.type = set("markerStart", value.asInstanceOf[js.Any])
    
    inline def markerUnits(value: Double | String): this.type = set("markerUnits", value.asInstanceOf[js.Any])
    
    inline def markerWidth(value: Double | String): this.type = set("markerWidth", value.asInstanceOf[js.Any])
    
    inline def mask(value: String): this.type = set("mask", value.asInstanceOf[js.Any])
    
    inline def maskContentUnits(value: Double | String): this.type = set("maskContentUnits", value.asInstanceOf[js.Any])
    
    inline def maskUnits(value: Double | String): this.type = set("maskUnits", value.asInstanceOf[js.Any])
    
    inline def mathematical(value: Double | String): this.type = set("mathematical", value.asInstanceOf[js.Any])
    
    inline def max(value: Double | String): this.type = set("max", value.asInstanceOf[js.Any])
    
    inline def media(value: String): this.type = set("media", value.asInstanceOf[js.Any])
    
    inline def method(value: String): this.type = set("method", value.asInstanceOf[js.Any])
    
    inline def min(value: Double | String): this.type = set("min", value.asInstanceOf[js.Any])
    
    inline def mode(value: Double | String): this.type = set("mode", value.asInstanceOf[js.Any])
    
    inline def name(value: String): this.type = set("name", value.asInstanceOf[js.Any])
    
    inline def numOctaves(value: Double | String): this.type = set("numOctaves", value.asInstanceOf[js.Any])
    
    inline def offset(value: Double | String): this.type = set("offset", value.asInstanceOf[js.Any])
    
    inline def onAbort(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onAbort", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onAnimationEnd(value: ReactAnimationEventFrom[SVGViewElement & Element] => Callback): this.type = set("onAnimationEnd", js.Any.fromFunction1((t0: ReactAnimationEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onAnimationIteration(value: ReactAnimationEventFrom[SVGViewElement & Element] => Callback): this.type = set("onAnimationIteration", js.Any.fromFunction1((t0: ReactAnimationEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onAnimationStart(value: ReactAnimationEventFrom[SVGViewElement & Element] => Callback): this.type = set("onAnimationStart", js.Any.fromFunction1((t0: ReactAnimationEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onAuxClick(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onAuxClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onBeforeInput(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onBeforeInput", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onBlur(value: ReactFocusEventFrom[SVGViewElement & Element] => Callback): this.type = set("onBlur", js.Any.fromFunction1((t0: ReactFocusEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onCanPlay(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onCanPlay", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onCanPlayThrough(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onCanPlayThrough", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onChange(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onChange", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onClick(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onCompositionEnd(value: ReactCompositionEventFrom[SVGViewElement & Element] => Callback): this.type = set("onCompositionEnd", js.Any.fromFunction1((t0: ReactCompositionEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onCompositionStart(value: ReactCompositionEventFrom[SVGViewElement & Element] => Callback): this.type = set("onCompositionStart", js.Any.fromFunction1((t0: ReactCompositionEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onCompositionUpdate(value: ReactCompositionEventFrom[SVGViewElement & Element] => Callback): this.type = set("onCompositionUpdate", js.Any.fromFunction1((t0: ReactCompositionEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onContextMenu(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onContextMenu", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onCopy(value: ReactClipboardEventFrom[SVGViewElement & Element] => Callback): this.type = set("onCopy", js.Any.fromFunction1((t0: ReactClipboardEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onCut(value: ReactClipboardEventFrom[SVGViewElement & Element] => Callback): this.type = set("onCut", js.Any.fromFunction1((t0: ReactClipboardEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDoubleClick(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDoubleClick", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDrag(value: ReactDragEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDrag", js.Any.fromFunction1((t0: ReactDragEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDragEnd(value: ReactDragEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDragEnd", js.Any.fromFunction1((t0: ReactDragEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDragEnter(value: ReactDragEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDragEnter", js.Any.fromFunction1((t0: ReactDragEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDragExit(value: ReactDragEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDragExit", js.Any.fromFunction1((t0: ReactDragEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDragLeave(value: ReactDragEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDragLeave", js.Any.fromFunction1((t0: ReactDragEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDragOver(value: ReactDragEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDragOver", js.Any.fromFunction1((t0: ReactDragEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDragStart(value: ReactDragEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDragStart", js.Any.fromFunction1((t0: ReactDragEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDrop(value: ReactDragEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDrop", js.Any.fromFunction1((t0: ReactDragEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onDurationChange(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onDurationChange", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onEmptied(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onEmptied", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onEncrypted(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onEncrypted", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onEnded(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onEnded", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onError(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onError", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onFocus(value: ReactFocusEventFrom[SVGViewElement & Element] => Callback): this.type = set("onFocus", js.Any.fromFunction1((t0: ReactFocusEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onInput(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onInput", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onInvalid(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onInvalid", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onKeyDown(value: ReactKeyboardEventFrom[SVGViewElement & Element] => Callback): this.type = set("onKeyDown", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onKeyPress(value: ReactKeyboardEventFrom[SVGViewElement & Element] => Callback): this.type = set("onKeyPress", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onKeyUp(value: ReactKeyboardEventFrom[SVGViewElement & Element] => Callback): this.type = set("onKeyUp", js.Any.fromFunction1((t0: ReactKeyboardEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onLoad(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onLoad", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onLoadStart(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onLoadStart", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onLoadedData(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onLoadedData", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onLoadedMetadata(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onLoadedMetadata", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onMouseDown(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onMouseDown", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onMouseEnter(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onMouseEnter", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onMouseLeave(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onMouseLeave", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onMouseMove(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onMouseMove", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onMouseOut(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onMouseOut", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onMouseOver(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onMouseOver", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onMouseUp(value: ReactMouseEventFrom[SVGViewElement & Element] => Callback): this.type = set("onMouseUp", js.Any.fromFunction1((t0: ReactMouseEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPaste(value: ReactClipboardEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPaste", js.Any.fromFunction1((t0: ReactClipboardEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPause(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPause", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPlay(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPlay", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPlaying(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPlaying", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPointerCancel(value: ReactPointerEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPointerCancel", js.Any.fromFunction1((t0: ReactPointerEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPointerDown(value: ReactPointerEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPointerDown", js.Any.fromFunction1((t0: ReactPointerEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPointerEnter(value: ReactPointerEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPointerEnter", js.Any.fromFunction1((t0: ReactPointerEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPointerLeave(value: ReactPointerEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPointerLeave", js.Any.fromFunction1((t0: ReactPointerEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPointerMove(value: ReactPointerEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPointerMove", js.Any.fromFunction1((t0: ReactPointerEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPointerOut(value: ReactPointerEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPointerOut", js.Any.fromFunction1((t0: ReactPointerEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPointerOver(value: ReactPointerEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPointerOver", js.Any.fromFunction1((t0: ReactPointerEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onPointerUp(value: ReactPointerEventFrom[SVGViewElement & Element] => Callback): this.type = set("onPointerUp", js.Any.fromFunction1((t0: ReactPointerEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onProgress(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onProgress", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onRateChange(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onRateChange", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onReset(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onReset", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onScroll(value: ReactUIEventFrom[SVGViewElement & Element] => Callback): this.type = set("onScroll", js.Any.fromFunction1((t0: ReactUIEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onSeeked(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onSeeked", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onSeeking(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onSeeking", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onSelect(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onSelect", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onStalled(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onStalled", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onSubmit(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onSubmit", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onSuspend(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onSuspend", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onTimeUpdate(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onTimeUpdate", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onTouchCancel(value: ReactTouchEventFrom[SVGViewElement & Element] => Callback): this.type = set("onTouchCancel", js.Any.fromFunction1((t0: ReactTouchEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onTouchEnd(value: ReactTouchEventFrom[SVGViewElement & Element] => Callback): this.type = set("onTouchEnd", js.Any.fromFunction1((t0: ReactTouchEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onTouchMove(value: ReactTouchEventFrom[SVGViewElement & Element] => Callback): this.type = set("onTouchMove", js.Any.fromFunction1((t0: ReactTouchEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onTouchStart(value: ReactTouchEventFrom[SVGViewElement & Element] => Callback): this.type = set("onTouchStart", js.Any.fromFunction1((t0: ReactTouchEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onTransitionEnd(value: ReactTransitionEventFrom[SVGViewElement & Element] => Callback): this.type = set("onTransitionEnd", js.Any.fromFunction1((t0: ReactTransitionEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onVolumeChange(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onVolumeChange", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onWaiting(value: ReactEventFrom[SVGViewElement & Element] => Callback): this.type = set("onWaiting", js.Any.fromFunction1((t0: ReactEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def onWheel(value: ReactWheelEventFrom[SVGViewElement & Element] => Callback): this.type = set("onWheel", js.Any.fromFunction1((t0: ReactWheelEventFrom[SVGViewElement & Element]) => value(t0).runNow()))
    
    inline def opacity(value: Double | String): this.type = set("opacity", value.asInstanceOf[js.Any])
    
    inline def operator(value: Double | String): this.type = set("operator", value.asInstanceOf[js.Any])
    
    inline def order(value: Double | String): this.type = set("order", value.asInstanceOf[js.Any])
    
    inline def orient(value: Double | String): this.type = set("orient", value.asInstanceOf[js.Any])
    
    inline def orientation(value: Double | String): this.type = set("orientation", value.asInstanceOf[js.Any])
    
    inline def origin(value: Double | String): this.type = set("origin", value.asInstanceOf[js.Any])
    
    inline def overflow(value: Double | String): this.type = set("overflow", value.asInstanceOf[js.Any])
    
    inline def overlinePosition(value: Double | String): this.type = set("overlinePosition", value.asInstanceOf[js.Any])
    
    inline def overlineThickness(value: Double | String): this.type = set("overlineThickness", value.asInstanceOf[js.Any])
    
    inline def paintOrder(value: Double | String): this.type = set("paintOrder", value.asInstanceOf[js.Any])
    
    inline def panose1(value: Double | String): this.type = set("panose1", value.asInstanceOf[js.Any])
    
    inline def pathLength(value: Double | String): this.type = set("pathLength", value.asInstanceOf[js.Any])
    
    inline def patternContentUnits(value: String): this.type = set("patternContentUnits", value.asInstanceOf[js.Any])
    
    inline def patternTransform(value: Double | String): this.type = set("patternTransform", value.asInstanceOf[js.Any])
    
    inline def patternUnits(value: String): this.type = set("patternUnits", value.asInstanceOf[js.Any])
    
    inline def pointerEvents(value: Double | String): this.type = set("pointerEvents", value.asInstanceOf[js.Any])
    
    inline def points(value: String): this.type = set("points", value.asInstanceOf[js.Any])
    
    inline def pointsAtX(value: Double | String): this.type = set("pointsAtX", value.asInstanceOf[js.Any])
    
    inline def pointsAtY(value: Double | String): this.type = set("pointsAtY", value.asInstanceOf[js.Any])
    
    inline def pointsAtZ(value: Double | String): this.type = set("pointsAtZ", value.asInstanceOf[js.Any])
    
    inline def preserveAlpha(value: Double | String): this.type = set("preserveAlpha", value.asInstanceOf[js.Any])
    
    inline def preserveAspectRatio(value: String): this.type = set("preserveAspectRatio", value.asInstanceOf[js.Any])
    
    inline def primitiveUnits(value: Double | String): this.type = set("primitiveUnits", value.asInstanceOf[js.Any])
    
    inline def r(value: Double | String): this.type = set("r", value.asInstanceOf[js.Any])
    
    inline def radius(value: Double | String): this.type = set("radius", value.asInstanceOf[js.Any])
    
    inline def refX(value: Double | String): this.type = set("refX", value.asInstanceOf[js.Any])
    
    inline def refY(value: Double | String): this.type = set("refY", value.asInstanceOf[js.Any])
    
    inline def renderingIntent(value: Double | String): this.type = set("renderingIntent", value.asInstanceOf[js.Any])
    
    inline def repeatCount(value: Double | String): this.type = set("repeatCount", value.asInstanceOf[js.Any])
    
    inline def repeatDur(value: Double | String): this.type = set("repeatDur", value.asInstanceOf[js.Any])
    
    inline def requiredExtensions(value: Double | String): this.type = set("requiredExtensions", value.asInstanceOf[js.Any])
    
    inline def requiredFeatures(value: Double | String): this.type = set("requiredFeatures", value.asInstanceOf[js.Any])
    
    inline def restart(value: Double | String): this.type = set("restart", value.asInstanceOf[js.Any])
    
    inline def result(value: String): this.type = set("result", value.asInstanceOf[js.Any])
    
    inline def role(value: String): this.type = set("role", value.asInstanceOf[js.Any])
    
    inline def rotate(value: Double | String): this.type = set("rotate", value.asInstanceOf[js.Any])
    
    inline def rx(value: Double | String): this.type = set("rx", value.asInstanceOf[js.Any])
    
    inline def ry(value: Double | String): this.type = set("ry", value.asInstanceOf[js.Any])
    
    inline def scale(value: Double | String): this.type = set("scale", value.asInstanceOf[js.Any])
    
    inline def seed(value: Double | String): this.type = set("seed", value.asInstanceOf[js.Any])
    
    inline def shapeRendering(value: Double | String): this.type = set("shapeRendering", value.asInstanceOf[js.Any])
    
    inline def slope(value: Double | String): this.type = set("slope", value.asInstanceOf[js.Any])
    
    inline def spacing(value: Double | String): this.type = set("spacing", value.asInstanceOf[js.Any])
    
    inline def specularConstant(value: Double | String): this.type = set("specularConstant", value.asInstanceOf[js.Any])
    
    inline def specularExponent(value: Double | String): this.type = set("specularExponent", value.asInstanceOf[js.Any])
    
    inline def speed(value: Double | String): this.type = set("speed", value.asInstanceOf[js.Any])
    
    inline def spreadMethod(value: String): this.type = set("spreadMethod", value.asInstanceOf[js.Any])
    
    inline def startOffset(value: Double | String): this.type = set("startOffset", value.asInstanceOf[js.Any])
    
    inline def stdDeviation(value: Double | String): this.type = set("stdDeviation", value.asInstanceOf[js.Any])
    
    inline def stemh(value: Double | String): this.type = set("stemh", value.asInstanceOf[js.Any])
    
    inline def stemv(value: Double | String): this.type = set("stemv", value.asInstanceOf[js.Any])
    
    inline def stitchTiles(value: Double | String): this.type = set("stitchTiles", value.asInstanceOf[js.Any])
    
    inline def stopColor(value: String): this.type = set("stopColor", value.asInstanceOf[js.Any])
    
    inline def stopOpacity(value: Double | String): this.type = set("stopOpacity", value.asInstanceOf[js.Any])
    
    inline def strikethroughPosition(value: Double | String): this.type = set("strikethroughPosition", value.asInstanceOf[js.Any])
    
    inline def strikethroughThickness(value: Double | String): this.type = set("strikethroughThickness", value.asInstanceOf[js.Any])
    
    inline def string(value: Double | String): this.type = set("string", value.asInstanceOf[js.Any])
    
    inline def stroke(value: String): this.type = set("stroke", value.asInstanceOf[js.Any])
    
    inline def strokeDasharray(value: String | Double): this.type = set("strokeDasharray", value.asInstanceOf[js.Any])
    
    inline def strokeDashoffset(value: String | Double): this.type = set("strokeDashoffset", value.asInstanceOf[js.Any])
    
    inline def strokeLinecap(value: "butt" | "round" | "square" | "inherit"): this.type = set("strokeLinecap", value.asInstanceOf[js.Any])
    
    inline def strokeLinejoin(value: "miter" | "round" | "bevel" | "inherit"): this.type = set("strokeLinejoin", value.asInstanceOf[js.Any])
    
    inline def strokeMiterlimit(value: Double | String): this.type = set("strokeMiterlimit", value.asInstanceOf[js.Any])
    
    inline def strokeOpacity(value: Double | String): this.type = set("strokeOpacity", value.asInstanceOf[js.Any])
    
    inline def strokeWidth(value: Double | String): this.type = set("strokeWidth", value.asInstanceOf[js.Any])
    
    inline def style(value: CSSProperties): this.type = set("style", value.asInstanceOf[js.Any])
    
    inline def surfaceScale(value: Double | String): this.type = set("surfaceScale", value.asInstanceOf[js.Any])
    
    inline def systemLanguage(value: Double | String): this.type = set("systemLanguage", value.asInstanceOf[js.Any])
    
    inline def tabIndex(value: Double): this.type = set("tabIndex", value.asInstanceOf[js.Any])
    
    inline def tableValues(value: Double | String): this.type = set("tableValues", value.asInstanceOf[js.Any])
    
    inline def target(value: String): this.type = set("target", value.asInstanceOf[js.Any])
    
    inline def targetX(value: Double | String): this.type = set("targetX", value.asInstanceOf[js.Any])
    
    inline def targetY(value: Double | String): this.type = set("targetY", value.asInstanceOf[js.Any])
    
    inline def textAnchor(value: String): this.type = set("textAnchor", value.asInstanceOf[js.Any])
    
    inline def textDecoration(value: Double | String): this.type = set("textDecoration", value.asInstanceOf[js.Any])
    
    inline def textLength(value: Double | String): this.type = set("textLength", value.asInstanceOf[js.Any])
    
    inline def textRendering(value: Double | String): this.type = set("textRendering", value.asInstanceOf[js.Any])
    
    inline def to(value: Double | String): this.type = set("to", value.asInstanceOf[js.Any])
    
    inline def transform(value: String): this.type = set("transform", value.asInstanceOf[js.Any])
    
    inline def `type`(value: String): this.type = set("type", value.asInstanceOf[js.Any])
    
    inline def u1(value: Double | String): this.type = set("u1", value.asInstanceOf[js.Any])
    
    inline def u2(value: Double | String): this.type = set("u2", value.asInstanceOf[js.Any])
    
    inline def underlinePosition(value: Double | String): this.type = set("underlinePosition", value.asInstanceOf[js.Any])
    
    inline def underlineThickness(value: Double | String): this.type = set("underlineThickness", value.asInstanceOf[js.Any])
    
    inline def unicode(value: Double | String): this.type = set("unicode", value.asInstanceOf[js.Any])
    
    inline def unicodeBidi(value: Double | String): this.type = set("unicodeBidi", value.asInstanceOf[js.Any])
    
    inline def unicodeRange(value: Double | String): this.type = set("unicodeRange", value.asInstanceOf[js.Any])
    
    inline def unitsPerEm(value: Double | String): this.type = set("unitsPerEm", value.asInstanceOf[js.Any])
    
    inline def vAlphabetic(value: Double | String): this.type = set("vAlphabetic", value.asInstanceOf[js.Any])
    
    inline def vHanging(value: Double | String): this.type = set("vHanging", value.asInstanceOf[js.Any])
    
    inline def vIdeographic(value: Double | String): this.type = set("vIdeographic", value.asInstanceOf[js.Any])
    
    inline def vMathematical(value: Double | String): this.type = set("vMathematical", value.asInstanceOf[js.Any])
    
    inline def values(value: String): this.type = set("values", value.asInstanceOf[js.Any])
    
    inline def vectorEffect(value: Double | String): this.type = set("vectorEffect", value.asInstanceOf[js.Any])
    
    inline def version(value: String): this.type = set("version", value.asInstanceOf[js.Any])
    
    inline def vertAdvY(value: Double | String): this.type = set("vertAdvY", value.asInstanceOf[js.Any])
    
    inline def vertOriginX(value: Double | String): this.type = set("vertOriginX", value.asInstanceOf[js.Any])
    
    inline def vertOriginY(value: Double | String): this.type = set("vertOriginY", value.asInstanceOf[js.Any])
    
    inline def viewBox(value: String): this.type = set("viewBox", value.asInstanceOf[js.Any])
    
    inline def viewTarget(value: Double | String): this.type = set("viewTarget", value.asInstanceOf[js.Any])
    
    inline def visibility(value: Double | String): this.type = set("visibility", value.asInstanceOf[js.Any])
    
    inline def width(value: Double | String): this.type = set("width", value.asInstanceOf[js.Any])
    
    inline def widths(value: Double | String): this.type = set("widths", value.asInstanceOf[js.Any])
    
    inline def wordSpacing(value: Double | String): this.type = set("wordSpacing", value.asInstanceOf[js.Any])
    
    inline def writingMode(value: Double | String): this.type = set("writingMode", value.asInstanceOf[js.Any])
    
    inline def x(value: Double | String): this.type = set("x", value.asInstanceOf[js.Any])
    
    inline def x1(value: Double | String): this.type = set("x1", value.asInstanceOf[js.Any])
    
    inline def x2(value: Double | String): this.type = set("x2", value.asInstanceOf[js.Any])
    
    inline def xChannelSelector(value: String): this.type = set("xChannelSelector", value.asInstanceOf[js.Any])
    
    inline def xHeight(value: Double | String): this.type = set("xHeight", value.asInstanceOf[js.Any])
    
    inline def xlinkActuate(value: String): this.type = set("xlinkActuate", value.asInstanceOf[js.Any])
    
    inline def xlinkArcrole(value: String): this.type = set("xlinkArcrole", value.asInstanceOf[js.Any])
    
    inline def xlinkHref(value: String): this.type = set("xlinkHref", value.asInstanceOf[js.Any])
    
    inline def xlinkRole(value: String): this.type = set("xlinkRole", value.asInstanceOf[js.Any])
    
    inline def xlinkShow(value: String): this.type = set("xlinkShow", value.asInstanceOf[js.Any])
    
    inline def xlinkTitle(value: String): this.type = set("xlinkTitle", value.asInstanceOf[js.Any])
    
    inline def xlinkType(value: String): this.type = set("xlinkType", value.asInstanceOf[js.Any])
    
    inline def xmlBase(value: String): this.type = set("xmlBase", value.asInstanceOf[js.Any])
    
    inline def xmlLang(value: String): this.type = set("xmlLang", value.asInstanceOf[js.Any])
    
    inline def xmlSpace(value: String): this.type = set("xmlSpace", value.asInstanceOf[js.Any])
    
    inline def xmlns(value: String): this.type = set("xmlns", value.asInstanceOf[js.Any])
    
    inline def xmlnsXlink(value: String): this.type = set("xmlnsXlink", value.asInstanceOf[js.Any])
    
    inline def y(value: Double | String): this.type = set("y", value.asInstanceOf[js.Any])
    
    inline def y1(value: Double | String): this.type = set("y1", value.asInstanceOf[js.Any])
    
    inline def y2(value: Double | String): this.type = set("y2", value.asInstanceOf[js.Any])
    
    inline def yChannelSelector(value: String): this.type = set("yChannelSelector", value.asInstanceOf[js.Any])
    
    inline def z(value: Double | String): this.type = set("z", value.asInstanceOf[js.Any])
    
    inline def zoomAndPan(value: String): this.type = set("zoomAndPan", value.asInstanceOf[js.Any])
  }
  
  val component: String = "view"
  
  implicit def make(companion: view.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: SVGProps[SVGViewElement]): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}

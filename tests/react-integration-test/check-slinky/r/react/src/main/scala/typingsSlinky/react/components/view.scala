package typingsSlinky.react.components

import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.EventTarget
import org.scalajs.dom.raw.SVGViewElement
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
import typingsSlinky.react.mod.SVGProps
import typingsSlinky.react.reactStrings.`additions text`
import typingsSlinky.react.reactStrings.`after-edge`
import typingsSlinky.react.reactStrings.`before-edge`
import typingsSlinky.react.reactStrings.`inline`
import typingsSlinky.react.reactStrings.`text-after-edge`
import typingsSlinky.react.reactStrings.`text-before-edge`
import typingsSlinky.react.reactStrings.additions
import typingsSlinky.react.reactStrings.all
import typingsSlinky.react.reactStrings.alphabetic
import typingsSlinky.react.reactStrings.ascending
import typingsSlinky.react.reactStrings.assertive
import typingsSlinky.react.reactStrings.auto
import typingsSlinky.react.reactStrings.baseline
import typingsSlinky.react.reactStrings.bevel
import typingsSlinky.react.reactStrings.both
import typingsSlinky.react.reactStrings.butt
import typingsSlinky.react.reactStrings.central
import typingsSlinky.react.reactStrings.copy
import typingsSlinky.react.reactStrings.date
import typingsSlinky.react.reactStrings.descending
import typingsSlinky.react.reactStrings.dialog
import typingsSlinky.react.reactStrings.evenodd
import typingsSlinky.react.reactStrings.execute
import typingsSlinky.react.reactStrings.grammar
import typingsSlinky.react.reactStrings.grid
import typingsSlinky.react.reactStrings.hanging
import typingsSlinky.react.reactStrings.horizontal
import typingsSlinky.react.reactStrings.ideographic
import typingsSlinky.react.reactStrings.inherit
import typingsSlinky.react.reactStrings.initial
import typingsSlinky.react.reactStrings.isolated
import typingsSlinky.react.reactStrings.linearRGB
import typingsSlinky.react.reactStrings.link
import typingsSlinky.react.reactStrings.list
import typingsSlinky.react.reactStrings.listbox
import typingsSlinky.react.reactStrings.location
import typingsSlinky.react.reactStrings.mathematical
import typingsSlinky.react.reactStrings.medial
import typingsSlinky.react.reactStrings.menu
import typingsSlinky.react.reactStrings.middle
import typingsSlinky.react.reactStrings.miter
import typingsSlinky.react.reactStrings.mixed
import typingsSlinky.react.reactStrings.move
import typingsSlinky.react.reactStrings.no
import typingsSlinky.react.reactStrings.none
import typingsSlinky.react.reactStrings.nonzero
import typingsSlinky.react.reactStrings.off
import typingsSlinky.react.reactStrings.other
import typingsSlinky.react.reactStrings.page
import typingsSlinky.react.reactStrings.polite
import typingsSlinky.react.reactStrings.popup
import typingsSlinky.react.reactStrings.removals
import typingsSlinky.react.reactStrings.replace
import typingsSlinky.react.reactStrings.round
import typingsSlinky.react.reactStrings.sRGB
import typingsSlinky.react.reactStrings.spelling
import typingsSlinky.react.reactStrings.square
import typingsSlinky.react.reactStrings.step
import typingsSlinky.react.reactStrings.sum
import typingsSlinky.react.reactStrings.terminal
import typingsSlinky.react.reactStrings.text
import typingsSlinky.react.reactStrings.time
import typingsSlinky.react.reactStrings.tree
import typingsSlinky.react.reactStrings.vertical
import typingsSlinky.react.reactStrings.yes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object view {
  
  val component: String = "view"
  
  implicit def make(companion: view.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: SVGProps[SVGViewElement]): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, SVGViewElement with js.Object] {
    
    @scala.inline
    def accentHeight(value: Double | String): this.type = set("accentHeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def accumulate(value: none | sum): this.type = set("accumulate", value.asInstanceOf[js.Any])
    
    @scala.inline
    def additive(value: replace | sum): this.type = set("additive", value.asInstanceOf[js.Any])
    
    @scala.inline
    def alignmentBaseline(
      value: auto | baseline | `before-edge` | `text-before-edge` | middle | central | `after-edge` | `text-after-edge` | ideographic | alphabetic | hanging | mathematical | inherit
    ): this.type = set("alignmentBaseline", value.asInstanceOf[js.Any])
    
    @scala.inline
    def allowReorder(value: no | yes): this.type = set("allowReorder", value.asInstanceOf[js.Any])
    
    @scala.inline
    def alphabetic(value: Double | String): this.type = set("alphabetic", value.asInstanceOf[js.Any])
    
    @scala.inline
    def amplitude(value: Double | String): this.type = set("amplitude", value.asInstanceOf[js.Any])
    
    @scala.inline
    def arabicForm(value: initial | medial | terminal | isolated): this.type = set("arabicForm", value.asInstanceOf[js.Any])
    
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
    def ascent(value: Double | String): this.type = set("ascent", value.asInstanceOf[js.Any])
    
    @scala.inline
    def attributeName(value: String): this.type = set("attributeName", value.asInstanceOf[js.Any])
    
    @scala.inline
    def attributeType(value: String): this.type = set("attributeType", value.asInstanceOf[js.Any])
    
    @scala.inline
    def autoReverse(value: Double | String): this.type = set("autoReverse", value.asInstanceOf[js.Any])
    
    @scala.inline
    def azimuth(value: Double | String): this.type = set("azimuth", value.asInstanceOf[js.Any])
    
    @scala.inline
    def baseFrequency(value: Double | String): this.type = set("baseFrequency", value.asInstanceOf[js.Any])
    
    @scala.inline
    def baseProfile(value: Double | String): this.type = set("baseProfile", value.asInstanceOf[js.Any])
    
    @scala.inline
    def baselineShift(value: Double | String): this.type = set("baselineShift", value.asInstanceOf[js.Any])
    
    @scala.inline
    def bbox(value: Double | String): this.type = set("bbox", value.asInstanceOf[js.Any])
    
    @scala.inline
    def begin(value: Double | String): this.type = set("begin", value.asInstanceOf[js.Any])
    
    @scala.inline
    def bias(value: Double | String): this.type = set("bias", value.asInstanceOf[js.Any])
    
    @scala.inline
    def by(value: Double | String): this.type = set("by", value.asInstanceOf[js.Any])
    
    @scala.inline
    def calcMode(value: Double | String): this.type = set("calcMode", value.asInstanceOf[js.Any])
    
    @scala.inline
    def capHeight(value: Double | String): this.type = set("capHeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    @scala.inline
    def clip(value: Double | String): this.type = set("clip", value.asInstanceOf[js.Any])
    
    @scala.inline
    def clipPath(value: String): this.type = set("clipPath", value.asInstanceOf[js.Any])
    
    @scala.inline
    def clipPathUnits(value: Double | String): this.type = set("clipPathUnits", value.asInstanceOf[js.Any])
    
    @scala.inline
    def clipRule(value: Double | String): this.type = set("clipRule", value.asInstanceOf[js.Any])
    
    @scala.inline
    def color(value: String): this.type = set("color", value.asInstanceOf[js.Any])
    
    @scala.inline
    def colorInterpolation(value: Double | String): this.type = set("colorInterpolation", value.asInstanceOf[js.Any])
    
    @scala.inline
    def colorInterpolationFilters(value: auto | sRGB | linearRGB | inherit): this.type = set("colorInterpolationFilters", value.asInstanceOf[js.Any])
    
    @scala.inline
    def colorProfile(value: Double | String): this.type = set("colorProfile", value.asInstanceOf[js.Any])
    
    @scala.inline
    def colorRendering(value: Double | String): this.type = set("colorRendering", value.asInstanceOf[js.Any])
    
    @scala.inline
    def contentScriptType(value: Double | String): this.type = set("contentScriptType", value.asInstanceOf[js.Any])
    
    @scala.inline
    def contentStyleType(value: Double | String): this.type = set("contentStyleType", value.asInstanceOf[js.Any])
    
    @scala.inline
    def cursor(value: Double | String): this.type = set("cursor", value.asInstanceOf[js.Any])
    
    @scala.inline
    def cx(value: Double | String): this.type = set("cx", value.asInstanceOf[js.Any])
    
    @scala.inline
    def cy(value: Double | String): this.type = set("cy", value.asInstanceOf[js.Any])
    
    @scala.inline
    def d(value: String): this.type = set("d", value.asInstanceOf[js.Any])
    
    @scala.inline
    def dangerouslySetInnerHTML(value: Html): this.type = set("dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
    
    @scala.inline
    def decelerate(value: Double | String): this.type = set("decelerate", value.asInstanceOf[js.Any])
    
    @scala.inline
    def descent(value: Double | String): this.type = set("descent", value.asInstanceOf[js.Any])
    
    @scala.inline
    def diffuseConstant(value: Double | String): this.type = set("diffuseConstant", value.asInstanceOf[js.Any])
    
    @scala.inline
    def direction(value: Double | String): this.type = set("direction", value.asInstanceOf[js.Any])
    
    @scala.inline
    def display(value: Double | String): this.type = set("display", value.asInstanceOf[js.Any])
    
    @scala.inline
    def divisor(value: Double | String): this.type = set("divisor", value.asInstanceOf[js.Any])
    
    @scala.inline
    def dominantBaseline(value: Double | String): this.type = set("dominantBaseline", value.asInstanceOf[js.Any])
    
    @scala.inline
    def dur(value: Double | String): this.type = set("dur", value.asInstanceOf[js.Any])
    
    @scala.inline
    def dx(value: Double | String): this.type = set("dx", value.asInstanceOf[js.Any])
    
    @scala.inline
    def dy(value: Double | String): this.type = set("dy", value.asInstanceOf[js.Any])
    
    @scala.inline
    def edgeMode(value: Double | String): this.type = set("edgeMode", value.asInstanceOf[js.Any])
    
    @scala.inline
    def elevation(value: Double | String): this.type = set("elevation", value.asInstanceOf[js.Any])
    
    @scala.inline
    def enableBackground(value: Double | String): this.type = set("enableBackground", value.asInstanceOf[js.Any])
    
    @scala.inline
    def end(value: Double | String): this.type = set("end", value.asInstanceOf[js.Any])
    
    @scala.inline
    def exponent(value: Double | String): this.type = set("exponent", value.asInstanceOf[js.Any])
    
    @scala.inline
    def externalResourcesRequired(value: Double | String): this.type = set("externalResourcesRequired", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fill(value: String): this.type = set("fill", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fillOpacity(value: Double | String): this.type = set("fillOpacity", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fillRule(value: nonzero | evenodd | inherit): this.type = set("fillRule", value.asInstanceOf[js.Any])
    
    @scala.inline
    def filter(value: String): this.type = set("filter", value.asInstanceOf[js.Any])
    
    @scala.inline
    def filterRes(value: Double | String): this.type = set("filterRes", value.asInstanceOf[js.Any])
    
    @scala.inline
    def filterUnits(value: Double | String): this.type = set("filterUnits", value.asInstanceOf[js.Any])
    
    @scala.inline
    def floodColor(value: Double | String): this.type = set("floodColor", value.asInstanceOf[js.Any])
    
    @scala.inline
    def floodOpacity(value: Double | String): this.type = set("floodOpacity", value.asInstanceOf[js.Any])
    
    @scala.inline
    def focusable(value: Double | String): this.type = set("focusable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fontFamily(value: String): this.type = set("fontFamily", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fontSize(value: Double | String): this.type = set("fontSize", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fontSizeAdjust(value: Double | String): this.type = set("fontSizeAdjust", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fontStretch(value: Double | String): this.type = set("fontStretch", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fontStyle(value: Double | String): this.type = set("fontStyle", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fontVariant(value: Double | String): this.type = set("fontVariant", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fontWeight(value: Double | String): this.type = set("fontWeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def format(value: Double | String): this.type = set("format", value.asInstanceOf[js.Any])
    
    @scala.inline
    def from(value: Double | String): this.type = set("from", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fx(value: Double | String): this.type = set("fx", value.asInstanceOf[js.Any])
    
    @scala.inline
    def fy(value: Double | String): this.type = set("fy", value.asInstanceOf[js.Any])
    
    @scala.inline
    def g1(value: Double | String): this.type = set("g1", value.asInstanceOf[js.Any])
    
    @scala.inline
    def g2(value: Double | String): this.type = set("g2", value.asInstanceOf[js.Any])
    
    @scala.inline
    def glyphName(value: Double | String): this.type = set("glyphName", value.asInstanceOf[js.Any])
    
    @scala.inline
    def glyphOrientationHorizontal(value: Double | String): this.type = set("glyphOrientationHorizontal", value.asInstanceOf[js.Any])
    
    @scala.inline
    def glyphOrientationVertical(value: Double | String): this.type = set("glyphOrientationVertical", value.asInstanceOf[js.Any])
    
    @scala.inline
    def glyphRef(value: Double | String): this.type = set("glyphRef", value.asInstanceOf[js.Any])
    
    @scala.inline
    def gradientTransform(value: String): this.type = set("gradientTransform", value.asInstanceOf[js.Any])
    
    @scala.inline
    def gradientUnits(value: String): this.type = set("gradientUnits", value.asInstanceOf[js.Any])
    
    @scala.inline
    def hanging(value: Double | String): this.type = set("hanging", value.asInstanceOf[js.Any])
    
    @scala.inline
    def height(value: Double | String): this.type = set("height", value.asInstanceOf[js.Any])
    
    @scala.inline
    def horizAdvX(value: Double | String): this.type = set("horizAdvX", value.asInstanceOf[js.Any])
    
    @scala.inline
    def horizOriginX(value: Double | String): this.type = set("horizOriginX", value.asInstanceOf[js.Any])
    
    @scala.inline
    def href(value: String): this.type = set("href", value.asInstanceOf[js.Any])
    
    @scala.inline
    def id(value: String): this.type = set("id", value.asInstanceOf[js.Any])
    
    @scala.inline
    def ideographic(value: Double | String): this.type = set("ideographic", value.asInstanceOf[js.Any])
    
    @scala.inline
    def imageRendering(value: Double | String): this.type = set("imageRendering", value.asInstanceOf[js.Any])
    
    @scala.inline
    def in(value: String): this.type = set("in", value.asInstanceOf[js.Any])
    
    @scala.inline
    def in2(value: Double | String): this.type = set("in2", value.asInstanceOf[js.Any])
    
    @scala.inline
    def intercept(value: Double | String): this.type = set("intercept", value.asInstanceOf[js.Any])
    
    @scala.inline
    def k(value: Double | String): this.type = set("k", value.asInstanceOf[js.Any])
    
    @scala.inline
    def k1(value: Double | String): this.type = set("k1", value.asInstanceOf[js.Any])
    
    @scala.inline
    def k2(value: Double | String): this.type = set("k2", value.asInstanceOf[js.Any])
    
    @scala.inline
    def k3(value: Double | String): this.type = set("k3", value.asInstanceOf[js.Any])
    
    @scala.inline
    def k4(value: Double | String): this.type = set("k4", value.asInstanceOf[js.Any])
    
    @scala.inline
    def kernelMatrix(value: Double | String): this.type = set("kernelMatrix", value.asInstanceOf[js.Any])
    
    @scala.inline
    def kernelUnitLength(value: Double | String): this.type = set("kernelUnitLength", value.asInstanceOf[js.Any])
    
    @scala.inline
    def kerning(value: Double | String): this.type = set("kerning", value.asInstanceOf[js.Any])
    
    @scala.inline
    def keyPoints(value: Double | String): this.type = set("keyPoints", value.asInstanceOf[js.Any])
    
    @scala.inline
    def keySplines(value: Double | String): this.type = set("keySplines", value.asInstanceOf[js.Any])
    
    @scala.inline
    def keyTimes(value: Double | String): this.type = set("keyTimes", value.asInstanceOf[js.Any])
    
    @scala.inline
    def lang(value: String): this.type = set("lang", value.asInstanceOf[js.Any])
    
    @scala.inline
    def lengthAdjust(value: Double | String): this.type = set("lengthAdjust", value.asInstanceOf[js.Any])
    
    @scala.inline
    def letterSpacing(value: Double | String): this.type = set("letterSpacing", value.asInstanceOf[js.Any])
    
    @scala.inline
    def lightingColor(value: Double | String): this.type = set("lightingColor", value.asInstanceOf[js.Any])
    
    @scala.inline
    def limitingConeAngle(value: Double | String): this.type = set("limitingConeAngle", value.asInstanceOf[js.Any])
    
    @scala.inline
    def local(value: Double | String): this.type = set("local", value.asInstanceOf[js.Any])
    
    @scala.inline
    def markerEnd(value: String): this.type = set("markerEnd", value.asInstanceOf[js.Any])
    
    @scala.inline
    def markerHeight(value: Double | String): this.type = set("markerHeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def markerMid(value: String): this.type = set("markerMid", value.asInstanceOf[js.Any])
    
    @scala.inline
    def markerStart(value: String): this.type = set("markerStart", value.asInstanceOf[js.Any])
    
    @scala.inline
    def markerUnits(value: Double | String): this.type = set("markerUnits", value.asInstanceOf[js.Any])
    
    @scala.inline
    def markerWidth(value: Double | String): this.type = set("markerWidth", value.asInstanceOf[js.Any])
    
    @scala.inline
    def mask(value: String): this.type = set("mask", value.asInstanceOf[js.Any])
    
    @scala.inline
    def maskContentUnits(value: Double | String): this.type = set("maskContentUnits", value.asInstanceOf[js.Any])
    
    @scala.inline
    def maskUnits(value: Double | String): this.type = set("maskUnits", value.asInstanceOf[js.Any])
    
    @scala.inline
    def mathematical(value: Double | String): this.type = set("mathematical", value.asInstanceOf[js.Any])
    
    @scala.inline
    def max(value: Double | String): this.type = set("max", value.asInstanceOf[js.Any])
    
    @scala.inline
    def media(value: String): this.type = set("media", value.asInstanceOf[js.Any])
    
    @scala.inline
    def method(value: String): this.type = set("method", value.asInstanceOf[js.Any])
    
    @scala.inline
    def min(value: Double | String): this.type = set("min", value.asInstanceOf[js.Any])
    
    @scala.inline
    def mode(value: Double | String): this.type = set("mode", value.asInstanceOf[js.Any])
    
    @scala.inline
    def name(value: String): this.type = set("name", value.asInstanceOf[js.Any])
    
    @scala.inline
    def numOctaves(value: Double | String): this.type = set("numOctaves", value.asInstanceOf[js.Any])
    
    @scala.inline
    def offset(value: Double | String): this.type = set("offset", value.asInstanceOf[js.Any])
    
    @scala.inline
    def onAbort(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onAbort", js.Any.fromFunction1(value))
    
    @scala.inline
    def onAnimationEnd(value: SyntheticAnimationEvent[SVGViewElement] => Unit): this.type = set("onAnimationEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onAnimationIteration(value: SyntheticAnimationEvent[SVGViewElement] => Unit): this.type = set("onAnimationIteration", js.Any.fromFunction1(value))
    
    @scala.inline
    def onAnimationStart(value: SyntheticAnimationEvent[SVGViewElement] => Unit): this.type = set("onAnimationStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onAuxClick(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onAuxClick", js.Any.fromFunction1(value))
    
    @scala.inline
    def onBeforeInput(value: SyntheticEvent[EventTarget with SVGViewElement, Event] => Unit): this.type = set("onBeforeInput", js.Any.fromFunction1(value))
    
    @scala.inline
    def onBlur(value: SyntheticFocusEvent[SVGViewElement] => Unit): this.type = set("onBlur", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCanPlay(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onCanPlay", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCanPlayThrough(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onCanPlayThrough", js.Any.fromFunction1(value))
    
    @scala.inline
    def onChange(value: SyntheticEvent[EventTarget with SVGViewElement, Event] => Unit): this.type = set("onChange", js.Any.fromFunction1(value))
    
    @scala.inline
    def onClick(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onClick", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCompositionEnd(value: SyntheticCompositionEvent[SVGViewElement] => Unit): this.type = set("onCompositionEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCompositionStart(value: SyntheticCompositionEvent[SVGViewElement] => Unit): this.type = set("onCompositionStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCompositionUpdate(value: SyntheticCompositionEvent[SVGViewElement] => Unit): this.type = set("onCompositionUpdate", js.Any.fromFunction1(value))
    
    @scala.inline
    def onContextMenu(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onContextMenu", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCopy(value: SyntheticClipboardEvent[SVGViewElement] => Unit): this.type = set("onCopy", js.Any.fromFunction1(value))
    
    @scala.inline
    def onCut(value: SyntheticClipboardEvent[SVGViewElement] => Unit): this.type = set("onCut", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDoubleClick(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onDoubleClick", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDrag(value: DragEvent[SVGViewElement] => Unit): this.type = set("onDrag", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragEnd(value: DragEvent[SVGViewElement] => Unit): this.type = set("onDragEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragEnter(value: DragEvent[SVGViewElement] => Unit): this.type = set("onDragEnter", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragExit(value: DragEvent[SVGViewElement] => Unit): this.type = set("onDragExit", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragLeave(value: DragEvent[SVGViewElement] => Unit): this.type = set("onDragLeave", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragOver(value: DragEvent[SVGViewElement] => Unit): this.type = set("onDragOver", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDragStart(value: DragEvent[SVGViewElement] => Unit): this.type = set("onDragStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDrop(value: DragEvent[SVGViewElement] => Unit): this.type = set("onDrop", js.Any.fromFunction1(value))
    
    @scala.inline
    def onDurationChange(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onDurationChange", js.Any.fromFunction1(value))
    
    @scala.inline
    def onEmptied(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onEmptied", js.Any.fromFunction1(value))
    
    @scala.inline
    def onEncrypted(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onEncrypted", js.Any.fromFunction1(value))
    
    @scala.inline
    def onEnded(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onEnded", js.Any.fromFunction1(value))
    
    @scala.inline
    def onError(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onError", js.Any.fromFunction1(value))
    
    @scala.inline
    def onFocus(value: SyntheticFocusEvent[SVGViewElement] => Unit): this.type = set("onFocus", js.Any.fromFunction1(value))
    
    @scala.inline
    def onInput(value: SyntheticEvent[EventTarget with SVGViewElement, Event] => Unit): this.type = set("onInput", js.Any.fromFunction1(value))
    
    @scala.inline
    def onInvalid(value: SyntheticEvent[EventTarget with SVGViewElement, Event] => Unit): this.type = set("onInvalid", js.Any.fromFunction1(value))
    
    @scala.inline
    def onKeyDown(value: SyntheticKeyboardEvent[SVGViewElement] => Unit): this.type = set("onKeyDown", js.Any.fromFunction1(value))
    
    @scala.inline
    def onKeyPress(value: SyntheticKeyboardEvent[SVGViewElement] => Unit): this.type = set("onKeyPress", js.Any.fromFunction1(value))
    
    @scala.inline
    def onKeyUp(value: SyntheticKeyboardEvent[SVGViewElement] => Unit): this.type = set("onKeyUp", js.Any.fromFunction1(value))
    
    @scala.inline
    def onLoad(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onLoad", js.Any.fromFunction1(value))
    
    @scala.inline
    def onLoadStart(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onLoadStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onLoadedData(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onLoadedData", js.Any.fromFunction1(value))
    
    @scala.inline
    def onLoadedMetadata(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onLoadedMetadata", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseDown(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onMouseDown", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseEnter(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onMouseEnter", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseLeave(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onMouseLeave", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseMove(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onMouseMove", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseOut(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onMouseOut", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseOver(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onMouseOver", js.Any.fromFunction1(value))
    
    @scala.inline
    def onMouseUp(value: SyntheticMouseEvent[SVGViewElement] => Unit): this.type = set("onMouseUp", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPaste(value: SyntheticClipboardEvent[SVGViewElement] => Unit): this.type = set("onPaste", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPause(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onPause", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPlay(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onPlay", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPlaying(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onPlaying", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerCancel(value: SyntheticPointerEvent[SVGViewElement] => Unit): this.type = set("onPointerCancel", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerDown(value: SyntheticPointerEvent[SVGViewElement] => Unit): this.type = set("onPointerDown", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerEnter(value: SyntheticPointerEvent[SVGViewElement] => Unit): this.type = set("onPointerEnter", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerLeave(value: SyntheticPointerEvent[SVGViewElement] => Unit): this.type = set("onPointerLeave", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerMove(value: SyntheticPointerEvent[SVGViewElement] => Unit): this.type = set("onPointerMove", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerOut(value: SyntheticPointerEvent[SVGViewElement] => Unit): this.type = set("onPointerOut", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerOver(value: SyntheticPointerEvent[SVGViewElement] => Unit): this.type = set("onPointerOver", js.Any.fromFunction1(value))
    
    @scala.inline
    def onPointerUp(value: SyntheticPointerEvent[SVGViewElement] => Unit): this.type = set("onPointerUp", js.Any.fromFunction1(value))
    
    @scala.inline
    def onProgress(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onProgress", js.Any.fromFunction1(value))
    
    @scala.inline
    def onRateChange(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onRateChange", js.Any.fromFunction1(value))
    
    @scala.inline
    def onReset(value: SyntheticEvent[EventTarget with SVGViewElement, Event] => Unit): this.type = set("onReset", js.Any.fromFunction1(value))
    
    @scala.inline
    def onScroll(value: SyntheticUIEvent[SVGViewElement] => Unit): this.type = set("onScroll", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSeeked(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onSeeked", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSeeking(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onSeeking", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSelect(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onSelect", js.Any.fromFunction1(value))
    
    @scala.inline
    def onStalled(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onStalled", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSubmit(value: SyntheticEvent[EventTarget with SVGViewElement, Event] => Unit): this.type = set("onSubmit", js.Any.fromFunction1(value))
    
    @scala.inline
    def onSuspend(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onSuspend", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTimeUpdate(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onTimeUpdate", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTouchCancel(value: SyntheticTouchEvent[SVGViewElement] => Unit): this.type = set("onTouchCancel", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTouchEnd(value: SyntheticTouchEvent[SVGViewElement] => Unit): this.type = set("onTouchEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTouchMove(value: SyntheticTouchEvent[SVGViewElement] => Unit): this.type = set("onTouchMove", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTouchStart(value: SyntheticTouchEvent[SVGViewElement] => Unit): this.type = set("onTouchStart", js.Any.fromFunction1(value))
    
    @scala.inline
    def onTransitionEnd(value: SyntheticTransitionEvent[SVGViewElement] => Unit): this.type = set("onTransitionEnd", js.Any.fromFunction1(value))
    
    @scala.inline
    def onVolumeChange(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onVolumeChange", js.Any.fromFunction1(value))
    
    @scala.inline
    def onWaiting(value: SyntheticEvent[Event, SVGViewElement] => Unit): this.type = set("onWaiting", js.Any.fromFunction1(value))
    
    @scala.inline
    def onWheel(value: SyntheticWheelEvent[SVGViewElement] => Unit): this.type = set("onWheel", js.Any.fromFunction1(value))
    
    @scala.inline
    def opacity(value: Double | String): this.type = set("opacity", value.asInstanceOf[js.Any])
    
    @scala.inline
    def operator(value: Double | String): this.type = set("operator", value.asInstanceOf[js.Any])
    
    @scala.inline
    def order(value: Double | String): this.type = set("order", value.asInstanceOf[js.Any])
    
    @scala.inline
    def orient(value: Double | String): this.type = set("orient", value.asInstanceOf[js.Any])
    
    @scala.inline
    def orientation(value: Double | String): this.type = set("orientation", value.asInstanceOf[js.Any])
    
    @scala.inline
    def origin(value: Double | String): this.type = set("origin", value.asInstanceOf[js.Any])
    
    @scala.inline
    def overflow(value: Double | String): this.type = set("overflow", value.asInstanceOf[js.Any])
    
    @scala.inline
    def overlinePosition(value: Double | String): this.type = set("overlinePosition", value.asInstanceOf[js.Any])
    
    @scala.inline
    def overlineThickness(value: Double | String): this.type = set("overlineThickness", value.asInstanceOf[js.Any])
    
    @scala.inline
    def paintOrder(value: Double | String): this.type = set("paintOrder", value.asInstanceOf[js.Any])
    
    @scala.inline
    def panose1(value: Double | String): this.type = set("panose1", value.asInstanceOf[js.Any])
    
    @scala.inline
    def pathLength(value: Double | String): this.type = set("pathLength", value.asInstanceOf[js.Any])
    
    @scala.inline
    def patternContentUnits(value: String): this.type = set("patternContentUnits", value.asInstanceOf[js.Any])
    
    @scala.inline
    def patternTransform(value: Double | String): this.type = set("patternTransform", value.asInstanceOf[js.Any])
    
    @scala.inline
    def patternUnits(value: String): this.type = set("patternUnits", value.asInstanceOf[js.Any])
    
    @scala.inline
    def pointerEvents(value: Double | String): this.type = set("pointerEvents", value.asInstanceOf[js.Any])
    
    @scala.inline
    def points(value: String): this.type = set("points", value.asInstanceOf[js.Any])
    
    @scala.inline
    def pointsAtX(value: Double | String): this.type = set("pointsAtX", value.asInstanceOf[js.Any])
    
    @scala.inline
    def pointsAtY(value: Double | String): this.type = set("pointsAtY", value.asInstanceOf[js.Any])
    
    @scala.inline
    def pointsAtZ(value: Double | String): this.type = set("pointsAtZ", value.asInstanceOf[js.Any])
    
    @scala.inline
    def preserveAlpha(value: Double | String): this.type = set("preserveAlpha", value.asInstanceOf[js.Any])
    
    @scala.inline
    def preserveAspectRatio(value: String): this.type = set("preserveAspectRatio", value.asInstanceOf[js.Any])
    
    @scala.inline
    def primitiveUnits(value: Double | String): this.type = set("primitiveUnits", value.asInstanceOf[js.Any])
    
    @scala.inline
    def r(value: Double | String): this.type = set("r", value.asInstanceOf[js.Any])
    
    @scala.inline
    def radius(value: Double | String): this.type = set("radius", value.asInstanceOf[js.Any])
    
    @scala.inline
    def refX(value: Double | String): this.type = set("refX", value.asInstanceOf[js.Any])
    
    @scala.inline
    def refY(value: Double | String): this.type = set("refY", value.asInstanceOf[js.Any])
    
    @scala.inline
    def renderingIntent(value: Double | String): this.type = set("renderingIntent", value.asInstanceOf[js.Any])
    
    @scala.inline
    def repeatCount(value: Double | String): this.type = set("repeatCount", value.asInstanceOf[js.Any])
    
    @scala.inline
    def repeatDur(value: Double | String): this.type = set("repeatDur", value.asInstanceOf[js.Any])
    
    @scala.inline
    def requiredExtensions(value: Double | String): this.type = set("requiredExtensions", value.asInstanceOf[js.Any])
    
    @scala.inline
    def requiredFeatures(value: Double | String): this.type = set("requiredFeatures", value.asInstanceOf[js.Any])
    
    @scala.inline
    def restart(value: Double | String): this.type = set("restart", value.asInstanceOf[js.Any])
    
    @scala.inline
    def result(value: String): this.type = set("result", value.asInstanceOf[js.Any])
    
    @scala.inline
    def role(value: String): this.type = set("role", value.asInstanceOf[js.Any])
    
    @scala.inline
    def rotate(value: Double | String): this.type = set("rotate", value.asInstanceOf[js.Any])
    
    @scala.inline
    def rx(value: Double | String): this.type = set("rx", value.asInstanceOf[js.Any])
    
    @scala.inline
    def ry(value: Double | String): this.type = set("ry", value.asInstanceOf[js.Any])
    
    @scala.inline
    def scale(value: Double | String): this.type = set("scale", value.asInstanceOf[js.Any])
    
    @scala.inline
    def seed(value: Double | String): this.type = set("seed", value.asInstanceOf[js.Any])
    
    @scala.inline
    def shapeRendering(value: Double | String): this.type = set("shapeRendering", value.asInstanceOf[js.Any])
    
    @scala.inline
    def slope(value: Double | String): this.type = set("slope", value.asInstanceOf[js.Any])
    
    @scala.inline
    def spacing(value: Double | String): this.type = set("spacing", value.asInstanceOf[js.Any])
    
    @scala.inline
    def specularConstant(value: Double | String): this.type = set("specularConstant", value.asInstanceOf[js.Any])
    
    @scala.inline
    def specularExponent(value: Double | String): this.type = set("specularExponent", value.asInstanceOf[js.Any])
    
    @scala.inline
    def speed(value: Double | String): this.type = set("speed", value.asInstanceOf[js.Any])
    
    @scala.inline
    def spreadMethod(value: String): this.type = set("spreadMethod", value.asInstanceOf[js.Any])
    
    @scala.inline
    def startOffset(value: Double | String): this.type = set("startOffset", value.asInstanceOf[js.Any])
    
    @scala.inline
    def stdDeviation(value: Double | String): this.type = set("stdDeviation", value.asInstanceOf[js.Any])
    
    @scala.inline
    def stemh(value: Double | String): this.type = set("stemh", value.asInstanceOf[js.Any])
    
    @scala.inline
    def stemv(value: Double | String): this.type = set("stemv", value.asInstanceOf[js.Any])
    
    @scala.inline
    def stitchTiles(value: Double | String): this.type = set("stitchTiles", value.asInstanceOf[js.Any])
    
    @scala.inline
    def stopColor(value: String): this.type = set("stopColor", value.asInstanceOf[js.Any])
    
    @scala.inline
    def stopOpacity(value: Double | String): this.type = set("stopOpacity", value.asInstanceOf[js.Any])
    
    @scala.inline
    def strikethroughPosition(value: Double | String): this.type = set("strikethroughPosition", value.asInstanceOf[js.Any])
    
    @scala.inline
    def strikethroughThickness(value: Double | String): this.type = set("strikethroughThickness", value.asInstanceOf[js.Any])
    
    @scala.inline
    def string(value: Double | String): this.type = set("string", value.asInstanceOf[js.Any])
    
    @scala.inline
    def stroke(value: String): this.type = set("stroke", value.asInstanceOf[js.Any])
    
    @scala.inline
    def strokeDasharray(value: String | Double): this.type = set("strokeDasharray", value.asInstanceOf[js.Any])
    
    @scala.inline
    def strokeDashoffset(value: String | Double): this.type = set("strokeDashoffset", value.asInstanceOf[js.Any])
    
    @scala.inline
    def strokeLinecap(value: butt | round | square | inherit): this.type = set("strokeLinecap", value.asInstanceOf[js.Any])
    
    @scala.inline
    def strokeLinejoin(value: miter | round | bevel | inherit): this.type = set("strokeLinejoin", value.asInstanceOf[js.Any])
    
    @scala.inline
    def strokeMiterlimit(value: Double | String): this.type = set("strokeMiterlimit", value.asInstanceOf[js.Any])
    
    @scala.inline
    def strokeOpacity(value: Double | String): this.type = set("strokeOpacity", value.asInstanceOf[js.Any])
    
    @scala.inline
    def strokeWidth(value: Double | String): this.type = set("strokeWidth", value.asInstanceOf[js.Any])
    
    @scala.inline
    def style(value: CSSProperties): this.type = set("style", value.asInstanceOf[js.Any])
    
    @scala.inline
    def surfaceScale(value: Double | String): this.type = set("surfaceScale", value.asInstanceOf[js.Any])
    
    @scala.inline
    def systemLanguage(value: Double | String): this.type = set("systemLanguage", value.asInstanceOf[js.Any])
    
    @scala.inline
    def tabIndex(value: Double): this.type = set("tabIndex", value.asInstanceOf[js.Any])
    
    @scala.inline
    def tableValues(value: Double | String): this.type = set("tableValues", value.asInstanceOf[js.Any])
    
    @scala.inline
    def target(value: String): this.type = set("target", value.asInstanceOf[js.Any])
    
    @scala.inline
    def targetX(value: Double | String): this.type = set("targetX", value.asInstanceOf[js.Any])
    
    @scala.inline
    def targetY(value: Double | String): this.type = set("targetY", value.asInstanceOf[js.Any])
    
    @scala.inline
    def textAnchor(value: String): this.type = set("textAnchor", value.asInstanceOf[js.Any])
    
    @scala.inline
    def textDecoration(value: Double | String): this.type = set("textDecoration", value.asInstanceOf[js.Any])
    
    @scala.inline
    def textLength(value: Double | String): this.type = set("textLength", value.asInstanceOf[js.Any])
    
    @scala.inline
    def textRendering(value: Double | String): this.type = set("textRendering", value.asInstanceOf[js.Any])
    
    @scala.inline
    def to(value: Double | String): this.type = set("to", value.asInstanceOf[js.Any])
    
    @scala.inline
    def transform(value: String): this.type = set("transform", value.asInstanceOf[js.Any])
    
    @scala.inline
    def `type`(value: String): this.type = set("type", value.asInstanceOf[js.Any])
    
    @scala.inline
    def u1(value: Double | String): this.type = set("u1", value.asInstanceOf[js.Any])
    
    @scala.inline
    def u2(value: Double | String): this.type = set("u2", value.asInstanceOf[js.Any])
    
    @scala.inline
    def underlinePosition(value: Double | String): this.type = set("underlinePosition", value.asInstanceOf[js.Any])
    
    @scala.inline
    def underlineThickness(value: Double | String): this.type = set("underlineThickness", value.asInstanceOf[js.Any])
    
    @scala.inline
    def unicode(value: Double | String): this.type = set("unicode", value.asInstanceOf[js.Any])
    
    @scala.inline
    def unicodeBidi(value: Double | String): this.type = set("unicodeBidi", value.asInstanceOf[js.Any])
    
    @scala.inline
    def unicodeRange(value: Double | String): this.type = set("unicodeRange", value.asInstanceOf[js.Any])
    
    @scala.inline
    def unitsPerEm(value: Double | String): this.type = set("unitsPerEm", value.asInstanceOf[js.Any])
    
    @scala.inline
    def vAlphabetic(value: Double | String): this.type = set("vAlphabetic", value.asInstanceOf[js.Any])
    
    @scala.inline
    def vHanging(value: Double | String): this.type = set("vHanging", value.asInstanceOf[js.Any])
    
    @scala.inline
    def vIdeographic(value: Double | String): this.type = set("vIdeographic", value.asInstanceOf[js.Any])
    
    @scala.inline
    def vMathematical(value: Double | String): this.type = set("vMathematical", value.asInstanceOf[js.Any])
    
    @scala.inline
    def values(value: String): this.type = set("values", value.asInstanceOf[js.Any])
    
    @scala.inline
    def vectorEffect(value: Double | String): this.type = set("vectorEffect", value.asInstanceOf[js.Any])
    
    @scala.inline
    def version(value: String): this.type = set("version", value.asInstanceOf[js.Any])
    
    @scala.inline
    def vertAdvY(value: Double | String): this.type = set("vertAdvY", value.asInstanceOf[js.Any])
    
    @scala.inline
    def vertOriginX(value: Double | String): this.type = set("vertOriginX", value.asInstanceOf[js.Any])
    
    @scala.inline
    def vertOriginY(value: Double | String): this.type = set("vertOriginY", value.asInstanceOf[js.Any])
    
    @scala.inline
    def viewBox(value: String): this.type = set("viewBox", value.asInstanceOf[js.Any])
    
    @scala.inline
    def viewTarget(value: Double | String): this.type = set("viewTarget", value.asInstanceOf[js.Any])
    
    @scala.inline
    def visibility(value: Double | String): this.type = set("visibility", value.asInstanceOf[js.Any])
    
    @scala.inline
    def width(value: Double | String): this.type = set("width", value.asInstanceOf[js.Any])
    
    @scala.inline
    def widths(value: Double | String): this.type = set("widths", value.asInstanceOf[js.Any])
    
    @scala.inline
    def wordSpacing(value: Double | String): this.type = set("wordSpacing", value.asInstanceOf[js.Any])
    
    @scala.inline
    def writingMode(value: Double | String): this.type = set("writingMode", value.asInstanceOf[js.Any])
    
    @scala.inline
    def x(value: Double | String): this.type = set("x", value.asInstanceOf[js.Any])
    
    @scala.inline
    def x1(value: Double | String): this.type = set("x1", value.asInstanceOf[js.Any])
    
    @scala.inline
    def x2(value: Double | String): this.type = set("x2", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xChannelSelector(value: String): this.type = set("xChannelSelector", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xHeight(value: Double | String): this.type = set("xHeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xlinkActuate(value: String): this.type = set("xlinkActuate", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xlinkArcrole(value: String): this.type = set("xlinkArcrole", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xlinkHref(value: String): this.type = set("xlinkHref", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xlinkRole(value: String): this.type = set("xlinkRole", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xlinkShow(value: String): this.type = set("xlinkShow", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xlinkTitle(value: String): this.type = set("xlinkTitle", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xlinkType(value: String): this.type = set("xlinkType", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xmlBase(value: String): this.type = set("xmlBase", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xmlLang(value: String): this.type = set("xmlLang", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xmlSpace(value: String): this.type = set("xmlSpace", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xmlns(value: String): this.type = set("xmlns", value.asInstanceOf[js.Any])
    
    @scala.inline
    def xmlnsXlink(value: String): this.type = set("xmlnsXlink", value.asInstanceOf[js.Any])
    
    @scala.inline
    def y(value: Double | String): this.type = set("y", value.asInstanceOf[js.Any])
    
    @scala.inline
    def y1(value: Double | String): this.type = set("y1", value.asInstanceOf[js.Any])
    
    @scala.inline
    def y2(value: Double | String): this.type = set("y2", value.asInstanceOf[js.Any])
    
    @scala.inline
    def yChannelSelector(value: String): this.type = set("yChannelSelector", value.asInstanceOf[js.Any])
    
    @scala.inline
    def z(value: Double | String): this.type = set("z", value.asInstanceOf[js.Any])
    
    @scala.inline
    def zoomAndPan(value: String): this.type = set("zoomAndPan", value.asInstanceOf[js.Any])
  }
}

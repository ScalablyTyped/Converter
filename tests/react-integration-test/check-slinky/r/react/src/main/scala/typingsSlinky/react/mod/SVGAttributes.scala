package typingsSlinky.react.mod

import typingsSlinky.react.reactStrings.`after-edge`
import typingsSlinky.react.reactStrings.`before-edge`
import typingsSlinky.react.reactStrings.`text-after-edge`
import typingsSlinky.react.reactStrings.`text-before-edge`
import typingsSlinky.react.reactStrings.alphabetic
import typingsSlinky.react.reactStrings.auto
import typingsSlinky.react.reactStrings.baseline
import typingsSlinky.react.reactStrings.bevel
import typingsSlinky.react.reactStrings.butt
import typingsSlinky.react.reactStrings.central
import typingsSlinky.react.reactStrings.evenodd
import typingsSlinky.react.reactStrings.hanging
import typingsSlinky.react.reactStrings.ideographic
import typingsSlinky.react.reactStrings.inherit
import typingsSlinky.react.reactStrings.initial
import typingsSlinky.react.reactStrings.isolated
import typingsSlinky.react.reactStrings.linearRGB
import typingsSlinky.react.reactStrings.mathematical
import typingsSlinky.react.reactStrings.medial
import typingsSlinky.react.reactStrings.middle
import typingsSlinky.react.reactStrings.miter
import typingsSlinky.react.reactStrings.no
import typingsSlinky.react.reactStrings.none
import typingsSlinky.react.reactStrings.nonzero
import typingsSlinky.react.reactStrings.replace
import typingsSlinky.react.reactStrings.round
import typingsSlinky.react.reactStrings.sRGB
import typingsSlinky.react.reactStrings.square
import typingsSlinky.react.reactStrings.sum
import typingsSlinky.react.reactStrings.terminal
import typingsSlinky.react.reactStrings.yes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

// this list is "complete" in that it contains every SVG attribute
// that React supports, but the types can be improved.
// Full list here: https://facebook.github.io/react/docs/dom-elements.html
//
// The three broad type categories are (in order of restrictiveness):
//   - "number | string"
//   - "string"
//   - union of string literals
trait SVGAttributes[T]
  extends StObject
     with AriaAttributes
     with DOMAttributes[T] {
  
  // SVG Specific attributes
  var accentHeight: js.UndefOr[Double | String] = js.undefined
  
  var accumulate: js.UndefOr[none | sum] = js.undefined
  
  var additive: js.UndefOr[replace | sum] = js.undefined
  
  var alignmentBaseline: js.UndefOr[
    auto | baseline | `before-edge` | `text-before-edge` | middle | central | `after-edge` | `text-after-edge` | ideographic | alphabetic | hanging | mathematical | inherit
  ] = js.undefined
  
  var allowReorder: js.UndefOr[no | yes] = js.undefined
  
  var alphabetic: js.UndefOr[Double | String] = js.undefined
  
  var amplitude: js.UndefOr[Double | String] = js.undefined
  
  var arabicForm: js.UndefOr[initial | medial | terminal | isolated] = js.undefined
  
  var ascent: js.UndefOr[Double | String] = js.undefined
  
  var attributeName: js.UndefOr[String] = js.undefined
  
  var attributeType: js.UndefOr[String] = js.undefined
  
  var autoReverse: js.UndefOr[Double | String] = js.undefined
  
  var azimuth: js.UndefOr[Double | String] = js.undefined
  
  var baseFrequency: js.UndefOr[Double | String] = js.undefined
  
  var baseProfile: js.UndefOr[Double | String] = js.undefined
  
  var baselineShift: js.UndefOr[Double | String] = js.undefined
  
  var bbox: js.UndefOr[Double | String] = js.undefined
  
  var begin: js.UndefOr[Double | String] = js.undefined
  
  var bias: js.UndefOr[Double | String] = js.undefined
  
  var by: js.UndefOr[Double | String] = js.undefined
  
  var calcMode: js.UndefOr[Double | String] = js.undefined
  
  var capHeight: js.UndefOr[Double | String] = js.undefined
  
  // Attributes which also defined in HTMLAttributes
  // See comment in SVGDOMPropertyConfig.js
  var className: js.UndefOr[String] = js.undefined
  
  var clip: js.UndefOr[Double | String] = js.undefined
  
  var clipPath: js.UndefOr[String] = js.undefined
  
  var clipPathUnits: js.UndefOr[Double | String] = js.undefined
  
  var clipRule: js.UndefOr[Double | String] = js.undefined
  
  var color: js.UndefOr[String] = js.undefined
  
  var colorInterpolation: js.UndefOr[Double | String] = js.undefined
  
  var colorInterpolationFilters: js.UndefOr[auto | sRGB | linearRGB | inherit] = js.undefined
  
  var colorProfile: js.UndefOr[Double | String] = js.undefined
  
  var colorRendering: js.UndefOr[Double | String] = js.undefined
  
  var contentScriptType: js.UndefOr[Double | String] = js.undefined
  
  var contentStyleType: js.UndefOr[Double | String] = js.undefined
  
  var cursor: js.UndefOr[Double | String] = js.undefined
  
  var cx: js.UndefOr[Double | String] = js.undefined
  
  var cy: js.UndefOr[Double | String] = js.undefined
  
  var d: js.UndefOr[String] = js.undefined
  
  var decelerate: js.UndefOr[Double | String] = js.undefined
  
  var descent: js.UndefOr[Double | String] = js.undefined
  
  var diffuseConstant: js.UndefOr[Double | String] = js.undefined
  
  var direction: js.UndefOr[Double | String] = js.undefined
  
  var display: js.UndefOr[Double | String] = js.undefined
  
  var divisor: js.UndefOr[Double | String] = js.undefined
  
  var dominantBaseline: js.UndefOr[Double | String] = js.undefined
  
  var dur: js.UndefOr[Double | String] = js.undefined
  
  var dx: js.UndefOr[Double | String] = js.undefined
  
  var dy: js.UndefOr[Double | String] = js.undefined
  
  var edgeMode: js.UndefOr[Double | String] = js.undefined
  
  var elevation: js.UndefOr[Double | String] = js.undefined
  
  var enableBackground: js.UndefOr[Double | String] = js.undefined
  
  var end: js.UndefOr[Double | String] = js.undefined
  
  var exponent: js.UndefOr[Double | String] = js.undefined
  
  var externalResourcesRequired: js.UndefOr[Double | String] = js.undefined
  
  var fill: js.UndefOr[String] = js.undefined
  
  var fillOpacity: js.UndefOr[Double | String] = js.undefined
  
  var fillRule: js.UndefOr[nonzero | evenodd | inherit] = js.undefined
  
  var filter: js.UndefOr[String] = js.undefined
  
  var filterRes: js.UndefOr[Double | String] = js.undefined
  
  var filterUnits: js.UndefOr[Double | String] = js.undefined
  
  var floodColor: js.UndefOr[Double | String] = js.undefined
  
  var floodOpacity: js.UndefOr[Double | String] = js.undefined
  
  var focusable: js.UndefOr[Double | String] = js.undefined
  
  var fontFamily: js.UndefOr[String] = js.undefined
  
  var fontSize: js.UndefOr[Double | String] = js.undefined
  
  var fontSizeAdjust: js.UndefOr[Double | String] = js.undefined
  
  var fontStretch: js.UndefOr[Double | String] = js.undefined
  
  var fontStyle: js.UndefOr[Double | String] = js.undefined
  
  var fontVariant: js.UndefOr[Double | String] = js.undefined
  
  var fontWeight: js.UndefOr[Double | String] = js.undefined
  
  var format: js.UndefOr[Double | String] = js.undefined
  
  var from: js.UndefOr[Double | String] = js.undefined
  
  var fx: js.UndefOr[Double | String] = js.undefined
  
  var fy: js.UndefOr[Double | String] = js.undefined
  
  var g1: js.UndefOr[Double | String] = js.undefined
  
  var g2: js.UndefOr[Double | String] = js.undefined
  
  var glyphName: js.UndefOr[Double | String] = js.undefined
  
  var glyphOrientationHorizontal: js.UndefOr[Double | String] = js.undefined
  
  var glyphOrientationVertical: js.UndefOr[Double | String] = js.undefined
  
  var glyphRef: js.UndefOr[Double | String] = js.undefined
  
  var gradientTransform: js.UndefOr[String] = js.undefined
  
  var gradientUnits: js.UndefOr[String] = js.undefined
  
  var hanging: js.UndefOr[Double | String] = js.undefined
  
  var height: js.UndefOr[Double | String] = js.undefined
  
  var horizAdvX: js.UndefOr[Double | String] = js.undefined
  
  var horizOriginX: js.UndefOr[Double | String] = js.undefined
  
  var href: js.UndefOr[String] = js.undefined
  
  var id: js.UndefOr[String] = js.undefined
  
  var ideographic: js.UndefOr[Double | String] = js.undefined
  
  var imageRendering: js.UndefOr[Double | String] = js.undefined
  
  var in: js.UndefOr[String] = js.undefined
  
  var in2: js.UndefOr[Double | String] = js.undefined
  
  var intercept: js.UndefOr[Double | String] = js.undefined
  
  var k: js.UndefOr[Double | String] = js.undefined
  
  var k1: js.UndefOr[Double | String] = js.undefined
  
  var k2: js.UndefOr[Double | String] = js.undefined
  
  var k3: js.UndefOr[Double | String] = js.undefined
  
  var k4: js.UndefOr[Double | String] = js.undefined
  
  var kernelMatrix: js.UndefOr[Double | String] = js.undefined
  
  var kernelUnitLength: js.UndefOr[Double | String] = js.undefined
  
  var kerning: js.UndefOr[Double | String] = js.undefined
  
  var keyPoints: js.UndefOr[Double | String] = js.undefined
  
  var keySplines: js.UndefOr[Double | String] = js.undefined
  
  var keyTimes: js.UndefOr[Double | String] = js.undefined
  
  var lang: js.UndefOr[String] = js.undefined
  
  var lengthAdjust: js.UndefOr[Double | String] = js.undefined
  
  var letterSpacing: js.UndefOr[Double | String] = js.undefined
  
  var lightingColor: js.UndefOr[Double | String] = js.undefined
  
  var limitingConeAngle: js.UndefOr[Double | String] = js.undefined
  
  var local: js.UndefOr[Double | String] = js.undefined
  
  var markerEnd: js.UndefOr[String] = js.undefined
  
  var markerHeight: js.UndefOr[Double | String] = js.undefined
  
  var markerMid: js.UndefOr[String] = js.undefined
  
  var markerStart: js.UndefOr[String] = js.undefined
  
  var markerUnits: js.UndefOr[Double | String] = js.undefined
  
  var markerWidth: js.UndefOr[Double | String] = js.undefined
  
  var mask: js.UndefOr[String] = js.undefined
  
  var maskContentUnits: js.UndefOr[Double | String] = js.undefined
  
  var maskUnits: js.UndefOr[Double | String] = js.undefined
  
  var mathematical: js.UndefOr[Double | String] = js.undefined
  
  var max: js.UndefOr[Double | String] = js.undefined
  
  var media: js.UndefOr[String] = js.undefined
  
  var method: js.UndefOr[String] = js.undefined
  
  var min: js.UndefOr[Double | String] = js.undefined
  
  var mode: js.UndefOr[Double | String] = js.undefined
  
  var name: js.UndefOr[String] = js.undefined
  
  var numOctaves: js.UndefOr[Double | String] = js.undefined
  
  var offset: js.UndefOr[Double | String] = js.undefined
  
  var opacity: js.UndefOr[Double | String] = js.undefined
  
  var operator: js.UndefOr[Double | String] = js.undefined
  
  var order: js.UndefOr[Double | String] = js.undefined
  
  var orient: js.UndefOr[Double | String] = js.undefined
  
  var orientation: js.UndefOr[Double | String] = js.undefined
  
  var origin: js.UndefOr[Double | String] = js.undefined
  
  var overflow: js.UndefOr[Double | String] = js.undefined
  
  var overlinePosition: js.UndefOr[Double | String] = js.undefined
  
  var overlineThickness: js.UndefOr[Double | String] = js.undefined
  
  var paintOrder: js.UndefOr[Double | String] = js.undefined
  
  var panose1: js.UndefOr[Double | String] = js.undefined
  
  var pathLength: js.UndefOr[Double | String] = js.undefined
  
  var patternContentUnits: js.UndefOr[String] = js.undefined
  
  var patternTransform: js.UndefOr[Double | String] = js.undefined
  
  var patternUnits: js.UndefOr[String] = js.undefined
  
  var pointerEvents: js.UndefOr[Double | String] = js.undefined
  
  var points: js.UndefOr[String] = js.undefined
  
  var pointsAtX: js.UndefOr[Double | String] = js.undefined
  
  var pointsAtY: js.UndefOr[Double | String] = js.undefined
  
  var pointsAtZ: js.UndefOr[Double | String] = js.undefined
  
  var preserveAlpha: js.UndefOr[Double | String] = js.undefined
  
  var preserveAspectRatio: js.UndefOr[String] = js.undefined
  
  var primitiveUnits: js.UndefOr[Double | String] = js.undefined
  
  var r: js.UndefOr[Double | String] = js.undefined
  
  var radius: js.UndefOr[Double | String] = js.undefined
  
  var refX: js.UndefOr[Double | String] = js.undefined
  
  var refY: js.UndefOr[Double | String] = js.undefined
  
  var renderingIntent: js.UndefOr[Double | String] = js.undefined
  
  var repeatCount: js.UndefOr[Double | String] = js.undefined
  
  var repeatDur: js.UndefOr[Double | String] = js.undefined
  
  var requiredExtensions: js.UndefOr[Double | String] = js.undefined
  
  var requiredFeatures: js.UndefOr[Double | String] = js.undefined
  
  var restart: js.UndefOr[Double | String] = js.undefined
  
  var result: js.UndefOr[String] = js.undefined
  
  // Other HTML properties supported by SVG elements in browsers
  var role: js.UndefOr[String] = js.undefined
  
  var rotate: js.UndefOr[Double | String] = js.undefined
  
  var rx: js.UndefOr[Double | String] = js.undefined
  
  var ry: js.UndefOr[Double | String] = js.undefined
  
  var scale: js.UndefOr[Double | String] = js.undefined
  
  var seed: js.UndefOr[Double | String] = js.undefined
  
  var shapeRendering: js.UndefOr[Double | String] = js.undefined
  
  var slope: js.UndefOr[Double | String] = js.undefined
  
  var spacing: js.UndefOr[Double | String] = js.undefined
  
  var specularConstant: js.UndefOr[Double | String] = js.undefined
  
  var specularExponent: js.UndefOr[Double | String] = js.undefined
  
  var speed: js.UndefOr[Double | String] = js.undefined
  
  var spreadMethod: js.UndefOr[String] = js.undefined
  
  var startOffset: js.UndefOr[Double | String] = js.undefined
  
  var stdDeviation: js.UndefOr[Double | String] = js.undefined
  
  var stemh: js.UndefOr[Double | String] = js.undefined
  
  var stemv: js.UndefOr[Double | String] = js.undefined
  
  var stitchTiles: js.UndefOr[Double | String] = js.undefined
  
  var stopColor: js.UndefOr[String] = js.undefined
  
  var stopOpacity: js.UndefOr[Double | String] = js.undefined
  
  var strikethroughPosition: js.UndefOr[Double | String] = js.undefined
  
  var strikethroughThickness: js.UndefOr[Double | String] = js.undefined
  
  var string: js.UndefOr[Double | String] = js.undefined
  
  var stroke: js.UndefOr[String] = js.undefined
  
  var strokeDasharray: js.UndefOr[String | Double] = js.undefined
  
  var strokeDashoffset: js.UndefOr[String | Double] = js.undefined
  
  var strokeLinecap: js.UndefOr[butt | round | square | inherit] = js.undefined
  
  var strokeLinejoin: js.UndefOr[miter | round | bevel | inherit] = js.undefined
  
  var strokeMiterlimit: js.UndefOr[Double | String] = js.undefined
  
  var strokeOpacity: js.UndefOr[Double | String] = js.undefined
  
  var strokeWidth: js.UndefOr[Double | String] = js.undefined
  
  var style: js.UndefOr[CSSProperties] = js.undefined
  
  var surfaceScale: js.UndefOr[Double | String] = js.undefined
  
  var systemLanguage: js.UndefOr[Double | String] = js.undefined
  
  var tabIndex: js.UndefOr[Double] = js.undefined
  
  var tableValues: js.UndefOr[Double | String] = js.undefined
  
  var target: js.UndefOr[String] = js.undefined
  
  var targetX: js.UndefOr[Double | String] = js.undefined
  
  var targetY: js.UndefOr[Double | String] = js.undefined
  
  var textAnchor: js.UndefOr[String] = js.undefined
  
  var textDecoration: js.UndefOr[Double | String] = js.undefined
  
  var textLength: js.UndefOr[Double | String] = js.undefined
  
  var textRendering: js.UndefOr[Double | String] = js.undefined
  
  var to: js.UndefOr[Double | String] = js.undefined
  
  var transform: js.UndefOr[String] = js.undefined
  
  var `type`: js.UndefOr[String] = js.undefined
  
  var u1: js.UndefOr[Double | String] = js.undefined
  
  var u2: js.UndefOr[Double | String] = js.undefined
  
  var underlinePosition: js.UndefOr[Double | String] = js.undefined
  
  var underlineThickness: js.UndefOr[Double | String] = js.undefined
  
  var unicode: js.UndefOr[Double | String] = js.undefined
  
  var unicodeBidi: js.UndefOr[Double | String] = js.undefined
  
  var unicodeRange: js.UndefOr[Double | String] = js.undefined
  
  var unitsPerEm: js.UndefOr[Double | String] = js.undefined
  
  var vAlphabetic: js.UndefOr[Double | String] = js.undefined
  
  var vHanging: js.UndefOr[Double | String] = js.undefined
  
  var vIdeographic: js.UndefOr[Double | String] = js.undefined
  
  var vMathematical: js.UndefOr[Double | String] = js.undefined
  
  var values: js.UndefOr[String] = js.undefined
  
  var vectorEffect: js.UndefOr[Double | String] = js.undefined
  
  var version: js.UndefOr[String] = js.undefined
  
  var vertAdvY: js.UndefOr[Double | String] = js.undefined
  
  var vertOriginX: js.UndefOr[Double | String] = js.undefined
  
  var vertOriginY: js.UndefOr[Double | String] = js.undefined
  
  var viewBox: js.UndefOr[String] = js.undefined
  
  var viewTarget: js.UndefOr[Double | String] = js.undefined
  
  var visibility: js.UndefOr[Double | String] = js.undefined
  
  var width: js.UndefOr[Double | String] = js.undefined
  
  var widths: js.UndefOr[Double | String] = js.undefined
  
  var wordSpacing: js.UndefOr[Double | String] = js.undefined
  
  var writingMode: js.UndefOr[Double | String] = js.undefined
  
  var x: js.UndefOr[Double | String] = js.undefined
  
  var x1: js.UndefOr[Double | String] = js.undefined
  
  var x2: js.UndefOr[Double | String] = js.undefined
  
  var xChannelSelector: js.UndefOr[String] = js.undefined
  
  var xHeight: js.UndefOr[Double | String] = js.undefined
  
  var xlinkActuate: js.UndefOr[String] = js.undefined
  
  var xlinkArcrole: js.UndefOr[String] = js.undefined
  
  var xlinkHref: js.UndefOr[String] = js.undefined
  
  var xlinkRole: js.UndefOr[String] = js.undefined
  
  var xlinkShow: js.UndefOr[String] = js.undefined
  
  var xlinkTitle: js.UndefOr[String] = js.undefined
  
  var xlinkType: js.UndefOr[String] = js.undefined
  
  var xmlBase: js.UndefOr[String] = js.undefined
  
  var xmlLang: js.UndefOr[String] = js.undefined
  
  var xmlSpace: js.UndefOr[String] = js.undefined
  
  var xmlns: js.UndefOr[String] = js.undefined
  
  var xmlnsXlink: js.UndefOr[String] = js.undefined
  
  var y: js.UndefOr[Double | String] = js.undefined
  
  var y1: js.UndefOr[Double | String] = js.undefined
  
  var y2: js.UndefOr[Double | String] = js.undefined
  
  var yChannelSelector: js.UndefOr[String] = js.undefined
  
  var z: js.UndefOr[Double | String] = js.undefined
  
  var zoomAndPan: js.UndefOr[String] = js.undefined
}
object SVGAttributes {
  
  inline def apply[T](): SVGAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[SVGAttributes[T]]
  }
  
  extension [Self <: SVGAttributes[?], T](x: Self & SVGAttributes[T]) {
    
    inline def setAccentHeight(value: Double | String): Self = StObject.set(x, "accentHeight", value.asInstanceOf[js.Any])
    
    inline def setAccentHeightUndefined: Self = StObject.set(x, "accentHeight", js.undefined)
    
    inline def setAccumulate(value: none | sum): Self = StObject.set(x, "accumulate", value.asInstanceOf[js.Any])
    
    inline def setAccumulateUndefined: Self = StObject.set(x, "accumulate", js.undefined)
    
    inline def setAdditive(value: replace | sum): Self = StObject.set(x, "additive", value.asInstanceOf[js.Any])
    
    inline def setAdditiveUndefined: Self = StObject.set(x, "additive", js.undefined)
    
    inline def setAlignmentBaseline(
      value: auto | baseline | `before-edge` | `text-before-edge` | middle | central | `after-edge` | `text-after-edge` | ideographic | alphabetic | hanging | mathematical | inherit
    ): Self = StObject.set(x, "alignmentBaseline", value.asInstanceOf[js.Any])
    
    inline def setAlignmentBaselineUndefined: Self = StObject.set(x, "alignmentBaseline", js.undefined)
    
    inline def setAllowReorder(value: no | yes): Self = StObject.set(x, "allowReorder", value.asInstanceOf[js.Any])
    
    inline def setAllowReorderUndefined: Self = StObject.set(x, "allowReorder", js.undefined)
    
    inline def setAlphabetic(value: Double | String): Self = StObject.set(x, "alphabetic", value.asInstanceOf[js.Any])
    
    inline def setAlphabeticUndefined: Self = StObject.set(x, "alphabetic", js.undefined)
    
    inline def setAmplitude(value: Double | String): Self = StObject.set(x, "amplitude", value.asInstanceOf[js.Any])
    
    inline def setAmplitudeUndefined: Self = StObject.set(x, "amplitude", js.undefined)
    
    inline def setArabicForm(value: initial | medial | terminal | isolated): Self = StObject.set(x, "arabicForm", value.asInstanceOf[js.Any])
    
    inline def setArabicFormUndefined: Self = StObject.set(x, "arabicForm", js.undefined)
    
    inline def setAscent(value: Double | String): Self = StObject.set(x, "ascent", value.asInstanceOf[js.Any])
    
    inline def setAscentUndefined: Self = StObject.set(x, "ascent", js.undefined)
    
    inline def setAttributeName(value: String): Self = StObject.set(x, "attributeName", value.asInstanceOf[js.Any])
    
    inline def setAttributeNameUndefined: Self = StObject.set(x, "attributeName", js.undefined)
    
    inline def setAttributeType(value: String): Self = StObject.set(x, "attributeType", value.asInstanceOf[js.Any])
    
    inline def setAttributeTypeUndefined: Self = StObject.set(x, "attributeType", js.undefined)
    
    inline def setAutoReverse(value: Double | String): Self = StObject.set(x, "autoReverse", value.asInstanceOf[js.Any])
    
    inline def setAutoReverseUndefined: Self = StObject.set(x, "autoReverse", js.undefined)
    
    inline def setAzimuth(value: Double | String): Self = StObject.set(x, "azimuth", value.asInstanceOf[js.Any])
    
    inline def setAzimuthUndefined: Self = StObject.set(x, "azimuth", js.undefined)
    
    inline def setBaseFrequency(value: Double | String): Self = StObject.set(x, "baseFrequency", value.asInstanceOf[js.Any])
    
    inline def setBaseFrequencyUndefined: Self = StObject.set(x, "baseFrequency", js.undefined)
    
    inline def setBaseProfile(value: Double | String): Self = StObject.set(x, "baseProfile", value.asInstanceOf[js.Any])
    
    inline def setBaseProfileUndefined: Self = StObject.set(x, "baseProfile", js.undefined)
    
    inline def setBaselineShift(value: Double | String): Self = StObject.set(x, "baselineShift", value.asInstanceOf[js.Any])
    
    inline def setBaselineShiftUndefined: Self = StObject.set(x, "baselineShift", js.undefined)
    
    inline def setBbox(value: Double | String): Self = StObject.set(x, "bbox", value.asInstanceOf[js.Any])
    
    inline def setBboxUndefined: Self = StObject.set(x, "bbox", js.undefined)
    
    inline def setBegin(value: Double | String): Self = StObject.set(x, "begin", value.asInstanceOf[js.Any])
    
    inline def setBeginUndefined: Self = StObject.set(x, "begin", js.undefined)
    
    inline def setBias(value: Double | String): Self = StObject.set(x, "bias", value.asInstanceOf[js.Any])
    
    inline def setBiasUndefined: Self = StObject.set(x, "bias", js.undefined)
    
    inline def setBy(value: Double | String): Self = StObject.set(x, "by", value.asInstanceOf[js.Any])
    
    inline def setByUndefined: Self = StObject.set(x, "by", js.undefined)
    
    inline def setCalcMode(value: Double | String): Self = StObject.set(x, "calcMode", value.asInstanceOf[js.Any])
    
    inline def setCalcModeUndefined: Self = StObject.set(x, "calcMode", js.undefined)
    
    inline def setCapHeight(value: Double | String): Self = StObject.set(x, "capHeight", value.asInstanceOf[js.Any])
    
    inline def setCapHeightUndefined: Self = StObject.set(x, "capHeight", js.undefined)
    
    inline def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
    
    inline def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
    
    inline def setClip(value: Double | String): Self = StObject.set(x, "clip", value.asInstanceOf[js.Any])
    
    inline def setClipPath(value: String): Self = StObject.set(x, "clipPath", value.asInstanceOf[js.Any])
    
    inline def setClipPathUndefined: Self = StObject.set(x, "clipPath", js.undefined)
    
    inline def setClipPathUnits(value: Double | String): Self = StObject.set(x, "clipPathUnits", value.asInstanceOf[js.Any])
    
    inline def setClipPathUnitsUndefined: Self = StObject.set(x, "clipPathUnits", js.undefined)
    
    inline def setClipRule(value: Double | String): Self = StObject.set(x, "clipRule", value.asInstanceOf[js.Any])
    
    inline def setClipRuleUndefined: Self = StObject.set(x, "clipRule", js.undefined)
    
    inline def setClipUndefined: Self = StObject.set(x, "clip", js.undefined)
    
    inline def setColor(value: String): Self = StObject.set(x, "color", value.asInstanceOf[js.Any])
    
    inline def setColorInterpolation(value: Double | String): Self = StObject.set(x, "colorInterpolation", value.asInstanceOf[js.Any])
    
    inline def setColorInterpolationFilters(value: auto | sRGB | linearRGB | inherit): Self = StObject.set(x, "colorInterpolationFilters", value.asInstanceOf[js.Any])
    
    inline def setColorInterpolationFiltersUndefined: Self = StObject.set(x, "colorInterpolationFilters", js.undefined)
    
    inline def setColorInterpolationUndefined: Self = StObject.set(x, "colorInterpolation", js.undefined)
    
    inline def setColorProfile(value: Double | String): Self = StObject.set(x, "colorProfile", value.asInstanceOf[js.Any])
    
    inline def setColorProfileUndefined: Self = StObject.set(x, "colorProfile", js.undefined)
    
    inline def setColorRendering(value: Double | String): Self = StObject.set(x, "colorRendering", value.asInstanceOf[js.Any])
    
    inline def setColorRenderingUndefined: Self = StObject.set(x, "colorRendering", js.undefined)
    
    inline def setColorUndefined: Self = StObject.set(x, "color", js.undefined)
    
    inline def setContentScriptType(value: Double | String): Self = StObject.set(x, "contentScriptType", value.asInstanceOf[js.Any])
    
    inline def setContentScriptTypeUndefined: Self = StObject.set(x, "contentScriptType", js.undefined)
    
    inline def setContentStyleType(value: Double | String): Self = StObject.set(x, "contentStyleType", value.asInstanceOf[js.Any])
    
    inline def setContentStyleTypeUndefined: Self = StObject.set(x, "contentStyleType", js.undefined)
    
    inline def setCursor(value: Double | String): Self = StObject.set(x, "cursor", value.asInstanceOf[js.Any])
    
    inline def setCursorUndefined: Self = StObject.set(x, "cursor", js.undefined)
    
    inline def setCx(value: Double | String): Self = StObject.set(x, "cx", value.asInstanceOf[js.Any])
    
    inline def setCxUndefined: Self = StObject.set(x, "cx", js.undefined)
    
    inline def setCy(value: Double | String): Self = StObject.set(x, "cy", value.asInstanceOf[js.Any])
    
    inline def setCyUndefined: Self = StObject.set(x, "cy", js.undefined)
    
    inline def setD(value: String): Self = StObject.set(x, "d", value.asInstanceOf[js.Any])
    
    inline def setDUndefined: Self = StObject.set(x, "d", js.undefined)
    
    inline def setDecelerate(value: Double | String): Self = StObject.set(x, "decelerate", value.asInstanceOf[js.Any])
    
    inline def setDecelerateUndefined: Self = StObject.set(x, "decelerate", js.undefined)
    
    inline def setDescent(value: Double | String): Self = StObject.set(x, "descent", value.asInstanceOf[js.Any])
    
    inline def setDescentUndefined: Self = StObject.set(x, "descent", js.undefined)
    
    inline def setDiffuseConstant(value: Double | String): Self = StObject.set(x, "diffuseConstant", value.asInstanceOf[js.Any])
    
    inline def setDiffuseConstantUndefined: Self = StObject.set(x, "diffuseConstant", js.undefined)
    
    inline def setDirection(value: Double | String): Self = StObject.set(x, "direction", value.asInstanceOf[js.Any])
    
    inline def setDirectionUndefined: Self = StObject.set(x, "direction", js.undefined)
    
    inline def setDisplay(value: Double | String): Self = StObject.set(x, "display", value.asInstanceOf[js.Any])
    
    inline def setDisplayUndefined: Self = StObject.set(x, "display", js.undefined)
    
    inline def setDivisor(value: Double | String): Self = StObject.set(x, "divisor", value.asInstanceOf[js.Any])
    
    inline def setDivisorUndefined: Self = StObject.set(x, "divisor", js.undefined)
    
    inline def setDominantBaseline(value: Double | String): Self = StObject.set(x, "dominantBaseline", value.asInstanceOf[js.Any])
    
    inline def setDominantBaselineUndefined: Self = StObject.set(x, "dominantBaseline", js.undefined)
    
    inline def setDur(value: Double | String): Self = StObject.set(x, "dur", value.asInstanceOf[js.Any])
    
    inline def setDurUndefined: Self = StObject.set(x, "dur", js.undefined)
    
    inline def setDx(value: Double | String): Self = StObject.set(x, "dx", value.asInstanceOf[js.Any])
    
    inline def setDxUndefined: Self = StObject.set(x, "dx", js.undefined)
    
    inline def setDy(value: Double | String): Self = StObject.set(x, "dy", value.asInstanceOf[js.Any])
    
    inline def setDyUndefined: Self = StObject.set(x, "dy", js.undefined)
    
    inline def setEdgeMode(value: Double | String): Self = StObject.set(x, "edgeMode", value.asInstanceOf[js.Any])
    
    inline def setEdgeModeUndefined: Self = StObject.set(x, "edgeMode", js.undefined)
    
    inline def setElevation(value: Double | String): Self = StObject.set(x, "elevation", value.asInstanceOf[js.Any])
    
    inline def setElevationUndefined: Self = StObject.set(x, "elevation", js.undefined)
    
    inline def setEnableBackground(value: Double | String): Self = StObject.set(x, "enableBackground", value.asInstanceOf[js.Any])
    
    inline def setEnableBackgroundUndefined: Self = StObject.set(x, "enableBackground", js.undefined)
    
    inline def setEnd(value: Double | String): Self = StObject.set(x, "end", value.asInstanceOf[js.Any])
    
    inline def setEndUndefined: Self = StObject.set(x, "end", js.undefined)
    
    inline def setExponent(value: Double | String): Self = StObject.set(x, "exponent", value.asInstanceOf[js.Any])
    
    inline def setExponentUndefined: Self = StObject.set(x, "exponent", js.undefined)
    
    inline def setExternalResourcesRequired(value: Double | String): Self = StObject.set(x, "externalResourcesRequired", value.asInstanceOf[js.Any])
    
    inline def setExternalResourcesRequiredUndefined: Self = StObject.set(x, "externalResourcesRequired", js.undefined)
    
    inline def setFill(value: String): Self = StObject.set(x, "fill", value.asInstanceOf[js.Any])
    
    inline def setFillOpacity(value: Double | String): Self = StObject.set(x, "fillOpacity", value.asInstanceOf[js.Any])
    
    inline def setFillOpacityUndefined: Self = StObject.set(x, "fillOpacity", js.undefined)
    
    inline def setFillRule(value: nonzero | evenodd | inherit): Self = StObject.set(x, "fillRule", value.asInstanceOf[js.Any])
    
    inline def setFillRuleUndefined: Self = StObject.set(x, "fillRule", js.undefined)
    
    inline def setFillUndefined: Self = StObject.set(x, "fill", js.undefined)
    
    inline def setFilter(value: String): Self = StObject.set(x, "filter", value.asInstanceOf[js.Any])
    
    inline def setFilterRes(value: Double | String): Self = StObject.set(x, "filterRes", value.asInstanceOf[js.Any])
    
    inline def setFilterResUndefined: Self = StObject.set(x, "filterRes", js.undefined)
    
    inline def setFilterUndefined: Self = StObject.set(x, "filter", js.undefined)
    
    inline def setFilterUnits(value: Double | String): Self = StObject.set(x, "filterUnits", value.asInstanceOf[js.Any])
    
    inline def setFilterUnitsUndefined: Self = StObject.set(x, "filterUnits", js.undefined)
    
    inline def setFloodColor(value: Double | String): Self = StObject.set(x, "floodColor", value.asInstanceOf[js.Any])
    
    inline def setFloodColorUndefined: Self = StObject.set(x, "floodColor", js.undefined)
    
    inline def setFloodOpacity(value: Double | String): Self = StObject.set(x, "floodOpacity", value.asInstanceOf[js.Any])
    
    inline def setFloodOpacityUndefined: Self = StObject.set(x, "floodOpacity", js.undefined)
    
    inline def setFocusable(value: Double | String): Self = StObject.set(x, "focusable", value.asInstanceOf[js.Any])
    
    inline def setFocusableUndefined: Self = StObject.set(x, "focusable", js.undefined)
    
    inline def setFontFamily(value: String): Self = StObject.set(x, "fontFamily", value.asInstanceOf[js.Any])
    
    inline def setFontFamilyUndefined: Self = StObject.set(x, "fontFamily", js.undefined)
    
    inline def setFontSize(value: Double | String): Self = StObject.set(x, "fontSize", value.asInstanceOf[js.Any])
    
    inline def setFontSizeAdjust(value: Double | String): Self = StObject.set(x, "fontSizeAdjust", value.asInstanceOf[js.Any])
    
    inline def setFontSizeAdjustUndefined: Self = StObject.set(x, "fontSizeAdjust", js.undefined)
    
    inline def setFontSizeUndefined: Self = StObject.set(x, "fontSize", js.undefined)
    
    inline def setFontStretch(value: Double | String): Self = StObject.set(x, "fontStretch", value.asInstanceOf[js.Any])
    
    inline def setFontStretchUndefined: Self = StObject.set(x, "fontStretch", js.undefined)
    
    inline def setFontStyle(value: Double | String): Self = StObject.set(x, "fontStyle", value.asInstanceOf[js.Any])
    
    inline def setFontStyleUndefined: Self = StObject.set(x, "fontStyle", js.undefined)
    
    inline def setFontVariant(value: Double | String): Self = StObject.set(x, "fontVariant", value.asInstanceOf[js.Any])
    
    inline def setFontVariantUndefined: Self = StObject.set(x, "fontVariant", js.undefined)
    
    inline def setFontWeight(value: Double | String): Self = StObject.set(x, "fontWeight", value.asInstanceOf[js.Any])
    
    inline def setFontWeightUndefined: Self = StObject.set(x, "fontWeight", js.undefined)
    
    inline def setFormat(value: Double | String): Self = StObject.set(x, "format", value.asInstanceOf[js.Any])
    
    inline def setFormatUndefined: Self = StObject.set(x, "format", js.undefined)
    
    inline def setFrom(value: Double | String): Self = StObject.set(x, "from", value.asInstanceOf[js.Any])
    
    inline def setFromUndefined: Self = StObject.set(x, "from", js.undefined)
    
    inline def setFx(value: Double | String): Self = StObject.set(x, "fx", value.asInstanceOf[js.Any])
    
    inline def setFxUndefined: Self = StObject.set(x, "fx", js.undefined)
    
    inline def setFy(value: Double | String): Self = StObject.set(x, "fy", value.asInstanceOf[js.Any])
    
    inline def setFyUndefined: Self = StObject.set(x, "fy", js.undefined)
    
    inline def setG1(value: Double | String): Self = StObject.set(x, "g1", value.asInstanceOf[js.Any])
    
    inline def setG1Undefined: Self = StObject.set(x, "g1", js.undefined)
    
    inline def setG2(value: Double | String): Self = StObject.set(x, "g2", value.asInstanceOf[js.Any])
    
    inline def setG2Undefined: Self = StObject.set(x, "g2", js.undefined)
    
    inline def setGlyphName(value: Double | String): Self = StObject.set(x, "glyphName", value.asInstanceOf[js.Any])
    
    inline def setGlyphNameUndefined: Self = StObject.set(x, "glyphName", js.undefined)
    
    inline def setGlyphOrientationHorizontal(value: Double | String): Self = StObject.set(x, "glyphOrientationHorizontal", value.asInstanceOf[js.Any])
    
    inline def setGlyphOrientationHorizontalUndefined: Self = StObject.set(x, "glyphOrientationHorizontal", js.undefined)
    
    inline def setGlyphOrientationVertical(value: Double | String): Self = StObject.set(x, "glyphOrientationVertical", value.asInstanceOf[js.Any])
    
    inline def setGlyphOrientationVerticalUndefined: Self = StObject.set(x, "glyphOrientationVertical", js.undefined)
    
    inline def setGlyphRef(value: Double | String): Self = StObject.set(x, "glyphRef", value.asInstanceOf[js.Any])
    
    inline def setGlyphRefUndefined: Self = StObject.set(x, "glyphRef", js.undefined)
    
    inline def setGradientTransform(value: String): Self = StObject.set(x, "gradientTransform", value.asInstanceOf[js.Any])
    
    inline def setGradientTransformUndefined: Self = StObject.set(x, "gradientTransform", js.undefined)
    
    inline def setGradientUnits(value: String): Self = StObject.set(x, "gradientUnits", value.asInstanceOf[js.Any])
    
    inline def setGradientUnitsUndefined: Self = StObject.set(x, "gradientUnits", js.undefined)
    
    inline def setHanging(value: Double | String): Self = StObject.set(x, "hanging", value.asInstanceOf[js.Any])
    
    inline def setHangingUndefined: Self = StObject.set(x, "hanging", js.undefined)
    
    inline def setHeight(value: Double | String): Self = StObject.set(x, "height", value.asInstanceOf[js.Any])
    
    inline def setHeightUndefined: Self = StObject.set(x, "height", js.undefined)
    
    inline def setHorizAdvX(value: Double | String): Self = StObject.set(x, "horizAdvX", value.asInstanceOf[js.Any])
    
    inline def setHorizAdvXUndefined: Self = StObject.set(x, "horizAdvX", js.undefined)
    
    inline def setHorizOriginX(value: Double | String): Self = StObject.set(x, "horizOriginX", value.asInstanceOf[js.Any])
    
    inline def setHorizOriginXUndefined: Self = StObject.set(x, "horizOriginX", js.undefined)
    
    inline def setHref(value: String): Self = StObject.set(x, "href", value.asInstanceOf[js.Any])
    
    inline def setHrefUndefined: Self = StObject.set(x, "href", js.undefined)
    
    inline def setId(value: String): Self = StObject.set(x, "id", value.asInstanceOf[js.Any])
    
    inline def setIdUndefined: Self = StObject.set(x, "id", js.undefined)
    
    inline def setIdeographic(value: Double | String): Self = StObject.set(x, "ideographic", value.asInstanceOf[js.Any])
    
    inline def setIdeographicUndefined: Self = StObject.set(x, "ideographic", js.undefined)
    
    inline def setImageRendering(value: Double | String): Self = StObject.set(x, "imageRendering", value.asInstanceOf[js.Any])
    
    inline def setImageRenderingUndefined: Self = StObject.set(x, "imageRendering", js.undefined)
    
    inline def setIn(value: String): Self = StObject.set(x, "in", value.asInstanceOf[js.Any])
    
    inline def setIn2(value: Double | String): Self = StObject.set(x, "in2", value.asInstanceOf[js.Any])
    
    inline def setIn2Undefined: Self = StObject.set(x, "in2", js.undefined)
    
    inline def setInUndefined: Self = StObject.set(x, "in", js.undefined)
    
    inline def setIntercept(value: Double | String): Self = StObject.set(x, "intercept", value.asInstanceOf[js.Any])
    
    inline def setInterceptUndefined: Self = StObject.set(x, "intercept", js.undefined)
    
    inline def setK(value: Double | String): Self = StObject.set(x, "k", value.asInstanceOf[js.Any])
    
    inline def setK1(value: Double | String): Self = StObject.set(x, "k1", value.asInstanceOf[js.Any])
    
    inline def setK1Undefined: Self = StObject.set(x, "k1", js.undefined)
    
    inline def setK2(value: Double | String): Self = StObject.set(x, "k2", value.asInstanceOf[js.Any])
    
    inline def setK2Undefined: Self = StObject.set(x, "k2", js.undefined)
    
    inline def setK3(value: Double | String): Self = StObject.set(x, "k3", value.asInstanceOf[js.Any])
    
    inline def setK3Undefined: Self = StObject.set(x, "k3", js.undefined)
    
    inline def setK4(value: Double | String): Self = StObject.set(x, "k4", value.asInstanceOf[js.Any])
    
    inline def setK4Undefined: Self = StObject.set(x, "k4", js.undefined)
    
    inline def setKUndefined: Self = StObject.set(x, "k", js.undefined)
    
    inline def setKernelMatrix(value: Double | String): Self = StObject.set(x, "kernelMatrix", value.asInstanceOf[js.Any])
    
    inline def setKernelMatrixUndefined: Self = StObject.set(x, "kernelMatrix", js.undefined)
    
    inline def setKernelUnitLength(value: Double | String): Self = StObject.set(x, "kernelUnitLength", value.asInstanceOf[js.Any])
    
    inline def setKernelUnitLengthUndefined: Self = StObject.set(x, "kernelUnitLength", js.undefined)
    
    inline def setKerning(value: Double | String): Self = StObject.set(x, "kerning", value.asInstanceOf[js.Any])
    
    inline def setKerningUndefined: Self = StObject.set(x, "kerning", js.undefined)
    
    inline def setKeyPoints(value: Double | String): Self = StObject.set(x, "keyPoints", value.asInstanceOf[js.Any])
    
    inline def setKeyPointsUndefined: Self = StObject.set(x, "keyPoints", js.undefined)
    
    inline def setKeySplines(value: Double | String): Self = StObject.set(x, "keySplines", value.asInstanceOf[js.Any])
    
    inline def setKeySplinesUndefined: Self = StObject.set(x, "keySplines", js.undefined)
    
    inline def setKeyTimes(value: Double | String): Self = StObject.set(x, "keyTimes", value.asInstanceOf[js.Any])
    
    inline def setKeyTimesUndefined: Self = StObject.set(x, "keyTimes", js.undefined)
    
    inline def setLang(value: String): Self = StObject.set(x, "lang", value.asInstanceOf[js.Any])
    
    inline def setLangUndefined: Self = StObject.set(x, "lang", js.undefined)
    
    inline def setLengthAdjust(value: Double | String): Self = StObject.set(x, "lengthAdjust", value.asInstanceOf[js.Any])
    
    inline def setLengthAdjustUndefined: Self = StObject.set(x, "lengthAdjust", js.undefined)
    
    inline def setLetterSpacing(value: Double | String): Self = StObject.set(x, "letterSpacing", value.asInstanceOf[js.Any])
    
    inline def setLetterSpacingUndefined: Self = StObject.set(x, "letterSpacing", js.undefined)
    
    inline def setLightingColor(value: Double | String): Self = StObject.set(x, "lightingColor", value.asInstanceOf[js.Any])
    
    inline def setLightingColorUndefined: Self = StObject.set(x, "lightingColor", js.undefined)
    
    inline def setLimitingConeAngle(value: Double | String): Self = StObject.set(x, "limitingConeAngle", value.asInstanceOf[js.Any])
    
    inline def setLimitingConeAngleUndefined: Self = StObject.set(x, "limitingConeAngle", js.undefined)
    
    inline def setLocal(value: Double | String): Self = StObject.set(x, "local", value.asInstanceOf[js.Any])
    
    inline def setLocalUndefined: Self = StObject.set(x, "local", js.undefined)
    
    inline def setMarkerEnd(value: String): Self = StObject.set(x, "markerEnd", value.asInstanceOf[js.Any])
    
    inline def setMarkerEndUndefined: Self = StObject.set(x, "markerEnd", js.undefined)
    
    inline def setMarkerHeight(value: Double | String): Self = StObject.set(x, "markerHeight", value.asInstanceOf[js.Any])
    
    inline def setMarkerHeightUndefined: Self = StObject.set(x, "markerHeight", js.undefined)
    
    inline def setMarkerMid(value: String): Self = StObject.set(x, "markerMid", value.asInstanceOf[js.Any])
    
    inline def setMarkerMidUndefined: Self = StObject.set(x, "markerMid", js.undefined)
    
    inline def setMarkerStart(value: String): Self = StObject.set(x, "markerStart", value.asInstanceOf[js.Any])
    
    inline def setMarkerStartUndefined: Self = StObject.set(x, "markerStart", js.undefined)
    
    inline def setMarkerUnits(value: Double | String): Self = StObject.set(x, "markerUnits", value.asInstanceOf[js.Any])
    
    inline def setMarkerUnitsUndefined: Self = StObject.set(x, "markerUnits", js.undefined)
    
    inline def setMarkerWidth(value: Double | String): Self = StObject.set(x, "markerWidth", value.asInstanceOf[js.Any])
    
    inline def setMarkerWidthUndefined: Self = StObject.set(x, "markerWidth", js.undefined)
    
    inline def setMask(value: String): Self = StObject.set(x, "mask", value.asInstanceOf[js.Any])
    
    inline def setMaskContentUnits(value: Double | String): Self = StObject.set(x, "maskContentUnits", value.asInstanceOf[js.Any])
    
    inline def setMaskContentUnitsUndefined: Self = StObject.set(x, "maskContentUnits", js.undefined)
    
    inline def setMaskUndefined: Self = StObject.set(x, "mask", js.undefined)
    
    inline def setMaskUnits(value: Double | String): Self = StObject.set(x, "maskUnits", value.asInstanceOf[js.Any])
    
    inline def setMaskUnitsUndefined: Self = StObject.set(x, "maskUnits", js.undefined)
    
    inline def setMathematical(value: Double | String): Self = StObject.set(x, "mathematical", value.asInstanceOf[js.Any])
    
    inline def setMathematicalUndefined: Self = StObject.set(x, "mathematical", js.undefined)
    
    inline def setMax(value: Double | String): Self = StObject.set(x, "max", value.asInstanceOf[js.Any])
    
    inline def setMaxUndefined: Self = StObject.set(x, "max", js.undefined)
    
    inline def setMedia(value: String): Self = StObject.set(x, "media", value.asInstanceOf[js.Any])
    
    inline def setMediaUndefined: Self = StObject.set(x, "media", js.undefined)
    
    inline def setMethod(value: String): Self = StObject.set(x, "method", value.asInstanceOf[js.Any])
    
    inline def setMethodUndefined: Self = StObject.set(x, "method", js.undefined)
    
    inline def setMin(value: Double | String): Self = StObject.set(x, "min", value.asInstanceOf[js.Any])
    
    inline def setMinUndefined: Self = StObject.set(x, "min", js.undefined)
    
    inline def setMode(value: Double | String): Self = StObject.set(x, "mode", value.asInstanceOf[js.Any])
    
    inline def setModeUndefined: Self = StObject.set(x, "mode", js.undefined)
    
    inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
    
    inline def setNameUndefined: Self = StObject.set(x, "name", js.undefined)
    
    inline def setNumOctaves(value: Double | String): Self = StObject.set(x, "numOctaves", value.asInstanceOf[js.Any])
    
    inline def setNumOctavesUndefined: Self = StObject.set(x, "numOctaves", js.undefined)
    
    inline def setOffset(value: Double | String): Self = StObject.set(x, "offset", value.asInstanceOf[js.Any])
    
    inline def setOffsetUndefined: Self = StObject.set(x, "offset", js.undefined)
    
    inline def setOpacity(value: Double | String): Self = StObject.set(x, "opacity", value.asInstanceOf[js.Any])
    
    inline def setOpacityUndefined: Self = StObject.set(x, "opacity", js.undefined)
    
    inline def setOperator(value: Double | String): Self = StObject.set(x, "operator", value.asInstanceOf[js.Any])
    
    inline def setOperatorUndefined: Self = StObject.set(x, "operator", js.undefined)
    
    inline def setOrder(value: Double | String): Self = StObject.set(x, "order", value.asInstanceOf[js.Any])
    
    inline def setOrderUndefined: Self = StObject.set(x, "order", js.undefined)
    
    inline def setOrient(value: Double | String): Self = StObject.set(x, "orient", value.asInstanceOf[js.Any])
    
    inline def setOrientUndefined: Self = StObject.set(x, "orient", js.undefined)
    
    inline def setOrientation(value: Double | String): Self = StObject.set(x, "orientation", value.asInstanceOf[js.Any])
    
    inline def setOrientationUndefined: Self = StObject.set(x, "orientation", js.undefined)
    
    inline def setOrigin(value: Double | String): Self = StObject.set(x, "origin", value.asInstanceOf[js.Any])
    
    inline def setOriginUndefined: Self = StObject.set(x, "origin", js.undefined)
    
    inline def setOverflow(value: Double | String): Self = StObject.set(x, "overflow", value.asInstanceOf[js.Any])
    
    inline def setOverflowUndefined: Self = StObject.set(x, "overflow", js.undefined)
    
    inline def setOverlinePosition(value: Double | String): Self = StObject.set(x, "overlinePosition", value.asInstanceOf[js.Any])
    
    inline def setOverlinePositionUndefined: Self = StObject.set(x, "overlinePosition", js.undefined)
    
    inline def setOverlineThickness(value: Double | String): Self = StObject.set(x, "overlineThickness", value.asInstanceOf[js.Any])
    
    inline def setOverlineThicknessUndefined: Self = StObject.set(x, "overlineThickness", js.undefined)
    
    inline def setPaintOrder(value: Double | String): Self = StObject.set(x, "paintOrder", value.asInstanceOf[js.Any])
    
    inline def setPaintOrderUndefined: Self = StObject.set(x, "paintOrder", js.undefined)
    
    inline def setPanose1(value: Double | String): Self = StObject.set(x, "panose1", value.asInstanceOf[js.Any])
    
    inline def setPanose1Undefined: Self = StObject.set(x, "panose1", js.undefined)
    
    inline def setPathLength(value: Double | String): Self = StObject.set(x, "pathLength", value.asInstanceOf[js.Any])
    
    inline def setPathLengthUndefined: Self = StObject.set(x, "pathLength", js.undefined)
    
    inline def setPatternContentUnits(value: String): Self = StObject.set(x, "patternContentUnits", value.asInstanceOf[js.Any])
    
    inline def setPatternContentUnitsUndefined: Self = StObject.set(x, "patternContentUnits", js.undefined)
    
    inline def setPatternTransform(value: Double | String): Self = StObject.set(x, "patternTransform", value.asInstanceOf[js.Any])
    
    inline def setPatternTransformUndefined: Self = StObject.set(x, "patternTransform", js.undefined)
    
    inline def setPatternUnits(value: String): Self = StObject.set(x, "patternUnits", value.asInstanceOf[js.Any])
    
    inline def setPatternUnitsUndefined: Self = StObject.set(x, "patternUnits", js.undefined)
    
    inline def setPointerEvents(value: Double | String): Self = StObject.set(x, "pointerEvents", value.asInstanceOf[js.Any])
    
    inline def setPointerEventsUndefined: Self = StObject.set(x, "pointerEvents", js.undefined)
    
    inline def setPoints(value: String): Self = StObject.set(x, "points", value.asInstanceOf[js.Any])
    
    inline def setPointsAtX(value: Double | String): Self = StObject.set(x, "pointsAtX", value.asInstanceOf[js.Any])
    
    inline def setPointsAtXUndefined: Self = StObject.set(x, "pointsAtX", js.undefined)
    
    inline def setPointsAtY(value: Double | String): Self = StObject.set(x, "pointsAtY", value.asInstanceOf[js.Any])
    
    inline def setPointsAtYUndefined: Self = StObject.set(x, "pointsAtY", js.undefined)
    
    inline def setPointsAtZ(value: Double | String): Self = StObject.set(x, "pointsAtZ", value.asInstanceOf[js.Any])
    
    inline def setPointsAtZUndefined: Self = StObject.set(x, "pointsAtZ", js.undefined)
    
    inline def setPointsUndefined: Self = StObject.set(x, "points", js.undefined)
    
    inline def setPreserveAlpha(value: Double | String): Self = StObject.set(x, "preserveAlpha", value.asInstanceOf[js.Any])
    
    inline def setPreserveAlphaUndefined: Self = StObject.set(x, "preserveAlpha", js.undefined)
    
    inline def setPreserveAspectRatio(value: String): Self = StObject.set(x, "preserveAspectRatio", value.asInstanceOf[js.Any])
    
    inline def setPreserveAspectRatioUndefined: Self = StObject.set(x, "preserveAspectRatio", js.undefined)
    
    inline def setPrimitiveUnits(value: Double | String): Self = StObject.set(x, "primitiveUnits", value.asInstanceOf[js.Any])
    
    inline def setPrimitiveUnitsUndefined: Self = StObject.set(x, "primitiveUnits", js.undefined)
    
    inline def setR(value: Double | String): Self = StObject.set(x, "r", value.asInstanceOf[js.Any])
    
    inline def setRUndefined: Self = StObject.set(x, "r", js.undefined)
    
    inline def setRadius(value: Double | String): Self = StObject.set(x, "radius", value.asInstanceOf[js.Any])
    
    inline def setRadiusUndefined: Self = StObject.set(x, "radius", js.undefined)
    
    inline def setRefX(value: Double | String): Self = StObject.set(x, "refX", value.asInstanceOf[js.Any])
    
    inline def setRefXUndefined: Self = StObject.set(x, "refX", js.undefined)
    
    inline def setRefY(value: Double | String): Self = StObject.set(x, "refY", value.asInstanceOf[js.Any])
    
    inline def setRefYUndefined: Self = StObject.set(x, "refY", js.undefined)
    
    inline def setRenderingIntent(value: Double | String): Self = StObject.set(x, "renderingIntent", value.asInstanceOf[js.Any])
    
    inline def setRenderingIntentUndefined: Self = StObject.set(x, "renderingIntent", js.undefined)
    
    inline def setRepeatCount(value: Double | String): Self = StObject.set(x, "repeatCount", value.asInstanceOf[js.Any])
    
    inline def setRepeatCountUndefined: Self = StObject.set(x, "repeatCount", js.undefined)
    
    inline def setRepeatDur(value: Double | String): Self = StObject.set(x, "repeatDur", value.asInstanceOf[js.Any])
    
    inline def setRepeatDurUndefined: Self = StObject.set(x, "repeatDur", js.undefined)
    
    inline def setRequiredExtensions(value: Double | String): Self = StObject.set(x, "requiredExtensions", value.asInstanceOf[js.Any])
    
    inline def setRequiredExtensionsUndefined: Self = StObject.set(x, "requiredExtensions", js.undefined)
    
    inline def setRequiredFeatures(value: Double | String): Self = StObject.set(x, "requiredFeatures", value.asInstanceOf[js.Any])
    
    inline def setRequiredFeaturesUndefined: Self = StObject.set(x, "requiredFeatures", js.undefined)
    
    inline def setRestart(value: Double | String): Self = StObject.set(x, "restart", value.asInstanceOf[js.Any])
    
    inline def setRestartUndefined: Self = StObject.set(x, "restart", js.undefined)
    
    inline def setResult(value: String): Self = StObject.set(x, "result", value.asInstanceOf[js.Any])
    
    inline def setResultUndefined: Self = StObject.set(x, "result", js.undefined)
    
    inline def setRole(value: String): Self = StObject.set(x, "role", value.asInstanceOf[js.Any])
    
    inline def setRoleUndefined: Self = StObject.set(x, "role", js.undefined)
    
    inline def setRotate(value: Double | String): Self = StObject.set(x, "rotate", value.asInstanceOf[js.Any])
    
    inline def setRotateUndefined: Self = StObject.set(x, "rotate", js.undefined)
    
    inline def setRx(value: Double | String): Self = StObject.set(x, "rx", value.asInstanceOf[js.Any])
    
    inline def setRxUndefined: Self = StObject.set(x, "rx", js.undefined)
    
    inline def setRy(value: Double | String): Self = StObject.set(x, "ry", value.asInstanceOf[js.Any])
    
    inline def setRyUndefined: Self = StObject.set(x, "ry", js.undefined)
    
    inline def setScale(value: Double | String): Self = StObject.set(x, "scale", value.asInstanceOf[js.Any])
    
    inline def setScaleUndefined: Self = StObject.set(x, "scale", js.undefined)
    
    inline def setSeed(value: Double | String): Self = StObject.set(x, "seed", value.asInstanceOf[js.Any])
    
    inline def setSeedUndefined: Self = StObject.set(x, "seed", js.undefined)
    
    inline def setShapeRendering(value: Double | String): Self = StObject.set(x, "shapeRendering", value.asInstanceOf[js.Any])
    
    inline def setShapeRenderingUndefined: Self = StObject.set(x, "shapeRendering", js.undefined)
    
    inline def setSlope(value: Double | String): Self = StObject.set(x, "slope", value.asInstanceOf[js.Any])
    
    inline def setSlopeUndefined: Self = StObject.set(x, "slope", js.undefined)
    
    inline def setSpacing(value: Double | String): Self = StObject.set(x, "spacing", value.asInstanceOf[js.Any])
    
    inline def setSpacingUndefined: Self = StObject.set(x, "spacing", js.undefined)
    
    inline def setSpecularConstant(value: Double | String): Self = StObject.set(x, "specularConstant", value.asInstanceOf[js.Any])
    
    inline def setSpecularConstantUndefined: Self = StObject.set(x, "specularConstant", js.undefined)
    
    inline def setSpecularExponent(value: Double | String): Self = StObject.set(x, "specularExponent", value.asInstanceOf[js.Any])
    
    inline def setSpecularExponentUndefined: Self = StObject.set(x, "specularExponent", js.undefined)
    
    inline def setSpeed(value: Double | String): Self = StObject.set(x, "speed", value.asInstanceOf[js.Any])
    
    inline def setSpeedUndefined: Self = StObject.set(x, "speed", js.undefined)
    
    inline def setSpreadMethod(value: String): Self = StObject.set(x, "spreadMethod", value.asInstanceOf[js.Any])
    
    inline def setSpreadMethodUndefined: Self = StObject.set(x, "spreadMethod", js.undefined)
    
    inline def setStartOffset(value: Double | String): Self = StObject.set(x, "startOffset", value.asInstanceOf[js.Any])
    
    inline def setStartOffsetUndefined: Self = StObject.set(x, "startOffset", js.undefined)
    
    inline def setStdDeviation(value: Double | String): Self = StObject.set(x, "stdDeviation", value.asInstanceOf[js.Any])
    
    inline def setStdDeviationUndefined: Self = StObject.set(x, "stdDeviation", js.undefined)
    
    inline def setStemh(value: Double | String): Self = StObject.set(x, "stemh", value.asInstanceOf[js.Any])
    
    inline def setStemhUndefined: Self = StObject.set(x, "stemh", js.undefined)
    
    inline def setStemv(value: Double | String): Self = StObject.set(x, "stemv", value.asInstanceOf[js.Any])
    
    inline def setStemvUndefined: Self = StObject.set(x, "stemv", js.undefined)
    
    inline def setStitchTiles(value: Double | String): Self = StObject.set(x, "stitchTiles", value.asInstanceOf[js.Any])
    
    inline def setStitchTilesUndefined: Self = StObject.set(x, "stitchTiles", js.undefined)
    
    inline def setStopColor(value: String): Self = StObject.set(x, "stopColor", value.asInstanceOf[js.Any])
    
    inline def setStopColorUndefined: Self = StObject.set(x, "stopColor", js.undefined)
    
    inline def setStopOpacity(value: Double | String): Self = StObject.set(x, "stopOpacity", value.asInstanceOf[js.Any])
    
    inline def setStopOpacityUndefined: Self = StObject.set(x, "stopOpacity", js.undefined)
    
    inline def setStrikethroughPosition(value: Double | String): Self = StObject.set(x, "strikethroughPosition", value.asInstanceOf[js.Any])
    
    inline def setStrikethroughPositionUndefined: Self = StObject.set(x, "strikethroughPosition", js.undefined)
    
    inline def setStrikethroughThickness(value: Double | String): Self = StObject.set(x, "strikethroughThickness", value.asInstanceOf[js.Any])
    
    inline def setStrikethroughThicknessUndefined: Self = StObject.set(x, "strikethroughThickness", js.undefined)
    
    inline def setString(value: Double | String): Self = StObject.set(x, "string", value.asInstanceOf[js.Any])
    
    inline def setStringUndefined: Self = StObject.set(x, "string", js.undefined)
    
    inline def setStroke(value: String): Self = StObject.set(x, "stroke", value.asInstanceOf[js.Any])
    
    inline def setStrokeDasharray(value: String | Double): Self = StObject.set(x, "strokeDasharray", value.asInstanceOf[js.Any])
    
    inline def setStrokeDasharrayUndefined: Self = StObject.set(x, "strokeDasharray", js.undefined)
    
    inline def setStrokeDashoffset(value: String | Double): Self = StObject.set(x, "strokeDashoffset", value.asInstanceOf[js.Any])
    
    inline def setStrokeDashoffsetUndefined: Self = StObject.set(x, "strokeDashoffset", js.undefined)
    
    inline def setStrokeLinecap(value: butt | round | square | inherit): Self = StObject.set(x, "strokeLinecap", value.asInstanceOf[js.Any])
    
    inline def setStrokeLinecapUndefined: Self = StObject.set(x, "strokeLinecap", js.undefined)
    
    inline def setStrokeLinejoin(value: miter | round | bevel | inherit): Self = StObject.set(x, "strokeLinejoin", value.asInstanceOf[js.Any])
    
    inline def setStrokeLinejoinUndefined: Self = StObject.set(x, "strokeLinejoin", js.undefined)
    
    inline def setStrokeMiterlimit(value: Double | String): Self = StObject.set(x, "strokeMiterlimit", value.asInstanceOf[js.Any])
    
    inline def setStrokeMiterlimitUndefined: Self = StObject.set(x, "strokeMiterlimit", js.undefined)
    
    inline def setStrokeOpacity(value: Double | String): Self = StObject.set(x, "strokeOpacity", value.asInstanceOf[js.Any])
    
    inline def setStrokeOpacityUndefined: Self = StObject.set(x, "strokeOpacity", js.undefined)
    
    inline def setStrokeUndefined: Self = StObject.set(x, "stroke", js.undefined)
    
    inline def setStrokeWidth(value: Double | String): Self = StObject.set(x, "strokeWidth", value.asInstanceOf[js.Any])
    
    inline def setStrokeWidthUndefined: Self = StObject.set(x, "strokeWidth", js.undefined)
    
    inline def setStyle(value: CSSProperties): Self = StObject.set(x, "style", value.asInstanceOf[js.Any])
    
    inline def setStyleUndefined: Self = StObject.set(x, "style", js.undefined)
    
    inline def setSurfaceScale(value: Double | String): Self = StObject.set(x, "surfaceScale", value.asInstanceOf[js.Any])
    
    inline def setSurfaceScaleUndefined: Self = StObject.set(x, "surfaceScale", js.undefined)
    
    inline def setSystemLanguage(value: Double | String): Self = StObject.set(x, "systemLanguage", value.asInstanceOf[js.Any])
    
    inline def setSystemLanguageUndefined: Self = StObject.set(x, "systemLanguage", js.undefined)
    
    inline def setTabIndex(value: Double): Self = StObject.set(x, "tabIndex", value.asInstanceOf[js.Any])
    
    inline def setTabIndexUndefined: Self = StObject.set(x, "tabIndex", js.undefined)
    
    inline def setTableValues(value: Double | String): Self = StObject.set(x, "tableValues", value.asInstanceOf[js.Any])
    
    inline def setTableValuesUndefined: Self = StObject.set(x, "tableValues", js.undefined)
    
    inline def setTarget(value: String): Self = StObject.set(x, "target", value.asInstanceOf[js.Any])
    
    inline def setTargetUndefined: Self = StObject.set(x, "target", js.undefined)
    
    inline def setTargetX(value: Double | String): Self = StObject.set(x, "targetX", value.asInstanceOf[js.Any])
    
    inline def setTargetXUndefined: Self = StObject.set(x, "targetX", js.undefined)
    
    inline def setTargetY(value: Double | String): Self = StObject.set(x, "targetY", value.asInstanceOf[js.Any])
    
    inline def setTargetYUndefined: Self = StObject.set(x, "targetY", js.undefined)
    
    inline def setTextAnchor(value: String): Self = StObject.set(x, "textAnchor", value.asInstanceOf[js.Any])
    
    inline def setTextAnchorUndefined: Self = StObject.set(x, "textAnchor", js.undefined)
    
    inline def setTextDecoration(value: Double | String): Self = StObject.set(x, "textDecoration", value.asInstanceOf[js.Any])
    
    inline def setTextDecorationUndefined: Self = StObject.set(x, "textDecoration", js.undefined)
    
    inline def setTextLength(value: Double | String): Self = StObject.set(x, "textLength", value.asInstanceOf[js.Any])
    
    inline def setTextLengthUndefined: Self = StObject.set(x, "textLength", js.undefined)
    
    inline def setTextRendering(value: Double | String): Self = StObject.set(x, "textRendering", value.asInstanceOf[js.Any])
    
    inline def setTextRenderingUndefined: Self = StObject.set(x, "textRendering", js.undefined)
    
    inline def setTo(value: Double | String): Self = StObject.set(x, "to", value.asInstanceOf[js.Any])
    
    inline def setToUndefined: Self = StObject.set(x, "to", js.undefined)
    
    inline def setTransform(value: String): Self = StObject.set(x, "transform", value.asInstanceOf[js.Any])
    
    inline def setTransformUndefined: Self = StObject.set(x, "transform", js.undefined)
    
    inline def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    
    inline def setTypeUndefined: Self = StObject.set(x, "type", js.undefined)
    
    inline def setU1(value: Double | String): Self = StObject.set(x, "u1", value.asInstanceOf[js.Any])
    
    inline def setU1Undefined: Self = StObject.set(x, "u1", js.undefined)
    
    inline def setU2(value: Double | String): Self = StObject.set(x, "u2", value.asInstanceOf[js.Any])
    
    inline def setU2Undefined: Self = StObject.set(x, "u2", js.undefined)
    
    inline def setUnderlinePosition(value: Double | String): Self = StObject.set(x, "underlinePosition", value.asInstanceOf[js.Any])
    
    inline def setUnderlinePositionUndefined: Self = StObject.set(x, "underlinePosition", js.undefined)
    
    inline def setUnderlineThickness(value: Double | String): Self = StObject.set(x, "underlineThickness", value.asInstanceOf[js.Any])
    
    inline def setUnderlineThicknessUndefined: Self = StObject.set(x, "underlineThickness", js.undefined)
    
    inline def setUnicode(value: Double | String): Self = StObject.set(x, "unicode", value.asInstanceOf[js.Any])
    
    inline def setUnicodeBidi(value: Double | String): Self = StObject.set(x, "unicodeBidi", value.asInstanceOf[js.Any])
    
    inline def setUnicodeBidiUndefined: Self = StObject.set(x, "unicodeBidi", js.undefined)
    
    inline def setUnicodeRange(value: Double | String): Self = StObject.set(x, "unicodeRange", value.asInstanceOf[js.Any])
    
    inline def setUnicodeRangeUndefined: Self = StObject.set(x, "unicodeRange", js.undefined)
    
    inline def setUnicodeUndefined: Self = StObject.set(x, "unicode", js.undefined)
    
    inline def setUnitsPerEm(value: Double | String): Self = StObject.set(x, "unitsPerEm", value.asInstanceOf[js.Any])
    
    inline def setUnitsPerEmUndefined: Self = StObject.set(x, "unitsPerEm", js.undefined)
    
    inline def setVAlphabetic(value: Double | String): Self = StObject.set(x, "vAlphabetic", value.asInstanceOf[js.Any])
    
    inline def setVAlphabeticUndefined: Self = StObject.set(x, "vAlphabetic", js.undefined)
    
    inline def setVHanging(value: Double | String): Self = StObject.set(x, "vHanging", value.asInstanceOf[js.Any])
    
    inline def setVHangingUndefined: Self = StObject.set(x, "vHanging", js.undefined)
    
    inline def setVIdeographic(value: Double | String): Self = StObject.set(x, "vIdeographic", value.asInstanceOf[js.Any])
    
    inline def setVIdeographicUndefined: Self = StObject.set(x, "vIdeographic", js.undefined)
    
    inline def setVMathematical(value: Double | String): Self = StObject.set(x, "vMathematical", value.asInstanceOf[js.Any])
    
    inline def setVMathematicalUndefined: Self = StObject.set(x, "vMathematical", js.undefined)
    
    inline def setValues(value: String): Self = StObject.set(x, "values", value.asInstanceOf[js.Any])
    
    inline def setValuesUndefined: Self = StObject.set(x, "values", js.undefined)
    
    inline def setVectorEffect(value: Double | String): Self = StObject.set(x, "vectorEffect", value.asInstanceOf[js.Any])
    
    inline def setVectorEffectUndefined: Self = StObject.set(x, "vectorEffect", js.undefined)
    
    inline def setVersion(value: String): Self = StObject.set(x, "version", value.asInstanceOf[js.Any])
    
    inline def setVersionUndefined: Self = StObject.set(x, "version", js.undefined)
    
    inline def setVertAdvY(value: Double | String): Self = StObject.set(x, "vertAdvY", value.asInstanceOf[js.Any])
    
    inline def setVertAdvYUndefined: Self = StObject.set(x, "vertAdvY", js.undefined)
    
    inline def setVertOriginX(value: Double | String): Self = StObject.set(x, "vertOriginX", value.asInstanceOf[js.Any])
    
    inline def setVertOriginXUndefined: Self = StObject.set(x, "vertOriginX", js.undefined)
    
    inline def setVertOriginY(value: Double | String): Self = StObject.set(x, "vertOriginY", value.asInstanceOf[js.Any])
    
    inline def setVertOriginYUndefined: Self = StObject.set(x, "vertOriginY", js.undefined)
    
    inline def setViewBox(value: String): Self = StObject.set(x, "viewBox", value.asInstanceOf[js.Any])
    
    inline def setViewBoxUndefined: Self = StObject.set(x, "viewBox", js.undefined)
    
    inline def setViewTarget(value: Double | String): Self = StObject.set(x, "viewTarget", value.asInstanceOf[js.Any])
    
    inline def setViewTargetUndefined: Self = StObject.set(x, "viewTarget", js.undefined)
    
    inline def setVisibility(value: Double | String): Self = StObject.set(x, "visibility", value.asInstanceOf[js.Any])
    
    inline def setVisibilityUndefined: Self = StObject.set(x, "visibility", js.undefined)
    
    inline def setWidth(value: Double | String): Self = StObject.set(x, "width", value.asInstanceOf[js.Any])
    
    inline def setWidthUndefined: Self = StObject.set(x, "width", js.undefined)
    
    inline def setWidths(value: Double | String): Self = StObject.set(x, "widths", value.asInstanceOf[js.Any])
    
    inline def setWidthsUndefined: Self = StObject.set(x, "widths", js.undefined)
    
    inline def setWordSpacing(value: Double | String): Self = StObject.set(x, "wordSpacing", value.asInstanceOf[js.Any])
    
    inline def setWordSpacingUndefined: Self = StObject.set(x, "wordSpacing", js.undefined)
    
    inline def setWritingMode(value: Double | String): Self = StObject.set(x, "writingMode", value.asInstanceOf[js.Any])
    
    inline def setWritingModeUndefined: Self = StObject.set(x, "writingMode", js.undefined)
    
    inline def setX(value: Double | String): Self = StObject.set(x, "x", value.asInstanceOf[js.Any])
    
    inline def setX1(value: Double | String): Self = StObject.set(x, "x1", value.asInstanceOf[js.Any])
    
    inline def setX1Undefined: Self = StObject.set(x, "x1", js.undefined)
    
    inline def setX2(value: Double | String): Self = StObject.set(x, "x2", value.asInstanceOf[js.Any])
    
    inline def setX2Undefined: Self = StObject.set(x, "x2", js.undefined)
    
    inline def setXChannelSelector(value: String): Self = StObject.set(x, "xChannelSelector", value.asInstanceOf[js.Any])
    
    inline def setXChannelSelectorUndefined: Self = StObject.set(x, "xChannelSelector", js.undefined)
    
    inline def setXHeight(value: Double | String): Self = StObject.set(x, "xHeight", value.asInstanceOf[js.Any])
    
    inline def setXHeightUndefined: Self = StObject.set(x, "xHeight", js.undefined)
    
    inline def setXUndefined: Self = StObject.set(x, "x", js.undefined)
    
    inline def setXlinkActuate(value: String): Self = StObject.set(x, "xlinkActuate", value.asInstanceOf[js.Any])
    
    inline def setXlinkActuateUndefined: Self = StObject.set(x, "xlinkActuate", js.undefined)
    
    inline def setXlinkArcrole(value: String): Self = StObject.set(x, "xlinkArcrole", value.asInstanceOf[js.Any])
    
    inline def setXlinkArcroleUndefined: Self = StObject.set(x, "xlinkArcrole", js.undefined)
    
    inline def setXlinkHref(value: String): Self = StObject.set(x, "xlinkHref", value.asInstanceOf[js.Any])
    
    inline def setXlinkHrefUndefined: Self = StObject.set(x, "xlinkHref", js.undefined)
    
    inline def setXlinkRole(value: String): Self = StObject.set(x, "xlinkRole", value.asInstanceOf[js.Any])
    
    inline def setXlinkRoleUndefined: Self = StObject.set(x, "xlinkRole", js.undefined)
    
    inline def setXlinkShow(value: String): Self = StObject.set(x, "xlinkShow", value.asInstanceOf[js.Any])
    
    inline def setXlinkShowUndefined: Self = StObject.set(x, "xlinkShow", js.undefined)
    
    inline def setXlinkTitle(value: String): Self = StObject.set(x, "xlinkTitle", value.asInstanceOf[js.Any])
    
    inline def setXlinkTitleUndefined: Self = StObject.set(x, "xlinkTitle", js.undefined)
    
    inline def setXlinkType(value: String): Self = StObject.set(x, "xlinkType", value.asInstanceOf[js.Any])
    
    inline def setXlinkTypeUndefined: Self = StObject.set(x, "xlinkType", js.undefined)
    
    inline def setXmlBase(value: String): Self = StObject.set(x, "xmlBase", value.asInstanceOf[js.Any])
    
    inline def setXmlBaseUndefined: Self = StObject.set(x, "xmlBase", js.undefined)
    
    inline def setXmlLang(value: String): Self = StObject.set(x, "xmlLang", value.asInstanceOf[js.Any])
    
    inline def setXmlLangUndefined: Self = StObject.set(x, "xmlLang", js.undefined)
    
    inline def setXmlSpace(value: String): Self = StObject.set(x, "xmlSpace", value.asInstanceOf[js.Any])
    
    inline def setXmlSpaceUndefined: Self = StObject.set(x, "xmlSpace", js.undefined)
    
    inline def setXmlns(value: String): Self = StObject.set(x, "xmlns", value.asInstanceOf[js.Any])
    
    inline def setXmlnsUndefined: Self = StObject.set(x, "xmlns", js.undefined)
    
    inline def setXmlnsXlink(value: String): Self = StObject.set(x, "xmlnsXlink", value.asInstanceOf[js.Any])
    
    inline def setXmlnsXlinkUndefined: Self = StObject.set(x, "xmlnsXlink", js.undefined)
    
    inline def setY(value: Double | String): Self = StObject.set(x, "y", value.asInstanceOf[js.Any])
    
    inline def setY1(value: Double | String): Self = StObject.set(x, "y1", value.asInstanceOf[js.Any])
    
    inline def setY1Undefined: Self = StObject.set(x, "y1", js.undefined)
    
    inline def setY2(value: Double | String): Self = StObject.set(x, "y2", value.asInstanceOf[js.Any])
    
    inline def setY2Undefined: Self = StObject.set(x, "y2", js.undefined)
    
    inline def setYChannelSelector(value: String): Self = StObject.set(x, "yChannelSelector", value.asInstanceOf[js.Any])
    
    inline def setYChannelSelectorUndefined: Self = StObject.set(x, "yChannelSelector", js.undefined)
    
    inline def setYUndefined: Self = StObject.set(x, "y", js.undefined)
    
    inline def setZ(value: Double | String): Self = StObject.set(x, "z", value.asInstanceOf[js.Any])
    
    inline def setZUndefined: Self = StObject.set(x, "z", js.undefined)
    
    inline def setZoomAndPan(value: String): Self = StObject.set(x, "zoomAndPan", value.asInstanceOf[js.Any])
    
    inline def setZoomAndPanUndefined: Self = StObject.set(x, "zoomAndPan", js.undefined)
  }
}

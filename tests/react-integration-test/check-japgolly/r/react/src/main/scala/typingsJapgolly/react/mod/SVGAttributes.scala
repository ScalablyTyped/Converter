package typingsJapgolly.react.mod

import typingsJapgolly.react.reactStrings.`after-edge`
import typingsJapgolly.react.reactStrings.`before-edge`
import typingsJapgolly.react.reactStrings.`text-after-edge`
import typingsJapgolly.react.reactStrings.`text-before-edge`
import typingsJapgolly.react.reactStrings.alphabetic
import typingsJapgolly.react.reactStrings.auto
import typingsJapgolly.react.reactStrings.baseline
import typingsJapgolly.react.reactStrings.bevel
import typingsJapgolly.react.reactStrings.butt
import typingsJapgolly.react.reactStrings.central
import typingsJapgolly.react.reactStrings.evenodd
import typingsJapgolly.react.reactStrings.hanging
import typingsJapgolly.react.reactStrings.ideographic
import typingsJapgolly.react.reactStrings.inherit
import typingsJapgolly.react.reactStrings.initial
import typingsJapgolly.react.reactStrings.isolated
import typingsJapgolly.react.reactStrings.linearRGB
import typingsJapgolly.react.reactStrings.mathematical
import typingsJapgolly.react.reactStrings.medial
import typingsJapgolly.react.reactStrings.middle
import typingsJapgolly.react.reactStrings.miter
import typingsJapgolly.react.reactStrings.no
import typingsJapgolly.react.reactStrings.none
import typingsJapgolly.react.reactStrings.nonzero
import typingsJapgolly.react.reactStrings.replace
import typingsJapgolly.react.reactStrings.round
import typingsJapgolly.react.reactStrings.sRGB
import typingsJapgolly.react.reactStrings.square
import typingsJapgolly.react.reactStrings.sum
import typingsJapgolly.react.reactStrings.terminal
import typingsJapgolly.react.reactStrings.yes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// this list is "complete" in that it contains every SVG attribute
// that React supports, but the types can be improved.
// Full list here: https://facebook.github.io/react/docs/dom-elements.html
//
// The three broad type categories are (in order of restrictiveness):
//   - "number | string"
//   - "string"
//   - union of string literals
@js.native
trait SVGAttributes[T]
  extends AriaAttributes
     with DOMAttributes[T] {
  // SVG Specific attributes
  var accentHeight: js.UndefOr[Double | String] = js.native
  var accumulate: js.UndefOr[none | sum] = js.native
  var additive: js.UndefOr[replace | sum] = js.native
  var alignmentBaseline: js.UndefOr[
    auto | baseline | `before-edge` | `text-before-edge` | middle | central | `after-edge` | `text-after-edge` | ideographic | alphabetic | hanging | mathematical | inherit
  ] = js.native
  var allowReorder: js.UndefOr[no | yes] = js.native
  var alphabetic: js.UndefOr[Double | String] = js.native
  var amplitude: js.UndefOr[Double | String] = js.native
  var arabicForm: js.UndefOr[initial | medial | terminal | isolated] = js.native
  var ascent: js.UndefOr[Double | String] = js.native
  var attributeName: js.UndefOr[String] = js.native
  var attributeType: js.UndefOr[String] = js.native
  var autoReverse: js.UndefOr[Double | String] = js.native
  var azimuth: js.UndefOr[Double | String] = js.native
  var baseFrequency: js.UndefOr[Double | String] = js.native
  var baseProfile: js.UndefOr[Double | String] = js.native
  var baselineShift: js.UndefOr[Double | String] = js.native
  var bbox: js.UndefOr[Double | String] = js.native
  var begin: js.UndefOr[Double | String] = js.native
  var bias: js.UndefOr[Double | String] = js.native
  var by: js.UndefOr[Double | String] = js.native
  var calcMode: js.UndefOr[Double | String] = js.native
  var capHeight: js.UndefOr[Double | String] = js.native
  // Attributes which also defined in HTMLAttributes
  // See comment in SVGDOMPropertyConfig.js
  var className: js.UndefOr[String] = js.native
  var clip: js.UndefOr[Double | String] = js.native
  var clipPath: js.UndefOr[String] = js.native
  var clipPathUnits: js.UndefOr[Double | String] = js.native
  var clipRule: js.UndefOr[Double | String] = js.native
  var color: js.UndefOr[String] = js.native
  var colorInterpolation: js.UndefOr[Double | String] = js.native
  var colorInterpolationFilters: js.UndefOr[auto | sRGB | linearRGB | inherit] = js.native
  var colorProfile: js.UndefOr[Double | String] = js.native
  var colorRendering: js.UndefOr[Double | String] = js.native
  var contentScriptType: js.UndefOr[Double | String] = js.native
  var contentStyleType: js.UndefOr[Double | String] = js.native
  var cursor: js.UndefOr[Double | String] = js.native
  var cx: js.UndefOr[Double | String] = js.native
  var cy: js.UndefOr[Double | String] = js.native
  var d: js.UndefOr[String] = js.native
  var decelerate: js.UndefOr[Double | String] = js.native
  var descent: js.UndefOr[Double | String] = js.native
  var diffuseConstant: js.UndefOr[Double | String] = js.native
  var direction: js.UndefOr[Double | String] = js.native
  var display: js.UndefOr[Double | String] = js.native
  var divisor: js.UndefOr[Double | String] = js.native
  var dominantBaseline: js.UndefOr[Double | String] = js.native
  var dur: js.UndefOr[Double | String] = js.native
  var dx: js.UndefOr[Double | String] = js.native
  var dy: js.UndefOr[Double | String] = js.native
  var edgeMode: js.UndefOr[Double | String] = js.native
  var elevation: js.UndefOr[Double | String] = js.native
  var enableBackground: js.UndefOr[Double | String] = js.native
  var end: js.UndefOr[Double | String] = js.native
  var exponent: js.UndefOr[Double | String] = js.native
  var externalResourcesRequired: js.UndefOr[Double | String] = js.native
  var fill: js.UndefOr[String] = js.native
  var fillOpacity: js.UndefOr[Double | String] = js.native
  var fillRule: js.UndefOr[nonzero | evenodd | inherit] = js.native
  var filter: js.UndefOr[String] = js.native
  var filterRes: js.UndefOr[Double | String] = js.native
  var filterUnits: js.UndefOr[Double | String] = js.native
  var floodColor: js.UndefOr[Double | String] = js.native
  var floodOpacity: js.UndefOr[Double | String] = js.native
  var focusable: js.UndefOr[Double | String] = js.native
  var fontFamily: js.UndefOr[String] = js.native
  var fontSize: js.UndefOr[Double | String] = js.native
  var fontSizeAdjust: js.UndefOr[Double | String] = js.native
  var fontStretch: js.UndefOr[Double | String] = js.native
  var fontStyle: js.UndefOr[Double | String] = js.native
  var fontVariant: js.UndefOr[Double | String] = js.native
  var fontWeight: js.UndefOr[Double | String] = js.native
  var format: js.UndefOr[Double | String] = js.native
  var from: js.UndefOr[Double | String] = js.native
  var fx: js.UndefOr[Double | String] = js.native
  var fy: js.UndefOr[Double | String] = js.native
  var g1: js.UndefOr[Double | String] = js.native
  var g2: js.UndefOr[Double | String] = js.native
  var glyphName: js.UndefOr[Double | String] = js.native
  var glyphOrientationHorizontal: js.UndefOr[Double | String] = js.native
  var glyphOrientationVertical: js.UndefOr[Double | String] = js.native
  var glyphRef: js.UndefOr[Double | String] = js.native
  var gradientTransform: js.UndefOr[String] = js.native
  var gradientUnits: js.UndefOr[String] = js.native
  var hanging: js.UndefOr[Double | String] = js.native
  var height: js.UndefOr[Double | String] = js.native
  var horizAdvX: js.UndefOr[Double | String] = js.native
  var horizOriginX: js.UndefOr[Double | String] = js.native
  var href: js.UndefOr[String] = js.native
  var id: js.UndefOr[String] = js.native
  var ideographic: js.UndefOr[Double | String] = js.native
  var imageRendering: js.UndefOr[Double | String] = js.native
  var in: js.UndefOr[String] = js.native
  var in2: js.UndefOr[Double | String] = js.native
  var intercept: js.UndefOr[Double | String] = js.native
  var k: js.UndefOr[Double | String] = js.native
  var k1: js.UndefOr[Double | String] = js.native
  var k2: js.UndefOr[Double | String] = js.native
  var k3: js.UndefOr[Double | String] = js.native
  var k4: js.UndefOr[Double | String] = js.native
  var kernelMatrix: js.UndefOr[Double | String] = js.native
  var kernelUnitLength: js.UndefOr[Double | String] = js.native
  var kerning: js.UndefOr[Double | String] = js.native
  var keyPoints: js.UndefOr[Double | String] = js.native
  var keySplines: js.UndefOr[Double | String] = js.native
  var keyTimes: js.UndefOr[Double | String] = js.native
  var lang: js.UndefOr[String] = js.native
  var lengthAdjust: js.UndefOr[Double | String] = js.native
  var letterSpacing: js.UndefOr[Double | String] = js.native
  var lightingColor: js.UndefOr[Double | String] = js.native
  var limitingConeAngle: js.UndefOr[Double | String] = js.native
  var local: js.UndefOr[Double | String] = js.native
  var markerEnd: js.UndefOr[String] = js.native
  var markerHeight: js.UndefOr[Double | String] = js.native
  var markerMid: js.UndefOr[String] = js.native
  var markerStart: js.UndefOr[String] = js.native
  var markerUnits: js.UndefOr[Double | String] = js.native
  var markerWidth: js.UndefOr[Double | String] = js.native
  var mask: js.UndefOr[String] = js.native
  var maskContentUnits: js.UndefOr[Double | String] = js.native
  var maskUnits: js.UndefOr[Double | String] = js.native
  var mathematical: js.UndefOr[Double | String] = js.native
  var max: js.UndefOr[Double | String] = js.native
  var media: js.UndefOr[String] = js.native
  var method: js.UndefOr[String] = js.native
  var min: js.UndefOr[Double | String] = js.native
  var mode: js.UndefOr[Double | String] = js.native
  var name: js.UndefOr[String] = js.native
  var numOctaves: js.UndefOr[Double | String] = js.native
  var offset: js.UndefOr[Double | String] = js.native
  var opacity: js.UndefOr[Double | String] = js.native
  var operator: js.UndefOr[Double | String] = js.native
  var order: js.UndefOr[Double | String] = js.native
  var orient: js.UndefOr[Double | String] = js.native
  var orientation: js.UndefOr[Double | String] = js.native
  var origin: js.UndefOr[Double | String] = js.native
  var overflow: js.UndefOr[Double | String] = js.native
  var overlinePosition: js.UndefOr[Double | String] = js.native
  var overlineThickness: js.UndefOr[Double | String] = js.native
  var paintOrder: js.UndefOr[Double | String] = js.native
  var panose1: js.UndefOr[Double | String] = js.native
  var pathLength: js.UndefOr[Double | String] = js.native
  var patternContentUnits: js.UndefOr[String] = js.native
  var patternTransform: js.UndefOr[Double | String] = js.native
  var patternUnits: js.UndefOr[String] = js.native
  var pointerEvents: js.UndefOr[Double | String] = js.native
  var points: js.UndefOr[String] = js.native
  var pointsAtX: js.UndefOr[Double | String] = js.native
  var pointsAtY: js.UndefOr[Double | String] = js.native
  var pointsAtZ: js.UndefOr[Double | String] = js.native
  var preserveAlpha: js.UndefOr[Double | String] = js.native
  var preserveAspectRatio: js.UndefOr[String] = js.native
  var primitiveUnits: js.UndefOr[Double | String] = js.native
  var r: js.UndefOr[Double | String] = js.native
  var radius: js.UndefOr[Double | String] = js.native
  var refX: js.UndefOr[Double | String] = js.native
  var refY: js.UndefOr[Double | String] = js.native
  var renderingIntent: js.UndefOr[Double | String] = js.native
  var repeatCount: js.UndefOr[Double | String] = js.native
  var repeatDur: js.UndefOr[Double | String] = js.native
  var requiredExtensions: js.UndefOr[Double | String] = js.native
  var requiredFeatures: js.UndefOr[Double | String] = js.native
  var restart: js.UndefOr[Double | String] = js.native
  var result: js.UndefOr[String] = js.native
  // Other HTML properties supported by SVG elements in browsers
  var role: js.UndefOr[String] = js.native
  var rotate: js.UndefOr[Double | String] = js.native
  var rx: js.UndefOr[Double | String] = js.native
  var ry: js.UndefOr[Double | String] = js.native
  var scale: js.UndefOr[Double | String] = js.native
  var seed: js.UndefOr[Double | String] = js.native
  var shapeRendering: js.UndefOr[Double | String] = js.native
  var slope: js.UndefOr[Double | String] = js.native
  var spacing: js.UndefOr[Double | String] = js.native
  var specularConstant: js.UndefOr[Double | String] = js.native
  var specularExponent: js.UndefOr[Double | String] = js.native
  var speed: js.UndefOr[Double | String] = js.native
  var spreadMethod: js.UndefOr[String] = js.native
  var startOffset: js.UndefOr[Double | String] = js.native
  var stdDeviation: js.UndefOr[Double | String] = js.native
  var stemh: js.UndefOr[Double | String] = js.native
  var stemv: js.UndefOr[Double | String] = js.native
  var stitchTiles: js.UndefOr[Double | String] = js.native
  var stopColor: js.UndefOr[String] = js.native
  var stopOpacity: js.UndefOr[Double | String] = js.native
  var strikethroughPosition: js.UndefOr[Double | String] = js.native
  var strikethroughThickness: js.UndefOr[Double | String] = js.native
  var string: js.UndefOr[Double | String] = js.native
  var stroke: js.UndefOr[String] = js.native
  var strokeDasharray: js.UndefOr[String | Double] = js.native
  var strokeDashoffset: js.UndefOr[String | Double] = js.native
  var strokeLinecap: js.UndefOr[butt | round | square | inherit] = js.native
  var strokeLinejoin: js.UndefOr[miter | round | bevel | inherit] = js.native
  var strokeMiterlimit: js.UndefOr[Double | String] = js.native
  var strokeOpacity: js.UndefOr[Double | String] = js.native
  var strokeWidth: js.UndefOr[Double | String] = js.native
  var style: js.UndefOr[CSSProperties] = js.native
  var surfaceScale: js.UndefOr[Double | String] = js.native
  var systemLanguage: js.UndefOr[Double | String] = js.native
  var tabIndex: js.UndefOr[Double] = js.native
  var tableValues: js.UndefOr[Double | String] = js.native
  var target: js.UndefOr[String] = js.native
  var targetX: js.UndefOr[Double | String] = js.native
  var targetY: js.UndefOr[Double | String] = js.native
  var textAnchor: js.UndefOr[String] = js.native
  var textDecoration: js.UndefOr[Double | String] = js.native
  var textLength: js.UndefOr[Double | String] = js.native
  var textRendering: js.UndefOr[Double | String] = js.native
  var to: js.UndefOr[Double | String] = js.native
  var transform: js.UndefOr[String] = js.native
  var `type`: js.UndefOr[String] = js.native
  var u1: js.UndefOr[Double | String] = js.native
  var u2: js.UndefOr[Double | String] = js.native
  var underlinePosition: js.UndefOr[Double | String] = js.native
  var underlineThickness: js.UndefOr[Double | String] = js.native
  var unicode: js.UndefOr[Double | String] = js.native
  var unicodeBidi: js.UndefOr[Double | String] = js.native
  var unicodeRange: js.UndefOr[Double | String] = js.native
  var unitsPerEm: js.UndefOr[Double | String] = js.native
  var vAlphabetic: js.UndefOr[Double | String] = js.native
  var vHanging: js.UndefOr[Double | String] = js.native
  var vIdeographic: js.UndefOr[Double | String] = js.native
  var vMathematical: js.UndefOr[Double | String] = js.native
  var values: js.UndefOr[String] = js.native
  var vectorEffect: js.UndefOr[Double | String] = js.native
  var version: js.UndefOr[String] = js.native
  var vertAdvY: js.UndefOr[Double | String] = js.native
  var vertOriginX: js.UndefOr[Double | String] = js.native
  var vertOriginY: js.UndefOr[Double | String] = js.native
  var viewBox: js.UndefOr[String] = js.native
  var viewTarget: js.UndefOr[Double | String] = js.native
  var visibility: js.UndefOr[Double | String] = js.native
  var width: js.UndefOr[Double | String] = js.native
  var widths: js.UndefOr[Double | String] = js.native
  var wordSpacing: js.UndefOr[Double | String] = js.native
  var writingMode: js.UndefOr[Double | String] = js.native
  var x: js.UndefOr[Double | String] = js.native
  var x1: js.UndefOr[Double | String] = js.native
  var x2: js.UndefOr[Double | String] = js.native
  var xChannelSelector: js.UndefOr[String] = js.native
  var xHeight: js.UndefOr[Double | String] = js.native
  var xlinkActuate: js.UndefOr[String] = js.native
  var xlinkArcrole: js.UndefOr[String] = js.native
  var xlinkHref: js.UndefOr[String] = js.native
  var xlinkRole: js.UndefOr[String] = js.native
  var xlinkShow: js.UndefOr[String] = js.native
  var xlinkTitle: js.UndefOr[String] = js.native
  var xlinkType: js.UndefOr[String] = js.native
  var xmlBase: js.UndefOr[String] = js.native
  var xmlLang: js.UndefOr[String] = js.native
  var xmlSpace: js.UndefOr[String] = js.native
  var xmlns: js.UndefOr[String] = js.native
  var xmlnsXlink: js.UndefOr[String] = js.native
  var y: js.UndefOr[Double | String] = js.native
  var y1: js.UndefOr[Double | String] = js.native
  var y2: js.UndefOr[Double | String] = js.native
  var yChannelSelector: js.UndefOr[String] = js.native
  var z: js.UndefOr[Double | String] = js.native
  var zoomAndPan: js.UndefOr[String] = js.native
}

object SVGAttributes {
  @scala.inline
  def apply[T](
    AriaAttributes: AriaAttributes = null,
    DOMAttributes: DOMAttributes[T] = null,
    accentHeight: Double | String = null,
    accumulate: none | sum = null,
    additive: replace | sum = null,
    alignmentBaseline: auto | baseline | `before-edge` | `text-before-edge` | middle | central | `after-edge` | `text-after-edge` | ideographic | alphabetic | hanging | mathematical | inherit = null,
    allowReorder: no | yes = null,
    alphabetic: Double | String = null,
    amplitude: Double | String = null,
    arabicForm: initial | medial | terminal | isolated = null,
    ascent: Double | String = null,
    attributeName: String = null,
    attributeType: String = null,
    autoReverse: Double | String = null,
    azimuth: Double | String = null,
    baseFrequency: Double | String = null,
    baseProfile: Double | String = null,
    baselineShift: Double | String = null,
    bbox: Double | String = null,
    begin: Double | String = null,
    bias: Double | String = null,
    by: Double | String = null,
    calcMode: Double | String = null,
    capHeight: Double | String = null,
    className: String = null,
    clip: Double | String = null,
    clipPath: String = null,
    clipPathUnits: Double | String = null,
    clipRule: Double | String = null,
    color: String = null,
    colorInterpolation: Double | String = null,
    colorInterpolationFilters: auto | sRGB | linearRGB | inherit = null,
    colorProfile: Double | String = null,
    colorRendering: Double | String = null,
    contentScriptType: Double | String = null,
    contentStyleType: Double | String = null,
    cursor: Double | String = null,
    cx: Double | String = null,
    cy: Double | String = null,
    d: String = null,
    decelerate: Double | String = null,
    descent: Double | String = null,
    diffuseConstant: Double | String = null,
    direction: Double | String = null,
    display: Double | String = null,
    divisor: Double | String = null,
    dominantBaseline: Double | String = null,
    dur: Double | String = null,
    dx: Double | String = null,
    dy: Double | String = null,
    edgeMode: Double | String = null,
    elevation: Double | String = null,
    enableBackground: Double | String = null,
    end: Double | String = null,
    exponent: Double | String = null,
    externalResourcesRequired: Double | String = null,
    fill: String = null,
    fillOpacity: Double | String = null,
    fillRule: nonzero | evenodd | inherit = null,
    filter: String = null,
    filterRes: Double | String = null,
    filterUnits: Double | String = null,
    floodColor: Double | String = null,
    floodOpacity: Double | String = null,
    focusable: Double | String = null,
    fontFamily: String = null,
    fontSize: Double | String = null,
    fontSizeAdjust: Double | String = null,
    fontStretch: Double | String = null,
    fontStyle: Double | String = null,
    fontVariant: Double | String = null,
    fontWeight: Double | String = null,
    format: Double | String = null,
    from: Double | String = null,
    fx: Double | String = null,
    fy: Double | String = null,
    g1: Double | String = null,
    g2: Double | String = null,
    glyphName: Double | String = null,
    glyphOrientationHorizontal: Double | String = null,
    glyphOrientationVertical: Double | String = null,
    glyphRef: Double | String = null,
    gradientTransform: String = null,
    gradientUnits: String = null,
    hanging: Double | String = null,
    height: Double | String = null,
    horizAdvX: Double | String = null,
    horizOriginX: Double | String = null,
    href: String = null,
    id: String = null,
    ideographic: Double | String = null,
    imageRendering: Double | String = null,
    in: String = null,
    in2: Double | String = null,
    intercept: Double | String = null,
    k: Double | String = null,
    k1: Double | String = null,
    k2: Double | String = null,
    k3: Double | String = null,
    k4: Double | String = null,
    kernelMatrix: Double | String = null,
    kernelUnitLength: Double | String = null,
    kerning: Double | String = null,
    keyPoints: Double | String = null,
    keySplines: Double | String = null,
    keyTimes: Double | String = null,
    lang: String = null,
    lengthAdjust: Double | String = null,
    letterSpacing: Double | String = null,
    lightingColor: Double | String = null,
    limitingConeAngle: Double | String = null,
    local: Double | String = null,
    markerEnd: String = null,
    markerHeight: Double | String = null,
    markerMid: String = null,
    markerStart: String = null,
    markerUnits: Double | String = null,
    markerWidth: Double | String = null,
    mask: String = null,
    maskContentUnits: Double | String = null,
    maskUnits: Double | String = null,
    mathematical: Double | String = null,
    max: Double | String = null,
    media: String = null,
    method: String = null,
    min: Double | String = null,
    mode: Double | String = null,
    name: String = null,
    numOctaves: Double | String = null,
    offset: Double | String = null,
    opacity: Double | String = null,
    operator: Double | String = null,
    order: Double | String = null,
    orient: Double | String = null,
    orientation: Double | String = null,
    origin: Double | String = null,
    overflow: Double | String = null,
    overlinePosition: Double | String = null,
    overlineThickness: Double | String = null,
    paintOrder: Double | String = null,
    panose1: Double | String = null,
    pathLength: Double | String = null,
    patternContentUnits: String = null,
    patternTransform: Double | String = null,
    patternUnits: String = null,
    pointerEvents: Double | String = null,
    points: String = null,
    pointsAtX: Double | String = null,
    pointsAtY: Double | String = null,
    pointsAtZ: Double | String = null,
    preserveAlpha: Double | String = null,
    preserveAspectRatio: String = null,
    primitiveUnits: Double | String = null,
    r: Double | String = null,
    radius: Double | String = null,
    refX: Double | String = null,
    refY: Double | String = null,
    renderingIntent: Double | String = null,
    repeatCount: Double | String = null,
    repeatDur: Double | String = null,
    requiredExtensions: Double | String = null,
    requiredFeatures: Double | String = null,
    restart: Double | String = null,
    result: String = null,
    role: String = null,
    rotate: Double | String = null,
    rx: Double | String = null,
    ry: Double | String = null,
    scale: Double | String = null,
    seed: Double | String = null,
    shapeRendering: Double | String = null,
    slope: Double | String = null,
    spacing: Double | String = null,
    specularConstant: Double | String = null,
    specularExponent: Double | String = null,
    speed: Double | String = null,
    spreadMethod: String = null,
    startOffset: Double | String = null,
    stdDeviation: Double | String = null,
    stemh: Double | String = null,
    stemv: Double | String = null,
    stitchTiles: Double | String = null,
    stopColor: String = null,
    stopOpacity: Double | String = null,
    strikethroughPosition: Double | String = null,
    strikethroughThickness: Double | String = null,
    string: Double | String = null,
    stroke: String = null,
    strokeDasharray: String | Double = null,
    strokeDashoffset: String | Double = null,
    strokeLinecap: butt | round | square | inherit = null,
    strokeLinejoin: miter | round | bevel | inherit = null,
    strokeMiterlimit: Double | String = null,
    strokeOpacity: Double | String = null,
    strokeWidth: Double | String = null,
    style: CSSProperties = null,
    surfaceScale: Double | String = null,
    systemLanguage: Double | String = null,
    tabIndex: Int | Double = null,
    tableValues: Double | String = null,
    target: String = null,
    targetX: Double | String = null,
    targetY: Double | String = null,
    textAnchor: String = null,
    textDecoration: Double | String = null,
    textLength: Double | String = null,
    textRendering: Double | String = null,
    to: Double | String = null,
    transform: String = null,
    `type`: String = null,
    u1: Double | String = null,
    u2: Double | String = null,
    underlinePosition: Double | String = null,
    underlineThickness: Double | String = null,
    unicode: Double | String = null,
    unicodeBidi: Double | String = null,
    unicodeRange: Double | String = null,
    unitsPerEm: Double | String = null,
    vAlphabetic: Double | String = null,
    vHanging: Double | String = null,
    vIdeographic: Double | String = null,
    vMathematical: Double | String = null,
    values: String = null,
    vectorEffect: Double | String = null,
    version: String = null,
    vertAdvY: Double | String = null,
    vertOriginX: Double | String = null,
    vertOriginY: Double | String = null,
    viewBox: String = null,
    viewTarget: Double | String = null,
    visibility: Double | String = null,
    width: Double | String = null,
    widths: Double | String = null,
    wordSpacing: Double | String = null,
    writingMode: Double | String = null,
    x: Double | String = null,
    x1: Double | String = null,
    x2: Double | String = null,
    xChannelSelector: String = null,
    xHeight: Double | String = null,
    xlinkActuate: String = null,
    xlinkArcrole: String = null,
    xlinkHref: String = null,
    xlinkRole: String = null,
    xlinkShow: String = null,
    xlinkTitle: String = null,
    xlinkType: String = null,
    xmlBase: String = null,
    xmlLang: String = null,
    xmlSpace: String = null,
    xmlns: String = null,
    xmlnsXlink: String = null,
    y: Double | String = null,
    y1: Double | String = null
  ): SVGAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (AriaAttributes != null) js.Dynamic.global.Object.assign(__obj, AriaAttributes)
    if (DOMAttributes != null) js.Dynamic.global.Object.assign(__obj, DOMAttributes)
    if (accentHeight != null) __obj.updateDynamic("accentHeight")(accentHeight.asInstanceOf[js.Any])
    if (accumulate != null) __obj.updateDynamic("accumulate")(accumulate.asInstanceOf[js.Any])
    if (additive != null) __obj.updateDynamic("additive")(additive.asInstanceOf[js.Any])
    if (alignmentBaseline != null) __obj.updateDynamic("alignmentBaseline")(alignmentBaseline.asInstanceOf[js.Any])
    if (allowReorder != null) __obj.updateDynamic("allowReorder")(allowReorder.asInstanceOf[js.Any])
    if (alphabetic != null) __obj.updateDynamic("alphabetic")(alphabetic.asInstanceOf[js.Any])
    if (amplitude != null) __obj.updateDynamic("amplitude")(amplitude.asInstanceOf[js.Any])
    if (arabicForm != null) __obj.updateDynamic("arabicForm")(arabicForm.asInstanceOf[js.Any])
    if (ascent != null) __obj.updateDynamic("ascent")(ascent.asInstanceOf[js.Any])
    if (attributeName != null) __obj.updateDynamic("attributeName")(attributeName.asInstanceOf[js.Any])
    if (attributeType != null) __obj.updateDynamic("attributeType")(attributeType.asInstanceOf[js.Any])
    if (autoReverse != null) __obj.updateDynamic("autoReverse")(autoReverse.asInstanceOf[js.Any])
    if (azimuth != null) __obj.updateDynamic("azimuth")(azimuth.asInstanceOf[js.Any])
    if (baseFrequency != null) __obj.updateDynamic("baseFrequency")(baseFrequency.asInstanceOf[js.Any])
    if (baseProfile != null) __obj.updateDynamic("baseProfile")(baseProfile.asInstanceOf[js.Any])
    if (baselineShift != null) __obj.updateDynamic("baselineShift")(baselineShift.asInstanceOf[js.Any])
    if (bbox != null) __obj.updateDynamic("bbox")(bbox.asInstanceOf[js.Any])
    if (begin != null) __obj.updateDynamic("begin")(begin.asInstanceOf[js.Any])
    if (bias != null) __obj.updateDynamic("bias")(bias.asInstanceOf[js.Any])
    if (by != null) __obj.updateDynamic("by")(by.asInstanceOf[js.Any])
    if (calcMode != null) __obj.updateDynamic("calcMode")(calcMode.asInstanceOf[js.Any])
    if (capHeight != null) __obj.updateDynamic("capHeight")(capHeight.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (clip != null) __obj.updateDynamic("clip")(clip.asInstanceOf[js.Any])
    if (clipPath != null) __obj.updateDynamic("clipPath")(clipPath.asInstanceOf[js.Any])
    if (clipPathUnits != null) __obj.updateDynamic("clipPathUnits")(clipPathUnits.asInstanceOf[js.Any])
    if (clipRule != null) __obj.updateDynamic("clipRule")(clipRule.asInstanceOf[js.Any])
    if (color != null) __obj.updateDynamic("color")(color.asInstanceOf[js.Any])
    if (colorInterpolation != null) __obj.updateDynamic("colorInterpolation")(colorInterpolation.asInstanceOf[js.Any])
    if (colorInterpolationFilters != null) __obj.updateDynamic("colorInterpolationFilters")(colorInterpolationFilters.asInstanceOf[js.Any])
    if (colorProfile != null) __obj.updateDynamic("colorProfile")(colorProfile.asInstanceOf[js.Any])
    if (colorRendering != null) __obj.updateDynamic("colorRendering")(colorRendering.asInstanceOf[js.Any])
    if (contentScriptType != null) __obj.updateDynamic("contentScriptType")(contentScriptType.asInstanceOf[js.Any])
    if (contentStyleType != null) __obj.updateDynamic("contentStyleType")(contentStyleType.asInstanceOf[js.Any])
    if (cursor != null) __obj.updateDynamic("cursor")(cursor.asInstanceOf[js.Any])
    if (cx != null) __obj.updateDynamic("cx")(cx.asInstanceOf[js.Any])
    if (cy != null) __obj.updateDynamic("cy")(cy.asInstanceOf[js.Any])
    if (d != null) __obj.updateDynamic("d")(d.asInstanceOf[js.Any])
    if (decelerate != null) __obj.updateDynamic("decelerate")(decelerate.asInstanceOf[js.Any])
    if (descent != null) __obj.updateDynamic("descent")(descent.asInstanceOf[js.Any])
    if (diffuseConstant != null) __obj.updateDynamic("diffuseConstant")(diffuseConstant.asInstanceOf[js.Any])
    if (direction != null) __obj.updateDynamic("direction")(direction.asInstanceOf[js.Any])
    if (display != null) __obj.updateDynamic("display")(display.asInstanceOf[js.Any])
    if (divisor != null) __obj.updateDynamic("divisor")(divisor.asInstanceOf[js.Any])
    if (dominantBaseline != null) __obj.updateDynamic("dominantBaseline")(dominantBaseline.asInstanceOf[js.Any])
    if (dur != null) __obj.updateDynamic("dur")(dur.asInstanceOf[js.Any])
    if (dx != null) __obj.updateDynamic("dx")(dx.asInstanceOf[js.Any])
    if (dy != null) __obj.updateDynamic("dy")(dy.asInstanceOf[js.Any])
    if (edgeMode != null) __obj.updateDynamic("edgeMode")(edgeMode.asInstanceOf[js.Any])
    if (elevation != null) __obj.updateDynamic("elevation")(elevation.asInstanceOf[js.Any])
    if (enableBackground != null) __obj.updateDynamic("enableBackground")(enableBackground.asInstanceOf[js.Any])
    if (end != null) __obj.updateDynamic("end")(end.asInstanceOf[js.Any])
    if (exponent != null) __obj.updateDynamic("exponent")(exponent.asInstanceOf[js.Any])
    if (externalResourcesRequired != null) __obj.updateDynamic("externalResourcesRequired")(externalResourcesRequired.asInstanceOf[js.Any])
    if (fill != null) __obj.updateDynamic("fill")(fill.asInstanceOf[js.Any])
    if (fillOpacity != null) __obj.updateDynamic("fillOpacity")(fillOpacity.asInstanceOf[js.Any])
    if (fillRule != null) __obj.updateDynamic("fillRule")(fillRule.asInstanceOf[js.Any])
    if (filter != null) __obj.updateDynamic("filter")(filter.asInstanceOf[js.Any])
    if (filterRes != null) __obj.updateDynamic("filterRes")(filterRes.asInstanceOf[js.Any])
    if (filterUnits != null) __obj.updateDynamic("filterUnits")(filterUnits.asInstanceOf[js.Any])
    if (floodColor != null) __obj.updateDynamic("floodColor")(floodColor.asInstanceOf[js.Any])
    if (floodOpacity != null) __obj.updateDynamic("floodOpacity")(floodOpacity.asInstanceOf[js.Any])
    if (focusable != null) __obj.updateDynamic("focusable")(focusable.asInstanceOf[js.Any])
    if (fontFamily != null) __obj.updateDynamic("fontFamily")(fontFamily.asInstanceOf[js.Any])
    if (fontSize != null) __obj.updateDynamic("fontSize")(fontSize.asInstanceOf[js.Any])
    if (fontSizeAdjust != null) __obj.updateDynamic("fontSizeAdjust")(fontSizeAdjust.asInstanceOf[js.Any])
    if (fontStretch != null) __obj.updateDynamic("fontStretch")(fontStretch.asInstanceOf[js.Any])
    if (fontStyle != null) __obj.updateDynamic("fontStyle")(fontStyle.asInstanceOf[js.Any])
    if (fontVariant != null) __obj.updateDynamic("fontVariant")(fontVariant.asInstanceOf[js.Any])
    if (fontWeight != null) __obj.updateDynamic("fontWeight")(fontWeight.asInstanceOf[js.Any])
    if (format != null) __obj.updateDynamic("format")(format.asInstanceOf[js.Any])
    if (from != null) __obj.updateDynamic("from")(from.asInstanceOf[js.Any])
    if (fx != null) __obj.updateDynamic("fx")(fx.asInstanceOf[js.Any])
    if (fy != null) __obj.updateDynamic("fy")(fy.asInstanceOf[js.Any])
    if (g1 != null) __obj.updateDynamic("g1")(g1.asInstanceOf[js.Any])
    if (g2 != null) __obj.updateDynamic("g2")(g2.asInstanceOf[js.Any])
    if (glyphName != null) __obj.updateDynamic("glyphName")(glyphName.asInstanceOf[js.Any])
    if (glyphOrientationHorizontal != null) __obj.updateDynamic("glyphOrientationHorizontal")(glyphOrientationHorizontal.asInstanceOf[js.Any])
    if (glyphOrientationVertical != null) __obj.updateDynamic("glyphOrientationVertical")(glyphOrientationVertical.asInstanceOf[js.Any])
    if (glyphRef != null) __obj.updateDynamic("glyphRef")(glyphRef.asInstanceOf[js.Any])
    if (gradientTransform != null) __obj.updateDynamic("gradientTransform")(gradientTransform.asInstanceOf[js.Any])
    if (gradientUnits != null) __obj.updateDynamic("gradientUnits")(gradientUnits.asInstanceOf[js.Any])
    if (hanging != null) __obj.updateDynamic("hanging")(hanging.asInstanceOf[js.Any])
    if (height != null) __obj.updateDynamic("height")(height.asInstanceOf[js.Any])
    if (horizAdvX != null) __obj.updateDynamic("horizAdvX")(horizAdvX.asInstanceOf[js.Any])
    if (horizOriginX != null) __obj.updateDynamic("horizOriginX")(horizOriginX.asInstanceOf[js.Any])
    if (href != null) __obj.updateDynamic("href")(href.asInstanceOf[js.Any])
    if (id != null) __obj.updateDynamic("id")(id.asInstanceOf[js.Any])
    if (ideographic != null) __obj.updateDynamic("ideographic")(ideographic.asInstanceOf[js.Any])
    if (imageRendering != null) __obj.updateDynamic("imageRendering")(imageRendering.asInstanceOf[js.Any])
    if (in != null) __obj.updateDynamic("in")(in.asInstanceOf[js.Any])
    if (in2 != null) __obj.updateDynamic("in2")(in2.asInstanceOf[js.Any])
    if (intercept != null) __obj.updateDynamic("intercept")(intercept.asInstanceOf[js.Any])
    if (k != null) __obj.updateDynamic("k")(k.asInstanceOf[js.Any])
    if (k1 != null) __obj.updateDynamic("k1")(k1.asInstanceOf[js.Any])
    if (k2 != null) __obj.updateDynamic("k2")(k2.asInstanceOf[js.Any])
    if (k3 != null) __obj.updateDynamic("k3")(k3.asInstanceOf[js.Any])
    if (k4 != null) __obj.updateDynamic("k4")(k4.asInstanceOf[js.Any])
    if (kernelMatrix != null) __obj.updateDynamic("kernelMatrix")(kernelMatrix.asInstanceOf[js.Any])
    if (kernelUnitLength != null) __obj.updateDynamic("kernelUnitLength")(kernelUnitLength.asInstanceOf[js.Any])
    if (kerning != null) __obj.updateDynamic("kerning")(kerning.asInstanceOf[js.Any])
    if (keyPoints != null) __obj.updateDynamic("keyPoints")(keyPoints.asInstanceOf[js.Any])
    if (keySplines != null) __obj.updateDynamic("keySplines")(keySplines.asInstanceOf[js.Any])
    if (keyTimes != null) __obj.updateDynamic("keyTimes")(keyTimes.asInstanceOf[js.Any])
    if (lang != null) __obj.updateDynamic("lang")(lang.asInstanceOf[js.Any])
    if (lengthAdjust != null) __obj.updateDynamic("lengthAdjust")(lengthAdjust.asInstanceOf[js.Any])
    if (letterSpacing != null) __obj.updateDynamic("letterSpacing")(letterSpacing.asInstanceOf[js.Any])
    if (lightingColor != null) __obj.updateDynamic("lightingColor")(lightingColor.asInstanceOf[js.Any])
    if (limitingConeAngle != null) __obj.updateDynamic("limitingConeAngle")(limitingConeAngle.asInstanceOf[js.Any])
    if (local != null) __obj.updateDynamic("local")(local.asInstanceOf[js.Any])
    if (markerEnd != null) __obj.updateDynamic("markerEnd")(markerEnd.asInstanceOf[js.Any])
    if (markerHeight != null) __obj.updateDynamic("markerHeight")(markerHeight.asInstanceOf[js.Any])
    if (markerMid != null) __obj.updateDynamic("markerMid")(markerMid.asInstanceOf[js.Any])
    if (markerStart != null) __obj.updateDynamic("markerStart")(markerStart.asInstanceOf[js.Any])
    if (markerUnits != null) __obj.updateDynamic("markerUnits")(markerUnits.asInstanceOf[js.Any])
    if (markerWidth != null) __obj.updateDynamic("markerWidth")(markerWidth.asInstanceOf[js.Any])
    if (mask != null) __obj.updateDynamic("mask")(mask.asInstanceOf[js.Any])
    if (maskContentUnits != null) __obj.updateDynamic("maskContentUnits")(maskContentUnits.asInstanceOf[js.Any])
    if (maskUnits != null) __obj.updateDynamic("maskUnits")(maskUnits.asInstanceOf[js.Any])
    if (mathematical != null) __obj.updateDynamic("mathematical")(mathematical.asInstanceOf[js.Any])
    if (max != null) __obj.updateDynamic("max")(max.asInstanceOf[js.Any])
    if (media != null) __obj.updateDynamic("media")(media.asInstanceOf[js.Any])
    if (method != null) __obj.updateDynamic("method")(method.asInstanceOf[js.Any])
    if (min != null) __obj.updateDynamic("min")(min.asInstanceOf[js.Any])
    if (mode != null) __obj.updateDynamic("mode")(mode.asInstanceOf[js.Any])
    if (name != null) __obj.updateDynamic("name")(name.asInstanceOf[js.Any])
    if (numOctaves != null) __obj.updateDynamic("numOctaves")(numOctaves.asInstanceOf[js.Any])
    if (offset != null) __obj.updateDynamic("offset")(offset.asInstanceOf[js.Any])
    if (opacity != null) __obj.updateDynamic("opacity")(opacity.asInstanceOf[js.Any])
    if (operator != null) __obj.updateDynamic("operator")(operator.asInstanceOf[js.Any])
    if (order != null) __obj.updateDynamic("order")(order.asInstanceOf[js.Any])
    if (orient != null) __obj.updateDynamic("orient")(orient.asInstanceOf[js.Any])
    if (orientation != null) __obj.updateDynamic("orientation")(orientation.asInstanceOf[js.Any])
    if (origin != null) __obj.updateDynamic("origin")(origin.asInstanceOf[js.Any])
    if (overflow != null) __obj.updateDynamic("overflow")(overflow.asInstanceOf[js.Any])
    if (overlinePosition != null) __obj.updateDynamic("overlinePosition")(overlinePosition.asInstanceOf[js.Any])
    if (overlineThickness != null) __obj.updateDynamic("overlineThickness")(overlineThickness.asInstanceOf[js.Any])
    if (paintOrder != null) __obj.updateDynamic("paintOrder")(paintOrder.asInstanceOf[js.Any])
    if (panose1 != null) __obj.updateDynamic("panose1")(panose1.asInstanceOf[js.Any])
    if (pathLength != null) __obj.updateDynamic("pathLength")(pathLength.asInstanceOf[js.Any])
    if (patternContentUnits != null) __obj.updateDynamic("patternContentUnits")(patternContentUnits.asInstanceOf[js.Any])
    if (patternTransform != null) __obj.updateDynamic("patternTransform")(patternTransform.asInstanceOf[js.Any])
    if (patternUnits != null) __obj.updateDynamic("patternUnits")(patternUnits.asInstanceOf[js.Any])
    if (pointerEvents != null) __obj.updateDynamic("pointerEvents")(pointerEvents.asInstanceOf[js.Any])
    if (points != null) __obj.updateDynamic("points")(points.asInstanceOf[js.Any])
    if (pointsAtX != null) __obj.updateDynamic("pointsAtX")(pointsAtX.asInstanceOf[js.Any])
    if (pointsAtY != null) __obj.updateDynamic("pointsAtY")(pointsAtY.asInstanceOf[js.Any])
    if (pointsAtZ != null) __obj.updateDynamic("pointsAtZ")(pointsAtZ.asInstanceOf[js.Any])
    if (preserveAlpha != null) __obj.updateDynamic("preserveAlpha")(preserveAlpha.asInstanceOf[js.Any])
    if (preserveAspectRatio != null) __obj.updateDynamic("preserveAspectRatio")(preserveAspectRatio.asInstanceOf[js.Any])
    if (primitiveUnits != null) __obj.updateDynamic("primitiveUnits")(primitiveUnits.asInstanceOf[js.Any])
    if (r != null) __obj.updateDynamic("r")(r.asInstanceOf[js.Any])
    if (radius != null) __obj.updateDynamic("radius")(radius.asInstanceOf[js.Any])
    if (refX != null) __obj.updateDynamic("refX")(refX.asInstanceOf[js.Any])
    if (refY != null) __obj.updateDynamic("refY")(refY.asInstanceOf[js.Any])
    if (renderingIntent != null) __obj.updateDynamic("renderingIntent")(renderingIntent.asInstanceOf[js.Any])
    if (repeatCount != null) __obj.updateDynamic("repeatCount")(repeatCount.asInstanceOf[js.Any])
    if (repeatDur != null) __obj.updateDynamic("repeatDur")(repeatDur.asInstanceOf[js.Any])
    if (requiredExtensions != null) __obj.updateDynamic("requiredExtensions")(requiredExtensions.asInstanceOf[js.Any])
    if (requiredFeatures != null) __obj.updateDynamic("requiredFeatures")(requiredFeatures.asInstanceOf[js.Any])
    if (restart != null) __obj.updateDynamic("restart")(restart.asInstanceOf[js.Any])
    if (result != null) __obj.updateDynamic("result")(result.asInstanceOf[js.Any])
    if (role != null) __obj.updateDynamic("role")(role.asInstanceOf[js.Any])
    if (rotate != null) __obj.updateDynamic("rotate")(rotate.asInstanceOf[js.Any])
    if (rx != null) __obj.updateDynamic("rx")(rx.asInstanceOf[js.Any])
    if (ry != null) __obj.updateDynamic("ry")(ry.asInstanceOf[js.Any])
    if (scale != null) __obj.updateDynamic("scale")(scale.asInstanceOf[js.Any])
    if (seed != null) __obj.updateDynamic("seed")(seed.asInstanceOf[js.Any])
    if (shapeRendering != null) __obj.updateDynamic("shapeRendering")(shapeRendering.asInstanceOf[js.Any])
    if (slope != null) __obj.updateDynamic("slope")(slope.asInstanceOf[js.Any])
    if (spacing != null) __obj.updateDynamic("spacing")(spacing.asInstanceOf[js.Any])
    if (specularConstant != null) __obj.updateDynamic("specularConstant")(specularConstant.asInstanceOf[js.Any])
    if (specularExponent != null) __obj.updateDynamic("specularExponent")(specularExponent.asInstanceOf[js.Any])
    if (speed != null) __obj.updateDynamic("speed")(speed.asInstanceOf[js.Any])
    if (spreadMethod != null) __obj.updateDynamic("spreadMethod")(spreadMethod.asInstanceOf[js.Any])
    if (startOffset != null) __obj.updateDynamic("startOffset")(startOffset.asInstanceOf[js.Any])
    if (stdDeviation != null) __obj.updateDynamic("stdDeviation")(stdDeviation.asInstanceOf[js.Any])
    if (stemh != null) __obj.updateDynamic("stemh")(stemh.asInstanceOf[js.Any])
    if (stemv != null) __obj.updateDynamic("stemv")(stemv.asInstanceOf[js.Any])
    if (stitchTiles != null) __obj.updateDynamic("stitchTiles")(stitchTiles.asInstanceOf[js.Any])
    if (stopColor != null) __obj.updateDynamic("stopColor")(stopColor.asInstanceOf[js.Any])
    if (stopOpacity != null) __obj.updateDynamic("stopOpacity")(stopOpacity.asInstanceOf[js.Any])
    if (strikethroughPosition != null) __obj.updateDynamic("strikethroughPosition")(strikethroughPosition.asInstanceOf[js.Any])
    if (strikethroughThickness != null) __obj.updateDynamic("strikethroughThickness")(strikethroughThickness.asInstanceOf[js.Any])
    if (string != null) __obj.updateDynamic("string")(string.asInstanceOf[js.Any])
    if (stroke != null) __obj.updateDynamic("stroke")(stroke.asInstanceOf[js.Any])
    if (strokeDasharray != null) __obj.updateDynamic("strokeDasharray")(strokeDasharray.asInstanceOf[js.Any])
    if (strokeDashoffset != null) __obj.updateDynamic("strokeDashoffset")(strokeDashoffset.asInstanceOf[js.Any])
    if (strokeLinecap != null) __obj.updateDynamic("strokeLinecap")(strokeLinecap.asInstanceOf[js.Any])
    if (strokeLinejoin != null) __obj.updateDynamic("strokeLinejoin")(strokeLinejoin.asInstanceOf[js.Any])
    if (strokeMiterlimit != null) __obj.updateDynamic("strokeMiterlimit")(strokeMiterlimit.asInstanceOf[js.Any])
    if (strokeOpacity != null) __obj.updateDynamic("strokeOpacity")(strokeOpacity.asInstanceOf[js.Any])
    if (strokeWidth != null) __obj.updateDynamic("strokeWidth")(strokeWidth.asInstanceOf[js.Any])
    if (style != null) __obj.updateDynamic("style")(style.asInstanceOf[js.Any])
    if (surfaceScale != null) __obj.updateDynamic("surfaceScale")(surfaceScale.asInstanceOf[js.Any])
    if (systemLanguage != null) __obj.updateDynamic("systemLanguage")(systemLanguage.asInstanceOf[js.Any])
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (tableValues != null) __obj.updateDynamic("tableValues")(tableValues.asInstanceOf[js.Any])
    if (target != null) __obj.updateDynamic("target")(target.asInstanceOf[js.Any])
    if (targetX != null) __obj.updateDynamic("targetX")(targetX.asInstanceOf[js.Any])
    if (targetY != null) __obj.updateDynamic("targetY")(targetY.asInstanceOf[js.Any])
    if (textAnchor != null) __obj.updateDynamic("textAnchor")(textAnchor.asInstanceOf[js.Any])
    if (textDecoration != null) __obj.updateDynamic("textDecoration")(textDecoration.asInstanceOf[js.Any])
    if (textLength != null) __obj.updateDynamic("textLength")(textLength.asInstanceOf[js.Any])
    if (textRendering != null) __obj.updateDynamic("textRendering")(textRendering.asInstanceOf[js.Any])
    if (to != null) __obj.updateDynamic("to")(to.asInstanceOf[js.Any])
    if (transform != null) __obj.updateDynamic("transform")(transform.asInstanceOf[js.Any])
    if (`type` != null) __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (u1 != null) __obj.updateDynamic("u1")(u1.asInstanceOf[js.Any])
    if (u2 != null) __obj.updateDynamic("u2")(u2.asInstanceOf[js.Any])
    if (underlinePosition != null) __obj.updateDynamic("underlinePosition")(underlinePosition.asInstanceOf[js.Any])
    if (underlineThickness != null) __obj.updateDynamic("underlineThickness")(underlineThickness.asInstanceOf[js.Any])
    if (unicode != null) __obj.updateDynamic("unicode")(unicode.asInstanceOf[js.Any])
    if (unicodeBidi != null) __obj.updateDynamic("unicodeBidi")(unicodeBidi.asInstanceOf[js.Any])
    if (unicodeRange != null) __obj.updateDynamic("unicodeRange")(unicodeRange.asInstanceOf[js.Any])
    if (unitsPerEm != null) __obj.updateDynamic("unitsPerEm")(unitsPerEm.asInstanceOf[js.Any])
    if (vAlphabetic != null) __obj.updateDynamic("vAlphabetic")(vAlphabetic.asInstanceOf[js.Any])
    if (vHanging != null) __obj.updateDynamic("vHanging")(vHanging.asInstanceOf[js.Any])
    if (vIdeographic != null) __obj.updateDynamic("vIdeographic")(vIdeographic.asInstanceOf[js.Any])
    if (vMathematical != null) __obj.updateDynamic("vMathematical")(vMathematical.asInstanceOf[js.Any])
    if (values != null) __obj.updateDynamic("values")(values.asInstanceOf[js.Any])
    if (vectorEffect != null) __obj.updateDynamic("vectorEffect")(vectorEffect.asInstanceOf[js.Any])
    if (version != null) __obj.updateDynamic("version")(version.asInstanceOf[js.Any])
    if (vertAdvY != null) __obj.updateDynamic("vertAdvY")(vertAdvY.asInstanceOf[js.Any])
    if (vertOriginX != null) __obj.updateDynamic("vertOriginX")(vertOriginX.asInstanceOf[js.Any])
    if (vertOriginY != null) __obj.updateDynamic("vertOriginY")(vertOriginY.asInstanceOf[js.Any])
    if (viewBox != null) __obj.updateDynamic("viewBox")(viewBox.asInstanceOf[js.Any])
    if (viewTarget != null) __obj.updateDynamic("viewTarget")(viewTarget.asInstanceOf[js.Any])
    if (visibility != null) __obj.updateDynamic("visibility")(visibility.asInstanceOf[js.Any])
    if (width != null) __obj.updateDynamic("width")(width.asInstanceOf[js.Any])
    if (widths != null) __obj.updateDynamic("widths")(widths.asInstanceOf[js.Any])
    if (wordSpacing != null) __obj.updateDynamic("wordSpacing")(wordSpacing.asInstanceOf[js.Any])
    if (writingMode != null) __obj.updateDynamic("writingMode")(writingMode.asInstanceOf[js.Any])
    if (x != null) __obj.updateDynamic("x")(x.asInstanceOf[js.Any])
    if (x1 != null) __obj.updateDynamic("x1")(x1.asInstanceOf[js.Any])
    if (x2 != null) __obj.updateDynamic("x2")(x2.asInstanceOf[js.Any])
    if (xChannelSelector != null) __obj.updateDynamic("xChannelSelector")(xChannelSelector.asInstanceOf[js.Any])
    if (xHeight != null) __obj.updateDynamic("xHeight")(xHeight.asInstanceOf[js.Any])
    if (xlinkActuate != null) __obj.updateDynamic("xlinkActuate")(xlinkActuate.asInstanceOf[js.Any])
    if (xlinkArcrole != null) __obj.updateDynamic("xlinkArcrole")(xlinkArcrole.asInstanceOf[js.Any])
    if (xlinkHref != null) __obj.updateDynamic("xlinkHref")(xlinkHref.asInstanceOf[js.Any])
    if (xlinkRole != null) __obj.updateDynamic("xlinkRole")(xlinkRole.asInstanceOf[js.Any])
    if (xlinkShow != null) __obj.updateDynamic("xlinkShow")(xlinkShow.asInstanceOf[js.Any])
    if (xlinkTitle != null) __obj.updateDynamic("xlinkTitle")(xlinkTitle.asInstanceOf[js.Any])
    if (xlinkType != null) __obj.updateDynamic("xlinkType")(xlinkType.asInstanceOf[js.Any])
    if (xmlBase != null) __obj.updateDynamic("xmlBase")(xmlBase.asInstanceOf[js.Any])
    if (xmlLang != null) __obj.updateDynamic("xmlLang")(xmlLang.asInstanceOf[js.Any])
    if (xmlSpace != null) __obj.updateDynamic("xmlSpace")(xmlSpace.asInstanceOf[js.Any])
    if (xmlns != null) __obj.updateDynamic("xmlns")(xmlns.asInstanceOf[js.Any])
    if (xmlnsXlink != null) __obj.updateDynamic("xmlnsXlink")(xmlnsXlink.asInstanceOf[js.Any])
    if (y != null) __obj.updateDynamic("y")(y.asInstanceOf[js.Any])
    if (y1 != null) __obj.updateDynamic("y1")(y1.asInstanceOf[js.Any])
    __obj.asInstanceOf[SVGAttributes[T]]
  }
  @scala.inline
  implicit class SVGAttributesOps[Self[t] <: SVGAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withAccentHeight(accentHeight: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (accentHeight != null) ret.updateDynamic("accentHeight")(accentHeight.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAccentHeight: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "accentHeight")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAccumulate(accumulate: none | sum): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (accumulate != null) ret.updateDynamic("accumulate")(accumulate.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAccumulate: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "accumulate")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAdditive(additive: replace | sum): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (additive != null) ret.updateDynamic("additive")(additive.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAdditive: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "additive")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAlignmentBaseline(
      alignmentBaseline: auto | baseline | `before-edge` | `text-before-edge` | middle | central | `after-edge` | `text-after-edge` | ideographic | alphabetic | hanging | mathematical | inherit
    ): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (alignmentBaseline != null) ret.updateDynamic("alignmentBaseline")(alignmentBaseline.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAlignmentBaseline: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "alignmentBaseline")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAllowReorder(allowReorder: no | yes): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (allowReorder != null) ret.updateDynamic("allowReorder")(allowReorder.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAllowReorder: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "allowReorder")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAlphabetic(alphabetic: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (alphabetic != null) ret.updateDynamic("alphabetic")(alphabetic.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAlphabetic: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "alphabetic")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAmplitude(amplitude: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (amplitude != null) ret.updateDynamic("amplitude")(amplitude.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAmplitude: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "amplitude")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withArabicForm(arabicForm: initial | medial | terminal | isolated): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (arabicForm != null) ret.updateDynamic("arabicForm")(arabicForm.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutArabicForm: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "arabicForm")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAscent(ascent: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (ascent != null) ret.updateDynamic("ascent")(ascent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAscent: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "ascent")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAttributeName(attributeName: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (attributeName != null) ret.updateDynamic("attributeName")(attributeName.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAttributeName: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "attributeName")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAttributeType(attributeType: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (attributeType != null) ret.updateDynamic("attributeType")(attributeType.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAttributeType: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "attributeType")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAutoReverse(autoReverse: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (autoReverse != null) ret.updateDynamic("autoReverse")(autoReverse.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAutoReverse: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "autoReverse")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withAzimuth(azimuth: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (azimuth != null) ret.updateDynamic("azimuth")(azimuth.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutAzimuth: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "azimuth")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withBaseFrequency(baseFrequency: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (baseFrequency != null) ret.updateDynamic("baseFrequency")(baseFrequency.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutBaseFrequency: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "baseFrequency")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withBaseProfile(baseProfile: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (baseProfile != null) ret.updateDynamic("baseProfile")(baseProfile.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutBaseProfile: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "baseProfile")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withBaselineShift(baselineShift: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (baselineShift != null) ret.updateDynamic("baselineShift")(baselineShift.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutBaselineShift: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "baselineShift")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withBbox(bbox: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (bbox != null) ret.updateDynamic("bbox")(bbox.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutBbox: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "bbox")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withBegin(begin: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (begin != null) ret.updateDynamic("begin")(begin.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutBegin: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "begin")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withBias(bias: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (bias != null) ret.updateDynamic("bias")(bias.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutBias: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "bias")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withBy(by: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (by != null) ret.updateDynamic("by")(by.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutBy: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "by")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withCalcMode(calcMode: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (calcMode != null) ret.updateDynamic("calcMode")(calcMode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutCalcMode: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "calcMode")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withCapHeight(capHeight: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (capHeight != null) ret.updateDynamic("capHeight")(capHeight.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutCapHeight: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "capHeight")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withClassName(className: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (className != null) ret.updateDynamic("className")(className.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutClassName: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "className")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withClip(clip: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (clip != null) ret.updateDynamic("clip")(clip.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutClip: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "clip")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withClipPath(clipPath: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (clipPath != null) ret.updateDynamic("clipPath")(clipPath.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutClipPath: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "clipPath")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withClipPathUnits(clipPathUnits: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (clipPathUnits != null) ret.updateDynamic("clipPathUnits")(clipPathUnits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutClipPathUnits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "clipPathUnits")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withClipRule(clipRule: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (clipRule != null) ret.updateDynamic("clipRule")(clipRule.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutClipRule: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "clipRule")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withColor(color: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (color != null) ret.updateDynamic("color")(color.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutColor: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "color")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withColorInterpolation(colorInterpolation: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (colorInterpolation != null) ret.updateDynamic("colorInterpolation")(colorInterpolation.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutColorInterpolation: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "colorInterpolation")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withColorInterpolationFilters(colorInterpolationFilters: auto | sRGB | linearRGB | inherit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (colorInterpolationFilters != null) ret.updateDynamic("colorInterpolationFilters")(colorInterpolationFilters.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutColorInterpolationFilters: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "colorInterpolationFilters")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withColorProfile(colorProfile: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (colorProfile != null) ret.updateDynamic("colorProfile")(colorProfile.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutColorProfile: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "colorProfile")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withColorRendering(colorRendering: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (colorRendering != null) ret.updateDynamic("colorRendering")(colorRendering.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutColorRendering: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "colorRendering")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withContentScriptType(contentScriptType: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (contentScriptType != null) ret.updateDynamic("contentScriptType")(contentScriptType.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutContentScriptType: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "contentScriptType")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withContentStyleType(contentStyleType: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (contentStyleType != null) ret.updateDynamic("contentStyleType")(contentStyleType.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutContentStyleType: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "contentStyleType")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withCursor(cursor: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (cursor != null) ret.updateDynamic("cursor")(cursor.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutCursor: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "cursor")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withCx(cx: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (cx != null) ret.updateDynamic("cx")(cx.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutCx: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "cx")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withCy(cy: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (cy != null) ret.updateDynamic("cy")(cy.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutCy: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "cy")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withD(d: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (d != null) ret.updateDynamic("d")(d.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutD: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "d")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDecelerate(decelerate: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (decelerate != null) ret.updateDynamic("decelerate")(decelerate.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDecelerate: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "decelerate")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDescent(descent: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (descent != null) ret.updateDynamic("descent")(descent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDescent: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "descent")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDiffuseConstant(diffuseConstant: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (diffuseConstant != null) ret.updateDynamic("diffuseConstant")(diffuseConstant.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDiffuseConstant: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "diffuseConstant")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDirection(direction: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (direction != null) ret.updateDynamic("direction")(direction.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDirection: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "direction")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDisplay(display: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (display != null) ret.updateDynamic("display")(display.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDisplay: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "display")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDivisor(divisor: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (divisor != null) ret.updateDynamic("divisor")(divisor.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDivisor: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "divisor")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDominantBaseline(dominantBaseline: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (dominantBaseline != null) ret.updateDynamic("dominantBaseline")(dominantBaseline.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDominantBaseline: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "dominantBaseline")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDur(dur: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (dur != null) ret.updateDynamic("dur")(dur.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDur: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "dur")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDx(dx: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (dx != null) ret.updateDynamic("dx")(dx.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDx: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "dx")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDy(dy: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (dy != null) ret.updateDynamic("dy")(dy.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDy: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "dy")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withEdgeMode(edgeMode: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (edgeMode != null) ret.updateDynamic("edgeMode")(edgeMode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutEdgeMode: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "edgeMode")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withElevation(elevation: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (elevation != null) ret.updateDynamic("elevation")(elevation.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutElevation: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "elevation")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withEnableBackground(enableBackground: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (enableBackground != null) ret.updateDynamic("enableBackground")(enableBackground.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutEnableBackground: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "enableBackground")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withEnd(end: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (end != null) ret.updateDynamic("end")(end.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutEnd: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "end")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withExponent(exponent: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (exponent != null) ret.updateDynamic("exponent")(exponent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutExponent: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "exponent")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withExternalResourcesRequired(externalResourcesRequired: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (externalResourcesRequired != null) ret.updateDynamic("externalResourcesRequired")(externalResourcesRequired.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutExternalResourcesRequired: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "externalResourcesRequired")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFill(fill: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fill != null) ret.updateDynamic("fill")(fill.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFill: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fill")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFillOpacity(fillOpacity: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fillOpacity != null) ret.updateDynamic("fillOpacity")(fillOpacity.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFillOpacity: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fillOpacity")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFillRule(fillRule: nonzero | evenodd | inherit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fillRule != null) ret.updateDynamic("fillRule")(fillRule.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFillRule: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fillRule")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFilter(filter: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (filter != null) ret.updateDynamic("filter")(filter.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFilter: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "filter")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFilterRes(filterRes: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (filterRes != null) ret.updateDynamic("filterRes")(filterRes.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFilterRes: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "filterRes")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFilterUnits(filterUnits: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (filterUnits != null) ret.updateDynamic("filterUnits")(filterUnits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFilterUnits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "filterUnits")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFloodColor(floodColor: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (floodColor != null) ret.updateDynamic("floodColor")(floodColor.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFloodColor: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "floodColor")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFloodOpacity(floodOpacity: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (floodOpacity != null) ret.updateDynamic("floodOpacity")(floodOpacity.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFloodOpacity: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "floodOpacity")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFocusable(focusable: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (focusable != null) ret.updateDynamic("focusable")(focusable.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFocusable: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "focusable")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFontFamily(fontFamily: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontFamily != null) ret.updateDynamic("fontFamily")(fontFamily.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFontFamily: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fontFamily")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFontSize(fontSize: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontSize != null) ret.updateDynamic("fontSize")(fontSize.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFontSize: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fontSize")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFontSizeAdjust(fontSizeAdjust: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontSizeAdjust != null) ret.updateDynamic("fontSizeAdjust")(fontSizeAdjust.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFontSizeAdjust: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fontSizeAdjust")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFontStretch(fontStretch: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontStretch != null) ret.updateDynamic("fontStretch")(fontStretch.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFontStretch: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fontStretch")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFontStyle(fontStyle: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontStyle != null) ret.updateDynamic("fontStyle")(fontStyle.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFontStyle: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fontStyle")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFontVariant(fontVariant: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontVariant != null) ret.updateDynamic("fontVariant")(fontVariant.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFontVariant: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fontVariant")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFontWeight(fontWeight: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontWeight != null) ret.updateDynamic("fontWeight")(fontWeight.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFontWeight: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fontWeight")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFormat(format: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (format != null) ret.updateDynamic("format")(format.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFormat: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "format")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFrom(from: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (from != null) ret.updateDynamic("from")(from.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFrom: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "from")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFx(fx: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fx != null) ret.updateDynamic("fx")(fx.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFx: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fx")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withFy(fy: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fy != null) ret.updateDynamic("fy")(fy.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutFy: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "fy")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withG1(g1: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (g1 != null) ret.updateDynamic("g1")(g1.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutG1: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "g1")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withG2(g2: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (g2 != null) ret.updateDynamic("g2")(g2.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutG2: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "g2")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withGlyphName(glyphName: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (glyphName != null) ret.updateDynamic("glyphName")(glyphName.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutGlyphName: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "glyphName")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withGlyphOrientationHorizontal(glyphOrientationHorizontal: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (glyphOrientationHorizontal != null) ret.updateDynamic("glyphOrientationHorizontal")(glyphOrientationHorizontal.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutGlyphOrientationHorizontal: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "glyphOrientationHorizontal")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withGlyphOrientationVertical(glyphOrientationVertical: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (glyphOrientationVertical != null) ret.updateDynamic("glyphOrientationVertical")(glyphOrientationVertical.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutGlyphOrientationVertical: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "glyphOrientationVertical")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withGlyphRef(glyphRef: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (glyphRef != null) ret.updateDynamic("glyphRef")(glyphRef.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutGlyphRef: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "glyphRef")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withGradientTransform(gradientTransform: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (gradientTransform != null) ret.updateDynamic("gradientTransform")(gradientTransform.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutGradientTransform: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "gradientTransform")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withGradientUnits(gradientUnits: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (gradientUnits != null) ret.updateDynamic("gradientUnits")(gradientUnits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutGradientUnits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "gradientUnits")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withHanging(hanging: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (hanging != null) ret.updateDynamic("hanging")(hanging.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutHanging: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "hanging")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withHeight(height: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (height != null) ret.updateDynamic("height")(height.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutHeight: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "height")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withHorizAdvX(horizAdvX: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (horizAdvX != null) ret.updateDynamic("horizAdvX")(horizAdvX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutHorizAdvX: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "horizAdvX")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withHorizOriginX(horizOriginX: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (horizOriginX != null) ret.updateDynamic("horizOriginX")(horizOriginX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutHorizOriginX: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "horizOriginX")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withHref(href: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (href != null) ret.updateDynamic("href")(href.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutHref: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "href")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withId(id: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (id != null) ret.updateDynamic("id")(id.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutId: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "id")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withIdeographic(ideographic: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (ideographic != null) ret.updateDynamic("ideographic")(ideographic.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutIdeographic: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "ideographic")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withImageRendering(imageRendering: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (imageRendering != null) ret.updateDynamic("imageRendering")(imageRendering.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutImageRendering: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "imageRendering")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withIn(in: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (in != null) ret.updateDynamic("in")(in.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutIn: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "in")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withIn2(in2: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (in2 != null) ret.updateDynamic("in2")(in2.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutIn2: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "in2")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withIntercept(intercept: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (intercept != null) ret.updateDynamic("intercept")(intercept.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutIntercept: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "intercept")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withK(k: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (k != null) ret.updateDynamic("k")(k.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutK: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "k")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withK1(k1: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (k1 != null) ret.updateDynamic("k1")(k1.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutK1: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "k1")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withK2(k2: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (k2 != null) ret.updateDynamic("k2")(k2.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutK2: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "k2")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withK3(k3: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (k3 != null) ret.updateDynamic("k3")(k3.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutK3: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "k3")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withK4(k4: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (k4 != null) ret.updateDynamic("k4")(k4.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutK4: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "k4")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withKernelMatrix(kernelMatrix: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (kernelMatrix != null) ret.updateDynamic("kernelMatrix")(kernelMatrix.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutKernelMatrix: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "kernelMatrix")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withKernelUnitLength(kernelUnitLength: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (kernelUnitLength != null) ret.updateDynamic("kernelUnitLength")(kernelUnitLength.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutKernelUnitLength: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "kernelUnitLength")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withKerning(kerning: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (kerning != null) ret.updateDynamic("kerning")(kerning.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutKerning: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "kerning")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withKeyPoints(keyPoints: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (keyPoints != null) ret.updateDynamic("keyPoints")(keyPoints.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutKeyPoints: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "keyPoints")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withKeySplines(keySplines: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (keySplines != null) ret.updateDynamic("keySplines")(keySplines.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutKeySplines: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "keySplines")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withKeyTimes(keyTimes: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (keyTimes != null) ret.updateDynamic("keyTimes")(keyTimes.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutKeyTimes: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "keyTimes")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withLang(lang: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (lang != null) ret.updateDynamic("lang")(lang.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutLang: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "lang")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withLengthAdjust(lengthAdjust: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (lengthAdjust != null) ret.updateDynamic("lengthAdjust")(lengthAdjust.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutLengthAdjust: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "lengthAdjust")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withLetterSpacing(letterSpacing: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (letterSpacing != null) ret.updateDynamic("letterSpacing")(letterSpacing.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutLetterSpacing: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "letterSpacing")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withLightingColor(lightingColor: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (lightingColor != null) ret.updateDynamic("lightingColor")(lightingColor.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutLightingColor: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "lightingColor")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withLimitingConeAngle(limitingConeAngle: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (limitingConeAngle != null) ret.updateDynamic("limitingConeAngle")(limitingConeAngle.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutLimitingConeAngle: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "limitingConeAngle")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withLocal(local: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (local != null) ret.updateDynamic("local")(local.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutLocal: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "local")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMarkerEnd(markerEnd: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (markerEnd != null) ret.updateDynamic("markerEnd")(markerEnd.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMarkerEnd: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "markerEnd")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMarkerHeight(markerHeight: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (markerHeight != null) ret.updateDynamic("markerHeight")(markerHeight.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMarkerHeight: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "markerHeight")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMarkerMid(markerMid: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (markerMid != null) ret.updateDynamic("markerMid")(markerMid.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMarkerMid: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "markerMid")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMarkerStart(markerStart: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (markerStart != null) ret.updateDynamic("markerStart")(markerStart.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMarkerStart: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "markerStart")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMarkerUnits(markerUnits: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (markerUnits != null) ret.updateDynamic("markerUnits")(markerUnits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMarkerUnits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "markerUnits")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMarkerWidth(markerWidth: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (markerWidth != null) ret.updateDynamic("markerWidth")(markerWidth.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMarkerWidth: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "markerWidth")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMask(mask: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (mask != null) ret.updateDynamic("mask")(mask.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMask: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "mask")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMaskContentUnits(maskContentUnits: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (maskContentUnits != null) ret.updateDynamic("maskContentUnits")(maskContentUnits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMaskContentUnits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "maskContentUnits")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMaskUnits(maskUnits: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (maskUnits != null) ret.updateDynamic("maskUnits")(maskUnits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMaskUnits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "maskUnits")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMathematical(mathematical: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (mathematical != null) ret.updateDynamic("mathematical")(mathematical.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMathematical: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "mathematical")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMax(max: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (max != null) ret.updateDynamic("max")(max.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMax: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "max")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMedia(media: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (media != null) ret.updateDynamic("media")(media.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMedia: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "media")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMethod(method: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (method != null) ret.updateDynamic("method")(method.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMethod: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "method")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMin(min: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (min != null) ret.updateDynamic("min")(min.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMin: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "min")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withMode(mode: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (mode != null) ret.updateDynamic("mode")(mode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutMode: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "mode")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withName(name: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (name != null) ret.updateDynamic("name")(name.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutName: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "name")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withNumOctaves(numOctaves: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (numOctaves != null) ret.updateDynamic("numOctaves")(numOctaves.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutNumOctaves: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "numOctaves")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOffset(offset: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (offset != null) ret.updateDynamic("offset")(offset.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOffset: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "offset")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOpacity(opacity: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (opacity != null) ret.updateDynamic("opacity")(opacity.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOpacity: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "opacity")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOperator(operator: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (operator != null) ret.updateDynamic("operator")(operator.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOperator: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "operator")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOrder(order: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (order != null) ret.updateDynamic("order")(order.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOrder: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "order")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOrient(orient: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (orient != null) ret.updateDynamic("orient")(orient.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOrient: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "orient")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOrientation(orientation: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (orientation != null) ret.updateDynamic("orientation")(orientation.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOrientation: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "orientation")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOrigin(origin: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (origin != null) ret.updateDynamic("origin")(origin.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOrigin: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "origin")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOverflow(overflow: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (overflow != null) ret.updateDynamic("overflow")(overflow.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOverflow: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "overflow")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOverlinePosition(overlinePosition: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (overlinePosition != null) ret.updateDynamic("overlinePosition")(overlinePosition.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOverlinePosition: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "overlinePosition")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOverlineThickness(overlineThickness: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (overlineThickness != null) ret.updateDynamic("overlineThickness")(overlineThickness.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOverlineThickness: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "overlineThickness")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPaintOrder(paintOrder: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (paintOrder != null) ret.updateDynamic("paintOrder")(paintOrder.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPaintOrder: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "paintOrder")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPanose1(panose1: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (panose1 != null) ret.updateDynamic("panose1")(panose1.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPanose1: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "panose1")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPathLength(pathLength: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (pathLength != null) ret.updateDynamic("pathLength")(pathLength.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPathLength: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "pathLength")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPatternContentUnits(patternContentUnits: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (patternContentUnits != null) ret.updateDynamic("patternContentUnits")(patternContentUnits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPatternContentUnits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "patternContentUnits")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPatternTransform(patternTransform: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (patternTransform != null) ret.updateDynamic("patternTransform")(patternTransform.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPatternTransform: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "patternTransform")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPatternUnits(patternUnits: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (patternUnits != null) ret.updateDynamic("patternUnits")(patternUnits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPatternUnits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "patternUnits")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPointerEvents(pointerEvents: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (pointerEvents != null) ret.updateDynamic("pointerEvents")(pointerEvents.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPointerEvents: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "pointerEvents")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPoints(points: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (points != null) ret.updateDynamic("points")(points.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPoints: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "points")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPointsAtX(pointsAtX: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (pointsAtX != null) ret.updateDynamic("pointsAtX")(pointsAtX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPointsAtX: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "pointsAtX")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPointsAtY(pointsAtY: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (pointsAtY != null) ret.updateDynamic("pointsAtY")(pointsAtY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPointsAtY: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "pointsAtY")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPointsAtZ(pointsAtZ: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (pointsAtZ != null) ret.updateDynamic("pointsAtZ")(pointsAtZ.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPointsAtZ: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "pointsAtZ")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPreserveAlpha(preserveAlpha: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (preserveAlpha != null) ret.updateDynamic("preserveAlpha")(preserveAlpha.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPreserveAlpha: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "preserveAlpha")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPreserveAspectRatio(preserveAspectRatio: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (preserveAspectRatio != null) ret.updateDynamic("preserveAspectRatio")(preserveAspectRatio.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPreserveAspectRatio: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "preserveAspectRatio")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withPrimitiveUnits(primitiveUnits: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (primitiveUnits != null) ret.updateDynamic("primitiveUnits")(primitiveUnits.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutPrimitiveUnits: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "primitiveUnits")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withR(r: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (r != null) ret.updateDynamic("r")(r.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutR: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "r")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRadius(radius: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (radius != null) ret.updateDynamic("radius")(radius.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRadius: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "radius")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRefX(refX: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (refX != null) ret.updateDynamic("refX")(refX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRefX: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "refX")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRefY(refY: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (refY != null) ret.updateDynamic("refY")(refY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRefY: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "refY")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRenderingIntent(renderingIntent: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (renderingIntent != null) ret.updateDynamic("renderingIntent")(renderingIntent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRenderingIntent: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "renderingIntent")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRepeatCount(repeatCount: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (repeatCount != null) ret.updateDynamic("repeatCount")(repeatCount.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRepeatCount: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "repeatCount")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRepeatDur(repeatDur: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (repeatDur != null) ret.updateDynamic("repeatDur")(repeatDur.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRepeatDur: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "repeatDur")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRequiredExtensions(requiredExtensions: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (requiredExtensions != null) ret.updateDynamic("requiredExtensions")(requiredExtensions.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRequiredExtensions: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "requiredExtensions")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRequiredFeatures(requiredFeatures: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (requiredFeatures != null) ret.updateDynamic("requiredFeatures")(requiredFeatures.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRequiredFeatures: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "requiredFeatures")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRestart(restart: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (restart != null) ret.updateDynamic("restart")(restart.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRestart: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "restart")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withResult(result: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (result != null) ret.updateDynamic("result")(result.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutResult: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "result")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRole(role: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (role != null) ret.updateDynamic("role")(role.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRole: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "role")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRotate(rotate: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (rotate != null) ret.updateDynamic("rotate")(rotate.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRotate: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "rotate")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRx(rx: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (rx != null) ret.updateDynamic("rx")(rx.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRx: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "rx")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRy(ry: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (ry != null) ret.updateDynamic("ry")(ry.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRy: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "ry")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withScale(scale: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (scale != null) ret.updateDynamic("scale")(scale.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutScale: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "scale")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSeed(seed: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (seed != null) ret.updateDynamic("seed")(seed.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSeed: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "seed")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withShapeRendering(shapeRendering: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (shapeRendering != null) ret.updateDynamic("shapeRendering")(shapeRendering.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutShapeRendering: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "shapeRendering")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSlope(slope: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (slope != null) ret.updateDynamic("slope")(slope.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSlope: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "slope")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSpacing(spacing: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (spacing != null) ret.updateDynamic("spacing")(spacing.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSpacing: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "spacing")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSpecularConstant(specularConstant: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (specularConstant != null) ret.updateDynamic("specularConstant")(specularConstant.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSpecularConstant: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "specularConstant")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSpecularExponent(specularExponent: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (specularExponent != null) ret.updateDynamic("specularExponent")(specularExponent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSpecularExponent: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "specularExponent")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSpeed(speed: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (speed != null) ret.updateDynamic("speed")(speed.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSpeed: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "speed")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSpreadMethod(spreadMethod: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (spreadMethod != null) ret.updateDynamic("spreadMethod")(spreadMethod.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSpreadMethod: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "spreadMethod")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStartOffset(startOffset: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (startOffset != null) ret.updateDynamic("startOffset")(startOffset.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStartOffset: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "startOffset")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStdDeviation(stdDeviation: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (stdDeviation != null) ret.updateDynamic("stdDeviation")(stdDeviation.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStdDeviation: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "stdDeviation")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStemh(stemh: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (stemh != null) ret.updateDynamic("stemh")(stemh.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStemh: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "stemh")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStemv(stemv: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (stemv != null) ret.updateDynamic("stemv")(stemv.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStemv: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "stemv")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStitchTiles(stitchTiles: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (stitchTiles != null) ret.updateDynamic("stitchTiles")(stitchTiles.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStitchTiles: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "stitchTiles")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStopColor(stopColor: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (stopColor != null) ret.updateDynamic("stopColor")(stopColor.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStopColor: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "stopColor")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStopOpacity(stopOpacity: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (stopOpacity != null) ret.updateDynamic("stopOpacity")(stopOpacity.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStopOpacity: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "stopOpacity")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStrikethroughPosition(strikethroughPosition: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (strikethroughPosition != null) ret.updateDynamic("strikethroughPosition")(strikethroughPosition.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStrikethroughPosition: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "strikethroughPosition")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStrikethroughThickness(strikethroughThickness: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (strikethroughThickness != null) ret.updateDynamic("strikethroughThickness")(strikethroughThickness.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStrikethroughThickness: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "strikethroughThickness")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withString(string: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (string != null) ret.updateDynamic("string")(string.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutString: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "string")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStroke(stroke: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (stroke != null) ret.updateDynamic("stroke")(stroke.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStroke: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "stroke")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStrokeDasharray(strokeDasharray: String | Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (strokeDasharray != null) ret.updateDynamic("strokeDasharray")(strokeDasharray.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStrokeDasharray: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "strokeDasharray")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStrokeDashoffset(strokeDashoffset: String | Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (strokeDashoffset != null) ret.updateDynamic("strokeDashoffset")(strokeDashoffset.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStrokeDashoffset: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "strokeDashoffset")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStrokeLinecap(strokeLinecap: butt | round | square | inherit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (strokeLinecap != null) ret.updateDynamic("strokeLinecap")(strokeLinecap.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStrokeLinecap: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "strokeLinecap")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStrokeLinejoin(strokeLinejoin: miter | round | bevel | inherit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (strokeLinejoin != null) ret.updateDynamic("strokeLinejoin")(strokeLinejoin.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStrokeLinejoin: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "strokeLinejoin")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStrokeMiterlimit(strokeMiterlimit: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (strokeMiterlimit != null) ret.updateDynamic("strokeMiterlimit")(strokeMiterlimit.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStrokeMiterlimit: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "strokeMiterlimit")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStrokeOpacity(strokeOpacity: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (strokeOpacity != null) ret.updateDynamic("strokeOpacity")(strokeOpacity.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStrokeOpacity: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "strokeOpacity")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStrokeWidth(strokeWidth: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (strokeWidth != null) ret.updateDynamic("strokeWidth")(strokeWidth.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStrokeWidth: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "strokeWidth")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withStyle(style: CSSProperties): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (style != null) ret.updateDynamic("style")(style.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutStyle: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "style")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSurfaceScale(surfaceScale: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (surfaceScale != null) ret.updateDynamic("surfaceScale")(surfaceScale.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSurfaceScale: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "surfaceScale")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withSystemLanguage(systemLanguage: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (systemLanguage != null) ret.updateDynamic("systemLanguage")(systemLanguage.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutSystemLanguage: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "systemLanguage")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTabIndex(tabIndex: Int | Double): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (tabIndex != null) ret.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTabIndex: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "tabIndex")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTableValues(tableValues: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (tableValues != null) ret.updateDynamic("tableValues")(tableValues.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTableValues: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "tableValues")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTarget(target: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (target != null) ret.updateDynamic("target")(target.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTarget: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "target")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTargetX(targetX: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (targetX != null) ret.updateDynamic("targetX")(targetX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTargetX: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "targetX")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTargetY(targetY: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (targetY != null) ret.updateDynamic("targetY")(targetY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTargetY: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "targetY")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTextAnchor(textAnchor: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (textAnchor != null) ret.updateDynamic("textAnchor")(textAnchor.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTextAnchor: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "textAnchor")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTextDecoration(textDecoration: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (textDecoration != null) ret.updateDynamic("textDecoration")(textDecoration.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTextDecoration: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "textDecoration")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTextLength(textLength: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (textLength != null) ret.updateDynamic("textLength")(textLength.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTextLength: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "textLength")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTextRendering(textRendering: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (textRendering != null) ret.updateDynamic("textRendering")(textRendering.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTextRendering: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "textRendering")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTo(to: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (to != null) ret.updateDynamic("to")(to.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTo: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "to")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withTransform(transform: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (transform != null) ret.updateDynamic("transform")(transform.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutTransform: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "transform")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withType(`type`: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (`type` != null) ret.updateDynamic("type")(`type`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutType: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "type")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withU1(u1: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (u1 != null) ret.updateDynamic("u1")(u1.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutU1: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "u1")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withU2(u2: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (u2 != null) ret.updateDynamic("u2")(u2.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutU2: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "u2")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withUnderlinePosition(underlinePosition: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (underlinePosition != null) ret.updateDynamic("underlinePosition")(underlinePosition.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutUnderlinePosition: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "underlinePosition")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withUnderlineThickness(underlineThickness: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (underlineThickness != null) ret.updateDynamic("underlineThickness")(underlineThickness.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutUnderlineThickness: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "underlineThickness")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withUnicode(unicode: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (unicode != null) ret.updateDynamic("unicode")(unicode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutUnicode: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "unicode")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withUnicodeBidi(unicodeBidi: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (unicodeBidi != null) ret.updateDynamic("unicodeBidi")(unicodeBidi.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutUnicodeBidi: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "unicodeBidi")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withUnicodeRange(unicodeRange: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (unicodeRange != null) ret.updateDynamic("unicodeRange")(unicodeRange.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutUnicodeRange: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "unicodeRange")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withUnitsPerEm(unitsPerEm: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (unitsPerEm != null) ret.updateDynamic("unitsPerEm")(unitsPerEm.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutUnitsPerEm: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "unitsPerEm")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVAlphabetic(vAlphabetic: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (vAlphabetic != null) ret.updateDynamic("vAlphabetic")(vAlphabetic.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVAlphabetic: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "vAlphabetic")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVHanging(vHanging: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (vHanging != null) ret.updateDynamic("vHanging")(vHanging.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVHanging: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "vHanging")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVIdeographic(vIdeographic: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (vIdeographic != null) ret.updateDynamic("vIdeographic")(vIdeographic.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVIdeographic: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "vIdeographic")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVMathematical(vMathematical: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (vMathematical != null) ret.updateDynamic("vMathematical")(vMathematical.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVMathematical: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "vMathematical")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withValues(values: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (values != null) ret.updateDynamic("values")(values.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutValues: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "values")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVectorEffect(vectorEffect: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (vectorEffect != null) ret.updateDynamic("vectorEffect")(vectorEffect.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVectorEffect: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "vectorEffect")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVersion(version: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (version != null) ret.updateDynamic("version")(version.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVersion: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "version")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVertAdvY(vertAdvY: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (vertAdvY != null) ret.updateDynamic("vertAdvY")(vertAdvY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVertAdvY: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "vertAdvY")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVertOriginX(vertOriginX: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (vertOriginX != null) ret.updateDynamic("vertOriginX")(vertOriginX.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVertOriginX: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "vertOriginX")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVertOriginY(vertOriginY: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (vertOriginY != null) ret.updateDynamic("vertOriginY")(vertOriginY.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVertOriginY: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "vertOriginY")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withViewBox(viewBox: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (viewBox != null) ret.updateDynamic("viewBox")(viewBox.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutViewBox: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "viewBox")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withViewTarget(viewTarget: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (viewTarget != null) ret.updateDynamic("viewTarget")(viewTarget.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutViewTarget: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "viewTarget")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withVisibility(visibility: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (visibility != null) ret.updateDynamic("visibility")(visibility.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutVisibility: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "visibility")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withWidth(width: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (width != null) ret.updateDynamic("width")(width.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutWidth: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "width")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withWidths(widths: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (widths != null) ret.updateDynamic("widths")(widths.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutWidths: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "widths")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withWordSpacing(wordSpacing: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (wordSpacing != null) ret.updateDynamic("wordSpacing")(wordSpacing.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutWordSpacing: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "wordSpacing")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withWritingMode(writingMode: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (writingMode != null) ret.updateDynamic("writingMode")(writingMode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutWritingMode: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "writingMode")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withX(x: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (x != null) ret.updateDynamic("x")(x.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutX: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "x")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withX1(x1: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (x1 != null) ret.updateDynamic("x1")(x1.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutX1: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "x1")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withX2(x2: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (x2 != null) ret.updateDynamic("x2")(x2.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutX2: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "x2")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXChannelSelector(xChannelSelector: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xChannelSelector != null) ret.updateDynamic("xChannelSelector")(xChannelSelector.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXChannelSelector: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xChannelSelector")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXHeight(xHeight: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xHeight != null) ret.updateDynamic("xHeight")(xHeight.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXHeight: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xHeight")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXlinkActuate(xlinkActuate: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xlinkActuate != null) ret.updateDynamic("xlinkActuate")(xlinkActuate.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXlinkActuate: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xlinkActuate")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXlinkArcrole(xlinkArcrole: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xlinkArcrole != null) ret.updateDynamic("xlinkArcrole")(xlinkArcrole.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXlinkArcrole: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xlinkArcrole")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXlinkHref(xlinkHref: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xlinkHref != null) ret.updateDynamic("xlinkHref")(xlinkHref.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXlinkHref: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xlinkHref")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXlinkRole(xlinkRole: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xlinkRole != null) ret.updateDynamic("xlinkRole")(xlinkRole.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXlinkRole: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xlinkRole")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXlinkShow(xlinkShow: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xlinkShow != null) ret.updateDynamic("xlinkShow")(xlinkShow.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXlinkShow: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xlinkShow")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXlinkTitle(xlinkTitle: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xlinkTitle != null) ret.updateDynamic("xlinkTitle")(xlinkTitle.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXlinkTitle: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xlinkTitle")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXlinkType(xlinkType: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xlinkType != null) ret.updateDynamic("xlinkType")(xlinkType.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXlinkType: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xlinkType")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXmlBase(xmlBase: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xmlBase != null) ret.updateDynamic("xmlBase")(xmlBase.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXmlBase: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xmlBase")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXmlLang(xmlLang: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xmlLang != null) ret.updateDynamic("xmlLang")(xmlLang.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXmlLang: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xmlLang")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXmlSpace(xmlSpace: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xmlSpace != null) ret.updateDynamic("xmlSpace")(xmlSpace.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXmlSpace: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xmlSpace")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXmlns(xmlns: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xmlns != null) ret.updateDynamic("xmlns")(xmlns.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXmlns: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xmlns")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withXmlnsXlink(xmlnsXlink: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (xmlnsXlink != null) ret.updateDynamic("xmlnsXlink")(xmlnsXlink.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutXmlnsXlink: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "xmlnsXlink")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withY(y: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (y != null) ret.updateDynamic("y")(y.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutY: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "y")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withY1(y1: Double | String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (y1 != null) ret.updateDynamic("y1")(y1.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutY1: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "y1")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}


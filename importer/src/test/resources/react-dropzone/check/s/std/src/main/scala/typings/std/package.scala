package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object std {
  import org.scalablytyped.runtime.StringDictionary

  type AnimationEvent = Event
  type ClipboardEvent = Event
  type CompositionEvent = Event
  type DragEvent = Event
  type FocusEvent = Event
  type HTMLAnchorElement = Element
  type HTMLAreaElement = Element
  type HTMLAudioElement = Element
  type HTMLBRElement = Element
  type HTMLBaseElement = Element
  type HTMLBodyElement = Element
  type HTMLButtonElement = Element
  type HTMLCanvasElement = Element
  type HTMLDListElement = Element
  type HTMLDataElement = Element
  type HTMLDataListElement = Element
  type HTMLDialogElement = Element
  type HTMLDivElement = Element
  type HTMLElement = Element
  type HTMLEmbedElement = Element
  type HTMLFieldSetElement = Element
  type HTMLFormElement = Element
  type HTMLHRElement = Element
  type HTMLHeadElement = Element
  type HTMLHeadingElement = Element
  type HTMLHtmlElement = Element
  type HTMLIFrameElement = Element
  type HTMLImageElement = Element
  type HTMLInputElement = Element
  type HTMLLIElement = Element
  type HTMLLabelElement = Element
  type HTMLLegendElement = Element
  type HTMLLinkElement = Element
  type HTMLMapElement = Element
  type HTMLMetaElement = Element
  type HTMLModElement = Element
  type HTMLOListElement = Element
  type HTMLObjectElement = Element
  type HTMLOptGroupElement = Element
  type HTMLOptionElement = Element
  type HTMLParagraphElement = Element
  type HTMLParamElement = Element
  type HTMLPreElement = Element
  type HTMLProgressElement = Element
  type HTMLQuoteElement = Element
  type HTMLScriptElement = Element
  type HTMLSelectElement = Element
  type HTMLSourceElement = Element
  type HTMLSpanElement = Element
  type HTMLStyleElement = Element
  type HTMLTableColElement = Element
  type HTMLTableDataCellElement = Element
  type HTMLTableElement = Element
  type HTMLTableHeaderCellElement = Element
  type HTMLTableRowElement = Element
  type HTMLTableSectionElement = Element
  type HTMLTemplateElement = Element
  type HTMLTextAreaElement = Element
  type HTMLTitleElement = Element
  type HTMLTrackElement = Element
  type HTMLUListElement = Element
  type HTMLVideoElement = Element
  type HTMLWebViewElement = Element
  type KeyboardEvent = Event
  type MouseEvent = Event
  /**
    * Make all properties in T optional
    */
  type Partial[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in keyof T ]:? T[P]}
    */ typings.std.stdStrings.Partial with T
  /**
    * From T pick a set of properties K
    */
  type Pick[T, K /* <: String */] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in K ]: T[P]}
    */ typings.std.stdStrings.Pick with T
  type PointerEvent = Event
  /**
    * Make all properties in T readonly
    */
  type Readonly[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {readonly [ P in keyof T ]: T[P]}
    */ typings.std.stdStrings.Readonly with T
  /**
    * Construct a type with a set of properties K of type T
    */
  type Record[K /* <: String */, T] = StringDictionary[K]
  type SVGCircleElement = Element
  type SVGClipPathElement = Element
  type SVGDefsElement = Element
  type SVGDescElement = Element
  type SVGElement = Element
  type SVGEllipseElement = Element
  type SVGFEBlendElement = Element
  type SVGFEColorMatrixElement = Element
  type SVGFEComponentTransferElement = Element
  type SVGFECompositeElement = Element
  type SVGFEConvolveMatrixElement = Element
  type SVGFEDiffuseLightingElement = Element
  type SVGFEDisplacementMapElement = Element
  type SVGFEDistantLightElement = Element
  type SVGFEDropShadowElement = Element
  type SVGFEFloodElement = Element
  type SVGFEFuncAElement = Element
  type SVGFEFuncBElement = Element
  type SVGFEFuncGElement = Element
  type SVGFEFuncRElement = Element
  type SVGFEGaussianBlurElement = Element
  type SVGFEImageElement = Element
  type SVGFEMergeElement = Element
  type SVGFEMergeNodeElement = Element
  type SVGFEMorphologyElement = Element
  type SVGFEOffsetElement = Element
  type SVGFEPointLightElement = Element
  type SVGFESpecularLightingElement = Element
  type SVGFESpotLightElement = Element
  type SVGFETileElement = Element
  type SVGFETurbulenceElement = Element
  type SVGFilterElement = Element
  type SVGForeignObjectElement = Element
  type SVGGElement = Element
  type SVGImageElement = Element
  type SVGLineElement = Element
  type SVGLinearGradientElement = Element
  type SVGMarkerElement = Element
  type SVGMaskElement = Element
  type SVGMetadataElement = Element
  type SVGPathElement = Element
  type SVGPatternElement = Element
  type SVGPolygonElement = Element
  type SVGPolylineElement = Element
  type SVGRadialGradientElement = Element
  type SVGRectElement = Element
  type SVGSVGElement = Element
  type SVGStopElement = Element
  type SVGSwitchElement = Element
  type SVGSymbolElement = Element
  type SVGTSpanElement = Element
  type SVGTextElement = Element
  type SVGTextPathElement = Element
  type SVGUseElement = Element
  type SVGViewElement = Element
  type TouchEvent = Event
  type TransitionEvent = Event
  type UIEvent = Event
  type WheelEvent = Event
}

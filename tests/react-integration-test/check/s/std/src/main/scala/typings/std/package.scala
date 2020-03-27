package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object std {
  type AnimationEvent = typings.std.Event
  type ClipboardEvent = typings.std.Event
  type CompositionEvent = typings.std.Event
  type DragEvent = typings.std.Event
  type FocusEvent = typings.std.Event
  type HTMLAnchorElement = typings.std.HTMLElement
  type HTMLAreaElement = typings.std.HTMLElement
  type HTMLAudioElement = typings.std.HTMLElement
  type HTMLBRElement = typings.std.HTMLElement
  type HTMLBaseElement = typings.std.HTMLElement
  type HTMLBodyElement = typings.std.HTMLElement
  type HTMLButtonElement = typings.std.HTMLElement
  type HTMLCanvasElement = typings.std.HTMLElement
  type HTMLDListElement = typings.std.HTMLElement
  type HTMLDataElement = typings.std.HTMLElement
  type HTMLDataListElement = typings.std.HTMLElement
  type HTMLDialogElement = typings.std.HTMLElement
  type HTMLDivElement = typings.std.HTMLElement
  type HTMLElement = typings.std.Element
  type HTMLEmbedElement = typings.std.HTMLElement
  type HTMLFieldSetElement = typings.std.HTMLElement
  type HTMLFormElement = typings.std.HTMLElement
  type HTMLHRElement = typings.std.HTMLElement
  type HTMLHeadElement = typings.std.HTMLElement
  type HTMLHeadingElement = typings.std.HTMLElement
  type HTMLHtmlElement = typings.std.HTMLElement
  type HTMLIFrameElement = typings.std.HTMLElement
  type HTMLImageElement = typings.std.HTMLElement
  type HTMLInputElement = typings.std.HTMLElement
  type HTMLLIElement = typings.std.HTMLElement
  type HTMLLabelElement = typings.std.HTMLElement
  type HTMLLegendElement = typings.std.HTMLElement
  type HTMLLinkElement = typings.std.HTMLElement
  type HTMLMapElement = typings.std.HTMLElement
  type HTMLMetaElement = typings.std.HTMLElement
  type HTMLModElement = typings.std.HTMLElement
  type HTMLOListElement = typings.std.HTMLElement
  type HTMLObjectElement = typings.std.HTMLElement
  type HTMLOptGroupElement = typings.std.HTMLElement
  type HTMLOptionElement = typings.std.HTMLElement
  type HTMLParagraphElement = typings.std.HTMLElement
  type HTMLParamElement = typings.std.HTMLElement
  type HTMLPreElement = typings.std.HTMLElement
  type HTMLProgressElement = typings.std.HTMLElement
  type HTMLQuoteElement = typings.std.HTMLElement
  type HTMLScriptElement = typings.std.HTMLElement
  type HTMLSelectElement = typings.std.HTMLElement
  type HTMLSourceElement = typings.std.HTMLElement
  type HTMLSpanElement = typings.std.HTMLElement
  type HTMLStyleElement = typings.std.HTMLElement
  type HTMLTableColElement = typings.std.HTMLElement
  type HTMLTableDataCellElement = typings.std.HTMLElement
  type HTMLTableElement = typings.std.HTMLElement
  type HTMLTableHeaderCellElement = typings.std.HTMLElement
  type HTMLTableRowElement = typings.std.HTMLElement
  type HTMLTableSectionElement = typings.std.HTMLElement
  type HTMLTemplateElement = typings.std.HTMLElement
  type HTMLTextAreaElement = typings.std.HTMLElement
  type HTMLTitleElement = typings.std.HTMLElement
  type HTMLTrackElement = typings.std.HTMLElement
  type HTMLUListElement = typings.std.HTMLElement
  type HTMLVideoElement = typings.std.HTMLElement
  type HTMLWebViewElement = typings.std.HTMLElement
  type KeyboardEvent = typings.std.Event
  type MouseEvent = typings.std.Event
  /**
    * Make all properties in T optional
    */
  type Partial[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in keyof T ]:? T[P]}
    */ typings.std.stdStrings.Partial with T
  /**
    * From T pick a set of properties K
    */
  type Pick[T, K /* <: java.lang.String */] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in K ]: T[P]}
    */ typings.std.stdStrings.Pick with T
  type PointerEvent = typings.std.Event
  /**
    * Make all properties in T readonly
    */
  type Readonly[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {readonly [ P in keyof T ]: T[P]}
    */ typings.std.stdStrings.Readonly with T
  /**
    * Construct a type with a set of properties K of type T
    */
  type Record[K /* <: java.lang.String */, T] = org.scalablytyped.runtime.StringDictionary[T]
  type SVGCircleElement = typings.std.SVGElement
  type SVGClipPathElement = typings.std.SVGElement
  type SVGDefsElement = typings.std.SVGElement
  type SVGDescElement = typings.std.SVGElement
  type SVGElement = typings.std.Element
  type SVGEllipseElement = typings.std.SVGElement
  type SVGFEBlendElement = typings.std.SVGElement
  type SVGFEColorMatrixElement = typings.std.SVGElement
  type SVGFEComponentTransferElement = typings.std.SVGElement
  type SVGFECompositeElement = typings.std.SVGElement
  type SVGFEConvolveMatrixElement = typings.std.SVGElement
  type SVGFEDiffuseLightingElement = typings.std.SVGElement
  type SVGFEDisplacementMapElement = typings.std.SVGElement
  type SVGFEDistantLightElement = typings.std.SVGElement
  type SVGFEDropShadowElement = typings.std.SVGElement
  type SVGFEFloodElement = typings.std.SVGElement
  type SVGFEFuncAElement = typings.std.SVGElement
  type SVGFEFuncBElement = typings.std.SVGElement
  type SVGFEFuncGElement = typings.std.SVGElement
  type SVGFEFuncRElement = typings.std.SVGElement
  type SVGFEGaussianBlurElement = typings.std.SVGElement
  type SVGFEImageElement = typings.std.SVGElement
  type SVGFEMergeElement = typings.std.SVGElement
  type SVGFEMergeNodeElement = typings.std.SVGElement
  type SVGFEMorphologyElement = typings.std.SVGElement
  type SVGFEOffsetElement = typings.std.SVGElement
  type SVGFEPointLightElement = typings.std.SVGElement
  type SVGFESpecularLightingElement = typings.std.SVGElement
  type SVGFESpotLightElement = typings.std.SVGElement
  type SVGFETileElement = typings.std.SVGElement
  type SVGFETurbulenceElement = typings.std.SVGElement
  type SVGFilterElement = typings.std.SVGElement
  type SVGForeignObjectElement = typings.std.SVGElement
  type SVGGElement = typings.std.SVGElement
  type SVGImageElement = typings.std.SVGElement
  type SVGLineElement = typings.std.SVGElement
  type SVGLinearGradientElement = typings.std.SVGElement
  type SVGMarkerElement = typings.std.SVGElement
  type SVGMaskElement = typings.std.SVGElement
  type SVGMetadataElement = typings.std.SVGElement
  type SVGPathElement = typings.std.SVGElement
  type SVGPatternElement = typings.std.SVGElement
  type SVGPolygonElement = typings.std.SVGElement
  type SVGPolylineElement = typings.std.SVGElement
  type SVGRadialGradientElement = typings.std.SVGElement
  type SVGRectElement = typings.std.SVGElement
  type SVGSVGElement = typings.std.SVGElement
  type SVGStopElement = typings.std.SVGElement
  type SVGSwitchElement = typings.std.SVGElement
  type SVGSymbolElement = typings.std.SVGElement
  type SVGTSpanElement = typings.std.SVGElement
  type SVGTextElement = typings.std.SVGElement
  type SVGTextPathElement = typings.std.SVGElement
  type SVGUseElement = typings.std.SVGElement
  type SVGViewElement = typings.std.SVGElement
  type TouchEvent = typings.std.Event
  type TransitionEvent = typings.std.Event
  type UIEvent = typings.std.Event
  type WheelEvent = typings.std.Event
}

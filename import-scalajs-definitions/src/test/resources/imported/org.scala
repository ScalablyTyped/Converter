package imported

import org.scalajs.dom.crypto.AlgorithmIdentifier
import org.scalajs.dom.crypto.HashAlgorithmIdentifier
import org.scalajs.dom.crypto.KeyAlgorithmIdentifier
import org.scalajs.dom.experimental.BodyInit
import org.scalajs.dom.experimental.ByteString
import org.scalajs.dom.experimental.RequestInfo
import org.scalajs.dom.experimental.mediastream.MediaDevices
import org.scalajs.dom.experimental.mediastream.MediaStream
import org.scalajs.dom.experimental.mediastream.MediaStreamTrack
import org.scalajs.dom.experimental.mediastream.MediaStreamTrackEvent
import org.scalajs.dom.experimental.serviceworkers.ExtendableEvent
import org.scalajs.dom.experimental.serviceworkers.ExtendableMessageEvent
import org.scalajs.dom.raw.CSSFontFaceRule
import org.scalajs.dom.raw.CSSImportRule
import org.scalajs.dom.raw.CSSKeyframeRule
import org.scalajs.dom.raw.CSSMediaRule
import org.scalajs.dom.raw.CSSNamespaceRule
import org.scalajs.dom.raw.CSSPageRule
import org.scalajs.dom.raw.CSSRule
import org.scalajs.dom.raw.CSSRuleList
import org.scalajs.dom.raw.CSSStyleDeclaration
import org.scalajs.dom.raw.CSSStyleRule
import org.scalajs.dom.raw.CSSStyleSheet
import org.scalajs.dom.raw.EventInit
import org.scalajs.dom.raw.HTMLAnchorElement
import org.scalajs.dom.raw.HTMLAreaElement
import org.scalajs.dom.raw.HTMLAudioElement
import org.scalajs.dom.raw.HTMLBRElement
import org.scalajs.dom.raw.HTMLBaseElement
import org.scalajs.dom.raw.HTMLBodyElement
import org.scalajs.dom.raw.HTMLButtonElement
import org.scalajs.dom.raw.HTMLCanvasElement
import org.scalajs.dom.raw.HTMLCollection
import org.scalajs.dom.raw.HTMLDListElement
import org.scalajs.dom.raw.HTMLDataListElement
import org.scalajs.dom.raw.HTMLDivElement
import org.scalajs.dom.raw.HTMLDocument
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.HTMLEmbedElement
import org.scalajs.dom.raw.HTMLFieldSetElement
import org.scalajs.dom.raw.HTMLFormElement
import org.scalajs.dom.raw.HTMLHRElement
import org.scalajs.dom.raw.HTMLHeadElement
import org.scalajs.dom.raw.HTMLHeadingElement
import org.scalajs.dom.raw.HTMLHtmlElement
import org.scalajs.dom.raw.HTMLIFrameElement
import org.scalajs.dom.raw.HTMLImageElement
import org.scalajs.dom.raw.HTMLInputElement
import org.scalajs.dom.raw.HTMLLIElement
import org.scalajs.dom.raw.HTMLLabelElement
import org.scalajs.dom.raw.HTMLLegendElement
import org.scalajs.dom.raw.HTMLLinkElement
import org.scalajs.dom.raw.HTMLMapElement
import org.scalajs.dom.raw.HTMLMediaElement
import org.scalajs.dom.raw.HTMLMenuElement
import org.scalajs.dom.raw.HTMLMetaElement
import org.scalajs.dom.raw.HTMLModElement
import org.scalajs.dom.raw.HTMLOListElement
import org.scalajs.dom.raw.HTMLObjectElement
import org.scalajs.dom.raw.HTMLOptGroupElement
import org.scalajs.dom.raw.HTMLOptionElement
import org.scalajs.dom.raw.HTMLParagraphElement
import org.scalajs.dom.raw.HTMLParamElement
import org.scalajs.dom.raw.HTMLPreElement
import org.scalajs.dom.raw.HTMLProgressElement
import org.scalajs.dom.raw.HTMLQuoteElement
import org.scalajs.dom.raw.HTMLScriptElement
import org.scalajs.dom.raw.HTMLSelectElement
import org.scalajs.dom.raw.HTMLSourceElement
import org.scalajs.dom.raw.HTMLSpanElement
import org.scalajs.dom.raw.HTMLStyleElement
import org.scalajs.dom.raw.HTMLTableAlignment
import org.scalajs.dom.raw.HTMLTableCaptionElement
import org.scalajs.dom.raw.HTMLTableCellElement
import org.scalajs.dom.raw.HTMLTableColElement
import org.scalajs.dom.raw.HTMLTableElement
import org.scalajs.dom.raw.HTMLTableRowElement
import org.scalajs.dom.raw.HTMLTableSectionElement
import org.scalajs.dom.raw.HTMLTextAreaElement
import org.scalajs.dom.raw.HTMLTitleElement
import org.scalajs.dom.raw.HTMLTrackElement
import org.scalajs.dom.raw.HTMLUListElement
import org.scalajs.dom.raw.HTMLUnknownElement
import org.scalajs.dom.raw.HTMLVideoElement
import org.scalajs.dom.raw.IDBCursor
import org.scalajs.dom.raw.IDBCursorWithValue
import org.scalajs.dom.raw.IDBDatabase
import org.scalajs.dom.raw.IDBEnvironment
import org.scalajs.dom.raw.IDBFactory
import org.scalajs.dom.raw.IDBIndex
import org.scalajs.dom.raw.IDBKeyRange
import org.scalajs.dom.raw.IDBObjectStore
import org.scalajs.dom.raw.IDBOpenDBRequest
import org.scalajs.dom.raw.IDBRequest
import org.scalajs.dom.raw.IDBTransaction
import org.scalajs.dom.raw.IDBVersionChangeEvent
import org.scalajs.dom.raw.SVGAElement
import org.scalajs.dom.raw.SVGAngle
import org.scalajs.dom.raw.SVGAnimatedAngle
import org.scalajs.dom.raw.SVGAnimatedBoolean
import org.scalajs.dom.raw.SVGAnimatedEnumeration
import org.scalajs.dom.raw.SVGAnimatedInteger
import org.scalajs.dom.raw.SVGAnimatedLength
import org.scalajs.dom.raw.SVGAnimatedLengthList
import org.scalajs.dom.raw.SVGAnimatedNumber
import org.scalajs.dom.raw.SVGAnimatedNumberList
import org.scalajs.dom.raw.SVGAnimatedPathData
import org.scalajs.dom.raw.SVGAnimatedPoints
import org.scalajs.dom.raw.SVGAnimatedPreserveAspectRatio
import org.scalajs.dom.raw.SVGAnimatedRect
import org.scalajs.dom.raw.SVGAnimatedString
import org.scalajs.dom.raw.SVGAnimatedTransformList
import org.scalajs.dom.raw.SVGCircleElement
import org.scalajs.dom.raw.SVGClipPathElement
import org.scalajs.dom.raw.SVGComponentTransferFunctionElement
import org.scalajs.dom.raw.SVGDefsElement
import org.scalajs.dom.raw.SVGDescElement
import org.scalajs.dom.raw.SVGElement
import org.scalajs.dom.raw.SVGElementInstance
import org.scalajs.dom.raw.SVGElementInstanceList
import org.scalajs.dom.raw.SVGEllipseElement
import org.scalajs.dom.raw.SVGException
import org.scalajs.dom.raw.SVGExternalResourcesRequired
import org.scalajs.dom.raw.SVGFEBlendElement
import org.scalajs.dom.raw.SVGFEColorMatrixElement
import org.scalajs.dom.raw.SVGFEComponentTransferElement
import org.scalajs.dom.raw.SVGFECompositeElement
import org.scalajs.dom.raw.SVGFEConvolveMatrixElement
import org.scalajs.dom.raw.SVGFEDiffuseLightingElement
import org.scalajs.dom.raw.SVGFEDisplacementMapElement
import org.scalajs.dom.raw.SVGFEDistantLightElement
import org.scalajs.dom.raw.SVGFEFloodElement
import org.scalajs.dom.raw.SVGFEFuncAElement
import org.scalajs.dom.raw.SVGFEFuncBElement
import org.scalajs.dom.raw.SVGFEFuncGElement
import org.scalajs.dom.raw.SVGFEFuncRElement
import org.scalajs.dom.raw.SVGFEGaussianBlurElement
import org.scalajs.dom.raw.SVGFEImageElement
import org.scalajs.dom.raw.SVGFEMergeElement
import org.scalajs.dom.raw.SVGFEMergeNodeElement
import org.scalajs.dom.raw.SVGFEMorphologyElement
import org.scalajs.dom.raw.SVGFEOffsetElement
import org.scalajs.dom.raw.SVGFEPointLightElement
import org.scalajs.dom.raw.SVGFESpecularLightingElement
import org.scalajs.dom.raw.SVGFESpotLightElement
import org.scalajs.dom.raw.SVGFETileElement
import org.scalajs.dom.raw.SVGFETurbulenceElement
import org.scalajs.dom.raw.SVGFilterElement
import org.scalajs.dom.raw.SVGFilterPrimitiveStandardAttributes
import org.scalajs.dom.raw.SVGFitToViewBox
import org.scalajs.dom.raw.SVGGElement
import org.scalajs.dom.raw.SVGGradientElement
import org.scalajs.dom.raw.SVGImageElement
import org.scalajs.dom.raw.SVGLangSpace
import org.scalajs.dom.raw.SVGLength
import org.scalajs.dom.raw.SVGLengthList
import org.scalajs.dom.raw.SVGLineElement
import org.scalajs.dom.raw.SVGLinearGradientElement
import org.scalajs.dom.raw.SVGLocatable
import org.scalajs.dom.raw.SVGMarkerElement
import org.scalajs.dom.raw.SVGMaskElement
import org.scalajs.dom.raw.SVGMatrix
import org.scalajs.dom.raw.SVGMetadataElement
import org.scalajs.dom.raw.SVGNumber
import org.scalajs.dom.raw.SVGNumberList
import org.scalajs.dom.raw.SVGPathElement
import org.scalajs.dom.raw.SVGPathSeg
import org.scalajs.dom.raw.SVGPathSegArcAbs
import org.scalajs.dom.raw.SVGPathSegArcRel
import org.scalajs.dom.raw.SVGPathSegClosePath
import org.scalajs.dom.raw.SVGPathSegCurvetoCubicAbs
import org.scalajs.dom.raw.SVGPathSegCurvetoCubicRel
import org.scalajs.dom.raw.SVGPathSegCurvetoCubicSmoothAbs
import org.scalajs.dom.raw.SVGPathSegCurvetoCubicSmoothRel
import org.scalajs.dom.raw.SVGPathSegCurvetoQuadraticAbs
import org.scalajs.dom.raw.SVGPathSegCurvetoQuadraticRel
import org.scalajs.dom.raw.SVGPathSegCurvetoQuadraticSmoothAbs
import org.scalajs.dom.raw.SVGPathSegCurvetoQuadraticSmoothRel
import org.scalajs.dom.raw.SVGPathSegLinetoAbs
import org.scalajs.dom.raw.SVGPathSegLinetoHorizontalAbs
import org.scalajs.dom.raw.SVGPathSegLinetoHorizontalRel
import org.scalajs.dom.raw.SVGPathSegLinetoRel
import org.scalajs.dom.raw.SVGPathSegLinetoVerticalAbs
import org.scalajs.dom.raw.SVGPathSegLinetoVerticalRel
import org.scalajs.dom.raw.SVGPathSegList
import org.scalajs.dom.raw.SVGPathSegMovetoAbs
import org.scalajs.dom.raw.SVGPathSegMovetoRel
import org.scalajs.dom.raw.SVGPatternElement
import org.scalajs.dom.raw.SVGPoint
import org.scalajs.dom.raw.SVGPointList
import org.scalajs.dom.raw.SVGPolygonElement
import org.scalajs.dom.raw.SVGPolylineElement
import org.scalajs.dom.raw.SVGPreserveAspectRatio
import org.scalajs.dom.raw.SVGRadialGradientElement
import org.scalajs.dom.raw.SVGRect
import org.scalajs.dom.raw.SVGRectElement
import org.scalajs.dom.raw.SVGSVGElement
import org.scalajs.dom.raw.SVGScriptElement
import org.scalajs.dom.raw.SVGStopElement
import org.scalajs.dom.raw.SVGStringList
import org.scalajs.dom.raw.SVGStylable
import org.scalajs.dom.raw.SVGStyleElement
import org.scalajs.dom.raw.SVGSwitchElement
import org.scalajs.dom.raw.SVGSymbolElement
import org.scalajs.dom.raw.SVGTSpanElement
import org.scalajs.dom.raw.SVGTests
import org.scalajs.dom.raw.SVGTextContentElement
import org.scalajs.dom.raw.SVGTextElement
import org.scalajs.dom.raw.SVGTextPathElement
import org.scalajs.dom.raw.SVGTextPositioningElement
import org.scalajs.dom.raw.SVGTitleElement
import org.scalajs.dom.raw.SVGTransform
import org.scalajs.dom.raw.SVGTransformList
import org.scalajs.dom.raw.SVGTransformable
import org.scalajs.dom.raw.SVGURIReference
import org.scalajs.dom.raw.SVGUnitTypes
import org.scalajs.dom.raw.SVGUseElement
import org.scalajs.dom.raw.SVGViewElement
import org.scalajs.dom.raw.SVGZoomAndPan
import org.scalajs.dom.raw.WebGLActiveInfo
import org.scalajs.dom.raw.WebGLBuffer
import org.scalajs.dom.raw.WebGLContextAttributes
import org.scalajs.dom.raw.WebGLFramebuffer
import org.scalajs.dom.raw.WebGLProgram
import org.scalajs.dom.raw.WebGLRenderbuffer
import org.scalajs.dom.raw.WebGLRenderingContext
import org.scalajs.dom.raw.WebGLShader
import org.scalajs.dom.raw.WebGLShaderPrecisionFormat
import org.scalajs.dom.raw.WebGLTexture
import org.scalajs.dom.raw.WebGLUniformLocation
import org.scalajs.dom.raw.WorkerGlobalScope
import org.scalajs.dom.webgl.RenderingContext
import org.scalajs.dom.webworkers.AbstractWorker
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object org {
  
  object scalablytyped {
    
    object runtime {
      
      @js.native
      trait Instantiable0[R] extends StObject
      
      @js.native
      trait Instantiable1[T1, R] extends StObject
      
      @js.native
      trait Instantiable10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R] extends StObject
      
      @js.native
      trait Instantiable11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R] extends StObject
      
      @js.native
      trait Instantiable12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R] extends StObject
      
      @js.native
      trait Instantiable13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R] extends StObject
      
      @js.native
      trait Instantiable14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R] extends StObject
      
      @js.native
      trait Instantiable15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R] extends StObject
      
      @js.native
      trait Instantiable16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R] extends StObject
      
      @js.native
      trait Instantiable17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R] extends StObject
      
      @js.native
      trait Instantiable18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R] extends StObject
      
      @js.native
      trait Instantiable19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R] extends StObject
      
      @js.native
      trait Instantiable2[T1, T2, R] extends StObject
      
      @js.native
      trait Instantiable20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R] extends StObject
      
      @js.native
      trait Instantiable21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R] extends StObject
      
      @js.native
      trait Instantiable22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R] extends StObject
      
      @js.native
      trait Instantiable3[T1, T2, T3, R] extends StObject
      
      @js.native
      trait Instantiable4[T1, T2, T3, T4, R] extends StObject
      
      @js.native
      trait Instantiable5[T1, T2, T3, T4, T5, R] extends StObject
      
      @js.native
      trait Instantiable6[T1, T2, T3, T4, T5, T6, R] extends StObject
      
      @js.native
      trait Instantiable7[T1, T2, T3, T4, T5, T6, T7, R] extends StObject
      
      @js.native
      trait Instantiable8[T1, T2, T3, T4, T5, T6, T7, T8, R] extends StObject
      
      @js.native
      trait Instantiable9[T1, T2, T3, T4, T5, T6, T7, T8, T9, R] extends StObject
      
      @js.native
      trait NumberDictionary[V] extends StObject
      object NumberDictionary {
        
        @js.native
        trait NumberDictionaryRaw[V] extends StObject {
          
          def apply[VV](index: Int): js.UndefOr[VV] = js.native
          
          def update[VV](index: Int, value: VV): Unit = js.native
        }
      }
      
      @js.native
      trait StObject extends StObject
      
      @js.native
      trait StringDictionary[V] extends StObject
      
      @js.native
      trait TopLevel[T]
        extends StObject
           with js.Any
    }
  }
  
  object scalajs {
    
    object dom {
      
      type AnalyserNode = org.scalajs.dom.raw.AnalyserNode
      
      type AnimationEvent = org.scalajs.dom.raw.AnimationEvent
      
      type ApplicationCache = org.scalajs.dom.raw.ApplicationCache
      
      type Attr = org.scalajs.dom.raw.Attr
      
      type AudioBuffer = org.scalajs.dom.raw.AudioBuffer
      
      type AudioBufferSourceNode = org.scalajs.dom.raw.AudioBufferSourceNode
      
      type AudioContext = org.scalajs.dom.raw.AudioContext
      
      type AudioDestinationNode = org.scalajs.dom.raw.AudioDestinationNode
      
      type AudioListener = org.scalajs.dom.raw.AudioListener
      
      type AudioNode = org.scalajs.dom.raw.AudioNode
      
      type AudioParam = org.scalajs.dom.raw.AudioParam
      
      type AudioTrack = org.scalajs.dom.raw.AudioTrack
      
      type AudioTrackList = org.scalajs.dom.raw.AudioTrackList
      
      type BeforeUnloadEvent = org.scalajs.dom.raw.BeforeUnloadEvent
      
      type BiquadFilterNode = org.scalajs.dom.raw.BiquadFilterNode
      
      type Blob = org.scalajs.dom.raw.Blob
      
      type BlobPropertyBag = org.scalajs.dom.raw.BlobPropertyBag
      
      type CDATASection = org.scalajs.dom.raw.CDATASection
      
      type CanvasGradient = org.scalajs.dom.raw.CanvasGradient
      
      type CanvasPattern = org.scalajs.dom.raw.CanvasPattern
      
      type CanvasRenderingContext2D = org.scalajs.dom.raw.CanvasRenderingContext2D
      
      type ChannelMergerNode = org.scalajs.dom.raw.ChannelMergerNode
      
      type ChannelSplitterNode = org.scalajs.dom.raw.ChannelSplitterNode
      
      type CharacterData = org.scalajs.dom.raw.CharacterData
      
      type ClientRect = org.scalajs.dom.raw.ClientRect
      
      type ClientRectList = org.scalajs.dom.raw.ClientRectList
      
      type ClipboardEvent = org.scalajs.dom.raw.ClipboardEvent
      
      type ClipboardEventInit = org.scalajs.dom.raw.ClipboardEventInit
      
      type CloseEvent = org.scalajs.dom.raw.CloseEvent
      
      type Comment = org.scalajs.dom.raw.Comment
      
      type CompositionEvent = org.scalajs.dom.raw.CompositionEvent
      
      type Console = org.scalajs.dom.raw.Console
      
      type ConvolverNode = org.scalajs.dom.raw.ConvolverNode
      
      type Coordinates = org.scalajs.dom.raw.Coordinates
      
      type CustomEvent = org.scalajs.dom.raw.CustomEvent
      
      type DOMException = org.scalajs.dom.raw.DOMException
      
      type DOMImplementation = org.scalajs.dom.raw.DOMImplementation
      
      type DOMList[T] = org.scalajs.dom.raw.DOMList[T]
      
      type DOMParser = org.scalajs.dom.raw.DOMParser
      
      type DOMSettableTokenList = org.scalajs.dom.raw.DOMSettableTokenList
      
      type DOMStringList = org.scalajs.dom.raw.DOMStringList
      
      type DOMTokenList = org.scalajs.dom.raw.DOMTokenList
      
      type DataTransfer = org.scalajs.dom.raw.DataTransfer
      
      type DelayNode = org.scalajs.dom.raw.DelayNode
      
      type Document = org.scalajs.dom.raw.Document
      
      type DocumentEvent = org.scalajs.dom.raw.DocumentEvent
      
      type DocumentFragment = org.scalajs.dom.raw.DocumentFragment
      
      type DocumentType = org.scalajs.dom.raw.DocumentType
      
      type DragEvent = org.scalajs.dom.raw.DragEvent
      
      type DynamicsCompressorNode = org.scalajs.dom.raw.DynamicsCompressorNode
      
      type Element = org.scalajs.dom.raw.Element
      
      type ErrorEvent = org.scalajs.dom.raw.ErrorEvent
      
      type Event = org.scalajs.dom.raw.Event
      
      type EventException = org.scalajs.dom.raw.EventException
      
      type EventSource = org.scalajs.dom.raw.EventSource
      
      type EventTarget = org.scalajs.dom.raw.EventTarget
      
      type External = org.scalajs.dom.raw.External
      
      type File = org.scalajs.dom.raw.File
      
      type FileList = org.scalajs.dom.raw.FileList
      
      type FileReader = org.scalajs.dom.raw.FileReader
      
      type FocusEvent = org.scalajs.dom.raw.FocusEvent
      
      type FormData = org.scalajs.dom.raw.FormData
      
      type GainNode = org.scalajs.dom.raw.GainNode
      
      type Geolocation = org.scalajs.dom.raw.Geolocation
      
      type HashChangeEvent = org.scalajs.dom.raw.HashChangeEvent
      
      type History = org.scalajs.dom.raw.History
      
      type ImageData = org.scalajs.dom.raw.ImageData
      
      type KeyboardEvent = org.scalajs.dom.raw.KeyboardEvent
      
      type KeyboardEventInit = org.scalajs.dom.raw.KeyboardEventInit
      
      type LinkStyle = org.scalajs.dom.raw.LinkStyle
      
      type Location = org.scalajs.dom.raw.Location
      
      type MediaElementAudioSourceNode = org.scalajs.dom.raw.MediaElementAudioSourceNode
      
      type MediaError = org.scalajs.dom.raw.MediaError
      
      type MediaList = org.scalajs.dom.raw.MediaList
      
      type MediaQueryList = org.scalajs.dom.raw.MediaQueryList
      
      type MediaQueryListListener = org.scalajs.dom.raw.MediaQueryListListener
      
      type MediaStreamAudioDestinationNode = org.scalajs.dom.raw.MediaStreamAudioDestinationNode
      
      type MediaStreamAudioSourceNode = org.scalajs.dom.raw.MediaStreamAudioSourceNode
      
      type MessageChannel = org.scalajs.dom.raw.MessageChannel
      
      type MessageEvent = org.scalajs.dom.raw.MessageEvent
      
      type MessagePort = org.scalajs.dom.raw.MessagePort
      
      type ModifierKeyEvent = org.scalajs.dom.raw.ModifierKeyEvent
      
      type MouseEvent = org.scalajs.dom.raw.MouseEvent
      
      type MutationObserver = org.scalajs.dom.raw.MutationObserver
      
      type MutationObserverInit = org.scalajs.dom.raw.MutationObserverInit
      
      type MutationRecord = org.scalajs.dom.raw.MutationRecord
      
      type NamedNodeMap = org.scalajs.dom.raw.NamedNodeMap
      
      type Navigator = org.scalajs.dom.raw.Navigator
      
      type NavigatorContentUtils = org.scalajs.dom.raw.NavigatorContentUtils
      
      type NavigatorGeolocation = org.scalajs.dom.raw.NavigatorGeolocation
      
      type NavigatorID = org.scalajs.dom.raw.NavigatorID
      
      type NavigatorLanguage = org.scalajs.dom.raw.NavigatorLanguage
      
      type NavigatorOnLine = org.scalajs.dom.raw.NavigatorOnLine
      
      type NavigatorStorageUtils = org.scalajs.dom.raw.NavigatorStorageUtils
      
      type Node = org.scalajs.dom.raw.Node
      
      type NodeFilter = org.scalajs.dom.raw.NodeFilter
      
      type NodeIterator = org.scalajs.dom.raw.NodeIterator
      
      type NodeList = org.scalajs.dom.raw.NodeList
      
      type NodeListOf[TNode] = org.scalajs.dom.raw.NodeListOf[TNode]
      
      type NodeSelector = org.scalajs.dom.raw.NodeSelector
      
      type OfflineAudioContext = org.scalajs.dom.raw.OfflineAudioContext
      
      type OscillatorNode = org.scalajs.dom.raw.OscillatorNode
      
      type PannerNode = org.scalajs.dom.raw.PannerNode
      
      type ParentNode = org.scalajs.dom.raw.ParentNode
      
      type Performance = org.scalajs.dom.raw.Performance
      
      type PerformanceEntry = org.scalajs.dom.raw.PerformanceEntry
      
      type PerformanceMark = org.scalajs.dom.raw.PerformanceMark
      
      type PerformanceMeasure = org.scalajs.dom.raw.PerformanceMeasure
      
      type PerformanceNavigation = org.scalajs.dom.raw.PerformanceNavigation
      
      type PerformanceResourceTiming = org.scalajs.dom.raw.PerformanceResourceTiming
      
      type PerformanceTiming = org.scalajs.dom.raw.PerformanceTiming
      
      type PeriodicWave = org.scalajs.dom.raw.PeriodicWave
      
      type PointerEvent = org.scalajs.dom.raw.PointerEvent
      
      type PointerEventInit = org.scalajs.dom.raw.PointerEventInit
      
      type PopStateEvent = org.scalajs.dom.raw.PopStateEvent
      
      type Position = org.scalajs.dom.raw.Position
      
      type PositionError = org.scalajs.dom.raw.PositionError
      
      type PositionOptions = org.scalajs.dom.raw.PositionOptions
      
      type ProcessingInstruction = org.scalajs.dom.raw.ProcessingInstruction
      
      type ProgressEvent = org.scalajs.dom.raw.ProgressEvent
      
      type Range = org.scalajs.dom.raw.Range
      
      type Screen = org.scalajs.dom.raw.Screen
      
      type Selection = org.scalajs.dom.raw.Selection
      
      type StereoPannerNode = org.scalajs.dom.raw.StereoPannerNode
      
      type Storage = org.scalajs.dom.raw.Storage
      
      type StorageEvent = org.scalajs.dom.raw.StorageEvent
      
      type StyleMedia = org.scalajs.dom.raw.StyleMedia
      
      type StyleSheet = org.scalajs.dom.raw.StyleSheet
      
      type StyleSheetList = org.scalajs.dom.raw.StyleSheetList
      
      type Text = org.scalajs.dom.raw.Text
      
      type TextEvent = org.scalajs.dom.raw.TextEvent
      
      type TextMetrics = org.scalajs.dom.raw.TextMetrics
      
      type TextTrack = org.scalajs.dom.raw.TextTrack
      
      type TextTrackCue = org.scalajs.dom.raw.TextTrackCue
      
      type TextTrackCueList = org.scalajs.dom.raw.TextTrackCueList
      
      type TextTrackList = org.scalajs.dom.raw.TextTrackList
      
      type TimeRanges = org.scalajs.dom.raw.TimeRanges
      
      type Touch = org.scalajs.dom.raw.Touch
      
      type TouchEvent = org.scalajs.dom.raw.TouchEvent
      
      type TouchList = org.scalajs.dom.raw.TouchList
      
      type TrackEvent = org.scalajs.dom.raw.TrackEvent
      
      type Transferable = org.scalajs.dom.raw.Transferable
      
      type TransitionEvent = org.scalajs.dom.raw.TransitionEvent
      
      type TreeWalker = org.scalajs.dom.raw.TreeWalker
      
      type UIEvent = org.scalajs.dom.raw.UIEvent
      
      type ValidityState = org.scalajs.dom.raw.ValidityState
      
      type VisibilityState = org.scalajs.dom.raw.VisibilityState
      
      type WaveShaperNode = org.scalajs.dom.raw.WaveShaperNode
      
      type WebSocket = org.scalajs.dom.raw.WebSocket
      
      type WheelEvent = org.scalajs.dom.raw.WheelEvent
      
      type Window = org.scalajs.dom.raw.Window
      
      type WindowBase64 = org.scalajs.dom.raw.WindowBase64
      
      type WindowConsole = org.scalajs.dom.raw.WindowConsole
      
      type WindowLocalStorage = org.scalajs.dom.raw.WindowLocalStorage
      
      type WindowSessionStorage = org.scalajs.dom.raw.WindowSessionStorage
      
      type WindowTimers = org.scalajs.dom.raw.WindowTimers
      
      type XMLHttpRequest = org.scalajs.dom.raw.XMLHttpRequest
      
      type XMLHttpRequestEventTarget = org.scalajs.dom.raw.XMLHttpRequestEventTarget
      
      type XMLSerializer = org.scalajs.dom.raw.XMLSerializer
      
      type XPathNSResolver = org.scalajs.dom.raw.XPathNSResolver
      
      type XPathResult = org.scalajs.dom.raw.XPathResult
      
      object crypto {
        
        @js.native
        trait AesCbcParams
          extends StObject
             with Algorithm {
          
          var iv: BufferSource = js.native
        }
        
        @js.native
        trait AesCfbParams
          extends StObject
             with Algorithm {
          
          var iv: BufferSource = js.native
        }
        
        @js.native
        trait AesCmacParams
          extends StObject
             with Algorithm {
          
          var length: Int = js.native
        }
        
        @js.native
        trait AesCtrParams
          extends StObject
             with Algorithm {
          
          var counter: BufferSource = js.native
          
          var length: Short = js.native
        }
        
        @js.native
        trait AesDerivedKeyParams
          extends StObject
             with KeyAlgorithm {
          
          var length: Int = js.native
        }
        
        @js.native
        trait AesGcmParams
          extends StObject
             with Algorithm {
          
          var additionalData: BufferSource = js.native
          
          var iv: BufferSource = js.native
          
          var tagLength: Short = js.native
        }
        
        @js.native
        trait AesKeyAlgorithm
          extends StObject
             with KeyAlgorithm {
          
          var length: Int = js.native
        }
        
        @js.native
        trait AesKeyGenParams
          extends StObject
             with KeyAlgorithm {
          
          var length: Int = js.native
        }
        
        @js.native
        trait Algorithm extends StObject {
          
          var name: String = js.native
        }
        
        type BigInteger = js.typedarray.Uint8Array
        
        @js.native
        sealed trait BufferSource
          extends StObject
             with js.Any
        
        @js.native
        trait ConcatParams
          extends StObject
             with Algorithm {
          
          var algorithmId: BufferSource = js.native
          
          var hash: HashAlgorithmIdentifier = js.native
          
          var partyUInfo: BufferSource = js.native
          
          var partyVInfo: BufferSource = js.native
          
          var privateInfo: BufferSource = js.native
          
          var publicInfo: BufferSource = js.native
        }
        
        @js.native
        trait Crypto extends StObject {
          
          def getRandomValues(array: js.typedarray.ArrayBufferView): js.typedarray.ArrayBufferView = js.native
          
          val subtle: SubtleCrypto = js.native
        }
        
        @js.native
        trait CryptoKey extends StObject {
          
          val algorithm: KeyAlgorithm = js.native
          
          val extractable: Boolean = js.native
          
          val `type`: String = js.native
          
          val usages: js.Array[KeyUsage] = js.native
        }
        
        @js.native
        trait CryptoKeyPair extends StObject {
          
          val privateKey: CryptoKey = js.native
          
          val publicKey: CryptoKey = js.native
        }
        
        @js.native
        trait DhImportKeyParams
          extends StObject
             with Algorithm {
          
          var generator: BigInteger = js.native
          
          var prime: BigInteger = js.native
        }
        
        @js.native
        trait DhKeyAlgorithm
          extends StObject
             with KeyAlgorithm {
          
          var generator: BigInteger = js.native
          
          var prime: BigInteger = js.native
        }
        
        @js.native
        trait DhKeyDeriveParams
          extends StObject
             with Algorithm {
          
          var public: CryptoKey = js.native
        }
        
        @js.native
        trait DhKeyGenParams
          extends StObject
             with Algorithm {
          
          var generator: BigInteger = js.native
          
          var prime: BigInteger = js.native
        }
        
        @js.native
        trait EcKeyAlgorithm
          extends StObject
             with KeyAlgorithm {
          
          var namedCurve: String = js.native
        }
        
        @js.native
        trait EcKeyGenParams
          extends StObject
             with Algorithm {
          
          var namedCurve: String = js.native
        }
        
        @js.native
        trait EcKeyImportParams
          extends StObject
             with KeyAlgorithm {
          
          var namedCurve: String = js.native
        }
        
        @js.native
        trait EcdhKeyDeriveParams
          extends StObject
             with KeyAlgorithm {
          
          var public: CryptoKey = js.native
        }
        
        @js.native
        trait EcdsaParams
          extends StObject
             with Algorithm {
          
          var hash: HashAlgorithmIdentifier = js.native
        }
        
        @js.native
        object GlobalCrypto extends StObject {
          
          val crypto: Crypto = js.native
        }
        
        @js.native
        trait HashAlgorithm
          extends StObject
             with Algorithm
        
        @js.native
        trait HkdfCtrParams
          extends StObject
             with Algorithm {
          
          var context: BufferSource = js.native
          
          var hash: HashAlgorithmIdentifier = js.native
          
          var label: BufferSource = js.native
        }
        
        @js.native
        trait HmacImportParams
          extends StObject
             with Algorithm {
          
          var hash: HashAlgorithmIdentifier = js.native
          
          var length: Double = js.native
        }
        
        @js.native
        trait HmacKeyAlgorithm
          extends StObject
             with KeyAlgorithm {
          
          var hash: HashAlgorithmIdentifier = js.native
          
          var length: Double = js.native
        }
        
        @js.native
        trait HmacKeyGenParams
          extends StObject
             with KeyAlgorithm {
          
          var hash: HashAlgorithmIdentifier = js.native
          
          var length: Double = js.native
        }
        
        @js.native
        trait JsonWebKey extends StObject {
          
          var alg: js.Array[String] = js.native
          
          var crv: String = js.native
          
          var d: String = js.native
          
          var dp: String = js.native
          
          var dq: String = js.native
          
          var e: String = js.native
          
          var ext: Boolean = js.native
          
          var k: String = js.native
          
          var key_ops: js.Array[String] = js.native
          
          var kty: String = js.native
          
          var n: String = js.native
          
          var oth: js.Array[String] = js.native
          
          var p: String = js.native
          
          var q: String = js.native
          
          var qi: String = js.native
          
          var use: String = js.native
          
          var x: String = js.native
          
          var y: String = js.native
        }
        
        @js.native
        trait KeyAlgorithm
          extends StObject
             with Algorithm
        
        @js.native
        trait KeyFormat
          extends StObject
             with js.Any
        
        @js.native
        trait KeyType
          extends StObject
             with js.Any
        
        @js.native
        trait KeyUsage
          extends StObject
             with js.Any
        
        @js.native
        trait Pbkdf2Params
          extends StObject
             with HashAlgorithm {
          
          var hash: HashAlgorithmIdentifier = js.native
          
          var iterations: Double = js.native
          
          var salt: BufferSource = js.native
        }
        
        @js.native
        trait RSAPublicKey extends StObject {
          
          def e(): String = js.native
          
          def n(): String = js.native
        }
        
        @js.native
        trait RsaHashedImportParams
          extends StObject
             with KeyAlgorithm {
          
          var hash: HashAlgorithmIdentifier = js.native
        }
        
        @js.native
        trait RsaHashedKeyAlgorithm
          extends StObject
             with RsaKeyAlgorithm {
          
          var hash: HashAlgorithmIdentifier = js.native
        }
        
        @js.native
        trait RsaHashedKeyGenParams
          extends StObject
             with RsaKeyGenParams {
          
          var hash: HashAlgorithmIdentifier = js.native
        }
        
        @js.native
        trait RsaKeyAlgorithm
          extends StObject
             with KeyAlgorithm {
          
          var modulusLength: Double = js.native
          
          var publicExponent: BigInteger = js.native
        }
        
        @js.native
        trait RsaKeyGenParams
          extends StObject
             with KeyAlgorithm {
          
          var modulusLength: Double = js.native
          
          var publicExponent: BigInteger = js.native
        }
        
        @js.native
        trait RsaOaepParams
          extends StObject
             with Algorithm {
          
          var label: BufferSource = js.native
        }
        
        @js.native
        trait RsaOtherPrimesInfo extends StObject {
          
          var d: String = js.native
          
          var r: String = js.native
          
          var t: String = js.native
        }
        
        @js.native
        trait RsaPssParams
          extends StObject
             with Algorithm {
          
          var saltLength: Double = js.native
        }
        
        @js.native
        trait SubtleCrypto extends StObject {
          
          def decrypt(algorithm: AlgorithmIdentifier, key: CryptoKey, data: BufferSource): js.Promise[js.Any] = js.native
          
          def deriveBits(algorithm: AlgorithmIdentifier, baseKey: CryptoKey, length: Double): js.Promise[js.Any] = js.native
          
          def deriveKey(
            algorithm: AlgorithmIdentifier,
            baseKey: CryptoKey,
            derivedKeyType: KeyAlgorithmIdentifier,
            extractable: Boolean,
            keyUsages: js.Array[KeyUsage]
          ): js.Promise[js.Any] = js.native
          
          def digest(algorithm: HashAlgorithmIdentifier, data: BufferSource): js.Promise[js.Any] = js.native
          
          def encrypt(algorithm: AlgorithmIdentifier, key: CryptoKey, data: BufferSource): js.Promise[js.Any] = js.native
          
          def exportKey(format: KeyFormat, key: CryptoKey): js.Promise[js.Any] = js.native
          
          def generateKey(algorithm: KeyAlgorithmIdentifier, extractable: Boolean, keyUsages: js.Array[KeyUsage]): js.Promise[js.Any] = js.native
          
          def importKey(
            format: KeyFormat,
            keyData: BufferSource,
            algorithm: KeyAlgorithmIdentifier,
            extractable: Boolean,
            keyUsages: js.Array[KeyUsage]
          ): js.Promise[js.Any] = js.native
          def importKey(
            format: KeyFormat,
            keyData: JsonWebKey,
            algorithm: KeyAlgorithmIdentifier,
            extractable: Boolean,
            keyUsages: js.Array[KeyUsage]
          ): js.Promise[js.Any] = js.native
          
          def sign(algorithm: AlgorithmIdentifier, key: CryptoKey, data: BufferSource): js.Promise[js.Any] = js.native
          
          def unwrapKey(
            format: String,
            wrappedKey: BufferSource,
            unwrappingKey: CryptoKey,
            unwrapAlgorithm: AlgorithmIdentifier,
            unwrappedKeyAlgorithm: AlgorithmIdentifier,
            extractable: Boolean,
            keyUsages: js.Array[KeyUsage]
          ): js.Promise[js.Any] = js.native
          
          def verify(algorithm: AlgorithmIdentifier, key: CryptoKey, signature: BufferSource, data: BufferSource): js.Promise[js.Any] = js.native
          
          def wrapKey(format: KeyFormat, key: CryptoKey, wrappingKey: CryptoKey, wrapAlgorithm: AlgorithmIdentifier): js.Promise[js.Any] = js.native
        }
      }
      
      object css {
        
        type FontFaceRule = CSSFontFaceRule
        
        type ImportRule = CSSImportRule
        
        type KeyframeRule = CSSKeyframeRule
        
        type MediaRule = CSSMediaRule
        
        type NamespaceRule = CSSNamespaceRule
        
        type PageRule = CSSPageRule
        
        type Rule = CSSRule
        
        type RuleList = CSSRuleList
        
        type StyleDeclaration = CSSStyleDeclaration
        
        type StyleRule = CSSStyleRule
        
        type StyleSheet = CSSStyleSheet
      }
      
      object experimental {
        
        @js.native
        class AbortController () extends StObject {
          
          def abort(): Unit = js.native
          
          val signal: AbortSignal = js.native
        }
        
        @js.native
        trait AbortSignal
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def aborted(): Boolean = js.native
          
          var onabort: js.Function0[Any] = js.native
        }
        
        @js.native
        trait Body extends StObject {
          
          def arrayBuffer(): js.Promise[js.typedarray.ArrayBuffer] = js.native
          
          def blob(): js.Promise[Blob] = js.native
          
          def bodyUsed(): Boolean = js.native
          
          def formData(): js.Promise[org.scalajs.dom.raw.FormData] = js.native
          
          def json(): js.Promise[js.Any] = js.native
          
          def text(): js.Promise[String] = js.native
        }
        
        @js.native
        trait Chunk[T] extends StObject {
          
          def done(): Boolean = js.native
          
          def value(): T = js.native
        }
        
        @js.native
        object Fetch extends StObject {
          
          def fetch(info: RequestInfo, init: RequestInit): js.Promise[Response] = js.native
        }
        
        object Fullscreen {
          
          @js.native
          trait FullscreenDocument extends StObject {
            
            def exitFullscreen(): js.UndefOr[js.Promise[Unit]] = js.native
            
            def fullscreenElement(): org.scalajs.dom.raw.Element = js.native
            
            def fullscreenEnabled(): Boolean = js.native
            
            var onfullscreenchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
            
            var onfullscreenerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          }
          
          @js.native
          trait FullscreenElement extends StObject {
            
            def requestFullscreen(): js.UndefOr[js.Promise[Unit]] = js.native
          }
        }
        
        @js.native
        class Headers protected ()
          extends StObject
             with js.Iterable[js.Array[ByteString]] {
          def this(map: HeadersInit) = this()
          
          def append(name: ByteString, value: ByteString): Unit = js.native
          
          def delete(name: ByteString): Unit = js.native
          
          def get(name: ByteString): js.UndefOr[ByteString] = js.native
          
          def getAll(name: ByteString): Sequence[ByteString] = js.native
          
          def has(name: ByteString): Boolean = js.native
          
          def jsIterator(): js.Iterator[js.Array[ByteString]] = js.native
          
          val map: HeadersInit = js.native
          
          def set(name: ByteString, value: ByteString): Unit = js.native
        }
        
        type HeadersInit = Headers | Sequence[Sequence[ByteString]] | OpenEndedDictionary[ByteString]
        
        @js.native
        trait HttpMethod
          extends StObject
             with js.Any
        
        @js.native
        class Notification protected ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          def this(title: String, options: NotificationOptions) = this()
          
          val body: String = js.native
          
          def close(): Unit = js.native
          
          val data: js.Object = js.native
          
          val dir: String = js.native
          
          val icon: String = js.native
          
          val lang: String = js.native
          
          val noscreen: Boolean = js.native
          
          var onclick: js.Function0[Any] = js.native
          
          var onerror: js.Function0[Any] = js.native
          
          val options: NotificationOptions = js.native
          
          val renotify: Boolean = js.native
          
          val silent: Boolean = js.native
          
          val sound: String = js.native
          
          val sticky: Boolean = js.native
          
          val tag: String = js.native
          
          val title: String = js.native
          
          val vibrate: js.Array[Double] = js.native
        }
        @js.native
        object Notification extends StObject {
          
          val permission: String = js.native
          
          def requestPermission(callback: js.Function1[String, Any]): Unit = js.native
        }
        
        @js.native
        trait NotificationOptions extends StObject {
          
          val body: String = js.native
          
          val dir: String = js.native
          
          val icon: String = js.native
          
          val lang: String = js.native
          
          val noscreen: Boolean = js.native
          
          val onclick: js.Function0[Any] = js.native
          
          val onerror: js.Function0[Any] = js.native
          
          val renotify: Boolean = js.native
          
          val silent: Boolean = js.native
          
          val sound: String = js.native
          
          val sticky: Boolean = js.native
          
          val tag: String = js.native
          
          val vibrate: js.Array[Double] = js.native
        }
        
        type OpenEndedDictionary[T] = js.Dictionary[T]
        
        object PointerLock {
          
          @js.native
          trait PointerLockDocument extends StObject {
            
            def exitPointerLock(): Unit = js.native
            
            var onpointerlockchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
            
            var onpointerlockerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
            
            def pointerLockElement(): org.scalajs.dom.raw.Element = js.native
          }
          
          @js.native
          trait PointerLockElement extends StObject {
            
            def requestPointerLock(): Unit = js.native
          }
          
          @js.native
          trait PointerLockMouseEvent extends StObject {
            
            def movementX(): Double = js.native
            
            def movementY(): Double = js.native
          }
        }
        
        @js.native
        trait ReadableStream[T] extends StObject {
          
          def cancel(reason: String): js.Promise[Any] = js.native
          
          def getReader(): ReadableStreamReader[T] = js.native
          
          def locked(): Boolean = js.native
          
          def pipeThrough[U](pair: Any, options: Any): ReadableStream[U] = js.native
          
          def pipeTo(dest: WriteableStream[T], options: Any): Unit = js.native
          
          def tee(): js.Array[_] = js.native
        }
        
        @js.native
        class ReadableStreamController[T] protected () extends StObject {
          def this(stream: ReadableStream[T]) = this()
          
          def close(): Unit = js.native
          
          def desiredSize(): Int = js.native
          
          def enqueue(chunk: Chunk[T]): js.UndefOr[Int] = js.native
          
          def error(e: Any): Unit = js.native
          
          val stream: ReadableStream[T] = js.native
        }
        
        @js.native
        class ReadableStreamReader[T] protected () extends StObject {
          def this(stream: ReadableStream[T]) = this()
          
          def cancel(reason: Any): js.Promise[Any] = js.native
          
          def closed(): js.Promise[ReadableStreamReader[T]] = js.native
          
          def read(): js.Promise[Chunk[T]] = js.native
          
          def releaseLock(): Unit = js.native
          
          val stream: ReadableStream[T] = js.native
        }
        
        @js.native
        sealed trait ReferrerPolicy
          extends StObject
             with js.Any
        
        @js.native
        class Request protected () extends StObject {
          def this(input: RequestInfo, init: RequestInit) = this()
          
          def cache(): RequestCache = js.native
          
          def credentials(): RequestCredentials = js.native
          
          def destination(): RequestDestination = js.native
          
          def headers(): Headers = js.native
          
          val init: RequestInit = js.native
          
          val input: RequestInfo = js.native
          
          def integrity(): String = js.native
          
          def keepalive(): Boolean = js.native
          
          def mediaType(): RequestType = js.native
          
          def method(): HttpMethod = js.native
          
          def mode(): RequestMode = js.native
          
          def redirect(): RequestRedirect = js.native
          
          def referrer(): String = js.native
          
          def referrerPolicy(): ReferrerPolicy = js.native
          
          def signal(): AbortSignal = js.native
          
          def url(): String = js.native
        }
        
        @js.native
        sealed trait RequestCache
          extends StObject
             with js.Any
        
        @js.native
        sealed trait RequestCredentials
          extends StObject
             with js.Any
        
        @js.native
        sealed trait RequestDestination
          extends StObject
             with js.Any
        
        @js.native
        trait RequestInit extends StObject {
          
          var body: js.UndefOr[BodyInit] = js.native
          
          var cache: js.UndefOr[RequestCache] = js.native
          
          var credentials: js.UndefOr[RequestCredentials] = js.native
          
          var headers: js.UndefOr[HeadersInit] = js.native
          
          var integrity: js.UndefOr[String] = js.native
          
          var keepalive: js.UndefOr[Boolean] = js.native
          
          var method: js.UndefOr[HttpMethod] = js.native
          
          var mode: js.UndefOr[RequestMode] = js.native
          
          var redirect: js.UndefOr[RequestRedirect] = js.native
          
          var referrer: js.UndefOr[String] = js.native
          
          var referrerPolicy: js.UndefOr[ReferrerPolicy] = js.native
          
          var signal: js.UndefOr[AbortSignal] = js.native
          
          var window: js.UndefOr[Null] = js.native
        }
        
        @js.native
        sealed trait RequestMode
          extends StObject
             with js.Any
        
        @js.native
        sealed trait RequestRedirect
          extends StObject
             with js.Any
        
        @js.native
        sealed trait RequestType
          extends StObject
             with js.Any
        
        @js.native
        class Response protected ()
          extends StObject
             with Body {
          def this(content: BodyInit, init: ResponseInit) = this()
          
          val body: ReadableStream[js.typedarray.Uint8Array] = js.native
          
          override def clone(): Response = js.native
          
          val content: BodyInit = js.native
          
          val headers: Headers = js.native
          
          val init: ResponseInit = js.native
          
          def ok(): Boolean = js.native
          
          val status: Int = js.native
          
          def statusText(): ByteString = js.native
          
          def `type`(): ResponseType = js.native
          
          def url(): String = js.native
        }
        @js.native
        object Response extends StObject {
          
          def error(): Response = js.native
          
          def redirect(url: String, status: Int): Response = js.native
        }
        
        @js.native
        trait ResponseInit extends StObject {
          
          var headers: HeadersInit = js.native
          
          var status: Int = js.native
          
          var statusText: ByteString = js.native
        }
        
        @js.native
        sealed trait ResponseType
          extends StObject
             with js.Any
        
        type Sequence[T] = js.Array[T]
        
        @js.native
        class URL protected () extends StObject {
          def this(url: String, base: String) = this()
          
          val base: String = js.native
          
          var hash: String = js.native
          
          var host: String = js.native
          
          var hostname: String = js.native
          
          var href: String = js.native
          
          def origin(): String = js.native
          
          var password: String = js.native
          
          var pathname: String = js.native
          
          var port: String = js.native
          
          var protocol: String = js.native
          
          var search: String = js.native
          
          var searchParams: URLSearchParams = js.native
          
          val url: String = js.native
          
          var username: String = js.native
        }
        
        @js.native
        class URLSearchParams ()
          extends StObject
             with js.Iterable[js.Tuple2[String, String]] {
          def this(init: String) = this()
          def this(init: js.Dictionary[String]) = this()
          def this(init: Sequence[String]) = this()
          
          def append(name: String, value: String): Unit = js.native
          
          def delete(name: String): Unit = js.native
          
          def entries(): js.Iterator[js.Tuple2[String, String]] = js.native
          
          def forEach(callback: js.Function2[String, String, Unit]): Unit = js.native
          
          def get(name: String): String = js.native
          
          def getAll(name: String): Sequence[String] = js.native
          
          def has(name: String): Boolean = js.native
          
          override def jsIterator(): js.Iterator[js.Tuple2[String, String]] = js.native
          
          def keys(): js.Iterator[String] = js.native
          
          def set(name: String, value: String): Unit = js.native
          
          def sort(): Unit = js.native
          
          def values(): js.Iterator[String] = js.native
        }
        
        object Vibration {
          
          @js.native
          trait VibrationNavigator
            extends StObject
               with js.Any {
            
            def vibrate(duration: Double): Boolean = js.native
            def vibrate(pattern: js.Array[Double]): Boolean = js.native
          }
        }
        
        @js.native
        sealed trait WriteableState
          extends StObject
             with js.Any
        
        @js.native
        trait WriteableStream[T] extends StObject {
          
          def abort(reason: Any): Unit = js.native
          
          def close(): js.Promise[WriteableStream[T]] = js.native
          
          val closed: js.Promise[WriteableStream[T]] = js.native
          
          val ready: js.Promise[WriteableStream[T]] = js.native
          
          def state(): WriteableState = js.native
          
          def write(chunk: Chunk[T]): js.Promise[Any] = js.native
        }
        
        object beacon {
          
          @js.native
          trait BeaconNavigator extends StObject {
            
            def sendBeacon(url: String, data: BodyInit): Boolean = js.native
          }
          
          @js.native
          trait BeaconWorkerNavigator extends StObject {
            
            def sendBeacon(url: String, data: BodyInit): Boolean = js.native
          }
        }
        
        object deviceorientation {
          
          @js.native
          trait DeviceAcceleration
            extends StObject
               with js.Any {
            
            val x: Double = js.native
            
            val y: Double = js.native
            
            val z: Double = js.native
          }
          
          @js.native
          class DeviceMotionEvent protected ()
            extends StObject
               with Event {
            def this(typeArg: String, init: js.UndefOr[DeviceMotionEventInit]) = this()
            
            val acceleration: DeviceAcceleration = js.native
            
            val accelerationIncludingGravity: DeviceAcceleration = js.native
            
            val init: js.UndefOr[DeviceMotionEventInit] = js.native
            
            val interval: Double = js.native
            
            val rotationRate: DeviceRotationRate = js.native
            
            val typeArg: String = js.native
          }
          
          @js.native
          trait DeviceMotionEventInit
            extends StObject
               with EventInit {
            
            val acceleration: js.UndefOr[DeviceAcceleration] = js.native
            
            val accelerationIncludingGravity: js.UndefOr[DeviceAcceleration] = js.native
            
            val interval: js.UndefOr[Double] = js.native
            
            val rotationRate: js.UndefOr[DeviceRotationRate] = js.native
          }
          
          @js.native
          class DeviceOrientationEvent protected ()
            extends StObject
               with Event {
            def this(typeArg: String, init: js.UndefOr[DeviceOrientationEventInit]) = this()
            
            val absolute: Boolean = js.native
            
            val alpha: Double = js.native
            
            val beta: Double = js.native
            
            val gamma: Double = js.native
            
            val init: js.UndefOr[DeviceOrientationEventInit] = js.native
            
            val typeArg: String = js.native
          }
          
          @js.native
          trait DeviceOrientationEventInit
            extends StObject
               with EventInit {
            
            var absolute: js.UndefOr[Boolean] = js.native
            
            var alpha: js.UndefOr[Double] = js.native
            
            var beta: js.UndefOr[Double] = js.native
            
            var gamma: js.UndefOr[Double] = js.native
          }
          
          @js.native
          trait DeviceRotationRate
            extends StObject
               with js.Any {
            
            val alpha: Double = js.native
            
            val beta: Double = js.native
            
            val gamma: Double = js.native
          }
        }
        
        object domparser {
          
          @js.native
          class DOMParser () extends StObject {
            
            def parseFromString(string: String, supportedType: SupportedType): org.scalajs.dom.raw.Document = js.native
          }
          
          @js.native
          sealed trait SupportedType
            extends StObject
               with js.Any
        }
        
        object gamepad {
          
          @js.native
          trait Gamepad
            extends StObject
               with js.Any {
            
            val axes: js.Array[Double] = js.native
            
            val buttons: js.Array[GamepadButton] = js.native
            
            val connected: Boolean = js.native
            
            val id: String = js.native
            
            val index: Double = js.native
            
            val mapping: GamepadMappingType = js.native
            
            val timestamp: Double = js.native
          }
          
          @js.native
          trait GamepadButton
            extends StObject
               with js.Any {
            
            val pressed: Boolean = js.native
            
            val value: Double = js.native
          }
          
          @js.native
          class GamepadEvent protected ()
            extends StObject
               with Event {
            def this(typeArg: String, init: js.UndefOr[GamepadEventInit]) = this()
            
            val gamepad: Gamepad = js.native
            
            val init: js.UndefOr[GamepadEventInit] = js.native
            
            val typeArg: String = js.native
          }
          
          @js.native
          trait GamepadEventInit
            extends StObject
               with EventInit {
            
            var gamepad: js.UndefOr[Gamepad] = js.native
          }
          
          @js.native
          trait GamepadMappingType
            extends StObject
               with js.Any
          
          @js.native
          trait GamepadNavigator
            extends StObject
               with js.Any {
            
            def getGamepads(): js.Array[Gamepad] = js.native
          }
        }
        
        object intl {
          
          @js.native
          class Collator protected () extends StObject {
            def this(locales: js.UndefOr[String | js.Array[String]], options: js.UndefOr[CollatorOptions]) = this()
            
            def compare(string1: String, string2: String): Double = js.native
            
            val locales: js.UndefOr[String | js.Array[String]] = js.native
            
            val options: js.UndefOr[CollatorOptions] = js.native
            
            def resolvedOptions(): CollatorOptions = js.native
            
            def supportedLocalesOf(locales: String | js.Array[String], options: js.Any): js.Array[String] = js.native
          }
          
          @js.native
          trait CollatorOptions extends StObject {
            
            val caseFirst: js.UndefOr[String] = js.native
            
            val ignorePunctuation: js.UndefOr[Boolean] = js.native
            
            val localeMatcher: js.UndefOr[String] = js.native
            
            val numeric: js.UndefOr[Boolean] = js.native
            
            val sensitivity: js.UndefOr[String] = js.native
            
            val usage: js.UndefOr[String] = js.native
          }
          
          @js.native
          class DateTimeFormat protected () extends StObject {
            def this(locales: js.UndefOr[String | js.Array[String]], options: js.UndefOr[DateTimeFormatOptions]) = this()
            
            def format(date: js.Date): String = js.native
            
            val locales: js.UndefOr[String | js.Array[String]] = js.native
            
            val options: js.UndefOr[DateTimeFormatOptions] = js.native
            
            def resolvedOptions(): DateTimeFormatOptions = js.native
            
            def supportedLocalesOf(locales: String | js.Array[String], options: js.Any): js.Array[String] = js.native
          }
          
          @js.native
          trait DateTimeFormatOptions extends StObject {
            
            val day: js.UndefOr[String] = js.native
            
            val era: js.UndefOr[String] = js.native
            
            val formatMatcher: js.UndefOr[String] = js.native
            
            val hour: js.UndefOr[String] = js.native
            
            val hour12: js.UndefOr[Boolean] = js.native
            
            val localeMatcher: js.UndefOr[String] = js.native
            
            val minute: js.UndefOr[String] = js.native
            
            val month: js.UndefOr[String] = js.native
            
            val second: js.UndefOr[String] = js.native
            
            val timeZone: js.UndefOr[String] = js.native
            
            val timeZoneName: js.UndefOr[String] = js.native
            
            val weekday: js.UndefOr[String] = js.native
            
            val year: js.UndefOr[String] = js.native
          }
          
          @js.native
          class NumberFormat protected () extends StObject {
            def this(locales: js.UndefOr[String | js.Array[String]], options: js.UndefOr[NumberFormatOptions]) = this()
            
            def format(number: Double): String = js.native
            
            val locales: js.UndefOr[String | js.Array[String]] = js.native
            
            val options: js.UndefOr[NumberFormatOptions] = js.native
            
            def resolvedOptions(): NumberFormatOptions = js.native
            
            def supportedLocalesOf(locales: String | js.Array[String], options: js.Any): js.Array[String] = js.native
          }
          
          @js.native
          trait NumberFormatOptions extends StObject {
            
            val currency: js.UndefOr[String] = js.native
            
            val currencyDisplay: js.UndefOr[String] = js.native
            
            val localeMatcher: js.UndefOr[String] = js.native
            
            val maximumFractionDigits: js.UndefOr[Double] = js.native
            
            val maximumSignificantDigits: js.UndefOr[Double] = js.native
            
            val minimumFractionDigits: js.UndefOr[Double] = js.native
            
            val minimumIntegerDigits: js.UndefOr[Double] = js.native
            
            val minimumSignificantDigits: js.UndefOr[Double] = js.native
            
            val style: js.UndefOr[String] = js.native
            
            val useGrouping: js.UndefOr[Boolean] = js.native
          }
        }
        
        object mediastream {
          
          @js.native
          trait MediaDeviceInfo extends StObject {
            
            val deviceId: String = js.native
            
            val groupId: String = js.native
            
            val kind: MediaDeviceKind = js.native
            
            val label: String = js.native
          }
          
          @js.native
          trait MediaDeviceKind
            extends StObject
               with js.Any
          
          @js.native
          trait MediaDevices
            extends StObject
               with org.scalajs.dom.raw.EventTarget {
            
            def enumerateDevices(): js.Promise[js.Array[MediaDeviceInfo]] = js.native
            
            def getSupportedConstraints(): MediaTrackSupportedConstraints = js.native
            
            def getUserMedia(constraints: MediaStreamConstraints): js.Promise[MediaStream] = js.native
            
            var ondevicechange: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
          }
          
          @js.native
          class MediaStream ()
            extends StObject
               with org.scalajs.dom.raw.EventTarget {
            
            val active: Boolean = js.native
            
            def addTrack(track: MediaStreamTrack): Unit = js.native
            
            override def clone(): MediaStream = js.native
            
            def getAudioTracks(): js.Array[MediaStreamTrack] = js.native
            
            def getTrackById(trackId: String): MediaStreamTrack = js.native
            
            def getTracks(): js.Array[MediaStreamTrack] = js.native
            
            def getVideoTracks(): js.Array[MediaStreamTrack] = js.native
            
            val id: String = js.native
            
            var onaddtrack: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onremovetrack: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            def removeTrack(track: MediaStreamTrack): Unit = js.native
          }
          
          @js.native
          trait MediaStreamConstraints extends StObject {
            
            var audio: Boolean | MediaTrackConstraints = js.native
            
            var peerIdentity: String = js.native
            
            var video: Boolean | MediaTrackConstraints = js.native
          }
          
          @js.native
          trait MediaStreamTrack
            extends StObject
               with org.scalajs.dom.raw.EventTarget {
            
            def applyConstraints(constraints: MediaTrackConstraints): js.Promise[Unit] = js.native
            
            override def clone(): MediaStreamTrack = js.native
            
            var enabled: Boolean = js.native
            
            def getCapabilities(): js.Any = js.native
            
            def getConstraints(): MediaTrackConstraints = js.native
            
            def getSettings(): js.Any = js.native
            
            val id: String = js.native
            
            val kind: String = js.native
            
            val label: String = js.native
            
            val muted: Boolean = js.native
            
            var onended: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onmute: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onoverconstrained: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onstarted: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onunmute: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            val readonly: Boolean = js.native
            
            val readyState: MediaStreamTrackState = js.native
            
            val remote: Boolean = js.native
            
            def stop(): Unit = js.native
          }
          
          @js.native
          class MediaStreamTrackEvent protected ()
            extends StObject
               with org.scalajs.dom.raw.Event {
            def this(typeArg: String, init: js.UndefOr[MediaStreamTrackEventInit]) = this()
            
            val init: js.UndefOr[MediaStreamTrackEventInit] = js.native
            
            val track: MediaStreamTrack = js.native
            
            val typeArg: String = js.native
          }
          
          @js.native
          trait MediaStreamTrackEventInit
            extends StObject
               with EventInit {
            
            var track: js.UndefOr[MediaStreamTrack] = js.native
          }
          
          @js.native
          trait MediaStreamTrackState
            extends StObject
               with js.Any
          
          @js.native
          trait MediaTrackConstraintSet extends StObject {
            
            var aspectRatio: Double = js.native
            
            var deviceId: String = js.native
            
            var echoCancellation: Boolean = js.native
            
            var facingMode: String = js.native
            
            var frameRate: Double = js.native
            
            var groupId: String = js.native
            
            var height: Double = js.native
            
            var sampleRate: Double = js.native
            
            var sampleSize: Double = js.native
            
            var volume: Double = js.native
            
            var width: Double = js.native
          }
          
          @js.native
          trait MediaTrackConstraints
            extends StObject
               with MediaTrackConstraintSet {
            
            var advanced: js.Array[MediaTrackConstraintSet] = js.native
          }
          
          @js.native
          trait MediaTrackSettings extends StObject {
            
            var aspectRatio: js.UndefOr[Double] = js.native
            
            var channelCount: js.UndefOr[Double] = js.native
            
            var deviceId: js.UndefOr[String] = js.native
            
            var echoCancellation: js.UndefOr[Boolean] = js.native
            
            var facingMode: js.UndefOr[String] = js.native
            
            var frameRate: js.UndefOr[Double] = js.native
            
            var groupId: js.UndefOr[String] = js.native
            
            var height: js.UndefOr[Double] = js.native
            
            var latency: js.UndefOr[Double] = js.native
            
            var sampleRate: js.UndefOr[Double] = js.native
            
            var sampleSize: js.UndefOr[Double] = js.native
            
            var volume: js.UndefOr[Double] = js.native
            
            var width: js.UndefOr[Double] = js.native
          }
          
          @js.native
          trait MediaTrackSupportedConstraints extends StObject {
            
            var aspectRatio: js.UndefOr[Boolean] = js.native
            
            var channelCount: js.UndefOr[Boolean] = js.native
            
            var deviceId: js.UndefOr[Boolean] = js.native
            
            var echoCancellation: js.UndefOr[Boolean] = js.native
            
            var facingMode: js.UndefOr[Boolean] = js.native
            
            var frameRate: js.UndefOr[Boolean] = js.native
            
            var groupId: js.UndefOr[Boolean] = js.native
            
            var height: js.UndefOr[Boolean] = js.native
            
            var latency: js.UndefOr[Boolean] = js.native
            
            var sampleRate: js.UndefOr[Boolean] = js.native
            
            var sampleSize: js.UndefOr[Boolean] = js.native
            
            var volume: js.UndefOr[Boolean] = js.native
            
            var width: js.UndefOr[Boolean] = js.native
          }
        }
        
        object permissions {
          
          @js.native
          trait PermissionDescriptor extends StObject {
            
            val name: PermissionName = js.native
          }
          
          @js.native
          sealed trait PermissionName
            extends StObject
               with js.Any
          
          @js.native
          sealed trait PermissionState
            extends StObject
               with js.Any
          
          @js.native
          trait PermissionStatus
            extends StObject
               with org.scalajs.dom.raw.EventTarget {
            
            var onchange: js.Function1[Event, _] = js.native
            
            val state: PermissionState = js.native
          }
          
          @js.native
          trait Permissions extends StObject {
            
            def query(permissionDescriptor: PermissionDescriptor): js.Promise[PermissionStatus] = js.native
          }
          
          @js.native
          trait PermissionsNavigator extends StObject {
            
            val permissions: Permissions = js.native
          }
          
          @js.native
          trait PushPermissionDescriptor
            extends StObject
               with PermissionDescriptor {
            
            val userVisibleOnly: Boolean = js.native
          }
        }
        
        object push {
          
          @js.native
          sealed trait PushEncryptionKeyName
            extends StObject
               with js.Any
          
          @js.native
          trait PushEvent
            extends StObject
               with ExtendableEvent {
            
            val data: PushMessageData = js.native
          }
          
          @js.native
          trait PushManager extends StObject {
            
            def getSubscription(): js.Promise[PushSubscription] = js.native
            
            def permissionState(options: PushSubscriptionOptions): js.Promise[PushPermissionState] = js.native
            
            def subscribe(options: PushSubscriptionOptions): js.Promise[PushSubscription] = js.native
          }
          
          @js.native
          trait PushMessageData extends StObject {
            
            def arrayBuffer(): js.typedarray.ArrayBuffer = js.native
            
            def blob(): org.scalajs.dom.raw.Blob = js.native
            
            def json(): js.Any = js.native
            
            def text(): String = js.native
          }
          
          @js.native
          sealed trait PushPermissionState
            extends StObject
               with js.Any
          
          @js.native
          trait PushServiceWorkerGlobalScope
            extends StObject
               with js.Any {
            
            var onpush: js.Function1[PushEvent, _] = js.native
            
            var onpushsubscriptionchange: js.Function1[PushEvent, _] = js.native
          }
          
          @js.native
          trait PushServiceWorkerRegistration
            extends StObject
               with js.Any {
            
            val pushManager: PushManager = js.native
          }
          
          @js.native
          trait PushSubscription extends StObject {
            
            val endpoint: String = js.native
            
            val expirationTime: java.lang.Double = js.native
            
            def getKey(name: PushEncryptionKeyName): js.typedarray.ArrayBuffer = js.native
            
            val options: PushSubscriptionOptions = js.native
            
            def toJSON(): PushSubscriptionJSON = js.native
            
            def unsubscribe(): js.Promise[Boolean] = js.native
          }
          
          @js.native
          trait PushSubscriptionJSON extends StObject {
            
            val endpoint: String = js.native
            
            val expirationTime: java.lang.Double = js.native
            
            val keys: js.Dictionary[String] = js.native
          }
          
          @js.native
          trait PushSubscriptionOptions extends StObject {
            
            var applicationServerKey: js.UndefOr[js.typedarray.Uint8Array] = js.native
            
            var userVisibleOnly: js.UndefOr[Boolean] = js.native
          }
        }
        
        object serviceworkers {
          
          @js.native
          abstract class Cache () extends StObject {
            
            def add(request: RequestInfo): js.Promise[Unit] = js.native
            
            def addAll(requests: js.Array[RequestInfo]): js.Promise[Unit] = js.native
            
            def delete(request: RequestInfo, options: js.UndefOr[CacheQueryOptions]): js.Promise[Boolean] = js.native
            
            def keys(request: js.UndefOr[RequestInfo], options: js.UndefOr[CacheQueryOptions]): js.Promise[js.Array[Request]] = js.native
            
            def `match`(request: RequestInfo, options: js.UndefOr[CacheQueryOptions]): js.Promise[js.UndefOr[Response]] = js.native
            
            def matchAll(request: RequestInfo, options: js.UndefOr[CacheQueryOptions]): js.Promise[js.Array[Response]] = js.native
            
            def put(request: RequestInfo, response: Response): js.Promise[Unit] = js.native
          }
          
          @js.native
          trait CacheQueryOptions extends StObject {
            
            var cacheName: String = js.native
            
            var ignoreMethod: Boolean = js.native
            
            var ignoreSearch: Boolean = js.native
            
            var ignoreVary: Boolean = js.native
          }
          
          @js.native
          trait CacheStorage extends StObject {
            
            def delete(cacheName: String): js.Promise[Boolean] = js.native
            
            def has(cacheName: String): js.Promise[Boolean] = js.native
            
            def keys(): js.Promise[js.Array[String]] = js.native
            
            def `match`(request: RequestInfo, options: CacheQueryOptions): js.Promise[js.Any] = js.native
            
            def open(cacheName: String): js.Promise[Cache] = js.native
          }
          
          @js.native
          trait CanvasProxy
            extends StObject
               with js.Any {
            
            def setContext(context: RenderingContext): Unit = js.native
          }
          
          @js.native
          trait Client extends StObject {
            
            def frameType(): FrameType = js.native
            
            def id(): String = js.native
            
            def postMessage(message: Any, transfer: Sequence[org.scalajs.dom.experimental.serviceworkers.Transferable]): Unit = js.native
            
            def url(): String = js.native
          }
          
          @js.native
          trait ClientQueryOptions extends StObject {
            
            var includeUncontrolled: Boolean = js.native
            
            var `type`: ClientType = js.native
          }
          
          @js.native
          sealed trait ClientType
            extends StObject
               with js.Any
          
          @js.native
          trait Clients extends StObject {
            
            def claim(): js.Promise[Unit] = js.native
            
            def get(id: String): js.Promise[js.UndefOr[Client]] = js.native
            
            def matchAll(options: js.UndefOr[ClientQueryOptions]): js.Promise[js.Array[Client]] = js.native
            
            def openWindow(url: String): js.Promise[WindowClient] = js.native
          }
          
          @js.native
          class ExtendableEvent protected ()
            extends StObject
               with Event {
            def this(typeArg: String, init: js.UndefOr[ExtendableEventInit]) = this()
            
            val init: js.UndefOr[ExtendableEventInit] = js.native
            
            val typeArg: String = js.native
            
            def waitUntil(promise: js.Promise[Any]): Unit = js.native
          }
          
          @js.native
          trait ExtendableEventInit
            extends StObject
               with EventInit
          
          @js.native
          class ExtendableMessageEvent protected ()
            extends StObject
               with ExtendableEvent {
            def this(typeArg: String, init: js.UndefOr[ExtendableMessageEventInit]) = this()
            
            val data: Any = js.native
            
            val init: js.UndefOr[ExtendableMessageEventInit] = js.native
            
            val lastEventId: String = js.native
            
            val origin: String = js.native
            
            def ports(): js.Array[MessagePort] = js.native
            
            def source(): ServiceWorker | MessagePort = js.native
            
            val typeArg: String = js.native
          }
          
          @js.native
          trait ExtendableMessageEventInit
            extends StObject
               with ExtendableEventInit {
            
            var data: js.UndefOr[Any] = js.native
            
            var lastEventId: js.UndefOr[String] = js.native
            
            var origin: js.UndefOr[String] = js.native
            
            var ports: js.UndefOr[js.Array[MessagePort]] = js.native
            
            var source: js.UndefOr[Client | ServiceWorker | MessagePort] = js.native
          }
          
          @js.native
          class FetchEvent protected ()
            extends StObject
               with Event {
            def this(typeArg: String, init: js.UndefOr[FetchEventInit]) = this()
            
            def clientId(): String = js.native
            
            val init: js.UndefOr[FetchEventInit] = js.native
            
            def isReload(): Boolean = js.native
            
            def preloadResponse(): js.Promise[Response] = js.native
            
            def replacesClientId(): String = js.native
            
            def request(): Request = js.native
            
            def respondWith(promisedResponse: Response | js.Promise[Response]): Unit = js.native
            
            def resultingClientId(): String = js.native
            
            val typeArg: String = js.native
          }
          
          @js.native
          trait FetchEventInit
            extends StObject
               with EventInit {
            
            var clientId: js.UndefOr[String] = js.native
            
            var isReload: js.UndefOr[Boolean] = js.native
            
            var request: js.UndefOr[Request] = js.native
          }
          
          @js.native
          sealed trait FrameType
            extends StObject
               with js.Any
          
          @js.native
          trait GetNotificationOptions extends StObject {
            
            var tag: js.UndefOr[String] = js.native
          }
          
          @js.native
          trait ServiceWorker
            extends StObject
               with EventTarget {
            
            var onstatechange: js.Function1[Event, _] = js.native
            
            def postMessage(message: js.Any, transfer: js.Array[org.scalajs.dom.experimental.serviceworkers.Transferable]): Unit = js.native
            
            def scriptURL(): String = js.native
            
            def state(): String = js.native
          }
          
          @js.native
          trait ServiceWorkerContainer
            extends StObject
               with EventTarget {
            
            def controller(): ServiceWorker = js.native
            
            def getRegistration(scope: String): js.Promise[js.UndefOr[ServiceWorkerRegistration]] = js.native
            
            def getRegistrations(): js.Promise[js.Array[ServiceWorkerRegistration]] = js.native
            
            var oncontrollerchange: js.Function1[Event, _] = js.native
            
            var onerror: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
            
            var onmessage: js.Function1[MessageEvent, _] = js.native
            
            def ready(): js.Promise[ServiceWorkerRegistration] = js.native
            
            def register(scriptURL: String, options: js.Object): js.Promise[ServiceWorkerRegistration] = js.native
          }
          
          @js.native
          trait ServiceWorkerGlobalScope
            extends StObject
               with org.scalajs.dom.raw.EventTarget
               with WorkerGlobalScope {
            
            override def caches(): CacheStorage = js.native
            
            def clients(): Clients = js.native
            
            var onactivate: js.Function1[ExtendableEvent, _] = js.native
            
            var onfetch: js.Function1[FetchEvent, _] = js.native
            
            var oninstall: js.Function1[ExtendableEvent, _] = js.native
            
            var onmessage: js.Function1[MessageEvent, _] = js.native
            
            def registration(): ServiceWorkerRegistration = js.native
            
            def skipWaiting(): js.Promise[Unit] = js.native
          }
          @js.native
          object ServiceWorkerGlobalScope extends StObject {
            
            def self(): ServiceWorkerGlobalScope = js.native
          }
          
          @js.native
          trait ServiceWorkerMessageEventInit
            extends StObject
               with EventInit {
            
            var data: js.UndefOr[Any] = js.native
            
            var lastEventId: js.UndefOr[String] = js.native
            
            var origin: js.UndefOr[String] = js.native
            
            var ports: js.UndefOr[js.Array[MessagePort]] = js.native
            
            var source: js.UndefOr[ServiceWorker | MessagePort] = js.native
          }
          
          @js.native
          trait ServiceWorkerNavigator
            extends StObject
               with js.Any {
            
            val serviceWorker: ServiceWorkerContainer = js.native
          }
          
          @js.native
          trait ServiceWorkerRegistration
            extends StObject
               with EventTarget {
            
            var active: ServiceWorker = js.native
            
            def getNotifications(options: GetNotificationOptions): js.Promise[Sequence[Notification]] = js.native
            
            var installing: ServiceWorker = js.native
            
            var onupdatefound: js.Function1[Event, _] = js.native
            
            var scope: String = js.native
            
            def showNotification(title: String, options: NotificationOptions): js.Promise[Unit] = js.native
            
            def unregister(): js.Promise[Boolean] = js.native
            
            def update(): js.Promise[Unit] = js.native
            
            var waiting: ServiceWorker = js.native
          }
          
          @js.native
          sealed trait ServiceWorkerState
            extends StObject
               with js.Any
          
          type Transferable = org.scalajs.dom.raw.Transferable | CanvasProxy
          
          @js.native
          trait WindowClient
            extends StObject
               with Client {
            
            def focus(): js.Promise[WindowClient] = js.native
            
            def focused(): Boolean = js.native
            
            def navigate(url: String): js.Promise[WindowClient] = js.native
            
            def visibilityState(): String = js.native
          }
        }
        
        object sharedworkers {
          
          @js.native
          class SharedWorker protected ()
            extends StObject
               with org.scalajs.dom.raw.EventTarget
               with AbstractWorker {
            def this(stringUrl: String, name: js.UndefOr[String]) = this()
            
            val name: js.UndefOr[String] = js.native
            
            def port(): org.scalajs.dom.raw.MessagePort = js.native
            
            val stringUrl: String = js.native
          }
          
          @js.native
          trait SharedWorkerGlobalScope
            extends StObject
               with org.scalajs.dom.raw.EventTarget
               with WorkerGlobalScope {
            
            def applicationCache(): org.scalajs.dom.raw.ApplicationCache = js.native
            
            def name(): String = js.native
            
            var onconnect: ExtendableMessageEvent => _ = js.native
          }
          @js.native
          object SharedWorkerGlobalScope extends StObject {
            
            def self(): SharedWorkerGlobalScope = js.native
          }
        }
        
        object storage {
          
          @js.native
          trait NavigatorStorage extends StObject {
            
            val storage: StorageManager = js.native
          }
          
          @js.native
          trait StorageEstimate
            extends StObject
               with js.Any {
            
            val quota: Double = js.native
            
            val usage: Double = js.native
          }
          
          @js.native
          trait StorageManager
            extends StObject
               with js.Any {
            
            def estimate(): js.Promise[StorageEstimate] = js.native
            
            def persist(): js.Promise[Boolean] = js.native
            
            def persisted(): js.Promise[Boolean] = js.native
          }
        }
        
        object webgl {
          
          object extensions {
            
            @js.native
            trait ANGLEInstancedArrays extends StObject {
              
              val VERTEX_ATTRIB_ARRAY_DIVISOR_ANGLE: Int = js.native
              
              def drawArraysInstancedANGLE(mode: Int, first: Int, count: Int, primcount: Int): Unit = js.native
              
              def drawElementsInstancedANGLE(mode: Int, count: Int, `type`: Int, offset: Int, primcount: Int): Unit = js.native
              
              def vertexAttribDivisorANGLE(index: Int, divisor: Int): Unit = js.native
            }
            
            @js.native
            trait EXTBlendMinmax extends StObject {
              
              val MAX_EXT: Int = js.native
              
              val MIN_EXT: Int = js.native
            }
            
            @js.native
            trait EXTColorBufferHalfFloat extends StObject {
              
              val FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE_EXT: Int = js.native
              
              val RGB16F_EXT: Int = js.native
              
              val RGBA16F_EXT: Int = js.native
              
              val UNSIGNED_NORMALIZED_EXT: Int = js.native
            }
            
            @js.native
            trait EXTDisjointTimerQuery extends StObject {
              
              val CURRENT_QUERY_EXT: Int = js.native
              
              val GPU_DISJOINT_EXT: Int = js.native
              
              val QUERY_COUNTER_BITS_EXT: Int = js.native
              
              val QUERY_RESULT_AVAILABLE_EXT: Int = js.native
              
              val QUERY_RESULT_EXT: Int = js.native
              
              val TIMESTAMP_EXT: Int = js.native
              
              val TIME_ELAPSED_EXT: Int = js.native
              
              def beginQueryEXT(target: Int, query: WebGLTimerQueryEXT): Unit = js.native
              
              def createQueryEXT(): WebGLTimerQueryEXT = js.native
              
              def deleteQueryEXT(query: WebGLTimerQueryEXT): Unit = js.native
              
              def endQueryEXT(target: Int): Unit = js.native
              
              def getQueryEXT(target: Int, pname: Int): js.Any = js.native
              
              def getQueryObjectEXT(target: Int, pname: Int): js.Any = js.native
              
              def isQueryEXT(query: WebGLTimerQueryEXT): Boolean = js.native
              
              def queryCounterEXT(query: WebGLTimerQueryEXT, target: Int): Unit = js.native
            }
            
            @js.native
            trait EXTFragDepth extends StObject
            
            @js.native
            trait EXTShaderTextureLOD extends StObject
            
            @js.native
            trait EXTTextureFilterAnisotropic extends StObject {
              
              val MAX_TEXTURE_MAX_ANISOTROPY_EXT: Int = js.native
              
              val TEXTURE_MAX_ANISOTROPY_EXT: Int = js.native
            }
            
            @js.native
            trait EXTsRGB extends StObject {
              
              val FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING_EXT: Int = js.native
              
              val SRGB8_ALPHA8_EXT: Int = js.native
              
              val SRGB_ALPHA_EXT: Int = js.native
              
              val SRGB_EXT: Int = js.native
            }
            
            @js.native
            trait OESElementIndexUint extends StObject
            
            @js.native
            trait OESStandardDerivatives extends StObject {
              
              val FRAGMENT_SHADER_DERIVATIVE_HINT_OES: Int = js.native
            }
            
            @js.native
            trait OESTextureFloat extends StObject
            
            @js.native
            trait OESTextureFloatLinear extends StObject
            
            @js.native
            trait OESTextureHalfFloat extends StObject {
              
              val HALF_FLOAT_OES: Int = js.native
            }
            
            @js.native
            trait OESTextureHalfFloatLinear extends StObject
            
            @js.native
            trait OESVertexArrayObject extends StObject {
              
              val VERTEX_ARRAY_BINDING_OES: Int = js.native
              
              def bindVertexArrayOES(arrayObject: WebGLVertexArrayObjectOES): Unit = js.native
              
              def createVertexArrayOES(): WebGLVertexArrayObjectOES = js.native
              
              def deleteVertexArrayOES(arrayObject: WebGLVertexArrayObjectOES): Unit = js.native
              
              def isVertexArrayOES(arrayObject: WebGLVertexArrayObjectOES): Boolean = js.native
            }
            
            @js.native
            trait WEBGLColorBufferFloat extends StObject {
              
              val FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE_EXT: Int = js.native
              
              val RGBA32F_EXT: Int = js.native
              
              val UNSIGNED_NORMALIZED_EXT: Int = js.native
            }
            
            @js.native
            trait WEBGLCompressedTextureETC1 extends StObject {
              
              val COMPRESSED_RGB_ETC1_WEBGL: Int = js.native
            }
            
            @js.native
            trait WEBGLDrawBuffers extends StObject {
              
              val COLOR_ATTACHMENT0_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT10_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT11_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT12_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT13_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT14_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT15_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT1_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT2_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT3_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT4_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT5_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT6_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT7_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT8_WEBGL: Int = js.native
              
              val COLOR_ATTACHMENT9_WEBGL: Int = js.native
              
              val DRAW_BUFFER0_WEBGL: Int = js.native
              
              val DRAW_BUFFER10_WEBGL: Int = js.native
              
              val DRAW_BUFFER11_WEBGL: Int = js.native
              
              val DRAW_BUFFER12_WEBGL: Int = js.native
              
              val DRAW_BUFFER13_WEBGL: Int = js.native
              
              val DRAW_BUFFER14_WEBGL: Int = js.native
              
              val DRAW_BUFFER15_WEBGL: Int = js.native
              
              val DRAW_BUFFER1_WEBGL: Int = js.native
              
              val DRAW_BUFFER2_WEBGL: Int = js.native
              
              val DRAW_BUFFER3_WEBGL: Int = js.native
              
              val DRAW_BUFFER4_WEBGL: Int = js.native
              
              val DRAW_BUFFER5_WEBGL: Int = js.native
              
              val DRAW_BUFFER6_WEBGL: Int = js.native
              
              val DRAW_BUFFER7_WEBGL: Int = js.native
              
              val DRAW_BUFFER8_WEBGL: Int = js.native
              
              val DRAW_BUFFER9_WEBGL: Int = js.native
              
              val MAX_COLOR_ATTACHMENTS_WEBGL: Int = js.native
              
              val MAX_DRAW_BUFFERS_WEBGL: Int = js.native
              
              def drawBuffersWEBGL(buffers: js.Array[Int]): Unit = js.native
            }
            
            @js.native
            trait WebGLCompressedTextureATC extends StObject {
              
              val COMPRESSED_RGBA_ATC_EXPLICIT_ALPHA_WEBGL: Int = js.native
              
              val COMPRESSED_RGBA_ATC_INTERPOLATED_ALPHA_WEBGL: Int = js.native
              
              val COMPRESSED_RGB_ATC_WEBGL: Int = js.native
            }
            
            @js.native
            trait WebGLCompressedTexturePVRTC extends StObject {
              
              val COMPRESSED_RGBA_PVRTC_2BPPV1_IMG: Int = js.native
              
              val COMPRESSED_RGBA_PVRTC_4BPPV1_IMG: Int = js.native
              
              val COMPRESSED_RGB_PVRTC_2BPPV1_IMG: Int = js.native
              
              val COMPRESSED_RGB_PVRTC_4BPPV1_IMG: Int = js.native
            }
            
            @js.native
            trait WebGLCompressedTextureS3TC extends StObject {
              
              val COMPRESSED_RGBA_S3TC_DXT1_EXT: Int = js.native
              
              val COMPRESSED_RGBA_S3TC_DXT3_EXT: Int = js.native
              
              val COMPRESSED_RGBA_S3TC_DXT5_EXT: Int = js.native
              
              val COMPRESSED_RGB_S3TC_DXT1_EXT: Int = js.native
            }
            
            @js.native
            trait WebGLDebugRendererInfo extends StObject {
              
              val UNMASKED_RENDERER_WEBGL: Int = js.native
              
              val UNMASKED_VENDOR_WEBGL: Int = js.native
            }
            
            @js.native
            trait WebGLDebugShaders extends StObject {
              
              def getTranslatedShaderSource(shader: WebGLShader): String = js.native
            }
            
            @js.native
            trait WebGLDepthTexture extends StObject {
              
              val UNSIGNED_INT_24_8_WEBGL: Int = js.native
            }
            
            @js.native
            trait WebGLLoseContext extends StObject {
              
              def loseContext(): Unit = js.native
              
              def restoreContext(): Unit = js.native
            }
            
            @js.native
            trait WebGLTimerQueryEXT extends StObject
            
            @js.native
            trait WebGLVertexArrayObjectOES extends StObject
          }
        }
        
        object webrtc {
          
          @js.native
          trait MediaStreamEventInit
            extends StObject
               with EventInit {
            
            var stream: js.UndefOr[MediaStream] = js.native
          }
          
          @js.native
          trait NavigatorMediaStream extends StObject {
            
            def mediaDevices(): MediaDevices = js.native
          }
          
          @js.native
          trait RTCBundlePolicy
            extends StObject
               with js.Any
          
          @js.native
          trait RTCConfiguration extends StObject {
            
            var bundlePolicy: RTCBundlePolicy = js.native
            
            var iceServers: js.Array[RTCIceServer] = js.native
            
            var iceTransportPolicy: RTCIceTransportPolicy = js.native
            
            var peerIdentity: String = js.native
          }
          
          @js.native
          trait RTCDTMFSender extends StObject {
            
            val canInsertDTMF: Boolean = js.native
            
            val duration: Double = js.native
            
            def insertDTMF(tones: String, duration: Double, interToneGap: Double): Unit = js.native
            
            val interToneGap: Double = js.native
            
            var ontonechange: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            val toneBuffer: String = js.native
            
            val track: MediaStreamTrack = js.native
          }
          
          @js.native
          trait RTCDataChannel
            extends StObject
               with org.scalajs.dom.raw.EventTarget {
            
            var binaryType: String = js.native
            
            def bufferedAmount(): Double = js.native
            
            def close(): Unit = js.native
            
            val id: Double = js.native
            
            val label: String = js.native
            
            val maxPacketLifeTime: Double = js.native
            
            val maxRetransmits: Double = js.native
            
            val negotiated: Boolean = js.native
            
            var onclose: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onerror: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onmessage: js.Function1[org.scalajs.dom.raw.MessageEvent, Any] = js.native
            
            var onopen: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            val ordered: Boolean = js.native
            
            val protocol: String = js.native
            
            def readyState(): RTCDataChannelState = js.native
            
            def send(data: String | Blob | js.typedarray.ArrayBuffer | js.typedarray.ArrayBufferView): Unit = js.native
          }
          
          @js.native
          class RTCDataChannelEvent protected ()
            extends StObject
               with org.scalajs.dom.raw.Event {
            def this(init: RTCDataChannelEventInit) = this()
            def this(typeArg: String, init: js.UndefOr[RTCDataChannelEventInit]) = this()
            
            val channel: RTCDataChannel = js.native
            
            val init: js.UndefOr[RTCDataChannelEventInit] = js.native
            
            val typeArg: String = js.native
          }
          
          @js.native
          trait RTCDataChannelEventInit
            extends StObject
               with EventInit {
            
            var channel: js.UndefOr[RTCDataChannel] = js.native
          }
          
          @js.native
          trait RTCDataChannelInit extends StObject {
            
            var id: Double = js.native
            
            var maxPacketLifeTime: Double = js.native
            
            var maxRetransmits: Double = js.native
            
            var negotiated: Boolean = js.native
            
            var ordered: Boolean = js.native
            
            var protocol: String = js.native
          }
          
          @js.native
          trait RTCDataChannelState
            extends StObject
               with js.Any
          
          @js.native
          class RTCIceCandidate protected () extends StObject {
            def this(candidateInitDict: RTCIceCandidateInit) = this()
            
            var candidate: String = js.native
            
            val candidateInitDict: RTCIceCandidateInit = js.native
            
            var sdpMLineIndex: Double = js.native
            
            var sdpMid: String = js.native
          }
          
          @js.native
          trait RTCIceCandidateInit extends StObject {
            
            var candidate: String = js.native
            
            var sdpMLineIndex: Double = js.native
            
            var sdpMid: String = js.native
          }
          
          @js.native
          trait RTCIceConnectionState
            extends StObject
               with js.Any
          
          @js.native
          trait RTCIceGatheringState
            extends StObject
               with js.Any
          
          @js.native
          trait RTCIceServer extends StObject {
            
            var credential: String = js.native
            
            var urls: String | js.Array[String] = js.native
            
            var username: String = js.native
          }
          
          @js.native
          trait RTCIceTransportPolicy
            extends StObject
               with js.Any
          
          @js.native
          trait RTCIdentityAssertion extends StObject {
            
            val idp: String = js.native
            
            val name: String = js.native
          }
          
          @js.native
          trait RTCOfferOptions extends StObject {
            
            var iceRestart: Boolean = js.native
            
            var offerToReceiveAudio: Double = js.native
            
            var offerToReceiveVideo: Double = js.native
            
            var voiceActivityDetection: Boolean = js.native
          }
          
          @js.native
          class RTCPeerConnection protected ()
            extends StObject
               with org.scalajs.dom.raw.EventTarget {
            def this(configuration: js.UndefOr[RTCConfiguration]) = this()
            
            def addIceCandidate(candidate: RTCIceCandidate): js.Promise[Unit] = js.native
            
            def addStream(stream: MediaStream): Unit = js.native
            
            val canTrickleIceCandidates: js.Any = js.native
            
            def close(): Unit = js.native
            
            val configuration: js.UndefOr[RTCConfiguration] = js.native
            
            def createAnswer(): js.Promise[RTCSessionDescription] = js.native
            
            def createDTMFSender(track: MediaStreamTrack): RTCDTMFSender = js.native
            
            def createDataChannel(label: String, dataChannelDict: RTCDataChannelInit): RTCDataChannel = js.native
            
            def createOffer(options: RTCOfferOptions): js.Promise[RTCSessionDescription] = js.native
            
            def getConfiguration(): RTCConfiguration = js.native
            
            def getIdentityAssertion(): js.Promise[Unit] = js.native
            
            def getLocalStreams(): js.Array[MediaStream] = js.native
            
            def getRemoteStreams(): js.Array[MediaStream] = js.native
            
            def getStats(
              selector: MediaStreamTrack,
              callback: js.Function1[RTCStatsReport, Any],
              error: js.Function1[org.scalajs.dom.raw.DOMException, Any]
            ): RTCStatsReport = js.native
            
            def getStreamById(id: String): MediaStream = js.native
            
            def iceConnectionState(): RTCIceConnectionState = js.native
            
            def iceGatheringState(): RTCIceGatheringState = js.native
            
            def localDescription(): RTCSessionDescription = js.native
            
            var ondatachannel: js.Function1[RTCDataChannelEvent, Any] = js.native
            
            var onicecandidate: js.Function1[RTCPeerConnectionIceEvent, Any] = js.native
            
            var oniceconnectionstatechange: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onidentityresult: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onidpassertionerror: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onidpvalidationerror: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onnegotiationneeded: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onpeeridentity: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var onremovetrack: js.Function1[MediaStreamTrackEvent, Any] = js.native
            
            var onsignalingstatechange: js.Function1[org.scalajs.dom.raw.Event, Any] = js.native
            
            var ontrack: js.Function1[MediaStreamTrackEvent, Any] = js.native
            
            val peerIdentity: RTCIdentityAssertion = js.native
            
            def remoteDescription(): RTCSessionDescription = js.native
            
            def removeStream(stream: MediaStream): Unit = js.native
            
            def setIdentityProvider(provider: String, protocol: String, usernameHint: String): Unit = js.native
            
            def setLocalDescription(description: RTCSessionDescription): js.Promise[Unit] = js.native
            
            def setRemoteDescription(description: RTCSessionDescription): js.Promise[Unit] = js.native
            
            def signalingState(): RTCSignalingState = js.native
            
            def updateIce(configuration: RTCConfiguration): Unit = js.native
          }
          
          @js.native
          class RTCPeerConnectionIceEvent protected ()
            extends StObject
               with org.scalajs.dom.raw.Event {
            def this(typeArg: String, init: js.UndefOr[RTCPeerConnectionIceEventInit]) = this()
            
            var candidate: RTCIceCandidate = js.native
            
            val init: js.UndefOr[RTCPeerConnectionIceEventInit] = js.native
            
            val typeArg: String = js.native
          }
          
          @js.native
          trait RTCPeerConnectionIceEventInit
            extends StObject
               with EventInit {
            
            var candidate: js.UndefOr[RTCIceCandidate] = js.native
          }
          
          @js.native
          trait RTCSdpType
            extends StObject
               with js.Any
          
          @js.native
          class RTCSessionDescription protected () extends StObject {
            def this(descriptionInitDict: js.UndefOr[RTCSessionDescriptionInit]) = this()
            
            val descriptionInitDict: js.UndefOr[RTCSessionDescriptionInit] = js.native
            
            var sdp: String = js.native
            
            var `type`: RTCSdpType = js.native
          }
          
          @js.native
          trait RTCSessionDescriptionInit extends StObject {
            
            var sdp: String = js.native
            
            var `type`: RTCSdpType = js.native
          }
          
          @js.native
          trait RTCSignalingState
            extends StObject
               with js.Any
          
          @js.native
          trait RTCStats extends StObject {
            
            var id: String = js.native
            
            var timestamp: Double = js.native
            
            var `type`: RTCStatsType = js.native
          }
          
          @js.native
          trait RTCStatsReport extends StObject {
            
            def apply(id: String): RTCStats = js.native
          }
          
          @js.native
          trait RTCStatsType
            extends StObject
               with js.Any
        }
      }
      
      object ext {
        
        object Ajax {
          
          @js.native
          sealed trait InputData
            extends StObject
               with js.Any
        }
        
        @js.native
        trait TouchEvents extends StObject {
          
          var ontouchcancel: js.Function1[org.scalajs.dom.raw.TouchEvent, _] = js.native
          
          var ontouchend: js.Function1[org.scalajs.dom.raw.TouchEvent, _] = js.native
          
          var ontouchmove: js.Function1[org.scalajs.dom.raw.TouchEvent, _] = js.native
          
          var ontouchstart: js.Function1[org.scalajs.dom.raw.TouchEvent, _] = js.native
        }
      }
      
      object html {
        
        type Anchor = HTMLAnchorElement
        
        type Area = HTMLAreaElement
        
        type Audio = HTMLAudioElement
        
        type BR = HTMLBRElement
        
        type Base = HTMLBaseElement
        
        type Body = HTMLBodyElement
        
        type Button = HTMLButtonElement
        
        type Canvas = HTMLCanvasElement
        
        type Collection = HTMLCollection
        
        type DList = HTMLDListElement
        
        type DataList = HTMLDataListElement
        
        type Div = HTMLDivElement
        
        type Document = HTMLDocument
        
        type Element = HTMLElement
        
        type Embed = HTMLEmbedElement
        
        type FieldSet = HTMLFieldSetElement
        
        type Form = HTMLFormElement
        
        type HR = HTMLHRElement
        
        type Head = HTMLHeadElement
        
        type Heading = HTMLHeadingElement
        
        type Html = HTMLHtmlElement
        
        type IFrame = HTMLIFrameElement
        
        type Image = HTMLImageElement
        
        type Input = HTMLInputElement
        
        type LI = HTMLLIElement
        
        type Label = HTMLLabelElement
        
        type Legend = HTMLLegendElement
        
        type Link = HTMLLinkElement
        
        type Map = HTMLMapElement
        
        type Media = HTMLMediaElement
        
        type Menu = HTMLMenuElement
        
        type Meta = HTMLMetaElement
        
        type Mod = HTMLModElement
        
        type OList = HTMLOListElement
        
        type Object = HTMLObjectElement
        
        type OptGroup = HTMLOptGroupElement
        
        type Option = HTMLOptionElement
        
        type Paragraph = HTMLParagraphElement
        
        type Param = HTMLParamElement
        
        type Pre = HTMLPreElement
        
        type Progress = HTMLProgressElement
        
        type Quote = HTMLQuoteElement
        
        type Script = HTMLScriptElement
        
        type Select = HTMLSelectElement
        
        type Source = HTMLSourceElement
        
        type Span = HTMLSpanElement
        
        type Style = HTMLStyleElement
        
        type Table = HTMLTableElement
        
        type TableAlignment = HTMLTableAlignment
        
        type TableCaption = HTMLTableCaptionElement
        
        type TableCell = HTMLTableCellElement
        
        type TableCol = HTMLTableColElement
        
        type TableRow = HTMLTableRowElement
        
        type TableSection = HTMLTableSectionElement
        
        type TextArea = HTMLTextAreaElement
        
        type Title = HTMLTitleElement
        
        type Track = HTMLTrackElement
        
        type UList = HTMLUListElement
        
        type Unknown = HTMLUnknownElement
        
        type Video = HTMLVideoElement
      }
      
      object idb {
        
        type Cursor = IDBCursor
        
        type CursorWithValue = IDBCursorWithValue
        
        type Database = IDBDatabase
        
        type Environment = IDBEnvironment
        
        type Factory = IDBFactory
        
        type Index = IDBIndex
        
        type KeyRange = IDBKeyRange
        
        type ObjectStore = IDBObjectStore
        
        type OpenDBRequest = IDBOpenDBRequest
        
        type Request = IDBRequest
        
        type Transaction = IDBTransaction
        
        type VersionChangeEvent = IDBVersionChangeEvent
      }
      
      object raw {
        
        @js.native
        trait AbstractWorker
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          var onerror: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
        }
        
        @js.native
        trait AnalyserNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          var fftSize: Int = js.native
          
          val frequencyBinCount: Int = js.native
          
          def getByteFrequencyData(array: js.typedarray.Uint8Array): Unit = js.native
          
          def getByteTimeDomainData(array: js.typedarray.Uint8Array): Unit = js.native
          
          def getFloatFrequencyData(array: js.typedarray.Float32Array): Unit = js.native
          
          def getFloatTimeDomainData(array: js.typedarray.Float32Array): Unit = js.native
          
          var maxDecibels: Double = js.native
          
          var minDecibels: Double = js.native
          
          var smoothingTimeConstant: Double = js.native
        }
        
        @js.native
        trait AnimationEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          def animationName(): String = js.native
          
          def elapsedTime(): Double = js.native
        }
        
        @js.native
        trait ApplicationCache
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def abort(): Unit = js.native
          
          var oncached: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onchecking: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var ondownloading: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
          
          var onnoupdate: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onobsolete: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onprogress: js.Function1[org.scalajs.dom.raw.ProgressEvent, _] = js.native
          
          var onupdateready: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          def status(): Int = js.native
          
          def swapCache(): Unit = js.native
          
          def update(): Unit = js.native
        }
        @js.native
        object ApplicationCache extends StObject {
          
          val CHECKING: Int = js.native
          
          val DOWNLOADING: Int = js.native
          
          val IDLE: Int = js.native
          
          val OBSOLETE: Int = js.native
          
          val UNCACHED: Int = js.native
          
          val UPDATEREADY: Int = js.native
        }
        
        @js.native
        class Attr ()
          extends StObject
             with org.scalajs.dom.raw.Node {
          
          def name(): String = js.native
          
          def ownerElement(): org.scalajs.dom.raw.Element = js.native
          
          def prefix(): String = js.native
          
          def specified(): Boolean = js.native
          
          var value: String = js.native
        }
        
        @js.native
        trait AudioBuffer extends StObject {
          
          def copyFromChannel(destination: js.typedarray.Float32Array, channelNumber: Int, startInChannel: Int): Unit = js.native
          
          def copyToChannel(source: js.typedarray.Float32Array, channelNumber: Int, startInChannel: Int): Unit = js.native
          
          val duration: Double = js.native
          
          def getChannelData(channel: Int): js.typedarray.Float32Array = js.native
          
          val length: Int = js.native
          
          val numberOfChannels: Int = js.native
          
          val sampleRate: Double = js.native
        }
        
        @js.native
        trait AudioBufferSourceNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          var buffer: org.scalajs.dom.raw.AudioBuffer = js.native
          
          var loop: Boolean = js.native
          
          var loopEnd: Double = js.native
          
          var loopStart: Double = js.native
          
          var onended: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          val playbackRate: org.scalajs.dom.raw.AudioParam = js.native
          
          def start(when: Double, offset: Double, duration: Double): Unit = js.native
          
          def stop(when: Double): Unit = js.native
        }
        
        @js.native
        class AudioContext ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def close(): js.Promise[Unit] = js.native
          
          def createAnalyser(): org.scalajs.dom.raw.AnalyserNode = js.native
          
          def createBiquadFilter(): org.scalajs.dom.raw.BiquadFilterNode = js.native
          
          def createBuffer(numOfChannels: Int, length: Int, sampleRate: Int): org.scalajs.dom.raw.AudioBuffer = js.native
          
          def createBufferSource(): org.scalajs.dom.raw.AudioBufferSourceNode = js.native
          
          def createChannelMerger(numberOfInputs: Int): org.scalajs.dom.raw.ChannelMergerNode = js.native
          
          def createChannelSplitter(numberOfOutputs: Int): org.scalajs.dom.raw.ChannelSplitterNode = js.native
          
          def createConvolver(): org.scalajs.dom.raw.ConvolverNode = js.native
          
          def createDelay(maxDelayTime: Int): org.scalajs.dom.raw.DelayNode = js.native
          
          def createDynamicsCompressor(): org.scalajs.dom.raw.DynamicsCompressorNode = js.native
          
          def createGain(): org.scalajs.dom.raw.GainNode = js.native
          
          def createMediaElementSource(myMediaElement: HTMLMediaElement): org.scalajs.dom.raw.MediaElementAudioSourceNode = js.native
          
          def createMediaStreamDestination(): org.scalajs.dom.raw.MediaStreamAudioDestinationNode = js.native
          
          def createMediaStreamSource(stream: MediaStream): org.scalajs.dom.raw.MediaStreamAudioSourceNode = js.native
          
          def createOscillator(): org.scalajs.dom.raw.OscillatorNode = js.native
          
          def createPanner(): org.scalajs.dom.raw.PannerNode = js.native
          
          def createPeriodicWave(real: js.typedarray.Float32Array, imag: js.typedarray.Float32Array): org.scalajs.dom.raw.PeriodicWave = js.native
          
          def createStereoPanner(): org.scalajs.dom.raw.StereoPannerNode = js.native
          
          def createWaveShaper(): org.scalajs.dom.raw.WaveShaperNode = js.native
          
          def currentTime(): Double = js.native
          
          def decodeAudioData(
            audioData: js.typedarray.ArrayBuffer,
            successCallback: js.Function1[org.scalajs.dom.raw.AudioBuffer, _],
            errorCallback: js.Function0[_]
          ): js.Promise[org.scalajs.dom.raw.AudioBuffer] = js.native
          
          val destination: org.scalajs.dom.raw.AudioDestinationNode = js.native
          
          val listener: org.scalajs.dom.raw.AudioListener = js.native
          
          def resume(): js.Promise[Unit] = js.native
          
          val sampleRate: Double = js.native
          
          def state(): String = js.native
          
          def suspend(): js.Promise[Unit] = js.native
        }
        
        @js.native
        trait AudioDestinationNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          var maxChannelCount: Int = js.native
        }
        
        @js.native
        trait AudioListener
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          var dopplerFactor: Double = js.native
          
          def setOrientation(x: Double, y: Double, z: Double, xUp: Double, yUp: Double, zUp: Double): Unit = js.native
          
          def setPosition(x: Double, y: Double, z: Double): Unit = js.native
          
          var speedOfSound: Double = js.native
        }
        
        @js.native
        trait AudioNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          var channelCount: Int = js.native
          
          var channelCountMode: Int = js.native
          
          var channelInterpretation: String = js.native
          
          def connect(audioNode: org.scalajs.dom.raw.AudioNode): Unit = js.native
          def connect(audioParam: org.scalajs.dom.raw.AudioParam): Unit = js.native
          
          val context: org.scalajs.dom.raw.AudioContext = js.native
          
          def disconnect(output: org.scalajs.dom.raw.AudioNode): Unit = js.native
          
          val numberOfInputs: Int = js.native
          
          val numberOfOutputs: Int = js.native
        }
        
        @js.native
        trait AudioParam
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          def cancelScheduledValues(startTime: Double): Unit = js.native
          
          val defaultValue: Double = js.native
          
          def exponentialRampToValueAtTime(value: Double, endTime: Double): Unit = js.native
          
          def linearRampToValueAtTime(value: Double, endTime: Double): Unit = js.native
          
          def setTargetAtTime(target: Double, startTime: Double, timeConstant: Double): Unit = js.native
          
          def setValueAtTime(value: Double, startTime: Double): Unit = js.native
          
          def setValueCurveAtTime(values: js.typedarray.Float32Array, startTime: Double, duration: Double): Unit = js.native
          
          var value: Double = js.native
        }
        
        @js.native
        trait AudioTrack extends StObject {
          
          var enabled: Boolean = js.native
          
          var id: String = js.native
          
          var kind: String = js.native
          
          var label: String = js.native
          
          var language: String = js.native
        }
        
        @js.native
        trait AudioTrackList
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.DOMList[org.scalajs.dom.raw.AudioTrack] {
          
          def getTrackById(id: String): org.scalajs.dom.raw.AudioTrack = js.native
          
          var onaddtrack: js.Function1[org.scalajs.dom.raw.TrackEvent, _] = js.native
          
          var onchange: js.Function1[js.Any, _] = js.native
        }
        
        @js.native
        class BeforeUnloadEvent ()
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          var returnValue: String = js.native
        }
        
        @js.native
        trait BiquadFilterNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          val Q: org.scalajs.dom.raw.AudioParam = js.native
          
          val detune: org.scalajs.dom.raw.AudioParam = js.native
          
          val frequency: org.scalajs.dom.raw.AudioParam = js.native
          
          val gain: org.scalajs.dom.raw.AudioParam = js.native
          
          def getFrequencyResponse(
            frequencyHz: js.typedarray.Float32Array,
            magResponse: js.typedarray.Float32Array,
            phaseResponse: js.typedarray.Float32Array
          ): Unit = js.native
          
          var `type`: String = js.native
        }
        
        @js.native
        class Blob protected () extends StObject {
          def this(blobParts: js.Array[js.Any], options: org.scalajs.dom.raw.BlobPropertyBag) = this()
          
          val blobParts: js.Array[js.Any] = js.native
          
          def close(): Unit = js.native
          
          val options: org.scalajs.dom.raw.BlobPropertyBag = js.native
          
          def size(): Double = js.native
          
          def slice(start: Double, end: Double, contentType: String): org.scalajs.dom.raw.Blob = js.native
          
          def `type`(): String = js.native
        }
        
        @js.native
        trait BlobPropertyBag extends StObject {
          
          def endings(): String = js.native
          
          def `type`(): String = js.native
        }
        
        @js.native
        abstract class CDATASection ()
          extends StObject
             with org.scalajs.dom.raw.Text
        
        @js.native
        class CSSFontFaceRule ()
          extends StObject
             with CSSRule {
          
          var style: CSSStyleDeclaration = js.native
        }
        
        @js.native
        class CSSImportRule ()
          extends StObject
             with CSSRule {
          
          var href: String = js.native
          
          var media: org.scalajs.dom.raw.MediaList = js.native
          
          var styleSheet: CSSStyleSheet = js.native
        }
        
        @js.native
        class CSSKeyframeRule ()
          extends StObject
             with CSSRule {
          
          var keyText: String = js.native
          
          var style: CSSStyleDeclaration = js.native
        }
        
        @js.native
        class CSSKeyframesRule ()
          extends StObject
             with CSSRule {
          
          def appendRule(rule: String): Unit = js.native
          
          var cssRules: CSSRuleList = js.native
          
          def deleteRule(rule: String): Unit = js.native
          
          def findRule(rule: String): CSSKeyframeRule = js.native
          
          var name: String = js.native
        }
        
        @js.native
        class CSSMediaRule ()
          extends StObject
             with CSSRule {
          
          var cssRules: CSSRuleList = js.native
          
          def deleteRule(index: Int): Unit = js.native
          
          def insertRule(rule: String, index: Int): Int = js.native
          
          var media: org.scalajs.dom.raw.MediaList = js.native
        }
        
        @js.native
        class CSSNamespaceRule ()
          extends StObject
             with CSSRule {
          
          var namespaceURI: String = js.native
          
          var prefix: String = js.native
        }
        
        @js.native
        class CSSPageRule ()
          extends StObject
             with CSSRule {
          
          var pseudoClass: String = js.native
          
          var selector: String = js.native
          
          var selectorText: String = js.native
          
          var style: CSSStyleDeclaration = js.native
        }
        
        @js.native
        class CSSRule () extends StObject {
          
          var CHARSET_RULE: Int = js.native
          
          var FONT_FACE_RULE: Int = js.native
          
          var IMPORT_RULE: Int = js.native
          
          var KEYFRAMES_RULE: Int = js.native
          
          var KEYFRAME_RULE: Int = js.native
          
          var MEDIA_RULE: Int = js.native
          
          var NAMESPACE_RULE: Int = js.native
          
          var PAGE_RULE: Int = js.native
          
          var STYLE_RULE: Int = js.native
          
          var UNKNOWN_RULE: Int = js.native
          
          var VIEWPORT_RULE: Int = js.native
          
          var cssText: String = js.native
          
          var parentRule: CSSRule = js.native
          
          var parentStyleSheet: CSSStyleSheet = js.native
          
          var `type`: Int = js.native
        }
        @js.native
        object CSSRule extends StObject {
          
          var CHARSET_RULE: Int = js.native
          
          var FONT_FACE_RULE: Int = js.native
          
          var IMPORT_RULE: Int = js.native
          
          var MEDIA_RULE: Int = js.native
          
          var NAMESPACE_RULE: Int = js.native
          
          var PAGE_RULE: Int = js.native
          
          var STYLE_RULE: Int = js.native
          
          var UNKNOWN_RULE: Int = js.native
        }
        
        @js.native
        class CSSRuleList ()
          extends StObject
             with org.scalajs.dom.raw.DOMList[CSSRule]
        
        @js.native
        class CSSStyleDeclaration () extends StObject {
          
          var alignmentBaseline: String = js.native
          
          var animation: String = js.native
          
          var animationDelay: String = js.native
          
          var animationDirection: String = js.native
          
          var animationDuration: String = js.native
          
          var animationFillMode: String = js.native
          
          var animationIterationCount: String = js.native
          
          var animationName: String = js.native
          
          var animationPlayState: String = js.native
          
          var animationTimingFunction: String = js.native
          
          def apply(index: Int): String = js.native
          
          var backfaceVisibility: String = js.native
          
          var background: String = js.native
          
          var backgroundAttachment: String = js.native
          
          var backgroundClip: String = js.native
          
          var backgroundColor: String = js.native
          
          var backgroundImage: String = js.native
          
          var backgroundOrigin: String = js.native
          
          var backgroundPosition: String = js.native
          
          var backgroundRepeat: String = js.native
          
          var backgroundSize: String = js.native
          
          var baselineShift: String = js.native
          
          var border: String = js.native
          
          var borderBottom: String = js.native
          
          var borderBottomColor: String = js.native
          
          var borderBottomLeftRadius: String = js.native
          
          var borderBottomRightRadius: String = js.native
          
          var borderBottomStyle: String = js.native
          
          var borderBottomWidth: String = js.native
          
          var borderCollapse: String = js.native
          
          var borderColor: String = js.native
          
          var borderLeft: String = js.native
          
          var borderLeftColor: String = js.native
          
          var borderLeftStyle: String = js.native
          
          var borderLeftWidth: String = js.native
          
          var borderRadius: String = js.native
          
          var borderRight: String = js.native
          
          var borderRightColor: String = js.native
          
          var borderRightStyle: String = js.native
          
          var borderRightWidth: String = js.native
          
          var borderSpacing: String = js.native
          
          var borderStyle: String = js.native
          
          var borderTop: String = js.native
          
          var borderTopColor: String = js.native
          
          var borderTopLeftRadius: String = js.native
          
          var borderTopRightRadius: String = js.native
          
          var borderTopStyle: String = js.native
          
          var borderTopWidth: String = js.native
          
          var borderWidth: String = js.native
          
          var bottom: String = js.native
          
          var boxShadow: String = js.native
          
          var boxSizing: String = js.native
          
          var breakAfter: String = js.native
          
          var breakBefore: String = js.native
          
          var breakInside: String = js.native
          
          var captionSide: String = js.native
          
          var clear: String = js.native
          
          var clip: String = js.native
          
          var clipPath: String = js.native
          
          var clipRule: String = js.native
          
          var color: String = js.native
          
          var colorInterpolationFilters: String = js.native
          
          var columnCount: js.Any = js.native
          
          var columnFill: String = js.native
          
          var columnGap: js.Any = js.native
          
          var columnRule: String = js.native
          
          var columnRuleColor: js.Any = js.native
          
          var columnRuleStyle: String = js.native
          
          var columnRuleWidth: js.Any = js.native
          
          var columnSpan: String = js.native
          
          var columnWidth: js.Any = js.native
          
          var columns: String = js.native
          
          var content: String = js.native
          
          var counterIncrement: String = js.native
          
          var counterReset: String = js.native
          
          var cssFloat: String = js.native
          
          var cssText: String = js.native
          
          var cursor: String = js.native
          
          var direction: String = js.native
          
          var display: String = js.native
          
          var dominantBaseline: String = js.native
          
          var emptyCells: String = js.native
          
          var enableBackground: String = js.native
          
          var fill: String = js.native
          
          var fillOpacity: String = js.native
          
          var fillRule: String = js.native
          
          var floodColor: String = js.native
          
          var floodOpacity: String = js.native
          
          var font: String = js.native
          
          var fontFamily: String = js.native
          
          var fontFeatureSettings: String = js.native
          
          var fontSize: String = js.native
          
          var fontSizeAdjust: String = js.native
          
          var fontStretch: String = js.native
          
          var fontStyle: String = js.native
          
          var fontVariant: String = js.native
          
          var fontWeight: String = js.native
          
          def getPropertyPriority(propertyName: String): String = js.native
          
          def getPropertyValue(propertyName: String): String = js.native
          
          var glyphOrientationHorizontal: String = js.native
          
          var glyphOrientationVertical: String = js.native
          
          var height: String = js.native
          
          def item(index: Int): String = js.native
          
          var kerning: String = js.native
          
          var left: String = js.native
          
          var length: Int = js.native
          
          var letterSpacing: String = js.native
          
          var lightingColor: String = js.native
          
          var lineHeight: String = js.native
          
          var listStyle: String = js.native
          
          var listStyleImage: String = js.native
          
          var listStylePosition: String = js.native
          
          var listStyleType: String = js.native
          
          var margin: String = js.native
          
          var marginBottom: String = js.native
          
          var marginLeft: String = js.native
          
          var marginRight: String = js.native
          
          var marginTop: String = js.native
          
          var marker: String = js.native
          
          var markerEnd: String = js.native
          
          var markerMid: String = js.native
          
          var markerStart: String = js.native
          
          var mask: String = js.native
          
          var maxHeight: String = js.native
          
          var maxWidth: String = js.native
          
          var minHeight: String = js.native
          
          var minWidth: String = js.native
          
          var opacity: String = js.native
          
          var orphans: String = js.native
          
          var outline: String = js.native
          
          var outlineColor: String = js.native
          
          var outlineStyle: String = js.native
          
          var outlineWidth: String = js.native
          
          var overflow: String = js.native
          
          var overflowX: String = js.native
          
          var overflowY: String = js.native
          
          var padding: String = js.native
          
          var paddingBottom: String = js.native
          
          var paddingLeft: String = js.native
          
          var paddingRight: String = js.native
          
          var paddingTop: String = js.native
          
          var pageBreakAfter: String = js.native
          
          var pageBreakBefore: String = js.native
          
          var pageBreakInside: String = js.native
          
          var parentRule: CSSRule = js.native
          
          var perspective: String = js.native
          
          var perspectiveOrigin: String = js.native
          
          var pointerEvents: String = js.native
          
          var position: String = js.native
          
          var quotes: String = js.native
          
          def removeProperty(propertyName: String): String = js.native
          
          var right: String = js.native
          
          var rubyAlign: String = js.native
          
          var rubyOverhang: String = js.native
          
          var rubyPosition: String = js.native
          
          def setProperty(propertyName: String, value: String, priority: String): Unit = js.native
          
          var stopColor: String = js.native
          
          var stopOpacity: String = js.native
          
          var stroke: String = js.native
          
          var strokeDasharray: String = js.native
          
          var strokeDashoffset: String = js.native
          
          var strokeLinecap: String = js.native
          
          var strokeLinejoin: String = js.native
          
          var strokeMiterlimit: String = js.native
          
          var strokeOpacity: String = js.native
          
          var strokeWidth: String = js.native
          
          var tableLayout: String = js.native
          
          var textAlign: String = js.native
          
          var textAlignLast: String = js.native
          
          var textAnchor: String = js.native
          
          var textDecoration: String = js.native
          
          var textIndent: String = js.native
          
          var textJustify: String = js.native
          
          var textOverflow: String = js.native
          
          var textShadow: String = js.native
          
          var textTransform: String = js.native
          
          var textUnderlinePosition: String = js.native
          
          var top: String = js.native
          
          var transform: String = js.native
          
          var transformOrigin: String = js.native
          
          var transformStyle: String = js.native
          
          var transition: String = js.native
          
          var transitionDelay: String = js.native
          
          var transitionDuration: String = js.native
          
          var transitionProperty: String = js.native
          
          var transitionTimingFunction: String = js.native
          
          var unicodeBidi: String = js.native
          
          def update(index: Int, v: String): Unit = js.native
          
          var verticalAlign: String = js.native
          
          var visibility: String = js.native
          
          var whiteSpace: String = js.native
          
          var widows: String = js.native
          
          var width: String = js.native
          
          var wordBreak: String = js.native
          
          var wordSpacing: String = js.native
          
          var wordWrap: String = js.native
          
          var zIndex: String = js.native
        }
        
        @js.native
        class CSSStyleRule ()
          extends StObject
             with CSSRule {
          
          var readOnly: Boolean = js.native
          
          var selectorText: String = js.native
          
          val style: CSSStyleDeclaration = js.native
        }
        
        @js.native
        class CSSStyleSheet ()
          extends StObject
             with org.scalajs.dom.raw.StyleSheet {
          
          def addImport(bstrURL: String, lIndex: Int): Int = js.native
          
          def addPageRule(bstrSelector: String, bstrStyle: String, lIndex: Int): Int = js.native
          
          def addRule(bstrSelector: String, bstrStyle: String, lIndex: Int): Int = js.native
          
          var cssRules: CSSRuleList = js.native
          
          var cssText: String = js.native
          
          def deleteRule(index: Int): Unit = js.native
          
          var id: String = js.native
          
          var imports: org.scalajs.dom.raw.StyleSheetList = js.native
          
          def insertRule(rule: String, index: Int): Int = js.native
          
          var isAlternate: Boolean = js.native
          
          var isPrefAlternate: Boolean = js.native
          
          var ownerRule: CSSRule = js.native
          
          var owningElement: org.scalajs.dom.raw.Element = js.native
          
          var readOnly: Boolean = js.native
          
          def removeImport(lIndex: Int): Unit = js.native
          
          def removeRule(lIndex: Int): Unit = js.native
        }
        
        @js.native
        class CanvasGradient () extends StObject {
          
          def addColorStop(offset: Double, color: String): Unit = js.native
        }
        
        @js.native
        class CanvasPattern () extends StObject
        
        @js.native
        class CanvasRenderingContext2D () extends StObject {
          
          def arc(x: Double, y: Double, radius: Double, startAngle: Double, endAngle: Double): Unit = js.native
          def arc(x: Double, y: Double, radius: Double, startAngle: Double, endAngle: Double, anticlockwise: Boolean): Unit = js.native
          
          def arcTo(x1: Double, y1: Double, x2: Double, y2: Double, radius: Double): Unit = js.native
          
          def beginPath(): Unit = js.native
          
          def bezierCurveTo(cp1x: Double, cp1y: Double, cp2x: Double, cp2y: Double, x: Double, y: Double): Unit = js.native
          
          var canvas: HTMLCanvasElement = js.native
          
          def clearRect(x: Double, y: Double, w: Double, h: Double): Unit = js.native
          
          def clip(fillRule: String): Unit = js.native
          
          def closePath(): Unit = js.native
          
          def createImageData(imageDataOrSw: js.Any, sh: Double): org.scalajs.dom.raw.ImageData = js.native
          
          def createLinearGradient(x0: Double, y0: Double, x1: Double, y1: Double): org.scalajs.dom.raw.CanvasGradient = js.native
          
          def createPattern(image: HTMLElement, repetition: String): org.scalajs.dom.raw.CanvasPattern = js.native
          
          def createRadialGradient(x0: Double, y0: Double, r0: Double, x1: Double, y1: Double, r1: Double): org.scalajs.dom.raw.CanvasGradient = js.native
          
          def drawImage(
            image: HTMLElement,
            offsetX: Double,
            offsetY: Double,
            width: Double,
            height: Double,
            canvasOffsetX: Double,
            canvasOffsetY: Double,
            canvasImageWidth: Double,
            canvasImageHeight: Double
          ): Unit = js.native
          
          def ellipse(
            x: Double,
            y: Double,
            radiusX: Double,
            radiusY: Double,
            rotation: Double,
            startAngle: Double,
            endAngle: Double,
            anticlockwise: Boolean
          ): Unit = js.native
          
          def fill(): Unit = js.native
          
          def fillRect(x: Double, y: Double, w: Double, h: Double): Unit = js.native
          
          var fillStyle: js.Any = js.native
          
          def fillText(text: String, x: Double, y: Double, maxWidth: Double): Unit = js.native
          
          var font: String = js.native
          
          def getImageData(sx: Double, sy: Double, sw: Double, sh: Double): org.scalajs.dom.raw.ImageData = js.native
          
          def getLineDash(): js.Array[Double] = js.native
          
          var globalAlpha: Double = js.native
          
          var globalCompositeOperation: String = js.native
          
          def isPointInPath(x: Double, y: Double): Boolean = js.native
          def isPointInPath(x: Double, y: Double, fillRule: String): Boolean = js.native
          
          var lineCap: String = js.native
          
          var lineDashOffset: Double = js.native
          
          var lineJoin: String = js.native
          
          def lineTo(x: Double, y: Double): Unit = js.native
          
          var lineWidth: Double = js.native
          
          def measureText(text: String): org.scalajs.dom.raw.TextMetrics = js.native
          
          var miterLimit: Double = js.native
          
          def moveBy(deltaX: Double, deltaY: Double): Unit = js.native
          
          def moveTo(x: Double, y: Double): Unit = js.native
          
          def putImageData(
            imagedata: org.scalajs.dom.raw.ImageData,
            dx: Double,
            dy: Double,
            dirtyX: Double,
            dirtyY: Double,
            dirtyWidth: Double,
            dirtyHeight: Double
          ): Unit = js.native
          
          def quadraticCurveTo(cpx: Double, cpy: Double, x: Double, y: Double): Unit = js.native
          
          def rect(x: Double, y: Double, w: Double, h: Double): Unit = js.native
          
          def restore(): Unit = js.native
          
          def rotate(angle: Double): Unit = js.native
          
          def save(): Unit = js.native
          
          def scale(x: Double, y: Double): Unit = js.native
          
          def setLineDash(segments: js.Array[Double]): Unit = js.native
          
          def setTransform(m11: Double, m12: Double, m21: Double, m22: Double, dx: Double, dy: Double): Unit = js.native
          
          var shadowBlur: Double = js.native
          
          var shadowColor: String = js.native
          
          var shadowOffsetX: Double = js.native
          
          var shadowOffsetY: Double = js.native
          
          def stroke(): Unit = js.native
          
          def strokeRect(x: Double, y: Double, w: Double, h: Double): Unit = js.native
          
          var strokeStyle: js.Any = js.native
          
          def strokeText(text: String, x: Double, y: Double, maxWidth: Double): Unit = js.native
          
          var textAlign: String = js.native
          
          var textBaseline: String = js.native
          
          def transform(m11: Double, m12: Double, m21: Double, m22: Double, dx: Double, dy: Double): Unit = js.native
          
          def translate(x: Double, y: Double): Unit = js.native
        }
        
        @js.native
        trait ChannelMergerNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode
        
        @js.native
        trait ChannelSplitterNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode
        
        @js.native
        abstract class CharacterData ()
          extends StObject
             with org.scalajs.dom.raw.Node
             with NonDocumentTypeChildNode {
          
          def appendData(arg: String): Unit = js.native
          
          var data: String = js.native
          
          def deleteData(offset: Int, count: Int): Unit = js.native
          
          def insertData(offset: Int, arg: String): Unit = js.native
          
          def length(): Int = js.native
          
          def replaceData(offset: Int, count: Int, arg: String): Unit = js.native
          
          def substringData(offset: Int, count: Int): String = js.native
        }
        
        @js.native
        class ClientRect () extends StObject {
          
          var bottom: Double = js.native
          
          var height: Double = js.native
          
          var left: Double = js.native
          
          var right: Double = js.native
          
          var top: Double = js.native
          
          var width: Double = js.native
        }
        
        @js.native
        class ClientRectList ()
          extends StObject
             with org.scalajs.dom.raw.DOMList[org.scalajs.dom.raw.ClientRect]
        
        @js.native
        trait Clipboard
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def read(): js.Promise[org.scalajs.dom.raw.DataTransfer] = js.native
          
          def readText(): js.Promise[String] = js.native
          
          def write(data: org.scalajs.dom.raw.DataTransfer): js.Promise[Unit] = js.native
          
          def writeText(newClipText: String): js.Promise[Unit] = js.native
        }
        
        @js.native
        class ClipboardEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.Event {
          def this(typeArg: String, init: js.UndefOr[org.scalajs.dom.raw.ClipboardEventInit]) = this()
          
          def clipboardData(): org.scalajs.dom.raw.DataTransfer = js.native
          
          val init: js.UndefOr[org.scalajs.dom.raw.ClipboardEventInit] = js.native
          
          val typeArg: String = js.native
        }
        
        @js.native
        trait ClipboardEventInit
          extends StObject
             with EventInit {
          
          var data: js.UndefOr[String] = js.native
          
          var dataType: js.UndefOr[String] = js.native
        }
        
        @js.native
        trait CloseEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          def code(): Int = js.native
          
          def reason(): String = js.native
          
          def wasClean(): Boolean = js.native
        }
        
        @js.native
        class Comment ()
          extends StObject
             with org.scalajs.dom.raw.CharacterData {
          
          var text: String = js.native
        }
        
        @js.native
        class CompositionEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.UIEvent {
          def this(typeArg: String, init: js.UndefOr[CompositionEventInit]) = this()
          
          def data(): String = js.native
          
          val init: js.UndefOr[CompositionEventInit] = js.native
          
          def locale(): String = js.native
          
          val typeArg: String = js.native
        }
        
        @js.native
        trait CompositionEventInit
          extends StObject
             with UIEventInit {
          
          var data: js.UndefOr[String] = js.native
          
          var locale: js.UndefOr[String] = js.native
        }
        
        @js.native
        trait Console extends StObject {
          
          def assert(test: Boolean, message: String, optionalParams: Any): Unit = js.native
          
          def clear(): Unit = js.native
          
          def count(label: String): Unit = js.native
          
          def countReset(label: String): Unit = js.native
          
          def debug(message: Any, optionalParams: Any): Unit = js.native
          
          def dir(value: Any, optionalParams: Any): Unit = js.native
          
          def dirxml(value: Any): Unit = js.native
          
          def error(message: Any, optionalParams: Any): Unit = js.native
          
          def group(label: js.UndefOr[String]): Unit = js.native
          
          def groupCollapsed(label: js.UndefOr[String]): Unit = js.native
          
          def groupEnd(): Unit = js.native
          
          def info(message: Any, optionalParams: Any): Unit = js.native
          
          def log(message: Any, optionalParams: Any): Unit = js.native
          
          def profile(reportName: String): Unit = js.native
          
          def profileEnd(): Unit = js.native
          
          def table(data: js.Object | js.Array[_], columns: js.UndefOr[Int]): Unit = js.native
          
          def time(label: String): Unit = js.native
          
          def timeEnd(label: String): Unit = js.native
          
          def trace(): Unit = js.native
          
          def warn(message: Any, optionalParams: Any): Unit = js.native
        }
        
        @js.native
        trait ConvolverNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          var buffer: org.scalajs.dom.raw.AudioBuffer = js.native
          
          var normalize: Boolean = js.native
        }
        
        @js.native
        trait Coordinates extends StObject {
          
          def accuracy(): Double = js.native
          
          def altitude(): Double = js.native
          
          def altitudeAccuracy(): Double = js.native
          
          def heading(): Double = js.native
          
          def latitude(): Double = js.native
          
          def longitude(): Double = js.native
          
          def speed(): Double = js.native
        }
        
        @js.native
        class CustomEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.Event {
          def this(typeArg: String, init: js.UndefOr[CustomEventInit]) = this()
          
          def detail(): Any = js.native
          
          val init: js.UndefOr[CustomEventInit] = js.native
          
          val typeArg: String = js.native
        }
        
        @js.native
        trait CustomEventInit
          extends StObject
             with EventInit {
          
          var detail: js.UndefOr[Any] = js.native
        }
        
        @js.native
        class DOMException () extends StObject {
          
          def message(): String = js.native
          
          def name(): String = js.native
        }
        @js.native
        object DOMException extends StObject {
          
          val ABORT_ERR: Int = js.native
          
          val DATA_CLONE_ERR: Int = js.native
          
          val DOMSTRING_SIZE_ERR: Int = js.native
          
          val HIERARCHY_REQUEST_ERR: Int = js.native
          
          val INDEX_SIZE_ERR: Int = js.native
          
          val INUSE_ATTRIBUTE_ERR: Int = js.native
          
          val INVALID_ACCESS_ERR: Int = js.native
          
          val INVALID_CHARACTER_ERR: Int = js.native
          
          val INVALID_MODIFICATION_ERR: Int = js.native
          
          val INVALID_NODE_TYPE_ERR: Int = js.native
          
          val INVALID_STATE_ERR: Int = js.native
          
          val NAMESPACE_ERR: Int = js.native
          
          val NETWORK_ERR: Int = js.native
          
          val NOT_FOUND_ERR: Int = js.native
          
          val NOT_SUPPORTED_ERR: Int = js.native
          
          val NO_DATA_ALLOWED_ERR: Int = js.native
          
          val NO_MODIFICATION_ALLOWED_ERR: Int = js.native
          
          val QUOTA_EXCEEDED_ERR: Int = js.native
          
          val SECURITY_ERR: Int = js.native
          
          val SYNTAX_ERR: Int = js.native
          
          val TIMEOUT_ERR: Int = js.native
          
          val TYPE_MISMATCH_ERR: Int = js.native
          
          val URL_MISMATCH_ERR: Int = js.native
          
          val VALIDATION_ERR: Int = js.native
          
          val WRONG_DOCUMENT_ERR: Int = js.native
        }
        
        @js.native
        class DOMImplementation () extends StObject {
          
          def createDocument(namespaceURI: String, qualifiedName: String, doctype: org.scalajs.dom.raw.DocumentType): org.scalajs.dom.raw.Document = js.native
          
          def createDocumentType(qualifiedName: String, publicId: String, systemId: String): org.scalajs.dom.raw.DocumentType = js.native
          
          def createHTMLDocument(title: String): org.scalajs.dom.raw.Document = js.native
          
          def hasFeature(feature: String): Boolean = js.native
          def hasFeature(feature: String, version: String): Boolean = js.native
        }
        
        @js.native
        trait DOMList[T] extends StObject {
          
          def apply(index: Int): T = js.native
          
          def item(index: Int): T = js.native
          
          def length(): Int = js.native
          
          def update(index: Int, v: T): Unit = js.native
        }
        
        @js.native
        class DOMParser () extends StObject {
          
          def parseFromString(source: String, mimeType: String): org.scalajs.dom.raw.Document = js.native
        }
        
        @js.native
        trait DOMSettableTokenList
          extends StObject
             with org.scalajs.dom.raw.DOMTokenList {
          
          def value(): String = js.native
        }
        
        @js.native
        trait DOMStringList
          extends StObject
             with org.scalajs.dom.raw.DOMList[String] {
          
          def contains(str: String): Boolean = js.native
        }
        
        @js.native
        trait DOMTokenList
          extends StObject
             with org.scalajs.dom.raw.DOMList[String] {
          
          def add(token: String): Unit = js.native
          
          def contains(token: String): Boolean = js.native
          
          def remove(token: String): Unit = js.native
          
          def toggle(token: String): Boolean = js.native
          def toggle(token: String, force: Boolean): Boolean = js.native
        }
        
        @js.native
        trait DataTransfer extends StObject {
          
          def clearData(format: String): Unit = js.native
          
          var dropEffect: String = js.native
          
          var effectAllowed: String = js.native
          
          def files(): org.scalajs.dom.raw.FileList = js.native
          
          def getData(format: String): String = js.native
          
          def setData(format: String, data: String): Unit = js.native
          
          def setDragImage(image: org.scalajs.dom.raw.Element, x: Double, y: Double): Unit = js.native
          
          def types(): js.Array[String] = js.native
        }
        
        @js.native
        trait DedicatedWorkerGlobalScope
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with WorkerGlobalScope {
          
          var onmessage: js.Function1[org.scalajs.dom.raw.MessageEvent, _] = js.native
          
          def postMessage(aMessage: js.Any, transferList: js.UndefOr[js.Array[org.scalajs.dom.raw.Transferable]]): Unit = js.native
        }
        @js.native
        object DedicatedWorkerGlobalScope extends StObject {
          
          def self(): DedicatedWorkerGlobalScope = js.native
        }
        
        @js.native
        trait DelayNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          val delayTime: org.scalajs.dom.raw.AudioParam = js.native
        }
        
        @js.native
        abstract class Document ()
          extends StObject
             with org.scalajs.dom.raw.Node
             with org.scalajs.dom.raw.NodeSelector
             with org.scalajs.dom.raw.DocumentEvent
             with org.scalajs.dom.raw.ParentNode
             with PageVisibility {
          
          def adoptNode(source: org.scalajs.dom.raw.Node): org.scalajs.dom.raw.Node = js.native
          
          def characterSet(): String = js.native
          
          def createAttribute(name: String): org.scalajs.dom.raw.Attr = js.native
          
          def createAttributeNS(namespaceURI: String, qualifiedName: String): org.scalajs.dom.raw.Attr = js.native
          
          def createCDATASection(data: String): org.scalajs.dom.raw.CDATASection = js.native
          
          def createComment(data: String): org.scalajs.dom.raw.Comment = js.native
          
          def createDocumentFragment(): org.scalajs.dom.raw.DocumentFragment = js.native
          
          def createElement(tagName: String): org.scalajs.dom.raw.Element = js.native
          
          def createElementNS(namespaceURI: String, qualifiedName: String): org.scalajs.dom.raw.Element = js.native
          
          def createNSResolver(node: org.scalajs.dom.raw.Node): org.scalajs.dom.raw.XPathNSResolver = js.native
          
          def createNodeIterator(
            root: org.scalajs.dom.raw.Node,
            whatToShow: Int,
            filter: org.scalajs.dom.raw.NodeFilter,
            entityReferenceExpansion: Boolean
          ): org.scalajs.dom.raw.NodeIterator = js.native
          
          def createProcessingInstruction(target: String, data: String): org.scalajs.dom.raw.ProcessingInstruction = js.native
          
          def createRange(): org.scalajs.dom.raw.Range = js.native
          
          def createStyleSheet(href: String, index: Int): CSSStyleSheet = js.native
          
          def createTextNode(data: String): org.scalajs.dom.raw.Text = js.native
          
          def createTreeWalker(
            root: org.scalajs.dom.raw.Node,
            whatToShow: Int,
            filter: org.scalajs.dom.raw.NodeFilter,
            entityReferenceExpansion: Boolean
          ): org.scalajs.dom.raw.TreeWalker = js.native
          
          def doctype(): org.scalajs.dom.raw.DocumentType = js.native
          
          def documentElement(): org.scalajs.dom.raw.Element = js.native
          
          def documentURI(): String = js.native
          
          def elementFromPoint(x: Double, y: Double): org.scalajs.dom.raw.Element = js.native
          
          def evaluate(
            xpathExpression: String,
            contextNode: org.scalajs.dom.raw.Node,
            namespaceResolver: js.Function1[String, String],
            resultType: Int,
            result: org.scalajs.dom.raw.XPathResult
          ): org.scalajs.dom.raw.XPathResult = js.native
          def evaluate(
            xpathExpression: String,
            contextNode: org.scalajs.dom.raw.Node,
            namespaceResolver: org.scalajs.dom.raw.XPathNSResolver,
            resultType: Int,
            result: org.scalajs.dom.raw.XPathResult
          ): org.scalajs.dom.raw.XPathResult = js.native
          
          def exitFullscreen(): js.Promise[Unit] = js.native
          
          def fullscreenElement(): org.scalajs.dom.raw.Element = js.native
          
          def fullscreenEnabled(): Boolean = js.native
          
          def getElementById(elementId: String): org.scalajs.dom.raw.Element = js.native
          
          def getElementsByClassName(classNames: String): HTMLCollection = js.native
          
          def getElementsByName(elementName: String): org.scalajs.dom.raw.NodeList = js.native
          
          def getElementsByTagName(name: String): HTMLCollection = js.native
          
          def getElementsByTagNameNS(namespaceURI: String, localName: String): HTMLCollection = js.native
          
          def implementation(): org.scalajs.dom.raw.DOMImplementation = js.native
          
          def importNode(importedNode: org.scalajs.dom.raw.Node, deep: Boolean): org.scalajs.dom.raw.Node = js.native
          
          def lastModified(): String = js.native
          
          var onfullscreenchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onfullscreenerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          def styleSheets(): org.scalajs.dom.raw.StyleSheetList = js.native
        }
        
        @js.native
        trait DocumentEvent extends StObject {
          
          def createEvent(eventInterface: String): org.scalajs.dom.raw.Event = js.native
        }
        
        @js.native
        abstract class DocumentFragment ()
          extends StObject
             with org.scalajs.dom.raw.Node
             with org.scalajs.dom.raw.NodeSelector
        
        @js.native
        abstract class DocumentType ()
          extends StObject
             with org.scalajs.dom.raw.Node {
          
          def name(): String = js.native
          
          def publicId(): String = js.native
          
          def systemId(): String = js.native
        }
        
        @js.native
        trait DragEvent
          extends StObject
             with org.scalajs.dom.raw.MouseEvent {
          
          def dataTransfer(): org.scalajs.dom.raw.DataTransfer = js.native
        }
        
        @js.native
        trait DynamicsCompressorNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          val attack: org.scalajs.dom.raw.AudioParam = js.native
          
          val knee: org.scalajs.dom.raw.AudioParam = js.native
          
          val ratio: org.scalajs.dom.raw.AudioParam = js.native
          
          val reduction: org.scalajs.dom.raw.AudioParam = js.native
          
          val release: org.scalajs.dom.raw.AudioParam = js.native
          
          val threshold: org.scalajs.dom.raw.AudioParam = js.native
        }
        
        @js.native
        abstract class Element ()
          extends StObject
             with org.scalajs.dom.raw.Node
             with org.scalajs.dom.raw.NodeSelector
             with org.scalajs.dom.raw.ParentNode
             with NonDocumentTypeChildNode {
          
          var accessKey: String = js.native
          
          var classList: org.scalajs.dom.raw.DOMTokenList = js.native
          
          def clientHeight(): Int = js.native
          
          def clientLeft(): Int = js.native
          
          def clientTop(): Int = js.native
          
          def clientWidth(): Int = js.native
          
          def getAttribute(name: String): String = js.native
          
          def getAttributeNS(namespaceURI: String, localName: String): String = js.native
          
          def getAttributeNode(name: String): org.scalajs.dom.raw.Attr = js.native
          
          def getAttributeNodeNS(namespaceURI: String, localName: String): org.scalajs.dom.raw.Attr = js.native
          
          def getBoundingClientRect(): org.scalajs.dom.raw.ClientRect = js.native
          
          def getClientRects(): org.scalajs.dom.raw.ClientRectList = js.native
          
          def getElementsByClassName(classNames: String): HTMLCollection = js.native
          
          def getElementsByTagName(name: String): HTMLCollection = js.native
          
          def getElementsByTagNameNS(namespaceURI: String, localName: String): HTMLCollection = js.native
          
          def hasAttribute(name: String): Boolean = js.native
          
          def hasAttributeNS(namespaceURI: String, localName: String): Boolean = js.native
          
          var id: String = js.native
          
          var innerHTML: String = js.native
          
          def insertAdjacentHTML(where: String, html: String): Unit = js.native
          
          def matches(selector: String): Boolean = js.native
          
          var oncopy: js.Function1[org.scalajs.dom.raw.ClipboardEvent, _] = js.native
          
          var oncut: js.Function1[org.scalajs.dom.raw.ClipboardEvent, _] = js.native
          
          var onfullscreenchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onfullscreenerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onpaste: js.Function1[org.scalajs.dom.raw.ClipboardEvent, _] = js.native
          
          var outerHTML: String = js.native
          
          def prefix(): String = js.native
          
          def removeAttribute(name: String): Unit = js.native
          
          def removeAttributeNS(namespaceURI: String, localName: String): Unit = js.native
          
          def removeAttributeNode(oldAttr: org.scalajs.dom.raw.Attr): org.scalajs.dom.raw.Attr = js.native
          
          def requestFullscreen(options: FullscreenOptions): js.Promise[Unit] = js.native
          
          def scrollHeight(): Int = js.native
          
          def scrollIntoView(top: Boolean): Unit = js.native
          
          var scrollLeft: Double = js.native
          
          var scrollTop: Double = js.native
          
          def scrollWidth(): Int = js.native
          
          def setAttribute(name: String, value: String): Unit = js.native
          
          def setAttributeNS(namespaceURI: String, qualifiedName: String, value: String): Unit = js.native
          
          def setAttributeNode(newAttr: org.scalajs.dom.raw.Attr): org.scalajs.dom.raw.Attr = js.native
          
          def setAttributeNodeNS(newAttr: org.scalajs.dom.raw.Attr): org.scalajs.dom.raw.Attr = js.native
          
          def tagName(): String = js.native
        }
        
        @js.native
        trait ErrorEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          def colno(): Int = js.native
          
          def filename(): String = js.native
          
          def lineno(): Int = js.native
          
          def message(): String = js.native
        }
        
        @js.native
        class Event protected () extends StObject {
          def this(typeArg: String, init: js.UndefOr[EventInit]) = this()
          
          def bubbles(): Boolean = js.native
          
          def cancelBubble(): Boolean = js.native
          
          def cancelable(): Boolean = js.native
          
          def currentTarget(): org.scalajs.dom.raw.EventTarget = js.native
          
          def defaultPrevented(): Boolean = js.native
          
          def eventPhase(): Int = js.native
          
          val init: js.UndefOr[EventInit] = js.native
          
          def isTrusted(): Boolean = js.native
          
          def preventDefault(): Unit = js.native
          
          def stopImmediatePropagation(): Unit = js.native
          
          def stopPropagation(): Unit = js.native
          
          def target(): org.scalajs.dom.raw.EventTarget = js.native
          
          def timeStamp(): Double = js.native
          
          def `type`(): String = js.native
          
          val typeArg: String = js.native
        }
        @js.native
        object Event extends StObject {
          
          def AT_TARGET(): Int = js.native
          
          def BUBBLING_PHASE(): Int = js.native
          
          def CAPTURING_PHASE(): Int = js.native
        }
        
        @js.native
        trait EventException extends StObject {
          
          def code(): Int = js.native
          
          def message(): String = js.native
          
          def name(): String = js.native
        }
        @js.native
        object EventException extends StObject {
          
          val DISPATCH_REQUEST_ERR: Int = js.native
          
          val UNSPECIFIED_EVENT_TYPE_ERR: Int = js.native
        }
        
        @js.native
        trait EventInit extends StObject {
          
          var bubbles: js.UndefOr[Boolean] = js.native
          
          var cancelable: js.UndefOr[Boolean] = js.native
          
          var composed: js.UndefOr[Boolean] = js.native
          
          var scoped: js.UndefOr[Boolean] = js.native
        }
        
        @js.native
        trait EventListenerOptions extends StObject {
          
          var capture: js.UndefOr[Boolean] = js.native
          
          var once: js.UndefOr[Boolean] = js.native
          
          var passive: js.UndefOr[Boolean] = js.native
        }
        
        @js.native
        class EventSource protected ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          def this(URL: String, settings: js.Dynamic) = this()
          
          val URL: String = js.native
          
          def close(): Unit = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onmessage: js.Function1[org.scalajs.dom.raw.MessageEvent, _] = js.native
          
          var onopen: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          def readyState(): Int = js.native
          
          val settings: js.Dynamic = js.native
          
          def url(): String = js.native
          
          def withCredentials(): Boolean = js.native
        }
        @js.native
        object EventSource extends StObject {
          
          val CLOSED: Int = js.native
          
          val CONNECTING: Int = js.native
          
          val OPEN: Int = js.native
        }
        
        @js.native
        class EventTarget () extends StObject {
          
          def addEventListener[T](`type`: String, listener: js.Function1[T, _], options: EventListenerOptions): Unit = js.native
          def addEventListener[T](`type`: String, listener: js.Function1[T, _], useCapture: Boolean): Unit = js.native
          
          def dispatchEvent(evt: org.scalajs.dom.raw.Event): Boolean = js.native
          
          def removeEventListener[T](`type`: String, listener: js.Function1[T, _], options: EventListenerOptions): Unit = js.native
          def removeEventListener[T](`type`: String, listener: js.Function1[T, _], useCapture: Boolean): Unit = js.native
        }
        
        @js.native
        trait External extends StObject
        
        @js.native
        abstract class File ()
          extends StObject
             with org.scalajs.dom.raw.Blob {
          
          def name(): String = js.native
        }
        
        @js.native
        trait FileList
          extends StObject
             with org.scalajs.dom.raw.DOMList[org.scalajs.dom.raw.File]
        
        @js.native
        class FileReader ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def abort(): Unit = js.native
          
          def error(): org.scalajs.dom.raw.DOMException = js.native
          
          var onabort: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onload: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onloadend: js.Function1[org.scalajs.dom.raw.ProgressEvent, _] = js.native
          
          var onloadstart: js.Function1[org.scalajs.dom.raw.ProgressEvent, _] = js.native
          
          var onprogress: js.Function1[org.scalajs.dom.raw.ProgressEvent, _] = js.native
          
          def readAsArrayBuffer(blob: org.scalajs.dom.raw.Blob): Unit = js.native
          
          def readAsDataURL(blob: org.scalajs.dom.raw.Blob): Unit = js.native
          
          def readAsText(blob: org.scalajs.dom.raw.Blob, encoding: String): Unit = js.native
          
          def readyState(): Short = js.native
          
          def result(): js.Any = js.native
        }
        @js.native
        object FileReader extends StObject {
          
          val DONE: Short = js.native
          
          val EMPTY: Short = js.native
          
          val LOADING: Short = js.native
        }
        
        @js.native
        class FocusEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.UIEvent {
          def this(typeArg: String, init: js.UndefOr[FocusEventInit]) = this()
          
          val init: js.UndefOr[FocusEventInit] = js.native
          
          def relatedTarget(): org.scalajs.dom.raw.EventTarget = js.native
          
          val typeArg: String = js.native
        }
        
        @js.native
        trait FocusEventInit
          extends StObject
             with UIEventInit {
          
          val relatedTarget: js.UndefOr[org.scalajs.dom.raw.EventTarget] = js.native
        }
        
        @js.native
        class FormData protected () extends StObject {
          def this(form: HTMLFormElement) = this()
          
          def append(name: js.Any, value: js.Any, blobName: String): Unit = js.native
          
          val form: HTMLFormElement = js.native
        }
        
        @js.native
        trait FullscreenOptions extends StObject {
          
          var navigationUI: js.UndefOr[String] = js.native
        }
        
        @js.native
        trait GainNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          val gain: org.scalajs.dom.raw.AudioParam = js.native
        }
        
        @js.native
        trait Geolocation extends StObject {
          
          def clearWatch(watchId: Int): Unit = js.native
          
          def getCurrentPosition(successCallback: js.Function1[org.scalajs.dom.raw.Position, _]): Unit = js.native
          def getCurrentPosition(
            successCallback: js.Function1[org.scalajs.dom.raw.Position, _],
            errorCallback: js.Function1[org.scalajs.dom.raw.PositionError, _],
            options: org.scalajs.dom.raw.PositionOptions
          ): Unit = js.native
          
          def watchPosition(
            successCallback: js.Function1[org.scalajs.dom.raw.Position, _],
            errorCallback: js.Function1[org.scalajs.dom.raw.PositionError, _],
            options: org.scalajs.dom.raw.PositionOptions
          ): Int = js.native
        }
        
        @js.native
        trait GetSVGDocument extends StObject {
          
          def getSVGDocument(): org.scalajs.dom.raw.Document = js.native
        }
        
        @js.native
        abstract class HTMLAnchorElement ()
          extends StObject
             with HTMLElement {
          
          var charset: String = js.native
          
          var hash: String = js.native
          
          var host: String = js.native
          
          var hostname: String = js.native
          
          var href: String = js.native
          
          var hreflang: String = js.native
          
          var mimeType: String = js.native
          
          var pathname: String = js.native
          
          var port: String = js.native
          
          var protocol: String = js.native
          
          var rel: String = js.native
          
          var search: String = js.native
          
          var target: String = js.native
          
          var text: String = js.native
          
          var `type`: String = js.native
        }
        
        @js.native
        abstract class HTMLAreaElement ()
          extends StObject
             with HTMLElement {
          
          var alt: String = js.native
          
          var coords: String = js.native
          
          var hash: String = js.native
          
          var host: String = js.native
          
          var hostname: String = js.native
          
          var href: String = js.native
          
          var pathname: String = js.native
          
          var port: String = js.native
          
          var protocol: String = js.native
          
          var search: String = js.native
          
          var shape: String = js.native
          
          var target: String = js.native
        }
        
        @js.native
        abstract class HTMLAudioElement ()
          extends StObject
             with HTMLMediaElement
        
        @js.native
        abstract class HTMLBRElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLBaseElement ()
          extends StObject
             with HTMLElement {
          
          var href: String = js.native
          
          var target: String = js.native
        }
        
        @js.native
        abstract class HTMLBodyElement ()
          extends StObject
             with HTMLElement {
          
          var onafterprint: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onbeforeprint: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onbeforeunload: js.Function1[org.scalajs.dom.raw.BeforeUnloadEvent, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onhashchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onmessage: js.Function1[org.scalajs.dom.raw.MessageEvent, _] = js.native
          
          var onoffline: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var ononline: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onpopstate: js.Function1[org.scalajs.dom.raw.PopStateEvent, _] = js.native
          
          var onresize: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onstorage: js.Function1[org.scalajs.dom.raw.StorageEvent, _] = js.native
          
          var onunload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var scroll: String = js.native
        }
        
        @js.native
        abstract class HTMLButtonElement ()
          extends StObject
             with HTMLElement {
          
          var autofocus: Boolean = js.native
          
          def checkValidity(): Boolean = js.native
          
          var disabled: Boolean = js.native
          
          def form(): HTMLFormElement = js.native
          
          var formAction: String = js.native
          
          var formEnctype: String = js.native
          
          var formMethod: String = js.native
          
          var formNoValidate: String = js.native
          
          var formTarget: String = js.native
          
          var name: String = js.native
          
          def setCustomValidity(error: String): Unit = js.native
          
          var status: js.Any = js.native
          
          var `type`: String = js.native
          
          def validationMessage(): String = js.native
          
          def validity(): org.scalajs.dom.raw.ValidityState = js.native
          
          var value: String = js.native
          
          def willValidate(): Boolean = js.native
        }
        
        @js.native
        abstract class HTMLCanvasElement ()
          extends StObject
             with HTMLElement {
          
          def getContext(contextId: String, args: js.Any): js.Dynamic = js.native
          
          var height: Int = js.native
          
          def toDataURL(`type`: String, args: js.Any): String = js.native
          
          var width: Int = js.native
        }
        
        @js.native
        abstract class HTMLCollection ()
          extends StObject
             with org.scalajs.dom.raw.DOMList[org.scalajs.dom.raw.Element] {
          
          def namedItem(name: String): org.scalajs.dom.raw.Element = js.native
        }
        
        @js.native
        abstract class HTMLDListElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLDataListElement ()
          extends StObject
             with HTMLElement {
          
          def options(): HTMLCollection = js.native
        }
        
        @js.native
        abstract class HTMLDivElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLDocument ()
          extends StObject
             with org.scalajs.dom.raw.Document {
          
          def URL(): String = js.native
          
          def activeElement(): org.scalajs.dom.raw.Element = js.native
          
          def anchors(): HTMLCollection = js.native
          
          var body: HTMLElement = js.native
          
          def close(): Unit = js.native
          
          def compatMode(): String = js.native
          
          var cookie: String = js.native
          
          def defaultView(): org.scalajs.dom.raw.Window = js.native
          
          var designMode: String = js.native
          
          var dir: String = js.native
          
          var domain: String = js.native
          
          def embeds(): HTMLCollection = js.native
          
          def execCommand(commandId: String, showUI: Boolean, value: js.Any): Boolean = js.native
          
          def execCommandShowHelp(commandId: String): Boolean = js.native
          
          def fireEvent(eventName: String, eventObj: js.Any): Boolean = js.native
          
          def focus(): Unit = js.native
          
          def forms(): HTMLCollection = js.native
          
          def getSelection(): org.scalajs.dom.raw.Selection = js.native
          
          var gotpointercapture: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          def hasFocus(): Boolean = js.native
          
          def head(): HTMLHeadElement = js.native
          
          def images(): HTMLCollection = js.native
          
          def links(): HTMLCollection = js.native
          
          var location: org.scalajs.dom.raw.Location = js.native
          
          var lostpointercapture: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onabort: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onactivate: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onbeforeactivate: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onbeforedeactivate: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onblur: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var oncanplay: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var oncanplaythrough: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onclick: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var oncontextmenu: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var ondblclick: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var ondeactivate: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var ondrag: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragend: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragenter: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragleave: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragover: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragstart: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondrop: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondurationchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onemptied: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onended: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onfocus: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var onfocusin: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var onfocusout: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var onhelp: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var oninput: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onkeydown: js.Function1[org.scalajs.dom.raw.KeyboardEvent, _] = js.native
          
          var onkeypress: js.Function1[org.scalajs.dom.raw.KeyboardEvent, _] = js.native
          
          var onkeyup: js.Function1[org.scalajs.dom.raw.KeyboardEvent, _] = js.native
          
          var onload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onloadeddata: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onloadedmetadata: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onloadstart: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onmousedown: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmousemove: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseout: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseover: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseup: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmousewheel: js.Function1[org.scalajs.dom.raw.WheelEvent, _] = js.native
          
          var onpause: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onplay: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onplaying: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onpointercancel: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerdown: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerenter: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerleave: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointermove: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerout: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerover: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerup: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onprogress: js.Function1[js.Any, _] = js.native
          
          var onratechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onreadystatechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onreset: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onscroll: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onseeked: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onseeking: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onselect: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onselectionchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onselectstart: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onstalled: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onstop: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onstoragecommit: js.Function1[org.scalajs.dom.raw.StorageEvent, _] = js.native
          
          var onsubmit: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onsuspend: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var ontimeupdate: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onvolumechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onwaiting: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          def open(url: String, name: String, features: String, replace: Boolean): js.Dynamic = js.native
          
          def plugins(): HTMLCollection = js.native
          
          def queryCommandEnabled(commandId: String): Boolean = js.native
          
          def queryCommandIndeterm(commandId: String): Boolean = js.native
          
          def queryCommandState(commandId: String): Boolean = js.native
          
          def queryCommandSupported(commandId: String): Boolean = js.native
          
          def queryCommandText(commandId: String): String = js.native
          
          def queryCommandValue(commandId: String): String = js.native
          
          def readyState(): String = js.native
          
          def referrer(): String = js.native
          
          var title: String = js.native
          
          var uniqueID: String = js.native
          
          def updateSettings(): Unit = js.native
          
          def write(content: String): Unit = js.native
          
          def writeln(content: String): Unit = js.native
        }
        
        @js.native
        abstract class HTMLElement ()
          extends StObject
             with org.scalajs.dom.raw.Element {
          
          def blur(): Unit = js.native
          
          var className: String = js.native
          
          def click(): Unit = js.native
          
          def contains(child: HTMLElement): Boolean = js.native
          
          var contentEditable: String = js.native
          
          def dataset(): js.Dictionary[String] = js.native
          
          var dir: String = js.native
          
          var draggable: Boolean = js.native
          
          var filters: Object = js.native
          
          def focus(): Unit = js.native
          
          var gotpointercapture: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          def isContentEditable(): Boolean = js.native
          
          var lang: String = js.native
          
          var lostpointercapture: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          def offsetHeight(): Double = js.native
          
          def offsetLeft(): Double = js.native
          
          def offsetParent(): org.scalajs.dom.raw.Element = js.native
          
          def offsetTop(): Double = js.native
          
          def offsetWidth(): Double = js.native
          
          var onabort: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onactivate: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onbeforeactivate: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onbeforecopy: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var onbeforecut: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var onbeforedeactivate: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onbeforepaste: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var onblur: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var oncanplay: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var oncanplaythrough: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onclick: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var oncontextmenu: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var oncuechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var ondblclick: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var ondeactivate: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var ondrag: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragend: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragenter: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragleave: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragover: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragstart: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondrop: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondurationchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onemptied: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onended: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onfocus: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var onfocusin: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var onfocusout: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var onhelp: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var oninput: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onkeydown: js.Function1[org.scalajs.dom.raw.KeyboardEvent, _] = js.native
          
          var onkeypress: js.Function1[org.scalajs.dom.raw.KeyboardEvent, _] = js.native
          
          var onkeyup: js.Function1[org.scalajs.dom.raw.KeyboardEvent, _] = js.native
          
          var onloadeddata: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onloadedmetadata: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onloadstart: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onmousedown: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseenter: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseleave: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmousemove: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseout: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseover: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseup: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmousewheel: js.Function1[org.scalajs.dom.raw.WheelEvent, _] = js.native
          
          var onpause: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onplay: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onplaying: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onpointercancel: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerdown: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerenter: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerleave: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointermove: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerout: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerover: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerup: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onprogress: js.Function1[js.Any, _] = js.native
          
          var onratechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onreadystatechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onreset: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onscroll: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onseeked: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onseeking: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onselect: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onselectstart: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onstalled: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onsubmit: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onsuspend: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var ontimeupdate: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onvolumechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onwaiting: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          override def ownerDocument(): HTMLDocument = js.native
          
          var parentElement: HTMLElement = js.native
          
          var readyState: js.Any = js.native
          
          var recordNumber: js.Any = js.native
          
          var spellcheck: Boolean = js.native
          
          def style(): CSSStyleDeclaration = js.native
          def style_=(value: String): Unit = js.native
          def style_=(value: CSSStyleDeclaration): Unit = js.native
          
          var tabIndex: Int = js.native
          
          var title: String = js.native
        }
        
        @js.native
        abstract class HTMLEmbedElement ()
          extends StObject
             with HTMLElement
             with GetSVGDocument {
          
          var height: String = js.native
          
          var src: String = js.native
          
          var width: String = js.native
        }
        
        @js.native
        abstract class HTMLFieldSetElement ()
          extends StObject
             with HTMLElement {
          
          def checkValidity(): Boolean = js.native
          
          var disabled: Boolean = js.native
          
          def form(): HTMLFormElement = js.native
          
          def setCustomValidity(error: String): Unit = js.native
          
          def validationMessage(): String = js.native
          
          def validity(): org.scalajs.dom.raw.ValidityState = js.native
          
          def willValidate(): Boolean = js.native
        }
        
        @js.native
        abstract class HTMLFormElement ()
          extends StObject
             with HTMLElement {
          
          var acceptCharset: String = js.native
          
          var action: String = js.native
          
          def apply(name: String): js.Any = js.native
          
          var autocomplete: String = js.native
          
          def checkValidity(): Boolean = js.native
          
          def elements(): HTMLCollection = js.native
          
          var encoding: String = js.native
          
          var enctype: String = js.native
          
          def item(name: js.Any, index: js.Any): js.Dynamic = js.native
          
          def length(): Int = js.native
          
          var method: String = js.native
          
          var name: String = js.native
          
          def namedItem(name: String): js.Dynamic = js.native
          
          var noValidate: Boolean = js.native
          
          def reset(): Unit = js.native
          
          def submit(): Unit = js.native
          
          var target: String = js.native
          
          def update(name: String, v: js.Any): Unit = js.native
        }
        
        @js.native
        abstract class HTMLHRElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLHeadElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLHeadingElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLHtmlElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLIFrameElement ()
          extends StObject
             with HTMLElement
             with GetSVGDocument {
          
          var border: String = js.native
          
          def contentDocument(): org.scalajs.dom.raw.Document = js.native
          
          def contentWindow(): org.scalajs.dom.raw.Window = js.native
          
          var height: String = js.native
          
          var name: String = js.native
          
          var onload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var sandbox: org.scalajs.dom.raw.DOMSettableTokenList = js.native
          
          var security: js.Any = js.native
          
          var src: String = js.native
          
          var width: String = js.native
        }
        
        @js.native
        abstract class HTMLImageElement ()
          extends StObject
             with HTMLElement {
          
          var alt: String = js.native
          
          def complete(): Boolean = js.native
          
          var height: Int = js.native
          
          var href: String = js.native
          
          var isMap: Boolean = js.native
          
          var naturalHeight: Int = js.native
          
          var naturalWidth: Int = js.native
          
          var onload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var src: String = js.native
          
          var useMap: String = js.native
          
          var width: Int = js.native
        }
        
        @js.native
        abstract class HTMLInputElement ()
          extends StObject
             with HTMLElement {
          
          var accept: String = js.native
          
          var alt: String = js.native
          
          var autocomplete: String = js.native
          
          var autofocus: Boolean = js.native
          
          def checkValidity(): Boolean = js.native
          
          var checked: Boolean = js.native
          
          var defaultChecked: Boolean = js.native
          
          var defaultValue: String = js.native
          
          var disabled: Boolean = js.native
          
          var files: org.scalajs.dom.raw.FileList = js.native
          
          def form(): HTMLFormElement = js.native
          
          var formAction: String = js.native
          
          var formEnctype: String = js.native
          
          var formMethod: String = js.native
          
          var formNoValidate: String = js.native
          
          var formTarget: String = js.native
          
          var height: String = js.native
          
          var indeterminate: Boolean = js.native
          
          var list: HTMLElement = js.native
          
          var max: String = js.native
          
          var maxLength: Int = js.native
          
          var min: String = js.native
          
          var multiple: Boolean = js.native
          
          var name: String = js.native
          
          var pattern: String = js.native
          
          var placeholder: String = js.native
          
          var readOnly: Boolean = js.native
          
          var required: Boolean = js.native
          
          def select(): Unit = js.native
          
          var selectionEnd: Int = js.native
          
          var selectionStart: Int = js.native
          
          def setCustomValidity(error: String): Unit = js.native
          
          def setSelectionRange(start: Int, end: Int): Unit = js.native
          
          var size: Int = js.native
          
          var src: String = js.native
          
          var status: Boolean = js.native
          
          var step: String = js.native
          
          def stepDown(n: Int): Unit = js.native
          
          def stepUp(n: Int): Unit = js.native
          
          var `type`: String = js.native
          
          def validationMessage(): String = js.native
          
          def validity(): org.scalajs.dom.raw.ValidityState = js.native
          
          var value: String = js.native
          
          var valueAsNumber: Double = js.native
          
          var width: String = js.native
          
          def willValidate(): Boolean = js.native
        }
        
        @js.native
        abstract class HTMLLIElement ()
          extends StObject
             with HTMLElement {
          
          var value: Int = js.native
        }
        
        @js.native
        abstract class HTMLLabelElement ()
          extends StObject
             with HTMLElement {
          
          def form(): HTMLFormElement = js.native
          
          var htmlFor: String = js.native
        }
        
        @js.native
        abstract class HTMLLegendElement ()
          extends StObject
             with HTMLElement {
          
          var align: String = js.native
          
          def form(): HTMLFormElement = js.native
        }
        
        @js.native
        abstract class HTMLLinkElement ()
          extends StObject
             with HTMLElement
             with org.scalajs.dom.raw.LinkStyle {
          
          var href: String = js.native
          
          var hreflang: String = js.native
          
          var media: String = js.native
          
          var rel: String = js.native
          
          var rev: String = js.native
          
          var target: String = js.native
          
          var `type`: String = js.native
        }
        
        @js.native
        abstract class HTMLMapElement ()
          extends StObject
             with HTMLElement {
          
          var name: String = js.native
        }
        
        @js.native
        abstract class HTMLMediaElement ()
          extends StObject
             with HTMLElement {
          
          def audioTracks(): org.scalajs.dom.raw.AudioTrackList = js.native
          
          var autoplay: Boolean = js.native
          
          def buffered(): org.scalajs.dom.raw.TimeRanges = js.native
          
          def canPlayType(`type`: String): String = js.native
          
          var controls: Boolean = js.native
          
          def currentSrc(): String = js.native
          
          var currentTime: Double = js.native
          
          var defaultPlaybackRate: Double = js.native
          
          def duration(): Double = js.native
          
          def ended(): Boolean = js.native
          
          def error(): org.scalajs.dom.raw.MediaError = js.native
          
          def initialTime(): Double = js.native
          
          def load(): Unit = js.native
          
          var loop: Boolean = js.native
          
          var muted: Boolean = js.native
          
          def networkState(): Int = js.native
          
          def pause(): Unit = js.native
          
          def paused(): Boolean = js.native
          
          def play(): Unit = js.native
          
          var playbackRate: Double = js.native
          
          def played(): org.scalajs.dom.raw.TimeRanges = js.native
          
          var preload: String = js.native
          
          def seekable(): org.scalajs.dom.raw.TimeRanges = js.native
          
          def seeking(): Boolean = js.native
          
          var src: String = js.native
          
          def textTracks(): org.scalajs.dom.raw.TextTrackList = js.native
          
          var volume: Double = js.native
        }
        @js.native
        object HTMLMediaElement extends StObject {
          
          val HAVE_CURRENT_DATA: Int = js.native
          
          val HAVE_ENOUGH_DATA: Int = js.native
          
          val HAVE_FUTURE_DATA: Int = js.native
          
          val HAVE_METADATA: Int = js.native
          
          val HAVE_NOTHING: Int = js.native
          
          val NETWORK_EMPTY: Int = js.native
          
          val NETWORK_IDLE: Int = js.native
          
          val NETWORK_LOADING: Int = js.native
          
          val NETWORK_NO_SOURCE: Int = js.native
        }
        
        @js.native
        abstract class HTMLMenuElement ()
          extends StObject
             with HTMLElement {
          
          var `type`: String = js.native
        }
        
        @js.native
        abstract class HTMLMetaElement ()
          extends StObject
             with HTMLElement {
          
          var charset: String = js.native
          
          var content: String = js.native
          
          var httpEquiv: String = js.native
          
          var name: String = js.native
          
          var url: String = js.native
        }
        
        @js.native
        abstract class HTMLModElement ()
          extends StObject
             with HTMLElement {
          
          var cite: String = js.native
          
          var dateTime: String = js.native
        }
        
        @js.native
        abstract class HTMLOListElement ()
          extends StObject
             with HTMLElement {
          
          var start: Int = js.native
        }
        
        @js.native
        abstract class HTMLObjectElement ()
          extends StObject
             with HTMLElement
             with GetSVGDocument {
          
          var BaseHref: String = js.native
          
          var alt: String = js.native
          
          var altHtml: String = js.native
          
          def checkValidity(): Boolean = js.native
          
          var classid: String = js.native
          
          def contentDocument(): org.scalajs.dom.raw.Document = js.native
          
          var data: String = js.native
          
          def form(): HTMLFormElement = js.native
          
          var height: String = js.native
          
          var name: String = js.native
          
          var `object`: Object = js.native
          
          def setCustomValidity(error: String): Unit = js.native
          
          var `type`: String = js.native
          
          var useMap: String = js.native
          
          def validationMessage(): String = js.native
          
          def validity(): org.scalajs.dom.raw.ValidityState = js.native
          
          var width: String = js.native
          
          def willValidate(): Boolean = js.native
        }
        
        @js.native
        abstract class HTMLOptGroupElement ()
          extends StObject
             with HTMLElement {
          
          var disabled: Boolean = js.native
          
          var label: String = js.native
        }
        
        @js.native
        abstract class HTMLOptionElement ()
          extends StObject
             with HTMLElement {
          
          def create(): HTMLOptionElement = js.native
          
          var defaultSelected: Boolean = js.native
          
          var disabled: Boolean = js.native
          
          def form(): HTMLFormElement = js.native
          
          def index(): Int = js.native
          
          var label: String = js.native
          
          var selected: Boolean = js.native
          
          var text: String = js.native
          
          var value: String = js.native
        }
        
        @js.native
        abstract class HTMLParagraphElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLParamElement ()
          extends StObject
             with HTMLElement {
          
          var name: String = js.native
          
          var value: String = js.native
        }
        
        @js.native
        abstract class HTMLPreElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLProgressElement ()
          extends StObject
             with HTMLElement {
          
          var form: HTMLFormElement = js.native
          
          var max: Double = js.native
          
          def position(): Double = js.native
          
          var value: Double = js.native
        }
        
        @js.native
        abstract class HTMLQuoteElement ()
          extends StObject
             with HTMLElement {
          
          var cite: String = js.native
          
          var dateTime: String = js.native
        }
        
        @js.native
        abstract class HTMLScriptElement ()
          extends StObject
             with HTMLElement {
          
          var async: Boolean = js.native
          
          var charset: String = js.native
          
          var defer: Boolean = js.native
          
          var event: String = js.native
          
          var onload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var src: String = js.native
          
          var text: String = js.native
          
          var `type`: String = js.native
        }
        
        @js.native
        abstract class HTMLSelectElement ()
          extends StObject
             with HTMLElement {
          
          def add(element: HTMLElement, before: js.Any): Unit = js.native
          
          def apply(name: String): js.Any = js.native
          
          var autofocus: Boolean = js.native
          
          def checkValidity(): Boolean = js.native
          
          var disabled: Boolean = js.native
          
          def form(): HTMLFormElement = js.native
          
          def item(name: js.Any, index: js.Any): js.Dynamic = js.native
          
          var length: Int = js.native
          
          var multiple: Boolean = js.native
          
          var name: String = js.native
          
          def namedItem(name: String): js.Dynamic = js.native
          
          val options: js.Array[HTMLOptionElement] = js.native
          
          def remove(index: Int): Unit = js.native
          
          var required: Boolean = js.native
          
          var selectedIndex: Int = js.native
          
          def setCustomValidity(error: String): Unit = js.native
          
          var size: Int = js.native
          
          def `type`(): String = js.native
          
          def update(name: String, v: js.Any): Unit = js.native
          
          def validationMessage(): String = js.native
          
          def validity(): org.scalajs.dom.raw.ValidityState = js.native
          
          var value: String = js.native
          
          def willValidate(): Boolean = js.native
        }
        
        @js.native
        abstract class HTMLSourceElement ()
          extends StObject
             with HTMLElement {
          
          var media: String = js.native
          
          var src: String = js.native
          
          var `type`: String = js.native
        }
        
        @js.native
        abstract class HTMLSpanElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLStyleElement ()
          extends StObject
             with HTMLElement
             with org.scalajs.dom.raw.LinkStyle {
          
          var media: String = js.native
          
          var `type`: String = js.native
        }
        
        @js.native
        trait HTMLTableAlignment extends StObject
        
        @js.native
        abstract class HTMLTableCaptionElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLTableCellElement ()
          extends StObject
             with HTMLElement
             with HTMLTableAlignment {
          
          def cellIndex(): Int = js.native
          
          var colSpan: Int = js.native
          
          def headers(): String = js.native
          
          var rowSpan: Int = js.native
        }
        
        @js.native
        abstract class HTMLTableColElement ()
          extends StObject
             with HTMLElement
             with HTMLTableAlignment {
          
          var span: Int = js.native
        }
        
        @js.native
        abstract class HTMLTableElement ()
          extends StObject
             with HTMLElement {
          
          var caption: HTMLTableCaptionElement = js.native
          
          def createCaption(): HTMLElement = js.native
          
          def createTBody(): HTMLElement = js.native
          
          def createTFoot(): HTMLElement = js.native
          
          def createTHead(): HTMLElement = js.native
          
          def deleteCaption(): Unit = js.native
          
          def deleteRow(index: Int): Unit = js.native
          
          def deleteTFoot(): Unit = js.native
          
          def deleteTHead(): Unit = js.native
          
          def insertRow(index: Int): HTMLElement = js.native
          
          def moveRow(indexFrom: Int, indexTo: Int): Object = js.native
          
          def rows(): HTMLCollection = js.native
          
          def tBodies(): HTMLCollection = js.native
          
          var tFoot: HTMLTableSectionElement = js.native
          
          var tHead: HTMLTableSectionElement = js.native
        }
        
        @js.native
        abstract class HTMLTableRowElement ()
          extends StObject
             with HTMLElement
             with HTMLTableAlignment {
          
          var borderColor: js.Any = js.native
          
          var borderColorDark: js.Any = js.native
          
          var borderColorLight: js.Any = js.native
          
          def cells(): HTMLCollection = js.native
          
          def deleteCell(index: Int): Unit = js.native
          
          var height: js.Any = js.native
          
          def insertCell(index: Int): HTMLElement = js.native
          
          def rowIndex(): Int = js.native
          
          def sectionRowIndex(): Int = js.native
        }
        
        @js.native
        abstract class HTMLTableSectionElement ()
          extends StObject
             with HTMLElement
             with HTMLTableAlignment {
          
          def deleteRow(index: Int): Unit = js.native
          
          def insertRow(index: Int): HTMLElement = js.native
          
          def moveRow(indexFrom: Int, indexTo: Int): Object = js.native
          
          def rows(): HTMLCollection = js.native
        }
        
        @js.native
        abstract class HTMLTextAreaElement ()
          extends StObject
             with HTMLElement {
          
          var autofocus: Boolean = js.native
          
          def checkValidity(): Boolean = js.native
          
          var cols: Int = js.native
          
          var defaultValue: String = js.native
          
          var disabled: Boolean = js.native
          
          def form(): HTMLFormElement = js.native
          
          var maxLength: Int = js.native
          
          var name: String = js.native
          
          var placeholder: String = js.native
          
          var readOnly: Boolean = js.native
          
          var required: Boolean = js.native
          
          var rows: Int = js.native
          
          def select(): Unit = js.native
          
          var selectionEnd: Int = js.native
          
          var selectionStart: Int = js.native
          
          def setCustomValidity(error: String): Unit = js.native
          
          def setSelectionRange(start: Int, end: Int): Unit = js.native
          
          var status: js.Any = js.native
          
          def `type`(): String = js.native
          
          def validationMessage(): String = js.native
          
          def validity(): org.scalajs.dom.raw.ValidityState = js.native
          
          var value: String = js.native
          
          def willValidate(): Boolean = js.native
          
          var wrap: String = js.native
        }
        
        @js.native
        abstract class HTMLTitleElement ()
          extends StObject
             with HTMLElement {
          
          var text: String = js.native
        }
        
        @js.native
        abstract class HTMLTrackElement ()
          extends StObject
             with HTMLElement {
          
          var kind: String = js.native
          
          var label: String = js.native
          
          var src: String = js.native
          
          var srclang: String = js.native
          
          def track(): org.scalajs.dom.raw.TextTrack = js.native
        }
        
        @js.native
        abstract class HTMLUListElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLUnknownElement ()
          extends StObject
             with HTMLElement
        
        @js.native
        abstract class HTMLVideoElement ()
          extends StObject
             with HTMLMediaElement {
          
          var height: Int = js.native
          
          var poster: String = js.native
          
          def videoHeight(): Int = js.native
          
          def videoWidth(): Int = js.native
          
          var width: Int = js.native
        }
        
        @js.native
        trait HashChangeEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          def newURL(): String = js.native
          
          def oldURL(): String = js.native
        }
        
        @js.native
        class History () extends StObject {
          
          def back(): Unit = js.native
          
          def forward(): Unit = js.native
          
          def go(): Unit = js.native
          def go(delta: Int): Unit = js.native
          
          def length(): Int = js.native
          
          def pushState(statedata: js.Any, title: String): Unit = js.native
          def pushState(statedata: js.Any, title: String, url: String): Unit = js.native
          
          def replaceState(statedata: js.Any, title: String): Unit = js.native
          def replaceState(statedata: js.Any, title: String, url: String): Unit = js.native
          
          def state(): js.Any = js.native
        }
        
        @js.native
        class IDBCursor () extends StObject {
          
          def advance(count: Int): Unit = js.native
          
          def continue(key: js.Any): Unit = js.native
          
          def delete(): IDBRequest = js.native
          
          def direction(): String = js.native
          
          def key(): js.Any = js.native
          
          def primaryKey(): js.Any = js.native
          
          def source(): js.Any = js.native
          
          def update(value: js.Any): IDBRequest = js.native
        }
        @js.native
        object IDBCursor extends StObject {
          
          val NEXT: String = js.native
          
          val NEXT_NO_DUPLICATE: String = js.native
          
          val PREV: String = js.native
          
          val PREV_NO_DUPLICATE: String = js.native
        }
        
        @js.native
        class IDBCursorWithValue ()
          extends StObject
             with IDBCursor {
          
          def value(): js.Any = js.native
        }
        
        @js.native
        class IDBDatabase ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def close(): Unit = js.native
          
          def createObjectStore(name: String, optionalParameters: js.Any): IDBObjectStore = js.native
          
          def deleteObjectStore(name: String): Unit = js.native
          
          def name(): String = js.native
          
          def objectStoreNames(): org.scalajs.dom.raw.DOMStringList = js.native
          
          var onabort: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
          
          def transaction(storeNames: js.Any, mode: String): IDBTransaction = js.native
          
          def version(): Int = js.native
        }
        
        @js.native
        trait IDBEnvironment extends StObject {
          
          def indexedDB(): IDBFactory = js.native
        }
        
        @js.native
        class IDBFactory () extends StObject {
          
          def cmp(first: js.Any, second: js.Any): Int = js.native
          
          def deleteDatabase(name: String): IDBOpenDBRequest = js.native
          
          def open(name: String): IDBOpenDBRequest = js.native
          def open(name: String, version: Int): IDBOpenDBRequest = js.native
        }
        
        @js.native
        class IDBIndex () extends StObject {
          
          def count(): IDBRequest = js.native
          def count(key: js.Any): IDBRequest = js.native
          
          def get(key: js.Any): IDBRequest = js.native
          
          def getKey(key: js.Any): IDBRequest = js.native
          
          def keyPath(): String = js.native
          
          def name(): String = js.native
          
          def objectStore(): IDBObjectStore = js.native
          
          def openCursor(range: IDBKeyRange, direction: String): IDBRequest = js.native
          
          def openKeyCursor(range: IDBKeyRange, direction: String): IDBRequest = js.native
          
          def unique(): Boolean = js.native
        }
        
        @js.native
        class IDBKeyRange () extends StObject {
          
          def lower(): js.Any = js.native
          
          def lowerOpen(): Boolean = js.native
          
          def upper(): js.Any = js.native
          
          def upperOpen(): Boolean = js.native
        }
        @js.native
        object IDBKeyRange extends StObject {
          
          def bound(lower: js.Any, upper: js.Any, lowerOpen: Boolean, upperOpen: Boolean): IDBKeyRange = js.native
          
          def lowerBound(bound: js.Any, open: Boolean): IDBKeyRange = js.native
          
          def only(value: js.Any): IDBKeyRange = js.native
          
          def upperBound(bound: js.Any, open: Boolean): IDBKeyRange = js.native
        }
        
        @js.native
        class IDBObjectStore () extends StObject {
          
          def add(value: js.Any, key: js.Any): IDBRequest = js.native
          
          def clear(): IDBRequest = js.native
          
          def count(key: js.Any): IDBRequest = js.native
          
          def createIndex(name: String, keyPath: String, optionalParameters: js.Any): IDBIndex = js.native
          
          def delete(key: js.Any): IDBRequest = js.native
          
          def deleteIndex(indexName: String): Unit = js.native
          
          def get(key: js.Any): IDBRequest = js.native
          
          def index(name: String): IDBIndex = js.native
          
          def indexNames(): org.scalajs.dom.raw.DOMStringList = js.native
          
          def keyPath(): String = js.native
          
          def name(): String = js.native
          
          def openCursor(range: js.Any, direction: String): IDBRequest = js.native
          
          def put(value: js.Any, key: js.Any): IDBRequest = js.native
          
          def transaction(): IDBTransaction = js.native
        }
        
        @js.native
        class IDBOpenDBRequest ()
          extends StObject
             with IDBRequest {
          
          var onblocked: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onupgradeneeded: js.Function1[IDBVersionChangeEvent, _] = js.native
        }
        
        @js.native
        class IDBRequest ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def error(): org.scalajs.dom.raw.DOMException = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
          
          var onsuccess: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          def readyState(): String = js.native
          
          def result(): js.Any = js.native
          
          def source(): js.Any = js.native
          
          def transaction(): IDBTransaction = js.native
        }
        
        @js.native
        class IDBTransaction ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def abort(): Unit = js.native
          
          def db(): IDBDatabase = js.native
          
          def error(): org.scalajs.dom.raw.DOMException = js.native
          
          def mode(): String = js.native
          
          def objectStore(name: String): IDBObjectStore = js.native
          
          var onabort: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var oncomplete: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
        }
        @js.native
        object IDBTransaction extends StObject {
          
          val READ_ONLY: String = js.native
          
          val READ_WRITE: String = js.native
          
          val VERSION_CHANGE: String = js.native
        }
        
        @js.native
        class IDBVersionChangeEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.Event {
          def this(typeArg: String, init: js.UndefOr[IDBVersionChangeEventInit]) = this()
          
          val init: js.UndefOr[IDBVersionChangeEventInit] = js.native
          
          def newVersion(): Int = js.native
          
          def oldVersion(): Int = js.native
          
          val typeArg: String = js.native
        }
        
        @js.native
        trait IDBVersionChangeEventInit
          extends StObject
             with EventInit {
          
          var newVersion: js.UndefOr[Int] = js.native
          
          var oldVersion: js.UndefOr[Int] = js.native
        }
        
        @js.native
        class ImageData () extends StObject {
          
          def data(): js.Array[Int] = js.native
          
          def height(): Int = js.native
          
          def width(): Int = js.native
        }
        
        @js.native
        class KeyboardEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.UIEvent
             with org.scalajs.dom.raw.ModifierKeyEvent {
          def this(typeArg: String) = this()
          def this(typeArg: String, init: js.UndefOr[org.scalajs.dom.raw.KeyboardEventInit]) = this()
          
          def charCode(): Int = js.native
          
          def getModifierState(keyArg: String): Boolean = js.native
          
          val init: js.UndefOr[org.scalajs.dom.raw.KeyboardEventInit] = js.native
          
          def key(): String = js.native
          
          def keyCode(): Int = js.native
          
          def location(): Int = js.native
          
          def repeat(): Boolean = js.native
          
          val typeArg: String = js.native
        }
        @js.native
        object KeyboardEvent extends StObject {
          
          def DOM_KEY_LOCATION_LEFT(): Int = js.native
          
          def DOM_KEY_LOCATION_NUMPAD(): Int = js.native
          
          def DOM_KEY_LOCATION_RIGHT(): Int = js.native
          
          def DOM_KEY_LOCATION_STANDARD(): Int = js.native
        }
        
        @js.native
        trait KeyboardEventInit
          extends StObject
             with UIEventInit
             with ModifierKeyEventInit {
          
          var charCode: js.UndefOr[Int] = js.native
          
          var key: js.UndefOr[String] = js.native
          
          var keyCode: js.UndefOr[Int] = js.native
          
          var locale: js.UndefOr[String] = js.native
          
          var location: js.UndefOr[Int] = js.native
          
          var repeat: js.UndefOr[Boolean] = js.native
        }
        
        @js.native
        trait LinkStyle extends StObject {
          
          def sheet(): org.scalajs.dom.raw.StyleSheet = js.native
        }
        
        @js.native
        trait Location extends StObject {
          
          def assign(url: String): Unit = js.native
          
          var hash: String = js.native
          
          var host: String = js.native
          
          var hostname: String = js.native
          
          var href: String = js.native
          
          def origin(): js.UndefOr[String] = js.native
          
          var pathname: String = js.native
          
          var port: String = js.native
          
          var protocol: String = js.native
          
          def reload(flag: Boolean): Unit = js.native
          
          def replace(url: String): Unit = js.native
          
          var search: String = js.native
        }
        
        @js.native
        trait MediaElementAudioSourceNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode
        
        @js.native
        class MediaError () extends StObject {
          
          def code(): Int = js.native
        }
        @js.native
        object MediaError extends StObject {
          
          val MEDIA_ERR_ABORTED: Int = js.native
          
          val MEDIA_ERR_DECODE: Int = js.native
          
          val MEDIA_ERR_NETWORK: Int = js.native
          
          val MEDIA_ERR_SRC_NOT_SUPPORTED: Int = js.native
        }
        
        @js.native
        class MediaList () extends StObject {
          
          def appendMedium(newMedium: String): Unit = js.native
          
          def apply(index: Int): String = js.native
          
          def deleteMedium(oldMedium: String): Unit = js.native
          
          def item(index: Int): String = js.native
          
          def length(): Int = js.native
          
          def mediaText(): String = js.native
          
          def update(index: Int, v: String): Unit = js.native
        }
        
        @js.native
        trait MediaQueryList extends StObject {
          
          def addListener(listener: org.scalajs.dom.raw.MediaQueryListListener): Unit = js.native
          
          def matches(): Boolean = js.native
          
          var media: String = js.native
          
          def removeListener(listener: org.scalajs.dom.raw.MediaQueryListListener): Unit = js.native
        }
        
        @js.native
        trait MediaQueryListListener extends StObject {
          
          def apply(mql: org.scalajs.dom.raw.MediaQueryList): Unit = js.native
        }
        
        @js.native
        trait MediaStreamAudioDestinationNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          var stream: MediaStream = js.native
        }
        
        @js.native
        trait MediaStreamAudioSourceNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode
        
        @js.native
        class MessageChannel () extends StObject {
          
          def port1(): org.scalajs.dom.raw.MessagePort = js.native
          
          def port2(): org.scalajs.dom.raw.MessagePort = js.native
        }
        
        @js.native
        class MessageEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.Event {
          def this(typeArg: String, init: js.UndefOr[MessageEventInit]) = this()
          
          def data(): Any = js.native
          
          val init: js.UndefOr[MessageEventInit] = js.native
          
          def origin(): String = js.native
          
          def ports(): js.Any = js.native
          
          def source(): org.scalajs.dom.raw.Window = js.native
          
          val typeArg: String = js.native
        }
        
        @js.native
        trait MessageEventInit
          extends StObject
             with EventInit {
          
          var data: js.UndefOr[Any] = js.native
          
          var origin: js.UndefOr[String] = js.native
          
          var source: js.UndefOr[org.scalajs.dom.raw.Window] = js.native
        }
        
        @js.native
        trait MessagePort
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def close(): Unit = js.native
          
          var onmessage: js.Function1[org.scalajs.dom.raw.MessageEvent, _] = js.native
          
          def postMessage(message: js.Any, ports: js.Any): Unit = js.native
          
          def start(): Unit = js.native
        }
        
        @js.native
        trait ModifierKeyEvent extends StObject {
          
          def altKey(): Boolean = js.native
          
          def ctrlKey(): Boolean = js.native
          
          def metaKey(): Boolean = js.native
          
          def shiftKey(): Boolean = js.native
        }
        
        @js.native
        trait ModifierKeyEventInit extends StObject {
          
          var altKey: js.UndefOr[Boolean] = js.native
          
          var ctrlKey: js.UndefOr[Boolean] = js.native
          
          var metaKey: js.UndefOr[Boolean] = js.native
          
          var shiftKey: js.UndefOr[Boolean] = js.native
        }
        
        @js.native
        class MouseEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.UIEvent
             with org.scalajs.dom.raw.ModifierKeyEvent {
          def this(typeArg: String, init: js.UndefOr[MouseEventInit]) = this()
          
          def button(): Int = js.native
          
          def buttons(): Int = js.native
          
          def clientX(): Double = js.native
          
          def clientY(): Double = js.native
          
          def getModifierState(keyArg: String): Boolean = js.native
          
          val init: js.UndefOr[MouseEventInit] = js.native
          
          def pageX(): Double = js.native
          
          def pageY(): Double = js.native
          
          def relatedTarget(): org.scalajs.dom.raw.EventTarget = js.native
          
          def screenX(): Double = js.native
          
          def screenY(): Double = js.native
          
          val typeArg: String = js.native
        }
        
        @js.native
        trait MouseEventInit
          extends StObject
             with UIEventInit
             with ModifierKeyEventInit {
          
          var button: js.UndefOr[Int] = js.native
          
          var buttons: js.UndefOr[Int] = js.native
          
          var clientX: js.UndefOr[Double] = js.native
          
          var clientY: js.UndefOr[Double] = js.native
          
          var pageX: js.UndefOr[Double] = js.native
          
          var pageY: js.UndefOr[Double] = js.native
          
          var relatedTarget: js.UndefOr[org.scalajs.dom.raw.EventTarget] = js.native
          
          var screenX: js.UndefOr[Double] = js.native
          
          var screenY: js.UndefOr[Double] = js.native
        }
        
        @js.native
        class MutationObserver protected () extends StObject {
          def this(callback: js.Function2[
                        js.Array[org.scalajs.dom.raw.MutationRecord], 
                        org.scalajs.dom.raw.MutationObserver, 
                        _
                      ]) = this()
          
          val callback: js.Function2[
                    js.Array[org.scalajs.dom.raw.MutationRecord], 
                    org.scalajs.dom.raw.MutationObserver, 
                    _
                  ] = js.native
          
          def disconnect(): Unit = js.native
          
          def observe(target: org.scalajs.dom.raw.Node, options: org.scalajs.dom.raw.MutationObserverInit): Unit = js.native
          
          def takeRecords(): js.Array[org.scalajs.dom.raw.MutationRecord] = js.native
        }
        
        @js.native
        trait MutationObserverInit extends StObject {
          
          var attributeFilter: js.UndefOr[js.Array[String]] = js.native
          
          var attributeOldValue: js.UndefOr[Boolean] = js.native
          
          var attributes: js.UndefOr[Boolean] = js.native
          
          var characterData: js.UndefOr[Boolean] = js.native
          
          var characterDataOldValue: js.UndefOr[Boolean] = js.native
          
          var childList: js.UndefOr[Boolean] = js.native
          
          var subtree: js.UndefOr[Boolean] = js.native
        }
        
        @js.native
        trait MutationRecord extends StObject {
          
          def addedNodes(): org.scalajs.dom.raw.NodeList = js.native
          
          def attributeName(): String = js.native
          
          def attributeNamespace(): String = js.native
          
          def nextSibling(): org.scalajs.dom.raw.Node = js.native
          
          def oldValue(): String = js.native
          
          def previousSibling(): org.scalajs.dom.raw.Node = js.native
          
          def removedNodes(): org.scalajs.dom.raw.NodeList = js.native
          
          def target(): org.scalajs.dom.raw.Node = js.native
          
          def `type`(): String = js.native
        }
        
        @js.native
        class NamedNodeMap () extends StObject {
          
          def apply(index: Int): org.scalajs.dom.raw.Attr = js.native
          
          def getNamedItem(name: String): org.scalajs.dom.raw.Attr = js.native
          
          def getNamedItemNS(namespaceURI: String, localName: String): org.scalajs.dom.raw.Attr = js.native
          
          def item(index: Int): org.scalajs.dom.raw.Attr = js.native
          
          def length(): Int = js.native
          
          def removeNamedItem(name: String): org.scalajs.dom.raw.Attr = js.native
          
          def removeNamedItemNS(namespaceURI: String, localName: String): org.scalajs.dom.raw.Attr = js.native
          
          def setNamedItem(arg: org.scalajs.dom.raw.Attr): org.scalajs.dom.raw.Attr = js.native
          
          def setNamedItemNS(arg: org.scalajs.dom.raw.Attr): org.scalajs.dom.raw.Attr = js.native
          
          def update(index: Int, v: org.scalajs.dom.raw.Attr): Unit = js.native
        }
        
        @js.native
        class Navigator ()
          extends StObject
             with org.scalajs.dom.raw.NavigatorID
             with org.scalajs.dom.raw.NavigatorOnLine
             with org.scalajs.dom.raw.NavigatorContentUtils
             with org.scalajs.dom.raw.NavigatorGeolocation
             with org.scalajs.dom.raw.NavigatorStorageUtils
             with org.scalajs.dom.raw.NavigatorLanguage {
          
          def clipboard(): Clipboard = js.native
        }
        
        @js.native
        trait NavigatorContentUtils extends StObject
        
        @js.native
        trait NavigatorGeolocation extends StObject {
          
          def geolocation(): org.scalajs.dom.raw.Geolocation = js.native
        }
        
        @js.native
        trait NavigatorID extends StObject {
          
          def appName(): String = js.native
          
          def appVersion(): String = js.native
          
          def platform(): String = js.native
          
          def userAgent(): String = js.native
        }
        
        @js.native
        trait NavigatorLanguage extends StObject {
          
          def language(): String = js.native
        }
        
        @js.native
        trait NavigatorOnLine extends StObject {
          
          def onLine(): Boolean = js.native
        }
        
        @js.native
        trait NavigatorStorageUtils extends StObject
        
        @js.native
        abstract class Node ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def appendChild(newChild: org.scalajs.dom.raw.Node): org.scalajs.dom.raw.Node = js.native
          
          def attributes(): org.scalajs.dom.raw.NamedNodeMap = js.native
          
          def childNodes(): org.scalajs.dom.raw.NodeList = js.native
          
          def cloneNode(deep: Boolean): org.scalajs.dom.raw.Node = js.native
          
          def compareDocumentPosition(other: org.scalajs.dom.raw.Node): Int = js.native
          
          def contains(otherNode: org.scalajs.dom.raw.Node): Boolean = js.native
          
          def firstChild(): org.scalajs.dom.raw.Node = js.native
          
          def hasAttributes(): Boolean = js.native
          
          def hasChildNodes(): Boolean = js.native
          
          var innerText: String = js.native
          
          def insertBefore(newChild: org.scalajs.dom.raw.Node, refChild: org.scalajs.dom.raw.Node): org.scalajs.dom.raw.Node = js.native
          
          def isDefaultNamespace(namespaceURI: String): Boolean = js.native
          
          def isEqualNode(arg: org.scalajs.dom.raw.Node): Boolean = js.native
          
          def isSameNode(other: org.scalajs.dom.raw.Node): Boolean = js.native
          
          def isSupported(feature: String, version: String): Boolean = js.native
          
          def lastChild(): org.scalajs.dom.raw.Node = js.native
          
          def localName(): String = js.native
          
          def lookupNamespaceURI(prefix: String): String = js.native
          
          def lookupPrefix(namespaceURI: String): String = js.native
          
          def namespaceURI(): String = js.native
          
          def nextSibling(): org.scalajs.dom.raw.Node = js.native
          
          def nodeName(): String = js.native
          
          def nodeType(): Int = js.native
          
          var nodeValue: String = js.native
          
          def normalize(): Unit = js.native
          
          def ownerDocument(): org.scalajs.dom.raw.Document = js.native
          
          def parentNode(): org.scalajs.dom.raw.Node = js.native
          
          def previousSibling(): org.scalajs.dom.raw.Node = js.native
          
          def removeChild(oldChild: org.scalajs.dom.raw.Node): org.scalajs.dom.raw.Node = js.native
          
          def replaceChild(newChild: org.scalajs.dom.raw.Node, oldChild: org.scalajs.dom.raw.Node): org.scalajs.dom.raw.Node = js.native
          
          var textContent: String = js.native
        }
        @js.native
        object Node extends StObject {
          
          def ATTRIBUTE_NODE(): Int = js.native
          
          def CDATA_SECTION_NODE(): Int = js.native
          
          def COMMENT_NODE(): Int = js.native
          
          def DOCUMENT_FRAGMENT_NODE(): Int = js.native
          
          def DOCUMENT_NODE(): Int = js.native
          
          def DOCUMENT_POSITION_CONTAINED_BY(): Int = js.native
          
          def DOCUMENT_POSITION_CONTAINS(): Int = js.native
          
          def DOCUMENT_POSITION_DISCONNECTED(): Int = js.native
          
          def DOCUMENT_POSITION_FOLLOWING(): Int = js.native
          
          def DOCUMENT_POSITION_IMPLEMENTATION_SPECIFIC(): Int = js.native
          
          def DOCUMENT_POSITION_PRECEDING(): Int = js.native
          
          def DOCUMENT_TYPE_NODE(): Int = js.native
          
          def ELEMENT_NODE(): Int = js.native
          
          def ENTITY_NODE(): Int = js.native
          
          def ENTITY_REFERENCE_NODE(): Int = js.native
          
          def NOTATION_NODE(): Int = js.native
          
          def PROCESSING_INSTRUCTION_NODE(): Int = js.native
          
          def TEXT_NODE(): Int = js.native
        }
        
        @js.native
        class NodeFilter () extends StObject {
          
          def acceptNode(n: org.scalajs.dom.raw.Node): Int = js.native
        }
        @js.native
        object NodeFilter extends StObject {
          
          val FILTER_ACCEPT: Int = js.native
          
          val FILTER_REJECT: Int = js.native
          
          val FILTER_SKIP: Int = js.native
          
          val SHOW_ALL: Int = js.native
          
          val SHOW_ATTRIBUTE: Int = js.native
          
          val SHOW_CDATA_SECTION: Int = js.native
          
          val SHOW_COMMENT: Int = js.native
          
          val SHOW_DOCUMENT: Int = js.native
          
          val SHOW_DOCUMENT_FRAGMENT: Int = js.native
          
          val SHOW_DOCUMENT_TYPE: Int = js.native
          
          val SHOW_ELEMENT: Int = js.native
          
          val SHOW_ENTITY: Int = js.native
          
          val SHOW_ENTITY_REFERENCE: Int = js.native
          
          val SHOW_NOTATION: Int = js.native
          
          val SHOW_PROCESSING_INSTRUCTION: Int = js.native
          
          val SHOW_TEXT: Int = js.native
        }
        
        @js.native
        class NodeIterator () extends StObject {
          
          def detach(): Unit = js.native
          
          def filter(): org.scalajs.dom.raw.NodeFilter = js.native
          
          def nextNode(): org.scalajs.dom.raw.Node = js.native
          
          def previousNode(): org.scalajs.dom.raw.Node = js.native
          
          def root(): org.scalajs.dom.raw.Node = js.native
          
          var whatToShow: Int = js.native
        }
        
        @js.native
        class NodeList ()
          extends StObject
             with org.scalajs.dom.raw.DOMList[org.scalajs.dom.raw.Node]
        
        @js.native
        trait NodeListOf[TNode]
          extends StObject
             with org.scalajs.dom.raw.DOMList[TNode]
        
        @js.native
        trait NodeSelector extends StObject {
          
          def querySelector(selectors: String): org.scalajs.dom.raw.Element = js.native
          
          def querySelectorAll(selectors: String): org.scalajs.dom.raw.NodeList = js.native
        }
        
        @js.native
        trait NonDocumentTypeChildNode extends StObject {
          
          def nextElementSibling(): org.scalajs.dom.raw.Element = js.native
          
          def previousElementSibling(): org.scalajs.dom.raw.Element = js.native
        }
        
        @js.native
        trait OfflineAudioCompletionEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          val renderedBuffer: org.scalajs.dom.raw.AudioBuffer = js.native
        }
        
        @js.native
        class OfflineAudioContext protected ()
          extends StObject
             with org.scalajs.dom.raw.AudioContext {
          def this(numOfChannels: Int, length: Int, sampleRate: Int) = this()
          
          val length: Int = js.native
          
          val numOfChannels: Int = js.native
          
          val sampleRate: Int = js.native
          
          def startRendering(): js.Promise[org.scalajs.dom.raw.AudioBuffer] = js.native
        }
        
        @js.native
        trait OscillatorNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          var detune: org.scalajs.dom.raw.AudioParam = js.native
          
          var frequency: org.scalajs.dom.raw.AudioParam = js.native
          
          var onended: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          def setPeriodicWave(wave: org.scalajs.dom.raw.PeriodicWave): Unit = js.native
          
          def start(when: Double): Unit = js.native
          
          def stop(when: Double): Unit = js.native
          
          var `type`: String = js.native
        }
        
        @js.native
        trait PageTransitionEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          def persisted(): Boolean = js.native
        }
        
        @js.native
        trait PageVisibility extends StObject {
          
          def hidden(): Boolean = js.native
          
          def visibilityState(): org.scalajs.dom.raw.VisibilityState | String = js.native
          
          var visibilitychange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
        }
        
        @js.native
        trait PannerNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          var coneInnerAngle: Double = js.native
          
          var coneOuterAngle: Double = js.native
          
          var coneOuterGain: Double = js.native
          
          var distanceModel: String = js.native
          
          var maxDistance: Double = js.native
          
          var panningModel: String = js.native
          
          var refDistance: Double = js.native
          
          var rolloffFactor: Double = js.native
          
          def setOrientation(x: Double, y: Double, z: Double): Unit = js.native
          
          def setPosition(x: Double, y: Double, z: Double): Unit = js.native
          
          def setVelocity(x: Double, y: Double, z: Double): Unit = js.native
        }
        
        @js.native
        trait ParentNode extends StObject {
          
          def childElementCount(): Int = js.native
          
          def children(): HTMLCollection = js.native
          
          def firstElementChild(): org.scalajs.dom.raw.Element = js.native
          
          def lastElementChild(): org.scalajs.dom.raw.Element = js.native
        }
        
        @js.native
        class Performance () extends StObject {
          
          def clearMarks(markName: String): Unit = js.native
          
          def clearMeasures(measureName: String): Unit = js.native
          
          def clearResourceTimings(): Unit = js.native
          
          def getEntries(): js.Dynamic = js.native
          
          def getEntriesByName(name: String, entryType: String): js.Dynamic = js.native
          
          def getEntriesByType(entryType: String): js.Dynamic = js.native
          
          def getMarks(markName: String): js.Dynamic = js.native
          
          def getMeasures(measureName: String): js.Dynamic = js.native
          
          def mark(markName: String): Unit = js.native
          
          def measure(measureName: String, startMarkName: String, endMarkName: String): Unit = js.native
          
          def navigation(): org.scalajs.dom.raw.PerformanceNavigation = js.native
          
          def now(): Double = js.native
          
          def setResourceTimingBufferSize(maxSize: Int): Unit = js.native
          
          def timing(): org.scalajs.dom.raw.PerformanceTiming = js.native
          
          def toJSON(): js.Dynamic = js.native
        }
        
        @js.native
        class PerformanceEntry () extends StObject {
          
          def duration(): Int = js.native
          
          def entryType(): String = js.native
          
          def name(): String = js.native
          
          def startTime(): Double = js.native
        }
        
        @js.native
        class PerformanceMark ()
          extends StObject
             with org.scalajs.dom.raw.PerformanceEntry
        
        @js.native
        class PerformanceMeasure ()
          extends StObject
             with org.scalajs.dom.raw.PerformanceEntry
        
        @js.native
        class PerformanceNavigation () extends StObject {
          
          def redirectCount(): Int = js.native
          
          def toJSON(): js.Dynamic = js.native
          
          def `type`(): Int = js.native
        }
        @js.native
        object PerformanceNavigation extends StObject {
          
          val TYPE_BACK_FORWARD: Int = js.native
          
          val TYPE_NAVIGATE: Int = js.native
          
          val TYPE_RELOAD: Int = js.native
          
          val TYPE_RESERVED: Int = js.native
        }
        
        @js.native
        class PerformanceResourceTiming ()
          extends StObject
             with org.scalajs.dom.raw.PerformanceEntry {
          
          def connectEnd(): Int = js.native
          
          def connectStart(): Int = js.native
          
          def domainLookupEnd(): Int = js.native
          
          def domainLookupStart(): Int = js.native
          
          def fetchStart(): Int = js.native
          
          def initiatorType(): String = js.native
          
          def redirectEnd(): Int = js.native
          
          def redirectStart(): Int = js.native
          
          def requestStart(): Int = js.native
          
          var responseEnd: Int = js.native
          
          def responseStart(): Int = js.native
        }
        
        @js.native
        class PerformanceTiming () extends StObject {
          
          def connectEnd(): Double = js.native
          
          def connectStart(): Double = js.native
          
          def domComplete(): Double = js.native
          
          def domContentLoadedEventEnd(): Double = js.native
          
          def domContentLoadedEventStart(): Double = js.native
          
          def domInteractive(): Double = js.native
          
          def domLoading(): Double = js.native
          
          def domainLookupEnd(): Double = js.native
          
          def domainLookupStart(): Double = js.native
          
          def fetchStart(): Double = js.native
          
          def loadEventEnd(): Double = js.native
          
          def loadEventStart(): Double = js.native
          
          def navigationStart(): Double = js.native
          
          def redirectEnd(): Double = js.native
          
          def redirectStart(): Double = js.native
          
          def requestStart(): Double = js.native
          
          def responseEnd(): Double = js.native
          
          def responseStart(): Double = js.native
          
          def toJSON(): js.Dynamic = js.native
          
          def unloadEventEnd(): Double = js.native
          
          def unloadEventStart(): Double = js.native
        }
        
        @js.native
        trait PeriodicWave extends StObject
        
        @js.native
        class PointerEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.MouseEvent {
          def this(typeArg: String) = this()
          def this(typeArg: String, pointerEventInit: js.UndefOr[org.scalajs.dom.raw.PointerEventInit]) = this()
          
          def height(): Double = js.native
          
          def isPrimary(): Boolean = js.native
          
          val pointerEventInit: js.UndefOr[org.scalajs.dom.raw.PointerEventInit] = js.native
          
          def pointerId(): Double = js.native
          
          def pointerType(): String = js.native
          
          def pressure(): Double = js.native
          
          def tangentialPressure(): Double = js.native
          
          def tiltX(): Double = js.native
          
          def tiltY(): Double = js.native
          
          def twist(): Double = js.native
          
          val typeArg: String = js.native
          
          def width(): Double = js.native
        }
        
        @js.native
        trait PointerEventInit
          extends StObject
             with MouseEventInit {
          
          var height: js.UndefOr[Double] = js.native
          
          var isPrimary: js.UndefOr[Boolean] = js.native
          
          var pointerId: js.UndefOr[Double] = js.native
          
          var pointerType: js.UndefOr[String] = js.native
          
          var pressure: js.UndefOr[Double] = js.native
          
          var tangentialPressure: js.UndefOr[Double] = js.native
          
          var tiltX: js.UndefOr[Double] = js.native
          
          var tiltY: js.UndefOr[Double] = js.native
          
          var twist: js.UndefOr[Double] = js.native
          
          var width: js.UndefOr[Double] = js.native
        }
        
        @js.native
        trait PopStateEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          def state(): js.Any = js.native
        }
        
        @js.native
        trait Position extends StObject {
          
          def coords(): org.scalajs.dom.raw.Coordinates = js.native
          
          def timestamp(): Double = js.native
        }
        
        @js.native
        trait PositionError extends StObject {
          
          def code(): Int = js.native
          
          def message(): String = js.native
        }
        @js.native
        object PositionError extends StObject {
          
          val PERMISSION_DENIED: Int = js.native
          
          val POSITION_UNAVAILABLE: Int = js.native
          
          val TIMEOUT: Int = js.native
        }
        
        @js.native
        class PositionOptions () extends StObject {
          
          var enableHighAccuracy: Boolean = js.native
          
          var maximumAge: Int = js.native
          
          var timeout: Int = js.native
        }
        
        @js.native
        abstract class ProcessingInstruction ()
          extends StObject
             with org.scalajs.dom.raw.Node {
          
          def data(): String = js.native
          
          def target(): String = js.native
        }
        
        @js.native
        trait ProgressEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          def lengthComputable(): Boolean = js.native
          
          def loaded(): Double = js.native
          
          def total(): Double = js.native
        }
        
        @js.native
        class Range () extends StObject {
          
          def cloneContents(): org.scalajs.dom.raw.DocumentFragment = js.native
          
          def cloneRange(): org.scalajs.dom.raw.Range = js.native
          
          def collapse(toStart: Boolean): Unit = js.native
          
          def collapsed(): Boolean = js.native
          
          def commonAncestorContainer(): org.scalajs.dom.raw.Node = js.native
          
          def compareBoundaryPoints(how: Int, sourceRange: org.scalajs.dom.raw.Range): Int = js.native
          
          def createContextualFragment(fragment: String): org.scalajs.dom.raw.DocumentFragment = js.native
          
          def deleteContents(): Unit = js.native
          
          def detach(): Unit = js.native
          
          def endContainer(): org.scalajs.dom.raw.Node = js.native
          
          def endOffset(): Int = js.native
          
          def extractContents(): org.scalajs.dom.raw.DocumentFragment = js.native
          
          def getBoundingClientRect(): org.scalajs.dom.raw.ClientRect = js.native
          
          def getClientRects(): org.scalajs.dom.raw.ClientRectList = js.native
          
          def insertNode(newNode: org.scalajs.dom.raw.Node): Unit = js.native
          
          def selectNode(refNode: org.scalajs.dom.raw.Node): Unit = js.native
          
          def selectNodeContents(refNode: org.scalajs.dom.raw.Node): Unit = js.native
          
          def setEnd(refNode: org.scalajs.dom.raw.Node, offset: Int): Unit = js.native
          
          def setEndAfter(refNode: org.scalajs.dom.raw.Node): Unit = js.native
          
          def setEndBefore(refNode: org.scalajs.dom.raw.Node): Unit = js.native
          
          def setStart(refNode: org.scalajs.dom.raw.Node, offset: Int): Unit = js.native
          
          def setStartAfter(refNode: org.scalajs.dom.raw.Node): Unit = js.native
          
          def setStartBefore(refNode: org.scalajs.dom.raw.Node): Unit = js.native
          
          def startContainer(): org.scalajs.dom.raw.Node = js.native
          
          def startOffset(): Int = js.native
          
          def surroundContents(newParent: org.scalajs.dom.raw.Node): Unit = js.native
        }
        @js.native
        object Range extends StObject {
          
          val END_TO_END: Int = js.native
          
          val END_TO_START: Int = js.native
          
          val START_TO_END: Int = js.native
          
          val START_TO_START: Int = js.native
        }
        
        @js.native
        abstract class SVGAElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired
             with SVGURIReference {
          
          def target(): SVGAnimatedString = js.native
        }
        
        @js.native
        class SVGAngle () extends StObject {
          
          def convertToSpecifiedUnits(unitType: Int): Unit = js.native
          
          def newValueSpecifiedUnits(unitType: Int, valueInSpecifiedUnits: Double): Unit = js.native
          
          def unitType(): Int = js.native
          
          var value: Double = js.native
          
          var valueAsString: String = js.native
          
          var valueInSpecifiedUnits: Double = js.native
        }
        @js.native
        object SVGAngle extends StObject {
          
          val SVG_ANGLETYPE_DEG: Int = js.native
          
          val SVG_ANGLETYPE_GRAD: Int = js.native
          
          val SVG_ANGLETYPE_RAD: Int = js.native
          
          val SVG_ANGLETYPE_UNKNOWN: Int = js.native
          
          val SVG_ANGLETYPE_UNSPECIFIED: Int = js.native
        }
        
        @js.native
        class SVGAnimatedAngle () extends StObject {
          
          def animVal(): SVGAngle = js.native
          
          var baseVal: SVGAngle = js.native
        }
        
        @js.native
        class SVGAnimatedBoolean () extends StObject {
          
          def animVal(): Boolean = js.native
          
          var baseVal: Boolean = js.native
        }
        
        @js.native
        class SVGAnimatedEnumeration () extends StObject {
          
          def animVal(): Int = js.native
          
          var baseVal: Int = js.native
        }
        
        @js.native
        class SVGAnimatedInteger () extends StObject {
          
          def animVal(): Int = js.native
          
          var baseVal: Int = js.native
        }
        
        @js.native
        class SVGAnimatedLength () extends StObject {
          
          def animVal(): SVGLength = js.native
          
          var baseVal: SVGLength = js.native
        }
        
        @js.native
        class SVGAnimatedLengthList () extends StObject {
          
          def animVal(): SVGLengthList = js.native
          
          var baseVal: SVGLengthList = js.native
        }
        
        @js.native
        class SVGAnimatedNumber () extends StObject {
          
          def animVal(): Double = js.native
          
          var baseVal: Double = js.native
        }
        
        @js.native
        class SVGAnimatedNumberList () extends StObject {
          
          def animVal(): SVGNumberList = js.native
          
          def baseVal(): SVGNumberList = js.native
        }
        
        @js.native
        trait SVGAnimatedPathData extends StObject {
          
          var pathSegList: SVGPathSegList = js.native
        }
        
        @js.native
        trait SVGAnimatedPoints extends StObject {
          
          def animatedPoints(): SVGPointList = js.native
          
          var points: SVGPointList = js.native
        }
        
        @js.native
        class SVGAnimatedPreserveAspectRatio () extends StObject {
          
          def animVal(): SVGPreserveAspectRatio = js.native
          
          var baseVal: SVGPreserveAspectRatio = js.native
        }
        
        @js.native
        class SVGAnimatedRect () extends StObject {
          
          def animVal(): SVGRect = js.native
          
          def baseVal(): SVGRect = js.native
        }
        
        @js.native
        class SVGAnimatedString () extends StObject {
          
          def animVal(): String = js.native
          
          var baseVal: String = js.native
        }
        
        @js.native
        class SVGAnimatedTransformList () extends StObject {
          
          def animVal(): SVGTransformList = js.native
          
          var baseVal: SVGTransformList = js.native
        }
        
        @js.native
        abstract class SVGCircleElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired {
          
          def cx(): SVGAnimatedLength = js.native
          
          def cy(): SVGAnimatedLength = js.native
          
          def r(): SVGAnimatedLength = js.native
        }
        
        @js.native
        abstract class SVGClipPathElement ()
          extends StObject
             with SVGElement
             with SVGUnitTypes
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired {
          
          def clipPathUnits(): SVGAnimatedEnumeration = js.native
        }
        
        @js.native
        abstract class SVGComponentTransferFunctionElement ()
          extends StObject
             with SVGElement {
          
          def amplitude(): SVGAnimatedNumber = js.native
          
          def exponent(): SVGAnimatedNumber = js.native
          
          def intercept(): SVGAnimatedNumber = js.native
          
          def offset(): SVGAnimatedNumber = js.native
          
          def slope(): SVGAnimatedNumber = js.native
          
          def tableValues(): SVGAnimatedNumberList = js.native
          
          def `type`(): SVGAnimatedEnumeration = js.native
        }
        @js.native
        object SVGComponentTransferFunctionElement extends StObject {
          
          val SVG_FECOMPONENTTRANSFER_TYPE_DISCRETE: Int = js.native
          
          val SVG_FECOMPONENTTRANSFER_TYPE_GAMMA: Int = js.native
          
          val SVG_FECOMPONENTTRANSFER_TYPE_IDENTITY: Int = js.native
          
          val SVG_FECOMPONENTTRANSFER_TYPE_LINEAR: Int = js.native
          
          val SVG_FECOMPONENTTRANSFER_TYPE_TABLE: Int = js.native
          
          val SVG_FECOMPONENTTRANSFER_TYPE_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGDefsElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired
        
        @js.native
        abstract class SVGDescElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGLangSpace
        
        @js.native
        abstract class SVGElement ()
          extends StObject
             with org.scalajs.dom.raw.Element {
          
          var onclick: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var ondblclick: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onfocusin: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var onfocusout: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var onload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onmousedown: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmousemove: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseout: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseover: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseup: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          def ownerSVGElement(): SVGSVGElement = js.native
          
          def viewportElement(): SVGElement = js.native
          
          var xmlbase: String = js.native
        }
        
        @js.native
        class SVGElementInstance ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def childNodes(): SVGElementInstanceList = js.native
          
          def correspondingElement(): SVGElement = js.native
          
          def correspondingUseElement(): SVGUseElement = js.native
          
          def firstChild(): SVGElementInstance = js.native
          
          def lastChild(): SVGElementInstance = js.native
          
          def nextSibling(): SVGElementInstance = js.native
          
          def parentNode(): SVGElementInstance = js.native
          
          def previousSibling(): SVGElementInstance = js.native
        }
        
        @js.native
        class SVGElementInstanceList () extends StObject {
          
          def item(index: Int): SVGElementInstance = js.native
          
          def length(): Int = js.native
        }
        
        @js.native
        abstract class SVGEllipseElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired {
          
          def cx(): SVGAnimatedLength = js.native
          
          def cy(): SVGAnimatedLength = js.native
          
          def rx(): SVGAnimatedLength = js.native
          
          def ry(): SVGAnimatedLength = js.native
        }
        
        @js.native
        trait SVGException extends StObject {
          
          def code(): Int = js.native
          
          def message(): String = js.native
          
          def name(): String = js.native
        }
        @js.native
        object SVGException extends StObject {
          
          val SVG_INVALID_VALUE_ERR: Int = js.native
          
          val SVG_MATRIX_NOT_INVERTABLE: Int = js.native
          
          val SVG_WRONG_TYPE_ERR: Int = js.native
        }
        
        @js.native
        trait SVGExternalResourcesRequired extends StObject {
          
          var externalResourcesRequired: SVGAnimatedBoolean = js.native
        }
        
        @js.native
        abstract class SVGFEBlendElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def in1(): SVGAnimatedString = js.native
          
          def in2(): SVGAnimatedString = js.native
          
          def mode(): SVGAnimatedEnumeration = js.native
        }
        @js.native
        object SVGFEBlendElement extends StObject {
          
          val SVG_FEBLEND_MODE_DARKEN: Int = js.native
          
          val SVG_FEBLEND_MODE_LIGHTEN: Int = js.native
          
          val SVG_FEBLEND_MODE_MULTIPLY: Int = js.native
          
          val SVG_FEBLEND_MODE_NORMAL: Int = js.native
          
          val SVG_FEBLEND_MODE_SCREEN: Int = js.native
          
          val SVG_FEBLEND_MODE_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGFEColorMatrixElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def in1(): SVGAnimatedString = js.native
          
          def `type`(): SVGAnimatedEnumeration = js.native
          
          def values(): SVGAnimatedNumberList = js.native
        }
        @js.native
        object SVGFEColorMatrixElement extends StObject {
          
          val SVG_FECOLORMATRIX_TYPE_HUEROTATE: Int = js.native
          
          val SVG_FECOLORMATRIX_TYPE_LUMINANCETOALPHA: Int = js.native
          
          val SVG_FECOLORMATRIX_TYPE_MATRIX: Int = js.native
          
          val SVG_FECOLORMATRIX_TYPE_SATURATE: Int = js.native
          
          val SVG_FECOLORMATRIX_TYPE_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGFEComponentTransferElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def in1(): SVGAnimatedString = js.native
        }
        
        @js.native
        abstract class SVGFECompositeElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def in1(): SVGAnimatedString = js.native
          
          def in2(): SVGAnimatedString = js.native
          
          def k1(): SVGAnimatedNumber = js.native
          
          def k2(): SVGAnimatedNumber = js.native
          
          def k3(): SVGAnimatedNumber = js.native
          
          def k4(): SVGAnimatedNumber = js.native
          
          def operator(): SVGAnimatedEnumeration = js.native
        }
        @js.native
        object SVGFECompositeElement extends StObject {
          
          val SVG_FECOMPOSITE_OPERATOR_ARITHMETIC: Int = js.native
          
          val SVG_FECOMPOSITE_OPERATOR_ATOP: Int = js.native
          
          val SVG_FECOMPOSITE_OPERATOR_IN: Int = js.native
          
          val SVG_FECOMPOSITE_OPERATOR_OUT: Int = js.native
          
          val SVG_FECOMPOSITE_OPERATOR_OVER: Int = js.native
          
          val SVG_FECOMPOSITE_OPERATOR_UNKNOWN: Int = js.native
          
          val SVG_FECOMPOSITE_OPERATOR_XOR: Int = js.native
        }
        
        @js.native
        abstract class SVGFEConvolveMatrixElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def bias(): SVGAnimatedNumber = js.native
          
          def divisor(): SVGAnimatedNumber = js.native
          
          def edgeMode(): SVGAnimatedEnumeration = js.native
          
          def in1(): SVGAnimatedString = js.native
          
          def kernelMatrix(): SVGAnimatedNumberList = js.native
          
          def kernelUnitLengthX(): SVGAnimatedNumber = js.native
          
          def kernelUnitLengthY(): SVGAnimatedNumber = js.native
          
          def orderX(): SVGAnimatedInteger = js.native
          
          def orderY(): SVGAnimatedInteger = js.native
          
          def preserveAlpha(): SVGAnimatedBoolean = js.native
          
          def targetX(): SVGAnimatedInteger = js.native
          
          def targetY(): SVGAnimatedInteger = js.native
        }
        @js.native
        object SVGFEConvolveMatrixElement extends StObject {
          
          val SVG_EDGEMODE_DUPLICATE: Int = js.native
          
          val SVG_EDGEMODE_NONE: Int = js.native
          
          val SVG_EDGEMODE_UNKNOWN: Int = js.native
          
          val SVG_EDGEMODE_WRAP: Int = js.native
        }
        
        @js.native
        abstract class SVGFEDiffuseLightingElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def diffuseConstant(): SVGAnimatedNumber = js.native
          
          def in1(): SVGAnimatedString = js.native
          
          def kernelUnitLengthX(): SVGAnimatedNumber = js.native
          
          def kernelUnitLengthY(): SVGAnimatedNumber = js.native
          
          def surfaceScale(): SVGAnimatedNumber = js.native
        }
        
        @js.native
        abstract class SVGFEDisplacementMapElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def in1(): SVGAnimatedString = js.native
          
          def in2(): SVGAnimatedString = js.native
          
          def scale(): SVGAnimatedNumber = js.native
          
          def xChannelSelector(): SVGAnimatedEnumeration = js.native
          
          def yChannelSelector(): SVGAnimatedEnumeration = js.native
        }
        @js.native
        object SVGFEDisplacementMapElement extends StObject {
          
          val SVG_CHANNEL_A: Int = js.native
          
          val SVG_CHANNEL_B: Int = js.native
          
          val SVG_CHANNEL_G: Int = js.native
          
          val SVG_CHANNEL_R: Int = js.native
          
          val SVG_CHANNEL_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGFEDistantLightElement ()
          extends StObject
             with SVGElement {
          
          def azimuth(): SVGAnimatedNumber = js.native
          
          def elevation(): SVGAnimatedNumber = js.native
        }
        
        @js.native
        abstract class SVGFEFloodElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes
        
        @js.native
        abstract class SVGFEFuncAElement ()
          extends StObject
             with SVGComponentTransferFunctionElement
        
        @js.native
        abstract class SVGFEFuncBElement ()
          extends StObject
             with SVGComponentTransferFunctionElement
        
        @js.native
        abstract class SVGFEFuncGElement ()
          extends StObject
             with SVGComponentTransferFunctionElement
        
        @js.native
        abstract class SVGFEFuncRElement ()
          extends StObject
             with SVGComponentTransferFunctionElement
        
        @js.native
        abstract class SVGFEGaussianBlurElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def in1(): SVGAnimatedString = js.native
          
          def setStdDeviation(stdDeviationX: Double, stdDeviationY: Double): Unit = js.native
          
          def stdDeviationX(): SVGAnimatedNumber = js.native
          
          def stdDeviationY(): SVGAnimatedNumber = js.native
        }
        
        @js.native
        abstract class SVGFEImageElement ()
          extends StObject
             with SVGElement
             with SVGLangSpace
             with SVGFilterPrimitiveStandardAttributes
             with SVGURIReference
             with SVGExternalResourcesRequired {
          
          def preserveAspectRatio(): SVGAnimatedPreserveAspectRatio = js.native
        }
        
        @js.native
        abstract class SVGFEMergeElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes
        
        @js.native
        abstract class SVGFEMergeNodeElement ()
          extends StObject
             with SVGElement {
          
          def in1(): SVGAnimatedString = js.native
        }
        
        @js.native
        abstract class SVGFEMorphologyElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def in1(): SVGAnimatedString = js.native
          
          def operator(): SVGAnimatedEnumeration = js.native
          
          def radiusX(): SVGAnimatedNumber = js.native
          
          def radiusY(): SVGAnimatedNumber = js.native
        }
        @js.native
        object SVGFEMorphologyElement extends StObject {
          
          val SVG_MORPHOLOGY_OPERATOR_DILATE: Int = js.native
          
          val SVG_MORPHOLOGY_OPERATOR_ERODE: Int = js.native
          
          val SVG_MORPHOLOGY_OPERATOR_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGFEOffsetElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def dx(): SVGAnimatedNumber = js.native
          
          def dy(): SVGAnimatedNumber = js.native
          
          def in1(): SVGAnimatedString = js.native
        }
        
        @js.native
        abstract class SVGFEPointLightElement ()
          extends StObject
             with SVGElement {
          
          def x(): SVGAnimatedNumber = js.native
          
          def y(): SVGAnimatedNumber = js.native
          
          def z(): SVGAnimatedNumber = js.native
        }
        
        @js.native
        abstract class SVGFESpecularLightingElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def in1(): SVGAnimatedString = js.native
          
          def kernelUnitLengthX(): SVGAnimatedNumber = js.native
          
          def kernelUnitLengthY(): SVGAnimatedNumber = js.native
          
          def specularConstant(): SVGAnimatedNumber = js.native
          
          def specularExponent(): SVGAnimatedNumber = js.native
          
          def surfaceScale(): SVGAnimatedNumber = js.native
        }
        
        @js.native
        abstract class SVGFESpotLightElement ()
          extends StObject
             with SVGElement {
          
          def limitingConeAngle(): SVGAnimatedNumber = js.native
          
          def pointsAtX(): SVGAnimatedNumber = js.native
          
          def pointsAtY(): SVGAnimatedNumber = js.native
          
          def pointsAtZ(): SVGAnimatedNumber = js.native
          
          def specularExponent(): SVGAnimatedNumber = js.native
          
          def x(): SVGAnimatedNumber = js.native
          
          def y(): SVGAnimatedNumber = js.native
          
          def z(): SVGAnimatedNumber = js.native
        }
        
        @js.native
        abstract class SVGFETileElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def in1(): SVGAnimatedString = js.native
        }
        
        @js.native
        abstract class SVGFETurbulenceElement ()
          extends StObject
             with SVGElement
             with SVGFilterPrimitiveStandardAttributes {
          
          def baseFrequencyX(): SVGAnimatedNumber = js.native
          
          def baseFrequencyY(): SVGAnimatedNumber = js.native
          
          def numOctaves(): SVGAnimatedInteger = js.native
          
          def seed(): SVGAnimatedNumber = js.native
          
          def stitchTiles(): SVGAnimatedEnumeration = js.native
          
          def `type`(): SVGAnimatedEnumeration = js.native
        }
        @js.native
        object SVGFETurbulenceElement extends StObject {
          
          val SVG_STITCHTYPE_NOSTITCH: Int = js.native
          
          val SVG_STITCHTYPE_STITCH: Int = js.native
          
          val SVG_STITCHTYPE_UNKNOWN: Int = js.native
          
          val SVG_TURBULENCE_TYPE_FRACTALNOISE: Int = js.native
          
          val SVG_TURBULENCE_TYPE_TURBULENCE: Int = js.native
          
          val SVG_TURBULENCE_TYPE_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGFilterElement ()
          extends StObject
             with SVGElement
             with SVGUnitTypes
             with SVGStylable
             with SVGLangSpace
             with SVGURIReference
             with SVGExternalResourcesRequired {
          
          def filterResX(): SVGAnimatedInteger = js.native
          
          def filterResY(): SVGAnimatedInteger = js.native
          
          def filterUnits(): SVGAnimatedEnumeration = js.native
          
          def height(): SVGAnimatedLength = js.native
          
          def primitiveUnits(): SVGAnimatedEnumeration = js.native
          
          def setFilterRes(filterResX: Double, filterResY: Double): Unit = js.native
          
          def width(): SVGAnimatedLength = js.native
          
          def x(): SVGAnimatedLength = js.native
          
          def y(): SVGAnimatedLength = js.native
        }
        
        @js.native
        trait SVGFilterPrimitiveStandardAttributes
          extends StObject
             with SVGStylable {
          
          def height(): SVGAnimatedLength = js.native
          
          def result(): SVGAnimatedString = js.native
          
          def width(): SVGAnimatedLength = js.native
          
          def x(): SVGAnimatedLength = js.native
          
          def y(): SVGAnimatedLength = js.native
        }
        
        @js.native
        trait SVGFitToViewBox extends StObject {
          
          var preserveAspectRatio: SVGAnimatedPreserveAspectRatio = js.native
          
          var viewBox: SVGAnimatedRect = js.native
        }
        
        @js.native
        abstract class SVGGElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired
        
        @js.native
        abstract class SVGGradientElement ()
          extends StObject
             with SVGElement
             with SVGUnitTypes
             with SVGStylable
             with SVGExternalResourcesRequired
             with SVGURIReference {
          
          def gradientTransform(): SVGAnimatedTransformList = js.native
          
          def gradientUnits(): SVGAnimatedEnumeration = js.native
          
          def spreadMethod(): SVGAnimatedEnumeration = js.native
        }
        @js.native
        object SVGGradientElement extends StObject {
          
          val SVG_SPREADMETHOD_PAD: Int = js.native
          
          val SVG_SPREADMETHOD_REFLECT: Int = js.native
          
          val SVG_SPREADMETHOD_REPEAT: Int = js.native
          
          val SVG_SPREADMETHOD_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGImageElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired
             with SVGURIReference {
          
          def height(): SVGAnimatedLength = js.native
          
          def preserveAspectRatio(): SVGAnimatedPreserveAspectRatio = js.native
          
          def width(): SVGAnimatedLength = js.native
          
          def x(): SVGAnimatedLength = js.native
          
          def y(): SVGAnimatedLength = js.native
        }
        
        @js.native
        trait SVGLangSpace extends StObject {
          
          var xmllang: String = js.native
          
          var xmlspace: String = js.native
        }
        
        @js.native
        class SVGLength () extends StObject {
          
          def convertToSpecifiedUnits(unitType: Int): Unit = js.native
          
          def newValueSpecifiedUnits(unitType: Int, valueInSpecifiedUnits: Double): Unit = js.native
          
          def unitType(): Int = js.native
          
          var value: Double = js.native
          
          var valueAsString: String = js.native
          
          var valueInSpecifiedUnits: Double = js.native
        }
        @js.native
        object SVGLength extends StObject {
          
          val SVG_LENGTHTYPE_CM: Int = js.native
          
          val SVG_LENGTHTYPE_EMS: Int = js.native
          
          val SVG_LENGTHTYPE_EXS: Int = js.native
          
          val SVG_LENGTHTYPE_IN: Int = js.native
          
          val SVG_LENGTHTYPE_MM: Int = js.native
          
          val SVG_LENGTHTYPE_NUMBER: Int = js.native
          
          val SVG_LENGTHTYPE_PC: Int = js.native
          
          val SVG_LENGTHTYPE_PERCENTAGE: Int = js.native
          
          val SVG_LENGTHTYPE_PT: Int = js.native
          
          val SVG_LENGTHTYPE_PX: Int = js.native
          
          val SVG_LENGTHTYPE_UNKNOWN: Int = js.native
        }
        
        @js.native
        class SVGLengthList () extends StObject {
          
          def appendItem(newItem: SVGLength): SVGLength = js.native
          
          def clear(): Unit = js.native
          
          def getItem(index: Int): SVGLength = js.native
          
          def initialize(newItem: SVGLength): SVGLength = js.native
          
          def insertItemBefore(newItem: SVGLength, index: Int): SVGLength = js.native
          
          def numberOfItems(): Int = js.native
          
          def removeItem(index: Int): SVGLength = js.native
          
          def replaceItem(newItem: SVGLength, index: Int): SVGLength = js.native
        }
        
        @js.native
        abstract class SVGLineElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired {
          
          def x1(): SVGAnimatedLength = js.native
          
          def x2(): SVGAnimatedLength = js.native
          
          def y1(): SVGAnimatedLength = js.native
          
          def y2(): SVGAnimatedLength = js.native
        }
        
        @js.native
        class SVGLinearGradientElement ()
          extends StObject
             with SVGGradientElement {
          
          def x1(): SVGAnimatedLength = js.native
          
          def x2(): SVGAnimatedLength = js.native
          
          def y1(): SVGAnimatedLength = js.native
          
          def y2(): SVGAnimatedLength = js.native
        }
        
        @js.native
        trait SVGLocatable extends StObject {
          
          var farthestViewportElement: SVGElement = js.native
          
          def getBBox(): SVGRect = js.native
          
          def getCTM(): SVGMatrix = js.native
          
          def getScreenCTM(): SVGMatrix = js.native
          
          def getTransformToElement(element: SVGElement): SVGMatrix = js.native
          
          var nearestViewportElement: SVGElement = js.native
        }
        
        @js.native
        abstract class SVGMarkerElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGLangSpace
             with SVGFitToViewBox
             with SVGExternalResourcesRequired {
          
          def markerHeight(): SVGAnimatedLength = js.native
          
          var markerUnits: SVGAnimatedEnumeration = js.native
          
          def markerWidth(): SVGAnimatedLength = js.native
          
          def orientAngle(): SVGAnimatedAngle = js.native
          
          var orientType: SVGAnimatedEnumeration = js.native
          
          def refX(): SVGAnimatedLength = js.native
          
          def refY(): SVGAnimatedLength = js.native
          
          def setOrientToAngle(angle: SVGAngle): Unit = js.native
          
          def setOrientToAuto(): Unit = js.native
        }
        @js.native
        object SVGMarkerElement extends StObject {
          
          val SVG_MARKERUNITS_STROKEWIDTH: Int = js.native
          
          val SVG_MARKERUNITS_UNKNOWN: Int = js.native
          
          val SVG_MARKERUNITS_USERSPACEONUSE: Int = js.native
          
          val SVG_MARKER_ORIENT_ANGLE: Int = js.native
          
          val SVG_MARKER_ORIENT_AUTO: Int = js.native
          
          val SVG_MARKER_ORIENT_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGMaskElement ()
          extends StObject
             with SVGElement
             with SVGUnitTypes
             with SVGStylable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired {
          
          def height(): SVGAnimatedLength = js.native
          
          def maskContentUnits(): SVGAnimatedEnumeration = js.native
          
          def maskUnits(): SVGAnimatedEnumeration = js.native
          
          def width(): SVGAnimatedLength = js.native
          
          def x(): SVGAnimatedLength = js.native
          
          def y(): SVGAnimatedLength = js.native
        }
        
        @js.native
        class SVGMatrix () extends StObject {
          
          var a: Double = js.native
          
          var b: Double = js.native
          
          var c: Double = js.native
          
          var d: Double = js.native
          
          var e: Double = js.native
          
          var f: Double = js.native
          
          def flipX(): SVGMatrix = js.native
          
          def flipY(): SVGMatrix = js.native
          
          def inverse(): SVGMatrix = js.native
          
          def multiply(secondMatrix: SVGMatrix): SVGMatrix = js.native
          
          def rotate(angle: Double): SVGMatrix = js.native
          
          def rotateFromVector(x: Double, y: Double): SVGMatrix = js.native
          
          def scale(scaleFactor: Double): SVGMatrix = js.native
          
          def scaleNonUniform(scaleFactorX: Double, scaleFactorY: Double): SVGMatrix = js.native
          
          def skewX(angle: Double): SVGMatrix = js.native
          
          def skewY(angle: Double): SVGMatrix = js.native
          
          def translate(x: Double, y: Double): SVGMatrix = js.native
        }
        
        @js.native
        abstract class SVGMetadataElement ()
          extends StObject
             with SVGElement
        
        @js.native
        class SVGNumber () extends StObject {
          
          var value: Double = js.native
        }
        
        @js.native
        class SVGNumberList () extends StObject {
          
          def appendItem(newItem: SVGNumber): SVGNumber = js.native
          
          def clear(): Unit = js.native
          
          def getItem(index: Int): SVGNumber = js.native
          
          def initialize(newItem: SVGNumber): SVGNumber = js.native
          
          def insertItemBefore(newItem: SVGNumber, index: Int): SVGNumber = js.native
          
          def numberOfItems(): Int = js.native
          
          def removeItem(index: Int): SVGNumber = js.native
          
          def replaceItem(newItem: SVGNumber, index: Int): SVGNumber = js.native
        }
        
        @js.native
        abstract class SVGPathElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGAnimatedPathData
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired {
          
          def createSVGPathSegArcAbs(
            x: Double,
            y: Double,
            r1: Double,
            r2: Double,
            angle: Double,
            largeArcFlag: Boolean,
            sweepFlag: Boolean
          ): SVGPathSegArcAbs = js.native
          
          def createSVGPathSegArcRel(
            x: Double,
            y: Double,
            r1: Double,
            r2: Double,
            angle: Double,
            largeArcFlag: Boolean,
            sweepFlag: Boolean
          ): SVGPathSegArcRel = js.native
          
          def createSVGPathSegClosePath(): SVGPathSegClosePath = js.native
          
          def createSVGPathSegCurvetoCubicAbs(x: Double, y: Double, x1: Double, y1: Double, x2: Double, y2: Double): SVGPathSegCurvetoCubicAbs = js.native
          
          def createSVGPathSegCurvetoCubicRel(x: Double, y: Double, x1: Double, y1: Double, x2: Double, y2: Double): SVGPathSegCurvetoCubicRel = js.native
          
          def createSVGPathSegCurvetoCubicSmoothAbs(x: Double, y: Double, x2: Double, y2: Double): SVGPathSegCurvetoCubicSmoothAbs = js.native
          
          def createSVGPathSegCurvetoCubicSmoothRel(x: Double, y: Double, x2: Double, y2: Double): SVGPathSegCurvetoCubicSmoothRel = js.native
          
          def createSVGPathSegCurvetoQuadraticAbs(x: Double, y: Double, x1: Double, y1: Double): SVGPathSegCurvetoQuadraticAbs = js.native
          
          def createSVGPathSegCurvetoQuadraticRel(x: Double, y: Double, x1: Double, y1: Double): SVGPathSegCurvetoQuadraticRel = js.native
          
          def createSVGPathSegCurvetoQuadraticSmoothAbs(x: Double, y: Double): SVGPathSegCurvetoQuadraticSmoothAbs = js.native
          
          def createSVGPathSegCurvetoQuadraticSmoothRel(x: Double, y: Double): SVGPathSegCurvetoQuadraticSmoothRel = js.native
          
          def createSVGPathSegLinetoAbs(x: Double, y: Double): SVGPathSegLinetoAbs = js.native
          
          def createSVGPathSegLinetoHorizontalAbs(x: Double): SVGPathSegLinetoHorizontalAbs = js.native
          
          def createSVGPathSegLinetoHorizontalRel(x: Double): SVGPathSegLinetoHorizontalRel = js.native
          
          def createSVGPathSegLinetoRel(x: Double, y: Double): SVGPathSegLinetoRel = js.native
          
          def createSVGPathSegLinetoVerticalAbs(y: Double): SVGPathSegLinetoVerticalAbs = js.native
          
          def createSVGPathSegLinetoVerticalRel(y: Double): SVGPathSegLinetoVerticalRel = js.native
          
          def createSVGPathSegMovetoAbs(x: Double, y: Double): SVGPathSegMovetoAbs = js.native
          
          def createSVGPathSegMovetoRel(x: Double, y: Double): SVGPathSegMovetoRel = js.native
          
          def getPathSegAtLength(distance: Double): Int = js.native
          
          def getPointAtLength(distance: Double): SVGPoint = js.native
          
          def getTotalLength(): Double = js.native
        }
        
        @js.native
        class SVGPathSeg () extends StObject {
          
          def pathSegType(): Int = js.native
          
          def pathSegTypeAsLetter(): String = js.native
        }
        @js.native
        object SVGPathSeg extends StObject {
          
          val PATHSEG_ARC_ABS: Int = js.native
          
          val PATHSEG_ARC_REL: Int = js.native
          
          val PATHSEG_CLOSEPATH: Int = js.native
          
          val PATHSEG_CURVETO_CUBIC_ABS: Int = js.native
          
          val PATHSEG_CURVETO_CUBIC_REL: Int = js.native
          
          val PATHSEG_CURVETO_CUBIC_SMOOTH_ABS: Int = js.native
          
          val PATHSEG_CURVETO_CUBIC_SMOOTH_REL: Int = js.native
          
          val PATHSEG_CURVETO_QUADRATIC_ABS: Int = js.native
          
          val PATHSEG_CURVETO_QUADRATIC_REL: Int = js.native
          
          val PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS: Int = js.native
          
          val PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL: Int = js.native
          
          val PATHSEG_LINETO_ABS: Int = js.native
          
          val PATHSEG_LINETO_HORIZONTAL_ABS: Int = js.native
          
          val PATHSEG_LINETO_HORIZONTAL_REL: Int = js.native
          
          val PATHSEG_LINETO_REL: Int = js.native
          
          val PATHSEG_LINETO_VERTICAL_ABS: Int = js.native
          
          val PATHSEG_LINETO_VERTICAL_REL: Int = js.native
          
          val PATHSEG_MOVETO_ABS: Int = js.native
          
          val PATHSEG_MOVETO_REL: Int = js.native
          
          val PATHSEG_UNKNOWN: Int = js.native
        }
        
        @js.native
        class SVGPathSegArcAbs ()
          extends StObject
             with SVGPathSeg {
          
          var angle: Double = js.native
          
          var largeArcFlag: Boolean = js.native
          
          var r1: Double = js.native
          
          var r2: Double = js.native
          
          var sweepFlag: Boolean = js.native
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPathSegArcRel ()
          extends StObject
             with SVGPathSeg {
          
          var angle: Double = js.native
          
          var largeArcFlag: Boolean = js.native
          
          var r1: Double = js.native
          
          var r2: Double = js.native
          
          var sweepFlag: Boolean = js.native
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPathSegClosePath ()
          extends StObject
             with SVGPathSeg
        
        @js.native
        class SVGPathSegCurvetoCubicAbs ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var x1: Double = js.native
          
          var x2: Double = js.native
          
          var y: Double = js.native
          
          var y1: Double = js.native
          
          var y2: Double = js.native
        }
        
        @js.native
        class SVGPathSegCurvetoCubicRel ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var x1: Double = js.native
          
          var x2: Double = js.native
          
          var y: Double = js.native
          
          var y1: Double = js.native
          
          var y2: Double = js.native
        }
        
        @js.native
        class SVGPathSegCurvetoCubicSmoothAbs ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var x2: Double = js.native
          
          var y: Double = js.native
          
          var y2: Double = js.native
        }
        
        @js.native
        class SVGPathSegCurvetoCubicSmoothRel ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var x2: Double = js.native
          
          var y: Double = js.native
          
          var y2: Double = js.native
        }
        
        @js.native
        class SVGPathSegCurvetoQuadraticAbs ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var x1: Double = js.native
          
          var y: Double = js.native
          
          var y1: Double = js.native
        }
        
        @js.native
        class SVGPathSegCurvetoQuadraticRel ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var x1: Double = js.native
          
          var y: Double = js.native
          
          var y1: Double = js.native
        }
        
        @js.native
        class SVGPathSegCurvetoQuadraticSmoothAbs ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPathSegCurvetoQuadraticSmoothRel ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPathSegLinetoAbs ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPathSegLinetoHorizontalAbs ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
        }
        
        @js.native
        class SVGPathSegLinetoHorizontalRel ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
        }
        
        @js.native
        class SVGPathSegLinetoRel ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPathSegLinetoVerticalAbs ()
          extends StObject
             with SVGPathSeg {
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPathSegLinetoVerticalRel ()
          extends StObject
             with SVGPathSeg {
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPathSegList () extends StObject {
          
          def appendItem(newItem: SVGPathSeg): SVGPathSeg = js.native
          
          def clear(): Unit = js.native
          
          def getItem(index: Int): SVGPathSeg = js.native
          
          def initialize(newItem: SVGPathSeg): SVGPathSeg = js.native
          
          def insertItemBefore(newItem: SVGPathSeg, index: Int): SVGPathSeg = js.native
          
          def numberOfItems(): Int = js.native
          
          def removeItem(index: Int): SVGPathSeg = js.native
          
          def replaceItem(newItem: SVGPathSeg, index: Int): SVGPathSeg = js.native
        }
        
        @js.native
        class SVGPathSegMovetoAbs ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPathSegMovetoRel ()
          extends StObject
             with SVGPathSeg {
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        abstract class SVGPatternElement ()
          extends StObject
             with SVGElement
             with SVGUnitTypes
             with SVGStylable
             with SVGLangSpace
             with SVGTests
             with SVGFitToViewBox
             with SVGExternalResourcesRequired
             with SVGURIReference {
          
          def height(): SVGAnimatedLength = js.native
          
          def patternContentUnits(): SVGAnimatedEnumeration = js.native
          
          def patternTransform(): SVGAnimatedTransformList = js.native
          
          def patternUnits(): SVGAnimatedEnumeration = js.native
          
          def width(): SVGAnimatedLength = js.native
          
          def x(): SVGAnimatedLength = js.native
          
          def y(): SVGAnimatedLength = js.native
        }
        
        @js.native
        class SVGPoint () extends StObject {
          
          def matrixTransform(matrix: SVGMatrix): SVGPoint = js.native
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        class SVGPointList () extends StObject {
          
          def appendItem(newItem: SVGPoint): SVGPoint = js.native
          
          def clear(): Unit = js.native
          
          def getItem(index: Int): SVGPoint = js.native
          
          def initialize(newItem: SVGPoint): SVGPoint = js.native
          
          def insertItemBefore(newItem: SVGPoint, index: Int): SVGPoint = js.native
          
          def numberOfItems(): Int = js.native
          
          def removeItem(index: Int): SVGPoint = js.native
          
          def replaceItem(newItem: SVGPoint, index: Int): SVGPoint = js.native
        }
        
        @js.native
        abstract class SVGPolygonElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGAnimatedPoints
             with SVGTests
             with SVGExternalResourcesRequired
        
        @js.native
        abstract class SVGPolylineElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGAnimatedPoints
             with SVGTests
             with SVGExternalResourcesRequired
        
        @js.native
        class SVGPreserveAspectRatio () extends StObject {
          
          var align: Int = js.native
          
          var meetOrSlice: Int = js.native
        }
        @js.native
        object SVGPreserveAspectRatio extends StObject {
          
          val SVG_MEETORSLICE_MEET: Int = js.native
          
          val SVG_MEETORSLICE_SLICE: Int = js.native
          
          val SVG_MEETORSLICE_UNKNOWN: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_NONE: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_UNKNOWN: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_XMAXYMAX: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_XMAXYMID: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_XMAXYMIN: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_XMIDYMAX: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_XMIDYMID: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_XMIDYMIN: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_XMINYMAX: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_XMINYMID: Int = js.native
          
          val SVG_PRESERVEASPECTRATIO_XMINYMIN: Int = js.native
        }
        
        @js.native
        class SVGRadialGradientElement ()
          extends StObject
             with SVGGradientElement {
          
          def cx(): SVGAnimatedLength = js.native
          
          def cy(): SVGAnimatedLength = js.native
          
          def fx(): SVGAnimatedLength = js.native
          
          def fy(): SVGAnimatedLength = js.native
          
          def r(): SVGAnimatedLength = js.native
        }
        
        @js.native
        class SVGRect () extends StObject {
          
          var height: Double = js.native
          
          var width: Double = js.native
          
          var x: Double = js.native
          
          var y: Double = js.native
        }
        
        @js.native
        abstract class SVGRectElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired {
          
          def height(): SVGAnimatedLength = js.native
          
          def rx(): SVGAnimatedLength = js.native
          
          def ry(): SVGAnimatedLength = js.native
          
          def width(): SVGAnimatedLength = js.native
          
          def x(): SVGAnimatedLength = js.native
          
          def y(): SVGAnimatedLength = js.native
        }
        
        @js.native
        abstract class SVGSVGElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGZoomAndPan
             with org.scalajs.dom.raw.DocumentEvent
             with SVGLangSpace
             with SVGLocatable
             with SVGTests
             with SVGFitToViewBox
             with SVGExternalResourcesRequired {
          
          def checkEnclosure(element: SVGElement, rect: SVGRect): Boolean = js.native
          
          def checkIntersection(element: SVGElement, rect: SVGRect): Boolean = js.native
          
          var contentScriptType: String = js.native
          
          var contentStyleType: String = js.native
          
          def createSVGAngle(): SVGAngle = js.native
          
          def createSVGLength(): SVGLength = js.native
          
          def createSVGMatrix(): SVGMatrix = js.native
          
          def createSVGNumber(): SVGNumber = js.native
          
          def createSVGPoint(): SVGPoint = js.native
          
          def createSVGRect(): SVGRect = js.native
          
          def createSVGTransform(): SVGTransform = js.native
          
          def createSVGTransformFromMatrix(matrix: SVGMatrix): SVGTransform = js.native
          
          def currentScale(): Double = js.native
          
          def currentTranslate(): SVGPoint = js.native
          
          def deselectAll(): Unit = js.native
          
          def forceRedraw(): Unit = js.native
          
          def getComputedStyle(elt: org.scalajs.dom.raw.Element, pseudoElt: String): CSSStyleDeclaration = js.native
          
          def getCurrentTime(): Int = js.native
          
          def getElementById(elementId: String): org.scalajs.dom.raw.Element = js.native
          
          def getEnclosureList(rect: SVGRect, referenceElement: SVGElement): org.scalajs.dom.raw.NodeList = js.native
          
          def getIntersectionList(rect: SVGRect, referenceElement: SVGElement): org.scalajs.dom.raw.NodeList = js.native
          
          def height(): SVGAnimatedLength = js.native
          
          var onabort: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onresize: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onscroll: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onunload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onzoom: js.Function1[js.Any, _] = js.native
          
          def pauseAnimations(): Unit = js.native
          
          def pixelUnitToMillimeterX(): Double = js.native
          
          def pixelUnitToMillimeterY(): Double = js.native
          
          def screenPixelToMillimeterX(): Double = js.native
          
          def screenPixelToMillimeterY(): Double = js.native
          
          def setCurrentTime(seconds: Double): Unit = js.native
          
          def suspendRedraw(maxWaitMilliseconds: Int): Int = js.native
          
          def unpauseAnimations(): Unit = js.native
          
          def unsuspendRedraw(suspendHandleID: Int): Unit = js.native
          
          def unsuspendRedrawAll(): Unit = js.native
          
          def viewport(): SVGRect = js.native
          
          def width(): SVGAnimatedLength = js.native
          
          def x(): SVGAnimatedLength = js.native
          
          def y(): SVGAnimatedLength = js.native
        }
        
        @js.native
        abstract class SVGScriptElement ()
          extends StObject
             with SVGElement
             with SVGExternalResourcesRequired
             with SVGURIReference {
          
          def `type`(): String = js.native
        }
        
        @js.native
        abstract class SVGStopElement ()
          extends StObject
             with SVGElement
             with SVGStylable {
          
          var offset: SVGAnimatedNumber = js.native
        }
        
        @js.native
        class SVGStringList () extends StObject {
          
          def appendItem(newItem: String): String = js.native
          
          def clear(): Unit = js.native
          
          def getItem(index: Int): String = js.native
          
          def initialize(newItem: String): String = js.native
          
          def insertItemBefore(newItem: String, index: Int): String = js.native
          
          def numberOfItems(): Int = js.native
          
          def removeItem(index: Int): String = js.native
          
          def replaceItem(newItem: String, index: Int): String = js.native
        }
        
        @js.native
        trait SVGStylable extends StObject {
          
          var className: SVGAnimatedString = js.native
          
          var style: CSSStyleDeclaration = js.native
        }
        
        @js.native
        abstract class SVGStyleElement ()
          extends StObject
             with SVGElement
             with SVGLangSpace {
          
          var media: String = js.native
          
          var title: String = js.native
          
          def `type`(): String = js.native
        }
        
        @js.native
        abstract class SVGSwitchElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired
        
        @js.native
        abstract class SVGSymbolElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGLangSpace
             with SVGFitToViewBox
             with SVGExternalResourcesRequired
        
        @js.native
        abstract class SVGTSpanElement ()
          extends StObject
             with SVGTextPositioningElement
        
        @js.native
        trait SVGTests extends StObject {
          
          def hasExtension(`extension`: String): Boolean = js.native
          
          var requiredExtensions: SVGStringList = js.native
          
          var requiredFeatures: SVGStringList = js.native
          
          var systemLanguage: SVGStringList = js.native
        }
        
        @js.native
        abstract class SVGTextContentElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired {
          
          def getCharNumAtPosition(point: SVGPoint): Int = js.native
          
          def getComputedTextLength(): Double = js.native
          
          def getEndPositionOfChar(charnum: Int): SVGPoint = js.native
          
          def getExtentOfChar(charnum: Int): SVGRect = js.native
          
          def getNumberOfChars(): Int = js.native
          
          def getRotationOfChar(charnum: Int): Double = js.native
          
          def getStartPositionOfChar(charnum: Int): SVGPoint = js.native
          
          def getSubStringLength(charnum: Int, nchars: Int): Double = js.native
          
          def lengthAdjust(): SVGAnimatedEnumeration = js.native
          
          def selectSubString(charnum: Int, nchars: Int): Unit = js.native
          
          def textLength(): SVGAnimatedLength = js.native
        }
        @js.native
        object SVGTextContentElement extends StObject {
          
          val LENGTHADJUST_SPACING: Int = js.native
          
          val LENGTHADJUST_SPACINGANDGLYPHS: Int = js.native
          
          val LENGTHADJUST_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGTextElement ()
          extends StObject
             with SVGTextPositioningElement
             with SVGTransformable
        
        @js.native
        abstract class SVGTextPathElement ()
          extends StObject
             with SVGTextContentElement
             with SVGURIReference {
          
          def method(): SVGAnimatedEnumeration = js.native
          
          def spacing(): SVGAnimatedEnumeration = js.native
          
          def startOffset(): SVGAnimatedLength = js.native
        }
        @js.native
        object SVGTextPathElement extends StObject {
          
          val TEXTPATH_METHODTYPE_ALIGN: Int = js.native
          
          val TEXTPATH_METHODTYPE_STRETCH: Int = js.native
          
          val TEXTPATH_METHODTYPE_UNKNOWN: Int = js.native
          
          val TEXTPATH_SPACINGTYPE_AUTO: Int = js.native
          
          val TEXTPATH_SPACINGTYPE_EXACT: Int = js.native
          
          val TEXTPATH_SPACINGTYPE_UNKNOWN: Int = js.native
        }
        
        @js.native
        abstract class SVGTextPositioningElement ()
          extends StObject
             with SVGTextContentElement {
          
          def dx(): SVGAnimatedLengthList = js.native
          
          def dy(): SVGAnimatedLengthList = js.native
          
          def rotate(): SVGAnimatedNumberList = js.native
          
          def x(): SVGAnimatedLengthList = js.native
          
          def y(): SVGAnimatedLengthList = js.native
        }
        
        @js.native
        abstract class SVGTitleElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGLangSpace
        
        @js.native
        class SVGTransform () extends StObject {
          
          def angle(): Double = js.native
          
          def matrix(): SVGMatrix = js.native
          
          def setMatrix(matrix: SVGMatrix): Unit = js.native
          
          def setRotate(angle: Double, cx: Double, cy: Double): Unit = js.native
          
          def setScale(sx: Double, sy: Double): Unit = js.native
          
          def setSkewX(angle: Double): Unit = js.native
          
          def setSkewY(angle: Double): Unit = js.native
          
          def setTranslate(tx: Double, ty: Double): Unit = js.native
          
          def `type`(): Int = js.native
        }
        @js.native
        object SVGTransform extends StObject {
          
          val SVG_TRANSFORM_MATRIX: Int = js.native
          
          val SVG_TRANSFORM_ROTATE: Int = js.native
          
          val SVG_TRANSFORM_SCALE: Int = js.native
          
          val SVG_TRANSFORM_SKEWX: Int = js.native
          
          val SVG_TRANSFORM_SKEWY: Int = js.native
          
          val SVG_TRANSFORM_TRANSLATE: Int = js.native
          
          val SVG_TRANSFORM_UNKNOWN: Int = js.native
        }
        
        @js.native
        class SVGTransformList () extends StObject {
          
          def appendItem(newItem: SVGTransform): SVGTransform = js.native
          
          def clear(): Unit = js.native
          
          def consolidate(): SVGTransform = js.native
          
          def createSVGTransformFromMatrix(matrix: SVGMatrix): SVGTransform = js.native
          
          def getItem(index: Int): SVGTransform = js.native
          
          def initialize(newItem: SVGTransform): SVGTransform = js.native
          
          def insertItemBefore(newItem: SVGTransform, index: Int): SVGTransform = js.native
          
          def numberOfItems(): Int = js.native
          
          def removeItem(index: Int): SVGTransform = js.native
          
          def replaceItem(newItem: SVGTransform, index: Int): SVGTransform = js.native
        }
        
        @js.native
        trait SVGTransformable
          extends StObject
             with SVGLocatable {
          
          var transform: SVGAnimatedTransformList = js.native
        }
        
        @js.native
        trait SVGURIReference extends StObject {
          
          var href: SVGAnimatedString = js.native
        }
        
        @js.native
        trait SVGUnitTypes extends StObject {
          
          val SVG_UNIT_TYPE_OBJECTBOUNDINGBOX: Int = js.native
          
          val SVG_UNIT_TYPE_UNKNOWN: Int = js.native
          
          val SVG_UNIT_TYPE_USERSPACEONUSE: Int = js.native
        }
        @js.native
        object SVGUnitTypes extends StObject {
          
          val SVG_UNIT_TYPE_OBJECTBOUNDINGBOX: Int = js.native
          
          val SVG_UNIT_TYPE_UNKNOWN: Int = js.native
          
          val SVG_UNIT_TYPE_USERSPACEONUSE: Int = js.native
        }
        
        @js.native
        abstract class SVGUseElement ()
          extends StObject
             with SVGElement
             with SVGStylable
             with SVGTransformable
             with SVGLangSpace
             with SVGTests
             with SVGExternalResourcesRequired
             with SVGURIReference {
          
          def animatedInstanceRoot(): SVGElementInstance = js.native
          
          def height(): SVGAnimatedLength = js.native
          
          def instanceRoot(): SVGElementInstance = js.native
          
          def width(): SVGAnimatedLength = js.native
          
          def x(): SVGAnimatedLength = js.native
          
          def y(): SVGAnimatedLength = js.native
        }
        
        @js.native
        abstract class SVGViewElement ()
          extends StObject
             with SVGElement
             with SVGZoomAndPan
             with SVGFitToViewBox
             with SVGExternalResourcesRequired {
          
          def viewTarget(): SVGStringList = js.native
        }
        
        @js.native
        trait SVGZoomAndPan extends StObject {
          
          var zoomAndPan: Int = js.native
        }
        @js.native
        object SVGZoomAndPan extends StObject {
          
          val SVG_ZOOMANDPAN_DISABLE: Int = js.native
          
          val SVG_ZOOMANDPAN_MAGNIFY: Int = js.native
          
          val SVG_ZOOMANDPAN_UNKNOWN: Int = js.native
        }
        
        @js.native
        trait SVGZoomEventInit
          extends StObject
             with UIEventInit {
          
          var newScale: js.UndefOr[Double] = js.native
          
          var newTranslate: js.UndefOr[SVGPoint] = js.native
          
          var previousScale: js.UndefOr[Double] = js.native
          
          var previousTranslate: js.UndefOr[SVGPoint] = js.native
          
          var zoomRectScreen: js.UndefOr[SVGRect] = js.native
        }
        
        @js.native
        class Screen () extends StObject {
          
          def availHeight(): Double = js.native
          
          def availWidth(): Double = js.native
          
          def colorDepth(): Int = js.native
          
          def height(): Double = js.native
          
          def pixelDepth(): Int = js.native
          
          def width(): Double = js.native
        }
        
        @js.native
        class Selection () extends StObject {
          
          def addRange(range: org.scalajs.dom.raw.Range): Unit = js.native
          
          def anchorNode(): org.scalajs.dom.raw.Node = js.native
          
          def anchorOffset(): Int = js.native
          
          def collapse(parentNode: org.scalajs.dom.raw.Node, offset: Int): Unit = js.native
          
          def collapseToEnd(): Unit = js.native
          
          def collapseToStart(): Unit = js.native
          
          def containsNode(node: org.scalajs.dom.raw.Node, partialContainment: Boolean): Boolean = js.native
          
          def deleteFromDocument(): Unit = js.native
          
          def extend(node: org.scalajs.dom.raw.Node, offset: Int): Unit = js.native
          
          def focusNode(): org.scalajs.dom.raw.Node = js.native
          
          def focusOffset(): Int = js.native
          
          def getRangeAt(index: Int): org.scalajs.dom.raw.Range = js.native
          
          def isCollapsed(): Boolean = js.native
          
          def rangeCount(): Int = js.native
          
          def removeAllRanges(): Unit = js.native
          
          def removeRange(range: org.scalajs.dom.raw.Range): Unit = js.native
          
          def selectAllChildren(parentNode: org.scalajs.dom.raw.Node): Unit = js.native
        }
        
        @js.native
        trait StereoPannerNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          val pan: org.scalajs.dom.raw.AudioParam = js.native
        }
        
        @js.native
        class Storage () extends StObject {
          
          def clear(): Unit = js.native
          
          def getItem(key: String): String = js.native
          
          def key(index: Int): String = js.native
          
          var length: Int = js.native
          
          def removeItem(key: String): Unit = js.native
          
          def setItem(key: String, data: String): Unit = js.native
        }
        
        @js.native
        class StorageEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.Event {
          def this(typeArg: String, init: js.UndefOr[StorageEventInit]) = this()
          
          val init: js.UndefOr[StorageEventInit] = js.native
          
          def key(): String = js.native
          
          def newValue(): String = js.native
          
          def oldValue(): String = js.native
          
          def storageArea(): org.scalajs.dom.raw.Storage = js.native
          
          val typeArg: String = js.native
          
          def url(): String = js.native
        }
        
        @js.native
        trait StorageEventInit
          extends StObject
             with EventInit {
          
          var key: js.UndefOr[String] = js.native
          
          var newValue: js.UndefOr[String] = js.native
          
          var oldValue: js.UndefOr[String] = js.native
          
          var storageArea: js.UndefOr[org.scalajs.dom.raw.Storage] = js.native
          
          var url: js.UndefOr[String] = js.native
        }
        
        @js.native
        trait StyleMedia extends StObject {
          
          def matchMedium(mediaquery: String): Boolean = js.native
          
          def `type`(): String = js.native
        }
        
        @js.native
        class StyleSheet () extends StObject {
          
          def disabled(): Boolean = js.native
          
          def href(): String = js.native
          
          def media(): org.scalajs.dom.raw.MediaList = js.native
          
          def ownerNode(): org.scalajs.dom.raw.Node = js.native
          
          def parentStyleSheet(): org.scalajs.dom.raw.StyleSheet = js.native
          
          def title(): String = js.native
          
          def `type`(): String = js.native
        }
        
        @js.native
        class StyleSheetList () extends StObject {
          
          def apply(index: Int): org.scalajs.dom.raw.StyleSheet = js.native
          
          def item(index: Int): org.scalajs.dom.raw.StyleSheet = js.native
          
          def length(): Int = js.native
          
          def update(index: Int, v: org.scalajs.dom.raw.StyleSheet): Unit = js.native
        }
        
        @js.native
        class Text ()
          extends StObject
             with org.scalajs.dom.raw.CharacterData {
          
          def splitText(offset: Int): org.scalajs.dom.raw.Text = js.native
          
          def wholeText(): String = js.native
        }
        
        @js.native
        class TextEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.UIEvent {
          def this(typeArg: String, init: js.UndefOr[TextEventInit]) = this()
          
          def data(): String = js.native
          
          val init: js.UndefOr[TextEventInit] = js.native
          
          def initTextEvent(
            typeArg: String,
            canBubbleArg: Boolean,
            cancelableArg: Boolean,
            viewArg: org.scalajs.dom.raw.Window,
            dataArg: String,
            inputMethod: Int,
            locale: String
          ): Unit = js.native
          
          def inputMethod(): Int = js.native
          
          def locale(): String = js.native
          
          val typeArg: String = js.native
        }
        @js.native
        object TextEvent extends StObject {
          
          val DOM_INPUT_METHOD_DROP: Int = js.native
          
          val DOM_INPUT_METHOD_HANDWRITING: Int = js.native
          
          val DOM_INPUT_METHOD_IME: Int = js.native
          
          val DOM_INPUT_METHOD_KEYBOARD: Int = js.native
          
          val DOM_INPUT_METHOD_MULTIMODAL: Int = js.native
          
          val DOM_INPUT_METHOD_OPTION: Int = js.native
          
          val DOM_INPUT_METHOD_PASTE: Int = js.native
          
          val DOM_INPUT_METHOD_SCRIPT: Int = js.native
          
          val DOM_INPUT_METHOD_UNKNOWN: Int = js.native
          
          val DOM_INPUT_METHOD_VOICE: Int = js.native
        }
        
        @js.native
        trait TextEventInit
          extends StObject
             with UIEventInit {
          
          var data: js.UndefOr[String] = js.native
          
          var inputMethod: js.UndefOr[Int] = js.native
          
          var locale: js.UndefOr[String] = js.native
        }
        
        @js.native
        class TextMetrics () extends StObject {
          
          var width: Double = js.native
        }
        
        @js.native
        trait TextTrack
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          var DISABLED: Int = js.native
          
          var ERROR: Int = js.native
          
          var HIDDEN: Int = js.native
          
          var LOADED: Int = js.native
          
          var LOADING: Int = js.native
          
          var NONE: Int = js.native
          
          var SHOWING: Int = js.native
          
          var activeCues: org.scalajs.dom.raw.TextTrackCueList = js.native
          
          var cues: org.scalajs.dom.raw.TextTrackCueList = js.native
          
          var kind: String = js.native
          
          var label: String = js.native
          
          var language: String = js.native
          
          var mode: js.Any = js.native
          
          var oncuechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
          
          var onload: js.Function1[js.Any, _] = js.native
          
          var readyState: Int = js.native
        }
        @js.native
        object TextTrack extends StObject {
          
          var DISABLED: Int = js.native
          
          var ERROR: Int = js.native
          
          var HIDDEN: Int = js.native
          
          var LOADED: Int = js.native
          
          var LOADING: Int = js.native
          
          var NONE: Int = js.native
          
          var SHOWING: Int = js.native
        }
        
        @js.native
        trait TextTrackCue
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          var endTime: Double = js.native
          
          def getCueAsHTML(): org.scalajs.dom.raw.DocumentFragment = js.native
          
          var id: String = js.native
          
          var onenter: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onexit: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var pauseOnExit: Boolean = js.native
          
          var startTime: Double = js.native
          
          var text: String = js.native
          
          var track: org.scalajs.dom.raw.TextTrack = js.native
        }
        
        @js.native
        trait TextTrackCueList
          extends StObject
             with org.scalajs.dom.raw.DOMList[org.scalajs.dom.raw.TextTrackCue] {
          
          def getCueById(id: String): org.scalajs.dom.raw.TextTrackCue = js.native
        }
        
        @js.native
        trait TextTrackList
          extends StObject
             with org.scalajs.dom.raw.DOMList[org.scalajs.dom.raw.TextTrack]
        
        @js.native
        class TimeRanges () extends StObject {
          
          def end(index: Int): Double = js.native
          
          def length(): Int = js.native
          
          def start(index: Int): Double = js.native
        }
        
        @js.native
        class Touch () extends StObject {
          
          def clientX(): Double = js.native
          
          def clientY(): Double = js.native
          
          def force(): Double = js.native
          
          def identifier(): Double = js.native
          
          def pageX(): Double = js.native
          
          def pageY(): Double = js.native
          
          def radiusX(): Double = js.native
          
          def radiusY(): Double = js.native
          
          def rotationAngle(): Double = js.native
          
          def screenX(): Double = js.native
          
          def screenY(): Double = js.native
          
          def target(): org.scalajs.dom.raw.EventTarget = js.native
        }
        
        @js.native
        class TouchEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.UIEvent
             with org.scalajs.dom.raw.ModifierKeyEvent {
          def this(typeArg: String, init: js.UndefOr[TouchEventInit]) = this()
          
          def changedTouches(): org.scalajs.dom.raw.TouchList = js.native
          
          val init: js.UndefOr[TouchEventInit] = js.native
          
          override def target(): org.scalajs.dom.raw.EventTarget = js.native
          
          def targetTouches(): org.scalajs.dom.raw.TouchList = js.native
          
          def touches(): org.scalajs.dom.raw.TouchList = js.native
          
          val typeArg: String = js.native
        }
        
        @js.native
        trait TouchEventInit
          extends StObject
             with UIEventInit
             with ModifierKeyEventInit {
          
          var changedTouches: js.UndefOr[org.scalajs.dom.raw.TouchList] = js.native
          
          var targetTouches: js.UndefOr[org.scalajs.dom.raw.TouchList] = js.native
          
          var touches: js.UndefOr[org.scalajs.dom.raw.TouchList] = js.native
        }
        
        @js.native
        class TouchList ()
          extends StObject
             with org.scalajs.dom.raw.DOMList[org.scalajs.dom.raw.Touch]
        
        @js.native
        trait TrackEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          var track: js.Any = js.native
        }
        
        type Transferable = js.typedarray.ArrayBuffer | org.scalajs.dom.raw.MessagePort
        
        @js.native
        trait TransitionEvent
          extends StObject
             with org.scalajs.dom.raw.Event {
          
          def elapsedTime(): Double = js.native
          
          def propertyName(): String = js.native
        }
        
        @js.native
        class TreeWalker () extends StObject {
          
          var currentNode: org.scalajs.dom.raw.Node = js.native
          
          def filter(): org.scalajs.dom.raw.NodeFilter = js.native
          
          def firstChild(): org.scalajs.dom.raw.Node = js.native
          
          def lastChild(): org.scalajs.dom.raw.Node = js.native
          
          def nextNode(): org.scalajs.dom.raw.Node = js.native
          
          def nextSibling(): org.scalajs.dom.raw.Node = js.native
          
          def parentNode(): org.scalajs.dom.raw.Node = js.native
          
          def previousNode(): org.scalajs.dom.raw.Node = js.native
          
          def previousSibling(): org.scalajs.dom.raw.Node = js.native
          
          def root(): org.scalajs.dom.raw.Node = js.native
          
          def whatToShow(): Int = js.native
        }
        
        @js.native
        class UIEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.Event {
          def this(typeArg: String, init: js.UndefOr[UIEventInit]) = this()
          
          def detail(): Int = js.native
          
          val init: js.UndefOr[UIEventInit] = js.native
          
          val typeArg: String = js.native
          
          def view(): org.scalajs.dom.raw.Window = js.native
        }
        
        @js.native
        trait UIEventInit
          extends StObject
             with EventInit {
          
          val detail: js.UndefOr[Int] = js.native
          
          val view: js.UndefOr[org.scalajs.dom.raw.Window] = js.native
        }
        
        @js.native
        object URL extends StObject {
          
          def createObjectURL(blob: org.scalajs.dom.raw.Blob): String = js.native
          
          def revokeObjectURL(url: String): Unit = js.native
        }
        
        @js.native
        trait ValidityState extends StObject {
          
          def customError(): Boolean = js.native
          
          def patternMismatch(): Boolean = js.native
          
          def rangeOverflow(): Boolean = js.native
          
          def rangeUnderflow(): Boolean = js.native
          
          def stepMismatch(): Boolean = js.native
          
          def tooLong(): Boolean = js.native
          
          def typeMismatch(): Boolean = js.native
          
          def valid(): Boolean = js.native
          
          def valueMissing(): Boolean = js.native
        }
        
        @js.native
        sealed trait VisibilityState
          extends StObject
             with js.Any
        
        @js.native
        trait WaveShaperNode
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AudioNode {
          
          var curve: js.typedarray.Float32Array = js.native
          
          var oversample: String = js.native
        }
        
        @js.native
        class WebGLActiveInfo private () extends StObject {
          
          val name: String = js.native
          
          val size: Int = js.native
          
          val `type`: Int = js.native
        }
        
        @js.native
        class WebGLBuffer private () extends StObject
        
        @js.native
        class WebGLContextAttributes () extends StObject {
          
          var alpha: Boolean = js.native
          
          var antialias: Boolean = js.native
          
          var depth: Boolean = js.native
          
          var premultipliedAlpha: Boolean = js.native
          
          var preserveDrawingBuffer: Boolean = js.native
          
          var stencil: Boolean = js.native
        }
        
        @js.native
        class WebGLFramebuffer private () extends StObject
        
        @js.native
        class WebGLProgram private () extends StObject
        
        @js.native
        class WebGLRenderbuffer private () extends StObject
        
        @js.native
        class WebGLRenderingContext () extends StObject {
          
          def activeTexture(texture: Int): Unit = js.native
          
          def attachShader(program: WebGLProgram, shader: WebGLShader): Unit = js.native
          
          def bindAttribLocation(program: WebGLProgram, index: Int, name: String): Unit = js.native
          
          def bindBuffer(target: Int, buffer: WebGLBuffer): Unit = js.native
          
          def bindFramebuffer(target: Int, framebuffer: WebGLFramebuffer): Unit = js.native
          
          def bindRenderbuffer(target: Int, renderbuffer: WebGLRenderbuffer): Unit = js.native
          
          def bindTexture(target: Int, texture: WebGLTexture): Unit = js.native
          
          def blendColor(red: Double, green: Double, blue: Double, alpha: Double): Unit = js.native
          
          def blendEquation(mode: Int): Unit = js.native
          
          def blendEquationSeparate(modeRGB: Int, modeAlpha: Int): Unit = js.native
          
          def blendFunc(sfactor: Int, dfactor: Int): Unit = js.native
          
          def blendFuncSeparate(srcRGB: Int, dstRGB: Int, srcAlpha: Int, dstAlpha: Int): Unit = js.native
          
          def bufferData(target: Int, data: js.typedarray.ArrayBufferView, usage: Int): Unit = js.native
          def bufferData(target: Int, data: js.typedarray.ArrayBuffer, usage: Int): Unit = js.native
          def bufferData(target: Int, size: Int, usage: Int): Unit = js.native
          
          def bufferSubData(target: Int, offset: Int, data: js.typedarray.ArrayBuffer): Unit = js.native
          def bufferSubData(target: Int, offset: Int, data: js.typedarray.ArrayBufferView): Unit = js.native
          
          val canvas: HTMLCanvasElement = js.native
          
          def checkFramebufferStatus(target: Int): Int = js.native
          
          def clear(mask: Int): Unit = js.native
          
          def clearColor(red: Double, green: Double, blue: Double, alpha: Double): Unit = js.native
          
          def clearDepth(depth: Double): Unit = js.native
          
          def clearStencil(s: Int): Unit = js.native
          
          def colorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean): Unit = js.native
          
          def compileShader(shader: WebGLShader): Unit = js.native
          
          def compressedTexImage2D(
            target: Int,
            level: Int,
            internalformat: Int,
            width: Int,
            height: Int,
            border: Int,
            data: js.typedarray.ArrayBufferView
          ): Unit = js.native
          
          def compressedTexSubImage2D(
            target: Int,
            level: Int,
            xoffset: Int,
            yoffset: Int,
            width: Int,
            height: Int,
            format: Int,
            data: js.typedarray.ArrayBufferView
          ): Unit = js.native
          
          def copyTexImage2D(target: Int, level: Int, internalformat: Int, x: Int, y: Int, width: Int, height: Int, border: Int): Unit = js.native
          
          def copyTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int, width: Int, height: Int): Unit = js.native
          
          def createBuffer(): WebGLBuffer = js.native
          
          def createFramebuffer(): WebGLFramebuffer = js.native
          
          def createProgram(): WebGLProgram = js.native
          
          def createRenderbuffer(): WebGLRenderbuffer = js.native
          
          def createShader(`type`: Int): WebGLShader = js.native
          
          def createTexture(): WebGLTexture = js.native
          
          def cullFace(mode: Int): Unit = js.native
          
          def deleteBuffer(buffer: WebGLBuffer): Unit = js.native
          
          def deleteFramebuffer(framebuffer: WebGLFramebuffer): Unit = js.native
          
          def deleteProgram(program: WebGLProgram): Unit = js.native
          
          def deleteRenderbuffer(renderbuffer: WebGLRenderbuffer): Unit = js.native
          
          def deleteShader(shader: WebGLShader): Unit = js.native
          
          def deleteTexture(texture: WebGLTexture): Unit = js.native
          
          def depthFunc(func: Int): Unit = js.native
          
          def depthMask(flag: Boolean): Unit = js.native
          
          def depthRange(zNear: Double, zFar: Double): Unit = js.native
          
          def detachShader(program: WebGLProgram, shader: WebGLShader): Unit = js.native
          
          def disable(cap: Int): Unit = js.native
          
          def disableVertexAttribArray(index: Int): Unit = js.native
          
          def drawArrays(mode: Int, first: Int, count: Int): Unit = js.native
          
          def drawElements(mode: Int, count: Int, `type`: Int, offset: Int): Unit = js.native
          
          val drawingBufferHeight: Int = js.native
          
          val drawingBufferWidth: Int = js.native
          
          def enable(cap: Int): Unit = js.native
          
          def enableVertexAttribArray(index: Int): Unit = js.native
          
          def finish(): Unit = js.native
          
          def flush(): Unit = js.native
          
          def framebufferRenderbuffer(target: Int, attachment: Int, renderbuffertarget: Int, renderbuffer: WebGLRenderbuffer): Unit = js.native
          
          def framebufferTexture2D(target: Int, attachment: Int, textarget: Int, texture: WebGLTexture, level: Int): Unit = js.native
          
          def frontFace(mode: Int): Unit = js.native
          
          def generateMipmap(target: Int): Unit = js.native
          
          def getActiveAttrib(program: WebGLProgram, index: Int): WebGLActiveInfo = js.native
          
          def getActiveUniform(program: WebGLProgram, index: Int): WebGLActiveInfo = js.native
          
          def getAttachedShaders(program: WebGLProgram): js.Array[WebGLShader] = js.native
          
          def getAttribLocation(program: WebGLProgram, name: String): Int = js.native
          
          def getBufferParameter(target: Int, pname: Int): Int = js.native
          
          def getContextAttributes(): WebGLContextAttributes = js.native
          
          def getError(): Int = js.native
          
          def getExtension(name: String): js.Any = js.native
          
          def getFramebufferAttachmentParameter(target: Int, attachment: Int, pname: Int): js.Any = js.native
          
          def getParameter(pname: Int): js.Any = js.native
          
          def getProgramInfoLog(program: WebGLProgram): String = js.native
          
          def getProgramParameter(program: WebGLProgram, pname: Int): js.Any = js.native
          
          def getRenderbufferParameter(target: Int, pname: Int): js.Any = js.native
          
          def getShaderInfoLog(shader: WebGLShader): String = js.native
          
          def getShaderParameter(shader: WebGLShader, pname: Int): js.Any = js.native
          
          def getShaderPrecisionFormat(shadertype: Int, precisiontype: Int): WebGLShaderPrecisionFormat = js.native
          
          def getShaderSource(shader: WebGLShader): String = js.native
          
          def getSupportedExtensions(): js.Array[String] = js.native
          
          def getTexParameter(target: Int, pname: Int): js.Any = js.native
          
          def getUniform(program: WebGLProgram, location: WebGLUniformLocation): js.Any = js.native
          
          def getUniformLocation(program: WebGLProgram, name: String): WebGLUniformLocation = js.native
          
          def getVertexAttrib(index: Int, pname: Int): js.Any = js.native
          
          def getVertexAttribOffset(index: Int, pname: Int): Int = js.native
          
          def hint(target: Int, mode: Int): Unit = js.native
          
          def isBuffer(buffer: js.Any): Boolean = js.native
          
          def isContextLost(): Boolean = js.native
          
          def isEnabled(cap: Int): Boolean = js.native
          
          def isFramebuffer(framebuffer: js.Any): Boolean = js.native
          
          def isProgram(program: js.Any): Boolean = js.native
          
          def isRenderbuffer(renderbuffer: js.Any): Boolean = js.native
          
          def isShader(shader: js.Any): Boolean = js.native
          
          def isTexture(texture: js.Any): Boolean = js.native
          
          def lineWidth(width: Double): Unit = js.native
          
          def linkProgram(program: WebGLProgram): Unit = js.native
          
          def pixelStorei(pname: Int, param: Int): Unit = js.native
          
          def polygonOffset(factor: Double, units: Double): Unit = js.native
          
          def readPixels(
            x: Int,
            y: Int,
            width: Int,
            height: Int,
            format: Int,
            `type`: Int,
            pixels: js.typedarray.ArrayBufferView
          ): Unit = js.native
          
          def renderbufferStorage(target: Int, internalformat: Int, width: Int, height: Int): Unit = js.native
          
          def sampleCoverage(value: Int, invert: Boolean): Unit = js.native
          
          def scissor(x: Int, y: Int, width: Int, height: Int): Unit = js.native
          
          def shaderSource(shader: WebGLShader, source: String): Unit = js.native
          
          def stencilFunc(func: Int, ref: Int, mask: Int): Unit = js.native
          
          def stencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int): Unit = js.native
          
          def stencilMask(mask: Int): Unit = js.native
          
          def stencilMaskSeparate(face: Int, mask: Int): Unit = js.native
          
          def stencilOp(fail: Int, zfail: Int, zpass: Int): Unit = js.native
          
          def stencilOpSeparate(face: Int, fail: Int, zfail: Int, zpass: Int): Unit = js.native
          
          def texImage2D(target: Int, level: Int, internalformat: Int, format: Int, `type`: Int, pixels: HTMLCanvasElement): Unit = js.native
          def texImage2D(target: Int, level: Int, internalformat: Int, format: Int, `type`: Int, pixels: HTMLImageElement): Unit = js.native
          def texImage2D(target: Int, level: Int, internalformat: Int, format: Int, `type`: Int, pixels: HTMLVideoElement): Unit = js.native
          def texImage2D(
            target: Int,
            level: Int,
            internalformat: Int,
            format: Int,
            `type`: Int,
            pixels: org.scalajs.dom.raw.ImageData
          ): Unit = js.native
          def texImage2D(
            target: Int,
            level: Int,
            internalformat: Int,
            width: Int,
            height: Int,
            border: Int,
            format: Int,
            `type`: Int,
            pixels: js.typedarray.ArrayBufferView
          ): Unit = js.native
          
          def texParameterf(target: Int, pname: Int, param: Double): Unit = js.native
          
          def texParameteri(target: Int, pname: Int, param: Int): Unit = js.native
          
          def texSubImage2D(
            target: Int,
            level: Int,
            xoffset: Int,
            yoffset: Int,
            format: Int,
            `type`: Int,
            pixels: HTMLCanvasElement
          ): Unit = js.native
          def texSubImage2D(
            target: Int,
            level: Int,
            xoffset: Int,
            yoffset: Int,
            format: Int,
            `type`: Int,
            pixels: HTMLImageElement
          ): Unit = js.native
          def texSubImage2D(
            target: Int,
            level: Int,
            xoffset: Int,
            yoffset: Int,
            format: Int,
            `type`: Int,
            pixels: HTMLVideoElement
          ): Unit = js.native
          def texSubImage2D(
            target: Int,
            level: Int,
            xoffset: Int,
            yoffset: Int,
            format: Int,
            `type`: Int,
            pixels: org.scalajs.dom.raw.ImageData
          ): Unit = js.native
          def texSubImage2D(
            target: Int,
            level: Int,
            xoffset: Int,
            yoffset: Int,
            width: Int,
            height: Int,
            format: Int,
            `type`: Int,
            pixels: js.typedarray.ArrayBufferView
          ): Unit = js.native
          
          def uniform1f(location: WebGLUniformLocation, x: Double): Unit = js.native
          
          def uniform1fv(location: WebGLUniformLocation, v: js.Array[Double]): Unit = js.native
          def uniform1fv(location: WebGLUniformLocation, v: js.typedarray.Float32Array): Unit = js.native
          
          def uniform1i(location: WebGLUniformLocation, x: Int): Unit = js.native
          
          def uniform1iv(location: WebGLUniformLocation, v: js.Array[Int]): Unit = js.native
          def uniform1iv(location: WebGLUniformLocation, v: js.typedarray.Int32Array): Unit = js.native
          
          def uniform2f(location: WebGLUniformLocation, x: Double, y: Double): Unit = js.native
          
          def uniform2fv(location: WebGLUniformLocation, v: js.Array[Double]): Unit = js.native
          def uniform2fv(location: WebGLUniformLocation, v: js.typedarray.Float32Array): Unit = js.native
          
          def uniform2i(location: WebGLUniformLocation, x: Int, y: Int): Unit = js.native
          
          def uniform2iv(location: WebGLUniformLocation, v: js.Array[Int]): Unit = js.native
          def uniform2iv(location: WebGLUniformLocation, v: js.typedarray.Int32Array): Unit = js.native
          
          def uniform3f(location: WebGLUniformLocation, x: Double, y: Double, z: Double): Unit = js.native
          
          def uniform3fv(location: WebGLUniformLocation, v: js.Array[Double]): Unit = js.native
          def uniform3fv(location: WebGLUniformLocation, v: js.typedarray.Float32Array): Unit = js.native
          
          def uniform3i(location: WebGLUniformLocation, x: Int, y: Int, z: Int): Unit = js.native
          
          def uniform3iv(location: WebGLUniformLocation, v: js.Array[Int]): Unit = js.native
          def uniform3iv(location: WebGLUniformLocation, v: js.typedarray.Int32Array): Unit = js.native
          
          def uniform4f(location: WebGLUniformLocation, x: Double, y: Double, z: Double, w: Double): Unit = js.native
          
          def uniform4fv(location: WebGLUniformLocation, v: js.Array[Double]): Unit = js.native
          def uniform4fv(location: WebGLUniformLocation, v: js.typedarray.Float32Array): Unit = js.native
          
          def uniform4i(location: WebGLUniformLocation, x: Int, y: Int, z: Int, w: Int): Unit = js.native
          
          def uniform4iv(location: WebGLUniformLocation, v: js.Array[Int]): Unit = js.native
          def uniform4iv(location: WebGLUniformLocation, v: js.typedarray.Int32Array): Unit = js.native
          
          def uniformMatrix2fv(location: WebGLUniformLocation, transpose: Boolean, value: js.Array[Double]): Unit = js.native
          def uniformMatrix2fv(location: WebGLUniformLocation, transpose: Boolean, value: js.typedarray.Float32Array): Unit = js.native
          
          def uniformMatrix3fv(location: WebGLUniformLocation, transpose: Boolean, value: js.Array[Double]): Unit = js.native
          def uniformMatrix3fv(location: WebGLUniformLocation, transpose: Boolean, value: js.typedarray.Float32Array): Unit = js.native
          
          def uniformMatrix4fv(location: WebGLUniformLocation, transpose: Boolean, value: js.Array[Double]): Unit = js.native
          def uniformMatrix4fv(location: WebGLUniformLocation, transpose: Boolean, value: js.typedarray.Float32Array): Unit = js.native
          
          def useProgram(program: WebGLProgram): Unit = js.native
          
          def validateProgram(program: WebGLProgram): Unit = js.native
          
          def vertexAttrib1f(indx: Int, x: Double): Unit = js.native
          
          def vertexAttrib1fv(indx: Int, values: js.Array[Double]): Unit = js.native
          def vertexAttrib1fv(indx: Int, values: js.typedarray.Float32Array): Unit = js.native
          
          def vertexAttrib2f(indx: Int, x: Double, y: Double): Unit = js.native
          
          def vertexAttrib2fv(indx: Int, values: js.Array[Double]): Unit = js.native
          def vertexAttrib2fv(indx: Int, values: js.typedarray.Float32Array): Unit = js.native
          
          def vertexAttrib3f(indx: Int, x: Double, y: Double, z: Double): Unit = js.native
          
          def vertexAttrib3fv(indx: Int, values: js.Array[Double]): Unit = js.native
          def vertexAttrib3fv(indx: Int, values: js.typedarray.Float32Array): Unit = js.native
          
          def vertexAttrib4f(indx: Int, x: Double, y: Double, z: Double, w: Double): Unit = js.native
          
          def vertexAttrib4fv(indx: Int, values: js.Array[Double]): Unit = js.native
          def vertexAttrib4fv(indx: Int, values: js.typedarray.Float32Array): Unit = js.native
          
          def vertexAttribPointer(indx: Int, size: Int, `type`: Int, normalized: Boolean, stride: Int, offset: Int): Unit = js.native
          
          def viewport(x: Double, y: Double, width: Double, height: Double): Unit = js.native
        }
        
        @js.native
        class WebGLShader private () extends StObject
        
        @js.native
        class WebGLShaderPrecisionFormat private () extends StObject {
          
          val precision: Int = js.native
          
          val rangeMax: Int = js.native
          
          val rangeMin: Int = js.native
        }
        
        @js.native
        class WebGLTexture private () extends StObject
        
        @js.native
        class WebGLUniformLocation private () extends StObject
        
        @js.native
        class WebSocket protected ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          def this(url: String, protocol: String) = this()
          def this(url: String, protocol: js.Array[String]) = this()
          
          var binaryType: String = js.native
          
          def bufferedAmount(): Int = js.native
          
          def close(code: Int, reason: String): Unit = js.native
          
          def extensions(): String = js.native
          
          var onclose: js.Function1[org.scalajs.dom.raw.CloseEvent, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onmessage: js.Function1[org.scalajs.dom.raw.MessageEvent, _] = js.native
          
          var onopen: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var protocol: String = js.native
          
          def readyState(): Int = js.native
          
          def send(data: String): Unit = js.native
          def send(data: js.typedarray.ArrayBuffer): Unit = js.native
          def send(data: org.scalajs.dom.raw.Blob): Unit = js.native
          
          var url: String = js.native
        }
        @js.native
        object WebSocket extends StObject {
          
          val CLOSED: Int = js.native
          
          val CLOSING: Int = js.native
          
          val CONNECTING: Int = js.native
          
          val OPEN: Int = js.native
        }
        
        @js.native
        class WheelEvent protected ()
          extends StObject
             with org.scalajs.dom.raw.MouseEvent {
          def this(typeArg: String, init: js.UndefOr[WheelEventInit]) = this()
          
          def deltaMode(): Int = js.native
          
          def deltaX(): Double = js.native
          
          def deltaY(): Double = js.native
          
          def deltaZ(): Double = js.native
          
          val init: js.UndefOr[WheelEventInit] = js.native
          
          val typeArg: String = js.native
        }
        @js.native
        object WheelEvent extends StObject {
          
          val DOM_DELTA_LINE: Int = js.native
          
          val DOM_DELTA_PAGE: Int = js.native
          
          val DOM_DELTA_PIXEL: Int = js.native
        }
        
        @js.native
        trait WheelEventInit
          extends StObject
             with MouseEventInit {
          
          var deltaMode: js.UndefOr[Int] = js.native
          
          var deltaX: js.UndefOr[Double] = js.native
          
          var deltaY: js.UndefOr[Double] = js.native
          
          var deltaZ: js.UndefOr[Double] = js.native
        }
        
        @js.native
        class Window ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.WindowLocalStorage
             with org.scalajs.dom.raw.WindowSessionStorage
             with org.scalajs.dom.raw.WindowTimers
             with org.scalajs.dom.raw.WindowBase64
             with IDBEnvironment
             with org.scalajs.dom.raw.WindowConsole {
          
          def alert(): Unit = js.native
          def alert(message: String): Unit = js.native
          
          def applicationCache(): org.scalajs.dom.raw.ApplicationCache = js.native
          
          def blur(): Unit = js.native
          
          def cancelAnimationFrame(handle: Int): Unit = js.native
          
          def close(): Unit = js.native
          
          def confirm(message: String): Boolean = js.native
          
          def devicePixelRatio(): Double = js.native
          
          def document(): HTMLDocument = js.native
          
          def focus(): Unit = js.native
          
          def frameElement(): org.scalajs.dom.raw.Element = js.native
          
          def frames(): org.scalajs.dom.raw.Window = js.native
          
          def getComputedStyle(elt: org.scalajs.dom.raw.Element, pseudoElt: String): CSSStyleDeclaration = js.native
          
          def getSelection(): org.scalajs.dom.raw.Selection = js.native
          
          var gotpointercapture: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          def history(): org.scalajs.dom.raw.History = js.native
          
          def innerHeight(): Double = js.native
          
          def innerWidth(): Double = js.native
          
          def length(): Int = js.native
          
          var location: org.scalajs.dom.raw.Location = js.native
          
          var lostpointercapture: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          def matchMedia(mediaQuery: String): org.scalajs.dom.raw.MediaQueryList = js.native
          
          var name: String = js.native
          
          def navigator(): org.scalajs.dom.raw.Navigator = js.native
          
          var onabort: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onafterprint: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onbeforeprint: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onbeforeunload: js.Function1[org.scalajs.dom.raw.BeforeUnloadEvent, _] = js.native
          
          var onblur: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var oncanplay: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var oncanplaythrough: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onclick: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var oncontextmenu: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var ondblclick: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var ondrag: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragend: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragenter: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragleave: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragover: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondragstart: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondrop: js.Function1[org.scalajs.dom.raw.DragEvent, _] = js.native
          
          var ondurationchange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onemptied: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onended: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onerror: js.Function5[org.scalajs.dom.raw.Event, String, Int, Int, Any, _] = js.native
          
          var onfocus: js.Function1[org.scalajs.dom.raw.FocusEvent, _] = js.native
          
          var onhashchange: js.Function1[org.scalajs.dom.raw.HashChangeEvent, _] = js.native
          
          var oninput: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onkeydown: js.Function1[org.scalajs.dom.raw.KeyboardEvent, _] = js.native
          
          var onkeypress: js.Function1[org.scalajs.dom.raw.KeyboardEvent, _] = js.native
          
          var onkeyup: js.Function1[org.scalajs.dom.raw.KeyboardEvent, _] = js.native
          
          var onload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onloadeddata: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onloadedmetadata: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onloadstart: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onmessage: js.Function1[org.scalajs.dom.raw.MessageEvent, _] = js.native
          
          var onmousedown: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmousemove: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseout: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseover: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmouseup: js.Function1[org.scalajs.dom.raw.MouseEvent, _] = js.native
          
          var onmousewheel: js.Function1[org.scalajs.dom.raw.WheelEvent, _] = js.native
          
          var onoffline: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var ononline: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onpagehide: js.Function1[PageTransitionEvent, _] = js.native
          
          var onpageshow: js.Function1[PageTransitionEvent, _] = js.native
          
          var onpause: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onplay: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onplaying: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onpointercancel: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerdown: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerenter: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerleave: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointermove: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerout: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerover: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpointerup: js.Function1[org.scalajs.dom.raw.PointerEvent, _] = js.native
          
          var onpopstate: js.Function1[org.scalajs.dom.raw.PopStateEvent, _] = js.native
          
          var onprogress: js.Function1[js.Any, _] = js.native
          
          var onratechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onreadystatechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onreset: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onresize: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onscroll: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onseeked: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onseeking: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onselect: js.Function1[org.scalajs.dom.raw.UIEvent, _] = js.native
          
          var onstalled: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onstorage: js.Function1[org.scalajs.dom.raw.StorageEvent, _] = js.native
          
          var onsubmit: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onsuspend: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var ontimeupdate: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onunload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onvolumechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onwaiting: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          def open(url: String, target: String, features: String, replace: Boolean): org.scalajs.dom.raw.Window = js.native
          
          var opener: org.scalajs.dom.raw.Window = js.native
          
          def outerHeight(): Int = js.native
          
          def outerWidth(): Int = js.native
          
          def pageXOffset(): Double = js.native
          
          def pageYOffset(): Double = js.native
          
          def parent(): org.scalajs.dom.raw.Window = js.native
          
          def performance(): org.scalajs.dom.raw.Performance = js.native
          
          def postMessage(message: js.Any, targetOrigin: String, transfer: js.Any): Unit = js.native
          
          def print(): Unit = js.native
          
          def prompt(): String = js.native
          def prompt(message: String, default: String): String = js.native
          
          def requestAnimationFrame(callback: js.Function1[Double, _]): Int = js.native
          
          def screen(): org.scalajs.dom.raw.Screen = js.native
          
          var screenX: Int = js.native
          
          def screenY(): Int = js.native
          
          def scroll(x: Int, y: Int): Unit = js.native
          
          def scrollBy(x: Int, y: Int): Unit = js.native
          
          def scrollTo(x: Int, y: Int): Unit = js.native
          
          def self(): org.scalajs.dom.raw.Window = js.native
          
          def showModalDialog(url: String, argument: js.Any, options: js.Any): js.Dynamic = js.native
          
          def styleMedia(): org.scalajs.dom.raw.StyleMedia = js.native
          
          def top(): org.scalajs.dom.raw.Window = js.native
          
          def window(): org.scalajs.dom.raw.Window = js.native
        }
        
        @js.native
        trait WindowBase64 extends StObject {
          
          def atob(encodedString: String): String = js.native
          
          def btoa(rawString: String): String = js.native
        }
        
        @js.native
        trait WindowConsole extends StObject {
          
          var console: org.scalajs.dom.raw.Console = js.native
        }
        
        @js.native
        trait WindowLocalStorage extends StObject {
          
          def localStorage(): org.scalajs.dom.raw.Storage = js.native
        }
        
        @js.native
        trait WindowSessionStorage extends StObject {
          
          def sessionStorage(): org.scalajs.dom.raw.Storage = js.native
        }
        
        @js.native
        trait WindowTimers extends StObject {
          
          def clearInterval(handle: Int): Unit = js.native
          
          def clearTimeout(handle: Int): Unit = js.native
          
          def setInterval(handler: js.Function0[Any], timeout: Double): Int = js.native
          
          def setTimeout(handler: js.Function0[Any], timeout: Double): Int = js.native
        }
        
        @js.native
        class Worker protected ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget
             with org.scalajs.dom.raw.AbstractWorker {
          def this(stringUrl: String) = this()
          
          var onmessage: js.Function1[org.scalajs.dom.raw.MessageEvent, _] = js.native
          
          def postMessage(aMessage: js.Any, transferList: js.UndefOr[js.Array[org.scalajs.dom.raw.Transferable]]): Unit = js.native
          
          val stringUrl: String = js.native
          
          def terminate(): Unit = js.native
        }
        
        @js.native
        trait WorkerGlobalScope
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def caches(): js.Any = js.native
          
          def close(): Unit = js.native
          
          def importScripts(urls: js.Array[String]): Unit = js.native
          
          def location(): WorkerLocation = js.native
          
          def navigator(): WorkerNavigator = js.native
          
          var onError: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
          
          var onlanguagechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onoffline: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var ononline: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          def self(): this.type = js.native
        }
        
        @js.native
        trait WorkerLocation extends StObject {
          
          def hash(): String = js.native
          
          def host(): String = js.native
          
          def hostname(): String = js.native
          
          def href(): String = js.native
          
          def origin(): String = js.native
          
          def pathname(): String = js.native
          
          def port(): String = js.native
          
          def protocol(): String = js.native
          
          def search(): String = js.native
        }
        
        @js.native
        trait WorkerNavigator
          extends StObject
             with org.scalajs.dom.raw.NavigatorID
             with org.scalajs.dom.raw.NavigatorOnLine
             with org.scalajs.dom.raw.NavigatorLanguage
        
        @js.native
        class XMLHttpRequest ()
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          def abort(): Unit = js.native
          
          def create(): org.scalajs.dom.raw.XMLHttpRequest = js.native
          
          def getAllResponseHeaders(): String = js.native
          
          def getResponseHeader(header: String): String = js.native
          
          var onabort: js.Function1[js.Any, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
          
          var onload: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var onloadend: js.Function1[org.scalajs.dom.raw.ProgressEvent, _] = js.native
          
          var onloadstart: js.Function1[js.Any, _] = js.native
          
          var onprogress: js.Function1[org.scalajs.dom.raw.ProgressEvent, _] = js.native
          
          var onreadystatechange: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          var ontimeout: js.Function1[org.scalajs.dom.raw.Event, _] = js.native
          
          def open(method: String, url: String, async: Boolean, user: String, password: String): Unit = js.native
          
          def readyState(): Int = js.native
          
          def response(): js.Any = js.native
          
          def responseText(): String = js.native
          
          var responseType: String = js.native
          
          def responseURL(): js.UndefOr[String] = js.native
          
          def responseXML(): org.scalajs.dom.raw.Document = js.native
          
          def send(data: js.Any): Unit = js.native
          
          def setRequestHeader(header: String, value: String): Unit = js.native
          
          def status(): Int = js.native
          
          def statusText(): String = js.native
          
          var timeout: Double = js.native
          
          var upload: org.scalajs.dom.raw.XMLHttpRequestEventTarget = js.native
          
          var withCredentials: Boolean = js.native
        }
        @js.native
        object XMLHttpRequest extends StObject {
          
          var DONE: Int = js.native
          
          var HEADERS_RECEIVED: Int = js.native
          
          var LOADING: Int = js.native
          
          var OPENED: Int = js.native
          
          var UNSENT: Int = js.native
        }
        
        @js.native
        trait XMLHttpRequestEventTarget
          extends StObject
             with org.scalajs.dom.raw.EventTarget {
          
          var onabort: js.Function1[js.Any, _] = js.native
          
          var onerror: js.Function1[org.scalajs.dom.raw.ErrorEvent, _] = js.native
          
          var onload: js.Function1[js.Any, _] = js.native
          
          var onloadend: js.Function1[org.scalajs.dom.raw.ProgressEvent, _] = js.native
          
          var onloadstart: js.Function1[js.Any, _] = js.native
          
          var onprogress: js.Function1[org.scalajs.dom.raw.ProgressEvent, _] = js.native
          
          var ontimeout: js.Function1[js.Any, _] = js.native
        }
        
        @js.native
        class XMLSerializer () extends StObject {
          
          def serializeToString(target: org.scalajs.dom.raw.Node): String = js.native
        }
        
        @js.native
        class XPathNSResolver () extends StObject {
          
          def lookupNamespaceURI(prefix: String): String = js.native
        }
        
        @js.native
        class XPathResult () extends StObject {
          
          def booleanValue(): Boolean = js.native
          
          def invalidIteratorState(): Boolean = js.native
          
          def iterateNext(): org.scalajs.dom.raw.Node = js.native
          
          def numberValue(): Double = js.native
          
          def resultType(): Int = js.native
          
          def singleNodeValue(): org.scalajs.dom.raw.Node = js.native
          
          def snapshotItem(index: Int): org.scalajs.dom.raw.Node = js.native
          
          def snapshotLength(): Int = js.native
          
          def stringValue(): String = js.native
        }
        @js.native
        object XPathResult extends StObject {
          
          val ANY_TYPE: Int = js.native
          
          val ANY_UNORDERED_NODE_TYPE: Int = js.native
          
          val BOOLEAN_TYPE: Int = js.native
          
          val FIRST_ORDERED_NODE_TYPE: Int = js.native
          
          val NUMBER_TYPE: Int = js.native
          
          val ORDERED_NODE_ITERATOR_TYPE: Int = js.native
          
          val ORDERED_NODE_SNAPSHOT_TYPE: Int = js.native
          
          val STRING_TYPE: Int = js.native
          
          val UNORDERED_NODE_ITERATOR_TYPE: Int = js.native
          
          val UNORDERED_NODE_SNAPSHOT_TYPE: Int = js.native
        }
      }
      
      object svg {
        
        type A = SVGAElement
        
        type Angle = SVGAngle
        
        type AnimatedAngle = SVGAnimatedAngle
        
        type AnimatedBoolean = SVGAnimatedBoolean
        
        type AnimatedEnumeration = SVGAnimatedEnumeration
        
        type AnimatedInteger = SVGAnimatedInteger
        
        type AnimatedLength = SVGAnimatedLength
        
        type AnimatedLengthList = SVGAnimatedLengthList
        
        type AnimatedNumber = SVGAnimatedNumber
        
        type AnimatedNumberList = SVGAnimatedNumberList
        
        type AnimatedPathData = SVGAnimatedPathData
        
        type AnimatedPoints = SVGAnimatedPoints
        
        type AnimatedPreserveAspectRatio = SVGAnimatedPreserveAspectRatio
        
        type AnimatedRect = SVGAnimatedRect
        
        type AnimatedString = SVGAnimatedString
        
        type AnimatedTransformList = SVGAnimatedTransformList
        
        type Circle = SVGCircleElement
        
        type ClipPath = SVGClipPathElement
        
        type ComponentTransferFunction = SVGComponentTransferFunctionElement
        
        type Defs = SVGDefsElement
        
        type Desc = SVGDescElement
        
        type Element = SVGElement
        
        type ElementInstance = SVGElementInstance
        
        type ElementInstanceList = SVGElementInstanceList
        
        type Ellipse = SVGEllipseElement
        
        type Exception = SVGException
        
        type ExternalResourcesRequired = SVGExternalResourcesRequired
        
        type FEBlend = SVGFEBlendElement
        
        type FEColorMatrix = SVGFEColorMatrixElement
        
        type FEComponentTransfer = SVGFEComponentTransferElement
        
        type FEComposite = SVGFECompositeElement
        
        type FEConvolveMatrix = SVGFEConvolveMatrixElement
        
        type FEDiffuseLighting = SVGFEDiffuseLightingElement
        
        type FEDisplacementMap = SVGFEDisplacementMapElement
        
        type FEDistantLight = SVGFEDistantLightElement
        
        type FEFlood = SVGFEFloodElement
        
        type FEFuncA = SVGFEFuncAElement
        
        type FEFuncB = SVGFEFuncBElement
        
        type FEFuncG = SVGFEFuncGElement
        
        type FEFuncR = SVGFEFuncRElement
        
        type FEGaussianBlur = SVGFEGaussianBlurElement
        
        type FEImage = SVGFEImageElement
        
        type FEMerge = SVGFEMergeElement
        
        type FEMergeNode = SVGFEMergeNodeElement
        
        type FEMorphology = SVGFEMorphologyElement
        
        type FEOffset = SVGFEOffsetElement
        
        type FEPointLight = SVGFEPointLightElement
        
        type FESpecularLighting = SVGFESpecularLightingElement
        
        type FESpotLight = SVGFESpotLightElement
        
        type FETile = SVGFETileElement
        
        type FETurbulence = SVGFETurbulenceElement
        
        type Filter = SVGFilterElement
        
        type FilterPrimitiveStandardAttributes = SVGFilterPrimitiveStandardAttributes
        
        type FitToViewBox = SVGFitToViewBox
        
        type G = SVGGElement
        
        type GetSVGDocument = org.scalajs.dom.raw.GetSVGDocument
        
        type Gradient = SVGGradientElement
        
        type Image = SVGImageElement
        
        type LangSpace = SVGLangSpace
        
        type Length = SVGLength
        
        type LengthList = SVGLengthList
        
        type Line = SVGLineElement
        
        type LinearGradient = SVGLinearGradientElement
        
        type Locatable = SVGLocatable
        
        type Marker = SVGMarkerElement
        
        type Mask = SVGMaskElement
        
        type Matrix = SVGMatrix
        
        type Metadata = SVGMetadataElement
        
        type Number = SVGNumber
        
        type NumberList = SVGNumberList
        
        type Path = SVGPathElement
        
        type PathSeg = SVGPathSeg
        
        type PathSegArcAbs = SVGPathSegArcAbs
        
        type PathSegArcRel = SVGPathSegArcRel
        
        type PathSegClosePath = SVGPathSegClosePath
        
        type PathSegCurvetoCubicAbs = SVGPathSegCurvetoCubicAbs
        
        type PathSegCurvetoCubicRel = SVGPathSegCurvetoCubicRel
        
        type PathSegCurvetoCubicSmoothAbs = SVGPathSegCurvetoCubicSmoothAbs
        
        type PathSegCurvetoCubicSmoothRel = SVGPathSegCurvetoCubicSmoothRel
        
        type PathSegCurvetoQuadraticAbs = SVGPathSegCurvetoQuadraticAbs
        
        type PathSegCurvetoQuadraticRel = SVGPathSegCurvetoQuadraticRel
        
        type PathSegCurvetoQuadraticSmoothAbs = SVGPathSegCurvetoQuadraticSmoothAbs
        
        type PathSegCurvetoQuadraticSmoothRel = SVGPathSegCurvetoQuadraticSmoothRel
        
        type PathSegLinetoAbs = SVGPathSegLinetoAbs
        
        type PathSegLinetoHorizontalAbs = SVGPathSegLinetoHorizontalAbs
        
        type PathSegLinetoHorizontalRel = SVGPathSegLinetoHorizontalRel
        
        type PathSegLinetoRel = SVGPathSegLinetoRel
        
        type PathSegLinetoVerticalAbs = SVGPathSegLinetoVerticalAbs
        
        type PathSegLinetoVerticalRel = SVGPathSegLinetoVerticalRel
        
        type PathSegList = SVGPathSegList
        
        type PathSegMovetoAbs = SVGPathSegMovetoAbs
        
        type PathSegMovetoRel = SVGPathSegMovetoRel
        
        type Pattern = SVGPatternElement
        
        type Point = SVGPoint
        
        type PointList = SVGPointList
        
        type Polygon = SVGPolygonElement
        
        type Polyline = SVGPolylineElement
        
        type PreserveAspectRatio = SVGPreserveAspectRatio
        
        type RadialGradient = SVGRadialGradientElement
        
        type Rect = SVGRect
        
        type RectElement = SVGRectElement
        
        type SVG = SVGSVGElement
        
        type Script = SVGScriptElement
        
        type Stop = SVGStopElement
        
        type StringList = SVGStringList
        
        type Stylable = SVGStylable
        
        type Style = SVGStyleElement
        
        type Switch = SVGSwitchElement
        
        type Symbol = SVGSymbolElement
        
        type TSpan = SVGTSpanElement
        
        type Tests = SVGTests
        
        type Text = SVGTextElement
        
        type TextContent = SVGTextContentElement
        
        type TextPath = SVGTextPathElement
        
        type TextPositioning = SVGTextPositioningElement
        
        type Title = SVGTitleElement
        
        type Transform = SVGTransform
        
        type TransformList = SVGTransformList
        
        type Transformable = SVGTransformable
        
        type URIReference = SVGURIReference
        
        type UnitTypes = SVGUnitTypes
        
        type Use = SVGUseElement
        
        type View = SVGViewElement
        
        type ZoomAndPan = SVGZoomAndPan
      }
      
      object webgl {
        
        type ActiveInfo = WebGLActiveInfo
        
        type Buffer = WebGLBuffer
        
        type ContextAttributes = WebGLContextAttributes
        
        type Framebuffer = WebGLFramebuffer
        
        type Program = WebGLProgram
        
        type Renderbuffer = WebGLRenderbuffer
        
        type RenderingContext = WebGLRenderingContext
        
        type Shader = WebGLShader
        
        type ShaderPrecisionFormat = WebGLShaderPrecisionFormat
        
        type Texture = WebGLTexture
        
        type UniformLocation = WebGLUniformLocation
      }
      
      object webworkers {
        
        type AbstractWorker = org.scalajs.dom.raw.AbstractWorker
        
        @js.native
        object DedicatedWorkerGlobalScope extends StObject {
          
          def self(): DedicatedWorkerGlobalScope = js.native
        }
        type DedicatedWorkerGlobalScope = org.scalajs.dom.raw.DedicatedWorkerGlobalScope
        
        type Worker = org.scalajs.dom.raw.Worker
        
        type WorkerGlobalScope = org.scalajs.dom.raw.WorkerGlobalScope
        
        type WorkerLocation = org.scalajs.dom.raw.WorkerLocation
        
        type WorkerNavigator = org.scalajs.dom.raw.WorkerNavigator
      }
    }
  }
}

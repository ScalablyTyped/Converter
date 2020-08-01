/// <reference no-default-lib="true"/>

declare interface Array<T> {}
declare interface Function {}

interface Event { }
interface AnimationEvent extends Event { }
interface ClipboardEvent extends Event { }
interface CompositionEvent extends Event { }
interface DragEvent extends Event { }
interface FocusEvent extends Event { }
interface KeyboardEvent extends Event { }
interface MouseEvent extends Event { }
interface TouchEvent extends Event { }
interface PointerEvent extends Event { }
interface TransitionEvent extends Event { }
interface UIEvent extends Event { }
interface WheelEvent extends Event { }

interface EventTarget { }
interface Document { }
interface DataTransfer { }
interface StyleMedia { }

interface Element { }

interface HTMLElement extends Element { }
interface HTMLAnchorElement extends HTMLElement { }
interface HTMLAreaElement extends HTMLElement { }
interface HTMLAudioElement extends HTMLElement { }
interface HTMLBaseElement extends HTMLElement { }
interface HTMLBodyElement extends HTMLElement { }
interface HTMLBRElement extends HTMLElement { }
interface HTMLButtonElement extends HTMLElement { }
interface HTMLCanvasElement extends HTMLElement { }
interface HTMLDataElement extends HTMLElement { }
interface HTMLDataListElement extends HTMLElement { }
interface HTMLDialogElement extends HTMLElement { }
interface HTMLDivElement extends HTMLElement { }
interface HTMLDListElement extends HTMLElement { }
interface HTMLEmbedElement extends HTMLElement { }
interface HTMLFieldSetElement extends HTMLElement { }
interface HTMLFormElement extends HTMLElement { }
interface HTMLHeadingElement extends HTMLElement { }
interface HTMLHeadElement extends HTMLElement { }
interface HTMLHRElement extends HTMLElement { }
interface HTMLHtmlElement extends HTMLElement { }
interface HTMLIFrameElement extends HTMLElement { }
interface HTMLImageElement extends HTMLElement { }
interface HTMLInputElement extends HTMLElement { }
interface HTMLModElement extends HTMLElement { }
interface HTMLLabelElement extends HTMLElement { }
interface HTMLLegendElement extends HTMLElement { }
interface HTMLLIElement extends HTMLElement { }
interface HTMLLinkElement extends HTMLElement { }
interface HTMLMapElement extends HTMLElement { }
interface HTMLMetaElement extends HTMLElement { }
interface HTMLObjectElement extends HTMLElement { }
interface HTMLOListElement extends HTMLElement { }
interface HTMLOptGroupElement extends HTMLElement { }
interface HTMLOptionElement extends HTMLElement { }
interface HTMLParagraphElement extends HTMLElement { }
interface HTMLParamElement extends HTMLElement { }
interface HTMLPreElement extends HTMLElement { }
interface HTMLProgressElement extends HTMLElement { }
interface HTMLQuoteElement extends HTMLElement { }
interface HTMLScriptElement extends HTMLElement { }
interface HTMLSelectElement extends HTMLElement { }
interface HTMLSourceElement extends HTMLElement { }
interface HTMLSpanElement extends HTMLElement { }
interface HTMLStyleElement extends HTMLElement { }
interface HTMLTableElement extends HTMLElement { }
interface HTMLTableColElement extends HTMLElement { }
interface HTMLTableDataCellElement extends HTMLElement { }
interface HTMLTableHeaderCellElement extends HTMLElement { }
interface HTMLTableRowElement extends HTMLElement { }
interface HTMLTableSectionElement extends HTMLElement { }
interface HTMLTemplateElement extends HTMLElement { }
interface HTMLTextAreaElement extends HTMLElement { }
interface HTMLTitleElement extends HTMLElement { }
interface HTMLTrackElement extends HTMLElement { }
interface HTMLUListElement extends HTMLElement { }
interface HTMLVideoElement extends HTMLElement { }
interface HTMLWebViewElement extends HTMLElement { }

interface SVGElement extends Element { }
interface SVGSVGElement extends SVGElement { }
interface SVGCircleElement extends SVGElement { }
interface SVGClipPathElement extends SVGElement { }
interface SVGDefsElement extends SVGElement { }
interface SVGDescElement extends SVGElement { }
interface SVGEllipseElement extends SVGElement { }
interface SVGFEBlendElement extends SVGElement { }
interface SVGFEColorMatrixElement extends SVGElement { }
interface SVGFEComponentTransferElement extends SVGElement { }
interface SVGFECompositeElement extends SVGElement { }
interface SVGFEConvolveMatrixElement extends SVGElement { }
interface SVGFEDiffuseLightingElement extends SVGElement { }
interface SVGFEDisplacementMapElement extends SVGElement { }
interface SVGFEDistantLightElement extends SVGElement { }
interface SVGFEDropShadowElement extends SVGElement { }
interface SVGFEFloodElement extends SVGElement { }
interface SVGFEFuncAElement extends SVGElement { }
interface SVGFEFuncBElement extends SVGElement { }
interface SVGFEFuncGElement extends SVGElement { }
interface SVGFEFuncRElement extends SVGElement { }
interface SVGFEGaussianBlurElement extends SVGElement { }
interface SVGFEImageElement extends SVGElement { }
interface SVGFEMergeElement extends SVGElement { }
interface SVGFEMergeNodeElement extends SVGElement { }
interface SVGFEMorphologyElement extends SVGElement { }
interface SVGFEOffsetElement extends SVGElement { }
interface SVGFEPointLightElement extends SVGElement { }
interface SVGFESpecularLightingElement extends SVGElement { }
interface SVGFESpotLightElement extends SVGElement { }
interface SVGFETileElement extends SVGElement { }
interface SVGFETurbulenceElement extends SVGElement { }
interface SVGFilterElement extends SVGElement { }
interface SVGForeignObjectElement extends SVGElement { }
interface SVGGElement extends SVGElement { }
interface SVGImageElement extends SVGElement { }
interface SVGLineElement extends SVGElement { }
interface SVGLinearGradientElement extends SVGElement { }
interface SVGMarkerElement extends SVGElement { }
interface SVGMaskElement extends SVGElement { }
interface SVGMetadataElement extends SVGElement { }
interface SVGPathElement extends SVGElement { }
interface SVGPatternElement extends SVGElement { }
interface SVGPolygonElement extends SVGElement { }
interface SVGPolylineElement extends SVGElement { }
interface SVGRadialGradientElement extends SVGElement { }
interface SVGRectElement extends SVGElement { }
interface SVGStopElement extends SVGElement { }
interface SVGSwitchElement extends SVGElement { }
interface SVGSymbolElement extends SVGElement { }
interface SVGTextElement extends SVGElement { }
interface SVGTextPathElement extends SVGElement { }
interface SVGTSpanElement extends SVGElement { }
interface SVGUseElement extends SVGElement { }
interface SVGViewElement extends SVGElement { }

/**
 * Make all properties in T optional
 */
type Partial<T> = {
    [P in keyof T]?: T[P];
};

/**
 * Make all properties in T readonly
 */
type Readonly<T> = {
    readonly [P in keyof T]: T[P];
};

/**
 * From T pick a set of properties K
 */
type Pick<T, K extends keyof T> = {
    [P in K]: T[P];
};

/**
 * Construct a type with a set of properties K of type T
 */
type Record<K extends keyof any, T> = {
    [P in K]: T;
};


interface HTMLElementTagNameMap {
    "a": HTMLAnchorElement;
    "abbr": HTMLElement;
    "address": HTMLElement;
    "area": HTMLAreaElement;
    "article": HTMLElement;
    "aside": HTMLElement;
    "audio": HTMLAudioElement;
    "b": HTMLElement;
    "base": HTMLBaseElement;
    "bdi": HTMLElement;
    "bdo": HTMLElement;
    "blockquote": HTMLQuoteElement;
    "body": HTMLBodyElement;
    "br": HTMLBRElement;
    "button": HTMLButtonElement;
    "canvas": HTMLCanvasElement;
    "cite": HTMLElement;
    "code": HTMLElement;
    "col": HTMLTableColElement;
    "colgroup": HTMLTableColElement;
    "data": HTMLDataElement;
    "datalist": HTMLDataListElement;
    "dd": HTMLElement;
    "del": HTMLModElement;
    "dfn": HTMLElement;
    "dialog": HTMLDialogElement;
    "div": HTMLDivElement;
    "dl": HTMLDListElement;
    "dt": HTMLElement;
    "em": HTMLElement;
    "embed": HTMLEmbedElement;
    "fieldset": HTMLFieldSetElement;
    "figcaption": HTMLElement;
    "figure": HTMLElement;
    "footer": HTMLElement;
    "form": HTMLFormElement;
    "h1": HTMLHeadingElement;
    "h2": HTMLHeadingElement;
    "h3": HTMLHeadingElement;
    "h4": HTMLHeadingElement;
    "h5": HTMLHeadingElement;
    "h6": HTMLHeadingElement;
    "head": HTMLHeadElement;
    "header": HTMLElement;
    "hgroup": HTMLElement;
    "hr": HTMLHRElement;
    "html": HTMLHtmlElement;
    "i": HTMLElement;
    "iframe": HTMLIFrameElement;
    "img": HTMLImageElement;
    "input": HTMLInputElement;
    "ins": HTMLModElement;
    "kbd": HTMLElement;
    "label": HTMLLabelElement;
    "legend": HTMLLegendElement;
    "li": HTMLLIElement;
    "link": HTMLLinkElement;
    "main": HTMLElement;
    "map": HTMLMapElement;
    "mark": HTMLElement;
    "meta": HTMLMetaElement;
    "nav": HTMLElement;
    "noscript": HTMLElement;
    "object": HTMLObjectElement;
    "ol": HTMLOListElement;
    "optgroup": HTMLOptGroupElement;
    "option": HTMLOptionElement;
    "p": HTMLParagraphElement;
    "param": HTMLParamElement;
    "pre": HTMLPreElement;
    "progress": HTMLProgressElement;
    "q": HTMLQuoteElement;
    "rp": HTMLElement;
    "rt": HTMLElement;
    "ruby": HTMLElement;
    "s": HTMLElement;
    "samp": HTMLElement;
    "script": HTMLScriptElement;
    "section": HTMLElement;
    "select": HTMLSelectElement;
    "small": HTMLElement;
    "source": HTMLSourceElement;
    "span": HTMLSpanElement;
    "strong": HTMLElement;
    "style": HTMLStyleElement;
    "sub": HTMLElement;
    "summary": HTMLElement;
    "sup": HTMLElement;
    "table": HTMLTableElement;
    "tbody": HTMLTableSectionElement;
    "td": HTMLTableDataCellElement;
    "template": HTMLTemplateElement;
    "textarea": HTMLTextAreaElement;
    "tfoot": HTMLTableSectionElement;
    "th": HTMLTableHeaderCellElement;
    "thead": HTMLTableSectionElement;
    "title": HTMLTitleElement;
    "tr": HTMLTableRowElement;
    "track": HTMLTrackElement;
    "u": HTMLElement;
    "ul": HTMLUListElement;
    "var": HTMLElement;
    "video": HTMLVideoElement;
    "wbr": HTMLElement;
}

interface SVGElementTagNameMap {
    "circle": SVGCircleElement;
    "clipPath": SVGClipPathElement;
    "defs": SVGDefsElement;
}

/**
 * Exclude from T those types that are assignable to U
 */
type Exclude<T, U> = T extends U ? never : T;

type Omit<T, K extends keyof any> = Pick<T, Exclude<keyof T, K>>;

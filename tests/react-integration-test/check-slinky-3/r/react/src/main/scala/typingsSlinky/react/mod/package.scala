package typingsSlinky.react.mod

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import org.scalajs.dom.Element
import org.scalajs.dom.Event
import org.scalajs.dom.EventTarget
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.HTMLInputElement
import org.scalajs.dom.SVGElement
import slinky.core.ReactComponentClass
import slinky.core.facade.ReactRef
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
import typingsSlinky.react.mod.^
import typingsSlinky.react.reactBooleans.`true`
import typingsSlinky.react.reactStrings.a_
import typingsSlinky.react.reactStrings.abbr
import typingsSlinky.react.reactStrings.address
import typingsSlinky.react.reactStrings.area
import typingsSlinky.react.reactStrings.article
import typingsSlinky.react.reactStrings.aside
import typingsSlinky.react.reactStrings.audio
import typingsSlinky.react.reactStrings.b
import typingsSlinky.react.reactStrings.base
import typingsSlinky.react.reactStrings.bdi
import typingsSlinky.react.reactStrings.bdo
import typingsSlinky.react.reactStrings.big
import typingsSlinky.react.reactStrings.input
import typingsSlinky.react.reactStrings.mount
import typingsSlinky.react.reactStrings.update
import typingsSlinky.react.reactStrings.view
import typingsSlinky.std.Exclude
import typingsSlinky.std.Partial
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


inline def Children: ReactChildren = ^.asInstanceOf[js.Dynamic].selectDynamic("Children").asInstanceOf[ReactChildren]

inline def Fragment: ReactComponentClass[typingsSlinky.react.anon.Children] = ^.asInstanceOf[js.Dynamic].selectDynamic("Fragment").asInstanceOf[ReactComponentClass[typingsSlinky.react.anon.Children]]

inline def Profiler: ReactComponentClass[ProfilerProps] = ^.asInstanceOf[js.Dynamic].selectDynamic("Profiler").asInstanceOf[ReactComponentClass[ProfilerProps]]

inline def StrictMode: ReactComponentClass[typingsSlinky.react.anon.Children] = ^.asInstanceOf[js.Dynamic].selectDynamic("StrictMode").asInstanceOf[ReactComponentClass[typingsSlinky.react.anon.Children]]

/**
  * This feature is not yet available for server-side rendering.
  * Suspense support will be added in a later release.
  */
inline def Suspense: ReactComponentClass[SuspenseProps] = ^.asInstanceOf[js.Dynamic].selectDynamic("Suspense").asInstanceOf[ReactComponentClass[SuspenseProps]]

inline def cloneElement[P](
  element: slinky.core.facade.ReactElement,
  props: Partial[P] & Attributes,
  children: slinky.core.facade.ReactElement*
): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
inline def cloneElement[P](element: slinky.core.facade.ReactElement, props: Unit, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
// Custom components
inline def cloneElement[P](
  element: FunctionComponentElement[P],
  props: Partial[P] & Attributes,
  children: slinky.core.facade.ReactElement*
): FunctionComponentElement[P] = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[FunctionComponentElement[P]]
inline def cloneElement[P](element: FunctionComponentElement[P], props: Unit, children: slinky.core.facade.ReactElement*): FunctionComponentElement[P] = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[FunctionComponentElement[P]]
inline def cloneElement[P, T /* <: ReactComponentClass[P] */](
  element: CElement[P, T],
  props: Partial[P] & ClassAttributes[T],
  children: slinky.core.facade.ReactElement*
): CElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[CElement[P, T]]
inline def cloneElement[P, T /* <: ReactComponentClass[P] */](element: CElement[P, T], props: Unit, children: slinky.core.facade.ReactElement*): CElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[CElement[P, T]]
// ReactHTMLElement, less specific
inline def cloneElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: ReactHTMLElement[T], props: P, children: slinky.core.facade.ReactElement*): ReactHTMLElement[T] = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[ReactHTMLElement[T]]
inline def cloneElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: ReactHTMLElement[T], props: Unit, children: slinky.core.facade.ReactElement*): ReactHTMLElement[T] = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[ReactHTMLElement[T]]
// SVGElement
inline def cloneElement[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement, props: P, children: slinky.core.facade.ReactElement*): ReactSVGElement = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[ReactSVGElement]
inline def cloneElement[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](element: ReactSVGElement, props: Unit, children: slinky.core.facade.ReactElement*): ReactSVGElement = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[ReactSVGElement]

// DOM Element (has to be the last, because type checking stops at first overload that fits)
inline def cloneElement_PT[P /* <: DOMAttributes[T] */, T /* <: Element */](
  element: slinky.core.facade.ReactElement,
  props: DOMAttributes[T] & P,
  children: slinky.core.facade.ReactElement*
): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
inline def cloneElement_PT[P /* <: DOMAttributes[T] */, T /* <: Element */](element: slinky.core.facade.ReactElement, props: Unit, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]

// DOM Elements
// ReactHTMLElement
inline def cloneElement_PT_DetailedReactHTMLElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: DetailedReactHTMLElement[P, T], props: P, children: slinky.core.facade.ReactElement*): DetailedReactHTMLElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[DetailedReactHTMLElement[P, T]]
inline def cloneElement_PT_DetailedReactHTMLElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](element: DetailedReactHTMLElement[P, T], props: Unit, children: slinky.core.facade.ReactElement*): DetailedReactHTMLElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")((scala.List(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[DetailedReactHTMLElement[P, T]]

inline def createContext[T](defaultValue: T): Context[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("createContext")(defaultValue.asInstanceOf[js.Any]).asInstanceOf[Context[T]]
inline def createContext[T](defaultValue: T, calculateChangedBits: js.Function2[/* prev */ T, /* next */ T, Double]): Context[T] = (^.asInstanceOf[js.Dynamic].applyDynamic("createContext")(defaultValue.asInstanceOf[js.Any], calculateChangedBits.asInstanceOf[js.Any])).asInstanceOf[Context[T]]

inline def createElement[P /* <: js.Object */](`type`: String, props: Attributes & P, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
inline def createElement[P /* <: js.Object */](`type`: String, props: Null, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
inline def createElement[P /* <: js.Object */](`type`: String, props: Unit, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
// Custom components
inline def createElement[P /* <: js.Object */](`type`: ReactComponentClass[P], props: Attributes & P, children: slinky.core.facade.ReactElement*): FunctionComponentElement[P] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[FunctionComponentElement[P]]
inline def createElement[P /* <: js.Object */](`type`: ReactComponentClass[P], props: Null, children: slinky.core.facade.ReactElement*): FunctionComponentElement[P] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[FunctionComponentElement[P]]
inline def createElement[P /* <: js.Object */](`type`: ReactComponentClass[P], props: Unit, children: slinky.core.facade.ReactElement*): FunctionComponentElement[P] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[FunctionComponentElement[P]]
inline def createElement[P /* <: js.Object */](
  `type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]],
  props: ClassAttributes[ReactComponentClass[P]] & P,
  children: slinky.core.facade.ReactElement*
): CElement[P, ReactComponentClass[P]] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[CElement[P, ReactComponentClass[P]]]
inline def createElement[P /* <: js.Object */](
  `type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]],
  props: Null,
  children: slinky.core.facade.ReactElement*
): CElement[P, ReactComponentClass[P]] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[CElement[P, ReactComponentClass[P]]]
inline def createElement[P /* <: js.Object */](
  `type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]],
  props: Unit,
  children: slinky.core.facade.ReactElement*
): CElement[P, ReactComponentClass[P]] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[CElement[P, ReactComponentClass[P]]]
inline def createElement[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
  `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55, starting with typingsSlinky.react.reactStrings.animate, typingsSlinky.react.reactStrings.circle, typingsSlinky.react.reactStrings.clipPath */ Any,
  props: ClassAttributes[T] & P,
  children: slinky.core.facade.ReactElement*
): ReactSVGElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[ReactSVGElement]
inline def createElement[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
  `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55, starting with typingsSlinky.react.reactStrings.animate, typingsSlinky.react.reactStrings.circle, typingsSlinky.react.reactStrings.clipPath */ Any,
  props: Null,
  children: slinky.core.facade.ReactElement*
): ReactSVGElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[ReactSVGElement]
inline def createElement[P /* <: SVGAttributes[T] */, T /* <: SVGElement */](
  `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55, starting with typingsSlinky.react.reactStrings.animate, typingsSlinky.react.reactStrings.circle, typingsSlinky.react.reactStrings.clipPath */ Any,
  props: Unit,
  children: slinky.core.facade.ReactElement*
): ReactSVGElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[ReactSVGElement]

inline def createElement_PT[P /* <: DOMAttributes[T] */, T /* <: Element */](`type`: String, props: ClassAttributes[T] & P, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
inline def createElement_PT[P /* <: DOMAttributes[T] */, T /* <: Element */](`type`: String, props: Null, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
inline def createElement_PT[P /* <: DOMAttributes[T] */, T /* <: Element */](`type`: String, props: Unit, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]

inline def createElement_PTC_CElement[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](
  `type`: ClassType[P, T, C],
  props: ClassAttributes[T] & P,
  children: slinky.core.facade.ReactElement*
): CElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[CElement[P, T]]
inline def createElement_PTC_CElement[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C], props: Null, children: slinky.core.facade.ReactElement*): CElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[CElement[P, T]]
inline def createElement_PTC_CElement[P /* <: js.Object */, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C], props: Unit, children: slinky.core.facade.ReactElement*): CElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[CElement[P, T]]

inline def createElement_PT_DetailedReactHTMLElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
  `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115, starting with typingsSlinky.react.reactStrings.a_, typingsSlinky.react.reactStrings.abbr, typingsSlinky.react.reactStrings.address */ Any,
  props: ClassAttributes[T] & P,
  children: slinky.core.facade.ReactElement*
): DetailedReactHTMLElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[DetailedReactHTMLElement[P, T]]
inline def createElement_PT_DetailedReactHTMLElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
  `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115, starting with typingsSlinky.react.reactStrings.a_, typingsSlinky.react.reactStrings.abbr, typingsSlinky.react.reactStrings.address */ Any,
  props: Null,
  children: slinky.core.facade.ReactElement*
): DetailedReactHTMLElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[DetailedReactHTMLElement[P, T]]
inline def createElement_PT_DetailedReactHTMLElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */](
  `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115, starting with typingsSlinky.react.reactStrings.a_, typingsSlinky.react.reactStrings.abbr, typingsSlinky.react.reactStrings.address */ Any,
  props: Unit,
  children: slinky.core.facade.ReactElement*
): DetailedReactHTMLElement[P, T] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[DetailedReactHTMLElement[P, T]]

inline def createElement_P_ReactElement[P /* <: js.Object */](`type`: ReactComponentClass[P], props: Attributes & P, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
inline def createElement_P_ReactElement[P /* <: js.Object */](`type`: ReactComponentClass[P], props: Null, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]
inline def createElement_P_ReactElement[P /* <: js.Object */](`type`: ReactComponentClass[P], props: Unit, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[slinky.core.facade.ReactElement]

// DOM Elements
// TODO: generalize this to everything in `keyof ReactHTML`, not just "input"
inline def createElement_input(
  `type`: input,
  props: InputHTMLAttributes[HTMLInputElement] & ClassAttributes[HTMLInputElement],
  children: slinky.core.facade.ReactElement*
): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement]]
inline def createElement_input(`type`: input, props: Null, children: slinky.core.facade.ReactElement*): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement]]
inline def createElement_input(`type`: input, props: Unit, children: slinky.core.facade.ReactElement*): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = (^.asInstanceOf[js.Dynamic].applyDynamic("createElement")((scala.List(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any])).`++`(children.asInstanceOf[Seq[js.Any]])*)).asInstanceOf[DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement]]

inline def createFactory(
  `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55, starting with typingsSlinky.react.reactStrings.animate, typingsSlinky.react.reactStrings.circle, typingsSlinky.react.reactStrings.clipPath */ Any
): SVGFactory = ^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[SVGFactory]
// Custom components
inline def createFactory[P](`type`: ReactComponentClass[P]): FunctionComponentFactory[P] = ^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[FunctionComponentFactory[P]]
inline def createFactory[P](`type`: ClassType[P, ReactComponentClass[P], ReactComponentClass[P]]): CFactory[P, ReactComponentClass[P]] = ^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[CFactory[P, ReactComponentClass[P]]]
inline def createFactory[P /* <: DOMAttributes[T] */, T /* <: Element */](`type`: String): DOMFactory[P, T] = ^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[DOMFactory[P, T]]

inline def createFactory_PTC_CFactory[P, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */](`type`: ClassType[P, T, C]): CFactory[P, T] = ^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[CFactory[P, T]]

inline def createFactory_P_Factory[P](`type`: ReactComponentClass[P]): Factory[P] = ^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[Factory[P]]

//
// Top Level API
// ----------------------------------------------------------------------
// DOM Elements
inline def createFactory_T_HTMLFactory[T /* <: HTMLElement */](
  `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115, starting with typingsSlinky.react.reactStrings.a_, typingsSlinky.react.reactStrings.abbr, typingsSlinky.react.reactStrings.address */ Any
): HTMLFactory[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[HTMLFactory[T]]

inline def createRef[T](): ReactRef[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("createRef")().asInstanceOf[ReactRef[T]]

inline def forwardRef[T, P](Component: RefForwardingComponent[T, P]): ReactComponentClass[PropsWithoutRef[P] & RefAttributes[T]] = ^.asInstanceOf[js.Dynamic].applyDynamic("forwardRef")(Component.asInstanceOf[js.Any]).asInstanceOf[ReactComponentClass[PropsWithoutRef[P] & RefAttributes[T]]]

inline def isValidElement[P](): /* is react.react.ReactElement */ Boolean = ^.asInstanceOf[js.Dynamic].applyDynamic("isValidElement")().asInstanceOf[/* is react.react.ReactElement */ Boolean]
inline def isValidElement[P](`object`: js.Object): /* is react.react.ReactElement */ Boolean = ^.asInstanceOf[js.Dynamic].applyDynamic("isValidElement")(`object`.asInstanceOf[js.Any]).asInstanceOf[/* is react.react.ReactElement */ Boolean]

inline def `lazy`[T /* <: ReactComponentClass[Any] */](
  factory: js.Function0[
  /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<{  default :T}> */ Any
]
): ReactComponentClass[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("lazy")(factory.asInstanceOf[js.Any]).asInstanceOf[ReactComponentClass[T]]

inline def memo[T /* <: ReactComponentClass[Any] */](Component: T): ReactComponentClass[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any]).asInstanceOf[ReactComponentClass[T]]
inline def memo[T /* <: ReactComponentClass[Any] */](
  Component: T,
  propsAreEqual: js.Function2[/* prevProps */ ComponentProps[T], /* nextProps */ ComponentProps[T], Boolean]
): ReactComponentClass[T] = (^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any], propsAreEqual.asInstanceOf[js.Any])).asInstanceOf[ReactComponentClass[T]]
inline def memo[P /* <: js.Object */](Component: ReactComponentClass[P]): ReactComponentClass[P] = ^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any]).asInstanceOf[ReactComponentClass[P]]
inline def memo[P /* <: js.Object */](
  Component: ReactComponentClass[P],
  propsAreEqual: js.Function2[/* prevProps */ PropsWithChildren[P], /* nextProps */ PropsWithChildren[P], Boolean]
): ReactComponentClass[P] = (^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any], propsAreEqual.asInstanceOf[js.Any])).asInstanceOf[ReactComponentClass[P]]

// I made 'inputs' required here and in useMemo as there's no point to memoizing without the memoization key
// useCallback(X) is identical to just using X, useMemo(() => Y) is identical to just using Y.
/**
  * `useCallback` will return a memoized version of the callback that only changes if one of the `inputs`
  * has changed.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#usecallback
  */
// TODO (TypeScript 3.0): <T extends (...args: never[]) => unknown>
inline def useCallback[T /* <: js.Function1[/* repeated */ Any, Any] */](callback: T, deps: DependencyList): T = (^.asInstanceOf[js.Dynamic].applyDynamic("useCallback")(callback.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[T]

// This will technically work if you give a Consumer<T> or Provider<T> but it's deprecated and warns
/**
  * Accepts a context object (the value returned from `React.createContext`) and returns the current
  * context value, as given by the nearest context provider for the given context.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#usecontext
  */
inline def useContext[T](context: Context[T]): T = ^.asInstanceOf[js.Dynamic].applyDynamic("useContext")(context.asInstanceOf[js.Any]).asInstanceOf[T]

/**
  * `useDebugValue` can be used to display a label for custom hooks in React DevTools.
  *
  * NOTE: We don’t recommend adding debug values to every custom hook.
  * It’s most valuable for custom hooks that are part of shared libraries.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#usedebugvalue
  */
// the name of the custom hook is itself derived from the function name at runtime:
// it's just the function name without the "use" prefix.
inline def useDebugValue[T](value: T): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("useDebugValue")(value.asInstanceOf[js.Any]).asInstanceOf[Unit]
inline def useDebugValue[T](value: T, format: js.Function1[/* value */ T, Any]): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("useDebugValue")(value.asInstanceOf[js.Any], format.asInstanceOf[js.Any])).asInstanceOf[Unit]

/**
  * Accepts a function that contains imperative, possibly effectful code.
  *
  * @param effect Imperative function that can return a cleanup function
  * @param deps If present, effect will only activate if the values in the list change.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#useeffect
  */
inline def useEffect(effect: EffectCallback): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("useEffect")(effect.asInstanceOf[js.Any]).asInstanceOf[Unit]
inline def useEffect(effect: EffectCallback, deps: DependencyList): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("useEffect")(effect.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[Unit]

inline def useImperativeHandle[T, R /* <: T */](ref: Unit, init: js.Function0[R]): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any])).asInstanceOf[Unit]
inline def useImperativeHandle[T, R /* <: T */](ref: Unit, init: js.Function0[R], deps: DependencyList): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[Unit]
// NOTE: this does not accept strings, but this will have to be fixed by removing strings from type Ref<T>
/**
  * `useImperativeHandle` customizes the instance value that is exposed to parent components when using
  * `ref`. As always, imperative code using refs should be avoided in most cases.
  *
  * `useImperativeHandle` should be used with `React.forwardRef`.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#useimperativehandle
  */
inline def useImperativeHandle[T, R /* <: T */](ref: Ref[T], init: js.Function0[R]): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any])).asInstanceOf[Unit]
inline def useImperativeHandle[T, R /* <: T */](ref: Ref[T], init: js.Function0[R], deps: DependencyList): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[Unit]

/**
  * The signature is identical to `useEffect`, but it fires synchronously after all DOM mutations.
  * Use this to read layout from the DOM and synchronously re-render. Updates scheduled inside
  * `useLayoutEffect` will be flushed synchronously, before the browser has a chance to paint.
  *
  * Prefer the standard `useEffect` when possible to avoid blocking visual updates.
  *
  * If you’re migrating code from a class component, `useLayoutEffect` fires in the same phase as
  * `componentDidMount` and `componentDidUpdate`.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#uselayouteffect
  */
inline def useLayoutEffect(effect: EffectCallback): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("useLayoutEffect")(effect.asInstanceOf[js.Any]).asInstanceOf[Unit]
inline def useLayoutEffect(effect: EffectCallback, deps: DependencyList): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("useLayoutEffect")(effect.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[Unit]

/**
  * `useMemo` will only recompute the memoized value when one of the `deps` has changed.
  *
  * Usage note: if calling `useMemo` with a referentially stable function, also give it as the input in
  * the second argument.
  *
  * ```ts
  * function expensive () { ... }
  *
  * function Component () {
  *   const expensiveResult = useMemo(expensive, [expensive])
  *   return ...
  * }
  * ```
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#usememo
  */
// allow undefined, but don't make it optional as that is very likely a mistake
inline def useMemo[T](factory: js.Function0[T]): T = ^.asInstanceOf[js.Dynamic].applyDynamic("useMemo")(factory.asInstanceOf[js.Any]).asInstanceOf[T]
inline def useMemo[T](factory: js.Function0[T], deps: DependencyList): T = (^.asInstanceOf[js.Dynamic].applyDynamic("useMemo")(factory.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[T]

/**
  * An alternative to `useState`.
  *
  * `useReducer` is usually preferable to `useState` when you have complex state logic that involves
  * multiple sub-values. It also lets you optimize performance for components that trigger deep
  * updates because you can pass `dispatch` down instead of callbacks.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#usereducer
  */
// I'm not sure if I keep this 2-ary or if I make it (2,3)-ary; it's currently (2,3)-ary.
// The Flow types do have an overload for 3-ary invocation with undefined initializer.
// NOTE: without the ReducerState indirection, TypeScript would reduce S to be the most common
// supertype between the reducer's return type and the initialState (or the initializer's return type),
// which would prevent autocompletion from ever working.
// TODO: double-check if this weird overload logic is necessary. It is possible it's either a bug
// in older versions, or a regression in newer versions of the typescript completion service.
inline def useReducer[R /* <: Reducer[Any, Any] */](reducer: R, initialState: ReducerState[R], initializer: Unit): js.Tuple2[ReducerState[R], Dispatch[ReducerAction[R]]] = (^.asInstanceOf[js.Dynamic].applyDynamic("useReducer")(reducer.asInstanceOf[js.Any], initialState.asInstanceOf[js.Any], initializer.asInstanceOf[js.Any])).asInstanceOf[js.Tuple2[ReducerState[R], Dispatch[ReducerAction[R]]]]
/**
  * An alternative to `useState`.
  *
  * `useReducer` is usually preferable to `useState` when you have complex state logic that involves
  * multiple sub-values. It also lets you optimize performance for components that trigger deep
  * updates because you can pass `dispatch` down instead of callbacks.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#usereducer
  */
// overload where "I" may be a subset of ReducerState<R>; used to provide autocompletion.
// If "I" matches ReducerState<R> exactly then the last overload will allow initializer to be ommitted.
// the last overload effectively behaves as if the identity function (x => x) is the initializer.
// overload for free "I"; all goes as long as initializer converts it into "ReducerState<R>".
inline def useReducer[R /* <: Reducer[Any, Any] */, I](
  reducer: R,
  initializerArg: (I & ReducerState[R]) | I,
  initializer: js.Function1[(/* arg */ I & ReducerState[R]) | (/* arg */ I), ReducerState[R]]
): js.Tuple2[ReducerState[R], Dispatch[ReducerAction[R]]] = (^.asInstanceOf[js.Dynamic].applyDynamic("useReducer")(reducer.asInstanceOf[js.Any], initializerArg.asInstanceOf[js.Any], initializer.asInstanceOf[js.Any])).asInstanceOf[js.Tuple2[ReducerState[R], Dispatch[ReducerAction[R]]]]

// convenience overload for refs given as a ref prop as they typically start with a null value
/**
  * `useRef` returns a mutable ref object whose `.current` property is initialized to the passed argument
  * (`initialValue`). The returned object will persist for the full lifetime of the component.
  *
  * Note that `useRef()` is useful for more than the `ref` attribute. It’s handy for keeping any mutable
  * value around similar to how you’d use instance fields in classes.
  *
  * Usage note: if you need the result of useRef to be directly mutable, include `| null` in the type
  * of the generic argument.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#useref
  */
// TODO (TypeScript 3.0): <T extends unknown>
inline def useRef[T](): ReactRef[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("useRef")().asInstanceOf[ReactRef[T]]
inline def useRef[T](initialValue: T): ReactRef[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("useRef")(initialValue.asInstanceOf[js.Any]).asInstanceOf[ReactRef[T]]

// convenience overload for potentially undefined initialValue / call with 0 arguments
// has a default to stop it from defaulting to {} instead
/**
  * `useRef` returns a mutable ref object whose `.current` property is initialized to the passed argument
  * (`initialValue`). The returned object will persist for the full lifetime of the component.
  *
  * Note that `useRef()` is useful for more than the `ref` attribute. It’s handy for keeping any mutable
  * value around similar to how you’d use instance fields in classes.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#useref
  */
// TODO (TypeScript 3.0): <T extends unknown>
inline def useRef_T_MutableRefObject[T](): MutableRefObject[js.UndefOr[T]] = ^.asInstanceOf[js.Dynamic].applyDynamic("useRef")().asInstanceOf[MutableRefObject[js.UndefOr[T]]]
/**
  * `useRef` returns a mutable ref object whose `.current` property is initialized to the passed argument
  * (`initialValue`). The returned object will persist for the full lifetime of the component.
  *
  * Note that `useRef()` is useful for more than the `ref` attribute. It’s handy for keeping any mutable
  * value around similar to how you’d use instance fields in classes.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#useref
  */
// TODO (TypeScript 3.0): <T extends unknown>
inline def useRef_T_MutableRefObject[T](initialValue: T): MutableRefObject[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("useRef")(initialValue.asInstanceOf[js.Any]).asInstanceOf[MutableRefObject[T]]

// convenience overload when first argument is ommitted
/**
  * Returns a stateful value, and a function to update it.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#usestate
  */
inline def useState[S](): js.Tuple2[js.UndefOr[S], Dispatch[SetStateAction[js.UndefOr[S]]]] = ^.asInstanceOf[js.Dynamic].applyDynamic("useState")().asInstanceOf[js.Tuple2[js.UndefOr[S], Dispatch[SetStateAction[js.UndefOr[S]]]]]
/**
  * Returns a stateful value, and a function to update it.
  *
  * @version 16.8.0
  * @see https://reactjs.org/docs/hooks-reference.html#usestate
  */
inline def useState[S](initialState: S): js.Tuple2[S, Dispatch[SetStateAction[S]]] = ^.asInstanceOf[js.Dynamic].applyDynamic("useState")(initialState.asInstanceOf[js.Any]).asInstanceOf[js.Tuple2[S, Dispatch[SetStateAction[S]]]]
inline def useState[S](initialState: js.Function0[S]): js.Tuple2[S, Dispatch[SetStateAction[S]]] = ^.asInstanceOf[js.Dynamic].applyDynamic("useState")(initialState.asInstanceOf[js.Any]).asInstanceOf[js.Tuple2[S, Dispatch[SetStateAction[S]]]]

inline def version: String = ^.asInstanceOf[js.Dynamic].selectDynamic("version").asInstanceOf[String]

type AnimationEventHandler[T] = EventHandler[SyntheticAnimationEvent[T]]

// tslint:disable-next-line:no-empty-interface
type AudioHTMLAttributes[T] = MediaHTMLAttributes[T]

type CElement[P, T /* <: ReactComponentClass[P] */] = ComponentElement[P, T]

type CFactory[P, T /* <: ReactComponentClass[P] */] = ComponentFactory[P, T]

type ChangeEventHandler[T] = EventHandler[ChangeEvent[T]]

/**
  * We use an intersection type to infer multiple type parameters from
  * a single argument, which is useful for many top-level API defs.
  * See https://github.com/Microsoft/TypeScript/issues/7234 for more info.
  */
type ClassType[P, T /* <: ReactComponentClass[P] */, C /* <: ReactComponentClass[P] */] = C & (Instantiable2[/* props */ P, /* context */ js.UndefOr[Any], T])

type ClassicElement[P] = CElement[P, ReactComponentClass[P]]

type ClassicFactory[P] = CFactory[P, ReactComponentClass[P]]

type ClipboardEventHandler[T] = EventHandler[SyntheticClipboardEvent[T]]

/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
  * TS definition: {{{
  T extends react.react.ComponentClass<infer P, react.react.ComponentState> ? react.react.PropsWithoutRef<P> & react.react.RefAttributes</ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> * / any> : react.react.PropsWithRef<react.react.ComponentProps<T>>
  }}}
  */
type ComponentPropsWithRef[T /* <: slinky.core.facade.ReactElement */] = ComponentProps[T]

type ComponentPropsWithoutRef[T /* <: slinky.core.facade.ReactElement */] = PropsWithoutRef[ComponentProps[T]]

type ComponentState = Any

type ComponentType[P] = ReactComponentClass[P]

type CompositionEventHandler[T] = EventHandler[SyntheticCompositionEvent[T]]

type Consumer[T] = ReactComponentClass[ConsumerProps[T]]

// Any prop that has a default prop becomes optional, but its type is unchanged
// Undeclared default props are augmented into the resulting allowable attributes
// If declared props have indexed properties, ignore default props entirely as keyof gets widened
// Wrap in an outer-level conditional type to allow distribution over props that are unions
/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
  * TS definition: {{{
  P extends any ? string extends keyof P ? P : std.Pick<P, std.Exclude<keyof P, keyof D>> & std.Partial<std.Pick<P, / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Extract<keyof P, keyof D> * / any>> & std.Partial<std.Pick<D, std.Exclude<keyof D, keyof P>>> : never
  }}}
  */
type Defaultize[P, D] = P

// The identity check is done with the SameValue algorithm (Object.is), which is stricter than ===
// TODO (TypeScript 3.0): ReadonlyArray<unknown>
type DependencyList = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify ReadonlyArray<any> */ Any

type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] & E

// this technically does accept a second argument, but it's already under a deprecation warning
// and it's not even released so probably better to not define it.
type Dispatch[A] = js.Function1[/* value */ A, Unit]

type DragEventHandler[T] = EventHandler[DragEvent[T]]

// NOTE: callbacks are _only_ allowed to return either void, or a destructor.
// The destructor is itself only allowed to return void.
type EffectCallback = js.Function0[Unit | js.Function0[js.UndefOr[Unit]]]

//
// React Elements
// ----------------------------------------------------------------------
type ElementType[P] = (/* import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view' ]: P extends react.react.<global>.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view'] */ js.Any) | ReactComponentClass[P]

//
// Event Handler Types
// ----------------------------------------------------------------------
type EventHandler[E /* <: slinky.core.SyntheticEvent[Any, Event] */] = js.Function1[/* event */ E, Unit]

type ExactlyAnyPropertyKeys[T] = /* import warning: importer.ImportType#apply Failed type conversion: {[ K in keyof T ]: react.react.IsExactlyAny<T[K]> extends true? K : never}[keyof T] */ js.Any

type FC[P] = ReactComponentClass[P]

type FocusEventHandler[T] = EventHandler[SyntheticFocusEvent[T]]

// tslint:disable-next-line:no-empty-interface
type FormEvent[T] = slinky.core.SyntheticEvent[T, Event]

type FormEventHandler[T] = EventHandler[slinky.core.SyntheticEvent[EventTarget & T, Event]]

type GetDerivedStateFromError[P, S] = /**
  * This lifecycle is invoked after an error has been thrown by a descendant component.
  * It receives the error that was thrown as a parameter and should return a value to update state.
  *
  * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
  */
js.Function1[/* error */ Any, Partial[S] | Null]

type GetDerivedStateFromProps[P, S] = /**
  * Returns an update to a component's state based on its new props and old state.
  *
  * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
  */
js.Function2[/* nextProps */ P, /* prevState */ S, Partial[S] | Null]

// tslint:disable-next-line:no-empty-interface
type HTMLFactory[T /* <: HTMLElement */] = DetailedHTMLFactory[AllHTMLAttributes[T], T]

// naked 'any' type in a conditional type will short circuit and union both the then/else branches
// so boolean is only resolved for T = any
/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
  * TS definition: {{{
  boolean extends T extends never ? true : false ? true : false
  }}}
  */
type IsExactlyAny[T] = `true`

type JSXElementConstructor[P] = (js.Function1[/* props */ P, slinky.core.facade.ReactElement | Null]) | (Instantiable1[/* props */ P, ReactComponentClass[P]])

type Key = String | Double

type KeyboardEventHandler[T] = EventHandler[SyntheticKeyboardEvent[T]]

type LegacyRef[T] = String | Ref[T]

// Try to resolve ill-defined props like for JS users: props can be any, or sometimes objects with properties of type any
/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
  * TS definition: {{{
  // Distribute over P in case it is a union type
P extends any ? react.react.IsExactlyAny<P> extends true ? T : // If declared props have indexed properties, ignore inferred props entirely as keyof gets widened
string extends keyof P ? P : std.Pick<P, react.react.NotExactlyAnyPropertyKeys<P>> & std.Pick<T, std.Exclude<keyof T, react.react.NotExactlyAnyPropertyKeys<P>>> & std.Pick<P, std.Exclude<keyof P, keyof T>> : never
  }}}
  */
type MergePropTypes[P, T] = T

type MouseEventHandler[T] = EventHandler[SyntheticMouseEvent[T]]

type NativeAnimationEvent = org.scalajs.dom.AnimationEvent

type NativeClipboardEvent = org.scalajs.dom.ClipboardEvent

type NativeCompositionEvent = org.scalajs.dom.CompositionEvent

type NativeDragEvent = org.scalajs.dom.DragEvent

type NativeFocusEvent = org.scalajs.dom.FocusEvent

type NativeKeyboardEvent = org.scalajs.dom.KeyboardEvent

type NativeMouseEvent = org.scalajs.dom.MouseEvent

type NativePointerEvent = org.scalajs.dom.PointerEvent

type NativeTouchEvent = org.scalajs.dom.TouchEvent

type NativeTransitionEvent = org.scalajs.dom.TransitionEvent

type NativeUIEvent = org.scalajs.dom.UIEvent

type NativeWheelEvent = org.scalajs.dom.WheelEvent

type NotExactlyAnyPropertyKeys[T] = Exclude[/* keyof T */ String, ExactlyAnyPropertyKeys[T]]

type PointerEventHandler[T] = EventHandler[SyntheticPointerEvent[T]]

/**
  * {@link https://github.com/bvaughn/rfcs/blob/profiler/text/0000-profiler.md#detailed-design | API}
  */
type ProfilerOnRenderCallback = js.Function7[
/* id */ String, 
/* phase */ mount | update, 
/* actualDuration */ Double, 
/* baseDuration */ Double, 
/* startTime */ Double, 
/* commitTime */ Double, 
/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ Any, 
Unit]

type PropsWithChildren[P] = P & typingsSlinky.react.anon.Children

/** Ensures that the props do not include string ref, which cannot be forwarded */
/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
  * TS definition: {{{
  'ref' extends keyof P ? P extends {  ref :infer R | undefined} ? string extends R ? react.react.PropsWithoutRef<P> & {  ref :std.Exclude<R, string> | undefined} : P : P : P
  }}}
  */
type PropsWithRef[P] = P

/** Ensures that the props do not include ref at all */
/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
  * TS definition: {{{
  'ref' extends keyof P ? std.Pick<P, std.Exclude<keyof P, 'ref'>> : P
  }}}
  */
type PropsWithoutRef[P] = P

// NOTE: only the Context object itself can get a displayName
// https://github.com/facebook/react-devtools/blob/e0b854e4c/backend/attachRendererFiber.js#L310-L325
type Provider[T] = ReactComponentClass[ProviderProps[T]]

type ReactChild = slinky.core.facade.ReactElement | ReactText

type ReactComponentElement[T /* <: a_ | abbr | address | area | article | aside | audio | b | base | bdi | bdo | big | view | JSXElementConstructor[Any] */, P] = slinky.core.facade.ReactElement

type ReactEventHandler[T] = EventHandler[slinky.core.SyntheticEvent[T, Event]]

type ReactFragment = js.Object | ReactNodeArray

// ReactHTML for ReactHTMLElement
// tslint:disable-next-line:no-empty-interface
type ReactHTMLElement[T /* <: HTMLElement */] = DetailedReactHTMLElement[AllHTMLAttributes[T], T]

//
// Component API
// ----------------------------------------------------------------------
type ReactInstance = ReactComponentClass[Any] | Element

/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
  * TS definition: {{{
  C extends {  propTypes :infer T,   defaultProps :infer D} ? react.react.Defaultize<react.react.MergePropTypes<P, / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> * / any>, D> : C extends {  propTypes :infer T} ? react.react.MergePropTypes<P, / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> * / any> : C extends {  defaultProps :infer D} ? react.react.Defaultize<P, D> : P
  }}}
  */
type ReactManagedAttributes[C, P] = P

type ReactNode = js.UndefOr[ReactChild | ReactFragment | ReactPortal | Boolean]

//
// React Nodes
// http://facebook.github.io/react/docs/glossary.html
// ----------------------------------------------------------------------
type ReactText = String | Double

/**
  * @deprecated Please use `ElementType`
  */
type ReactType[P] = slinky.core.facade.ReactElement

// Unlike redux, the actions _can_ be anything
type Reducer[S, A] = js.Function2[/* prevState */ S, /* action */ A, S]

type Ref[T] = (js.Function1[/* instance */ T | Null, Unit]) | ReactRef[T] | Null

type Requireable[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<T> */ Any

//
// Class Interfaces
// ----------------------------------------------------------------------
/**
  * @deprecated as of recent React versions, function components can no
  * longer be considered 'stateless'. Please use `FunctionComponent` instead.
  *
  * @see [React Hooks](https://reactjs.org/docs/hooks-intro.html)
  */
type SFC[P] = ReactComponentClass[P]

/**
  * @deprecated Please use `FunctionComponentElement`
  */
type SFCElement[P] = FunctionComponentElement[P]

/**
  * @deprecated Please use `FunctionComponentFactory`
  */
type SFCFactory[P] = FunctionComponentFactory[P]

//
// React Hooks
// ----------------------------------------------------------------------
// based on the code in https://github.com/facebook/react/pull/13968
// Unlike the class component setState, the updates are not allowed to be partial
type SetStateAction[S] = S | (js.Function1[/* prevState */ S, S])

/**
  * @deprecated as of recent React versions, function components can no
  * longer be considered 'stateless'. Please use `FunctionComponent` instead.
  *
  * @see [React Hooks](https://reactjs.org/docs/hooks-intro.html)
  */
type StatelessComponent[P] = ReactComponentClass[P]

/**
  * currentTarget - a reference to the element on which the event listener is registered.
  *
  * target - a reference to the element from which the event was originally dispatched.
  * This might be a child element to the element on which the event listener is registered.
  * If you thought this should be `EventTarget & T`, see https://github.com/DefinitelyTyped/DefinitelyTyped/pull/12239
  */
type SyntheticEvent[T, E] = slinky.core.SyntheticEvent[EventTarget & T, E]

type TouchEventHandler[T] = EventHandler[SyntheticTouchEvent[T]]

type TransitionEventHandler[T] = EventHandler[SyntheticTransitionEvent[T]]

type UIEventHandler[T] = EventHandler[SyntheticUIEvent[T]]

type ValidationMap[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.ValidationMap<T> */ Any

//
// React.PropTypes
// ----------------------------------------------------------------------
type Validator[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<T> */ Any

type WheelEventHandler[T] = EventHandler[SyntheticWheelEvent[T]]

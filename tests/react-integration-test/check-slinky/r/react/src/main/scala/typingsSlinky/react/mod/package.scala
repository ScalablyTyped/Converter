package typingsSlinky.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

  
  @scala.inline
  def Children: typingsSlinky.react.mod.ReactChildren = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("Children").asInstanceOf[typingsSlinky.react.mod.ReactChildren]
  
  @scala.inline
  def Fragment: slinky.core.ReactComponentClass[typingsSlinky.react.anon.Children] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("Fragment").asInstanceOf[slinky.core.ReactComponentClass[typingsSlinky.react.anon.Children]]
  
  @scala.inline
  def Profiler: slinky.core.ReactComponentClass[typingsSlinky.react.mod.ProfilerProps] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("Profiler").asInstanceOf[slinky.core.ReactComponentClass[typingsSlinky.react.mod.ProfilerProps]]
  
  @scala.inline
  def StrictMode: slinky.core.ReactComponentClass[typingsSlinky.react.anon.Children] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("StrictMode").asInstanceOf[slinky.core.ReactComponentClass[typingsSlinky.react.anon.Children]]
  
  /**
    * This feature is not yet available for server-side rendering.
    * Suspense support will be added in a later release.
    */
  @scala.inline
  def Suspense: slinky.core.ReactComponentClass[typingsSlinky.react.mod.SuspenseProps] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("Suspense").asInstanceOf[slinky.core.ReactComponentClass[typingsSlinky.react.mod.SuspenseProps]]
  
  @scala.inline
  def cloneElement[P](
    element: slinky.core.facade.ReactElement,
    props: typingsSlinky.std.Partial[P] & typingsSlinky.react.mod.Attributes,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def cloneElement[P](
    element: slinky.core.facade.ReactElement,
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  // Custom components
  @scala.inline
  def cloneElement[P](
    element: typingsSlinky.react.mod.FunctionComponentElement[P],
    props: typingsSlinky.std.Partial[P] & typingsSlinky.react.mod.Attributes,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.FunctionComponentElement[P] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.FunctionComponentElement[P]]
  @scala.inline
  def cloneElement[P](
    element: typingsSlinky.react.mod.FunctionComponentElement[P],
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.FunctionComponentElement[P] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.FunctionComponentElement[P]]
  // DOM Element (has to be the last, because type checking stops at first overload that fits)
  @scala.inline
  def cloneElement[P /* <: typingsSlinky.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](
    element: slinky.core.facade.ReactElement,
    props: typingsSlinky.react.mod.DOMAttributes[T] & P,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def cloneElement[P, T /* <: slinky.core.ReactComponentClass[P] */](
    element: typingsSlinky.react.mod.CElement[P, T],
    props: typingsSlinky.std.Partial[P] & typingsSlinky.react.mod.ClassAttributes[T],
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.CElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.CElement[P, T]]
  @scala.inline
  def cloneElement[P, T /* <: slinky.core.ReactComponentClass[P] */](
    element: typingsSlinky.react.mod.CElement[P, T],
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.CElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.CElement[P, T]]
  // DOM Elements
  // ReactHTMLElement
  @scala.inline
  def cloneElement[P /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    element: typingsSlinky.react.mod.DetailedReactHTMLElement[P, T],
    props: P,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.DetailedReactHTMLElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.DetailedReactHTMLElement[P, T]]
  @scala.inline
  def cloneElement[P /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    element: typingsSlinky.react.mod.DetailedReactHTMLElement[P, T],
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.DetailedReactHTMLElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.DetailedReactHTMLElement[P, T]]
  // SVGElement
  @scala.inline
  def cloneElement[P /* <: typingsSlinky.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    element: typingsSlinky.react.mod.ReactSVGElement,
    props: P,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.ReactSVGElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.ReactSVGElement]
  @scala.inline
  def cloneElement[P /* <: typingsSlinky.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    element: typingsSlinky.react.mod.ReactSVGElement,
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.ReactSVGElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.ReactSVGElement]
  
  @scala.inline
  def cloneElement_P_DOMAttributesTT_Element[P /* <: typingsSlinky.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](
    element: slinky.core.facade.ReactElement,
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  
  // ReactHTMLElement, less specific
  @scala.inline
  def cloneElement_P_HTMLAttributesTT_HTMLElement_ReactHTMLElement[P /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    element: typingsSlinky.react.mod.ReactHTMLElement[T],
    props: P,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.ReactHTMLElement[T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.ReactHTMLElement[T]]
  @scala.inline
  def cloneElement_P_HTMLAttributesTT_HTMLElement_ReactHTMLElement[P /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    element: typingsSlinky.react.mod.ReactHTMLElement[T],
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.ReactHTMLElement[T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.ReactHTMLElement[T]]
  
  @scala.inline
  def createContext[T](defaultValue: T): typingsSlinky.react.mod.Context[T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createContext")(defaultValue.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.Context[T]]
  @scala.inline
  def createContext[T](defaultValue: T, calculateChangedBits: js.Function2[/* prev */ T, /* next */ T, scala.Double]): typingsSlinky.react.mod.Context[T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createContext")(defaultValue.asInstanceOf[js.Any], calculateChangedBits.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.Context[T]]
  
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: java.lang.String,
    props: typingsSlinky.react.mod.Attributes & P,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def createElement[P /* <: js.Object */](`type`: java.lang.String, props: scala.Null, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def createElement[P /* <: js.Object */](`type`: java.lang.String, props: scala.Unit, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: slinky.core.ReactComponentClass[P],
    props: typingsSlinky.react.mod.Attributes & P,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: slinky.core.ReactComponentClass[P],
    props: scala.Null,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: slinky.core.ReactComponentClass[P],
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: typingsSlinky.react.mod.ClassType[P, slinky.core.ReactComponentClass[P], slinky.core.ReactComponentClass[P]],
    props: typingsSlinky.react.mod.ClassAttributes[slinky.core.ReactComponentClass[P]] & P,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.CElement[P, slinky.core.ReactComponentClass[P]] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.CElement[P, slinky.core.ReactComponentClass[P]]]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: typingsSlinky.react.mod.ClassType[P, slinky.core.ReactComponentClass[P], slinky.core.ReactComponentClass[P]],
    props: scala.Null,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.CElement[P, slinky.core.ReactComponentClass[P]] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.CElement[P, slinky.core.ReactComponentClass[P]]]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: typingsSlinky.react.mod.ClassType[P, slinky.core.ReactComponentClass[P], slinky.core.ReactComponentClass[P]],
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.CElement[P, slinky.core.ReactComponentClass[P]] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.CElement[P, slinky.core.ReactComponentClass[P]]]
  @scala.inline
  def createElement[P /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: typingsSlinky.react.mod.ClassAttributes[T] & P,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.DetailedReactHTMLElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.DetailedReactHTMLElement[P, T]]
  @scala.inline
  def createElement[P /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: scala.Null,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.DetailedReactHTMLElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.DetailedReactHTMLElement[P, T]]
  @scala.inline
  def createElement[P /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.DetailedReactHTMLElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.DetailedReactHTMLElement[P, T]]
  @scala.inline
  def createElement[P /* <: js.Object */, T /* <: slinky.core.ReactComponentClass[P] */, C /* <: slinky.core.ReactComponentClass[P] */](
    `type`: typingsSlinky.react.mod.ClassType[P, T, C],
    props: typingsSlinky.react.mod.ClassAttributes[T] & P,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.CElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.CElement[P, T]]
  @scala.inline
  def createElement[P /* <: js.Object */, T /* <: slinky.core.ReactComponentClass[P] */, C /* <: slinky.core.ReactComponentClass[P] */](
    `type`: typingsSlinky.react.mod.ClassType[P, T, C],
    props: scala.Null,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.CElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.CElement[P, T]]
  @scala.inline
  def createElement[P /* <: js.Object */, T /* <: slinky.core.ReactComponentClass[P] */, C /* <: slinky.core.ReactComponentClass[P] */](
    `type`: typingsSlinky.react.mod.ClassType[P, T, C],
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.CElement[P, T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.CElement[P, T]]
  
  @scala.inline
  def createElement_P_DOMAttributesTT_Element[P /* <: typingsSlinky.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](
    `type`: java.lang.String,
    props: typingsSlinky.react.mod.ClassAttributes[T] & P,
    children: slinky.core.facade.ReactElement*
  ): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def createElement_P_DOMAttributesTT_Element[P /* <: typingsSlinky.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](`type`: java.lang.String, props: scala.Null, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  def createElement_P_DOMAttributesTT_Element[P /* <: typingsSlinky.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](`type`: java.lang.String, props: scala.Unit, children: slinky.core.facade.ReactElement*): slinky.core.facade.ReactElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[slinky.core.facade.ReactElement]
  
  // Custom components
  @scala.inline
  def createElement_P_Object_FunctionComponentElement[P /* <: js.Object */](
    `type`: slinky.core.ReactComponentClass[P],
    props: typingsSlinky.react.mod.Attributes & P,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.FunctionComponentElement[P] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.FunctionComponentElement[P]]
  @scala.inline
  def createElement_P_Object_FunctionComponentElement[P /* <: js.Object */](
    `type`: slinky.core.ReactComponentClass[P],
    props: scala.Null,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.FunctionComponentElement[P] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.FunctionComponentElement[P]]
  @scala.inline
  def createElement_P_Object_FunctionComponentElement[P /* <: js.Object */](
    `type`: slinky.core.ReactComponentClass[P],
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.FunctionComponentElement[P] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.FunctionComponentElement[P]]
  
  @scala.inline
  def createElement_P_SVGAttributesTT_SVGElement_ReactSVGElement[P /* <: typingsSlinky.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: typingsSlinky.react.mod.ClassAttributes[T] & P,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.ReactSVGElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.ReactSVGElement]
  @scala.inline
  def createElement_P_SVGAttributesTT_SVGElement_ReactSVGElement[P /* <: typingsSlinky.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: scala.Null,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.ReactSVGElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.ReactSVGElement]
  @scala.inline
  def createElement_P_SVGAttributesTT_SVGElement_ReactSVGElement[P /* <: typingsSlinky.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.ReactSVGElement = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.ReactSVGElement]
  
  // DOM Elements
  // TODO: generalize this to everything in `keyof ReactHTML`, not just "input"
  @scala.inline
  def createElement_input(
    `type`: typingsSlinky.react.reactStrings.input,
    props: typingsSlinky.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement] & typingsSlinky.react.mod.ClassAttributes[org.scalajs.dom.raw.HTMLInputElement],
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.DetailedReactHTMLElement[
    typingsSlinky.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.DetailedReactHTMLElement[
    typingsSlinky.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ]]
  @scala.inline
  def createElement_input(
    `type`: typingsSlinky.react.reactStrings.input,
    props: scala.Null,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.DetailedReactHTMLElement[
    typingsSlinky.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.DetailedReactHTMLElement[
    typingsSlinky.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ]]
  @scala.inline
  def createElement_input(
    `type`: typingsSlinky.react.reactStrings.input,
    props: scala.Unit,
    children: slinky.core.facade.ReactElement*
  ): typingsSlinky.react.mod.DetailedReactHTMLElement[
    typingsSlinky.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsSlinky.react.mod.DetailedReactHTMLElement[
    typingsSlinky.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ]]
  
  @scala.inline
  def createFactory(`type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any): typingsSlinky.react.mod.SVGFactory = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.SVGFactory]
  // Custom components
  @scala.inline
  def createFactory[P](`type`: slinky.core.ReactComponentClass[P]): typingsSlinky.react.mod.FunctionComponentFactory[P] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.FunctionComponentFactory[P]]
  @scala.inline
  def createFactory[P](
    `type`: typingsSlinky.react.mod.ClassType[P, slinky.core.ReactComponentClass[P], slinky.core.ReactComponentClass[P]]
  ): typingsSlinky.react.mod.CFactory[P, slinky.core.ReactComponentClass[P]] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.CFactory[P, slinky.core.ReactComponentClass[P]]]
  @scala.inline
  def createFactory[P /* <: typingsSlinky.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](`type`: java.lang.String): typingsSlinky.react.mod.DOMFactory[P, T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.DOMFactory[P, T]]
  @scala.inline
  def createFactory[P, T /* <: slinky.core.ReactComponentClass[P] */, C /* <: slinky.core.ReactComponentClass[P] */](`type`: typingsSlinky.react.mod.ClassType[P, T, C]): typingsSlinky.react.mod.CFactory[P, T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.CFactory[P, T]]
  
  @scala.inline
  def createFactory_P_Factory[P](`type`: slinky.core.ReactComponentClass[P]): typingsSlinky.react.mod.Factory[P] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.Factory[P]]
  
  //
  // Top Level API
  // ----------------------------------------------------------------------
  // DOM Elements
  @scala.inline
  def createFactory_T_HTMLElement_HTMLFactory[T /* <: org.scalajs.dom.raw.HTMLElement */](`type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any): typingsSlinky.react.mod.HTMLFactory[T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.HTMLFactory[T]]
  
  @scala.inline
  def createRef[T](): slinky.core.facade.ReactRef[T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createRef")().asInstanceOf[slinky.core.facade.ReactRef[T]]
  
  @scala.inline
  def forwardRef[T, P](Component: slinky.core.ReactComponentClass[T]): typingsSlinky.react.mod.ForwardRefExoticComponent[
    typingsSlinky.react.mod.PropsWithoutRef[P] & typingsSlinky.react.mod.RefAttributes[T]
  ] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("forwardRef")(Component.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.ForwardRefExoticComponent[
    typingsSlinky.react.mod.PropsWithoutRef[P] & typingsSlinky.react.mod.RefAttributes[T]
  ]]
  
  @scala.inline
  def isValidElement[P](): /* is react.react.ReactElement */ scala.Boolean = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("isValidElement")().asInstanceOf[/* is react.react.ReactElement */ scala.Boolean]
  @scala.inline
  def isValidElement[P](`object`: js.Object): /* is react.react.ReactElement */ scala.Boolean = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("isValidElement")(`object`.asInstanceOf[js.Any]).asInstanceOf[/* is react.react.ReactElement */ scala.Boolean]
  
  @scala.inline
  def `lazy`[T /* <: slinky.core.ReactComponentClass[js.Any] */](
    factory: js.Function0[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<{  default :T}> */ js.Any
    ]
  ): slinky.core.ReactComponentClass[T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("lazy")(factory.asInstanceOf[js.Any]).asInstanceOf[slinky.core.ReactComponentClass[T]]
  
  @scala.inline
  def memo[T /* <: slinky.core.ReactComponentClass[js.Any] */](Component: T): slinky.core.ReactComponentClass[T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any]).asInstanceOf[slinky.core.ReactComponentClass[T]]
  @scala.inline
  def memo[T /* <: slinky.core.ReactComponentClass[js.Any] */](
    Component: T,
    propsAreEqual: js.Function2[
      /* prevProps */ typingsSlinky.react.mod.ComponentProps[T], 
      /* nextProps */ typingsSlinky.react.mod.ComponentProps[T], 
      scala.Boolean
    ]
  ): slinky.core.ReactComponentClass[T] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any], propsAreEqual.asInstanceOf[js.Any])).asInstanceOf[slinky.core.ReactComponentClass[T]]
  @scala.inline
  def memo[P /* <: js.Object */](Component: slinky.core.ReactComponentClass[P]): slinky.core.ReactComponentClass[P] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any]).asInstanceOf[slinky.core.ReactComponentClass[P]]
  @scala.inline
  def memo[P /* <: js.Object */](
    Component: slinky.core.ReactComponentClass[P],
    propsAreEqual: js.Function2[
      /* prevProps */ typingsSlinky.react.mod.PropsWithChildren[P], 
      /* nextProps */ typingsSlinky.react.mod.PropsWithChildren[P], 
      scala.Boolean
    ]
  ): slinky.core.ReactComponentClass[P] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any], propsAreEqual.asInstanceOf[js.Any])).asInstanceOf[slinky.core.ReactComponentClass[P]]
  
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
  @scala.inline
  def useCallback[T /* <: js.Function1[/* repeated */ js.Any, js.Any] */](callback: T, deps: typingsSlinky.react.mod.DependencyList): T = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useCallback")(callback.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[T]
  
  // This will technically work if you give a Consumer<T> or Provider<T> but it's deprecated and warns
  /**
    * Accepts a context object (the value returned from `React.createContext`) and returns the current
    * context value, as given by the nearest context provider for the given context.
    *
    * @version 16.8.0
    * @see https://reactjs.org/docs/hooks-reference.html#usecontext
    */
  @scala.inline
  def useContext[T](context: typingsSlinky.react.mod.Context[T]): T = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useContext")(context.asInstanceOf[js.Any]).asInstanceOf[T]
  
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
  @scala.inline
  def useDebugValue[T](value: T): scala.Unit = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useDebugValue")(value.asInstanceOf[js.Any]).asInstanceOf[scala.Unit]
  @scala.inline
  def useDebugValue[T](value: T, format: js.Function1[/* value */ T, js.Any]): scala.Unit = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useDebugValue")(value.asInstanceOf[js.Any], format.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  
  /**
    * Accepts a function that contains imperative, possibly effectful code.
    *
    * @param effect Imperative function that can return a cleanup function
    * @param deps If present, effect will only activate if the values in the list change.
    *
    * @version 16.8.0
    * @see https://reactjs.org/docs/hooks-reference.html#useeffect
    */
  @scala.inline
  def useEffect(effect: typingsSlinky.react.mod.EffectCallback): scala.Unit = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useEffect")(effect.asInstanceOf[js.Any]).asInstanceOf[scala.Unit]
  @scala.inline
  def useEffect(effect: typingsSlinky.react.mod.EffectCallback, deps: typingsSlinky.react.mod.DependencyList): scala.Unit = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useEffect")(effect.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  
  @scala.inline
  def useImperativeHandle[T, R /* <: T */](ref: scala.Unit, init: js.Function0[R]): scala.Unit = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  @scala.inline
  def useImperativeHandle[T, R /* <: T */](ref: scala.Unit, init: js.Function0[R], deps: typingsSlinky.react.mod.DependencyList): scala.Unit = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
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
  @scala.inline
  def useImperativeHandle[T, R /* <: T */](ref: typingsSlinky.react.mod.Ref[T], init: js.Function0[R]): scala.Unit = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  @scala.inline
  def useImperativeHandle[T, R /* <: T */](
    ref: typingsSlinky.react.mod.Ref[T],
    init: js.Function0[R],
    deps: typingsSlinky.react.mod.DependencyList
  ): scala.Unit = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  
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
  @scala.inline
  def useLayoutEffect(effect: typingsSlinky.react.mod.EffectCallback): scala.Unit = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useLayoutEffect")(effect.asInstanceOf[js.Any]).asInstanceOf[scala.Unit]
  @scala.inline
  def useLayoutEffect(effect: typingsSlinky.react.mod.EffectCallback, deps: typingsSlinky.react.mod.DependencyList): scala.Unit = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useLayoutEffect")(effect.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  
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
  @scala.inline
  def useMemo[T](factory: js.Function0[T]): T = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useMemo")(factory.asInstanceOf[js.Any]).asInstanceOf[T]
  @scala.inline
  def useMemo[T](factory: js.Function0[T], deps: typingsSlinky.react.mod.DependencyList): T = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useMemo")(factory.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[T]
  
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
  @scala.inline
  def useReducer[R /* <: typingsSlinky.react.mod.Reducer[js.Any, js.Any] */](reducer: R, initialState: typingsSlinky.react.mod.ReducerState[R], initializer: scala.Unit): js.Tuple2[
    typingsSlinky.react.mod.ReducerState[R], 
    typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.ReducerAction[R]]
  ] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useReducer")(reducer.asInstanceOf[js.Any], initialState.asInstanceOf[js.Any], initializer.asInstanceOf[js.Any])).asInstanceOf[js.Tuple2[
    typingsSlinky.react.mod.ReducerState[R], 
    typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.ReducerAction[R]]
  ]]
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
  @scala.inline
  def useReducer[R /* <: typingsSlinky.react.mod.Reducer[js.Any, js.Any] */, I](
    reducer: R,
    initializerArg: (I & typingsSlinky.react.mod.ReducerState[R]) | I,
    initializer: js.Function1[
      (/* arg */ I & typingsSlinky.react.mod.ReducerState[R]) | (/* arg */ I), 
      typingsSlinky.react.mod.ReducerState[R]
    ]
  ): js.Tuple2[
    typingsSlinky.react.mod.ReducerState[R], 
    typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.ReducerAction[R]]
  ] = (typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useReducer")(reducer.asInstanceOf[js.Any], initializerArg.asInstanceOf[js.Any], initializer.asInstanceOf[js.Any])).asInstanceOf[js.Tuple2[
    typingsSlinky.react.mod.ReducerState[R], 
    typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.ReducerAction[R]]
  ]]
  
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
  @scala.inline
  def useRef[T](): typingsSlinky.react.mod.MutableRefObject[js.UndefOr[T]] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useRef")().asInstanceOf[typingsSlinky.react.mod.MutableRefObject[js.UndefOr[T]]]
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
  @scala.inline
  def useRef[T](initialValue: T): typingsSlinky.react.mod.MutableRefObject[T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useRef")(initialValue.asInstanceOf[js.Any]).asInstanceOf[typingsSlinky.react.mod.MutableRefObject[T]]
  
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
  @scala.inline
  def useRef_T_ReactRef[T](): slinky.core.facade.ReactRef[T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useRef")().asInstanceOf[slinky.core.facade.ReactRef[T]]
  @scala.inline
  def useRef_T_ReactRef[T](initialValue: T): slinky.core.facade.ReactRef[T] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useRef")(initialValue.asInstanceOf[js.Any]).asInstanceOf[slinky.core.facade.ReactRef[T]]
  
  // convenience overload when first argument is ommitted
  /**
    * Returns a stateful value, and a function to update it.
    *
    * @version 16.8.0
    * @see https://reactjs.org/docs/hooks-reference.html#usestate
    */
  @scala.inline
  def useState[S](): js.Tuple2[
    js.UndefOr[S], 
    typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.SetStateAction[js.UndefOr[S]]]
  ] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useState")().asInstanceOf[js.Tuple2[
    js.UndefOr[S], 
    typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.SetStateAction[js.UndefOr[S]]]
  ]]
  /**
    * Returns a stateful value, and a function to update it.
    *
    * @version 16.8.0
    * @see https://reactjs.org/docs/hooks-reference.html#usestate
    */
  @scala.inline
  def useState[S](initialState: S): js.Tuple2[S, typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.SetStateAction[S]]] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useState")(initialState.asInstanceOf[js.Any]).asInstanceOf[js.Tuple2[S, typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.SetStateAction[S]]]]
  @scala.inline
  def useState[S](initialState: js.Function0[S]): js.Tuple2[S, typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.SetStateAction[S]]] = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useState")(initialState.asInstanceOf[js.Any]).asInstanceOf[js.Tuple2[S, typingsSlinky.react.mod.Dispatch[typingsSlinky.react.mod.SetStateAction[S]]]]
  
  @scala.inline
  def version: java.lang.String = typingsSlinky.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("version").asInstanceOf[java.lang.String]
  
  type AnimationEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticAnimationEvent[T]]
  
  // tslint:disable-next-line:no-empty-interface
  type AudioHTMLAttributes[T] = typingsSlinky.react.mod.MediaHTMLAttributes[T]
  
  type CElement[P, T /* <: slinky.core.ReactComponentClass[P] */] = typingsSlinky.react.mod.ComponentElement[P, T]
  
  type CFactory[P, T /* <: slinky.core.ReactComponentClass[P] */] = typingsSlinky.react.mod.ComponentFactory[P, T]
  
  type ChangeEventHandler[T] = typingsSlinky.react.mod.EventHandler[typingsSlinky.react.mod.ChangeEvent[T]]
  
  /**
    * We use an intersection type to infer multiple type parameters from
    * a single argument, which is useful for many top-level API defs.
    * See https://github.com/Microsoft/TypeScript/issues/7234 for more info.
    */
  type ClassType[P, T /* <: slinky.core.ReactComponentClass[P] */, C /* <: slinky.core.ReactComponentClass[P] */] = C & (org.scalablytyped.runtime.Instantiable2[/* props */ P, /* context */ js.UndefOr[js.Any], T])
  
  type ClassicElement[P] = typingsSlinky.react.mod.CElement[P, slinky.core.ReactComponentClass[P]]
  
  type ClassicFactory[P] = typingsSlinky.react.mod.CFactory[P, slinky.core.ReactComponentClass[P]]
  
  type ClipboardEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticClipboardEvent[T]]
  
  /**
    * NOTE: prefer ComponentPropsWithRef, if the ref is forwarded,
    * or ComponentPropsWithoutRef when refs are not supported.
    */
  type ComponentProps[T /* <: typingsSlinky.react.reactStrings.a_ | typingsSlinky.react.reactStrings.abbr | typingsSlinky.react.reactStrings.address | typingsSlinky.react.reactStrings.area | typingsSlinky.react.reactStrings.article | typingsSlinky.react.reactStrings.aside | typingsSlinky.react.reactStrings.audio | typingsSlinky.react.reactStrings.b | typingsSlinky.react.reactStrings.base | typingsSlinky.react.reactStrings.bdi | typingsSlinky.react.reactStrings.bdo | typingsSlinky.react.reactStrings.big | typingsSlinky.react.reactStrings.view | typingsSlinky.react.mod.JSXElementConstructor[js.Any] */] = js.Object | (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)
  
  type ComponentPropsWithRef[T /* <: slinky.core.facade.ReactElement */] = typingsSlinky.react.mod.PropsWithRef[typingsSlinky.react.mod.ComponentProps[T]] | (typingsSlinky.react.mod.PropsWithoutRef[js.Any] & (typingsSlinky.react.mod.RefAttributes[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> */ js.Any
  ]))
  
  type ComponentPropsWithoutRef[T /* <: slinky.core.facade.ReactElement */] = typingsSlinky.react.mod.PropsWithoutRef[typingsSlinky.react.mod.ComponentProps[T]]
  
  type ComponentState = js.Any
  
  type ComponentType[P] = slinky.core.ReactComponentClass[P]
  
  type CompositionEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticCompositionEvent[T]]
  
  type Consumer[T] = slinky.core.ReactComponentClass[typingsSlinky.react.mod.ConsumerProps[T]]
  
  type ContextType[C /* <: typingsSlinky.react.mod.Context[js.Any] */] = js.Any
  
  // Any prop that has a default prop becomes optional, but its type is unchanged
  // Undeclared default props are augmented into the resulting allowable attributes
  // If declared props have indexed properties, ignore default props entirely as keyof gets widened
  // Wrap in an outer-level conditional type to allow distribution over props that are unions
  type Defaultize[P, D] = ((typingsSlinky.std.Pick[
    P, 
    typingsSlinky.std.Exclude[/* keyof P */ java.lang.String, /* keyof D */ java.lang.String]
  ]) & (typingsSlinky.std.Partial[
    typingsSlinky.std.Pick[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Extract<keyof P, keyof D> */ js.Any
    ]
  ]) & (typingsSlinky.std.Partial[
    typingsSlinky.std.Pick[
      D, 
      typingsSlinky.std.Exclude[/* keyof D */ java.lang.String, /* keyof P */ java.lang.String]
    ]
  ])) | P
  
  // The identity check is done with the SameValue algorithm (Object.is), which is stricter than ===
  // TODO (TypeScript 3.0): ReadonlyArray<unknown>
  type DependencyList = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify ReadonlyArray<any> */ js.Any
  
  type DetailedHTMLProps[E /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T] = typingsSlinky.react.mod.ClassAttributes[T] & E
  
  // this technically does accept a second argument, but it's already under a deprecation warning
  // and it's not even released so probably better to not define it.
  type Dispatch[A] = js.Function1[/* value */ A, scala.Unit]
  
  type DragEventHandler[T] = typingsSlinky.react.mod.EventHandler[typingsSlinky.react.mod.DragEvent[T]]
  
  // NOTE: callbacks are _only_ allowed to return either void, or a destructor.
  // The destructor is itself only allowed to return void.
  type EffectCallback = js.Function0[scala.Unit | js.Function0[js.UndefOr[scala.Unit]]]
  
  //
  // React Elements
  // ----------------------------------------------------------------------
  type ElementType[P] = (/* import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view' ]: P extends react.react.<global>.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view'] */ js.Any) | slinky.core.ReactComponentClass[P]
  
  //
  // Event Handler Types
  // ----------------------------------------------------------------------
  type EventHandler[E /* <: slinky.core.SyntheticEvent[org.scalajs.dom.raw.Event, js.Any] */] = js.Function1[/* event */ E, scala.Unit]
  
  type ExactlyAnyPropertyKeys[T] = /* import warning: importer.ImportType#apply Failed type conversion: {[ K in keyof T ]: react.react.IsExactlyAny<T[K]> extends true? K : never}[keyof T] */ js.Any
  
  type FC[P] = slinky.core.ReactComponentClass[P]
  
  type FocusEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticFocusEvent[T]]
  
  // tslint:disable-next-line:no-empty-interface
  type FormEvent[T] = slinky.core.SyntheticEvent[org.scalajs.dom.raw.Event, T]
  
  type FormEventHandler[T] = typingsSlinky.react.mod.EventHandler[
    slinky.core.SyntheticEvent[org.scalajs.dom.raw.EventTarget & T, org.scalajs.dom.raw.Event]
  ]
  
  type GetDerivedStateFromError[P, S] = /**
    * This lifecycle is invoked after an error has been thrown by a descendant component.
    * It receives the error that was thrown as a parameter and should return a value to update state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function1[/* error */ js.Any, typingsSlinky.std.Partial[S] | scala.Null]
  
  type GetDerivedStateFromProps[P, S] = /**
    * Returns an update to a component's state based on its new props and old state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function2[/* nextProps */ P, /* prevState */ S, typingsSlinky.std.Partial[S] | scala.Null]
  
  // tslint:disable-next-line:no-empty-interface
  type HTMLFactory[T /* <: org.scalajs.dom.raw.HTMLElement */] = typingsSlinky.react.mod.DetailedHTMLFactory[typingsSlinky.react.mod.AllHTMLAttributes[T], T]
  
  type JSXElementConstructor[P] = (js.Function1[/* props */ P, slinky.core.facade.ReactElement | scala.Null]) | (org.scalablytyped.runtime.Instantiable1[/* props */ P, slinky.core.ReactComponentClass[P]])
  
  type Key = java.lang.String | scala.Double
  
  type KeyboardEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticKeyboardEvent[T]]
  
  type LegacyRef[T] = java.lang.String | typingsSlinky.react.mod.Ref[T]
  
  // Try to resolve ill-defined props like for JS users: props can be any, or sometimes objects with properties of type any
  type MergePropTypes[P, T] = ((typingsSlinky.std.Pick[P, typingsSlinky.react.mod.NotExactlyAnyPropertyKeys[P]]) & (typingsSlinky.std.Pick[
    T, 
    typingsSlinky.std.Exclude[
      /* keyof T */ java.lang.String, 
      typingsSlinky.react.mod.NotExactlyAnyPropertyKeys[P]
    ]
  ]) & (typingsSlinky.std.Pick[
    P, 
    typingsSlinky.std.Exclude[/* keyof P */ java.lang.String, /* keyof T */ java.lang.String]
  ])) | P | T
  
  type MouseEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticMouseEvent[T]]
  
  type NativeAnimationEvent = org.scalajs.dom.raw.AnimationEvent
  
  type NativeClipboardEvent = org.scalajs.dom.raw.ClipboardEvent
  
  type NativeCompositionEvent = org.scalajs.dom.raw.CompositionEvent
  
  type NativeDragEvent = org.scalajs.dom.raw.DragEvent
  
  type NativeFocusEvent = org.scalajs.dom.raw.FocusEvent
  
  type NativeKeyboardEvent = org.scalajs.dom.raw.KeyboardEvent
  
  type NativeMouseEvent = org.scalajs.dom.raw.MouseEvent
  
  type NativePointerEvent = org.scalajs.dom.raw.PointerEvent
  
  type NativeTouchEvent = org.scalajs.dom.raw.TouchEvent
  
  type NativeTransitionEvent = org.scalajs.dom.raw.TransitionEvent
  
  type NativeUIEvent = org.scalajs.dom.raw.UIEvent
  
  type NativeWheelEvent = org.scalajs.dom.raw.WheelEvent
  
  type NotExactlyAnyPropertyKeys[T] = typingsSlinky.std.Exclude[/* keyof T */ java.lang.String, typingsSlinky.react.mod.ExactlyAnyPropertyKeys[T]]
  
  type PointerEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticPointerEvent[T]]
  
  /**
    * {@link https://github.com/bvaughn/rfcs/blob/profiler/text/0000-profiler.md#detailed-design | API}
    */
  type ProfilerOnRenderCallback = js.Function7[
    /* id */ java.lang.String, 
    /* phase */ typingsSlinky.react.reactStrings.mount | typingsSlinky.react.reactStrings.update, 
    /* actualDuration */ scala.Double, 
    /* baseDuration */ scala.Double, 
    /* startTime */ scala.Double, 
    /* commitTime */ scala.Double, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any, 
    scala.Unit
  ]
  
  type PropsWithChildren[P] = P & typingsSlinky.react.anon.Children
  
  /** Ensures that the props do not include string ref, which cannot be forwarded */
  type PropsWithRef[P] = P | (typingsSlinky.react.mod.PropsWithoutRef[P] & typingsSlinky.react.anon.`1`)
  
  /** Ensures that the props do not include ref at all */
  type PropsWithoutRef[P] = P | (typingsSlinky.std.Pick[
    P, 
    typingsSlinky.std.Exclude[/* keyof P */ java.lang.String, typingsSlinky.react.reactStrings.ref]
  ])
  
  // NOTE: only the Context object itself can get a displayName
  // https://github.com/facebook/react-devtools/blob/e0b854e4c/backend/attachRendererFiber.js#L310-L325
  type Provider[T] = slinky.core.ReactComponentClass[typingsSlinky.react.mod.ProviderProps[T]]
  
  type ReactChild = slinky.core.facade.ReactElement | typingsSlinky.react.mod.ReactText
  
  type ReactComponentElement[T /* <: typingsSlinky.react.reactStrings.a_ | typingsSlinky.react.reactStrings.abbr | typingsSlinky.react.reactStrings.address | typingsSlinky.react.reactStrings.area | typingsSlinky.react.reactStrings.article | typingsSlinky.react.reactStrings.aside | typingsSlinky.react.reactStrings.audio | typingsSlinky.react.reactStrings.b | typingsSlinky.react.reactStrings.base | typingsSlinky.react.reactStrings.bdi | typingsSlinky.react.reactStrings.bdo | typingsSlinky.react.reactStrings.big | typingsSlinky.react.reactStrings.view | typingsSlinky.react.mod.JSXElementConstructor[js.Any] */, P] = slinky.core.facade.ReactElement
  
  type ReactEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.core.SyntheticEvent[org.scalajs.dom.raw.Event, T]]
  
  type ReactFragment = js.Object | typingsSlinky.react.mod.ReactNodeArray
  
  // ReactHTML for ReactHTMLElement
  // tslint:disable-next-line:no-empty-interface
  type ReactHTMLElement[T /* <: org.scalajs.dom.raw.HTMLElement */] = typingsSlinky.react.mod.DetailedReactHTMLElement[typingsSlinky.react.mod.AllHTMLAttributes[T], T]
  
  //
  // Component API
  // ----------------------------------------------------------------------
  type ReactInstance = slinky.core.ReactComponentClass[js.Any] | org.scalajs.dom.raw.Element
  
  type ReactManagedAttributes[C, P] = P | (typingsSlinky.react.mod.Defaultize[
    (typingsSlinky.react.mod.MergePropTypes[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
    ]) | P, 
    js.Any
  ]) | (typingsSlinky.react.mod.MergePropTypes[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
  ])
  
  type ReactNode = js.UndefOr[
    typingsSlinky.react.mod.ReactChild | typingsSlinky.react.mod.ReactFragment | typingsSlinky.react.mod.ReactPortal | scala.Boolean
  ]
  
  //
  // React Nodes
  // http://facebook.github.io/react/docs/glossary.html
  // ----------------------------------------------------------------------
  type ReactText = java.lang.String | scala.Double
  
  /**
    * @deprecated Please use `ElementType`
    */
  type ReactType[P] = slinky.core.facade.ReactElement
  
  // Unlike redux, the actions _can_ be anything
  type Reducer[S, A] = js.Function2[/* prevState */ S, /* action */ A, S]
  
  type ReducerAction[R /* <: typingsSlinky.react.mod.Reducer[js.Any, js.Any] */] = js.Any
  
  // types used to try and prevent the compiler from reducing S
  // to a supertype common with the second argument to useReducer()
  type ReducerState[R /* <: typingsSlinky.react.mod.Reducer[js.Any, js.Any] */] = js.Any
  
  type Ref[T] = (js.Function1[/* instance */ T | scala.Null, scala.Unit]) | slinky.core.facade.ReactRef[T] | scala.Null
  
  type Requireable[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<T> */ js.Any
  
  //
  // Class Interfaces
  // ----------------------------------------------------------------------
  /**
    * @deprecated as of recent React versions, function components can no
    * longer be considered 'stateless'. Please use `FunctionComponent` instead.
    *
    * @see [React Hooks](https://reactjs.org/docs/hooks-intro.html)
    */
  type SFC[P] = slinky.core.ReactComponentClass[P]
  
  /**
    * @deprecated Please use `FunctionComponentElement`
    */
  type SFCElement[P] = typingsSlinky.react.mod.FunctionComponentElement[P]
  
  /**
    * @deprecated Please use `FunctionComponentFactory`
    */
  type SFCFactory[P] = typingsSlinky.react.mod.FunctionComponentFactory[P]
  
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
  type StatelessComponent[P] = slinky.core.ReactComponentClass[P]
  
  /**
    * currentTarget - a reference to the element on which the event listener is registered.
    *
    * target - a reference to the element from which the event was originally dispatched.
    * This might be a child element to the element on which the event listener is registered.
    * If you thought this should be `EventTarget & T`, see https://github.com/DefinitelyTyped/DefinitelyTyped/pull/12239
    */
  type SyntheticEvent[T, E] = slinky.core.SyntheticEvent[org.scalajs.dom.raw.EventTarget & T, E]
  
  type TouchEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticTouchEvent[T]]
  
  type TransitionEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticTransitionEvent[T]]
  
  type UIEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticUIEvent[T]]
  
  type ValidationMap[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.ValidationMap<T> */ js.Any
  
  //
  // React.PropTypes
  // ----------------------------------------------------------------------
  type Validator[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<T> */ js.Any
  
  type WeakValidationMap[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ K in keyof T ]:? null extends T[K]? react.react.Validator<T[K] | null | undefined> : undefined extends T[K]? react.react.Validator<T[K] | null | undefined> : react.react.Validator<T[K]>}
    */ typingsSlinky.react.reactStrings.WeakValidationMap & org.scalablytyped.runtime.TopLevel[js.Any]
  
  type WheelEventHandler[T] = typingsSlinky.react.mod.EventHandler[slinky.web.SyntheticWheelEvent[T]]

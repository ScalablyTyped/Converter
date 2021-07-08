package typingsJapgolly.react

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object mod {
  
  @scala.inline
  def Children: typingsJapgolly.react.mod.ReactChildren = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("Children").asInstanceOf[typingsJapgolly.react.mod.ReactChildren]
  
  @scala.inline
  def Fragment: typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.anon.Children] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("Fragment").asInstanceOf[typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.anon.Children]]
  
  @scala.inline
  def Profiler: typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.mod.ProfilerProps] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("Profiler").asInstanceOf[typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.mod.ProfilerProps]]
  
  @scala.inline
  def StrictMode: typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.anon.Children] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("StrictMode").asInstanceOf[typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.anon.Children]]
  
  /**
    * This feature is not yet available for server-side rendering.
    * Suspense support will be added in a later release.
    */
  @scala.inline
  def Suspense: typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.mod.SuspenseProps] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("Suspense").asInstanceOf[typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.mod.SuspenseProps]]
  
  @scala.inline
  def cloneElement[P](
    element: japgolly.scalajs.react.raw.React.Element,
    props: typingsJapgolly.std.Partial[P] with typingsJapgolly.react.mod.Attributes,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def cloneElement[P](
    element: japgolly.scalajs.react.raw.React.Element,
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  // Custom components
  @scala.inline
  def cloneElement[P](
    element: typingsJapgolly.react.mod.FunctionComponentElement[P],
    props: typingsJapgolly.std.Partial[P] with typingsJapgolly.react.mod.Attributes,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.FunctionComponentElement[P] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.FunctionComponentElement[P]]
  @scala.inline
  def cloneElement[P](
    element: typingsJapgolly.react.mod.FunctionComponentElement[P],
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.FunctionComponentElement[P] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.FunctionComponentElement[P]]
  // DOM Element (has to be the last, because type checking stops at first overload that fits)
  @scala.inline
  def cloneElement[P /* <: typingsJapgolly.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](
    element: japgolly.scalajs.react.raw.React.DomElement,
    props: typingsJapgolly.react.mod.DOMAttributes[T] with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.DomElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.DomElement]
  @scala.inline
  def cloneElement[P /* <: typingsJapgolly.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](
    element: japgolly.scalajs.react.raw.React.DomElement,
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.DomElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.DomElement]
  @scala.inline
  def cloneElement[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](
    element: typingsJapgolly.react.mod.CElement[P, T],
    props: typingsJapgolly.std.Partial[P] with typingsJapgolly.react.mod.ClassAttributes[T],
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.CElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.CElement[P, T]]
  @scala.inline
  def cloneElement[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](
    element: typingsJapgolly.react.mod.CElement[P, T],
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.CElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.CElement[P, T]]
  // ReactHTMLElement, less specific
  @scala.inline
  def cloneElement[P /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    element: typingsJapgolly.react.mod.ReactHTMLElement[T],
    props: P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.ReactHTMLElement[T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.ReactHTMLElement[T]]
  @scala.inline
  def cloneElement[P /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    element: typingsJapgolly.react.mod.ReactHTMLElement[T],
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.ReactHTMLElement[T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.ReactHTMLElement[T]]
  // SVGElement
  @scala.inline
  def cloneElement[P /* <: typingsJapgolly.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    element: typingsJapgolly.react.mod.ReactSVGElement,
    props: P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.ReactSVGElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.ReactSVGElement]
  @scala.inline
  def cloneElement[P /* <: typingsJapgolly.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    element: typingsJapgolly.react.mod.ReactSVGElement,
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.ReactSVGElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.ReactSVGElement]
  
  // DOM Elements
  // ReactHTMLElement
  @scala.inline
  def cloneElement_P_HTMLAttributesTT_HTMLElement_DetailedReactHTMLElement[P /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    element: typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T],
    props: P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T]]
  @scala.inline
  def cloneElement_P_HTMLAttributesTT_HTMLElement_DetailedReactHTMLElement[P /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    element: typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T],
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("cloneElement")(element.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T]]
  
  @scala.inline
  def createContext[T](defaultValue: T): typingsJapgolly.react.mod.Context[T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createContext")(defaultValue.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.Context[T]]
  @scala.inline
  def createContext[T](defaultValue: T, calculateChangedBits: js.Function2[/* prev */ T, /* next */ T, scala.Double]): typingsJapgolly.react.mod.Context[T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createContext")(defaultValue.asInstanceOf[js.Any], calculateChangedBits.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.Context[T]]
  
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object],
    props: typingsJapgolly.react.mod.Attributes with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object],
    props: scala.Null,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object],
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: java.lang.String,
    props: typingsJapgolly.react.mod.Attributes with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def createElement[P /* <: js.Object */](`type`: java.lang.String, props: scala.Null, children: japgolly.scalajs.react.raw.React.Node*): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def createElement[P /* <: js.Object */](`type`: java.lang.String, props: scala.Unit, children: japgolly.scalajs.react.raw.React.Node*): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: typingsJapgolly.react.mod.ClassType[
      P, 
      typingsJapgolly.react.mod.ClassicComponent[P, js.Object], 
      typingsJapgolly.react.mod.ClassicComponentClass[P]
    ],
    props: (typingsJapgolly.react.mod.ClassAttributes[typingsJapgolly.react.mod.ClassicComponent[P, js.Object]]) with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.CElement[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.CElement[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]]]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: typingsJapgolly.react.mod.ClassType[
      P, 
      typingsJapgolly.react.mod.ClassicComponent[P, js.Object], 
      typingsJapgolly.react.mod.ClassicComponentClass[P]
    ],
    props: scala.Null,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.CElement[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.CElement[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]]]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: typingsJapgolly.react.mod.ClassType[
      P, 
      typingsJapgolly.react.mod.ClassicComponent[P, js.Object], 
      typingsJapgolly.react.mod.ClassicComponentClass[P]
    ],
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.CElement[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.CElement[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]]]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: typingsJapgolly.react.mod.FunctionComponent[P],
    props: typingsJapgolly.react.mod.Attributes with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: typingsJapgolly.react.mod.FunctionComponent[P],
    props: scala.Null,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def createElement[P /* <: js.Object */](
    `type`: typingsJapgolly.react.mod.FunctionComponent[P],
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.Element = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.Element]
  @scala.inline
  def createElement[P /* <: typingsJapgolly.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: typingsJapgolly.react.mod.ClassAttributes[T] with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.ReactSVGElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.ReactSVGElement]
  @scala.inline
  def createElement[P /* <: typingsJapgolly.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: scala.Null,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.ReactSVGElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.ReactSVGElement]
  @scala.inline
  def createElement[P /* <: typingsJapgolly.react.mod.SVGAttributes[T] */, T /* <: org.scalajs.dom.raw.SVGElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any,
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.ReactSVGElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.ReactSVGElement]
  @scala.inline
  def createElement[P /* <: js.Object */, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object] */](
    `type`: typingsJapgolly.react.mod.ClassType[P, T, C],
    props: typingsJapgolly.react.mod.ClassAttributes[T] with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.CElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.CElement[P, T]]
  @scala.inline
  def createElement[P /* <: js.Object */, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object] */](
    `type`: typingsJapgolly.react.mod.ClassType[P, T, C],
    props: scala.Null,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.CElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.CElement[P, T]]
  @scala.inline
  def createElement[P /* <: js.Object */, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object] */](
    `type`: typingsJapgolly.react.mod.ClassType[P, T, C],
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.CElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.CElement[P, T]]
  
  @scala.inline
  def createElement_P_DOMAttributesTT_Element_DomElement[P /* <: typingsJapgolly.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](
    `type`: java.lang.String,
    props: typingsJapgolly.react.mod.ClassAttributes[T] with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): japgolly.scalajs.react.raw.React.DomElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.DomElement]
  @scala.inline
  def createElement_P_DOMAttributesTT_Element_DomElement[P /* <: typingsJapgolly.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](`type`: java.lang.String, props: scala.Null, children: japgolly.scalajs.react.raw.React.Node*): japgolly.scalajs.react.raw.React.DomElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.DomElement]
  @scala.inline
  def createElement_P_DOMAttributesTT_Element_DomElement[P /* <: typingsJapgolly.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](`type`: java.lang.String, props: scala.Unit, children: japgolly.scalajs.react.raw.React.Node*): japgolly.scalajs.react.raw.React.DomElement = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[japgolly.scalajs.react.raw.React.DomElement]
  
  @scala.inline
  def createElement_P_HTMLAttributesTT_HTMLElement_DetailedReactHTMLElement[P /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: typingsJapgolly.react.mod.ClassAttributes[T] with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T]]
  @scala.inline
  def createElement_P_HTMLAttributesTT_HTMLElement_DetailedReactHTMLElement[P /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: scala.Null,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T]]
  @scala.inline
  def createElement_P_HTMLAttributesTT_HTMLElement_DetailedReactHTMLElement[P /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T /* <: org.scalajs.dom.raw.HTMLElement */](
    `type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any,
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.DetailedReactHTMLElement[P, T]]
  
  // Custom components
  @scala.inline
  def createElement_P_Object_FunctionComponentElement[P /* <: js.Object */](
    `type`: typingsJapgolly.react.mod.FunctionComponent[P],
    props: typingsJapgolly.react.mod.Attributes with P,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.FunctionComponentElement[P] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.FunctionComponentElement[P]]
  @scala.inline
  def createElement_P_Object_FunctionComponentElement[P /* <: js.Object */](
    `type`: typingsJapgolly.react.mod.FunctionComponent[P],
    props: scala.Null,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.FunctionComponentElement[P] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.FunctionComponentElement[P]]
  @scala.inline
  def createElement_P_Object_FunctionComponentElement[P /* <: js.Object */](
    `type`: typingsJapgolly.react.mod.FunctionComponent[P],
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.FunctionComponentElement[P] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.FunctionComponentElement[P]]
  
  // DOM Elements
  // TODO: generalize this to everything in `keyof ReactHTML`, not just "input"
  @scala.inline
  def createElement_input(
    `type`: typingsJapgolly.react.reactStrings.input,
    props: typingsJapgolly.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement] with typingsJapgolly.react.mod.ClassAttributes[org.scalajs.dom.raw.HTMLInputElement],
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.DetailedReactHTMLElement[
    typingsJapgolly.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.DetailedReactHTMLElement[
    typingsJapgolly.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ]]
  @scala.inline
  def createElement_input(
    `type`: typingsJapgolly.react.reactStrings.input,
    props: scala.Null,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.DetailedReactHTMLElement[
    typingsJapgolly.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.DetailedReactHTMLElement[
    typingsJapgolly.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ]]
  @scala.inline
  def createElement_input(
    `type`: typingsJapgolly.react.reactStrings.input,
    props: scala.Unit,
    children: japgolly.scalajs.react.raw.React.Node*
  ): typingsJapgolly.react.mod.DetailedReactHTMLElement[
    typingsJapgolly.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createElement")(`type`.asInstanceOf[js.Any], props.asInstanceOf[js.Any], children.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.DetailedReactHTMLElement[
    typingsJapgolly.react.mod.InputHTMLAttributes[org.scalajs.dom.raw.HTMLInputElement], 
    org.scalajs.dom.raw.HTMLInputElement
  ]]
  
  @scala.inline
  def createFactory(`type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 55 */ js.Any): typingsJapgolly.react.mod.SVGFactory = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.SVGFactory]
  @scala.inline
  def createFactory[P](`type`: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object]): typingsJapgolly.react.mod.Factory[P] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.Factory[P]]
  @scala.inline
  def createFactory[P](
    `type`: typingsJapgolly.react.mod.ClassType[
      P, 
      typingsJapgolly.react.mod.ClassicComponent[P, js.Object], 
      typingsJapgolly.react.mod.ClassicComponentClass[P]
    ]
  ): typingsJapgolly.react.mod.CFactory[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.CFactory[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]]]
  // Custom components
  @scala.inline
  def createFactory[P](`type`: typingsJapgolly.react.mod.FunctionComponent[P]): typingsJapgolly.react.mod.FunctionComponentFactory[P] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.FunctionComponentFactory[P]]
  @scala.inline
  def createFactory[P /* <: typingsJapgolly.react.mod.DOMAttributes[T] */, T /* <: org.scalajs.dom.raw.Element */](`type`: java.lang.String): typingsJapgolly.react.mod.DOMFactory[P, T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.DOMFactory[P, T]]
  @scala.inline
  def createFactory[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object] */](`type`: typingsJapgolly.react.mod.ClassType[P, T, C]): typingsJapgolly.react.mod.CFactory[P, T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.CFactory[P, T]]
  
  //
  // Top Level API
  // ----------------------------------------------------------------------
  // DOM Elements
  @scala.inline
  def createFactory_T_HTMLElement_HTMLFactory[T /* <: org.scalajs.dom.raw.HTMLElement */](`type`: /* import warning: LimitUnionLength.leaveTypeRef Was union type with length 115 */ js.Any): typingsJapgolly.react.mod.HTMLFactory[T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createFactory")(`type`.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.HTMLFactory[T]]
  
  @scala.inline
  def createRef[T](): japgolly.scalajs.react.raw.React.RefHandle[T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("createRef")().asInstanceOf[japgolly.scalajs.react.raw.React.RefHandle[T]]
  
  @scala.inline
  def forwardRef[T, P](Component: typingsJapgolly.react.mod.RefForwardingComponent[T, P]): typingsJapgolly.react.mod.ForwardRefExoticComponent[
    typingsJapgolly.react.mod.PropsWithoutRef[P] with typingsJapgolly.react.mod.RefAttributes[T]
  ] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("forwardRef")(Component.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.ForwardRefExoticComponent[
    typingsJapgolly.react.mod.PropsWithoutRef[P] with typingsJapgolly.react.mod.RefAttributes[T]
  ]]
  
  @scala.inline
  def isValidElement[P](): /* is react.react.ReactElement */ scala.Boolean = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("isValidElement")().asInstanceOf[/* is react.react.ReactElement */ scala.Boolean]
  @scala.inline
  def isValidElement[P](`object`: js.Object): /* is react.react.ReactElement */ scala.Boolean = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("isValidElement")(`object`.asInstanceOf[js.Any]).asInstanceOf[/* is react.react.ReactElement */ scala.Boolean]
  
  @scala.inline
  def `lazy`[T /* <: typingsJapgolly.react.mod.ComponentType[js.Any] */](
    factory: js.Function0[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<{  default :T}> */ js.Any
    ]
  ): typingsJapgolly.react.mod.LazyExoticComponent[T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("lazy")(factory.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.LazyExoticComponent[T]]
  
  @scala.inline
  def memo[T /* <: typingsJapgolly.react.mod.ComponentType[js.Any] */](Component: T): typingsJapgolly.react.mod.MemoExoticComponent[T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.MemoExoticComponent[T]]
  @scala.inline
  def memo[T /* <: typingsJapgolly.react.mod.ComponentType[js.Any] */](
    Component: T,
    propsAreEqual: js.Function2[
      /* prevProps */ typingsJapgolly.react.mod.ComponentProps[T], 
      /* nextProps */ typingsJapgolly.react.mod.ComponentProps[T], 
      scala.Boolean
    ]
  ): typingsJapgolly.react.mod.MemoExoticComponent[T] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any], propsAreEqual.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.MemoExoticComponent[T]]
  @scala.inline
  def memo[P /* <: js.Object */](Component: typingsJapgolly.react.mod.SFC[P]): typingsJapgolly.react.mod.NamedExoticComponent[P] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.NamedExoticComponent[P]]
  @scala.inline
  def memo[P /* <: js.Object */](
    Component: typingsJapgolly.react.mod.SFC[P],
    propsAreEqual: js.Function2[
      /* prevProps */ typingsJapgolly.react.mod.PropsWithChildren[P], 
      /* nextProps */ typingsJapgolly.react.mod.PropsWithChildren[P], 
      scala.Boolean
    ]
  ): typingsJapgolly.react.mod.NamedExoticComponent[P] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("memo")(Component.asInstanceOf[js.Any], propsAreEqual.asInstanceOf[js.Any])).asInstanceOf[typingsJapgolly.react.mod.NamedExoticComponent[P]]
  
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
  def useCallback[T /* <: js.Function1[/* repeated */ js.Any, js.Any] */](callback: T, deps: typingsJapgolly.react.mod.DependencyList): T = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useCallback")(callback.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[T]
  
  // This will technically work if you give a Consumer<T> or Provider<T> but it's deprecated and warns
  /**
    * Accepts a context object (the value returned from `React.createContext`) and returns the current
    * context value, as given by the nearest context provider for the given context.
    *
    * @version 16.8.0
    * @see https://reactjs.org/docs/hooks-reference.html#usecontext
    */
  @scala.inline
  def useContext[T](context: typingsJapgolly.react.mod.Context[T]): T = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useContext")(context.asInstanceOf[js.Any]).asInstanceOf[T]
  
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
  def useDebugValue[T](value: T): scala.Unit = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useDebugValue")(value.asInstanceOf[js.Any]).asInstanceOf[scala.Unit]
  @scala.inline
  def useDebugValue[T](value: T, format: js.Function1[/* value */ T, js.Any]): scala.Unit = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useDebugValue")(value.asInstanceOf[js.Any], format.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  
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
  def useEffect(effect: typingsJapgolly.react.mod.EffectCallback): scala.Unit = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useEffect")(effect.asInstanceOf[js.Any]).asInstanceOf[scala.Unit]
  @scala.inline
  def useEffect(effect: typingsJapgolly.react.mod.EffectCallback, deps: typingsJapgolly.react.mod.DependencyList): scala.Unit = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useEffect")(effect.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  
  @scala.inline
  def useImperativeHandle[T, R /* <: T */](ref: scala.Unit, init: js.Function0[R]): scala.Unit = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  @scala.inline
  def useImperativeHandle[T, R /* <: T */](ref: scala.Unit, init: js.Function0[R], deps: typingsJapgolly.react.mod.DependencyList): scala.Unit = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
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
  def useImperativeHandle[T, R /* <: T */](ref: typingsJapgolly.react.mod.Ref[T], init: js.Function0[R]): scala.Unit = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  @scala.inline
  def useImperativeHandle[T, R /* <: T */](
    ref: typingsJapgolly.react.mod.Ref[T],
    init: js.Function0[R],
    deps: typingsJapgolly.react.mod.DependencyList
  ): scala.Unit = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useImperativeHandle")(ref.asInstanceOf[js.Any], init.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  
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
  def useLayoutEffect(effect: typingsJapgolly.react.mod.EffectCallback): scala.Unit = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useLayoutEffect")(effect.asInstanceOf[js.Any]).asInstanceOf[scala.Unit]
  @scala.inline
  def useLayoutEffect(effect: typingsJapgolly.react.mod.EffectCallback, deps: typingsJapgolly.react.mod.DependencyList): scala.Unit = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useLayoutEffect")(effect.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[scala.Unit]
  
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
  def useMemo[T](factory: js.Function0[T]): T = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useMemo")(factory.asInstanceOf[js.Any]).asInstanceOf[T]
  @scala.inline
  def useMemo[T](factory: js.Function0[T], deps: typingsJapgolly.react.mod.DependencyList): T = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useMemo")(factory.asInstanceOf[js.Any], deps.asInstanceOf[js.Any])).asInstanceOf[T]
  
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
  def useReducer[R /* <: typingsJapgolly.react.mod.Reducer[js.Any, js.Any] */](reducer: R, initialState: typingsJapgolly.react.mod.ReducerState[R], initializer: scala.Unit): js.Tuple2[
    typingsJapgolly.react.mod.ReducerState[R], 
    typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.ReducerAction[R]]
  ] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useReducer")(reducer.asInstanceOf[js.Any], initialState.asInstanceOf[js.Any], initializer.asInstanceOf[js.Any])).asInstanceOf[js.Tuple2[
    typingsJapgolly.react.mod.ReducerState[R], 
    typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.ReducerAction[R]]
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
  def useReducer[R /* <: typingsJapgolly.react.mod.Reducer[js.Any, js.Any] */, I](
    reducer: R,
    initializerArg: (I with typingsJapgolly.react.mod.ReducerState[R]) | I,
    initializer: js.Function1[
      (/* arg */ I with typingsJapgolly.react.mod.ReducerState[R]) | (/* arg */ I), 
      typingsJapgolly.react.mod.ReducerState[R]
    ]
  ): js.Tuple2[
    typingsJapgolly.react.mod.ReducerState[R], 
    typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.ReducerAction[R]]
  ] = (typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useReducer")(reducer.asInstanceOf[js.Any], initializerArg.asInstanceOf[js.Any], initializer.asInstanceOf[js.Any])).asInstanceOf[js.Tuple2[
    typingsJapgolly.react.mod.ReducerState[R], 
    typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.ReducerAction[R]]
  ]]
  
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
  def useRef[T](): japgolly.scalajs.react.raw.React.RefHandle[T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useRef")().asInstanceOf[japgolly.scalajs.react.raw.React.RefHandle[T]]
  @scala.inline
  def useRef[T](initialValue: T): japgolly.scalajs.react.raw.React.RefHandle[T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useRef")(initialValue.asInstanceOf[js.Any]).asInstanceOf[japgolly.scalajs.react.raw.React.RefHandle[T]]
  
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
  def useRef_T_MutableRefObject[T](): typingsJapgolly.react.mod.MutableRefObject[js.UndefOr[T]] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useRef")().asInstanceOf[typingsJapgolly.react.mod.MutableRefObject[js.UndefOr[T]]]
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
  def useRef_T_MutableRefObject[T](initialValue: T): typingsJapgolly.react.mod.MutableRefObject[T] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useRef")(initialValue.asInstanceOf[js.Any]).asInstanceOf[typingsJapgolly.react.mod.MutableRefObject[T]]
  
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
    typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.SetStateAction[js.UndefOr[S]]]
  ] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useState")().asInstanceOf[js.Tuple2[
    js.UndefOr[S], 
    typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.SetStateAction[js.UndefOr[S]]]
  ]]
  /**
    * Returns a stateful value, and a function to update it.
    *
    * @version 16.8.0
    * @see https://reactjs.org/docs/hooks-reference.html#usestate
    */
  @scala.inline
  def useState[S](initialState: S): js.Tuple2[S, typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.SetStateAction[S]]] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useState")(initialState.asInstanceOf[js.Any]).asInstanceOf[js.Tuple2[S, typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.SetStateAction[S]]]]
  @scala.inline
  def useState[S](initialState: js.Function0[S]): js.Tuple2[S, typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.SetStateAction[S]]] = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].applyDynamic("useState")(initialState.asInstanceOf[js.Any]).asInstanceOf[js.Tuple2[S, typingsJapgolly.react.mod.Dispatch[typingsJapgolly.react.mod.SetStateAction[S]]]]
  
  @scala.inline
  def version: java.lang.String = typingsJapgolly.react.mod.^.asInstanceOf[js.Dynamic].selectDynamic("version").asInstanceOf[java.lang.String]
  
  type AnimationEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactAnimationEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  
  // tslint:disable-next-line:no-empty-interface
  type AudioHTMLAttributes[T] = typingsJapgolly.react.mod.MediaHTMLAttributes[T]
  
  type CElement[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */] = typingsJapgolly.react.mod.ComponentElement[P, T]
  
  type CFactory[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */] = typingsJapgolly.react.mod.ComponentFactory[P, T]
  
  type ChangeEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]]
  
  /**
    * We use an intersection type to infer multiple type parameters from
    * a single argument, which is useful for many top-level API defs.
    * See https://github.com/Microsoft/TypeScript/issues/7234 for more info.
    */
  type ClassType[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */, C /* <: japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object] */] = C with (org.scalablytyped.runtime.Instantiable2[/* props */ P, /* context */ js.UndefOr[js.Any], T])
  
  type ClassicElement[P] = typingsJapgolly.react.mod.CElement[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]]
  
  type ClassicFactory[P] = typingsJapgolly.react.mod.CFactory[P, typingsJapgolly.react.mod.ClassicComponent[P, js.Object]]
  
  type ClipboardEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactClipboardEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  
  /**
    * NOTE: prefer ComponentPropsWithRef, if the ref is forwarded,
    * or ComponentPropsWithoutRef when refs are not supported.
    */
  type ComponentProps[T /* <: typingsJapgolly.react.reactStrings.a_ | typingsJapgolly.react.reactStrings.abbr | typingsJapgolly.react.reactStrings.address | typingsJapgolly.react.reactStrings.area | typingsJapgolly.react.reactStrings.article | typingsJapgolly.react.reactStrings.aside | typingsJapgolly.react.reactStrings.audio | typingsJapgolly.react.reactStrings.b | typingsJapgolly.react.reactStrings.base | typingsJapgolly.react.reactStrings.bdi | typingsJapgolly.react.reactStrings.bdo | typingsJapgolly.react.reactStrings.big | typingsJapgolly.react.reactStrings.view | typingsJapgolly.react.mod.JSXElementConstructor[js.Any] */] = js.Object | (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)
  
  type ComponentPropsWithRef[T /* <: japgolly.scalajs.react.raw.React.ElementType */] = typingsJapgolly.react.mod.PropsWithRef[typingsJapgolly.react.mod.ComponentProps[T]] | (typingsJapgolly.react.mod.PropsWithoutRef[js.Any] with (typingsJapgolly.react.mod.RefAttributes[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify InstanceType<T> */ js.Any
  ]))
  
  type ComponentPropsWithoutRef[T /* <: japgolly.scalajs.react.raw.React.ElementType */] = typingsJapgolly.react.mod.PropsWithoutRef[typingsJapgolly.react.mod.ComponentProps[T]]
  
  type ComponentState = js.Any
  
  type ComponentType[P] = (japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object]) | typingsJapgolly.react.mod.FunctionComponent[P]
  
  type CompositionEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactCompositionEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  
  type Consumer[T] = typingsJapgolly.react.mod.ExoticComponent[typingsJapgolly.react.mod.ConsumerProps[T]]
  
  type ContextType[C /* <: typingsJapgolly.react.mod.Context[js.Any] */] = js.Any
  
  // Any prop that has a default prop becomes optional, but its type is unchanged
  // Undeclared default props are augmented into the resulting allowable attributes
  // If declared props have indexed properties, ignore default props entirely as keyof gets widened
  // Wrap in an outer-level conditional type to allow distribution over props that are unions
  type Defaultize[P, D] = ((typingsJapgolly.std.Pick[
    P, 
    typingsJapgolly.std.Exclude[/* keyof P */ java.lang.String, /* keyof D */ java.lang.String]
  ]) with (typingsJapgolly.std.Partial[
    typingsJapgolly.std.Pick[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Extract<keyof P, keyof D> */ js.Any
    ]
  ]) with (typingsJapgolly.std.Partial[
    typingsJapgolly.std.Pick[
      D, 
      typingsJapgolly.std.Exclude[/* keyof D */ java.lang.String, /* keyof P */ java.lang.String]
    ]
  ])) | P
  
  // The identity check is done with the SameValue algorithm (Object.is), which is stricter than ===
  // TODO (TypeScript 3.0): ReadonlyArray<unknown>
  type DependencyList = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify ReadonlyArray<any> */ js.Any
  
  type DetailedHTMLProps[E /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T] = typingsJapgolly.react.mod.ClassAttributes[T] with E
  
  // this technically does accept a second argument, but it's already under a deprecation warning
  // and it's not even released so probably better to not define it.
  type Dispatch[A] = js.Function1[/* value */ A, scala.Unit]
  
  type DragEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactDragEventFrom[T with org.scalajs.dom.raw.Element]]
  
  // NOTE: callbacks are _only_ allowed to return either void, or a destructor.
  // The destructor is itself only allowed to return void.
  type EffectCallback = js.Function0[scala.Unit | js.Function0[js.UndefOr[scala.Unit]]]
  
  //
  // React Elements
  // ----------------------------------------------------------------------
  type ElementType[P] = (/* import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view' ]: P extends react.react.<global>.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view'] */ js.Any) | typingsJapgolly.react.mod.ComponentType[P]
  
  //
  // Event Handler Types
  // ----------------------------------------------------------------------
  type EventHandler[E /* <: japgolly.scalajs.react.ReactEventFrom[js.Any with org.scalajs.dom.raw.Element] */] = js.Function1[/* event */ E, scala.Unit]
  
  type ExactlyAnyPropertyKeys[T] = /* import warning: importer.ImportType#apply Failed type conversion: {[ K in keyof T ]: react.react.IsExactlyAny<T[K]> extends true? K : never}[keyof T] */ js.Any
  
  type FC[P] = typingsJapgolly.react.mod.FunctionComponent[P]
  
  type FocusEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactFocusEventFrom[T with org.scalajs.dom.raw.Element]]
  
  // tslint:disable-next-line:no-empty-interface
  type FormEvent[T] = japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]
  
  type FormEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]]
  
  type GetDerivedStateFromError[P, S] = /**
    * This lifecycle is invoked after an error has been thrown by a descendant component.
    * It receives the error that was thrown as a parameter and should return a value to update state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function1[/* error */ js.Any, typingsJapgolly.std.Partial[S] | scala.Null]
  
  type GetDerivedStateFromProps[P, S] = /**
    * Returns an update to a component's state based on its new props and old state.
    *
    * Note: its presence prevents any of the deprecated lifecycle methods from being invoked
    */
  js.Function2[/* nextProps */ P, /* prevState */ S, typingsJapgolly.std.Partial[S] | scala.Null]
  
  // tslint:disable-next-line:no-empty-interface
  type HTMLFactory[T /* <: org.scalajs.dom.raw.HTMLElement */] = typingsJapgolly.react.mod.DetailedHTMLFactory[typingsJapgolly.react.mod.AllHTMLAttributes[T], T]
  
  type JSXElementConstructor[P] = (js.Function1[/* props */ P, japgolly.scalajs.react.raw.React.Element | scala.Null]) | (org.scalablytyped.runtime.Instantiable1[
    /* props */ P, 
    japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object]
  ])
  
  type Key = java.lang.String | scala.Double
  
  type KeyboardEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactKeyboardEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  
  type LegacyRef[T] = java.lang.String | typingsJapgolly.react.mod.Ref[T]
  
  // Try to resolve ill-defined props like for JS users: props can be any, or sometimes objects with properties of type any
  type MergePropTypes[P, T] = ((typingsJapgolly.std.Pick[P, typingsJapgolly.react.mod.NotExactlyAnyPropertyKeys[P]]) with (typingsJapgolly.std.Pick[
    T, 
    typingsJapgolly.std.Exclude[
      /* keyof T */ java.lang.String, 
      typingsJapgolly.react.mod.NotExactlyAnyPropertyKeys[P]
    ]
  ]) with (typingsJapgolly.std.Pick[
    P, 
    typingsJapgolly.std.Exclude[/* keyof P */ java.lang.String, /* keyof T */ java.lang.String]
  ])) | P | T
  
  type MouseEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactMouseEventFrom[T with org.scalajs.dom.raw.Element]]
  
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
  
  type NotExactlyAnyPropertyKeys[T] = typingsJapgolly.std.Exclude[
    /* keyof T */ java.lang.String, 
    typingsJapgolly.react.mod.ExactlyAnyPropertyKeys[T]
  ]
  
  type PointerEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactPointerEventFrom[T with org.scalajs.dom.raw.Element]]
  
  /**
    * {@link https://github.com/bvaughn/rfcs/blob/profiler/text/0000-profiler.md#detailed-design | API}
    */
  type ProfilerOnRenderCallback = js.Function7[
    /* id */ java.lang.String, 
    /* phase */ typingsJapgolly.react.reactStrings.mount | typingsJapgolly.react.reactStrings.update, 
    /* actualDuration */ scala.Double, 
    /* baseDuration */ scala.Double, 
    /* startTime */ scala.Double, 
    /* commitTime */ scala.Double, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Set<SchedulerInteraction> */ /* interactions */ js.Any, 
    scala.Unit
  ]
  
  type PropsWithChildren[P] = P with typingsJapgolly.react.anon.Children
  
  /** Ensures that the props do not include string ref, which cannot be forwarded */
  type PropsWithRef[P] = P | (typingsJapgolly.react.mod.PropsWithoutRef[P] with typingsJapgolly.react.anon.`1`)
  
  /** Ensures that the props do not include ref at all */
  type PropsWithoutRef[P] = P | (typingsJapgolly.std.Pick[
    P, 
    typingsJapgolly.std.Exclude[/* keyof P */ java.lang.String, typingsJapgolly.react.reactStrings.ref]
  ])
  
  // NOTE: only the Context object itself can get a displayName
  // https://github.com/facebook/react-devtools/blob/e0b854e4c/backend/attachRendererFiber.js#L310-L325
  type Provider[T] = typingsJapgolly.react.mod.ProviderExoticComponent[typingsJapgolly.react.mod.ProviderProps[T]]
  
  type ReactChild = japgolly.scalajs.react.raw.React.Element | typingsJapgolly.react.mod.ReactText
  
  type ReactComponentElement[T /* <: typingsJapgolly.react.reactStrings.a_ | typingsJapgolly.react.reactStrings.abbr | typingsJapgolly.react.reactStrings.address | typingsJapgolly.react.reactStrings.area | typingsJapgolly.react.reactStrings.article | typingsJapgolly.react.reactStrings.aside | typingsJapgolly.react.reactStrings.audio | typingsJapgolly.react.reactStrings.b | typingsJapgolly.react.reactStrings.base | typingsJapgolly.react.reactStrings.bdi | typingsJapgolly.react.reactStrings.bdo | typingsJapgolly.react.reactStrings.big | typingsJapgolly.react.reactStrings.view | typingsJapgolly.react.mod.JSXElementConstructor[js.Any] */, P] = japgolly.scalajs.react.raw.React.Element
  
  type ReactEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactEventFrom[T with org.scalajs.dom.raw.Element]]
  
  type ReactFragment = js.Object | typingsJapgolly.react.mod.ReactNodeArray
  
  // ReactHTML for ReactHTMLElement
  // tslint:disable-next-line:no-empty-interface
  type ReactHTMLElement[T /* <: org.scalajs.dom.raw.HTMLElement */] = typingsJapgolly.react.mod.DetailedReactHTMLElement[typingsJapgolly.react.mod.AllHTMLAttributes[T], T]
  
  //
  // Component API
  // ----------------------------------------------------------------------
  type ReactInstance = (japgolly.scalajs.react.raw.React.Component[js.Any with js.Object, js.Object]) | org.scalajs.dom.raw.Element
  
  type ReactManagedAttributes[C, P] = P | (typingsJapgolly.react.mod.Defaultize[
    (typingsJapgolly.react.mod.MergePropTypes[
      P, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
    ]) | P, 
    js.Any
  ]) | (typingsJapgolly.react.mod.MergePropTypes[
    P, 
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.InferProps<T> */ js.Any
  ])
  
  type ReactNode = js.UndefOr[
    typingsJapgolly.react.mod.ReactChild | typingsJapgolly.react.mod.ReactFragment | typingsJapgolly.react.mod.ReactPortal | scala.Boolean
  ]
  
  //
  // React Nodes
  // http://facebook.github.io/react/docs/glossary.html
  // ----------------------------------------------------------------------
  type ReactText = java.lang.String | scala.Double
  
  /**
    * @deprecated Please use `ElementType`
    */
  type ReactType[P] = japgolly.scalajs.react.raw.React.ElementType
  
  // Unlike redux, the actions _can_ be anything
  type Reducer[S, A] = js.Function2[/* prevState */ S, /* action */ A, S]
  
  type ReducerAction[R /* <: typingsJapgolly.react.mod.Reducer[js.Any, js.Any] */] = js.Any
  
  // types used to try and prevent the compiler from reducing S
  // to a supertype common with the second argument to useReducer()
  type ReducerState[R /* <: typingsJapgolly.react.mod.Reducer[js.Any, js.Any] */] = js.Any
  
  type Ref[T] = (js.Function1[/* instance */ T | scala.Null, scala.Unit]) | japgolly.scalajs.react.raw.React.RefHandle[T] | scala.Null
  
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
  type SFC[P] = typingsJapgolly.react.mod.FunctionComponent[P]
  
  /**
    * @deprecated Please use `FunctionComponentElement`
    */
  type SFCElement[P] = typingsJapgolly.react.mod.FunctionComponentElement[P]
  
  /**
    * @deprecated Please use `FunctionComponentFactory`
    */
  type SFCFactory[P] = typingsJapgolly.react.mod.FunctionComponentFactory[P]
  
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
  type StatelessComponent[P] = typingsJapgolly.react.mod.FunctionComponent[P]
  
  /**
    * currentTarget - a reference to the element on which the event listener is registered.
    *
    * target - a reference to the element from which the event was originally dispatched.
    * This might be a child element to the element on which the event listener is registered.
    * If you thought this should be `EventTarget & T`, see https://github.com/DefinitelyTyped/DefinitelyTyped/pull/12239
    */
  type SyntheticEvent[T, E] = japgolly.scalajs.react.ReactEventFrom[org.scalajs.dom.raw.EventTarget with T with org.scalajs.dom.raw.Element]
  
  type TouchEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactTouchEventFrom[T with org.scalajs.dom.raw.Element]]
  
  type TransitionEventHandler[T] = typingsJapgolly.react.mod.EventHandler[
    japgolly.scalajs.react.ReactTransitionEventFrom[T with org.scalajs.dom.raw.Element]
  ]
  
  type UIEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactUIEventFrom[T with org.scalajs.dom.raw.Element]]
  
  type ValidationMap[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.ValidationMap<T> */ js.Any
  
  //
  // React.PropTypes
  // ----------------------------------------------------------------------
  type Validator[T] = /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<T> */ js.Any
  
  type WeakValidationMap[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ K in keyof T ]:? null extends T[K]? react.react.Validator<T[K] | null | undefined> : undefined extends T[K]? react.react.Validator<T[K] | null | undefined> : react.react.Validator<T[K]>}
    */ typingsJapgolly.react.reactStrings.WeakValidationMap with org.scalablytyped.runtime.TopLevel[js.Any]
  
  type WheelEventHandler[T] = typingsJapgolly.react.mod.EventHandler[japgolly.scalajs.react.ReactWheelEventFrom[T with org.scalajs.dom.raw.Element]]
}

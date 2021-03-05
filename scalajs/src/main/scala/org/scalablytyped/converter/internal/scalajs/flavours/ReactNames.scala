package org.scalablytyped.converter.internal
package scalajs
package flavours

class ReactNames(val outputPkg: Name) {
  val libName              = Name("react")
  val mod                  = QualifiedName(IArray(outputPkg, libName, Name.mod))
  val Ref                  = mod + Name("Ref")
  val LegacyRef            = mod + Name("LegacyRef")
  val RefObject            = mod + Name("RefObject")
  val ReactNode            = mod + Name("ReactNode")
  val ReactElement         = mod + Name("ReactElement")
  val DOMElement           = mod + Name("DOMElement")
  val ElementType          = mod + Name("ElementType")
  val ReactType            = mod + Name("ReactType")
  val AllHTMLAttributes    = mod + Name("AllHTMLAttributes")
  val SVGAttributes        = mod + Name("SVGAttributes")
  val Component            = mod + Name("Component")
  val ComponentType        = mod + Name("ComponentType")
  val ComponentClass       = mod + Name("ComponentClass")
  val ReactDOM             = mod + Name("ReactDOM")
  val ComponentState       = mod + Name("ComponentState")
  val Jsx                  = mod + Name.global + Name("JSX")
  val JsxIntrinsicElements = Jsx + Name("IntrinsicElements")
  val JsxReactElement      = Jsx + Name("Element")
  val isElement            = Set(ReactElement, JsxReactElement)

  val isRef: Set[QualifiedName] = Set(Ref, LegacyRef, RefObject)

  val WrappedComponents: Set[String] = Set(
    "MemoExoticComponent",
    "LazyExoticComponent",
    "RefForwardingComponent",
  )
  val WrappedComponentsQNames: Set[QualifiedName] =
    WrappedComponents.map(mod + Name(_))

  val ComponentNames: Set[String] =
    Set(
      "ClassicComponent",
      "ClassicComponentClass",
      "Component",
      "ComponentClass",
      "ComponentType",
      "ExoticComponent",
      "FC",
      "FunctionComponent",
      "NamedExoticComponent",
      "ProviderExoticComponent",
      "PureComponent",
      "RefForwardingComponent",
      "SFC",
      "StatelessComponent",
    )

  val ComponentQNames: Set[QualifiedName] =
    ComponentNames.map(mod + Name(_))

  val ComponentLike: Set[QualifiedName] =
    ComponentQNames ++ WrappedComponentsQNames

  def isComponent(tr: TypeRef): Option[PropsRef] =
    tr match {
      case TypeRef.Intersection(types, _)                                => types.firstDefined(isComponent)
      case TypeRef(c, IArray.first(props), _) if ComponentQNames(c)      => Some(PropsRef(props))
      case TypeRef(c, IArray.first(cc), _) if WrappedComponentsQNames(c) => isComponent(cc)
      case _                                                             => None
    }

  // events
  val BaseSyntheticEvent = mod + Name("BaseSyntheticEvent")
  val ChangeEvent        = mod + Name("ChangeEvent")
  val InvalidEvent       = mod + Name("InvalidEvent")
  val AnimationEvent     = mod + Name("AnimationEvent")
  val ClipboardEvent     = mod + Name("ClipboardEvent")
  val CompositionEvent   = mod + Name("CompositionEvent")
  val DragEvent          = mod + Name("DragEvent")
  val FormEvent          = mod + Name("FormEvent")
  val FocusEvent         = mod + Name("FocusEvent")
  val KeyboardEvent      = mod + Name("KeyboardEvent")
  val MouseEvent         = mod + Name("MouseEvent")
  val PointerEvent       = mod + Name("PointerEvent")
  val SyntheticEvent     = mod + Name("SyntheticEvent")
  val TouchEvent         = mod + Name("TouchEvent")
  val TransitionEvent    = mod + Name("TransitionEvent")
  val UIEvent            = mod + Name("UIEvent")
  val WheelEvent         = mod + Name("WheelEvent")
}

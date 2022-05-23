package org.scalablytyped.converter.internal
package scalajs
package flavours

class ReactNames(val outputPkg: Name) {
  val libName              = Name("react")
  val mod                  = QualifiedName(IArray(outputPkg, libName, Name.mod))
  val static               = QualifiedName(IArray(outputPkg, libName, Name.global, Name("React")))
  val Ref                  = mod + Name("Ref")
  val RefCallback          = mod + Name("RefCallback")
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

  val isRef: Set[QualifiedName] = Set(Ref, LegacyRef, RefObject, RefCallback)

  def explode(names: String*) = names.toSet.flatMap((name: String) => List(mod + Name(name), static + Name(name)))

  val PropsWithWithoutRefQNames: Set[QualifiedName] =
    explode("PropsWithoutRef", "PropsWithRef")

  val ComponentPropsWithWithoutRefQNames: Set[QualifiedName] =
    explode("ComponentPropsWithRef", "ComponentPropsWithoutRef")

  val WrappedComponentsQNames: Set[QualifiedName] =
    explode("MemoExoticComponent", "LazyExoticComponent")

  val ComponentQNames: Set[QualifiedName] = explode(
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
    "SFC",
    "StatelessComponent",
    "ForwardRefExoticComponent",
  )

  val ComponentLike: Set[QualifiedName] =
    ComponentQNames ++ WrappedComponentsQNames

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

package com.olvind.tso
package scalajs
package flavours

class ReactNames(val outputPkg: Name) {
  val lib = QualifiedName(List(outputPkg, Name("react")))
  val mod = lib + Name("reactMod")

  val Ref               = mod + Name("Ref")
  val RefObject         = mod + Name("RefObject")
  val ReactNode         = mod + Name("ReactNode")
  val ReactElement      = mod + Name("ReactElement")
  val DOMElement        = mod + Name("DOMElement")
  val ElementType       = mod + Name("ElementType")
  val ReactType         = mod + Name("ReactType")
  val AllHTMLAttributes = mod + Name("AllHTMLAttributes")
  val SVGAttributes     = mod + Name("SVGAttributes")
  val Component         = mod + Name("Component")
  val ComponentType     = mod + Name("ComponentType")
  val ComponentClass    = mod + Name("ComponentClass")
  val ReactDOM          = mod + Name("ReactDOM")
  val ComponentState    = mod + Name("ComponentState")
  val JsxReactElement   = mod + Name("_Global_") + Name("JSX") + Name("Element")
  val isElement         = Set(ReactElement, JsxReactElement)

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
      "LazyExoticComponent",
      "MemoExoticComponent",
      "NamedExoticComponent",
      "ProviderExoticComponent",
      "PureComponent",
      "RefForwardingComponent",
      "SFC",
      "StatelessComponent",
    )

  val isComponent: Set[QualifiedName] = ComponentNames.map(mod + Name(_))

  // events
  val BaseSyntheticEvent     = mod + Name("BaseSyntheticEvent")
  val ChangeEvent            = mod + Name("ChangeEvent")
  val InvalidEvent           = mod + Name("InvalidEvent")
  val AnimationEvent         = mod + Name("AnimationEvent")
  val ClipboardEvent         = mod + Name("ClipboardEvent")
  val CompositionEvent       = mod + Name("CompositionEvent")
  val DragEvent              = mod + Name("DragEvent")
  val FormEvent              = mod + Name("FormEvent")
  val FocusEvent             = mod + Name("FocusEvent")
  val KeyboardEvent          = mod + Name("KeyboardEvent")
  val MouseEvent             = mod + Name("MouseEvent")
  val PointerEvent           = mod + Name("PointerEvent")
  val SyntheticEvent         = mod + Name("SyntheticEvent")
  val TouchEvent             = mod + Name("TouchEvent")
  val TransitionEvent        = mod + Name("TransitionEvent")
  val UIEvent                = mod + Name("UIEvent")
  val WheelEvent             = mod + Name("WheelEvent")
  val NativeAnimationEvent   = lib + Name("NativeAnimationEvent")
  val NativeClipboardEvent   = lib + Name("NativeClipboardEvent")
  val NativeCompositionEvent = lib + Name("NativeCompositionEvent")
  val NativeDragEvent        = lib + Name("NativeDragEvent")
  val NativeFocusEvent       = lib + Name("NativeFocusEvent")
  val NativeKeyboardEvent    = lib + Name("NativeKeyboardEvent")
  val NativeMouseEvent       = lib + Name("NativeMouseEvent")
  val NativePointerEvent     = lib + Name("NativePointerEvent")
  val NativeTouchEvent       = lib + Name("NativeTouchEvent")
  val NativeTransitionEvent  = lib + Name("NativeTransitionEvent")
  val NativeUIEvent          = lib + Name("NativeUIEvent")
  val NativeWheelEvent       = lib + Name("NativeWheelEvent")
}

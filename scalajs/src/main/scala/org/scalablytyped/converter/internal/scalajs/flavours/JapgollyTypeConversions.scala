package org.scalablytyped.converter.internal.scalajs.flavours

import org.scalablytyped.converter.internal.IArray
import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TParam
import org.scalablytyped.converter.internal.scalajs.flavours.JapgollyGenComponents.japgolly
import org.scalablytyped.converter.internal.scalajs.{Name, QualifiedName, TypeRef}

object JapgollyTypeConversions {
  def apply(reactNames: ReactNames, scalaJsDomNames: ScalaJsDomNames): IArray[CastConversion] = {
    val _1Element = TParam._1.among(scalaJsDomNames.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
    val _2Element = TParam._2.among(scalaJsDomNames.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
    val _1Object  = TParam._1.among(Set.empty, QualifiedName.Object)

    scalaJsDomNames.All ++ IArray(
      CastConversion(reactNames.ComponentState, QualifiedName.Object),
      CastConversion(reactNames.ReactDOM, QualifiedName.Any),
      CastConversion(reactNames.ReactNode, japgolly.rawReactNode),
      CastConversion(reactNames.Ref, japgolly.rawReactRef),
      CastConversion(reactNames.RefObject, japgolly.rawReactRefHandle, TParam._1),
      CastConversion(reactNames.Component, japgolly.rawReactComponent, _1Object, TypeRef.Object),
      CastConversion(reactNames.ComponentClass, japgolly.rawReactComponentClassP, _1Object),
      CastConversion(reactNames.ReactElement, japgolly.rawReactElement),
      CastConversion(reactNames.DOMElement, japgolly.rawReactDOMElement),
      CastConversion(reactNames.ElementType, japgolly.rawReactElementType),
      CastConversion(reactNames.BaseSyntheticEvent, japgolly.reactReactEventFrom, _2Element),
      CastConversion(reactNames.ChangeEvent, japgolly.reactReactEventFrom, _1Element),
      CastConversion(reactNames.FormEvent, japgolly.reactReactEventFrom, _1Element),
      CastConversion(reactNames.InvalidEvent, japgolly.reactReactEventFrom, _1Element),
      CastConversion(reactNames.SyntheticEvent, japgolly.reactReactEventFrom, _1Element),
      CastConversion(reactNames.AnimationEvent, japgolly.react + Name("ReactAnimationEventFrom"), _1Element),
      CastConversion(reactNames.ClipboardEvent, japgolly.react + Name("ReactClipboardEventFrom"), _1Element),
      CastConversion(reactNames.CompositionEvent, japgolly.react + Name("ReactCompositionEventFrom"), _1Element),
      CastConversion(reactNames.DragEvent, japgolly.react + Name("ReactDragEventFrom"), _1Element),
      CastConversion(reactNames.FocusEvent, japgolly.react + Name("ReactFocusEventFrom"), _1Element),
      CastConversion(reactNames.KeyboardEvent, japgolly.react + Name("ReactKeyboardEventFrom"), _1Element),
      CastConversion(reactNames.MouseEvent, japgolly.react + Name("ReactMouseEventFrom"), _1Element),
      CastConversion(reactNames.PointerEvent, japgolly.react + Name("ReactPointerEventFrom"), _1Element),
      CastConversion(reactNames.TouchEvent, japgolly.react + Name("ReactTouchEventFrom"), _1Element),
      CastConversion(reactNames.TransitionEvent, japgolly.react + Name("ReactTransitionEventFrom"), _1Element),
      CastConversion(reactNames.UIEvent, japgolly.react + Name("ReactUIEventFrom"), _1Element),
      CastConversion(reactNames.WheelEvent, japgolly.react + Name("ReactWheelEventFrom"), _1Element),
    )
  }
}

package org.scalablytyped.converter.internal.scalajs.flavours

import org.scalablytyped.converter.internal.IArray
import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TParam
import org.scalablytyped.converter.internal.scalajs.{QualifiedName, TypeRef}

object JapgollyTypeConversions {
  def apply(reactNames: ReactNames, scalaJsDomNames: ScalaJsDomNames): IArray[CastConversion] = {
    val _1Element = TParam._1.among(scalaJsDomNames.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
    val _2Element = TParam._2.among(scalaJsDomNames.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
    val _1Object  = TParam._1.among(Set.empty, QualifiedName.Object)

    // format: off
    scalaJsDomNames.All ++ IArray(
      CastConversion(reactNames.ComponentState, QualifiedName.Object),
      CastConversion(reactNames.ReactDOM, QualifiedName.Any),
      CastConversion(reactNames.ReactNode, QualifiedName("japgolly.scalajs.react.raw.React.Node")),
      CastConversion(reactNames.Ref, QualifiedName("japgolly.scalajs.react.raw.React.Ref")),
      CastConversion(reactNames.RefObject, QualifiedName("japgolly.scalajs.react.raw.React.RefHandle"), TParam._1),
      CastConversion(reactNames.Component, QualifiedName("japgolly.scalajs.react.raw.React.Component"), _1Object, TypeRef.Object),
      CastConversion(reactNames.ComponentClass, QualifiedName("japgolly.scalajs.react.raw.React.ComponentClassP"), _1Object),
      CastConversion(reactNames.ReactElement, JapgollyGenComponents.japgolly.reactElement),
      CastConversion(reactNames.DOMElement, QualifiedName("japgolly.scalajs.react.raw.React.DomElement")),
      CastConversion(reactNames.ElementType, QualifiedName("japgolly.scalajs.react.raw.React.ElementType")),
      CastConversion(reactNames.BaseSyntheticEvent, QualifiedName("japgolly.scalajs.react.ReactEventFrom"), _2Element),
      CastConversion(reactNames.ChangeEvent, QualifiedName("japgolly.scalajs.react.ReactEventFrom"), _1Element),
      CastConversion(reactNames.FormEvent, QualifiedName("japgolly.scalajs.react.ReactEventFrom"), _1Element),
      CastConversion(reactNames.InvalidEvent, QualifiedName("japgolly.scalajs.react.ReactEventFrom"), _1Element),
      CastConversion(reactNames.SyntheticEvent, QualifiedName("japgolly.scalajs.react.ReactEventFrom"), _1Element),
      CastConversion(reactNames.AnimationEvent, QualifiedName("japgolly.scalajs.react.ReactAnimationEventFrom"), _1Element),
      CastConversion(reactNames.ClipboardEvent, QualifiedName("japgolly.scalajs.react.ReactClipboardEventFrom"), _1Element),
      CastConversion(reactNames.CompositionEvent, QualifiedName("japgolly.scalajs.react.ReactCompositionEventFrom"), _1Element),
      CastConversion(reactNames.DragEvent, QualifiedName("japgolly.scalajs.react.ReactDragEventFrom"), _1Element),
      CastConversion(reactNames.FocusEvent, QualifiedName("japgolly.scalajs.react.ReactFocusEventFrom"), _1Element),
      CastConversion(reactNames.KeyboardEvent, QualifiedName("japgolly.scalajs.react.ReactKeyboardEventFrom"), _1Element),
      CastConversion(reactNames.MouseEvent, QualifiedName("japgolly.scalajs.react.ReactMouseEventFrom"), _1Element),
      CastConversion(reactNames.PointerEvent, QualifiedName("japgolly.scalajs.react.ReactPointerEventFrom"), _1Element),
      CastConversion(reactNames.TouchEvent, QualifiedName("japgolly.scalajs.react.ReactTouchEventFrom"), _1Element),
      CastConversion(reactNames.TransitionEvent, QualifiedName("japgolly.scalajs.react.ReactTransitionEventFrom"), _1Element),
      CastConversion(reactNames.UIEvent, QualifiedName("japgolly.scalajs.react.ReactUIEventFrom"), _1Element),
      CastConversion(reactNames.WheelEvent, QualifiedName("japgolly.scalajs.react.ReactWheelEventFrom"), _1Element),
    )
    // format: on
  }
}

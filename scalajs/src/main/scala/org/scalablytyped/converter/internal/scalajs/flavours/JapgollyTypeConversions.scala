package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.CastConversion.TParam

object JapgollyTypeConversions {
  def apply(
      reactNames:      ReactNames,
      scalaJsDomNames: ScalaJsDomNames,
      scalaJsLibNames: ScalaJsLibNames,
  ): IArray[CastConversion] = {
    val AllElements = scalaJsDomNames.AllElements + reactNames.JsxReactElement
    val _1Element   = TParam._1.among(AllElements, scalaJsDomNames.Element)
    val _2Element   = TParam._2.among(AllElements, scalaJsDomNames.Element)
    val _1Object    = TParam._1.among(Set.empty, QualifiedName.JsObject)

    scalaJsLibNames.All ++ scalaJsDomNames.All ++ IArray(
      CastConversion(reactNames.ComponentState, QualifiedName.JsObject),
      CastConversion(reactNames.ReactDOM, QualifiedName.JsAny),
      CastConversion(reactNames.ReactNode, JapgollyNames.rawReact.Node),
      CastConversion(reactNames.RefCallback, JapgollyNames.rawReact.RefFn, TParam._1),
      CastConversion(reactNames.RefObject, JapgollyNames.rawReact.RefHandle, TParam._1),
      CastConversion(reactNames.Component, JapgollyNames.rawReact.Component, _1Object, TypeRef.JsObject),
      CastConversion(reactNames.ComponentClass, JapgollyNames.rawReact.ComponentClassP, _1Object),
      CastConversion(reactNames.ReactElement, JapgollyNames.rawReact.Element),
      CastConversion(reactNames.DOMElement, JapgollyNames.rawReact.DomElement),
      CastConversion(reactNames.ElementType, JapgollyNames.rawReact.ElementType),
      CastConversion(reactNames.BaseSyntheticEvent, JapgollyNames.ReactEventFrom, _2Element),
      CastConversion(reactNames.ChangeEvent, JapgollyNames.ReactEventFrom, _1Element),
      CastConversion(reactNames.FormEvent, JapgollyNames.ReactEventFrom, _1Element),
      CastConversion(reactNames.InvalidEvent, JapgollyNames.ReactEventFrom, _1Element),
      CastConversion(reactNames.SyntheticEvent, JapgollyNames.ReactEventFrom, _1Element),
      CastConversion(reactNames.AnimationEvent, JapgollyNames.ReactAnimationEventFrom, _1Element),
      CastConversion(reactNames.ClipboardEvent, JapgollyNames.ReactClipboardEventFrom, _1Element),
      CastConversion(reactNames.CompositionEvent, JapgollyNames.ReactCompositionEventFrom, _1Element),
      CastConversion(reactNames.DragEvent, JapgollyNames.ReactDragEventFrom, _1Element),
      CastConversion(reactNames.FocusEvent, JapgollyNames.ReactFocusEventFrom, _1Element),
      CastConversion(reactNames.KeyboardEvent, JapgollyNames.ReactKeyboardEventFrom, _1Element),
      CastConversion(reactNames.MouseEvent, JapgollyNames.ReactMouseEventFrom, _1Element),
      CastConversion(reactNames.PointerEvent, JapgollyNames.ReactPointerEventFrom, _1Element),
      CastConversion(reactNames.TouchEvent, JapgollyNames.ReactTouchEventFrom, _1Element),
      CastConversion(reactNames.TransitionEvent, JapgollyNames.ReactTransitionEventFrom, _1Element),
      CastConversion(reactNames.UIEvent, JapgollyNames.ReactUIEventFrom, _1Element),
      CastConversion(reactNames.WheelEvent, JapgollyNames.ReactWheelEventFrom, _1Element),
    )
  }
}

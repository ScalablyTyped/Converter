package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.CastConversion.TParam.{_1, _}
import org.scalablytyped.converter.internal.scalajs.flavours.SlinkyGenComponents.names

object SlinkyTypeConversions {
  def apply(
      scalaJsDomNames: ScalaJsDomNames,
      scalaJsLibNames: ScalaJsLibNames,
      reactNames:      ReactNames,
      isWeb:           Boolean,
  ): IArray[CastConversion] = {
    val react: IArray[CastConversion] =
      IArray(
        CastConversion(reactNames.ComponentState, QualifiedName.JsObject),
        CastConversion(reactNames.ReactDOM, QualifiedName.JsAny),
        CastConversion(reactNames.ReactNode, names.ReactElement),
        CastConversion(reactNames.RefObject, names.ReactRef, _1),
        CastConversion(reactNames.ReactElement, names.ReactElement),
        CastConversion(reactNames.DOMElement, names.ReactElement),
        CastConversion(reactNames.ElementType, names.ReactElement),
        CastConversion(reactNames.BaseSyntheticEvent, names.SyntheticEvent, _2, _1),
        CastConversion(reactNames.SyntheticEvent, names.SyntheticEvent, _1, _2),
      )

    val components: IArray[CastConversion] =
      IArray.fromTraversable(
        reactNames.ComponentLike.map(from => CastConversion(from, names.ReactComponentClass, _1)),
      )

    val web = IArray(
      CastConversion(reactNames.AnimationEvent, QualifiedName("slinky.web.SyntheticAnimationEvent"), _1),
      CastConversion(reactNames.ClipboardEvent, QualifiedName("slinky.web.SyntheticClipboardEvent"), _1),
      CastConversion(reactNames.CompositionEvent, QualifiedName("slinky.web.SyntheticCompositionEvent"), _1),
      //        CastConversion(reactNames.DragEvent, QualifiedName("slinky.web.ReactDragEventFrom"), _1Element),
      CastConversion(reactNames.FocusEvent, QualifiedName("slinky.web.SyntheticFocusEvent"), _1),
      CastConversion(reactNames.KeyboardEvent, QualifiedName("slinky.web.SyntheticKeyboardEvent"), _1),
      CastConversion(reactNames.MouseEvent, QualifiedName("slinky.web.SyntheticMouseEvent"), _1),
      CastConversion(reactNames.PointerEvent, QualifiedName("slinky.web.SyntheticPointerEvent"), _1),
      CastConversion(reactNames.TouchEvent, QualifiedName("slinky.web.SyntheticTouchEvent"), _1),
      CastConversion(reactNames.TransitionEvent, QualifiedName("slinky.web.SyntheticTransitionEvent"), _1),
      CastConversion(reactNames.UIEvent, QualifiedName("slinky.web.SyntheticUIEvent"), _1),
      CastConversion(reactNames.WheelEvent, QualifiedName("slinky.web.SyntheticWheelEvent"), _1),
    )

    val shared = scalaJsLibNames.All ++ scalaJsDomNames.All ++ react ++ components

    if (isWeb) shared ++ web else shared
  }
}

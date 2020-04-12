package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TParam.{_1, _}
import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.flavours.GenSlinkyComponents.names._

object SlinkyTypeConversions {
  def apply(
      scalaJsDomNames: ScalaJsDomNames,
      reactNames:      ReactNames,
      isWeb:           Boolean,
  ): TypeRewriterCast = {
    val react: IArray[CastConversion] =
      IArray(
        CastConversion(reactNames.ReactType, ReactComponentClass, _1),
        CastConversion(reactNames.ComponentState, QualifiedName.Object),
        CastConversion(reactNames.ReactDOM, QualifiedName.Any),
        CastConversion(reactNames.ReactNode, TagMod, Ref(TypeRef.ScalaAny)),
        CastConversion(reactNames.RefObject, ReactRef, _1),
        //        CastConversion(reactNames.Component, rawReactComponent, _1, TypeRef.Object),
        //        CastConversion(reactNames.ComponentClass, rawReactComponentClassP, _1Object),
        CastConversion(reactNames.ReactElement, ReactElement),
        CastConversion(reactNames.DOMElement, ReactElement),
        CastConversion(reactNames.ElementType, ReactElement),
        CastConversion(reactNames.BaseSyntheticEvent, SyntheticEvent, _2, _1),
        //        CastConversion(reactNames.ChangeEvent, SyntheticEvent, _2, _1),
        //        CastConversion(reactNames.FormEvent, SyntheticEvent, _2, _1),
        //        CastConversion(reactNames.InvalidEvent, SyntheticEvent, _2, _1),
        CastConversion(reactNames.SyntheticEvent, SyntheticEvent, _2, _1),
      )

    val components: IArray[CastConversion] =
      IArray.fromTraversable(reactNames.ComponentQNames.map(from => CastConversion(from, ReactComponentClass, _1)))

    val web = IArray(
      CastConversion(reactNames.AnimationEvent, slinkyWeb + Name("SyntheticAnimationEvent"), _1),
      CastConversion(reactNames.ClipboardEvent, slinkyWeb + Name("SyntheticClipboardEvent"), _1),
      CastConversion(reactNames.CompositionEvent, slinkyWeb + Name("SyntheticCompositionEvent"), _1),
      //        CastConversion(reactNames.DragEvent, slinkyWeb + Name("ReactDragEventFrom"), _1Element),
      CastConversion(reactNames.FocusEvent, slinkyWeb + Name("SyntheticFocusEvent"), _1),
      CastConversion(reactNames.KeyboardEvent, slinkyWeb + Name("SyntheticKeyboardEvent"), _1),
      CastConversion(reactNames.MouseEvent, slinkyWeb + Name("SyntheticMouseEvent"), _1),
      CastConversion(reactNames.PointerEvent, slinkyWeb + Name("SyntheticPointerEvent"), _1),
      CastConversion(reactNames.TouchEvent, slinkyWeb + Name("SyntheticTouchEvent"), _1),
      CastConversion(reactNames.TransitionEvent, slinkyWeb + Name("SyntheticTransitionEvent"), _1),
      CastConversion(reactNames.UIEvent, slinkyWeb + Name("SyntheticUIEvent"), _1),
      CastConversion(reactNames.WheelEvent, slinkyWeb + Name("SyntheticWheelEvent"), _1),
    )

    val shared = scalaJsDomNames.All ++ react ++ components

    val conversions: IArray[CastConversion] = if (isWeb) shared ++ web else shared

    TypeRewriterCast(conversions)
  }
}

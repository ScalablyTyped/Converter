package typingsJapgolly

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object react {
  import typingsJapgolly.std.AnimationEvent
  import typingsJapgolly.std.ClipboardEvent
  import typingsJapgolly.std.CompositionEvent
  import typingsJapgolly.std.DragEvent
  import typingsJapgolly.std.FocusEvent
  import typingsJapgolly.std.KeyboardEvent
  import typingsJapgolly.std.MouseEvent
  import typingsJapgolly.std.PointerEvent
  import typingsJapgolly.std.TouchEvent
  import typingsJapgolly.std.TransitionEvent
  import typingsJapgolly.std.UIEvent
  import typingsJapgolly.std.WheelEvent

  type NativeAnimationEvent = AnimationEvent
  type NativeClipboardEvent = ClipboardEvent
  type NativeCompositionEvent = CompositionEvent
  type NativeDragEvent = DragEvent
  type NativeFocusEvent = FocusEvent
  type NativeKeyboardEvent = KeyboardEvent
  type NativeMouseEvent = MouseEvent
  type NativePointerEvent = PointerEvent
  type NativeTouchEvent = TouchEvent
  type NativeTransitionEvent = TransitionEvent
  type NativeUIEvent = UIEvent
  type NativeWheelEvent = WheelEvent
  type NotExactlyAnyPropertyKeys[T] = /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Exclude<keyof T, ExactlyAnyPropertyKeys<T>> */ js.Any
}

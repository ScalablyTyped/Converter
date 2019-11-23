package typingsSlinky

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object react {
  import typingsSlinky.std.AnimationEvent
  import typingsSlinky.std.ClipboardEvent
  import typingsSlinky.std.CompositionEvent
  import typingsSlinky.std.DragEvent
  import typingsSlinky.std.FocusEvent
  import typingsSlinky.std.KeyboardEvent
  import typingsSlinky.std.MouseEvent
  import typingsSlinky.std.PointerEvent
  import typingsSlinky.std.TouchEvent
  import typingsSlinky.std.TransitionEvent
  import typingsSlinky.std.UIEvent
  import typingsSlinky.std.WheelEvent

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

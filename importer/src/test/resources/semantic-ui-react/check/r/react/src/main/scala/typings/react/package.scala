package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object react {
<<<<<<< HEAD
  type AnimationEvent = Event
  type ClipboardEvent = Event
  type CompositionEvent = Event
  type DragEvent = Event
  type FocusEvent = Event
  type KeyboardEvent = Event
  type MouseEvent = Event
=======
  import typings.std.AnimationEvent
  import typings.std.ClipboardEvent
  import typings.std.CompositionEvent
  import typings.std.DragEvent
  import typings.std.FocusEvent
  import typings.std.KeyboardEvent
  import typings.std.MouseEvent
  import typings.std.PointerEvent
  import typings.std.TouchEvent
  import typings.std.TransitionEvent
  import typings.std.UIEvent
  import typings.std.WheelEvent

>>>>>>> oyvindberg/plugin+jagpolly+slinky
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
<<<<<<< HEAD
  type PointerEvent = Event
  type TouchEvent = Event
  type TransitionEvent = Event
  type UIEvent = Event
  type WheelEvent = Event
=======
>>>>>>> oyvindberg/plugin+jagpolly+slinky
}

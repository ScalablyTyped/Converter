package typingsSlinky

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object react {
  import org.scalajs.dom.raw.AnimationEvent
  import org.scalajs.dom.raw.ClipboardEvent
  import org.scalajs.dom.raw.CompositionEvent
  import org.scalajs.dom.raw.DragEvent
  import org.scalajs.dom.raw.FocusEvent
  import org.scalajs.dom.raw.KeyboardEvent
  import org.scalajs.dom.raw.MouseEvent
  import org.scalajs.dom.raw.PointerEvent
  import org.scalajs.dom.raw.TouchEvent
  import org.scalajs.dom.raw.TransitionEvent
  import org.scalajs.dom.raw.UIEvent
  import org.scalajs.dom.raw.WheelEvent

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

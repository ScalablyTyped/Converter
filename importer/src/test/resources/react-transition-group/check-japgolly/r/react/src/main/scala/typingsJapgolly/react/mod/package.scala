package typingsJapgolly.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  import org.scalajs.dom.raw.AnimationEvent

  type ComponentState = js.Object
  type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] with E
  type Key = String | Double
  type NativeAnimationEvent = AnimationEvent
  type ReactNode = js.UndefOr[String | Double | Boolean]
  type ReactType[P] = String | ComponentType[P]
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, js.Any])
  type SFC[P] = StatelessComponent[P]
  type SVGAttributes[T] = DOMAttributes[T]
  type SVGProps[T] = ClassAttributes[T]
}

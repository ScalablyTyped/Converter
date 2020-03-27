package typingsSlinky.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type ComponentState = js.Object
  type DetailedHTMLProps[E /* <: typingsSlinky.react.mod.HTMLAttributes[T] */, T] = typingsSlinky.react.mod.ClassAttributes[T] with E
  type Key = java.lang.String | scala.Double
  type NativeAnimationEvent = org.scalajs.dom.raw.AnimationEvent
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean]
  type ReactType[P] = java.lang.String | slinky.core.ReactComponentClass[P]
  type Ref[T] = java.lang.String | (js.Function1[/* instance */ T | scala.Null, js.Any])
  type SFC[P] = slinky.core.ReactComponentClass[P]
  type SVGAttributes[T] = typingsSlinky.react.mod.DOMAttributes[T]
  type SVGProps[T] = typingsSlinky.react.mod.ClassAttributes[T]
}

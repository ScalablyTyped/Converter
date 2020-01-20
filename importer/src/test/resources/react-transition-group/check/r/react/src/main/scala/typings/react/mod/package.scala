package typings.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type ComponentState = js.Object
  type DetailedHTMLProps[E /* <: typings.react.mod.HTMLAttributes[T] */, T] = typings.react.mod.ClassAttributes[T] with E
  type Key = java.lang.String | scala.Double
  type NativeAnimationEvent = typings.std.AnimationEvent
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean]
  type ReactType[P] = java.lang.String | typings.react.mod.ComponentType[P]
  type Ref[T] = java.lang.String | (js.Function1[/* instance */ T | scala.Null, js.Any])
  type SFC[P] = typings.react.mod.StatelessComponent[P]
  type SVGAttributes[T] = typings.react.mod.DOMAttributes[T]
  type SVGProps[T] = typings.react.mod.ClassAttributes[T]
}

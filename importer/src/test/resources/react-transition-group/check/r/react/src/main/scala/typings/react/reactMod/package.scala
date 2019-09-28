package typings.react

import scala.scalajs.js
import scala.scalajs.js.`|`

package object reactMod {
  type ComponentState = js.Object
  type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] with E
  type Key = String | Double
  type ReactNode = js.UndefOr[String | Double | Boolean]
  type ReactType[P] = String | ComponentType[P]
  type Ref[T] = String | (js.Function1[/* instance */ T | Null, js.Any])
  type SFC[P] = StatelessComponent[P]
  type SVGProps[T] = ClassAttributes[T]
}

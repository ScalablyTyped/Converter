package typings.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactMod {
  import org.scalablytyped.runtime.NullOr
  import org.scalablytyped.runtime.UndefOr

  type ComponentState = js.Object
  type DetailedHTMLProps[E /* <: HTMLAttributes[T] */, T] = ClassAttributes[T] with E
  type Key = String | Double
  type ReactNode = UndefOr[String | Double | Boolean]
  type ReactType[P] = String | ComponentType[P]
  type Ref[T] = String | (js.Function1[NullOr[T], js.Any])
  type SFC[P] = StatelessComponent[P]
  type SVGProps[T] = ClassAttributes[T]
}

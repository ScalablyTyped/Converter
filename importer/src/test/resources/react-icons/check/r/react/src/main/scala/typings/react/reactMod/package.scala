package typings.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactMod {
  import org.scalablytyped.runtime.NullOr
  import org.scalablytyped.runtime.NullUndefOr
  import org.scalablytyped.runtime.UndefOr
  import typings.react.Element

  type ComponentState = js.Object
  type DOMFactory[P /* <: DOMAttributes[T] */, T /* <: Element */] = js.Function2[NullUndefOr[ClassAttributes[T] with P], /* repeated */ ReactNode, DOMElement[P, T]]
  type Key = String | Double
  type ReactNode = UndefOr[String | Double | Boolean]
  type Ref[T] = String | (js.Function1[NullOr[T], js.Any])
  type SFC[P] = StatelessComponent[P]
  type SVGProps[T] = ClassAttributes[T]
}

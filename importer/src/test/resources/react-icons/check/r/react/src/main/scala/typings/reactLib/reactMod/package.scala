package typings
package reactLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object reactMod {
  type ComponentState = js.Object
  type DOMFactory[P /* <: DOMAttributes[T] */, T /* <: reactLib.Element */] = js.Function2[
    /* props */ js.UndefOr[ClassAttributes[T] with (P | scala.Null)], 
    /* repeated */ ReactNode, 
    DOMElement[P, T]
  ]
  type Key = java.lang.String | scala.Double
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean]
  type Ref[T] = java.lang.String | (js.Function1[/* instance */ T | scala.Null, js.Any])
  type SFC[P] = StatelessComponent[P]
  type SVGProps[T] = ClassAttributes[T]
}

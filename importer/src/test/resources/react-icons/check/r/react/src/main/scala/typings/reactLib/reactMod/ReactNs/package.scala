package typings
package reactLib.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object ReactNs {
  type DOMFactory[P /* <: DOMAttributes[T] */, T /* <: reactLib.Element */] = js.Function2[
    /* props */ js.UndefOr[ClassAttributes[T] with (P | scala.Null)], 
    /* repeated */ ReactNode, 
    DOMElement[P, T]
  ]
  type Key = java.lang.String | scala.Double
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean | scala.Null]
  type Ref[T] = java.lang.String | (js.Function1[/* instance */ T | scala.Null, js.Any])
  type SVGProps[T] = ClassAttributes[T]
}

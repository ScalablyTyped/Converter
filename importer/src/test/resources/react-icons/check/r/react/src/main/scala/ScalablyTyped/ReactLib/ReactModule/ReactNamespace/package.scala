package ScalablyTyped
package ReactLib
package ReactModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object ReactNamespace {
  type DOMFactory[P /* <: ReactLib.ReactModule.ReactNamespace.DOMAttributes[T] */, T /* <: ReactLib.Element */] = js.Function2[/* props */ js.UndefOr[(P | scala.Null) with ReactLib.ReactModule.ReactNamespace.ClassAttributes[T]], /* repeated */ReactLib.ReactModule.ReactNamespace.ReactNode, ReactLib.ReactModule.ReactNamespace.DOMElement[P, T]]
  type Key = java.lang.String | scala.Double
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean | scala.Null]
  type Ref[T] = java.lang.String | (js.Function1[/* instance */ T | scala.Null, js.Any])
  type SVGProps[T] = ReactLib.ReactModule.ReactNamespace.ClassAttributes[T]
}

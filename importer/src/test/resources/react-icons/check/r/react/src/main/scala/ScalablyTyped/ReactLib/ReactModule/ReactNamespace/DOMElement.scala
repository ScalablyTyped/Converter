package ScalablyTyped
package ReactLib
package ReactModule
package ReactNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// string fallback for custom web-components

trait DOMElement[P /* <: ReactLib.ReactModule.ReactNamespace.HTMLAttributes[T] | ReactLib.ReactModule.ReactNamespace.SVGAttributes[T] */, T /* <: ReactLib.Element */] extends ReactLib.ReactModule.ReactNamespace.ReactElement[P] {
  val ref: ReactLib.ReactModule.ReactNamespace.Ref[T]
  @JSName("type")
  val type_DOMElement: java.lang.String
}


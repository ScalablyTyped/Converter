package ScalablyTyped
package ReactLib.ReactModule.ReactNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// string fallback for custom web-components

trait DOMElement[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: ReactLib.Element */] extends ReactElement[P] {
  val ref: Ref[T]
  @JSName("type")
  val type_DOMElement: java.lang.String
}


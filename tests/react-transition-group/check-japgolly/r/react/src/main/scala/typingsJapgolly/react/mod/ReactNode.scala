package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - java.lang.String
  - scala.Double
  - scala.Boolean
  - js.UndefOr[scala.Nothing]
*/
trait ReactNode extends js.Object

object ReactNode {
  @scala.inline
  implicit def apply(value: Boolean): Node = value.asInstanceOf[Node]
  @scala.inline
  implicit def apply(value: Double): Node = value.asInstanceOf[Node]
  @scala.inline
  implicit def apply(value: String): Node = value.asInstanceOf[Node]
  @scala.inline
  implicit def fromUndef[T](value: js.UndefOr[T])(implicit ev: T => Node): Node = value.map(ev).asInstanceOf[T]
}


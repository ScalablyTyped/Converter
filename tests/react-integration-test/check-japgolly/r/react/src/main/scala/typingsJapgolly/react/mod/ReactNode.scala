package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsJapgolly.react.mod.ReactChild
  - typingsJapgolly.react.mod.ReactFragment
  - typingsJapgolly.react.mod.ReactPortal
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
  implicit def apply(value: js.Object): Node = value.asInstanceOf[Node]
  @scala.inline
  implicit def apply(value: Element): Node = value.asInstanceOf[Node]
  @scala.inline
  implicit def apply(value: ReactNodeArray): Node = value.asInstanceOf[Node]
  @scala.inline
  implicit def apply(value: ReactPortal): Node = value.asInstanceOf[Node]
  @scala.inline
  implicit def apply(value: String): Node = value.asInstanceOf[Node]
  @scala.inline
  implicit def fromUndef[T](value: js.UndefOr[T])(implicit ev: T => Node): Node = value.map(ev).asInstanceOf[T]
}


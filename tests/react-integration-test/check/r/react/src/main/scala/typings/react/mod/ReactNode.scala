package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.react.mod.ReactChild
  - typings.react.mod.ReactFragment
  - typings.react.mod.ReactPortal
  - scala.Boolean
  - js.UndefOr[scala.Nothing]
*/
trait ReactNode extends js.Object

object ReactNode {
  @scala.inline
  implicit def apply(value: Boolean): ReactNode = value.asInstanceOf[ReactNode]
  @scala.inline
  implicit def apply(value: Double): ReactNode = value.asInstanceOf[ReactNode]
  @scala.inline
  implicit def apply(value: js.Object): ReactNode = value.asInstanceOf[ReactNode]
  @scala.inline
  implicit def apply(value: ReactElement): ReactNode = value.asInstanceOf[ReactNode]
  @scala.inline
  implicit def apply(value: ReactNodeArray): ReactNode = value.asInstanceOf[ReactNode]
  @scala.inline
  implicit def apply(value: ReactPortal): ReactNode = value.asInstanceOf[ReactNode]
  @scala.inline
  implicit def apply(value: String): ReactNode = value.asInstanceOf[ReactNode]
  @scala.inline
  implicit def fromUndef[T](value: js.UndefOr[T])(implicit ev: T => ReactNode): ReactNode = value.map(ev).asInstanceOf[T]
}


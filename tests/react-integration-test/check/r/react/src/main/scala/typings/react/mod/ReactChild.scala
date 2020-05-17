package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.react.mod.ReactElement
  - typings.react.mod.ReactText
*/
trait ReactChild extends ReactNode

object ReactChild {
  @scala.inline
  implicit def apply(value: Double): ReactChild = value.asInstanceOf[ReactChild]
  @scala.inline
  implicit def apply(value: ReactElement): ReactChild = value.asInstanceOf[ReactChild]
  @scala.inline
  implicit def apply(value: String): ReactChild = value.asInstanceOf[ReactChild]
}


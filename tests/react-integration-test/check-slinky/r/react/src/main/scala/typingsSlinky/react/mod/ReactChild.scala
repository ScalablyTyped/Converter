package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsSlinky.react.mod.ReactElement
  - typingsSlinky.react.mod.ReactText
*/
trait ReactChild extends ReactNode

object ReactChild {
  @scala.inline
  implicit def apply(value: Double): ReactChild = value.asInstanceOf[ReactChild]
  @scala.inline
  implicit def apply(value: slinky.core.facade.ReactElement): ReactChild = value.asInstanceOf[ReactChild]
  @scala.inline
  implicit def apply(value: String): ReactChild = value.asInstanceOf[ReactChild]
}


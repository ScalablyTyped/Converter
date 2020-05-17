package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsJapgolly.react.mod.ReactElement
  - typingsJapgolly.react.mod.ReactText
*/
trait ReactChild extends ReactNode

object ReactChild {
  @scala.inline
  implicit def apply(value: Double): ReactChild = value.asInstanceOf[ReactChild]
  @scala.inline
  implicit def apply(value: Element): ReactChild = value.asInstanceOf[ReactChild]
  @scala.inline
  implicit def apply(value: String): ReactChild = value.asInstanceOf[ReactChild]
}


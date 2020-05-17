package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - js.Object
  - typingsSlinky.react.mod.ReactNodeArray
*/
trait ReactFragment extends ReactNode

object ReactFragment {
  @scala.inline
  implicit def apply(value: js.Object): ReactFragment = value.asInstanceOf[ReactFragment]
  @scala.inline
  implicit def apply(value: ReactNodeArray): ReactFragment = value.asInstanceOf[ReactFragment]
}


package typingsSlinky.react.mod

import org.scalajs.dom.raw.Element
import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// Component API
// ----------------------------------------------------------------------
/* Rewritten from type alias, can be one of: 
  - typingsSlinky.react.mod.Component[js.Any, js.Object, js.Any]
  - typingsSlinky.std.Element
*/
trait ReactInstance extends js.Object

object ReactInstance {
  @scala.inline
  implicit def apply(value: ReactComponentClass[js.Any]): ReactInstance = value.asInstanceOf[ReactInstance]
  @scala.inline
  implicit def apply(value: Element): ReactInstance = value.asInstanceOf[ReactInstance]
}


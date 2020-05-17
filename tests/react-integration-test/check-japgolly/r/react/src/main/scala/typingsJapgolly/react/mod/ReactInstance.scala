package typingsJapgolly.react.mod

import org.scalajs.dom.raw.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// Component API
// ----------------------------------------------------------------------
/* Rewritten from type alias, can be one of: 
  - typingsJapgolly.react.mod.Component[js.Any, js.Object, js.Any]
  - typingsJapgolly.std.Element
*/
trait ReactInstance extends js.Object

object ReactInstance {
  @scala.inline
  implicit def apply(value: japgolly.scalajs.react.raw.React.Component[js.Any with js.Object, js.Object]): ReactInstance = value.asInstanceOf[ReactInstance]
  @scala.inline
  implicit def apply(value: Element): ReactInstance = value.asInstanceOf[ReactInstance]
}


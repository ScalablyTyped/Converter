package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.ComponentClassP
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - java.lang.String
  - typingsJapgolly.react.mod.ComponentType[P]
*/
trait ReactType[P] extends js.Object

object ReactType {
  @scala.inline
  implicit def apply[P](value: ComponentClassP[P with js.Object]): ReactType[P] = value.asInstanceOf[ReactType[P]]
  @scala.inline
  implicit def apply[P](value: StatelessComponent[P]): ReactType[P] = value.asInstanceOf[ReactType[P]]
  @scala.inline
  implicit def apply[P](value: String): ReactType[P] = value.asInstanceOf[ReactType[P]]
}


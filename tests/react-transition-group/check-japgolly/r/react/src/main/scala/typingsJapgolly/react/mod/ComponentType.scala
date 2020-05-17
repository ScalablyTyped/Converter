package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.ComponentClassP
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsJapgolly.react.mod.ComponentClass[P]
  - typingsJapgolly.react.mod.StatelessComponent[P]
*/
trait ComponentType[P] extends ReactType[P]

object ComponentType {
  @scala.inline
  implicit def apply[P](value: ComponentClassP[P with js.Object]): ComponentType[P] = value.asInstanceOf[ComponentType[P]]
  @scala.inline
  implicit def apply[P](value: StatelessComponent[P]): ComponentType[P] = value.asInstanceOf[ComponentType[P]]
}


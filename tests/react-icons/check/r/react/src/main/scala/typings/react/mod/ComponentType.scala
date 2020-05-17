package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.react.mod.ComponentClass[P]
  - typings.react.mod.StatelessComponent[P]
*/
trait ComponentType[P] extends js.Object

object ComponentType {
  @scala.inline
  implicit def apply[P](value: ComponentClass[P]): ComponentType[P] = value.asInstanceOf[ComponentType[P]]
  @scala.inline
  implicit def apply[P](value: StatelessComponent[P]): ComponentType[P] = value.asInstanceOf[ComponentType[P]]
}


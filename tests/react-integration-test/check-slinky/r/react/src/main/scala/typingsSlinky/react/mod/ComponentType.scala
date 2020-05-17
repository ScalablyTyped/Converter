package typingsSlinky.react.mod

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsSlinky.react.mod.ComponentClass[P, typingsSlinky.react.mod.ComponentState]
  - typingsSlinky.react.mod.FunctionComponent[P]
*/
trait ComponentType[P] extends js.Object

object ComponentType {
  @scala.inline
  implicit def apply[P](value: ComponentClass[P, js.Object]): ReactComponentClass[P] = value.asInstanceOf[ReactComponentClass[P]]
  @scala.inline
  implicit def apply[P](value: FunctionComponent[P]): ReactComponentClass[P] = value.asInstanceOf[ReactComponentClass[P]]
}


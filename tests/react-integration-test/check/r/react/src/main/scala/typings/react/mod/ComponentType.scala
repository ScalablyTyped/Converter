package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.react.mod.ComponentClass[P, typings.react.mod.ComponentState]
  - typings.react.mod.FunctionComponent[P]
*/
trait ComponentType[P] extends ElementType[P]

object ComponentType {
  @scala.inline
  implicit def apply[P](value: ComponentClass[P, ComponentState]): ComponentType[P] = value.asInstanceOf[ComponentType[P]]
  @scala.inline
  implicit def apply[P](value: FunctionComponent[P]): ComponentType[P] = value.asInstanceOf[ComponentType[P]]
}


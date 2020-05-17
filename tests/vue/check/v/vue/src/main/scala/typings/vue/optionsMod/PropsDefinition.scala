package typings.vue.optionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.vue.optionsMod.ArrayPropsDefinition[T]
  - typings.vue.optionsMod.RecordPropsDefinition[T]
*/
trait PropsDefinition[T] extends js.Object

object PropsDefinition {
  @scala.inline
  implicit def apply[T](value: ArrayPropsDefinition[T]): PropsDefinition[T] = value.asInstanceOf[PropsDefinition[T]]
  @scala.inline
  implicit def apply[T](value: RecordPropsDefinition[T]): PropsDefinition[T] = value.asInstanceOf[PropsDefinition[T]]
}


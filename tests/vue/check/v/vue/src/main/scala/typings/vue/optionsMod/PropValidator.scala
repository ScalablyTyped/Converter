package typings.vue.optionsMod

import typings.vue.anon.Instantiable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.vue.optionsMod.PropOptions[T]
  - typings.vue.optionsMod.Prop[T]
  - js.Array[typings.vue.optionsMod.Prop[T]]
*/
trait PropValidator[T] extends js.Object

object PropValidator {
  @scala.inline
  implicit def apply[T](value: js.Array[Prop[T]]): PropValidator[T] = value.asInstanceOf[PropValidator[T]]
  @scala.inline
  implicit def apply[T](value: js.Function0[T]): PropValidator[T] = value.asInstanceOf[PropValidator[T]]
  @scala.inline
  implicit def apply[T](value: Instantiable[T]): PropValidator[T] = value.asInstanceOf[PropValidator[T]]
  @scala.inline
  implicit def apply[T](value: PropOptions[T]): PropValidator[T] = value.asInstanceOf[PropValidator[T]]
}


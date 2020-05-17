package typings.vue.optionsMod

import typings.vue.anon.Instantiable
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - js.Function0[T]
  - typings.vue.anon.Instantiable[T]
*/
trait Prop[T] extends PropValidator[T]

object Prop {
  @scala.inline
  implicit def apply[T](value: js.Function0[T]): Prop[T] = value.asInstanceOf[Prop[T]]
  @scala.inline
  implicit def apply[T](value: Instantiable[T]): Prop[T] = value.asInstanceOf[Prop[T]]
}


package typings.vue.vnodeMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.vue.vnodeMod.VNodeChildrenArrayContents
  - js.Array[typings.vue.vnodeMod.ScopedSlot]
  - java.lang.String
*/
trait VNodeChildren extends js.Object

object VNodeChildren {
  @scala.inline
  implicit def apply(value: js.Array[ScopedSlot]): VNodeChildren = value.asInstanceOf[VNodeChildren]
  @scala.inline
  implicit def apply(value: String): VNodeChildren = value.asInstanceOf[VNodeChildren]
  @scala.inline
  implicit def apply(value: VNodeChildrenArrayContents): VNodeChildren = value.asInstanceOf[VNodeChildren]
}


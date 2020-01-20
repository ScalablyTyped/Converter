package typings.vue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object vnodeMod {
  type ScopedSlot = js.Function1[
    /* props */ js.Any, 
    typings.vue.vnodeMod.VNodeChildrenArrayContents | java.lang.String
  ]
  type VNodeChildren = typings.vue.vnodeMod.VNodeChildrenArrayContents | js.Array[typings.vue.vnodeMod.ScopedSlot] | java.lang.String
}

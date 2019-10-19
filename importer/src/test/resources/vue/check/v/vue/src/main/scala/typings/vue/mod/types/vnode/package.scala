package typings.vue.mod.types

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object vnode {
  type ScopedSlot = js.Function1[/* props */ js.Any, VNodeChildrenArrayContents | String]
  type VNodeChildren = VNodeChildrenArrayContents | js.Array[ScopedSlot] | String
}

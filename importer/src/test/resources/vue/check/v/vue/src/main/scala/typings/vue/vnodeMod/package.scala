package typings.vue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object vnodeMod {
  type ScopedSlot = js.Function1[/* props */ js.Any, VNodeChildrenArrayContents | String]
  type VNodeChildren = VNodeChildrenArrayContents | js.Array[ScopedSlot] | String
}

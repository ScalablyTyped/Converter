package typings.vueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typesVnodeMod {
  type ScopedSlot = js.Function1[/* props */ js.Any, VNodeChildrenArrayContents | String]
  type VNodeChildren = VNodeChildrenArrayContents | js.Array[ScopedSlot] | String
}

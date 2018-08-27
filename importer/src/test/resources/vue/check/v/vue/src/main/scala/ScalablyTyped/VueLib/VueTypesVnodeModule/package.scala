package ScalablyTyped
package VueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object VueTypesVnodeModule {
  type ScopedSlot = js.Function1[/* props */ js.Any, VNodeChildrenArrayContents | java.lang.String]
  type VNodeChildren = VNodeChildrenArrayContents | js.Array[ScopedSlot] | java.lang.String
}

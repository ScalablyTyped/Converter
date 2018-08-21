package ScalablyTyped
package VueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object VueTypesVnodeModule {
  type ScopedSlot = js.Function1[/* props */ js.Any, VueLib.VueTypesVnodeModule.VNodeChildrenArrayContents | java.lang.String]
  type VNodeChildren = VueLib.VueTypesVnodeModule.VNodeChildrenArrayContents | js.Array[VueLib.VueTypesVnodeModule.ScopedSlot] | java.lang.String
}

package ScalablyTyped
package VueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object VueTypesPluginModule {
  type PluginFunction[T] = js.Function2[/* Vue */ VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue], /* options */ js.UndefOr[T], scala.Unit]
}

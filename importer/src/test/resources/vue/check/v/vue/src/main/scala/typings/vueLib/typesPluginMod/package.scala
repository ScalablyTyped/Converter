package typings.vueLib

import typings.vueLib.typesVueMod.Vue
import typings.vueLib.typesVueMod.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typesPluginMod {
  type PluginFunction[T] = js.Function2[/* Vue */ VueConstructor[Vue], /* options */ js.UndefOr[T], Unit]
}

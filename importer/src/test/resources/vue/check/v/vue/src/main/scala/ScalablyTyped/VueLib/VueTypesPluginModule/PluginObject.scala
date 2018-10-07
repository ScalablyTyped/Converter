package ScalablyTyped
package VueLib.VueTypesPluginModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait PluginObject[T] extends /* key */ ScalablyTyped.runtime.StringDictionary[js.Any] {
  @JSName("install")
  val install_Original: PluginFunction[T] = js.native
  def install(Vue: VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue]): scala.Unit = js.native
  def install(Vue: VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue], options: T): scala.Unit = js.native
}


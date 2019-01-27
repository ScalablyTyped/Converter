package typings
package vueLib.pluginMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait PluginObject[T]
  extends /* key */ org.scalablytyped.runtime.StringDictionary[js.Any] {
  @JSName("install")
  var install_Original: PluginFunction[T] = js.native
  def install(Vue: vueLib.vueVueMod.VueConstructor[vueLib.vueVueMod.Vue]): scala.Unit = js.native
  def install(Vue: vueLib.vueVueMod.VueConstructor[vueLib.vueVueMod.Vue], options: T): scala.Unit = js.native
}


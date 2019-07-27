package typings
package vueLib.typesPluginMod

import org.scalablytyped.runtime.StringDictionary
import vueLib.typesVueMod.Vue
import vueLib.typesVueMod.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait PluginObject[T]
  extends /* key */ StringDictionary[js.Any] {
  @JSName("install")
  var install_Original: PluginFunction[T] = js.native
  def install(Vue: VueConstructor[Vue]): Unit = js.native
  def install(Vue: VueConstructor[Vue], options: T): Unit = js.native
}


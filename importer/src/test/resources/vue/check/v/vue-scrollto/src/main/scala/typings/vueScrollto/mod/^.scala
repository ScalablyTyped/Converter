package typings.vueScrollto.mod

import typings.vue.mod.types.plugin.PluginFunction
import typings.vue.mod.types.vue.Vue
import typings.vue.mod.types.vue.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("vue-scrollto", JSImport.Namespace)
@js.native
class ^ () extends VueScrollTo

@JSImport("vue-scrollto", JSImport.Namespace)
@js.native
object ^ extends js.Object {
  @JSName("install")
  var install_Original: PluginFunction[scala.Nothing] = js.native
  def install(Vue: VueConstructor[Vue]): Unit = js.native
  def install(Vue: VueConstructor[Vue], options: scala.Nothing): Unit = js.native
}


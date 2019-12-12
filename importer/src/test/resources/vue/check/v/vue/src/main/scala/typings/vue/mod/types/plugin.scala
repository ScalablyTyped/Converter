package typings.vue.mod.types

import org.scalablytyped.runtime.StringDictionary
import typings.vue.mod.types.vue.Vue
import typings.vue.mod.types.vue.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("vue/types/plugin", JSImport.Namespace)
@js.native
object plugin extends js.Object {
  @js.native
  trait PluginObject[T]
    extends /* key */ StringDictionary[js.Any] {
    @JSName("install")
    var install_Original: PluginFunction[T] = js.native
    def install(Vue: VueConstructor[Vue]): Unit = js.native
    def install(Vue: VueConstructor[Vue], options: T): Unit = js.native
  }
  
  type PluginFunction[T] = js.Function2[/* Vue */ VueConstructor[Vue], /* options */ js.UndefOr[T], Unit]
}


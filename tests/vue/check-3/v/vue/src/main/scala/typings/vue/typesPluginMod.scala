package typings.vue

import _root_.typings.vue.typesVueMod.Vue
import _root_.typings.vue.typesVueMod.VueConstructor
import org.scalablytyped.runtime.StringDictionary
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object typesPluginMod {
  
  type PluginFunction[T] = js.Function2[/* Vue */ VueConstructor[Vue], /* options */ js.UndefOr[T], Unit]
  
  trait PluginObject[T]
    extends StObject
       with /* key */ StringDictionary[Any] {
    
    def install(Vue: VueConstructor[Vue]): Unit
    def install(Vue: VueConstructor[Vue], options: T): Unit
    @JSName("install")
    var install_Original: PluginFunction[T]
  }
  object PluginObject {
    
    inline def apply[T](install: (/* Vue */ VueConstructor[Vue], /* options */ js.UndefOr[T]) => Unit): PluginObject[T] = {
      val __obj = js.Dynamic.literal(install = js.Any.fromFunction2(install))
      __obj.asInstanceOf[PluginObject[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: PluginObject[?], T] (val x: Self & PluginObject[T]) extends AnyVal {
      
      inline def setInstall(value: (/* Vue */ VueConstructor[Vue], /* options */ js.UndefOr[T]) => Unit): Self = StObject.set(x, "install", js.Any.fromFunction2(value))
    }
  }
}

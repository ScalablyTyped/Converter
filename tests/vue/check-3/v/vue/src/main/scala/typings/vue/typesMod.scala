package typings.vue

import org.scalablytyped.runtime.Shortcut
import typings.vue.typesVueMod.Vue
import typings.vue.typesVueMod.VueConstructor
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object typesMod extends Shortcut {
  
  @JSImport("vue/types", JSImport.Default)
  @js.native
  val default: VueConstructor[Vue] = js.native
  
  type _To = VueConstructor[Vue]
  
  /* This means you don't have to write `default`, but can instead just say `typesMod.foo` */
  override def _to: VueConstructor[Vue] = default
}

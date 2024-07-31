package typings.vue

import _root_.typings.vue.typesVueMod.Vue
import _root_.typings.vue.typesVueMod.VueConstructor
import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod extends Shortcut {
  
  @JSImport("vue", JSImport.Default)
  @js.native
  val default: VueConstructor[Vue] = js.native
  
  type _To = VueConstructor[Vue]
  
  /* This means you don't have to write `default`, but can instead just say `mod.foo` */
  override def _to: VueConstructor[Vue] = default
}

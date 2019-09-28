package typings.vue.typesOptionsMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.vue.typesVueMod.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`

trait EsModuleComponent extends js.Object {
  var default: Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]
}

object EsModuleComponent {
  @inline
  def apply(default: Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]): EsModuleComponent = {
    val __obj = js.Dynamic.literal(default = default.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[EsModuleComponent]
  }
}


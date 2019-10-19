package typings.vue.mod.types.options

import typings.vue.mod.types.vue.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait EsModuleComponent extends js.Object {
  var default: Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]
}

object EsModuleComponent {
  @scala.inline
  def apply(default: Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]): EsModuleComponent = {
    val __obj = js.Dynamic.literal(default = default.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[EsModuleComponent]
  }
}


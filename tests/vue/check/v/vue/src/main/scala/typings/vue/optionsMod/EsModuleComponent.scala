package typings.vue.optionsMod

import typings.vue.vueMod.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait EsModuleComponent extends js.Object {
  var default: Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps] = js.native
}

object EsModuleComponent {
  @scala.inline
  def apply(default: Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]): EsModuleComponent = {
    val __obj = js.Dynamic.literal(default = default.asInstanceOf[js.Any])
    __obj.asInstanceOf[EsModuleComponent]
  }
}


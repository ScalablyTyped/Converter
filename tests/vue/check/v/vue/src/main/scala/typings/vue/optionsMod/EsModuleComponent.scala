package typings.vue.optionsMod

import typings.vue.vueMod.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
  
  @scala.inline
  implicit class EsModuleComponentOps[Self <: EsModuleComponent] (val x: Self) extends AnyVal {
    
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    
    @scala.inline
    def set(key: String, value: js.Any): Self = {
      x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
      x
    }
    
    @scala.inline
    def setDefault(value: Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]): Self = this.set("default", value.asInstanceOf[js.Any])
  }
}

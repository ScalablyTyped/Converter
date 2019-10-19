package typings.storybookVue.mod

import typings.vue.mod.types.options.ComponentOptions
import typings.vue.mod.types.options.DefaultComputed
import typings.vue.mod.types.options.DefaultData
import typings.vue.mod.types.options.DefaultMethods
import typings.vue.mod.types.options.DefaultProps
import typings.vue.mod.types.options.PropsDefinition
import typings.vue.mod.types.vue.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StoryObject extends js.Object {
  var name: String = js.native
  @JSName("render")
  var render_Original: StoryFunction = js.native
  def render(): (ComponentOptions[
    Vue, 
    DefaultData[Vue], 
    DefaultMethods[Vue], 
    DefaultComputed, 
    PropsDefinition[DefaultProps]
  ]) | String = js.native
}


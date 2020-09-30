package typings.storybookVue.mod

import typings.vue.optionsMod.ComponentOptions
import typings.vue.optionsMod.DefaultComputed
import typings.vue.optionsMod.DefaultData
import typings.vue.optionsMod.DefaultMethods
import typings.vue.optionsMod.DefaultProps
import typings.vue.optionsMod.PropsDefinition
import typings.vue.vueMod.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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


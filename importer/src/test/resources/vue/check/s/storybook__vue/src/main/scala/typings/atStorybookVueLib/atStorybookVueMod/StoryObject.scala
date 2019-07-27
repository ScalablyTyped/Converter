package typings.atStorybookVueLib.atStorybookVueMod

import typings.vueLib.typesOptionsMod.ComponentOptions
import typings.vueLib.typesOptionsMod.DefaultComputed
import typings.vueLib.typesOptionsMod.DefaultData
import typings.vueLib.typesOptionsMod.DefaultMethods
import typings.vueLib.typesOptionsMod.DefaultProps
import typings.vueLib.typesOptionsMod.PropsDefinition
import typings.vueLib.typesVueMod.Vue
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


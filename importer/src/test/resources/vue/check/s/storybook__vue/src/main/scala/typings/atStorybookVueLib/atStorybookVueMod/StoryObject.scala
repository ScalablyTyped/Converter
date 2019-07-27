package typings
package atStorybookVueLib.atStorybookVueMod

import vueLib.typesOptionsMod.ComponentOptions
import vueLib.typesOptionsMod.DefaultComputed
import vueLib.typesOptionsMod.DefaultData
import vueLib.typesOptionsMod.DefaultMethods
import vueLib.typesOptionsMod.DefaultProps
import vueLib.typesOptionsMod.PropsDefinition
import vueLib.typesVueMod.Vue
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


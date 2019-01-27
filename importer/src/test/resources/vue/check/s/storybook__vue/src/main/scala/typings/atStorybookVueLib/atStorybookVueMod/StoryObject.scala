package typings
package atStorybookVueLib.atStorybookVueMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StoryObject extends js.Object {
  var name: java.lang.String = js.native
  @JSName("render")
  var render_Original: StoryFunction = js.native
  def render(): (vueLib.optionsMod.ComponentOptions[
    vueLib.vueVueMod.Vue, 
    vueLib.optionsMod.DefaultData[vueLib.vueVueMod.Vue], 
    vueLib.optionsMod.DefaultMethods[vueLib.vueVueMod.Vue], 
    vueLib.optionsMod.DefaultComputed, 
    vueLib.optionsMod.PropsDefinition[vueLib.optionsMod.DefaultProps]
  ]) | java.lang.String = js.native
}


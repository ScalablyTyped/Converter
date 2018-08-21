package ScalablyTyped
package AtStorybookVueLib
package AtStorybookVueModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@storybook/vue", JSImport.Namespace)
@js.native
object AtStorybookVueModuleMembers extends js.Object {
  def addDecorator(decorator: AtStorybookVueLib.AtStorybookVueModule.StoryDecorator): scala.Unit = js.native
  def configure(loaders: js.Function0[scala.Unit], module: WebpackDashEnvLib.NodeModule): scala.Unit = js.native
  def getStorybook(): StdLib.Array[AtStorybookVueLib.AtStorybookVueModule.StoryStore] = js.native
  def setAddon(addon: AtStorybookVueLib.AtStorybookVueModule.Addon): scala.Unit = js.native
  def storiesOf(kind: java.lang.String, module: WebpackDashEnvLib.NodeModule): AtStorybookVueLib.AtStorybookVueModule.Story = js.native
}


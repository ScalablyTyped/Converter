package ScalablyTyped
package AtStorybookVueLib
package AtStorybookVueModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait Story extends js.Object {
  val kind: java.lang.String
  def add(storyName: java.lang.String, getStory: AtStorybookVueLib.AtStorybookVueModule.StoryFunction): this.type
  def addDecorator(decorator: AtStorybookVueLib.AtStorybookVueModule.StoryDecorator): this.type
}


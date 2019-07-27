package typings.atStorybookVue.atStorybookVueMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Story extends js.Object {
  val kind: String
  def add(storyName: String, getStory: StoryFunction): this.type
  def addDecorator(decorator: StoryDecorator): this.type
}

object Story {
  @scala.inline
  def apply(add: (String, StoryFunction) => Story, addDecorator: StoryDecorator => Story, kind: String): Story = {
    val __obj = js.Dynamic.literal(add = js.Any.fromFunction2(add), addDecorator = js.Any.fromFunction1(addDecorator), kind = kind)
  
    __obj.asInstanceOf[Story]
  }
}


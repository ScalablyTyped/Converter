package typings.storybookVue.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Story extends js.Object {
  def add(storyName: String, getStory: StoryFunction): this.type = js.native
  def addDecorator(decorator: StoryDecorator): this.type = js.native
  val kind: String = js.native
}

object Story {
  @scala.inline
  def apply(add: (String, StoryFunction) => Story, addDecorator: StoryDecorator => Story, kind: String): Story = {
    val __obj = js.Dynamic.literal(add = js.Any.fromFunction2(add), addDecorator = js.Any.fromFunction1(addDecorator), kind = kind.asInstanceOf[js.Any])
    __obj.asInstanceOf[Story]
  }
  @scala.inline
  implicit class StoryOps[Self <: Story] (val x: Self) extends AnyVal {
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
    def setAdd(value: (String, StoryFunction) => Story): Self = this.set("add", js.Any.fromFunction2(value))
    @scala.inline
    def setAddDecorator(value: StoryDecorator => Story): Self = this.set("addDecorator", js.Any.fromFunction1(value))
    @scala.inline
    def setKind(value: String): Self = this.set("kind", value.asInstanceOf[js.Any])
  }
  
}


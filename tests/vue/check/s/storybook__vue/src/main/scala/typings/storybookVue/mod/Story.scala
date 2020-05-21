package typings.storybookVue.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Story extends js.Object {
  val kind: String = js.native
  def add(storyName: String, getStory: StoryFunction): this.type = js.native
  def addDecorator(decorator: StoryDecorator): this.type = js.native
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
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAdd(add: (String, StoryFunction) => Story): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("add")(js.Any.fromFunction2(add))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAddDecorator(addDecorator: StoryDecorator => Story): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("addDecorator")(js.Any.fromFunction1(addDecorator))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withKind(kind: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("kind")(kind.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}


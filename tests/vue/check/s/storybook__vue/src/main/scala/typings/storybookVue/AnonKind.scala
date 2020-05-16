package typings.storybookVue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonKind extends js.Object {
  var kind: String = js.native
  var story: String = js.native
}

object AnonKind {
  @scala.inline
  def apply(kind: String, story: String): AnonKind = {
    val __obj = js.Dynamic.literal(kind = kind.asInstanceOf[js.Any], story = story.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonKind]
  }
  @scala.inline
  implicit class AnonKindOps[Self <: AnonKind] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withKind(kind: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("kind")(kind.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withStory(story: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("story")(story.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}


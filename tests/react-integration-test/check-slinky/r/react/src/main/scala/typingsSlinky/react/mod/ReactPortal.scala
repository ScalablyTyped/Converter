package typingsSlinky.react.mod

import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReactPortal extends ReactElement {
  var children: TagMod[Any] = js.native
}

object ReactPortal {
  @scala.inline
  def apply(props: js.Any, `type`: js.Any, children: TagMod[Any] = null, key: Key = null): ReactPortal = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactPortal]
  }
  @scala.inline
  implicit class ReactPortalOps[Self <: ReactPortal] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildren(children: TagMod[Any]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutChildren: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "children")
        ret.asInstanceOf[Self]
    }
  }
  
}


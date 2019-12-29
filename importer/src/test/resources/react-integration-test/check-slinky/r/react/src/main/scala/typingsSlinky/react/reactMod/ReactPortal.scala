package typingsSlinky.react.reactMod

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
  def apply(children: TagMod[Any], props: js.Any, `type`: js.Any, key: Key = null): ReactPortal = {
    val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any], props = props.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactPortal]
  }
}


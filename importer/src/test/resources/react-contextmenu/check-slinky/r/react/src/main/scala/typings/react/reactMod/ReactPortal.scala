package typings.react.reactMod

import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ReactPortal extends ReactElement {
  var children: TagMod[Any]
}

object ReactPortal {
  @scala.inline
  def apply(props: js.Any, `type`: js.Any, children: TagMod[Any] = null, key: Key = null): ReactPortal = {
    val __obj = js.Dynamic.literal(props = props)
    __obj.updateDynamic("type")(`type`)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactPortal]
  }
}


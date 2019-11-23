package typings.react.reactMod

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ReactElement extends js.Object {
  var key: Key | Null
  var props: js.Any
  var `type`: String | ReactComponentClass[_] | ReactComponentClass[_]
}

object ReactElement {
  @scala.inline
  def apply(props: js.Any, `type`: String | ReactComponentClass[_] | ReactComponentClass[_], key: Key = null): ReactElement = {
    val __obj = js.Dynamic.literal(props = props)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactElement]
  }
}


package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.ComponentClassP
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReactElement extends js.Object {
  var key: Key | Null = js.native
  var props: js.Any = js.native
  var `type`: String | ComponentClassP[js.Object] | SFC[_] = js.native
}

object ReactElement {
  @scala.inline
  def apply(props: js.Any, `type`: String | ComponentClassP[js.Object] | SFC[_], key: Key = null): ReactElement = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactElement]
  }
}


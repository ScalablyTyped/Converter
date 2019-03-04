package typings
package reactLib.reactMod.ReactNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ReactElement[P] extends js.Object {
  var key: Key | scala.Null
  var props: P
  var `type`: java.lang.String | ComponentClass[P] | SFC[P]
}

object ReactElement {
  @scala.inline
  def apply[P](props: P, `type`: java.lang.String | ComponentClass[P] | SFC[P], key: Key = null): ReactElement[P] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactElement[P]]
  }
}


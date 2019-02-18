package typings
package reactLib.reactMod.ReactNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Props[T] extends js.Object {
  var key: js.UndefOr[java.lang.String] = js.undefined
}

object Props {
  @scala.inline
  def apply[T](key: java.lang.String = null): Props[T] = {
    val __obj = js.Dynamic.literal()
    if (key != null) __obj.updateDynamic("key")(key)
    __obj.asInstanceOf[Props[T]]
  }
}


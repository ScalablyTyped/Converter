package typings.vueResource

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonMethod extends js.Object {
  var method: String = js.native
}

object AnonMethod {
  @scala.inline
  def apply(method: String): AnonMethod = {
    val __obj = js.Dynamic.literal(method = method.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[AnonMethod]
  }
}


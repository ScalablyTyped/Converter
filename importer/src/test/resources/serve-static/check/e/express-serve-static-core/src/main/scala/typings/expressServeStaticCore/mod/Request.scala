package typings.expressServeStaticCore.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Request
  extends typings.expressServeStaticCore.mod._Global_.Express.Request {
  var url: String
}

object Request {
  @scala.inline
  def apply(url: String): Request = {
    val __obj = js.Dynamic.literal(url = url.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Request]
  }
}


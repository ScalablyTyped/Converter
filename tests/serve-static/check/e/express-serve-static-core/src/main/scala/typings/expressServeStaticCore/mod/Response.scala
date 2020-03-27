package typings.expressServeStaticCore.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Response
  extends typings.expressServeStaticCore.mod._Global_.Express.Response {
  def location(url: String): Response = js.native
}

object Response {
  @scala.inline
  def apply(location: String => Response): Response = {
    val __obj = js.Dynamic.literal(location = js.Any.fromFunction1(location))
  
    __obj.asInstanceOf[Response]
  }
}


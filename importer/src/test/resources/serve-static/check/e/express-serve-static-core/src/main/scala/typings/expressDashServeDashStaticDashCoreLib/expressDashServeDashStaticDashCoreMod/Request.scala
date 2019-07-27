package typings.expressDashServeDashStaticDashCoreLib.expressDashServeDashStaticDashCoreMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Request
  extends typings.expressDashServeDashStaticDashCoreLib.expressDashServeDashStaticDashCoreMod.Global.ExpressNs.Request {
  var url: String
}

object Request {
  @scala.inline
  def apply(url: String): Request = {
    val __obj = js.Dynamic.literal(url = url)
  
    __obj.asInstanceOf[Request]
  }
}


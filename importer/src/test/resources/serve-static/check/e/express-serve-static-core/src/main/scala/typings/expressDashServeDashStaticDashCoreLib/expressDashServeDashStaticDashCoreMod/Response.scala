package typings
package expressDashServeDashStaticDashCoreLib.expressDashServeDashStaticDashCoreMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Response
  extends expressDashServeDashStaticDashCoreLib.expressDashServeDashStaticDashCoreMod.Global.ExpressNs.Response {
  def location(url: java.lang.String): Response
}

object Response {
  @scala.inline
  def apply(location: java.lang.String => Response): Response = {
    val __obj = js.Dynamic.literal(location = js.Any.fromFunction1(location))
  
    __obj.asInstanceOf[Response]
  }
}


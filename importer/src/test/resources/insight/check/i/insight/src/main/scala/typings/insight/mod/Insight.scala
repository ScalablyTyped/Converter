package typings.insight.mod

import typings.insight.mod.insight.IConfigstore
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Insight extends js.Object {
  var clientId: String
  var config: IConfigstore
  var optOut: Boolean
  def track(args: String*): Unit
}

object Insight {
  @scala.inline
  def apply(clientId: String, config: IConfigstore, optOut: Boolean, track: /* repeated */ String => Unit): Insight = {
    val __obj = js.Dynamic.literal(clientId = clientId.asInstanceOf[js.Any], config = config.asInstanceOf[js.Any], optOut = optOut.asInstanceOf[js.Any], track = js.Any.fromFunction1(track))
  
    __obj.asInstanceOf[Insight]
  }
}


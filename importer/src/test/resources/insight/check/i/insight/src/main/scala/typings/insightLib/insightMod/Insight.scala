package typings.insightLib.insightMod

import typings.insightLib.insightMod.insightNs.IConfigstore
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
    val __obj = js.Dynamic.literal(clientId = clientId, config = config, optOut = optOut, track = js.Any.fromFunction1(track))
  
    __obj.asInstanceOf[Insight]
  }
}


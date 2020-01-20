package typings.insight.mod

import typings.insight.mod.insight_.IConfigstore
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Insight extends js.Object {
  var clientId: String = js.native
  var config: IConfigstore = js.native
  var optOut: Boolean = js.native
  def track(args: String*): Unit = js.native
}

object Insight {
  @scala.inline
  def apply(clientId: String, config: IConfigstore, optOut: Boolean, track: /* repeated */ String => Unit): Insight = {
    val __obj = js.Dynamic.literal(clientId = clientId.asInstanceOf[js.Any], config = config.asInstanceOf[js.Any], optOut = optOut.asInstanceOf[js.Any], track = js.Any.fromFunction1(track))
  
    __obj.asInstanceOf[Insight]
  }
}


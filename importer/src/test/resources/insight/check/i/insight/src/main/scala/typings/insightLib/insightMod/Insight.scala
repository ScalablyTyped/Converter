package typings
package insightLib.insightMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Insight extends js.Object {
  var clientId: java.lang.String
  var config: insightLib.insightMod.insightNs.IConfigstore
  var optOut: scala.Boolean
  def track(args: java.lang.String*): scala.Unit
}

object Insight {
  @scala.inline
  def apply(
    clientId: java.lang.String,
    config: insightLib.insightMod.insightNs.IConfigstore,
    optOut: scala.Boolean,
    track: js.Function1[/* repeated */ java.lang.String, scala.Unit]
  ): Insight = {
    val __obj = js.Dynamic.literal(clientId = clientId, config = config, optOut = optOut, track = track)
  
    __obj.asInstanceOf[Insight]
  }
}


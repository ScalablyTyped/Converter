package typings.insight.insightMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.insight.insightMod.insight.IConfigstore
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Insight extends js.Object {
  var clientId: String
  var config: IConfigstore
  var optOut: Boolean
  def track(args: String*): Unit
}

object Insight {
  @inline
  def apply(clientId: String, config: IConfigstore, optOut: Boolean, track: /* repeated */ String => Unit): Insight = {
    val __obj = js.Dynamic.literal(clientId = clientId, config = config, optOut = optOut, track = js.Any.fromFunction1(track))
  
    __obj.asInstanceOf[Insight]
  }
}


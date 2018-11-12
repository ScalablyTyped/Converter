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


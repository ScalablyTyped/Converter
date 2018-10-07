package ScalablyTyped
package InsightLib.InsightModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait Insight extends js.Object {
  var clientId: java.lang.String
  var config: InsightLib.InsightModule.insightNamespace.IConfigstore
  var optOut: scala.Boolean
  def track(args: java.lang.String*): scala.Unit
}


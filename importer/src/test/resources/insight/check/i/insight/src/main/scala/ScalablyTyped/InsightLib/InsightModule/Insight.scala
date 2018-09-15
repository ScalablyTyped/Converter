package ScalablyTyped
package InsightLib.InsightModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait Insight extends js.Object {
  val clientId: java.lang.String
  val config: InsightLib.InsightModule.insightNamespace.IConfigstore
  val optOut: scala.Boolean
  def track(args: java.lang.String*): scala.Unit
}


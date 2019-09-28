package typings.insight.insightMod.insight

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait IOptions extends js.Object {
  var trackingCode: String
}

object IOptions {
  @inline
  def apply(trackingCode: String): IOptions = {
    val __obj = js.Dynamic.literal(trackingCode = trackingCode)
  
    __obj.asInstanceOf[IOptions]
  }
}


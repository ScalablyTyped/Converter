package typings.insight.insightMod.insight

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait IOptions extends js.Object {
  var trackingCode: String
}

object IOptions {
  @scala.inline
  def apply(trackingCode: String): IOptions = {
    val __obj = js.Dynamic.literal(trackingCode = trackingCode.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[IOptions]
  }
}


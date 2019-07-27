package typings.insightLib.insightMod.insightNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait IOptions extends js.Object {
  var trackingCode: String
}

object IOptions {
  @scala.inline
  def apply(trackingCode: String): IOptions = {
    val __obj = js.Dynamic.literal(trackingCode = trackingCode)
  
    __obj.asInstanceOf[IOptions]
  }
}


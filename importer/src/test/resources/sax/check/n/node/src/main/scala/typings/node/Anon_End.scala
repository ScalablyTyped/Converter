package typings.node

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Anon_End extends js.Object {
  var end: js.UndefOr[Boolean] = js.undefined
}

object Anon_End {
  @inline
  def apply(end: js.UndefOr[Boolean] = js.undefined): Anon_End = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(end)) __obj.updateDynamic("end")(end)
    __obj.asInstanceOf[Anon_End]
  }
}


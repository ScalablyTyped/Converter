package typingsJapgolly.componentstest.mod

import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait A extends Props {
  var aMember: Double = js.native
  def aCallback(): Double = js.native
}

object A {
  @scala.inline
  def apply(aCallback: CallbackTo[Double], aMember: Double): A = {
    val __obj = js.Dynamic.literal(aMember = aMember.asInstanceOf[js.Any])
    __obj.updateDynamic("aCallback")(aCallback.toJsFn)
    __obj.asInstanceOf[A]
  }
}


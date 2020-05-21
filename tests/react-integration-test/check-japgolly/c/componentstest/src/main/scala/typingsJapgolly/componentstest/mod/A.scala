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
    val __obj = js.Dynamic.literal(aCallback = aCallback.toJsFn, aMember = aMember.asInstanceOf[js.Any])
    __obj.asInstanceOf[A]
  }
  @scala.inline
  implicit class AOps[Self <: A] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setACallback(value: CallbackTo[Double]): Self = this.set("aCallback", value.toJsFn)
    @scala.inline
    def setAMember(value: Double): Self = this.set("aMember", value.asInstanceOf[js.Any])
  }
  
}


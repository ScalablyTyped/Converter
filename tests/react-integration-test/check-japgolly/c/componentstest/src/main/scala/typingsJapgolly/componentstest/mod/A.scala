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
  @scala.inline
  implicit class AOps[Self <: A] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withACallback(aCallback: CallbackTo[Double]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("aCallback")(aCallback.toJsFn)
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAMember(aMember: Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("aMember")(aMember.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}


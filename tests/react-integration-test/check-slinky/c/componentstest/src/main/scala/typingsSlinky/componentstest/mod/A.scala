package typingsSlinky.componentstest.mod

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
  def apply(aCallback: () => Double, aMember: Double): A = {
    val __obj = js.Dynamic.literal(aCallback = js.Any.fromFunction0(aCallback), aMember = aMember.asInstanceOf[js.Any])
    __obj.asInstanceOf[A]
  }
  @scala.inline
  implicit class AOps[Self <: A] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withACallback(aCallback: () => Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("aCallback")(js.Any.fromFunction0(aCallback))
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


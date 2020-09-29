package typingsSlinky.inheritanceWithIntersection.anon

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait CenterRipple extends js.Object {
  var centerRipple: js.UndefOr[Boolean] = js.native
}

object CenterRipple {
  @scala.inline
  def apply(): CenterRipple = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[CenterRipple]
  }
  @scala.inline
  implicit class CenterRippleOps[Self <: CenterRipple] (val x: Self) extends AnyVal {
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
    def setCenterRipple(value: Boolean): Self = this.set("centerRipple", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteCenterRipple: Self = this.set("centerRipple", js.undefined)
  }
  
}


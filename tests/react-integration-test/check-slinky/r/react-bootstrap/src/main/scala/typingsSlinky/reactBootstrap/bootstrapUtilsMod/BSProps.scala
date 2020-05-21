package typingsSlinky.reactBootstrap.bootstrapUtilsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait BSProps extends js.Object {
  var bsClass: js.Any = js.native
}

object BSProps {
  @scala.inline
  def apply(bsClass: js.Any): BSProps = {
    val __obj = js.Dynamic.literal(bsClass = bsClass.asInstanceOf[js.Any])
    __obj.asInstanceOf[BSProps]
  }
  @scala.inline
  implicit class BSPropsOps[Self <: BSProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withBsClass(bsClass: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("bsClass")(bsClass.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}


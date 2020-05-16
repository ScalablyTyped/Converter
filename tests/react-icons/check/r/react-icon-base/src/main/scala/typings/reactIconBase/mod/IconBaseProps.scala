package typings.reactIconBase.mod

import typings.react.mod.ClassAttributes
import typings.react.mod.ReactSVGElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait IconBaseProps extends ClassAttributes[ReactSVGElement] {
  var size: js.UndefOr[String | Double] = js.native
}

object IconBaseProps {
  @scala.inline
  def apply(): IconBaseProps = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[IconBaseProps]
  }
  @scala.inline
  implicit class IconBasePropsOps[Self <: IconBaseProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withSize(value: String | Double): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("size")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutSize: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("size")(js.undefined)
        ret
    }
  }
  
}


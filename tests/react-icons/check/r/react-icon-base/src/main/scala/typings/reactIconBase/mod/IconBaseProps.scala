package typings.reactIconBase.mod

import typings.react.mod.ClassAttributes
import typings.react.mod.Key
import typings.react.mod.ReactSVGElement
import typings.react.mod.Ref
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait IconBaseProps extends ClassAttributes[ReactSVGElement] {
  var size: js.UndefOr[String | Double] = js.native
}

object IconBaseProps {
  @scala.inline
  def apply(key: Key = null, ref: Ref[ReactSVGElement] = null, size: String | Double = null): IconBaseProps = {
    val __obj = js.Dynamic.literal()
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    __obj.asInstanceOf[IconBaseProps]
  }
  @scala.inline
  implicit class IconBasePropsOps[Self <: IconBaseProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withSize(size: String | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (size != null) ret.updateDynamic("size")(size.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutSize: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "size")
        ret.asInstanceOf[Self]
    }
  }
  
}


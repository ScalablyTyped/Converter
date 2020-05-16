package typingsJapgolly.semanticUiReact.genericMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictHtmlImageProps extends js.Object {
  var src: js.UndefOr[String] = js.native
}

object StrictHtmlImageProps {
  @scala.inline
  def apply(src: String = null): StrictHtmlImageProps = {
    val __obj = js.Dynamic.literal()
    if (src != null) __obj.updateDynamic("src")(src.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictHtmlImageProps]
  }
  @scala.inline
  implicit class StrictHtmlImagePropsOps[Self <: StrictHtmlImageProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withSrc(src: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (src != null) ret.updateDynamic("src")(src.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutSrc: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "src")
        ret.asInstanceOf[Self]
    }
  }
  
}


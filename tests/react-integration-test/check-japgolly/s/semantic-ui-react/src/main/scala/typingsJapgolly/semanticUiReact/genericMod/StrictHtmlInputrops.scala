package typingsJapgolly.semanticUiReact.genericMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictHtmlInputrops extends js.Object {
  var `type`: js.UndefOr[String] = js.native
}

object StrictHtmlInputrops {
  @scala.inline
  def apply(): StrictHtmlInputrops = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StrictHtmlInputrops]
  }
  @scala.inline
  implicit class StrictHtmlInputropsOps[Self <: StrictHtmlInputrops] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withType(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("type")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutType: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("type")(js.undefined)
        ret
    }
  }
  
}


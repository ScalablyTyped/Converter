package typings.vue.optionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait WatchOptions extends js.Object {
  var deep: js.UndefOr[Boolean] = js.native
  var immediate: js.UndefOr[Boolean] = js.native
}

object WatchOptions {
  @scala.inline
  def apply(deep: js.UndefOr[Boolean] = js.undefined, immediate: js.UndefOr[Boolean] = js.undefined): WatchOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(deep)) __obj.updateDynamic("deep")(deep.asInstanceOf[js.Any])
    if (!js.isUndefined(immediate)) __obj.updateDynamic("immediate")(immediate.asInstanceOf[js.Any])
    __obj.asInstanceOf[WatchOptions]
  }
  @scala.inline
  implicit class WatchOptionsOps[Self <: WatchOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withDeep(deep: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(deep)) ret.updateDynamic("deep")(deep.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDeep: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "deep")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withImmediate(immediate: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(immediate)) ret.updateDynamic("immediate")(immediate.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutImmediate: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "immediate")
        ret.asInstanceOf[Self]
    }
  }
  
}


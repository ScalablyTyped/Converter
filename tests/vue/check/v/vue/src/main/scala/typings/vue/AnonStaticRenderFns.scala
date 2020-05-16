package typings.vue

import typings.vue.vnodeMod.VNode
import typings.vue.vueMod.CreateElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonStaticRenderFns extends js.Object {
  var staticRenderFns: js.Array[js.Function0[VNode]] = js.native
  def render(createElement: CreateElement): VNode = js.native
}

object AnonStaticRenderFns {
  @scala.inline
  def apply(render: CreateElement => VNode, staticRenderFns: js.Array[js.Function0[VNode]]): AnonStaticRenderFns = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction1(render), staticRenderFns = staticRenderFns.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonStaticRenderFns]
  }
  @scala.inline
  implicit class AnonStaticRenderFnsOps[Self <: AnonStaticRenderFns] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withRender(render: CreateElement => VNode): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("render")(js.Any.fromFunction1(render))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withStaticRenderFns(staticRenderFns: js.Array[js.Function0[VNode]]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("staticRenderFns")(staticRenderFns.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}


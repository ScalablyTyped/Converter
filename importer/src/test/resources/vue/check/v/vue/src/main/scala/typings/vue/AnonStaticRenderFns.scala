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
}


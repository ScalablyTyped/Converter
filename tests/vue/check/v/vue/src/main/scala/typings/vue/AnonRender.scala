package typings.vue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonRender extends js.Object {
  var render: js.Function = js.native
  var staticRenderFns: js.Array[js.Function] = js.native
}

object AnonRender {
  @scala.inline
  def apply(render: js.Function, staticRenderFns: js.Array[js.Function]): AnonRender = {
    val __obj = js.Dynamic.literal(render = render.asInstanceOf[js.Any], staticRenderFns = staticRenderFns.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonRender]
  }
}


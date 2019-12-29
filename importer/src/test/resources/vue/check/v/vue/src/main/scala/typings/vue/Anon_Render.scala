package typings.vue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Anon_Render extends js.Object {
  var render: js.Function = js.native
  var staticRenderFns: js.Array[js.Function] = js.native
}

object Anon_Render {
  @scala.inline
  def apply(render: js.Function, staticRenderFns: js.Array[js.Function]): Anon_Render = {
    val __obj = js.Dynamic.literal(render = render.asInstanceOf[js.Any], staticRenderFns = staticRenderFns.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Anon_Render]
  }
}


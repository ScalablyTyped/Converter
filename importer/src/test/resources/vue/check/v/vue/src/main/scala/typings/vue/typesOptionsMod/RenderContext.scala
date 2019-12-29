package typings.vue.typesOptionsMod

import typings.vue.typesVnodeMod.VNode
import typings.vue.typesVnodeMod.VNodeData
import typings.vue.typesVueMod.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait RenderContext[Props] extends js.Object {
  var children: js.Array[VNode] = js.native
  var data: VNodeData = js.native
  var injections: js.Any = js.native
  var parent: Vue = js.native
  var props: Props = js.native
  def slots(): js.Any = js.native
}

object RenderContext {
  @scala.inline
  def apply[Props](
    children: js.Array[VNode],
    data: VNodeData,
    injections: js.Any,
    parent: Vue,
    props: Props,
    slots: () => js.Any
  ): RenderContext[Props] = {
    val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any], data = data.asInstanceOf[js.Any], injections = injections.asInstanceOf[js.Any], parent = parent.asInstanceOf[js.Any], props = props.asInstanceOf[js.Any], slots = js.Any.fromFunction0(slots))
  
    __obj.asInstanceOf[RenderContext[Props]]
  }
}


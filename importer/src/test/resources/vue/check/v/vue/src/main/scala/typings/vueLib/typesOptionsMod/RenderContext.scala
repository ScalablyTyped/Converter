package typings.vueLib.typesOptionsMod

import typings.vueLib.typesVnodeMod.VNode
import typings.vueLib.typesVnodeMod.VNodeData
import typings.vueLib.typesVueMod.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait RenderContext[Props] extends js.Object {
  var children: js.Array[VNode]
  var data: VNodeData
  var injections: js.Any
  var parent: Vue
  var props: Props
  def slots(): js.Any
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
    val __obj = js.Dynamic.literal(children = children, data = data, injections = injections, parent = parent, props = props.asInstanceOf[js.Any], slots = js.Any.fromFunction0(slots))
  
    __obj.asInstanceOf[RenderContext[Props]]
  }
}


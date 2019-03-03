package typings
package vueLib.typesOptionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait RenderContext[Props] extends js.Object {
  var children: js.Array[vueLib.typesVnodeMod.VNode]
  var data: vueLib.typesVnodeMod.VNodeData
  var injections: js.Any
  var parent: vueLib.typesVueMod.Vue
  var props: Props
  def slots(): js.Any
}

object RenderContext {
  @scala.inline
  def apply[Props](
    children: js.Array[vueLib.typesVnodeMod.VNode],
    data: vueLib.typesVnodeMod.VNodeData,
    injections: js.Any,
    parent: vueLib.typesVueMod.Vue,
    props: Props,
    slots: () => js.Any
  ): RenderContext[Props] = {
    val __obj = js.Dynamic.literal(children = children, data = data, injections = injections, parent = parent, props = props.asInstanceOf[js.Any], slots = js.Any.fromFunction0(slots))
  
    __obj.asInstanceOf[RenderContext[Props]]
  }
}


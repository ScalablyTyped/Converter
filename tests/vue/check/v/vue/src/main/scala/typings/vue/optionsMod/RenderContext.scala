package typings.vue.optionsMod

import typings.vue.vnodeMod.VNode
import typings.vue.vnodeMod.VNodeData
import typings.vue.vueMod.Vue
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
  @scala.inline
  implicit class RenderContextOps[Self <: RenderContext[_], Props] (val x: Self with RenderContext[Props]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildren(value: js.Array[VNode]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("children")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withData(value: VNodeData): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("data")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withInjections(value: js.Any): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("injections")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withParent(value: Vue): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("parent")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withProps(value: Props): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("props")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withSlots(value: () => js.Any): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("slots")(js.Any.fromFunction0(value))
        ret
    }
  }
  
}


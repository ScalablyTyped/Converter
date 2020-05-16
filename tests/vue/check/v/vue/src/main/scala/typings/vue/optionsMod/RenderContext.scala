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
  implicit class RenderContextOps[Self[props] <: RenderContext[props], Props] (val x: Self[Props]) extends AnyVal {
    @scala.inline
    def duplicate: Self[Props] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[Props]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[Props] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[Props] with Other]
    @scala.inline
    def withChildren(children: js.Array[VNode]): Self[Props] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("children")(children.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[Props]]
    }
    @scala.inline
    def withData(data: VNodeData): Self[Props] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("data")(data.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[Props]]
    }
    @scala.inline
    def withInjections(injections: js.Any): Self[Props] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("injections")(injections.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[Props]]
    }
    @scala.inline
    def withParent(parent: Vue): Self[Props] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("parent")(parent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[Props]]
    }
    @scala.inline
    def withProps(props: Props): Self[Props] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("props")(props.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[Props]]
    }
    @scala.inline
    def withSlots(slots: () => js.Any): Self[Props] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("slots")(js.Any.fromFunction0(slots))
        ret.asInstanceOf[Self[Props]]
    }
  }
  
}


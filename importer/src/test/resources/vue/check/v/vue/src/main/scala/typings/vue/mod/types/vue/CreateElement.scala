package typings.vue.mod.types.vue

import typings.vue.mod.types.options.AsyncComponent
import typings.vue.mod.types.options.Component
import typings.vue.mod.types.options.DefaultComputed
import typings.vue.mod.types.options.DefaultData
import typings.vue.mod.types.options.DefaultMethods
import typings.vue.mod.types.options.DefaultProps
import typings.vue.mod.types.vnode.VNode
import typings.vue.mod.types.vnode.VNodeChildren
import typings.vue.mod.types.vnode.VNodeData
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait CreateElement extends js.Object {
  def apply(): VNode = js.native
  def apply(tag: String): VNode = js.native
  def apply(tag: String, children: VNodeChildren): VNode = js.native
  def apply(tag: String, data: VNodeData): VNode = js.native
  def apply(tag: String, data: VNodeData, children: VNodeChildren): VNode = js.native
  def apply(tag: js.Function0[Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]]): VNode = js.native
  def apply(
    tag: js.Function0[Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]],
    children: VNodeChildren
  ): VNode = js.native
  def apply(
    tag: js.Function0[Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]],
    data: VNodeData
  ): VNode = js.native
  def apply(
    tag: js.Function0[Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]],
    data: VNodeData,
    children: VNodeChildren
  ): VNode = js.native
  def apply(tag: AsyncComponent[_, _, _, _]): VNode = js.native
  def apply(tag: AsyncComponent[_, _, _, _], children: VNodeChildren): VNode = js.native
  def apply(tag: AsyncComponent[_, _, _, _], data: VNodeData): VNode = js.native
  def apply(tag: AsyncComponent[_, _, _, _], data: VNodeData, children: VNodeChildren): VNode = js.native
  def apply(tag: Component[_, _, _, _]): VNode = js.native
  def apply(tag: Component[_, _, _, _], children: VNodeChildren): VNode = js.native
  def apply(tag: Component[_, _, _, _], data: VNodeData): VNode = js.native
  def apply(tag: Component[_, _, _, _], data: VNodeData, children: VNodeChildren): VNode = js.native
}


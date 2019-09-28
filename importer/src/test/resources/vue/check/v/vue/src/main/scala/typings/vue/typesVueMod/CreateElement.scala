package typings.vue.typesVueMod

import typings.vue.typesOptionsMod.AsyncComponent
import typings.vue.typesOptionsMod.Component
import typings.vue.typesOptionsMod.DefaultComputed
import typings.vue.typesOptionsMod.DefaultData
import typings.vue.typesOptionsMod.DefaultMethods
import typings.vue.typesOptionsMod.DefaultProps
import typings.vue.typesVnodeMod.VNode
import typings.vue.typesVnodeMod.VNodeChildren
import typings.vue.typesVnodeMod.VNodeData
import scala.scalajs.js
import scala.scalajs.js.`|`

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


package typings.vueLib.typesVueMod

import typings.vueLib.typesOptionsMod.AsyncComponent
import typings.vueLib.typesOptionsMod.Component
import typings.vueLib.typesOptionsMod.DefaultComputed
import typings.vueLib.typesOptionsMod.DefaultData
import typings.vueLib.typesOptionsMod.DefaultMethods
import typings.vueLib.typesOptionsMod.DefaultProps
import typings.vueLib.typesVnodeMod.VNode
import typings.vueLib.typesVnodeMod.VNodeChildren
import typings.vueLib.typesVnodeMod.VNodeData
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


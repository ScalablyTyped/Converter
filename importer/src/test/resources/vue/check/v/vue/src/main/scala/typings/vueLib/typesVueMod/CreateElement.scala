package typings
package vueLib.typesVueMod

import vueLib.typesOptionsMod.AsyncComponent
import vueLib.typesOptionsMod.Component
import vueLib.typesOptionsMod.DefaultComputed
import vueLib.typesOptionsMod.DefaultData
import vueLib.typesOptionsMod.DefaultMethods
import vueLib.typesOptionsMod.DefaultProps
import vueLib.typesVnodeMod.VNode
import vueLib.typesVnodeMod.VNodeChildren
import vueLib.typesVnodeMod.VNodeData
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


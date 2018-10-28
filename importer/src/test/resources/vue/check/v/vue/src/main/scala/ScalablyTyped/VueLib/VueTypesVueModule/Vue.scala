package ScalablyTyped
package VueLib.VueTypesVueModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Vue extends js.Object {
  @JSName("$attrs")
  val $attrs: StdLib.Record[java.lang.String, java.lang.String] = js.native
  @JSName("$children")
  val $children: StdLib.Array[Vue] = js.native
  @JSName("$createElement")
  var $createElement_Original: CreateElement = js.native
  @JSName("$data")
  val $data: StdLib.Record[java.lang.String, _] = js.native
  @JSName("$delete")
  var $delete_Original: js.Function2[/* object */ js.Object, /* key */ java.lang.String, scala.Unit] = js.native
  @JSName("$el")
  val $el: StdLib.HTMLElement = js.native
  @JSName("$isServer")
  val $isServer: scala.Boolean = js.native
  @JSName("$listeners")
  val $listeners: StdLib.Record[java.lang.String, js.Function | StdLib.Array[js.Function]] = js.native
  @JSName("$options")
  val $options: VueLib.VueTypesOptionsModule.ComponentOptions[
    Vue, 
    VueLib.VueTypesOptionsModule.DefaultData[Vue], 
    VueLib.VueTypesOptionsModule.DefaultMethods[Vue], 
    VueLib.VueTypesOptionsModule.DefaultComputed, 
    VueLib.VueTypesOptionsModule.PropsDefinition[VueLib.VueTypesOptionsModule.DefaultProps]
  ] = js.native
  @JSName("$parent")
  val $parent: Vue = js.native
  @JSName("$props")
  val $props: StdLib.Record[java.lang.String, _] = js.native
  @JSName("$refs")
  val $refs: ScalablyTyped.runtime.StringDictionary[Vue | StdLib.Element | StdLib.Array[Vue] | StdLib.Array[StdLib.Element]] = js.native
  @JSName("$root")
  val $root: Vue = js.native
  @JSName("$scopedSlots")
  val $scopedSlots: ScalablyTyped.runtime.StringDictionary[VueLib.VueTypesVnodeModule.ScopedSlot] = js.native
  @JSName("$set")
  var $set_Original: js.Function3[/* object */ js.Object, /* key */ java.lang.String, /* value */ js.Any, _] = js.native
  @JSName("$slots")
  val $slots: ScalablyTyped.runtime.StringDictionary[StdLib.Array[VueLib.VueTypesVnodeModule.VNode]] = js.native
  @JSName("$ssrContext")
  val $ssrContext: js.Any = js.native
  @JSName("$vnode")
  val $vnode: VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: VueLib.VueTypesOptionsModule.AsyncComponent[_, _, _, _]): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: VueLib.VueTypesOptionsModule.AsyncComponent[_, _, _, _],
    children: VueLib.VueTypesVnodeModule.VNodeChildren
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: VueLib.VueTypesOptionsModule.AsyncComponent[_, _, _, _],
    data: VueLib.VueTypesVnodeModule.VNodeData
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: VueLib.VueTypesOptionsModule.AsyncComponent[_, _, _, _],
    data: VueLib.VueTypesVnodeModule.VNodeData,
    children: VueLib.VueTypesVnodeModule.VNodeChildren
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: VueLib.VueTypesOptionsModule.Component[_, _, _, _]): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: VueLib.VueTypesOptionsModule.Component[_, _, _, _],
    children: VueLib.VueTypesVnodeModule.VNodeChildren
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: VueLib.VueTypesOptionsModule.Component[_, _, _, _],
    data: VueLib.VueTypesVnodeModule.VNodeData
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: VueLib.VueTypesOptionsModule.Component[_, _, _, _],
    data: VueLib.VueTypesVnodeModule.VNodeData,
    children: VueLib.VueTypesVnodeModule.VNodeChildren
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: java.lang.String): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: java.lang.String, children: VueLib.VueTypesVnodeModule.VNodeChildren): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: java.lang.String, data: VueLib.VueTypesVnodeModule.VNodeData): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: java.lang.String,
    data: VueLib.VueTypesVnodeModule.VNodeData,
    children: VueLib.VueTypesVnodeModule.VNodeChildren
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: js.Function0[
      VueLib.VueTypesOptionsModule.Component[
        VueLib.VueTypesOptionsModule.DefaultData[Vue], 
        VueLib.VueTypesOptionsModule.DefaultMethods[Vue], 
        VueLib.VueTypesOptionsModule.DefaultComputed, 
        VueLib.VueTypesOptionsModule.DefaultProps
      ]
    ]
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: js.Function0[
      VueLib.VueTypesOptionsModule.Component[
        VueLib.VueTypesOptionsModule.DefaultData[Vue], 
        VueLib.VueTypesOptionsModule.DefaultMethods[Vue], 
        VueLib.VueTypesOptionsModule.DefaultComputed, 
        VueLib.VueTypesOptionsModule.DefaultProps
      ]
    ],
    children: VueLib.VueTypesVnodeModule.VNodeChildren
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: js.Function0[
      VueLib.VueTypesOptionsModule.Component[
        VueLib.VueTypesOptionsModule.DefaultData[Vue], 
        VueLib.VueTypesOptionsModule.DefaultMethods[Vue], 
        VueLib.VueTypesOptionsModule.DefaultComputed, 
        VueLib.VueTypesOptionsModule.DefaultProps
      ]
    ],
    data: VueLib.VueTypesVnodeModule.VNodeData
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: js.Function0[
      VueLib.VueTypesOptionsModule.Component[
        VueLib.VueTypesOptionsModule.DefaultData[Vue], 
        VueLib.VueTypesOptionsModule.DefaultMethods[Vue], 
        VueLib.VueTypesOptionsModule.DefaultComputed, 
        VueLib.VueTypesOptionsModule.DefaultProps
      ]
    ],
    data: VueLib.VueTypesVnodeModule.VNodeData,
    children: VueLib.VueTypesVnodeModule.VNodeChildren
  ): VueLib.VueTypesVnodeModule.VNode = js.native
  @JSName("$delete")
  def $delete(`object`: js.Object, key: java.lang.String): scala.Unit = js.native
  @JSName("$destroy")
  def $destroy(): scala.Unit = js.native
  @JSName("$emit")
  def $emit(event: java.lang.String, args: js.Any*): this.type = js.native
  @JSName("$forceUpdate")
  def $forceUpdate(): scala.Unit = js.native
  @JSName("$mount")
  def $mount(): this.type = js.native
  @JSName("$mount")
  def $mount(elementOrSelector: StdLib.Element): this.type = js.native
  @JSName("$mount")
  def $mount(elementOrSelector: StdLib.Element, hydrating: scala.Boolean): this.type = js.native
  @JSName("$mount")
  def $mount(elementOrSelector: java.lang.String): this.type = js.native
  @JSName("$mount")
  def $mount(elementOrSelector: java.lang.String, hydrating: scala.Boolean): this.type = js.native
  @JSName("$nextTick")
  def $nextTick(): StdLib.Promise = js.native
  @JSName("$nextTick")
  def $nextTick(callback: js.ThisFunction0[/* this */ this.type, scala.Unit]): scala.Unit = js.native
  @JSName("$off")
  def $off(): this.type = js.native
  @JSName("$off")
  def $off(event: StdLib.Array[java.lang.String]): this.type = js.native
  @JSName("$off")
  def $off(event: StdLib.Array[java.lang.String], callback: js.Function): this.type = js.native
  @JSName("$off")
  def $off(event: java.lang.String): this.type = js.native
  @JSName("$off")
  def $off(event: java.lang.String, callback: js.Function): this.type = js.native
  @JSName("$on")
  def $on(event: StdLib.Array[java.lang.String], callback: js.Function): this.type = js.native
  @JSName("$on")
  def $on(event: java.lang.String, callback: js.Function): this.type = js.native
  @JSName("$once")
  def $once(event: java.lang.String, callback: js.Function): this.type = js.native
  @JSName("$set")
  def $set[T](`object`: js.Object, key: java.lang.String, value: T): T = js.native
  @JSName("$watch")
  def $watch(
    expOrFn: java.lang.String,
    callback: js.ThisFunction2[/* this */ this.type, /* n */ js.Any, /* o */ js.Any, scala.Unit]
  ): js.Function0[scala.Unit] = js.native
  @JSName("$watch")
  def $watch(
    expOrFn: java.lang.String,
    callback: js.ThisFunction2[/* this */ this.type, /* n */ js.Any, /* o */ js.Any, scala.Unit],
    options: VueLib.VueTypesOptionsModule.WatchOptions
  ): js.Function0[scala.Unit] = js.native
  @JSName("$watch")
  def $watch[T](
    expOrFn: js.ThisFunction0[/* this */ this.type, T],
    callback: js.ThisFunction2[/* this */ this.type, /* n */ T, /* o */ T, scala.Unit]
  ): js.Function0[scala.Unit] = js.native
  @JSName("$watch")
  def $watch[T](
    expOrFn: js.ThisFunction0[/* this */ this.type, T],
    callback: js.ThisFunction2[/* this */ this.type, /* n */ T, /* o */ T, scala.Unit],
    options: VueLib.VueTypesOptionsModule.WatchOptions
  ): js.Function0[scala.Unit] = js.native
}


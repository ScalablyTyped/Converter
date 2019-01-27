package typings
package vueLib.vueVueMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Vue extends js.Object {
  @JSName("$attrs")
  val $attrs: stdLib.Record[java.lang.String, java.lang.String] = js.native
  @JSName("$children")
  val $children: js.Array[Vue] = js.native
  @JSName("$createElement")
  var $createElement_Original: CreateElement = js.native
  @JSName("$data")
  val $data: stdLib.Record[java.lang.String, _] = js.native
  @JSName("$delete")
  var $delete_Original: vueLib.Anon_ArrayKey = js.native
  @JSName("$el")
  val $el: stdLib.HTMLElement = js.native
  @JSName("$isServer")
  val $isServer: scala.Boolean = js.native
  @JSName("$listeners")
  val $listeners: stdLib.Record[java.lang.String, js.Function | js.Array[js.Function]] = js.native
  @JSName("$options")
  val $options: vueLib.optionsMod.ComponentOptions[
    Vue, 
    vueLib.optionsMod.DefaultData[Vue], 
    vueLib.optionsMod.DefaultMethods[Vue], 
    vueLib.optionsMod.DefaultComputed, 
    vueLib.optionsMod.PropsDefinition[vueLib.optionsMod.DefaultProps]
  ] = js.native
  @JSName("$parent")
  val $parent: Vue = js.native
  @JSName("$props")
  val $props: stdLib.Record[java.lang.String, _] = js.native
  @JSName("$refs")
  val $refs: org.scalablytyped.runtime.StringDictionary[Vue | stdLib.Element | js.Array[Vue] | js.Array[stdLib.Element]] = js.native
  @JSName("$root")
  val $root: Vue = js.native
  @JSName("$scopedSlots")
  val $scopedSlots: org.scalablytyped.runtime.StringDictionary[vueLib.vnodeMod.ScopedSlot] = js.native
  @JSName("$set")
  var $set_Original: vueLib.Anon_Array = js.native
  @JSName("$slots")
  val $slots: org.scalablytyped.runtime.StringDictionary[js.Array[vueLib.vnodeMod.VNode]] = js.native
  @JSName("$ssrContext")
  val $ssrContext: js.Any = js.native
  @JSName("$vnode")
  val $vnode: vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: java.lang.String): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: java.lang.String, children: vueLib.vnodeMod.VNodeChildren): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: java.lang.String, data: vueLib.vnodeMod.VNodeData): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: java.lang.String, data: vueLib.vnodeMod.VNodeData, children: vueLib.vnodeMod.VNodeChildren): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: js.Function0[
      vueLib.optionsMod.Component[
        vueLib.optionsMod.DefaultData[Vue], 
        vueLib.optionsMod.DefaultMethods[Vue], 
        vueLib.optionsMod.DefaultComputed, 
        vueLib.optionsMod.DefaultProps
      ]
    ]
  ): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: js.Function0[
      vueLib.optionsMod.Component[
        vueLib.optionsMod.DefaultData[Vue], 
        vueLib.optionsMod.DefaultMethods[Vue], 
        vueLib.optionsMod.DefaultComputed, 
        vueLib.optionsMod.DefaultProps
      ]
    ],
    children: vueLib.vnodeMod.VNodeChildren
  ): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: js.Function0[
      vueLib.optionsMod.Component[
        vueLib.optionsMod.DefaultData[Vue], 
        vueLib.optionsMod.DefaultMethods[Vue], 
        vueLib.optionsMod.DefaultComputed, 
        vueLib.optionsMod.DefaultProps
      ]
    ],
    data: vueLib.vnodeMod.VNodeData
  ): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: js.Function0[
      vueLib.optionsMod.Component[
        vueLib.optionsMod.DefaultData[Vue], 
        vueLib.optionsMod.DefaultMethods[Vue], 
        vueLib.optionsMod.DefaultComputed, 
        vueLib.optionsMod.DefaultProps
      ]
    ],
    data: vueLib.vnodeMod.VNodeData,
    children: vueLib.vnodeMod.VNodeChildren
  ): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: vueLib.optionsMod.AsyncComponent[_, _, _, _]): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: vueLib.optionsMod.AsyncComponent[_, _, _, _], children: vueLib.vnodeMod.VNodeChildren): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: vueLib.optionsMod.AsyncComponent[_, _, _, _], data: vueLib.vnodeMod.VNodeData): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: vueLib.optionsMod.AsyncComponent[_, _, _, _],
    data: vueLib.vnodeMod.VNodeData,
    children: vueLib.vnodeMod.VNodeChildren
  ): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: vueLib.optionsMod.Component[_, _, _, _]): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: vueLib.optionsMod.Component[_, _, _, _], children: vueLib.vnodeMod.VNodeChildren): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(tag: vueLib.optionsMod.Component[_, _, _, _], data: vueLib.vnodeMod.VNodeData): vueLib.vnodeMod.VNode = js.native
  @JSName("$createElement")
  def $createElement(
    tag: vueLib.optionsMod.Component[_, _, _, _],
    data: vueLib.vnodeMod.VNodeData,
    children: vueLib.vnodeMod.VNodeChildren
  ): vueLib.vnodeMod.VNode = js.native
  @JSName("$delete")
  def $delete(`object`: js.Object, key: java.lang.String): scala.Unit = js.native
  @JSName("$delete")
  def $delete[T](array: js.Array[T], key: scala.Double): scala.Unit = js.native
  @JSName("$destroy")
  def $destroy(): scala.Unit = js.native
  @JSName("$emit")
  def $emit(event: java.lang.String, args: js.Any*): this.type = js.native
  @JSName("$forceUpdate")
  def $forceUpdate(): scala.Unit = js.native
  @JSName("$mount")
  def $mount(): this.type = js.native
  @JSName("$mount")
  def $mount(elementOrSelector: java.lang.String): this.type = js.native
  @JSName("$mount")
  def $mount(elementOrSelector: java.lang.String, hydrating: scala.Boolean): this.type = js.native
  @JSName("$mount")
  def $mount(elementOrSelector: stdLib.Element): this.type = js.native
  @JSName("$mount")
  def $mount(elementOrSelector: stdLib.Element, hydrating: scala.Boolean): this.type = js.native
  @JSName("$nextTick")
  def $nextTick(): js.Promise[scala.Unit] = js.native
  @JSName("$nextTick")
  def $nextTick(callback: js.ThisFunction0[/* this */ this.type, scala.Unit]): scala.Unit = js.native
  @JSName("$off")
  def $off(): this.type = js.native
  @JSName("$off")
  def $off(event: java.lang.String): this.type = js.native
  @JSName("$off")
  def $off(event: java.lang.String, callback: js.Function): this.type = js.native
  @JSName("$off")
  def $off(event: js.Array[java.lang.String]): this.type = js.native
  @JSName("$off")
  def $off(event: js.Array[java.lang.String], callback: js.Function): this.type = js.native
  @JSName("$on")
  def $on(event: java.lang.String, callback: js.Function): this.type = js.native
  @JSName("$on")
  def $on(event: js.Array[java.lang.String], callback: js.Function): this.type = js.native
  @JSName("$once")
  def $once(event: java.lang.String, callback: js.Function): this.type = js.native
  @JSName("$set")
  def $set[T](array: js.Array[T], key: scala.Double, value: T): T = js.native
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
    options: vueLib.optionsMod.WatchOptions
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
    options: vueLib.optionsMod.WatchOptions
  ): js.Function0[scala.Unit] = js.native
}


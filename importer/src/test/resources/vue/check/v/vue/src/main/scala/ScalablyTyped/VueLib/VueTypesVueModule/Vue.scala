package ScalablyTyped
package VueLib
package VueTypesVueModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Vue extends js.Object {
  @JSName("$attrs")
  val $attrs: StdLib.Record[java.lang.String, java.lang.String] = js.native
  @JSName("$children")
  val $children: StdLib.Array[VueLib.VueTypesVueModule.Vue] = js.native
  @JSName("$createElement")
  val $createElement: VueLib.VueTypesVueModule.CreateElement = js.native
  @JSName("$data")
  val $data: StdLib.Record[java.lang.String, _] = js.native
  @JSName("$delete")
  val $delete: js.Function2[/* object */ js.Object, /* key */ java.lang.String, scala.Unit] = js.native
  @JSName("$el")
  val $el: StdLib.HTMLElement = js.native
  @JSName("$isServer")
  val $isServer: scala.Boolean = js.native
  @JSName("$listeners")
  val $listeners: StdLib.Record[java.lang.String, js.Function | StdLib.Array[js.Function]] = js.native
  @JSName("$options")
  val $options: VueLib.VueTypesOptionsModule.ComponentOptions[VueLib.VueTypesVueModule.Vue, VueLib.VueTypesOptionsModule.DefaultData[VueLib.VueTypesVueModule.Vue], VueLib.VueTypesOptionsModule.DefaultMethods[VueLib.VueTypesVueModule.Vue], VueLib.VueTypesOptionsModule.DefaultComputed, VueLib.VueTypesOptionsModule.PropsDefinition[VueLib.VueTypesOptionsModule.DefaultProps]] = js.native
  @JSName("$parent")
  val $parent: VueLib.VueTypesVueModule.Vue = js.native
  @JSName("$props")
  val $props: StdLib.Record[java.lang.String, _] = js.native
  @JSName("$refs")
  val $refs: ScalablyTyped.runtime.StringDictionary[VueLib.VueTypesVueModule.Vue | StdLib.Element | StdLib.Array[VueLib.VueTypesVueModule.Vue] | StdLib.Array[StdLib.Element]] = js.native
  @JSName("$root")
  val $root: VueLib.VueTypesVueModule.Vue = js.native
  @JSName("$scopedSlots")
  val $scopedSlots: ScalablyTyped.runtime.StringDictionary[VueLib.VueTypesVnodeModule.ScopedSlot] = js.native
  @JSName("$set")
  val $set: js.Function3[/* object */ js.Object, /* key */ java.lang.String, /* value */ js.Any, _] = js.native
  @JSName("$slots")
  val $slots: ScalablyTyped.runtime.StringDictionary[StdLib.Array[VueLib.VueTypesVnodeModule.VNode]] = js.native
  @JSName("$ssrContext")
  val $ssrContext: js.Any = js.native
  @JSName("$vnode")
  val $vnode: VueLib.VueTypesVnodeModule.VNode = js.native
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
  def $nextTick(callback: js.Function1[/* this */ this.type, scala.Unit]): scala.Unit = js.native
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
  @JSName("$watch")
  def $watch(expOrFn: java.lang.String, callback: js.Function3[/* this */ this.type, /* n */ js.Any, /* o */ js.Any, scala.Unit]): js.Function0[scala.Unit] = js.native
  @JSName("$watch")
  def $watch(expOrFn: java.lang.String, callback: js.Function3[/* this */ this.type, /* n */ js.Any, /* o */ js.Any, scala.Unit], options: VueLib.VueTypesOptionsModule.WatchOptions): js.Function0[scala.Unit] = js.native
  @JSName("$watch")
  def $watch[T](expOrFn: js.Function1[/* this */ this.type, T], callback: js.Function3[/* this */ this.type, /* n */ T, /* o */ T, scala.Unit]): js.Function0[scala.Unit] = js.native
  @JSName("$watch")
  def $watch[T](expOrFn: js.Function1[/* this */ this.type, T], callback: js.Function3[/* this */ this.type, /* n */ T, /* o */ T, scala.Unit], options: VueLib.VueTypesOptionsModule.WatchOptions): js.Function0[scala.Unit] = js.native
}


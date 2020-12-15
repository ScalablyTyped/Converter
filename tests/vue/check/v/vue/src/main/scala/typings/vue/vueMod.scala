package typings.vue

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.StringDictionary
import typings.std.Element
import typings.std.Error
import typings.std.HTMLElement
import typings.std.Record
import typings.std.RegExp
import typings.vue.anon.FnCall
import typings.vue.anon.FnCallObjectKey
import typings.vue.anon.StaticRenderFns
import typings.vue.optionsMod.AsyncComponent
import typings.vue.optionsMod.Component
import typings.vue.optionsMod.ComponentOptions
import typings.vue.optionsMod.DefaultComputed
import typings.vue.optionsMod.DefaultData
import typings.vue.optionsMod.DefaultMethods
import typings.vue.optionsMod.DefaultProps
import typings.vue.optionsMod.DirectiveFunction
import typings.vue.optionsMod.DirectiveOptions
import typings.vue.optionsMod.FunctionalComponentOptions
import typings.vue.optionsMod.PropsDefinition
import typings.vue.optionsMod.RecordPropsDefinition
import typings.vue.optionsMod.ThisTypedComponentOptionsWithArrayProps
import typings.vue.optionsMod.ThisTypedComponentOptionsWithRecordProps
import typings.vue.optionsMod.WatchOptions
import typings.vue.pluginMod.PluginFunction
import typings.vue.pluginMod.PluginObject
import typings.vue.vnodeMod.ScopedSlot
import typings.vue.vnodeMod.VNode
import typings.vue.vnodeMod.VNodeChildren
import typings.vue.vnodeMod.VNodeData
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object vueMod {
  
  @JSImport("vue/types/vue", "Vue")
  @js.native
  val Vue: VueConstructor[typings.vue.vueMod.Vue] = js.native
  
  @js.native
  trait CreateElement extends js.Object {
    
    def apply(): VNode = js.native
    def apply(tag: js.UndefOr[Component[_, _, _, _]], children: VNodeChildren): VNode = js.native
    def apply(tag: js.UndefOr[Component[_, _, _, _]], data: js.UndefOr[scala.Nothing], children: VNodeChildren): VNode = js.native
    def apply(tag: js.UndefOr[Component[_, _, _, _]], data: VNodeData): VNode = js.native
    def apply(tag: js.UndefOr[Component[_, _, _, _]], data: VNodeData, children: VNodeChildren): VNode = js.native
    def apply(tag: String): VNode = js.native
    def apply(tag: String, children: VNodeChildren): VNode = js.native
    def apply(tag: String, data: js.UndefOr[scala.Nothing], children: VNodeChildren): VNode = js.native
    def apply(tag: String, data: VNodeData): VNode = js.native
    def apply(tag: String, data: VNodeData, children: VNodeChildren): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ]
    ): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      children: VNodeChildren
    ): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: js.UndefOr[scala.Nothing],
      children: VNodeChildren
    ): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: VNodeData
    ): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: VNodeData,
      children: VNodeChildren
    ): VNode = js.native
    def apply(tag: AsyncComponent[_, _, _, _]): VNode = js.native
    def apply(tag: AsyncComponent[_, _, _, _], children: VNodeChildren): VNode = js.native
    def apply(tag: AsyncComponent[_, _, _, _], data: js.UndefOr[scala.Nothing], children: VNodeChildren): VNode = js.native
    def apply(tag: AsyncComponent[_, _, _, _], data: VNodeData): VNode = js.native
    def apply(tag: AsyncComponent[_, _, _, _], data: VNodeData, children: VNodeChildren): VNode = js.native
    def apply(tag: Component[_, _, _, _]): VNode = js.native
  }
  
  @js.native
  trait Vue extends js.Object {
    
    @JSName("$attrs")
    val $attrs: Record[String, String] = js.native
    
    @JSName("$children")
    val $children: js.Array[typings.vue.vueMod.Vue] = js.native
    
    @JSName("$createElement")
    def $createElement(): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: js.UndefOr[Component[_, _, _, _]], children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: js.UndefOr[Component[_, _, _, _]], data: js.UndefOr[scala.Nothing], children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: js.UndefOr[Component[_, _, _, _]], data: VNodeData): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: js.UndefOr[Component[_, _, _, _]], data: VNodeData, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String, data: js.UndefOr[scala.Nothing], children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String, data: VNodeData): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String, data: VNodeData, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ]
    ): VNode = js.native
    @JSName("$createElement")
    def $createElement(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      children: VNodeChildren
    ): VNode = js.native
    @JSName("$createElement")
    def $createElement(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: js.UndefOr[scala.Nothing],
      children: VNodeChildren
    ): VNode = js.native
    @JSName("$createElement")
    def $createElement(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: VNodeData
    ): VNode = js.native
    @JSName("$createElement")
    def $createElement(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.vueMod.Vue], 
            DefaultMethods[typings.vue.vueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: VNodeData,
      children: VNodeChildren
    ): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[_, _, _, _]): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[_, _, _, _], children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[_, _, _, _], data: js.UndefOr[scala.Nothing], children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[_, _, _, _], data: VNodeData): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[_, _, _, _], data: VNodeData, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Component[_, _, _, _]): VNode = js.native
    @JSName("$createElement")
    var $createElement_Original: CreateElement = js.native
    
    @JSName("$data")
    val $data: Record[String, _] = js.native
    
    @JSName("$delete")
    def $delete(`object`: js.Object, key: String): Unit = js.native
    @JSName("$delete")
    def $delete[T](array: js.Array[T], key: Double): Unit = js.native
    @JSName("$delete")
    var $delete_Original: FnCallObjectKey = js.native
    
    @JSName("$destroy")
    def $destroy(): Unit = js.native
    
    @JSName("$el")
    val $el: HTMLElement = js.native
    
    @JSName("$emit")
    def $emit(event: String, args: js.Any*): this.type = js.native
    
    @JSName("$forceUpdate")
    def $forceUpdate(): Unit = js.native
    
    @JSName("$isServer")
    val $isServer: Boolean = js.native
    
    @JSName("$listeners")
    val $listeners: Record[String, js.Function | js.Array[js.Function]] = js.native
    
    @JSName("$mount")
    def $mount(): this.type = js.native
    @JSName("$mount")
    def $mount(elementOrSelector: js.UndefOr[scala.Nothing], hydrating: Boolean): this.type = js.native
    @JSName("$mount")
    def $mount(elementOrSelector: String): this.type = js.native
    @JSName("$mount")
    def $mount(elementOrSelector: String, hydrating: Boolean): this.type = js.native
    @JSName("$mount")
    def $mount(elementOrSelector: Element): this.type = js.native
    @JSName("$mount")
    def $mount(elementOrSelector: Element, hydrating: Boolean): this.type = js.native
    
    @JSName("$nextTick")
    def $nextTick(): js.Promise[Unit] = js.native
    @JSName("$nextTick")
    def $nextTick(callback: js.ThisFunction0[/* this */ this.type, Unit]): Unit = js.native
    
    @JSName("$off")
    def $off(): this.type = js.native
    @JSName("$off")
    def $off(event: js.UndefOr[scala.Nothing], callback: js.Function): this.type = js.native
    @JSName("$off")
    def $off(event: String): this.type = js.native
    @JSName("$off")
    def $off(event: String, callback: js.Function): this.type = js.native
    @JSName("$off")
    def $off(event: js.Array[String]): this.type = js.native
    @JSName("$off")
    def $off(event: js.Array[String], callback: js.Function): this.type = js.native
    
    @JSName("$on")
    def $on(event: String, callback: js.Function): this.type = js.native
    @JSName("$on")
    def $on(event: js.Array[String], callback: js.Function): this.type = js.native
    
    @JSName("$once")
    def $once(event: String, callback: js.Function): this.type = js.native
    
    @JSName("$options")
    val $options: ComponentOptions[
        typings.vue.vueMod.Vue, 
        DefaultData[typings.vue.vueMod.Vue], 
        DefaultMethods[typings.vue.vueMod.Vue], 
        DefaultComputed, 
        PropsDefinition[DefaultProps]
      ] = js.native
    
    @JSName("$parent")
    val $parent: typings.vue.vueMod.Vue = js.native
    
    @JSName("$props")
    val $props: Record[String, _] = js.native
    
    @JSName("$refs")
    val $refs: StringDictionary[typings.vue.vueMod.Vue | Element | (js.Array[Element | typings.vue.vueMod.Vue])] = js.native
    
    @JSName("$root")
    val $root: typings.vue.vueMod.Vue = js.native
    
    @JSName("$scopedSlots")
    val $scopedSlots: StringDictionary[ScopedSlot] = js.native
    
    @JSName("$set")
    def $set[T](array: js.Array[T], key: Double, value: T): T = js.native
    @JSName("$set")
    def $set[T](`object`: js.Object, key: String, value: T): T = js.native
    @JSName("$set")
    var $set_Original: FnCall = js.native
    
    @JSName("$slots")
    val $slots: StringDictionary[js.Array[VNode]] = js.native
    
    @JSName("$ssrContext")
    val $ssrContext: js.Any = js.native
    
    @JSName("$vnode")
    val $vnode: VNode = js.native
    
    @JSName("$watch")
    def $watch(
      expOrFn: String,
      callback: js.ThisFunction2[/* this */ this.type, /* n */ js.Any, /* o */ js.Any, Unit]
    ): js.Function0[Unit] = js.native
    @JSName("$watch")
    def $watch(
      expOrFn: String,
      callback: js.ThisFunction2[/* this */ this.type, /* n */ js.Any, /* o */ js.Any, Unit],
      options: WatchOptions
    ): js.Function0[Unit] = js.native
    @JSName("$watch")
    def $watch[T](
      expOrFn: js.ThisFunction0[/* this */ this.type, T],
      callback: js.ThisFunction2[/* this */ this.type, /* n */ T, /* o */ T, Unit]
    ): js.Function0[Unit] = js.native
    @JSName("$watch")
    def $watch[T](
      expOrFn: js.ThisFunction0[/* this */ this.type, T],
      callback: js.ThisFunction2[/* this */ this.type, /* n */ T, /* o */ T, Unit],
      options: WatchOptions
    ): js.Function0[Unit] = js.native
  }
  
  @js.native
  trait VueConfiguration extends js.Object {
    
    var devtools: Boolean = js.native
    
    def errorHandler(err: Error, vm: typings.vue.vueMod.Vue, info: String): Unit = js.native
    
    var ignoredElements: js.Array[String | RegExp] = js.native
    
    var keyCodes: StringDictionary[Double | js.Array[Double]] = js.native
    
    var optionMergeStrategies: js.Any = js.native
    
    var performance: Boolean = js.native
    
    var productionTip: Boolean = js.native
    
    var silent: Boolean = js.native
    
    def warnHandler(msg: String, vm: typings.vue.vueMod.Vue, trace: String): Unit = js.native
  }
  object VueConfiguration {
    
    @scala.inline
    def apply(
      devtools: Boolean,
      errorHandler: (Error, typings.vue.vueMod.Vue, String) => Unit,
      ignoredElements: js.Array[String | RegExp],
      keyCodes: StringDictionary[Double | js.Array[Double]],
      optionMergeStrategies: js.Any,
      performance: Boolean,
      productionTip: Boolean,
      silent: Boolean,
      warnHandler: (String, typings.vue.vueMod.Vue, String) => Unit
    ): VueConfiguration = {
      val __obj = js.Dynamic.literal(devtools = devtools.asInstanceOf[js.Any], errorHandler = js.Any.fromFunction3(errorHandler), ignoredElements = ignoredElements.asInstanceOf[js.Any], keyCodes = keyCodes.asInstanceOf[js.Any], optionMergeStrategies = optionMergeStrategies.asInstanceOf[js.Any], performance = performance.asInstanceOf[js.Any], productionTip = productionTip.asInstanceOf[js.Any], silent = silent.asInstanceOf[js.Any], warnHandler = js.Any.fromFunction3(warnHandler))
      __obj.asInstanceOf[VueConfiguration]
    }
    
    @scala.inline
    implicit class VueConfigurationOps[Self <: VueConfiguration] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setDevtools(value: Boolean): Self = this.set("devtools", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setErrorHandler(value: (Error, typings.vue.vueMod.Vue, String) => Unit): Self = this.set("errorHandler", js.Any.fromFunction3(value))
      
      @scala.inline
      def setIgnoredElementsVarargs(value: (String | RegExp)*): Self = this.set("ignoredElements", js.Array(value :_*))
      
      @scala.inline
      def setIgnoredElements(value: js.Array[String | RegExp]): Self = this.set("ignoredElements", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setKeyCodes(value: StringDictionary[Double | js.Array[Double]]): Self = this.set("keyCodes", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setOptionMergeStrategies(value: js.Any): Self = this.set("optionMergeStrategies", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPerformance(value: Boolean): Self = this.set("performance", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setProductionTip(value: Boolean): Self = this.set("productionTip", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setSilent(value: Boolean): Self = this.set("silent", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setWarnHandler(value: (String, typings.vue.vueMod.Vue, String) => Unit): Self = this.set("warnHandler", js.Any.fromFunction3(value))
    }
  }
  
  @js.native
  trait VueConstructor[V /* <: typings.vue.vueMod.Vue */]
    extends // ideally, the return type should just contains Props, not Record<keyof Props, any>. But TS requires Base constructors must all have the same return type.
  Instantiable0[
          CombinedVueInstance[V, js.Object, js.Object, js.Object, Record[/* keyof object */ String, js.Any]]
        ]
       with Instantiable1[
          (/* options */ ComponentOptions[V, DefaultData[V], DefaultMethods[V], DefaultComputed, PropsDefinition[DefaultProps]]) | (/* options */ ThisTypedComponentOptionsWithArrayProps[V, js.Object, js.Object, js.Object, String]) | (/* options */ ThisTypedComponentOptionsWithRecordProps[V, js.Object, js.Object, js.Object, js.Object]), 
          CombinedVueInstance[V, js.Object, js.Object, js.Object, Record[/* keyof object */ String, js.Any]]
        ] {
    
    def compile(template: String): StaticRenderFns = js.native
    
    def component(id: String): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
    def component(
      id: String,
      definition: ComponentOptions[V, DefaultData[V], DefaultMethods[V], DefaultComputed, PropsDefinition[DefaultProps]]
    ): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
    def component[VC /* <: VueConstructor[typings.vue.vueMod.Vue] */](id: String, constructor: VC): VC = js.native
    def component[Props](id: String, definition: FunctionalComponentOptions[Props, RecordPropsDefinition[Props]]): ExtendedVue[V, js.Object, js.Object, js.Object, Props] = js.native
    def component[Data, Methods, Computed, Props](id: String, definition: AsyncComponent[Data, Methods, Computed, Props]): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    @JSName("component")
    def component_DataMethodsComputedPropNames_String[Data, Methods, Computed, PropNames /* <: String */](id: String): ExtendedVue[V, Data, Methods, Computed, Record[PropNames, _]] = js.native
    @JSName("component")
    def component_DataMethodsComputedPropNames_String[Data, Methods, Computed, PropNames /* <: String */](
      id: String,
      definition: ThisTypedComponentOptionsWithArrayProps[V, Data, Methods, Computed, PropNames]
    ): ExtendedVue[V, Data, Methods, Computed, Record[PropNames, _]] = js.native
    @JSName("component")
    def component_DataMethodsComputedProps[Data, Methods, Computed, Props](id: String): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    @JSName("component")
    def component_DataMethodsComputedProps[Data, Methods, Computed, Props](
      id: String,
      definition: ThisTypedComponentOptionsWithRecordProps[V, Data, Methods, Computed, Props]
    ): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    @JSName("component")
    def component_PropNames_String[PropNames /* <: String */](id: String, definition: FunctionalComponentOptions[Record[PropNames, _], js.Array[PropNames]]): ExtendedVue[V, js.Object, js.Object, js.Object, Record[PropNames, _]] = js.native
    @JSName("component")
    def component_VueConstructor(id: String): VueConstructor[typings.vue.vueMod.Vue] = js.native
    
    var config: VueConfiguration = js.native
    
    def delete(`object`: js.Object, key: String): Unit = js.native
    def delete[T](array: js.Array[T], key: Double): Unit = js.native
    
    def directive(id: String): DirectiveOptions = js.native
    def directive(id: String, definition: DirectiveFunction): DirectiveOptions = js.native
    def directive(id: String, definition: DirectiveOptions): DirectiveOptions = js.native
    
    def extend(): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
    def extend(
      options: ComponentOptions[V, DefaultData[V], DefaultMethods[V], DefaultComputed, PropsDefinition[DefaultProps]]
    ): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
    def extend[Props](definition: FunctionalComponentOptions[Props, RecordPropsDefinition[Props]]): ExtendedVue[V, js.Object, js.Object, js.Object, Props] = js.native
    @JSName("extend")
    def extend_DataMethodsComputedPropNames_String[Data, Methods, Computed, PropNames /* <: String */](): ExtendedVue[V, Data, Methods, Computed, Record[PropNames, _]] = js.native
    @JSName("extend")
    def extend_DataMethodsComputedPropNames_String[Data, Methods, Computed, PropNames /* <: String */](options: ThisTypedComponentOptionsWithArrayProps[V, Data, Methods, Computed, PropNames]): ExtendedVue[V, Data, Methods, Computed, Record[PropNames, _]] = js.native
    @JSName("extend")
    def extend_DataMethodsComputedProps[Data, Methods, Computed, Props](): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    @JSName("extend")
    def extend_DataMethodsComputedProps[Data, Methods, Computed, Props](options: ThisTypedComponentOptionsWithRecordProps[V, Data, Methods, Computed, Props]): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    @JSName("extend")
    def extend_PropNames_String[PropNames /* <: String */](definition: FunctionalComponentOptions[Record[PropNames, _], js.Array[PropNames]]): ExtendedVue[V, js.Object, js.Object, js.Object, Record[PropNames, _]] = js.native
    
    def filter(id: String): js.Function = js.native
    def filter(id: String, definition: js.Function): js.Function = js.native
    
    def mixin(
      mixin: ComponentOptions[
          typings.vue.vueMod.Vue, 
          DefaultData[typings.vue.vueMod.Vue], 
          DefaultMethods[typings.vue.vueMod.Vue], 
          DefaultComputed, 
          PropsDefinition[DefaultProps]
        ]
    ): Unit = js.native
    def mixin(mixin: VueConstructor[typings.vue.vueMod.Vue]): Unit = js.native
    
    def nextTick(): js.Promise[Unit] = js.native
    def nextTick(callback: js.Function0[Unit]): Unit = js.native
    def nextTick(callback: js.Function0[Unit], context: js.Array[_]): Unit = js.native
    
    def set[T](array: js.Array[T], key: Double, value: T): T = js.native
    def set[T](`object`: js.Object, key: String, value: T): T = js.native
    
    def use(plugin: PluginFunction[_], options: js.Any*): Unit = js.native
    def use(plugin: PluginObject[_], options: js.Any*): Unit = js.native
    def use[T](plugin: PluginFunction[T]): Unit = js.native
    def use[T](plugin: PluginFunction[T], options: T): Unit = js.native
    def use[T](plugin: PluginObject[T]): Unit = js.native
    def use[T](plugin: PluginObject[T], options: T): Unit = js.native
  }
  
  type CombinedVueInstance[Instance /* <: typings.vue.vueMod.Vue */, Data, Methods, Computed, Props] = Data with Methods with Computed with Props with Instance
  
  type ExtendedVue[Instance /* <: typings.vue.vueMod.Vue */, Data, Methods, Computed, Props] = VueConstructor[
    (CombinedVueInstance[Instance, Data, Methods, Computed, Props]) with typings.vue.vueMod.Vue
  ]
}

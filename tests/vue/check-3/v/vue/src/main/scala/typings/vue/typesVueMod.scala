package typings.vue

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.StringDictionary
import typings.std.Element
import typings.std.HTMLElement
import typings.std.Record
import typings.vue.anon.FnCall
import typings.vue.anon.FnCallObjectKey
import typings.vue.anon.StaticRenderFns
import typings.vue.typesOptionsMod.AsyncComponent
import typings.vue.typesOptionsMod.Component
import typings.vue.typesOptionsMod.ComponentOptions
import typings.vue.typesOptionsMod.DefaultComputed
import typings.vue.typesOptionsMod.DefaultData
import typings.vue.typesOptionsMod.DefaultMethods
import typings.vue.typesOptionsMod.DefaultProps
import typings.vue.typesOptionsMod.DirectiveFunction
import typings.vue.typesOptionsMod.DirectiveOptions
import typings.vue.typesOptionsMod.FunctionalComponentOptions
import typings.vue.typesOptionsMod.PropsDefinition
import typings.vue.typesOptionsMod.RecordPropsDefinition
import typings.vue.typesOptionsMod.ThisTypedComponentOptionsWithArrayProps
import typings.vue.typesOptionsMod.ThisTypedComponentOptionsWithRecordProps
import typings.vue.typesOptionsMod.WatchOptions
import typings.vue.typesPluginMod.PluginFunction
import typings.vue.typesPluginMod.PluginObject
import typings.vue.typesVnodeMod.ScopedSlot
import typings.vue.typesVnodeMod.VNode
import typings.vue.typesVnodeMod.VNodeChildren
import typings.vue.typesVnodeMod.VNodeData
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object typesVueMod {
  
  @js.native
  trait Vue extends StObject {
    
    @JSName("$attrs")
    val $attrs: Record[String, String] = js.native
    
    @JSName("$children")
    val $children: js.Array[typings.vue.typesVueMod.Vue] = js.native
    
    @JSName("$createElement")
    def $createElement(): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String, data: Unit, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String, data: VNodeData): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: String, data: VNodeData, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ]
    ): VNode = js.native
    @JSName("$createElement")
    def $createElement(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
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
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: Unit,
      children: VNodeChildren
    ): VNode = js.native
    @JSName("$createElement")
    def $createElement(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
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
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: VNodeData,
      children: VNodeChildren
    ): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Unit, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Unit, data: Unit, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Unit, data: VNodeData): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Unit, data: VNodeData, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[Any, Any, Any, Any]): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[Any, Any, Any, Any], children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[Any, Any, Any, Any], data: Unit, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[Any, Any, Any, Any], data: VNodeData): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: AsyncComponent[Any, Any, Any, Any], data: VNodeData, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Component[Any, Any, Any, Any]): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Component[Any, Any, Any, Any], children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Component[Any, Any, Any, Any], data: Unit, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Component[Any, Any, Any, Any], data: VNodeData): VNode = js.native
    @JSName("$createElement")
    def $createElement(tag: Component[Any, Any, Any, Any], data: VNodeData, children: VNodeChildren): VNode = js.native
    @JSName("$createElement")
    var $createElement_Original: CreateElement = js.native
    
    @JSName("$data")
    val $data: Record[String, Any] = js.native
    
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
    def $emit(event: String, args: Any*): this.type = js.native
    
    @JSName("$forceUpdate")
    def $forceUpdate(): Unit = js.native
    
    @JSName("$isServer")
    val $isServer: Boolean = js.native
    
    @JSName("$listeners")
    val $listeners: Record[String, js.Function | js.Array[js.Function]] = js.native
    
    @JSName("$mount")
    def $mount(): this.type = js.native
    @JSName("$mount")
    def $mount(elementOrSelector: String): this.type = js.native
    @JSName("$mount")
    def $mount(elementOrSelector: String, hydrating: Boolean): this.type = js.native
    @JSName("$mount")
    def $mount(elementOrSelector: Unit, hydrating: Boolean): this.type = js.native
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
    def $off(event: String): this.type = js.native
    @JSName("$off")
    def $off(event: String, callback: js.Function): this.type = js.native
    @JSName("$off")
    def $off(event: js.Array[String]): this.type = js.native
    @JSName("$off")
    def $off(event: js.Array[String], callback: js.Function): this.type = js.native
    @JSName("$off")
    def $off(event: Unit, callback: js.Function): this.type = js.native
    
    @JSName("$on")
    def $on(event: String, callback: js.Function): this.type = js.native
    @JSName("$on")
    def $on(event: js.Array[String], callback: js.Function): this.type = js.native
    
    @JSName("$once")
    def $once(event: String, callback: js.Function): this.type = js.native
    
    @JSName("$options")
    val $options: ComponentOptions[
        typings.vue.typesVueMod.Vue, 
        DefaultData[typings.vue.typesVueMod.Vue], 
        DefaultMethods[typings.vue.typesVueMod.Vue], 
        DefaultComputed, 
        PropsDefinition[DefaultProps]
      ] = js.native
    
    @JSName("$parent")
    val $parent: typings.vue.typesVueMod.Vue = js.native
    
    @JSName("$props")
    val $props: Record[String, Any] = js.native
    
    @JSName("$refs")
    val $refs: StringDictionary[
        typings.vue.typesVueMod.Vue | Element | (js.Array[Element | typings.vue.typesVueMod.Vue])
      ] = js.native
    
    @JSName("$root")
    val $root: typings.vue.typesVueMod.Vue = js.native
    
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
    val $ssrContext: Any = js.native
    
    @JSName("$vnode")
    val $vnode: VNode = js.native
    
    @JSName("$watch")
    def $watch(expOrFn: String, callback: js.ThisFunction2[/* this */ this.type, /* n */ Any, /* o */ Any, Unit]): js.Function0[Unit] = js.native
    @JSName("$watch")
    def $watch(
      expOrFn: String,
      callback: js.ThisFunction2[/* this */ this.type, /* n */ Any, /* o */ Any, Unit],
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
  @JSImport("vue/types/vue", "Vue")
  @js.native
  val Vue: VueConstructor[typings.vue.typesVueMod.Vue] = js.native
  
  type CombinedVueInstance[Instance /* <: typings.vue.typesVueMod.Vue */, Data, Methods, Computed, Props] = Data & Methods & Computed & Props & Instance
  
  @js.native
  trait CreateElement extends StObject {
    
    def apply(): VNode = js.native
    def apply(tag: String): VNode = js.native
    def apply(tag: String, children: VNodeChildren): VNode = js.native
    def apply(tag: String, data: Unit, children: VNodeChildren): VNode = js.native
    def apply(tag: String, data: VNodeData): VNode = js.native
    def apply(tag: String, data: VNodeData, children: VNodeChildren): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ]
    ): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      children: VNodeChildren
    ): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: Unit,
      children: VNodeChildren
    ): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: VNodeData
    ): VNode = js.native
    def apply(
      tag: js.Function0[
          Component[
            DefaultData[typings.vue.typesVueMod.Vue], 
            DefaultMethods[typings.vue.typesVueMod.Vue], 
            DefaultComputed, 
            DefaultProps
          ]
        ],
      data: VNodeData,
      children: VNodeChildren
    ): VNode = js.native
    def apply(tag: Unit, children: VNodeChildren): VNode = js.native
    def apply(tag: Unit, data: Unit, children: VNodeChildren): VNode = js.native
    def apply(tag: Unit, data: VNodeData): VNode = js.native
    def apply(tag: Unit, data: VNodeData, children: VNodeChildren): VNode = js.native
    def apply(tag: AsyncComponent[Any, Any, Any, Any]): VNode = js.native
    def apply(tag: AsyncComponent[Any, Any, Any, Any], children: VNodeChildren): VNode = js.native
    def apply(tag: AsyncComponent[Any, Any, Any, Any], data: Unit, children: VNodeChildren): VNode = js.native
    def apply(tag: AsyncComponent[Any, Any, Any, Any], data: VNodeData): VNode = js.native
    def apply(tag: AsyncComponent[Any, Any, Any, Any], data: VNodeData, children: VNodeChildren): VNode = js.native
    def apply(tag: Component[Any, Any, Any, Any]): VNode = js.native
    def apply(tag: Component[Any, Any, Any, Any], children: VNodeChildren): VNode = js.native
    def apply(tag: Component[Any, Any, Any, Any], data: Unit, children: VNodeChildren): VNode = js.native
    def apply(tag: Component[Any, Any, Any, Any], data: VNodeData): VNode = js.native
    def apply(tag: Component[Any, Any, Any, Any], data: VNodeData, children: VNodeChildren): VNode = js.native
  }
  
  type ExtendedVue[Instance /* <: typings.vue.typesVueMod.Vue */, Data, Methods, Computed, Props] = VueConstructor[
    (CombinedVueInstance[Instance, Data, Methods, Computed, Props]) & typings.vue.typesVueMod.Vue
  ]
  
  trait VueConfiguration extends StObject {
    
    var devtools: Boolean
    
    def errorHandler(err: js.Error, vm: typings.vue.typesVueMod.Vue, info: String): Unit
    
    var ignoredElements: js.Array[String | js.RegExp]
    
    var keyCodes: StringDictionary[Double | js.Array[Double]]
    
    var optionMergeStrategies: Any
    
    var performance: Boolean
    
    var productionTip: Boolean
    
    var silent: Boolean
    
    def warnHandler(msg: String, vm: typings.vue.typesVueMod.Vue, trace: String): Unit
  }
  object VueConfiguration {
    
    inline def apply(
      devtools: Boolean,
      errorHandler: (js.Error, typings.vue.typesVueMod.Vue, String) => Unit,
      ignoredElements: js.Array[String | js.RegExp],
      keyCodes: StringDictionary[Double | js.Array[Double]],
      optionMergeStrategies: Any,
      performance: Boolean,
      productionTip: Boolean,
      silent: Boolean,
      warnHandler: (String, typings.vue.typesVueMod.Vue, String) => Unit
    ): VueConfiguration = {
      val __obj = js.Dynamic.literal(devtools = devtools.asInstanceOf[js.Any], errorHandler = js.Any.fromFunction3(errorHandler), ignoredElements = ignoredElements.asInstanceOf[js.Any], keyCodes = keyCodes.asInstanceOf[js.Any], optionMergeStrategies = optionMergeStrategies.asInstanceOf[js.Any], performance = performance.asInstanceOf[js.Any], productionTip = productionTip.asInstanceOf[js.Any], silent = silent.asInstanceOf[js.Any], warnHandler = js.Any.fromFunction3(warnHandler))
      __obj.asInstanceOf[VueConfiguration]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: VueConfiguration] (val x: Self) extends AnyVal {
      
      inline def setDevtools(value: Boolean): Self = StObject.set(x, "devtools", value.asInstanceOf[js.Any])
      
      inline def setErrorHandler(value: (js.Error, typings.vue.typesVueMod.Vue, String) => Unit): Self = StObject.set(x, "errorHandler", js.Any.fromFunction3(value))
      
      inline def setIgnoredElements(value: js.Array[String | js.RegExp]): Self = StObject.set(x, "ignoredElements", value.asInstanceOf[js.Any])
      
      inline def setIgnoredElementsVarargs(value: (String | js.RegExp)*): Self = StObject.set(x, "ignoredElements", js.Array(value*))
      
      inline def setKeyCodes(value: StringDictionary[Double | js.Array[Double]]): Self = StObject.set(x, "keyCodes", value.asInstanceOf[js.Any])
      
      inline def setOptionMergeStrategies(value: Any): Self = StObject.set(x, "optionMergeStrategies", value.asInstanceOf[js.Any])
      
      inline def setPerformance(value: Boolean): Self = StObject.set(x, "performance", value.asInstanceOf[js.Any])
      
      inline def setProductionTip(value: Boolean): Self = StObject.set(x, "productionTip", value.asInstanceOf[js.Any])
      
      inline def setSilent(value: Boolean): Self = StObject.set(x, "silent", value.asInstanceOf[js.Any])
      
      inline def setWarnHandler(value: (String, typings.vue.typesVueMod.Vue, String) => Unit): Self = StObject.set(x, "warnHandler", js.Any.fromFunction3(value))
    }
  }
  
  @js.native
  trait VueConstructor[V /* <: typings.vue.typesVueMod.Vue */]
    extends StObject
       with // ideally, the return type should just contains Props, not Record<keyof Props, any>. But TS requires Base constructors must all have the same return type.
  Instantiable0[
          CombinedVueInstance[V, js.Object, js.Object, js.Object, Record[/* keyof object */ String, Any]]
        ]
       with Instantiable1[
          (/* options */ ComponentOptions[V, DefaultData[V], DefaultMethods[V], DefaultComputed, PropsDefinition[DefaultProps]]) | (/* options */ ThisTypedComponentOptionsWithArrayProps[V, js.Object, js.Object, js.Object, String]) | (/* options */ ThisTypedComponentOptionsWithRecordProps[V, js.Object, js.Object, js.Object, js.Object]), 
          CombinedVueInstance[V, js.Object, js.Object, js.Object, Record[/* keyof object */ String, Any]]
        ] {
    
    def compile(template: String): StaticRenderFns = js.native
    
    def component(id: String): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
    def component(
      id: String,
      definition: ComponentOptions[V, DefaultData[V], DefaultMethods[V], DefaultComputed, PropsDefinition[DefaultProps]]
    ): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
    def component[VC /* <: VueConstructor[typings.vue.typesVueMod.Vue] */](id: String, constructor: VC): VC = js.native
    def component[PropNames /* <: String */](id: String, definition: FunctionalComponentOptions[Record[PropNames, Any], js.Array[PropNames]]): ExtendedVue[V, js.Object, js.Object, js.Object, Record[PropNames, Any]] = js.native
    def component[Data, Methods, Computed, Props](id: String, definition: AsyncComponent[Data, Methods, Computed, Props]): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    def component[Data, Methods, Computed, PropNames /* <: String */](
      id: String,
      definition: ThisTypedComponentOptionsWithArrayProps[V, Data, Methods, Computed, PropNames]
    ): ExtendedVue[V, Data, Methods, Computed, Record[PropNames, Any]] = js.native
    def component[Data, Methods, Computed, Props](
      id: String,
      definition: ThisTypedComponentOptionsWithRecordProps[V, Data, Methods, Computed, Props]
    ): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    @JSName("component")
    def component_DataMethodsComputedPropNames[Data, Methods, Computed, PropNames /* <: String */](id: String): ExtendedVue[V, Data, Methods, Computed, Record[PropNames, Any]] = js.native
    @JSName("component")
    def component_DataMethodsComputedProps[Data, Methods, Computed, Props](id: String): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    @JSName("component")
    def component_Props[Props](id: String, definition: FunctionalComponentOptions[Props, RecordPropsDefinition[Props]]): ExtendedVue[V, js.Object, js.Object, js.Object, Props] = js.native
    @JSName("component")
    def component_VueConstructor(id: String): VueConstructor[typings.vue.typesVueMod.Vue] = js.native
    
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
    def extend[PropNames /* <: String */](definition: FunctionalComponentOptions[Record[PropNames, Any], js.Array[PropNames]]): ExtendedVue[V, js.Object, js.Object, js.Object, Record[PropNames, Any]] = js.native
    def extend[Data, Methods, Computed, PropNames /* <: String */](options: ThisTypedComponentOptionsWithArrayProps[V, Data, Methods, Computed, PropNames]): ExtendedVue[V, Data, Methods, Computed, Record[PropNames, Any]] = js.native
    def extend[Data, Methods, Computed, Props](options: ThisTypedComponentOptionsWithRecordProps[V, Data, Methods, Computed, Props]): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    @JSName("extend")
    def extend_DataMethodsComputedPropNames[Data, Methods, Computed, PropNames /* <: String */](): ExtendedVue[V, Data, Methods, Computed, Record[PropNames, Any]] = js.native
    @JSName("extend")
    def extend_DataMethodsComputedProps[Data, Methods, Computed, Props](): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
    @JSName("extend")
    def extend_Props[Props](definition: FunctionalComponentOptions[Props, RecordPropsDefinition[Props]]): ExtendedVue[V, js.Object, js.Object, js.Object, Props] = js.native
    
    def filter(id: String): js.Function = js.native
    def filter(id: String, definition: js.Function): js.Function = js.native
    
    def mixin(
      mixin: ComponentOptions[
          typings.vue.typesVueMod.Vue, 
          DefaultData[typings.vue.typesVueMod.Vue], 
          DefaultMethods[typings.vue.typesVueMod.Vue], 
          DefaultComputed, 
          PropsDefinition[DefaultProps]
        ]
    ): Unit = js.native
    def mixin(mixin: VueConstructor[typings.vue.typesVueMod.Vue]): Unit = js.native
    
    def nextTick(): js.Promise[Unit] = js.native
    def nextTick(callback: js.Function0[Unit]): Unit = js.native
    def nextTick(callback: js.Function0[Unit], context: js.Array[Any]): Unit = js.native
    
    def set[T](array: js.Array[T], key: Double, value: T): T = js.native
    def set[T](`object`: js.Object, key: String, value: T): T = js.native
    
    def use(plugin: PluginFunction[Any], options: Any*): Unit = js.native
    def use(plugin: PluginObject[Any], options: Any*): Unit = js.native
    def use[T](plugin: PluginFunction[T]): Unit = js.native
    def use[T](plugin: PluginFunction[T], options: T): Unit = js.native
    def use[T](plugin: PluginObject[T]): Unit = js.native
    def use[T](plugin: PluginObject[T], options: T): Unit = js.native
  }
}

package typings
package vueLib.vueVueMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait VueConstructor[V /* <: Vue */]
  extends // ideally, the return type should just contains Props, not Record<keyof Props, any>. But TS requires Base constructors must all have the same return type.
org.scalablytyped.runtime.Instantiable0[
      CombinedVueInstance[V, js.Object, js.Object, js.Object, stdLib.Record[java.lang.String, js.Any]]
    ]
     with org.scalablytyped.runtime.Instantiable1[
      (/* options */ vueLib.optionsMod.ComponentOptions[
        V, 
        vueLib.optionsMod.DefaultData[V], 
        vueLib.optionsMod.DefaultMethods[V], 
        vueLib.optionsMod.DefaultComputed, 
        vueLib.optionsMod.PropsDefinition[vueLib.optionsMod.DefaultProps]
      ]) | (/* options */ vueLib.optionsMod.ThisTypedComponentOptionsWithArrayProps[V, js.Object, js.Object, js.Object, java.lang.String]) | (/* options */ vueLib.optionsMod.ThisTypedComponentOptionsWithRecordProps[V, js.Object, js.Object, js.Object, js.Object]), 
      CombinedVueInstance[V, js.Object, js.Object, js.Object, stdLib.Record[java.lang.String, js.Any]]
    ] {
  var config: VueConfiguration = js.native
  def compile(template: java.lang.String): vueLib.Anon_CreateElement = js.native
  def component(id: java.lang.String): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
  def component(
    id: java.lang.String,
    definition: vueLib.optionsMod.ComponentOptions[
      V, 
      vueLib.optionsMod.DefaultData[V], 
      vueLib.optionsMod.DefaultMethods[V], 
      vueLib.optionsMod.DefaultComputed, 
      vueLib.optionsMod.PropsDefinition[vueLib.optionsMod.DefaultProps]
    ]
  ): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
  def component[VC /* <: VueConstructor[Vue] */](id: java.lang.String, constructor: VC): VC = js.native
  def component[PropNames /* <: java.lang.String */](
    id: java.lang.String,
    definition: vueLib.optionsMod.FunctionalComponentOptions[stdLib.Record[PropNames, _], js.Array[PropNames]]
  ): ExtendedVue[V, js.Object, js.Object, js.Object, stdLib.Record[PropNames, _]] = js.native
  def component[Data, Methods, Computed, Props](id: java.lang.String, definition: vueLib.optionsMod.AsyncComponent[Data, Methods, Computed, Props]): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("component")
  def component_DataMethodsComputedPropNamesString[Data, Methods, Computed, PropNames /* <: java.lang.String */](id: java.lang.String): ExtendedVue[V, Data, Methods, Computed, stdLib.Record[PropNames, _]] = js.native
  @JSName("component")
  def component_DataMethodsComputedPropNamesString[Data, Methods, Computed, PropNames /* <: java.lang.String */](
    id: java.lang.String,
    definition: vueLib.optionsMod.ThisTypedComponentOptionsWithArrayProps[V, Data, Methods, Computed, PropNames]
  ): ExtendedVue[V, Data, Methods, Computed, stdLib.Record[PropNames, _]] = js.native
  @JSName("component")
  def component_DataMethodsComputedProps[Data, Methods, Computed, Props](id: java.lang.String): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("component")
  def component_DataMethodsComputedProps[Data, Methods, Computed, Props](
    id: java.lang.String,
    definition: vueLib.optionsMod.ThisTypedComponentOptionsWithRecordProps[V, Data, Methods, Computed, Props]
  ): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("component")
  def component_Props[Props](
    id: java.lang.String,
    definition: vueLib.optionsMod.FunctionalComponentOptions[Props, vueLib.optionsMod.RecordPropsDefinition[Props]]
  ): ExtendedVue[V, js.Object, js.Object, js.Object, Props] = js.native
  @JSName("component")
  def component_VueConstructor(id: java.lang.String): VueConstructor[Vue] = js.native
  def delete(`object`: js.Object, key: java.lang.String): scala.Unit = js.native
  def delete[T](array: js.Array[T], key: scala.Double): scala.Unit = js.native
  def directive(id: java.lang.String): vueLib.optionsMod.DirectiveOptions = js.native
  def directive(id: java.lang.String, definition: vueLib.optionsMod.DirectiveFunction): vueLib.optionsMod.DirectiveOptions = js.native
  def directive(id: java.lang.String, definition: vueLib.optionsMod.DirectiveOptions): vueLib.optionsMod.DirectiveOptions = js.native
  def extend(): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
  def extend(
    options: vueLib.optionsMod.ComponentOptions[
      V, 
      vueLib.optionsMod.DefaultData[V], 
      vueLib.optionsMod.DefaultMethods[V], 
      vueLib.optionsMod.DefaultComputed, 
      vueLib.optionsMod.PropsDefinition[vueLib.optionsMod.DefaultProps]
    ]
  ): ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
  def extend[PropNames /* <: java.lang.String */](
    definition: vueLib.optionsMod.FunctionalComponentOptions[stdLib.Record[PropNames, _], js.Array[PropNames]]
  ): ExtendedVue[V, js.Object, js.Object, js.Object, stdLib.Record[PropNames, _]] = js.native
  @JSName("extend")
  def extend_DataMethodsComputedPropNamesString[Data, Methods, Computed, PropNames /* <: java.lang.String */](): ExtendedVue[V, Data, Methods, Computed, stdLib.Record[PropNames, _]] = js.native
  @JSName("extend")
  def extend_DataMethodsComputedPropNamesString[Data, Methods, Computed, PropNames /* <: java.lang.String */](
    options: vueLib.optionsMod.ThisTypedComponentOptionsWithArrayProps[V, Data, Methods, Computed, PropNames]
  ): ExtendedVue[V, Data, Methods, Computed, stdLib.Record[PropNames, _]] = js.native
  @JSName("extend")
  def extend_DataMethodsComputedProps[Data, Methods, Computed, Props](): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("extend")
  def extend_DataMethodsComputedProps[Data, Methods, Computed, Props](
    options: vueLib.optionsMod.ThisTypedComponentOptionsWithRecordProps[V, Data, Methods, Computed, Props]
  ): ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("extend")
  def extend_Props[Props](
    definition: vueLib.optionsMod.FunctionalComponentOptions[Props, vueLib.optionsMod.RecordPropsDefinition[Props]]
  ): ExtendedVue[V, js.Object, js.Object, js.Object, Props] = js.native
  def filter(id: java.lang.String): js.Function = js.native
  def filter(id: java.lang.String, definition: js.Function): js.Function = js.native
  def mixin(
    mixin: vueLib.optionsMod.ComponentOptions[
      Vue, 
      vueLib.optionsMod.DefaultData[Vue], 
      vueLib.optionsMod.DefaultMethods[Vue], 
      vueLib.optionsMod.DefaultComputed, 
      vueLib.optionsMod.PropsDefinition[vueLib.optionsMod.DefaultProps]
    ]
  ): scala.Unit = js.native
  def mixin(mixin: VueConstructor[Vue]): scala.Unit = js.native
  def nextTick(): js.Promise[scala.Unit] = js.native
  def nextTick(callback: js.Function0[scala.Unit]): scala.Unit = js.native
  def nextTick(callback: js.Function0[scala.Unit], context: js.Array[_]): scala.Unit = js.native
  def set[T](array: js.Array[T], key: scala.Double, value: T): T = js.native
  def set[T](`object`: js.Object, key: java.lang.String, value: T): T = js.native
  def use(plugin: vueLib.pluginMod.PluginFunction[_], options: js.Any*): scala.Unit = js.native
  def use(plugin: vueLib.pluginMod.PluginObject[_], options: js.Any*): scala.Unit = js.native
  def use[T](plugin: vueLib.pluginMod.PluginFunction[T]): scala.Unit = js.native
  def use[T](plugin: vueLib.pluginMod.PluginFunction[T], options: T): scala.Unit = js.native
  def use[T](plugin: vueLib.pluginMod.PluginObject[T]): scala.Unit = js.native
  def use[T](plugin: vueLib.pluginMod.PluginObject[T], options: T): scala.Unit = js.native
}


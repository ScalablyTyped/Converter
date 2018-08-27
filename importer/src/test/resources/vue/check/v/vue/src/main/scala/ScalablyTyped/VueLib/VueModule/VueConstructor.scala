package ScalablyTyped
package VueLib.VueModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait VueConstructor[V /* <: VueLib.VueTypesVueModule.Vue */] extends ScalablyTyped.runtime.Instantiable0[VueLib.VueTypesVueModule.CombinedVueInstance[V, js.Object, js.Object, js.Object, StdLib.Record[java.lang.String, js.Any]]] with ScalablyTyped.runtime.Instantiable1[/* options */ VueLib.VueTypesOptionsModule.ComponentOptions[V, VueLib.VueTypesOptionsModule.DefaultData[V], VueLib.VueTypesOptionsModule.DefaultMethods[V], VueLib.VueTypesOptionsModule.DefaultComputed, VueLib.VueTypesOptionsModule.PropsDefinition[VueLib.VueTypesOptionsModule.DefaultProps]], VueLib.VueTypesVueModule.CombinedVueInstance[V, js.Object, js.Object, js.Object, StdLib.Record[java.lang.String, js.Any]]] {
  val config: VueLib.VueTypesVueModule.VueConfiguration = js.native
  def compile(template: java.lang.String): VueLib.Anon_StaticRenderFnsRender = js.native
  def component(id: java.lang.String): VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue] = js.native
  def component(id: java.lang.String, definition: VueLib.VueTypesOptionsModule.ComponentOptions[V, VueLib.VueTypesOptionsModule.DefaultData[V], VueLib.VueTypesOptionsModule.DefaultMethods[V], VueLib.VueTypesOptionsModule.DefaultComputed, VueLib.VueTypesOptionsModule.PropsDefinition[VueLib.VueTypesOptionsModule.DefaultProps]]): VueLib.VueTypesVueModule.ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
  def component[VC /* <: VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue] */](id: java.lang.String, constructor: VC): VC = js.native
  def component[PropNames /* <: java.lang.String */](id: java.lang.String, definition: VueLib.VueTypesOptionsModule.FunctionalComponentOptions[StdLib.Record[PropNames, _], StdLib.Array[PropNames]]): VueLib.VueTypesVueModule.ExtendedVue[V, js.Object, js.Object, js.Object, StdLib.Record[PropNames, _]] = js.native
  def component[Data, Methods, Computed, Props](id: java.lang.String, definition: VueLib.VueTypesOptionsModule.AsyncComponent[Data, Methods, Computed, Props]): VueLib.VueTypesVueModule.ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("component")
  def component_DataMethodsComputedPropNamesString[Data, Methods, Computed, PropNames /* <: java.lang.String */](id: java.lang.String, definition: VueLib.VueTypesOptionsModule.ThisTypedComponentOptionsWithArrayProps[V, Data, Methods, Computed, PropNames]): VueLib.VueTypesVueModule.ExtendedVue[V, Data, Methods, Computed, StdLib.Record[PropNames, _]] = js.native
  @JSName("component")
  def component_DataMethodsComputedPropNamesStringExtendedVue[Data, Methods, Computed, PropNames /* <: java.lang.String */](id: java.lang.String): VueLib.VueTypesVueModule.ExtendedVue[V, Data, Methods, Computed, StdLib.Record[PropNames, _]] = js.native
  @JSName("component")
  def component_DataMethodsComputedProps[Data, Methods, Computed, Props](id: java.lang.String, definition: VueLib.VueTypesOptionsModule.ThisTypedComponentOptionsWithRecordProps[V, Data, Methods, Computed, Props]): VueLib.VueTypesVueModule.ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("component")
  def component_DataMethodsComputedPropsExtendedVue[Data, Methods, Computed, Props](id: java.lang.String): VueLib.VueTypesVueModule.ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("component")
  def component_ExtendedVue(id: java.lang.String): VueLib.VueTypesVueModule.ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
  @JSName("component")
  def component_Props[Props](id: java.lang.String, definition: VueLib.VueTypesOptionsModule.FunctionalComponentOptions[Props, VueLib.VueTypesOptionsModule.RecordPropsDefinition[Props]]): VueLib.VueTypesVueModule.ExtendedVue[V, js.Object, js.Object, js.Object, Props] = js.native
  def delete(`object`: js.Object, key: java.lang.String): scala.Unit = js.native
  def delete[T](array: StdLib.Array[T], key: scala.Double): scala.Unit = js.native
  def directive(id: java.lang.String): VueLib.VueTypesOptionsModule.DirectiveOptions = js.native
  def directive(id: java.lang.String, definition: VueLib.VueTypesOptionsModule.DirectiveFunction): VueLib.VueTypesOptionsModule.DirectiveOptions = js.native
  def directive(id: java.lang.String, definition: VueLib.VueTypesOptionsModule.DirectiveOptions): VueLib.VueTypesOptionsModule.DirectiveOptions = js.native
  def extend(): VueLib.VueTypesVueModule.ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
  def extend(options: VueLib.VueTypesOptionsModule.ComponentOptions[V, VueLib.VueTypesOptionsModule.DefaultData[V], VueLib.VueTypesOptionsModule.DefaultMethods[V], VueLib.VueTypesOptionsModule.DefaultComputed, VueLib.VueTypesOptionsModule.PropsDefinition[VueLib.VueTypesOptionsModule.DefaultProps]]): VueLib.VueTypesVueModule.ExtendedVue[V, js.Object, js.Object, js.Object, js.Object] = js.native
  def extend[PropNames /* <: java.lang.String */](definition: VueLib.VueTypesOptionsModule.FunctionalComponentOptions[StdLib.Record[PropNames, _], StdLib.Array[PropNames]]): VueLib.VueTypesVueModule.ExtendedVue[V, js.Object, js.Object, js.Object, StdLib.Record[PropNames, _]] = js.native
  @JSName("extend")
  def extend_DataMethodsComputedPropNamesString[Data, Methods, Computed, PropNames /* <: java.lang.String */](): VueLib.VueTypesVueModule.ExtendedVue[V, Data, Methods, Computed, StdLib.Record[PropNames, _]] = js.native
  @JSName("extend")
  def extend_DataMethodsComputedPropNamesString[Data, Methods, Computed, PropNames /* <: java.lang.String */](options: VueLib.VueTypesOptionsModule.ThisTypedComponentOptionsWithArrayProps[V, Data, Methods, Computed, PropNames]): VueLib.VueTypesVueModule.ExtendedVue[V, Data, Methods, Computed, StdLib.Record[PropNames, _]] = js.native
  @JSName("extend")
  def extend_DataMethodsComputedProps[Data, Methods, Computed, Props](): VueLib.VueTypesVueModule.ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("extend")
  def extend_DataMethodsComputedProps[Data, Methods, Computed, Props](options: VueLib.VueTypesOptionsModule.ThisTypedComponentOptionsWithRecordProps[V, Data, Methods, Computed, Props]): VueLib.VueTypesVueModule.ExtendedVue[V, Data, Methods, Computed, Props] = js.native
  @JSName("extend")
  def extend_Props[Props](definition: VueLib.VueTypesOptionsModule.FunctionalComponentOptions[Props, VueLib.VueTypesOptionsModule.RecordPropsDefinition[Props]]): VueLib.VueTypesVueModule.ExtendedVue[V, js.Object, js.Object, js.Object, Props] = js.native
  def filter(id: java.lang.String): js.Function = js.native
  def filter(id: java.lang.String, definition: js.Function): js.Function = js.native
  def mixin(mixin: VueLib.VueTypesOptionsModule.ComponentOptions[VueLib.VueTypesVueModule.Vue, VueLib.VueTypesOptionsModule.DefaultData[VueLib.VueTypesVueModule.Vue], VueLib.VueTypesOptionsModule.DefaultMethods[VueLib.VueTypesVueModule.Vue], VueLib.VueTypesOptionsModule.DefaultComputed, VueLib.VueTypesOptionsModule.PropsDefinition[VueLib.VueTypesOptionsModule.DefaultProps]]): scala.Unit = js.native
  def mixin(mixin: VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue]): scala.Unit = js.native
  def nextTick(): StdLib.Promise = js.native
  def nextTick(callback: js.Function0[scala.Unit]): scala.Unit = js.native
  def nextTick(callback: js.Function0[scala.Unit], context: StdLib.Array[_]): scala.Unit = js.native
  def set[T](array: StdLib.Array[T], key: scala.Double, value: T): T = js.native
  def set[T](`object`: js.Object, key: java.lang.String, value: T): T = js.native
  def use(plugin: VueLib.VueTypesPluginModule.PluginFunction[_], options: js.Any*): scala.Unit = js.native
  def use(plugin: VueLib.VueTypesPluginModule.PluginObject[_], options: js.Any*): scala.Unit = js.native
  def use[T](plugin: VueLib.VueTypesPluginModule.PluginFunction[T]): scala.Unit = js.native
  def use[T](plugin: VueLib.VueTypesPluginModule.PluginFunction[T], options: T): scala.Unit = js.native
  def use[T](plugin: VueLib.VueTypesPluginModule.PluginObject[T]): scala.Unit = js.native
  def use[T](plugin: VueLib.VueTypesPluginModule.PluginObject[T], options: T): scala.Unit = js.native
}


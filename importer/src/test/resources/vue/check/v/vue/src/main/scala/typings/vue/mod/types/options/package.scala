package typings.vue.mod.types

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object options {
  import org.scalablytyped.runtime.StringDictionary
  import typings.std.HTMLElement
  import typings.std.Record
  import typings.std.ThisType
  import typings.vue.Anon_Args
  import typings.vue.Anon_Default
  import typings.vue.mod.types.vnode.VNode
  import typings.vue.mod.types.vnode.VNodeDirective
  import typings.vue.mod.types.vue.CombinedVueInstance
  import typings.vue.mod.types.vue.Vue
  import typings.vue.mod.types.vue.VueConstructor

  type Accessors[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ K in keyof T ]: (): T[K] | vue.vue/types/options.ComputedOptions<T[K]>}
    */ typings.vue.vueStrings.Accessors with js.Any
  type ArrayPropsDefinition[T] = js.Array[String]
  type AsyncComponent[Data, Methods, Computed, Props] = js.Function2[
    /* resolve */ js.Function1[/* component */ Component[Data, Methods, Computed, Props], Unit], 
    /* reject */ js.Function1[/* reason */ js.UndefOr[js.Any], Unit], 
    (js.Promise[
      (Component[DefaultData[Vue], DefaultMethods[Vue], DefaultComputed, DefaultProps]) | EsModuleComponent
    ]) | Unit
  ]
  type Component[Data, Methods, Computed, Props] = VueConstructor[Vue] | (FunctionalComponentOptions[Props, PropsDefinition[Props]]) | (ComponentOptions[Vue, Data, Methods, Computed, Props])
  type DefaultComputed = StringDictionary[js.Any]
  type DefaultData[V] = js.Object | (js.ThisFunction0[/* this */ V, js.Object])
  type DefaultMethods[V] = StringDictionary[js.ThisFunction1[/* this */ V, /* repeated */ js.Any, js.Any]]
  type DefaultProps = Record[String, js.Any]
  type DirectiveFunction = js.Function4[
    /* el */ HTMLElement, 
    /* binding */ VNodeDirective, 
    /* vnode */ VNode, 
    /* oldVnode */ VNode, 
    Unit
  ]
  type InjectKey = String | js.Symbol
  type InjectOptions = (StringDictionary[InjectKey | Anon_Default]) | js.Array[String]
  type Prop[T] = js.Function0[T] | Anon_Args[T]
  type PropValidator[T] = PropOptions[T] | Prop[T] | js.Array[Prop[T]]
  type PropsDefinition[T] = ArrayPropsDefinition[T] | RecordPropsDefinition[T]
  type RecordPropsDefinition[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ K in keyof T ]: vue.vue/types/options.PropValidator<T[K]>}
    */ typings.vue.vueStrings.RecordPropsDefinition with T
  type ThisTypedComponentOptionsWithArrayProps[V /* <: Vue */, Data, Methods, Computed, PropNames /* <: String */] = js.Object with (ComponentOptions[
    V, 
    Data | (js.ThisFunction0[/* this */ (Record[PropNames, _]) with V, Data]), 
    Methods, 
    Computed, 
    js.Array[PropNames]
  ]) with (ThisType[CombinedVueInstance[V, Data, Methods, Computed, Record[PropNames, _]]])
  type ThisTypedComponentOptionsWithRecordProps[V /* <: Vue */, Data, Methods, Computed, Props] = js.Object with (ComponentOptions[
    V, 
    Data | (js.ThisFunction0[/* this */ Props with V, Data]), 
    Methods, 
    Computed, 
    RecordPropsDefinition[Props]
  ]) with (ThisType[CombinedVueInstance[V, Data, Methods, Computed, Props]])
  type WatchHandler[T] = js.Function2[/* val */ T, /* oldVal */ T, Unit]
}

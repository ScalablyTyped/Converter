package typings
package vueLib

import org.scalablytyped.runtime.StringDictionary
import stdLib.HTMLElement
import stdLib.Record
import stdLib.ThisType
import vueLib.Anon_Default
import vueLib.typesVnodeMod.VNode
import vueLib.typesVnodeMod.VNodeDirective
import vueLib.typesVueMod.CombinedVueInstance
import vueLib.typesVueMod.Vue
import vueLib.typesVueMod.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typesOptionsMod {
  type Accessors[T] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ K in keyof T ]: (): T[K] | vue.vue/types/options.ComputedOptions<T[K]>}
    */ vueLib.vueLibStrings.Accessors with js.Any
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
  /* Rewritten from type alias, can be one of: 
    - vueLib.typesOptionsMod.PropOptions[T]
    - vueLib.typesOptionsMod.Prop[T]
    - js.Array[vueLib.typesOptionsMod.Prop[T]]
  */
  type PropValidator[T] = _PropValidator[T] | js.Array[Prop[T]]
  type PropsDefinition[T] = ArrayPropsDefinition[T] | RecordPropsDefinition[T]
  type RecordPropsDefinition[T] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ K in keyof T ]: vue.vue/types/options.PropValidator<T[K]>}
    */ vueLib.vueLibStrings.RecordPropsDefinition with T
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

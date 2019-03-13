package typings
package vueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typesOptionsMod {
  type Accessors[T] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ K in keyof T ]: (): T[K] | vue.vue/types/options.ComputedOptions<T[K]>}
    */ vueLib.vueLibStrings.Accessors with js.Any
  type ArrayPropsDefinition[T] = js.Array[java.lang.String]
  type AsyncComponent[Data, Methods, Computed, Props] = js.Function2[
    /* resolve */ js.Function1[/* component */ Component[Data, Methods, Computed, Props], scala.Unit], 
    /* reject */ js.Function1[/* reason */ js.UndefOr[js.Any], scala.Unit], 
    (js.Promise[
      (Component[
        DefaultData[vueLib.typesVueMod.Vue], 
        DefaultMethods[vueLib.typesVueMod.Vue], 
        DefaultComputed, 
        DefaultProps
      ]) | EsModuleComponent
    ]) | scala.Unit
  ]
  type Component[Data, Methods, Computed, Props] = vueLib.typesVueMod.VueConstructor[vueLib.typesVueMod.Vue] | (FunctionalComponentOptions[Props, PropsDefinition[Props]]) | (ComponentOptions[vueLib.typesVueMod.Vue, Data, Methods, Computed, Props])
  type DefaultData[V] = js.Object | (js.ThisFunction0[/* this */ V, js.Object])
  type DefaultProps = stdLib.Record[java.lang.String, js.Any]
  type DirectiveFunction = js.Function4[
    /* el */ stdLib.HTMLElement, 
    /* binding */ vueLib.typesVnodeMod.VNodeDirective, 
    /* vnode */ vueLib.typesVnodeMod.VNode, 
    /* oldVnode */ vueLib.typesVnodeMod.VNode, 
    scala.Unit
  ]
  type InjectKey = java.lang.String | js.Symbol
  type InjectOptions = (org.scalablytyped.runtime.StringDictionary[InjectKey | vueLib.Anon_Default]) | js.Array[java.lang.String]
  /* Rewritten from type alias, can be one of: 
    - PropOptions[T]
    - Prop[T]
    - js.Array[Prop[T]]
  */
  type PropValidator[T] = _PropValidator[T] | js.Array[Prop[T]]
  type PropsDefinition[T] = ArrayPropsDefinition[T] | RecordPropsDefinition[T]
  type RecordPropsDefinition[T] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ K in keyof T ]: vue.vue/types/options.PropValidator<T[K]>}
    */ vueLib.vueLibStrings.RecordPropsDefinition with T
  type ThisTypedComponentOptionsWithArrayProps[V /* <: vueLib.typesVueMod.Vue */, Data, Methods, Computed, PropNames /* <: java.lang.String */] = js.Object with (ComponentOptions[
    V, 
    Data | (js.ThisFunction0[/* this */ (stdLib.Readonly[stdLib.Record[PropNames, _]]) with V, Data]), 
    Methods, 
    Computed, 
    js.Array[PropNames]
  ]) with (stdLib.ThisType[
    vueLib.typesVueMod.CombinedVueInstance[V, Data, Methods, Computed, stdLib.Readonly[stdLib.Record[PropNames, _]]]
  ])
  type ThisTypedComponentOptionsWithRecordProps[V /* <: vueLib.typesVueMod.Vue */, Data, Methods, Computed, Props] = js.Object with (ComponentOptions[
    V, 
    Data | (js.ThisFunction0[/* this */ stdLib.Readonly[Props] with V, Data]), 
    Methods, 
    Computed, 
    RecordPropsDefinition[Props]
  ]) with (stdLib.ThisType[
    vueLib.typesVueMod.CombinedVueInstance[V, Data, Methods, Computed, stdLib.Readonly[Props]]
  ])
  type WatchHandler[T] = js.Function2[/* val */ T, /* oldVal */ T, scala.Unit]
}

package typings
package vueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object optionsMod {
  type Accessors[T] = vueLib.vueLibStrings.Accessors with T
  type ArrayPropsDefinition[T] = js.Array[java.lang.String]
  type AsyncComponent[Data, Methods, Computed, Props] = js.Function2[
    /* resolve */ js.Function1[/* component */ Component[Data, Methods, Computed, Props], scala.Unit], 
    /* reject */ js.Function1[/* reason */ js.UndefOr[js.Any], scala.Unit], 
    (js.Promise[
      (Component[
        DefaultData[vueLib.vueVueMod.Vue], 
        DefaultMethods[vueLib.vueVueMod.Vue], 
        DefaultComputed, 
        DefaultProps
      ]) | EsModuleComponent
    ]) | scala.Unit
  ]
  type Component[Data, Methods, Computed, Props] = vueLib.vueVueMod.VueConstructor[vueLib.vueVueMod.Vue] | (FunctionalComponentOptions[Props, PropsDefinition[Props]]) | (ComponentOptions[vueLib.vueVueMod.Vue, Data, Methods, Computed, Props])
  type DefaultData[V] = js.Object | (js.ThisFunction0[/* this */ V, js.Object])
  type DefaultProps = stdLib.Record[java.lang.String, js.Any]
  type DirectiveFunction = js.Function4[
    /* el */ stdLib.HTMLElement, 
    /* binding */ vueLib.vnodeMod.VNodeDirective, 
    /* vnode */ vueLib.vnodeMod.VNode, 
    /* oldVnode */ vueLib.vnodeMod.VNode, 
    scala.Unit
  ]
  type InjectKey = java.lang.String | js.Symbol
  type InjectOptions = (org.scalablytyped.runtime.StringDictionary[InjectKey | vueLib.Anon_Default]) | js.Array[java.lang.String]
  type Prop[T] = vueLib.Anon_T[T] | vueLib.Anon_Args[T]
  type PropValidator[T] = PropOptions[T] | Prop[T] | js.Array[Prop[T]]
  type PropsDefinition[T] = ArrayPropsDefinition[T] | RecordPropsDefinition[T]
  type RecordPropsDefinition[T] = vueLib.vueLibStrings.RecordPropsDefinition with T
  type ThisTypedComponentOptionsWithArrayProps[V /* <: vueLib.vueVueMod.Vue */, Data, Methods, Computed, PropNames /* <: java.lang.String */] = js.Object with (ComponentOptions[
    V, 
    Data | (js.ThisFunction0[/* this */ (stdLib.Readonly[stdLib.Record[PropNames, _]]) with V, Data]), 
    Methods, 
    Computed, 
    js.Array[PropNames]
  ]) with (stdLib.ThisType[
    vueLib.vueVueMod.CombinedVueInstance[V, Data, Methods, Computed, stdLib.Readonly[stdLib.Record[PropNames, _]]]
  ])
  type ThisTypedComponentOptionsWithRecordProps[V /* <: vueLib.vueVueMod.Vue */, Data, Methods, Computed, Props] = js.Object with (ComponentOptions[
    V, 
    Data | (js.ThisFunction0[/* this */ stdLib.Readonly[Props] with V, Data]), 
    Methods, 
    Computed, 
    RecordPropsDefinition[Props]
  ]) with (stdLib.ThisType[
    vueLib.vueVueMod.CombinedVueInstance[V, Data, Methods, Computed, stdLib.Readonly[Props]]
  ])
  type WatchHandler[T] = js.Function2[/* val */ T, /* oldVal */ T, scala.Unit]
}

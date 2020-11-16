package typings.vue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object optionsMod {
  
  type Accessors[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ K in keyof T ]: (): T[K] | vue.vue/types/options.ComputedOptions<T[K]>}
    */ typings.vue.vueStrings.Accessors with org.scalablytyped.runtime.TopLevel[js.Any]
  
  type ArrayPropsDefinition[T] = js.Array[/* keyof T */ java.lang.String]
  
  type AsyncComponent[Data, Methods, Computed, Props] = js.Function2[
    /* resolve */ js.Function1[
      /* component */ typings.vue.optionsMod.Component[Data, Methods, Computed, Props], 
      scala.Unit
    ], 
    /* reject */ js.Function1[/* reason */ js.UndefOr[js.Any], scala.Unit], 
    (js.Promise[
      (typings.vue.optionsMod.Component[
        typings.vue.optionsMod.DefaultData[typings.vue.vueMod.Vue], 
        typings.vue.optionsMod.DefaultMethods[typings.vue.vueMod.Vue], 
        typings.vue.optionsMod.DefaultComputed, 
        typings.vue.optionsMod.DefaultProps
      ]) | typings.vue.optionsMod.EsModuleComponent
    ]) | scala.Unit
  ]
  
  type Component[Data, Methods, Computed, Props] = typings.vue.vueMod.VueConstructor[typings.vue.vueMod.Vue] | (typings.vue.optionsMod.FunctionalComponentOptions[Props, typings.vue.optionsMod.PropsDefinition[Props]]) | (typings.vue.optionsMod.ComponentOptions[typings.vue.vueMod.Vue, Data, Methods, Computed, Props])
  
  type DefaultComputed = org.scalablytyped.runtime.StringDictionary[js.Any]
  
  type DefaultData[V] = js.Object | (js.ThisFunction0[/* this */ V, js.Object])
  
  type DefaultMethods[V] = org.scalablytyped.runtime.StringDictionary[js.ThisFunction1[/* this */ V, /* repeated */ js.Any, js.Any]]
  
  type DefaultProps = typings.std.Record[java.lang.String, js.Any]
  
  type DirectiveFunction = js.Function4[
    /* el */ typings.std.HTMLElement, 
    /* binding */ typings.vue.vnodeMod.VNodeDirective, 
    /* vnode */ typings.vue.vnodeMod.VNode, 
    /* oldVnode */ typings.vue.vnodeMod.VNode, 
    scala.Unit
  ]
  
  type InjectKey = java.lang.String | js.Symbol
  
  type InjectOptions = (org.scalablytyped.runtime.StringDictionary[typings.vue.optionsMod.InjectKey | typings.vue.anon.Default]) | js.Array[java.lang.String]
  
  type Prop[T] = js.Function0[T] | typings.vue.anon.Instantiable[T]
  
  type PropValidator[T] = typings.vue.optionsMod.PropOptions[T] | typings.vue.optionsMod.Prop[T] | js.Array[typings.vue.optionsMod.Prop[T]]
  
  type PropsDefinition[T] = typings.vue.optionsMod.ArrayPropsDefinition[T] | typings.vue.optionsMod.RecordPropsDefinition[T]
  
  type RecordPropsDefinition[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ K in keyof T ]: vue.vue/types/options.PropValidator<T[K]>}
    */ typings.vue.vueStrings.RecordPropsDefinition with org.scalablytyped.runtime.TopLevel[T]
  
  type ThisTypedComponentOptionsWithArrayProps[V /* <: typings.vue.vueMod.Vue */, Data, Methods, Computed, PropNames /* <: java.lang.String */] = js.Object with (typings.vue.optionsMod.ComponentOptions[
    V, 
    Data | (js.ThisFunction0[/* this */ (typings.std.Record[PropNames, _]) with V, Data]), 
    Methods, 
    Computed, 
    js.Array[PropNames]
  ]) with (typings.std.ThisType[
    typings.vue.vueMod.CombinedVueInstance[V, Data, Methods, Computed, typings.std.Record[PropNames, _]]
  ])
  
  type ThisTypedComponentOptionsWithRecordProps[V /* <: typings.vue.vueMod.Vue */, Data, Methods, Computed, Props] = js.Object with (typings.vue.optionsMod.ComponentOptions[
    V, 
    Data | (js.ThisFunction0[/* this */ Props with V, Data]), 
    Methods, 
    Computed, 
    typings.vue.optionsMod.RecordPropsDefinition[Props]
  ]) with (typings.std.ThisType[typings.vue.vueMod.CombinedVueInstance[V, Data, Methods, Computed, Props]])
  
  type WatchHandler[T] = js.Function2[/* val */ T, /* oldVal */ T, scala.Unit]
}

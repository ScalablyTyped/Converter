package ScalablyTyped
package VueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object VueTypesOptionsModule {
  type ArrayPropsDefinition[T] = StdLib.Array[java.lang.String]
  type AsyncComponent[Data, Methods, Computed, Props] = js.Function2[/* resolve */ js.Function1[/* component */ VueLib.VueTypesOptionsModule.Component[Data, Methods, Computed, Props], scala.Unit], /* reject */ js.Function1[/* reason */ js.UndefOr[js.Any], scala.Unit], StdLib.Promise | scala.Unit]
  type Component[Data, Methods, Computed, Props] = VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue] | (VueLib.VueTypesOptionsModule.FunctionalComponentOptions[Props, VueLib.VueTypesOptionsModule.PropsDefinition[Props]]) | (VueLib.VueTypesOptionsModule.ComponentOptions[VueLib.VueTypesVueModule.Vue, Data, Methods, Computed, Props])
  type DefaultData[V] = js.Object | (js.Function1[/* this */ V, js.Object])
  type DefaultProps = StdLib.Record[java.lang.String, js.Any]
  type DirectiveFunction = js.Function4[/* el */ StdLib.HTMLElement, /* binding */ VueLib.VueTypesVnodeModule.VNodeDirective, /* vnode */ VueLib.VueTypesVnodeModule.VNode, /* oldVnode */ VueLib.VueTypesVnodeModule.VNode, scala.Unit]
  type InjectKey = java.lang.String | js.Symbol
  type InjectOptions = (ScalablyTyped.runtime.StringDictionary[VueLib.VueTypesOptionsModule.InjectKey | VueLib.Anon_From]) | StdLib.Array[java.lang.String]
  type Prop[T] = VueLib.Anon_T[T] | VueLib.Anon_Args[T]
  type PropValidator[T] = VueLib.VueTypesOptionsModule.PropOptions[T] | VueLib.VueTypesOptionsModule.Prop[T] | StdLib.Array[VueLib.VueTypesOptionsModule.Prop[T]]
  type PropsDefinition[T] = VueLib.VueTypesOptionsModule.ArrayPropsDefinition[T] | VueLib.VueTypesOptionsModule.RecordPropsDefinition[T]
  type ThisTypedComponentOptionsWithArrayProps[V /* <: VueLib.VueTypesVueModule.Vue */, Data, Methods, Computed, PropNames /* <: java.lang.String */] = (StdLib.ThisType[VueLib.VueTypesVueModule.CombinedVueInstance[V, Data, Methods, Computed, StdLib.Readonly[StdLib.Record[PropNames, _]]]]) with (VueLib.VueTypesOptionsModule.ComponentOptions[V, Data | (js.Function1[/* this */ (StdLib.Readonly[StdLib.Record[PropNames, _]]) with V, Data]), Methods, Computed, StdLib.Array[PropNames]]) with js.Object
  type ThisTypedComponentOptionsWithRecordProps[V /* <: VueLib.VueTypesVueModule.Vue */, Data, Methods, Computed, Props] = (StdLib.ThisType[VueLib.VueTypesVueModule.CombinedVueInstance[V, Data, Methods, Computed, StdLib.Readonly[Props]]]) with (VueLib.VueTypesOptionsModule.ComponentOptions[V, Data | (js.Function1[/* this */ StdLib.Readonly[Props] with V, Data]), Methods, Computed, VueLib.VueTypesOptionsModule.RecordPropsDefinition[Props]]) with js.Object
  type WatchHandler[T] = js.Function2[/* val */ T, /* oldVal */ T, scala.Unit]
}

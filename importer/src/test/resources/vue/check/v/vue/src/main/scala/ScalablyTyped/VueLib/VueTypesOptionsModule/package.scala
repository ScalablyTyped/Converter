package ScalablyTyped
package VueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object VueTypesOptionsModule {
  type ArrayPropsDefinition[T] = StdLib.Array[java.lang.String]
  type AsyncComponent[Data, Methods, Computed, Props] = js.Function2[/* resolve */ js.Function1[/* component */ Component[Data, Methods, Computed, Props], scala.Unit], /* reject */ js.Function1[/* reason */ js.UndefOr[js.Any], scala.Unit], StdLib.Promise | scala.Unit]
  type Component[Data, Methods, Computed, Props] = VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue] | (FunctionalComponentOptions[Props, PropsDefinition[Props]]) | (ComponentOptions[VueLib.VueTypesVueModule.Vue, Data, Methods, Computed, Props])
  type DefaultData[V] = js.Object | (js.Function1[/* this */ V, js.Object])
  type DefaultProps = StdLib.Record[java.lang.String, js.Any]
  type DirectiveFunction = js.Function4[/* el */ StdLib.Node, /* binding */ VueLib.VueTypesVnodeModule.VNodeDirective, /* vnode */ VueLib.VueTypesVnodeModule.VNode, /* oldVnode */ VueLib.VueTypesVnodeModule.VNode, scala.Unit]
  type InjectKey = java.lang.String | js.Symbol
  type InjectOptions = (ScalablyTyped.runtime.StringDictionary[InjectKey | VueLib.Anon_From]) | StdLib.Array[java.lang.String]
  type Prop[T] = VueLib.Anon_T[T] | VueLib.Anon_Args[T]
  type PropValidator[T] = PropOptions[T] | Prop[T] | StdLib.Array[Prop[T]]
  type PropsDefinition[T] = StdLib.Array[java.lang.String] | RecordPropsDefinition[T]
  type ThisTypedComponentOptionsWithArrayProps[V /* <: VueLib.VueTypesVueModule.Vue */, Data, Methods, Computed, PropNames /* <: java.lang.String */] = js.Object with (ComponentOptions[V, Data | (js.Function1[/* this */ (StdLib.Readonly[StdLib.Record[PropNames, _]]) with V, Data]), Methods, Computed, StdLib.Array[PropNames]]) with (StdLib.ThisType[VueLib.VueTypesVueModule.CombinedVueInstance[V, Data, Methods, Computed, StdLib.Readonly[StdLib.Record[PropNames, _]]]])
  type ThisTypedComponentOptionsWithRecordProps[V /* <: VueLib.VueTypesVueModule.Vue */, Data, Methods, Computed, Props] = js.Object with (ComponentOptions[V, Data | (js.Function1[/* this */ StdLib.Readonly[Props] with V, Data]), Methods, Computed, RecordPropsDefinition[Props]]) with (StdLib.ThisType[VueLib.VueTypesVueModule.CombinedVueInstance[V, Data, Methods, Computed, StdLib.Readonly[Props]]])
  type WatchHandler[T] = js.Function2[/* val */ T, /* oldVal */ T, scala.Unit]
}

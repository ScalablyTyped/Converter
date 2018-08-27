package ScalablyTyped
package VueLib.VueTypesOptionsModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait ComponentOptions[V /* <: VueLib.VueTypesVueModule.Vue */, Data, Methods, Computed, PropsDef] extends js.Object {
  val activated: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val beforeCreate: js.UndefOr[js.Function1[/* this */ V, scala.Unit]] = js.undefined
  val beforeDestroy: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val beforeMount: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val beforeUpdate: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val comments: js.UndefOr[scala.Boolean] = js.undefined
  val components: js.UndefOr[ScalablyTyped.runtime.StringDictionary[(Component[_, _, _, _]) | (AsyncComponent[_, _, _, _])]] = js.undefined
  val computed: js.UndefOr[Accessors[Computed]] = js.undefined
  val created: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val data: js.UndefOr[Data] = js.undefined
  val deactivated: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val delimiters: js.UndefOr[js.Tuple2[java.lang.String, java.lang.String]] = js.undefined
  val destroyed: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val directives: js.UndefOr[ScalablyTyped.runtime.StringDictionary[DirectiveFunction | DirectiveOptions]] = js.undefined
  val el: js.UndefOr[StdLib.Element | java.lang.String] = js.undefined
  val errorCaptured: js.UndefOr[js.Function0[scala.Boolean | scala.Unit]] = js.undefined
  // TODO: support properly inferred 'extends'
  val `extends`: js.UndefOr[(ComponentOptions[VueLib.VueTypesVueModule.Vue, DefaultData[VueLib.VueTypesVueModule.Vue], DefaultMethods[VueLib.VueTypesVueModule.Vue], DefaultComputed, PropsDefinition[DefaultProps]]) | VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue]] = js.undefined
  val filters: js.UndefOr[ScalablyTyped.runtime.StringDictionary[js.Function]] = js.undefined
  val inheritAttrs: js.UndefOr[scala.Boolean] = js.undefined
  val inject: js.UndefOr[InjectOptions] = js.undefined
  val methods: js.UndefOr[Methods] = js.undefined
  val mixins: js.UndefOr[StdLib.Array[(ComponentOptions[VueLib.VueTypesVueModule.Vue, DefaultData[VueLib.VueTypesVueModule.Vue], DefaultMethods[VueLib.VueTypesVueModule.Vue], DefaultComputed, PropsDefinition[DefaultProps]]) | VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue]]] = js.undefined
  val model: js.UndefOr[VueLib.Anon_Prop] = js.undefined
  val mounted: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val name: js.UndefOr[java.lang.String] = js.undefined
  val parent: js.UndefOr[VueLib.VueTypesVueModule.Vue] = js.undefined
  val props: js.UndefOr[PropsDef] = js.undefined
  val propsData: js.UndefOr[js.Object] = js.undefined
  val provide: js.UndefOr[js.Object | js.Function0[js.Object]] = js.undefined
  val render: js.UndefOr[js.Function1[/* createElement */ VueLib.VueTypesVueModule.CreateElement, VueLib.VueTypesVnodeModule.VNode]] = js.undefined
  val renderError: js.UndefOr[js.Function2[/* h */ js.Function0[VueLib.VueTypesVnodeModule.VNode], /* err */ StdLib.Error, VueLib.VueTypesVnodeModule.VNode]] = js.undefined
  val staticRenderFns: js.UndefOr[StdLib.Array[js.Function1[/* createElement */ VueLib.VueTypesVueModule.CreateElement, VueLib.VueTypesVnodeModule.VNode]]] = js.undefined
  val template: js.UndefOr[java.lang.String] = js.undefined
  val transitions: js.UndefOr[ScalablyTyped.runtime.StringDictionary[js.Object]] = js.undefined
  val updated: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  val watch: js.UndefOr[StdLib.Record[java.lang.String, WatchOptionsWithHandler[_] | WatchHandler[_] | java.lang.String]] = js.undefined
}


package typings
package vueLib.typesOptionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ComponentOptions[V /* <: vueLib.typesVueMod.Vue */, Data, Methods, Computed, PropsDef] extends js.Object {
  var activated: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  var beforeCreate: js.UndefOr[js.ThisFunction0[/* this */ V, scala.Unit]] = js.undefined
  var beforeDestroy: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  var beforeMount: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  var beforeUpdate: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  var comments: js.UndefOr[scala.Boolean] = js.undefined
  var components: js.UndefOr[
    org.scalablytyped.runtime.StringDictionary[(Component[_, _, _, _]) | (AsyncComponent[_, _, _, _])]
  ] = js.undefined
  var computed: js.UndefOr[Accessors[Computed]] = js.undefined
  var created: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  var data: js.UndefOr[Data] = js.undefined
  var deactivated: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  var delimiters: js.UndefOr[js.Tuple2[java.lang.String, java.lang.String]] = js.undefined
  var destroyed: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  var directives: js.UndefOr[org.scalablytyped.runtime.StringDictionary[DirectiveFunction | DirectiveOptions]] = js.undefined
  var el: js.UndefOr[stdLib.Element | java.lang.String] = js.undefined
  var errorCaptured: js.UndefOr[js.Function0[scala.Boolean | scala.Unit]] = js.undefined
  // TODO: support properly inferred 'extends'
  var `extends`: js.UndefOr[
    (ComponentOptions[
      vueLib.typesVueMod.Vue, 
      DefaultData[vueLib.typesVueMod.Vue], 
      DefaultMethods[vueLib.typesVueMod.Vue], 
      DefaultComputed, 
      PropsDefinition[DefaultProps]
    ]) | vueLib.typesVueMod.VueConstructor[vueLib.typesVueMod.Vue]
  ] = js.undefined
  var filters: js.UndefOr[org.scalablytyped.runtime.StringDictionary[js.Function]] = js.undefined
  var inheritAttrs: js.UndefOr[scala.Boolean] = js.undefined
  var inject: js.UndefOr[InjectOptions] = js.undefined
  var methods: js.UndefOr[Methods] = js.undefined
  var mixins: js.UndefOr[
    js.Array[
      (ComponentOptions[
        vueLib.typesVueMod.Vue, 
        DefaultData[vueLib.typesVueMod.Vue], 
        DefaultMethods[vueLib.typesVueMod.Vue], 
        DefaultComputed, 
        PropsDefinition[DefaultProps]
      ]) | vueLib.typesVueMod.VueConstructor[vueLib.typesVueMod.Vue]
    ]
  ] = js.undefined
  var model: js.UndefOr[vueLib.Anon_Prop] = js.undefined
  var mounted: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  var name: js.UndefOr[java.lang.String] = js.undefined
  var parent: js.UndefOr[vueLib.typesVueMod.Vue] = js.undefined
  var props: js.UndefOr[PropsDef] = js.undefined
  var propsData: js.UndefOr[js.Object] = js.undefined
  var provide: js.UndefOr[js.Object | js.Function0[js.Object]] = js.undefined
  var render: js.UndefOr[
    js.Function1[/* createElement */ vueLib.typesVueMod.CreateElement, vueLib.typesVnodeMod.VNode]
  ] = js.undefined
  var renderError: js.UndefOr[
    js.Function2[
      /* h */ js.Function0[vueLib.typesVnodeMod.VNode], 
      /* err */ stdLib.Error, 
      vueLib.typesVnodeMod.VNode
    ]
  ] = js.undefined
  var staticRenderFns: js.UndefOr[
    js.Array[
      js.Function1[/* createElement */ vueLib.typesVueMod.CreateElement, vueLib.typesVnodeMod.VNode]
    ]
  ] = js.undefined
  var template: js.UndefOr[java.lang.String] = js.undefined
  var transitions: js.UndefOr[org.scalablytyped.runtime.StringDictionary[js.Object]] = js.undefined
  var updated: js.UndefOr[js.Function0[scala.Unit]] = js.undefined
  var watch: js.UndefOr[
    stdLib.Record[java.lang.String, WatchOptionsWithHandler[_] | WatchHandler[_] | java.lang.String]
  ] = js.undefined
}


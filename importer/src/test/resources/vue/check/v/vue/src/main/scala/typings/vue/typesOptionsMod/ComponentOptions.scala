package typings.vue.typesOptionsMod

import org.scalablytyped.runtime.StringDictionary
import org.scalablytyped.runtime.UndefOr
import typings.std.Element
import typings.std.Error
import typings.std.Record
import typings.vue.Anon_Event
import typings.vue.typesVnodeMod.VNode
import typings.vue.typesVueMod.CreateElement
import typings.vue.typesVueMod.Vue
import typings.vue.typesVueMod.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ComponentOptions[V /* <: Vue */, Data, Methods, Computed, PropsDef] extends js.Object {
  var activated: UndefOr[js.Function0[Unit]] = js.undefined
  var beforeCreate: UndefOr[js.ThisFunction0[/* this */ V, Unit]] = js.undefined
  var beforeDestroy: UndefOr[js.Function0[Unit]] = js.undefined
  var beforeMount: UndefOr[js.Function0[Unit]] = js.undefined
  var beforeUpdate: UndefOr[js.Function0[Unit]] = js.undefined
  var comments: UndefOr[Boolean] = js.undefined
  var components: UndefOr[StringDictionary[(Component[_, _, _, _]) | (AsyncComponent[_, _, _, _])]] = js.undefined
  var computed: UndefOr[Accessors[Computed]] = js.undefined
  var created: UndefOr[js.Function0[Unit]] = js.undefined
  var data: UndefOr[Data] = js.undefined
  var deactivated: UndefOr[js.Function0[Unit]] = js.undefined
  var delimiters: UndefOr[js.Tuple2[String, String]] = js.undefined
  var destroyed: UndefOr[js.Function0[Unit]] = js.undefined
  var directives: UndefOr[StringDictionary[DirectiveFunction | DirectiveOptions]] = js.undefined
  var el: UndefOr[Element | String] = js.undefined
  var errorCaptured: UndefOr[js.Function0[Boolean | Unit]] = js.undefined
  // TODO: support properly inferred 'extends'
  var `extends`: UndefOr[
    (ComponentOptions[
      Vue, 
      DefaultData[Vue], 
      DefaultMethods[Vue], 
      DefaultComputed, 
      PropsDefinition[DefaultProps]
    ]) | VueConstructor[Vue]
  ] = js.undefined
  var filters: UndefOr[StringDictionary[js.Function]] = js.undefined
  var inheritAttrs: UndefOr[Boolean] = js.undefined
  var inject: UndefOr[InjectOptions] = js.undefined
  var methods: UndefOr[Methods] = js.undefined
  var mixins: UndefOr[
    js.Array[
      (ComponentOptions[
        Vue, 
        DefaultData[Vue], 
        DefaultMethods[Vue], 
        DefaultComputed, 
        PropsDefinition[DefaultProps]
      ]) | VueConstructor[Vue]
    ]
  ] = js.undefined
  var model: UndefOr[Anon_Event] = js.undefined
  var mounted: UndefOr[js.Function0[Unit]] = js.undefined
  var name: UndefOr[String] = js.undefined
  var parent: UndefOr[Vue] = js.undefined
  var props: UndefOr[PropsDef] = js.undefined
  var propsData: UndefOr[js.Object] = js.undefined
  var provide: UndefOr[js.Object | js.Function0[js.Object]] = js.undefined
  var render: UndefOr[js.Function1[/* createElement */ CreateElement, VNode]] = js.undefined
  var renderError: UndefOr[js.Function2[/* h */ js.Function0[VNode], /* err */ Error, VNode]] = js.undefined
  var staticRenderFns: UndefOr[js.Array[js.Function1[/* createElement */ CreateElement, VNode]]] = js.undefined
  var template: UndefOr[String] = js.undefined
  var transitions: UndefOr[StringDictionary[js.Object]] = js.undefined
  var updated: UndefOr[js.Function0[Unit]] = js.undefined
  var watch: UndefOr[Record[String, WatchOptionsWithHandler[_] | WatchHandler[_] | String]] = js.undefined
}

object ComponentOptions {
  @scala.inline
  def apply[V /* <: Vue */, Data, Methods, Computed, PropsDef](
    activated: () => Unit = null,
    beforeCreate: js.ThisFunction0[/* this */ V, Unit] = null,
    beforeDestroy: () => Unit = null,
    beforeMount: () => Unit = null,
    beforeUpdate: () => Unit = null,
    comments: `<undefined>` | Boolean = js.undefined,
    components: StringDictionary[(Component[_, _, _, _]) | (AsyncComponent[_, _, _, _])] = null,
    computed: Accessors[Computed] = null,
    created: () => Unit = null,
    data: Data = null,
    deactivated: () => Unit = null,
    delimiters: js.Tuple2[String, String] = null,
    destroyed: () => Unit = null,
    directives: StringDictionary[DirectiveFunction | DirectiveOptions] = null,
    el: Element | String = null,
    errorCaptured: () => Boolean | Unit = null,
    `extends`: (ComponentOptions[
      Vue, 
      DefaultData[Vue], 
      DefaultMethods[Vue], 
      DefaultComputed, 
      PropsDefinition[DefaultProps]
    ]) | VueConstructor[Vue] = null,
    filters: StringDictionary[js.Function] = null,
    inheritAttrs: `<undefined>` | Boolean = js.undefined,
    inject: InjectOptions = null,
    methods: Methods = null,
    mixins: js.Array[
      (ComponentOptions[
        Vue, 
        DefaultData[Vue], 
        DefaultMethods[Vue], 
        DefaultComputed, 
        PropsDefinition[DefaultProps]
      ]) | VueConstructor[Vue]
    ] = null,
    model: Anon_Event = null,
    mounted: () => Unit = null,
    name: String = null,
    parent: Vue = null,
    props: PropsDef = null,
    propsData: js.Object = null,
    provide: js.Object | js.Function0[js.Object] = null,
    render: /* createElement */ CreateElement => VNode = null,
    renderError: (/* h */ js.Function0[VNode], /* err */ Error) => VNode = null,
    staticRenderFns: js.Array[js.Function1[/* createElement */ CreateElement, VNode]] = null,
    template: String = null,
    transitions: StringDictionary[js.Object] = null,
    updated: () => Unit = null,
    watch: Record[String, WatchOptionsWithHandler[_] | WatchHandler[_] | String] = null
  ): ComponentOptions[V, Data, Methods, Computed, PropsDef] = {
    val __obj = js.Dynamic.literal()
    if (activated != null) __obj.updateDynamic("activated")(js.Any.fromFunction0(activated))
    if (beforeCreate != null) __obj.updateDynamic("beforeCreate")(beforeCreate)
    if (beforeDestroy != null) __obj.updateDynamic("beforeDestroy")(js.Any.fromFunction0(beforeDestroy))
    if (beforeMount != null) __obj.updateDynamic("beforeMount")(js.Any.fromFunction0(beforeMount))
    if (beforeUpdate != null) __obj.updateDynamic("beforeUpdate")(js.Any.fromFunction0(beforeUpdate))
    if (!js.isUndefined(comments)) __obj.updateDynamic("comments")(comments)
    if (components != null) __obj.updateDynamic("components")(components)
    if (computed != null) __obj.updateDynamic("computed")(computed)
    if (created != null) __obj.updateDynamic("created")(js.Any.fromFunction0(created))
    if (data != null) __obj.updateDynamic("data")(data.asInstanceOf[js.Any])
    if (deactivated != null) __obj.updateDynamic("deactivated")(js.Any.fromFunction0(deactivated))
    if (delimiters != null) __obj.updateDynamic("delimiters")(delimiters)
    if (destroyed != null) __obj.updateDynamic("destroyed")(js.Any.fromFunction0(destroyed))
    if (directives != null) __obj.updateDynamic("directives")(directives)
    if (el != null) __obj.updateDynamic("el")(el.asInstanceOf[js.Any])
    if (errorCaptured != null) __obj.updateDynamic("errorCaptured")(js.Any.fromFunction0(errorCaptured))
    if (`extends` != null) __obj.updateDynamic("extends")(`extends`.asInstanceOf[js.Any])
    if (filters != null) __obj.updateDynamic("filters")(filters)
    if (!js.isUndefined(inheritAttrs)) __obj.updateDynamic("inheritAttrs")(inheritAttrs)
    if (inject != null) __obj.updateDynamic("inject")(inject.asInstanceOf[js.Any])
    if (methods != null) __obj.updateDynamic("methods")(methods.asInstanceOf[js.Any])
    if (mixins != null) __obj.updateDynamic("mixins")(mixins)
    if (model != null) __obj.updateDynamic("model")(model)
    if (mounted != null) __obj.updateDynamic("mounted")(js.Any.fromFunction0(mounted))
    if (name != null) __obj.updateDynamic("name")(name)
    if (parent != null) __obj.updateDynamic("parent")(parent)
    if (props != null) __obj.updateDynamic("props")(props.asInstanceOf[js.Any])
    if (propsData != null) __obj.updateDynamic("propsData")(propsData)
    if (provide != null) __obj.updateDynamic("provide")(provide.asInstanceOf[js.Any])
    if (render != null) __obj.updateDynamic("render")(js.Any.fromFunction1(render))
    if (renderError != null) __obj.updateDynamic("renderError")(js.Any.fromFunction2(renderError))
    if (staticRenderFns != null) __obj.updateDynamic("staticRenderFns")(staticRenderFns)
    if (template != null) __obj.updateDynamic("template")(template)
    if (transitions != null) __obj.updateDynamic("transitions")(transitions)
    if (updated != null) __obj.updateDynamic("updated")(js.Any.fromFunction0(updated))
    if (watch != null) __obj.updateDynamic("watch")(watch)
    __obj.asInstanceOf[ComponentOptions[V, Data, Methods, Computed, PropsDef]]
  }
}


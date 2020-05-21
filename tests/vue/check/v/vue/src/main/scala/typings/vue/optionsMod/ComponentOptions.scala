package typings.vue.optionsMod

import org.scalablytyped.runtime.StringDictionary
import typings.std.Element
import typings.std.Error
import typings.std.Record
import typings.vue.AnonEvent
import typings.vue.vnodeMod.VNode
import typings.vue.vueMod.CreateElement
import typings.vue.vueMod.Vue
import typings.vue.vueMod.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ComponentOptions[V /* <: Vue */, Data, Methods, Computed, PropsDef] extends js.Object {
  var activated: js.UndefOr[js.Function0[Unit]] = js.native
  var beforeCreate: js.UndefOr[js.ThisFunction0[/* this */ V, Unit]] = js.native
  var beforeDestroy: js.UndefOr[js.Function0[Unit]] = js.native
  var beforeMount: js.UndefOr[js.Function0[Unit]] = js.native
  var beforeUpdate: js.UndefOr[js.Function0[Unit]] = js.native
  var comments: js.UndefOr[Boolean] = js.native
  var components: js.UndefOr[StringDictionary[(Component[_, _, _, _]) | (AsyncComponent[_, _, _, _])]] = js.native
  var computed: js.UndefOr[Accessors[Computed]] = js.native
  var created: js.UndefOr[js.Function0[Unit]] = js.native
  var data: js.UndefOr[Data] = js.native
  var deactivated: js.UndefOr[js.Function0[Unit]] = js.native
  var delimiters: js.UndefOr[js.Tuple2[String, String]] = js.native
  var destroyed: js.UndefOr[js.Function0[Unit]] = js.native
  var directives: js.UndefOr[StringDictionary[DirectiveFunction | DirectiveOptions]] = js.native
  var el: js.UndefOr[Element | String] = js.native
  var errorCaptured: js.UndefOr[js.Function0[Boolean | Unit]] = js.native
  // TODO: support properly inferred 'extends'
  var `extends`: js.UndefOr[
    (ComponentOptions[
      Vue, 
      DefaultData[Vue], 
      DefaultMethods[Vue], 
      DefaultComputed, 
      PropsDefinition[DefaultProps]
    ]) | VueConstructor[Vue]
  ] = js.native
  var filters: js.UndefOr[StringDictionary[js.Function]] = js.native
  var inheritAttrs: js.UndefOr[Boolean] = js.native
  var inject: js.UndefOr[InjectOptions] = js.native
  var methods: js.UndefOr[Methods] = js.native
  var mixins: js.UndefOr[
    js.Array[
      (ComponentOptions[
        Vue, 
        DefaultData[Vue], 
        DefaultMethods[Vue], 
        DefaultComputed, 
        PropsDefinition[DefaultProps]
      ]) | VueConstructor[Vue]
    ]
  ] = js.native
  var model: js.UndefOr[AnonEvent] = js.native
  var mounted: js.UndefOr[js.Function0[Unit]] = js.native
  var name: js.UndefOr[String] = js.native
  var parent: js.UndefOr[Vue] = js.native
  var props: js.UndefOr[PropsDef] = js.native
  var propsData: js.UndefOr[js.Object] = js.native
  var provide: js.UndefOr[js.Object | js.Function0[js.Object]] = js.native
  var render: js.UndefOr[js.Function1[/* createElement */ CreateElement, VNode]] = js.native
  var renderError: js.UndefOr[js.Function2[/* h */ js.Function0[VNode], /* err */ Error, VNode]] = js.native
  var staticRenderFns: js.UndefOr[js.Array[js.Function1[/* createElement */ CreateElement, VNode]]] = js.native
  var template: js.UndefOr[String] = js.native
  var transitions: js.UndefOr[StringDictionary[js.Object]] = js.native
  var updated: js.UndefOr[js.Function0[Unit]] = js.native
  var watch: js.UndefOr[Record[String, WatchOptionsWithHandler[_] | WatchHandler[_] | String]] = js.native
}

object ComponentOptions {
  @scala.inline
  def apply[V /* <: Vue */, Data, Methods, Computed, PropsDef](
    activated: () => Unit = null,
    beforeCreate: js.ThisFunction0[/* this */ V, Unit] = null,
    beforeDestroy: () => Unit = null,
    beforeMount: () => Unit = null,
    beforeUpdate: () => Unit = null,
    comments: js.UndefOr[Boolean] = js.undefined,
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
    inheritAttrs: js.UndefOr[Boolean] = js.undefined,
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
    model: AnonEvent = null,
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
    if (beforeCreate != null) __obj.updateDynamic("beforeCreate")(beforeCreate.asInstanceOf[js.Any])
    if (beforeDestroy != null) __obj.updateDynamic("beforeDestroy")(js.Any.fromFunction0(beforeDestroy))
    if (beforeMount != null) __obj.updateDynamic("beforeMount")(js.Any.fromFunction0(beforeMount))
    if (beforeUpdate != null) __obj.updateDynamic("beforeUpdate")(js.Any.fromFunction0(beforeUpdate))
    if (!js.isUndefined(comments)) __obj.updateDynamic("comments")(comments.asInstanceOf[js.Any])
    if (components != null) __obj.updateDynamic("components")(components.asInstanceOf[js.Any])
    if (computed != null) __obj.updateDynamic("computed")(computed.asInstanceOf[js.Any])
    if (created != null) __obj.updateDynamic("created")(js.Any.fromFunction0(created))
    if (data != null) __obj.updateDynamic("data")(data.asInstanceOf[js.Any])
    if (deactivated != null) __obj.updateDynamic("deactivated")(js.Any.fromFunction0(deactivated))
    if (delimiters != null) __obj.updateDynamic("delimiters")(delimiters.asInstanceOf[js.Any])
    if (destroyed != null) __obj.updateDynamic("destroyed")(js.Any.fromFunction0(destroyed))
    if (directives != null) __obj.updateDynamic("directives")(directives.asInstanceOf[js.Any])
    if (el != null) __obj.updateDynamic("el")(el.asInstanceOf[js.Any])
    if (errorCaptured != null) __obj.updateDynamic("errorCaptured")(js.Any.fromFunction0(errorCaptured))
    if (`extends` != null) __obj.updateDynamic("extends")(`extends`.asInstanceOf[js.Any])
    if (filters != null) __obj.updateDynamic("filters")(filters.asInstanceOf[js.Any])
    if (!js.isUndefined(inheritAttrs)) __obj.updateDynamic("inheritAttrs")(inheritAttrs.asInstanceOf[js.Any])
    if (inject != null) __obj.updateDynamic("inject")(inject.asInstanceOf[js.Any])
    if (methods != null) __obj.updateDynamic("methods")(methods.asInstanceOf[js.Any])
    if (mixins != null) __obj.updateDynamic("mixins")(mixins.asInstanceOf[js.Any])
    if (model != null) __obj.updateDynamic("model")(model.asInstanceOf[js.Any])
    if (mounted != null) __obj.updateDynamic("mounted")(js.Any.fromFunction0(mounted))
    if (name != null) __obj.updateDynamic("name")(name.asInstanceOf[js.Any])
    if (parent != null) __obj.updateDynamic("parent")(parent.asInstanceOf[js.Any])
    if (props != null) __obj.updateDynamic("props")(props.asInstanceOf[js.Any])
    if (propsData != null) __obj.updateDynamic("propsData")(propsData.asInstanceOf[js.Any])
    if (provide != null) __obj.updateDynamic("provide")(provide.asInstanceOf[js.Any])
    if (render != null) __obj.updateDynamic("render")(js.Any.fromFunction1(render))
    if (renderError != null) __obj.updateDynamic("renderError")(js.Any.fromFunction2(renderError))
    if (staticRenderFns != null) __obj.updateDynamic("staticRenderFns")(staticRenderFns.asInstanceOf[js.Any])
    if (template != null) __obj.updateDynamic("template")(template.asInstanceOf[js.Any])
    if (transitions != null) __obj.updateDynamic("transitions")(transitions.asInstanceOf[js.Any])
    if (updated != null) __obj.updateDynamic("updated")(js.Any.fromFunction0(updated))
    if (watch != null) __obj.updateDynamic("watch")(watch.asInstanceOf[js.Any])
    __obj.asInstanceOf[ComponentOptions[V, Data, Methods, Computed, PropsDef]]
  }
  @scala.inline
  implicit class ComponentOptionsOps[Self[v /* <: typings.vue.vueMod.Vue */, data, methods, computed, propsdef] <: ComponentOptions[v, data, methods, computed, propsdef], V <: Vue, Data, Methods, Computed, PropsDef] (val x: Self[V, Data, Methods, Computed, PropsDef]) extends AnyVal {
    @scala.inline
    def duplicate: Self[V, Data, Methods, Computed, PropsDef] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[V, Data, Methods, Computed, PropsDef]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[V, Data, Methods, Computed, PropsDef]) with Other]
    @scala.inline
    def withActivated(activated: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (activated != null) ret.updateDynamic("activated")(js.Any.fromFunction0(activated))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutActivated: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "activated")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withBeforeCreate(beforeCreate: js.ThisFunction0[/* this */ V, Unit]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (beforeCreate != null) ret.updateDynamic("beforeCreate")(beforeCreate.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutBeforeCreate: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "beforeCreate")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withBeforeDestroy(beforeDestroy: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (beforeDestroy != null) ret.updateDynamic("beforeDestroy")(js.Any.fromFunction0(beforeDestroy))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutBeforeDestroy: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "beforeDestroy")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withBeforeMount(beforeMount: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (beforeMount != null) ret.updateDynamic("beforeMount")(js.Any.fromFunction0(beforeMount))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutBeforeMount: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "beforeMount")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withBeforeUpdate(beforeUpdate: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (beforeUpdate != null) ret.updateDynamic("beforeUpdate")(js.Any.fromFunction0(beforeUpdate))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutBeforeUpdate: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "beforeUpdate")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withComments(comments: js.UndefOr[Boolean]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(comments)) ret.updateDynamic("comments")(comments.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutComments: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "comments")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withComponents(components: StringDictionary[(Component[_, _, _, _]) | (AsyncComponent[_, _, _, _])]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (components != null) ret.updateDynamic("components")(components.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutComponents: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "components")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withComputed(computed: Accessors[Computed]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (computed != null) ret.updateDynamic("computed")(computed.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutComputed: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "computed")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withCreated(created: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (created != null) ret.updateDynamic("created")(js.Any.fromFunction0(created))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutCreated: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "created")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withData(data: Data): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (data != null) ret.updateDynamic("data")(data.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutData: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "data")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withDeactivated(deactivated: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (deactivated != null) ret.updateDynamic("deactivated")(js.Any.fromFunction0(deactivated))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutDeactivated: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "deactivated")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withDelimiters(delimiters: js.Tuple2[String, String]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (delimiters != null) ret.updateDynamic("delimiters")(delimiters.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutDelimiters: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "delimiters")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withDestroyed(destroyed: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (destroyed != null) ret.updateDynamic("destroyed")(js.Any.fromFunction0(destroyed))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutDestroyed: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "destroyed")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withDirectives(directives: StringDictionary[DirectiveFunction | DirectiveOptions]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (directives != null) ret.updateDynamic("directives")(directives.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutDirectives: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "directives")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withEl(el: Element | String): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (el != null) ret.updateDynamic("el")(el.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutEl: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "el")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withErrorCaptured(errorCaptured: () => Boolean | Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (errorCaptured != null) ret.updateDynamic("errorCaptured")(js.Any.fromFunction0(errorCaptured))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutErrorCaptured: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "errorCaptured")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withExtends(
      `extends`: (ComponentOptions[
          Vue, 
          DefaultData[Vue], 
          DefaultMethods[Vue], 
          DefaultComputed, 
          PropsDefinition[DefaultProps]
        ]) | VueConstructor[Vue]
    ): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (`extends` != null) ret.updateDynamic("extends")(`extends`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutExtends: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "extends")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withFilters(filters: StringDictionary[js.Function]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (filters != null) ret.updateDynamic("filters")(filters.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutFilters: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "filters")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withInheritAttrs(inheritAttrs: js.UndefOr[Boolean]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(inheritAttrs)) ret.updateDynamic("inheritAttrs")(inheritAttrs.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutInheritAttrs: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "inheritAttrs")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withInject(inject: InjectOptions): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (inject != null) ret.updateDynamic("inject")(inject.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutInject: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "inject")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withMethods(methods: Methods): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (methods != null) ret.updateDynamic("methods")(methods.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutMethods: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "methods")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withMixins(
      mixins: js.Array[
          (ComponentOptions[
            Vue, 
            DefaultData[Vue], 
            DefaultMethods[Vue], 
            DefaultComputed, 
            PropsDefinition[DefaultProps]
          ]) | VueConstructor[Vue]
        ]
    ): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (mixins != null) ret.updateDynamic("mixins")(mixins.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutMixins: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "mixins")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withModel(model: AnonEvent): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (model != null) ret.updateDynamic("model")(model.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutModel: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "model")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withMounted(mounted: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (mounted != null) ret.updateDynamic("mounted")(js.Any.fromFunction0(mounted))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutMounted: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "mounted")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withName(name: String): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (name != null) ret.updateDynamic("name")(name.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutName: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "name")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withParent(parent: Vue): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (parent != null) ret.updateDynamic("parent")(parent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutParent: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "parent")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withProps(props: PropsDef): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (props != null) ret.updateDynamic("props")(props.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutProps: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "props")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withPropsData(propsData: js.Object): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (propsData != null) ret.updateDynamic("propsData")(propsData.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutPropsData: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "propsData")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withProvideFunction0(provide: () => js.Object): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("provide")(js.Any.fromFunction0(provide))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withProvide(provide: js.Object | js.Function0[js.Object]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (provide != null) ret.updateDynamic("provide")(provide.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutProvide: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "provide")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withRender(render: /* createElement */ CreateElement => VNode): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (render != null) ret.updateDynamic("render")(js.Any.fromFunction1(render))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutRender: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "render")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withRenderError(renderError: (/* h */ js.Function0[VNode], /* err */ Error) => VNode): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (renderError != null) ret.updateDynamic("renderError")(js.Any.fromFunction2(renderError))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutRenderError: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "renderError")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withStaticRenderFns(staticRenderFns: js.Array[js.Function1[/* createElement */ CreateElement, VNode]]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (staticRenderFns != null) ret.updateDynamic("staticRenderFns")(staticRenderFns.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutStaticRenderFns: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "staticRenderFns")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withTemplate(template: String): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (template != null) ret.updateDynamic("template")(template.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutTemplate: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "template")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withTransitions(transitions: StringDictionary[js.Object]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (transitions != null) ret.updateDynamic("transitions")(transitions.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutTransitions: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "transitions")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withUpdated(updated: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (updated != null) ret.updateDynamic("updated")(js.Any.fromFunction0(updated))
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutUpdated: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "updated")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withWatch(watch: Record[String, WatchOptionsWithHandler[_] | WatchHandler[_] | String]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (watch != null) ret.updateDynamic("watch")(watch.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
    @scala.inline
    def withoutWatch: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        js.special.delete(ret, "watch")
        ret.asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    }
  }
  
}


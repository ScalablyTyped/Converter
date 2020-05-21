package typings.vue.optionsMod

import org.scalablytyped.runtime.StringDictionary
import typings.std.Element
import typings.std.Error
import typings.std.Record
import typings.vue.anon.Event
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
  var model: js.UndefOr[Event] = js.native
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
  def apply[V, Data, Methods, Computed, PropsDef](): ComponentOptions[V, Data, Methods, Computed, PropsDef] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ComponentOptions[V, Data, Methods, Computed, PropsDef]]
  }
  @scala.inline
  implicit class ComponentOptionsOps[Self[v, data, methods, computed, propsdef] <: ComponentOptions[v, data, methods, computed, propsdef], V, Data, Methods, Computed, PropsDef] (val x: Self[V, Data, Methods, Computed, PropsDef]) extends AnyVal {
    @scala.inline
    def duplicate: Self[V, Data, Methods, Computed, PropsDef] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[V, Data, Methods, Computed, PropsDef]]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): (Self[V, Data, Methods, Computed, PropsDef]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[V, Data, Methods, Computed, PropsDef]) with Other]
    @scala.inline
    def withActivated(value: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("activated")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutActivated: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("activated")(js.undefined)
        ret
    }
    @scala.inline
    def withBeforeCreate(value: js.ThisFunction0[/* this */ V, Unit]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("beforeCreate")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutBeforeCreate: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("beforeCreate")(js.undefined)
        ret
    }
    @scala.inline
    def withBeforeDestroy(value: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("beforeDestroy")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutBeforeDestroy: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("beforeDestroy")(js.undefined)
        ret
    }
    @scala.inline
    def withBeforeMount(value: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("beforeMount")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutBeforeMount: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("beforeMount")(js.undefined)
        ret
    }
    @scala.inline
    def withBeforeUpdate(value: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("beforeUpdate")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutBeforeUpdate: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("beforeUpdate")(js.undefined)
        ret
    }
    @scala.inline
    def withComments(value: Boolean): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("comments")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutComments: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("comments")(js.undefined)
        ret
    }
    @scala.inline
    def withComponents(value: StringDictionary[(Component[_, _, _, _]) | (AsyncComponent[_, _, _, _])]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("components")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutComponents: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("components")(js.undefined)
        ret
    }
    @scala.inline
    def withComputed(value: Accessors[Computed]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("computed")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutComputed: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("computed")(js.undefined)
        ret
    }
    @scala.inline
    def withCreated(value: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("created")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutCreated: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("created")(js.undefined)
        ret
    }
    @scala.inline
    def withData(value: Data): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("data")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutData: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("data")(js.undefined)
        ret
    }
    @scala.inline
    def withDeactivated(value: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("deactivated")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutDeactivated: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("deactivated")(js.undefined)
        ret
    }
    @scala.inline
    def withDelimiters(value: js.Tuple2[String, String]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("delimiters")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutDelimiters: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("delimiters")(js.undefined)
        ret
    }
    @scala.inline
    def withDestroyed(value: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("destroyed")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutDestroyed: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("destroyed")(js.undefined)
        ret
    }
    @scala.inline
    def withDirectives(value: StringDictionary[DirectiveFunction | DirectiveOptions]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("directives")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutDirectives: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("directives")(js.undefined)
        ret
    }
    @scala.inline
    def withEl(value: Element | String): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("el")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutEl: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("el")(js.undefined)
        ret
    }
    @scala.inline
    def withErrorCaptured(value: () => Boolean | Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("errorCaptured")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutErrorCaptured: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("errorCaptured")(js.undefined)
        ret
    }
    @scala.inline
    def withExtends(
      value: (ComponentOptions[
          Vue, 
          DefaultData[Vue], 
          DefaultMethods[Vue], 
          DefaultComputed, 
          PropsDefinition[DefaultProps]
        ]) | VueConstructor[Vue]
    ): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("extends")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutExtends: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("extends")(js.undefined)
        ret
    }
    @scala.inline
    def withFilters(value: StringDictionary[js.Function]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("filters")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutFilters: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("filters")(js.undefined)
        ret
    }
    @scala.inline
    def withInheritAttrs(value: Boolean): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inheritAttrs")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutInheritAttrs: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inheritAttrs")(js.undefined)
        ret
    }
    @scala.inline
    def withInject(value: InjectOptions): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inject")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutInject: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inject")(js.undefined)
        ret
    }
    @scala.inline
    def withMethods(value: Methods): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("methods")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutMethods: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("methods")(js.undefined)
        ret
    }
    @scala.inline
    def withMixins(
      value: js.Array[
          (ComponentOptions[
            Vue, 
            DefaultData[Vue], 
            DefaultMethods[Vue], 
            DefaultComputed, 
            PropsDefinition[DefaultProps]
          ]) | VueConstructor[Vue]
        ]
    ): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("mixins")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutMixins: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("mixins")(js.undefined)
        ret
    }
    @scala.inline
    def withModel(value: Event): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("model")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutModel: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("model")(js.undefined)
        ret
    }
    @scala.inline
    def withMounted(value: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("mounted")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutMounted: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("mounted")(js.undefined)
        ret
    }
    @scala.inline
    def withName(value: String): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("name")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutName: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("name")(js.undefined)
        ret
    }
    @scala.inline
    def withParent(value: Vue): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("parent")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutParent: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("parent")(js.undefined)
        ret
    }
    @scala.inline
    def withProps(value: PropsDef): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("props")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutProps: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("props")(js.undefined)
        ret
    }
    @scala.inline
    def withPropsData(value: js.Object): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("propsData")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutPropsData: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("propsData")(js.undefined)
        ret
    }
    @scala.inline
    def withProvideFunction0(value: () => js.Object): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("provide")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withProvide(value: js.Object | js.Function0[js.Object]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("provide")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutProvide: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("provide")(js.undefined)
        ret
    }
    @scala.inline
    def withRender(value: /* createElement */ CreateElement => VNode): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("render")(js.Any.fromFunction1(value))
        ret
    }
    @scala.inline
    def withoutRender: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("render")(js.undefined)
        ret
    }
    @scala.inline
    def withRenderError(value: (/* h */ js.Function0[VNode], /* err */ Error) => VNode): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("renderError")(js.Any.fromFunction2(value))
        ret
    }
    @scala.inline
    def withoutRenderError: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("renderError")(js.undefined)
        ret
    }
    @scala.inline
    def withStaticRenderFns(value: js.Array[js.Function1[/* createElement */ CreateElement, VNode]]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("staticRenderFns")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutStaticRenderFns: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("staticRenderFns")(js.undefined)
        ret
    }
    @scala.inline
    def withTemplate(value: String): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("template")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutTemplate: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("template")(js.undefined)
        ret
    }
    @scala.inline
    def withTransitions(value: StringDictionary[js.Object]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("transitions")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutTransitions: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("transitions")(js.undefined)
        ret
    }
    @scala.inline
    def withUpdated(value: () => Unit): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("updated")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutUpdated: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("updated")(js.undefined)
        ret
    }
    @scala.inline
    def withWatch(value: Record[String, WatchOptionsWithHandler[_] | WatchHandler[_] | String]): Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("watch")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutWatch: Self[V, Data, Methods, Computed, PropsDef] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("watch")(js.undefined)
        ret
    }
  }
  
}


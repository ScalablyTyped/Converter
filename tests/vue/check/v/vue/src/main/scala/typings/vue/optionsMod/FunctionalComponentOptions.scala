package typings.vue.optionsMod

import typings.vue.vnodeMod.VNode
import typings.vue.vueMod.CreateElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait FunctionalComponentOptions[Props, PropDefs] extends js.Object {
  var functional: Boolean = js.native
  var inject: js.UndefOr[InjectOptions] = js.native
  var name: js.UndefOr[String] = js.native
  var props: js.UndefOr[PropDefs] = js.native
  def render(createElement: CreateElement, context: RenderContext[Props]): VNode = js.native
}

object FunctionalComponentOptions {
  @scala.inline
  def apply[Props, PropDefs](
    functional: Boolean,
    render: (CreateElement, RenderContext[Props]) => VNode,
    inject: InjectOptions = null,
    name: String = null,
    props: PropDefs = null
  ): FunctionalComponentOptions[Props, PropDefs] = {
    val __obj = js.Dynamic.literal(functional = functional.asInstanceOf[js.Any], render = js.Any.fromFunction2(render))
    if (inject != null) __obj.updateDynamic("inject")(inject.asInstanceOf[js.Any])
    if (name != null) __obj.updateDynamic("name")(name.asInstanceOf[js.Any])
    if (props != null) __obj.updateDynamic("props")(props.asInstanceOf[js.Any])
    __obj.asInstanceOf[FunctionalComponentOptions[Props, PropDefs]]
  }
  @scala.inline
  implicit class FunctionalComponentOptionsOps[Self[props, propdefs] <: FunctionalComponentOptions[props, propdefs], Props, PropDefs] (val x: Self[Props, PropDefs]) extends AnyVal {
    @scala.inline
    def duplicate: Self[Props, PropDefs] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[Props, PropDefs]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[Props, PropDefs]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[Props, PropDefs]) with Other]
    @scala.inline
    def withFunctional(functional: Boolean): Self[Props, PropDefs] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("functional")(functional.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[Props, PropDefs]]
    }
    @scala.inline
    def withRender(render: (CreateElement, RenderContext[Props]) => VNode): Self[Props, PropDefs] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("render")(js.Any.fromFunction2(render))
        ret.asInstanceOf[Self[Props, PropDefs]]
    }
    @scala.inline
    def withInject(inject: InjectOptions): Self[Props, PropDefs] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (inject != null) ret.updateDynamic("inject")(inject.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[Props, PropDefs]]
    }
    @scala.inline
    def withoutInject: Self[Props, PropDefs] = {
        val ret = this.duplicate
        js.special.delete(ret, "inject")
        ret.asInstanceOf[Self[Props, PropDefs]]
    }
    @scala.inline
    def withName(name: String): Self[Props, PropDefs] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (name != null) ret.updateDynamic("name")(name.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[Props, PropDefs]]
    }
    @scala.inline
    def withoutName: Self[Props, PropDefs] = {
        val ret = this.duplicate
        js.special.delete(ret, "name")
        ret.asInstanceOf[Self[Props, PropDefs]]
    }
    @scala.inline
    def withProps(props: PropDefs): Self[Props, PropDefs] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (props != null) ret.updateDynamic("props")(props.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[Props, PropDefs]]
    }
    @scala.inline
    def withoutProps: Self[Props, PropDefs] = {
        val ret = this.duplicate
        js.special.delete(ret, "props")
        ret.asInstanceOf[Self[Props, PropDefs]]
    }
  }
  
}


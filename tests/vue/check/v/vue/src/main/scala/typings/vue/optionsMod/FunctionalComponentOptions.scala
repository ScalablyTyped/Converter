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
  def apply[Props, PropDefs](functional: Boolean, render: (CreateElement, RenderContext[Props]) => VNode): FunctionalComponentOptions[Props, PropDefs] = {
    val __obj = js.Dynamic.literal(functional = functional.asInstanceOf[js.Any], render = js.Any.fromFunction2(render))
    __obj.asInstanceOf[FunctionalComponentOptions[Props, PropDefs]]
  }
  @scala.inline
  implicit class FunctionalComponentOptionsOps[Self[props, propdefs] <: FunctionalComponentOptions[props, propdefs], Props, PropDefs] (val x: Self[Props, PropDefs]) extends AnyVal {
    @scala.inline
    def duplicate: Self[Props, PropDefs] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[Props, PropDefs]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[Props, PropDefs]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[Props, PropDefs]) with Other]
    @scala.inline
    def withFunctional(value: Boolean): Self[Props, PropDefs] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("functional")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withRender(value: (CreateElement, RenderContext[Props]) => VNode): Self[Props, PropDefs] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("render")(js.Any.fromFunction2(value))
        ret
    }
    @scala.inline
    def withInject(value: InjectOptions): Self[Props, PropDefs] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inject")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutInject: Self[Props, PropDefs] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inject")(js.undefined)
        ret
    }
    @scala.inline
    def withName(value: String): Self[Props, PropDefs] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("name")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutName: Self[Props, PropDefs] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("name")(js.undefined)
        ret
    }
    @scala.inline
    def withProps(value: PropDefs): Self[Props, PropDefs] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("props")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutProps: Self[Props, PropDefs] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("props")(js.undefined)
        ret
    }
  }
  
}


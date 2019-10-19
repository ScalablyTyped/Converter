package typings.vue.mod.types.options

import typings.vue.mod.types.vnode.VNode
import typings.vue.mod.types.vue.CreateElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait FunctionalComponentOptions[Props, PropDefs] extends js.Object {
  var functional: Boolean
  var inject: js.UndefOr[InjectOptions] = js.undefined
  var name: js.UndefOr[String] = js.undefined
  var props: js.UndefOr[PropDefs] = js.undefined
  def render(`this`: js.UndefOr[scala.Nothing], createElement: CreateElement, context: RenderContext[Props]): VNode
}

object FunctionalComponentOptions {
  @scala.inline
  def apply[Props, PropDefs](
    functional: Boolean,
    render: (js.UndefOr[scala.Nothing], CreateElement, RenderContext[Props]) => VNode,
    inject: InjectOptions = null,
    name: String = null,
    props: PropDefs = null
  ): FunctionalComponentOptions[Props, PropDefs] = {
    val __obj = js.Dynamic.literal(functional = functional.asInstanceOf[js.Any], render = js.Any.fromFunction3(render))
    if (inject != null) __obj.updateDynamic("inject")(inject.asInstanceOf[js.Any])
    if (name != null) __obj.updateDynamic("name")(name.asInstanceOf[js.Any])
    if (props != null) __obj.updateDynamic("props")(props.asInstanceOf[js.Any])
    __obj.asInstanceOf[FunctionalComponentOptions[Props, PropDefs]]
  }
}


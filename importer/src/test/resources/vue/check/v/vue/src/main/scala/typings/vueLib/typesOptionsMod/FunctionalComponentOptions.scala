package typings
package vueLib.typesOptionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait FunctionalComponentOptions[Props, PropDefs] extends js.Object {
  var functional: scala.Boolean
  var inject: js.UndefOr[InjectOptions] = js.undefined
  var name: js.UndefOr[java.lang.String] = js.undefined
  var props: js.UndefOr[PropDefs] = js.undefined
  def render(
    `this`: js.UndefOr[scala.Nothing],
    createElement: vueLib.typesVueMod.CreateElement,
    context: RenderContext[Props]
  ): vueLib.typesVnodeMod.VNode
}

object FunctionalComponentOptions {
  @scala.inline
  def apply[Props, PropDefs](
    functional: scala.Boolean,
    render: js.Function3[
      js.UndefOr[scala.Nothing], 
      vueLib.typesVueMod.CreateElement, 
      RenderContext[Props], 
      vueLib.typesVnodeMod.VNode
    ],
    inject: InjectOptions = null,
    name: java.lang.String = null,
    props: PropDefs = null
  ): FunctionalComponentOptions[Props, PropDefs] = {
    val __obj = js.Dynamic.literal(functional = functional, render = render)
    if (inject != null) __obj.updateDynamic("inject")(inject.asInstanceOf[js.Any])
    if (name != null) __obj.updateDynamic("name")(name)
    if (props != null) __obj.updateDynamic("props")(props.asInstanceOf[js.Any])
    __obj.asInstanceOf[FunctionalComponentOptions[Props, PropDefs]]
  }
}


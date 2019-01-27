package typings
package vueLib.optionsMod

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
    createElement: vueLib.vueVueMod.CreateElement,
    context: RenderContext[Props]
  ): vueLib.vnodeMod.VNode
}


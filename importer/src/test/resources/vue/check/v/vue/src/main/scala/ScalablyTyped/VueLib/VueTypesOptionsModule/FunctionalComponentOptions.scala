package ScalablyTyped
package VueLib.VueTypesOptionsModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait FunctionalComponentOptions[Props, PropDefs] extends js.Object {
  val functional: scala.Boolean
  val inject: js.UndefOr[InjectOptions] = js.undefined
  val name: js.UndefOr[java.lang.String] = js.undefined
  val props: js.UndefOr[PropDefs] = js.undefined
  def render(`this`: js.UndefOr[scala.Nothing], createElement: VueLib.VueTypesVueModule.CreateElement, context: RenderContext[Props]): VueLib.VueTypesVnodeModule.VNode
}


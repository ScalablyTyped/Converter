package ScalablyTyped
package VueLib.VueTypesOptionsModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait RenderContext[Props] extends js.Object {
  var children: StdLib.Array[VueLib.VueTypesVnodeModule.VNode]
  var data: VueLib.VueTypesVnodeModule.VNodeData
  var injections: js.Any
  var parent: VueLib.VueTypesVueModule.Vue
  var props: Props
  def slots(): js.Any
}


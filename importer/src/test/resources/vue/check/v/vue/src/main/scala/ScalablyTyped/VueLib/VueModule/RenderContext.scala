package ScalablyTyped
package VueLib
package VueModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait RenderContext[Props] extends js.Object {
  val children: StdLib.Array[VueLib.VueTypesVnodeModule.VNode]
  val data: VueLib.VueTypesVnodeModule.VNodeData
  val injections: js.Any
  val parent: VueLib.VueTypesVueModule.Vue
  val props: Props
  def slots(): js.Any
}


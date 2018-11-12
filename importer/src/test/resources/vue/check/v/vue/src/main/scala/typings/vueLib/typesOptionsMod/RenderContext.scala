package typings
package vueLib.typesOptionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait RenderContext[Props] extends js.Object {
  var children: js.Array[vueLib.typesVnodeMod.VNode]
  var data: vueLib.typesVnodeMod.VNodeData
  var injections: js.Any
  var parent: vueLib.typesVueMod.Vue
  var props: Props
  def slots(): js.Any
}


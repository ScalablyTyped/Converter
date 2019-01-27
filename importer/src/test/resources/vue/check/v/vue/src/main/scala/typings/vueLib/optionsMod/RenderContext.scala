package typings
package vueLib.optionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait RenderContext[Props] extends js.Object {
  var children: js.Array[vueLib.vnodeMod.VNode]
  var data: vueLib.vnodeMod.VNodeData
  var injections: js.Any
  var parent: vueLib.vueVueMod.Vue
  var props: Props
  def slots(): js.Any
}


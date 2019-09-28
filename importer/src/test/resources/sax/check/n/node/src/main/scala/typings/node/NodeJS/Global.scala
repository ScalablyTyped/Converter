package typings.node.NodeJS

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.std.ArrayConstrucor
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Global extends js.Object {
  var Array: ArrayConstrucor
  var global: Global
}

object Global {
  @inline
  def apply(Array: ArrayConstrucor, global: Global): Global = {
    val __obj = js.Dynamic.literal(Array = Array, global = global)
  
    __obj.asInstanceOf[Global]
  }
}


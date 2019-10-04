package typings.node.NodeJS

import typings.std.ArrayConstrucor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Global extends js.Object {
  var Array: ArrayConstrucor
  var global: Global
}

object Global {
  @scala.inline
  def apply(Array: ArrayConstrucor, global: Global): Global = {
    val __obj = js.Dynamic.literal(Array = Array, global = global)
  
    __obj.asInstanceOf[Global]
  }
}


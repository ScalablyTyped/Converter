package typings.node.NodeJS

import typings.std.ArrayConstrucor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Global extends js.Object {
  var Array: ArrayConstrucor = js.native
  var global: Global = js.native
}

object Global {
  @scala.inline
  def apply(Array: ArrayConstrucor, global: Global): Global = {
    val __obj = js.Dynamic.literal(Array = Array.asInstanceOf[js.Any], global = global.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Global]
  }
}


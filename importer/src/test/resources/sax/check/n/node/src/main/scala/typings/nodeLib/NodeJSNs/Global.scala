package typings
package nodeLib.NodeJSNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Global extends js.Object {
  var Array: stdLib.ArrayConstrucor
  var global: Global
}

object Global {
  @scala.inline
  def apply(Array: stdLib.ArrayConstrucor, global: Global): Global = {
    val __obj = js.Dynamic.literal(Array = Array, global = global)
  
    __obj.asInstanceOf[Global]
  }
}


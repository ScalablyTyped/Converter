package typings
package reactLib.reactMod.Global.JSXNs

import reactLib.reactMod.Component
import reactLib.reactMod.ReactNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ElementClass
  extends Component[js.Any, js.Object] {
  def render(): ReactNode
}

object ElementClass {
  @scala.inline
  def apply(render: () => ReactNode): ElementClass = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
  
    __obj.asInstanceOf[ElementClass]
  }
}


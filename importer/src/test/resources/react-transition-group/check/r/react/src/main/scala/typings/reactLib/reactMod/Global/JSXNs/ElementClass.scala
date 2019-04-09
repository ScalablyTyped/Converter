package typings
package reactLib.reactMod.Global.JSXNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ElementClass
  extends reactLib.reactMod.Component[js.Any, js.Object] {
  def render(): reactLib.reactMod.ReactNode
}

object ElementClass {
  @scala.inline
  def apply(render: () => reactLib.reactMod.ReactNode): ElementClass = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
  
    __obj.asInstanceOf[ElementClass]
  }
}


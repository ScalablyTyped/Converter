package typings
package reactLib.reactMod.Global.JSXNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ElementClass
  extends reactLib.reactMod.ReactNs.Component[js.Any, js.Object] {
  def render(): reactLib.reactMod.ReactNs.ReactNode
}

object ElementClass {
  @scala.inline
  def apply(render: () => reactLib.reactMod.ReactNs.ReactNode): ElementClass = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
  
    __obj.asInstanceOf[ElementClass]
  }
}


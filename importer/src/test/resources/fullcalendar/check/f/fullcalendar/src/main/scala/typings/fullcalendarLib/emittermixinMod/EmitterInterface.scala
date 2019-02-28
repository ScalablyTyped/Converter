package typings
package fullcalendarLib.emittermixinMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait EmitterInterface extends js.Object {
  def on(types: js.Any, handler: js.Any): js.Any
}

object EmitterInterface {
  @scala.inline
  def apply(on: js.Function2[js.Any, js.Any, js.Any]): EmitterInterface = {
    val __obj = js.Dynamic.literal(on = on)
  
    __obj.asInstanceOf[EmitterInterface]
  }
}


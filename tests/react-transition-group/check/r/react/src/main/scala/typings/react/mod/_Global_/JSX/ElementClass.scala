package typings.react.mod._Global_.JSX

import typings.react.mod.Component
import typings.react.mod.ReactNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ElementClass
  extends Component[js.Any, js.Object] {
  def render(): ReactNode = js.native
}

object ElementClass {
  @scala.inline
  def apply(render: () => ReactNode): ElementClass = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
  
    __obj.asInstanceOf[ElementClass]
  }
}


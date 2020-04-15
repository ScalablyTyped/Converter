package typingsSlinky.react.mod._Global_.JSX

import slinky.core.TagMod
import typingsSlinky.react.mod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ElementClass
  extends Component[js.Any, js.Object] {
  def render(): TagMod[Any] = js.native
}

object ElementClass {
  @scala.inline
  def apply(render: () => TagMod[Any]): ElementClass = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
    __obj.asInstanceOf[ElementClass]
  }
}


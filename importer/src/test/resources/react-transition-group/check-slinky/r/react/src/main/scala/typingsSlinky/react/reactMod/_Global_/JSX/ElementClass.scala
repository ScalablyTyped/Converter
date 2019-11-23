package typingsSlinky.react.reactMod._Global_.JSX

import slinky.core.TagMod
import typingsSlinky.react.reactMod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ElementClass
  extends Component[js.Any, js.Object] {
  def render(): TagMod[Any]
}

object ElementClass {
  @scala.inline
  def apply(render: () => TagMod[Any]): ElementClass = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
  
    __obj.asInstanceOf[ElementClass]
  }
}


package typings.react.reactMod._Global_.JSX

import japgolly.scalajs.react.raw.React.Node
import typings.react.reactMod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ElementClass
  extends Component[js.Any, js.Object] {
  def render(): Node
}

object ElementClass {
  @scala.inline
  def apply(render: () => Node): ElementClass = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
  
    __obj.asInstanceOf[ElementClass]
  }
}


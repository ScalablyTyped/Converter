package typingsJapgolly.react.reactMod._Global_.JSX

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Node
import typingsJapgolly.react.reactMod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ElementClass
  extends Component[js.Any, js.Object] {
  def render(): Node
}

object ElementClass {
  @scala.inline
  def apply(render: CallbackTo[Node]): ElementClass = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("render")(render.toJsFn)
    __obj.asInstanceOf[ElementClass]
  }
}


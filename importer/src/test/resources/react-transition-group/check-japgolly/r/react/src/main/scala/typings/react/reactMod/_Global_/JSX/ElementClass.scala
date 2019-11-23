package typings.react.reactMod._Global_.JSX

import japgolly.scalajs.react.CallbackTo
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
  def apply(render: CallbackTo[Node]): ElementClass = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("render")(js.Any.fromFunction0((() => render.runNow())))
    __obj.asInstanceOf[ElementClass]
  }
}


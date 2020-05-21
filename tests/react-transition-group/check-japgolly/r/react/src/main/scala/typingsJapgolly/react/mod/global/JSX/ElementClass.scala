package typingsJapgolly.react.mod.global.JSX

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Node
import typingsJapgolly.react.mod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ElementClass
  extends Component[js.Any, js.Object] {
  def render(): Node = js.native
}

object ElementClass {
  @scala.inline
  def apply(render: CallbackTo[Node]): ElementClass = {
    val __obj = js.Dynamic.literal(render = render.toJsFn)
    __obj.asInstanceOf[ElementClass]
  }
  @scala.inline
  implicit class ElementClassOps[Self <: ElementClass] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setRender(value: CallbackTo[Node]): Self = this.set("render", value.toJsFn)
  }
  
}


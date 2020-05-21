package typings.react.mod.global.JSX

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
    def setRender(value: () => ReactNode): Self = this.set("render", js.Any.fromFunction0(value))
  }
  
}


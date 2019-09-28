package typings.react.reactMod._Global_.JSX

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.reactMod.Component
import typings.react.reactMod.ReactNode
import scala.scalajs.js
import scala.scalajs.js.`|`

trait ElementClass extends Component[js.Any, js.Object] {
  def render(): ReactNode
}

object ElementClass {
  @inline
  def apply(render: () => ReactNode): ElementClass = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
  
    __obj.asInstanceOf[ElementClass]
  }
}


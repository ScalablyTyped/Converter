package typingsJapgolly.react.mod.global.JSX

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Node
import typingsJapgolly.react.mod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
}

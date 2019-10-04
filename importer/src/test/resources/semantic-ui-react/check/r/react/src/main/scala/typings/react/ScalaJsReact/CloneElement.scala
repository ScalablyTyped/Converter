package typings.react.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.react.reactMod.ReactElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object CloneElement {
  def apply(props: js.Any, `type`: js.Any)(): UnmountedWithRoot[ReactElement, js.Object, Unit, ReactElement] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal(props = props)
  
    type CloneElementType = scala.scalajs.js.Object
  
      __obj.updateDynamic("type")(`type`)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, CloneElementType](js.constructorOf[CloneElementType])
  
    f(props)
  }
  type Props = ReactElement
}


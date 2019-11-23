package typings.react.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.react.Anon_Children
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object StrictMode {
  def apply()(): UnmountedWithRoot[Anon_Children, js.Object, Unit, Anon_Children] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type StrictModeType = scala.scalajs.js.Object
  
    
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, StrictModeType](js.constructorOf[StrictModeType])
  
    f(props)
  }
  type Props = Anon_Children
}


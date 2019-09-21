package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.buttonButtonOrMod.ButtonOrProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Or {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    text: Double | String = null
  )(
    
  ): UnmountedWithRoot[ButtonOrProps, js.Object, Unit, ButtonOrProps] = {
    import japgolly.scalajs.react._
  
    val __obj = js.Dynamic.literal()
  
    type OrType = scala.scalajs.js.Object
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (text != null) __obj.updateDynamic("text")(text.asInstanceOf[js.Any])
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, OrType](js.constructorOf[OrType])
  
    f(props)
  }
  type Props = ButtonOrProps
}


package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcElementsFlagFlagMod.FlagNameValues
import typings.semanticDashUiDashReact.srcElementsFlagFlagMod.FlagProps
import typings.semanticDashUiDashReact.srcElementsFlagMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: className */
object Flag {
  def apply(
    name: FlagNameValues,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null
  )(
    
  ): UnmountedWithRoot[FlagProps, default, Unit, FlagProps] = {
    import japgolly.scalajs.react._
  
    val __obj = js.Dynamic.literal(name = name)
  
    type FlagType = typings.semanticDashUiDashReact.srcElementsFlagMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, FlagType](js.constructorOf[FlagType])
  
    f(props)
  }
  type Props = FlagProps
}


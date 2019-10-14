package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcModulesDimmerDimmerMod.DimmerProps
import typings.semanticDashUiDashReact.srcModulesDimmerMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Dimmer {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    page: js.UndefOr[Boolean] = js.undefined
  )(
    
  ): UnmountedWithRoot[DimmerProps, default, Unit, DimmerProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type DimmerType = typings.semanticDashUiDashReact.srcModulesDimmerMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (!js.isUndefined(page)) __obj.updateDynamic("page")(page)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, DimmerType](js.constructorOf[DimmerType])
  
    f(props)
  }
  type Props = DimmerProps
}


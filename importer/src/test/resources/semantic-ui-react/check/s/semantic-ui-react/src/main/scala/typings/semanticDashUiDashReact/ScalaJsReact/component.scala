package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcModulesDimmerDimmerMod.DimmerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object component {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    page: js.UndefOr[Boolean] = js.undefined
  ): UnmountedSimple[
    DimmerProps, 
    MountedWithRawType[DimmerProps, js.Object, RawMounted[DimmerProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (!js.isUndefined(page)) __obj.updateDynamic("page")(page)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcModulesDimmerDimmerMod.DimmerProps, 
  japgolly.scalajs.react.Children.None, 
  js.Object](typings.semanticDashUiDashReact.srcModulesDimmerMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesDimmerDimmerMod.DimmerProps])
  }
}


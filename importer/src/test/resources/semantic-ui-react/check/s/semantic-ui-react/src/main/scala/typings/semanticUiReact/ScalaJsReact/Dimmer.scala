package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.modulesDimmerDimmerMod.DimmerProps
import typings.semanticUiReact.modulesDimmerMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Dimmer {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    page: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedWithRoot[DimmerProps, default, Unit, DimmerProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (!js.isUndefined(page)) __obj.updateDynamic("page")(page)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesDimmerDimmerMod.DimmerProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesDimmerMod.default](js.constructorOf[typings.semanticUiReact.modulesDimmerMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesDimmerDimmerMod.DimmerProps])(children: _*)
  }
}


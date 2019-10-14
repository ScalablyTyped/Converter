package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderImageMod.PlaceholderImageProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: className */
object PlaceholderImage {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    rectangular: js.UndefOr[Boolean] = js.undefined,
    square: js.UndefOr[Boolean] = js.undefined
  ): UnmountedSimple[
    PlaceholderImageProps, 
    MountedWithRawType[PlaceholderImageProps, js.Object, RawMounted[PlaceholderImageProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(rectangular)) __obj.updateDynamic("rectangular")(rectangular)
    if (!js.isUndefined(square)) __obj.updateDynamic("square")(square)
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderImageMod.PlaceholderImageProps, 
  japgolly.scalajs.react.Children.None, 
  js.Object](typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderImageMod.default)
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcElementsPlaceholderPlaceholderImageMod.PlaceholderImageProps])
  }
}


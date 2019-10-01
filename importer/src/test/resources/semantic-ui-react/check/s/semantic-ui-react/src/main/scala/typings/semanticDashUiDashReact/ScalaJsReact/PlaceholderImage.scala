package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
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
  )(
    
  ): UnmountedWithRoot[PlaceholderImageProps, js.Object, Unit, PlaceholderImageProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type PlaceholderImageType = scala.scalajs.js.Object
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(rectangular)) __obj.updateDynamic("rectangular")(rectangular)
    if (!js.isUndefined(square)) __obj.updateDynamic("square")(square)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, PlaceholderImageType](js.constructorOf[PlaceholderImageType])
  
    f(props)
  }
  type Props = PlaceholderImageProps
}


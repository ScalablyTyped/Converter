package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticUiReact.modulesRatingMod.default
import typings.semanticUiReact.modulesRatingRatingMod.RatingProps
import typings.semanticUiReact.semanticUiReactStrings.auto
import typings.semanticUiReact.semanticUiReactStrings.heart
import typings.semanticUiReact.semanticUiReactStrings.huge
import typings.semanticUiReact.semanticUiReactStrings.large
import typings.semanticUiReact.semanticUiReactStrings.massive
import typings.semanticUiReact.semanticUiReactStrings.mini
import typings.semanticUiReact.semanticUiReactStrings.small
import typings.semanticUiReact.semanticUiReactStrings.star
import typings.semanticUiReact.semanticUiReactStrings.tiny
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Rating {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    className: String = null,
    clearable: Boolean | auto = null,
    defaultRating: Double | String = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    icon: star | heart = null,
    maxRating: Double | String = null,
    onRate: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ RatingProps) => Callback = null,
    rating: Double | String = null,
    size: mini | tiny | small | large | huge | massive = null
  ): UnmountedWithRoot[RatingProps, default, Unit, RatingProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (clearable != null) __obj.updateDynamic("clearable")(clearable.asInstanceOf[js.Any])
    if (defaultRating != null) __obj.updateDynamic("defaultRating")(defaultRating.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (maxRating != null) __obj.updateDynamic("maxRating")(maxRating.asInstanceOf[js.Any])
    if (onRate != null) __obj.updateDynamic("onRate")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesRatingRatingMod.RatingProps) => onRate(t0, t1).runNow())))
    if (rating != null) __obj.updateDynamic("rating")(rating.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesRatingRatingMod.RatingProps, 
  japgolly.scalajs.react.Children.None, 
  typings.semanticUiReact.modulesRatingMod.default](js.constructorOf[typings.semanticUiReact.modulesRatingMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesRatingRatingMod.RatingProps])
  }
}


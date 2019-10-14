package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import typings.semanticDashUiDashReact.srcModulesRatingRatingIconMod.RatingIconProps
import typings.semanticDashUiDashReact.srcModulesRatingRatingIconMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: className, selected */
object RatingIcon {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    index: Int | Double = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ RatingIconProps) => Callback = null,
    onKeyUp: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ RatingIconProps) => Callback = null,
    onMouseEnter: (/* event */ ReactMouseEventFrom[HTMLElement], /* data */ RatingIconProps) => Callback = null
  ): UnmountedWithRoot[RatingIconProps, default, Unit, RatingIconProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (index != null) __obj.updateDynamic("index")(index.asInstanceOf[js.Any])
        if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesRatingRatingIconMod.RatingIconProps) => onClick(t0, t1).runNow())))
        if (onKeyUp != null) __obj.updateDynamic("onKeyUp")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesRatingRatingIconMod.RatingIconProps) => onKeyUp(t0, t1).runNow())))
        if (onMouseEnter != null) __obj.updateDynamic("onMouseEnter")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesRatingRatingIconMod.RatingIconProps) => onMouseEnter(t0, t1).runNow())))
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.semanticDashUiDashReact.srcModulesRatingRatingIconMod.RatingIconProps, 
  japgolly.scalajs.react.Children.None, 
  typings.semanticDashUiDashReact.srcModulesRatingRatingIconMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesRatingRatingIconMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesRatingRatingIconMod.RatingIconProps])
  }
}


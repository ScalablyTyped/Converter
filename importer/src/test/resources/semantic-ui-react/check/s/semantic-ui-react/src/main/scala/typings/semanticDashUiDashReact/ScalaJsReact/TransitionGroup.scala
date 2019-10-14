package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.srcGenericMod.SemanticTRANSITIONS
import typings.semanticDashUiDashReact.srcModulesTransitionTransitionGroupMod.TransitionGroupProps
import typings.semanticDashUiDashReact.srcModulesTransitionTransitionGroupMod.default
import typings.semanticDashUiDashReact.srcModulesTransitionTransitionMod.TransitionPropDuration
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children */
object TransitionGroup {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    animation: SemanticTRANSITIONS | String = null,
    as: js.Any = null,
    directional: js.UndefOr[Boolean] = js.undefined,
    duration: Double | String | TransitionPropDuration = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedWithRoot[TransitionGroupProps, default, Unit, TransitionGroupProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (animation != null) __obj.updateDynamic("animation")(animation.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(directional)) __obj.updateDynamic("directional")(directional)
    if (duration != null) __obj.updateDynamic("duration")(duration.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.semanticDashUiDashReact.srcModulesTransitionTransitionGroupMod.TransitionGroupProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcModulesTransitionTransitionGroupMod.default](js.constructorOf[typings.semanticDashUiDashReact.srcModulesTransitionTransitionGroupMod.default])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesTransitionTransitionGroupMod.TransitionGroupProps])(children: _*)
  }
}


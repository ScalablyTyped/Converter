package typings.semanticUiReact.jagpolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.genericMod.SemanticTRANSITIONS
import typings.semanticUiReact.modulesTransitionTransitionGroupMod.TransitionGroupProps
import typings.semanticUiReact.modulesTransitionTransitionGroupMod.default
import typings.semanticUiReact.modulesTransitionTransitionMod.TransitionPropDuration
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object TransitionGroup {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    animation: SemanticTRANSITIONS | String = null,
    as: js.Any = null,
    directional: js.UndefOr[Boolean] = js.undefined,
    duration: Double | String | TransitionPropDuration = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[TransitionGroupProps, default, Unit, TransitionGroupProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (animation != null) __obj.updateDynamic("animation")(animation.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(directional)) __obj.updateDynamic("directional")(directional)
    if (duration != null) __obj.updateDynamic("duration")(duration.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesTransitionTransitionGroupMod.TransitionGroupProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesTransitionTransitionGroupMod.default](js.constructorOf[typings.semanticUiReact.modulesTransitionTransitionGroupMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesTransitionTransitionGroupMod.TransitionGroupProps])(children: _*)
  }
}


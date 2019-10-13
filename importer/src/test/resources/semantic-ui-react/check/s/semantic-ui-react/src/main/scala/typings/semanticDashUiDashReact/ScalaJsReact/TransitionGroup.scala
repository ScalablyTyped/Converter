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
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type TransitionGroupType = typings.semanticDashUiDashReact.srcModulesTransitionTransitionGroupMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (animation != null) __obj.updateDynamic("animation")(animation.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(directional)) __obj.updateDynamic("directional")(directional)
    if (duration != null) __obj.updateDynamic("duration")(duration.asInstanceOf[js.Any])
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.Varargs, TransitionGroupType](js.constructorOf[TransitionGroupType])
  
    f(props)(children: _*)
  }
  type Props = TransitionGroupProps
}


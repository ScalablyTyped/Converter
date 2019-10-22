package typings.semanticUiReact.jagpolly

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.semanticUiReact.genericMod.SemanticTRANSITIONS
import typings.semanticUiReact.modulesTransitionMod.default
import typings.semanticUiReact.modulesTransitionTransitionMod.TransitionEventData
import typings.semanticUiReact.modulesTransitionTransitionMod.TransitionPropDuration
import typings.semanticUiReact.modulesTransitionTransitionMod.TransitionProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Transition {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    animation: SemanticTRANSITIONS | String = null,
    directional: js.UndefOr[Boolean] = js.undefined,
    duration: Double | String | TransitionPropDuration = null,
    mountOnShow: js.UndefOr[Boolean] = js.undefined,
    onComplete: (/* nothing */ Null, /* data */ TransitionEventData) => Callback = null,
    onHide: (/* nothing */ Null, /* data */ TransitionEventData) => Callback = null,
    onShow: (/* nothing */ Null, /* data */ TransitionEventData) => Callback = null,
    onStart: (/* nothing */ Null, /* data */ TransitionEventData) => Callback = null,
    reactKey: String = null,
    transitionOnMount: js.UndefOr[Boolean] = js.undefined,
    unmountOnHide: js.UndefOr[Boolean] = js.undefined,
    visible: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedWithRoot[TransitionProps, default, Unit, TransitionProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (animation != null) __obj.updateDynamic("animation")(animation.asInstanceOf[js.Any])
    if (!js.isUndefined(directional)) __obj.updateDynamic("directional")(directional)
    if (duration != null) __obj.updateDynamic("duration")(duration.asInstanceOf[js.Any])
    if (!js.isUndefined(mountOnShow)) __obj.updateDynamic("mountOnShow")(mountOnShow)
    if (onComplete != null) __obj.updateDynamic("onComplete")(js.Any.fromFunction2(((t0: /* nothing */ scala.Null, t1: /* data */ typings.semanticUiReact.modulesTransitionTransitionMod.TransitionEventData) => onComplete(t0, t1).runNow())))
    if (onHide != null) __obj.updateDynamic("onHide")(js.Any.fromFunction2(((t0: /* nothing */ scala.Null, t1: /* data */ typings.semanticUiReact.modulesTransitionTransitionMod.TransitionEventData) => onHide(t0, t1).runNow())))
    if (onShow != null) __obj.updateDynamic("onShow")(js.Any.fromFunction2(((t0: /* nothing */ scala.Null, t1: /* data */ typings.semanticUiReact.modulesTransitionTransitionMod.TransitionEventData) => onShow(t0, t1).runNow())))
    if (onStart != null) __obj.updateDynamic("onStart")(js.Any.fromFunction2(((t0: /* nothing */ scala.Null, t1: /* data */ typings.semanticUiReact.modulesTransitionTransitionMod.TransitionEventData) => onStart(t0, t1).runNow())))
    if (reactKey != null) __obj.updateDynamic("reactKey")(reactKey)
    if (!js.isUndefined(transitionOnMount)) __obj.updateDynamic("transitionOnMount")(transitionOnMount)
    if (!js.isUndefined(unmountOnHide)) __obj.updateDynamic("unmountOnHide")(unmountOnHide)
    if (!js.isUndefined(visible)) __obj.updateDynamic("visible")(visible)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesTransitionTransitionMod.TransitionProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesTransitionMod.default](js.constructorOf[typings.semanticUiReact.modulesTransitionMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesTransitionTransitionMod.TransitionProps])(children: _*)
  }
}


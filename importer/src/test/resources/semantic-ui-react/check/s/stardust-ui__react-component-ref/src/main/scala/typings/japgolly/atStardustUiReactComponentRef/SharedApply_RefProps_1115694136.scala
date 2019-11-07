package typings.japgolly.atStardustUiReactComponentRef

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.raw.React.Ref
import org.scalablytyped.runtime.StringDictionary
import typings.atStardustUiReactComponentRef.esTypesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_RefProps_1115694136[ComponentRef] () {
  def __component: js.Any
  def apply(
    innerRef: Ref = null,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[RefProps, ComponentRef, Unit, RefProps] = {
    val __obj = js.Dynamic.literal()
  
      if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.atStardustUiReactComponentRef.esTypesMod.RefProps, 
  japgolly.scalajs.react.Children.Varargs, 
  ComponentRef](__component)
    f(__obj.asInstanceOf[typings.atStardustUiReactComponentRef.esTypesMod.RefProps])(children: _*)
  }
}

